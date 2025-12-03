package com.ax.hrms.policy.process.management.hr.admin.web.action;

import com.ax.hrms.master.model.PolicyTypeMaster;
import com.ax.hrms.master.service.PolicyTypeMasterLocalService;
import com.ax.hrms.model.Policy;
import com.ax.hrms.model.RolePolicies;
import com.ax.hrms.policy.process.management.web.constants.AxHrmsPolicyProcessManagementHrAdminWebPortletKeys;
import com.ax.hrms.policy.process.management.web.constants.AxHrmsPolicyProcessManagementWebPortletConstants;
import com.ax.hrms.service.PolicyLocalService;
import com.ax.hrms.service.RolePoliciesLocalService;
import com.liferay.document.library.kernel.service.DLAppService;
import com.liferay.document.library.kernel.service.DLFileEntryLocalService;
import com.liferay.document.library.kernel.util.DLUtil;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.File;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**

Author: himanshu Jha
*/
@Component(
		immediate = true,
		property = {
			"javax.portlet.name="+AxHrmsPolicyProcessManagementHrAdminWebPortletKeys.AXHRMSPOLICYPROCESSMANAGEMENTHRADMINWEB,
			"mvc.command.name=/fetchPolicy"
		},
		service = MVCRenderCommand.class
	)

public class FetchPolicyProcessManagementHrAdminMVCRenderCommand implements MVCRenderCommand{

	
	@Reference
    PolicyLocalService policyLocalService;
	
    @Reference
    PolicyTypeMasterLocalService policyTypeMasterLocalService;
    
	@Reference
    DLFileEntryLocalService dlFileEntryLocalService;
	
    @Reference
    DLAppService dlAppLocalService;
    
    @Reference
    RolePoliciesLocalService rolePoliciesLocalService;
    
    private static final Log log = LogFactoryUtil.getLog(FetchPolicyProcessManagementHrAdminMVCRenderCommand.class);
    
    @Override
    public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
        ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);

        long policyId = ParamUtil.getLong(renderRequest, AxHrmsPolicyProcessManagementWebPortletConstants.Policy_Id_Policy_Process_Management, AxHrmsPolicyProcessManagementWebPortletConstants.Long_Default_Value_Policy_Process_Management);
        Policy policy = policyLocalService.fetchPolicy(policyId);

        long policyTypeId = policy.getPolicyTypeId();

        String policyType = null;
        try {
            policyType = policyTypeMasterLocalService.getPolicyTypeMaster(policyTypeId).getPolicyType();
        } catch (PortalException e1) {
            e1.printStackTrace();
        }

        String filePreviewUrl = AxHrmsPolicyProcessManagementWebPortletConstants.Empty_Policy_process_Management;
        String fileName = AxHrmsPolicyProcessManagementWebPortletConstants.Empty_Policy_process_Management;
        

        try {
            if (policy.getPolicyDocumentId() > 0) {
                FileEntry fileEntry = dlAppLocalService.getFileEntry(policy.getPolicyDocumentId());
                filePreviewUrl = DLUtil.getPreviewURL(fileEntry, fileEntry.getFileVersion(), themeDisplay, StringPool.BLANK);
                fileName = fileEntry.getFileName();
            }
        } catch (PortalException e) {
            log.error("FetchPolicyMVCRenderCommand >>> render ::: Exception is: " + e.getMessage());
        }

        List<PolicyTypeMaster> policyTypes = policyTypeMasterLocalService.getPolicyTypeMasters(-1,-1);
        int year = policy.getYear();

        
        
        renderRequest.setAttribute(AxHrmsPolicyProcessManagementWebPortletConstants.Upload_Documents_Policy_Process_Management, fileName);
        
       
        
		List<Role> roles = RoleLocalServiceUtil.getRoles(-1, -1);

        
        List<RolePolicies> rolepoliciesList = rolePoliciesLocalService.findByPolicyId(policyId);
        List<Integer> policyYear = policyLocalService.getAllYear();
        
        
        renderRequest.setAttribute(AxHrmsPolicyProcessManagementWebPortletConstants.ROLE_NAME, roles);

        renderRequest.setAttribute(AxHrmsPolicyProcessManagementWebPortletConstants.ROLE_POLICIES_ID, getRolePoliciesId(rolepoliciesList));
        renderRequest.setAttribute(AxHrmsPolicyProcessManagementWebPortletConstants.Year_Policy_Process_Management, year);
        renderRequest.setAttribute(AxHrmsPolicyProcessManagementWebPortletConstants.Policy_Types_Policy_Process_Management, policyTypes);
        renderRequest.setAttribute(AxHrmsPolicyProcessManagementWebPortletConstants.Url_Policy_Process_Management, filePreviewUrl);
        renderRequest.setAttribute(AxHrmsPolicyProcessManagementWebPortletConstants.File_Name_Policy_Process_Management, fileName);
        renderRequest.setAttribute(AxHrmsPolicyProcessManagementWebPortletConstants.Policy_Policy_Process_Management, policy);
        renderRequest.setAttribute(AxHrmsPolicyProcessManagementWebPortletConstants.Current_Policy_Policy_Process_Management, policyType);
		renderRequest.setAttribute(AxHrmsPolicyProcessManagementWebPortletConstants.Policy_Year_Policy_Process_Management, policyYear);


        return AxHrmsPolicyProcessManagementWebPortletConstants.Add_Edit_Policy_Process_Management;
    }

    private String getRolePoliciesId(List<RolePolicies> rolepoliciesList) {
    	StringBuilder rolePoliciesId = new StringBuilder();
    	 int i=1;
    	
    	for(RolePolicies rolePolicy : rolepoliciesList) {
    		rolePoliciesId.append(rolePolicy.getRoleId());
    		 if(i != rolepoliciesList.size()){
    			 rolePoliciesId.append(",");
			 }
			 i++;
    		
    		
    	}
    	return rolePoliciesId.toString();
    	
    	
    }


	
}
