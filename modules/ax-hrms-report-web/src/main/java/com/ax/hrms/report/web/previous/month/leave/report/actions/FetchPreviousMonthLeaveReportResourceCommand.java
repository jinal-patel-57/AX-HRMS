package com.ax.hrms.report.web.previous.month.leave.report.actions;

import com.ax.hrms.master.model.LeaveTypeMaster;
import com.ax.hrms.master.service.LeaveTypeMasterLocalService;
import com.ax.hrms.model.*;
import com.ax.hrms.report.web.constants.AxHrmsPreviousMonthLeaveReportWebPortletKeys;
import com.ax.hrms.report.web.leave.balance.actions.FetchLeaveBalanceResourceCommand;
import com.ax.hrms.report.web.util.ExcelExportUtil;
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
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static com.ax.hrms.report.web.constants.AkHrmsLeaveBalanceReportWebPortletKeys.*;

@Component(
        property = {
                "javax.portlet.name=" + AxHrmsPreviousMonthLeaveReportWebPortletKeys.AXHRMSPREVIOUSMONTHLEAVEREPORTWEB,
                "mvc.command.name=/previous/month/leave/report/export"
        },
        service = MVCResourceCommand.class
)
public class FetchPreviousMonthLeaveReportResourceCommand implements MVCResourceCommand {


    public static final String EMPLOYEE_IDS = "employeeIds";

    public static final String EMPLOYEE_TYPE = "employeeType";

    @Override
    public boolean serveResource(ResourceRequest request, ResourceResponse response) {

        try {

            String employeeType = ParamUtil.getString(request, EMPLOYEE_TYPE);
            boolean isPreviousMonth = ParamUtil.getBoolean(request, "previousMonth");

            Map<String, Map<String, Double>> leaveBalanceData = new LinkedHashMap<>();

            long[] employeeIds;

            if (ALL.equalsIgnoreCase(employeeType)) {
                List<EmployeeDetails> allEmployees =
                        employeeDetailsLocalService.findByIsTerminated(false);
                employeeIds = allEmployees.stream()
                        .mapToLong(EmployeeDetails::getEmployeeId)
                        .toArray();

            } else {
                employeeIds = ParamUtil.getLongValues(request, EMPLOYEE_IDS);
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
                String fromDateStr = ParamUtil.getString(request, "fromDate");
                String toDateStr = ParamUtil.getString(request, "toDate");

                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

                startDate = sdf.parse(fromDateStr);
                endDate = sdf.parse(toDateStr);
            }

            List<LeaveTypeMaster> leaveTypes =
                    leaveTypeMasterLocalService.getLeaveTypeMasters(
                            QueryUtil.ALL_POS, QueryUtil.ALL_POS);

            for (long employeeId : employeeIds) {

                EmployeeDetails employeeDetails =
                        employeeDetailsLocalService.getEmployeeDetails(employeeId);

                JSONObject employeeDetailsJson = JSONFactoryUtil.createJSONObject();
                employeeDetailsJson.put(EMPLOYEE_ID, employeeDetails.getEmployeeCode());
                employeeDetailsJson.put(EMPLOYEE_NAME,
                        employeeDetails.getFirstName() + " " + employeeDetails.getLastName());
                employeeDetailsJson.put(EMPLOYEE_EMAIL,
                        employeeDetails.getOfficialEmail());

                Map<String, Double> leaveTypeCountMap = new LinkedHashMap<>();

                for (LeaveTypeMaster leaveType : leaveTypes) {
                    leaveTypeCountMap.put(leaveType.getLeaveTypeName(), 0.0);
                }

                List<LeaveRequest> leaveRequests =
                        leaveRequestLocalService.findByEmployeeId(employeeId);

                for (LeaveRequest leaveRequest : leaveRequests) {

                    long leaveTypeMasterId = leaveRequest.getLeaveTypeMasterId();

                    LeaveTypeMaster leaveTypeMaster =
                            leaveTypeMasterLocalService.fetchLeaveTypeMaster(leaveTypeMasterId);

                    if (leaveTypeMaster == null) {
                        continue;
                    }

                    String leaveTypeName = leaveTypeMaster.getLeaveTypeName();

                    List<LeaveDayType> leaveDays =
                            leaveDayTypeLocalService.findByLeaveRequestId(
                                    leaveRequest.getLeaveRequestId());

                    for (LeaveDayType leaveDay : leaveDays) {

                        Date leaveDate = leaveDay.getLeaveDate();

                        if (!leaveDate.before(startDate) && !leaveDate.after(endDate)) {

                            double current = leaveTypeCountMap.getOrDefault(leaveTypeName, 0.0);

                            if (leaveDay.isIsHalfDay()) {
                                current += 0.5;
                            } else {
                                current += 1.0;
                            }

                            leaveTypeCountMap.put(leaveTypeName, current);

                        }
                    }
                }

                leaveBalanceData.put(String.valueOf(employeeDetailsJson), leaveTypeCountMap);

            }

            ExcelExportUtil.exportLeaveBalance(
                    leaveBalanceData,
                    response,
                    "AX_Leave_Report"
            );

        } catch (Exception e) {
            log.error("Exception in Leave Export", e);
        }

        return false;
    }

    private static final Log log = LogFactoryUtil.getLog(FetchPreviousMonthLeaveReportResourceCommand.class);

    @Reference
    private LeaveTypeMasterLocalService leaveTypeMasterLocalService;

    @Reference
    private EmployeeDetailsLocalService employeeDetailsLocalService;

    @Reference
    private LeaveRequestLocalService leaveRequestLocalService;

    @Reference
    private LeaveDayTypeLocalService leaveDayTypeLocalService;

}
