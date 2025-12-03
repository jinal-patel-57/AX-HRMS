package com.ax.hrms.policy.process.management.hr.admin.web.action;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.ax.hrms.common.api.api.AxHrmsCommonApi;
import com.ax.hrms.master.service.PolicyTypeMasterLocalService;
import com.ax.hrms.model.Policy;
import com.ax.hrms.model.RolePolicies;
import com.ax.hrms.policy.process.management.hr.admin.web.dto.PolicyDto;
import com.ax.hrms.policy.process.management.web.constants.AxHrmsPolicyProcessManagementHrAdminWebPortletKeys;
import com.ax.hrms.policy.process.management.web.constants.AxHrmsPolicyProcessManagementWebPortletConstants;
import com.ax.hrms.service.PolicyLocalService;
import com.ax.hrms.service.RolePoliciesLocalService;
import com.liferay.document.library.kernel.service.DLAppLocalServiceUtil;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.PortletURLUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.util.ParamUtil;


@Component(
		immediate = true,
		property = {
			"javax.portlet.name="+AxHrmsPolicyProcessManagementHrAdminWebPortletKeys.AXHRMSPOLICYPROCESSMANAGEMENTHRADMINWEB,
			"mvc.command.name=/",
			"mvc.command.name=/fetchDataWithYears"
		},
		service = MVCRenderCommand.class
	)

public class ListPolicyProcessManagementHrAdminMVCRenderCommand implements MVCRenderCommand {
	private static final  Log log = LogFactoryUtil.getLog(ListPolicyProcessManagementHrAdminMVCRenderCommand.class);
	
	@Reference
	private PolicyTypeMasterLocalService policyTypeMasterLocalService;
	
	@Reference
	private PolicyLocalService policyLocalService;
	
	@Reference
	private RolePoliciesLocalService rolePoliciesLocalService;
	
	@Reference
	private AxHrmsCommonApi axHrmsCommonApi;

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		
		try {
			
			List<Policy> policy = null;

			int currentYear = Calendar.getInstance().get(Calendar.YEAR);
			int selectedYear = ParamUtil.getInteger(renderRequest, AxHrmsPolicyProcessManagementWebPortletConstants.Selected_Year_Policy_Process_Management);
		        if(selectedYear != 0) {
		        	policy = policyLocalService.findByYear(selectedYear);
		        }else {
		        	selectedYear = currentYear;
		        	policy = policyLocalService.findByYear(Calendar.getInstance().get(Calendar.YEAR));

		        }
				

			PortletURL iteratorURL = PortletURLUtil.getCurrent(renderRequest, renderResponse);
			SearchContainer<PolicyDto> policySearchContainer = new SearchContainer<>(renderRequest, iteratorURL, null, StringPool.BLANK);
			
			policySearchContainer.setResultsAndTotal(getPolicyDtoList(policy));

			renderRequest.setAttribute(AxHrmsPolicyProcessManagementWebPortletConstants.Policy_Search_Container_Policy_Process_Management, policySearchContainer);

		        
		        List<Integer> policyYears = policyLocalService.getAllYear();
		        
		        Collections.sort(policyYears);

		        renderRequest.setAttribute(AxHrmsPolicyProcessManagementWebPortletConstants.Current_Year_Policy_Process_Management, Calendar.getInstance().get(Calendar.YEAR));
		        renderRequest.setAttribute(AxHrmsPolicyProcessManagementWebPortletConstants.SELECT_YEAR_Policy_Process_Management, selectedYear);
		        renderRequest.setAttribute(AxHrmsPolicyProcessManagementWebPortletConstants.Policy_Years_List_Policy_Process_Management, policyYears);

		}catch(Exception e) {
			log.error("ListPolicyProcessManagementHrAdminMVCRenderCommand >>> "+ e.getMessage() );
		}
		
		return AxHrmsPolicyProcessManagementWebPortletConstants.List_Policy_Process_Management_Hr_Admin;
	}

	public List<PolicyDto> getPolicyDtoList(List<Policy> policyList) throws PortalException {
		List<PolicyDto> policyDtoList = new ArrayList<>();
		
		for(Policy policy : policyList) {
			PolicyDto policyDto = new PolicyDto();
			policyDto.setDate(axHrmsCommonApi.setDateFormat(policy.getApplicableDate()));
			policyDto.setPolicyId(policy.getPolicyId());
			policyDto.setPolicyName(policy.getPolicyName());
			policyDto.setPolicyTypeName(policyTypeMasterLocalService.getPolicyTypeMaster(policy.getPolicyTypeId()).getPolicyType());
			policyDto.setDescription(policy.getPolicyDescription());
			policyDto.setStatus(policy.getStatus());
			policyDto.setYear(policy.getYear());

			List<RolePolicies> rolePolicies = rolePoliciesLocalService.findByPolicyId(policy.getPolicyId());
			List<String> roleList = new ArrayList<>();
			for(RolePolicies role : rolePolicies) {
				roleList.add(RoleLocalServiceUtil.getRole(role.getRoleId()).getName());
			}
			policyDto.setRoleNameList(roleList);
			policyDto.setFile(DLAppLocalServiceUtil.getFileEntry(policy.getPolicyDocumentId()));
			policyDtoList.add(policyDto);
			
		}
		return policyDtoList;
	}

}
