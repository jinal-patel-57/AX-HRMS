package com.ax.hrms.probation.management.hr.web.portlet;

import com.ax.hrms.probation.management.hr.web.constants.AxHrmsProbationHrWebConstants;
import com.ax.hrms.probation.management.hr.web.constants.AxHrmsProbationHrWebPortletKey;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.Portlet;

import org.osgi.service.component.annotations.Component;

/**
 * @author krish.moradiya
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category="+AxHrmsProbationHrWebConstants.PORTLET_CATEGORY,
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.header-portlet-javascript="+AxHrmsProbationHrWebConstants.JQUERY_JS_PATH,
		"com.liferay.portlet.header-portlet-javascript="+AxHrmsProbationHrWebConstants.JQUERY_VALIDATOR_JS_PATH,
		"com.liferay.portlet.header-portlet-javascript="+AxHrmsProbationHrWebConstants.MAIN_JS_PATH,
		"com.liferay.portlet.instanceable=false",
		"javax.portlet.display-name=AxHrms Probation Management HR",
		"javax.portlet.init-param.template-path="+ AxHrmsProbationHrWebConstants.DEFAULT_PATH,
		"javax.portlet.init-param.view-template="+AxHrmsProbationHrWebConstants.LIST_OF_UPCOMING_PROBATION_EMPLOYEE_JSP_PATH,
		"javax.portlet.name=" + AxHrmsProbationHrWebPortletKey.AX_HRMS_PROBATION_HR_WEB_PORTLET_KEY,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class AxHrmsProbationHrWebPortlet extends MVCPortlet {
}