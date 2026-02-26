package com.ax.hrms.report.web.portlet;

import com.ax.hrms.report.web.constants.AxHrmsMonthWiseLeaveBalanceReportWebPortletKeys;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import org.osgi.service.component.annotations.Component;

import javax.portlet.Portlet;

/**
 * @author ankit.hadiyal
 */
@Component(
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=AxHrmsMonthWiseLeaveBalanceReportWeb",
		"com.liferay.portlet.footer-portlet-javascript=/js/main.js",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/jsp/leavebalance/view.jsp",
		"javax.portlet.name=" + AxHrmsMonthWiseLeaveBalanceReportWebPortletKeys.AXHRMSMONTHWISELEAVEBALANCEREPORTWEB,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class AxHrmsMonthWiseLeaveBalanceReportWebPortlet extends MVCPortlet {
}