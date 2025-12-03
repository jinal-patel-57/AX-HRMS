package ax.hrms.project.web.action;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.ax.hrms.common.api.api.AxHrmsCommonApi;
import com.ax.hrms.exception.NoSuchEmployeeDetailsException;
import com.ax.hrms.master.model.ProjectTaskStatusMaster;
import com.ax.hrms.master.service.ProjectTaskStatusMasterLocalService;
import com.ax.hrms.model.EmployeeDetails;
import com.ax.hrms.model.Project;
import com.ax.hrms.model.ProjectEmployeeDetails;
import com.ax.hrms.service.EmployeeDetailsLocalService;
import com.ax.hrms.service.ProjectEmployeeDetailsLocalService;
import com.ax.hrms.service.ProjectHistoryLocalService;
import com.ax.hrms.service.ProjectLocalService;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;

import ax.hrms.project.web.constants.AxHrmsProjectWebConstants;
import ax.hrms.project.web.constants.AxHrmsProjectWebPortletKeys;
import ax.hrms.project.web.dto.ProjectDetailsDto;
import ax.hrms.project.web.util.ProjectWebUtil;

@Component(immediate = true, property = {
		"javax.portlet.name=" + AxHrmsProjectWebPortletKeys.AXHRMSPROJECTWEB,
		"mvc.command.name="+AxHrmsProjectWebConstants.FETCH_PROJECT_DETAILS}, service = MVCRenderCommand.class)


public class FetchProjectDetailsMVCRenderCommand implements MVCRenderCommand {
	private static final Log log = LogFactoryUtil.getLog(FetchProjectDetailsMVCRenderCommand.class);


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
	
	
	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse)  {

		long projectId = ParamUtil.getLong(renderRequest,AxHrmsProjectWebConstants.PROJECT_ID);
		String command = ParamUtil.getString(renderRequest,AxHrmsProjectWebConstants.COMMAND);
		ProjectWebUtil projectWebUtil = new ProjectWebUtil(projectLocalService, projectHistoryLocalService, projectEmployeeDetailsLocalService, employeeDetailsLocalService, projectTaskStatusMasterLocalService, axHrmsCommonApi);
		
				
	
		try {
			
			List<EmployeeDetails> employeeList  = employeeDetailsLocalService.findByIsTerminated(false);

			List<ProjectTaskStatusMaster> statusList = projectTaskStatusMasterLocalService.getProjectTaskStatusMasters(-1,-1);
			
			
			
			renderRequest.setAttribute(AxHrmsProjectWebConstants.EMPLOYEE_LIST, employeeList);
			renderRequest.setAttribute(AxHrmsProjectWebConstants.STATUS_LIST, statusList);
			
			
			Project project = projectLocalService.findByProjectId(projectId);
			ProjectDetailsDto projectDto = projectWebUtil.convertDataIntoProjectDetailsDto(project);
			List<ProjectEmployeeDetails> projectEmployeeDetailsList = projectEmployeeDetailsLocalService.findByProjectId(projectId);
			
			
			long managerId = projectHistoryLocalService.findByProjectId(projectId).getManagerId();
			List<EmployeeDetails> assigneeList = getAssigneeData(projectEmployeeDetailsList,managerId);
			
			assigneeList.remove(employeeDetailsLocalService.findByEmployeeId(managerId));
			String listOfAssignee = setListOfAssignee(assigneeList);

			renderRequest.setAttribute(AxHrmsProjectWebConstants.ASSIGNEE_LIST, assigneeList);
			renderRequest.setAttribute(AxHrmsProjectWebConstants.PROJECT_DTO, projectDto);
			
			
			if(Validator.isNotNull(command)) {
				
				renderRequest.setAttribute(AxHrmsProjectWebConstants.LIST_OF_ASSIGNEE, listOfAssignee);
				return AxHrmsProjectWebConstants.ADD_PROJECT_DETAILS_JSP;
			}
		} catch (Exception e) {
			log.error("FetchProjectDetailsMVCRenderCommand >>> Render >>> "+ e.getMessage());
		} 
		
		return AxHrmsProjectWebConstants.VIEW_PROJECT_DETAILS_JSP;
	}

	private List<EmployeeDetails> getAssigneeData(List<ProjectEmployeeDetails> projectEmployeeList,long managerId) throws NoSuchEmployeeDetailsException{
		
		List<EmployeeDetails> employeeList = new ArrayList<>();
		
		for(ProjectEmployeeDetails projectEmployee : projectEmployeeList ) {
			
			EmployeeDetails employee = employeeDetailsLocalService.findByEmployeeId(projectEmployee.getEmployeeId());
			employeeList.add(employee);			
		}
		
		employeeList.add(employeeDetailsLocalService.findByEmployeeId(managerId));
		return employeeList;
		
	}

	
	private String setListOfAssignee(List<EmployeeDetails> assigneeList) {
		StringBuilder listOfAssignee = new StringBuilder();
         int i=1;
         for(EmployeeDetails employee  : assigneeList){
             listOfAssignee.append(employee.getEmployeeId());
			 if(i != assigneeList.size()){
				 listOfAssignee.append(",");
			 }
			 i++;
         }
		
		return listOfAssignee.toString();
	}
}
