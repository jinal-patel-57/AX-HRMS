package ax.hrms.task.web.constants;

public class AxHrmsTaskWebConstants {
	public static final String DEFAULT_PATH="/";
	public static final String LIST_TASK_JSP= "/jsp/ax-hrms-task-web/listTask.jsp";
	public static final String ITERATOR_URL = "iteratorURL";
	public static final String ADD_EDIT_TASK_JSP= "/jsp/ax-hrms-task-web/addEditTask.jsp";
	public static final String VIEW_TASK_JSP= "/jsp/ax-hrms-task-web/viewTask.jsp";
	public static final String REVIEW_TASK_JSP= "/jsp/ax-hrms-task-web/reviewTask.jsp";
	public static final String ADD_LOG_TIME_JSP= "/jsp/ax-hrms-task-web/addLogTime.jsp";
	public static final String LIST_LOG_TIME_JSP= "/jsp/ax-hrms-task-web/listLogTime.jsp";

	public static final String BODY = "body";
	public static final String MAIL_BODY_PART_1 = "Project Name : ";
	public static final String MAIL_BODY_PART_2 = "Manager Name : ";
	public static final String MAIL_BODY_PART_3 = "Task Name : ";

	public static final String BR_TAG = "<br/>";
	public static final String PROJECT_MAIL_FOOTER = "<p>This mail is sent automatically via AX_HRMS Systems, Please contact Admin if any information is found suspectful.</p>\n </div>\n ";
	public static final String PROJECT_MAIL_HEAD = "</div>\n <div style=\"padding: 20px;\">\n <p>Hello,</p>\n ";
	public static final String TASK_ASSIGNE_MAIL_CONTENTLINE = "<p>you have been assigned in new TASK:</p>\n";
	public static final String TASK_REMOVAL_MAIL_CONTENTLINE = "<p>you have been Removed from the TASK:</p>\n";

	
	public static final String ADD_TASK = "/addTask";
	public static final String ADD_LOG_TIME = "/addLogTime";
	public static final String ADD_REVIEW = "/addReview";
	public static final String PROJECT_ID = "projectId";
	public static final String TASK_ID = "taskId";
	public static final String TASK = "task";
	public static final String TIME_TRACKER_ID = "timeTrackerId";
	public static final String TIME_TRACKER_DTO = "timeTrackerDto";
	public static final String TIME_TRACKER_DTO_LIST = "timeTrackerDtoList";
	public static final String TASK_DTO = "taskDto";
	public static final String FILE_LIST = "fileList";
	public static final String IS_TABLE_VISIBLE = "isTableVisible";
	public static final String REVIEW_LIST = "reviewList";
	public static final String EMPLOYEE = "Employee";
	public static final String MANAGER = "Manager";
	public static final String PRIORITY_LIST = "priorityList";
	public static final String TASK_LIST = "taskList";
	public static final String STATUS_LIST = "statusList";
	public static final String EMPLOYEE_LIST = "employeeList";
	public static final String PROJECT = "project";
	public static final String COMMAND = "command";
	public static final String APPROVED = "Approved";
	public static final String REJECTED = "Rejected";
	
	
	public static final String ADD_UPDATE_TASK = "/addUpdateTask";
	public static final String DELETE_ATTACHMENT = "/deleteAttachment";
	public static final String DELETE_LOG_TIME = "/deleteLogTime";
	public static final String LIST_LOG_TIME = "/listLogTime";
	public static final String APPROVE_REJECT_LOG_TIME = "/approveRejectLogTime";
	public static final String TASK_UPDATED_KEY = "task-updated";
	public static final String TASK_ADDED_KEY = "task-added";
	public static final String ATTACHMENT_ID = "attachmentId";
	public static final String UPDATE_LOG_TIME_KEY = "Update-log-time";
	public static final String ADD_LOG_TIME_KEY = "Add-log-time";
	public static final String APPROVED_LOG_TIME_KEY = "logTime-approved";
	public static final String REJECTED_LOG_TIME_KEY = "logTime-rejected";
	public static final String TASK_REVIEW_ADDED_KEY = "task-review-added";
	public static final String ATTACHMENT_DELETED_KEY = "attachment-deleted";
	public static final String TIMETRACKER_DELETED_KEY = "timeTracker-deleted";
	public static final String YOU_DELETED_LOG_TIME = "You deleted Log Time";
	public static final String ERROR_KEY = "error";
	public static final String YOUR_LOG_TIME_OF = "Your Log Time of ";
	public static final String IS = " is ";
	public static final String BY = " by ";
	public static final String BACKURL = "backURL";
	public static final String DELETE_TASK = "/deleteTask";
	public static final String ADD_UPDATE_LOG_TIME = "/addUpdateLogTime";

	public static final String TASK_DELETED_KEY = "task-deleted";
	public static final String FETCH_TASK_DETAILS = "/fetchTaskDetails";
	public static final String IS_MANAGER = "isManager";
	public static final String IS_VISIBLE = "isVisible";
	public static final String TASK_SEARCH_CONTAINER = "taskSearchContainer";
	public static final String TIME_SEARCH_CONTAINER = "timeSearchContainer";
	public static final String PROJECT_LIST = "projectList";
	public static final String YES = "Yes";
	public static final String NO = "No";
	public static final String MAIN_TASK = "mainTask";
	public static final String ASSIGNED_TO = "assignedTo";
	public static final String PROJECT_TASK_STATUS_MASTER = "projectTaskStatusMaster";
	public static final String PRIORITY = "priority";
	public static final String TASKNAME = "taskName";
	public static final String DESCRIPTION = "description";
	public static final String DATE_FORMAT = "yyyy-MM-dd";
	public static final String ASSIGN_DATE = "assignDate";
	public static final String DUE_DATE = "dueDate";
	public static final String DURATION = "duration";
	public static final String START_TIME = "startTime";
	public static final String END_TIME = "endTime";
	public static final String T = "T";
	public static final String PENDING = "Pending";
	public static final String EMPLOYEE_ID = "employeeId";
	public static final String ATTACHMENTS = "attachments";
	public static final String ESTIMATED_HOURS = "estimatedHours";
	public static final String COMPLETE_DATE = "completeDate";
	public static final String START_DATE = "startDate";
	public static final String IS_BILLABLE = "isBillable";
	public static final String IS_SUBTASK = "isSubTask";
	public static final String REVIEW = "review";
	public static final String OF = " of ";
	public static final String ADDED_MANAGER_NOTIFICATION_1 = "You Added One new Task - ";
	public static final String UPDATED_MANAGER_NOTIFICATION_1 = "You Updated Task - ";
	
	public static final String MANAGER_NOTIFICATION_2 =  " Project .";
	public static final String REMOVAL_TASK_MAIL_SUBJECT = "Task Update : Your Removal From the Task";
	public static final String ASSIGNE_TASK_MAIL_SUBJECT = "Task Update : New Task Assignement";
	public static final String NOTIFICATION_BODY_OF_REMOVAL_TASK_FOR_ASSIGNEE_1 = "You have been removed from the task ";
	public static final String NOTIFICATION_BODY_OF_TASK_2 = " Project , Which is given by ";
	public static final String NOTIFICATION_BODY_OF_ASSIGNE_TASK_FOR_ASSIGNEE_1 = "You have new task of ";
	public static final String NOTIFICATION_BODY_OF_REVIEW_FOR_MANAGER = " Task is Reviewed by you.";
	public static final String NOTIFICATION_BODY_OF_REVIEW_FOR_ASSIGNEE_1 ="Task -  ";
	public static final String NOTIFICATION_BODY_OF_REVIEW_FOR_ASSIGNEE_2 =" has been Reviewed by ";

	
	
}
