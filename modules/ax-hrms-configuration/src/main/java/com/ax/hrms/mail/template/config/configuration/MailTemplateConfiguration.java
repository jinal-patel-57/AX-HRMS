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


}
