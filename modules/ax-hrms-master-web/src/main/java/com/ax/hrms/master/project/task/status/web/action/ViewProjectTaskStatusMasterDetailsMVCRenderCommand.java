package com.ax.hrms.master.project.task.status.web.action;


import com.ax.hrms.master.model.ProjectTaskStatusMaster;
import com.ax.hrms.master.service.ProjectTaskStatusMasterLocalService;
import com.ax.hrms.master.web.constants.AxHrmsMasterWebPortletKeys;
import com.ax.hrms.master.web.constants.AxHrmsProjectTaskStatusMasterConstants;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

/**
 * Author: Nivid Koradiya
 */
@Component(
        property = {
                "javax.portlet.name=" + AxHrmsMasterWebPortletKeys.AX_HRMS_PROJECT_TASK_STATUS_MASTER_WEB_PORTLET,
                "mvc.command.name=/viewProjectTaskStatusMaster"
        },
        service = MVCRenderCommand.class
)
public class ViewProjectTaskStatusMasterDetailsMVCRenderCommand implements MVCRenderCommand {

    @Reference
    ProjectTaskStatusMasterLocalService projectTaskStatusMasterLocalService;
    @Override
    public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {

        long projectTaskStatusMasterId = ParamUtil.getLong(renderRequest, "projectTaskStatusMasterId");
        ProjectTaskStatusMaster projectTaskStatusMaster=null;
        try {
            projectTaskStatusMaster = projectTaskStatusMasterLocalService.getProjectTaskStatusMaster(projectTaskStatusMasterId);
        } catch (PortalException e) {
            Log log = LogFactoryUtil.getLog(FetchProjectTaskStatusMasterMVCRenderCommand.class);
            log.error(e);
        }
        renderRequest.setAttribute(AxHrmsProjectTaskStatusMasterConstants.PROJECT_TASK_STATUS_MASTER, projectTaskStatusMaster);
        return AxHrmsProjectTaskStatusMasterConstants.PROJECT_TASK_STATUS_MASTER_VIEW_JSP;
    }
}
