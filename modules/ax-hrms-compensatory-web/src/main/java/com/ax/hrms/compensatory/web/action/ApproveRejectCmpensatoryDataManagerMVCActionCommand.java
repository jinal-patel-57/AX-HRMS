package com.ax.hrms.compensatory.web.action;


import com.ax.hrms.common.api.api.AxHrmsCommonApi;
import com.ax.hrms.compensatory.web.constants.AxHrmsCompensatoryDataConstants;
import com.ax.hrms.compensatory.web.constants.AxHrmsCompensatoryWebPortletKeys;
import com.ax.hrms.master.model.LeaveTypeMaster;
import com.ax.hrms.master.service.*;
import com.ax.hrms.model.CompensatoryData;
import com.ax.hrms.model.EmployeeDetails;
import com.ax.hrms.model.LeaveBalance;
import com.ax.hrms.service.*;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.RoleLocalService;
import com.liferay.portal.kernel.service.UserLocalService;
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
import java.util.GregorianCalendar;


/**
 * Author: Nivid Koradiya
 */
@Component(
        property = {
                "javax.portlet.name=" + AxHrmsCompensatoryWebPortletKeys.AX_HRMS_COMPENSATORY_MANAGER_WEB_PORTLET,
                "mvc.command.name=/approveRejectCompensatoryData"
        },
        service = MVCActionCommand.class
)
public class ApproveRejectCmpensatoryDataManagerMVCActionCommand extends BaseMVCActionCommand {

    Log log = LogFactoryUtil.getLog(ApproveRejectCmpensatoryDataManagerMVCActionCommand.class);

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
        int approvedHours = ParamUtil.getInteger(actionRequest, AxHrmsCompensatoryDataConstants.APPROVED_HOURS);
        long compensatoryDataId = ParamUtil.getLong(actionRequest, AxHrmsCompensatoryDataConstants.COMPENSATORY_DATA_ID);
        ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
        if (approvedHours > 0) {

            CompensatoryData compensatoryData = compensatoryDataLocalService.getCompensatoryData(compensatoryDataId);
            compensatoryData.setApprovedHours(approvedHours);
            compensatoryData.setLeaveCompensatoryStatusMasterId(
                    leaveCompensatoryStatusMasterLocalService.findByLeaveCompensatoryStatusName(AxHrmsCompensatoryDataConstants.APPROVED)
                            .getLeaveCompensatoryStatusMasterId()
            );
            compensatoryDataLocalService.updateCompensatoryData(compensatoryData);

            LeaveTypeMaster leaveTypeMaster = leaveTypeMasterLocalService.findByLeaveTypeName(AxHrmsCompensatoryDataConstants.COMPENSATORY_OFF);
            try {
                LeaveBalance leaveBalance = leaveBalanceLocalService.findByEmployeeIdAndLeaveTypeMasterId(compensatoryData.getEmployeeId(), leaveTypeMaster.getLeaveTypeMasterId());
                double hoursToDays = (double) approvedHours /8;
                leaveBalance.setNoOfRemainingLeaves(leaveBalance.getNoOfRemainingLeaves() + hoursToDays);
                leaveBalanceLocalService.updateLeaveBalance(leaveBalance);
            } catch (Exception e) {
                //getting year
                Date date = new Date();
                Calendar calendar = new GregorianCalendar();
                calendar.setTime(date);
                int year = calendar.get(Calendar.YEAR);
                //year-end
                EmployeeDetails employeeDetails = employeeDetailsLocalService.getEmployeeDetails(compensatoryData.getEmployeeId());
                LeaveBalance lb = leaveBalanceLocalService.createLeaveBalance(CounterLocalServiceUtil.increment(LeaveBalance.class.getName()));
                lb.setCompanyId(themeDisplay.getCompanyId());
                lb.setCreatedBy(themeDisplay.getUserId());
                lb.setGroupId(themeDisplay.getCompanyGroupId());
                lb.setCreateDate(new Date());
                lb.setModifiedDate(new Date());

                lb.setEmployeeId(employeeDetails.getEmployeeId());
                lb.setEmployeeId(employeeDetails.getEmployeeId());
                lb.setLeaveTypeMasterId(leaveTypeMaster.getLeaveTypeMasterId());
                lb.setYear(year);
                lb.setNoOfUsedLeaves(0);
                lb.setNoOfRemainingLeaves(0);
                leaveBalanceLocalService.addLeaveBalance(lb);

                LeaveBalance leaveBalance = leaveBalanceLocalService.findByEmployeeIdAndLeaveTypeMasterId(compensatoryData.getEmployeeId(), leaveTypeMaster.getLeaveTypeMasterId());
                double hoursToDays = Math.round((float) approvedHours / 8);
                leaveBalance.setNoOfRemainingLeaves(leaveBalance.getNoOfRemainingLeaves() + hoursToDays);
                leaveBalanceLocalService.updateLeaveBalance(leaveBalance);
            }
            SessionMessages.add(actionRequest,"compensation-request-approved");

        } else {
            CompensatoryData compensatoryData = compensatoryDataLocalService.getCompensatoryData(compensatoryDataId);
            compensatoryData.setLeaveCompensatoryStatusMasterId(
                    leaveCompensatoryStatusMasterLocalService.findByLeaveCompensatoryStatusName(AxHrmsCompensatoryDataConstants.REJECTED)
                            .getLeaveCompensatoryStatusMasterId()
            );
            compensatoryDataLocalService.updateCompensatoryData(compensatoryData);
            SessionMessages.add(actionRequest,"compensation-request-rejected");

        }
    }
}



