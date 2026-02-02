package com.ax.hrms.notification.template.config.configuration;

import aQute.bnd.annotation.metatype.Meta;
import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;

@ExtendedObjectClassDefinition(category = "HRMS", scope = ExtendedObjectClassDefinition.Scope.SYSTEM)
@Meta.OCD(id = "com.ax.hrms.notification.template.config.configuration.NotificationTemplateConfiguration",
        localization = "content/Language", name = "notification-template-configuration")
public interface NotificationTemplateConfiguration {

  
 // Anniversary Web Portlet
 
 @Meta.AD(deflt = "${EMPLOYEE_CODE} - ${EMPLOYEE_NAME}, ${DESIGNATION_NAME} (${DEPARTMENT_NAME}) ${TITLE} on ${DATE} ${MONTH} ${YEAR}.",
       name="Anniversary Wish", //  ${EMPLOYEE_CODE} ${EMPLOYEE_NAME} ${DEPARTMENT_NAME} ${DESIGNATION_NAME} ${TITLE} ${MONTH} ${DATE} ${YEAR}
       required = false)
public String notificationAnniversary();
 
 // Birthday Web Portlet
 
 @Meta.AD(deflt = "${EMPLOYEE_CODE} ${EMPLOYEE_NAME} ${DEPARTMENT_NAME} ${DESIGNATION_NAME} ${TITLE} ${MONTH} ${DATE} ${YEAR}",
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

    @Meta.AD(deflt = "Your Leave Request Has Been Approved",
            name="Leave Approved Notification to Employee (Employee)",
            required = false)
    public String leaveApprovedNotificationToEmployee();

    @Meta.AD(deflt = "Your Leave Request Has Been Rejected",
            name="Leave Rejected Notification to Employee (Employee)",
            required = false)
    public String leaveRejectedNotificationToEmployee();


    @Meta.AD(deflt = "Your Leave Request Has Been Cancelled",
            name="Leave Cancelled Notification to Employee (Employee)",
            required = false)
    public String leaveCancelledNotificationToEmployee();
    @Meta.AD(deflt = "<h1>HELLO</h1>",
            name="Compensatory Leave Request Cancelled Notification to Employee (Employee)",
            required = false)
    public String compensatoryLeaveRequestCancelledNotificationToEmployee();
    @Meta.AD(deflt = "Your Compensatory Request Has Been Approved",
            name="Compensatory Leave Request Approved Notification to Employee (Employee)",
            required = false)
    public String compensatoryLeaveRequestApprovedNotificationToEmployee();
    @Meta.AD(deflt = "Your Compensatory Request Has Been Rejected",
            name="Compensatory Leave Request Rejected Notification to Employee (Employee)",
            required = false)
    public String compensatoryLeaveRequestRejectedNotificationToEmployee();
    @Meta.AD(deflt = "New Compensatory Request Has Been Added.",
            name="Compensatory Leave Request Notification to Manager And HR (Employee)",
            required = false)
    public String compensatoryLeaveRequestNotificationToManagerAndHr();

    @Meta.AD(
            deflt =
                    "The compensatory leave request submitted by ${EMPLOYEE_NAME} has been cancelled.",
            name = "Compensatory Leave Request Cancelled Notification to Approver",
            description =
                    "Notification sent to the approver when an employee cancels a compensatory leave request. " +
                            "Available placeholders: ${APPROVER_NAME}, ${EMPLOYEE_NAME}, ${LEAVE_DATE}.",
            required = false
    )
    public String compensatoryLeaveRequestCancelledNotificationToApprover();


    @Meta.AD(deflt = "<h1>Leave is Requested.</h1>",
            name="Leave Rejected Notification to Manager.",
            required = false)
    public String leaveRequestedNotificationToManager();


    @Meta.AD(deflt = "<h1>HELLO</h1>",
            name="WFH Approved Notification to Employee (Employee)",
            required = false)
    public String WFHRequestApprovedNotificationToEmployee();

    @Meta.AD(deflt = "<h1>HELLO</h1>",
            name="WFH Rejected Notification to Employee (Employee)",
            required = false)
    public String WFHRequestRejectedNotificationToEmployee();

    @Meta.AD(deflt = "<h1>HELLO</h1>",
            name="WFH Canceled Notification to Employee (Employee)",
            required = false)
    public String WFHRequestCanceledNotificationToEmployee();

    @Meta.AD(
            deflt = "<h1>HELLO</h1>",
            name = "Work From Home Request Manager And HR",
            required = false
    )
    public String WFHRequestManagerAndHr();
}
