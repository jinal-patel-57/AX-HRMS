package com.ax.hrms.report.web.leave.report.actions;

import com.ax.hrms.master.exception.NoSuchLeaveCompensatoryStatusMasterException;
import com.ax.hrms.master.model.LeaveCompensatoryStatusMaster;
import com.ax.hrms.master.service.LeaveCompensatoryStatusMasterLocalService;
import com.ax.hrms.master.service.LeaveTypeMasterLocalService;
import com.ax.hrms.model.EmployeeDetails;
import com.ax.hrms.model.LeaveRequestTable;
import com.ax.hrms.report.web.leave.report.dto.LeaveReportDTO;
import com.ax.hrms.report.web.util.LeaveReportExcelExportUtil;
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
import java.util.ArrayList;
import java.util.List;

import static com.ax.hrms.report.web.constants.AkHrmsLeaveBalanceReportWebPortletKeys.*;

@Component(property = {"javax.portlet.name=" + AKHRMSLEAVEREPORTWEB, "mvc.command.name=/leave_report/export"}, service = MVCResourceCommand.class)
public class FetchLeaveReportMVCResourceCommand implements MVCResourceCommand {

    private static final Log log = LogFactoryUtil.getLog(FetchLeaveReportMVCResourceCommand.class);

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

            List<LeaveReportDTO> reportList = buildReport(results, startDate, endDate);

            LeaveReportExcelExportUtil.exportLeaveReport(reportList, response, "Leave_Report");

        } catch (IllegalArgumentException e) {
            log.error("Validation error: " + e.getMessage());
        } catch (Exception e) {
            log.error("Unexpected error while generating report" + e.getMessage());
        }

        return false;
    }

    private void validateDates(LocalDate start, LocalDate end) {
        if (start == null || end == null) {
            throw new IllegalArgumentException("Start or End date missing");
        }
        if (start.isAfter(end)) {
            throw new IllegalArgumentException("Start date cannot be after End date");
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

        Long[] ids = java.util.Arrays.stream(empIds).boxed().toArray(Long[]::new);

        DSLQuery query = DSLQueryFactoryUtil.select(LeaveRequestTable.INSTANCE.employeeId, LeaveRequestTable.INSTANCE.startDateTime, LeaveRequestTable.INSTANCE.endDateTime, LeaveRequestTable.INSTANCE.leaveTypeMasterId, LeaveRequestTable.INSTANCE.leaveCompensatoryStatusMasterId, LeaveRequestTable.INSTANCE.createDate, LeaveRequestTable.INSTANCE.managerApprovalId, LeaveRequestTable.INSTANCE.modifiedDate, LeaveRequestTable.INSTANCE.reason).from(LeaveRequestTable.INSTANCE).where(LeaveRequestTable.INSTANCE.employeeId.in(ids).and(LeaveRequestTable.INSTANCE.startDateTime.lte(java.sql.Timestamp.valueOf(endDate.atStartOfDay()))).and(LeaveRequestTable.INSTANCE.endDateTime.gte(java.sql.Timestamp.valueOf(startDate.atStartOfDay()))));

        return leaveRequestLocalService.dslQuery(query);
    }

    private List<LeaveReportDTO> buildReport(List<Object[]> results, LocalDate filterStart, LocalDate filterEnd) {

        List<LeaveReportDTO> list = new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy");

        for (Object[] row : results) {

            LeaveReportDTO dto = processRow(row, filterStart, filterEnd, formatter);

            if (dto != null) {
                list.add(dto);
            }
        }

        return list;
    }

    private LeaveReportDTO processRow(Object[] row, LocalDate filterStart, LocalDate filterEnd, DateTimeFormatter formatter) {
        try {

            if (row == null || row.length < 9) {
                log.warn("Invalid row data");
                return null;
            }

            long empId = (long) row[0];

            LocalDate leaveStart = toLocalDate((java.util.Date) row[1]);
            LocalDate leaveEnd = toLocalDate((java.util.Date) row[2]);

            if (leaveStart == null || leaveEnd == null) {
                log.warn("Invalid leave dates for empId: " + empId);
                return null;
            }
            LocalDate actualStart = leaveStart.isAfter(filterStart) ? leaveStart : filterStart;
            LocalDate actualEnd = leaveEnd.isBefore(filterEnd) ? leaveEnd : filterEnd;

            LocalDate[] workingRange = getWorkingRange(actualStart, actualEnd);

            LocalDate displayStart = workingRange[0];
            LocalDate displayEnd = workingRange[1];

            if (displayStart.isAfter(displayEnd)) return null;

            long days = calculateWorkingDays(actualStart, actualEnd);
            if (days <= 0) return null;

            long leaveTypeId = (long) row[3];
            long statusId = (long) row[4];

            String status = getStatus(statusId);

            if (!isValidStatus(status)) return null;

            EmployeeDetails emp = employeeDetailsLocalService.fetchEmployeeDetails(empId);

            if (leaveStart == null || leaveEnd == null) {
                log.warn("Invalid leave dates for empId: " + empId);
                return null;
            }
            return buildDTO(row, emp, leaveTypeId, status, displayStart, displayEnd, days, formatter);
        } catch (Exception e) {
            log.error("Error processing row", e);
            return null;
        }
    }

    private String getStatus(long statusId) {

        try {
            LeaveCompensatoryStatusMaster statusMaster = leaveCompensatoryStatusMasterLocalService.findByLeaveCompensatoryStatusById(statusId);

            return statusMaster != null ? statusMaster.getLeaveCompensatoryStatus() : "";

        } catch (NoSuchLeaveCompensatoryStatusMasterException e) {
            log.warn("Invalid statusId: " + statusId);
            return "";
        } catch (Exception e) {
            log.error("Error fetching status", e);
            return "";
        }
    }

    private LeaveReportDTO buildDTO(Object[] row, EmployeeDetails emp, long leaveTypeId, String status, LocalDate start, LocalDate end, long days, DateTimeFormatter formatter) {

        LeaveReportDTO dto = new LeaveReportDTO();
        try {
            dto.setEmployeeCode(String.valueOf(emp.getEmployeeId()));
            dto.setEmployeeName(emp.getFirstName() + " " + emp.getLastName());
            dto.setEmployeeEmail(emp.getOfficialEmail());

            dto.setLeaveType(leaveTypeMasterLocalService.fetchLeaveTypeMaster(leaveTypeId).getLeaveTypeName());

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
        } catch (Exception e) {
            log.error("Error building DTO" + e.getMessage());
        }

        return dto;
    }

    private boolean isValidStatus(String status) {
        return "Pending".equalsIgnoreCase(status) || "Approved".equalsIgnoreCase(status);
    }

    private LocalDate toLocalDate(java.util.Date date) {
        try {
            return date != null ? new java.sql.Date(date.getTime()).toLocalDate() : null;
        } catch (Exception e) {
            log.error("Date conversion error", e);
            return null;
        }
    }

    private String formatDate(java.util.Date date, DateTimeFormatter formatter) {
        try {
            return date != null ? toLocalDate(date).format(formatter) : "";
        } catch (Exception e) {
            log.error("Date formatting error", e);
            return "";
        }
    }

    private long calculateWorkingDays(LocalDate start, LocalDate end) {
        long days = 0;

        while (!start.isAfter(end)) {
            if (start.getDayOfWeek() != DayOfWeek.SATURDAY && start.getDayOfWeek() != DayOfWeek.SUNDAY) {
                days++;
            }
            start = start.plusDays(1);
        }

        return days;
    }

    private LocalDate[] getWorkingRange(LocalDate start, LocalDate end) {

        while (start.getDayOfWeek() == DayOfWeek.SATURDAY || start.getDayOfWeek() == DayOfWeek.SUNDAY) {
            start = start.plusDays(1);
        }

        while (end.getDayOfWeek() == DayOfWeek.SATURDAY || end.getDayOfWeek() == DayOfWeek.SUNDAY) {
            end = end.minusDays(1);
        }

        return new LocalDate[]{start, end};
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