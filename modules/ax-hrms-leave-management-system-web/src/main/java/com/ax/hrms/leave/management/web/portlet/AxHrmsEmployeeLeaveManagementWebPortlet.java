package com.ax.hrms.leave.management.web.portlet;

import javax.portlet.Portlet;

import org.osgi.service.component.annotations.Component;

import com.ax.hrms.leave.management.web.constants.AxHrmsLeaveManagementSystemWebPortletKeys;
import com.ax.hrms.leave.management.web.constants.AxHrmsLeaveManagementWebPortletConstants;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

/**
 * @author krish.moradiya
 * @implNote : Portlet file of leaveRequest Managing Portlet
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category="+AxHrmsLeaveManagementWebPortletConstants.PORTLET_CATEGORY,
		"com.liferay.portlet.header-portlet-javascript="+AxHrmsLeaveManagementWebPortletConstants.JQUERY_JS_PATH,
		"com.liferay.portlet.header-portlet-javascript="+AxHrmsLeaveManagementWebPortletConstants.JQUERY_VALIDATOR_JS_PATH,
		"com.liferay.portlet.footer-portlet-javascript="+AxHrmsLeaveManagementWebPortletConstants.MAIN_JS_PATH,
		"com.liferay.portlet.header-portlet-css="+AxHrmsLeaveManagementWebPortletConstants.MAIN_CSS_PATH,
		"com.liferay.portlet.instanceable=false",
		"javax.portlet.display-name=AxHrmsEmployeeLeaveRequestPortlet",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=",
		"javax.portlet.name=" + AxHrmsLeaveManagementSystemWebPortletKeys.AXHRMS_EMPLOYEE_LEAVE_MANAGEMENT_SYSTEM_WEB_PORTLET,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class AxHrmsEmployeeLeaveManagementWebPortlet extends MVCPortlet {
}
