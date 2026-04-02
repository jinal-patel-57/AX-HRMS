package com.ax.hrms.report.web.leave.report.actions;

import com.ax.hrms.master.exception.NoSuchLeaveCompensatoryStatusMasterException;
import com.ax.hrms.master.model.LeaveCompensatoryStatusMaster;
import com.ax.hrms.master.model.LeaveTypeMaster;
import com.ax.hrms.master.service.LeaveCompensatoryStatusMasterLocalService;
import com.ax.hrms.master.service.LeaveTypeMasterLocalService;
import com.ax.hrms.model.EmployeeDetails;
import com.ax.hrms.model.LeaveDayTypeTable;
import com.ax.hrms.model.LeaveRequestTable;
import com.ax.hrms.report.web.leave.report.dto.LeaveDetailsReportDTO;
import com.ax.hrms.report.web.util.LeaveDetailsReportExcelExportUtil;
import com.ax.hrms.service.EmployeeDetailsLocalService;
import com.ax.hrms.service.LeaveRequestLocalService;
import com.liferay.petra.sql.dsl.DSLQueryFactoryUtil;
import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

import static com.ax.hrms.report.web.constants.AkHrmsLeaveBalanceReportWebPortletKeys.*;

@Component(property = {"javax.portlet.name=" + AKHRMSLEAVEREPORTWEB, "mvc.command.name=/leave_report/export"}, service = MVCResourceCommand.class)
public class FetchLeaveDetailsReportMVCResourceCommand implements MVCResourceCommand {

    private static final Log log = LogFactoryUtil.getLog(FetchLeaveDetailsReportMVCResourceCommand.class);

    public static final String EMPLOYEE_IDS = "employeeIds";
    public static final String YEAR = "year";
    public static final String EMPLOYEE_TYPE = "employeeType";
    public static final String START_DATE = "startDate";
    public static final String END_DATE = "endDate";

    @Override
    public boolean serveResource(ResourceRequest request, ResourceResponse response) {

        try {
            LocalDate startDate = LocalDate.parse(ParamUtil.getString(request, START_DATE));
            LocalDate endDate = LocalDate.parse(ParamUtil.getString(request, END_DATE));

            validateDates(startDate, endDate);

            long[] employeeIds = getEmployeeIds(request);

            List<Object[]> results = fetchLeaveData(employeeIds, startDate, endDate);

            List<LeaveDetailsReportDTO> reportList = buildReport(results, startDate, endDate);
            reportList.sort(Comparator.comparing(LeaveDetailsReportDTO::getEmployeeEmail));

            LeaveDetailsReportExcelExportUtil.exportLeaveReport(reportList, response, "Leave Details Report");

        } catch (Exception e) {
            log.error("Error generating report", e);
        }

        return false;
    }

    private void validateDates(LocalDate start, LocalDate end) {
        if (start == null || end == null) {
            log.info("Start or End date missing");
            return;
        }
        if (start.isAfter(end)) {
            log.info("Start date cannot be after End date");
            return;
        }
    }

    private long[] getEmployeeIds(ResourceRequest request) {

        String employeeType = ParamUtil.getString(request, EMPLOYEE_TYPE);

        if (ALL.equalsIgnoreCase(employeeType)) {
            return employeeDetailsLocalService.findByIsTerminated(false).stream().mapToLong(EmployeeDetails::getEmployeeId).toArray();
        }

        return ParamUtil.getLongValues(request, EMPLOYEE_IDS);
    }

    private List<Object[]> fetchLeaveData(long[] empIds, LocalDate startDate, LocalDate endDate) {

        Long[] ids = Arrays.stream(empIds).boxed().toArray(Long[]::new);

        DSLQuery query = DSLQueryFactoryUtil.select(LeaveRequestTable.INSTANCE.employeeId, LeaveRequestTable.INSTANCE.startDateTime, LeaveRequestTable.INSTANCE.endDateTime, LeaveRequestTable.INSTANCE.leaveTypeMasterId, LeaveRequestTable.INSTANCE.leaveCompensatoryStatusMasterId, LeaveRequestTable.INSTANCE.createDate, LeaveRequestTable.INSTANCE.managerApprovalId, LeaveRequestTable.INSTANCE.modifiedDate, LeaveRequestTable.INSTANCE.reason, LeaveDayTypeTable.INSTANCE.isHalfDay, LeaveDayTypeTable.INSTANCE.leaveDate, LeaveRequestTable.INSTANCE.leaveRequestId).from(LeaveRequestTable.INSTANCE).leftJoinOn(LeaveDayTypeTable.INSTANCE, LeaveDayTypeTable.INSTANCE.leaveRequestId.eq(LeaveRequestTable.INSTANCE.leaveRequestId)).where(LeaveRequestTable.INSTANCE.employeeId.in(ids).and(LeaveRequestTable.INSTANCE.startDateTime.lte(java.sql.Timestamp.valueOf(endDate.atStartOfDay()))).and(LeaveRequestTable.INSTANCE.endDateTime.gte(java.sql.Timestamp.valueOf(startDate.atStartOfDay()))));

        return leaveRequestLocalService.dslQuery(query);
    }

    private List<LeaveDetailsReportDTO> buildReport(List<Object[]> results, LocalDate filterStart, LocalDate filterEnd) {

        List<LeaveDetailsReportDTO> list = new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy");

        Map<Long, List<Object[]>> requestMap = new HashMap<>();

        for (Object[] row : results) {
            Long requestId = (Long) row[11];

            requestMap.computeIfAbsent(requestId, k -> new ArrayList<>()).add(row);
        }

        for (List<Object[]> rows : requestMap.values()) {

            Object[] first = rows.get(0);

            long empId = (long) first[0];
            long leaveTypeId = (long) first[3];
            long statusId = (long) first[4];

            String status = getStatus(statusId);

            if (!isValidStatus(status)) continue;

            LocalDate leaveStart = toLocalDate((Date) first[1]);
            LocalDate leaveEnd = toLocalDate((Date) first[2]);

            double days = 0.0;

            for (Object[] row : rows) {

                Boolean isHalfDay = (Boolean) row[9];
                Date dt = (Date) row[10];

                if (dt == null) continue;

                LocalDate leaveDate = toLocalDate(dt);

                if (leaveDate.isBefore(filterStart) || leaveDate.isAfter(filterEnd)) {
                    continue;
                }

                days += Boolean.TRUE.equals(isHalfDay) ? 0.5 : 1.0;
            }

            if (days <= 0) continue;

            EmployeeDetails emp = employeeDetailsLocalService.fetchEmployeeDetails(empId);

            LeaveDetailsReportDTO dto = buildDTO(first, emp, leaveTypeId, status, leaveStart, leaveEnd, days, formatter);

            list.add(dto);
        }

        return list;
    }

    private String getStatus(long statusId) {
        try {
            LeaveCompensatoryStatusMaster status = leaveCompensatoryStatusMasterLocalService.findByLeaveCompensatoryStatusById(statusId);

            return status != null ? status.getLeaveCompensatoryStatus() : "";

        } catch (NoSuchLeaveCompensatoryStatusMasterException e) {
            return "";
        }
    }

    private LeaveDetailsReportDTO buildDTO(Object[] row, EmployeeDetails emp, long leaveTypeId, String status, LocalDate start, LocalDate end, double days, DateTimeFormatter formatter) {

        LeaveDetailsReportDTO dto = new LeaveDetailsReportDTO();

        dto.setEmployeeCode(String.valueOf(emp.getEmployeeId()));
        dto.setEmployeeName(emp.getFirstName() + " " + emp.getLastName());
        dto.setEmployeeEmail(emp.getOfficialEmail());

        LeaveTypeMaster leaveType = leaveTypeMasterLocalService.fetchLeaveTypeMaster(leaveTypeId);

        dto.setLeaveType(leaveType != null ? leaveType.getLeaveTypeName() : "Unknown");

        dto.setDays(days);
        dto.setStartDate(start.format(formatter));
        dto.setEndDate(end.format(formatter));
        dto.setStatus(status);
        dto.setReason((String) row[8]);

        dto.setRequestedDate(formatDate((java.util.Date) row[5], formatter));

        long approverId = (long) row[6];
        if (approverId != 0) {
            EmployeeDetails approver = employeeDetailsLocalService.fetchEmployeeDetails(approverId);
            dto.setApprovedBy(approver.getFirstName() + " " + approver.getLastName());
            dto.setApprovedDate(formatDate((java.util.Date) row[7], formatter));
        }

        return dto;
    }

    private boolean isValidStatus(String status) {
        return "Pending".equalsIgnoreCase(status) || "Approved".equalsIgnoreCase(status);
    }

    private LocalDate toLocalDate(java.util.Date date) {
        return date != null ? new java.sql.Date(date.getTime()).toLocalDate() : null;
    }

    private String formatDate(java.util.Date date, DateTimeFormatter formatter) {
        return date != null ? toLocalDate(date).format(formatter) : "";
    }

    @Reference
    private LeaveCompensatoryStatusMasterLocalService leaveCompensatoryStatusMasterLocalService;

    @Reference
    private LeaveTypeMasterLocalService leaveTypeMasterLocalService;

    @Reference
    private LeaveRequestLocalService leaveRequestLocalService;

    @Reference
    private EmployeeDetailsLocalService employeeDetailsLocalService;
}