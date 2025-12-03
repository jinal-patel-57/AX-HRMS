package com.ax.hrms.anniversary.web.notification;

import com.ax.hrms.anniversary.web.constants.AxHrmsAnniversaryWebPortletConstants;
import com.ax.hrms.anniversary.web.constants.AxHrmsAnniversaryWebPortletKeys;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.model.UserNotificationEvent;
import com.liferay.portal.kernel.notifications.BaseUserNotificationHandler;
import com.liferay.portal.kernel.notifications.UserNotificationHandler;
import com.liferay.portal.kernel.service.ServiceContext;
import org.osgi.service.component.annotations.Component;

@Component(service = UserNotificationHandler.class)
public class SendNotificationToUserHandler extends BaseUserNotificationHandler {

    public static final String PORTLET_ID = AxHrmsAnniversaryWebPortletKeys.AXHRMSANNIVERSARYWEB;
    public SendNotificationToUserHandler() {
        setPortletId(com.ax.hrms.anniversary.web.notification.SendNotificationToUserHandler.PORTLET_ID);
    }

    @Override
    protected String getBody(UserNotificationEvent userNotificationEvent, ServiceContext serviceContext)
            throws Exception {

        JSONObject jsonObject = JSONFactoryUtil.createJSONObject(userNotificationEvent.getPayload());

        return jsonObject.getString(AxHrmsAnniversaryWebPortletConstants.BODY);
    }

    public void callGetBody(UserNotificationEvent userNotificationEvent, ServiceContext serviceContext) throws Exception {
        getBody(userNotificationEvent, serviceContext);
    }
}
