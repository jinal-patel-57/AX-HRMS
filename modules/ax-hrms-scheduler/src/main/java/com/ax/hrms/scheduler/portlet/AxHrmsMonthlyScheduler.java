package com.ax.hrms.scheduler.portlet;


import com.ax.hrms.common.api.api.AxHrmsCommonApi;
import com.ax.hrms.master.exception.NoSuchAppraisalStatusMasterException;
import com.ax.hrms.master.model.DepartmentMaster;
import com.ax.hrms.master.model.DesignationMaster;
import com.ax.hrms.master.service.*;
import com.ax.hrms.model.*;
import com.ax.hrms.notification.template.config.configuration.NotificationTemplateConfiguration;
import com.ax.hrms.scheduler.constants.AxHrmsMonthlySchedulerConstants;
import com.ax.hrms.scheduler.constants.AxHrmsSchedulerPortletKeys;
import com.ax.hrms.scheduler.portlet.notification.SendNotificationToUserHandler;
import com.ax.hrms.service.*;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.dispatch.executor.BaseDispatchTaskExecutor;
import com.liferay.dispatch.executor.DispatchTaskExecutor;
import com.liferay.dispatch.executor.DispatchTaskExecutorOutput;
import com.liferay.dispatch.model.DispatchTrigger;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.UserNotificationDeliveryConstants;
import com.liferay.portal.kernel.model.UserNotificationEvent;
import com.liferay.portal.kernel.service.*;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.PrefsPropsUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.*;
import java.util.stream.Collectors;

@Component(
        property = {
                "dispatch.task.executor.name=Ax Hrms Monthly Scheduler", "dispatch.task.executor.type=Ax Hrms Monthly Scheduler"
        },
        service = DispatchTaskExecutor.class
)
public class AxHrmsMonthlyScheduler extends BaseDispatchTaskExecutor {

    Log log = LogFactoryUtil.getLog(AxHrmsMonthlyScheduler.class);

    @Reference
    AppraisalEvaluationFormStatusLocalService appraisalEvaluationFormStatusLocalService;

    @Reference
    NotificationTemplateConfiguration notificationTemplateConfiguration;

    @Reference
    EmployeeDetailsLocalService employeeDetailsLocalService;

    @Reference
    AxHrmsCommonApi axHrmsCommonApi;

    @Reference
    AppraisalReminderLocalService appraisalReminderLocalService;

    @Reference
    AppraisalFormTemplatesLocalService appraisalFormTemplatesLocalService;

    @Reference
    TemplateLevelMasterLocalService templateLevelMasterLocalService;
    @Reference
    UserLocalService userLocalService;

    @Reference
    EmployeeDesignationLocalService employeeDesignationLocalService;

    @Reference
    DepartmentMasterLocalService departmentMasterLocalService;

    @Reference
    DesignationMasterLocalService designationMasterLocalService;

    @Reference
    EmployeeDepartmentLocalService employeeDepartmentLocalService;

    @Reference
    RoleLocalService roleLocalService;

    @Reference
    UserNotificationEventLocalService userNotificationEventLocalService;

    @Reference
    AppraisalProcessLocalService appraisalProcessLocalService;

    @Reference
    AppraisalStatusMasterLocalService appraisalStatusMasterLocalService;

    @Reference
    ProbationStatusMasterLocalService probationStatusMasterLocalService;

    @Reference
    EmployeeProbationDetailsLocalService employeeProbationDetailsLocalService;

    @Reference
    UpcomingProbationEmployeeLocalService upcomingProbationEmployeeLocalService;

    @Override
    public void doExecute(DispatchTrigger dispatchTrigger, DispatchTaskExecutorOutput dispatchTaskExecutorOutput) throws Exception {
        log.info("AxHrmsMonthlyScheduler >>> doExecute ::: Monthly Schedular Run");
        appraisalReminderToHr();
        getMonthlyProbationDetails();
    }

    @Override
    public String getName() {
        return "Ax Hrms Monthly Scheduler";
    }

   private void appraisalReminderToHr() throws Exception {
       // getting the current month using calendar.
       Calendar cal = new GregorianCalendar();
       cal.setTime(new Date());
       int month = cal.get(Calendar.MONTH) + 1; // since months are zero-based in the calendar.
       int year = cal.get(Calendar.YEAR);
       // Query to find employees with appraisals this month.

       List<EmployeeDetails> allEmployeeDetailsList = employeeDetailsLocalService.getEmployeeDetailses(-1, -1);


       // Filter employees with joining date in current month but not in current year
       List<EmployeeDetails> employeeDetailsList = allEmployeeDetailsList.stream()
               .filter(employeeDetails -> {
                   Calendar joiningCal = Calendar.getInstance();
                   joiningCal.setTime(employeeDetails.getJoiningDate());
                   int joiningYear = joiningCal.get(Calendar.YEAR);
                   int joiningMonth = joiningCal.get(Calendar.MONTH) + 1; // Adding 1 because Calendar.MONTH is zero-based
                   return joiningYear != year && joiningMonth == month;
               })
               .collect(Collectors.toList());

       employeeDetailsList.forEach(employeeDetails -> {
           AppraisalReminder appraisalReminder = appraisalReminderLocalService.createAppraisalReminder(CounterLocalServiceUtil.increment(AppraisalReminder.class.getName()));
           //Audit fields
           appraisalReminder.setCreateDate(new Date());
           appraisalReminder.setModifiedDate(new Date());
           // Main Field
           appraisalReminder.setAppraisalRemainderMonth(cal.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.getDefault()));
           appraisalReminder.setAppraisalRemainderYear(String.valueOf(cal.get(Calendar.YEAR)));
           appraisalReminder.setEmployeeId(employeeDetails.getEmployeeId());


           AppraisalProcess appraisalProcess = appraisalProcessLocalService.createAppraisalProcess(CounterLocalServiceUtil.increment(AppraisalProcess.class.getName()));
           appraisalProcess.setIsSelfEvalutionFormFilled(false);
           appraisalProcess.setIsSelfEvalutionFormSent(false);
           appraisalProcess.setArePeerEvaluationFormFilled(false);
           appraisalProcess.setArePeerEvaluationFormSent(false); 
           appraisalProcess.setIsManagementFormSent(false);
           appraisalProcess.setIsManagementFormFilled(false);
           appraisalProcess.setIsMeetingScheduled(false);
           appraisalProcess.setIsMeetingDone(false);
           appraisalProcess.setIsSalaryUpdated(false);

           try {
               appraisalProcess.setStatus(appraisalStatusMasterLocalService.findBystatus("Pending").getAppraisalStatusMasterId());

           } catch (NoSuchAppraisalStatusMasterException e) {
               log.error("UNABLE TO FETCH APPRAISAL STATUS MASTER!");
           }
           appraisalProcessLocalService.addAppraisalProcess(appraisalProcess);

           appraisalReminder.setAppraisalProcessId(appraisalProcess.getAppraisalProcessId());
           //adding records to database.
           appraisalReminderLocalService.addAppraisalReminder(appraisalReminder);
       });
       List<User> hrUsers = null;
       try
       {
           Group group = GroupLocalServiceUtil.fetchGroup(PortalUtil.getDefaultCompanyId(), AxHrmsMonthlySchedulerConstants.GUEST);
           hrUsers = axHrmsCommonApi.fetchHrAdminList(group.getCompanyId());
       }
       catch (Exception e){
            log.error("ERROR GETTING HR ADMIN LIST");
       }
        sendAppraisalReminderMailToHr(hrUsers,employeeDetailsList);

   }

    private void sendAppraisalReminderMailToHr(List<User> hrList, List<EmployeeDetails> employeeDetailsList) throws Exception {
        StringBuilder body =
                new StringBuilder(AxHrmsMonthlySchedulerConstants.HR_APPRISAL_REMMINDER_MAIL_HEAD);
        Group group = GroupLocalServiceUtil.fetchGroup(PortalUtil.getDefaultCompanyId(), "Guest");
        String fromName = PrefsPropsUtil.getString(group.getCompanyId(), PropsKeys.ADMIN_EMAIL_FROM_NAME);
        String fromEmailAddress = PrefsPropsUtil.getString(group.getCompanyId(), PropsKeys.ADMIN_EMAIL_FROM_ADDRESS);
        for (EmployeeDetails employeeDetails : employeeDetailsList) {

            List<DepartmentMaster> departmentMasterList = axHrmsCommonApi.getDepartmentMastersFromEmployeeId(employeeDetails.getEmployeeId());
            List<DesignationMaster> designationMasterList = axHrmsCommonApi.getDesignationMastersFromEmployeeId(employeeDetails.getEmployeeId());
            StringBuilder departmentListStringHtml = new StringBuilder();
            StringBuilder designationListStringHtml = new StringBuilder();
            for (DepartmentMaster departmentMaster : departmentMasterList) {
                departmentListStringHtml.append(departmentMaster.getDepartmentName()).append("<br>");
            }
            for (DesignationMaster designationMaster : designationMasterList) {
                designationListStringHtml.append(designationMaster.getDesignationName()).append("<br>");
            }
            Calendar cal = Calendar.getInstance();
            cal.setTime(employeeDetails.getJoiningDate());
            cal.set(Calendar.YEAR, 2024);
            body.append("<tr>\n <td style=\"border: 1px solid #ddd; padding: 10px;\">").append(employeeDetails.getEmployeeCode()).append("</td>\n  <td style=\"border: 1px solid #ddd; padding: 10px;\">").append(employeeDetails.getFirstName()).append(" ").append(employeeDetails.getLastName()).append("</td>\n <td style=\"border: 1px solid #ddd; padding: 10px;\"> ").append(departmentListStringHtml).append("</td>\n <td style=\"border: 1px solid #ddd; padding: 10px;\">").append(designationListStringHtml).append("</td>\n <td style=\"border: 1px solid #ddd; padding: 10px;\">  ").append(cal.getTime()).append("</td>\n </tr>\n");



            JSONObject notificationJSON = JSONFactoryUtil.createJSONObject();
            for (User user : hrList) {
                Calendar mCalendar = Calendar.getInstance();
                String month = mCalendar.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.getDefault());
                int year = mCalendar.get(Calendar.YEAR);

                String bodyNotification= notificationTemplateConfiguration.appraisalReminderToHrNotification();
                bodyNotification = bodyNotification.replace("${EMPLOYEE_CODE}", employeeDetails.getEmployeeCode());
                bodyNotification = bodyNotification.replace("${FIRST_NAME}", employeeDetails.getFirstName());
                bodyNotification = bodyNotification.replace("${CURRENT_MONTH}", month);
                bodyNotification = bodyNotification.replace("${CURRENT_YEAR}",String.valueOf(year));
                bodyNotification = bodyNotification.replace("${LAST_NAME}", employeeDetails.getLastName());
                notificationJSON.put("body", bodyNotification );

                // Notification........
                UserNotificationEvent userNotificationEvent = UserNotificationEventLocalServiceUtil.sendUserNotificationEvents(
                        user.getUserId(), AxHrmsSchedulerPortletKeys.AXHRMSSCHEDULER,
                        UserNotificationDeliveryConstants.TYPE_WEBSITE, notificationJSON);

                ServiceContext serviceContext = new ServiceContext();
                SendNotificationToUserHandler sendNotificationToUserHandler = new SendNotificationToUserHandler();
                sendNotificationToUserHandler.callGetBody(userNotificationEvent, serviceContext);
            }
        }
        body.append(AxHrmsMonthlySchedulerConstants.HR_APPRISAL_REMMINDER_MAIL_FOOTER);

        for (User user : hrList) {
            axHrmsCommonApi.sendMail(user.getEmailAddress(), fromEmailAddress, fromName, AxHrmsMonthlySchedulerConstants.SUBJECT, body.toString());
        }
    }

    private void getMonthlyProbationDetails(){
        Calendar calendar = Calendar.getInstance();
        int currentMonth = calendar.get(Calendar.MONTH)+1;
        int currentYear = calendar.get(Calendar.YEAR);

        List<EmployeeProbationDetails> listOfEmployeeProbationDetail;
        List<EmployeeProbationDetails> upcomingProbationList = new ArrayList<>();
        listOfEmployeeProbationDetail = employeeProbationDetailsLocalService.getEmployeeProbationDetailses(-1,-1);

        int monthOfProbationEndDate = 0;
        int yearOfProbationEndDate = 0;

        try{
            for(EmployeeProbationDetails employeeProbationDetails: listOfEmployeeProbationDetail){

                Calendar employeeProbationEndDateCalendar = Calendar.getInstance();
                employeeProbationEndDateCalendar.setTime(employeeProbationDetails.getProbationEndDate());
                monthOfProbationEndDate = employeeProbationEndDateCalendar.get(Calendar.MONTH)+1;
                yearOfProbationEndDate = employeeProbationEndDateCalendar.get(Calendar.YEAR);

                log.info("Month is: "+monthOfProbationEndDate+" and year is: "+yearOfProbationEndDate );
                if(monthOfProbationEndDate == currentMonth && yearOfProbationEndDate == currentYear)
                    upcomingProbationList.add(employeeProbationDetails);
            }
        }catch(Exception e){
            log.error("AxHrmsMonthlyScheduler >>> addUpcomingProbationDetails ::: Exception is: "+e.getMessage());
        }

        addUpcomingProbationDetails(upcomingProbationList);
    }
    private void addUpcomingProbationDetails(List<EmployeeProbationDetails> employeeProbationDetailList){
        try{
            Group group = GroupLocalServiceUtil.fetchGroup(PortalUtil.getDefaultCompanyId(), AxHrmsMonthlySchedulerConstants.GUEST);
            for(EmployeeProbationDetails employeeProbationDetails : employeeProbationDetailList){

                Calendar employeeProbationEndDateCalendar = Calendar.getInstance();
                employeeProbationEndDateCalendar.setTime(employeeProbationDetails.getProbationEndDate());
                int monthOfProbationEndDate = employeeProbationEndDateCalendar.get(Calendar.MONTH)+1;
                int yearOfProbationEndDate = employeeProbationEndDateCalendar.get(Calendar.YEAR);

                UpcomingProbationEmployee upcomingProbationEmployee = upcomingProbationEmployeeLocalService.createUpcomingProbationEmployee(CounterLocalServiceUtil.increment(UpcomingProbationEmployee.class.getName()));

                upcomingProbationEmployee.setProbationDetailId(employeeProbationDetails.getProbationDetailId());
                upcomingProbationEmployee.setMonth(monthOfProbationEndDate);
                upcomingProbationEmployee.setYear(yearOfProbationEndDate);

                upcomingProbationEmployee.setCompanyId(group.getCompanyId());
                upcomingProbationEmployee.setCreatedBy(group.getCreatorUserId());
                upcomingProbationEmployee.setModifiedBy(group.getCreatorUserId());
                upcomingProbationEmployee.setGroupId(group.getGroupId());
                upcomingProbationEmployeeLocalService.addUpcomingProbationEmployee(upcomingProbationEmployee);
            }
        }catch(Exception e){
            log.error("AxHrmsMonthlyScheduler >>> addUpcomingProbationDetails ::: Exception is: "+e.getMessage());
        }


    }
}
