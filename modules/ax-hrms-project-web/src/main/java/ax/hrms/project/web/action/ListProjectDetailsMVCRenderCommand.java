package ax.hrms.project.web.action;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.ax.hrms.common.api.api.AxHrmsCommonApi;
import com.ax.hrms.exception.NoSuchProjectException;
import com.ax.hrms.exception.NoSuchProjectHistoryException;
import com.ax.hrms.master.service.ProjectTaskStatusMasterLocalService;
import com.ax.hrms.model.Project;
import com.ax.hrms.model.ProjectEmployeeDetails;
import com.ax.hrms.service.EmployeeDetailsLocalService;
import com.ax.hrms.service.ProjectEmployeeDetailsLocalService;
import com.ax.hrms.service.ProjectHistoryLocalService;
import com.ax.hrms.service.ProjectLocalService;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.PortletURLUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.service.RoleLocalService;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;

import ax.hrms.project.web.constants.AxHrmsProjectWebConstants;
import ax.hrms.project.web.constants.AxHrmsProjectWebPortletKeys;
import ax.hrms.project.web.dto.ProjectDetailsDto;
import ax.hrms.project.web.util.ProjectWebUtil;

@Component(immediate = true, property = {
		"javax.portlet.name=" + AxHrmsProjectWebPortletKeys.AXHRMSPROJECTWEB,
		"mvc.command.name="+AxHrmsProjectWebConstants.DEFAULT_PATH}, service = MVCRenderCommand.class)


public class ListProjectDetailsMVCRenderCommand implements MVCRenderCommand{
	private static final Log log = LogFactoryUtil.getLog(ListProjectDetailsMVCRenderCommand.class);

	@Reference
	private ProjectLocalService projectLocalService;
	@Reference
	private ProjectHistoryLocalService projectHistoryLocalService;
	@Reference
	private ProjectEmployeeDetailsLocalService projectEmployeeDetailsLocalService;
	@Reference
	private EmployeeDetailsLocalService employeeDetailsLocalService;
	@Reference
	private ProjectTaskStatusMasterLocalService projectTaskStatusMasterLocalService;
	@Reference
	private AxHrmsCommonApi axHrmsCommonApi;
	@Reference
	private RoleLocalService roleLocalService;
	
	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse)  {
		
		try {
			ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);


			boolean isHRAdmin = axHrmsCommonApi.isRolePerson(themeDisplay, "HR Admin");
			 List<ProjectDetailsDto> projectDtoList = new ArrayList<>();
			if(isHRAdmin) {
				List<Project> projectList = projectLocalService.getProjects(-1,-1);
				projectDtoList = getProjectDataForHR(projectList);
				
				
				
			}else {
				List<ProjectEmployeeDetails> projectEmployeeList = projectEmployeeDetailsLocalService.findByEmployeeId(employeeDetailsLocalService.findByLrUserId(themeDisplay.getUserId()).getEmployeeId());
				projectDtoList = getProjectData(projectEmployeeList);
			}

		
		//Check is manager or not.?
		
		  PortletURL iteratorURL = PortletURLUtil.getCurrent(renderRequest, renderResponse);
			SearchContainer<ProjectDetailsDto> projectSearchContainer = new SearchContainer<>(renderRequest, iteratorURL, null,
					StringPool.BLANK);
			projectSearchContainer.setResultsAndTotal(projectDtoList);
			
			
			renderRequest.setAttribute(AxHrmsProjectWebConstants.PROJECT_SEARCH_CONTAINER, projectSearchContainer);
			
		
		

			
			renderRequest.setAttribute(AxHrmsProjectWebConstants.ITERATOR_URL,
					renderResponse.createRenderURL());
			boolean isManager= axHrmsCommonApi.isRolePerson(themeDisplay, AxHrmsProjectWebConstants.MANAGER);
			renderRequest.setAttribute(AxHrmsProjectWebConstants.IS_MANAGER,
					isManager);
			renderRequest.setAttribute(AxHrmsProjectWebConstants.IS_HRADMIN, isHRAdmin);
			

		} catch (Exception e) {
			log.error("ListProjectDetailsMVCRenderCommand >>> Render >>> " + e.getMessage());
		}
		return AxHrmsProjectWebConstants.LIST_PROJECT_DETAILS_JSP;
	}
	
	public List<ProjectDetailsDto> getProjectData(List<ProjectEmployeeDetails> projectEmployeeList) throws NoSuchProjectHistoryException, NoSuchProjectException {
		List<ProjectDetailsDto> projectDetailsDto =new ArrayList<>();
		ProjectWebUtil projectWebUtil = new ProjectWebUtil(projectLocalService, projectHistoryLocalService, projectEmployeeDetailsLocalService, employeeDetailsLocalService, projectTaskStatusMasterLocalService, axHrmsCommonApi);
		
		for(ProjectEmployeeDetails projectEmployeeDetails: projectEmployeeList ) {
			Project project = projectLocalService.findByProjectId(projectEmployeeDetails.getProjectId());
			ProjectDetailsDto projectDto = projectWebUtil.convertDataIntoProjectDetailsDto(project);
			projectDetailsDto.add(projectDto);
		}
		return projectDetailsDto;
		
	}
	public List<ProjectDetailsDto> getProjectDataForHR(List<Project> projectList) throws NoSuchProjectHistoryException{
		List<ProjectDetailsDto> projectDtoList = new ArrayList<>();
		ProjectWebUtil projectWebUtil = new ProjectWebUtil(projectLocalService, projectHistoryLocalService, projectEmployeeDetailsLocalService, employeeDetailsLocalService, projectTaskStatusMasterLocalService, axHrmsCommonApi);

		for(Project project : projectList) {
			ProjectDetailsDto projectDto = projectWebUtil.convertDataIntoProjectDetailsDto(project);
			projectDtoList.add(projectDto);
		}
		return projectDtoList;
	}
	

	
	}



	
	

