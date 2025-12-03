package com.ax.hrms.master.web.portlet;

import com.ax.hrms.master.web.constants.AxLeaveCompensatoryStatusMasterWebPortletConstants;
import com.ax.hrms.master.web.constants.AxLeaveCompensatoryStatusMasterWebPortletKeys;
import com.ax.hrms.master.web.constants.AxWishTypeMasterWebPortletConstants;
import com.ax.hrms.master.web.constants.AxWishTypeMasterWebPortletKeys;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.Portlet;

import org.osgi.service.component.annotations.Component;

@Component(
		immediate = true,
		property = {
			"com.liferay.portlet.display-category=category.sample",
			"com.liferay.portlet.header-portlet-css=/css/main.css",
			"com.liferay.portlet.footer-portlet-javascript=" + AxLeaveCompensatoryStatusMasterWebPortletConstants.MAIN_JS_LEAVE_COMPENSATORY_STATUS_MASTER,
			"com.liferay.portlet.instanceable=true",
			"javax.portlet.display-name=AxHrmsLeaveCompensatoryStatusMasterWeb",
			"javax.portlet.init-param.template-path=/",
			"javax.portlet.name="+AxLeaveCompensatoryStatusMasterWebPortletKeys.AXHRMS_LEAVECOMPENSATORYSTATUSMASTER_WEB_PORTLET_KEYS,
			"javax.portlet.resource-bundle=content.Language",
			"javax.portlet.security-role-ref=power-user,user"
		},
		service = Portlet.class
)

public class AxLeaveCompensatoryStatusWebPortlet extends MVCPortlet {
}
