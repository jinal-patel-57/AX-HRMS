package com.ax.hrms.holiday.web.portlet.portlet;

import com.ax.hrms.holiday.web.portlet.constants.AxHrmsHolidayHrAdminWebPortletConstants;
import com.ax.hrms.holiday.web.portlet.constants.AxHrmsHolidayHrAdminWebPortletKeys;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.Portlet;

import org.osgi.service.component.annotations.Component;

/**
 * @author himashu.jha
 */


@Component(
		immediate = true,
		property = {
			"com.liferay.portlet.display-category=AX HRMS",
			"com.liferay.portlet.header-portlet-css=/css/main.css",
			"com.liferay.portlet.instanceable=true",
			"javax.portlet.display-name=AxHrmsHrAdminHolidayWeb",
			"javax.portlet.init-param.template-path=/",
			"com.liferay.portlet.footer-portlet-javascript=" + AxHrmsHolidayHrAdminWebPortletConstants.MAIN_JS_HOLIDAY_HR_ADMIN,
			"javax.portlet.name=" + AxHrmsHolidayHrAdminWebPortletKeys.AXHRMSHRADMINHOLIDAYWEB,
			"javax.portlet.resource-bundle=content.Language",
			"javax.portlet.security-role-ref=power-user,user"
		},
		service = Portlet.class
	)

public class AxHrmsHolidayHrAdminWebPortlet extends MVCPortlet {

}
