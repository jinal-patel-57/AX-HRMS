package com.ax.hrms.master.leave.policy.web.action;

import com.ax.hrms.master.service.LeavePolicyMasterLocalService;
import com.ax.hrms.master.web.constants.AxDepartmentMasterWebPortletConstants;
import com.ax.hrms.master.web.constants.AxLeavePolicyMasterWebPortletConstants;
import com.ax.hrms.master.web.constants.AxLeavePolicyMasterWebPortletKeys;
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

@Component(
	    immediate = true,
	    property = {
	       "javax.portlet.name=" + AxLeavePolicyMasterWebPortletKeys.AXHRMS_LEAVE_POLICY_MASTER_WEB_PORTLET_KEY,
	       "mvc.command.name=/deleteLeavePolicy"
	    },
	    service = MVCActionCommand.class
	)

public class DeleteLeavePolicyMasterDetailsMVCActionCommand extends BaseMVCActionCommand{

	private Log log=LogFactoryUtil.getLog(DeleteLeavePolicyMasterDetailsMVCActionCommand.class);
	
	@Reference
	LeavePolicyMasterLocalService leavePolicyMasterLocalService;
	
	
	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		Long leavePolicyMasterId = ParamUtil.getLong(actionRequest, AxLeavePolicyMasterWebPortletConstants.LEAVE_POLICY_MASTER_ID);
		
	    try {
	    	leavePolicyMasterLocalService.deleteLeavePolicyMaster(leavePolicyMasterId);
	        SessionMessages.add(actionRequest, AxLeavePolicyMasterWebPortletConstants.LEAVE_POLICY_MASTER_DELETED);
	        actionResponse.sendRedirect(ParamUtil.getString(actionRequest, AxDepartmentMasterWebPortletConstants.ITERATOR_URL));
	    }catch (Exception e) {
	        log.error("Error deleting department: " + e.getMessage(), e);
	    }
	}

}
