package com.ax.hrms.compensatory.web.portlet;

import com.ax.hrms.compensatory.web.constants.AxHrmsCompensatoryWebPortletKeys;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import org.osgi.service.component.annotations.Component;

import javax.portlet.Portlet;

/**
 * @author nivid.koradiya
 */
@Component(
	property = {
		"com.liferay.portlet.display-category=AX HRMS",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.header-portlet-javascript=/js/lib/jquery.validate.min.js",
		"com.liferay.portlet.footer-portlet-javascript=/js/approveRejectCompensatoryManager/main.js",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=Ax Hrms Manager Compensatory Web",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + AxHrmsCompensatoryWebPortletKeys.AX_HRMS_COMPENSATORY_MANAGER_WEB_PORTLET,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class AxHrmsManagerCompensatoryWebPortlet extends MVCPortlet {
}