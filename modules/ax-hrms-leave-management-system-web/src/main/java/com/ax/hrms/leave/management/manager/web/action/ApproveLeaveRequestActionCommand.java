package com.ax.hrms.leave.management.manager.web.action;

import com.ax.hrms.leave.management.manager.web.util.AxHrmsManagerLeaveRequestWebUtil;
import com.ax.hrms.leave.management.web.constants.AxHrmsHrLeaveManagementSystemWebPortletConstants;
import com.ax.hrms.leave.management.web.constants.AxHrmsLeaveManagementSystemWebPortletKeys;
import com.ax.hrms.mail.template.config.configuration.MailTemplateConfiguration;
import com.ax.hrms.master.service.LeaveCompensatoryStatusMasterLocalService;
import com.ax.hrms.model.EmployeeDetails;
import com.ax.hrms.model.LeaveRequest;
import com.ax.hrms.notification.template.config.configuration.NotificationTemplateConfiguration;
import com.ax.hrms.service.EmployeeDetailsLocalService;
import com.ax.hrms.service.LeaveRequestLocalService;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PrefsPropsUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.WebKeys;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;

@Component(
        immediate = true,
        property = {
                "javax.portlet.name=" + AxHrmsLeaveManagementSystemWebPortletKeys.AXHRMS_MANAGER_LEAVE_MANAGEMENT_SYSTEM_WEB_PORTLET,
                "mvc.command.name=/leave/approve"
        },
        service = MVCActionCommand.class
)
public class ApproveLeaveRequestActionCommand implements MVCActionCommand {
    private static final Log log = LogFactoryUtil.getLog(ApproveLeaveRequestActionCommand.class);

    @Reference
    private LeaveRequestLocalService leaveRequestLocalService;

    @Reference
    EmployeeDetailsLocalService employeeDetailsLocalService;


    @Reference
    private LeaveCompensatoryStatusMasterLocalService leaveStatusLocalService;
    @Reference
    NotificationTemplateConfiguration notificationTemplateConfiguration;
    @Reference
    AxHrmsManagerLeaveRequestWebUtil axHrmsManagerLeaveRequestWebUtil;

    @Reference
    MailTemplateConfiguration mailTemplateConfiguration;
    @Override
    public boolean processAction(ActionRequest actionRequest, ActionResponse actionResponse)
            throws PortletException {


        ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
        String fromName = PrefsPropsUtil.getString(themeDisplay.getCompanyId(), PropsKeys.ADMIN_EMAIL_FROM_NAME);
        String fromEmailAddress = PrefsPropsUtil.getString(themeDisplay.getCompanyId(),
                PropsKeys.ADMIN_EMAIL_FROM_ADDRESS);
        try {
            long leaveRequestId = ParamUtil.getLong(actionRequest, "leaveRequestId");

            log.info(" leaveRequestId: " + leaveRequestId);
            long approvedStatusId = ParamUtil.getLong(actionRequest,
                    AxHrmsHrLeaveManagementSystemWebPortletConstants.APPROVED_ID);
            log.info(" leave request id : " + leaveRequestId);
            LeaveRequest leaveRequest = leaveRequestLocalService.findByleaveRequestId(leaveRequestId);
            EmployeeDetails employee = employeeDetailsLocalService.getEmployeeDetails(leaveRequest.getEmployeeId());

           log.info("Employee details: " + employee);


            leaveRequest.setLeaveCompensatoryStatusMasterId(approvedStatusId);
            leaveRequest.setHrApprovalId(employeeDetailsLocalService.findByLrUserId(themeDisplay.getUserId()).getEmployeeId());
            leaveRequest.setManagerApprovalId(employeeDetailsLocalService.findByLrUserId(themeDisplay.getUserId()).getEmployeeId());

            leaveRequestLocalService.updateLeaveRequest(leaveRequest);

            String employeeMailSubject =notificationTemplateConfiguration.leaveApprovedNotificationToEmployee();
            StringBuilder employeeMailBody = new StringBuilder(
                    AxHrmsHrLeaveManagementSystemWebPortletConstants.LEAVE_REQUEST_MAIL_HEAD);
            axHrmsManagerLeaveRequestWebUtil.sendMailtoEmployee(fromName, fromEmailAddress, leaveRequestId,
                    employeeMailBody,mailTemplateConfiguration,true,false);

            //SENDING MAIL TO THE TEAM
            String teamMailSubject = AxHrmsHrLeaveManagementSystemWebPortletConstants.YOUR_TEAM_MEMBER_IS_ON_LEAVE;
            StringBuilder teamMailBody = new StringBuilder(
                    AxHrmsHrLeaveManagementSystemWebPortletConstants.LEAVE_REQUEST_TEAM_MAIL_HEAD);
            axHrmsManagerLeaveRequestWebUtil.sendMailtoTeam(fromName, fromEmailAddress, leaveRequestId, teamMailBody,mailTemplateConfiguration);
            log.info("leave is sending shortly.......");
            axHrmsManagerLeaveRequestWebUtil.sendNotificationToTeam("approved is done",leaveRequestId);
            log.info(" leave request id : " + leaveRequestId);
            log.info("leave to team is done....");
            // SENDING NOTIFICATION TO EMPLOYEE
            axHrmsManagerLeaveRequestWebUtil.sendNotificationToEmployee(employeeMailSubject, employee);
            SessionMessages.add(actionRequest, AxHrmsHrLeaveManagementSystemWebPortletConstants.LEAVE_REQUEST_APPROVED);

             return true;



//            LeaveRequest leave = leaveRequestLocalService.fetchLeaveRequest(leaveId);
//
//            if (leave == null) {
//                SessionErrors.add(actionRequest, "leave-error");
//                return false;
//            }
//
//            // Fetch all statuses
//            java.util.List<LeaveCompensatoryStatusMaster> statusList =
//                    leaveStatusLocalService.getLeaveCompensatoryStatusMasters(-1, -1);
//
//            // Find Approved Status ID
//            long approvedId = 0L;
//            for (LeaveCompensatoryStatusMaster status : statusList) {
//                if ("Approved".equalsIgnoreCase(status.getLeaveCompensatoryStatus())) {
//                    approvedId = status.getLeaveCompensatoryStatusMasterId();
//                    break;
//                }
//            }
//
//            if (approvedId == 0) {
//                SessionErrors.add(actionRequest, "leave-error");
//                return false;
//            }
//
//            // Update the leave status
//            leave.setLeaveCompensatoryStatusMasterId(approvedId);
//            leaveRequestLocalService.updateLeaveRequest(leave);
//
//            // Send success message
//            SessionMessages.add(actionRequest, "leave-approved");

        } catch (Exception e) {
            e.printStackTrace();
            SessionErrors.add(actionRequest, "leave-error");
        }

        return true;
    }
}
