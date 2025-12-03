package ax.hrms.project.web.util;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.portlet.ActionRequest;

import com.ax.hrms.common.api.api.AxHrmsCommonApi;
import com.ax.hrms.exception.NoSuchEmployeeDetailsException;
import com.ax.hrms.exception.NoSuchProjectHistoryException;
import com.ax.hrms.mail.template.config.configuration.MailTemplateConfiguration;
import com.ax.hrms.master.service.ProjectTaskStatusMasterLocalService;
import com.ax.hrms.model.EmployeeDetails;
import com.ax.hrms.model.Project;
import com.ax.hrms.model.ProjectEmployeeDetails;
import com.ax.hrms.model.ProjectHistory;
import com.ax.hrms.notification.template.config.configuration.NotificationTemplateConfiguration;
import com.ax.hrms.service.EmployeeDetailsLocalService;
import com.ax.hrms.service.ProjectEmployeeDetailsLocalService;
import com.ax.hrms.service.ProjectHistoryLocalService;
import com.ax.hrms.service.ProjectLocalService;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.model.UserNotificationDeliveryConstants;
import com.liferay.portal.kernel.model.UserNotificationEvent;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserNotificationEventLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PrefsPropsUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.WebKeys;

import ax.hrms.project.web.constants.AxHrmsProjectWebConstants;
import ax.hrms.project.web.constants.AxHrmsProjectWebPortletKeys;
import ax.hrms.project.web.dto.ProjectDetailsDto;
import ax.hrms.project.web.notification.SendNotificationToUserHandler;


public class ProjectWebUtil {

	
	private final ProjectLocalService projectLocalService;
	private final ProjectHistoryLocalService projectHistoryLocalService;
	private final ProjectEmployeeDetailsLocalService projectEmployeeDetailsLocalService;
	private final EmployeeDetailsLocalService employeeDetailsLocalService;
	private final ProjectTaskStatusMasterLocalService projectTaskStatusMasterLocalService;
	private final AxHrmsCommonApi axHrmsCommonApi;
	private  MailTemplateConfiguration mailTemplateConfiguration ;
	
	
	

	public ProjectWebUtil(ProjectLocalService projectLocalService,
			ProjectHistoryLocalService projectHistoryLocalService,
			ProjectEmployeeDetailsLocalService projectEmployeeDetailsLocalService,
			EmployeeDetailsLocalService employeeDetailsLocalService,
			ProjectTaskStatusMasterLocalService projectTaskStatusMasterLocalService, AxHrmsCommonApi axHrmsCommonApi) {
		super();
		this.projectLocalService = projectLocalService;
		this.projectHistoryLocalService = projectHistoryLocalService;
		this.projectEmployeeDetailsLocalService = projectEmployeeDetailsLocalService;
		this.employeeDetailsLocalService = employeeDetailsLocalService;
		this.projectTaskStatusMasterLocalService = projectTaskStatusMasterLocalService;
		this.axHrmsCommonApi = axHrmsCommonApi;
	}
	
	

	public ProjectWebUtil(ProjectLocalService projectLocalService,
			ProjectHistoryLocalService projectHistoryLocalService,
			ProjectEmployeeDetailsLocalService projectEmployeeDetailsLocalService,
			EmployeeDetailsLocalService employeeDetailsLocalService,
			ProjectTaskStatusMasterLocalService projectTaskStatusMasterLocalService, AxHrmsCommonApi axHrmsCommonApi,
			MailTemplateConfiguration mailTemplateConfiguration) {
		super();
		this.projectLocalService = projectLocalService;
		this.projectHistoryLocalService = projectHistoryLocalService;
		this.projectEmployeeDetailsLocalService = projectEmployeeDetailsLocalService;
		this.employeeDetailsLocalService = employeeDetailsLocalService;
		this.projectTaskStatusMasterLocalService = projectTaskStatusMasterLocalService;
		this.axHrmsCommonApi = axHrmsCommonApi;
		this.mailTemplateConfiguration = mailTemplateConfiguration;
	}



	public ProjectDetailsDto convertDataIntoProjectDetailsDto(Project project) throws NoSuchProjectHistoryException {

		ProjectDetailsDto projectDto = new ProjectDetailsDto();
		projectDto.setProjectId(project.getProjectId());
		projectDto.setProjectName(project.getProjectName());
		projectDto.setDescription(project.getDescription());
		
		
		ProjectHistory projectHistroy = projectHistoryLocalService.findByProjectId(project.getProjectId());
		projectDto.setStartDate(axHrmsCommonApi.setDateFormat(projectHistroy.getStartDate()));
		projectDto.setStartDateOfProject(projectHistroy.getStartDate());
		projectDto.setProjectStatus(projectTaskStatusMasterLocalService.fetchProjectTaskStatusMaster(projectHistroy.getProjectTaskStatusMasterId()).getProjectTaskStatusName());
		
		projectDto.setIsBillable(projectHistroy.getIsBillble() ? AxHrmsProjectWebConstants.YES : AxHrmsProjectWebConstants.NO);

		
		return projectDto;
	}
	
	public void addUpdate(ActionRequest actionRequest,boolean isUpdate,NotificationTemplateConfiguration notificationTemplateConfiguration) throws Exception {
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long projectId = ParamUtil.getLong(actionRequest, AxHrmsProjectWebConstants.PROJECT_ID);
		String projectName = ParamUtil.getString(actionRequest, AxHrmsProjectWebConstants.PROJECT_NAME);
		String description = ParamUtil.getString(actionRequest, AxHrmsProjectWebConstants.DESCRIPTION);
		long projectTaskStatusMasterId = ParamUtil.getLong(actionRequest, AxHrmsProjectWebConstants.PROJECT_STATUS);
		SimpleDateFormat sdf = new SimpleDateFormat(AxHrmsProjectWebConstants.DATE_FORMATER);
		Date startDate = ParamUtil.getDate(actionRequest,AxHrmsProjectWebConstants.START_DATE,sdf);
		String isBillable = ParamUtil.getString(actionRequest, AxHrmsProjectWebConstants.IS_BILLABLE);
		String employeesId = ParamUtil.getString(actionRequest, AxHrmsProjectWebConstants.TEAM_ID);

			Project project = setProjectData(projectId,projectName,description, themeDisplay,isUpdate);
			setProjectHistroyData(projectTaskStatusMasterId,startDate,isBillable, themeDisplay, project,isUpdate);
			
			//SET DATA IN THE PROJECT EMPLOYEE DETAILS OF MANAGER
			
			setManagerDataInProjectEmployeeDetails(themeDisplay, project,isUpdate,notificationTemplateConfiguration);
			
			
			//SET THE EMPLOYEE DATA WHICH IS INCLUDED IN PROJECT
			ProjectDetailsDto projectDto = setDataIntoProjectDto(actionRequest,themeDisplay.getUserId());
			setEmployeesDataInProjectEmployeeDetails(themeDisplay, project, employeesId,projectDto,isUpdate,notificationTemplateConfiguration);

			
			
		 
	}

	public void setEmployeesDataInProjectEmployeeDetails(ThemeDisplay themeDisplay, Project project,String employeesId,ProjectDetailsDto projectDto,boolean isUpdate,NotificationTemplateConfiguration notificationTemplateConfiguration) throws Exception {
		
		String fromName = PrefsPropsUtil.getString(themeDisplay.getCompanyId(), PropsKeys.ADMIN_EMAIL_FROM_NAME);
		String fromEmailAddress = PrefsPropsUtil.getString(themeDisplay.getCompanyId(),PropsKeys.ADMIN_EMAIL_FROM_ADDRESS);
		
		ProjectEmployeeDetails projectEmployeeDetails;
		EmployeeDetails managerPerson = employeeDetailsLocalService.findByLrUserId(themeDisplay.getUserId());
		String managerName = employeeDetailsLocalService.findByLrUserId(themeDisplay.getUserId()).getFirstName()+AxHrmsProjectWebConstants.SPACE+employeeDetailsLocalService.findByLrUserId(themeDisplay.getUserId()).getLastName();
		List<String> employeesIdList = new ArrayList<>(Arrays.asList(employeesId.split(AxHrmsProjectWebConstants.COMMA)));
		List<EmployeeDetails> newAssigneeList = new ArrayList<>(); 
		
		

		for(String id:employeesIdList) {
			newAssigneeList.add(employeeDetailsLocalService.findByEmployeeId(Long.parseLong(id)));			
		}
		newAssigneeList.remove(managerPerson);
		StringBuilder mailBody = new StringBuilder(AxHrmsProjectWebConstants.PROJECT_MAIL_HEAD);

		if(isUpdate) {
		
			List<ProjectEmployeeDetails> projectEmployeeList = projectEmployeeDetailsLocalService.findByProjectId(project.getProjectId());
			
			List<EmployeeDetails> oldAssigneeList = new ArrayList<>();
			for(ProjectEmployeeDetails projectEmployee : projectEmployeeList) {
				oldAssigneeList.add(employeeDetailsLocalService.findByEmployeeId(projectEmployee.getEmployeeId()));
			}
			long managerId = projectHistoryLocalService.findByProjectId(project.getProjectId()).getManagerId();
			oldAssigneeList.remove(employeeDetailsLocalService.findByEmployeeId(managerId));
			List<EmployeeDetails> removeAssigneeList = new ArrayList<>(oldAssigneeList);
			removeAssigneeList.removeAll(newAssigneeList);
			newAssigneeList.removeAll(oldAssigneeList);
			
			StringBuilder body= new StringBuilder();
			body.append(AxHrmsProjectWebConstants.NOTIFICATION_OF_REMOVE_ASSIGNEE_PART_1).append(project.getProjectName()).append(AxHrmsProjectWebConstants.NOTIFICATION_OF_ASSIGNEE_PART_2).append(managerName);
			String subject = AxHrmsProjectWebConstants.SUBJECT_OF_REMOVE_ASSIGNEE;
			StringBuilder removeAssigneeMailBody = new StringBuilder(AxHrmsProjectWebConstants.PROJECT_MAIL_HEAD);
			removeAssigneeMailBody.append(AxHrmsProjectWebConstants.PROJECT_REMOVE_MAIL_CONTENTLINE);
			
			String notificationContent = notificationTemplateConfiguration.notificationProjectRemovedEmployee();
			notificationContent = notificationContent.replace("${PROJECT_NAME}", project.getProjectName());
			notificationContent = notificationContent.replace("${MANAGER_NAME}", managerPerson.getFirstName()+StringPool.SPACE+managerPerson.getLastName());

			for(EmployeeDetails removeAssignee : removeAssigneeList) {
				projectEmployeeDetailsLocalService.deleteProjectEmployeeDetails(projectEmployeeDetailsLocalService.findByProjectIdAndEmployeeId(project.getProjectId(), removeAssignee.getEmployeeId()));
				sendEmailToEmployee(projectDto,removeAssignee.getEmployeeId(),fromName,fromEmailAddress,false);

				sendNotificationToEmployee(removeAssignee.getEmployeeId(), notificationContent);
				
			}			
		
		}
		StringBuilder body= new StringBuilder();
		body.append(AxHrmsProjectWebConstants.NOTIFICATION_OF_NEW_ASSIGNEE_PART_1).append(project.getProjectName()).append(AxHrmsProjectWebConstants.NOTIFICATION_OF_ASSIGNEE_PART_2).append(managerName);
			
			
			String subject = AxHrmsProjectWebConstants.SUBJECT_OF_NEW_ASSIGNEE;
			mailBody.append(AxHrmsProjectWebConstants.PROJECT_ASSIGNE_MAIL_CONTENTLINE);
			String notificationContent = notificationTemplateConfiguration.notificationProjectAssignedEmployee();
			notificationContent = notificationContent.replace("${PROJECT_NAME}", project.getProjectName());
			notificationContent = notificationContent.replace("${MANAGER_NAME}", managerPerson.getFirstName()+StringPool.SPACE+managerPerson.getLastName());


			for(EmployeeDetails employee: newAssigneeList) {
				projectEmployeeDetails = projectEmployeeDetailsLocalService.createProjectEmployeeDetails(CounterLocalServiceUtil.increment(ProjectEmployeeDetails.class.getName()));
				projectEmployeeDetails.setProjectId(project.getProjectId());
				
				//-->set audit field of project employee details
				projectEmployeeDetails.setCompanyId(themeDisplay.getCompanyId());
				projectEmployeeDetails.setGroupId(themeDisplay.getCompanyGroupId());
				projectEmployeeDetails.setCreateDate(new Date());
				projectEmployeeDetails.setModifiedDate(new Date());
				projectEmployeeDetails.setCreatedBy(themeDisplay.getUserId());
				projectEmployeeDetails.setModifiedBy(themeDisplay.getUserId());
				projectEmployeeDetails.setEmployeeId(employee.getEmployeeId());
				projectEmployeeDetailsLocalService.addProjectEmployeeDetails(projectEmployeeDetails);
				sendEmailToEmployee(projectDto,employee.getEmployeeId(),fromName,fromEmailAddress,true);

				sendNotificationToEmployee(employee.getEmployeeId(), notificationContent);
		
		}

	}

	public void setManagerDataInProjectEmployeeDetails(ThemeDisplay themeDisplay, Project project,boolean isUpdate,NotificationTemplateConfiguration notificationTemplateConfiguration)
			throws Exception {
		ProjectEmployeeDetails projectEmployeeDetails;

		if(isUpdate) {
			String notificationContent = notificationTemplateConfiguration.notificationUpdateProjectManager();
			notificationContent = notificationContent.replace("${PROJECT_NAME}", project.getProjectName());
			projectEmployeeDetails = projectEmployeeDetailsLocalService.getProjectEmployeeDetails(projectEmployeeDetailsLocalService.findByProjectIdAndEmployeeId(project.getProjectId(), employeeDetailsLocalService.findByLrUserId(themeDisplay.getUserId()).getEmployeeId()).getProjectEmployeeDetailsId());
			projectEmployeeDetails.setModifiedDate(new Date());
			projectEmployeeDetails.setModifiedBy(themeDisplay.getUserId());
			projectEmployeeDetails.setEmployeeId(employeeDetailsLocalService.findByLrUserId(themeDisplay.getUserId()).getEmployeeId());
			projectEmployeeDetailsLocalService.updateProjectEmployeeDetails(projectEmployeeDetails);
			String body = AxHrmsProjectWebConstants.NOTIFICATION_UPDATE_BODY;
			sendNotificationToEmployee(projectEmployeeDetails.getEmployeeId(), notificationContent);

			
		}
		else {
		projectEmployeeDetails = projectEmployeeDetailsLocalService.createProjectEmployeeDetails(CounterLocalServiceUtil.increment(ProjectEmployeeDetails.class.getName()));
		projectEmployeeDetails.setProjectId(project.getProjectId());
		
		//-->set audit field of project employee details
		projectEmployeeDetails.setCompanyId(themeDisplay.getCompanyId());
		projectEmployeeDetails.setGroupId(themeDisplay.getCompanyGroupId());
		projectEmployeeDetails.setCreateDate(new Date());
		projectEmployeeDetails.setModifiedDate(new Date());
		projectEmployeeDetails.setCreatedBy(themeDisplay.getUserId());
		projectEmployeeDetails.setModifiedBy(themeDisplay.getUserId());
		projectEmployeeDetails.setEmployeeId(employeeDetailsLocalService.findByLrUserId(themeDisplay.getUserId()).getEmployeeId());
		projectEmployeeDetailsLocalService.addProjectEmployeeDetails(projectEmployeeDetails);
		
		String notificationContent = notificationTemplateConfiguration.notificationAddProjectManager();
		notificationContent = notificationContent.replace("${PROJECT_NAME}", project.getProjectName());


		String body = AxHrmsProjectWebConstants.NOTIFICATION_ADD_BODY;
		System.out.println("notification :"+ notificationContent);

		sendNotificationToEmployee(projectEmployeeDetails.getEmployeeId(), notificationContent);
		}
	}

	public void setProjectHistroyData(long projectTaskStatusMasterId , Date startDate,String isBillable, ThemeDisplay themeDisplay, Project project,boolean isUpdate)
			throws PortalException {
		ProjectHistory projectHistory;
		if(isUpdate) {
			 projectHistory = projectHistoryLocalService.getProjectHistory(projectHistoryLocalService.findByProjectId(project.getProjectId()).getProjectHistoryId());

			projectHistory.setModifiedDate(new Date());

			projectHistory.setModifiedBy(themeDisplay.getUserId());
			projectHistory.setProjectId(project.getProjectId());
			projectHistory.setProjectTaskStatusMasterId(projectTaskStatusMasterId);
			projectHistory.setStartDate(startDate);
			projectHistory.setManagerId(employeeDetailsLocalService.findByLrUserId(themeDisplay.getUserId()).getEmployeeId());
			
			projectHistory.setIsBillble(isBillable.equals(AxHrmsProjectWebConstants.YES));
			projectHistoryLocalService.updateProjectHistory(projectHistory);

			
		}else {
			
			//SET DATA IN THE PROJECT HISTORY TABLE
			
			projectHistory = projectHistoryLocalService.createProjectHistory(CounterLocalServiceUtil.increment(ProjectHistory.class.getName()));
			projectHistory.setProjectId(project.getProjectId());
			projectHistory.setProjectTaskStatusMasterId(projectTaskStatusMasterId);
			projectHistory.setStartDate(startDate);
			projectHistory.setManagerId(employeeDetailsLocalService.findByLrUserId(themeDisplay.getUserId()).getEmployeeId());
			
			projectHistory.setIsBillble(isBillable.equals(AxHrmsProjectWebConstants.YES));
			
			
			// --> set audit field of project history
			projectHistory.setCompanyId(themeDisplay.getCompanyId());
			projectHistory.setCreateDate(new Date());
			projectHistory.setModifiedDate(new Date());
			projectHistory.setCreatedBy(themeDisplay.getUserId());
			projectHistory.setModifiedBy(themeDisplay.getUserId());
			projectHistory.setGroupId(themeDisplay.getCompanyGroupId());
			projectHistoryLocalService.addProjectHistory(projectHistory);
			
			
			
		}
	}

	public Project setProjectData(long projectId,String projectName, String description, ThemeDisplay themeDisplay,boolean isUpdate) throws PortalException {
		Project project;
		if(isUpdate) {
			project = projectLocalService.getProject(projectId);
			project.setProjectName(projectName);
			project.setDescription(description);
			project.setModifiedBy(themeDisplay.getUserId());
			project.setModifiedDate(new Date());
			projectLocalService.updateProject(project);
			
			
		}else {
		
		//SET PROJECT DATA IN PROJECT TABLE
		 project = projectLocalService.createProject(CounterLocalServiceUtil.increment(Project.class.getName()));
		project.setProjectName(projectName);
		project.setDescription(description);
		
		// --> set audit field of project
		project.setCompanyId(themeDisplay.getCompanyId());
		project.setCreateDate(new Date());
		project.setCreatedBy(themeDisplay.getUserId());
		project.setModifiedBy(themeDisplay.getUserId());
		project.setGroupId(themeDisplay.getCompanyGroupId());
		project.setModifiedDate(new Date());
		projectLocalService.addProject(project);
		}
		return project;
	}
	
	
	public void sendEmailToEmployee(ProjectDetailsDto projectDto,long employeeId,String fromName,String fromEmailAddress,boolean isAssigned) throws NoSuchEmployeeDetailsException {
		EmployeeDetails manager = employeeDetailsLocalService.findByLrUserId(projectDto.getManagerId());
		EmployeeDetails employee = employeeDetailsLocalService.findByEmployeeId(employeeId);

		
		
		String mailContent = isAssigned ? mailTemplateConfiguration.mailAssignProjectBody(): mailTemplateConfiguration.mailRemovalProjectBody();
		mailContent = mailContent.replace("${EMPLOYEE_NAME}", employee.getFirstName()+StringPool.SPACE+employee.getLastName());
		mailContent = mailContent.replace("${PROJECT_NAME}", projectDto.getProjectName());
		mailContent = mailContent.replace("${MANAGER_NAME}", manager.getFirstName()+StringPool.SPACE+manager.getLastName());
		
		String subject = isAssigned ? mailTemplateConfiguration.mailAssignProjectSubject(): mailTemplateConfiguration.mailRemovalProjectSubject();
		
		axHrmsCommonApi.sendMail(employee.getOfficialEmail(), fromEmailAddress, fromName, subject, mailContent);
		
	}
	public ProjectDetailsDto setDataIntoProjectDto(ActionRequest actionRequest,long managerId) {
		ProjectDetailsDto projectDto = new ProjectDetailsDto();
		String projectName = ParamUtil.getString(actionRequest, AxHrmsProjectWebConstants.PROJECT_NAME);
		String description = ParamUtil.getString(actionRequest, AxHrmsProjectWebConstants.DESCRIPTION);
		long projectTaskStatusMasterId = ParamUtil.getLong(actionRequest, AxHrmsProjectWebConstants.PROJECT_STATUS);
		SimpleDateFormat sdf = new SimpleDateFormat(AxHrmsProjectWebConstants.DATE_FORMATER);
		Date startDate = ParamUtil.getDate(actionRequest,AxHrmsProjectWebConstants.START_DATE,sdf);
		String isBillable = ParamUtil.getString(actionRequest,AxHrmsProjectWebConstants.IS_BILLABLE);
		
		projectDto.setIsBillable(isBillable);
		projectDto.setProjectName(projectName);
		projectDto.setProjectStatus(projectTaskStatusMasterLocalService.fetchProjectTaskStatusMaster(projectTaskStatusMasterId).getProjectTaskStatusName());
		projectDto.setDescription(description);
		projectDto.setStartDate(axHrmsCommonApi.setDateFormat(startDate));
		projectDto.setManagerId(managerId);
		
		return projectDto;
		
		
	}
	
	public void sendNotificationToEmployee(long employeeId,String body) throws Exception {
		JSONObject notificationJSON = JSONFactoryUtil.createJSONObject();
		
		
			EmployeeDetails employee = employeeDetailsLocalService.findByEmployeeId(employeeId);
			
			
			notificationJSON.put(AxHrmsProjectWebConstants.BODY,body);

			// Notification........
			UserNotificationEvent userNotificationEvent = UserNotificationEventLocalServiceUtil.sendUserNotificationEvents(
					employee.getLrUserId(), AxHrmsProjectWebPortletKeys.AXHRMSPROJECTWEB,
					UserNotificationDeliveryConstants.TYPE_WEBSITE, notificationJSON);

			ServiceContext serviceContext = new ServiceContext();
			SendNotificationToUserHandler sendNotificationToUserHandler = new SendNotificationToUserHandler();
			sendNotificationToUserHandler.callGetBody(userNotificationEvent, serviceContext);
		}
}

