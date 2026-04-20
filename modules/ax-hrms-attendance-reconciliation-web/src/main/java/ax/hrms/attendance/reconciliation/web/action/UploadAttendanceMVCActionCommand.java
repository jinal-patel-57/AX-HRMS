package ax.hrms.attendance.reconciliation.web.action;

import ax.hrms.attendance.reconciliation.web.constants.AxHrmsAttendanceReconciliationWebPortletKeys;
import ax.hrms.attendance.reconciliation.web.dto.AttendanceRecord;
import ax.hrms.attendance.reconciliation.web.dto.MissingAttendanceRecord;
import ax.hrms.attendance.reconciliation.web.util.AttendanceValidationUtil;
import ax.hrms.attendance.reconciliation.web.util.AttendanceExcelExportUtil;
import ax.hrms.attendance.reconciliation.web.util.ExcelParserUtil;

import com.ax.hrms.common.api.api.AxHrmsCommonApi;
import com.ax.hrms.mail.template.config.configuration.MailTemplateConfiguration;
import com.ax.hrms.master.exception.NoSuchLeaveCompensatoryStatusMasterException;
import com.ax.hrms.master.model.LeaveCompensatoryStatusMaster;
import com.ax.hrms.master.service.LeaveCompensatoryStatusMasterLocalService;
import com.ax.hrms.model.EmployeeDetails;
import com.ax.hrms.model.Holiday;
import com.ax.hrms.model.LeaveDayType;
import com.ax.hrms.model.LeaveRequest;
import com.ax.hrms.model.WorkFromHomeDayType;
import com.ax.hrms.model.WorkFromHomeRequest;
import com.ax.hrms.service.EmployeeDetailsLocalService;
import com.ax.hrms.service.HolidayLocalService;
import com.ax.hrms.service.LeaveDayTypeLocalService;
import com.ax.hrms.service.LeaveRequestLocalService;
import com.ax.hrms.service.WorkFromHomeDayTypeLocalService;
import com.ax.hrms.service.WorkFromHomeRequestLocalService;

import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.PrefsPropsUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.theme.ThemeDisplay;

import java.io.File;
import java.io.InputStream;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
	property = {
		"javax.portlet.name=" + AxHrmsAttendanceReconciliationWebPortletKeys.AXHRMSATTENDANCERECONCILIATIONWEB,
		"mvc.command.name=" + AxHrmsAttendanceReconciliationWebPortletKeys.ACTION_UPLOAD_ATTENDANCE
	},
	service = MVCActionCommand.class
)
public class UploadAttendanceMVCActionCommand extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		hideDefaultErrorMessage(actionRequest);
		hideDefaultSuccessMessage(actionRequest);

		try {
			UploadPortletRequest uploadPortletRequest =
				PortalUtil.getUploadPortletRequest(actionRequest);

			String fileName = uploadPortletRequest.getFileName("attendanceFile");
			InputStream inputStream = uploadPortletRequest.getFileAsStream(
				"attendanceFile");

			if (Validator.isNull(fileName) || inputStream == null) {
				SessionErrors.add(actionRequest, "file-required");

				return;
			}

			String normalizedFileName = fileName.toLowerCase();

			if (!normalizedFileName.endsWith(".xlsx") &&
				!normalizedFileName.endsWith(".xls")) {

				SessionErrors.add(actionRequest, "invalid-file-type");

				return;
			}

			Map<String, Long> employeeCodeToIdMap = new HashMap<>();
			Map<Long, EmployeeDetails> employeeMap = new HashMap<>();

			_buildEmployeeMappings(employeeCodeToIdMap, employeeMap);
			_log.info(
				"UploadAttendanceMVCActionCommand >> Active employees loaded: " +
					employeeMap.size() + ", employee codes mapped: " +
					employeeCodeToIdMap.size());

			List<AttendanceRecord> attendanceRecords =
				ExcelParserUtil.parseAttendanceExcel(
					inputStream, fileName, _axHrmsCommonApi, employeeCodeToIdMap,
					employeeMap);

			_log.info(
				"UploadAttendanceMVCActionCommand >> Parsed attendance rows: " +
					attendanceRecords.size());

			if (attendanceRecords.isEmpty()) {
				SessionErrors.add(actionRequest, "empty-file");

				return;
			}

			YearMonth yearMonth = _resolveYearMonth(attendanceRecords);

			if (yearMonth == null) {
				SessionErrors.add(actionRequest, "empty-file");

				return;
			}

			Map<Long, Map<LocalDate, AttendanceRecord>> attendanceMap =
				_buildAttendanceMap(attendanceRecords, yearMonth);
			_log.info(
				"UploadAttendanceMVCActionCommand >> Attendance map employees: " +
					attendanceMap.size());
			Date startDate = _toDate(yearMonth.atDay(1));
			Date endDate = _toDate(yearMonth.atEndOfMonth());
			long approvedStatusId = _getApprovedStatusId();
			_log.info(
				"UploadAttendanceMVCActionCommand >> Selected month: " +
					yearMonth + ", approved status id: " + approvedStatusId);

			Set<LocalDate> holidaySet = _fetchHolidaySet(yearMonth);
			Map<Long, Set<LocalDate>> leaveMap = _buildLeaveMap(
				startDate, endDate, approvedStatusId);
			Map<Long, Set<LocalDate>> wfhMap = _buildWfhMap(
				startDate, endDate, approvedStatusId);
			_log.info(
				"UploadAttendanceMVCActionCommand >> Holiday count: " +
					holidaySet.size() + ", leave employees: " + leaveMap.size() +
					", wfh employees: " + wfhMap.size());

			String skipEmployeeCodesStr = uploadPortletRequest.getParameter("skipEmployeeCodes");
			Set<String> skipEmployeeCodes = new HashSet<>();
			if (Validator.isNotNull(skipEmployeeCodesStr)) {
				for (String code : skipEmployeeCodesStr.split(",")) {
					if (Validator.isNotNull(code) && Validator.isNotNull(code.trim())) {
						skipEmployeeCodes.add(code.trim().toLowerCase());
					}
				}
				_log.info("UploadAttendanceMVCActionCommand >> Skip Employee Codes: " + skipEmployeeCodes);
			}

			List<MissingAttendanceRecord> missingAttendanceRecords =
				AttendanceValidationUtil.validateAttendance(
					attendanceMap, employeeMap, yearMonth, leaveMap, wfhMap,
					holidaySet, skipEmployeeCodes);
			_log.info(
				"UploadAttendanceMVCActionCommand >> Final issues count: " +
					missingAttendanceRecords.size());

			if (missingAttendanceRecords != null && !missingAttendanceRecords.isEmpty()) {
				File tempExcelFile = null;
				try {
					tempExcelFile = AttendanceExcelExportUtil.generateMissingAttendanceExcelFile(missingAttendanceRecords);
					if (tempExcelFile != null && tempExcelFile.exists()) {
						ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
						long companyId = themeDisplay.getCompanyId();
						String fromName = PrefsPropsUtil.getString(companyId, PropsKeys.ADMIN_EMAIL_FROM_NAME);
						String fromEmailAddress = PrefsPropsUtil.getString(companyId, PropsKeys.ADMIN_EMAIL_FROM_ADDRESS);
						String toEmail = _mailTemplateConfiguration.mailAttendanceReconciliationToEmailAddress();
						String subject = _mailTemplateConfiguration.mailAttendanceReconciliationSubject();
						String body = _mailTemplateConfiguration.mailAttendanceReconciliationBody();

						// Replace placeholders
						if (Validator.isNotNull(subject)) {
							subject = subject.replace("${YEAR_MONTH}", yearMonth.toString());
						}
						if (Validator.isNotNull(body)) {
							body = body.replace("${YEAR_MONTH}", yearMonth.toString());
						}

						_axHrmsCommonApi.sendMailWithAttachment(
							toEmail, fromEmailAddress, fromName, subject, body, tempExcelFile,
							"Missing_Attendance_Report_" + yearMonth.toString() + ".xlsx");
						_log.info("UploadAttendanceMVCActionCommand >> Successfully sent the email with the excel attachment.");
						
						SessionMessages.add(actionRequest, AxHrmsAttendanceReconciliationWebPortletKeys.MAIL_SENT_SUCCESS);
					}
				}
				catch (Exception e) {
					_log.error("UploadAttendanceMVCActionCommand >> Error occurred while sending email with excel attachment.", e);
				}
			}

			actionRequest.getPortletSession().setAttribute(
				AxHrmsAttendanceReconciliationWebPortletKeys.
					MISSING_ATTENDANCE_LIST,
				missingAttendanceRecords);

			actionRequest.getPortletSession().setAttribute(
				AxHrmsAttendanceReconciliationWebPortletKeys.
					UPLOADED_RECORDS_COUNT,
				attendanceRecords.size());

			SessionMessages.add(
				actionRequest,
				AxHrmsAttendanceReconciliationWebPortletKeys.
					PROCESSING_SUCCESS);
		}
		catch (Exception exception) {
			_log.error(
				"UploadAttendanceMVCActionCommand >> Error processing file",
				exception);

			SessionErrors.add(
				actionRequest,
				AxHrmsAttendanceReconciliationWebPortletKeys.PROCESSING_ERROR);
		}

		actionResponse.setRenderParameter("mvcPath", "/view.jsp");
	}

	private Map<Long, Map<LocalDate, AttendanceRecord>> _buildAttendanceMap(
		List<AttendanceRecord> attendanceRecords, YearMonth yearMonth) {

		Map<Long, Map<LocalDate, AttendanceRecord>> attendanceMap =
			new HashMap<>();

		for (AttendanceRecord attendanceRecord : attendanceRecords) {
			if (attendanceRecord == null || attendanceRecord.getEmployeeId() == null ||
				attendanceRecord.getDate() == null ||
				!yearMonth.equals(YearMonth.from(attendanceRecord.getDate()))) {

				if (attendanceRecord != null) {
					_log.info(
						"UploadAttendanceMVCActionCommand >> Skipping attendance row while building attendanceMap. employeeCode=" +
							attendanceRecord.getEmployeeCode() + ", employeeId=" +
							attendanceRecord.getEmployeeId() + ", date=" +
							attendanceRecord.getDate());
				}

				continue;
			}

			attendanceMap.computeIfAbsent(
				attendanceRecord.getEmployeeId(),
				key -> new HashMap<>()
			).put(attendanceRecord.getDate(), attendanceRecord);
			_log.info(
				"UploadAttendanceMVCActionCommand >> attendanceMap add employeeId=" +
					attendanceRecord.getEmployeeId() + ", employeeCode=" +
					attendanceRecord.getEmployeeCode() + ", date=" +
					attendanceRecord.getDate() + ", firstPunch=" +
					attendanceRecord.getFirstPunch());
		}

		return attendanceMap;
	}

	private void _buildEmployeeMappings(
		Map<String, Long> employeeCodeToIdMap,
		Map<Long, EmployeeDetails> employeeMap) {

		List<EmployeeDetails> employeeDetailsList =
			_employeeDetailsLocalService.findByIsTerminated(false);

		for (EmployeeDetails employeeDetails : employeeDetailsList) {
			employeeMap.put(employeeDetails.getEmployeeId(), employeeDetails);

			if (Validator.isNotNull(employeeDetails.getEmployeeCode())) {
				employeeCodeToIdMap.put(
					employeeDetails.getEmployeeCode().trim(),
					employeeDetails.getEmployeeId());
				_log.info(
					"UploadAttendanceMVCActionCommand >> employeeCode mapped: " +
						employeeDetails.getEmployeeCode().trim() + " -> " +
						employeeDetails.getEmployeeId());
			}
		}
	}

	private Map<Long, Set<LocalDate>> _buildLeaveMap(
		Date startDate, Date endDate, long approvedStatusId) {

		List<LeaveDayType> leaveDayTypes =
			_leaveDayTypeLocalService.findByLeaveDateBetween(startDate, endDate);
		Set<Long> leaveRequestIds = leaveDayTypes.stream(
		).map(
			LeaveDayType::getLeaveRequestId
		).collect(
			Collectors.toSet()
		);
		Map<Long, LeaveRequest> leaveRequestMap = _getApprovedLeaveRequestMap(
			leaveRequestIds, approvedStatusId);
		Map<Long, Set<LocalDate>> leaveMap = new HashMap<>();

		for (LeaveDayType leaveDayType : leaveDayTypes) {
			LeaveRequest leaveRequest = leaveRequestMap.get(
				leaveDayType.getLeaveRequestId());

			if (leaveRequest == null || leaveDayType.getLeaveDate() == null) {
				_log.info(
					"UploadAttendanceMVCActionCommand >> Ignoring leaveDayType. leaveRequestId=" +
						leaveDayType.getLeaveRequestId() + ", leaveDate=" +
						leaveDayType.getLeaveDate() + ", approvedRequestFound=" +
						(leaveRequest != null));
				continue;
			}

			leaveMap.computeIfAbsent(
				leaveRequest.getEmployeeId(),
				key -> new HashSet<>()
			).add(_toLocalDate(leaveDayType.getLeaveDate()));
			_log.info(
				"UploadAttendanceMVCActionCommand >> leaveMap add employeeId=" +
					leaveRequest.getEmployeeId() + ", date=" +
					_toLocalDate(leaveDayType.getLeaveDate()));
		}

		return leaveMap;
	}

	private Map<Long, Set<LocalDate>> _buildWfhMap(
		Date startDate, Date endDate, long approvedStatusId) {

		List<WorkFromHomeDayType> workFromHomeDayTypes =
			_workFromHomeDayTypeLocalService.findByWorkFromHomeDateBetween(
				startDate, endDate);
		Set<Long> workFromHomeRequestIds = workFromHomeDayTypes.stream(
		).map(
			WorkFromHomeDayType::getWorkFromHomeRequestId
		).collect(
			Collectors.toSet()
		);
		Map<Long, WorkFromHomeRequest> workFromHomeRequestMap =
			_getApprovedWfhRequestMap(workFromHomeRequestIds, approvedStatusId);
		Map<Long, Set<LocalDate>> wfhMap = new HashMap<>();

		for (WorkFromHomeDayType workFromHomeDayType : workFromHomeDayTypes) {
			WorkFromHomeRequest workFromHomeRequest = workFromHomeRequestMap.get(
				workFromHomeDayType.getWorkFromHomeRequestId());

			if (workFromHomeRequest == null ||
				workFromHomeDayType.getWorkFromHomeDate() == null) {

				_log.info(
					"UploadAttendanceMVCActionCommand >> Ignoring wfhDayType. requestId=" +
						workFromHomeDayType.getWorkFromHomeRequestId() + ", date=" +
						workFromHomeDayType.getWorkFromHomeDate() + ", approvedRequestFound=" +
						(workFromHomeRequest != null));

				continue;
			}

			wfhMap.computeIfAbsent(
				workFromHomeRequest.getEmployeeId(),
				key -> new HashSet<>()
			).add(_toLocalDate(workFromHomeDayType.getWorkFromHomeDate()));
			_log.info(
				"UploadAttendanceMVCActionCommand >> wfhMap add employeeId=" +
					workFromHomeRequest.getEmployeeId() + ", date=" +
					_toLocalDate(workFromHomeDayType.getWorkFromHomeDate()));
		}

		return wfhMap;
	}

	private Set<LocalDate> _fetchHolidaySet(YearMonth yearMonth) {
		return _holidayLocalService.findByYear(
			yearMonth.getYear()
		).stream(
		).map(
			Holiday::getDate
		).filter(
			Objects::nonNull
		).map(
			this::_toLocalDate
		).filter(
			date -> YearMonth.from(date).equals(yearMonth)
		).collect(
			Collectors.toSet()
		);
	}

	private Map<Long, LeaveRequest> _getApprovedLeaveRequestMap(
		Set<Long> leaveRequestIds, long approvedStatusId) {

		if (leaveRequestIds.isEmpty() || approvedStatusId <= 0) {
			return new HashMap<>();
		}

		DynamicQuery dynamicQuery = _leaveRequestLocalService.dynamicQuery();

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"leaveRequestId", leaveRequestIds.toArray(new Long[0])));
		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"leaveCompensatoryStatusMasterId", approvedStatusId));

		List<LeaveRequest> leaveRequests = _leaveRequestLocalService.dynamicQuery(
			dynamicQuery);

		return leaveRequests.stream().collect(
			Collectors.toMap(
				LeaveRequest::getLeaveRequestId, leaveRequest -> leaveRequest));
	}

	private Map<Long, WorkFromHomeRequest> _getApprovedWfhRequestMap(
		Set<Long> workFromHomeRequestIds, long approvedStatusId) {

		if (workFromHomeRequestIds.isEmpty() || approvedStatusId <= 0) {
			return new HashMap<>();
		}

		DynamicQuery dynamicQuery =
			_workFromHomeRequestLocalService.dynamicQuery();

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"workFromHomeRequestId",
				workFromHomeRequestIds.toArray(new Long[0])));
		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("status", approvedStatusId));

		List<WorkFromHomeRequest> workFromHomeRequests =
			_workFromHomeRequestLocalService.dynamicQuery(dynamicQuery);

		return workFromHomeRequests.stream().collect(
			Collectors.toMap(
				WorkFromHomeRequest::getWorkFromHomeRequestId,
				workFromHomeRequest -> workFromHomeRequest));
	}

	private long _getApprovedStatusId() throws NoSuchLeaveCompensatoryStatusMasterException {
		LeaveCompensatoryStatusMaster leaveCompensatoryStatusMaster =
			_leaveCompensatoryStatusMasterLocalService.
				findByLeaveCompensatoryStatusName(
					AxHrmsAttendanceReconciliationWebPortletKeys.
						STATUS_APPROVED);

		if (leaveCompensatoryStatusMaster == null) {
			return 0;
		}

		return leaveCompensatoryStatusMaster.getLeaveCompensatoryStatusMasterId();
	}

	private YearMonth _resolveYearMonth(List<AttendanceRecord> attendanceRecords) {
		LocalDate firstAttendanceDate = attendanceRecords.stream(
		).map(
			AttendanceRecord::getDate
		).filter(
			Objects::nonNull
		).sorted(
		).findFirst(
		).orElse(null);

		if (firstAttendanceDate == null) {
			return null;
		}

		return YearMonth.from(firstAttendanceDate);
	}

	private Date _toDate(LocalDate localDate) {
		return Date.from(
			localDate.atStartOfDay(
				ZoneId.systemDefault()
			).toInstant());
	}

	private LocalDate _toLocalDate(Date date) {
		return date.toInstant(
		).atZone(
			ZoneId.systemDefault()
		).toLocalDate();
	}

	private static final Log _log = LogFactoryUtil.getLog(
		UploadAttendanceMVCActionCommand.class);

	@Reference
	private AxHrmsCommonApi _axHrmsCommonApi;

	@Reference
	private EmployeeDetailsLocalService _employeeDetailsLocalService;

	@Reference
	private HolidayLocalService _holidayLocalService;

	@Reference
	private LeaveCompensatoryStatusMasterLocalService
		_leaveCompensatoryStatusMasterLocalService;

	@Reference
	private LeaveDayTypeLocalService _leaveDayTypeLocalService;

	@Reference
	private LeaveRequestLocalService _leaveRequestLocalService;

	@Reference
	private WorkFromHomeDayTypeLocalService _workFromHomeDayTypeLocalService;

	@Reference
	private WorkFromHomeRequestLocalService _workFromHomeRequestLocalService;

	@Reference
	private MailTemplateConfiguration _mailTemplateConfiguration;

}
