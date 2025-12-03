package ax.hrms.project.web.constants;

public class AxHrmsProjectWebConstants {

	
	public static final String ITERATOR_URL = "iteratorURL";
	public static final String DEFAULT_PATH = "/";
	public static final String LIST_PROJECT_DETAILS_JSP = "/jsp/ax-hrms-project-web/listProjectDetails.jsp";
	public static final String ADD_PROJECT_DETAILS_JSP = "/jsp/ax-hrms-project-web/addProject.jsp";
	public static final String VIEW_PROJECT_DETAILS_JSP = "/jsp/ax-hrms-project-web/viewProjectDetails.jsp";


	public static final String TOTAL_PROJECT = "totalProject";
	public static final String PROJECT_LIST = "projectList";
	public static final String IS_MANAGER = "isManager";
	public static final String IS_HRADMIN = "isHRAdmin";

//	public static final String PROJECT_MAIL_HEAD = "<body style=\"font-family: Arial, sans-serif; line-height: 1.6; margin: 0; padding: 0;\">\n <div style=\"background-color:#ADD8E6; color: #fff; padding: 10px; text-align: center;\">\n <h2>Project Details </h2>\n </div>\n <div style=\"padding: 20px;\">\n <p>Dear Assignee,</p>\n <p>Please find below the details of your Project in which you are assigne :</p>\n <table style=\"width: 100%; border-collapse: collapse;\">\n <thead>\n"
//			+ "                <tr>\n"
//			+ "                    <th style=\"border: 1px solid #ddd; padding: 10px; background-color: #f2f2f2; text-align: left;\">Project Name</th>\n"
//			+ "                    <th style=\"border: 1px solid #ddd; padding: 10px; background-color: #f2f2f2; text-align: left;\">Description </th>\n"
//			+ "                    <th style=\"border: 1px solid #ddd; padding: 10px; background-color: #f2f2f2; text-align: left;\">Project Start Date</th>\n"
//			+ "                    <th style=\"border: 1px solid #ddd; padding: 10px; background-color: #f2f2f2; text-align: left;\">Project Status</th>\n"
//			+ "                    <th style=\"border: 1px solid #ddd; padding: 10px; background-color: #f2f2f2; text-align: left;\">Manager Name</th>\n"
//			+ "                    <th style=\"border: 1px solid #ddd; padding: 10px; background-color: #f2f2f2; text-align: left;\">Is Billable</th>\n"
//
//			+ "                </tr>\n" + "            </thead>\n" + "            <tbody>\n";
	
	public static final String PROJECT_MAIL_HEAD = "</div>\n <div style=\"padding: 20px;\">\n <p>Hello,</p>\n ";
	
	public static final String PROJECT_ASSIGNE_MAIL_CONTENTLINE = "<p>you have been assigned in new project:</p>\n";
	public static final String PROJECT_REMOVE_MAIL_CONTENTLINE = "<p>you have been removed from the project:</p>\n";



	public static final String PROJECT_MAIL_FOOTER = "<p>This mail is sent automatically via AX_HRMS Systems, Please contact Admin if any information is found suspectful.</p>\n </div>\n ";

	public static final String ERROR_MESSAGE = "error-occur";
	public static final String ADD_PROJECT_MESSAGE = "successfully-project-added";
	public static final String DELETE_PROJECT_MESSAGE = "successfully-project-deleted";
	public static final String UPDATE_PROJECT_MESSAGE = "successfully-project-updated";


	
	public static final String ADD_PROJECT = "/addProject";
	public static final String EMPLOYEE ="Employee";
	public static final String EMPLOYEE_LIST ="employeeList";
	public static final String STATUS_LIST ="statusList";

	public static final String ADD_UPDATE_PROJECT ="/addUpdateProject";

	public static final String PROJECT_ID ="projectId";

	
	public static final String  DELETE_PROJECT ="/deleteProjectDetails";
	
	public static final String  COMMAND = "command";
	public static final String  ASSIGNEE_LIST = "assigneeList";
	public static final String  PROJECT_DTO = "projectDto";
	public static final String  LIST_OF_ASSIGNEE = "listOfAssignee";


	public static final String FETCH_PROJECT_DETAILS = "/fetchProjectDetails";
	public static final String  MANAGER = "Manager";
	public static final String BODY = "body";
	
	public static final String YES = "Yes";
	public static final String NO = "No";
	public static final String PROJECT_NAME = "projectName";
	public static final String PROJECT_SEARCH_CONTAINER = "projectSearchContainer";
	public static final String DESCRIPTION = "description";
	public static final String IS_BILLABLE = "isBillable";
	public static final String START_DATE = "startDate";
	public static final String TEAM_ID = "teamId";
	public static final String PROJECT_STATUS = "projectStatus";
	
	public static final String NOTIFICATION_OF_REMOVE_ASSIGNEE_PART_1 = "You have been removed From ";
	public static final String NOTIFICATION_OF_ASSIGNEE_PART_2 = " project by ";
	public static final String NOTIFICATION_OF_NEW_ASSIGNEE_PART_1 = "You have been assigned to ";
	public static final String SUBJECT_OF_REMOVE_ASSIGNEE = "Project Update: Your Removal from Project";

	public static final String SUBJECT_OF_NEW_ASSIGNEE = "Project Update: Your New Project Assignment";
	public static final String NOTIFICATION_UPDATE_BODY = "You have Updated one project";
	public static final String NOTIFICATION_ADD_BODY = "You have added one new project";
	public static final String UPDATE = "Updated";
	public static final String ADDED = "Added";
	
	public static final String MAIL_BODY_PART_1 = "Project Name : ";
	public static final String MAIL_BODY_PART_2 = "Manager Name : ";

	public static final String DATE_FORMATER = "yyyy-MM-dd";
	
	public static final String SPACE = " ";
	public static final String COMMA = ",";

	public static final String BR_TAG = "<br/>";

	
}
