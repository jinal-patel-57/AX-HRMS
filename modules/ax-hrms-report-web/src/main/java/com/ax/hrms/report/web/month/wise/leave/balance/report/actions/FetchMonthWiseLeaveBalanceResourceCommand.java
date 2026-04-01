package com.ax.hrms.report.web.month.wise.leave.balance.report.actions;

import com.ax.hrms.master.model.LeaveTypeMaster;
import com.ax.hrms.master.service.LeaveCompensatoryStatusMasterLocalService;
import com.ax.hrms.master.service.LeaveTypeMasterLocalService;
import com.ax.hrms.model.*;
import com.ax.hrms.report.web.constants.AxHrmsMonthWiseLeaveBalanceReportWebPortletKeys;
import com.ax.hrms.report.web.leave.balance.actions.FetchLeaveBalanceResourceCommand;
import com.ax.hrms.report.web.util.MonthWiseLeaveBalanceExcelUtil;
import com.ax.hrms.service.*;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;
import java.util.stream.Collectors;

import static com.ax.hrms.report.web.constants.AkHrmsLeaveBalanceReportWebPortletKeys.ALL;

@Component(
        property = {
                "javax.portlet.name=" + AxHrmsMonthWiseLeaveBalanceReportWebPortletKeys.AXHRMSMONTHWISELEAVEBALANCEREPORTWEB,
                "mvc.command.name=/month_wise_leave_balance/export"
        },
        service = MVCResourceCommand.class
)
public class FetchMonthWiseLeaveBalanceResourceCommand implements MVCResourceCommand {

    public static final String EMPLOYEE_IDS = "employeeIds";
    public static final String YEAR = "year";
    public static final String EMPLOYEE_TYPE = "employeeType";

    private static final Log log =
            LogFactoryUtil.getLog(FetchLeaveBalanceResourceCommand.class);

    @Reference private LeaveTypeMasterLocalService leaveTypeMasterLocalService;
    @Reference private LeaveBalanceHistoryLocalService leaveBalanceHistoryLocalService;
    @Reference private LeaveBalanceLocalService leaveBalanceLocalService;
    @Reference private EmployeeDetailsLocalService employeeDetailsLocalService;
    @Reference private LeaveRequestLocalService leaveRequestLocalService;
    @Reference private LeaveDayTypeLocalService leaveDayTypeLocalService;
    @Reference private LeaveCompensatoryStatusMasterLocalService leaveCompensatoryStatusMasterLocalService;

    @Override
    public boolean serveResource(ResourceRequest request, ResourceResponse response) {

        log.info("Year-wise Leave Balance Report");

        try {

            String employeeType = ParamUtil.getString(request, EMPLOYEE_TYPE);
            int year = ParamUtil.getInteger(request, YEAR);

            long approvedId = leaveCompensatoryStatusMasterLocalService
                    .findByLeaveCompensatoryStatusName("Approved")
                    .getLeaveCompensatoryStatusMasterId();

            long pendingId = leaveCompensatoryStatusMasterLocalService
                    .findByLeaveCompensatoryStatusName("Pending")
                    .getLeaveCompensatoryStatusMasterId();

            LocalDate today = LocalDate.now();
            int currentYear = today.getYear();

            //  Date Range (Year-based only)
            LocalDate startDate = LocalDate.of(year, 1, 1);
            LocalDate endDate = (year == currentYear)
                    ? today
                    : LocalDate.of(year, 12, 31);

            Date cumulativeStart = Date.from(
                    startDate.atStartOfDay(ZoneId.systemDefault()).toInstant());

            Date cumulativeEnd = Date.from(
                    endDate.atTime(23, 59, 59)
                            .atZone(ZoneId.systemDefault()).toInstant());

            long earnedLeaveId = 0;
            long loyaltyLeaveId = 0;

            List<LeaveTypeMaster> leaveTypes =
                    leaveTypeMasterLocalService.getLeaveTypeMasters(
                            QueryUtil.ALL_POS, QueryUtil.ALL_POS);

            for (LeaveTypeMaster leaveType : leaveTypes) {

                String name = leaveType.getLeaveTypeName();

                if ("Earned Leave".equalsIgnoreCase(name)) {
                    earnedLeaveId = leaveType.getLeaveTypeMasterId();
                }
                else if ("Loyalty Leave".equalsIgnoreCase(name)) {
                    loyaltyLeaveId = leaveType.getLeaveTypeMasterId();
                }
            }

            long[] employeeIds;

            if (ALL.equalsIgnoreCase(employeeType)) {

                List<EmployeeDetails> allEmployees = employeeDetailsLocalService
                        .findByIsTerminated(false)
                        .stream()
                        .sorted(Comparator
                                .comparing(EmployeeDetails::getJoiningDate,
                                        Comparator.nullsLast(Comparator.naturalOrder()))
                                .thenComparing(e ->
                                        (e.getFirstName() + " " + e.getLastName()).toLowerCase()
                                )
                        )
                        .collect(Collectors.toList());
                employeeIds = allEmployees.stream()
                        .mapToLong(EmployeeDetails::getEmployeeId)
                        .toArray();
            }
            else {
                employeeIds = ParamUtil.getLongValues(request, EMPLOYEE_IDS);
            }

            Map<String, Map<String, Double>> leaveBalanceData =
                    new LinkedHashMap<>();

            for (long employeeId : employeeIds) {

                try {

                    EmployeeDetails employee =
                            employeeDetailsLocalService.getEmployeeDetails(employeeId);

                    JSONObject employeeJson = JSONFactoryUtil.createJSONObject();
                    employeeJson.put("Employee Code", employee.getEmployeeCode());
                    employeeJson.put("Employee Name",
                            employee.getFirstName() + " " + employee.getLastName());
                    employeeJson.put("Email", employee.getOfficialEmail());

                    double earnedAllocation = 0.0;
                    double loyaltyAllocation = 0.0;
                    double earnedTakenTotal = 0.0;
                    double loyaltyTakenTotal = 0.0;

                    // ===============================
                    // CURRENT YEAR LOGIC
                    // ===============================
                    if (year == currentYear) {

                        try {
                            LeaveBalance earned =
                                    leaveBalanceLocalService
                                            .findByEmployeeIdLeaveTypeMasterIdAndYear(
                                                    employeeId, earnedLeaveId, year);

                            if (earned != null) {
                                earnedAllocation =
                                        earned.getNoOfUsedLeaves()
                                                + earned.getNoOfRemainingLeaves();
                            }

                        } catch (Exception ignored) {}

                        try {
                            LeaveBalance loyalty =
                                    leaveBalanceLocalService
                                            .findByEmployeeIdLeaveTypeMasterIdAndYear(
                                                    employeeId, loyaltyLeaveId, year);

                            if (loyalty != null) {
                                loyaltyAllocation =
                                        loyalty.getNoOfUsedLeaves()
                                                + loyalty.getNoOfRemainingLeaves();
                            }

                        } catch (Exception ignored) {}



                        Set<LeaveRequest> leaveRequests = new HashSet<>();

                        leaveRequests.addAll(
                                leaveRequestLocalService.findByEmployeeIdAndLeaveTypeId(employeeId, earnedLeaveId)
                        );

                        leaveRequests.addAll(
                                leaveRequestLocalService.findByEmployeeIdAndLeaveTypeId(employeeId, loyaltyLeaveId)
                        );

                        for (LeaveRequest leaveRequest : leaveRequests) {

                            //  Only approved
                            long statusId = leaveRequest.getLeaveCompensatoryStatusMasterId();

                            if (statusId != approvedId && statusId != pendingId) {
                                continue;
                            }

                            List<LeaveDayType> leaveDays =
                                    leaveDayTypeLocalService
                                            .findByLeaveRequestId(leaveRequest.getLeaveRequestId());

                            for (LeaveDayType leaveDay : leaveDays) {

                                if (leaveDay == null || leaveDay.getLeaveDate() == null)
                                    continue;

                                Date leaveDate = leaveDay.getLeaveDate();
                                double count = leaveDay.isIsHalfDay() ? 0.5 : 1.0;

                                if (!leaveDate.before(cumulativeStart)
                                        && !leaveDate.after(cumulativeEnd)) {

                                    if (leaveRequest.getLeaveTypeMasterId() == earnedLeaveId) {
                                        earnedTakenTotal += count;

                                    } else if (leaveRequest.getLeaveTypeMasterId() == loyaltyLeaveId) {
                                        loyaltyTakenTotal += count;
                                    }
                                }
                            }
                        }
                    }

                    // ===============================
                    //  PAST YEAR LOGIC (NO CALCULATION)
                    // ===============================
                    else {

                        try {
                            LeaveBalanceHistory earnedHistory =
                                    leaveBalanceHistoryLocalService
                                            .findByEmployeeIdLeaveTypeMasterIdAndYear(
                                                    employeeId, earnedLeaveId, year);

                            if (earnedHistory != null) {
                                earnedAllocation =
                                        earnedHistory.getNoOfUsedLeaves()
                                                + earnedHistory.getNoOfRemainingLeaves();

                                earnedTakenTotal = earnedHistory.getNoOfUsedLeaves();
                            }

                        } catch (Exception ignored) {}

                        try {
                            LeaveBalanceHistory loyaltyHistory =
                                    leaveBalanceHistoryLocalService
                                            .findByEmployeeIdLeaveTypeMasterIdAndYear(
                                                    employeeId, loyaltyLeaveId, year);

                            if (loyaltyHistory != null) {
                                loyaltyAllocation =
                                        loyaltyHistory.getNoOfUsedLeaves()
                                                + loyaltyHistory.getNoOfRemainingLeaves();

                                loyaltyTakenTotal = loyaltyHistory.getNoOfUsedLeaves();
                            }

                        } catch (Exception ignored) {}
                    }

                    // ===============================
                    //  FINAL CALCULATION
                    // ===============================
                    double openingBalance = earnedAllocation + loyaltyAllocation;

                    double finalBalance =
                            openingBalance - (earnedTakenTotal + loyaltyTakenTotal);

                    double leaveTaken =
                            earnedTakenTotal + loyaltyTakenTotal;

                    Map<String, Double> balanceMap = new LinkedHashMap<>();
                    balanceMap.put("Leave Balance", finalBalance);
                    balanceMap.put("Leave Taken", leaveTaken);

                    leaveBalanceData.put(employeeJson.toString(), balanceMap);

                } catch (Exception ex) {
                    log.error("Error processing employee: " + employeeId, ex);
                }
            }

            MonthWiseLeaveBalanceExcelUtil.exportMonthWiseLeaveBalance(
                    leaveBalanceData, response,year);

        } catch (Exception e) {
            log.error("Exception in Leave Balance Report", e);
        }

        return false;
    }
}