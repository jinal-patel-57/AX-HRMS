package ax.hrms.task.web.action;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.ax.hrms.common.api.api.AxHrmsCommonApi;
import com.ax.hrms.exception.NoSuchEmployeeDetailsException;
import com.ax.hrms.exception.NoSuchProjectException;
import com.ax.hrms.master.service.PriorityMasterLocalService;
import com.ax.hrms.master.service.ProjectTaskStatusMasterLocalService;
import com.ax.hrms.model.EmployeeDetails;
import com.ax.hrms.model.Project;
import com.ax.hrms.model.ProjectEmployeeDetails;
import com.ax.hrms.model.Task;
import com.ax.hrms.service.EmployeeDetailsLocalService;
import com.ax.hrms.service.ProjectEmployeeDetailsLocalService;
import com.ax.hrms.service.ProjectLocalService;
import com.ax.hrms.service.TaskLocalService;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.PortletURLUtil;
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
		"mvc.command.name="+AxHrmsTaskWebConstants.DEFAULT_PATH}, service = MVCRenderCommand.class)


public class ListProjectTaskMVCRenderCommand implements MVCRenderCommand {

	private static final Log log = LogFactoryUtil.getLog(ListProjectTaskMVCRenderCommand.class);

	@Reference
	private AxHrmsCommonApi axHrmsCommonApi;
	
	@Reference
	private ProjectEmployeeDetailsLocalService projectEmployeeDetailsLocalService;
	
	@Reference
	private ProjectLocalService projectLocalService;
	
	@Reference
	private EmployeeDetailsLocalService employeeDetailsLocalService;
	@Reference
	private TaskLocalService taskLocalService;
	@Reference
	private ProjectTaskStatusMasterLocalService projectTaskStatusMasterLocalService;
	@Reference
	private PriorityMasterLocalService priorityMasterLocalService;

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);

		try {
			long projectId = ParamUtil.getLong(renderRequest,AxHrmsTaskWebConstants.PROJECT_ID);	
			
			
			TaskWebUtil taskWebUtil = new TaskWebUtil(employeeDetailsLocalService, projectEmployeeDetailsLocalService,
					axHrmsCommonApi, projectLocalService, taskLocalService, projectTaskStatusMasterLocalService,
					priorityMasterLocalService);
			
			
			boolean isManager = axHrmsCommonApi.isRolePerson(themeDisplay, AxHrmsTaskWebConstants.MANAGER);
			renderRequest.setAttribute(AxHrmsTaskWebConstants.IS_MANAGER,isManager);
			List<Task> taskList = new ArrayList<>() ;
			List<TaskDto>taskDtoList ;
			
			if(Validator.isNotNull(projectId)) {
				

				Project project = projectLocalService.getProject(projectId);
				if(isManager) {
					
					taskList = taskLocalService.findByProjectIdAndManagerId(projectId, employeeDetailsLocalService.findByLrUserId(themeDisplay.getUserId()).getEmployeeId());
					
					
				}else {
//					taskList = taskLocalService.findByProjectIdAndAssigneeId(projectId, employeeDetailsLocalService.findByLrUserId(themeDisplay.getUserId()).getEmployeeId());
					taskList = taskLocalService.findByProjectId(projectId);
				}
				renderRequest.setAttribute(AxHrmsTaskWebConstants.PROJECT, project);		
				renderRequest.setAttribute(AxHrmsTaskWebConstants.IS_VISIBLE, true);
			
				
				
			}else {
				
				if(isManager) {
					
					taskList = taskLocalService.findByManagerId(employeeDetailsLocalService.findByLrUserId(themeDisplay.getUserId()).getEmployeeId());

					
				}else {
					List<ProjectEmployeeDetails> projectEmployeeDetailsList = projectEmployeeDetailsLocalService.findByEmployeeId(employeeDetailsLocalService.findByLrUserId(themeDisplay.getUserId()).getEmployeeId());
					List<Long> projectIdList = new ArrayList<>();
					for(ProjectEmployeeDetails projectEmployee : projectEmployeeDetailsList) {
						projectIdList.add(projectEmployee.getProjectId());
					}
					for(Long id : projectIdList) {
					
					taskList.addAll(taskLocalService.findByProjectId(id));
					}
					
//					taskList = taskLocalService.findByAssignedTo( employeeDetailsLocalService.findByLrUserId(themeDisplay.getUserId()).getEmployeeId());
				}
				
				
				
			}
			taskDtoList = getTaskList(taskList,taskWebUtil);
			PortletURL iteratorURL = PortletURLUtil.getCurrent(renderRequest, renderResponse);
			SearchContainer<TaskDto> taskSearchContainer = new SearchContainer<>(renderRequest, iteratorURL, null,
					StringPool.BLANK);
			taskSearchContainer.setResultsAndTotal(taskDtoList);
			renderRequest.setAttribute(AxHrmsTaskWebConstants.EMPLOYEE_ID,employeeDetailsLocalService.findByLrUserId(themeDisplay.getUserId()).getEmployeeId());

			renderRequest.setAttribute(AxHrmsTaskWebConstants.TASK_SEARCH_CONTAINER, taskSearchContainer);
			renderRequest.setAttribute(AxHrmsTaskWebConstants.ITERATOR_URL,renderResponse.createRenderURL());
		
		List<Project>projectList = fetchProjectList(themeDisplay);
		renderRequest.setAttribute(AxHrmsTaskWebConstants.PROJECT_LIST, projectList);
		}
		catch(Exception e) {
			e.printStackTrace();
			log.error("ListTaskMVCRenderComand >>> Render >>> "+ e.getMessage());
			
		}
		return AxHrmsTaskWebConstants.LIST_TASK_JSP;
	}
	
	private List<Project>fetchProjectList(ThemeDisplay themeDisplay) throws NoSuchEmployeeDetailsException, NoSuchProjectException{
		EmployeeDetails manager = employeeDetailsLocalService.findByLrUserId(themeDisplay.getUserId());
		List<ProjectEmployeeDetails> projectEmployeeDetailsList = projectEmployeeDetailsLocalService.findByEmployeeId(manager.getEmployeeId());
		List<Project> projetList =new ArrayList<>();
		
		
		for(ProjectEmployeeDetails projectemployeedetails : projectEmployeeDetailsList) {
			Project project = projectLocalService.findByProjectId(projectemployeedetails.getProjectId());
			projetList.add(project);
		}
		return projetList;
		
	}

	private List<TaskDto> getTaskList(List<Task> taskList,TaskWebUtil taskWebUtil) throws NoSuchProjectException, NoSuchEmployeeDetailsException{
		List<TaskDto> taskDtoList = new ArrayList<>();
		
		
		for(Task task: taskList) {
			TaskDto taskDto = taskWebUtil.convertDataIntoDto(task);
			taskDtoList.add(taskDto);
			
		}
		return taskDtoList;
	}

}
