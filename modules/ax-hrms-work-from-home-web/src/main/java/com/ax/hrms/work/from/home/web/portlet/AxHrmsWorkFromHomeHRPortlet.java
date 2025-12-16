package com.ax.hrms.work.from.home.web.portlet;

import com.ax.hrms.work.from.home.web.constants.AxHrmsWorkFromHomePortletKeys;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import org.osgi.service.component.annotations.Component;

import javax.portlet.Portlet;

/**
 * @author Parth.Ranipa
 */
@Component(
        property = {
                "com.liferay.portlet.display-category=category.sample",
                "com.liferay.portlet.header-portlet-css=/css/main.css",
                "com.liferay.portlet.instanceable=true",
                "javax.portlet.display-name=AxHrmsWorkFromHomeHR",
                "javax.portlet.init-param.template-path=/",
                "javax.portlet.init-param.view-template=/jsp/ax-hrms-work-from-home-hr/list_work_from_home_hr.jsp",
                "javax.portlet.name=" + AxHrmsWorkFromHomePortletKeys.AXHRMSWORKFROMHOMEHR,
                "javax.portlet.resource-bundle=content.Language",
                "javax.portlet.security-role-ref=power-user,user"
        },
        service = Portlet.class
)
public class AxHrmsWorkFromHomeHRPortlet extends MVCPortlet {
}