package com.ax.hrms.work.from.home.web.hr.action;


import com.ax.hrms.common.api.api.AxHrmsCommonApi;
import com.ax.hrms.mail.template.config.configuration.MailTemplateConfiguration;
import com.ax.hrms.master.model.LeaveCompensatoryStatusMaster;
import com.ax.hrms.master.service.DepartmentMasterLocalService;
import com.ax.hrms.master.service.DesignationMasterLocalService;
import com.ax.hrms.master.service.LeaveCompensatoryStatusMasterLocalService;
import com.ax.hrms.model.EmployeeDetails;
import com.ax.hrms.model.WorkFromHomeRequest;
import com.ax.hrms.notification.template.config.configuration.NotificationTemplateConfiguration;
import com.ax.hrms.service.EmployeeDepartmentLocalService;
import com.ax.hrms.service.EmployeeDesignationLocalService;
import com.ax.hrms.service.EmployeeDetailsLocalService;
import com.ax.hrms.service.WorkFromHomeRequestLocalService;
import com.ax.hrms.work.from.home.web.constants.AxHrmsWorkFromHomePortletKeys;
import com.ax.hrms.work.from.home.web.hr.util.WFHStatusUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PrefsPropsUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.WebKeys;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component(immediate = true, property = {"javax.portlet.name=" + AxHrmsWorkFromHomePortletKeys.AXHRMSWORKFROMHOMEHR, "mvc.command.name=/wfh/approve"}, service = MVCActionCommand.class)
public class ApproveWFHRequestActionCommand implements MVCActionCommand {

    private static final Log log = LogFactoryUtil.getLog(ApproveWFHRequestActionCommand.class);

    @Reference
    private WorkFromHomeRequestLocalService workFromHomeRequestLocalService;

    @Reference
    LeaveCompensatoryStatusMasterLocalService leaveStatusLocalService;
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

        try {

            ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);

            long wfhId = ParamUtil.getLong(actionRequest, "wfhId");

            WorkFromHomeRequest wfh = workFromHomeRequestLocalService.fetchWorkFromHomeRequest(wfhId);

            if (wfh == null) {
                SessionErrors.add(actionRequest, "wfh-error");
                return false;
            }

            // Fetch all statuses
            java.util.List<LeaveCompensatoryStatusMaster> statusList = leaveStatusLocalService.getLeaveCompensatoryStatusMasters(-1, -1);
            // Find Approved Status ID

            long approvedId = statusList.stream().filter(s -> "Approved".equalsIgnoreCase(s.getLeaveCompensatoryStatus())).map(LeaveCompensatoryStatusMaster::getLeaveCompensatoryStatusMasterId).findFirst().orElse(0L);

            if (approvedId == 0) {
                SessionErrors.add(actionRequest, "wfh-error");
                return false;
            }

            // Update the status
            wfh.setStatus(approvedId);
            long currentUserId = themeDisplay.getUserId();
            EmployeeDetails approverEmployeeDetails = employeeDetailsLocalService.findByLrUserId(currentUserId);

            Map<String, Object> serviceMap = new HashMap<>();
            serviceMap.put("departmentMasterLocalService", departmentMasterLocalService);
            serviceMap.put("designationMasterLocalService", designationMasterLocalService);
            serviceMap.put("employeeDepartmentLocalService", employeeDepartmentLocalService);
            serviceMap.put("employeeDesignationLocalService", employeeDesignationLocalService);
            serviceMap.put("leaveStatusLocalService", leaveStatusLocalService);
            serviceMap.put("employeeDetailsLocalService", employeeDetailsLocalService);

            String fromName = PrefsPropsUtil.getString(themeDisplay.getCompanyId(), PropsKeys.ADMIN_EMAIL_FROM_NAME);
            String fromEmailAddress = PrefsPropsUtil.getString(themeDisplay.getCompanyId(), PropsKeys.ADMIN_EMAIL_FROM_ADDRESS);
            StringBuilder employeeMailBody = new StringBuilder(AxHrmsWorkFromHomePortletKeys.WFH_REQUEST_MAIL_HEAD_v2);
            EmployeeDetails employeeDetails = employeeDetailsLocalService.findByLrUserId(currentUserId);
            wfh.setReviewerId(employeeDetails.getEmployeeId());
            workFromHomeRequestLocalService.updateWorkFromHomeRequest(wfh);

            EmployeeDetails employeeDetails1 = employeeDetailsLocalService.findByEmployeeId(wfh.getEmployeeId());
            WFHStatusUtil.sendMailtoManager(fromName, fromEmailAddress, employeeMailBody, wfh, employeeDetails1, mailTemplateConfiguration, employeeDetailsLocalService, axHrmsCommonApi, serviceMap, true, false);
            String employeeApprovedNotification = notificationTemplateConfiguration.WFHRequestApprovedNotificationToEmployee();

            EmployeeDetails manager = employeeDetailsLocalService.findByEmployeeId(employeeDetails1.getManagerId());
            if (manager != null && manager.getEmployeeId() != approverEmployeeDetails.getEmployeeId()) {
                StringBuilder managerMailBody = new StringBuilder(AxHrmsWorkFromHomePortletKeys.WFH_REQUEST_MAIL_HEAD_v2);
                WFHStatusUtil.sendMailtoManager(fromName, fromEmailAddress, managerMailBody, wfh, manager, mailTemplateConfiguration, employeeDetailsLocalService, axHrmsCommonApi, serviceMap, true, false);
                WFHStatusUtil.sendNotificationToEmployee(employeeApprovedNotification, manager);
            }
            WFHStatusUtil.sendNotificationToEmployee(employeeApprovedNotification, employeeDetails1);
            String roleName = "HR Admin";
            Role role = RoleLocalServiceUtil.fetchRole(themeDisplay.getCompanyId(), roleName);
            List<User> users = UserLocalServiceUtil.getRoleUsers(role.getRoleId());

            for (User user : users) {
                if (user.getUserId() == currentUserId) {
                    continue;
                }
                StringBuilder hrMailBody = new StringBuilder(AxHrmsWorkFromHomePortletKeys.WFH_REQUEST_MAIL_HEAD_v2);
                log.info("User: " + user.getFullName() + " | Email: " + user.getEmailAddress() + "  ,,,,, " + user.getUserId());
                EmployeeDetails HremployeeDetails = employeeDetailsLocalService.findByLrUserId(user.getUserId());
                log.info("Employee Id: " + HremployeeDetails.toString());
                WFHStatusUtil.sendNotificationToEmployee(employeeApprovedNotification, HremployeeDetails);
                WFHStatusUtil.sendMailtoManager(fromName, fromEmailAddress, hrMailBody, wfh, HremployeeDetails, mailTemplateConfiguration, employeeDetailsLocalService, axHrmsCommonApi, serviceMap, true, false);
            }

            //Send mail to team

            log.info("Team Mail Id is the :: " + wfh.getTeamMailId());
            List<String> teamEmailList = WFHStatusUtil.extractValidEmails(wfh.getTeamMailId());
            WFHStatusUtil.sendMailtoTeam(fromName, fromEmailAddress, teamEmailList, serviceMap, employeeMailBody, wfh, axHrmsCommonApi, mailTemplateConfiguration);
            log.info("mail sent successfully");
            // Send success message
            SessionMessages.add(actionRequest, "wfh-approved");

        } catch (Exception e) {
            e.printStackTrace();
            SessionErrors.add(actionRequest, "wfh-error");
        }

        return true;
    }
}
