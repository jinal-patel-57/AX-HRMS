package com.ax.hrms.hr.leave.management.web.action;

import com.ax.hrms.common.api.api.AxHrmsCommonApi;
import com.ax.hrms.hr.leave.management.web.constants.AxHrmsHrLeaveManagementWebPortletKeys;
import com.ax.hrms.master.service.*;
import com.ax.hrms.model.LeaveBalance;
import com.ax.hrms.service.*;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.RoleLocalService;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import java.util.Calendar;
import java.util.Date;

/**
 * Author: Nivid Koradiya
 */
@Component(property = {
        "javax.portlet.name=" + AxHrmsHrLeaveManagementWebPortletKeys.AXHRMSHRLEAVEMANAGEMENTWEB,
        "mvc.command.name=/updateLeaveBalance"
}, service = MVCActionCommand.class)
public class EditLeaveBalanceMVCActionCommand extends BaseMVCActionCommand {

    Log log = LogFactoryUtil.getLog(EditLeaveBalanceMVCActionCommand.class);

    @Reference
    UserLocalService userLocalService;

    @Reference
    AxHrmsCommonApi axHrmsCommonApi;

    @Reference
    RoleLocalService roleLocalService;

    @Reference
    EmployeeDetailsLocalService employeeDetailsLocalService;

    @Reference
    EmployeeSalaryLocalService employeeSalaryLocalService;

    @Reference
    LeaveTypeMasterLocalService leaveTypeMasterLocalService;

    @Reference
    LeavePolicyMasterLocalService leavePolicyMasterLocalService;

    @Reference
    LeaveBalanceLocalService leaveBalanceLocalService;

    @Reference
    EmployeeProbationDetailsLocalService employeeProbationDetailsLocalService;

    @Reference
    ProbationStatusMasterLocalService probationStatusMasterLocalService;

    @Reference
    DepartmentMasterLocalService departmentMasterLocalService;

    @Reference
    DesignationMasterLocalService designationMasterLocalService;

    @Reference
    EmployeeDepartmentLocalService employeeDepartmentLocalService;

    @Reference
    EmployeeDesignationLocalService employeeDesignationLocalService;

    @Reference
    CompensatoryDataLocalService compensatoryDataLocalService;

    @Reference
    LeaveCompensatoryStatusMasterLocalService leaveCompensatoryStatusMasterLocalService;

    @Override
    protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
        long employeeId = ParamUtil.getLong(actionRequest, "employeeId");
        long leaveTypeMasterId = ParamUtil.getLong(actionRequest, "leaveTypeMasterId");
        double leaveAmount = ParamUtil.getDouble(actionRequest, "leaveAmount");
        ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);

        try{
            LeaveBalance leaveBalance = leaveBalanceLocalService.findByEmployeeIdLeaveTypeMasterIdAndYear(employeeId,leaveTypeMasterId,year);
            leaveBalance.setNoOfRemainingLeaves(leaveAmount);
            leaveBalanceLocalService.updateLeaveBalance(leaveBalance);
        }catch (Exception e){
            LeaveBalance lb = leaveBalanceLocalService.createLeaveBalance(CounterLocalServiceUtil.increment(LeaveBalance.class.getName()));
            lb.setCompanyId(themeDisplay.getCompanyId());
            lb.setCreatedBy(themeDisplay.getUserId());
            lb.setGroupId(themeDisplay.getCompanyGroupId());
            lb.setCreateDate(new Date());
            lb.setModifiedDate(new Date());
            lb.setEmployeeId(employeeId);
            lb.setLeaveTypeMasterId(leaveTypeMasterId);
            lb.setYear(year);
            lb.setNoOfUsedLeaves(0);
            lb.setNoOfRemainingLeaves(leaveAmount);
            leaveBalanceLocalService.addLeaveBalance(lb);
        }
        SessionMessages.add(actionRequest,"leave-updated");

    }
}
