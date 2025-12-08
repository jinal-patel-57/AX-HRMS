package com.ax.hrms.portlet;

import javax.portlet.Portlet;

import org.osgi.service.component.annotations.Component;

import com.ax.hrms.constants.AxHrmsBirthdayWebPortletKeys;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

@Component(
		immediate = true,
		property = {
			"com.liferay.portlet.display-category=AX HRMS",
			"com.liferay.portlet.header-portlet-css=/css/main.css",
			"com.liferay.portlet.header-portlet-javascript=/js/ax-hrms-birthday-web/main.js",
			"com.liferay.portlet.header-portlet-javascript=/js/ax-hrms-birthday-web/summernote-lite.min.js",
			"com.liferay.portlet.instanceable=false",
			"javax.portlet.display-name=AxHrms Birthday Web",
			"javax.portlet.init-param.template-path=/",
			"javax.portlet.init-param.view-template=/jsp/ax-hrms-birthday-web/listBirthdayEmployee.jsp",
			"javax.portlet.name=" + AxHrmsBirthdayWebPortletKeys.AXHRMSEMPLOYEEBIRTHDAYWEB,
			"javax.portlet.resource-bundle=content.Language",
			"javax.portlet.security-role-ref=power-user,user"
		},
		service = Portlet.class
	)
public class AxHrmsEmployeeBirthdayWebPortlet extends MVCPortlet {

}
