package com.ax.hrms.birthday.web.scheduler;

import com.ax.hrms.anniversary.web.constants.AxHrmsAnniversaryWebPortletConstants;
import com.ax.hrms.anniversary.web.util.AnniversaryUtil;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.ax.hrms.birthday.web.util.BirthdayWebUtil;
import com.ax.hrms.common.api.api.AxHrmsCommonApi;
import com.ax.hrms.constants.AxHrmsBirthdayWebPortletConstants;
import com.ax.hrms.mail.template.config.configuration.MailTemplateConfiguration;
import com.ax.hrms.master.service.DepartmentMasterLocalService;
import com.ax.hrms.master.service.DesignationMasterLocalService;
import com.ax.hrms.master.service.LeavePolicyMasterLocalService;
import com.ax.hrms.master.service.LeaveTypeMasterLocalService;
import com.ax.hrms.master.service.WishTypeMasterLocalService;
import com.ax.hrms.notification.template.config.configuration.NotificationTemplateConfiguration;
import com.ax.hrms.service.EmployeeDepartmentLocalService;
import com.ax.hrms.service.EmployeeDesignationLocalService;
import com.ax.hrms.service.EmployeeDetailsLocalService;
import com.ax.hrms.service.EmployeeWishLocalService;
import com.ax.hrms.service.LeaveBalanceLocalService;
import com.liferay.dispatch.executor.BaseDispatchTaskExecutor;
import com.liferay.dispatch.executor.DispatchTaskExecutor;
import com.liferay.dispatch.executor.DispatchTaskExecutorOutput;
import com.liferay.dispatch.model.DispatchTrigger;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.service.GroupLocalServiceUtil;
import com.liferay.portal.kernel.service.UserNotificationEventLocalService;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.PrefsPropsUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.workflow.kaleo.definition.Notification;

@Component(property = { "dispatch.task.executor.name=" + AxHrmsBirthdayWebPortletConstants.BIRTHDAY_JOB_SCHEDULER,
		"dispatch.task.executor.type="
				+ AxHrmsBirthdayWebPortletConstants.BIRTHDAY_JOB_SCHEDULER }, service = DispatchTaskExecutor.class)
public class AxHrmsBirthdayJobScheduler extends BaseDispatchTaskExecutor {
	private static final Log log = LogFactoryUtil.getLog(AxHrmsBirthdayJobScheduler.class);

	@Reference
	private EmployeeDetailsLocalService employeeDetailsLocalService;
	@Reference
	private DepartmentMasterLocalService departmentMasterLocalService;

	@Reference
	private EmployeeDepartmentLocalService employeeDepartmentLocalService;

	@Reference
	private AxHrmsCommonApi axHrmsCommonApi;

	@Reference
	private EmployeeDesignationLocalService employeeDesignationLocalService;

	@Reference
	private DesignationMasterLocalService designationMasterLocalService;
	@Reference
	private UserNotificationEventLocalService userNotificationEventLocalService;

	@Reference
	private WishTypeMasterLocalService wishTypeMasterLocalService;

	@Reference
	private LeaveBalanceLocalService leaveBalanceLocalService;
	@Reference
	private LeavePolicyMasterLocalService leavePolicyMasterLocalService;
	@Reference
	private LeaveTypeMasterLocalService leaveTypeMasterLocalService;
	@Reference
	private EmployeeWishLocalService employeeWishLocalService;
	
	@Reference
	private MailTemplateConfiguration mailTemplateConfiguration;

	@Reference
	private NotificationTemplateConfiguration notificationTemplateConfiguration;
	@Override
	public String getName() {
		return AxHrmsBirthdayWebPortletConstants.BIRTHDAY_JOB_SCHEDULER;
	}

	@Override
	public void doExecute(DispatchTrigger dispatchTrigger, DispatchTaskExecutorOutput dispatchTaskExecutorOutput)
			throws Exception {
		Group group = GroupLocalServiceUtil.fetchGroup(PortalUtil.getDefaultCompanyId(), "Guest");
		String fromName = PrefsPropsUtil.getString(group.getCompanyId(), PropsKeys.ADMIN_EMAIL_FROM_NAME);
		String fromEmailAddress = PrefsPropsUtil.getString(group.getCompanyId(), PropsKeys.ADMIN_EMAIL_FROM_ADDRESS);

		try {
			sendMailAndNotificationToHrForBirthdayWishes(fromName, fromEmailAddress,group.getCompanyId());
			sendMailAndNotificationToHrForAnniversaryWishes(group, group.getGroupId(),
					group.getCreatorUserId(), group.getCompanyId());
		} catch (Exception e) {
			log.error("AxHrmsBirthdayJobScheduler >>> doExecute >>> " + e.getMessage());
		}
	}

	private void sendMailAndNotificationToHrForBirthdayWishes(String fromName, String fromEmailAddress,long companyId)
			throws Exception {
		StringBuilder body = new StringBuilder(AxHrmsBirthdayWebPortletConstants.HR_BIRTHDAY_REMMINDER_MAIL_HEAD);

		BirthdayWebUtil birthdayWebUtil = new BirthdayWebUtil(employeeDetailsLocalService,
				employeeDepartmentLocalService, employeeDesignationLocalService, departmentMasterLocalService,
				designationMasterLocalService, wishTypeMasterLocalService);

		birthdayWebUtil.sendMailAndNotificationToHr(fromName, fromEmailAddress, body,
				axHrmsCommonApi,companyId,mailTemplateConfiguration,notificationTemplateConfiguration);

	}

	private void sendMailAndNotificationToHrForAnniversaryWishes(Group group, long groupId,
			long userId, long companyId) throws Exception {
		StringBuilder body = new StringBuilder(AxHrmsAnniversaryWebPortletConstants.ANNIVERSARY_REMMINDER_MAIL_HEAD);

		AnniversaryUtil anniversaryEmployeeRetrieverUtil = new AnniversaryUtil(employeeDetailsLocalService,axHrmsCommonApi,leaveBalanceLocalService,leavePolicyMasterLocalService,leaveTypeMasterLocalService,designationMasterLocalService,departmentMasterLocalService);

		anniversaryEmployeeRetrieverUtil.sendMailAndNotificationToHr(group,body,employeeDepartmentLocalService,employeeDesignationLocalService,mailTemplateConfiguration,notificationTemplateConfiguration);
		anniversaryEmployeeRetrieverUtil.addLoyaltyLeave(anniversaryEmployeeRetrieverUtil.getAnniversaryEmployee(employeeDetailsLocalService.getEmployeeDetailses(-1,-1)),groupId,userId,companyId);
	}

}
