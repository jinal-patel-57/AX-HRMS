package com.ax.hrms.master.web.portlet;

import com.ax.hrms.master.web.constants.AxHrmsMasterWebPortletKeys;
import com.ax.hrms.master.web.constants.AxHrmsProjectTaskStatusMasterConstants;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import org.osgi.service.component.annotations.Component;

import javax.portlet.Portlet;

/**
 * @author keval.kathiriya
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=AX HRMS MASTERS",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.header-portlet-javascript=" + AxHrmsProjectTaskStatusMasterConstants.JQUERY_JS_PATH,
		"com.liferay.portlet.header-portlet-javascript=" + AxHrmsProjectTaskStatusMasterConstants.JQUERY_VALIDATE_JS_PATH,
		"com.liferay.portlet.header-portlet-javascript=/js/appraisal-status-master/main.js",
		"com.liferay.portlet.instanceable=false",
		"javax.portlet.display-name=Ax Hrms Appraisal Status Master",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + AxHrmsMasterWebPortletKeys.AX_HRMS_APPRAISAL_STATUS_MASTER_WEB_PORTLET,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class AxHrmsAppraisalStatusMasterWebPortlet extends MVCPortlet {

}