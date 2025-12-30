package com.ax.hrms.mail.template.config.configuration;

import aQute.bnd.annotation.metatype.Meta;
import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;

@ExtendedObjectClassDefinition(category = "HRMS", scope = ExtendedObjectClassDefinition.Scope.SYSTEM)
@Meta.OCD(id = "com.ax.hrms.mail.template.config.configuration.MailTemplateConfiguration",
        localization = "content/Language", name = "mail-template-configuration")
public interface MailTemplateConfiguration {

    @Meta.AD(deflt = "<h1>HELLO</h1>",
            name = "Permanent Employee OnBoarding Mail (SUBJECT)",
            required = false)
    public String mailOnBoardingPermanentAndTemporaryEmployeesSubject();

    @Meta.AD(deflt = "<h1>HELLO</h1>",
            name = "Permanent Employee OnBoarding Mail (BODY)",
            required = false)
    public String mailOnBoardingPermanentAndTemporaryEmployeesBody();




    @Meta.AD(deflt = "<h1>HELLO</h1>",
            name = "Appraisal Meeting  (SUBJECT)",
            required = false)
    public String appraisalMeetingScheduledSubject();

    @Meta.AD(deflt = "<h1>HELLO</h1>",
            name = "Appraisal Meeting  (BODY)",
            required = false)
    public String appraisalMeetingScheduledBody();



    @Meta.AD(deflt = "<h1>HELLO</h1>",
            name = "Appraisal Meeting Updated (SUBJECT)",
            required = false)
    public String appraisalMeetingUpdatedSubject();

    @Meta.AD(deflt = "<h1>HELLO</h1>",
            name = "Appraisal Meeting Updated (BODY)",
            required = false)
    public String appraisalMeetingUpdatedBody();

    @Meta.AD(deflt = "<h1>HELLO</h1>",
            name = "Appraisal Meeting Invitation Cancellation (SUBJECT)",
            required = false)
    public String appraisalMeetingInvitationCancellationSubject();

    @Meta.AD(deflt = "<h1>HELLO</h1>",
            name = "Appraisal Meeting Invitation Cancellation (BODY)",
            required = false)
    public String appraisalMeetingInvitationCancellationBody();





    @Meta.AD(deflt = "<h1>HELLO</h1>",
            name = "Manager Evaluation Form Mail (SUBJECT)",
            required = false)
    public String managerEvaluationFormMailSubject();

    @Meta.AD(deflt = "<h1>HELLO</h1>",
            name = "Manager Evaluation Form Mail (BODY)",
            required = false)
    public String managerEvaluationFormMailBody();


    @Meta.AD(deflt = "<h1>HELLO</h1>",
            name = "Peer Evaluation Form Mail (SUBJECT)",
            required = false)
    public String peerEvaluationFormMailSubject();

    @Meta.AD(deflt = "<h1>HELLO</h1>",
            name = "Peer Evaluation Form Mail (BODY)",
            required = false)
    public String peerEvaluationFormMailBody();

    @Meta.AD(deflt = "<h1>HELLO</h1>",
            name = "Self Evaluation Form Mail (SUBJECT)",
            required = false)
    public String selfEvaluationFormMailSubject();

    @Meta.AD(deflt = "<h1>HELLO</h1>",
            name = "Self Evaluation Form Mail (BODY)",
            required = false)
    public String selfEvaluationFormMailBody();


    @Meta.AD(deflt = "<h1>HELLO</h1>",
            name = "PIP Program Mail (SUBJECT)",
            required = false)
    public String pipProgramMailSubject();

    @Meta.AD(deflt = "<h1>HELLO</h1>",
            name = "PIP Program Mail (BODY)",
            required = false)
    public String pipProgramMailBody();






    @Meta.AD(deflt = "<h1>HELLO</h1>",
            name = "Appraisal Document to Employee  (SUBJECT)",
            required = false)
    public String appraisalDocumentSubject();

    @Meta.AD(deflt = "<h1>HELLO</h1>",
            name = "Appraisal Document to Employee (BODY)",
            required = false)
    public String appraisalDocumentBody();

    // Anniversary Web Portlet

    @Meta.AD(deflt = "<h1>HELLO</h1>",
            name = "Anniversary Wish (SUBJECT)",
            required = false)
    public String mailAnniversaryWishSubject();

    @Meta.AD(deflt = "<h1>HELLO</h1>",
//description = "${EMPLOYEE_NAME} ${SENDER_NAME} ",
            name = "Anniversary Wish (BODY)",
            required = false)
    public String mailAnniversaryWishBody();

    @Meta.AD(deflt = "<h1>HELLO</h1>",
            name = "Intern and Contractor OnBoarding Mail (SUBJECT)",
            required = false)
    public String mailOnBoardingInternAndContractorEmployeesSubject();

    @Meta.AD(deflt = "<h1>HELLO</h1>",
            name = "Intern and Contractor OnBoarding Mail (BODY)",
            required = false)
    public String mailOnBoardingInternAndContractorEmployeesBody();

    //

    @Meta.AD(deflt = "<h1>HELLO</h1>",
            name = "Verify OnBoarding Details HR MAIL (SUBJECT)",
            required = false)
    public String mailHrForOnBoardingDetailsVerificationSubject();

    @Meta.AD(deflt = "<h1>HELLO</h1>",
            name = "Verify OnBoarding Details HR MAIL  (BODY)",
            required = false)
    public String mailHrForOnBoardingDetailsVerificationBody();

    //

    @Meta.AD(deflt = "<h1>HELLO</h1>",
            name = "Re-Upload OnBoarding Details Employee MAIL  (SUBJECT)",
            required = false)
    public String reUploadOnboardingDetailsEmployeeMailSubject();


    @Meta.AD(deflt = "<h1>HELLO</h1>",
            name = "Re-Upload OnBoarding Details Employee MAIL  (BODY)",
            required = false)
    public String reUploadOnboardingDetailsEmployeeMailBody();


    //


    @Meta.AD(deflt = "<h1>HELLO</h1>",
            name = "Employee OnBoarding Details Successfully Verified Employee MAIL  (SUBJECT)",
            required = false)
    public String onboardingVerificationSuccessEmailSubject();


    @Meta.AD(deflt = "<h1>HELLO</h1>",
            name = "Employee OnBoarding Details Successfully Verified Employee MAIL  (BODY)",
            required = false)
    public String onboardingVerificationSuccessEmailBody();


    //

    @Meta.AD(deflt = "<h1>HELLO</h1>",
            name = "Employee Off-Boarding Mail (SUBJECT)",
            required = false)
    public String employeeOffBoardingMailSubject();

    @Meta.AD(deflt = "<h1>HELLO</h1>",
            name = "Employee Off-Boarding Mail (BODY)",
            required = false)
    public String employeeOffBoardingMailBody();


//Birthday Portlet

    @Meta.AD(deflt = "<h1>HELLO</h1>",
            name = "Birthday Wish (SUBJECT)",
            required = false)
    public String mailBirthdayWishSubject();

    @Meta.AD(deflt = "<h1>HELLO</h1>",
            //description = "${EMPLOYEE_NAME} ${SENDER_NAME} ",
            name = "Birthday Wish (BODY)",
            required = false)
    public String mailBirthdayWishBody();


    // New Joiner Portlet
    @Meta.AD(deflt = "<h1>HELLO</h1>",
            name = "New Joinee Wish (SUBJECT)",
            required = false)
    public String mailNewJoinerWishSubject();

    @Meta.AD(deflt = "<h1>HELLO</h1>",
            //description = "${EMPLOYEE_NAME} ${SENDER_NAME} ",
            name = "New Joinee Wish (BODY)",
            required = false)
    public String mailNewJoinerWishBody();


    // Project Portlet

    @Meta.AD(deflt = "<h1>HELLO</h1>",
            name = "Project Assignement for Employee (SUBJECT)",
            required = false)
    public String mailAssignProjectSubject();

    @Meta.AD(deflt = "<h1>HELLO</h1>",
            //description = "${EMPLOYEE_NAME} ${SENDER_NAME} ${PROJECT_NAME} ${STATUS}",
            name = "Project Assignement for Employee (BODY)",
            required = false)
    public String mailAssignProjectBody();
    
    
    @Meta.AD(deflt = "<h1>HELLO</h1>",
            name = "Project Removal for Employee (SUBJECT)",
            required = false)
    public String mailRemovalProjectSubject();

    @Meta.AD(deflt = "<h1>HELLO</h1>",
            //description = "${EMPLOYEE_NAME} ${SENDER_NAME} ${PROJECT_NAME} ",
            name = "Project Removal for Employee (BODY)",
            required = false)
    public String mailRemovalProjectBody();


    // Task Portlet

    @Meta.AD(deflt = "<h1>HELLO</h1>",
            name = "Task Assignement for Employee (SUBJECT)",
            required = false)
    public String mailAssignTaskSubject();

    @Meta.AD(deflt = "<h1>HELLO</h1>",
            //description = "${EMPLOYEE_NAME} ${SENDER_NAME} ${PROJECT_NAME} ${STATUS}",
            name = "Task Assignement for Employee (BODY)",
            required = false)
    public String mailAssignTaskBody();
    
    @Meta.AD(deflt = "<h1>HELLO</h1>",
    		name = "Task Removal for Employee (SUBJECT)",
    		required = false)
    public String mailRemoveTaskSubject();
    
    @Meta.AD(deflt = "<h1>HELLO</h1>",
    		//description = "${EMPLOYEE_NAME} ${SENDER_NAME} ${PROJECT_NAME} ${STATUS}",
    		name = "Task Removal for Employee (BODY)",
    		required = false)
    public String mailRemoveTaskBody();


    // Daily Scheduler

    @Meta.AD(deflt = "<h1>HELLO</h1>",
            //description = "${TABLE} ",
            name = "Daily Scheduler Birthday (SUBJECT)",
            required = false)
    public String mailDailySchedulerBirthdaySubject();

    @Meta.AD(deflt = "<h1>HELLO</h1>",
            //description = "${TABLE} ",
            name = "Daily Scheduler Anniversary (SUBJECT)",
            required = false)
    public String mailDailySchedulerAnniversarySubject();

    @Meta.AD(deflt = "<h1>HELLO</h1>",
            name = "Daily Scheduler Birthday(BODY)",
            required = false)
    public String mailDailySchedulerBirthdayBody();
    
    @Meta.AD(deflt = "<h1>HELLO</h1>",
    		name = "Daily Scheduler Anniversary(BODY)",
    		required = false)
    public String mailDailySchedulerAnniversaryBody();
    
    

    // Leave Data for Employee
    @Meta.AD(deflt = "<h1>HELLO</h1>",
            name = "Leave Approve Mail to  Employee (SUBJECT)",
            required = false)
    public String mailLeaveApproveEmployeeSubject();

    @Meta.AD(deflt = "<h1>HELLO</h1>",
            //description = "${EMPLOYEE_NAME} ${BODY} ",
            name = "Leave Approve Mail to  Employee (BODY)",
            required = false)
    public String mailLeaveApproveEmployeeBody();
    
    
    @Meta.AD(deflt = "<h1>HELLO</h1>",
    		name = "Leave Reject Mail to  Employee (SUBJECT)",
    		required = false)
    public String mailLeaveRejectEmployeeSubject();
    
    @Meta.AD(deflt = "<h1>HELLO</h1>",
    		//description = "${EMPLOYEE_NAME} ${BODY} ",
    		name = "Leave Reject Mail to  Employee (BODY)",
    		required = false)
    public String mailLeaveRejectEmployeeBody();
    
    @Meta.AD(deflt = "<h1>HELLO</h1>",
    		name = "Leave Cancel Mail to  Employee (SUBJECT)",
    		required = false)
    public String mailLeaveCancelEmployeeSubject();
    
    @Meta.AD(deflt = "<h1>HELLO</h1>",
    		//description = "${EMPLOYEE_NAME} ${BODY} ",
    		name = "Leave Cancel Mail to  Employee (BODY)",
    		required = false)
    public String mailLeaveCancelEmployeeBody();
    
    
    

    // Leave Data for Team
    @Meta.AD(deflt = "<h1>HELLO</h1>",
            name = "Leave Management Team(SUBJECT)",
            required = false)
    public String mailLeaveManagementTeamSubject();

    @Meta.AD(deflt = "<h1>HELLO</h1>",
            //description = " ${BODY} ",
            name = "Leave Management Team(BODY)",
            required = false)
    public String mailLeaveManagementTeamBody();

    @Meta.AD(
            deflt = "Leave Request Submitted",
            name = "Leave Request Mail to Manager (SUBJECT)",
            required = false
    )
    public String mailLeaveRequestManagerSubject();


    @Meta.AD(deflt = "<h1>HELLO</h1>",
            name = "Compensatory Leave Request Cancel Mail to Employee (SUBJECT)",
            required = false)
    public String mailCompensatoryLeaveRequestCancelEmployeeSubject();

    @Meta.AD(deflt = "<h1>HELLO</h1>",
            //description = "${EMPLOYEE_NAME} ${BODY} ",
            name = "Compensatory Leave Request Cancel Mail to Employee (BODY)",
            required = false)
    public String mailCompensatoryLeaveRequestCancelEmployeeBody();
    @Meta.AD(deflt = "<h1>HELLO</h1>",
            name = "Compensatory Leave Request Approved Mail to Employee (SUBJECT)",
            required = false)
    public String mailCompensatoryLeaveRequestApprovedEmployeeSubject();

    @Meta.AD(deflt = "<h1>HELLO</h1>",
            //description = "${EMPLOYEE_NAME} ${BODY} ",
            name = "Compensatory Leave Request Approved Mail to Employee (BODY)",
            required = false)
    public String mailCompensatoryLeaveRequestApprovedEmployeeBody();
    @Meta.AD(deflt = "<h1>HELLO</h1>",
            name = "Compensatory Leave Request Rejected Mail to Employee (SUBJECT)",
            required = false)
    public String mailCompensatoryLeaveRequestRejectedEmployeeSubject();

    @Meta.AD(deflt = "<h1>HELLO</h1>",
            //description = "${EMPLOYEE_NAME} ${BODY} ",
            name = "Compensatory Leave Request Rejected Mail to Employee (BODY)",
            required = false)
    public String mailCompensatoryLeaveRequestRejectedEmployeeBody();

    @Meta.AD(deflt = "<h1>HELLO</h1>",
            name = "Compensatory Leave Request Manager And HR (SUBJECT)",
            required = false)
    public String mailCompensatoryLeaveRequestManagerAndHrSubject();

    @Meta.AD(deflt = "<h1>HELLO</h1>",
            //description = "${EMPLOYEE_NAME} ${BODY} ",
            name = "Compensatory Leave Request Manager And HR (BODY)",
            required = false)
    public String mailCompensatoryLeaveRequestManagerAndHrBody();



    @Meta.AD(
            deflt = "<h1>Leave Request Submitted.</h1>",
            name = "Leave Request Mail to Manager (BODY)",
            required = false
    )
    public String mailLeaveRequestManagerBody();

    @Meta.AD(
            deflt = "Work From Home Request Approved",
            name = "Work From Home Request Approved Mail to Employee (SUBJECT)",
            required = false
    )
    public String mailWFHApproveEmployeeSubject();


    @Meta.AD(
            deflt = "<p>Dear ${EMPLOYEE_NAME},</p>" +
                    "<p>Work From Home request has been <b>approved</b>.</p>" +
                    "${BODY}",
            name = "Work From Home Request Approved Mail to Employee (BODY)",
            required = false
    )
    public String mailWFHApproveEmployeeBody();

    @Meta.AD(
            deflt = "Work From Home Request Rejected",
            name = "Work From Home Request Rejected Mail to Employee (SUBJECT)",
            required = false
    )
    public String mailWFHRejectEmployeeSubject();


    @Meta.AD(
            deflt = "<p>Dear ${EMPLOYEE_NAME},</p>" +
                    "<p>Work From Home request has been <b>rejected</b>.</p>" +
                    "${BODY}",
            name = "Work From Home Request Rejected Mail to Employee (BODY)",
            required = false
    )
    public String mailWFHRejectEmployeeBody();

    @Meta.AD(
            deflt = "Work From Home Request Cancelled",
            name = "Work From Home Request Cancelled Mail to Employee (SUBJECT)",
            required = false
    )
    public String mailWFHCancelEmployeeSubject();


    @Meta.AD(
            deflt = "<p>Dear ${EMPLOYEE_NAME},</p>" +
                    "<p>Work From Home request has been <b>cancelled</b>.</p>" +
                    "${BODY}",
            name = "Work From Home Request Cancelled Mail to Employee (BODY)",
            required = false
    )
    public String mailWFHCancelEmployeeBody();

    @Meta.AD(
            deflt = "Work From Home Request Notification",
            name = "Work From Home Request Manager And HR (SUBJECT)",
            required = false
    )
    public String mailWFHRequestManagerAndHrSubject();


    @Meta.AD(
            deflt = "<p>Hello ${EMPLOYEE_NAME},</p>" +
                    "<p>A new <b>Work From Home</b> request has been ${STATUS}</p>" +
                    "<p>Employee details are given below:</p>" +
                    "${BODY}" +
                    "<p>Please review and take the necessary action.</p>" +
                    "<p>Regards,<br/>HRMS</p>",
            name = "Work From Home Request Manager And HR (BODY)",
            required = false
    )
    public String mailWFHRequestManagerAndHrBody();

    @Meta.AD(
            deflt = "Work From Home Request Approved",
            name = "Work From Home Request Approved Mail to Employee (SUBJECT)",
            required = false
    )
    public String mailWFHApproveTeamSubject();

    @Meta.AD(
            deflt = "<p>Dear Team Members,</p>" +
                    "<p>Work From Home request has been <b>approved</b>.</p>" +
                    "${BODY}" ,
            name = "Work From Home Request Approved Mail to Employee (BODY)",
            required = false
    )
    public String mailWFHApproveTeamBody();
}
