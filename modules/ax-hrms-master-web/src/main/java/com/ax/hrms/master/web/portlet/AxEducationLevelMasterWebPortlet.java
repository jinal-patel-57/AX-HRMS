package com.ax.hrms.master.web.portlet;

import com.ax.hrms.master.web.constants.AxEducationLevelMasterWebPortletConstants;
import com.ax.hrms.master.web.constants.AxEducationLevelMasterWebPortletKeys;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.Portlet;

import org.osgi.service.component.annotations.Component;

@Component(
		immediate = true,
		property = {
			"com.liferay.portlet.display-category=category.sample",
			"com.liferay.portlet.header-portlet-css=/css/main.css",
			"com.liferay.portlet.header-portlet-javascript=" + AxEducationLevelMasterWebPortletConstants.JQUERY_EDUCATION_LEVEL_MASTER,
			"com.liferay.portlet.header-portlet-javascript=" + AxEducationLevelMasterWebPortletConstants.JQUERY_VALIDATE_EDUCATION_LEVEL_MASTER,
			"com.liferay.portlet.footer-portlet-javascript=" + AxEducationLevelMasterWebPortletConstants.MAIN_JS_EDUCATION_LEVEL_MASTER,
			"com.liferay.portlet.instanceable=true",
			"javax.portlet.display-name=AxHrmsEducationLevelMasterWeb",
			"javax.portlet.init-param.template-path=/",
			"javax.portlet.name="+AxEducationLevelMasterWebPortletKeys.AXHRMS_EDUCATIONLEVELMASTER_WEB_PORTLET_KEYS,
			"javax.portlet.resource-bundle=content.Language",
			"javax.portlet.security-role-ref=power-user,user"
		},
		service = Portlet.class
)
public class AxEducationLevelMasterWebPortlet extends MVCPortlet {

}
