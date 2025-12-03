package com.ax.hrms.employee.directory.web.portlet;

import com.ax.hrms.employee.directory.web.constants.AxHrmsEmployeeDirectoryEmployeeWebPortletKeys;
import com.ax.hrms.employee.directory.web.constants.AxHrmsEmployeeDirectoryWebPortletKeys;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.Portlet;

import org.osgi.service.component.annotations.Component;

/**
 * @author himashu.jha
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=Employee Directory EmployeeWeb",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/jsp/employee-directory-employee/listEmployeeDirectory.jsp",
		"javax.portlet.name=" + AxHrmsEmployeeDirectoryEmployeeWebPortletKeys.AXHRMSEMPLOYEEDIRECTORYEMPLOYEEWEB,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)


public class AxHrmsEmployeeDirectoryEmployeeWebPortlet extends MVCPortlet {

}
