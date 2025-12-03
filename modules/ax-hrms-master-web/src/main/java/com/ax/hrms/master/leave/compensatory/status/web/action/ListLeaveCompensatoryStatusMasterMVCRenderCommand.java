package com.ax.hrms.master.leave.compensatory.status.web.action;

import com.ax.hrms.master.model.LeaveCompensatoryStatusMaster;
import com.ax.hrms.master.service.LeaveCompensatoryStatusMasterLocalService;
import com.ax.hrms.master.service.LeaveCompensatoryStatusMasterLocalServiceUtil;
import com.ax.hrms.master.web.constants.AxLeaveCompensatoryStatusMasterWebPortletConstants;
import com.ax.hrms.master.web.constants.AxLeaveCompensatoryStatusMasterWebPortletKeys;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.ParamUtil;

import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;


/**

Author: Himanshu Jha
*/

@Component(
		immediate = true,
		property = {
			"javax.portlet.name="+AxLeaveCompensatoryStatusMasterWebPortletKeys.AXHRMS_LEAVECOMPENSATORYSTATUSMASTER_WEB_PORTLET_KEYS,
			"mvc.command.name=/"
		},
		service = MVCRenderCommand.class
	)

public class ListLeaveCompensatoryStatusMasterMVCRenderCommand implements MVCRenderCommand {
	
	@Reference
	LeaveCompensatoryStatusMasterLocalService leaveCompensatoryStatusMasterLocalService;
	
	
	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		
		
		List<LeaveCompensatoryStatusMaster> leaveCompensatoryStatusMasters = null;
		
		int curValue = ParamUtil.getInteger(renderRequest,SearchContainer.DEFAULT_CUR_PARAM,1);
		int deltaValue = ParamUtil.getInteger(renderRequest, SearchContainer.DEFAULT_DELTA_PARAM,3);
		
		int totalOfLeaveCompensatoryStatus = leaveCompensatoryStatusMasterLocalService.getLeaveCompensatoryStatusMastersCount();
	    int totalPageContainer = (totalOfLeaveCompensatoryStatus + deltaValue - 1) / deltaValue;
	    
	    if (curValue > totalPageContainer) {
	        curValue = totalPageContainer;
	    }
		
		int start = (curValue - 1) * deltaValue;
	    int end = start + deltaValue;
		
	    leaveCompensatoryStatusMasters = leaveCompensatoryStatusMasterLocalService.getLeaveCompensatoryStatusMasters(start, end);
		
		renderRequest.setAttribute(AxLeaveCompensatoryStatusMasterWebPortletConstants.LEAVECOMPENSATORYSTATUS_GET, leaveCompensatoryStatusMasters);
		renderRequest.setAttribute(AxLeaveCompensatoryStatusMasterWebPortletConstants.LEAVECOMPENSATORYSTATUS_TOTAL, LeaveCompensatoryStatusMasterLocalServiceUtil.getLeaveCompensatoryStatusMastersCount());
		renderRequest.setAttribute(AxLeaveCompensatoryStatusMasterWebPortletConstants.LEAVECOMPENSATORYSTATUS_MASTER, leaveCompensatoryStatusMasters);
		
		return AxLeaveCompensatoryStatusMasterWebPortletConstants.LIST_LEAVE_COMPENSATORY_STATUS_MASTER;
	}
}