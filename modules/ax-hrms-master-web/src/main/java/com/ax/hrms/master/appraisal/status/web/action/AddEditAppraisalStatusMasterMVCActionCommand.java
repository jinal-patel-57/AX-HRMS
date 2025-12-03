package com.ax.hrms.master.appraisal.status.web.action;


import com.ax.hrms.master.exception.NoSuchAppraisalStatusMasterException;
import com.ax.hrms.master.model.AppraisalStatusMaster;
import com.ax.hrms.master.service.AppraisalStatusMasterLocalService;
import com.ax.hrms.master.web.constants.AxDocumentTypeMasterWebPortletConstants;
import com.ax.hrms.master.web.constants.AxHrmsAppraisalStatusMasterConstants;
import com.ax.hrms.master.web.constants.AxHrmsMasterWebPortletKeys;
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

 Author: Nivid Koradiya
 */
@Component(
        property = {
                "javax.portlet.name=" + AxHrmsMasterWebPortletKeys.AX_HRMS_APPRAISAL_STATUS_MASTER_WEB_PORTLET,
                "mvc.command.name=/addEditAppraisalStatusMasterDetails"
        },
        service = MVCActionCommand.class
)
public class AddEditAppraisalStatusMasterMVCActionCommand extends BaseMVCActionCommand {

    @Reference
    AppraisalStatusMasterLocalService appraisalStatusMasterLocalService;


    @Override
    protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
        String status = ParamUtil.getString(actionRequest, AxHrmsAppraisalStatusMasterConstants.STATUS);  // getting the status parameter from the request. The status parameter is the value entered by the user in the text field in the HTML form.
        long appraisalStatusMasterId = ParamUtil.getLong(actionRequest, AxHrmsAppraisalStatusMasterConstants.APPRAISAL_STATUS_MASTER_ID);
        if (appraisalStatusMasterId <= 0) { // if the ID parameter is less then or equal to 0, then the ID parameter is nor passed.
            if (Validator.isNotNull(status) && Validator.isName(status)) {
                if (isAppraisalStatusMasterAvailable(status,0)) {
                    // Creates a new AppraisalStatusMaster entity and increments the counter for AppraisalStatusMaster.class
                    AppraisalStatusMaster appraisalStatusMaster = appraisalStatusMasterLocalService.createAppraisalStatusMaster(CounterLocalServiceUtil.increment(AppraisalStatusMaster.class.getName()));
                    ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);

                    // The code sets the status, company ID, user ID, group ID, and creation and modification dates for the new appraisal status.
                    appraisalStatusMaster.setStatus(status);
                    appraisalStatusMaster.setCompanyId(themeDisplay.getCompanyId());
                    appraisalStatusMaster.setCreatedBy(themeDisplay.getUserId());
                    appraisalStatusMaster.setGroupId(themeDisplay.getCompanyGroupId());
                    appraisalStatusMaster.setCreateDate(new Date());
                    appraisalStatusMaster.setModifiedDate(new Date());

                    appraisalStatusMasterLocalService.addAppraisalStatusMaster(appraisalStatusMaster); //  add the new appraisal status to the system.
                    SessionMessages.add(actionRequest, AxHrmsAppraisalStatusMasterConstants.SUCCESS); // Setting success key to actionRequest
                } else {
                    SessionErrors.add(actionRequest, AxHrmsAppraisalStatusMasterConstants.ERROR_ALREADY_EXIST); // setting error key to actionRequest
                    actionResponse.setRenderParameter(AxHrmsAppraisalStatusMasterConstants.MVC_PATH_PARAMETER, AxHrmsAppraisalStatusMasterConstants.APPRAISAL_STATUS_MASTER_FORM_JSP);
                    actionRequest.setAttribute(AxHrmsAppraisalStatusMasterConstants.STATUS, status);
                }
            }
        } else  { // for edit request handling
            if (isAppraisalStatusMasterAvailable(status,appraisalStatusMasterId)) {
                AppraisalStatusMaster appraisalStatusMaster = appraisalStatusMasterLocalService.getAppraisalStatusMaster(appraisalStatusMasterId);
                appraisalStatusMaster.setStatus(status);
                ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
                appraisalStatusMaster.setModifiedBy(themeDisplay.getUserId());
                appraisalStatusMasterLocalService.updateAppraisalStatusMaster(appraisalStatusMaster);
                SessionMessages.add(actionRequest, AxHrmsAppraisalStatusMasterConstants.SUCCESS_EDIT);
            } else {
                SessionErrors.add(actionRequest, AxHrmsAppraisalStatusMasterConstants.ERROR_ALREADY_EXIST);
                actionResponse.setRenderParameter(AxDocumentTypeMasterWebPortletConstants.MVC_PATH_PARAMETER, AxHrmsAppraisalStatusMasterConstants.APPRAISAL_STATUS_MASTER_FORM_JSP);
                actionRequest.setAttribute(AxHrmsAppraisalStatusMasterConstants.STATUS, status);
            }

        }
        SessionMessages.add(actionRequest, PortalUtil.getPortletId(actionRequest) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
    }

    private boolean isAppraisalStatusMasterAvailable(String status, long id) {
        try {
            status = StringUtil.lowerCase(status);
            AppraisalStatusMaster appraisalStatusMaster = appraisalStatusMasterLocalService.findBystatus(status);
            if(id > 0 && appraisalStatusMaster.getAppraisalStatusMasterId() == id){
                return true;
            }
            return false;
        } catch (NoSuchAppraisalStatusMasterException e) {
            return true;
        }
    }
}
