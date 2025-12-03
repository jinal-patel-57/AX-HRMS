package com.ax.hrms.master.template.level.web.action;


import com.ax.hrms.master.exception.NoSuchTemplateLevelMasterException;
import com.ax.hrms.master.model.TemplateLevelMaster;
import com.ax.hrms.master.service.TemplateLevelMasterLocalService;
import com.ax.hrms.master.web.constants.AxHrmsMasterWebPortletKeys;
import com.ax.hrms.master.web.constants.AxHrmsTemplateLevelMasterConstants;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.*;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import java.util.Date;


/**
 * Author: Nivid Koradiya
 */
@Component(
        property = {
                "javax.portlet.name=" + AxHrmsMasterWebPortletKeys.AX_HRMS_TEMPLATE_LEVEL_MASTER_WEB_PORTLET,
                "mvc.command.name=/addEditTemplateLevelMasterDetails"
        },
        service = MVCActionCommand.class
)
public class AddEditTemplateLevelMasterMVCActionCommand extends BaseMVCActionCommand {

    @Reference
    TemplateLevelMasterLocalService templateLevelMasterLocalService;

    @Override
    protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {

        String levelName = ParamUtil.getString(actionRequest, AxHrmsTemplateLevelMasterConstants.LEVEL_NAME);
        long templateLevelMasterId = ParamUtil.getLong(actionRequest, AxHrmsTemplateLevelMasterConstants.TEMPLATE_LEVEL_MASTER_ID);

        if (templateLevelMasterId <= 0) {
            if (isLevelMasterAvailable(levelName,0)) {
                TemplateLevelMaster templatelevelMaster = templateLevelMasterLocalService.createTemplateLevelMaster(CounterLocalServiceUtil.increment(TemplateLevelMaster.class.getName()));
                ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
                templatelevelMaster.setLevelName(levelName);
                templatelevelMaster.setCompanyId(themeDisplay.getCompanyId());
                templatelevelMaster.setCreatedBy(themeDisplay.getUserId());
                templatelevelMaster.setGroupId(themeDisplay.getCompanyGroupId());
                templatelevelMaster.setCreateDate(new Date());
                templatelevelMaster.setModifiedDate(new Date());
                templateLevelMasterLocalService.addTemplateLevelMaster(templatelevelMaster);
                SessionMessages.add(actionRequest, AxHrmsTemplateLevelMasterConstants.SUCCESS); // Setting success key to actionRequest
            } else {
                SessionErrors.add(actionRequest, AxHrmsTemplateLevelMasterConstants.ERROR_ALREADY_EXIST); // setting error key to actionRequest
                actionResponse.setRenderParameter(AxHrmsTemplateLevelMasterConstants.MVC_PATH_PARAMETER, AxHrmsTemplateLevelMasterConstants.TEMPLATE_LEVEL_MASTER_FORM_JSP);
                actionRequest.setAttribute(AxHrmsTemplateLevelMasterConstants.LEVEL_NAME, levelName);
            }
        }
        else {
            if (isLevelMasterAvailable(levelName, templateLevelMasterId) && isLevelNameValid(levelName)) {
                TemplateLevelMaster templatelevelMaster = templateLevelMasterLocalService.getTemplateLevelMaster(templateLevelMasterId);
                templatelevelMaster.setLevelName(levelName);
                ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
                templatelevelMaster.setModifiedBy(themeDisplay.getUserId());
                templateLevelMasterLocalService.updateTemplateLevelMaster(templatelevelMaster);
                SessionMessages.add(actionRequest, AxHrmsTemplateLevelMasterConstants.SUCCESS_EDIT); // setting succss key to actionRequest
            } else {
                SessionErrors.add(actionRequest, AxHrmsTemplateLevelMasterConstants.ERROR_ALREADY_EXIST); // setting error key to actionRequest.
                actionResponse.setRenderParameter(AxHrmsTemplateLevelMasterConstants.MVC_PATH_PARAMETER, AxHrmsTemplateLevelMasterConstants.TEMPLATE_LEVEL_MASTER_FORM_JSP);
                actionRequest.setAttribute(AxHrmsTemplateLevelMasterConstants.LEVEL_NAME, levelName);
            }
        }
        SessionMessages.add(actionRequest, PortalUtil.getPortletId(actionRequest) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
    }

    private boolean isLevelMasterAvailable(String levelName,long id) { // check weather the levelName is available or not!
        try {
            levelName = StringUtil.lowerCase(levelName);
            TemplateLevelMaster templateLevelMaster = templateLevelMasterLocalService.findBylevelName(levelName);
            if(id>0 && templateLevelMaster.getTemplateLevelMasterId() == id){
                return true;
            }
            return false;
        } catch (NoSuchTemplateLevelMasterException e) {
            return true;
        }
    }

    private boolean isLevelNameValid(String levelName) { // checks weather the level name is valid!
        return Validator.isNotNull(levelName) && Validator.isName(levelName);
    }


}



