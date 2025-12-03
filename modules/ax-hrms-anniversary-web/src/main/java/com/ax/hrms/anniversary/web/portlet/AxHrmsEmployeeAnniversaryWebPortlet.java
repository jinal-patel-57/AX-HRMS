package com.ax.hrms.anniversary.web.portlet;

import com.ax.hrms.anniversary.web.constants.AxHrmsAnniversaryWebPortletConstants;
import com.ax.hrms.anniversary.web.constants.AxHrmsAnniversaryWebPortletKeys;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import org.osgi.service.component.annotations.Component;

import javax.portlet.Portlet;

@Component(
        immediate = true,
        property = {
                "com.liferay.portlet.display-category="+ AxHrmsAnniversaryWebPortletConstants.PORTLET_CATEGORY,
                "com.liferay.portlet.header-portlet-css="+AxHrmsAnniversaryWebPortletConstants.MAIN_CSS_PATH,
                "com.liferay.portlet.footer-portlet-javascript="+AxHrmsAnniversaryWebPortletConstants.MAIN_JS_PATH,
                "com.liferay.portlet.instanceable=false",
                "javax.portlet.display-name=AxHrmsAnniversaryWeb",
                "javax.portlet.init-param.template-path=/",
                "javax.portlet.init-param.view-template="+AxHrmsAnniversaryWebPortletConstants.EMPLOYEE_ANNIVERSARY_LIST_JSP_PATH,
                "javax.portlet.name=" + AxHrmsAnniversaryWebPortletKeys.AXHRMSANNIVERSARYWEB,
                "javax.portlet.resource-bundle=content.Language",
                "javax.portlet.security-role-ref=power-user,user"
        },
        service = Portlet.class
)
public class AxHrmsEmployeeAnniversaryWebPortlet extends MVCPortlet {
}
