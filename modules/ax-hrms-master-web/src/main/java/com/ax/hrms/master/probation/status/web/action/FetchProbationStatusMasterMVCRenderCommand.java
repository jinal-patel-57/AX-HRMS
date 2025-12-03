package com.ax.hrms.master.probation.status.web.action;

import com.ax.hrms.master.service.ProbationStatusMasterLocalService;
import com.ax.hrms.master.web.constants.AxProbationStatusMasterWebPortletConstants;
import com.ax.hrms.master.web.constants.AxProbationStatusMasterWebPortletKeys;
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
			"javax.portlet.name="+AxProbationStatusMasterWebPortletKeys.AXHRMS_PROBATIONSTATUSMASTER_WEB_PORTLET_KEYS,
			"mvc.command.name=/fetchProbationStatus"
		},
		service = MVCRenderCommand.class
	)

public class FetchProbationStatusMasterMVCRenderCommand implements MVCRenderCommand {
	
	private Log log = LogFactoryUtil.getLog(FetchProbationStatusMasterMVCRenderCommand.class);
	
	@Reference
	ProbationStatusMasterLocalService probationStatusMasterLocalService;

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		
		
		long probationStatusMasterId = ParamUtil.getLong(renderRequest, AxProbationStatusMasterWebPortletConstants.PROBATIONSTATUS_MASTER_ID);
		
		try {
																				
			renderRequest.setAttribute(AxProbationStatusMasterWebPortletConstants.PROBATIONSTATUS_MASTER_DATA, probationStatusMasterLocalService.getProbationStatusMaster(probationStatusMasterId));
			
			
		} catch (PortalException e) {
			log.error("Error " + e.getMessage());
		}

		return AxProbationStatusMasterWebPortletConstants.FORM_PROBATION_STATUS_MASTER;
	}

}
