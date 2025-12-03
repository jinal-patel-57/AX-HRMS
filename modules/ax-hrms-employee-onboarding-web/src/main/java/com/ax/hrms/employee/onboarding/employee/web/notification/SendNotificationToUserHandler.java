package com.ax.hrms.employee.onboarding.employee.web.notification;

import com.ax.hrms.employee.onboarding.web.constants.AxHrmsEmployeeOnBoardingEmployeeConstants;
import com.ax.hrms.employee.onboarding.web.constants.AxHrmsEmployeeOnboardingWebPortletKeys;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.model.UserNotificationEvent;
import com.liferay.portal.kernel.notifications.BaseUserNotificationHandler;
import com.liferay.portal.kernel.notifications.UserNotificationHandler;
import com.liferay.portal.kernel.service.ServiceContext;

import org.osgi.service.component.annotations.Component;

@Component(service = UserNotificationHandler.class)

public class SendNotificationToUserHandler extends BaseUserNotificationHandler {
	public static final String PORTLET_ID = AxHrmsEmployeeOnboardingWebPortletKeys.AX_HRMS_EMPLOYEE_ONBOARDING_EMPLOYEE_WEB;

	public SendNotificationToUserHandler() {
		setPortletId(SendNotificationToUserHandler.PORTLET_ID);
	}

	@Override
	protected String getBody(UserNotificationEvent userNotificationEvent, ServiceContext serviceContext)
			throws Exception {

		JSONObject jsonObject = JSONFactoryUtil.createJSONObject(userNotificationEvent.getPayload());

		return jsonObject.getString(AxHrmsEmployeeOnBoardingEmployeeConstants.BODY);
	}
	
	public void callGetBody(UserNotificationEvent userNotificationEvent, ServiceContext serviceContext) throws Exception {
		getBody(userNotificationEvent, serviceContext);
	}
}