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
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
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

	private static Log log = LogFactoryUtil.getLog(UploadAttendanceMVCActionCommand.class);
	private static final String MVC_PATH = "mvcPath";
	private static final String VIEW_JSP = "/view.jsp";

	@Override
	protected void doProcessAction(
			ActionRequest actionRequest,
			ActionResponse actionResponse) throws Exception {

		hideDefaultErrorMessage(actionRequest);
		hideDefaultSuccessMessage(actionRequest);

		try {
			ProcessContext ctx = buildContext(actionRequest);

			if (!validateUpload(ctx, actionRequest)) {
				actionResponse.getRenderParameters().setValue(MVC_PATH, VIEW_JSP);
				return;
			}

			List<AttendanceRecord> attendanceRecords =
					ExcelParserUtil.parseAttendanceExcel(
							ctx.inputStream,
							ctx.fileName,
							axHrmsCommonApi,
							ctx.employeeCodeToIdMap,
							ctx.employeeMap);

			if (attendanceRecords.isEmpty()) {
				SessionErrors.add(actionRequest, "empty-file");
				actionResponse.getRenderParameters().setValue(MVC_PATH, VIEW_JSP);
				return;
			}

			YearMonth yearMonth = resolveYearMonth(attendanceRecords);

			if (yearMonth == null) {
				SessionErrors.add(actionRequest, "empty-file");
				actionResponse.getRenderParameters().setValue(MVC_PATH, VIEW_JSP);
				return;
			}

			AttendanceData data = buildAttendanceData(attendanceRecords, yearMonth);

			List<MissingAttendanceRecord> missing =
					AttendanceValidationUtil.validateAttendance(
							data.attendanceMap,
							ctx.employeeMap,
							yearMonth,
							data.leaveMap,
							data.wfhMap,
							data.holidaySet,
							ctx.skipEmployeeCodes);

			handleMissingRecords(actionRequest, missing, yearMonth);

			storeSessionData(actionRequest, attendanceRecords, missing);

			SessionMessages.add(
					actionRequest,
					AxHrmsAttendanceReconciliationWebPortletKeys.PROCESSING_SUCCESS);

		} catch (Exception e) {
			_log.error("UploadAttendanceMVCActionCommand >> Error processing file", e);

			SessionErrors.add(
					actionRequest,
					AxHrmsAttendanceReconciliationWebPortletKeys.PROCESSING_ERROR);
		}

		actionResponse.getRenderParameters().setValue(MVC_PATH, VIEW_JSP);
	}
	private void storeSessionData(
			ActionRequest actionRequest,
			List<AttendanceRecord> attendanceRecords,
			List<MissingAttendanceRecord> missing) {

		actionRequest.getPortletSession().setAttribute(
				AxHrmsAttendanceReconciliationWebPortletKeys.MISSING_ATTENDANCE_LIST,
				missing
		);

		actionRequest.getPortletSession().setAttribute(
				AxHrmsAttendanceReconciliationWebPortletKeys.UPLOADED_RECORDS_COUNT,
				attendanceRecords.size()
		);
	}
	private void handleMissingRecords(
			ActionRequest actionRequest,
			List<MissingAttendanceRecord> missing,
			YearMonth yearMonth) {

		if (missing == null || missing.isEmpty()) {
			return;
		}

		File tempExcelFile =
				AttendanceExcelExportUtil.generateMissingAttendanceExcelFile(missing);

		if (tempExcelFile == null || !tempExcelFile.exists()) {
			return;
		}

		try {
			ThemeDisplay themeDisplay =
					(ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);

			long companyId = themeDisplay.getCompanyId();

			String fromName = PrefsPropsUtil.getString(
					companyId, PropsKeys.ADMIN_EMAIL_FROM_NAME);

			String fromEmailAddress = PrefsPropsUtil.getString(
					companyId, PropsKeys.ADMIN_EMAIL_FROM_ADDRESS);

			String toEmail =
					mailTemplateConfiguration.mailAttendanceReconciliationToEmailAddress();

			String subject =
					mailTemplateConfiguration.mailAttendanceReconciliationSubject();

			String body =
					mailTemplateConfiguration.mailAttendanceReconciliationBody();

			String formattedMonth = yearMonth.format(DateTimeFormatter.ofPattern("MMMM yyyy"));

			if (Validator.isNotNull(subject)) {
				subject = subject.replace("${YEAR_MONTH}", formattedMonth);
			}

			if (Validator.isNotNull(body)) {
				body = body.replace("${YEAR_MONTH}", formattedMonth);
			}

			axHrmsCommonApi.sendMailWithAttachment(
					toEmail,
					fromEmailAddress,
					fromName,
					subject,
					body,
					tempExcelFile,
					"Missing_Attendance_Report_" + formattedMonth.replace(" ", "_") + ".xlsx"
			);

		} catch (Exception e) {
			log.error("Error sending missing attendance email", e);
		}
	}
	private static class ProcessContext {
		String fileName;
		InputStream inputStream;
		Map<String, Long> employeeCodeToIdMap;
		Map<Long, EmployeeDetails> employeeMap;
		Set<String> skipEmployeeCodes;
	}
	private ProcessContext buildContext(ActionRequest request)
			throws IOException {

		UploadPortletRequest uploadPortletRequest =
				PortalUtil.getUploadPortletRequest(request);

		ProcessContext ctx = new ProcessContext();

		ctx.fileName = uploadPortletRequest.getFileName("attendanceFile");
		ctx.inputStream = uploadPortletRequest.getFileAsStream("attendanceFile");

		ctx.employeeCodeToIdMap = new HashMap<>();
		ctx.employeeMap = new HashMap<>();

		buildEmployeeMappings(ctx.employeeCodeToIdMap, ctx.employeeMap);

		ctx.skipEmployeeCodes = parseSkipCodes(
				uploadPortletRequest.getParameter("skipEmployeeCodes"));

		return ctx;
	}
	private Set<String> parseSkipCodes(String input) {

		Set<String> set = new HashSet<>();

		if (Validator.isNull(input)) {
			return set;
		}

		for (String code : input.split(",")) {
			if (Validator.isNotNull(code) && Validator.isNotNull(code.trim())) {
				set.add(code.trim().toLowerCase());
			}
		}

		return set;
	}
	private static class AttendanceData {
		Map<Long, Map<LocalDate, AttendanceRecord>> attendanceMap;
		Map<Long, Set<LocalDate>> leaveMap;
		Map<Long, Set<LocalDate>> wfhMap;
		Set<LocalDate> holidaySet;
	}
	private AttendanceData buildAttendanceData(
			List<AttendanceRecord> records,
			YearMonth yearMonth) {

		AttendanceData data = new AttendanceData();

		data.attendanceMap = buildAttendanceMap(records, yearMonth);

		Date startDate = toDate(yearMonth.atDay(1));
		Date endDate = toDate(yearMonth.atEndOfMonth());

        long approvedStatusId = 0;
        long pendingStatusId = 0;
        try {
            approvedStatusId = getApprovedStatusId();
            pendingStatusId = getPendingStatusId();
        } catch (NoSuchLeaveCompensatoryStatusMasterException e) {
			log.error("Error occurred while fetching status IDs", e);
        }

        data.holidaySet = fetchHolidaySet(yearMonth);

		data.leaveMap = buildLeaveMap(startDate, endDate, approvedStatusId,pendingStatusId);
		data.wfhMap = buildWfhMap(startDate, endDate, approvedStatusId, pendingStatusId);

		return data;
	}
	private boolean validateUpload(ProcessContext ctx, ActionRequest request) {

		if (Validator.isNull(ctx.fileName) || ctx.inputStream == null) {
			SessionErrors.add(request, "file-required");
			return false;
		}

		String normalized = ctx.fileName.toLowerCase();

		if (!normalized.endsWith(".xlsx") && !normalized.endsWith(".xls")) {
			SessionErrors.add(request, "invalid-file-type");
			return false;
		}

		return true;
	}

	private Map<Long, Map<LocalDate, AttendanceRecord>> buildAttendanceMap(
		List<AttendanceRecord> attendanceRecords, YearMonth yearMonth) {

		Map<Long, Map<LocalDate, AttendanceRecord>> attendanceMap =
			new HashMap<>();

		for (AttendanceRecord attendanceRecord : attendanceRecords) {
			if (attendanceRecord == null || attendanceRecord.getEmployeeId() == null ||
				attendanceRecord.getDate() == null ||
				!yearMonth.equals(YearMonth.from(attendanceRecord.getDate()))) {



				continue;
			}

			attendanceMap.computeIfAbsent(
				attendanceRecord.getEmployeeId(),
				key -> new HashMap<>()
			).put(attendanceRecord.getDate(), attendanceRecord);

		}

		return attendanceMap;
	}

	private void buildEmployeeMappings(
		Map<String, Long> employeeCodeToIdMap,
		Map<Long, EmployeeDetails> employeeMap) {

		List<EmployeeDetails> employeeDetailsList =
			employeeDetailsLocalService.findByIsTerminated(false);

		for (EmployeeDetails employeeDetails : employeeDetailsList) {
			employeeMap.put(employeeDetails.getEmployeeId(), employeeDetails);

			if (Validator.isNotNull(employeeDetails.getEmployeeCode())) {
				employeeCodeToIdMap.put(
					employeeDetails.getEmployeeCode().trim(),
					employeeDetails.getEmployeeId());
			}
		}
	}

	private Map<Long, Set<LocalDate>> buildLeaveMap(
		Date startDate, Date endDate, long approvedStatusId, long pendingStatusId) {

		List<LeaveDayType> leaveDayTypes =
			leaveDayTypeLocalService.findByLeaveDateBetween(startDate, endDate);
		Set<Long> leaveRequestIds = leaveDayTypes.stream(
		).map(
			LeaveDayType::getLeaveRequestId
		).collect(
			Collectors.toSet()
		);
		Map<Long, LeaveRequest> leaveRequestMap = getLeaveRequestMap(
			leaveRequestIds, approvedStatusId,pendingStatusId);
		Map<Long, Set<LocalDate>> leaveMap = new HashMap<>();

		for (LeaveDayType leaveDayType : leaveDayTypes) {
			LeaveRequest leaveRequest = leaveRequestMap.get(
				leaveDayType.getLeaveRequestId());

			if (leaveRequest == null || leaveDayType.getLeaveDate() == null) {
				continue;
			}

			leaveMap.computeIfAbsent(
				leaveRequest.getEmployeeId(),
				key -> new HashSet<>()
			).add(toLocalDate(leaveDayType.getLeaveDate()));
		}

		return leaveMap;
	}

	private Map<Long, Set<LocalDate>> buildWfhMap(
		Date startDate, Date endDate, long approvedStatusId, long pendingStatusId) {

		List<WorkFromHomeDayType> workFromHomeDayTypes =
			workFromHomeDayTypeLocalService.findByWorkFromHomeDateBetween(
				startDate, endDate);
		Set<Long> workFromHomeRequestIds = workFromHomeDayTypes.stream(
		).map(
			WorkFromHomeDayType::getWorkFromHomeRequestId
		).collect(
			Collectors.toSet()
		);
		Map<Long, WorkFromHomeRequest> workFromHomeRequestMap =
			getWfhRequestMap(workFromHomeRequestIds, approvedStatusId, pendingStatusId);
		Map<Long, Set<LocalDate>> wfhMap = new HashMap<>();

		for (WorkFromHomeDayType workFromHomeDayType : workFromHomeDayTypes) {
			WorkFromHomeRequest workFromHomeRequest = workFromHomeRequestMap.get(
				workFromHomeDayType.getWorkFromHomeRequestId());

			if (workFromHomeRequest == null ||
				workFromHomeDayType.getWorkFromHomeDate() == null) {
				continue;
			}

			wfhMap.computeIfAbsent(
				workFromHomeRequest.getEmployeeId(),
				key -> new HashSet<>()
			).add(toLocalDate(workFromHomeDayType.getWorkFromHomeDate()));
			_log.info(
				"UploadAttendanceMVCActionCommand >> wfhMap add employeeId=" +
					workFromHomeRequest.getEmployeeId() + ", date=" +
					toLocalDate(workFromHomeDayType.getWorkFromHomeDate()));
		}

		return wfhMap;
	}

	private Set<LocalDate> fetchHolidaySet(YearMonth yearMonth) {
		return holidayLocalService.findByYear(
			yearMonth.getYear()
		).stream(
		).filter(
			holiday -> !Boolean.TRUE.equals(holiday.getIsFloater())
		).map(
			Holiday::getDate
		).filter(
			Objects::nonNull
		).map(
			this::toLocalDate
		).filter(
			date -> YearMonth.from(date).equals(yearMonth)
		).collect(
			Collectors.toSet()
		);
	}

	private Map<Long, LeaveRequest> getLeaveRequestMap(
			Set<Long> leaveRequestIds,
			long approvedStatusId,
			long pendingStatusId) {

		if (leaveRequestIds.isEmpty() ||
				(approvedStatusId <= 0 && pendingStatusId <= 0)) {

			return new HashMap<>();
		}

		DynamicQuery dynamicQuery =
				leaveRequestLocalService.dynamicQuery();

		dynamicQuery.add(
				RestrictionsFactoryUtil.in(
						"leaveRequestId",
						leaveRequestIds.toArray(new Long[0])
				)
		);

		Long[] validStatuses = {approvedStatusId, pendingStatusId};

		dynamicQuery.add(
				RestrictionsFactoryUtil.in(
						"leaveCompensatoryStatusMasterId",
						validStatuses
				)
		);

		List<LeaveRequest> leaveRequests =
				leaveRequestLocalService.dynamicQuery(dynamicQuery);

		return leaveRequests.stream().collect(
				Collectors.toMap(
						LeaveRequest::getLeaveRequestId,
						leaveRequest -> leaveRequest
				)
		);
	}

	private Map<Long, WorkFromHomeRequest> getWfhRequestMap(
		Set<Long> workFromHomeRequestIds, long approvedStatusId, long pendingStatusId) {

		if (workFromHomeRequestIds.isEmpty() || (approvedStatusId <= 0 && pendingStatusId <= 0)) {
			return new HashMap<>();
		}

		DynamicQuery dynamicQuery =
			workFromHomeRequestLocalService.dynamicQuery();

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"workFromHomeRequestId",
				workFromHomeRequestIds.toArray(new Long[0])));

		Long[] validStatuses = {approvedStatusId, pendingStatusId};
		dynamicQuery.add(
			RestrictionsFactoryUtil.in("status", validStatuses));

		List<WorkFromHomeRequest> workFromHomeRequests =
			workFromHomeRequestLocalService.dynamicQuery(dynamicQuery);

		return workFromHomeRequests.stream().collect(
			Collectors.toMap(
				WorkFromHomeRequest::getWorkFromHomeRequestId,
				workFromHomeRequest -> workFromHomeRequest));
	}

	private long getApprovedStatusId() throws NoSuchLeaveCompensatoryStatusMasterException {
		LeaveCompensatoryStatusMaster leaveCompensatoryStatusMaster =
			leaveCompensatoryStatusMasterLocalService.
				findByLeaveCompensatoryStatusName(
					AxHrmsAttendanceReconciliationWebPortletKeys.
						STATUS_APPROVED);

		if (leaveCompensatoryStatusMaster == null) {
			return 0;
		}

		return leaveCompensatoryStatusMaster.getLeaveCompensatoryStatusMasterId();
	}

	private long getPendingStatusId() throws NoSuchLeaveCompensatoryStatusMasterException {
		LeaveCompensatoryStatusMaster leaveCompensatoryStatusMaster =
			leaveCompensatoryStatusMasterLocalService.
				findByLeaveCompensatoryStatusName(
					AxHrmsAttendanceReconciliationWebPortletKeys.
						STATUS_PENDING);

		if (leaveCompensatoryStatusMaster == null) {
			return 0;
		}

		return leaveCompensatoryStatusMaster.getLeaveCompensatoryStatusMasterId();
	}

	private YearMonth resolveYearMonth(List<AttendanceRecord> attendanceRecords) {
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

	private Date toDate(LocalDate localDate) {
		return Date.from(
			localDate.atStartOfDay(
				ZoneId.systemDefault()
			).toInstant());
	}

	private LocalDate toLocalDate(Date date) {
		return date.toInstant(
		).atZone(
			ZoneId.systemDefault()
		).toLocalDate();
	}

	private static final Log _log = LogFactoryUtil.getLog(
		UploadAttendanceMVCActionCommand.class);

	@Reference
	private AxHrmsCommonApi axHrmsCommonApi;

	@Reference
	private EmployeeDetailsLocalService employeeDetailsLocalService;

	@Reference
	private HolidayLocalService holidayLocalService;

	@Reference
	private LeaveCompensatoryStatusMasterLocalService
		leaveCompensatoryStatusMasterLocalService;

	@Reference
	private LeaveDayTypeLocalService leaveDayTypeLocalService;

	@Reference
	private LeaveRequestLocalService leaveRequestLocalService;

	@Reference
	private WorkFromHomeDayTypeLocalService workFromHomeDayTypeLocalService;

	@Reference
	private WorkFromHomeRequestLocalService workFromHomeRequestLocalService;

	@Reference
	private MailTemplateConfiguration mailTemplateConfiguration;

}
