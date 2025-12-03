package com.ax.hrms.notification.template.config.configuration;

import aQute.bnd.annotation.metatype.Meta;
import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;

@ExtendedObjectClassDefinition(category = "HRMS", scope = ExtendedObjectClassDefinition.Scope.SYSTEM)
@Meta.OCD(id = "com.ax.hrms.notification.template.config.configuration.NotificationTemplateConfiguration",
        localization = "content/Language", name = "notification-template-configuration")
public interface NotificationTemplateConfiguration {

  
 // Anniversary Web Portlet
 
 @Meta.AD(deflt = "<h1>HELLO</h1>",
       name="Anniversary Wish", //  ${EMPLOYEE_CODE} ${EMPLOYEE_NAME} ${DEPARTMENT_NAME} ${DESIGNATION_NAME} ${TITLE} ${MONTH} ${DATE} ${YEAR}
       required = false)
public String notificationAnniversary();
 
 // Birthday Web Portlet
 
 @Meta.AD(deflt = "<h1>HELLO</h1>",
		 name="Birthday Wish", //  ${EMPLOYEE_CODE} ${EMPLOYEE_NAME} ${DEPARTMENT_NAME} ${DESIGNATION_NAME} ${TITLE} ${MONTH} ${DATE} ${YEAR}
		 required = false)
 public String notificationBirthday();
 

  
 
 // Project Web Portlet
 
 @Meta.AD(deflt = "<h1>HELLO</h1>",
		 name="Project (Manager AddProject)", // ${PROJECT_NAME} ${STATUS}
		 required = false)
 public String notificationAddProjectManager();
 
 @Meta.AD(deflt = "<h1>HELLO</h1>",
		 name="Project (Manager UpdateProject)", // ${PROJECT_NAME} ${STATUS}
		 required = false)
 public String notificationUpdateProjectManager();
 
 
 // Project Web Portlet
 
 @Meta.AD(deflt = "<h1>HELLO</h1>",
		 name="Project (Employee Assigne)", // ${PROJECT_NAME} ${MANAGER_NAME}
		 required = false)
 public String notificationProjectAssignedEmployee();
 
 @Meta.AD(deflt = "<h1>HELLO</h1>",
		 name="Project (Employee Remove)", // ${PROJECT_NAME},${MANAGER_NAME},${STATUS}
		 required = false)
 public String notificationProjectRemovedEmployee();
 
 // Task Web Portlet
 
 @Meta.AD(deflt = "<h1>HELLO</h1>",
		 name="Task (Manager AddTask)", // ${PROJECT_NAME} ${TASK_NAME} 
		 required = false)
 public String notificationAddTaskManager();
 
 @Meta.AD(deflt = "<h1>HELLO</h1>",
		 name="Task (Manager Update)", // ${PROJECT_NAME} ${TASK_NAME} 
		 required = false)
 public String notificationUpdateTaskManager();
 
 @Meta.AD(deflt = "<h1>HELLO</h1>",
		 name="Task (Employee Assigne)", // ${PROJECT_NAME} ${TASK_NAME} ${MANAGER_NAME} 
		 required = false)
 public String notificationTaskAssignedEmployee();
 
 @Meta.AD(deflt = "<h1>HELLO</h1>",
		 name="Task (Employee Remove)", // ${PROJECT_NAME} ${TASK_NAME} ${MANAGER_NAME} 
		 required = false)
 public String notificationTaskRemoveEmployee();
 
    
 // Review 
 @Meta.AD(deflt = "<h1>HELLO</h1>",
		 name="Review ", //  ${TASK_NAME} ${REVIEWER_NAME} 
		 required = false)
 public String notificationReview();
 
 
 //Log Time
 
 @Meta.AD(deflt = "<h1>HELLO</h1>",
		 name="Log Time(Approve) ", //  ${TASK_NAME} ${MANAGER_NAME} 
		 required = false)
 public String notificationApproveLogTime();
 
 
 @Meta.AD(deflt = "<h1>HELLO</h1>",
		 name="Log Time(Reject)", //  ${TASK_NAME} ${MANAGER_NAME} 
		 required = false)
 public String notificationRejectLogTime();
 
 
 


    @Meta.AD(deflt = "<h1>HELLO</h1>",
            name="Appraisal Reminder to HR Notification (Employee)",
            required = false)
    public String appraisalReminderToHrNotification();

    @Meta.AD(deflt = "<h1>HELLO</h1>",
            name="Leave Approved Notification to Employee (Employee)",
            required = false)
    public String leaveApprovedNotificationToEmployee();

    @Meta.AD(deflt = "<h1>HELLO</h1>",
            name="Leave Rejected Notification to Employee (Employee)",
            required = false)
    public String leaveRejectedNotificationToEmployee();


    @Meta.AD(deflt = "<h1>HELLO</h1>",
            name="Leave Cancelled Notification to Employee (Employee)",
            required = false)
    public String leaveCancelledNotificationToEmployee();





}
