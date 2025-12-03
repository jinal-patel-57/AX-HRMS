package com.ax.hrms.master.web.portlet;
import com.ax.hrms.master.web.constants.AxHrmsDesignationMasterWebPortletConstants;
import com.ax.hrms.master.web.constants.AxHrmsMasterWebPortletKeys;
import com.ax.hrms.master.web.constants.AxHrmsPriorityMasterWebPortletConstants;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.Portlet;

import org.osgi.service.component.annotations.Component;

/**
 * 
 * @author krish.moradiya
 * 
 * @category Master Table : Priority default web portlet
 */
@Component(
        immediate = true,
        property = {
                "com.liferay.portlet.display-category="+ AxHrmsPriorityMasterWebPortletConstants.PORTLET_CATEGORY,
                "com.liferay.portlet.header-portlet-javascript=" + AxHrmsPriorityMasterWebPortletConstants.JQUERY_JS_PATH,
                "com.liferay.portlet.header-portlet-javascript=" + AxHrmsPriorityMasterWebPortletConstants.JQUERY_VALIDATOR_JS_PATH,
                "com.liferay.portlet.footer-portlet-javascript=" + AxHrmsPriorityMasterWebPortletConstants.MAIN_JS_PATH,
                "com.liferay.portlet.header-portlet-css=" + AxHrmsPriorityMasterWebPortletConstants.MAIN_CSS_PATH,
                "com.liferay.portlet.instanceable=false",
                "javax.portlet.display-name=" + AxHrmsPriorityMasterWebPortletConstants.PRIORITY_MASTER_DISPLAY_NAME,
                "javax.portlet.init-param.template-path=" + AxHrmsPriorityMasterWebPortletConstants.DEFAULT_JSP_PATH,
                "javax.portlet.init-param.view-template=" + AxHrmsPriorityMasterWebPortletConstants.LIST_OF_PRIORITY_MASTER_JSP_PATH,
                "javax.portlet.name=" + AxHrmsMasterWebPortletKeys.AXHRMS_PRIORITY_MASTER_WEB_PORTLET_KEYS,
                "javax.portlet.resource-bundle=content.Language",
                "javax.portlet.security-role-ref=power-user,user"
        },
        service = Portlet.class
)
public class AxHrmsPriorityMasterWebPortlet extends MVCPortlet{
}