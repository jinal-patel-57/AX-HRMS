package com.ax.hrms.master.web.portlet;

import com.ax.hrms.master.web.constants.AxProbationStatusMasterWebPortletConstants;
import com.ax.hrms.master.web.constants.AxProbationStatusMasterWebPortletKeys;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.Portlet;

import org.osgi.service.component.annotations.Component;


@Component(
		immediate = true,
		property = {
			"com.liferay.portlet.display-category=AX HRMS MASTER",
			"com.liferay.portlet.header-portlet-css=/css/main.css",
			"com.liferay.portlet.footer-portlet-javascript=" + AxProbationStatusMasterWebPortletConstants.MAIN_JS_PROBATION_STATUS_MASTER,
			"com.liferay.portlet.instanceable=true",
			"javax.portlet.display-name=AxHrmsProbationStatusMasterWeb",
			"javax.portlet.init-param.template-path=/",
			"javax.portlet.name="+AxProbationStatusMasterWebPortletKeys.AXHRMS_PROBATIONSTATUSMASTER_WEB_PORTLET_KEYS,
			"javax.portlet.resource-bundle=content.Language",
			"javax.portlet.security-role-ref=power-user,user"
		},
		service = Portlet.class
)


public class AxProbationStatusMasterWebPortlet extends MVCPortlet {

}
