package com.ax.hrms.master.policy.type.web.action;

import com.ax.hrms.master.education.level.web.action.DeleteEducationLevelMasterMVCActionCommand;
import com.ax.hrms.master.service.PolicyTypeMasterLocalService;
import com.ax.hrms.master.web.constants.AxPolicyTypeMasterWebPortletConstants;
import com.ax.hrms.master.web.constants.AxPolicyTypeMasterWebPortletKeys;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;


/**

Author: Himanshu Jha
*/

@Component(immediate = true, property = {
		"javax.portlet.name="+AxPolicyTypeMasterWebPortletKeys.AXHRMS_POLICYTYPEMASTER_WEB_PORTLET_KEYS,
        "mvc.command.name=/deletePolicyType"
}, service = MVCActionCommand.class)

public class DeletePolicyTypeMasterMVCActionCommand extends BaseMVCActionCommand {
	
	private Log log=LogFactoryUtil.getLog(DeleteEducationLevelMasterMVCActionCommand.class);
	
	@Reference
	PolicyTypeMasterLocalService policyTypeMasterLocalService;

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		
		Long policyTypeMasterId = ParamUtil.getLong(actionRequest, AxPolicyTypeMasterWebPortletConstants.POLICYTYPE_MASTER_ID);
		
		
		try {
			
			policyTypeMasterLocalService.deletePolicyTypeMaster(policyTypeMasterId);
			
			SessionMessages.add(actionRequest, AxPolicyTypeMasterWebPortletConstants.POLICY_TYPE_DELETED);

			
		}catch (Exception e) {
			SessionMessages.add(actionRequest, AxPolicyTypeMasterWebPortletConstants.POLICY_TYPE_DELETED_ERROR);
			log.error(e.getMessage());
		}
	}

}
