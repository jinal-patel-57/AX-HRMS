package com.ax.hrms.master.web.portlet;

import com.ax.hrms.master.web.constants.AxPolicyTypeMasterWebPortletConstants;
import com.ax.hrms.master.web.constants.AxPolicyTypeMasterWebPortletKeys;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.Portlet;

import org.osgi.service.component.annotations.Component;

@Component(
		immediate = true,
		property = {
			"com.liferay.portlet.display-category=category.sample",
			"com.liferay.portlet.header-portlet-css=/css/main.css",
			"com.liferay.portlet.footer-portlet-javascript=" + AxPolicyTypeMasterWebPortletConstants.MAIN_JS_POLICY_TYPE_MASTER,
			"com.liferay.portlet.instanceable=true",
			"javax.portlet.display-name=AxHrmsPolicyTypeMasterWeb",
			"javax.portlet.init-param.template-path=/",
			"javax.portlet.name="+AxPolicyTypeMasterWebPortletKeys.AXHRMS_POLICYTYPEMASTER_WEB_PORTLET_KEYS,
			"javax.portlet.resource-bundle=content.Language",
			"javax.portlet.security-role-ref=power-user,user"
		},
		service = Portlet.class
)

public class AxPolicyTypeMasterWebPortlet extends MVCPortlet {

}
