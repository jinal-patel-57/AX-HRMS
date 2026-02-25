package com.ax.hrms.hr.dashboard.leave.report.web.portlet;

import com.ax.hrms.hr.dashboard.leave.report.web.constants.AxHrmsHrDashboardLeaveReportWebPortletKeys;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import org.osgi.service.component.annotations.Component;

import javax.portlet.Portlet;

@Component(
        property = {
                "com.liferay.portlet.display-category=category.sample",
                "com.liferay.portlet.header-portlet-css=/css/main.css",
                "com.liferay.portlet.instanceable=true",
                "javax.portlet.display-name=AxHrmsHrDashboardWFHReportWeb",
                "javax.portlet.init-param.template-path=/",
                "javax.portlet.init-param.view-template=/jsp/dashboardWFHreport/listTodaysWFHEmployees.jsp",
                "javax.portlet.name=" + AxHrmsHrDashboardLeaveReportWebPortletKeys.AXHRMSHRDASHBOARDWFHREPORTWEB,
                "javax.portlet.resource-bundle=content.Language",
                "javax.portlet.security-role-ref=power-user,user"
        },
        service = Portlet.class
)
public class AxHrmsHrDashboardWFHReportWebPortlet extends MVCPortlet {
}
