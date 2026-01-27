package com.ax.hrms.report.web.compensatory.report.actions;

import com.ax.hrms.master.model.*;
import com.ax.hrms.master.service.*;
import com.ax.hrms.model.*;
import com.ax.hrms.report.web.constants.AxHrmsCompensatoryReportWebPortletKeys;
import com.ax.hrms.report.web.util.CompensatoryOffExcelExportUtil;
import com.ax.hrms.service.*;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;

@Component(
        property = {
                "javax.portlet.name=" + AxHrmsCompensatoryReportWebPortletKeys.AXHRMSCOMPENSATORYREPORTWEB,
                "mvc.command.name=/comp/off/report/export"
        },
        service = MVCResourceCommand.class
)
public class FetchCompensatoryOffReportResourceCommand implements MVCResourceCommand{

    @Override
    public boolean serveResource(ResourceRequest request, ResourceResponse response) {

        try {

            String employeeType = ParamUtil.getString(request, "employeeType");
            boolean isPreviousMonth = ParamUtil.getBoolean(request, "previousMonth");

            String fromDateStr = ParamUtil.getString(request, "fromDate");
            String toDateStr = ParamUtil.getString(request, "toDate");

            List<Map<String, String>> reportData = new ArrayList<>();

            long[] employeeIds;

            if ("ALL".equalsIgnoreCase(employeeType)) {
                List<EmployeeDetails> allEmployees =
                        employeeDetailsLocalService.findByIsTerminated(false);

                employeeIds = allEmployees.stream()
                        .mapToLong(EmployeeDetails::getEmployeeId)
                        .toArray();

            } else {
                employeeIds = ParamUtil.getLongValues(request, "employeeIds");
            }

            Date startDate;
            Date endDate;

            if (isPreviousMonth) {
                LocalDate now = LocalDate.now();
                LocalDate prevMonth = now.minusMonths(1);

                LocalDate firstDay = prevMonth.withDayOfMonth(1);
                LocalDate lastDay = prevMonth.withDayOfMonth(prevMonth.lengthOfMonth());

                startDate = Date.from(firstDay.atStartOfDay(ZoneId.systemDefault()).toInstant());
                endDate = Date.from(lastDay.atTime(23, 59, 59)
                        .atZone(ZoneId.systemDefault()).toInstant());
            } else {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                startDate = sdf.parse(fromDateStr);
                endDate = sdf.parse(toDateStr);
            }

            SimpleDateFormat displayFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");

            LeaveTypeMaster compOffType =
                    leaveTypeMasterLocalService.findByLeaveTypeName(
                            AxHrmsCompensatoryReportWebPortletKeys.COMP_OFF);

            long compOffLeaveTypeId = compOffType.getLeaveTypeMasterId();

            for (long employeeId : employeeIds) {

                EmployeeDetails employeeDetails =
                        employeeDetailsLocalService.getEmployeeDetails(employeeId);

                List<LeaveRequest> leaveRequests =
                        leaveRequestLocalService.findByEmployeeId(employeeId);

                List<LeaveRequest> sortedLeaveRequests = new ArrayList<>(leaveRequests);
                sortedLeaveRequests.sort(Comparator.comparing(LeaveRequest::getDateOfRequest));

                // POLICY-AWARE BALANCE SETUP
                Calendar cal = Calendar.getInstance();
                cal.setTime(startDate);
                int currentPolicyYear = cal.get(Calendar.YEAR);

                LeavePolicyMaster currentPolicy =
                        leavePolicyMasterLocalService
                                .findByLeaveTypeMasterIdAndYear(
                                        compOffLeaveTypeId, currentPolicyYear);

                double runningBalance = 0;

                LeaveBalanceHistory history =
                        leaveBalanceHistoryLocalService
                                .findByEmployeeIdLeaveTypeMasterIdAndYear(
                                        employeeId, compOffLeaveTypeId, currentPolicyYear);

                if (history != null) {
                    runningBalance = history.getNoOfRemainingLeaves();
                }

                for (LeaveRequest leaveRequest : sortedLeaveRequests) {

                    LeaveTypeMaster leaveTypeMaster =
                            leaveTypeMasterLocalService.fetchLeaveTypeMaster(
                                    leaveRequest.getLeaveTypeMasterId());

                    if (leaveTypeMaster == null ||
                            !AxHrmsCompensatoryReportWebPortletKeys.COMP_OFF
                                    .equalsIgnoreCase(leaveTypeMaster.getLeaveTypeName())) {
                        continue;
                    }

                    if (leaveRequest.getStartDateTime().before(startDate)
                            || leaveRequest.getEndDateTime().after(endDate)) {
                        continue;
                    }

                    // POLICY YEAR CHANGE CHECK
                    cal.setTime(leaveRequest.getStartDateTime());
                    int requestYear = cal.get(Calendar.YEAR);

                    if (requestYear != currentPolicyYear) {

                        LeavePolicyMaster newPolicy =
                                leavePolicyMasterLocalService
                                        .findByLeaveTypeMasterIdAndYear(
                                                compOffLeaveTypeId, requestYear);

                        if (newPolicy == null || !newPolicy.getIsCarryForward()) {
                            runningBalance = 0;
                        } else if (newPolicy.getIsCheckMax()) {
                            runningBalance = Math.min(
                                    runningBalance, newPolicy.getMaximumBalance());
                        }

                        currentPolicyYear = requestYear;
                        currentPolicy = newPolicy;
                    }

                    Map<String, String> row = new LinkedHashMap<>();

                    row.put("Employee Code", employeeDetails.getEmployeeCode());
                    row.put("Employee Name",
                            employeeDetails.getFirstName() + StringPool.SPACE +
                                    employeeDetails.getLastName());
                    row.put("Employee Email", employeeDetails.getOfficialEmail());

                    EmployeeDepartment employeeDepartment =
                            employeeDepartmentLocalService
                                    .findByEmployeeId(employeeDetails.getEmployeeId());

                    DepartmentMaster departmentMaster = employeeDepartment != null
                            ? departmentMasterLocalService.fetchDepartmentMaster(
                            employeeDepartment.getDepartmentMasterId())
                            : null;

                    row.put("Department",
                            departmentMaster != null
                                    ? departmentMaster.getDepartmentName()
                                    : "-");

                    EmployeeDesignation employeeDesignation =
                            employeeDesignationLocalService
                                    .findByEmployeeId(employeeDetails.getEmployeeId());

                    DesignationMaster designationMaster = employeeDesignation != null
                            ? designationMasterLocalService.fetchDesignationMaster(
                            employeeDesignation.getDesignationMasterId())
                            : null;

                    row.put("Designation",
                            designationMaster != null
                                    ? designationMaster.getDesignationName()
                                    : "-");

                    long managerId = employeeDetails.getManagerId();
                    EmployeeDetails manager = managerId > 0
                            ? employeeDetailsLocalService.fetchEmployeeDetails(managerId)
                            : null;

                    row.put("Manager", manager != null
                            ? manager.getFirstName() + StringPool.SPACE +
                            manager.getLastName()
                            : "-");

                    row.put("Location", "Ahmedabad");
                    row.put("Employee Type", employeeDetails.getEmployeeType());

                    row.put("Start Date",
                            displayFormat.format(leaveRequest.getStartDateTime()));
                    row.put("End Date",
                            displayFormat.format(leaveRequest.getEndDateTime()));

                    LeaveCompensatoryStatusMaster statusMaster =
                            leaveCompensatoryStatusMasterLocalService
                                    .fetchLeaveCompensatoryStatusMaster(
                                            leaveRequest.getLeaveCompensatoryStatusMasterId());

                    String statusName = statusMaster != null
                            ? statusMaster.getLeaveCompensatoryStatus()
                            : "-";

                    row.put("Status", statusName);

                    List<LeaveDayType> leaveDays =
                            leaveDayTypeLocalService
                                    .findByLeaveRequestId(
                                            leaveRequest.getLeaveRequestId());

                    double noOfDays = 0.0;
                    for (LeaveDayType day : leaveDays) {
                        noOfDays += day.isIsHalfDay() ? 0.5 : 1.0;
                    }

                    // CORRECT BALANCE LOGIC
                    if (AxHrmsCompensatoryReportWebPortletKeys.APPROVED
                            .equalsIgnoreCase(statusName)) {

                        runningBalance += noOfDays;

                        if (currentPolicy != null && currentPolicy.getIsCheckMax()) {
                            runningBalance = Math.min(
                                    runningBalance,
                                    currentPolicy.getMaximumBalance());
                        }
                    }

                    row.put("Balance", String.valueOf(runningBalance));
                    row.put("No Of Days", String.valueOf(noOfDays));

                    EmployeeDetails actionBy =
                            leaveRequest.getManagerApprovalId() > 0
                                    ? employeeDetailsLocalService.fetchEmployeeDetails(
                                    leaveRequest.getManagerApprovalId())
                                    : null;

                    row.put("Action By", actionBy != null
                            ? actionBy.getFirstName() + StringPool.SPACE +
                            actionBy.getLastName()
                            : "-");

                    row.put("Action On",
                            leaveRequest.getModifiedDate() != null
                                    ? displayFormat.format(leaveRequest.getModifiedDate())
                                    : "-");

                    row.put("Reason", leaveRequest.getReason());

                    reportData.add(row);
                }
            }

            CompensatoryOffExcelExportUtil.exportCompOffReport(
                    reportData,
                    response,
                    AxHrmsCompensatoryReportWebPortletKeys.FILE_NAME);

        } catch (Exception e) {
            log.error("Exception in Comp Off Export", e);
        }

        return false;
    }

    private static final Log log =
            LogFactoryUtil.getLog(FetchCompensatoryOffReportResourceCommand.class);

    @Reference
    private EmployeeDetailsLocalService employeeDetailsLocalService;

    @Reference
    private LeaveRequestLocalService leaveRequestLocalService;

    @Reference
    private LeaveTypeMasterLocalService leaveTypeMasterLocalService;

    @Reference
    private EmployeeDepartmentLocalService employeeDepartmentLocalService;

    @Reference
    private DepartmentMasterLocalService departmentMasterLocalService;

    @Reference
    private EmployeeDesignationLocalService employeeDesignationLocalService;

    @Reference
    private DesignationMasterLocalService designationMasterLocalService;

    @Reference
    private LeaveCompensatoryStatusMasterLocalService leaveCompensatoryStatusMasterLocalService;

    @Reference
    private LeaveDayTypeLocalService leaveDayTypeLocalService;

    @Reference
    private LeavePolicyMasterLocalService leavePolicyMasterLocalService;

    @Reference
    private LeaveBalanceHistoryLocalService leaveBalanceHistoryLocalService;
}
