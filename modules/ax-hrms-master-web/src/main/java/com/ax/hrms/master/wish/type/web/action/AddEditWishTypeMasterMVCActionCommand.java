package com.ax.hrms.master.wish.type.web.action;

import com.ax.hrms.master.exception.NoSuchWishTypeMasterException;
import com.ax.hrms.master.model.WishTypeMaster;
import com.ax.hrms.master.service.WishTypeMasterLocalService;
import com.ax.hrms.master.web.constants.AxWishTypeMasterWebPortletConstants;
import com.ax.hrms.master.web.constants.AxWishTypeMasterWebPortletKeys;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.Date;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**

Author: Himanshu Jha
*/

@Component(
	    immediate = true,
	    property = {
	        "javax.portlet.name="+ AxWishTypeMasterWebPortletKeys.AXHRMS_WISHTYPEMASTER_WEB_PORTLET_KEYS,
	        "mvc.command.name=/addEditWishType"
	    },
	    service = MVCActionCommand.class
)

public class AddEditWishTypeMasterMVCActionCommand extends BaseMVCActionCommand {
		
	@Reference
	WishTypeMasterLocalService wishTypeMasterLocalService;


	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		
		String wishTypeName = ParamUtil.getString(actionRequest, AxWishTypeMasterWebPortletConstants.WISHTYPE_NAME, null);
		long wishTypeMasterId = ParamUtil.getLong(actionRequest, AxWishTypeMasterWebPortletConstants.WISHTYPE_MASTER_ID, AxWishTypeMasterWebPortletConstants.DEFAULT_LONG_VALUE);

		if (wishTypeMasterId <= 0) {
		   if (isLevelMasterAvailable(wishTypeName, 0)) {
		       WishTypeMaster wishTypeMaster = wishTypeMasterLocalService.createWishTypeMaster(CounterLocalServiceUtil.increment(WishTypeMaster.class.getName()));
		       
		       ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		       wishTypeMaster.setWishType(wishTypeName);
		       wishTypeMaster.setCompanyId(themeDisplay.getCompanyId());
		       wishTypeMaster.setCreatedBy(themeDisplay.getUserId());
		       wishTypeMaster.setGroupId(themeDisplay.getCompanyGroupId());
		       wishTypeMaster.setCreateDate(new Date());
		       wishTypeMaster.setModifiedDate(new Date());
		       wishTypeMasterLocalService.addWishTypeMaster(wishTypeMaster);
		       
		       SessionMessages.add(actionRequest, AxWishTypeMasterWebPortletConstants.WISH_TYPE_ADDED);
		       }
		       else {
		           SessionErrors.add(actionRequest, AxWishTypeMasterWebPortletConstants.WISH_TYPE_EXISTS);
		           super.hideDefaultErrorMessage(actionRequest);

		           actionResponse.setRenderParameter(AxWishTypeMasterWebPortletConstants.WISHTYPE_PATH, AxWishTypeMasterWebPortletConstants.FORM_WISH_TYPE_MASTER);
		       }
		}

		else {
		   if (isLevelMasterAvailable(wishTypeName, wishTypeMasterId) && isLevelNameValid(wishTypeName)) {
			 
		       WishTypeMaster wishTypeMaster = wishTypeMasterLocalService.getWishTypeMaster(wishTypeMasterId);
		       wishTypeMaster.setWishType(wishTypeName);
		       ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		       wishTypeMaster.setModifiedBy(themeDisplay.getUserId());
		       
		       wishTypeMasterLocalService.updateWishTypeMaster(wishTypeMaster);
		         
		       SessionMessages.add(actionRequest, AxWishTypeMasterWebPortletConstants.WISH_TYPE_UPDATED);
		   }
		   else {
		       SessionErrors.add(actionRequest, AxWishTypeMasterWebPortletConstants.WISH_TYPE_EXISTS);
		       super.hideDefaultErrorMessage(actionRequest);
		       
		       actionResponse.setRenderParameter(AxWishTypeMasterWebPortletConstants.WISHTYPE_PATH, AxWishTypeMasterWebPortletConstants.FORM_WISH_TYPE_MASTER);
		   }
		}
		}

		private boolean isLevelMasterAvailable(String wishTypeName, long id) { 
		try {
		   
		   WishTypeMaster name = wishTypeMasterLocalService.findByWishType(wishTypeName);
		   
		   return (id>0 && name.getWishTypeMasterId() == id);
		} catch (NoSuchWishTypeMasterException e) {
		   return true;
		}
	}

	private boolean isLevelNameValid(String wishTypeName) { 
		return Validator.isNotNull(wishTypeName) && Validator.isName(wishTypeName);
		}
}