
package com.ax.hrms.master.education.level.web.action;

import com.ax.hrms.master.model.EducationLevelMaster;
import com.ax.hrms.master.service.EducationLevelMasterLocalService;
import com.ax.hrms.master.service.EducationLevelMasterLocalServiceUtil;
import com.ax.hrms.master.web.constants.AxEducationLevelMasterWebPortletConstants;
import com.ax.hrms.master.web.constants.AxEducationLevelMasterWebPortletKeys;
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
			"javax.portlet.name="+AxEducationLevelMasterWebPortletKeys.AXHRMS_EDUCATIONLEVELMASTER_WEB_PORTLET_KEYS,
			"mvc.command.name=/"
		},
		service = MVCRenderCommand.class
	)

public class ListEducationLevelMasterMVCRenderCommand implements MVCRenderCommand {
    
	@Reference
	EducationLevelMasterLocalService educationLevelMasterLocalService;
	
	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		
		List<EducationLevelMaster> educationLevelMasters = null;

		
		int curValue = ParamUtil.getInteger(renderRequest,SearchContainer.DEFAULT_CUR_PARAM,1);
		int deltaValue = ParamUtil.getInteger(renderRequest, SearchContainer.DEFAULT_DELTA_PARAM,3);
		
		int totalOfEducationLevel = educationLevelMasterLocalService.getEducationLevelMastersCount();
	    int totalPageContainer = (totalOfEducationLevel + deltaValue - 1) / deltaValue;
	    
	    if (curValue > totalPageContainer) {
	        curValue = totalPageContainer;
	    }
		
		int start = (curValue - 1) * deltaValue;
	    int end = start + deltaValue;
		
	    educationLevelMasters = educationLevelMasterLocalService.getEducationLevelMasters(start, end);
	    
		renderRequest.setAttribute(AxEducationLevelMasterWebPortletConstants.EDUCATIONLEVEL_GET, educationLevelMasters);
		renderRequest.setAttribute(AxEducationLevelMasterWebPortletConstants.EDUCATIONLEVEL_TOTAL, EducationLevelMasterLocalServiceUtil.getEducationLevelMastersCount());
		renderRequest.setAttribute(AxEducationLevelMasterWebPortletConstants.EDUCATIONLEVEL_MASTER, educationLevelMasters);
		
		
		return AxEducationLevelMasterWebPortletConstants.LIST_EDUCATION_LEVEL_MASTER;
	}

}
