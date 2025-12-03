package com.ax.hrms.policy.process.management.hr.admin.web.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.portlet.ActionRequest;

import org.osgi.service.component.annotations.Reference;

import com.ax.hrms.common.api.api.AxHrmsCommonApi;
import com.ax.hrms.exception.NoSuchPolicyException;
import com.ax.hrms.master.exception.NoSuchPolicyTypeMasterException;
import com.ax.hrms.master.service.PolicyTypeMasterLocalService;
import com.ax.hrms.model.Policy;
import com.ax.hrms.model.RolePolicies;
import com.ax.hrms.policy.process.management.web.constants.AxHrmsPolicyProcessManagementWebPortletConstants;
import com.ax.hrms.service.PolicyLocalService;
import com.ax.hrms.service.RolePoliciesLocalService;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.document.library.kernel.service.DLAppService;
import com.liferay.document.library.kernel.service.DLFolderLocalService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;

public class PolicyWebUtil {
	private static final Log log = LogFactoryUtil.getLog(PolicyWebUtil.class);

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
	

	public PolicyWebUtil(AxHrmsCommonApi axHrmsCommonApi, DLFolderLocalService dlFolderLocalService,
			DLAppService dlAppService, PolicyLocalService policyLocalService,
			PolicyTypeMasterLocalService policyTypeMasterLocalService,
			RolePoliciesLocalService rolePoliciesLocalService) {
		super();
		this.axHrmsCommonApi = axHrmsCommonApi;
		this.dlFolderLocalService = dlFolderLocalService;
		this.dlAppService = dlAppService;
		this.policyLocalService = policyLocalService;
		this.policyTypeMasterLocalService = policyTypeMasterLocalService;
		this.rolePoliciesLocalService = rolePoliciesLocalService;
	}

	public boolean isExistCombinationOfLevelAndYear(long policyTypeMasterId, int year,long policyId) {
		try {
			Policy policy = policyLocalService.findByPolicyTypeIdAndPolicyYear(policyTypeMasterId, year);
			if(policy.getPolicyId()==policyId) {
				return false;
			}
		} catch (NoSuchPolicyException exception) {
			log.info("AddEditPolicyMVCActionCommand >>> checkCombinationOfPolicyTypeAndYear ::: Policy Added...");
			return false;
		}
		return true;
	}

	public Policy setPolicy(ActionRequest actionRequest) throws NoSuchPolicyTypeMasterException, ParseException {
		

		Policy policy = null;

		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		String policyName = ParamUtil.getString(actionRequest,
				AxHrmsPolicyProcessManagementWebPortletConstants.Policy_Name_Policy_Process_Management);

		String policyDesc = ParamUtil.getString(actionRequest,
				AxHrmsPolicyProcessManagementWebPortletConstants.Policy_Description_Policy_Process_Management);

		String status = ParamUtil.getString(actionRequest,
				AxHrmsPolicyProcessManagementWebPortletConstants.Policy_Status_Policy_Process_Management);

		String enteredDate = ParamUtil.getString(actionRequest,
				AxHrmsPolicyProcessManagementWebPortletConstants.Policy_Applicable_Date_Policy_Process_Management,
				null);

		int year = ParamUtil.getInteger(actionRequest,
				AxHrmsPolicyProcessManagementWebPortletConstants.Policy_Year_Policy_Process_Management);

		SimpleDateFormat dateFormat = new SimpleDateFormat(
				AxHrmsPolicyProcessManagementWebPortletConstants.Policy_Date_Format_Policy_Process_Management);

		Date date = dateFormat.parse(enteredDate);

		long policyTypeMasterId = ParamUtil.getLong(actionRequest,AxHrmsPolicyProcessManagementWebPortletConstants.Selected_Policy_Type_Policy_Process_Management);
		long policyId = ParamUtil.getLong(actionRequest,
				AxHrmsPolicyProcessManagementWebPortletConstants.Policy_Id_Policy_Process_Management, 0L);


		try {
			if (policyId == 0) {
				policy = policyLocalService.createPolicy(CounterLocalServiceUtil.increment(Policy.class.getName()));

				policy.setPolicyName(policyName);
				policy.setPolicyDescription(policyDesc);
				policy.setYear(year);
				policy.setStatus(status.equals(
						AxHrmsPolicyProcessManagementWebPortletConstants.Active_Status_Policy_Process_Management));
				policy.setPolicyTypeId(policyTypeMasterId);
				policy.setApplicableDate(date);

				policy.setCompanyId(themeDisplay.getCompanyId());
				policy.setCreatedBy(themeDisplay.getUserId());
				policy.setGroupId(themeDisplay.getCompanyGroupId());
				policy.setCreateDate(new Date());
				policy.setModifiedDate(new Date());

			} else {

				policy = policyLocalService.fetchPolicy(policyId);

				policy.setPolicyName(policyName);
				policy.setPolicyDescription(policyDesc);
				policy.setYear(year);
				policy.setStatus(status.equals(
						AxHrmsPolicyProcessManagementWebPortletConstants.Active_Status_Policy_Process_Management));
				policy.setPolicyTypeId(policyTypeMasterId);
				policy.setApplicableDate(date);

				policy.setGroupId(themeDisplay.getCompanyGroupId());
				policy.setModifiedDate(new Date());

			}
		} catch (Exception exception) {
			log.error("AddEditPolicyMVCActionCommand >>> setPolicyData ::: PortalException Occur"+ exception.getMessage());
		}
		return policy;
	}
	
	private void setRolePolicy(String rolesId, ThemeDisplay themeDisplay, long policyId, boolean isUpdate)
			throws PortalException {

		String[] roleIdArr = rolesId.split(",");
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
				rolePoliciesLocalService.addRolePolicies(rolePolicy);
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

	
	
