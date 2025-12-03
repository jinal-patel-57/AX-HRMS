package com.ax.hrms.hr.appraisal.process.portlet;

import com.ax.hrms.hr.appraisal.process.constants.AxHrmsHrAppraisalProcessPortletKeys;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.Portlet;

import org.osgi.service.component.annotations.Component;

/**
 * @author nivid.koradiya
 */
@Component(
	property = {
		"com.liferay.portlet.display-category=AX HRMS",
		"com.liferay.portlet.header-portlet-javascript=/js/lib/jquery-3.7.1.js",
		"com.liferay.portlet.header-portlet-javascript=/js/lib/bootstrap.bundle.js",
		"com.liferay.portlet.header-portlet-javascript=/js/lib/popper.js",
		"com.liferay.portlet.header-portlet-javascript=/js/lib/jquery.validate.min.js",
		"com.liferay.portlet.footer-portlet-javascript=/js/appraisal-process-hr/main.js",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=false",
		"javax.portlet.display-name=Ax Hrms HR Appraisal Process",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + AxHrmsHrAppraisalProcessPortletKeys.AX_HRMS_HR_APPRAISAL_PROCESS_WEB_PORTLET,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user",
	},
	service = Portlet.class
)
public class AxHrmsHrAppraisalProcessPortlet extends MVCPortlet {
}