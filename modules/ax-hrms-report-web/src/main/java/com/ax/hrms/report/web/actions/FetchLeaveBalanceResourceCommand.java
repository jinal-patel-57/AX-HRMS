package com.ax.hrms.report.web.actions;

import com.ax.hrms.master.model.LeaveTypeMaster;
import com.ax.hrms.master.service.LeaveTypeMasterLocalService;
import com.ax.hrms.model.EmployeeDetails;
import com.ax.hrms.model.LeaveBalance;
import com.ax.hrms.model.LeaveBalanceHistory;
import static com.ax.hrms.report.web.constants.AkHrmsLeaveBalanceReportWebPortletKeys.*;
import com.ax.hrms.report.web.util.ExcelExportUtil;
import com.ax.hrms.service.EmployeeDetailsLocalService;
import com.ax.hrms.service.LeaveBalanceHistoryLocalService;
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

import java.time.Year;
import java.util.*;


@Component(
        property = {
                "javax.portlet.name=" + AKHRMSLEAVEBALANCEREPORTWEB,
                "mvc.command.name=/leave_balance/export"
        },
        service = MVCResourceCommand.class
)
public class FetchLeaveBalanceResourceCommand implements MVCResourceCommand {

    public static final String EMPLOYEE_IDS = "employeeIds";

	public static final String YEAR = "year";

	public static final String EMPLOYEE_TYPE = "employeeType";
	
	@Override
    public boolean serveResource(ResourceRequest request, ResourceResponse response) {

        try {
            String employeeType = ParamUtil.getString(request, EMPLOYEE_TYPE);
            int year = ParamUtil.getInteger(request, YEAR);
            log.info("year -- " + year);
            List<LeaveTypeMaster> leaveTypes = leaveTypeMasterLocalService.getLeaveTypeMasters(QueryUtil.ALL_POS, QueryUtil.ALL_POS);

            Map<String, Map<String, Double>> leaveBalanceData = new LinkedHashMap<>();

            long[] employeeIds;
            if (ALL.equalsIgnoreCase(employeeType)) {
                List<EmployeeDetails> allEmployees = employeeDetailsLocalService.findByIsTerminated(false);
                employeeIds = allEmployees.stream().mapToLong(EmployeeDetails::getEmployeeId).toArray();
            } else {
                employeeIds = ParamUtil.getLongValues(request, EMPLOYEE_IDS);
            }
            for (long employeeId : employeeIds) {

                EmployeeDetails employeeDetails = employeeDetailsLocalService.getEmployeeDetails(employeeId);

                JSONObject employeeDetailsJson = JSONFactoryUtil.createJSONObject();
                employeeDetailsJson.put(EMPLOYEE_ID, employeeDetails.getEmployeeCode());
                employeeDetailsJson.put(EMPLOYEE_NAME, employeeDetails.getFirstName() + StringPool.SPACE + employeeDetails.getLastName());
                employeeDetailsJson.put(EMPLOYEE_EMAIL, employeeDetails.getOfficialEmail());

                Map<String, Double> leaveTypeBalanceMap = new LinkedHashMap<>();

                for (LeaveTypeMaster leaveType : leaveTypes) {

                    long leaveTypeMasterId = leaveType.getLeaveTypeMasterId();
                    
                    log.info("cur year -- " + Year.now().getValue()); 
                    if(Year.now().getValue() == year) {
                    	LeaveBalance leaveBalance = null;
                    	try {
                    		leaveBalance = leaveBalanceLocalService.findByEmployeeIdLeaveTypeMasterIdAndYear(employeeId, leaveTypeMasterId, year);
                    	} catch (Exception e) {
                    		log.warn("LeaveBalance not found for employeeId=" + employeeId +
                    				", leaveTypeId=" + leaveTypeMasterId);
                    	}
                    	double remainingLeaves = (leaveBalance != null) ? leaveBalance.getNoOfRemainingLeaves() : 0.0;
                    	leaveTypeBalanceMap.put(leaveType.getLeaveTypeName(), remainingLeaves);
                    } else {
                    	LeaveBalanceHistory leaveBalanceHistory = null;
                    	try {
                    		leaveBalanceHistory = leaveBalanceHistoryLocalService.findByEmployeeIdLeaveTypeMasterIdAndYear(employeeId, leaveTypeMasterId, year);
                    	} catch (Exception e) {
                    		log.warn("LeaveBalance not found for employeeId=" + employeeId +
                    				", leaveTypeId=" + leaveTypeMasterId);
                    	}
                    	double remainingLeaves = (leaveBalanceHistory != null) ? leaveBalanceHistory.getNoOfRemainingLeaves() : 0.0;
                    	leaveTypeBalanceMap.put(leaveType.getLeaveTypeName(), remainingLeaves);
                    }
                }
                log.info("leaveTypeBalanceMap -- " + leaveTypeBalanceMap);
                leaveBalanceData.put(employeeDetailsJson.toString(), leaveTypeBalanceMap);
            }
            ExcelExportUtil.exportLeaveBalance(leaveBalanceData, response, LEAVE_BALANCE_EXPORT_FILE_NAME);
        } catch (Exception e) {
            log.error("Exception occurred in LeaveBalanceExportResourceCommand", e);
        }

        return false;
    }

    private static final Log log = LogFactoryUtil.getLog(FetchLeaveBalanceResourceCommand.class);

    @Reference
    private LeaveTypeMasterLocalService leaveTypeMasterLocalService;
    @Reference
    private LeaveBalanceHistoryLocalService leaveBalanceHistoryLocalService;
    @Reference
    private LeaveBalanceLocalService leaveBalanceLocalService;
    @Reference
    private EmployeeDetailsLocalService employeeDetailsLocalService;
}
