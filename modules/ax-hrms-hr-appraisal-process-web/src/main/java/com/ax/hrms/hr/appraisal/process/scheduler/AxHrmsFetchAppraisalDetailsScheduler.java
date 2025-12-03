package com.ax.hrms.hr.appraisal.process.scheduler;

import com.ax.hrms.common.api.api.AxHrmsCommonApi;
import com.ax.hrms.exception.NoSuchEmployeeDetailsException;
import com.ax.hrms.hr.appraisal.process.constants.AxHrmsHrAppraisalProcessPortletKeys;
import com.ax.hrms.hr.appraisal.process.constants.AxHrmsHrAppraisalProcessSchedularConstants;
import com.ax.hrms.hr.appraisal.process.notification.SendNotificationToUserHandler;
import com.ax.hrms.master.exception.NoSuchAppraisalStatusMasterException;
import com.ax.hrms.master.model.AppraisalStatusMaster;
import com.ax.hrms.master.model.DepartmentMaster;
import com.ax.hrms.master.model.DesignationMaster;
import com.ax.hrms.master.service.AppraisalStatusMasterLocalService;
import com.ax.hrms.master.service.DepartmentMasterLocalService;
import com.ax.hrms.master.service.DesignationMasterLocalService;
import com.ax.hrms.model.AppraisalProcess;
import com.ax.hrms.model.AppraisalReminder;
import com.ax.hrms.model.EmployeeDepartment;
import com.ax.hrms.model.EmployeeDetails;
import com.ax.hrms.service.*;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.dispatch.executor.BaseDispatchTaskExecutor;
import com.liferay.dispatch.executor.DispatchTaskExecutor;
import com.liferay.dispatch.executor.DispatchTaskExecutorOutput;
import com.liferay.dispatch.model.DispatchTrigger;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Type;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.*;
import com.liferay.portal.kernel.service.*;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.PrefsPropsUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author nivid.koradiya
 */
@Component(
        property = {
                "dispatch.task.executor.name=Fetch Appraisal Details Scheduler", "dispatch.task.executor.type=FetchAppraisalDetailsScheduler"
        },
        service = DispatchTaskExecutor.class
)
public class AxHrmsFetchAppraisalDetailsScheduler extends BaseDispatchTaskExecutor {

    Log log = LogFactoryUtil.getLog(AxHrmsFetchAppraisalDetailsScheduler.class);
    @Reference
    AxHrmsCommonApi axHrmsCommonApi;
    @Reference
    UserLocalService userLocalService;

    @Reference
    EmployeeDetailsLocalService employeeDetailsLocalService;

    @Reference
    EmployeeDesignationLocalService employeeDesignationLocalService;

    @Reference
    AppraisalReminderLocalService appraisalReminderLocalService;

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

    @Override
    public void doExecute(DispatchTrigger dispatchTrigger, DispatchTaskExecutorOutput dispatchTaskExecutorOutput) throws Exception {

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
        Group group = GroupLocalServiceUtil.fetchGroup(PortalUtil.getDefaultCompanyId(), "Guest");
        hrUsers = axHrmsCommonApi.fetchHrAdminList(group.getCompanyId());
    }
    catch (Exception e){
        e.printStackTrace();
    }
        sendAppraisalReminderMailToHr(hrUsers,employeeDetailsList);

    }

    @Override
    public String getName() {
        return AxHrmsHrAppraisalProcessSchedularConstants.FETCH_APPRAISAL_DATE_SCHEDULER;
    }

    private void sendAppraisalReminderMailToHr(List<User> hrList, List<EmployeeDetails> employeeDetailsList) throws Exception {
        StringBuilder body =
                new StringBuilder(AxHrmsHrAppraisalProcessSchedularConstants.HR_APPRISAL_REMMINDER_MAIL_HEAD);
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

                notificationJSON.put("body", "Appraisal Upcoming this month - EMP CODE - " + employeeDetails.getEmployeeCode() +" || "+ employeeDetails.getFirstName() + " " + employeeDetails.getLastName() );
    
                // Notification........
                UserNotificationEvent userNotificationEvent = UserNotificationEventLocalServiceUtil.sendUserNotificationEvents(
                        user.getUserId(), AxHrmsHrAppraisalProcessPortletKeys.AX_HRMS_HR_APPRAISAL_PROCESS_WEB_PORTLET,
                        UserNotificationDeliveryConstants.TYPE_WEBSITE, notificationJSON);

                ServiceContext serviceContext = new ServiceContext();
                SendNotificationToUserHandler sendNotificationToUserHandler = new SendNotificationToUserHandler();
                sendNotificationToUserHandler.callGetBody(userNotificationEvent, serviceContext);
            }





        }
        body.append(AxHrmsHrAppraisalProcessSchedularConstants.HR_APPRISAL_REMMINDER_MAIL_FOOTER);

        for (User user : hrList) {
            axHrmsCommonApi.sendMail(user.getEmailAddress(), fromEmailAddress, fromName, AxHrmsHrAppraisalProcessSchedularConstants.SUBJECT, body.toString());
        }
    }
}