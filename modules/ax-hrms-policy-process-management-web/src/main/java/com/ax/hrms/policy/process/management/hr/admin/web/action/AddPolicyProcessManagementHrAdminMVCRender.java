package com.ax.hrms.policy.process.management.hr.admin.web.action;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.ax.hrms.master.model.PolicyTypeMaster;
import com.ax.hrms.master.service.PolicyTypeMasterLocalService;
import com.ax.hrms.policy.process.management.web.constants.AxHrmsPolicyProcessManagementHrAdminWebPortletKeys;
import com.ax.hrms.policy.process.management.web.constants.AxHrmsPolicyProcessManagementWebPortletConstants;
import com.ax.hrms.service.PolicyLocalService;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.util.ParamUtil;

/**

Author: himanshu Jha
*/
@Component(
		immediate = true,
		property = {
			"javax.portlet.name="+AxHrmsPolicyProcessManagementHrAdminWebPortletKeys.AXHRMSPOLICYPROCESSMANAGEMENTHRADMINWEB,
			"mvc.command.name=/addRenderMethod"
		},
		service = MVCRenderCommand.class
	)

public class AddPolicyProcessManagementHrAdminMVCRender implements MVCRenderCommand {
	

	@Reference
	PolicyTypeMasterLocalService policyTypeMasterLocalService;
	
	@Reference
	PolicyLocalService policyLocalService;

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {

		
        List<PolicyTypeMaster> policyTypes = policyTypeMasterLocalService.getPolicyTypeMasters(-1,-1);

		
		List<Integer> policyYear = policyLocalService.getAllYear();

		List<Role> roles = RoleLocalServiceUtil.getRoles(-1, -1);

		// ------------------ Calculate next year end date ------------------
		Calendar cal = Calendar.getInstance();

		cal.add(Calendar.YEAR, 1); // next year
		cal.set(Calendar.MONTH, Calendar.DECEMBER);
		cal.set(Calendar.DAY_OF_MONTH, 31);

		Date nextYearEndDate = cal.getTime();

		// Set attribute for JSP
		renderRequest.setAttribute("nextYearEndDate", nextYearEndDate);




		renderRequest.setAttribute(AxHrmsPolicyProcessManagementWebPortletConstants.ROLE_NAME, roles);
		renderRequest.setAttribute(AxHrmsPolicyProcessManagementWebPortletConstants.Policy_Types_Policy_Process_Management, policyTypes);
		renderRequest.setAttribute(AxHrmsPolicyProcessManagementWebPortletConstants.Policy_Year_Policy_Process_Management, policyYear);
		renderRequest.setAttribute(AxHrmsPolicyProcessManagementWebPortletConstants.Selected_Year_Policy_Process_Management, ParamUtil.getInteger(renderRequest,AxHrmsPolicyProcessManagementWebPortletConstants.Selected_Year_Policy_Process_Management));
		
		return AxHrmsPolicyProcessManagementWebPortletConstants.Add_Edit_Policy_Process_Management;
	}

	
}
