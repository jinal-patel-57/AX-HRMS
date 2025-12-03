package com.ax.hrms.birthday.web.notification;

import org.osgi.service.component.annotations.Component;

import com.ax.hrms.constants.AxHrmsBirthdayWebPortletConstants;
import com.ax.hrms.constants.AxHrmsBirthdayWebPortletKeys;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.model.UserNotificationEvent;
import com.liferay.portal.kernel.notifications.BaseUserNotificationHandler;
import com.liferay.portal.kernel.notifications.UserNotificationHandler;
import com.liferay.portal.kernel.service.ServiceContext;

@Component(service = UserNotificationHandler.class)

public class SendNotificationToUserHandler extends BaseUserNotificationHandler {
	public static final String PORTLET_ID = AxHrmsBirthdayWebPortletKeys.AXHRMSEMPLOYEEBIRTHDAYWEB;

	public SendNotificationToUserHandler() {
		setPortletId(SendNotificationToUserHandler.PORTLET_ID);
	}

	@Override
	protected String getBody(UserNotificationEvent userNotificationEvent, ServiceContext serviceContext)
			throws Exception {

		JSONObject jsonObject = JSONFactoryUtil.createJSONObject(userNotificationEvent.getPayload());

		return jsonObject.getString(AxHrmsBirthdayWebPortletConstants.BODY);
	}
	
	public void callGetBody(UserNotificationEvent userNotificationEvent, ServiceContext serviceContext) throws Exception {
		getBody(userNotificationEvent, serviceContext);
	}

}
