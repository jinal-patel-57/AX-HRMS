package com.ax.hrms.master.project.task.status.web.action;


import com.ax.hrms.master.model.ProjectTaskStatusMaster;
import com.ax.hrms.master.service.ProjectTaskStatusMasterLocalService;
import com.ax.hrms.master.service.ProjectTaskStatusMasterLocalServiceUtil;
import com.ax.hrms.master.web.constants.AxHrmsMasterWebPortletKeys;
import com.ax.hrms.master.web.constants.AxHrmsProjectTaskStatusMasterConstants;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.portlet.PortletURLUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.PortletException;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

/**
 * Author: Nivid Koradiya
 */
@Component(
        property = {
                "javax.portlet.name=" + AxHrmsMasterWebPortletKeys.AX_HRMS_PROJECT_TASK_STATUS_MASTER_WEB_PORTLET,
                "mvc.command.name=/"
        },
        service = MVCRenderCommand.class
)
public class ListProjectTaskStatusMasterMVCRenderCommand implements MVCRenderCommand {

    @Reference
    ProjectTaskStatusMasterLocalService projectTaskStatusMasterLocalService;
    @Override
    public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {

        //setting search container
        PortletURL iteratorURL = PortletURLUtil.getCurrent(renderRequest, renderResponse);
        SearchContainer<ProjectTaskStatusMaster> customerOrderSearchContainer = new SearchContainer<>(renderRequest, iteratorURL,
                null, StringPool.BLANK); // New search container
        customerOrderSearchContainer.setEmptyResultsMessage(AxHrmsProjectTaskStatusMasterConstants.NO_PROJECT_TASK_STATUS_MASTER);
        customerOrderSearchContainer.setDeltaConfigurable(true); // Setting the delta configurable to true
        customerOrderSearchContainer.setResultsAndTotal(projectTaskStatusMasterLocalService.getProjectTaskStatusMasters(-1,-1)); // Loading all records on the Search Container
        renderRequest.setAttribute(AxHrmsProjectTaskStatusMasterConstants.PROJECT_TASK_STATUS_MASTER_SC, customerOrderSearchContainer);
        renderRequest.setAttribute(AxHrmsProjectTaskStatusMasterConstants.COUNT, ProjectTaskStatusMasterLocalServiceUtil.getProjectTaskStatusMastersCount());
        // END setting search container

        return  AxHrmsProjectTaskStatusMasterConstants.PROJECT_TASK_STATUS_MASTER_LIST_JSP;
    }
}
