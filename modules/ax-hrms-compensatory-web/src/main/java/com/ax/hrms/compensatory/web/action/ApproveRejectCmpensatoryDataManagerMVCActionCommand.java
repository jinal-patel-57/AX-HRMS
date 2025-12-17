package com.ax.hrms.compensatory.web.action;


import com.ax.hrms.common.api.api.AxHrmsCommonApi;
import com.ax.hrms.compensatory.web.constants.AxHrmsCompensatoryDataConstants;
import com.ax.hrms.compensatory.web.constants.AxHrmsCompensatoryWebPortletKeys;
import com.ax.hrms.compensatory.web.util.AxHrmsCompensatoryLeaveRequestWebUtil;
import com.ax.hrms.mail.template.config.configuration.MailTemplateConfiguration;
import com.ax.hrms.master.model.LeaveTypeMaster;
import com.ax.hrms.master.service.*;
import com.ax.hrms.model.CompensatoryData;
import com.ax.hrms.model.EmployeeDetails;
import com.ax.hrms.model.LeaveBalance;
import com.ax.hrms.notification.template.config.configuration.NotificationTemplateConfiguration;
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
import com.liferay.portal.kernel.util.*;
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



    @Reference
    NotificationTemplateConfiguration notificationTemplateConfiguration;


    @Reference
    MailTemplateConfiguration mailTemplateConfiguration;

    @Reference
    AxHrmsCompensatoryLeaveRequestWebUtil axHrmsCompensatoryLeaveRequestWebUtil;


    @Override
    protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
        int approvedHours = ParamUtil.getInteger(actionRequest, AxHrmsCompensatoryDataConstants.APPROVED_HOURS);
        long compensatoryDataId = ParamUtil.getLong(actionRequest, AxHrmsCompensatoryDataConstants.COMPENSATORY_DATA_ID);
        ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
        String fromName = PrefsPropsUtil.getString(themeDisplay.getCompanyId(), PropsKeys.ADMIN_EMAIL_FROM_NAME);
        String fromEmailAddress = PrefsPropsUtil.getString(themeDisplay.getCompanyId(),
                PropsKeys.ADMIN_EMAIL_FROM_ADDRESS);
        log.info("Approval Hours :- "+ approvedHours);
        log.info("compensatoryDataId"+ compensatoryDataId);
        if (approvedHours > 0) {

            CompensatoryData compensatoryData = compensatoryDataLocalService.getCompensatoryData(compensatoryDataId);
            compensatoryData.setApprovedHours(approvedHours);
            compensatoryData.setLeaveCompensatoryStatusMasterId(
                    leaveCompensatoryStatusMasterLocalService.findByLeaveCompensatoryStatusName(AxHrmsCompensatoryDataConstants.APPROVED)
                            .getLeaveCompensatoryStatusMasterId()
            );
            compensatoryDataLocalService.updateCompensatoryData(compensatoryData);

            LeaveTypeMaster leaveTypeMaster = leaveTypeMasterLocalService.findByLeaveTypeName(AxHrmsCompensatoryDataConstants.COMPENSATORY_OFF);
            LeaveBalance leaveBalance;
            try {
                 leaveBalance = leaveBalanceLocalService.findByEmployeeIdAndLeaveTypeMasterId(compensatoryData.getEmployeeId(), leaveTypeMaster.getLeaveTypeMasterId());
                double hoursToDays = (double) approvedHours /8;
                leaveBalance.setNoOfRemainingLeaves(leaveBalance.getNoOfRemainingLeaves() + hoursToDays);
                leaveBalanceLocalService.updateLeaveBalance(leaveBalance);
                log.info("compensatory updated successfully..!!");
            } catch (Exception e) {
                //getting year
                Date date = new Date();
                Calendar calendar = new GregorianCalendar();
                calendar.setTime(date);
                int year = calendar.get(Calendar.YEAR);
                //year-end
                EmployeeDetails employeeDetails = employeeDetailsLocalService.getEmployeeDetails(compensatoryData.getEmployeeId());
                leaveBalance = leaveBalanceLocalService.createLeaveBalance(CounterLocalServiceUtil.increment(LeaveBalance.class.getName()));
                leaveBalance.setCompanyId(themeDisplay.getCompanyId());
                leaveBalance.setCreatedBy(themeDisplay.getUserId());
                leaveBalance.setGroupId(themeDisplay.getCompanyGroupId());
                leaveBalance.setCreateDate(new Date());
                leaveBalance.setModifiedDate(new Date());

                leaveBalance.setEmployeeId(employeeDetails.getEmployeeId());
                leaveBalance.setEmployeeId(employeeDetails.getEmployeeId());
                leaveBalance.setLeaveTypeMasterId(leaveTypeMaster.getLeaveTypeMasterId());
                leaveBalance.setYear(year);
                leaveBalance.setNoOfUsedLeaves(0);
                leaveBalance.setNoOfRemainingLeaves(0);
                leaveBalanceLocalService.addLeaveBalance(leaveBalance);

                leaveBalance = leaveBalanceLocalService.findByEmployeeIdAndLeaveTypeMasterId(compensatoryData.getEmployeeId(), leaveTypeMaster.getLeaveTypeMasterId());
                double hoursToDays = Math.round((float) approvedHours / 8);
                leaveBalance.setNoOfRemainingLeaves(leaveBalance.getNoOfRemainingLeaves() + hoursToDays);
                leaveBalanceLocalService.updateLeaveBalance(leaveBalance);
                log.info("Compensatory leave added successfully..!!!");


            }
            // Approved Notification and mail to the Employee
            EmployeeDetails employee = employeeDetailsLocalService.getEmployeeDetails(leaveBalance.getEmployeeId());


            String employeeMailSubject =notificationTemplateConfiguration.compensatoryLeaveRequestApprovedNotificationToEmployee();
            StringBuilder employeeMailBody = new StringBuilder(
                    AxHrmsCompensatoryDataConstants.COMPENSATORY_REQUEST_MAIL_HEAD);
            axHrmsCompensatoryLeaveRequestWebUtil.sendMailtoEmployee(fromName, fromEmailAddress, compensatoryData.getCompensatoryDataId(),
                    employeeMailBody,mailTemplateConfiguration,true,false);
            axHrmsCompensatoryLeaveRequestWebUtil.sendNotificationToEmployee(employeeMailSubject, employee);
            SessionMessages.add(actionRequest,"compensation-request-approved");





        } else {
            CompensatoryData compensatoryData = compensatoryDataLocalService.getCompensatoryData(compensatoryDataId);
            compensatoryData.setLeaveCompensatoryStatusMasterId(
                    leaveCompensatoryStatusMasterLocalService.findByLeaveCompensatoryStatusName(AxHrmsCompensatoryDataConstants.REJECTED)
                            .getLeaveCompensatoryStatusMasterId()
            );
            compensatoryDataLocalService.updateCompensatoryData(compensatoryData);

            // Rejected Notification and mail to the Employee
            EmployeeDetails employee = employeeDetailsLocalService.getEmployeeDetails(compensatoryData.getEmployeeId());


            String employeeMailSubject =notificationTemplateConfiguration.compensatoryLeaveRequestRejectedNotificationToEmployee();
            StringBuilder employeeMailBody = new StringBuilder(
                    AxHrmsCompensatoryDataConstants.COMPENSATORY_REQUEST_MAIL_HEAD);
            axHrmsCompensatoryLeaveRequestWebUtil.sendMailtoEmployee(fromName, fromEmailAddress, compensatoryData.getCompensatoryDataId(),
                    employeeMailBody,mailTemplateConfiguration,false,false);
            axHrmsCompensatoryLeaveRequestWebUtil.sendNotificationToEmployee(employeeMailSubject, employee);

            SessionMessages.add(actionRequest,"compensation-request-rejected");

        }
        actionResponse.sendRedirect(PortalUtil.getLayoutFullURL(themeDisplay));
    }
}



