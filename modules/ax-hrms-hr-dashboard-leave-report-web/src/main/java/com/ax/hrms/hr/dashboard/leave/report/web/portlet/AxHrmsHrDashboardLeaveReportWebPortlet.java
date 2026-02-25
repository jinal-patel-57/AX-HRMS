package com.ax.hrms.hr.dashboard.leave.report.web.portlet;

import com.ax.hrms.hr.dashboard.leave.report.web.constants.AxHrmsHrDashboardLeaveReportWebPortletKeys;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.Portlet;

import org.osgi.service.component.annotations.Component;

/**
 * @author jinal.patel
 */
@Component(
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=AxHrmsHrDashboardLeaveReportWeb",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/jsp/dashboardleavereport/listTodaysLeaveEmployees.jsp",
		"javax.portlet.name=" + AxHrmsHrDashboardLeaveReportWebPortletKeys.AXHRMSHRDASHBOARDLEAVEREPORTWEB,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class AxHrmsHrDashboardLeaveReportWebPortlet extends MVCPortlet {
}