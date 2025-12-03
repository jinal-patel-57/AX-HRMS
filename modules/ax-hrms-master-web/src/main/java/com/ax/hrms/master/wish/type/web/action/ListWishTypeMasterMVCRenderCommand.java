package com.ax.hrms.master.wish.type.web.action;

import com.ax.hrms.master.model.WishTypeMaster;
import com.ax.hrms.master.service.WishTypeMasterLocalService;
import com.ax.hrms.master.service.WishTypeMasterLocalServiceUtil;
import com.ax.hrms.master.web.constants.AxWishTypeMasterWebPortletConstants;
import com.ax.hrms.master.web.constants.AxWishTypeMasterWebPortletKeys;
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
			"javax.portlet.name="+AxWishTypeMasterWebPortletKeys.AXHRMS_WISHTYPEMASTER_WEB_PORTLET_KEYS,
			"mvc.command.name=/"
		},
		service = MVCRenderCommand.class
	)

public class ListWishTypeMasterMVCRenderCommand implements MVCRenderCommand {
	
    
	@Reference
	WishTypeMasterLocalService wishTypeMasterLocalService;
	
	
	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		
		
		List<WishTypeMaster> wishTypeMasters = null;
		
		int curValue = ParamUtil.getInteger(renderRequest,SearchContainer.DEFAULT_CUR_PARAM,1);
		int deltaValue = ParamUtil.getInteger(renderRequest, SearchContainer.DEFAULT_DELTA_PARAM,3);
		
		int totalOfWishType = wishTypeMasterLocalService.getWishTypeMastersCount();
	    int totalPageContainer = (totalOfWishType + deltaValue - 1) / deltaValue;
	    
	    if (curValue > totalPageContainer) {
	        curValue = totalPageContainer;
	    }
		
		int start = (curValue - 1) * deltaValue;
	    int end = start + deltaValue;
		
	    wishTypeMasters = wishTypeMasterLocalService.getWishTypeMasters(start, end);
		
		renderRequest.setAttribute(AxWishTypeMasterWebPortletConstants.WISHTYPE_GET, wishTypeMasters);
		renderRequest.setAttribute(AxWishTypeMasterWebPortletConstants.WISHTYPE_TOTAL, WishTypeMasterLocalServiceUtil.getWishTypeMastersCount());
		renderRequest.setAttribute(AxWishTypeMasterWebPortletConstants.WISHTYPE_MASTER, wishTypeMasters);
		
		
		return AxWishTypeMasterWebPortletConstants.LIST_WISH_TYPE_MASTER;
	}

}
