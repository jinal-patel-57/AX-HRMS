package com.ax.hrms.employee.onboarding.web.portlet;

import com.ax.hrms.employee.onboarding.web.constants.AxHrmsEmployeeOnboardingHrWebPortletConstants;
import com.ax.hrms.employee.onboarding.web.constants.AxHrmsEmployeeOnboardingWebPortletKeys;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import org.osgi.service.component.annotations.Component;

import javax.portlet.Portlet;

/**
 * @author nivid.koradiya
 */
@Component(
	property = {
		"com.liferay.portlet.display-category=AX HRMS",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.header-portlet-javascript=/js/employee-onboarding-hr/main.js",
		"com.liferay.portlet.header-portlet-javascript=/js/employee-onboarding-hr/main-employee.js",
		"com.liferay.portlet.instanceable=false",
		"javax.portlet.display-name=Ax Hrms Employee Onboarding HR",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + AxHrmsEmployeeOnboardingWebPortletKeys.AX_HRMS_EMPLOYEE_ONBOARDING_HR_WEB,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class AxHrmsEmployeeOnboardingHrWebPortlet extends MVCPortlet {
}