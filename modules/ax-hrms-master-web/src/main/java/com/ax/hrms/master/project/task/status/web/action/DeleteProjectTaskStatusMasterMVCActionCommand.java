package com.ax.hrms.master.project.task.status.web.action;


import com.ax.hrms.master.service.ProjectTaskStatusMasterLocalService;
import com.ax.hrms.master.web.constants.AxHrmsMasterWebPortletKeys;
import com.ax.hrms.master.web.constants.AxHrmsProjectTaskStatusMasterConstants;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

/**

 Author: Nivid Koradiya
 */
@Component(
        property = {
                "javax.portlet.name=" + AxHrmsMasterWebPortletKeys.AX_HRMS_PROJECT_TASK_STATUS_MASTER_WEB_PORTLET,
                "mvc.command.name=/deleteProjectTaskStatusMaster"
        },
        service = MVCActionCommand.class
)
public class DeleteProjectTaskStatusMasterMVCActionCommand extends BaseMVCActionCommand {

    @Reference
    ProjectTaskStatusMasterLocalService projectTaskStatusMasterLocalService;
    @Override
    protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
        long projectTaskStatusMasterId = ParamUtil.getLong(actionRequest, "projectTaskStatusMasterId");
        projectTaskStatusMasterLocalService.deleteProjectTaskStatusMaster(projectTaskStatusMasterId);
        String iteratorURL = ParamUtil.getString(actionRequest, AxHrmsProjectTaskStatusMasterConstants.ITERATOR_URL);
        SessionMessages.add(actionRequest, AxHrmsProjectTaskStatusMasterConstants.SUCCESS_DELETE);
        actionResponse.sendRedirect(iteratorURL);
    }
}
