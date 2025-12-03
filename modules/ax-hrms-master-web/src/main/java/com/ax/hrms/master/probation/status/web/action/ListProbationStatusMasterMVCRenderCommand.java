package com.ax.hrms.master.probation.status.web.action;

import com.ax.hrms.master.model.ProbationStatusMaster;
import com.ax.hrms.master.service.ProbationStatusMasterLocalService;
import com.ax.hrms.master.service.ProbationStatusMasterLocalServiceUtil;
import com.ax.hrms.master.web.constants.AxProbationStatusMasterWebPortletConstants;
import com.ax.hrms.master.web.constants.AxProbationStatusMasterWebPortletKeys;
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
			"javax.portlet.name="+AxProbationStatusMasterWebPortletKeys.AXHRMS_PROBATIONSTATUSMASTER_WEB_PORTLET_KEYS,
			"mvc.command.name=/"
		},
		service = MVCRenderCommand.class
	)

public class ListProbationStatusMasterMVCRenderCommand implements MVCRenderCommand  {

	@Reference
	ProbationStatusMasterLocalService probationStatusMasterLocalService;
	
	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		
		List<ProbationStatusMaster> probationStatusMasters = null;

		
		int curValue = ParamUtil.getInteger(renderRequest,SearchContainer.DEFAULT_CUR_PARAM,1);
		int deltaValue = ParamUtil.getInteger(renderRequest, SearchContainer.DEFAULT_DELTA_PARAM,3);
		
		int totalOfprobationStatus = probationStatusMasterLocalService.getProbationStatusMastersCount();
	    int totalPageContainer = (totalOfprobationStatus + deltaValue - 1) / deltaValue;
	    
	    if (curValue > totalPageContainer) {
	        curValue = totalPageContainer;
	    }
		
		int start = (curValue - 1) * deltaValue;
	    int end = start + deltaValue;
		
	    probationStatusMasters = probationStatusMasterLocalService.getProbationStatusMasters(start, end);
	    
		renderRequest.setAttribute(AxProbationStatusMasterWebPortletConstants.PROBATIONSTATUS_GET, probationStatusMasters);
		renderRequest.setAttribute(AxProbationStatusMasterWebPortletConstants.PROBATIONSTATUS_TOTAL, ProbationStatusMasterLocalServiceUtil.getProbationStatusMastersCount());
		renderRequest.setAttribute(AxProbationStatusMasterWebPortletConstants.PROBATIONSTATUS_MASTER, probationStatusMasters);
		
		
		return AxProbationStatusMasterWebPortletConstants.LIST_PROBATION_STATUS_MASTER;
	}

}
