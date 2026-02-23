package com.ax.hrms.compensatory.web.action;

import com.ax.hrms.common.api.api.AxHrmsCommonApi;
import com.ax.hrms.compensatory.web.constants.AxHrmsCompensatoryDataConstants;
import com.ax.hrms.compensatory.web.constants.AxHrmsCompensatoryWebPortletKeys;
import com.ax.hrms.compensatory.web.util.AxHrmsCompensatoryLeaveRequestWebUtil;
import com.ax.hrms.mail.template.config.configuration.MailTemplateConfiguration;
import com.ax.hrms.master.service.*;
import com.ax.hrms.model.CompensatoryData;
import com.ax.hrms.model.EmployeeDetails;
import com.ax.hrms.notification.template.config.configuration.NotificationTemplateConfiguration;
import com.ax.hrms.service.*;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
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
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Author: Nivid Koradiya
 */
@Component(immediate = true, property = {
        "javax.portlet.name=" + AxHrmsCompensatoryWebPortletKeys.AX_HRMS_COMPENSATORY_EMPLOYEE_WEB_PORTLET,
        "mvc.command.name=/addCompensatoryData"
}, service = MVCActionCommand.class)
public class AddCompensatoryDataEmployeeMVCActionCommand extends BaseMVCActionCommand {

    Log log = LogFactoryUtil.getLog(AddCompensatoryDataEmployeeMVCActionCommand.class);

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
        SimpleDateFormat sdf = new SimpleDateFormat(AxHrmsCompensatoryDataConstants.DATE_FORMATER);
        Date compensationDate = ParamUtil.getDate(actionRequest,
                AxHrmsCompensatoryDataConstants.COMPENSATION_DATE, sdf);
        String compensationType = ParamUtil.getString(
                actionRequest,
                "compensationType"
        );
        log.info("compensationType :: "+compensationType);
        int compensationHours = 0;
        if ("HALF".equalsIgnoreCase(compensationType)) {
            compensationHours = 4;
        } else if ("FULL".equalsIgnoreCase(compensationType)) {
            compensationHours = 8;
        }

        log.info("compensationHours :: "+compensationHours);

        long projectManager = ParamUtil.getLong(actionRequest, AxHrmsCompensatoryDataConstants.PROJECT_MANAGER);
        String description = ParamUtil.getString(actionRequest, AxHrmsCompensatoryDataConstants.DESCRIPTION);
        ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
        String fromName = PrefsPropsUtil.getString(themeDisplay.getCompanyId(), PropsKeys.ADMIN_EMAIL_FROM_NAME);
        String fromEmailAddress = PrefsPropsUtil.getString(themeDisplay.getCompanyId(),
                PropsKeys.ADMIN_EMAIL_FROM_ADDRESS);

        boolean hrManagerStatus = ParamUtil.getBoolean(actionRequest, "hrManagerStatus");

        CompensatoryData compensatoryData = compensatoryDataLocalService.createCompensatoryData(
                CounterLocalServiceUtil.increment(CompensatoryData.class.getName()));
        compensatoryData.setDateOfCompensation(compensationDate);
        compensatoryData.setApprovedHours(0);
        if (hrManagerStatus) {
            String employeeNames = ParamUtil.getString(actionRequest, "employeeNames");
            compensatoryData.setEmployeeId(Long.parseLong(employeeNames));

        } else {
            compensatoryData.setEmployeeId(
                    employeeDetailsLocalService.findByLrUserId(themeDisplay.getUserId()).getEmployeeId());
        }
        compensatoryData.setRequestedHours(compensationHours);
        compensatoryData.setManagerId(projectManager);
        compensatoryData.setDescription(description);
        compensatoryData.setLeaveCompensatoryStatusMasterId(
                leaveCompensatoryStatusMasterLocalService
                        .findByLeaveCompensatoryStatusName(
                                AxHrmsCompensatoryDataConstants.PENDING)
                        .getLeaveCompensatoryStatusMasterId());

        compensatoryData.setCompanyId(themeDisplay.getCompanyId());
        compensatoryData.setCreatedBy(themeDisplay.getUserId());
        compensatoryData.setGroupId(themeDisplay.getCompanyGroupId());
        compensatoryData.setCreateDate(new Date());
        compensatoryData.setModifiedDate(new Date());
        compensatoryData.setModifiedBy(themeDisplay.getUserId());
        CompensatoryData compensatoryData1 = compensatoryDataLocalService.addCompensatoryData(compensatoryData);


        // Request Notification and mail to the HR and Manager
        try {
            EmployeeDetails manager = employeeDetailsLocalService.getEmployeeDetails(compensatoryData.getManagerId());

            List<User> userList = axHrmsCommonApi.fetchRolePersonList(themeDisplay.getCompanyId(), AxHrmsCompensatoryDataConstants.HR_ADMIN, -1, -1);
            userList.add(userLocalService.getUser(manager.getLrUserId()));
            String employeeMailSubject = notificationTemplateConfiguration.compensatoryLeaveRequestNotificationToManagerAndHr();
            StringBuilder employeeMailBody = new StringBuilder(
                    AxHrmsCompensatoryDataConstants.COMPENSATORY_REQUEST_MAIL_HEAD);
            axHrmsCompensatoryLeaveRequestWebUtil.sendMailtoManagerAndHr(fromName, fromEmailAddress, compensatoryData1.getCompensatoryDataId(),
                    employeeMailBody, mailTemplateConfiguration, themeDisplay, userList);


            axHrmsCompensatoryLeaveRequestWebUtil.sendNotificationToManagerAndHr(employeeMailSubject, userList);
        } catch (Exception e) {
            e.printStackTrace();
        }

        SessionMessages.add(actionRequest, "compensation-request-submitted");
        actionResponse.sendRedirect(PortalUtil.getLayoutFullURL(themeDisplay));
    }

}
