package com.ax.hrms.compensatory.web.util;

import com.ax.hrms.common.api.api.AxHrmsCommonApi;
import com.ax.hrms.compensatory.web.constants.AxHrmsCompensatoryDataConstants;
import com.ax.hrms.compensatory.web.constants.AxHrmsCompensatoryWebPortletKeys;
import com.ax.hrms.compensatory.web.notification.SendNotificationToUserHandler;
import com.ax.hrms.mail.template.config.configuration.MailTemplateConfiguration;
import com.ax.hrms.master.model.DepartmentMaster;
import com.ax.hrms.master.model.DesignationMaster;
import com.ax.hrms.master.model.LeaveCompensatoryStatusMaster;
import com.ax.hrms.master.service.DepartmentMasterLocalService;
import com.ax.hrms.master.service.DesignationMasterLocalService;
import com.ax.hrms.master.service.LeaveCompensatoryStatusMasterLocalService;
import com.ax.hrms.model.*;
import com.ax.hrms.notification.template.config.configuration.NotificationTemplateConfiguration;
import com.ax.hrms.service.*;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.UserNotificationDeliveryConstants;
import com.liferay.portal.kernel.model.UserNotificationEvent;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.service.UserNotificationEventLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Component(
        immediate = true,
        service = AxHrmsCompensatoryLeaveRequestWebUtil.class
)
public class AxHrmsCompensatoryLeaveRequestWebUtil {

    @Reference
    LeaveRequestLocalService leaveRequestLocalService;
    @Reference
    AxHrmsCommonApi axHrmsCommonApi;

    @Reference
    EmployeeDetailsLocalService employeeDetailsLocalService;

    @Reference
    DepartmentMasterLocalService departmentMasterLocalService;

    @Reference
    DesignationMasterLocalService designationMasterLocalService;

    @Reference
    NotificationTemplateConfiguration notificationTemplateConfiguration;

    @Reference
    EmployeeDepartmentLocalService employeeDepartmentLocalService;

    @Reference
    EmployeeDesignationLocalService employeeDesignationLocalService;

    @Reference
    LeaveCompensatoryStatusMasterLocalService leaveCompensatoryStatusMasterLocalService;

    @Reference
    MailTemplateConfiguration mailTemplateConfiguration;

    @Reference
    CompensatoryDataLocalService compensatoryDataLocalService;


    private static final Log log = LogFactoryUtil.getLog(AxHrmsCompensatoryLeaveRequestWebUtil.class);

    public void sendMailtoEmployee(String fromName, String fromEmailAddress, Long compensatoryRequestId,
                                   StringBuilder body, MailTemplateConfiguration mailTemplateConfiguration,String comment, boolean isApprove, boolean isCancelled) {
        try {
            CompensatoryData compensatoryRequest = CompensatoryDataLocalServiceUtil.getCompensatoryData(compensatoryRequestId);
            EmployeeDetails employee = employeeDetailsLocalService.getEmployeeDetails(compensatoryRequest.getEmployeeId());
            log.info("get Official Email :: "+employee.toString());

            String subject;
            String mailContent;
            body = getBody(compensatoryRequest, employee, body);
            log.info("body "+ body);

            // SEND MAIL TO EMPLOYEE
            mailContent = isApprove ? mailTemplateConfiguration.mailCompensatoryLeaveRequestApprovedEmployeeBody() : isCancelled ? mailTemplateConfiguration.mailCompensatoryLeaveRequestCancelEmployeeBody() : mailTemplateConfiguration.mailCompensatoryLeaveRequestRejectedEmployeeBody();
            mailContent = mailContent.replace("${EMPLOYEE_NAME}", employee.getFirstName() + StringPool.SPACE + employee.getLastName());
            mailContent = mailContent.replace("${BODY}", body);
            mailContent = mailContent.replace("${COMMENT}", comment);

                 subject = isApprove ? mailTemplateConfiguration.mailCompensatoryLeaveRequestApprovedEmployeeSubject() : isCancelled ? mailTemplateConfiguration.mailCompensatoryLeaveRequestCancelEmployeeSubject() : mailTemplateConfiguration.mailCompensatoryLeaveRequestRejectedEmployeeSubject();

            axHrmsCommonApi.sendMail(employee.getOfficialEmail(), fromEmailAddress, fromName, subject, mailContent);
            log.info("Mail sent successfully");
        } catch (Exception e) {
            log.error("AxHrmsCompensatoryLeaveRequestWebUtil >>>sendMailtoEmployee >>>  " + e.getMessage());
        }

    }

    public void sendMailtoApprovePerson(String fromName, String fromEmailAddress, Long compensatoryRequestId, Long approverId,
                                   StringBuilder body, MailTemplateConfiguration mailTemplateConfiguration,String comment, boolean isApprove, boolean isCancelled) {
        try {
            EmployeeDetails approver = employeeDetailsLocalService.findByLrUserId(approverId);
            CompensatoryData compensatoryRequest = CompensatoryDataLocalServiceUtil.getCompensatoryData(compensatoryRequestId);
            EmployeeDetails employee = employeeDetailsLocalService.getEmployeeDetails(compensatoryRequest.getEmployeeId());

            log.info("get Official Email :: "+employee.toString());
            String subject;
            String mailContent;
            body = getBody(compensatoryRequest, employee, body);
            log.info("body "+ body);

            // SEND MAIL TO EMPLOYEE
            mailContent = mailTemplateConfiguration.mailCompensatoryLeaveRequestCancelApproverBody();
            mailContent = mailContent.replace("${EMPLOYEE_NAME}", employee.getFirstName() + StringPool.SPACE + employee.getLastName());
            mailContent = mailContent.replace("${BODY}", body);
            mailContent = mailContent.replace("${COMMENT}", comment);
            mailContent=mailContent.replace("${APPROVER_NAME}", approver.getFirstName() + StringPool.SPACE + approver.getLastName());
            subject = mailTemplateConfiguration.mailCompensatoryLeaveRequestCancelApproverSubject();
            axHrmsCommonApi.sendMail(approver.getOfficialEmail(), fromEmailAddress, fromName, subject, mailContent);
            log.info("Mail sent successfully");
        } catch (PortalException e) {
            log.info("Exception Raised Due to :: "+e.getMessage());
        } catch (Exception exception){
            log.error("Exception Raised Due to :: "+exception.getMessage());
        }


    }



        public void sendMailtoManagerAndHr(String fromName, String fromEmailAddress, Long compensatoryRequestId,
                                       StringBuilder body, MailTemplateConfiguration mailTemplateConfiguration, ThemeDisplay themeDisplay,List<User>userList) {

        try {
            CompensatoryData compensatoryRequest = compensatoryDataLocalService.fetchCompensatoryData(compensatoryRequestId);
            EmployeeDetails employee = employeeDetailsLocalService.getEmployeeDetails(compensatoryRequest.getEmployeeId());
            String subject;
            String mailContent;
            body = getBody(compensatoryRequest, employee, body);
            log.info("body "+ body);

                subject = mailTemplateConfiguration.mailCompensatoryLeaveRequestManagerAndHrSubject();



            for(User user : userList) {
                mailContent = mailTemplateConfiguration.mailCompensatoryLeaveRequestManagerAndHrBody();
                mailContent = mailContent.replace("${BODY}", body);
                EmployeeDetails managerOrHr = employeeDetailsLocalService.findByLrUserId(user.getUserId());

                mailContent = mailContent.replace("${EMPLOYEE_NAME}", managerOrHr.getFirstName() + StringPool.SPACE + managerOrHr.getLastName());
                axHrmsCommonApi.sendMail(managerOrHr.getOfficialEmail(), fromEmailAddress, fromName, subject, mailContent);

}
        } catch (Exception e) {
            log.error("AxHrmsCompensatoryLeaveRequestWebUtil >>>sendMailtoEmployee >>>  " + e.getMessage());
            e.printStackTrace();
        }

    }

    public void sendNotificationToEmployee(String body, EmployeeDetails employee)  {

        try {
            JSONObject notificationJSON = JSONFactoryUtil.createJSONObject();
            notificationJSON.put("body", body);

            // Notification........
            UserNotificationEvent userNotification = UserNotificationEventLocalServiceUtil.sendUserNotificationEvents(
                    employee.getLrUserId(),
                    AxHrmsCompensatoryWebPortletKeys.AX_HRMS_COMPENSATORY_MANAGER_WEB_PORTLET,
                    UserNotificationDeliveryConstants.TYPE_WEBSITE, notificationJSON);



            ServiceContext serviceContext = new ServiceContext();
            SendNotificationToUserHandler sendNotificationToUserHandler = new SendNotificationToUserHandler();
            sendNotificationToUserHandler.callGetBody(userNotification, serviceContext);

            log.info("SENDING NOTIFICATION IN LEAVE REQUEST PORTLET ...." + userNotification.getPayload());


        } catch (Exception e) {
            log.error("Error in notification employee");
        }

    }

    public void sendNotificationToApprover(String body, EmployeeDetails employee,Long approverId)  {
        EmployeeDetails approver=null;

            try {
                approver = employeeDetailsLocalService.findByLrUserId(approverId);

                JSONObject notificationJSON = JSONFactoryUtil.createJSONObject();
                body = body.replace("${EMPLOYEE_NAME}", employee.getFirstName() + StringPool.SPACE + employee.getLastName());

            notificationJSON.put("body", body);

            // Notification........
            UserNotificationEvent userNotification = UserNotificationEventLocalServiceUtil.sendUserNotificationEvents(
                    approver.getLrUserId(),
                    AxHrmsCompensatoryWebPortletKeys.AX_HRMS_COMPENSATORY_MANAGER_WEB_PORTLET,
                    UserNotificationDeliveryConstants.TYPE_WEBSITE, notificationJSON);



            ServiceContext serviceContext = new ServiceContext();
            SendNotificationToUserHandler sendNotificationToUserHandler = new SendNotificationToUserHandler();
            sendNotificationToUserHandler.callGetBody(userNotification, serviceContext);

            log.info("SENDING NOTIFICATION IN LEAVE REQUEST PORTLET ...." + userNotification.getPayload());


        } catch (Exception e) {
            log.error("Error in notification employee :: "+e.getMessage());
        }

    }

    public void sendNotificationToManagerAndHr(String body, List<User> employeeList)  {
        log.info("sendNotificationToManagerAndHr...............");
        log.info("employeeList "+ employeeList);

        try {
            JSONObject notificationJSON = JSONFactoryUtil.createJSONObject();

            notificationJSON.put("body", body);

            for(User employee : employeeList) {

                // Notification........
                UserNotificationEvent userNotification = UserNotificationEventLocalServiceUtil.sendUserNotificationEvents(
                        employee.getUserId(),
                        AxHrmsCompensatoryWebPortletKeys.AX_HRMS_COMPENSATORY_MANAGER_WEB_PORTLET,
                        UserNotificationDeliveryConstants.TYPE_WEBSITE, notificationJSON);


                ServiceContext serviceContext = new ServiceContext();
                SendNotificationToUserHandler sendNotificationToUserHandler = new SendNotificationToUserHandler();
                sendNotificationToUserHandler.callGetBody(userNotification, serviceContext);

                log.info("SENDING NOTIFICATION IN LEAVE REQUEST PORTLET ...." + userNotification.getPayload());

            }


        } catch (Exception e) {
            log.error("Error in notification employee");
        }

    }

    public StringBuilder getBody(CompensatoryData compensatoryData, EmployeeDetails employee, StringBuilder body)
            throws PortalException {
        AxHrmsCompensatoryLeaveRequestWebUtil leaveRequestUtil = new AxHrmsCompensatoryLeaveRequestWebUtil();

        // FETCH DATA OF EMPLOYEE DEPARTMENT AND DESIGNATION
        EmployeeDepartment employeeDepartment = employeeDepartmentLocalService
                .findByEmployeeId(employee.getEmployeeId());

        DepartmentMaster departmentMaster = departmentMasterLocalService
                .findByDepartmentNameById(employeeDepartment.getDepartmentMasterId());

        EmployeeDesignation employeeDesignation = employeeDesignationLocalService
                .findByEmployeeId(employee.getEmployeeId());
        DesignationMaster designationMaster = designationMasterLocalService
                .findByDesignationNameById(employeeDesignation.getDesignationMasterId());

        // FETCH DATA OF STATUS
        LeaveCompensatoryStatusMaster status = leaveCompensatoryStatusMasterLocalService
                .findByLeaveCompensatoryStatusById(compensatoryData.getLeaveCompensatoryStatusMasterId());

        // SET DATA OF LEAVE REQUEST IN THE BODY OF MAIL

        body.append(AxHrmsCompensatoryDataConstants.COMPENSATORY_REQUEST_MAIL_STYLE).append(employee.getEmployeeCode())
                .append(AxHrmsCompensatoryDataConstants.COMPENSATORY_REQUEST_MAIL_STYLE)
                .append(employee.getFirstName()).append(" ").append(employee.getLastName())
                .append(AxHrmsCompensatoryDataConstants.COMPENSATORY_REQUEST_MAIL_STYLE)
                .append(departmentMaster.getDepartmentName())
                .append(AxHrmsCompensatoryDataConstants.COMPENSATORY_REQUEST_MAIL_STYLE)
                .append(designationMaster.getDesignationName())
                .append(AxHrmsCompensatoryDataConstants.COMPENSATORY_REQUEST_MAIL_STYLE)
                .append(status.getLeaveCompensatoryStatus())
                .append(AxHrmsCompensatoryDataConstants.COMPENSATORY_REQUEST_MAIL_STYLE)
                .append(leaveRequestUtil.setDateFormat(compensatoryData.getCreateDate()))
                .append(AxHrmsCompensatoryDataConstants.COMPENSATORY_REQUEST_MAIL_STYLE)
                .append(leaveRequestUtil.setDateFormat(compensatoryData.getDateOfCompensation()))
                .append(AxHrmsCompensatoryDataConstants.COMPENSATORY_REQUEST_MAIL_STYLE)
                .append(compensatoryData.getRequestedHours())
               .append(AxHrmsCompensatoryDataConstants.COMPENSATORY_REQUEST_MAIL_STYLE_CLOSING);

        body.append(AxHrmsCompensatoryDataConstants.COMPENSATORY_REQUEST_MAIL_FOOTER);
        return body;
    }
    public String setDateFormat(Date inputDate) {
        SimpleDateFormat outputDateFormat = new SimpleDateFormat(
                AxHrmsCompensatoryDataConstants.DATE_FORMAT);
        String dateStr = null;
        try {

            // Format the current date to the desired format
            dateStr = outputDateFormat.format(inputDate);

        } catch (Exception e) {
            log.error("AxHrmsCompensatoryLeaveRequestWebUtil >>> setDateFormat Method >>Error in Set the Date..!!"
                    + e.getMessage());
        }

        return dateStr;

    }
}
