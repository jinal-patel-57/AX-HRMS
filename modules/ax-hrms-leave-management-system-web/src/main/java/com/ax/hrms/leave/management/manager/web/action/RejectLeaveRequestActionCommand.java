//package com.ax.hrms.leave.management.manager.web.action;
//
//
//import com.ax.hrms.model.LeaveRequest;
//import com.ax.hrms.service.LeaveRequestLocalService;
//import com.ax.hrms.master.model.LeaveCompensatoryStatusMaster;
//import com.ax.hrms.master.service.LeaveCompensatoryStatusMasterLocalService;
//import com.ax.hrms.leave.management.web.constants.AxHrmsLeaveManagementSystemWebPortletKeys;
//import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
//import com.liferay.portal.kernel.servlet.SessionMessages;
//import com.liferay.portal.kernel.servlet.SessionErrors;
//import com.liferay.portal.kernel.util.ParamUtil;
//
//import javax.portlet.ActionRequest;
//import javax.portlet.ActionResponse;
//import javax.portlet.PortletException;
//
//import org.osgi.service.component.annotations.Component;
//import org.osgi.service.component.annotations.Reference;
//
//@Component(
//        immediate = true,
//        property = {
//                "javax.portlet.name=" + AxHrmsLeaveManagementSystemWebPortletKeys.AXHRMS_MANAGER_LEAVE_MANAGEMENT_SYSTEM_WEB_PORTLET,
//                "mvc.command.name=/leave/reject"
//        },
//        service = MVCActionCommand.class
//)
//public class RejectLeaveRequestActionCommand implements MVCActionCommand {
//
//    @Reference
//    private LeaveRequestLocalService leaveRequestLocalService;
//
//    @Reference
//    private LeaveCompensatoryStatusMasterLocalService leaveStatusLocalService;
//
//    @Override
//    public boolean processAction(ActionRequest actionRequest, ActionResponse actionResponse)
//            throws PortletException {
//
//        try {
//            long leaveId = ParamUtil.getLong(actionRequest, "leaveId");
//
//            LeaveRequest leave = leaveRequestLocalService.fetchLeaveRequest(leaveId);
//
//            if (leave == null) {
//                SessionErrors.add(actionRequest, "leave-error");
//                return false;
//            }
//
//            // Fetch all statuses from master table
//            java.util.List<LeaveCompensatoryStatusMaster> statusList =
//                    leaveStatusLocalService.getLeaveCompensatoryStatusMasters(-1, -1);
//
//            // Find REJECTED status ID
//            long rejectedId = statusList.stream()
//                    .filter(s -> "Rejected".equalsIgnoreCase(s.getLeaveCompensatoryStatus()))
//                    .map(s -> s.getLeaveCompensatoryStatusMasterId()) // simple stream mapping
//                    .findFirst()
//                    .orElse(0L);
//
//            if (rejectedId == 0) {
//                SessionErrors.add(actionRequest, "leave-error");
//                return false;
//            }
//
//            // Update the status
//            leave.setLeaveCompensatoryStatusMasterId(rejectedId);
//            leaveRequestLocalService.updateLeaveRequest(leave);
//
//            // Success message
//            SessionMessages.add(actionRequest, "leave-rejected");
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            SessionErrors.add(actionRequest, "leave-error");
//        }
//
//        return true;
//    }
//}





























package com.ax.hrms.leave.management.manager.web.action;

import java.time.LocalDate;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.ax.hrms.leave.management.hr.web.util.AxHrmsHrLeaveRequestWebUtil;
import com.ax.hrms.mail.template.config.configuration.MailTemplateConfiguration;
import com.ax.hrms.master.model.LeaveCompensatoryStatusMaster;
import com.ax.hrms.master.service.LeaveCompensatoryStatusMasterLocalService;
import com.ax.hrms.model.EmployeeDetails;
import com.ax.hrms.model.LeaveRequest;
import com.ax.hrms.service.EmployeeDetailsLocalService;
import com.ax.hrms.service.LeaveRequestLocalService;
import com.ax.hrms.leave.management.web.constants.AxHrmsLeaveManagementSystemWebPortletKeys;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PrefsPropsUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.util.Validator;

@Component(
        immediate = true,
        property = {
                "javax.portlet.name=" + AxHrmsLeaveManagementSystemWebPortletKeys.AXHRMS_MANAGER_LEAVE_MANAGEMENT_SYSTEM_WEB_PORTLET,
                "mvc.command.name=/leave/reject"
        },
        service = MVCActionCommand.class
)
public class RejectLeaveRequestActionCommand implements MVCActionCommand {

    private static final Log log = LogFactoryUtil.getLog(RejectLeaveRequestActionCommand.class);

    @Reference
    private LeaveRequestLocalService leaveRequestLocalService;

    @Reference
    private LeaveCompensatoryStatusMasterLocalService leaveStatusLocalService;

    @Reference
    private EmployeeDetailsLocalService employeeDetailsLocalService;

    @Reference
    private AxHrmsHrLeaveRequestWebUtil leaveRequestWebUtil;

    @Reference
    private MailTemplateConfiguration mailTemplateConfiguration;

    @Override
    public boolean processAction(ActionRequest actionRequest, ActionResponse actionResponse)
            throws PortletException {

        try {
            // Get leave request ID
            long leaveId = ParamUtil.getLong(actionRequest, "leaveId");
            LeaveRequest leave = leaveRequestLocalService.fetchLeaveRequest(leaveId);

            if (leave == null) {
                SessionErrors.add(actionRequest, "leave-error");
                return false;
            }

            // Fetch REJECTED status ID
            long rejectedId = leaveRequestWebUtil.getLeaveStatusId("Rejected");
            if (rejectedId == 0) {
                SessionErrors.add(actionRequest, "leave-error");
                return false;
            }

            ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
            long currentUserEmpId = employeeDetailsLocalService.findByLrUserId(themeDisplay.getUserId())
                    .getEmployeeId();

            // Update HR & Manager approval
            leave.setHrApprovalId(currentUserEmpId);
            leave.setManagerApprovalId(currentUserEmpId);

            long previousStatusId = leave.getLeaveCompensatoryStatusMasterId();

            // Update leave to REJECTED
            leave.setLeaveCompensatoryStatusMasterId(rejectedId);
            leaveRequestLocalService.updateLeaveRequest(leave);

            // Update leave balance if status changed
            if (previousStatusId != rejectedId) {
                LocalDate currentDate = LocalDate.now();
                int currentYear = currentDate.getYear();
                double totalDays = leaveRequestWebUtil.countLeaveDays(leaveId, 0);
                leaveRequestWebUtil.updateLeaveBalance(currentYear, leave.getEmployeeId(),
                        leave.getLeaveTypeMasterId(), totalDays);
            }

            // Send success message
            SessionMessages.add(actionRequest, "leave-rejected");

            // Send email & notification to employee
            EmployeeDetails employee = employeeDetailsLocalService.getEmployeeDetails(leave.getEmployeeId());
            String fromName = PrefsPropsUtil.getString(themeDisplay.getCompanyId(), PropsKeys.ADMIN_EMAIL_FROM_NAME);
            String fromEmailAddress = PrefsPropsUtil.getString(themeDisplay.getCompanyId(),
                    PropsKeys.ADMIN_EMAIL_FROM_ADDRESS);

            leaveRequestWebUtil.sendMailtoEmployee(fromName, fromEmailAddress, leaveId,
                    new StringBuilder(), mailTemplateConfiguration, false, false);

            leaveRequestWebUtil.sendNotificationToEmployee("Your leave request has been rejected", employee);

        } catch (Exception e) {
            log.error("RejectLeaveRequestActionCommand >>> " + e.getMessage(), e);
            SessionErrors.add(actionRequest, "leave-error");
        }

        return true;
    }
}
