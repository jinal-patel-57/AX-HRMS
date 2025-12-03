package com.ax.hrms.employee.onboarding.web.portlet;

import com.ax.hrms.employee.onboarding.web.constants.AxHrmsEmployeeOnboardingWebPortletKeys;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.Portlet;

import org.osgi.service.component.annotations.Component;

@Component(
		property = {
			"com.liferay.portlet.display-category=AX HRMS",
			"com.liferay.portlet.header-portlet-css=/css/main.css",
			"com.liferay.portlet.instanceable=false",
			"com.liferay.portlet.footer-portlet-javascript=/js/employee-onborading/main.js",
			"javax.portlet.display-name=AxHrmsEmployeeOnboardingEmployeeWeb",
			"javax.portlet.init-param.template-path=/",
			"javax.portlet.init-param.view-template=/jsp/ax-hrms-employee-onboarding-employee/test.jsp",
			"javax.portlet.name=" + AxHrmsEmployeeOnboardingWebPortletKeys.AX_HRMS_EMPLOYEE_ONBOARDING_EMPLOYEE_WEB,
			"javax.portlet.resource-bundle=content.Language",
			"javax.portlet.security-role-ref=power-user,user"
		},
		service = Portlet.class
	)
public class AxHrmsEmployeeOnboardingEmployeeWebPortlet extends MVCPortlet{

}
