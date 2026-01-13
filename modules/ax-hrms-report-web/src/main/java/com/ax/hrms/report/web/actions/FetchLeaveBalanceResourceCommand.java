package com.ax.hrms.report.web.actions;

import com.ax.hrms.master.model.LeaveTypeMaster;
import com.ax.hrms.master.service.LeaveTypeMasterLocalService;
import com.ax.hrms.model.EmployeeDetails;
import com.ax.hrms.model.LeaveBalance;
import com.ax.hrms.report.web.constants.AkHrmsLeaveBalanceReportWebPortletKeys;
import com.ax.hrms.report.web.util.ExcelExportUtil;
import com.ax.hrms.service.EmployeeDetailsLocalService;
import com.ax.hrms.service.LeaveBalanceLocalService;
import com.liferay.petra.string.StringPool;
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
import java.util.*;


@Component(
        property = {
                "javax.portlet.name=" + AkHrmsLeaveBalanceReportWebPortletKeys.AKHRMSLEAVEBALANCEREPORTWEB,
                "mvc.command.name=/leave_balance/export"
        },
        service = MVCResourceCommand.class
)
public class FetchLeaveBalanceResourceCommand implements MVCResourceCommand {

    @Override
    public boolean serveResource(ResourceRequest request, ResourceResponse response) {

        try {
            String employeeType = ParamUtil.getString(request, "employeeType");
            int year = ParamUtil.getInteger(request, "year");

            List<LeaveTypeMaster> leaveTypes = leaveTypeMasterLocalService.getLeaveTypeMasters(QueryUtil.ALL_POS, QueryUtil.ALL_POS);

            Map<String, Map<String, Double>> leaveBalanceData = new LinkedHashMap<>();

            long[] employeeIds;
            if (AkHrmsLeaveBalanceReportWebPortletKeys.ALL.equalsIgnoreCase(employeeType)) {
                List<EmployeeDetails> allEmployees = employeeDetailsLocalService.findByIsTerminated(false);
                employeeIds = allEmployees.stream().mapToLong(EmployeeDetails::getEmployeeId).toArray();
            } else {
                employeeIds = ParamUtil.getLongValues(request, "employeeIds");
            }
            for (long employeeId : employeeIds) {

                EmployeeDetails employeeDetails = employeeDetailsLocalService.getEmployeeDetails(employeeId);

                JSONObject employeeDetailsJson = JSONFactoryUtil.createJSONObject();
                employeeDetailsJson.put(AkHrmsLeaveBalanceReportWebPortletKeys.EMPLOYEE_ID, employeeDetails.getEmployeeCode());
                employeeDetailsJson.put(AkHrmsLeaveBalanceReportWebPortletKeys.EMPLOYEE_NAME, employeeDetails.getFirstName() + StringPool.SPACE + employeeDetails.getLastName());
                employeeDetailsJson.put(AkHrmsLeaveBalanceReportWebPortletKeys.EMPLOYEE_EMAIL, employeeDetails.getOfficialEmail());

                Map<String, Double> leaveTypeBalanceMap = new LinkedHashMap<>();

                for (LeaveTypeMaster leaveType : leaveTypes) {

                    long leaveTypeMasterId = leaveType.getLeaveTypeMasterId();

                    LeaveBalance leaveBalance = null;

                    try {
                        leaveBalance = leaveBalanceLocalService.findByEmployeeIdLeaveTypeMasterIdAndYear(employeeId, leaveTypeMasterId, year);
                    } catch (Exception e) {
                        _log.warn("LeaveBalance not found for employeeId=" + employeeId +
                                ", leaveTypeId=" + leaveTypeMasterId);
                    }

                    double remainingLeaves = (leaveBalance != null) ? leaveBalance.getNoOfRemainingLeaves() : 0.0;

                    leaveTypeBalanceMap.put(leaveType.getLeaveTypeName(), remainingLeaves);
                }

                leaveBalanceData.put(employeeDetailsJson.toString(), leaveTypeBalanceMap);

            }

            ExcelExportUtil.exportLeaveBalance(leaveBalanceData, response, AkHrmsLeaveBalanceReportWebPortletKeys.LEAVE_BALANCE_EXPORT_FILE_NAME);

        } catch (Exception e) {
            _log.error("Exception occurred in LeaveBalanceExportResourceCommand", e);
        }

        return false;
    }

    private static final Log _log = LogFactoryUtil.getLog(FetchLeaveBalanceResourceCommand.class);

    @Reference
    private LeaveTypeMasterLocalService leaveTypeMasterLocalService;
    @Reference
    private LeaveBalanceLocalService leaveBalanceLocalService;
    @Reference
    private EmployeeDetailsLocalService employeeDetailsLocalService;
}
