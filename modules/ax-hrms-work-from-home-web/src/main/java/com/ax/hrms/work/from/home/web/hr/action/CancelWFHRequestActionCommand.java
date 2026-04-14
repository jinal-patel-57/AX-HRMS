package com.ax.hrms.work.from.home.web.hr.action;

import com.ax.hrms.common.api.api.AxHrmsCommonApi;
import com.ax.hrms.mail.template.config.configuration.MailTemplateConfiguration;
import com.ax.hrms.master.model.LeaveCompensatoryStatusMaster;
import com.ax.hrms.master.service.DepartmentMasterLocalService;
import com.ax.hrms.master.service.DesignationMasterLocalService;
import com.ax.hrms.master.service.LeaveCompensatoryStatusMasterLocalService;
import com.ax.hrms.model.EmployeeDetails;
import com.ax.hrms.model.WorkFromHome;
import com.ax.hrms.model.WorkFromHomeRequest;
import com.ax.hrms.notification.template.config.configuration.NotificationTemplateConfiguration;
import com.ax.hrms.service.*;

import com.ax.hrms.work.from.home.web.constants.AxHrmsWorkFromHomePortletKeys;
import com.ax.hrms.work.from.home.web.constants.WFHActionConstants;
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

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;

import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.*;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component(
        property = {
                "javax.portlet.name=" + AxHrmsWorkFromHomePortletKeys.AXHRMSWORKFROMHOMEHR,
                "mvc.command.name=/wfh/cancel"
        },
        service = MVCActionCommand.class
)
public class CancelWFHRequestActionCommand implements MVCActionCommand {
    private static final Log log = LogFactoryUtil.getLog(CancelWFHRequestActionCommand.class);

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
    EmployeeDepartmentLocalService employeeDepartmentLocalService;

    @Reference
    EmployeeDesignationLocalService employeeDesignationLocalService;
    @Reference
    DesignationMasterLocalService designationMasterLocalService;
    @Reference
    private CommentLocalService commentLocalService;

    @Reference
    private WorkFromHomeDayTypeLocalService workFromHomeDayTypeLocalService;

    @Override
    public boolean processAction(ActionRequest request, ActionResponse response)
            throws PortletException {
        ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);

        try {
            long wfhId = Long.parseLong(request.getParameter("wfhId"));

            WorkFromHomeRequest wfh = workFromHomeRequestLocalService.fetchWorkFromHomeRequest(wfhId);
            String userComment = ParamUtil.getString(request,"actionComment");


            commentLocalService.addWorkflowComment(themeDisplay, 2L, WFHActionConstants.CANCEL, wfhId, userComment);


            if (wfh == null) {
                SessionErrors.add(request, "wfhNotFound");
                return false;
            }

            List<LeaveCompensatoryStatusMaster> statusList =
                    leaveStatusLocalService.getLeaveCompensatoryStatusMasters(-1, -1);

            long cancelledId = statusList.stream()
                    .filter(s -> "Cancelled".equalsIgnoreCase(s.getLeaveCompensatoryStatus()))
                    .map(LeaveCompensatoryStatusMaster::getLeaveCompensatoryStatusMasterId)
                    .findFirst()
                    .orElse(0L);

            if (cancelledId == 0) {
                SessionErrors.add(request, "statusNotFound");
                return false;
            }

            wfh.setStatus(cancelledId);
            Map<String, Object> serviceMap = new HashMap<>();
            serviceMap.put("departmentMasterLocalService", departmentMasterLocalService);
            serviceMap.put("designationMasterLocalService", designationMasterLocalService);
            serviceMap.put("employeeDepartmentLocalService", employeeDepartmentLocalService);
            serviceMap.put("employeeDesignationLocalService", employeeDesignationLocalService);
            serviceMap.put("leaveStatusLocalService", leaveStatusLocalService);
            serviceMap.put("employeeDetailsLocalService", employeeDetailsLocalService);
            serviceMap.put("workFromHomeDayTypeLocalService", workFromHomeDayTypeLocalService);

            long currentUserId = themeDisplay.getUserId();
            String fromName = PrefsPropsUtil.getString(themeDisplay.getCompanyId(), PropsKeys.ADMIN_EMAIL_FROM_NAME);
            String fromEmailAddress = PrefsPropsUtil.getString(themeDisplay.getCompanyId(),
                    PropsKeys.ADMIN_EMAIL_FROM_ADDRESS);
            StringBuilder employeeMailBody = new StringBuilder(AxHrmsWorkFromHomePortletKeys.WFH_REQUEST_MAIL_HEAD_v2);
            EmployeeDetails employeeDetails = employeeDetailsLocalService.findByLrUserId(currentUserId);
            wfh.setReviewerId(employeeDetails.getEmployeeId());
            wfh.setModifiedBy(currentUserId);
            workFromHomeRequestLocalService.updateWorkFromHomeRequest(wfh);
            EmployeeDetails employeeDetails1 = employeeDetailsLocalService.findByEmployeeId(wfh.getEmployeeId());
            EmployeeDetails manager = employeeDetailsLocalService.fetchEmployeeDetails(employeeDetails1.getManagerId());
            StringBuilder managerMailBody =new StringBuilder(AxHrmsWorkFromHomePortletKeys.WFH_REQUEST_MAIL_HEAD_v2);
            EmployeeDetails cancelEmployeeDetails = employeeDetailsLocalService.findByLrUserId(currentUserId);
            String employeeCanceledNotification =notificationTemplateConfiguration.WFHRequestCanceledNotificationToEmployee();

            WFHStatusUtil.sendMailtoManager(fromName,fromEmailAddress,employeeMailBody,wfh,employeeDetails1,mailTemplateConfiguration,employeeDetailsLocalService,axHrmsCommonApi,serviceMap,false,true, userComment);
            if (manager != null && manager.getEmployeeId() != cancelEmployeeDetails.getEmployeeId()) {

                WFHStatusUtil.sendMailtoManager(fromName, fromEmailAddress, managerMailBody, wfh, manager, mailTemplateConfiguration, employeeDetailsLocalService, axHrmsCommonApi, serviceMap, false, true, userComment);
                WFHStatusUtil.sendNotificationToEmployee(employeeCanceledNotification, manager);

            }

            WFHStatusUtil.sendNotificationToEmployee(employeeCanceledNotification, employeeDetails1);

            String roleName = "HR Admin";
            Role role = RoleLocalServiceUtil.fetchRole(themeDisplay.getCompanyId(), roleName);
            List<User> users = UserLocalServiceUtil.getRoleUsers(role.getRoleId());
            for (User user : users) {
                if (user.getUserId() == currentUserId) {
                    continue;
                }
                try {
                    StringBuilder hrMailBody =
                            new StringBuilder(AxHrmsWorkFromHomePortletKeys.WFH_REQUEST_MAIL_HEAD_v2);
                    log.info("User: " + user.getFullName() + " | Email: " + user.getEmailAddress() + "  ,,,,, " + user.getUserId());
                    EmployeeDetails HremployeeDetails = employeeDetailsLocalService.findByLrUserId(user.getUserId());
                    log.info("Employee Id: " + HremployeeDetails.toString());
                    WFHStatusUtil.sendNotificationToEmployee(employeeCanceledNotification, HremployeeDetails);
                    WFHStatusUtil.sendMailtoManager(fromName, fromEmailAddress, hrMailBody, wfh, HremployeeDetails, mailTemplateConfiguration, employeeDetailsLocalService, axHrmsCommonApi, serviceMap, false, true, userComment);
                } catch (Exception e) {
                    log.error("Error while sending notification to manager: " + e.getMessage());
                }
                }
            response.sendRedirect(PortalUtil.getLayoutFullURL(themeDisplay));

            SessionMessages.add(request, "wfhCancelled");

        } catch (Exception e) {
            SessionErrors.add(request, "cancelError");
        }

        return true;
    }
}
