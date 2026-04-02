package com.ax.hrms.report.web.portlet;

import com.ax.hrms.report.web.constants.AkHrmsLeaveBalanceReportWebPortletKeys;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import org.osgi.service.component.annotations.Component;

import javax.portlet.Portlet;

/**
 * @author parth.ranipa
 */
@Component(
        property = {
                "com.liferay.portlet.display-category=category.sample",
                "com.liferay.portlet.header-portlet-css=/css/main.css",
                "com.liferay.portlet.instanceable=true",
                "javax.portlet.display-name=AkHrmsLeaveDetailsReportWeb",
                "com.liferay.portlet.footer-portlet-javascript=/js/main.js",
                "javax.portlet.init-param.template-path=/",
                "javax.portlet.init-param.view-template=/jsp/leavereport/leaveReport.jsp",
                "javax.portlet.name=" + AkHrmsLeaveBalanceReportWebPortletKeys.AKHRMSLEAVEREPORTWEB,
                "javax.portlet.resource-bundle=content.Language",
                "javax.portlet.security-role-ref=power-user,user"
        },
        service = Portlet.class
)
public class AxHrmsLeaveDetailsReportWebPortlet extends MVCPortlet {
}