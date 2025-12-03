package com.ax.hrms.profile.management.portlet;

import com.ax.hrms.profile.management.constants.AxHrmsProfileManagementWebConstants;
import com.ax.hrms.profile.management.constants.AxHrmsProfileManagementWebPortletKeys;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.Portlet;

import org.osgi.service.component.annotations.Component;

/**
 * @author krish.moradiya
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category="+AxHrmsProfileManagementWebConstants.PORTLET_CATEGORY,
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.header-portlet-javascript="+AxHrmsProfileManagementWebConstants.JQUERY_JS_FILE,
		"com.liferay.portlet.header-portlet-javascript="+AxHrmsProfileManagementWebConstants.JQUERY_VALIDATOR_JS_FILE,
		"com.liferay.portlet.footer-portlet-javascript="+AxHrmsProfileManagementWebConstants.MAIN_JS_FILE,
		"com.liferay.portlet.instanceable=false",
		"javax.portlet.display-name="+AxHrmsProfileManagementWebConstants.DISPLAY_NAME,
		"javax.portlet.init-param.template-path="+AxHrmsProfileManagementWebConstants.DEFAULT_PATH,
		"javax.portlet.init-param.view-template="+AxHrmsProfileManagementWebConstants.VIEW_EMPLOYEE_PROFILE_JSP_FILE,
		"javax.portlet.name=" + AxHrmsProfileManagementWebPortletKeys.AXHRMSPROFILEMANAGEMENTWEB,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class AxHrmsProfileManagementWebPortlet extends MVCPortlet {
}