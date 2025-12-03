package com.ax.hrms.master.leave.policy.web.action;

import com.ax.hrms.master.model.LeavePolicyMaster;
import com.ax.hrms.master.model.LeaveTypeMaster;
import com.ax.hrms.master.service.LeavePolicyMasterLocalService;
import com.ax.hrms.master.service.LeaveTypeMasterLocalService;
import com.ax.hrms.master.web.constants.AxLeavePolicyMasterWebPortletConstants;
import com.ax.hrms.master.web.constants.AxLeavePolicyMasterWebPortletKeys;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.ParamUtil;

import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
	    immediate = true,
	    property = {
	       "javax.portlet.name=" + AxLeavePolicyMasterWebPortletKeys.AXHRMS_LEAVE_POLICY_MASTER_WEB_PORTLET_KEY,
	       "mvc.command.name=/fetchLeavePolicy"
	    },
	    service = MVCRenderCommand.class
	)

public class FetchLeavePolicyMasterMVCRenderCommand implements MVCRenderCommand {

	private Log log = LogFactoryUtil.getLog(FetchLeavePolicyMasterMVCRenderCommand.class);
	
	@Reference
	LeavePolicyMasterLocalService leavePolicyMasterLocalService;
	
	@Reference
	LeaveTypeMasterLocalService leaveTypeMasterLocalService;
	
	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		
		
		List<LeaveTypeMaster> leaveTypeMasterList = leaveTypeMasterLocalService.getLeaveTypeMasters(-1, -1);
		renderRequest.setAttribute(AxLeavePolicyMasterWebPortletConstants.LEAVE_TYPE_MASTER_LIST, leaveTypeMasterList);
		
		Long leavePolicyMasterId = ParamUtil.getLong(renderRequest,AxLeavePolicyMasterWebPortletConstants.LEAVE_POLICY_MASTER_ID);	
		try {
			LeavePolicyMaster getLeavePolicyMaster=leavePolicyMasterLocalService.getLeavePolicyMaster(leavePolicyMasterId);
			renderRequest.setAttribute("getLeavePolicyMaster", getLeavePolicyMaster);
		} catch (PortalException e) {
			log.error(e.getMessage());
		}
		return AxLeavePolicyMasterWebPortletConstants.ADD_LEAVE_POLICY_MASTER_JSP;
	}

}
