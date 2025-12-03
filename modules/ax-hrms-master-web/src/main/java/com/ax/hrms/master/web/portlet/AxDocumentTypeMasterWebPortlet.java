package com.ax.hrms.master.web.portlet;

import javax.portlet.Portlet;

import org.osgi.service.component.annotations.Component;

import com.ax.hrms.master.web.constants.AxDocumentTypeMasterWebPortletKeys;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

/**
 * 
 * @author keval.kathiriya
 *
 */
@Component(
		immediate = true,
		property = {
			"com.liferay.portlet.display-category=AX HRMS MASTERS",
			"com.liferay.portlet.header-portlet-css=/css/document-type-master/main.css",	
			"com.liferay.portlet.header-portlet-javascript=/js/document-type-master/jquery.js",
			"com.liferay.portlet.header-portlet-javascript=/js/document-type-master/jquery-validator.js",
			"com.liferay.portlet.header-portlet-javascript=/js/document-type-master/main.js",
			"com.liferay.portlet.header-portlet-javascript=/js/document-type-master/sweetalert.js",
			"com.liferay.portlet.instanceable=true",
			"javax.portlet.display-name=AxDocumentTypeMasterWeb",
			"javax.portlet.init-param.template-path=/",
			"javax.portlet.init-param.view-template=/jsp/document-type-master/list-view-document-type-master.jsp",
			"javax.portlet.name=" + AxDocumentTypeMasterWebPortletKeys.AXDOCUMENTTYPEMASTERWEB,
			"javax.portlet.resource-bundle=content.Language",
			"javax.portlet.security-role-ref=power-user,user"
		},
		service = Portlet.class
	)

public class AxDocumentTypeMasterWebPortlet extends MVCPortlet {

}
