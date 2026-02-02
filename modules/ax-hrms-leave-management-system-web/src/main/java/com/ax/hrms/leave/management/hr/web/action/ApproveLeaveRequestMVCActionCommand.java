package com.ax.hrms.leave.management.hr.web.action;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import com.ax.hrms.notification.template.config.configuration.NotificationTemplateConfiguration;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.util.*;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.ax.hrms.common.api.api.AxHrmsCommonApi;
import com.ax.hrms.leave.management.hr.web.util.AxHrmsHrLeaveRequestWebUtil;
import com.ax.hrms.leave.management.web.constants.AxHrmsHrLeaveManagementSystemWebPortletConstants;
import com.ax.hrms.leave.management.web.constants.AxHrmsLeaveManagementSystemWebPortletKeys;
import com.ax.hrms.mail.template.config.configuration.MailTemplateConfiguration;
import com.ax.hrms.master.service.DepartmentMasterLocalService;
import com.ax.hrms.master.service.DesignationMasterLocalService;
import com.ax.hrms.master.service.LeaveCompensatoryStatusMasterLocalService;
import com.ax.hrms.model.EmployeeDetails;
import com.ax.hrms.model.LeaveRequest;
import com.ax.hrms.service.CommentLocalService;
import com.ax.hrms.service.EmployeeDepartmentLocalService;
import com.ax.hrms.service.EmployeeDesignationLocalService;
import com.ax.hrms.service.EmployeeDetailsLocalService;
import com.ax.hrms.service.LeaveInformToTeamDetailLocalService;
import com.ax.hrms.service.LeaveRequestLocalService;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;

import java.io.IOException;

/**
 * 
 * @author keval.kathiriya
 *
 */
@Component(immediate = true, property = {
		"javax.portlet.name=" + AxHrmsLeaveManagementSystemWebPortletKeys.AXHRMS_HR_LEAVE_MANAGEMENT_SYSTEM_WEB_PORTLET,
		"mvc.command.name="
				+ AxHrmsHrLeaveManagementSystemWebPortletConstants.APPROVED_LEAVE_REQUEST }, service = MVCActionCommand.class)

public class ApproveLeaveRequestMVCActionCommand extends BaseMVCActionCommand {
	private static final Log log = LogFactoryUtil.getLog(ApproveLeaveRequestMVCActionCommand.class);

	

	@Reference
	LeaveRequestLocalService leaveRequestLocalService;
	
	@Reference
	CommentLocalService commentLocalService;
	
	@Reference
	AxHrmsCommonApi axHrmsCommonApi;

	@Reference
	EmployeeDetailsLocalService employeeDetailsLocalService;

	@Reference
	DepartmentMasterLocalService departmentMasterLocalService;

	@Reference
	DesignationMasterLocalService designationMasterLocalService;

	@Reference
	NotificationTemplateConfiguration notificationTemplateConfiguration;

	@Reference
	EmployeeDepartmentLocalService employeeDepartmentLocalService;

	@Reference
	EmployeeDesignationLocalService employeeDesignationLocalService;

	@Reference
	LeaveCompensatoryStatusMasterLocalService leaveCompensatoryStatusMasterLocalService;

	@Reference
	LeaveInformToTeamDetailLocalService leaveInformToTeamDetailLocalService;
	@Reference
	AxHrmsHrLeaveRequestWebUtil leaveRequestWebUtil;
	
	@Reference
	MailTemplateConfiguration mailTemplateConfiguration;

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws PortalException, IOException {
		super.hideDefaultErrorMessage(actionRequest);
		super.hideDefaultSuccessMessage(actionRequest);

		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		String fromName = PrefsPropsUtil.getString(themeDisplay.getCompanyId(), PropsKeys.ADMIN_EMAIL_FROM_NAME);
		String fromEmailAddress = PrefsPropsUtil.getString(themeDisplay.getCompanyId(),
				PropsKeys.ADMIN_EMAIL_FROM_ADDRESS);
		String comment = ParamUtil.getString(actionRequest, "comment");

		try {
			

			Long leaveRequestId = ParamUtil.getLong(actionRequest,
					AxHrmsHrLeaveManagementSystemWebPortletConstants.LEAVE_REQUEST_ID);
			long approvedStatusId = ParamUtil.getLong(actionRequest,
					AxHrmsHrLeaveManagementSystemWebPortletConstants.APPROVED_ID);

			LeaveRequest leaveRequest = leaveRequestLocalService.findByleaveRequestId(leaveRequestId);
            EmployeeDetails employee = employeeDetailsLocalService.getEmployeeDetails(leaveRequest.getEmployeeId());

			leaveRequest.setLeaveCompensatoryStatusMasterId(approvedStatusId);
			leaveRequest.setHrApprovalId(employeeDetailsLocalService.findByLrUserId(themeDisplay.getUserId()).getEmployeeId());
			leaveRequest.setManagerApprovalId(employeeDetailsLocalService.findByLrUserId(themeDisplay.getUserId()).getEmployeeId());
			leaveRequest.setModifiedBy(themeDisplay.getUserId());

			leaveRequestLocalService.updateLeaveRequest(leaveRequest);

			// SENDING MAIL TO EMPLOYEE 
			String employeeMail =notificationTemplateConfiguration.leaveApprovedNotificationToEmployee();
			employeeMail = employeeMail.replace("${COMMENT}", comment);
			StringBuilder employeeMailBody = new StringBuilder(
					AxHrmsHrLeaveManagementSystemWebPortletConstants.LEAVE_REQUEST_MAIL_HEAD);
			leaveRequestWebUtil.sendMailtoEmployee(fromName, fromEmailAddress, leaveRequestId,
					employeeMailBody,mailTemplateConfiguration,true,false);

			//SENDING MAIL TO THE TEAM
			String teamMailSubject = AxHrmsHrLeaveManagementSystemWebPortletConstants.YOUR_TEAM_MEMBER_IS_ON_LEAVE;
            log.info("mail is starti g sending to the team");

            StringBuilder teamMailBody = new StringBuilder(
                    AxHrmsHrLeaveManagementSystemWebPortletConstants.LEAVE_REQUEST_TEAM_MAIL_HEAD);
			leaveRequestWebUtil.sendMailtoTeam(fromName, fromEmailAddress, leaveRequestId, teamMailBody,mailTemplateConfiguration);
            leaveRequestWebUtil.sendNotificationToTeam("approve is done by hr.",leaveRequestId);
			// SENDING NOTIFICATION TO EMPLOYEE			
			leaveRequestWebUtil.sendNotificationToEmployee(employeeMail, employee);
			SessionMessages.add(actionRequest, AxHrmsHrLeaveManagementSystemWebPortletConstants.LEAVE_REQUEST_APPROVED);
			
			//Add comment code
			commentLocalService.addWorkflowComment(themeDisplay, 1l, "Approved", leaveRequestId, comment);

		} catch (Exception e) {
			log.error("ApproveLeaveRequestMVCRenderActionCommand >>> Action >>> Error in this method !!!!! "
					+ e.getMessage());
			SessionErrors.add(actionRequest, AxHrmsHrLeaveManagementSystemWebPortletConstants.SOME_ERROR_FOUND);
		}
		actionResponse.sendRedirect(PortalUtil.getLayoutFullURL(themeDisplay));

	}

}
