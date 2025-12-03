package com.ax.hrms.leave.management.web.notification;

import org.osgi.service.component.annotations.Component;

import com.ax.hrms.leave.management.web.constants.AxHrmsLeaveManagementSystemWebPortletKeys;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.model.UserNotificationEvent;
import com.liferay.portal.kernel.notifications.BaseUserNotificationHandler;
import com.liferay.portal.kernel.notifications.UserNotificationHandler;
import com.liferay.portal.kernel.service.ServiceContext;
@Component(
		
		
		service = UserNotificationHandler.class)

public class SendNotificationToUserHandler extends BaseUserNotificationHandler{
	
	public static final  String PORTLET_ID= AxHrmsLeaveManagementSystemWebPortletKeys.AXHRMS_HR_LEAVE_MANAGEMENT_SYSTEM_WEB_PORTLET;
	
	
	public SendNotificationToUserHandler( ) {
		setPortletId(PORTLET_ID);
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
