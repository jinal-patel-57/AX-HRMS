package com.ax.hrms.master.leave.compensatory.status.web.action;

import com.ax.hrms.master.service.LeaveCompensatoryStatusMasterLocalService;
import com.ax.hrms.master.web.constants.AxLeaveCompensatoryStatusMasterWebPortletConstants;
import com.ax.hrms.master.web.constants.AxLeaveCompensatoryStatusMasterWebPortletKeys;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.ParamUtil;

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
			"mvc.command.name=/fetchLeaveCompensatoryStatus"
		},
		service = MVCRenderCommand.class
	)


public class FetchLeaveCompensatoryStatusMasterMVCRenderCommand implements MVCRenderCommand {
	
	private Log log = LogFactoryUtil.getLog(FetchLeaveCompensatoryStatusMasterMVCRenderCommand.class);
	
	@Reference
	LeaveCompensatoryStatusMasterLocalService leaveCompensatoryStatusLocalService;
	

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
			
		long leaveCompensatoryStatus = ParamUtil.getLong(renderRequest, AxLeaveCompensatoryStatusMasterWebPortletConstants.LEAVECOMPENSATORYSTATUS_MASTER_ID);
		
		try {
																				
			renderRequest.setAttribute(AxLeaveCompensatoryStatusMasterWebPortletConstants.LEAVECOMPENSATORYSTATUS_MASTER_DATA, leaveCompensatoryStatusLocalService.getLeaveCompensatoryStatusMaster(leaveCompensatoryStatus));
			
			
		} catch (PortalException e) {
			log.error("Error " + e.getMessage());
		}

		return AxLeaveCompensatoryStatusMasterWebPortletConstants.FORM_LEAVE_COMPENSATORY_STATUS_MASTER;
	}
}