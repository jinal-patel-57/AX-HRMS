package com.ax.hrms.leave.management.web.portlet;

import javax.portlet.Portlet;

import org.osgi.service.component.annotations.Component;

import com.ax.hrms.leave.management.web.constants.AxHrmsHrLeaveManagementSystemWebPortletConstants;
import com.ax.hrms.leave.management.web.constants.AxHrmsLeaveManagementSystemWebPortletKeys;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

/**
 * 
 * @author keval.kathiriya
 *
 */

@Component(
		immediate = true,
		property = {
			"com.liferay.portlet.display-category=AX HRMS",
			"com.liferay.portlet.header-portlet-css=/css/main.css",
			"com.liferay.portlet.instanceable=false",
			"javax.portlet.display-name=AxHrms HR Leave Management System Web",
			"javax.portlet.init-param.template-path=/",
			"javax.portlet.init-param.view-template="+AxHrmsHrLeaveManagementSystemWebPortletConstants.LIST_VIEW_LEAVE_REQUEST_JSP,
			"javax.portlet.name=" + AxHrmsLeaveManagementSystemWebPortletKeys.AXHRMS_HR_LEAVE_MANAGEMENT_SYSTEM_WEB_PORTLET,
			"javax.portlet.resource-bundle=content.Language",
			"javax.portlet.security-role-ref=power-user,user"
		},
		service = Portlet.class
	)

public class AxHrmsHrLeaveManagementWebPortlet extends MVCPortlet{

}
