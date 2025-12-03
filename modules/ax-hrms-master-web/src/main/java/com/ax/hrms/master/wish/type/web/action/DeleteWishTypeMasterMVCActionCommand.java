package com.ax.hrms.master.wish.type.web.action;

import com.ax.hrms.master.service.WishTypeMasterLocalService;
import com.ax.hrms.master.web.constants.AxWishTypeMasterWebPortletConstants;
import com.ax.hrms.master.web.constants.AxWishTypeMasterWebPortletKeys;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;


/**

Author: Himanshu Jha
*/

@Component(immediate = true, property = {
		"javax.portlet.name="+AxWishTypeMasterWebPortletKeys.AXHRMS_WISHTYPEMASTER_WEB_PORTLET_KEYS,
        "mvc.command.name=/deleteWishType"
}, service = MVCActionCommand.class)


public class DeleteWishTypeMasterMVCActionCommand extends BaseMVCActionCommand {
	
	private Log log=LogFactoryUtil.getLog(DeleteWishTypeMasterMVCActionCommand.class);
	
	@Reference
	WishTypeMasterLocalService wishTypeMasterLocalService;

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		
		Long wishTypeMasterId = ParamUtil.getLong(actionRequest, AxWishTypeMasterWebPortletConstants.WISHTYPE_MASTER_ID);
		
		try {
			
			wishTypeMasterLocalService.deleteWishTypeMaster(wishTypeMasterId);
			
			SessionMessages.add(actionRequest, AxWishTypeMasterWebPortletConstants.WISH_TYPE_DELETED);
			
		}catch (Exception e) {
			SessionMessages.add(actionRequest, AxWishTypeMasterWebPortletConstants.WISH_TYPE_DELETED_ERROR);
			log.error("Encountred Error " + e.getMessage());
		}
	}

}
