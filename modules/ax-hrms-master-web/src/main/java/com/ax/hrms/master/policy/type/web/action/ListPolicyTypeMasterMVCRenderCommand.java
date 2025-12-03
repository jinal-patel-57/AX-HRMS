package com.ax.hrms.master.policy.type.web.action;

import com.ax.hrms.master.model.PolicyTypeMaster;
import com.ax.hrms.master.service.PolicyTypeMasterLocalService;
import com.ax.hrms.master.service.PolicyTypeMasterLocalServiceUtil;
import com.ax.hrms.master.web.constants.AxPolicyTypeMasterWebPortletConstants;
import com.ax.hrms.master.web.constants.AxPolicyTypeMasterWebPortletKeys;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.ParamUtil;

import java.util.List;

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
			"mvc.command.name=/"
		},
		service = MVCRenderCommand.class
	)

public class ListPolicyTypeMasterMVCRenderCommand implements MVCRenderCommand {
	
    
	@Reference
	PolicyTypeMasterLocalService policyTypeMasterLocalService;
	
	
	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		
		
		List<PolicyTypeMaster> policyTypeMasters = null;
		
		int curValue = ParamUtil.getInteger(renderRequest,SearchContainer.DEFAULT_CUR_PARAM,1);
		int deltaValue = ParamUtil.getInteger(renderRequest, SearchContainer.DEFAULT_DELTA_PARAM,3);
		
		int totalOfPolicyType = policyTypeMasterLocalService.getPolicyTypeMastersCount();
	    int totalPageContainer = (totalOfPolicyType + deltaValue - 1) / deltaValue;
	    
	    if (curValue > totalPageContainer) {
	        curValue = totalPageContainer;
	    }
		
		int start = (curValue - 1) * deltaValue;
	    int end = start + deltaValue;
		
	    policyTypeMasters = policyTypeMasterLocalService.getPolicyTypeMasters(start, end);
		
		renderRequest.setAttribute(AxPolicyTypeMasterWebPortletConstants.POLICYTYPE_GET, policyTypeMasters);
		renderRequest.setAttribute(AxPolicyTypeMasterWebPortletConstants.POLICYTYPE_TOTAL, PolicyTypeMasterLocalServiceUtil.getPolicyTypeMastersCount());
		renderRequest.setAttribute(AxPolicyTypeMasterWebPortletConstants.POLICYTYPE_MASTER, policyTypeMasters);
		
		
		return AxPolicyTypeMasterWebPortletConstants.LIST_POLICY_TYPE_MASTER;
	}

}
