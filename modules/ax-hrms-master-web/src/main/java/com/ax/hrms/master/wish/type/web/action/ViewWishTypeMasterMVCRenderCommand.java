package com.ax.hrms.master.wish.type.web.action;

import com.ax.hrms.master.education.level.web.action.ViewEducationLevelMasterRenderCommand;
import com.ax.hrms.master.service.WishTypeMasterLocalService;
import com.ax.hrms.master.web.constants.AxWishTypeMasterWebPortletConstants;
import com.ax.hrms.master.web.constants.AxWishTypeMasterWebPortletKeys;
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
			"javax.portlet.name="+AxWishTypeMasterWebPortletKeys.AXHRMS_WISHTYPEMASTER_WEB_PORTLET_KEYS,
			"mvc.command.name=/viewWishType"
		},
		service = MVCRenderCommand.class
	)

public class ViewWishTypeMasterMVCRenderCommand implements MVCRenderCommand {
	
	private Log log = LogFactoryUtil.getLog(ViewEducationLevelMasterRenderCommand.class);

	
	@Reference
	WishTypeMasterLocalService wishTypeMasterLocalService;

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		
		long wishTypeMasterId = ParamUtil.getLong(renderRequest, AxWishTypeMasterWebPortletConstants.WISHTYPE_MASTER_ID);
		
		try {
			
			renderRequest.setAttribute(AxWishTypeMasterWebPortletConstants.WISHTYPEDETAILS, wishTypeMasterLocalService.getWishTypeMaster(wishTypeMasterId));
			
		} catch (PortalException e) {
			log.error("Error " + e.getMessage());
		}
		return AxWishTypeMasterWebPortletConstants.VIEW_WISH_TYPE_MASTER;

	}

}
