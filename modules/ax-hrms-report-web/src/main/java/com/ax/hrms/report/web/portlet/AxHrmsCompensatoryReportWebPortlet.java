package com.ax.hrms.report.web.portlet;

import com.ax.hrms.report.web.constants.AkHrmsLeaveBalanceReportWebPortletKeys;
import com.ax.hrms.report.web.constants.AxHrmsCompensatoryReportWebPortletKeys;
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
		"javax.portlet.display-name=Ax Hrms Compensatory Report",
		"com.liferay.portlet.footer-portlet-javascript=/js/main.js",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/jsp/compensatory/compensatoryReportExport.jsp",
		"javax.portlet.name=" + AxHrmsCompensatoryReportWebPortletKeys.AXHRMSCOMPENSATORYREPORTWEB,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class AxHrmsCompensatoryReportWebPortlet extends MVCPortlet {
}