package com.ax.hrms.scheduler.portlet.notification;

import com.ax.hrms.scheduler.constants.AxHrmsSchedulerPortletKeys;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.model.UserNotificationEvent;
import com.liferay.portal.kernel.notifications.BaseUserNotificationHandler;
import com.liferay.portal.kernel.notifications.UserNotificationHandler;
import com.liferay.portal.kernel.service.ServiceContext;
import org.osgi.service.component.annotations.Component;

@Component(service = UserNotificationHandler.class)

public class SendNotificationToUserHandler extends BaseUserNotificationHandler {
	public static final String PORTLET_ID = AxHrmsSchedulerPortletKeys.AXHRMSSCHEDULER;

	public SendNotificationToUserHandler() {
		setPortletId(SendNotificationToUserHandler.PORTLET_ID);
	}

	@Override
	protected String getBody(UserNotificationEvent userNotificationEvent, ServiceContext serviceContext)
			throws Exception {

		JSONObject jsonObject = JSONFactoryUtil.createJSONObject(userNotificationEvent.getPayload());

		return jsonObject.getString("body");
	}
	
	public void callGetBody(UserNotificationEvent userNotificationEvent, ServiceContext serviceContext) throws Exception {
		getBody(userNotificationEvent, serviceContext);
	}

}
