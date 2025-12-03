package com.ax.hrms.master.project.task.status.web.action;


import com.ax.hrms.master.model.ProjectTaskStatusMaster;
import com.ax.hrms.master.service.ProjectTaskStatusMasterLocalService;
import com.ax.hrms.master.web.constants.AxDocumentTypeMasterWebPortletConstants;
import com.ax.hrms.master.web.constants.AxHrmsMasterWebPortletKeys;
import com.ax.hrms.master.web.constants.AxHrmsProjectTaskStatusMasterConstants;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.WebKeys;
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
                "javax.portlet.name=" + AxHrmsMasterWebPortletKeys.AX_HRMS_PROJECT_TASK_STATUS_MASTER_WEB_PORTLET,
                "mvc.command.name=/addEditProjectTaskStatusMasterDetails"
        },
        service = MVCActionCommand.class
)
public class AddEditProjectTaskStatusMasterMVCActionCommand extends BaseMVCActionCommand {

    @Reference
    ProjectTaskStatusMasterLocalService projectTaskStatusMasterLocalService;
    @Override
    protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
        //getting variables from the action request
        String projectTaskStatusName = ParamUtil.getString(actionRequest, "projectTaskStatusName");
        boolean isApplicableForProject = ParamUtil.getBoolean(actionRequest, "isApplicableForProject");
        boolean isApplicableForTask = ParamUtil.getBoolean(actionRequest, "isApplicableForTask");
        long projectTaskStatusMasterId = ParamUtil.getLong(actionRequest, "projectTaskStatusMasterId");
        //getting variables from the action request Ends
        if(projectTaskStatusMasterId <= 0){ // Insertion Logic
            if(isProjectTaskStatusMasterAvailable(projectTaskStatusName, projectTaskStatusMasterId)){
                //insertion code
                ProjectTaskStatusMaster projectTaskStatusMaster = projectTaskStatusMasterLocalService.createProjectTaskStatusMaster(CounterLocalServiceUtil.increment(ProjectTaskStatusMaster.class.getName()));
                ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
                // audit Field Setting
                projectTaskStatusMaster.setCompanyId(themeDisplay.getCompanyId());
                projectTaskStatusMaster.setCreatedBy(themeDisplay.getUserId());
                projectTaskStatusMaster.setGroupId(themeDisplay.getCompanyGroupId());
                projectTaskStatusMaster.setCreateDate(new Date());
                projectTaskStatusMaster.setModifiedDate(new Date());
                // data fields
                projectTaskStatusMaster.setIsApplicableForProject(isApplicableForProject);
                projectTaskStatusMaster.setIsApplicableForTask(isApplicableForTask);
                projectTaskStatusMaster.setProjectTaskStatusName(projectTaskStatusName);
                // inserting record
                projectTaskStatusMasterLocalService.addProjectTaskStatusMaster(projectTaskStatusMaster);
                SessionMessages.add(actionRequest, AxHrmsProjectTaskStatusMasterConstants.SUCCESS); // Setting success key to actionRequest

            } else {
                ProjectTaskStatusMaster projectTaskStatusMaster = projectTaskStatusMasterLocalService.createProjectTaskStatusMaster(CounterLocalServiceUtil.increment(ProjectTaskStatusMaster.class.getName()));
                SessionErrors.add(actionRequest, AxHrmsProjectTaskStatusMasterConstants.ERROR_ALREADY_EXIST); // setting error key to actionRequest
                actionResponse.setRenderParameter(AxDocumentTypeMasterWebPortletConstants.MVC_PATH_PARAMETER, AxHrmsProjectTaskStatusMasterConstants.PROJECT_TASK_STATUS_MASTER_FORM_JSP);
                actionRequest.setAttribute(AxHrmsProjectTaskStatusMasterConstants.STATUS, projectTaskStatusName);

            }
        }
        else{ // Editing Logic
            if(isProjectTaskStatusMasterAvailable(projectTaskStatusName,projectTaskStatusMasterId)){
                ProjectTaskStatusMaster projectTaskStatusMaster;
                projectTaskStatusMaster = projectTaskStatusMasterLocalService.getProjectTaskStatusMaster(projectTaskStatusMasterId);
                ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);

                projectTaskStatusMaster.setModifiedBy(themeDisplay.getUserId());
                projectTaskStatusMaster.setModifiedDate(new Date());
                projectTaskStatusMaster.setIsApplicableForProject(isApplicableForProject);
                projectTaskStatusMaster.setIsApplicableForTask(isApplicableForTask);
                projectTaskStatusMaster.setProjectTaskStatusName(projectTaskStatusName);

                projectTaskStatusMasterLocalService.updateProjectTaskStatusMaster(projectTaskStatusMaster);
                SessionMessages.add(actionRequest, AxHrmsProjectTaskStatusMasterConstants.SUCCESS_EDIT); // setting error key to actionRequest

            }

        }
        SessionMessages.add(actionRequest, PortalUtil.getPortletId(actionRequest) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
    }

    private boolean isProjectTaskStatusMasterAvailable(String projectTaskStatusName, long id){
        try {
            projectTaskStatusName = StringUtil.lowerCase(projectTaskStatusName);
            ProjectTaskStatusMaster projectTaskStatusMaster;
            projectTaskStatusMaster = projectTaskStatusMasterLocalService.findByProjectTaskStatusName(projectTaskStatusName);
            return id > 0 && projectTaskStatusMaster.getProjectTaskStatusMasterId() == id;
        }catch (Exception e){
            return true;
        }
    }

}



