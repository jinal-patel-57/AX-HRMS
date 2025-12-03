package com.ax.hrms.master.leave.policy.web.action;

import com.ax.hrms.master.leave.policy.web.dto.LeavePolicyMasterDetails;

import com.ax.hrms.master.model.LeavePolicyMaster;
import com.ax.hrms.master.service.LeavePolicyMasterLocalService;
import com.ax.hrms.master.service.LeavePolicyMasterLocalServiceUtil;
import com.ax.hrms.master.service.LeaveTypeMasterLocalService;

import com.ax.hrms.master.web.constants.AxLeavePolicyMasterWebPortletConstants;
import com.ax.hrms.master.web.constants.AxLeavePolicyMasterWebPortletKeys;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.ParamUtil;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, property = {
		"javax.portlet.name=" + AxLeavePolicyMasterWebPortletKeys.AXHRMS_LEAVE_POLICY_MASTER_WEB_PORTLET_KEY,
		"mvc.command.name=/" }, service = MVCRenderCommand.class)
public class ListLeavePolicyMasterMVCRenderCommand implements MVCRenderCommand {

	@Reference
	LeaveTypeMasterLocalService leaveTypeMasterLocalService;

	@Reference
	LeavePolicyMasterLocalService leavePolicyMasterLocalService;

	private Log log = LogFactoryUtil.getLog(ListLeavePolicyMasterMVCRenderCommand.class);

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		try {
			int currentPage = ParamUtil.getInteger(renderRequest, SearchContainer.DEFAULT_CUR_PARAM, 1);
	        int delta = ParamUtil.getInteger(renderRequest, SearchContainer.DEFAULT_DELTA_PARAM, 5);

	        int totalRecords = LeavePolicyMasterLocalServiceUtil.getLeavePolicyMastersCount();
	        int totalPages = (totalRecords + delta - 1) / delta;
	        
	        if (currentPage > totalPages) {
	            currentPage = totalPages;
	        }
	        
	        int start = (currentPage - 1) * delta;
	        int end = start + delta;
	        List<LeavePolicyMasterDetails> leavePolicyMasterDetails = setLeavePolicyMasterDetails(leavePolicyMasterLocalService.getLeavePolicyMasters(start, end));
	        
			renderRequest.setAttribute(AxLeavePolicyMasterWebPortletConstants.LEAVE_POLICY_MASTER_DETAILS_LIST,leavePolicyMasterDetails);
			renderRequest.setAttribute(AxLeavePolicyMasterWebPortletConstants.LEAVE_POLICY_MASTER_COUNTS, totalRecords);
			renderRequest.setAttribute(AxLeavePolicyMasterWebPortletConstants.DELTA, delta);
		} catch (PortalException e) {
			log.error("Error processing leave policy master details", e);
		}
		return AxLeavePolicyMasterWebPortletConstants.LIST_LEAVE_POLICY_MASTER_JSP;
	}

	public List<LeavePolicyMasterDetails> setLeavePolicyMasterDetails(List<LeavePolicyMaster> leavePolicyMasterList)
			throws PortalException {
		List<LeavePolicyMasterDetails> leavePolicyMasterDetailsList = new ArrayList<LeavePolicyMasterDetails>();
		for (LeavePolicyMaster leavePolicyMaster : leavePolicyMasterList) {
			LeavePolicyMasterDetails leavePolicyMasterDetails = new LeavePolicyMasterDetails();
			leavePolicyMasterDetails.setLeavePolicyMasterid(leavePolicyMaster.getLeavePolicyMasterId());
			leavePolicyMasterDetails.setDescription(leavePolicyMaster.getDescription());
			leavePolicyMasterDetails.setCarryForward(leavePolicyMaster.getIsCarryForward());
			leavePolicyMasterDetails.setAccrualRate((int)(leavePolicyMaster.getAccrualRate()*12));
			leavePolicyMasterDetails.setMaximumBalance(leavePolicyMaster.getMaximumBalance());
			leavePolicyMasterDetails.setCheckMax(leavePolicyMaster.getIsCheckMax());
			leavePolicyMasterDetails.setYearOfPolicy(leavePolicyMaster.getYearOfPolicy());
			leavePolicyMasterDetails.setIsApplicableFloater(leavePolicyMaster.getIsApplicableFloater());
			leavePolicyMasterDetails.setContinous(leavePolicyMaster.getIsContinuous());
			leavePolicyMasterDetails.setEligibleAfterMonths(leavePolicyMaster.getEligibleAfterMonths());
			leavePolicyMasterDetails.setLeaveTypeMasterId(leavePolicyMaster.getLeaveTypeMasterId());
			leavePolicyMasterDetails.setLeaveTypeName(leaveTypeMasterLocalService.getLeaveTypeMaster(leavePolicyMaster.getLeaveTypeMasterId()).getLeaveTypeName());
			leavePolicyMasterDetailsList.add(leavePolicyMasterDetails);
		}
		return leavePolicyMasterDetailsList;
	}
}
