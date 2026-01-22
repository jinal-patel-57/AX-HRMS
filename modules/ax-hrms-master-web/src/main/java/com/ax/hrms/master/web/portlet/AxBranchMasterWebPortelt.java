package com.ax.hrms.master.web.portlet;

import com.ax.hrms.master.web.constants.AxBranchWebPortletConstants;
import com.ax.hrms.master.web.constants.AxBranchWebPortletKeys;
import com.ax.hrms.master.web.constants.AxWishTypeMasterWebPortletConstants;
import com.ax.hrms.master.web.constants.AxWishTypeMasterWebPortletKeys;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import org.osgi.service.component.annotations.Component;

import javax.portlet.Portlet;

@Component(
        immediate = true,
        property = {
                "com.liferay.portlet.display-category=category.sample",
                "com.liferay.portlet.header-portlet-css=/css/main.css",
                "com.liferay.portlet.footer-portlet-javascript=" + AxBranchWebPortletConstants.MAIN_JS_WISH_TYPE_MASTER,
                "com.liferay.portlet.instanceable=true",
                "javax.portlet.display-name=Ax Hrms Branch Master Web",
                "javax.portlet.init-param.template-path=/",
                "javax.portlet.name="+ AxBranchWebPortletKeys.AXHRMS_BRANCHMASTER_WEB_PORTLET_KEYS,
                "javax.portlet.resource-bundle=content.Language",
                "javax.portlet.security-role-ref=power-user,user"
        },
        service = Portlet.class
)
public class AxBranchMasterWebPortelt extends MVCPortlet {
}
