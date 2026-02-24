package com.ax.hrms.scheduler.portlet;


import com.ax.hrms.anniversary.web.constants.AxHrmsAnniversaryWebPortletConstants;
import com.ax.hrms.anniversary.web.util.AnniversaryUtil;
import com.ax.hrms.birthday.web.util.BirthdayWebUtil;
import com.ax.hrms.common.api.api.AxHrmsCommonApi;
import com.ax.hrms.constants.AxHrmsBirthdayWebPortletConstants;
import com.ax.hrms.link.config.configuration.LinksConfiguration;
import com.ax.hrms.mail.template.config.configuration.MailTemplateConfiguration;
import com.ax.hrms.master.model.DepartmentMaster;
import com.ax.hrms.master.model.DesignationMaster;
import com.ax.hrms.master.model.TemplateLevelMaster;
import com.ax.hrms.master.service.*;
import com.ax.hrms.model.*;
import com.ax.hrms.notification.template.config.configuration.NotificationTemplateConfiguration;
import com.ax.hrms.scheduler.constants.AxHrmsSchedulerPortletKeys;
import com.ax.hrms.scheduler.portlet.notification.SendNotificationToUserHandler;
import com.ax.hrms.service.*;
import com.liferay.dispatch.executor.BaseDispatchTaskExecutor;
import com.liferay.dispatch.executor.DispatchTaskExecutor;
import com.liferay.dispatch.executor.DispatchTaskExecutorOutput;
import com.liferay.dispatch.model.DispatchTrigger;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.UserNotificationDeliveryConstants;
import com.liferay.portal.kernel.model.UserNotificationEvent;
import com.liferay.portal.kernel.service.GroupLocalServiceUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserNotificationEventLocalService;
import com.liferay.portal.kernel.service.UserNotificationEventLocalServiceUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.PrefsPropsUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.text.SimpleDateFormat;
import java.util.*;

@Component(property = {"dispatch.task.executor.name=Ax Hrms Daily Scheduler", "dispatch.task.executor.type=Ax Hrms Daily Scheduler"}, service = DispatchTaskExecutor.class)
public class AxHrmsDailyScheduler extends BaseDispatchTaskExecutor {
    private static final Log log = LogFactoryUtil.getLog(AxHrmsDailyScheduler.class);

    @Reference
    AppraisalEvaluationFormStatusLocalService appraisalEvaluationFormStatusLocalService;

    @Reference
    EmployeeDetailsLocalService employeeDetailsLocalService;

    @Reference
    AxHrmsCommonApi axHrmsCommonApi;

    @Reference
    AppraisalReminderLocalService appraisalReminderLocalService;

    @Reference
    PipProgramLocalService pipProgramLocalService;

    @Reference
    AppraisalFormTemplatesLocalService appraisalFormTemplatesLocalService;

    @Reference
    TemplateLevelMasterLocalService templateLevelMasterLocalService;


    @Reference
    private DepartmentMasterLocalService departmentMasterLocalService;

    @Reference
    private EmployeeDepartmentLocalService employeeDepartmentLocalService;

    @Reference
    private LinksConfiguration linksConfiguration;


    @Reference
    private EmployeeDesignationLocalService employeeDesignationLocalService;

    @Reference
    private DesignationMasterLocalService designationMasterLocalService;
    @Reference
    private UserNotificationEventLocalService userNotificationEventLocalService;

    @Reference
    private WishTypeMasterLocalService wishTypeMasterLocalService;

    @Reference
    private LeaveBalanceLocalService leaveBalanceLocalService;
    @Reference
    private LeavePolicyMasterLocalService leavePolicyMasterLocalService;
    @Reference
    private LeaveTypeMasterLocalService leaveTypeMasterLocalService;
    @Reference
    private EmployeeWishLocalService employeeWishLocalService;

    @Reference
    private MailTemplateConfiguration mailTemplateConfiguration;

    @Reference
    private NotificationTemplateConfiguration notificationTemplateConfiguration;

    @Override
    public void doExecute(DispatchTrigger dispatchTrigger, DispatchTaskExecutorOutput dispatchTaskExecutorOutput) throws Exception {

        Group group = GroupLocalServiceUtil.fetchGroup(PortalUtil.getDefaultCompanyId(), "Guest");
        String fromName = PrefsPropsUtil.getString(group.getCompanyId(), PropsKeys.ADMIN_EMAIL_FROM_NAME);
        String fromEmailAddress = PrefsPropsUtil.getString(group.getCompanyId(), PropsKeys.ADMIN_EMAIL_FROM_ADDRESS);

        try {
            log.info("Inside the do execute method of the Daily Schedular");
            send7thDayBirthdayAndAnniversaryToHrAndMarketing(fromName, fromEmailAddress, group.getCompanyId());
            sendMailForPendingAppraisalEvaluation();
            sendNotificationAndMailToHrForPipMeetings();
            sendMailAndNotificationToHrForBirthdayWishes(fromName, fromEmailAddress, group.getCompanyId());
            sendMailAndNotificationToHrForAnniversaryWishes(group, group.getGroupId(), group.getCreatorUserId(), group.getCompanyId());
        } catch (Exception e) {
            log.error("AxHrmsBirthdayJobScheduler >>> doExecute >>> " + e.getMessage());
        }
    }

    @Override
    public String getName() {
        return "Ax Hrms Daily Scheduler";
    }

    private void sendMailForPendingAppraisalEvaluation() throws PortalException {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DAY_OF_MONTH, cal.get(Calendar.DAY_OF_MONTH) + 1);
        cal.set(Calendar.HOUR, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        cal.set(Calendar.MINUTE, 0);
//        cal.set(Calendar.T);
//        List<AppraisalEvaluationFormStatus> appraisalEvaluationFormStatusList = appraisalEvaluationFormStatusLocalService.findByStatusAndSubmissionDate(cal.getTime(), false);
        List<AppraisalEvaluationFormStatus> appraisalEvaluationFormStatusList = new ArrayList<>();
        List<AppraisalEvaluationFormStatus> appraisalEvaluationFormStatusList2 = appraisalEvaluationFormStatusLocalService.getAppraisalEvaluationFormStatuses(-1, -1);
        appraisalEvaluationFormStatusList2.forEach(e -> {
            Calendar cal2 = Calendar.getInstance();
            cal2.setTime(e.getSubmissionDate());
            if (cal2.get(Calendar.YEAR) == cal.get(Calendar.YEAR) && cal2.get(Calendar.MONTH) == cal.get(Calendar.MONTH) && cal2.get(Calendar.DATE) == cal.get(Calendar.DATE)) {
                appraisalEvaluationFormStatusList.add(e);
            }
        });

        List<User> hrUsers = axHrmsCommonApi.fetchHrAdminList(GroupLocalServiceUtil.fetchGroup(PortalUtil.getDefaultCompanyId(), "Guest").getCompanyId());
        StringBuilder htmlBuilder = new StringBuilder();

        // Append the header and table structure
        htmlBuilder.append("<h2 style=\"text-align: center;\">Pending Appraisal Evaluation Forms For Date - ").append(new Date()).append("</h2>\n");
        htmlBuilder.append("<table style=\"width: 100%; border-collapse: collapse;\">\n");
        htmlBuilder.append("  <thead>\n");
        htmlBuilder.append("    <tr>\n");
        htmlBuilder.append("      <th style=\"border: 1px solid #dddddd; text-align: left; padding: 8px; background-color: #f2f2f2;\">Sr No</th>\n");
        htmlBuilder.append("      <th style=\"border: 1px solid #dddddd; text-align: left; padding: 8px; background-color: #f2f2f2;\">Appraisee Name</th>\n");
        htmlBuilder.append("      <th style=\"border: 1px solid #dddddd; text-align: left; padding: 8px; background-color: #f2f2f2;\">Reviewer Name</th>\n");
        htmlBuilder.append("      <th style=\"border: 1px solid #dddddd; text-align: left; padding: 8px; background-color: #f2f2f2;\">Form Level</th>\n");
        htmlBuilder.append("      <th style=\"border: 1px solid #dddddd; text-align: left; padding: 8px; background-color: #f2f2f2;\">Status</th>\n");
        htmlBuilder.append("    </tr>\n");
        htmlBuilder.append("  </thead>\n");
        htmlBuilder.append("  <tbody>\n");

        int x = 0;
        for (AppraisalEvaluationFormStatus appraisalEvaluationFormStatus : appraisalEvaluationFormStatusList) {
            TemplateLevelMaster templateLevelMaster = templateLevelMasterLocalService.getTemplateLevelMaster(appraisalFormTemplatesLocalService.getAppraisalFormTemplates(appraisalEvaluationFormStatus.getAppraisalFormTemplateId()).getTemplateLevelId());
            EmployeeDetails employeeDetails = employeeDetailsLocalService.getEmployeeDetails(appraisalEvaluationFormStatus.getEmployeeId());
            EmployeeDetails apprisee = employeeDetailsLocalService.getEmployeeDetails(appraisalReminderLocalService.findByAppraisalProcessId(appraisalEvaluationFormStatus.getAppraisalProcessId()).getEmployeeId());
            // Append table data
            x++;
            htmlBuilder.append("    <tr>\n");
            htmlBuilder.append("      <td style=\"border: 1px solid #dddddd; text-align: left; padding: 8px;\">").append(x).append("</td>\n");
            htmlBuilder.append("      <td style=\"border: 1px solid #dddddd; text-align: left; padding: 8px;\">").append(apprisee.getFirstName() + " " + apprisee.getLastName()).append("</td>\n");
            htmlBuilder.append("      <td style=\"border: 1px solid #dddddd; text-align: left; padding: 8px;\">").append(employeeDetails.getFirstName() + " " + employeeDetails.getLastName()).append("</td>\n");
            htmlBuilder.append("      <td style=\"border: 1px solid #dddddd; text-align: left; padding: 8px;\">").append(templateLevelMaster.getLevelName()).append("</td>\n");
            htmlBuilder.append("      <td style=\"border: 1px solid #dddddd; color: red; text-align: left; padding: 8px;\">").append("Pending").append("</td>\n");
            htmlBuilder.append("    </tr>\n");
        }

        // Close table and body
        htmlBuilder.append("  </tbody>\n");
        htmlBuilder.append("</table>\n");
        Group group = GroupLocalServiceUtil.fetchGroup(PortalUtil.getDefaultCompanyId(), "Guest");
        String fromName = PrefsPropsUtil.getString(group.getCompanyId(), PropsKeys.ADMIN_EMAIL_FROM_NAME);
        String fromEmailAddress = PrefsPropsUtil.getString(group.getCompanyId(), PropsKeys.ADMIN_EMAIL_FROM_ADDRESS);
        for (User hrAdmin : hrUsers) {
            axHrmsCommonApi.sendMail(hrAdmin.getEmailAddress(), fromEmailAddress, fromName, "PENDING APPRAISAL FORMS!", htmlBuilder.toString());
        }
    }

    private void sendNotificationAndMailToHrForPipMeetings() throws Exception {
        Calendar calendar = Calendar.getInstance();


        // Set the time fields to zero
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        calendar.set(Calendar.DAY_OF_MONTH, calendar.get(Calendar.DAY_OF_MONTH) + 1);

        List<PipProgram> pipProgramList = pipProgramLocalService.getPipPrograms(-1, -1);
        List<User> hrUsers = axHrmsCommonApi.fetchHrAdminList(GroupLocalServiceUtil.fetchGroup(PortalUtil.getDefaultCompanyId(), "Guest").getCompanyId());
        StringBuilder htmlBuilder = new StringBuilder();

        // Append the header and table structure
        htmlBuilder.append("<h2 style=\"text-align: center;\">Upcoming PIP Program Meeting For Date - ").append(calendar.getTime()).append("</h2>\n");
        htmlBuilder.append("<table style=\"width: 100%; border-collapse: collapse;\">\n");
        htmlBuilder.append("  <thead>\n");
        htmlBuilder.append("    <tr>\n");
        htmlBuilder.append("      <th style=\"border: 1px solid #dddddd; text-align: left; padding: 8px; background-color: #f2f2f2;\">Sr No</th>\n");
        htmlBuilder.append("      <th style=\"border: 1px solid #dddddd; text-align: left; padding: 8px; background-color: #f2f2f2;\">Employee Name</th>\n");
        htmlBuilder.append("      <th style=\"border: 1px solid #dddddd; text-align: left; padding: 8px; background-color: #f2f2f2;\">Status</th>\n");
        htmlBuilder.append("      <th style=\"border: 1px solid #dddddd; text-align: left; padding: 8px; background-color: #f2f2f2;\">Start Date</th>\n");
        htmlBuilder.append("      <th style=\"border: 1px solid #dddddd; text-align: left; padding: 8px; background-color: #f2f2f2;\">End Date</th>\n");
        htmlBuilder.append("    </tr>\n");
        htmlBuilder.append("  </thead>\n");
        htmlBuilder.append("  <tbody>\n");
        int x = 0;
        for (PipProgram pipProgram : pipProgramList) {
            if (pipProgram.getStatus().equals("Active") || pipProgram.getStatus().equals("Extended")) {
                Calendar cal2 = Calendar.getInstance();
                cal2.setTime(pipProgram.getMeetingDate());
                if (cal2.get(Calendar.YEAR) == calendar.get(Calendar.YEAR) && cal2.get(Calendar.MONTH) == calendar.get(Calendar.MONTH) && cal2.get(Calendar.DATE) == calendar.get(Calendar.DATE)) {


                    EmployeeDetails employeeDetails = employeeDetailsLocalService.getEmployeeDetails(pipProgram.getEmployeeId());
                    // Append table data
                    x++;
                    htmlBuilder.append("    <tr>\n");
                    htmlBuilder.append("      <td style=\"border: 1px solid #dddddd; text-align: left; padding: 8px;\">").append(x).append("</td>\n");
                    htmlBuilder.append("      <td style=\"border: 1px solid #dddddd; text-align: left; padding: 8px;\">").append(employeeDetails.getFirstName()).append(" ").append(employeeDetails.getLastName()).append("</td>\n");
                    htmlBuilder.append("      <td style=\"border: 1px solid #dddddd; text-align: left; padding: 8px;\">").append(pipProgram.getStatus()).append("</td>\n");
                    htmlBuilder.append("      <td style=\"border: 1px solid #dddddd; text-align: left; padding: 8px;\">").append(pipProgram.getStartDate()).append("</td>\n");
                    htmlBuilder.append("      <td style=\"border: 1px solid #dddddd; text-align: left; padding: 8px;\">").append(pipProgram.getEndDate()).append("</td>\n");
                    htmlBuilder.append("    </tr>\n");


                    JSONObject notificationJSON = JSONFactoryUtil.createJSONObject();
                    notificationJSON.put("body", "UPCOMING PIP PROGRAM MEETING ->  " + " " + employeeDetails.getFirstName() + " " + employeeDetails.getLastName() + " == " + "Meeting Date : " + calendar.getTime());

                    for (User hrAdmin : hrUsers) {

                        UserNotificationEvent userNotificationEvent = UserNotificationEventLocalServiceUtil.sendUserNotificationEvents(hrAdmin.getUserId(), AxHrmsSchedulerPortletKeys.AXHRMSSCHEDULER, UserNotificationDeliveryConstants.TYPE_WEBSITE, notificationJSON);
                        ServiceContext serviceContext = new ServiceContext();
                        SendNotificationToUserHandler sendNotificationToUserHandler = new SendNotificationToUserHandler();
                        sendNotificationToUserHandler.callGetBody(userNotificationEvent, serviceContext);
                    }
                    // Notification........

                }
            }
        }
        if (x == 0) {
            return;
        }
        // Close table and body
        htmlBuilder.append("  </tbody>\n");
        htmlBuilder.append("</table>\n");

        Group group = GroupLocalServiceUtil.fetchGroup(PortalUtil.getDefaultCompanyId(), "Guest");
        String fromName = PrefsPropsUtil.getString(group.getCompanyId(), PropsKeys.ADMIN_EMAIL_FROM_NAME);
        String fromEmailAddress = PrefsPropsUtil.getString(group.getCompanyId(), PropsKeys.ADMIN_EMAIL_FROM_ADDRESS);
        for (User hrAdmin : hrUsers) {
            axHrmsCommonApi.sendMail(hrAdmin.getEmailAddress(), fromEmailAddress, fromName, "UPCOMING PIP PROGRAM MEETINGS", htmlBuilder.toString());

        }


    }

    private void sendMailAndNotificationToHrForBirthdayWishes(String fromName, String fromEmailAddress, long companyId) throws Exception {
        StringBuilder body = new StringBuilder(AxHrmsBirthdayWebPortletConstants.HR_BIRTHDAY_REMMINDER_MAIL_HEAD);

        BirthdayWebUtil birthdayWebUtil = new BirthdayWebUtil(employeeDetailsLocalService, employeeDepartmentLocalService, employeeDesignationLocalService, departmentMasterLocalService, designationMasterLocalService, wishTypeMasterLocalService);

        birthdayWebUtil.sendMailAndNotificationToHr(fromName, fromEmailAddress, body, axHrmsCommonApi, companyId, mailTemplateConfiguration, notificationTemplateConfiguration);

    }

    private void sendMailAndNotificationToHrForAnniversaryWishes(Group group, long groupId, long userId, long companyId) throws Exception {
        StringBuilder body = new StringBuilder(AxHrmsAnniversaryWebPortletConstants.ANNIVERSARY_REMMINDER_MAIL_HEAD);

        AnniversaryUtil anniversaryEmployeeRetrieverUtil = new AnniversaryUtil(employeeDetailsLocalService, axHrmsCommonApi, leaveBalanceLocalService, leavePolicyMasterLocalService, leaveTypeMasterLocalService, designationMasterLocalService, departmentMasterLocalService);

        anniversaryEmployeeRetrieverUtil.sendMailAndNotificationToHr(group, body, employeeDepartmentLocalService, employeeDesignationLocalService, mailTemplateConfiguration, notificationTemplateConfiguration);
        anniversaryEmployeeRetrieverUtil.addLoyaltyLeave(anniversaryEmployeeRetrieverUtil.getAnniversaryEmployee(employeeDetailsLocalService.getEmployeeDetailses(-1, -1)), groupId, userId, companyId);
        anniversaryEmployeeRetrieverUtil.updateExperience(anniversaryEmployeeRetrieverUtil.getAnniversaryEmployee(employeeDetailsLocalService.getEmployeeDetailses(-1, -1)));
    }


    private void send7thDayBirthdayAndAnniversaryToHrAndMarketing(String fromName, String fromEmailAddress, long companyId) throws Exception {
        try {
            Calendar targetDate = Calendar.getInstance();
            targetDate.set(Calendar.HOUR_OF_DAY, 0);
            targetDate.set(Calendar.MINUTE, 0);
            targetDate.set(Calendar.SECOND, 0);
            targetDate.set(Calendar.MILLISECOND, 0);
            StringBuilder birthdayNamesBuilder = new StringBuilder();
            StringBuilder anniversaryNamesBuilder = new StringBuilder();


            //  Add 7 days
            targetDate.add(Calendar.DAY_OF_MONTH, 7);
            log.info("7th Day Scheduler Started");
            log.info("Target Date (After 7 Days): " + targetDate.getTime());

            int targetDay = targetDate.get(Calendar.DAY_OF_MONTH);
            int targetMonth = targetDate.get(Calendar.MONTH);

            List<EmployeeDetails> employees = employeeDetailsLocalService.getEmployeeDetailses(-1, -1);
            log.info("Total Employees Fetched: " + employees.size());

            StringBuilder birthdayTable = new StringBuilder();
            StringBuilder anniversaryTable = new StringBuilder();

            birthdayTable.append(getTableHeader());
            anniversaryTable.append(getTableHeader());

            int birthdayCount = 0;
            int anniversaryCount = 0;

            for (EmployeeDetails emp : employees) {
                try {
                    //  Birthday Check
                    if (emp.getDateOfBirth() != null) {
                        Calendar birthCal = Calendar.getInstance();
                        birthCal.setTime(emp.getDateOfBirth());

                        if (birthCal.get(Calendar.DAY_OF_MONTH) == targetDay && birthCal.get(Calendar.MONTH) == targetMonth) {

                            birthdayCount++;
                            log.info("Birthday Matched: " + emp.getFirstName() + " " + emp.getLastName());

                            birthdayNamesBuilder.append(birthdayCount)
                                    .append(". ")
                                    .append(emp.getEmployeeCode() != null ? emp.getEmployeeCode() : "-")
                                    .append(" - ")
                                    .append(emp.getFirstName() != null ? emp.getFirstName() : "")
                                    .append(" ")
                                    .append(emp.getLastName() != null ? emp.getLastName() : "")
                                    .append("\n");

                            birthdayTable.append(getRow(emp));
                        }

                    }

                    // Anniversary Check
                    if (emp.getJoiningDate() != null) {
                        Calendar joinCal = Calendar.getInstance();
                        joinCal.setTime(emp.getJoiningDate());

                        if (joinCal.get(Calendar.DAY_OF_MONTH) == targetDay && joinCal.get(Calendar.MONTH) == targetMonth) {

                            anniversaryCount++;

                            anniversaryNamesBuilder.append(anniversaryCount)
                                    .append(". ")
                                    .append(emp.getEmployeeCode() != null ? emp.getEmployeeCode() : "-")
                                    .append(" - ")
                                    .append(emp.getFirstName() != null ? emp.getFirstName() : "")
                                    .append(" ")
                                    .append(emp.getLastName() != null ? emp.getLastName() : "")
                                    .append("\n");


                            log.info("Anniversary Matched: " + emp.getFirstName() + " " + emp.getLastName());

                            anniversaryTable.append(getRow(emp));
                        }
                    }
                } catch (Exception e) {
                    log.error("Error processing employee: " + emp.getEmployeeId(), e);
                }
            }

            birthdayTable.append("</table>");
            anniversaryTable.append("</table>");

            log.info("Total Birthday Matches: " + birthdayCount);
            log.info("Total Anniversary Matches: " + anniversaryCount);
            List<User> hrUsers = axHrmsCommonApi.fetchHrAdminList(companyId);
            log.info("Total HR Admin Users Found: " + hrUsers.size());
            SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM yyyy");
            String formattedDate = sdf.format(targetDate.getTime());
            //  SEND BIRTHDAY MAIL
            if (birthdayCount > 0) {

                String subject = mailTemplateConfiguration.mailUpcomingBirthdayHrMarketingSubject();

                String body = mailTemplateConfiguration.mailUpcomingBirthdayHrMarketingBody().replace("${BODY}", birthdayTable.toString()).replace("${EVENT_DATE}", formattedDate);
                log.info("Sending Birthday Mail to HR & Marketing...");
                String notificationMessage =
                        notificationTemplateConfiguration.upcomingBirthdayNotification()
                                .replace("${EVENT_DATE}", formattedDate)
                                .replace("${EMPLOYEE_NAMES}", birthdayNamesBuilder.toString());

                sendWebsiteNotificationToUsers(hrUsers, notificationMessage);
                sendToHrAndMarketing(hrUsers, subject, body, fromName, fromEmailAddress);
            }

            //  SEND ANNIVERSARY MAIL
            if (anniversaryCount > 0) {

                String subject = mailTemplateConfiguration.mailUpcomingAnniversaryHrMarketingSubject();

                String body = mailTemplateConfiguration.mailUpcomingAnniversaryHrMarketingBody().replace("${BODY}", anniversaryTable.toString()).replace("${EVENT_DATE}", formattedDate);
                log.info("Sending Anniversary Mail to HR & Marketing...");
                String notificationMessage =
                        notificationTemplateConfiguration
                                .upcomingAnniversaryNotification()
                                .replace("${EVENT_DATE}", formattedDate)
                                .replace("${EMPLOYEE_NAMES}", anniversaryNamesBuilder.toString());

                sendWebsiteNotificationToUsers(hrUsers, notificationMessage);
                sendToHrAndMarketing(hrUsers, subject, body, fromName, fromEmailAddress);
            }
        } catch (Exception exception) {
            log.error("Error in 7th Day Birthday & Anniversary Scheduler" + exception.getMessage());
        }
    }

    private void sendToHrAndMarketing(List<User> hrUsers, String subject, String body, String fromName, String fromEmailAddress) {

        try {

            // HR Users
            for (User hr : hrUsers) {

                try {
                    axHrmsCommonApi.sendMail(hr.getEmailAddress(), fromEmailAddress, fromName, subject, body);
                } catch (Exception e) {
                    log.error("Failed sending mail to HR: " + hr.getEmailAddress(), e);
                }
            }

            // Marketing
            String marketingEmails = linksConfiguration.marketingTeamEmailIds();

            if (marketingEmails != null && !marketingEmails.trim().isEmpty()) {
                Set<String> uniqueEmails = new HashSet<>();
                String[] emailArray = marketingEmails.split(",");
                for (String email : emailArray) {
                    if (email != null && !email.trim().isEmpty()) {
                        uniqueEmails.add(email.trim().toLowerCase());
                    }
                }

                for (String email : uniqueEmails) {

                    try {
                        axHrmsCommonApi.sendMail(email.trim(), fromEmailAddress, fromName, subject, body);
                    } catch (Exception e) {
                        log.error("Failed sending mail to Marketing: " + email, e);
                    }
                }
            }

        } catch (Exception e) {
            log.error("Error in sendToHrAndMarketing()", e);
        }
    }


    private String getTableHeader() {

        return "<table style='width:100%; border-collapse: collapse;'>" + "<tr>" + "<th style='border:1px solid #ddd; padding:8px;'>Employee Code</th>" + "<th style='border:1px solid #ddd; padding:8px;'>Employee Name</th>" + "<th style='border:1px solid #ddd; padding:8px;'>Department</th>" + "<th style='border:1px solid #ddd; padding:8px;'>Designation</th>" + "</tr>";
    }

    private String getRow(EmployeeDetails emp) {

        String departmentName = "-";
        String designationName = "-";

        try {

            if (emp != null) {

                try {
                    EmployeeDepartment empDept = employeeDepartmentLocalService.findByEmployeeId(emp.getEmployeeId());

                    if (empDept != null) {
                        DepartmentMaster dept = departmentMasterLocalService.fetchDepartmentMaster(empDept.getDepartmentMasterId());

                        if (dept != null) {
                            departmentName = dept.getDepartmentName();
                        }
                    }

                } catch (Exception e) {
                    log.warn("Department fetch failed for employeeId: " + emp.getEmployeeId(), e);
                }

                try {
                    EmployeeDesignation empDes = employeeDesignationLocalService.findByEmployeeId(emp.getEmployeeId());

                    if (empDes != null) {
                        DesignationMaster des = designationMasterLocalService.fetchDesignationMaster(empDes.getDesignationMasterId());

                        if (des != null) {
                            designationName = des.getDesignationName();
                        }
                    }

                } catch (Exception e) {
                    log.warn("Designation fetch failed for employeeId: " + emp.getEmployeeId(), e);
                }
            }

            return "<tr>" + "<td style='border:1px solid #ddd; padding:8px;'>" + (emp.getEmployeeCode() != null ? emp.getEmployeeCode() : "-") + "</td>" + "<td style='border:1px solid #ddd; padding:8px;'>" + (emp.getFirstName() != null ? emp.getFirstName() : "") + " " + (emp.getLastName() != null ? emp.getLastName() : "") + "</td>" + "<td style='border:1px solid #ddd; padding:8px;'>" + departmentName + "</td>" + "<td style='border:1px solid #ddd; padding:8px;'>" + designationName + "</td>" + "</tr>";

        } catch (Exception e) {
            log.error("Error building row for employeeId: " + emp.getEmployeeId(), e);
            return "";
        }
    }

    private void sendWebsiteNotificationToUsers(
            List<User> users,
            String notificationMessage
    ) {

        if (users == null || users.isEmpty()) {
            log.warn("No users found for sending notification.");
            return;
        }

        for (User user : users) {

            if (user == null) {
                continue;
            }

            try {

                JSONObject notificationJSON = JSONFactoryUtil.createJSONObject();
                notificationJSON.put("body", notificationMessage);
                notificationJSON.put("title", "HRMS Notification");
                notificationJSON.put("timestamp", System.currentTimeMillis());

                UserNotificationEvent userNotificationEvent =
                        UserNotificationEventLocalServiceUtil.sendUserNotificationEvents(
                                user.getUserId(),
                                AxHrmsSchedulerPortletKeys.AXHRMSSCHEDULER,
                                UserNotificationDeliveryConstants.TYPE_WEBSITE,
                                notificationJSON
                        );

                ServiceContext serviceContext = new ServiceContext();

                SendNotificationToUserHandler handler =
                        new SendNotificationToUserHandler();

                handler.callGetBody(userNotificationEvent, serviceContext);

                log.info("Website notification sent to userId: " + user.getUserId());

            } catch (Exception e) {
                log.error("Failed sending notification to userId: " + user.getUserId(), e);
            }
        }
    }
}
