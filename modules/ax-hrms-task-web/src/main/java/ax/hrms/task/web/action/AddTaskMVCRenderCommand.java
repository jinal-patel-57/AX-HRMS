package ax.hrms.task.web.action;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.ax.hrms.common.api.api.AxHrmsCommonApi;
import com.ax.hrms.master.model.PriorityMaster;
import com.ax.hrms.master.model.ProjectTaskStatusMaster;
import com.ax.hrms.master.service.PriorityMasterLocalService;
import com.ax.hrms.master.service.ProjectTaskStatusMasterLocalService;
import com.ax.hrms.model.EmployeeDetails;
import com.ax.hrms.model.Project;
import com.ax.hrms.model.ProjectEmployeeDetails;
import com.ax.hrms.model.Task;
import com.ax.hrms.model.TaskReview;
import com.ax.hrms.model.TimeTracker;
import com.ax.hrms.service.AttachmentLocalService;
import com.ax.hrms.service.EmployeeDetailsLocalService;
import com.ax.hrms.service.ProjectEmployeeDetailsLocalService;
import com.ax.hrms.service.ProjectHistoryLocalService;
import com.ax.hrms.service.ProjectLocalService;
import com.ax.hrms.service.TaskLocalService;
import com.ax.hrms.service.TaskReviewLocalService;
import com.ax.hrms.service.TimeTrackerLocalService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import ax.hrms.task.web.constants.AxHrmsTaskWebConstants;
import ax.hrms.task.web.constants.AxHrmsTaskWebPortletKeys;
import ax.hrms.task.web.dto.TaskDto;
import ax.hrms.task.web.util.TaskWebUtil;

@Component(immediate = true, property = {
		"javax.portlet.name=" + AxHrmsTaskWebPortletKeys.AXHRMSTASKWEB ,
		"mvc.command.name="+AxHrmsTaskWebConstants.ADD_TASK}, service = MVCRenderCommand.class)

public class AddTaskMVCRenderCommand implements MVCRenderCommand{
	private static final Log log = LogFactoryUtil.getLog(AddTaskMVCRenderCommand.class);

	@Reference
	private PriorityMasterLocalService priorityMasterLocalService;
	
	@Reference
	private TaskLocalService taskLocalService;
	
	@Reference
	private ProjectTaskStatusMasterLocalService projectTaskStatusMasterLocalService;
	@Reference
	private AxHrmsCommonApi axHrmsCommonApi;
	
	@Reference
	private EmployeeDetailsLocalService employeeDetailsLocalService;
	@Reference
	 private ProjectLocalService projectLocalService;
	@Reference
	private ProjectEmployeeDetailsLocalService projectEmployeeDetailsLocalService;
	@Reference
	private TaskReviewLocalService taskReviewLocalService;
	
	@Reference
	private TimeTrackerLocalService timeTrackerLocalService;
	
	@Reference
	private AttachmentLocalService attachmentLocalService;
	
	@Reference
	private ProjectHistoryLocalService projectHistoryLocalService;
		
	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
try {
		long projectId = ParamUtil.getLong(renderRequest,AxHrmsTaskWebConstants.PROJECT_ID);
		long taskId = ParamUtil.getLong(renderRequest,AxHrmsTaskWebConstants.TASK_ID);
		if(Validator.isNotNull(taskId)) {
			TaskWebUtil taskWebUtil = new TaskWebUtil(employeeDetailsLocalService, projectEmployeeDetailsLocalService, axHrmsCommonApi, projectLocalService, taskLocalService, projectTaskStatusMasterLocalService, priorityMasterLocalService);
			
			TaskDto taskDto = taskWebUtil.getTaskData(taskId, false);
			renderRequest.setAttribute(AxHrmsTaskWebConstants.TASK_DTO,taskDto);
			renderRequest.setAttribute(AxHrmsTaskWebConstants.IS_TABLE_VISIBLE,true);
			List<TaskReview> taskReviewList = taskReviewLocalService.findByTaskId(taskId);
			
			renderRequest.setAttribute(AxHrmsTaskWebConstants.REVIEW_LIST,taskReviewList);
		}
		List<PriorityMaster> priorityList = priorityMasterLocalService.getPriorityMasters(-1, -1);
		long managerId  = projectHistoryLocalService.findByProjectId(projectId).getManagerId();
		List<Task> taskList = taskLocalService.findByProjectIdAndManagerId(projectId, managerId);
		List<ProjectTaskStatusMaster> statusList = projectTaskStatusMasterLocalService.getProjectTaskStatusMasters(-1,-1);
		
		
		
		List<ProjectEmployeeDetails> projectEmployeeList = projectEmployeeDetailsLocalService.findByProjectId(projectId);
		List<EmployeeDetails> employeeList = getEmployeeList(projectEmployeeList);
		
		boolean isManager = axHrmsCommonApi.isRolePerson(themeDisplay, AxHrmsTaskWebConstants.MANAGER);

		sendTimeTrackerData(renderRequest, themeDisplay, taskId, isManager);
		
		
		List<TaskReview> reviewList = taskReviewLocalService.findByTaskId(taskId);
		renderRequest.setAttribute(AxHrmsTaskWebConstants.REVIEW_LIST, reviewList);
		renderRequest.setAttribute(AxHrmsTaskWebConstants.PRIORITY_LIST, priorityList);
		renderRequest.setAttribute(AxHrmsTaskWebConstants.TASK_LIST, taskList);
		renderRequest.setAttribute(AxHrmsTaskWebConstants.STATUS_LIST,statusList);
		renderRequest.setAttribute(AxHrmsTaskWebConstants.EMPLOYEE_LIST,employeeList);
		renderRequest.setAttribute(AxHrmsTaskWebConstants.ITERATOR_URL,renderResponse.createRenderURL());

		Project project = projectLocalService.getProject(projectId);
		renderRequest.setAttribute(AxHrmsTaskWebConstants.PROJECT, project);
		renderRequest.setAttribute(AxHrmsTaskWebConstants.IS_MANAGER,isManager);
		
}catch(Exception e) {
	log.error("AddTaskMVCRenderCommand >>> render >>> "+ e.getMessage());
}
		
		return AxHrmsTaskWebConstants.ADD_EDIT_TASK_JSP;
	}

	public void sendTimeTrackerData(RenderRequest renderRequest, ThemeDisplay themeDisplay, long taskId,
			boolean isManager) {
		List<TimeTracker> timeTrackerList;
		try {
			if(isManager) {
				timeTrackerList = timeTrackerLocalService.findByTaskId(taskId);
			}else {
				timeTrackerList = timeTrackerLocalService.findByTaskIdAndEmployeeId(taskId, employeeDetailsLocalService.findByLrUserId(themeDisplay.getUserId()).getEmployeeId());
			}
			
			List<TaskDto> timeTrackerDtoList = getTimeTrackerData(timeTrackerList, themeDisplay);
			
			
			renderRequest.setAttribute(AxHrmsTaskWebConstants.TIME_TRACKER_DTO_LIST, timeTrackerDtoList);
					}
			catch(Exception e) {
				log.error("AddTaskMVCRenderCommand >>>listing of time tracker >>>  render >>>"+ e.getMessage());
			}
	}


	private List<EmployeeDetails> getEmployeeList(List<ProjectEmployeeDetails> projectEmployeeDetailsList) throws PortalException{
		List<EmployeeDetails> employeeList = new ArrayList<>();
		for(ProjectEmployeeDetails projectEmployee : projectEmployeeDetailsList) {
			EmployeeDetails employee = employeeDetailsLocalService.getEmployeeDetails(projectEmployee.getEmployeeId());
			employeeList.add(employee);
		}
		return employeeList;
	}
	
	
	private List<TaskDto> getTimeTrackerData(List<TimeTracker> timeTrackerList,ThemeDisplay themeDisplay) throws PortalException{
		List<TaskDto> timeDtoList = new ArrayList<>();
		TaskWebUtil taskWebUtil = new TaskWebUtil(employeeDetailsLocalService, axHrmsCommonApi, projectLocalService, taskLocalService, taskReviewLocalService, timeTrackerLocalService, attachmentLocalService);
		
		for(TimeTracker timeTracker : timeTrackerList) {
			timeDtoList.add(taskWebUtil.convertTimeTrackerDataIntoDto(timeTracker,themeDisplay));
		}
		return timeDtoList;
	}
}
