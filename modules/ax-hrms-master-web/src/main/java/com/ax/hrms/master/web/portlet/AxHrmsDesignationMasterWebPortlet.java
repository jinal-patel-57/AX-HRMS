package com.ax.hrms.master.web.portlet;

import com.ax.hrms.master.web.constants.AxHrmsDesignationMasterWebPortletConstants;
import com.ax.hrms.master.web.constants.AxHrmsDesignationMasterWebPortletKeys;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.Portlet;

import org.osgi.service.component.annotations.Component;

@Component(
		immediate = true,
		property = {
			"com.liferay.portlet.display-category="+AxHrmsDesignationMasterWebPortletConstants.PORTLET_CATEGORY,
			"com.liferay.portlet.header-portlet-javascript=" + AxHrmsDesignationMasterWebPortletConstants.JQUERY_JS_PATH,
			"com.liferay.portlet.header-portlet-javascript=" + AxHrmsDesignationMasterWebPortletConstants.JQUERY_VALIDATOR_JS_PATH,
			"com.liferay.portlet.footer-portlet-javascript=" + AxHrmsDesignationMasterWebPortletConstants.MAIN_JS_PATH,
			"com.liferay.portlet.header-portlet-css=" + AxHrmsDesignationMasterWebPortletConstants.MAIN_CSS_PATH,
			"com.liferay.portlet.instanceable=false",
			"javax.portlet.display-name=" + AxHrmsDesignationMasterWebPortletConstants.DESIGNATION_MASTER_DISPLAY_NAME,
			"javax.portlet.init-param.template-path=" + AxHrmsDesignationMasterWebPortletConstants.DEFAULT_PATH,
			"javax.portlet.init-param.view-template=" + AxHrmsDesignationMasterWebPortletConstants.DESIGNATION_MASTER_LIST_JSP_PATH,
			"javax.portlet.name=" + AxHrmsDesignationMasterWebPortletKeys.AXHRMS_DESIGNATIONMASTER_WEB_PORTLET_KEY,
			"javax.portlet.resource-bundle=content.Language",
			"javax.portlet.security-role-ref=power-user,user"
		},
		service = Portlet.class
)
public class AxHrmsDesignationMasterWebPortlet extends MVCPortlet{

}
