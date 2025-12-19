package com.ax.hrms.work.from.home.web.hr.util;

import com.ax.hrms.common.api.api.AxHrmsCommonApi;
import com.ax.hrms.mail.template.config.configuration.MailTemplateConfiguration;
import com.ax.hrms.master.model.DepartmentMaster;
import com.ax.hrms.master.model.DesignationMaster;
import com.ax.hrms.master.model.LeaveCompensatoryStatusMaster;
import com.ax.hrms.master.service.DepartmentMasterLocalService;
import com.ax.hrms.master.service.DesignationMasterLocalService;
import com.ax.hrms.master.service.LeaveCompensatoryStatusMasterLocalService;
import com.ax.hrms.model.*;
import com.ax.hrms.service.EmployeeDepartmentLocalService;
import com.ax.hrms.service.EmployeeDesignationLocalService;
import com.ax.hrms.service.EmployeeDetailsLocalService;
import com.ax.hrms.work.from.home.web.constants.AxHrmsWorkFromHomePortletKeys;
import com.ax.hrms.work.from.home.web.employee.notification.SendNotificationToUserHandler;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.UserNotificationDeliveryConstants;
import com.liferay.portal.kernel.model.UserNotificationEvent;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserNotificationEventLocalServiceUtil;
import com.liferay.portal.kernel.util.Validator;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Utility class to get readable WFH status from LeaveCompensatoryStatusMaster
 */
public class WFHStatusUtil {

    private WFHStatusUtil() {
        // Private constructor to prevent instantiation
    }

    private static final Log log = LogFactoryUtil.getLog(WFHStatusUtil.class);

    /**
     * Get WFH status name by status ID
     *
     * @param statusId   Status ID from WorkFromHome entity
     * @param statusList List of LeaveCompensatoryStatusMaster
     * @return Status name as String
     */
    public static String getStatusNameById(long statusId, List<LeaveCompensatoryStatusMaster> statusList) {
        try {
            Optional<LeaveCompensatoryStatusMaster> statusObj = statusList.stream().filter(status -> status.getLeaveCompensatoryStatusMasterId() == statusId).findFirst();

            if (statusObj.isPresent()) {
                return statusObj.get().getLeaveCompensatoryStatus();
            } else {
                log.warn("No WFH status found for ID: " + statusId);
            }
        } catch (Exception e) {
            log.error("Error while fetching WFH status for ID: " + statusId, e);
        }

        return "Unknown";
    }

    public static void sendNotificationToEmployee(String body, EmployeeDetails employee) {

        log.info("Starting sendNotificationToEmployee()");
        log.info("Notification body: " + body);

        if (employee == null) {
            log.warn("EmployeeDetails is null. Notification will not be sent.");
            return;
        }

        log.info("Sending notification to employee. LR User ID: " + employee.getLrUserId());

        try {
            JSONObject notificationJSON = JSONFactoryUtil.createJSONObject();
            notificationJSON.put("body", body);

            log.debug("Notification JSON payload created: " + notificationJSON.toString());

            // Send notification
            UserNotificationEvent userNotification = UserNotificationEventLocalServiceUtil.sendUserNotificationEvents(employee.getLrUserId(), AxHrmsWorkFromHomePortletKeys.AXHRMSWORKFROMHOMEHR, UserNotificationDeliveryConstants.TYPE_WEBSITE, notificationJSON);

            if (userNotification != null) {
                log.info("UserNotificationEvent created successfully. Event ID: " + userNotification.getUserNotificationEventId());
            } else {
                log.warn("UserNotificationEvent is null after sending notification.");
            }

            ServiceContext serviceContext = new ServiceContext();
            SendNotificationToUserHandler sendNotificationToUserHandler = new SendNotificationToUserHandler();

            log.debug("Invoking SendNotificationToUserHandler.callGetBody()");
            sendNotificationToUserHandler.callGetBody(userNotification, serviceContext);

            if (userNotification != null) {
                log.info("Notification sent successfully. Payload: " + userNotification.getPayload());
            }

        } catch (Exception e) {
            log.error("Error occurred while sending notification to employee. LR User ID: " + employee.getLrUserId(), e);
        }

        log.info("Completed sendNotificationToEmployee()");
    }


    public static void sendMailtoManager(String fromName, String fromEmailAddress, StringBuilder body, WorkFromHomeRequest workFromHomeRequest, EmployeeDetails employeeDetails, MailTemplateConfiguration mailTemplateConfiguration, EmployeeDetailsLocalService employeeDetailsLocalService, AxHrmsCommonApi axHrmsCommonApi, Map<String, Object> serviceMap, boolean isApprove, boolean isCancelled) {
        try {
            log.info("SENDING MAIL TO MANAGER");
            EmployeeDetails managerOrHr = employeeDetailsLocalService.getEmployeeDetails(employeeDetails.getEmployeeId());
            DepartmentMasterLocalService departmentMasterLocalService =
                    (DepartmentMasterLocalService) serviceMap.get("departmentMasterLocalService");

            DesignationMasterLocalService designationMasterLocalService =
                    (DesignationMasterLocalService) serviceMap.get("designationMasterLocalService");

            EmployeeDepartmentLocalService employeeDepartmentLocalService =
                    (EmployeeDepartmentLocalService) serviceMap.get("employeeDepartmentLocalService");

            EmployeeDesignationLocalService employeeDesignationLocalService =
                    (EmployeeDesignationLocalService) serviceMap.get("employeeDesignationLocalService");
            LeaveCompensatoryStatusMasterLocalService leaveStatusLocalService =
                    (LeaveCompensatoryStatusMasterLocalService) serviceMap.get("leaveStatusLocalService");
            EmployeeDetails employee = employeeDetailsLocalService.getEmployeeDetails(workFromHomeRequest.getEmployeeId());

            body = getWfhBody(workFromHomeRequest, employee, body, leaveStatusLocalService, departmentMasterLocalService, designationMasterLocalService,employeeDepartmentLocalService,employeeDesignationLocalService);
//
            // SEND MAIL TO EMPLOYE

            String mailContent = isApprove ? mailTemplateConfiguration.mailWFHApproveEmployeeBody() : isCancelled ? mailTemplateConfiguration.mailWFHCancelEmployeeBody() : mailTemplateConfiguration.mailWFHRejectEmployeeBody();


            mailContent = mailContent.replace("${EMPLOYEE_NAME}", managerOrHr.getFirstName() + StringPool.SPACE + managerOrHr.getLastName());

            mailContent = mailContent.replace("${BODY}", body);
//            mailContent = mailContent.replace("${EMPLOYEE_NAME}", employee.getFirstName() + StringPool.SPACE + employee.getLastName());
//            mailContent =  mailContent.replace("${BODY}", body);
            log.info("SENDING MAIL TO MANAGER ...." + mailContent);
            String subject = isApprove ? mailTemplateConfiguration.mailWFHApproveEmployeeSubject() : isCancelled ? mailTemplateConfiguration.mailWFHCancelEmployeeSubject() : mailTemplateConfiguration.mailWFHRejectEmployeeSubject();
            log.info("mail is senting to " + managerOrHr.getFirstName() + " " + managerOrHr.getFirstName());
//            String subject=mailTemplateConfiguration.mailLeaveRequestManagerSubject();
            axHrmsCommonApi.sendMail(managerOrHr.getOfficialEmail(), fromEmailAddress, fromName, subject, mailContent);
//
        } catch (Exception e) {
            log.error("ApproveLeaveRequestMVCActionCommand >>>sendMailtoEmployee >>>  " + e.getMessage());
        }
    }


//    public static StringBuilder getWfhBody(WorkFromHomeRequest workFromHomeRequest, EmployeeDetails employee, StringBuilder body) throws PortalException {
//
//        // START TABLE
//        body.append("<table border='1' cellpadding='8' cellspacing='0' style='border-collapse:collapse;width:100%;'>");
//
//        body.append("<tr><th align='left'>Employee Code</th><td>").append(employee.getEmployeeCode()).append("</td></tr>");
//
//        body.append("<tr><th align='left'>Employee Name</th><td>").append(employee.getFirstName()).append(" ").append(employee.getLastName()).append("</td></tr>");
//
//        // END TABLE
//        body.append("</table>");
//
//        body.append("<br/><p>This is a system generated email.</p>");
//
//        return body;
//    }

    public static void sendMailtoTeam(String fromName, String fromEmailAddress,List<String> teamEmailList,Map<String, Object> serviceMap,StringBuilder body,WorkFromHomeRequest workFromHomeRequest,AxHrmsCommonApi axHrmsCommonApi, MailTemplateConfiguration mailTemplateConfiguration)
    {
        DepartmentMasterLocalService departmentMasterLocalService =
                (DepartmentMasterLocalService) serviceMap.get("departmentMasterLocalService");

        DesignationMasterLocalService designationMasterLocalService =
                (DesignationMasterLocalService) serviceMap.get("designationMasterLocalService");

        EmployeeDepartmentLocalService employeeDepartmentLocalService =
                (EmployeeDepartmentLocalService) serviceMap.get("employeeDepartmentLocalService");

        EmployeeDesignationLocalService employeeDesignationLocalService =
                (EmployeeDesignationLocalService) serviceMap.get("employeeDesignationLocalService");
        LeaveCompensatoryStatusMasterLocalService leaveStatusLocalService =
                (LeaveCompensatoryStatusMasterLocalService) serviceMap.get("leaveStatusLocalService");
        EmployeeDetailsLocalService employeeDetailsLocalService=(EmployeeDetailsLocalService) serviceMap.get("employeeDetailsLocalService");
        EmployeeDetails employee= null;
        try {
            employee = employeeDetailsLocalService.getEmployeeDetails(workFromHomeRequest.getEmployeeId());
            String subject=mailTemplateConfiguration.mailWFHApproveTeamSubject();
            body = getWfhBody(workFromHomeRequest, employee, body, leaveStatusLocalService, departmentMasterLocalService, designationMasterLocalService,employeeDepartmentLocalService,employeeDesignationLocalService);
            String mailContent=mailTemplateConfiguration.mailWFHApproveTeamBody();
            mailContent = mailContent.replace("${EMPLOYEE_NAME}", employee.getFirstName() + StringPool.SPACE + employee.getLastName());

            mailContent = mailContent.replace("${BODY}", body);



            for (String teamEmail : teamEmailList) {

                log.info("Sending WFH mail to team member :: " + teamEmail);


                axHrmsCommonApi.sendMail(
                        teamEmail,
                        fromEmailAddress,
                        fromName,
                        subject,
                        mailContent
                );
            }





        } catch (PortalException e) {
            throw new RuntimeException(e);
        }

    }


    public static StringBuilder getWfhBody(WorkFromHomeRequest workFromHomeRequest, EmployeeDetails employee, StringBuilder body, LeaveCompensatoryStatusMasterLocalService leaveStatusLocalService, DepartmentMasterLocalService departmentMasterLocalService, DesignationMasterLocalService designationMasterLocalService,EmployeeDepartmentLocalService employeeDepartmentLocalService ,EmployeeDesignationLocalService employeeDesignationLocalService) throws PortalException {
        WFHStatusUtil wFHStatusUtil = new WFHStatusUtil();
        LeaveCompensatoryStatusMaster string = leaveStatusLocalService.findByLeaveCompensatoryStatusById(workFromHomeRequest.getStatus());
        log.info("string.getLeaveCompensatoryStatus() :; " + string.getLeaveCompensatoryStatus());
        //  EXACTLY ONE ROW — SAME AS LEAVE

        EmployeeDepartment employeeDepartment = employeeDepartmentLocalService
                .findByEmployeeId(workFromHomeRequest.getEmployeeId());

        DepartmentMaster departmentMaster = departmentMasterLocalService
                .findByDepartmentNameById(employeeDepartment.getDepartmentMasterId());

        EmployeeDesignation employeeDesignation = employeeDesignationLocalService
                .findByEmployeeId(workFromHomeRequest.getEmployeeId());
        DesignationMaster designationMaster = designationMasterLocalService
                .findByDesignationNameById(employeeDesignation.getDesignationMasterId());


        body.append("<tr>")

                .append("<td style='border:1px solid #ddd;padding:10px;'>").append(employee.getEmployeeCode()).append("</td>")

                .append("<td style='border:1px solid #ddd;padding:10px;'>").append(employee.getFirstName()).append(" ").append(employee.getLastName()).append("</td>")

                .append("<td style='border:1px solid #ddd;padding:10px;'>").append(departmentMaster.getDepartmentName()).append("</td>")

                .append("<td style='border:1px solid #ddd;padding:10px;'>").append(designationMaster.getDesignationName()).append("</td>")

                .append("<td style='border:1px solid #ddd;padding:10px;'>").append(string.getLeaveCompensatoryStatus()).append("</td>")

                .append("<td style='border:1px solid #ddd;padding:10px;'>").append(wFHStatusUtil.setDateFormat(workFromHomeRequest.getCreateDate())).append("</td>")

                .append("<td style='border:1px solid #ddd;padding:10px;'>").append(wFHStatusUtil.setDateFormat(workFromHomeRequest.getStartDate())).append("</td>")

                .append("<td style='border:1px solid #ddd;padding:10px;'>").append(wFHStatusUtil.setDateFormat(workFromHomeRequest.getEndDate())).append("</td>")

                .append("</tr>");

        body.append(AxHrmsWorkFromHomePortletKeys.WFH_REQUEST_MAIL_FOOTER);

        return body;
    }


    public static List<String> extractValidEmails(String emailString) {

        List<String> emailList = new ArrayList<>();

        if (Validator.isNull(emailString)) {
            return emailList;
        }

        String[] emails = emailString.split(",");

        for (String email : emails) {
            if (Validator.isNotNull(email)) {
                String trimmedEmail = email.trim();
                if (Validator.isEmailAddress(trimmedEmail)) {
                    emailList.add(trimmedEmail);
                }
            }
        }

        return emailList;
    }


    public String setDateFormat(Date inputDate) {
        SimpleDateFormat outputDateFormat = new SimpleDateFormat(AxHrmsWorkFromHomePortletKeys.DATE_FORMAT);
        String dateStr = null;
        try {

            // Format the current date to the desired format
            dateStr = outputDateFormat.format(inputDate);

        } catch (Exception e) {
            log.error("AxHrmsHrLeaveRequestWebUtil >>> setDateFormat Method >>Error in Set the Date..!!" + e.getMessage());
        }

        return dateStr;

    }

}
