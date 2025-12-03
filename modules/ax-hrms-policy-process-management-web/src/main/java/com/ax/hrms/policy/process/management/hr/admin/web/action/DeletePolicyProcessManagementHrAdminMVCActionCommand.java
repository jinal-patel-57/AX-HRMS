package com.ax.hrms.policy.process.management.hr.admin.web.action;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.ax.hrms.policy.process.management.web.constants.AxHrmsPolicyProcessManagementHrAdminWebPortletKeys;
import com.ax.hrms.policy.process.management.web.constants.AxHrmsPolicyProcessManagementWebPortletConstants;
import com.ax.hrms.service.PolicyLocalService;
import com.liferay.document.library.kernel.service.DLAppLocalServiceUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;

/**

Author: himanshu Jha
*/
@Component(
		immediate = true,
		property = {
			"javax.portlet.name="+AxHrmsPolicyProcessManagementHrAdminWebPortletKeys.AXHRMSPOLICYPROCESSMANAGEMENTHRADMINWEB,
			"mvc.command.name=/deletePolicy"
		},
		service = MVCActionCommand.class
	)

public class DeletePolicyProcessManagementHrAdminMVCActionCommand extends BaseMVCActionCommand {
	
	private Log log = LogFactoryUtil.getLog(DeletePolicyProcessManagementHrAdminMVCActionCommand.class);
	
	@Reference
	PolicyLocalService policyLocalService;

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		
		long policyId = ParamUtil.getLong(actionRequest,AxHrmsPolicyProcessManagementWebPortletConstants.Policy_Id_Policy_Process_Management);
		try {
			DLAppLocalServiceUtil.deleteFileEntry(policyLocalService.getPolicy(policyId).getPolicyDocumentId());
			policyLocalService.deletePolicy(policyId);
			
			SessionMessages.add(actionRequest, AxHrmsPolicyProcessManagementWebPortletConstants.DELETED_KEY);
	
		}catch (Exception e) {
			SessionMessages.add(actionRequest, AxHrmsPolicyProcessManagementWebPortletConstants.ERROR_KEY);
			log.error(e.getMessage());
		}
		int selectedYear = ParamUtil.getInteger(actionRequest, AxHrmsPolicyProcessManagementWebPortletConstants.Selected_Year_Policy_Process_Management);
		
		if (selectedYear!=0) {
			actionRequest.setAttribute(AxHrmsPolicyProcessManagementWebPortletConstants.Selected_Year_Policy_Process_Management, selectedYear);
		}

		actionResponse.sendRedirect(ParamUtil.getString(actionRequest,AxHrmsPolicyProcessManagementWebPortletConstants.BACK_URL));

	}

}
