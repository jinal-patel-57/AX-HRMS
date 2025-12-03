package com.ax.hrms.master.education.level.web.action;

import com.ax.hrms.master.service.EducationLevelMasterLocalService;
import com.ax.hrms.master.web.constants.AxEducationLevelMasterWebPortletConstants;
import com.ax.hrms.master.web.constants.AxEducationLevelMasterWebPortletKeys;
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
			"javax.portlet.name="+AxEducationLevelMasterWebPortletKeys.AXHRMS_EDUCATIONLEVELMASTER_WEB_PORTLET_KEYS,
			"mvc.command.name=/viewEducationLevel"
		},
		service = MVCRenderCommand.class
	)

public class ViewEducationLevelMasterRenderCommand implements MVCRenderCommand {
	
	private Log log = LogFactoryUtil.getLog(ViewEducationLevelMasterRenderCommand.class);

	
	@Reference
	EducationLevelMasterLocalService educationLevelMasterLocalService;

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		
		long educationLevelMasterId = ParamUtil.getLong(renderRequest, AxEducationLevelMasterWebPortletConstants.EDUCATIONLEVEL_MASTER_ID);
		
		try {
			
			renderRequest.setAttribute("educationDetails", educationLevelMasterLocalService.getEducationLevelMaster(educationLevelMasterId));
			
		} catch (PortalException e) {
			log.error("Error " + e.getMessage());
		}
		return AxEducationLevelMasterWebPortletConstants.VIEW_EDUCATION_LEVEL_MASTER;

	}

}
