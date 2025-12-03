package com.ax.hrms.policy.process.management.web.portlet;

import com.ax.hrms.policy.process.management.web.constants.AxHrmsPolicyProcessManagementHrAdminWebPortletKeys;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.Portlet;

import org.osgi.service.component.annotations.Component;

/**
 * @author himashu.jha
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=AX HRMS",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=Ax Hrms Policy Process Management Hr Admin Web",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/jsp/policy-process-management-hr-admin/listPolicyProcessManagementHrAdmin.jsp",
		"com.liferay.portlet.header-portlet-javascript=" + "js/policy-process-management-hr-admin/jquery.js",
		"com.liferay.portlet.header-portlet-javascript=" + "js/policy-process-management-hr-admin/jquery.validation.min.js",
		"com.liferay.portlet.footer-portlet-javascript=" + "js/policy-process-management-hr-admin/main.js",
		"javax.portlet.name=" + AxHrmsPolicyProcessManagementHrAdminWebPortletKeys.AXHRMSPOLICYPROCESSMANAGEMENTHRADMINWEB,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class AxHrmsPolicyProcessManagementHrAdminWebPortlet extends MVCPortlet {

}
