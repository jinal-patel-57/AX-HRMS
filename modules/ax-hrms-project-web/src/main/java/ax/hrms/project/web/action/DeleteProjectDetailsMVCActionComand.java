package ax.hrms.project.web.action;

import java.io.IOException;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.ax.hrms.model.ProjectEmployeeDetails;
import com.ax.hrms.model.Task;
import com.ax.hrms.model.TaskReview;
import com.ax.hrms.service.ProjectEmployeeDetailsLocalService;
import com.ax.hrms.service.ProjectHistoryLocalService;
import com.ax.hrms.service.ProjectLocalService;
import com.ax.hrms.service.TaskLocalService;
import com.ax.hrms.service.TaskReviewLocalService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;

import ax.hrms.project.web.constants.AxHrmsProjectWebConstants;
import ax.hrms.project.web.constants.AxHrmsProjectWebPortletKeys;

@Component(immediate = true, property = {
		"javax.portlet.name=" + AxHrmsProjectWebPortletKeys.AXHRMSPROJECTWEB,
		"mvc.command.name="+AxHrmsProjectWebConstants.DELETE_PROJECT}, service = MVCActionCommand.class)


public class DeleteProjectDetailsMVCActionComand extends BaseMVCActionCommand{

	private static final Log log = LogFactoryUtil.getLog(DeleteProjectDetailsMVCActionComand.class);

	@Reference
	private ProjectLocalService projectLocalService;
	@Reference
	private ProjectEmployeeDetailsLocalService projectEmployeeDetailsLocalService;
	
	@Reference
	private ProjectHistoryLocalService projectHistoryLocalService;
	
	@Reference
	private TaskLocalService taskLocalService;
	
	@Reference
	private TaskReviewLocalService taskReviewLocalService;
	
	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws PortalException, IOException  {
		
		long projectId = ParamUtil.getLong(actionRequest,AxHrmsProjectWebConstants.PROJECT_ID);
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
		try {
		//DELETE DATA FROM PROJECT
		projectLocalService.deleteProject(projectId);
		
		//DELETE DATA FROM PROJECT EMPLOYEE DETAILS
		List<ProjectEmployeeDetails> projectEmployeeList = projectEmployeeDetailsLocalService.findByProjectId(projectId);
		for(ProjectEmployeeDetails projectEmployeeDetails: projectEmployeeList) {
			
		projectEmployeeDetailsLocalService.deleteProjectEmployeeDetails(projectEmployeeDetails.getProjectEmployeeDetailsId());
		}
		
		//DELETE DATA FROM PROJECT HISTORY
		
		projectHistoryLocalService.deleteProjectHistory(projectHistoryLocalService.findByProjectId(projectId).getProjectHistoryId());
		
		//DELETE DATA FROM TASK TABLE
		List<Task> taskList = taskLocalService.findByProjectId(projectId);
		for(Task task : taskList) {
			taskLocalService.deleteTask(task.getTaskId());
			//DELETE DATA FROM TASK REVIEW TABLE
			List<TaskReview> taskReviewList = taskReviewLocalService.findByTaskId(task.getTaskId());
			for(TaskReview taskReview : taskReviewList) {
				taskReviewLocalService.deleteTaskReview(taskReview.getTaskReviewId());
			}

		}
		SessionMessages.add(actionRequest,AxHrmsProjectWebConstants.DELETE_PROJECT_MESSAGE);

		}catch(Exception e) {
			SessionErrors.add(actionRequest,AxHrmsProjectWebConstants.ERROR_MESSAGE);

			log.error("DeleteProjectDetailsMVCActionComand >>> Delete Action >>> "+ e.getMessage());
		}
		
		
		
		
		actionResponse.sendRedirect(PortalUtil.getLayoutFullURL(themeDisplay));
	}

}
