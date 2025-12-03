package com.ax.hrms.leave.management.hr.web.action;

import java.time.LocalDate;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import com.ax.hrms.notification.template.config.configuration.NotificationTemplateConfiguration;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.ax.hrms.common.api.api.AxHrmsCommonApi;
import com.ax.hrms.leave.management.hr.web.util.AxHrmsHrLeaveRequestWebUtil;
import com.ax.hrms.leave.management.web.constants.AxHrmsHrLeaveManagementSystemWebPortletConstants;
import com.ax.hrms.leave.management.web.constants.AxHrmsLeaveManagementSystemWebPortletKeys;
import com.ax.hrms.mail.template.config.configuration.MailTemplateConfiguration;
import com.ax.hrms.master.model.LeaveCompensatoryStatusMaster;
import com.ax.hrms.master.service.DepartmentMasterLocalService;
import com.ax.hrms.master.service.DesignationMasterLocalService;
import com.ax.hrms.master.service.LeaveCompensatoryStatusMasterLocalService;
import com.ax.hrms.master.service.LeaveTypeMasterLocalService;
import com.ax.hrms.model.EmployeeDetails;
import com.ax.hrms.model.LeaveRequest;
import com.ax.hrms.service.EmployeeDepartmentLocalService;
import com.ax.hrms.service.EmployeeDesignationLocalService;
import com.ax.hrms.service.EmployeeDetailsLocalService;
import com.ax.hrms.service.LeaveBalanceLocalService;
import com.ax.hrms.service.LeaveDayTypeLocalService;
import com.ax.hrms.service.LeaveRequestLocalService;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PrefsPropsUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

/**
 * 
 * @author keval.kathiriya
 *
 */
@Component(immediate = true, property = {
		"javax.portlet.name=" + AxHrmsLeaveManagementSystemWebPortletKeys.AXHRMS_HR_LEAVE_MANAGEMENT_SYSTEM_WEB_PORTLET,
		"mvc.command.name="
				+ AxHrmsHrLeaveManagementSystemWebPortletConstants.REJECT_CANCEL_LEAVE_REQUEST }, service = MVCActionCommand.class)
public class RejectCancelLeaveRequestMVCActionCommand extends BaseMVCActionCommand {

	private static final Log log = LogFactoryUtil.getLog(RejectCancelLeaveRequestMVCActionCommand.class);

	@Reference
	LeaveTypeMasterLocalService leaveTypeMasterLocalService;

	@Reference
	NotificationTemplateConfiguration notificationTemplateConfiguration;

	@Reference
	LeaveRequestLocalService leaveRequestLocalService;

	@Reference
	LeaveCompensatoryStatusMasterLocalService leaveCompensatoryStatusMasterLocalService;

	@Reference
	LeaveBalanceLocalService leaveBalanceLocalService;

	@Reference
	LeaveDayTypeLocalService leaveDayTypeLocalService;

	@Reference
	AxHrmsCommonApi axHrmsCommonApi;

	@Reference
	EmployeeDetailsLocalService employeeDetailsLocalService;

	@Reference
	DepartmentMasterLocalService departmentMasterLocalService;

	@Reference
	DesignationMasterLocalService designationMasterLocalService;

	@Reference
	EmployeeDepartmentLocalService employeeDepartmentLocalService;

	@Reference
	EmployeeDesignationLocalService employeeDesignationLocalService;
	@Reference
	AxHrmsHrLeaveRequestWebUtil leaveRequestWebUtil;
	
	@Reference
	private MailTemplateConfiguration mailTemplateConfiguration;

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse)  {

		super.hideDefaultErrorMessage(actionRequest);
		super.hideDefaultSuccessMessage(actionRequest);

		try {

			Long leaveRequestId = ParamUtil.getLong(actionRequest,
					AxHrmsHrLeaveManagementSystemWebPortletConstants.LEAVE_REQUEST_ID);
			long cancelId = ParamUtil.getLong(actionRequest,
					AxHrmsHrLeaveManagementSystemWebPortletConstants.CANCELLED_ID);
			long rejectedId = ParamUtil.getLong(actionRequest,
					AxHrmsHrLeaveManagementSystemWebPortletConstants.REJECTED_ID);

			ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
			String fromName = PrefsPropsUtil.getString(themeDisplay.getCompanyId(), PropsKeys.ADMIN_EMAIL_FROM_NAME);
			String fromEmailAddress = PrefsPropsUtil.getString(themeDisplay.getCompanyId(),
					PropsKeys.ADMIN_EMAIL_FROM_ADDRESS);

			LeaveRequest leaveRequest = leaveRequestLocalService.findByleaveRequestId(leaveRequestId);
			EmployeeDetails employee = employeeDetailsLocalService.getEmployeeDetails(leaveRequest.getEmployeeId());

			long previousStatusId = leaveRequest.getLeaveCompensatoryStatusMasterId();
			boolean isCancelled;

			if (Validator.isNotNull(cancelId)) {
				isCancelled = true;
				leaveRequest.setLeaveCompensatoryStatusMasterId(cancelId);
				SessionMessages.add(actionRequest,
						AxHrmsHrLeaveManagementSystemWebPortletConstants.LEAVE_REQUEST_CANCELLED);

			} else {
				isCancelled = false;
				leaveRequest.setLeaveCompensatoryStatusMasterId(rejectedId);
				SessionMessages.add(actionRequest,
						AxHrmsHrLeaveManagementSystemWebPortletConstants.LEAVE_REQUEST_REJECTED);

			}
			leaveRequest.setHrApprovalId(employeeDetailsLocalService.findByLrUserId(themeDisplay.getUserId()).getEmployeeId());
			leaveRequest.setManagerApprovalId(employeeDetailsLocalService.findByLrUserId(themeDisplay.getUserId()).getEmployeeId());
			leaveRequestLocalService.updateLeaveRequest(leaveRequest);

			LeaveCompensatoryStatusMaster leaveStatusMasterOfRejected = leaveCompensatoryStatusMasterLocalService
					.findByLeaveCompensatoryStatusName(AxHrmsHrLeaveManagementSystemWebPortletConstants.REJECTED);

			if (previousStatusId != leaveStatusMasterOfRejected.getLeaveCompensatoryStatusMasterId()) {

				LocalDate currentDate = LocalDate.now();
				int currentYear = currentDate.getYear();
				long employeeId = leaveRequest.getEmployeeId();
				long leaveTypeMasterId = leaveRequest.getLeaveTypeMasterId();
				double totalDays = 0;

				// Counting Days on date wise .......

				totalDays = leaveRequestWebUtil.countLeaveDays(leaveRequestId, totalDays);
				
				// Update the Leave Balance

				leaveRequestWebUtil.updateLeaveBalance(currentYear, employeeId, leaveTypeMasterId, totalDays);

				// DECIDING SUBJECT  FOR CANCEL AND REJECT
				String subject;

				if (leaveRequest.getLeaveCompensatoryStatusMasterId() == leaveStatusMasterOfRejected
						.getLeaveCompensatoryStatusMasterId() ) {
					subject = notificationTemplateConfiguration.leaveRejectedNotificationToEmployee();
				} else {
					subject =notificationTemplateConfiguration.leaveCancelledNotificationToEmployee();

				}


				// SEND MAIL TO EMPLOYEE

				StringBuilder employeeMailBody = new StringBuilder(
						AxHrmsHrLeaveManagementSystemWebPortletConstants.LEAVE_REQUEST_MAIL_HEAD);
				leaveRequestWebUtil.sendMailtoEmployee(fromName, fromEmailAddress, leaveRequestId,
						employeeMailBody,mailTemplateConfiguration,false,isCancelled);

				// SEND NOTITIFCATION TO EMPLOYEE
				leaveRequestWebUtil.sendNotificationToEmployee(subject, employee);
				
				
				
			}
		} catch (Exception e) {
			log.error(" RejectCancelLeaveRequestMVCActionCommand >>> Action >>> " + e.getMessage());
			SessionErrors.add(actionRequest, AxHrmsHrLeaveManagementSystemWebPortletConstants.SOME_ERROR_FOUND);

		}
	}



}
