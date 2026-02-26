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
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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

        log.info("in leave balcne report of month wise");

        try {

            String employeeType = ParamUtil.getString(request, EMPLOYEE_TYPE);
            int year = ParamUtil.getInteger(request, YEAR);
            int month = ParamUtil.getInteger(request, "month");

            long approvedId = leaveCompensatoryStatusMasterLocalService.findByLeaveCompensatoryStatusName("Approved").getLeaveCompensatoryStatusMasterId();
            long pendingId = leaveCompensatoryStatusMasterLocalService.findByLeaveCompensatoryStatusName("Pending").getLeaveCompensatoryStatusMasterId();

            log.info("year" + year);
            log.info("month" + month);

            LocalDate today = LocalDate.now();
            int currentYear = today.getYear();
            int currentMonth = today.getMonthValue();

            if (year == currentYear && month > currentMonth) {
                throw new IllegalArgumentException("Future month selection not allowed.");
            }

            LocalDate yearStart = LocalDate.of(year, 1, 1);
            LocalDate monthStart = LocalDate.of(year, month, 1);
            LocalDate monthEnd = monthStart.withDayOfMonth(monthStart.lengthOfMonth());



            Date cumulativeStart = Date.from(
                    yearStart.atStartOfDay(ZoneId.systemDefault()).toInstant());

            Date cumulativeEnd = Date.from(
                    monthEnd.atTime(23, 59, 59)
                            .atZone(ZoneId.systemDefault()).toInstant());

            Date monthOnlyStart = Date.from(
                    monthStart.atStartOfDay(ZoneId.systemDefault()).toInstant());

            Date monthOnlyEnd = cumulativeEnd;

            long earnedLeaveId = 0;
            long loyaltyLeaveId = 0;
            long unpaidLeaveId = 0;

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
                else if ("Unpaid Leave".equalsIgnoreCase(name)) {
                    unpaidLeaveId = leaveType.getLeaveTypeMasterId();
                }
            }

            long[] employeeIds;

            if (ALL.equalsIgnoreCase(employeeType)) {

                List<EmployeeDetails> allEmployees =
                        employeeDetailsLocalService.findByIsTerminated(false);

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

                    EmployeeDetails employee;

                    try {
                        employee = employeeDetailsLocalService.getEmployeeDetails(employeeId);
                    } catch (Exception e) {
                        log.error("Employee not found for ID: " + employeeId, e);
                        continue;
                    }

                    JSONObject employeeJson = JSONFactoryUtil.createJSONObject();
                    employeeJson.put("Employee Code", employee.getEmployeeCode());
                    employeeJson.put("Employee Name",
                            employee.getFirstName() + " " + employee.getLastName());
                    employeeJson.put("Email", employee.getOfficialEmail());

                    double finalBalance = 0.0;
                    double earnedAllocation = 0.0;
                    double loyaltyAllocation = 0.0;

                    double earnedTakenTotal = 0.0;
                    double loyaltyTakenTotal = 0.0;
                    double earnedTakenMonth = 0.0;
                    double loyaltyTakenMonth = 0.0;
                    double unpaidTakenMonth = 0.0;






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

                        } else {

                            try {
                                LeaveBalanceHistory earnedHistory =
                                        leaveBalanceHistoryLocalService
                                                .findByEmployeeIdLeaveTypeMasterIdAndYear(
                                                        employeeId, earnedLeaveId, year);

                                if (earnedHistory != null) {
                                    earnedAllocation =
                                            earnedHistory.getNoOfUsedLeaves()
                                                    + earnedHistory.getNoOfRemainingLeaves();
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
                                }

                            } catch (Exception ignored) {}
                        }



                    List<LeaveRequest> leaveRequests =
                            leaveRequestLocalService.findByEmployeeId(employeeId);

                    for (LeaveRequest leaveRequest : leaveRequests) {

                        if (leaveRequest.getLeaveCompensatoryStatusMasterId() != approvedId
                                && leaveRequest.getLeaveCompensatoryStatusMasterId() != pendingId) {
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

                            // ===== CUMULATIVE CALCULATION =====
                            if (!leaveDate.before(cumulativeStart)
                                    && !leaveDate.after(cumulativeEnd)) {

                                if (leaveRequest.getLeaveTypeMasterId() == earnedLeaveId) {
                                    earnedTakenTotal += count;
                                }
                                else if (leaveRequest.getLeaveTypeMasterId() == loyaltyLeaveId) {
                                    loyaltyTakenTotal += count;
                                }
                            }

                            if (!leaveDate.before(monthOnlyStart)
                                    && !leaveDate.after(monthOnlyEnd)) {

                                if (leaveRequest.getLeaveTypeMasterId() == earnedLeaveId) {
                                    earnedTakenMonth += count;
                                }
                                else if (leaveRequest.getLeaveTypeMasterId() == loyaltyLeaveId) {
                                    loyaltyTakenMonth += count;
                                }
                                else if (leaveRequest.getLeaveTypeMasterId() == unpaidLeaveId) {
                                    unpaidTakenMonth += count;
                                }
                            }
                        }
                    }




                        double openingBalance = earnedAllocation + loyaltyAllocation;

                        finalBalance =
                                openingBalance
                                        - (earnedTakenTotal + loyaltyTakenTotal);


                    double leaveTakenMonth =
                            earnedTakenMonth + loyaltyTakenMonth;

                    double unpaidMonth =
                            -unpaidTakenMonth;

                    Map<String, Double> balanceMap = new LinkedHashMap<>();
                    balanceMap.put("Leave Balance", finalBalance);
                    balanceMap.put("Leave Taken", leaveTakenMonth);
                    balanceMap.put("Unpaid Leave", unpaidMonth);

                    leaveBalanceData.put(employeeJson.toString(), balanceMap);

                } catch (Exception ex) {
                    log.error("Error processing employee: " + employeeId, ex);
                }
            }

            log.info("leave balance " + leaveBalanceData);
            MonthWiseLeaveBalanceExcelUtil.exportMonthWiseLeaveBalance(leaveBalanceData,response);

        } catch (Exception e) {
            log.error("Exception in Month Wise Leave Balance Export", e);
        }

        return false;
    }
}