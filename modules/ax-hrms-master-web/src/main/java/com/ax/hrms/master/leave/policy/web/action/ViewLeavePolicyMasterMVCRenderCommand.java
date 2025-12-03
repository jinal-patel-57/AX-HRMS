package com.ax.hrms.master.leave.policy.web.action;


import com.ax.hrms.master.leave.policy.web.dto.LeavePolicyMasterDetails;

import com.ax.hrms.master.model.LeavePolicyMaster;
import com.ax.hrms.master.service.LeavePolicyMasterLocalService;
import com.ax.hrms.master.service.LeaveTypeMasterLocalService;
import com.ax.hrms.master.web.constants.AxLeavePolicyMasterWebPortletConstants;
import com.ax.hrms.master.web.constants.AxLeavePolicyMasterWebPortletKeys;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.ParamUtil;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, property = {
		"javax.portlet.name=" + AxLeavePolicyMasterWebPortletKeys.AXHRMS_LEAVE_POLICY_MASTER_WEB_PORTLET_KEY,
		"mvc.command.name=/viewLeavePolicy"
},
service = MVCRenderCommand.class)
public class ViewLeavePolicyMasterMVCRenderCommand implements MVCRenderCommand{

	@Reference
	LeavePolicyMasterLocalService leavePolicyMasterLocalService;
	
	@Reference
	LeaveTypeMasterLocalService leaveTypeMasterLocalService;
	
	private Log log = LogFactoryUtil.getLog(ViewLeavePolicyMasterMVCRenderCommand.class);
	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {

		long leavePolicyMasterId = ParamUtil.getLong(renderRequest, AxLeavePolicyMasterWebPortletConstants.LEAVE_POLICY_MASTER_ID);
		
		try {
			LeavePolicyMaster leavePolicyMasterRecord  =leavePolicyMasterLocalService.getLeavePolicyMaster(leavePolicyMasterId);
			LeavePolicyMasterDetails leavePolicyMasterDetails=new LeavePolicyMasterDetails();
			leavePolicyMasterDetails.setAccrualRate((int)leavePolicyMasterRecord.getAccrualRate());
			leavePolicyMasterDetails.setCarryForward(leavePolicyMasterRecord.getIsCarryForward());
			leavePolicyMasterDetails.setLeaveTypeName(leaveTypeMasterLocalService.getLeaveTypeMaster(leavePolicyMasterRecord.getLeaveTypeMasterId()).getLeaveTypeName());
			leavePolicyMasterDetails.setDescription(leavePolicyMasterRecord.getDescription());
			leavePolicyMasterDetails.setMaximumBalance(leavePolicyMasterRecord.getMaximumBalance());
			leavePolicyMasterDetails.setCheckMax(leavePolicyMasterRecord.getIsCheckMax());
			leavePolicyMasterDetails.setYearOfPolicy(leavePolicyMasterRecord.getYearOfPolicy());
			leavePolicyMasterDetails.setIsApplicableFloater(leavePolicyMasterRecord.getIsApplicableFloater());
			leavePolicyMasterDetails.setContinous(leavePolicyMasterRecord.getIsContinuous());
			leavePolicyMasterDetails.setEligibleAfterMonths(leavePolicyMasterRecord.getEligibleAfterMonths());
			
			renderRequest.setAttribute(AxLeavePolicyMasterWebPortletConstants.GET_LEAVE_POLICY_MASTER_RECORD, leavePolicyMasterDetails);
		} catch (Exception e) {
			log.error(e.getMessage());
		} 
		return AxLeavePolicyMasterWebPortletConstants.VIEW_LEAVE_POLICY_MASTER_JSP;
	}

}
