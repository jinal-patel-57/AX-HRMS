package com.ax.hrms.work.from.home.web.hr.action;

import com.ax.hrms.common.api.api.AxHrmsCommonApi;
import com.ax.hrms.mail.template.config.configuration.MailTemplateConfiguration;
import com.ax.hrms.master.service.DepartmentMasterLocalService;
import com.ax.hrms.master.service.DesignationMasterLocalService;
import com.ax.hrms.model.EmployeeDetails;
import com.ax.hrms.model.WorkFromHome;
import com.ax.hrms.model.WorkFromHomeRequest;
import com.ax.hrms.notification.template.config.configuration.NotificationTemplateConfiguration;
import com.ax.hrms.service.*;
import com.ax.hrms.master.model.LeaveCompensatoryStatusMaster;
import com.ax.hrms.master.service.LeaveCompensatoryStatusMasterLocalService;
import com.ax.hrms.work.from.home.web.constants.AxHrmsWorkFromHomePortletKeys;
import com.ax.hrms.work.from.home.web.hr.util.WFHStatusUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;

import com.liferay.portal.kernel.util.PrefsPropsUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.WebKeys;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component(immediate = true, property = {"javax.portlet.name=" + AxHrmsWorkFromHomePortletKeys.AXHRMSWORKFROMHOMEHR, "mvc.command.name=/wfh/reject"}, service = MVCActionCommand.class)
public class RejectWFHRequestActionCommand implements MVCActionCommand {
    private static final Log log = LogFactoryUtil.getLog(RejectWFHRequestActionCommand.class);

    @Reference
    private WorkFromHomeRequestLocalService workFromHomeRequestLocalService;

    @Reference
    private LeaveCompensatoryStatusMasterLocalService leaveStatusLocalService;

    @Reference
    private EmployeeDetailsLocalService employeeDetailsLocalService;
    @Reference
    MailTemplateConfiguration mailTemplateConfiguration;
    @Reference
    AxHrmsCommonApi axHrmsCommonApi;
    @Reference
    NotificationTemplateConfiguration notificationTemplateConfiguration;
    @Reference
    DepartmentMasterLocalService departmentMasterLocalService;
    @Reference
    DesignationMasterLocalService designationMasterLocalService;
    @Reference
    EmployeeDepartmentLocalService employeeDepartmentLocalService;

    @Reference
    EmployeeDesignationLocalService employeeDesignationLocalService;

    @Override
    public boolean processAction(ActionRequest actionRequest, ActionResponse actionResponse) throws PortletException {
        ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);

        try {
            long wfhId = ParamUtil.getLong(actionRequest, "wfhId");

            WorkFromHomeRequest wfh = workFromHomeRequestLocalService.fetchWorkFromHomeRequest(wfhId);

            if (wfh == null) {
                SessionErrors.add(actionRequest, "wfh-error");
                return false;
            }

            // Fetch all statuses from master table
            java.util.List<LeaveCompensatoryStatusMaster> statusList = leaveStatusLocalService.getLeaveCompensatoryStatusMasters(-1, -1);

            // Find REJECTED status ID
            long rejectedId = statusList.stream().filter(s -> "Rejected".equalsIgnoreCase(s.getLeaveCompensatoryStatus())).map(LeaveCompensatoryStatusMaster::getLeaveCompensatoryStatusMasterId).findFirst().orElse(0L);

            if (rejectedId == 0) {
                SessionErrors.add(actionRequest, "wfh-error");
                return false;
            }

            // Update the status
            wfh.setStatus(rejectedId);
            Map<String, Object> serviceMap = new HashMap<>();
            serviceMap.put("departmentMasterLocalService", departmentMasterLocalService);
            serviceMap.put("designationMasterLocalService", designationMasterLocalService);
            serviceMap.put("employeeDepartmentLocalService", employeeDepartmentLocalService);
            serviceMap.put("employeeDesignationLocalService", employeeDesignationLocalService);
            serviceMap.put("leaveStatusLocalService", leaveStatusLocalService);
            serviceMap.put("employeeDetailsLocalService", employeeDetailsLocalService);

            long currentUserId = themeDisplay.getUserId();
            String fromName = PrefsPropsUtil.getString(themeDisplay.getCompanyId(), PropsKeys.ADMIN_EMAIL_FROM_NAME);
            String fromEmailAddress = PrefsPropsUtil.getString(themeDisplay.getCompanyId(), PropsKeys.ADMIN_EMAIL_FROM_ADDRESS);
            StringBuilder employeeMailBody = new StringBuilder(AxHrmsWorkFromHomePortletKeys.WFH_REQUEST_MAIL_HEAD_v2);

            EmployeeDetails employeeDetails = employeeDetailsLocalService.findByLrUserId(currentUserId);
            wfh.setReviewerId(employeeDetails.getEmployeeId());


            workFromHomeRequestLocalService.updateWorkFromHomeRequest(wfh);

            EmployeeDetails employeeDetails1 = employeeDetailsLocalService.findByEmployeeId(wfh.getEmployeeId());
            EmployeeDetails manager = employeeDetailsLocalService.findByEmployeeId(employeeDetails1.getManagerId());
            WFHStatusUtil.sendMailtoManager(fromName, fromEmailAddress, employeeMailBody, wfh, manager, mailTemplateConfiguration, employeeDetailsLocalService, axHrmsCommonApi, serviceMap, false, false);
            WFHStatusUtil.sendMailtoManager(fromName, fromEmailAddress, employeeMailBody, wfh, employeeDetails1, mailTemplateConfiguration, employeeDetailsLocalService, axHrmsCommonApi, serviceMap, false, false);

            String employeeRejectedNotification = notificationTemplateConfiguration.WFHRequestRejectedNotificationToEmployee();

            WFHStatusUtil.sendNotificationToEmployee(employeeRejectedNotification, employeeDetails1);
            String roleName = "HR Admin";
            Role role = RoleLocalServiceUtil.fetchRole(themeDisplay.getCompanyId(), roleName);
            List<User> users = UserLocalServiceUtil.getRoleUsers(role.getRoleId());
            for (User user : users) {
                log.info("User: " + user.getFullName() + " | Email: " + user.getEmailAddress() + "  ,,,,, " + user.getUserId());
                EmployeeDetails HremployeeDetails = employeeDetailsLocalService.findByLrUserId(user.getUserId());
                log.info("Employee Id: " + HremployeeDetails.toString());
                WFHStatusUtil.sendNotificationToEmployee(employeeRejectedNotification, HremployeeDetails);
                WFHStatusUtil.sendMailtoManager(fromName, fromEmailAddress, employeeMailBody, wfh, HremployeeDetails, mailTemplateConfiguration, employeeDetailsLocalService, axHrmsCommonApi, serviceMap, false, false);
            }


            // Success message (matches your JSP)
            SessionMessages.add(actionRequest, "wfh-rejected");

        } catch (Exception e) {
            e.printStackTrace();
            SessionErrors.add(actionRequest, "wfh-error");
        }

        return true;
    }
}
