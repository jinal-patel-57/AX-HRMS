package com.ax.hrms.master.web.portlet;
import com.ax.hrms.master.web.constants.AxHrmsDesignationMasterWebPortletConstants;
import com.ax.hrms.master.web.constants.AxHrmsLeaveTypeMasterWebPortletConstants;
import com.ax.hrms.master.web.constants.AxHrmsLeaveTypeMasterWebPortletKeys;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.Portlet;

import org.osgi.service.component.annotations.Component;


/**
 * 
 * @author krish.moradiya
 * 
 * Default Web Portlet for Leave type Master Data
 *
 */
@Component(
		immediate = true,
		property = {
			"com.liferay.portlet.display-category="+ AxHrmsLeaveTypeMasterWebPortletConstants.PORTLET_CATEGORY,
			"com.liferay.portlet.header-portlet-javascript=" + AxHrmsLeaveTypeMasterWebPortletConstants.JQUERY_JS_PATH,
			"com.liferay.portlet.header-portlet-javascript=" + AxHrmsLeaveTypeMasterWebPortletConstants.JQUERY_VALIDATOR_JS_PATH,
			"com.liferay.portlet.footer-portlet-javascript=" + AxHrmsLeaveTypeMasterWebPortletConstants.MAIN_JS_PATH,
			"com.liferay.portlet.header-portlet-css=" + AxHrmsLeaveTypeMasterWebPortletConstants.MAIN_CSS_PATH,
			"com.liferay.portlet.instanceable=false",
			"javax.portlet.display-name=" + AxHrmsLeaveTypeMasterWebPortletConstants.LEAVE_TYPE_MASTER_DISPLAY_NAME,
			"javax.portlet.init-param.template-path=" + AxHrmsLeaveTypeMasterWebPortletConstants.DEFAULT_JSP_PATH,
			"javax.portlet.init-param.view-template=" + AxHrmsLeaveTypeMasterWebPortletConstants.LIST_OF_LEAVE_TYPE_MASTER_JSP_PATH,
			"javax.portlet.name=" + AxHrmsLeaveTypeMasterWebPortletKeys.AXHRMS_LEAVE_TYPE_MASTER_WEB_PORTLET_KEYS,
			"javax.portlet.resource-bundle=content.Language",
			"javax.portlet.security-role-ref=power-user,user"
		},
		service = Portlet.class
)
public class AxHrmsLeaveTypeMasterWebPortlet extends MVCPortlet{
}
