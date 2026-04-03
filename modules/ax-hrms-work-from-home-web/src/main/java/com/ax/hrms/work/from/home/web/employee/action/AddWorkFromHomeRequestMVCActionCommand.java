package com.ax.hrms.work.from.home.web.employee.action;

import com.ax.hrms.common.api.api.AxHrmsCommonApi;
import com.ax.hrms.mail.template.config.configuration.MailTemplateConfiguration;
import com.ax.hrms.master.service.DepartmentMasterLocalService;
import com.ax.hrms.master.service.DesignationMasterLocalService;
import com.ax.hrms.master.service.LeaveCompensatoryStatusMasterLocalService;
import com.ax.hrms.model.EmployeeDetails;
import com.ax.hrms.model.WorkFromHomeDayType;
import com.ax.hrms.model.WorkFromHomeRequest;
import com.ax.hrms.notification.template.config.configuration.NotificationTemplateConfiguration;
import com.ax.hrms.service.*;
import com.ax.hrms.work.from.home.web.constants.AxHrmsWorkFromHomePortletKeys;
import com.ax.hrms.work.from.home.web.employee.util.WFHStatusUtil;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.*;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

@Component(property = {"javax.portlet.name=" + AxHrmsWorkFromHomePortletKeys.AXHRMSWORKFROMHOME, "mvc.command.name=/addEditWFH"}, service = MVCActionCommand.class)
public class AddWorkFromHomeRequestMVCActionCommand extends BaseMVCActionCommand {
    private static final Log log = LogFactoryUtil.getLog(AddWorkFromHomeRequestMVCActionCommand.class);

    @Reference
    WorkFromHomeRequestLocalService workFromHomeRequestLocalService;

    @Reference
    private LeaveCompensatoryStatusMasterLocalService leaveCompensatoryStatusMasterLocalService;

    @Reference
    private EmployeeDetailsLocalService employeeDetailsLocalService;
    @Reference
    NotificationTemplateConfiguration notificationTemplateConfiguration;

    @Reference
    MailTemplateConfiguration mailTemplateConfiguration;
    @Reference
    AxHrmsCommonApi axHrmsCommonApi;
    @Reference
    LeaveCompensatoryStatusMasterLocalService leaveStatusLocalService;
    @Reference
    DepartmentMasterLocalService departmentMasterLocalService;

    @Reference
    DesignationMasterLocalService designationMasterLocalService;


    @Reference
    EmployeeDepartmentLocalService employeeDepartmentLocalService;

    @Reference
    EmployeeDesignationLocalService employeeDesignationLocalService;

    @Reference
    WorkFromHomeDayTypeLocalService workFromHomeDayTypeLocalService;

    @Override
    protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
        super.hideDefaultErrorMessage(actionRequest);
//        super.hideDefaultSuccessMessage(actionRequest);
        long wfhId = ParamUtil.getLong(actionRequest, "workFromHomeRequestId");

        System.out.println("workFromHomeRequestId:" + wfhId);
        System.out.println("wfhId in doProcessAction = " + wfhId);
        log.info("wfhId in doProcessAction = " + wfhId);
//        String teamMailId = ParamUtil.getString(actionRequest, "teamMailId");
        String teamMailId = ParamUtil.getString(actionRequest, "teamId");
        log.info("teammailid:-"+ teamMailId);
        String reason = ParamUtil.getString(actionRequest, "reason");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        String startDateStr = ParamUtil.getString(actionRequest, "startDate");
        String endDateStr = ParamUtil.getString(actionRequest, "endDate");

        Date startDate = Validator.isNotNull(startDateStr) ? sdf.parse(startDateStr) : null;
        Date endDate = Validator.isNotNull(endDateStr) ? sdf.parse(endDateStr) : null;

        ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
        log.info("here ok.....");



        // -----------------------------
        // VALIDATION SECTION
        // -----------------------------

        boolean hasError = false;
        // Empty fields check
        if (Validator.isNull(teamMailId) ||
                Validator.isNull(reason) ||
                Validator.isNull(startDateStr) ||
                Validator.isNull(endDateStr)) {

            SessionErrors.add(actionRequest, "empty-fields");
            hasError = true;
        }else {

            // Split by comma
            String[] emailArray = teamMailId.split(",");

            Set<String> uniqueEmails = new LinkedHashSet<>();
            boolean invalidEmailFound = false;

            for (String email : emailArray) {
                String trimmedEmail = email.trim();

                // Validate email format
                if (!Validator.isEmailAddress(trimmedEmail)) {
                    invalidEmailFound = true;
                    break;
                }

                uniqueEmails.add(trimmedEmail.toLowerCase());
            }

            if (invalidEmailFound) {
                SessionErrors.add(actionRequest, "email-invalid");
                hasError = true;
            } else {
                // Remove duplicates & rebuild string
                teamMailId = uniqueEmails.stream()
                        .collect(Collectors.joining(","));
            }
        }


        // Email validation
        if (Validator.isNull(teamMailId)) {
            SessionErrors.add(actionRequest, "email-invalid");
            hasError = true;
        }

        // Reason validation (min 10 chars)
        if (reason.length() < 10) {
            SessionErrors.add(actionRequest, "reason-min-char-invalid");
            hasError = true;
        }

        // Reason validation (max 250 chars)
        if (reason.length() > 250) {
            SessionErrors.add(actionRequest, "reason-max-char-invalid");
            hasError = true;
        }

        // Start date required
        if (startDate == null) {
            SessionErrors.add(actionRequest, "start-date-invalid");
            hasError = true;
        }

        // End date required
        if (endDate == null) {
            SessionErrors.add(actionRequest, "end-date-invalid");
            hasError = true;
        }

        // End date must be after start date
        if (startDate != null && endDate != null && endDate.before(startDate)) {
            SessionErrors.add(actionRequest, "end-before-start");
            hasError = true;
        }

        // If any validation failed → stop processing
        if (hasError) {
            actionResponse.setRenderParameter("mvcPath", "/jsp/ax-hrms-work-from-home-employee/add_edit_work_from_home.jsp");
            return;
        }


        // -----------------------------
        // SAVE DATA (ADD / EDIT)
        // -----------------------------
        log.info("befor the condition check");
        Map<String, Object> serviceMap = new HashMap<>();
        serviceMap.put("departmentMasterLocalService", departmentMasterLocalService);
        serviceMap.put("designationMasterLocalService", designationMasterLocalService);
        serviceMap.put("employeeDepartmentLocalService", employeeDepartmentLocalService);
        serviceMap.put("employeeDesignationLocalService", employeeDesignationLocalService);
        serviceMap.put("leaveStatusLocalService", leaveStatusLocalService);
        serviceMap.put("employeeDetailsLocalService", employeeDetailsLocalService);

        String fromName = PrefsPropsUtil.getString(themeDisplay.getCompanyId(), PropsKeys.ADMIN_EMAIL_FROM_NAME);
        String fromEmailAddress = PrefsPropsUtil.getString(themeDisplay.getCompanyId(),
                PropsKeys.ADMIN_EMAIL_FROM_ADDRESS);
        EmployeeDetails employeeDetails = null;
        try {
            employeeDetails = employeeDetailsLocalService.findByLrUserId(themeDisplay.getUserId());
            log.info("employee details " + employeeDetails.toString());
        } catch (Exception e) {
            log.error("Error while fetching employee details for ID: " + wfhId+"     "+ e.getMessage());
        }
        if (wfhId <= 0) {

            log.info("inside the ....................");
            // ADD NEW ENTRY
            WorkFromHomeRequest wfh = workFromHomeRequestLocalService.createWorkFromHomeRequest(CounterLocalServiceUtil.increment(WorkFromHomeRequest.class.getName()));
            log.info("inside the condition check");

            wfh.setCompanyId(themeDisplay.getCompanyId());
            wfh.setGroupId(themeDisplay.getScopeGroupId());
            wfh.setCreatedBy(themeDisplay.getUserId());
            wfh.setModifiedBy(themeDisplay.getUserId());
            wfh.setCreateDate(new Date());
            wfh.setModifiedDate(new Date());

            wfh.setTeamMailId(teamMailId);
            wfh.setReason(reason);
            wfh.setStatus(leaveCompensatoryStatusMasterLocalService.findByLeaveCompensatoryStatusName(AxHrmsWorkFromHomePortletKeys.PENDING).getLeaveCompensatoryStatusMasterId());
            wfh.setStartDate(startDate);
            wfh.setEndDate(endDate);
            wfh.setRequestDate(new Date());
            assert employeeDetails != null;
            wfh.setEmployeeId(employeeDetails.getEmployeeId());
            wfh.setModifiedBy(themeDisplay.getUserId());
            wfh.setReviewerId(employeeDetails.getEmployeeId());
            log.info("over here");
            workFromHomeRequestLocalService.addWorkFromHomeRequest(wfh);
            addWFHDayTypeData(actionRequest, wfh.getWorkFromHomeRequestId(), themeDisplay);
            log.info("add successfullyt");


            // adding details in workFromHomeDayType table














            //Sending notification to Manager

            log.info("employeeDetails.getManagerId() ::   "+employeeDetails.getManagerId());
            EmployeeDetails manager = employeeDetailsLocalService.fetchEmployeeDetails(employeeDetails.getManagerId());
            log.info("manage info is the :: "+manager);

            String HrAndManagerNotification =notificationTemplateConfiguration.WFHRequestManagerAndHr();


            //Sending notification to the HR Admin
            String roleName="HR Admin";
            Role role = RoleLocalServiceUtil.fetchRole(themeDisplay.getCompanyId(), roleName);
            List<User> users = UserLocalServiceUtil.getRoleUsers(role.getRoleId());
            for (User user : users) {
                try {
                    log.info("User: " + user.getFullName() + " | Email: " + user.getEmailAddress() + "  ,,,,, " + user.getUserId());
                    EmployeeDetails HremployeeDetails = employeeDetailsLocalService.findByLrUserId(user.getUserId());
                    log.info("Employee Id: " + HremployeeDetails.toString());
                    WFHStatusUtil.sendNotificationToEmployee(HrAndManagerNotification, HremployeeDetails);
                    StringBuilder hrMailBody = new StringBuilder(AxHrmsWorkFromHomePortletKeys.WFH_REQUEST_MAIL_HEAD_v2);
                    WFHStatusUtil.sendMailtoManager(fromName, fromEmailAddress, hrMailBody, wfh, HremployeeDetails, mailTemplateConfiguration, employeeDetailsLocalService, axHrmsCommonApi, serviceMap, false);
                } catch (Exception e) {
                    log.info("error while sending notification to manager :: "+e.getMessage());
                }
            }

            //send mail to Manager
            if(Validator.isNotNull(manager)){
                StringBuilder managerMailBody = new StringBuilder(AxHrmsWorkFromHomePortletKeys.WFH_REQUEST_MAIL_HEAD_v2);

                WFHStatusUtil.sendMailtoManager(fromName,fromEmailAddress,managerMailBody,wfh,manager,mailTemplateConfiguration,employeeDetailsLocalService,axHrmsCommonApi,serviceMap,false);
                WFHStatusUtil.sendNotificationToEmployee(HrAndManagerNotification, manager);

            }


            SessionMessages.add(actionRequest, "wfh-added");
        } else {

            // EDIT EXISTING ENTRY
            WorkFromHomeRequest wfh = workFromHomeRequestLocalService.getWorkFromHomeRequest(wfhId);

            wfh.setTeamMailId(teamMailId);
            wfh.setReason(reason);
            wfh.setStartDate(startDate);
            wfh.setEndDate(endDate);
            wfh.setModifiedBy(themeDisplay.getUserId());
            wfh.setModifiedDate(new Date());
            wfh.setModifiedBy(themeDisplay.getUserId());
            wfh.setReviewerId(employeeDetails.getEmployeeId());
            workFromHomeRequestLocalService.updateWorkFromHomeRequest(wfh);
            // delete old records
            List<WorkFromHomeDayType> oldList =
                    workFromHomeDayTypeLocalService
                            .findByWorkFromHomeRequestId(wfhId);

            for (WorkFromHomeDayType old : oldList) {
                workFromHomeDayTypeLocalService.deleteWorkFromHomeDayType(old);
            }

// insert new records
            addWFHDayTypeData(actionRequest, wfhId, themeDisplay);

            //Send Notification and Mail
            EmployeeDetails manager = employeeDetailsLocalService.fetchEmployeeDetails(employeeDetails.getManagerId());
            String HrAndManagerNotification =notificationTemplateConfiguration.WFHRequestManagerAndHr();


            //Sending notification to the HR Admin
            String roleName="HR Admin";
            Role role = RoleLocalServiceUtil.fetchRole(themeDisplay.getCompanyId(), roleName);
            List<User> users = UserLocalServiceUtil.getRoleUsers(role.getRoleId());
            for (User user : users) {
                try {
                    log.info("User: " + user.getFullName() + " | Email: " + user.getEmailAddress() + "  ,,,,, " + user.getUserId());
                    EmployeeDetails HremployeeDetails = employeeDetailsLocalService.findByLrUserId(user.getUserId());
                    log.info("Employee Id: " + HremployeeDetails.toString());
                    WFHStatusUtil.sendNotificationToEmployee(HrAndManagerNotification, HremployeeDetails);
                    StringBuilder hrMailBody = new StringBuilder(AxHrmsWorkFromHomePortletKeys.WFH_REQUEST_MAIL_HEAD_v2);
                    WFHStatusUtil.sendMailtoManager(fromName, fromEmailAddress, hrMailBody, wfh, HremployeeDetails, mailTemplateConfiguration, employeeDetailsLocalService, axHrmsCommonApi, serviceMap, true);
                } catch (Exception e) {
                    log.info("error while sending notification to manager :: "+e.getMessage());
                }
            }

            //send mail to Manager

            StringBuilder managerMailBody = new StringBuilder(AxHrmsWorkFromHomePortletKeys.WFH_REQUEST_MAIL_HEAD_v2);
            if(Validator.isNotNull(manager)){
                WFHStatusUtil.sendMailtoManager(fromName,fromEmailAddress,managerMailBody,wfh,manager,mailTemplateConfiguration,employeeDetailsLocalService,axHrmsCommonApi,serviceMap,true);
                WFHStatusUtil.sendNotificationToEmployee(HrAndManagerNotification, manager);
            }

            SessionMessages.add(actionRequest, "wfh-updated");
        }
//        String redirect = ParamUtil.getString(actionRequest, "redirect");
//        if (Validator.isNotNull(redirect)) {
//            actionResponse.sendRedirect(redirect);
//        }
        log.info("I am at last of WFH");
        // Hide default Liferay error message
        actionResponse.sendRedirect(PortalUtil.getLayoutFullURL(themeDisplay));

    }

    private void addWFHDayTypeData(
            ActionRequest actionRequest,
            long wfhRequestId,
            ThemeDisplay themeDisplay) {

        String[] selectedDates =
                ParamUtil.getParameterValues(actionRequest, "wfhDate");

        log.info("selectedDate:-"+ selectedDates);

        if (selectedDates == null || selectedDates.length == 0) {
            return;
        }

        SimpleDateFormat sdf =
                new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSSSS");

        for (String dateStr : selectedDates) {

            try {

                Date wfhDate =
                        sdf.parse(dateStr + " 00:00:00.0000");

                String dateKey = dateStr.replace("-", "");

                boolean isHalf =
                        ParamUtil.getBoolean(
                                actionRequest,
                                "day" + dateKey + "IsHalf",
                                false);

                boolean isFirstHalf = false;

                if (isHalf) {

                    String halfType =
                            ParamUtil.getString(
                                    actionRequest,
                                    "day" + dateKey + "halfType");

                    isFirstHalf =
                            "firstHalf".equalsIgnoreCase(halfType);
                }

                long id =
                        CounterLocalServiceUtil.increment(
                                WorkFromHomeDayType.class.getName());

                WorkFromHomeDayType dayType =
                        workFromHomeDayTypeLocalService
                                .createWorkFromHomeDayType(id);

                dayType.setCompanyId(themeDisplay.getCompanyId());
                dayType.setGroupId(themeDisplay.getScopeGroupId());
                dayType.setCreatedBy(themeDisplay.getUserId());
                dayType.setModifiedBy(themeDisplay.getUserId());
                dayType.setCreateDate(new Date());
                dayType.setModifiedDate(new Date());

                dayType.setWorkFromHomeRequestId(wfhRequestId);
                dayType.setWorkFromHomeDate(wfhDate);
                dayType.setIsHalfDay(isHalf);
                dayType.setIsFirstHalf(isFirstHalf);

                workFromHomeDayTypeLocalService
                        .addWorkFromHomeDayType(dayType);

            } catch (Exception e) {
                log.error("Error saving WFH day type", e);
            }
        }
    }
}
