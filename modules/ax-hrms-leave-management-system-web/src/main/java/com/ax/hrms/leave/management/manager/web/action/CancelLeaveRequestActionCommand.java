//package com.ax.hrms.leave.management.manager.web.action;
//
//import com.ax.hrms.leave.management.web.constants.AxHrmsLeaveManagementSystemWebPortletKeys;
//import com.ax.hrms.master.model.LeaveCompensatoryStatusMaster;
//import com.ax.hrms.master.service.LeaveCompensatoryStatusMasterLocalService;
//import com.ax.hrms.model.LeaveRequest;
//import com.ax.hrms.service.LeaveRequestLocalService;
//import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
//import com.liferay.portal.kernel.servlet.SessionErrors;
//import com.liferay.portal.kernel.servlet.SessionMessages;
//import org.osgi.service.component.annotations.Component;
//import org.osgi.service.component.annotations.Reference;
//
//import javax.portlet.ActionRequest;
//import javax.portlet.ActionResponse;
//import javax.portlet.PortletException;
//import java.util.List;
//
//@Component(property = {"javax.portlet.name=" + AxHrmsLeaveManagementSystemWebPortletKeys.AXHRMS_MANAGER_LEAVE_MANAGEMENT_SYSTEM_WEB_PORTLET, "mvc.command.name=/leave/cancel"}, service = MVCActionCommand.class)
//public class CancelLeaveRequestActionCommand implements MVCActionCommand {
//
//    @Reference
//    private LeaveRequestLocalService leaveRequestLocalService;
//
//    @Reference
//    private LeaveCompensatoryStatusMasterLocalService leaveStatusLocalService;
//
//    @Override
//    public boolean processAction(ActionRequest request, ActionResponse response) throws PortletException {
//
//        try {
//            long leaveId = Long.parseLong(request.getParameter("leaveId"));
//
//            LeaveRequest leave = leaveRequestLocalService.fetchLeaveRequest(leaveId);
//
//            if (leave == null) {
//                SessionErrors.add(request, "leaveNotFound");
//                return false;
//            }
//
//            // Fetch all statuses from master table
//            List<LeaveCompensatoryStatusMaster> statusList = leaveStatusLocalService.getLeaveCompensatoryStatusMasters(-1, -1);
//
//            // Find CANCELLED status ID
//            long cancelledId = statusList.stream().filter(s -> "Canceled".equalsIgnoreCase(s.getLeaveCompensatoryStatus())).map(s -> s.getLeaveCompensatoryStatusMasterId()) // simple mapping
//                    .findFirst().orElse(0L);
//
//            if (cancelledId == 0) {
//                SessionErrors.add(request, "statusNotFound");
//                return false;
//            }
//
//            // Update leave request status
//            leave.setLeaveCompensatoryStatusMasterId(cancelledId);
//            leaveRequestLocalService.updateLeaveRequest(leave);
//
//            SessionMessages.add(request, "leaveCancelled");
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            SessionErrors.add(request, "cancelError");
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

import com.ax.hrms.leave.management.manager.web.util.AxHrmsManagerLeaveRequestWebUtil;
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
                "mvc.command.name=/leave/cancel"
        },
        service = MVCActionCommand.class
)
public class CancelLeaveRequestActionCommand implements MVCActionCommand {

    private static final Log log = LogFactoryUtil.getLog(CancelLeaveRequestActionCommand.class);

    @Reference
    private LeaveRequestLocalService leaveRequestLocalService;

    @Reference
    private LeaveCompensatoryStatusMasterLocalService leaveStatusLocalService;

    @Reference
    private EmployeeDetailsLocalService employeeDetailsLocalService;

    @Reference
    private AxHrmsManagerLeaveRequestWebUtil leaveRequestWebUtil;

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
                SessionErrors.add(actionRequest, "leaveNotFound");
                return false;
            }

            // Fetch CANCELLED status ID
            long cancelledId = leaveRequestWebUtil.getLeaveStatusId("Canceled");
            if (cancelledId == 0) {
                SessionErrors.add(actionRequest, "statusNotFound");
                return false;
            }

            ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
            long currentUserEmpId = employeeDetailsLocalService.findByLrUserId(themeDisplay.getUserId())
                    .getEmployeeId();

            // Update HR & Manager approval
            leave.setHrApprovalId(currentUserEmpId);
            leave.setManagerApprovalId(currentUserEmpId);

            long previousStatusId = leave.getLeaveCompensatoryStatusMasterId();

            // Update leave to CANCELLED
            leave.setLeaveCompensatoryStatusMasterId(cancelledId);
            leaveRequestLocalService.updateLeaveRequest(leave);

            // Update leave balance if previous status was not cancelled
            if (previousStatusId != cancelledId) {
                LocalDate currentDate = LocalDate.now();
                int currentYear = currentDate.getYear();
                double totalDays = leaveRequestWebUtil.countLeaveDays(leaveId, 0);
                leaveRequestWebUtil.updateLeaveBalance(currentYear, leave.getEmployeeId(),
                        leave.getLeaveTypeMasterId(), totalDays);
            }

            // Success message
            SessionMessages.add(actionRequest, "leaveCancelled");

            // Send email & notification to employee
            EmployeeDetails employee = employeeDetailsLocalService.getEmployeeDetails(leave.getEmployeeId());
            String fromName = PrefsPropsUtil.getString(themeDisplay.getCompanyId(), PropsKeys.ADMIN_EMAIL_FROM_NAME);
            String fromEmailAddress = PrefsPropsUtil.getString(themeDisplay.getCompanyId(),
                    PropsKeys.ADMIN_EMAIL_FROM_ADDRESS);

            leaveRequestWebUtil.sendMailtoEmployee(fromName, fromEmailAddress, leaveId,
                    new StringBuilder(), mailTemplateConfiguration, false, true);

            leaveRequestWebUtil.sendNotificationToEmployee("Your leave request has been cancelled", employee);

        } catch (Exception e) {
            log.error("CancelLeaveRequestActionCommand >>> " + e.getMessage(), e);
            SessionErrors.add(actionRequest, "cancelError");
        }

        return true;
    }
}
