package com.ax.hrms.newjoiner.web.portlet;

import com.ax.hrms.newjoiner.web.constants.AxHrmsNewJoinerWebPortletConstants;
import com.ax.hrms.newjoiner.web.constants.AxHrmsNewJoinerWebPortletKeys;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.Portlet;

import org.osgi.service.component.annotations.Component;

/**
 * @author krish.moradiya
 */
@Component(
        immediate = true,
        property = {
                "com.liferay.portlet.display-category="+AxHrmsNewJoinerWebPortletConstants.PORTLET_KEY,
                "com.liferay.portlet.header-portlet-css=/css/ax-hrms-new-joiner-web/main.css",
                "com.liferay.portlet.header-portlet-javascript="+AxHrmsNewJoinerWebPortletConstants.MAIN_JS_PATH,
                "com.liferay.portlet.instanceable=false",
                "javax.portlet.display-name=AxHrmsNewJoinerWishWeb",
                "javax.portlet.init-param.template-path=/",
                "javax.portlet.init-param.view-template="+ AxHrmsNewJoinerWebPortletConstants.LIST_OF_NEW_JOINER_JSP_PATH,
                "javax.portlet.name=" + AxHrmsNewJoinerWebPortletKeys.AXHRMSNEWJOINERWEB,
                "javax.portlet.resource-bundle=content.Language",
                "javax.portlet.security-role-ref=power-user,user"
        },
        service = Portlet.class
)
public class AxHrmsNewJoinerWebPortlet extends MVCPortlet {
}