package com.ax.hrms.master.education.level.web.action;

import com.ax.hrms.master.exception.NoSuchEducationLevelMasterException;
import com.ax.hrms.master.model.EducationLevelMaster;
import com.ax.hrms.master.service.EducationLevelMasterLocalService;
import com.ax.hrms.master.web.constants.AxEducationLevelMasterWebPortletConstants;
import com.ax.hrms.master.web.constants.AxEducationLevelMasterWebPortletKeys;
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
	        "javax.portlet.name="+ AxEducationLevelMasterWebPortletKeys.AXHRMS_EDUCATIONLEVELMASTER_WEB_PORTLET_KEYS,
	        "mvc.command.name=/addEditEducationLevel"
	    },
	    service = MVCActionCommand.class
	)

public class AddEditEducationLevelMasterMVCActionCommand extends BaseMVCActionCommand {
	
	@Reference
	EducationLevelMasterLocalService educationLevelMasterLocalService;


	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		
		
		String educationLevelName = ParamUtil.getString(actionRequest, AxEducationLevelMasterWebPortletConstants.EDUCATIONLEVEL_NAME, null);
		long educationLevelMasterId = ParamUtil.getLong(actionRequest, AxEducationLevelMasterWebPortletConstants.EDUCATIONLEVEL_MASTER_ID, AxEducationLevelMasterWebPortletConstants.DEFAULT_LONG_VALUE);

        if (educationLevelMasterId <= 0) {
            if (isLevelMasterAvailable(educationLevelName, 0)) {
            	
            	if(isLevelNameValid(educationLevelName)) {
            	
	            	EducationLevelMaster educationLevelMaster = educationLevelMasterLocalService.createEducationLevelMaster(CounterLocalServiceUtil.increment(EducationLevelMaster.class.getName()));
	                
	                ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
	                educationLevelMaster.setLevelName(educationLevelName);
	                educationLevelMaster.setCompanyId(themeDisplay.getCompanyId());
	                educationLevelMaster.setCreatedBy(themeDisplay.getUserId());
	                educationLevelMaster.setGroupId(themeDisplay.getCompanyGroupId());
	                educationLevelMaster.setCreateDate(new Date());
	                educationLevelMaster.setModifiedDate(new Date());
	                educationLevelMasterLocalService.addEducationLevelMaster(educationLevelMaster);
	                
	                SessionMessages.add(actionRequest, AxEducationLevelMasterWebPortletConstants.EDUCATION_LEVEL_ADDED);
            	}
            	else {
            		
            		SessionErrors.add(actionRequest, AxEducationLevelMasterWebPortletConstants.EDUCATION_LEVEL_INCORRECT);
					super.hideDefaultErrorMessage(actionRequest);

					actionResponse.setRenderParameter(AxEducationLevelMasterWebPortletConstants.EDUCATIONLEVEL_PATH, AxEducationLevelMasterWebPortletConstants.FORM_EDUCATION_LEVEL_MASTER);
            	}
			}
			else {
				
				SessionErrors.add(actionRequest, AxEducationLevelMasterWebPortletConstants.EDUCATION_LEVEL_EXISTS);
				super.hideDefaultErrorMessage(actionRequest);

				actionResponse.setRenderParameter(AxEducationLevelMasterWebPortletConstants.EDUCATIONLEVEL_PATH, AxEducationLevelMasterWebPortletConstants.FORM_EDUCATION_LEVEL_MASTER);
			}
        }
        else {
            if (isLevelMasterAvailable(educationLevelName, educationLevelMasterId)) {
	            	if(isLevelNameValid(educationLevelName)) {
	            		EducationLevelMaster educationLevelMaster = educationLevelMasterLocalService.getEducationLevelMaster(educationLevelMasterId);
	                	educationLevelMaster.setLevelName(educationLevelName);
	                    ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
	                    educationLevelMaster.setModifiedBy(themeDisplay.getUserId());
	                    educationLevelMasterLocalService.updateEducationLevelMaster(educationLevelMaster);
	                    SessionMessages.add(actionRequest, AxEducationLevelMasterWebPortletConstants.EDUCATION_LEVEL_UPDATED);
	    			}
	            	else {
	            		SessionErrors.add(actionRequest, AxEducationLevelMasterWebPortletConstants.EDUCATION_LEVEL_INCORRECT);
						super.hideDefaultErrorMessage(actionRequest);

						actionResponse.setRenderParameter(AxEducationLevelMasterWebPortletConstants.EDUCATIONLEVEL_PATH, AxEducationLevelMasterWebPortletConstants.FORM_EDUCATION_LEVEL_MASTER);
	            	}
            	
            	}
            	
				else {
					SessionErrors.add(actionRequest, AxEducationLevelMasterWebPortletConstants.EDUCATION_LEVEL_EXISTS);
					super.hideDefaultErrorMessage(actionRequest);

					actionResponse.setRenderParameter(AxEducationLevelMasterWebPortletConstants.EDUCATIONLEVEL_PATH, AxEducationLevelMasterWebPortletConstants.FORM_EDUCATION_LEVEL_MASTER);
				}
        }
    }

    private boolean isLevelMasterAvailable(String educationLevelName, long id) { 
        try {
        	
        	EducationLevelMaster name = educationLevelMasterLocalService.findByLevelName(educationLevelName);
            return (id>0 && name.getEducationLevelMasterId() == id);
        } catch (NoSuchEducationLevelMasterException e) {
            return true;
        }
    }

    private boolean isLevelNameValid(String educationLevelName) { 
        return Validator.isNotNull(educationLevelName) && Validator.isName(educationLevelName);
    }


}