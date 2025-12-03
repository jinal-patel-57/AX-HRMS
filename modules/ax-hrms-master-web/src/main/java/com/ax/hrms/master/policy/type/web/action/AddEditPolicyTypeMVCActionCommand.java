package com.ax.hrms.master.policy.type.web.action;

import com.ax.hrms.master.exception.NoSuchPolicyTypeMasterException;
import com.ax.hrms.master.model.PolicyTypeMaster;
import com.ax.hrms.master.service.PolicyTypeMasterLocalService;
import com.ax.hrms.master.web.constants.AxPolicyTypeMasterWebPortletConstants;
import com.ax.hrms.master.web.constants.AxPolicyTypeMasterWebPortletKeys;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.Date;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;


/**

Author: Himanshu Jha
*/

@Component(
	    immediate = true,
	    property = {
	        "javax.portlet.name="+ AxPolicyTypeMasterWebPortletKeys.AXHRMS_POLICYTYPEMASTER_WEB_PORTLET_KEYS,
	        "mvc.command.name=/addEditPolicyType"
	    },
	    service = MVCActionCommand.class
)

public class AddEditPolicyTypeMVCActionCommand extends BaseMVCActionCommand {
		
	@Reference
	PolicyTypeMasterLocalService policyTypeMasterLocalService;


	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		
		 String policyTypeName = ParamUtil.getString(actionRequest, AxPolicyTypeMasterWebPortletConstants.POLICYTYPE_NAME, null);
		 long policyTypeMasterId = ParamUtil.getLong(actionRequest, AxPolicyTypeMasterWebPortletConstants.POLICYTYPE_MASTER_ID, AxPolicyTypeMasterWebPortletConstants.DEFAULT_LONG_VALUE);

		 if (policyTypeMasterId <= 0) {
            if (isLevelMasterAvailable(policyTypeName, 0)) {
                PolicyTypeMaster policyTypeMaster = policyTypeMasterLocalService.createPolicyTypeMaster(CounterLocalServiceUtil.increment(PolicyTypeMaster.class.getName()));

                
                ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
                policyTypeMaster.setPolicyType(policyTypeName);
                policyTypeMaster.setCompanyId(themeDisplay.getCompanyId());
                policyTypeMaster.setCreatedBy(themeDisplay.getUserId());
                policyTypeMaster.setGroupId(themeDisplay.getCompanyGroupId());
                policyTypeMaster.setCreateDate(new Date());
                policyTypeMaster.setModifiedDate(new Date());
                policyTypeMasterLocalService.addPolicyTypeMaster(policyTypeMaster);
                
                SessionMessages.add(actionRequest, AxPolicyTypeMasterWebPortletConstants.POLICY_TYPE_ADDED);
				}
				else {
					SessionErrors.add(actionRequest, AxPolicyTypeMasterWebPortletConstants.POLICY_TYPE_EXISTS);
					super.hideDefaultErrorMessage(actionRequest);

					actionResponse.setRenderParameter(AxPolicyTypeMasterWebPortletConstants.POLICYTYPE_PATH, AxPolicyTypeMasterWebPortletConstants.FORM_POLICY_TYPE_MASTER);
				}
		 }
		 
        else {
            if (isLevelMasterAvailable(policyTypeName, policyTypeMasterId) && isLevelNameValid(policyTypeName)) {
            	PolicyTypeMaster policyTypeMaster = policyTypeMasterLocalService.getPolicyTypeMaster(policyTypeMasterId);
            	policyTypeMaster.setPolicyType(policyTypeName);
                ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
                policyTypeMaster.setModifiedBy(themeDisplay.getUserId());
                
                policyTypeMasterLocalService.updatePolicyTypeMaster(policyTypeMaster);
				  
		        SessionMessages.add(actionRequest, AxPolicyTypeMasterWebPortletConstants.POLICY_TYPE_UPDATED);
			}
			else {
				SessionErrors.add(actionRequest, AxPolicyTypeMasterWebPortletConstants.POLICY_TYPE_EXISTS);
				super.hideDefaultErrorMessage(actionRequest);
				
				actionResponse.setRenderParameter(AxPolicyTypeMasterWebPortletConstants.POLICYTYPE_PATH, AxPolicyTypeMasterWebPortletConstants.FORM_POLICY_TYPE_MASTER);
			}
        }
    }

    private boolean isLevelMasterAvailable(String policyTypeName, long id) { 
        try {
        	
        	PolicyTypeMaster name = policyTypeMasterLocalService.findByPolicyType(policyTypeName);
        	
        	 return (id>0 && name.getPolicyTypeMasterID() == id);
        } catch (NoSuchPolicyTypeMasterException e) {
            return true;
        }
    }

    private boolean isLevelNameValid(String policyTypeName) { 
        return Validator.isNotNull(policyTypeName) && Validator.isName(policyTypeName);
    }
}