package com.ax.hrms.policy.process.management.hr.admin.web.action;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.ax.hrms.common.api.api.AxHrmsCommonApi;
import com.ax.hrms.exception.NoSuchPolicyException;
import com.ax.hrms.master.model.PolicyTypeMaster;
import com.ax.hrms.master.service.PolicyTypeMasterLocalService;
import com.ax.hrms.model.Policy;
import com.ax.hrms.model.RolePolicies;
import com.ax.hrms.policy.process.management.hr.admin.web.util.PolicyWebUtil;
import com.ax.hrms.policy.process.management.web.constants.AxHrmsPolicyProcessManagementHrAdminWebPortletKeys;
import com.ax.hrms.policy.process.management.web.constants.AxHrmsPolicyProcessManagementWebPortletConstants;
import com.ax.hrms.service.PolicyLocalService;
import com.ax.hrms.service.RolePoliciesLocalService;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.document.library.kernel.model.DLFileEntry;
import com.liferay.document.library.kernel.model.DLFolder;
import com.liferay.document.library.kernel.model.DLVersionNumberIncrease;
import com.liferay.document.library.kernel.service.DLAppLocalServiceUtil;
import com.liferay.document.library.kernel.service.DLAppService;
import com.liferay.document.library.kernel.service.DLFileEntryLocalService;
import com.liferay.document.library.kernel.service.DLFolderLocalService;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.repository.model.Folder;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.MimeTypesUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;

/**
 * 
 * Author: himanshu Jha
 */
@Component(immediate = true, property = {
		"javax.portlet.name="
				+ AxHrmsPolicyProcessManagementHrAdminWebPortletKeys.AXHRMSPOLICYPROCESSMANAGEMENTHRADMINWEB,
		"mvc.command.name="+AxHrmsPolicyProcessManagementWebPortletConstants.ADD_EDIT_POLICY_MANAGEMENT }, service = MVCActionCommand.class)

public class AddEditPolicyProcessManagementHrAdminMVCActionCommand extends BaseMVCActionCommand {

	@Reference
	AxHrmsCommonApi axHrmsCommonApi;

	@Reference
	DLFolderLocalService dlFolderLocalService;

	@Reference
	DLAppService dlAppService;

	@Reference
	PolicyLocalService policyLocalService;

	@Reference
	PolicyTypeMasterLocalService policyTypeMasterLocalService;

	@Reference
	RolePoliciesLocalService rolePoliciesLocalService;
	@Reference
	DLFileEntryLocalService dlFileEntryLocalService;

	private static final Log log = LogFactoryUtil.getLog(AddEditPolicyProcessManagementHrAdminMVCActionCommand.class);

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		super.hideDefaultErrorMessage(actionRequest);
        super.hideDefaultSuccessMessage(actionRequest);
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);

		PolicyWebUtil policyUtil = new PolicyWebUtil(axHrmsCommonApi, dlFolderLocalService, dlAppService,
				policyLocalService, policyTypeMasterLocalService, rolePoliciesLocalService);
		String namespace = PortalUtil.getPortletNamespace(themeDisplay.getPpid());

		long policyId = ParamUtil.getLong(actionRequest,
				AxHrmsPolicyProcessManagementWebPortletConstants.Policy_Id_Policy_Process_Management,
				AxHrmsPolicyProcessManagementWebPortletConstants.Long_Default_Value_Policy_Process_Management);
		Policy policy = policyUtil.setPolicy(actionRequest);



		
		if (policyId == 0) {
			handleNewPolicy(actionRequest, actionResponse, themeDisplay, namespace, policy,true);

		} else {
			handleExistingPolicy(actionRequest, actionResponse, themeDisplay, namespace, policyId, policy);
		}
		

		
		
		
	}
	 private void handleExistingPolicy(ActionRequest actionRequest, ActionResponse actionResponse, ThemeDisplay themeDisplay, String namespace, long policyId, Policy policy) throws IOException {
	        if (isExistCombinationOfLevelAndYear(policy.getPolicyTypeId(), policy.getYear(), policyId)) {
	            handleExistingEntry(actionRequest, actionResponse, policy,false);
	        } else {
	            try {
	            	updatePolicy(actionRequest, themeDisplay, namespace, policyId, policy);
	            	String backURL = ParamUtil.getString(actionRequest,AxHrmsPolicyProcessManagementWebPortletConstants.BACK_URL);
	        		backURL = backURL.replace("SELECTED_YEAR", Integer.toString(policy.getYear()));
	        		
	                actionResponse.sendRedirect(backURL);

	            } catch (Exception exception) {
	                log.error("Exception at update form template: " + exception.getMessage());
	    	        SessionErrors.add(actionRequest, AxHrmsPolicyProcessManagementWebPortletConstants.ERROR_KEY);
	            }
	        }
	    }
	
	private void handleNewPolicy(ActionRequest actionRequest, ActionResponse actionResponse, ThemeDisplay themeDisplay, String namespace, Policy policy,boolean newEntry) throws IOException {
        if (isExistCombinationOfLevelAndYear(policy.getPolicyTypeId(), policy.getYear(), policy.getPolicyId())) {
            handleExistingEntry(actionRequest, actionResponse, policy,newEntry);
        } else {
            try {
                PolicyTypeMaster policyTypeMaster = policyTypeMasterLocalService.fetchPolicyTypeMaster(policy.getPolicyTypeId());
                createFile(namespace, themeDisplay, actionRequest, policyTypeMaster, policy);
                String backURL = ParamUtil.getString(actionRequest,AxHrmsPolicyProcessManagementWebPortletConstants.BACK_URL);
        		backURL = backURL.replace("SELECTED_YEAR", Integer.toString(policy.getYear()));
        		
                actionResponse.sendRedirect(backURL);

            } catch (Exception exception) {
                log.error("Exception at insert form policy: " + exception.getMessage());
				exception.printStackTrace();
    	        SessionErrors.add(actionRequest, AxHrmsPolicyProcessManagementWebPortletConstants.EXISTED_ENTRY_KEY);
            }
        }
    }
	  private void handleExistingEntry(ActionRequest actionRequest, ActionResponse actionResponse,  Policy policy,boolean newEntry) {
	        SessionErrors.add(actionRequest, AxHrmsPolicyProcessManagementWebPortletConstants.EXISTED_ENTRY_KEY);
	        if(!newEntry) {
	        actionRequest.setAttribute(AxHrmsPolicyProcessManagementWebPortletConstants.Policy_Id_Policy_Process_Management, policy.getPolicyId());
	        actionResponse.setRenderParameter(AxHrmsPolicyProcessManagementWebPortletConstants.MVC_RENDER_COMMAND_NAME,AxHrmsPolicyProcessManagementWebPortletConstants.FETCH_POLICY);
	        }
	        else {
	        	actionRequest.setAttribute(AxHrmsPolicyProcessManagementWebPortletConstants.SELECT_YEAR_Policy_Process_Management, policy.getYear());
	        }
	        }
	  public void createFile(String namespace,ThemeDisplay themeDisplay,ActionRequest actionRequest,PolicyTypeMaster policyTypeMaster,Policy policy) throws PortalException{
	        String yearFolderName = AxHrmsPolicyProcessManagementWebPortletConstants.YEAR+policy.getYear();
	        String policyTypeFolderName = policyTypeMaster.getPolicyType();

	        ServiceContext serviceContext = ServiceContextFactory.getInstance(Folder.class.getName(), actionRequest);
	        serviceContext.setAddGroupPermissions(true);
	        serviceContext.setAddGuestPermissions(false);

	        Folder parentFolder = axHrmsCommonApi.createFolder(AxHrmsPolicyProcessManagementWebPortletConstants.POLICY_DOCUMENTS, 0, themeDisplay, serviceContext);
	        Folder yearFolder = axHrmsCommonApi.createFolder(yearFolderName,parentFolder.getFolderId(), themeDisplay, serviceContext);
	        Folder policyTypeFolder = axHrmsCommonApi.createFolder(policyTypeFolderName, yearFolder.getFolderId(),themeDisplay, serviceContext);

	        //Upload System Setup
	        UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(actionRequest);
	        File file = uploadRequest.getFile(namespace
					+ AxHrmsPolicyProcessManagementWebPortletConstants.Upload_Documents_Policy_Process_Management);

			String fileName = uploadRequest.getFileName(namespace
					+ AxHrmsPolicyProcessManagementWebPortletConstants.Upload_Documents_Policy_Process_Management);

	        List<FileEntry> listFileEntries = dlAppService.getFileEntries(policyTypeFolder.getRepositoryId(),policyTypeFolder.getFolderId());
	        addFileEntry(listFileEntries,file,policyTypeFolder,policy,fileName,serviceContext,actionRequest);
	    }
	
	  public void addFileEntry(List<FileEntry> listFileEntries,File file,Folder levelFolder,Policy policy,String fileName,ServiceContext serviceContext,ActionRequest actionRequest){
	        ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
	        try{
	            if(listFileEntries.isEmpty() && file.exists()){

	                FileEntry entry = DLAppLocalServiceUtil.addFileEntry(themeDisplay.getUserId(),
	                        themeDisplay.getScopeGroupId(), levelFolder.getFolderId(), fileName,
	                        MimeTypesUtil.getContentType(file), fileName, StringPool.BLANK, StringPool.BLANK, file,
	                        serviceContext);
	                policy.setPolicyDocumentId(entry.getFileEntryId());
	                policyLocalService.addPolicy(policy);
					setRolePolicy(ParamUtil.getString(actionRequest, AxHrmsPolicyProcessManagementWebPortletConstants.SELECTED_ROLES), themeDisplay, policy.getPolicyId(), true);

	                
	                SessionMessages.add(actionRequest,AxHrmsPolicyProcessManagementWebPortletConstants.ADD_FORM_KEY);
	            }
	        }catch (PortalException exception){
	            log.error("AddEditAppraisalFormTemplateMVCActionCommand >>> addFileEntry ::: Exception is: "+exception.getMessage());
	        }
	    }
	  
	  private void updatePolicy(ActionRequest actionRequest, ThemeDisplay themeDisplay, String namespace, long policyId, Policy  policy) throws PortalException, IOException {
	        
	        Policy tempPolicy = policyLocalService.getPolicy(policyId);
	        PolicyTypeMaster temporalPolicyTypeMaster = policyTypeMasterLocalService.getPolicyTypeMaster(tempPolicy.getPolicyTypeId());
	        PolicyTypeMaster policyTypeMaster = policyTypeMasterLocalService.getPolicyTypeMaster(policy.getPolicyTypeId());

	        String yearFolderName = AxHrmsPolicyProcessManagementWebPortletConstants.YEAR+policy.getYear();
	        String policyTypeFolderName = policyTypeMaster.getPolicyType();
	        
	        ServiceContext serviceContext = ServiceContextFactory.getInstance(Folder.class.getName(), actionRequest);
	        Folder policyTypeFolder = getOrCreateFolderStructure(themeDisplay, yearFolderName, policyTypeFolderName, serviceContext);

	        UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(actionRequest);
	        File file = uploadRequest.getFile(namespace
					+ AxHrmsPolicyProcessManagementWebPortletConstants.Upload_Documents_Policy_Process_Management);

			String fileName = uploadRequest.getFileName(namespace
					+ AxHrmsPolicyProcessManagementWebPortletConstants.Upload_Documents_Policy_Process_Management);

	        String mimeType = MimeTypesUtil.getContentType(file);

	        List<FileEntry> listFileEntries = dlAppService.getFileEntries(policyTypeFolder.getRepositoryId(), policyTypeFolder.getFolderId());

	        Map<String,String> stringProviderMap = new HashMap<>();
	        stringProviderMap.put(AxHrmsPolicyProcessManagementWebPortletConstants.FILENAME,fileName);
	        stringProviderMap.put(AxHrmsPolicyProcessManagementWebPortletConstants.MIMETYPE,mimeType);
	        stringProviderMap.put(AxHrmsPolicyProcessManagementWebPortletConstants.POLICY_TYPE_FOLDER_NAME,policyTypeFolderName);
	        stringProviderMap.put(AxHrmsPolicyProcessManagementWebPortletConstants.YEAR_FOLDER_NAME,yearFolderName);

	        if (!listFileEntries.isEmpty() && file.exists()) {
	            updateFileEntry(themeDisplay, stringProviderMap, file, policy, serviceContext, actionRequest);
	        }
	        if ((tempPolicy.getYear() != policy.getYear()) || tempPolicy.getPolicyTypeId() != policy.getPolicyTypeId()) {
	            moveFileToNewFolder(themeDisplay, tempPolicy, policy, file, serviceContext,temporalPolicyTypeMaster,stringProviderMap);
	        }
	        policyLocalService.updatePolicy(policy);
			setRolePolicy(ParamUtil.getString(actionRequest, AxHrmsPolicyProcessManagementWebPortletConstants.SELECTED_ROLES), themeDisplay, policyId, true);

	        SessionMessages.add(actionRequest, AxHrmsPolicyProcessManagementWebPortletConstants.UPDATE_FORM_KEY);
	        
	    }

	  private Folder getOrCreateFolderStructure(ThemeDisplay themeDisplay, String yearFolderName, String levelFolderName, ServiceContext serviceContext) {
	        Folder parentFolder = axHrmsCommonApi.createFolder(AxHrmsPolicyProcessManagementWebPortletConstants.POLICY_DOCUMENTS, 0, themeDisplay, serviceContext);
	        Folder yearFolder = axHrmsCommonApi.createFolder(yearFolderName, parentFolder.getFolderId(), themeDisplay, serviceContext);
	        return axHrmsCommonApi.createFolder(levelFolderName, yearFolder.getFolderId(), themeDisplay, serviceContext);
	    }
	  private void updateFileEntry(ThemeDisplay themeDisplay, Map<String,String> stringProviderMap, File file, Policy policy, ServiceContext serviceContext, ActionRequest actionRequest) throws PortalException, IOException {
	        String fileName = stringProviderMap.get(AxHrmsPolicyProcessManagementWebPortletConstants.FILENAME);
			String mimeType = stringProviderMap.get(AxHrmsPolicyProcessManagementWebPortletConstants.MIMETYPE);

			FileEntry existingFileEntry = DLAppLocalServiceUtil.getFileEntry(policy.getPolicyDocumentId());

			FileEntry updatedFileEntry = DLAppLocalServiceUtil.updateFileEntry(themeDisplay.getUserId(),
					policyLocalService.getPolicy(policy.getPolicyId()).getPolicyDocumentId(), fileName, mimeType, fileName,
					fileName, existingFileEntry.getDescription(), null, DLVersionNumberIncrease.MAJOR, file,
					null, null, null, serviceContext);

			User user = themeDisplay.getUser();
			user.setPortraitId(updatedFileEntry.getFileEntryId());
			user.setAgreedToTermsOfUse(true);
			UserLocalServiceUtil.updateUser(user);
	        SessionMessages.add(actionRequest, AxHrmsPolicyProcessManagementWebPortletConstants.UPDATE_FORM_KEY);
	    }
	  
	  
	  private void moveFileToNewFolder(ThemeDisplay themeDisplay, Policy tempPolicy, Policy policy, File file, ServiceContext serviceContext,PolicyTypeMaster temporalPolicyTypeMaster,Map<String,String> stringProviderMap) throws PortalException {
	        String fileName = stringProviderMap.get(AxHrmsPolicyProcessManagementWebPortletConstants.FILENAME);
	        String mimeType = stringProviderMap.get(AxHrmsPolicyProcessManagementWebPortletConstants.MIMETYPE);
	        String policyTypeFolderName = stringProviderMap.get(AxHrmsPolicyProcessManagementWebPortletConstants.POLICY_TYPE_FOLDER_NAME);
	        String yearFolderName = stringProviderMap.get(AxHrmsPolicyProcessManagementWebPortletConstants.YEAR_FOLDER_NAME);

	        DLFileEntry currentFile;
	        if (tempPolicy.getPolicyDocumentId() == policy.getPolicyDocumentId()) {
	            if (!dlFileEntryLocalService.fetchDLFileEntry(tempPolicy.getPolicyDocumentId()).getFileName().equals(fileName)) {
	                DLAppLocalServiceUtil.updateFileEntry(themeDisplay.getUserId(), tempPolicy.getPolicyDocumentId(), fileName, mimeType, fileName, null, dlFileEntryLocalService.fetchDLFileEntry(tempPolicy.getPolicyDocumentId()).getDescription(), null, DLVersionNumberIncrease.MAJOR, file, null, null, null, serviceContext);
	            }
	            currentFile = dlFileEntryLocalService.fetchDLFileEntry(tempPolicy.getPolicyDocumentId());
	        } else {
	            currentFile = dlFileEntryLocalService.fetchDLFileEntry(policy.getPolicyDocumentId());
	        }

	        DLFolder dlFolder = getDlFolderByName(0L, themeDisplay,AxHrmsPolicyProcessManagementWebPortletConstants.POLICY_DOCUMENTS, yearFolderName, policyTypeFolderName);
	        currentFile.setFolderId(dlFolder.getFolderId());
	        currentFile.setTreePath(dlFolder.getTreePath());
	        deleteDlFolder(temporalPolicyTypeMaster.getPolicyType(), themeDisplay, 0L, AxHrmsPolicyProcessManagementWebPortletConstants.POLICY_DOCUMENTS, AxHrmsPolicyProcessManagementWebPortletConstants.YEAR + tempPolicy.getYear());
	        dlFileEntryLocalService.updateDLFileEntry(currentFile);
	    }
	  public DLFolder getDlFolderByName(long parentFolderId,ThemeDisplay themeDisplay,String parentFolderName,String yearFolderName,String levelName){
	        DLFolder mainFolder = dlFolderLocalService.fetchFolder(themeDisplay.getScopeGroupId(),parentFolderId,parentFolderName);
	        DLFolder yearDlFolder = dlFolderLocalService.fetchFolder(themeDisplay.getScopeGroupId(),mainFolder.getFolderId(),yearFolderName);
	        return dlFolderLocalService.fetchFolder(themeDisplay.getScopeGroupId(),yearDlFolder.getFolderId(),levelName);
	    }
	    public void deleteDlFolder(String levelFolderName,ThemeDisplay themeDisplay,long parentFolderId,String parentFolderName,String yearFolderName){
	        DLFolder mainFolder = dlFolderLocalService.fetchFolder(themeDisplay.getScopeGroupId(),parentFolderId,parentFolderName);
	        DLFolder yearDlFolder = dlFolderLocalService.fetchFolder(themeDisplay.getScopeGroupId(),mainFolder.getFolderId(),yearFolderName);
	        dlFolderLocalService.deleteDLFolder(dlFolderLocalService.fetchFolder(themeDisplay.getScopeGroupId(), yearDlFolder.getFolderId(), levelFolderName));
	    }
	    public boolean isExistCombinationOfLevelAndYear(long policyTypeMasterId,int year,long policyId){
	    	try {
				Policy policy = policyLocalService.findByPolicyTypeIdAndPolicyYear(policyTypeMasterId,year);
				if(policy.getPolicyId()==policyId) {
					return false;
				}
			} catch (NoSuchPolicyException exception) {
				return false;
			}
			return true;
	    }
	    private void setRolePolicy(String rolesId, ThemeDisplay themeDisplay, long policyId, boolean isUpdate)
				throws PortalException {

			String[] roleIdArr = rolesId.split(StringPool.COMMA);
			List<Long> newRolePoliciesList = new ArrayList<>();
			List<Long> oldRolePoliciesIdList = new ArrayList<>();
			List<RolePolicies> oldRolePolicyList;

			for (String roleId : roleIdArr) {
				if (!isUpdate) {

					RolePolicies rolePolicy = rolePoliciesLocalService
							.createRolePolicies(CounterLocalServiceUtil.increment(RolePolicies.class.getName()));
					rolePolicy.setCompanyId(themeDisplay.getCompanyId());
					rolePolicy.setCreateDate(new Date());
					rolePolicy.setCreatedBy(themeDisplay.getUserId());
					rolePolicy.setModifiedBy(themeDisplay.getUserId());
					rolePolicy.setModifiedDate(new Date());
					rolePolicy.setRoleId(Long.parseLong(roleId));
					rolePolicy.setGroupId(themeDisplay.getScopeGroupId());
					rolePolicy.setPolicyId(policyId);
				} 
				else {
					newRolePoliciesList.add(Long.parseLong(roleId));
					
				}
			}
			oldRolePolicyList = rolePoliciesLocalService.findByPolicyId(policyId);
			if (isUpdate) {
				for (RolePolicies rolePolicy : oldRolePolicyList) {
					oldRolePoliciesIdList.add(rolePolicy.getRoleId());

				}
			
			List<Long> removeRoleId = new ArrayList<>(oldRolePoliciesIdList);
			oldRolePoliciesIdList.removeAll(newRolePoliciesList);
			// delete old role
			for (Long roleId : oldRolePoliciesIdList) {
				RolePolicies rolePolicy = rolePoliciesLocalService.findByPolicyIdAndRoleId(policyId, roleId);
				
				rolePoliciesLocalService.deleteRolePolicies(rolePolicy);
			}
			
			
			newRolePoliciesList.removeAll(removeRoleId);
			for (Long roleId : newRolePoliciesList) {
				RolePolicies rolePolicy = rolePoliciesLocalService
						.createRolePolicies(CounterLocalServiceUtil.increment(RolePolicies.class.getName()));
				rolePolicy.setCompanyId(themeDisplay.getCompanyId());
				rolePolicy.setCreateDate(new Date());
				rolePolicy.setCreatedBy(themeDisplay.getUserId());
				rolePolicy.setModifiedBy(themeDisplay.getUserId());
				rolePolicy.setModifiedDate(new Date());
				rolePolicy.setRoleId(roleId);
				rolePolicy.setGroupId(themeDisplay.getScopeGroupId());
				rolePolicy.setPolicyId(policyId);
				rolePoliciesLocalService.addRolePolicies(rolePolicy);
			}
			
			}
		}

	   
}