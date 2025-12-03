package com.ax.hrms.master.policy.type.web.action;

import com.ax.hrms.master.service.PolicyTypeMasterLocalService;
import com.ax.hrms.master.web.constants.AxPolicyTypeMasterWebPortletConstants;
import com.ax.hrms.master.web.constants.AxPolicyTypeMasterWebPortletKeys;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.ParamUtil;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**

Author: Himanshu Jha
*/

@Component(
		immediate = true,
		property = {
			"javax.portlet.name="+AxPolicyTypeMasterWebPortletKeys.AXHRMS_POLICYTYPEMASTER_WEB_PORTLET_KEYS,
			"mvc.command.name=/viewPolicyType"
		},
		service = MVCRenderCommand.class
	)

public class ViewPolicyTypeMasterMVCRenderCommand implements MVCRenderCommand {
	
	private Log log = LogFactoryUtil.getLog(ViewPolicyTypeMasterMVCRenderCommand.class);

	
	@Reference
	PolicyTypeMasterLocalService policyTypeMasterLocalService;
		
	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		
		long policyTypeMasterId = ParamUtil.getLong(renderRequest, AxPolicyTypeMasterWebPortletConstants.POLICYTYPE_MASTER_ID);
		
		try {
			
			renderRequest.setAttribute(AxPolicyTypeMasterWebPortletConstants.POLICYDETAILS, policyTypeMasterLocalService.getPolicyTypeMaster(policyTypeMasterId));
			
		} catch (PortalException e) {
			log.error("Error " + e.getMessage());
		}
		return AxPolicyTypeMasterWebPortletConstants.VIEW_POLICY_TYPE_MASTER;

	}

}
