package com.ax.hrms.master.web.portlet;

import com.ax.hrms.master.web.constants.AxDepartmentMasterWebPortletKeys;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import javax.portlet.Portlet;

import org.osgi.service.component.annotations.Component;

@Component(
		immediate = true,
		property = {
			"com.liferay.portlet.display-category=AX HRMS MASTERS",
			"com.liferay.portlet.header-portlet-javascript=/js/department-master/jqurey.3.7.1.js",
			"com.liferay.portlet.header-portlet-javascript=/js/department-master/jqurey.validate.min.js",
			"com.liferay.portlet.header-portlet-css=/css/main.css",
			"com.liferay.portlet.footer-portlet-javascript=/js/department-master/main.js",
			"com.liferay.portlet.instanceable=true",
			"javax.portlet.display-name=AxDepartmentMasterWeb",
			"javax.portlet.init-param.template-path=/",
			"javax.portlet.init-param.view-template=/jsp/department-master/listDepartmentMaster.jsp",
			"javax.portlet.name=" + AxDepartmentMasterWebPortletKeys.AXHRMS_DEPARTMENT_MASTER_WEB_PORTLET_KEYS,
			"javax.portlet.resource-bundle=content.Language",
			"javax.portlet.security-role-ref=power-user,user"
		},
		service = Portlet.class
	)
public class AxDepartmentMasterWebPortlet extends MVCPortlet{

}
