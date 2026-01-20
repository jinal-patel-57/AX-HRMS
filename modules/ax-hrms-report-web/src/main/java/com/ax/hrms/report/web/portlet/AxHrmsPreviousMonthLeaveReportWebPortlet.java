package com.ax.hrms.report.web.portlet;

import com.ax.hrms.report.web.constants.AkHrmsLeaveBalanceReportWebPortletKeys;
import com.ax.hrms.report.web.constants.AxHrmsPreviousMonthLeaveReportWebPortletKeys;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import org.osgi.service.component.annotations.Component;

import javax.portlet.Portlet;

@Component(
        property = {
                "com.liferay.portlet.display-category=category.sample",
                "com.liferay.portlet.header-portlet-css=/css/main.css",
                "com.liferay.portlet.instanceable=true",
                "javax.portlet.display-name=AxHrmsPreviousMonthLeaveReportWebPortlet",
                "com.liferay.portlet.footer-portlet-javascript=/js/main.js",
                "javax.portlet.init-param.template-path=/",
                "javax.portlet.name=" + AxHrmsPreviousMonthLeaveReportWebPortletKeys.AXHRMSPREVIOUSMONTHLEAVEREPORTWEB,
                "javax.portlet.resource-bundle=content.Language",
                "javax.portlet.security-role-ref=power-user,user"
        },
        service = Portlet.class
)
public class AxHrmsPreviousMonthLeaveReportWebPortlet extends MVCPortlet {
}

