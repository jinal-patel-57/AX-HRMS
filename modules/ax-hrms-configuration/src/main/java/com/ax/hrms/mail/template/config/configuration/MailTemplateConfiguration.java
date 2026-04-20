package com.ax.hrms.mail.template.config.configuration;

import aQute.bnd.annotation.metatype.Meta;
import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;

@ExtendedObjectClassDefinition(category = "HRMS", scope = ExtendedObjectClassDefinition.Scope.SYSTEM)
@Meta.OCD(id = "com.ax.hrms.mail.template.config.configuration.MailTemplateConfiguration",
        localization = "content/Language", name = "mail-template-configuration")
public interface MailTemplateConfiguration {

    @Meta.AD( deflt = "Welcome to the Team",
            name = "Permanent Employee OnBoarding Mail (SUBJECT)",
            required = false)
    public String mailOnBoardingPermanentAndTemporaryEmployeesSubject();

    @Meta.AD(
            deflt =
                    "<!DOCTYPE html>" +
                            "<html>" +
                            "<head>" +
                            "    <meta charset=\"UTF-8\">" +
                            "    <title>Onboarding Details</title>" +
                            "</head>" +
                            "<body style=\"font-family: Arial, sans-serif; background-color: #f7f7f7; padding: 20px;\">" +
                            "    <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" " +
                            "           style=\"max-width: 600px; margin: 0 auto; background: #ffffff; padding: 20px; border-radius: 8px;\">" +
                            "        <tr>" +
                            "            <td>" +
                            "                <h2 style=\"color: #333333;\">Dear Employee,</h2>" +
                            "                <p style=\"color: #555555; font-size: 14px; line-height: 1.6;\">" +
                            "                    Welcome to our organization! Your onboarding has been successfully initiated." +
                            "                </p>" +

                            "                <h3 style=\"color: #333333;\">Your Login Details:</h3>" +
                            "                <p style=\"color: #555555; font-size: 14px; line-height: 1.6;\">" +
                            "                    <strong>Email:</strong> ${EMPLOYEE_MAIL}<br>" +
                            "                    <strong>Password:</strong> ${EMPLOYEE_PASSWORD}" +
                            "                </p>" +

                            "                <h3 style=\"color: #333333;\">Important Links:</h3>" +
                            "                <p style=\"color: #555555; font-size: 14px; line-height: 1.6;\">" +
                            "                    <strong>Login:</strong> " +
                            "                    <a href=\"${LOGIN_LINK}\" style=\"background-color: #0066cc; color: #ffffff; padding: 10px 15px; text-decoration: none; border-radius: 5px; font-size: 14px;\">Login Here</a>" +
                            "                </p>" +
                            "                <p style=\"color: #555555; font-size: 14px; line-height: 1.6;\">" +
                            "                    <strong>Complete Onboarding:</strong> " +
                            "                    <a href=\"${ONBOARDING_LINK}\" style=\"background-color: #0066cc; color: #ffffff; padding: 10px 15px; text-decoration: none; border-radius: 5px; font-size: 14px;\">Complete Onboarding</a>" +
                            "                </p>" +
                            "                <p style=\"color: #555555; font-size: 14px; line-height: 1.6;\">" +
                            "                    <strong>Insurance Details:</strong> " +
                            "                    <a href=\"${INSURANCE_LINK}\" style=\"background-color: #0066cc; color: #ffffff; padding: 10px 15px; text-decoration: none; border-radius: 5px; font-size: 14px;\">View Insurance</a>" +
                            "                </p>" +

                            "                <p style=\"color: #555555; font-size: 14px; line-height: 1.6;\">" +
                            "                    If you have any questions, feel free to reach out to the HR team." +
                            "                </p>" +

                            "                <p style=\"margin-top: 30px; color: #333333; font-size: 14px;\">" +
                            "                    Regards,<br><strong>HR Team</strong>" +
                            "                </p>" +
                            "            </td>" +
                            "        </tr>" +
                            "    </table>" +
                            "</body>" +
                            "</html>",
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

    @Meta.AD(deflt = "Wishes for Work Anniversary",
            name = "Anniversary Wish (SUBJECT)",
            required = false)
    public String mailAnniversaryWishSubject();

    @Meta.AD(
            deflt =
                    "<!DOCTYPE html>" +
                            "<html><head><meta charset=\"UTF-8\"><title>Email Template</title></head>" +
                            "<body style=\"font-family: Arial, sans-serif; background-color: #f7f7f7; padding: 20px;\">" +
                            "<table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" " +
                            "style=\"max-width: 600px; margin: 0 auto; background: #ffffff; padding: 20px; border-radius: 8px;\">" +
                            "<tr><td>" +
                            "<p style=\"color:#333;font-size:14px;\">Dear <strong>${EMPLOYEE_NAME}</strong>,</p>" +
                            "<p style=\"color:#555;font-size:14px;line-height:1.6;\">${WISH_BODY}</p>" +
                            "<p style=\"margin-top:30px;color:#333;font-size:14px;\">Best Regards,<br><strong>${SENDER_NAME}</strong></p>" +
                            "</td></tr></table></body></html>",
            name = "Anniversary Wish (BODY)",
            required = false)
    public String mailAnniversaryWishBody();

    @Meta.AD(
            deflt = "Welcome to the Team",
            name = "Intern and Contractor OnBoarding Mail (SUBJECT)",
            required = false)
    public String mailOnBoardingInternAndContractorEmployeesSubject();

    @Meta.AD(
            deflt =
                    "<!DOCTYPE html><html><head><meta charset=\"UTF-8\"><title>Onboarding Details</title></head>" +
                            "<body style=\"font-family:Arial,sans-serif;background-color:#f7f7f7;padding:20px;\">" +
                            "<table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" " +
                            "style=\"max-width:600px;margin:0 auto;background:#fff;padding:20px;border-radius:8px;\">" +
                            "<tr><td>" +
                            "<h2>Dear Employee,</h2>" +
                            "<p>Welcome to our organization! Your onboarding has been successfully initiated.</p>" +
                            "<h3>Your Login Details:</h3>" +
                            "<p><strong>Email:</strong> ${EMPLOYEE_MAIL}<br><strong>Password:</strong> ${EMPLOYEE_PASSWORD}</p>" +
                            "<p><strong>Login:</strong> <a href=\"${LOGIN_LINK}\">Login Here</a></p>" +
                            "<p><strong>Complete Onboarding:</strong> <a href=\"${ONBOARDING_LINK}\">Complete Onboarding</a></p>" +
                            "<p>Regards,<br><strong>HR Team</strong></p>" +
                            "</td></tr></table></body></html>",
            name = "Intern and Contractor OnBoarding Mail (BODY)",
            required = false)
    public String mailOnBoardingInternAndContractorEmployeesBody();

    //

    @Meta.AD(
            deflt = "Request to Verify Onboarding Information",
            name = "Verify OnBoarding Details HR MAIL (SUBJECT)",
            required = false)
    public String mailHrForOnBoardingDetailsVerificationSubject();

    @Meta.AD(
            deflt =
                    "<!DOCTYPE html><html><head><meta charset=\"UTF-8\"></head>" +
                            "<body style=\"font-family:Arial,sans-serif;background:#f2f2f2;padding:20px;\">" +
                            "<table style=\"max-width:600px;margin:auto;background:#fff;padding:20px;border-radius:8px;\">" +
                            "<tr><td>" +
                            "<p>Dear HR,</p>" +
                            "<p>Please verify the onboarding details for <strong>${EMPLOYEE_NAME}</strong>.</p>" +
                            "<a href=\"${VERIFICATION_LINK}\">Verify Onboarding Details</a>" +
                            "</td></tr></table></body></html>",
            name = "Verify OnBoarding Details HR MAIL  (BODY)",
            required = false)
    public String mailHrForOnBoardingDetailsVerificationBody();

    //

    @Meta.AD(
            deflt = "Action Required: Re-Upload Onboarding Details",
            name = "Re-Upload OnBoarding Details Employee MAIL  (SUBJECT)",
            required = false)
    public String reUploadOnboardingDetailsEmployeeMailSubject();


    @Meta.AD(
            deflt =
                    "<!DOCTYPE html><html><head><meta charset=\"UTF-8\"></head>" +
                            "<body style=\"font-family:Arial,sans-serif;background:#f2f2f2;padding:20px;\">" +
                            "<table style=\"max-width:600px;margin:auto;background:#fff;padding:20px;border-radius:8px;\">" +
                            "<tr><td>" +
                            "<p>Dear <strong>${EMPLOYEE_NAME}</strong>,</p>" +
                            "<div style=\"background-color:#fff3cd;border:2px solid #ffc107;border-radius:6px;padding:15px;margin:20px 0;\">" +
                            "<p style=\"color:#856404;margin:0;\">${COMMENTS}</p>" +
                            "</div>" +
                            "<p style=\"margin-top:20px;\"><a href=\"${RE_UPLOAD_LINK}\" style=\"background-color:#0066cc;color:#fff;padding:10px 20px;text-decoration:none;border-radius:5px;display:inline-block;\">Re-upload Onboarding Details</a></p>" +
                            "</td></tr></table></body></html>",
            name = "Re-Upload OnBoarding Details Employee MAIL  (BODY)",
            required = false)
    public String reUploadOnboardingDetailsEmployeeMailBody();


    //


    @Meta.AD(
            deflt = "Employee OnBoarding Details Verification",
            name = "Employee OnBoarding Details Successfully Verified Employee MAIL  (SUBJECT)",
            required = false)
    public String onboardingVerificationSuccessEmailSubject();


    @Meta.AD(
            deflt =
                    "<!DOCTYPE html><html><head><meta charset=\"UTF-8\"></head>" +
                            "<body><p>Dear ${EMPLOYEE_NAME},</p>" +
                            "<p>Your onboarding details have been successfully verified.</p>" +
                            "<p>Regards,<br>HR Team</p></body></html>",
            name = "Employee OnBoarding Details Successfully Verified Employee MAIL  (BODY)",
            required = false)
    public String onboardingVerificationSuccessEmailBody();


    //

    @Meta.AD(deflt = "Employee Off-Boarding Mail",
            name = "Employee Off-Boarding Mail (SUBJECT)",
            required = false)
    public String employeeOffBoardingMailSubject();

    @Meta.AD(    deflt =
            "<!DOCTYPE html><html><head><meta charset=\"UTF-8\"></head>" +
                    "<body><p>Dear ${EMPLOYEE_NAME},</p>" +
                    "<p>${EMPLOYEE_DETAILS}</p>" +
                    "<p>${FULL_AND_FINAL_DETAILS}</p>" +
                    "<p>Regards,<br>HR Team</p></body></html>",
            name = "Employee Off-Boarding Mail (BODY)",
            required = false)
    public String employeeOffBoardingMailBody();


//Birthday Portlet

    @Meta.AD(deflt = "Happy Birthday",
            name = "Birthday Wish (SUBJECT)",
            required = false)
    public String mailBirthdayWishSubject();

    @Meta.AD(deflt = "${WISH_BODY}",
            //description = "${EMPLOYEE_NAME} ${SENDER_NAME} ",
            name = "Birthday Wish (BODY)",
            required = false)
    public String mailBirthdayWishBody();


    // New Joiner Portlet
    @Meta.AD(deflt = "Congratulations and Best Wishes",
            name = "New Joinee Wish (SUBJECT)",
            required = false)
    public String mailNewJoinerWishSubject();

    @Meta.AD(deflt = "${WISH_BODY}",
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

    @Meta.AD(deflt = "Birthday Person",
            //description = "${TABLE} ",
            name = "Daily Scheduler Birthday (SUBJECT)",
            required = false)
    public String mailDailySchedulerBirthdaySubject();

    @Meta.AD(deflt = "Anniversary Person",
            //description = "${TABLE} ",
            name = "Daily Scheduler Anniversary (SUBJECT)",
            required = false)
    public String mailDailySchedulerAnniversarySubject();

    @Meta.AD(deflt = "${TABLE}",
            name = "Daily Scheduler Birthday(BODY)",
            required = false)
    public String mailDailySchedulerBirthdayBody();
    
    @Meta.AD(deflt = "${TABLE}",
    		name = "Daily Scheduler Anniversary(BODY)",
    		required = false)
    public String mailDailySchedulerAnniversaryBody();
    
    

    // Leave Data for Employee
    @Meta.AD(deflt = "Your Leave Request Has Been Approved",
            name = "Leave Approve Mail to  Employee (SUBJECT)",
            required = false)
    public String mailLeaveApproveEmployeeSubject();

    @Meta.AD(
            deflt =
                    "<!DOCTYPE html><html><head><meta charset=\"UTF-8\"></head>" +
                            "<body style=\"font-family:Arial,sans-serif;background:#f7f7f7;padding:20px;\">" +
                            "<table style=\"max-width:600px;margin:auto;background:#fff;padding:20px;border-radius:8px;\">" +
                            "<tr><td>" +
                            "<p>Dear <strong>${EMPLOYEE_NAME}</strong>,</p>" +
                            "<p>${BODY}</p>" +
                            "</td></tr></table></body></html>",
            //description = "${EMPLOYEE_NAME} ${BODY} ",
            name = "Leave Approve Mail to  Employee (BODY)",
            required = false)
    public String mailLeaveApproveEmployeeBody();
    
    
    @Meta.AD(deflt = "Your Leave Request Has Been Rejected",
    		name = "Leave Reject Mail to  Employee (SUBJECT)",
    		required = false)
    public String mailLeaveRejectEmployeeSubject();
    
    @Meta.AD(
            deflt =
                    "<!DOCTYPE html><html><head><meta charset=\"UTF-8\"></head>" +
                            "<body style=\"font-family:Arial,sans-serif;background:#f7f7f7;padding:20px;\">" +
                            "<table style=\"max-width:600px;margin:auto;background:#fff;padding:20px;border-radius:8px;\">" +
                            "<tr><td>" +
                            "<p>Dear <strong>${EMPLOYEE_NAME}</strong>,</p>" +
                            "<p>${BODY}</p>" +
                            "</td></tr></table></body></html>",
    		//description = "${EMPLOYEE_NAME} ${BODY} ",
    		name = "Leave Reject Mail to  Employee (BODY)",
    		required = false)
    public String mailLeaveRejectEmployeeBody();
    
    @Meta.AD(    deflt = "Your Leave Request Has Been Cancelled",
    		name = "Leave Cancel Mail to  Employee (SUBJECT)",
    		required = false)
    public String mailLeaveCancelEmployeeSubject();
    
    @Meta.AD(    deflt =
            "<!DOCTYPE html><html><head><meta charset=\"UTF-8\"></head>" +
                    "<body style=\"font-family:Arial,sans-serif;background:#f7f7f7;padding:20px;\">" +
                    "<table style=\"max-width:600px;margin:auto;background:#fff;padding:20px;border-radius:8px;\">" +
                    "<tr><td>" +
                    "<p>Dear <strong>${EMPLOYEE_NAME}</strong>,</p>" +
                    "<p>${BODY}</p>" +
                    "</td></tr></table></body></html>",
    		//description = "${EMPLOYEE_NAME} ${BODY} ",
    		name = "Leave Cancel Mail to  Employee (BODY)",
    		required = false)
    public String mailLeaveCancelEmployeeBody();
    
    
    

    // Leave Data for Team
    @Meta.AD(deflt = "Leave Management Team",
            name = "Leave Management Team(SUBJECT)",
            required = false)
    public String mailLeaveManagementTeamSubject();

    @Meta.AD(deflt = "${BODY}",
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


    @Meta.AD(    deflt = "Your Compensatory Request Has Been Cancelled",
            name = "Compensatory Leave Request Cancel Mail to Employee (SUBJECT)",
            required = false)
    public String mailCompensatoryLeaveRequestCancelEmployeeSubject();

    @Meta.AD(  deflt =
            "<!DOCTYPE html><html><head><meta charset=\"UTF-8\"></head>" +
                    "<body style=\"font-family:Arial,sans-serif;background:#f7f7f7;padding:20px;\">" +
                    "<table style=\"max-width:600px;margin:auto;background:#fff;padding:20px;border-radius:8px;\">" +
                    "<tr><td>" +
                    "<p>Dear <strong>${EMPLOYEE_NAME}</strong>,</p>" +
                    "<p>${BODY}</p>" +
                    "</td></tr></table></body></html>",
            //description = "${EMPLOYEE_NAME} ${BODY} ",
            name = "Compensatory Leave Request Cancel Mail to Employee (BODY)",
            required = false)
    public String mailCompensatoryLeaveRequestCancelEmployeeBody();
    @Meta.AD(deflt = "Your Compensatory Request Has Been Approved",
            name = "Compensatory Leave Request Approved Mail to Employee (SUBJECT)",
            required = false)
    public String mailCompensatoryLeaveRequestApprovedEmployeeSubject();

    @Meta.AD(    deflt =
            "<!DOCTYPE html><html><head><meta charset=\"UTF-8\"></head>" +
                    "<body style=\"font-family:Arial,sans-serif;background:#f7f7f7;padding:20px;\">" +
                    "<table style=\"max-width:600px;margin:auto;background:#fff;padding:20px;border-radius:8px;\">" +
                    "<tr><td>" +
                    "<p>Dear <strong>${EMPLOYEE_NAME}</strong>,</p>" +
                    "<p>${BODY}</p>" +
                    "</td></tr></table></body></html>",
            //description = "${EMPLOYEE_NAME} ${BODY} ",
            name = "Compensatory Leave Request Approved Mail to Employee (BODY)",
            required = false)
    public String mailCompensatoryLeaveRequestApprovedEmployeeBody();
    @Meta.AD(    deflt = "Your Compensatory Request Has Been Rejected",
            name = "Compensatory Leave Request Rejected Mail to Employee (SUBJECT)",
            required = false)
    public String mailCompensatoryLeaveRequestRejectedEmployeeSubject();

    @Meta.AD(
            deflt =
                    "<!DOCTYPE html><html><head><meta charset=\"UTF-8\"></head>" +
                            "<body style=\"font-family:Arial,sans-serif;background:#f7f7f7;padding:20px;\">" +
                            "<table style=\"max-width:600px;margin:auto;background:#fff;padding:20px;border-radius:8px;\">" +
                            "<tr><td>" +
                            "<p>Dear <strong>${EMPLOYEE_NAME}</strong>,</p>" +
                            "<p>${BODY}</p>" +
                            "</td></tr></table></body></html>",
            //description = "${EMPLOYEE_NAME} ${BODY} ",
            name = "Compensatory Leave Request Rejected Mail to Employee (BODY)",
            required = false)
    public String mailCompensatoryLeaveRequestRejectedEmployeeBody();

    @Meta.AD( deflt = "New Compensatory Request",
            name = "Compensatory Leave Request Manager And HR (SUBJECT)",
            required = false)
    public String mailCompensatoryLeaveRequestManagerAndHrSubject();



    @Meta.AD(
            deflt = "Compensatory Leave Request Cancelled",
            name = "Compensatory Leave Request Cancel Mail to Approver (SUBJECT)",
            description = "Email subject sent to the approver when an employee cancels a compensatory leave request.",
            required = false
    )
    public String mailCompensatoryLeaveRequestCancelApproverSubject();

    @Meta.AD(
            deflt =
                    "<p>Dear ${APPROVER_NAME},</p>" +
                            "<p>The compensatory leave request submitted by ${EMPLOYEE_NAME} has been cancelled.</p>"+
                            "${BODY}"+
                            "<p>Regards,<br/>HR Team</p>",
            name = "Compensatory Leave Request Cancel Mail to Approver (BODY)",
            description =
                    "Email body sent to the approver when an employee cancels a compensatory leave request. " +
                            "Available placeholders: ${APPROVER_NAME}, ${EMPLOYEE_NAME}, ${CANCEL_REASON}.",
            required = false
    )
    public String mailCompensatoryLeaveRequestCancelApproverBody();




    @Meta.AD(
            deflt =
                    "<!DOCTYPE html>" +
                            "<html>" +
                            "<head>" +
                            "<meta charset=\"UTF-8\">" +
                            "<title>Email Template</title>" +
                            "</head>" +
                            "<body style=\"font-family: Arial, sans-serif; background-color: #f7f7f7; padding: 20px;\">" +
                            "<table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" " +
                            "style=\"max-width: 600px; margin: auto; background: #ffffff; padding: 20px; border-radius: 8px;\">" +
                            "<tr>" +
                            "<td>" +
                            "<p style=\"color: #333333; font-size: 15px;\">" +
                            "Dear <strong>${EMPLOYEE_NAME}</strong>," +
                            "</p>" +
                            "<p style=\"color: #555555; font-size: 14px; line-height: 1.6;\">" +
                            "${BODY}" +
                            "</p>" +
                            "</td>" +
                            "</tr>" +
                            "</table>" +
                            "</body>" +
                            "</html>",
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
            name = "Work From Home Request Approved Mail to Team (SUBJECT)",
            required = false
    )
    public String mailWFHApproveTeamSubject();

    @Meta.AD(
            deflt = "<p>Dear Team Members,</p>" +
                    "<p>Work From Home request has been <b>approved</b>.</p>" +
                    "${BODY}" ,
            name = "Work From Home Request Approved Mail to Team (BODY)",
            required = false
    )
    public String mailWFHApproveTeamBody();


    @Meta.AD(
            deflt = "Upcoming Employee Birthdays - After 7 Days",
            name = "Upcoming Birthday Notification to HR and Marketing (SUBJECT)",
            required = false
    )
    public String mailUpcomingBirthdayHrMarketingSubject();


    @Meta.AD(
            deflt = "<p>Dear Team,</p>" +
                    "<p>Please find below the list of employees who have upcoming <b>Birthdays</b> on <b>${EVENT_DATE}</b>" +
                    "${BODY}" +
                    "<p>Kindly make the necessary arrangements.</p>" +
                    "<p>Regards,<br/>HRMS</p>",
            name = "Upcoming Birthday Notification to HR and Marketing (BODY)",
            required = false
    )
    public String mailUpcomingBirthdayHrMarketingBody();


    @Meta.AD(
            deflt = "Upcoming Work Anniversaries - After 7 Days",
            name = "Upcoming Work Anniversary Notification to HR and Marketing (SUBJECT)",
            required = false
    )
    public String mailUpcomingAnniversaryHrMarketingSubject();


    @Meta.AD(
            deflt = "<p>Dear Team,</p>" +
                    "<p>Please find below the list of employees who have upcoming <b>Work Anniversaries</b> on <b>${EVENT_DATE}</b>" +
                    "${BODY}" +
                    "<p>Kindly take the necessary action.</p>" +
                    "<p>Regards,<br/>HRMS</p>",
            name = "Upcoming Work Anniversary Notification to HR and Marketing (BODY)",
            required = false
    )
    public String mailUpcomingAnniversaryHrMarketingBody();





    @Meta.AD(
            deflt = "Yearly Scheduler Execution Failed - Immediate Attention Required",
            name = "Yearly Scheduler Failure Notification (SUBJECT)",
            required = false
    )
    public String mailYearlySchedulerFailSubject();


    @Meta.AD(
            deflt = "<p style=\"font-family:Arial, sans-serif; font-size:14px;\">Dear Team,</p>" +
                    "<p style=\"font-family:Arial, sans-serif; font-size:14px;\">" +
                    "The yearly scheduled job has encountered an <b style=\"color:#d9534f;\">error</b> during execution." +
                    "</p>" +
                    "<p style=\"font-family:Arial, sans-serif; font-size:14px;\">" +
                    "Please find the error details below:" +
                    "</p>" +
                    "<div style=\"background-color:#f8d7da; border-left:4px solid #d9534f; padding:10px; " +
                    "font-family:monospace; font-size:13px; color:#721c24; margin:10px 0;\">" +
                    "${MESSAGE}" +
                    "</div>" +
                    "<p style=\"font-family:Arial, sans-serif; font-size:14px;\">" +
                    "Kindly review the issue and take necessary corrective action at the earliest." +
                    "</p>" +
                    "<br/>" +
                    "<p style=\"font-family:Arial, sans-serif; font-size:14px;\">" +
                    "Regards,<br/>" +
                    "<b>HRMS System Scheduler</b><br/>" +
                    "<span style=\"font-size:12px; color:#888;\">(This is an automated notification)</span>" +
                    "</p>",
            name = "Yearly Scheduler Failure Notification (BODY)",
            required = false
    )
    public String mailYearlySchedulerFailBody();

	@Meta.AD(
		deflt = "hr@yopmail.com",
		name = "Attendance Reconciliation Recipient Email",
		required = false
	)
	public String mailAttendanceReconciliationToEmailAddress();

	@Meta.AD(
		deflt = "Missing Attendance Reconciliation Report - ${YEAR_MONTH}",
		name = "Attendance Reconciliation Report (SUBJECT)",
		required = false
	)
	public String mailAttendanceReconciliationSubject();

	@Meta.AD(
		deflt = "<p>Dear HR Team,</p><p>Please find attached the missing attendance report for the period <b>${YEAR_MONTH}</b>.</p><p>Regards,<br/>HRMS System</p>",
		name = "Attendance Reconciliation Report (BODY)",
		required = false
	)
	public String mailAttendanceReconciliationBody();
}
