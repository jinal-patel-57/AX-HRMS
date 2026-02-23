package com.ax.hrms.compensatory.web.action;

import com.ax.hrms.common.api.api.AxHrmsCommonApi;
import com.ax.hrms.compensatory.web.constants.AxHrmsCompensatoryDataConstants;
import com.ax.hrms.compensatory.web.constants.AxHrmsCompensatoryWebPortletKeys;
import com.ax.hrms.compensatory.web.util.AxHrmsCompensatoryLeaveRequestWebUtil;
import com.ax.hrms.exception.NoSuchLeaveBalanceException;
import com.ax.hrms.mail.template.config.configuration.MailTemplateConfiguration;
import com.ax.hrms.master.exception.NoSuchLeaveCompensatoryStatusMasterException;
import com.ax.hrms.master.exception.NoSuchLeaveTypeMasterException;
import com.ax.hrms.master.model.LeaveTypeMaster;
import com.ax.hrms.master.service.*;
import com.ax.hrms.model.CompensatoryData;
import com.ax.hrms.model.EmployeeDetails;
import com.ax.hrms.model.LeaveBalance;
import com.ax.hrms.notification.template.config.configuration.NotificationTemplateConfiguration;
import com.ax.hrms.service.*;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.RoleLocalService;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.*;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import java.math.BigDecimal;
import java.math.BigInteger;

    @Component(property = {"javax.portlet.name=" + AxHrmsCompensatoryWebPortletKeys.AX_HRMS_COMPENSATORY_MANAGER_WEB_PORTLET, "mvc.command.name=/cancelCompensatoryData"}, service = MVCActionCommand.class)
public class CancelCompensatoryDataManagerMVCActionCommand extends BaseMVCActionCommand {
    Log log = LogFactoryUtil.getLog(CancelCompensatoryDataManagerMVCActionCommand.class);

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
    CommentLocalService commentLocalService;

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

        long compensatoryDataId = ParamUtil.getLong(actionRequest, AxHrmsCompensatoryDataConstants.COMPENSATORY_DATA_ID);
        log.info("compensatoryDataId :: " + compensatoryDataId);
        ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
        String fromName = PrefsPropsUtil.getString(themeDisplay.getCompanyId(), PropsKeys.ADMIN_EMAIL_FROM_NAME);
        String fromEmailAddress = PrefsPropsUtil.getString(themeDisplay.getCompanyId(), PropsKeys.ADMIN_EMAIL_FROM_ADDRESS);
        String comment = ParamUtil.getString(actionRequest, "comment");
        log.info("comment is the ::"+comment);
        CompensatoryData compensatoryData = null;
        long approvedStatusId = 0;
        long cancelledStatusId = 0;


        try {
            compensatoryData = compensatoryDataLocalService.getCompensatoryData(compensatoryDataId);
            if (compensatoryData == null) {
                log.error("CompensatoryData not found for ID : " + compensatoryDataId);
                return;
            }
        } catch (PortalException portalException) {
            log.error("Exception Raised Due to :: " + portalException.getMessage());
        }
        try {
            approvedStatusId =
                    leaveCompensatoryStatusMasterLocalService
                            .findByLeaveCompensatoryStatusName(
                                    AxHrmsCompensatoryDataConstants.APPROVED)
                            .getLeaveCompensatoryStatusMasterId();

        } catch (NoSuchLeaveCompensatoryStatusMasterException noSuchLeaveCompensatoryStatusMasterException) {
            log.error("Exception Raised Due to :: " + noSuchLeaveCompensatoryStatusMasterException.getMessage());
        }

        try {
            cancelledStatusId =
                    leaveCompensatoryStatusMasterLocalService
                            .findByLeaveCompensatoryStatusName(
                                    AxHrmsCompensatoryDataConstants.CANCELLED)
                            .getLeaveCompensatoryStatusMasterId();
        } catch (NoSuchLeaveCompensatoryStatusMasterException e) {
            log.error("CANCELLED status not found", e);
        }

        if (approvedStatusId > 0 && compensatoryData.getLeaveCompensatoryStatusMasterId() == approvedStatusId) {

            try {
                LeaveTypeMaster leaveTypeMaster =
                        leaveTypeMasterLocalService.findByLeaveTypeName(
                                AxHrmsCompensatoryDataConstants.COMPENSATORY_OFF);
                LeaveBalance leaveBalance =
                        leaveBalanceLocalService.findByEmployeeIdAndLeaveTypeMasterId(
                                compensatoryData.getEmployeeId(),
                                leaveTypeMaster.getLeaveTypeMasterId());
                // revert credited leave
                double hoursToDays = (double) compensatoryData.getApprovedHours() / 8;
                double roundedDays = roundToNearestQuarter(hoursToDays);

                leaveBalance.setNoOfRemainingLeaves(
                        leaveBalance.getNoOfRemainingLeaves() - roundedDays);

                leaveBalanceLocalService.updateLeaveBalance(leaveBalance);

                log.info("Reverted compensatory leave : " + roundedDays);
                compensatoryData.setApprovedHours(0);
            } catch (NoSuchLeaveTypeMasterException | NoSuchLeaveBalanceException exception) {
                log.error("Exception Raised Due to :: " + exception.getMessage());
            } catch (Exception exception) {
                log.error("Unexpected error during leave revert" + exception.getMessage());
            }
        }

        // Update status to CANCELLED
        try {
            if (cancelledStatusId > 0) {
                log.info("cancelledStatusId :: "+cancelledStatusId);
                compensatoryData.setLeaveCompensatoryStatusMasterId(cancelledStatusId);
                compensatoryData.setModifiedBy(themeDisplay.getUserId());
                commentLocalService.addWorkflowComment(themeDisplay, 3l, "Cancel", compensatoryDataId, comment);
//                log.info("compensatoryData.getLeaveCompensatoryStatusMasterId() :: "+compensatoryData.getLeaveCompensatoryStatusMasterId());
                compensatoryDataLocalService.updateCompensatoryData(compensatoryData);
                log.info("Compensatory request cancelled successfully");
            }
        } catch (Exception exception) {
            log.info("Exception Raised Due to :: " + exception.getMessage());
        }

        // Notification & Mail
        try {
            EmployeeDetails employee =
                    employeeDetailsLocalService.getEmployeeDetails(
                            compensatoryData.getEmployeeId());
            axHrmsCompensatoryLeaveRequestWebUtil.sendNotificationToEmployee("Cancelled", employee);
        } catch (PortalException portalException) {
            log.error("Exception Raised Due to :: " + portalException.getMessage());
        }

        StringBuilder mailBody =
                new StringBuilder(AxHrmsCompensatoryDataConstants.COMPENSATORY_REQUEST_MAIL_HEAD);


        axHrmsCompensatoryLeaveRequestWebUtil.sendMailtoEmployee(
                fromName,
                fromEmailAddress,
                compensatoryData.getCompensatoryDataId(),
                mailBody,
                mailTemplateConfiguration,comment,
                false,
                true);
        EmployeeDetails employee = employeeDetailsLocalService.getEmployeeDetails(compensatoryData.getEmployeeId());
        String employeeMailSubject =notificationTemplateConfiguration.compensatoryLeaveRequestCancelledNotificationToEmployee();

        axHrmsCompensatoryLeaveRequestWebUtil.sendNotificationToEmployee(employeeMailSubject, employee);

        StringBuilder approverMailBody =
                new StringBuilder(AxHrmsCompensatoryDataConstants.COMPENSATORY_REQUEST_MAIL_HEAD);

        String approverMailSubject =notificationTemplateConfiguration.compensatoryLeaveRequestCancelledNotificationToApprover();

        axHrmsCompensatoryLeaveRequestWebUtil.sendNotificationToApprover(approverMailSubject, employee,compensatoryData.getModifiedBy());

        axHrmsCompensatoryLeaveRequestWebUtil.sendMailtoApprovePerson(
                fromName,
                fromEmailAddress,
                compensatoryData.getCompensatoryDataId(),
                compensatoryData.getModifiedBy(),
                approverMailBody,
                mailTemplateConfiguration,
                comment,
                false,
                true);
        actionResponse.sendRedirect(PortalUtil.getLayoutFullURL(themeDisplay));

    }

    private double roundToNearestQuarter(double value) {

        int wholePart = (int) value;          // e.g. 1 from 1.30
        double decimalPart = value - wholePart;

        double roundedDecimal;

        if (decimalPart < 0.25) {
            roundedDecimal = 0.0;
        } else if (decimalPart < 0.50) {
            roundedDecimal = 0.25;
        } else if (decimalPart < 0.75) {
            roundedDecimal = 0.50;
        } else {
            roundedDecimal = 0.75;
        }

        return wholePart + roundedDecimal;
    }


}
