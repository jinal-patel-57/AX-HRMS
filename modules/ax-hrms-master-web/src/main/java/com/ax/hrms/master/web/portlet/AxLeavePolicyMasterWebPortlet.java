package com.ax.hrms.master.web.portlet;

import com.ax.hrms.master.web.constants.AxLeavePolicyMasterWebPortletKeys;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.Portlet;

import org.osgi.service.component.annotations.Component;

@Component(
		immediate = true,
		property = {
			"com.liferay.portlet.display-category=AX HRMS MASTERS",
			"com.liferay.portlet.header-portlet-css=/css/main.css",
			"com.liferay.portlet.footer-portlet-javascript=/js/leave-policy-master/main.js",
			"com.liferay.portlet.instanceable=true",
			"javax.portlet.display-name=AxLeavePolicyMasterWeb",
			"javax.portlet.init-param.template-path=/",
			"javax.portlet.init-param.view-template=/jsp/leave-policy-master/listLeavePolicyMaster.jsp",
			"javax.portlet.name=" + AxLeavePolicyMasterWebPortletKeys.AXHRMS_LEAVE_POLICY_MASTER_WEB_PORTLET_KEY,
			"javax.portlet.resource-bundle=content.Language",
			"javax.portlet.security-role-ref=power-user,user"
		},
		service = Portlet.class
	)
public class AxLeavePolicyMasterWebPortlet extends MVCPortlet{

}
