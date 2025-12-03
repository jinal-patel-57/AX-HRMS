package com.ax.hrms.notification.template.config.configuration;

import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;

import java.util.Map;

@Component(
        configurationPid = "com.ax.hrms.notification.template.config.configuration.NotificationTemplateConfiguration",
        immediate = true,
        service = NotificationTemplateConfiguration.class
)
public class NotificationTemplateConfigurationImpl implements NotificationTemplateConfiguration {



	@Override
	public String notificationAnniversary() {
		// TODO Auto-generated method stub
		return _configuration.notificationAnniversary();
	}

	@Override
	public String notificationBirthday() {
		// TODO Auto-generated method stub
		return _configuration.notificationBirthday();
	}


	@Override
	public String notificationAddProjectManager() {
		// TODO Auto-generated method stub
		return _configuration.notificationAddProjectManager();
	}

	@Override
	public String notificationAddTaskManager() {
		
		// TODO Auto-generated method stub
		return _configuration.notificationAddTaskManager();
	}

	@Override
	public String notificationProjectAssignedEmployee() {
		// TODO Auto-generated method stub
		return _configuration.notificationProjectAssignedEmployee();
	}

	

	@Override
	public String notificationReview() {
		// TODO Auto-generated method stub
		return _configuration.notificationReview();
	}
	public String appraisalReminderToHrNotification() {
		return _configuration.appraisalReminderToHrNotification();
	}

	@Override
	public String leaveApprovedNotificationToEmployee() {
		return _configuration.leaveApprovedNotificationToEmployee();
	}

	@Override
	public String leaveRejectedNotificationToEmployee() {
		return _configuration.leaveRejectedNotificationToEmployee();
	}

	@Override
	public String leaveCancelledNotificationToEmployee() {
		return _configuration.leaveCancelledNotificationToEmployee();
	}

	@Override
	public String notificationApproveLogTime() {
		// TODO Auto-generated method stub
		return _configuration.notificationApproveLogTime();
	}

	
	// below code need not be changed (strictly)
	@Activate
	@Modified
	protected void activate(Map<String, Object> properties) {
		_configuration = ConfigurableUtil.createConfigurable(
				NotificationTemplateConfiguration.class, properties);
	}

	private volatile NotificationTemplateConfiguration _configuration;

	@Override
	public String notificationUpdateProjectManager() {
		// TODO Auto-generated method stub
		return _configuration.notificationUpdateProjectManager();
	}

	@Override
	public String notificationProjectRemovedEmployee() {
		// TODO Auto-generated method stub
		return _configuration.notificationProjectRemovedEmployee();
	}

	@Override
	public String notificationUpdateTaskManager() {
		// TODO Auto-generated method stub
		return _configuration.notificationUpdateTaskManager();
	}

	@Override
	public String notificationTaskAssignedEmployee() {
		// TODO Auto-generated method stub
		return _configuration.notificationTaskAssignedEmployee();
	}

	@Override
	public String notificationTaskRemoveEmployee() {
		// TODO Auto-generated method stub
		return _configuration.notificationTaskRemoveEmployee();
	}

	@Override
	public String notificationRejectLogTime() {
		// TODO Auto-generated method stub
		return _configuration.notificationRejectLogTime();
	}

}
