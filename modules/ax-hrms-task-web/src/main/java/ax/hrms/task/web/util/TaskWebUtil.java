
package ax.hrms.task.web.util;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.portlet.ActionRequest;

import com.ax.hrms.common.api.api.AxHrmsCommonApi;
import com.ax.hrms.exception.NoSuchEmployeeDetailsException;
import com.ax.hrms.exception.NoSuchProjectException;
import com.ax.hrms.mail.template.config.configuration.MailTemplateConfiguration;
import com.ax.hrms.master.service.PriorityMasterLocalService;
import com.ax.hrms.master.service.ProjectTaskStatusMasterLocalService;
import com.ax.hrms.model.Attachment;
import com.ax.hrms.model.EmployeeDetails;
import com.ax.hrms.model.Project;
import com.ax.hrms.model.Task;
import com.ax.hrms.model.TaskReview;
import com.ax.hrms.model.TimeTracker;
import com.ax.hrms.notification.template.config.configuration.NotificationTemplateConfiguration;
import com.ax.hrms.service.AttachmentLocalService;
import com.ax.hrms.service.EmployeeDetailsLocalService;
import com.ax.hrms.service.ProjectEmployeeDetailsLocalService;
import com.ax.hrms.service.ProjectLocalService;
import com.ax.hrms.service.TaskLocalService;
import com.ax.hrms.service.TaskReviewLocalService;
import com.ax.hrms.service.TimeTrackerLocalService;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.document.library.kernel.service.DLAppLocalServiceUtil;
import com.liferay.document.library.kernel.util.DLUtil;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.model.UserNotificationDeliveryConstants;
import com.liferay.portal.kernel.model.UserNotificationEvent;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.repository.model.Folder;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserNotificationEventLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.MimeTypesUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.PrefsPropsUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import ax.hrms.task.web.constants.AxHrmsTaskWebConstants;
import ax.hrms.task.web.constants.AxHrmsTaskWebPortletKeys;
import ax.hrms.task.web.dto.TaskDto;
import ax.hrms.task.web.notification.SendNotificationToUserHandler;

public class TaskWebUtil {
	private EmployeeDetailsLocalService employeeDetailsLocalService;
	private ProjectEmployeeDetailsLocalService projectEmployeeDetailsLocalService;

	private AxHrmsCommonApi axHrmsCommonApi;
	private ProjectLocalService projectLocalService;
	private TaskLocalService taskLocalService;
	private ProjectTaskStatusMasterLocalService projectTaskStatusMasterLocalService;

	private PriorityMasterLocalService priorityMasterLocalService;
	private TaskReviewLocalService taskReviewLocalService;

	private TimeTrackerLocalService timeTrackerLocalService;

	private AttachmentLocalService attachmentLocalService;


	public TaskWebUtil(EmployeeDetailsLocalService employeeDetailsLocalService, AxHrmsCommonApi axHrmsCommonApi,
			ProjectLocalService projectLocalService, TaskLocalService taskLocalService,
			TaskReviewLocalService taskReviewLocalService, TimeTrackerLocalService timeTrackerLocalService,
			AttachmentLocalService attachmentLocalService) {
		super();
		this.employeeDetailsLocalService = employeeDetailsLocalService;
		this.axHrmsCommonApi = axHrmsCommonApi;
		this.projectLocalService = projectLocalService;
		this.taskLocalService = taskLocalService;
		this.taskReviewLocalService = taskReviewLocalService;
		this.timeTrackerLocalService = timeTrackerLocalService;
		this.attachmentLocalService = attachmentLocalService;
	}

	public TaskWebUtil(EmployeeDetailsLocalService employeeDetailsLocalService,
			ProjectEmployeeDetailsLocalService projectEmployeeDetailsLocalService, AxHrmsCommonApi axHrmsCommonApi,
			ProjectLocalService projectLocalService, TaskLocalService taskLocalService,
			ProjectTaskStatusMasterLocalService projectTaskStatusMasterLocalService,
			PriorityMasterLocalService priorityMasterLocalService) {
		super();
		this.employeeDetailsLocalService = employeeDetailsLocalService;
		this.projectEmployeeDetailsLocalService = projectEmployeeDetailsLocalService;
		this.axHrmsCommonApi = axHrmsCommonApi;
		this.projectLocalService = projectLocalService;
		this.taskLocalService = taskLocalService;
		this.projectTaskStatusMasterLocalService = projectTaskStatusMasterLocalService;
		this.priorityMasterLocalService = priorityMasterLocalService;
	}

	public TaskWebUtil(EmployeeDetailsLocalService employeeDetailsLocalService, AxHrmsCommonApi axHrmsCommonApi,
			ProjectLocalService projectLocalService, TaskLocalService taskLocalService,
			ProjectTaskStatusMasterLocalService projectTaskStatusMasterLocalService,
			PriorityMasterLocalService priorityMasterLocalService, TaskReviewLocalService taskReviewLocalService) {
		super();
		this.employeeDetailsLocalService = employeeDetailsLocalService;
		this.axHrmsCommonApi = axHrmsCommonApi;
		this.projectLocalService = projectLocalService;
		this.taskLocalService = taskLocalService;
		this.projectTaskStatusMasterLocalService = projectTaskStatusMasterLocalService;
		this.priorityMasterLocalService = priorityMasterLocalService;
		this.taskReviewLocalService = taskReviewLocalService;
	}

	public TaskDto convertDataIntoDto(Task task) throws NoSuchProjectException, NoSuchEmployeeDetailsException {
		TaskDto taskDto = new TaskDto();
		taskDto.setTaskName(task.getTaskName());
		taskDto.setTaskId(task.getTaskId());
		taskDto.setIsSubTask(task.getIsSubTask() ? AxHrmsTaskWebConstants.YES : AxHrmsTaskWebConstants.NO);
		taskDto.setMainTaskName(taskLocalService.fetchTask(task.getMainTaskId()).getTaskName());
		taskDto.setProjectName(projectLocalService.findByProjectId(task.getProjectId()).getProjectName());
		taskDto.setProjectId(task.getProjectId());
		taskDto.setDescription(task.getDescription());
		taskDto.setProjectTaskStatus(projectTaskStatusMasterLocalService
				.fetchProjectTaskStatusMaster(task.getProjectTaskStatusMasterId()).getProjectTaskStatusName());
		taskDto.setPriority(
				priorityMasterLocalService.fetchPriorityMaster(task.getPriorityMasterId()).getPriorityName());
		taskDto.setIsBillable(task.getIsBillble() ? AxHrmsTaskWebConstants.YES : AxHrmsTaskWebConstants.NO);
		taskDto.setAssignDate(task.getAssignDate());
		taskDto.setAssignedTo(task.getAssignedTo());
		taskDto.setAssignedEmployee(employeeDetailsLocalService.findByEmployeeId(task.getAssignedTo()).getFirstName()
				+ StringPool.SPACE + employeeDetailsLocalService.findByEmployeeId(task.getAssignedTo()).getLastName());
		taskDto.setDueDate(task.getDueDate());
		taskDto.setCompleteDate(task.getCompleteDate());

		return taskDto;

	}

	public void setTaskData(ActionRequest actionRequest, boolean isUpdate,MailTemplateConfiguration mailTemplateConfiguration,NotificationTemplateConfiguration notificationTemplateConfiguration) throws Exception {
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);

		long projectId = ParamUtil.getLong(actionRequest, AxHrmsTaskWebConstants.PROJECT_ID);
		long mainTaskId = ParamUtil.getLong(actionRequest, AxHrmsTaskWebConstants.MAIN_TASK);
		long assignedTo = ParamUtil.getLong(actionRequest, AxHrmsTaskWebConstants.ASSIGNED_TO);
		long projectTaskStatusId = ParamUtil.getLong(actionRequest, AxHrmsTaskWebConstants.PROJECT_TASK_STATUS_MASTER);
		long priorityId = ParamUtil.getLong(actionRequest, AxHrmsTaskWebConstants.PRIORITY);
		int estimatedHours = ParamUtil.getInteger(actionRequest, AxHrmsTaskWebConstants.ESTIMATED_HOURS);
		String taskName = ParamUtil.getString(actionRequest, AxHrmsTaskWebConstants.TASKNAME);
		String description = ParamUtil.getString(actionRequest, AxHrmsTaskWebConstants.DESCRIPTION);

		SimpleDateFormat sdf = new SimpleDateFormat(AxHrmsTaskWebConstants.DATE_FORMAT);

		Date assignDate = ParamUtil.getDate(actionRequest, AxHrmsTaskWebConstants.ASSIGN_DATE, sdf);
		Date dueDate = ParamUtil.getDate(actionRequest, AxHrmsTaskWebConstants.DUE_DATE, sdf);
		Date completeDate = ParamUtil.getDate(actionRequest, AxHrmsTaskWebConstants.COMPLETE_DATE, sdf, null);
		Date startDate = ParamUtil.getDate(actionRequest, AxHrmsTaskWebConstants.START_DATE, sdf, null);

		boolean isBillable = ParamUtil.getBoolean(actionRequest, AxHrmsTaskWebConstants.IS_BILLABLE);
		boolean isSubTask = ParamUtil.getBoolean(actionRequest, AxHrmsTaskWebConstants.IS_SUBTASK);
		boolean isManager = axHrmsCommonApi.isRolePerson(themeDisplay, AxHrmsTaskWebConstants.MANAGER);

		long taskId = ParamUtil.getLong(actionRequest, AxHrmsTaskWebConstants.TASK_ID);
		String review = ParamUtil.getString(actionRequest, AxHrmsTaskWebConstants.REVIEW);

		Task task = isUpdate ? taskLocalService.getTask(taskId)
				: taskLocalService.createTask(CounterLocalServiceUtil.increment(Task.class.getName()));
		if (isManager) {
			if (!isUpdate) {
				task.setCompanyId(themeDisplay.getCompanyId());
				task.setCreateDate(new Date());
				task.setCreatedBy(themeDisplay.getUserId());
				task.setGroupId(themeDisplay.getScopeGroupId());

			}
			task.setAssignDate(assignDate);
			task.setCompleteDate(completeDate);
			task.setDescription(description);
			task.setDueDate(dueDate);
			task.setIsBillble(isBillable);
			task.setTaskName(taskName);
			task.setStartDate(startDate);
			task.setProjectTaskStatusMasterId(projectTaskStatusId);
			task.setProjectId(projectId);
			task.setPriorityMasterId(priorityId);
			task.setIsSubTask(isSubTask);
			task.setMainTaskId(Validator.isNotNull(mainTaskId) ? mainTaskId : task.getTaskId());
			task.setModifiedBy(themeDisplay.getUserId());
			task.setModifiedDate(new Date());
			task.setEstimatedHours(estimatedHours);
			EmployeeDetails managerPerson = employeeDetailsLocalService.findByLrUserId(themeDisplay.getUserId());
			task.setManagerId(managerPerson.getEmployeeId());
			long oldAssigneeId = 0;
			long newAssigneeId = 0;
			Project project = projectLocalService.findByProjectId(projectId);
			String managerBody;
			
			
			if (!isUpdate) {
				String notificationContent = notificationTemplateConfiguration.notificationAddTaskManager();
				notificationContent = notificationContent.replace("${TASK_NAME}", task.getTaskName());
				notificationContent = notificationContent.replace("${PROJECT_NAME}",project.getProjectName());
				task.setAssignedTo(assignedTo);
				taskLocalService.addTask(task);
				managerBody = AxHrmsTaskWebConstants.ADDED_MANAGER_NOTIFICATION_1 + task.getTaskName()
						+ AxHrmsTaskWebConstants.OF + project.getProjectName()
						+ AxHrmsTaskWebConstants.MANAGER_NOTIFICATION_2;
				notificationContent = notificationContent.replace("${STATUS}","Added to");
				sendNotificationToEmployee(managerPerson.getEmployeeId(), notificationContent);

			} else {
				String notificationContent = notificationTemplateConfiguration.notificationUpdateTaskManager();
				notificationContent = notificationContent.replace("${TASK_NAME}", task.getTaskName());
				notificationContent = notificationContent.replace("${PROJECT_NAME}",project.getProjectName());
				oldAssigneeId = task.getAssignedTo();
				task.setAssignedTo(assignedTo);
				taskLocalService.updateTask(task);
				managerBody = AxHrmsTaskWebConstants.UPDATED_MANAGER_NOTIFICATION_1 + task.getTaskName()
						+ AxHrmsTaskWebConstants.OF + project.getProjectName()
						+ AxHrmsTaskWebConstants.MANAGER_NOTIFICATION_2;
				notificationContent = notificationContent.replace("${STATUS}","Updated to");
				sendNotificationToEmployee(managerPerson.getEmployeeId(), notificationContent);



				// set Task review Data
				if (Validator.isNotNull(review))
					setTaskReviewData(themeDisplay, review, taskId,notificationTemplateConfiguration);
			}

			String fromName = PrefsPropsUtil.getString(themeDisplay.getCompanyId(), PropsKeys.ADMIN_EMAIL_FROM_NAME);
			String fromEmailAddress = PrefsPropsUtil.getString(themeDisplay.getCompanyId(),
					PropsKeys.ADMIN_EMAIL_FROM_ADDRESS);

			newAssigneeId = sendMailAndNotificationToOldAssignee(task, managerPerson, oldAssigneeId, fromName,
					fromEmailAddress,mailTemplateConfiguration,notificationTemplateConfiguration);
			sendMailAndNotificationToNewAssignee(task, managerPerson, newAssigneeId, fromName,
					fromEmailAddress,mailTemplateConfiguration,notificationTemplateConfiguration);

			// sendNotification to Manager for adding task
		} else {

			task.setStartDate(startDate);
			task.setModifiedBy(themeDisplay.getUserId());
			task.setModifiedDate(new Date());
			task.setCompleteDate(completeDate);
			taskLocalService.updateTask(task);

			if (Validator.isNotNull(review))
				setTaskReviewData(themeDisplay, review, taskId,notificationTemplateConfiguration);

		}

	}

	public void sendMailAndNotificationToNewAssignee(Task task, EmployeeDetails managerPerson, long newAssigneeId,
			 String fromName, String fromEmailAddress,MailTemplateConfiguration mailTemplateConfiguration,NotificationTemplateConfiguration notificationTemplateConfiguration)

			throws Exception, NoSuchEmployeeDetailsException {
		Project project = projectLocalService.getProject(task.getProjectId());
		
		if (Validator.isNotNull(newAssigneeId)) {
			TaskDto taskDto = new TaskDto();
			taskDto.setManagerId(managerPerson.getEmployeeId());
			taskDto.setAssignedTo(newAssigneeId);
			taskDto.setProjectName(project.getProjectName());
			taskDto.setTaskName(task.getTaskName());
			
		String notificationContent = notificationTemplateConfiguration.notificationTaskAssignedEmployee();
		notificationContent =  notificationContent.replace("${TASK_NAME}", task.getTaskName());
		notificationContent =  notificationContent.replace("${STATUS}", "added to");
		notificationContent =  notificationContent.replace("${PROJECT_NAME}", project.getProjectName());
		notificationContent =  notificationContent.replace("${MANAGER_NAME}", managerPerson.getFirstName()+StringPool.SPACE+managerPerson.getLastName());
		
			
			// send notification to assignee user
			sendNotificationToEmployee(newAssigneeId, notificationContent);
			// send mail to Assignee for new task.

			sendEmailToEmployee(taskDto, fromName, fromEmailAddress,true,mailTemplateConfiguration);

		}
	}

	public long sendMailAndNotificationToOldAssignee(Task task, EmployeeDetails managerPerson, long oldAssigneeId,
			 String fromName, String fromEmailAddress,MailTemplateConfiguration mailTemplateConfiguration,NotificationTemplateConfiguration notificationTemplateConfiguration) throws Exception {
		Project project = projectLocalService.getProject(task.getProjectId());

		if (Validator.isNotNull(oldAssigneeId) && oldAssigneeId != task.getAssignedTo()) {
			TaskDto taskDto = new TaskDto();
			taskDto.setManagerId(managerPerson.getEmployeeId());
			taskDto.setAssignedTo(oldAssigneeId);
			taskDto.setProjectName(project.getProjectName());
			taskDto.setTaskName(task.getTaskName());
			
			String notificationContent = notificationTemplateConfiguration.notificationTaskRemoveEmployee();
			notificationContent =  notificationContent.replace("${TASK_NAME}", task.getTaskName());
			notificationContent =  notificationContent.replace("${STATUS}", "removed from");
			notificationContent =  notificationContent.replace("${PROJECT_NAME}", project.getProjectName());
			notificationContent =  notificationContent.replace("${MANAGER_NAME}", managerPerson.getFirstName()+StringPool.SPACE+managerPerson.getLastName());
			
			// send notification to assignee user
			sendNotificationToEmployee(oldAssigneeId, notificationContent);

			sendEmailToEmployee(taskDto, fromName, fromEmailAddress,false,mailTemplateConfiguration);
		}
		return task.getAssignedTo();
	}
	// SEND NOTIFICATION
	// ..............................................................

	public void sendNotificationToEmployee(long employeeId, String body) throws Exception {
		JSONObject notificationJSON = JSONFactoryUtil.createJSONObject();

		EmployeeDetails employee = employeeDetailsLocalService.findByEmployeeId(employeeId);

		notificationJSON.put(AxHrmsTaskWebConstants.BODY, body);

		// Notification........
		UserNotificationEvent userNotificationEvent = UserNotificationEventLocalServiceUtil.sendUserNotificationEvents(
				employee.getLrUserId(), AxHrmsTaskWebPortletKeys.AXHRMSTASKWEB,
				UserNotificationDeliveryConstants.TYPE_WEBSITE, notificationJSON);

		ServiceContext serviceContext = new ServiceContext();
		SendNotificationToUserHandler sendNotificationToUserHandler = new SendNotificationToUserHandler();
		sendNotificationToUserHandler.callGetBody(userNotificationEvent, serviceContext);
	}

	// SEND MAIL
	// .............................................................................
	public void sendEmailToEmployee(TaskDto taskDto, String fromName, String fromEmailAddress,boolean isAssigned,MailTemplateConfiguration mailTemplateConfiguration) throws NoSuchEmployeeDetailsException {
		EmployeeDetails manager = employeeDetailsLocalService.findByEmployeeId(taskDto.getManagerId());
		EmployeeDetails employee = employeeDetailsLocalService.findByEmployeeId(taskDto.getAssignedTo());

//		String body = mailBody + AxHrmsTaskWebConstants.MAIL_BODY_PART_1 + taskDto.getProjectName()
//				+ AxHrmsTaskWebConstants.BR_TAG + AxHrmsTaskWebConstants.MAIL_BODY_PART_2 + manager.getFirstName()
//				+ StringPool.SPACE + manager.getLastName() + AxHrmsTaskWebConstants.BR_TAG
//				+ AxHrmsTaskWebConstants.MAIL_BODY_PART_3 + taskDto.getTaskName()
//				+ AxHrmsTaskWebConstants.PROJECT_MAIL_FOOTER;
		
		String mailContent = isAssigned ? mailTemplateConfiguration.mailAssignTaskBody() : mailTemplateConfiguration.mailRemoveTaskBody();
		mailContent = mailContent.replace("${EMPLOYEE_NAME}",employee.getFirstName()+StringPool.SPACE+employee.getLastName());
		mailContent = mailContent.replace("${MANAGER_NAME}",manager.getFirstName()+StringPool.SPACE+manager.getLastName());
		mailContent = mailContent.replace("${PROJECT_NAME}",taskDto.getProjectName());
		mailContent = mailContent.replace("${TASK_NAME}",taskDto.getTaskName());
		
		String subject = isAssigned ?  mailTemplateConfiguration.mailAssignTaskSubject() : mailTemplateConfiguration.mailRemoveTaskSubject();
		
		axHrmsCommonApi.sendMail(employee.getOfficialEmail(), fromEmailAddress, fromName, subject, mailContent);

	}

	public TaskDto getTaskData(long taskId, boolean isReview) throws PortalException {
		TaskDto taskDto = new TaskDto();
		Task task = taskLocalService.getTask(taskId);
		taskDto.setTaskId(taskId);
		taskDto.setTaskName(task.getTaskName());
		Project project = projectLocalService.getProject(task.getProjectId());
		taskDto.setProjectId(project.getProjectId());
		if (isReview) {
			return taskDto;
		}

		taskDto.setProjectName(project.getProjectName());
		taskDto.setIsSubTask(task.getIsSubTask() ? AxHrmsTaskWebConstants.YES : AxHrmsTaskWebConstants.NO);
		taskDto.setMainTaskName(taskLocalService.getTask(task.getMainTaskId()).getTaskName());
		taskDto.setMainTaskId(task.getMainTaskId());
		taskDto.setDescription(task.getDescription());
		taskDto.setProjectTaskStatus(projectTaskStatusMasterLocalService
				.getProjectTaskStatusMaster(task.getProjectTaskStatusMasterId()).getProjectTaskStatusName());
		taskDto.setProjectTaskStatusId(task.getProjectTaskStatusMasterId());
		taskDto.setPriority(priorityMasterLocalService.getPriorityMaster(task.getPriorityMasterId()).getPriorityName());
		taskDto.setPriorityId(task.getPriorityMasterId());
		taskDto.setAssignedTo(task.getAssignedTo());
		taskDto.setAssignDate(task.getAssignDate());
		taskDto.setCompleteDate(task.getCompleteDate());
		taskDto.setDueDate(task.getDueDate());
		taskDto.setStartDate(task.getStartDate());
		taskDto.setEstimatedHours(task.getEstimatedHours());
		taskDto.setIsBillable(task.getIsBillble() ? AxHrmsTaskWebConstants.YES : AxHrmsTaskWebConstants.NO);
		EmployeeDetails assigneePerson = employeeDetailsLocalService.findByEmployeeId(task.getAssignedTo());
		taskDto.setAssignedEmployee(assigneePerson.getFirstName() + StringPool.SPACE + assigneePerson.getLastName());

		return taskDto;
	}

	public void setTaskReviewData(ThemeDisplay themeDisplay, String review, long taskId,NotificationTemplateConfiguration notificationTemplateConfiguration) throws Exception {
		TaskReview taskReview = taskReviewLocalService
				.createTaskReview(CounterLocalServiceUtil.increment(TaskReview.class.getName()));
		taskReview.setCompanyId(themeDisplay.getCompanyId());
		taskReview.setCreateDate(new Date());
		taskReview.setCreatedBy(themeDisplay.getUserId());
		taskReview.setDateOfReview(new Date());
		taskReview.setGroupId(themeDisplay.getScopeGroupId());
		taskReview.setModifiedBy(themeDisplay.getUserId());
		taskReview.setModifiedDate(new Date());
		taskReview.setReview(review);
		taskReview.setReviewerId(employeeDetailsLocalService.findByLrUserId(themeDisplay.getUserId()).getEmployeeId());
		taskReview.setTaskId(taskId);
		taskReviewLocalService.addTaskReview(taskReview);

		boolean isManager = axHrmsCommonApi.isRolePerson(themeDisplay, AxHrmsTaskWebConstants.MANAGER);
		sendNotificationForReview(taskId, isManager,notificationTemplateConfiguration);
	}

	public void sendNotificationForReview(long taskId, boolean isManager,NotificationTemplateConfiguration notificationTemplateConfiguration) throws Exception {

		TaskWebUtil taskWebUtil = new TaskWebUtil(employeeDetailsLocalService, projectEmployeeDetailsLocalService,
				axHrmsCommonApi, projectLocalService, taskLocalService, projectTaskStatusMasterLocalService,
				priorityMasterLocalService);
		Task task = taskLocalService.getTask(taskId);
		String notificationContent = notificationTemplateConfiguration.notificationReview();
		notificationContent = notificationContent.replace("${TASK_NAME}", task.getTaskName());
		EmployeeDetails managerPerson = employeeDetailsLocalService.getEmployeeDetails(task.getManagerId());
		EmployeeDetails employeePerson = employeeDetailsLocalService.getEmployeeDetails(task.getAssignedTo());

		if (isManager) {
			notificationContent = notificationContent.replace("${REVIEWER_NAME}", managerPerson.getFirstName()+StringPool.SPACE+managerPerson.getLastName());


		} else {

			notificationContent = notificationContent.replace("${REVIEWER_NAME}", employeePerson.getFirstName()+StringPool.SPACE+employeePerson.getLastName());
		}
		
		// SEND NOTIFICATION TO MANAGER
		taskWebUtil.sendNotificationToEmployee(task.getManagerId(),
				notificationContent);
		// SEND NOTIFICATIION TO EMPLOYEE
		taskWebUtil.sendNotificationToEmployee(task.getAssignedTo(),
				notificationContent);
		

	}

	public void setLogTime(ActionRequest actionRequest, boolean isUpdate) throws PortalException, IOException {
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long taskId = ParamUtil.getLong(actionRequest, AxHrmsTaskWebConstants.TASK_ID);
		long timeTrackerId = ParamUtil.getLong(actionRequest, AxHrmsTaskWebConstants.TIME_TRACKER_ID);
		String description = ParamUtil.getString(actionRequest, AxHrmsTaskWebConstants.DESCRIPTION);
		double duration = ParamUtil.getDouble(actionRequest, AxHrmsTaskWebConstants.DURATION);
		String startDateTime = ParamUtil.getString(actionRequest, AxHrmsTaskWebConstants.START_TIME);
		String endDateTime = ParamUtil.getString(actionRequest, AxHrmsTaskWebConstants.END_TIME);

		String[] sTime = startDateTime.split(AxHrmsTaskWebConstants.T);
		String[] eTime = endDateTime.split(AxHrmsTaskWebConstants.T);

		Calendar startTime = axHrmsCommonApi.setDateAndTime(sTime[0], sTime[1]);
		Calendar endTime = axHrmsCommonApi.setDateAndTime(eTime[0], eTime[1]);

		TimeTracker timeTracker = isUpdate ? timeTrackerLocalService.getTimeTracker(timeTrackerId)
				: timeTrackerLocalService
						.createTimeTracker(CounterLocalServiceUtil.increment(TimeTracker.class.getName()));
		if (!isUpdate) {
			timeTracker.setCompanyId(themeDisplay.getCompanyId());
			timeTracker.setCreateDate(new Date());
			timeTracker.setGroupId(themeDisplay.getScopeGroupId());
			timeTracker.setCreatedBy(themeDisplay.getUserId());

		}
		timeTracker.setManagerApproveStatus(AxHrmsTaskWebConstants.PENDING);
		timeTracker.setDescription(description);
		timeTracker.setDuration(duration);
		timeTracker.setModifiedBy(themeDisplay.getUserId());
		timeTracker.setModifiedDate(new Date());
		timeTracker.setStartTime(startTime.getTime());
		timeTracker.setEndTime(endTime.getTime());
		timeTracker.setEmployeeId(employeeDetailsLocalService.findByLrUserId(themeDisplay.getUserId()).getEmployeeId());
		timeTracker.setTaskId(taskId);
		if (isUpdate) {
			timeTrackerLocalService.updateTimeTracker(timeTracker);
			setAttachments(actionRequest, timeTracker.getTimeTrackerId());
		} else {

			timeTrackerLocalService.addTimeTracker(timeTracker);
			setAttachments(actionRequest, timeTracker.getTimeTrackerId());
		}

	}

	public TaskDto convertTimeTrackerDataIntoDto(TimeTracker timeTracker,ThemeDisplay themeDisplay) throws PortalException {
		TaskDto timeTrackerDto = new TaskDto();
		Task task = taskLocalService.getTask(timeTracker.getTaskId());
		timeTrackerDto.setTimeTrackerId(timeTracker.getTimeTrackerId());
		timeTrackerDto.setProjectId(task.getProjectId());
		timeTrackerDto.setTaskName(task.getTaskName());
		timeTrackerDto.setTaskId(task.getTaskId());
		timeTrackerDto.setProjectId(task.getProjectId());
		timeTrackerDto.setDescription(timeTracker.getDescription());
		timeTrackerDto.setStartTime(timeTracker.getStartTime());
		timeTrackerDto.setEndTime(timeTracker.getEndTime());
		timeTrackerDto.setDuration(timeTracker.getDuration());
		timeTrackerDto.setManagerApproveStatus(timeTracker.getManagerApproveStatus());
		EmployeeDetails employee = employeeDetailsLocalService.getEmployeeDetails(timeTracker.getEmployeeId());
		timeTrackerDto.setAssignedEmployee(employee.getFirstName() + StringPool.SPACE + employee.getLastName());
		
		List<Attachment> attachementsList = attachmentLocalService.findByTimeTrackerId(timeTracker.getTimeTrackerId());
		List<TaskDto> fileEntryList = new ArrayList<>();
		for(Attachment attachment : attachementsList) {
			TaskDto fileDto = new TaskDto();
			FileEntry file = DLAppLocalServiceUtil.getFileEntry(attachment.getAttachmentId());
			String previewURL = DLUtil.getPreviewURL(file, file.getFileVersion(), themeDisplay, StringPool.BLANK);
			fileDto.setFile(file);
			fileDto.setPreviewURL(previewURL);
			fileEntryList.add(fileDto);
			
		}
		timeTrackerDto.setAttachmentList(fileEntryList);

		return timeTrackerDto;
	}

	public void setAttachments(ActionRequest actionRequest, long timeTrackerId)
			throws PortalException, IOException {
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long taskId = ParamUtil.getLong(actionRequest, AxHrmsTaskWebConstants.TASK_ID);
		String startTime = ParamUtil.getString(actionRequest, AxHrmsTaskWebConstants.START_TIME);
		startTime = startTime.replace(AxHrmsTaskWebConstants.T, StringPool.UNDERLINE);
		startTime = startTime.replace(StringPool.COLON,StringPool.BLANK);
		ServiceContext serviceContext = new ServiceContext();
		Task task = taskLocalService.getTask(taskId);
		String projectName = task.getProjectId() + StringPool.DASH
				+ projectLocalService.getProject(task.getProjectId()).getProjectName();
		String taskName = task.getTaskId() + StringPool.DASH + task.getTaskName();
		Folder folder = null;

		folder = axHrmsCommonApi.createFolder(AxHrmsTaskWebConstants.PROJECT, 0, themeDisplay, serviceContext);
		folder = axHrmsCommonApi.createFolder(projectName, folder.getFolderId(), themeDisplay, serviceContext);
		folder = axHrmsCommonApi.createFolder(taskName, folder.getFolderId(), themeDisplay, serviceContext);

		UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(actionRequest);

		String[] fileNames = uploadRequest.getFileNames(AxHrmsTaskWebConstants.ATTACHMENTS);
		File[] fileArr = uploadRequest.getFiles(AxHrmsTaskWebConstants.ATTACHMENTS);

		if (Validator.isNotNull(fileArr) && Validator.isNotNull(fileNames)) {
			for (int i = 0; i < fileArr.length; i++) {
				
				FileEntry entry = DLAppLocalServiceUtil.addFileEntry(themeDisplay.getUserId(),
						themeDisplay.getScopeGroupId(), folder.getFolderId(),  startTime + StringPool.DASH +fileNames[i],
						MimeTypesUtil.getContentType((File) fileArr[i]), fileNames[i],
						StringPool.BLANK, StringPool.BLANK, fileArr[i], serviceContext);
				Attachment attachments = attachmentLocalService.createAttachment(entry.getFileEntryId());				
				attachments.setCompanyId(themeDisplay.getCompanyId());
				attachments.setCreateDate(new Date());
				attachments.setCreatedBy(themeDisplay.getUserId());
				attachments.setGroupId(themeDisplay.getScopeGroupId());
				attachments.setModifiedBy(themeDisplay.getUserId());
				attachments.setModifiedDate(new Date());
				attachments.setTimeTrackerId(timeTrackerId);
				attachmentLocalService.addAttachment(attachments);

				
			}

		}


		
		
		
		

	}

}
