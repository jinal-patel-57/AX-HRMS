package com.ax.hrms.leave.management.manager.web.action;

import com.ax.hrms.common.api.api.AxHrmsCommonApi;
import com.ax.hrms.leave.management.hr.web.util.AxHrmsHrLeaveRequestWebUtil;
import com.ax.hrms.leave.management.web.constants.AxHrmsHrLeaveManagementSystemWebPortletConstants;
import com.ax.hrms.leave.management.web.constants.AxHrmsLeaveManagementSystemWebPortletKeys;
import com.ax.hrms.mail.template.config.configuration.MailTemplateConfiguration;
import com.ax.hrms.master.model.LeaveCompensatoryStatusMaster;
import com.ax.hrms.master.service.DepartmentMasterLocalService;
import com.ax.hrms.master.service.DesignationMasterLocalService;
import com.ax.hrms.master.service.LeaveCompensatoryStatusMasterLocalService;
import com.ax.hrms.master.service.LeaveTypeMasterLocalService;
import com.ax.hrms.model.EmployeeDetails;
import com.ax.hrms.model.LeaveRequest;
import com.ax.hrms.notification.template.config.configuration.NotificationTemplateConfiguration;
import com.ax.hrms.service.*;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.*;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import java.io.IOException;
import java.time.LocalDate;

@Component(
        immediate = true,
        property = {
                "javax.portlet.name=" + AxHrmsLeaveManagementSystemWebPortletKeys.AXHRMS_MANAGER_LEAVE_MANAGEMENT_SYSTEM_WEB_PORTLET,
                "mvc.command.name=" + AxHrmsHrLeaveManagementSystemWebPortletConstants.REJECT_CANCEL_LEAVE_REQUEST
        },
        service = MVCActionCommand.class
)
public class RejectCancelLeaveRequestMVCActionCommand extends BaseMVCActionCommand {

    private static final Log log = LogFactoryUtil.getLog(RejectCancelLeaveRequestMVCActionCommand.class);

    @Reference
    private LeaveTypeMasterLocalService leaveTypeMasterLocalService;

    @Reference
    private NotificationTemplateConfiguration notificationTemplateConfiguration;

    @Reference
    private LeaveRequestLocalService leaveRequestLocalService;

    @Reference
    private LeaveCompensatoryStatusMasterLocalService leaveStatusLocalService;

    @Reference
    private LeaveBalanceLocalService leaveBalanceLocalService;

    @Reference
    private LeaveDayTypeLocalService leaveDayTypeLocalService;

    @Reference
    private AxHrmsCommonApi axHrmsCommonApi;

    @Reference
    private EmployeeDetailsLocalService employeeDetailsLocalService;

    @Reference
    private DepartmentMasterLocalService departmentMasterLocalService;

    @Reference
    private DesignationMasterLocalService designationMasterLocalService;

    @Reference
    private EmployeeDepartmentLocalService employeeDepartmentLocalService;

    @Reference
    LeaveCompensatoryStatusMasterLocalService leaveCompensatoryStatusMasterLocalService;

    @Reference
    private EmployeeDesignationLocalService employeeDesignationLocalService;

    @Reference
    private AxHrmsHrLeaveRequestWebUtil leaveRequestWebUtil;

    @Reference
    private MailTemplateConfiguration mailTemplateConfiguration;

    @Override
    protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws PortalException, IOException {

        super.hideDefaultErrorMessage(actionRequest);
        super.hideDefaultSuccessMessage(actionRequest);
        boolean status=false;
        ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
        try {

            Long leaveRequestId = ParamUtil.getLong(actionRequest,
                    AxHrmsHrLeaveManagementSystemWebPortletConstants.LEAVE_REQUEST_ID);
            log.info("RejectCancelLeaveRequestMVCActionCommand doProcessAction   "+leaveRequestId);
            long cancelId = ParamUtil.getLong(actionRequest,
                    AxHrmsHrLeaveManagementSystemWebPortletConstants.CANCELLED_ID);
            long rejectedId = ParamUtil.getLong(actionRequest,
                    AxHrmsHrLeaveManagementSystemWebPortletConstants.REJECTED_ID);
            String fromName = PrefsPropsUtil.getString(themeDisplay.getCompanyId(), PropsKeys.ADMIN_EMAIL_FROM_NAME);
            String fromEmailAddress = PrefsPropsUtil.getString(themeDisplay.getCompanyId(),
                    PropsKeys.ADMIN_EMAIL_FROM_ADDRESS);

            LeaveRequest leaveRequest = leaveRequestLocalService.findByleaveRequestId(leaveRequestId);
            EmployeeDetails employee = employeeDetailsLocalService.getEmployeeDetails(leaveRequest.getEmployeeId());

            long previousStatusId = leaveRequest.getLeaveCompensatoryStatusMasterId();
            boolean isCancelled;

            if (Validator.isNotNull(cancelId)) {
                isCancelled = true;
                leaveRequest.setLeaveCompensatoryStatusMasterId(cancelId);
                SessionMessages.add(actionRequest,
                        AxHrmsHrLeaveManagementSystemWebPortletConstants.LEAVE_REQUEST_CANCELLED);

            } else {
                isCancelled = false;
                leaveRequest.setLeaveCompensatoryStatusMasterId(rejectedId);
                SessionMessages.add(actionRequest,
                        AxHrmsHrLeaveManagementSystemWebPortletConstants.LEAVE_REQUEST_REJECTED);

            }

            leaveRequest.setHrApprovalId(employeeDetailsLocalService.findByLrUserId(themeDisplay.getUserId()).getEmployeeId());
            leaveRequest.setManagerApprovalId(employeeDetailsLocalService.findByLrUserId(themeDisplay.getUserId()).getEmployeeId());
            leaveRequestLocalService.updateLeaveRequest(leaveRequest);

            LeaveCompensatoryStatusMaster leaveStatusMasterOfRejected = leaveCompensatoryStatusMasterLocalService
                    .findByLeaveCompensatoryStatusName(AxHrmsHrLeaveManagementSystemWebPortletConstants.REJECTED);

            if (previousStatusId != leaveStatusMasterOfRejected.getLeaveCompensatoryStatusMasterId()) {

                LocalDate currentDate = LocalDate.now();
                int currentYear = currentDate.getYear();
                long employeeId = leaveRequest.getEmployeeId();
                long leaveTypeMasterId = leaveRequest.getLeaveTypeMasterId();
                double totalDays = 0;

                // Counting Days on date wise .......

                totalDays = leaveRequestWebUtil.countLeaveDays(leaveRequestId, totalDays);

                // Update the Leave Balance

                leaveRequestWebUtil.updateLeaveBalance(currentYear, employeeId, leaveTypeMasterId, totalDays);
                status=true;
                // DECIDING SUBJECT  FOR CANCEL AND REJECT
                String subject;
                log.info("above notification ok...............");
                if (leaveRequest.getLeaveCompensatoryStatusMasterId() == leaveStatusMasterOfRejected
                        .getLeaveCompensatoryStatusMasterId() ) {
                    log.info("inside the reject ");
                    subject = notificationTemplateConfiguration.leaveRejectedNotificationToEmployee();
                } else {

                    log.info("inside the cancel ");
                    subject =notificationTemplateConfiguration.leaveCancelledNotificationToEmployee();

                }


                // SEND MAIL TO EMPLOYEE

                StringBuilder employeeMailBody = new StringBuilder(
                        AxHrmsHrLeaveManagementSystemWebPortletConstants.LEAVE_REQUEST_MAIL_HEAD);
                leaveRequestWebUtil.sendMailtoEmployee(fromName, fromEmailAddress, leaveRequestId,
                        employeeMailBody,mailTemplateConfiguration,false,isCancelled);

                // SEND NOTITIFCATION TO EMPLOYEE
                leaveRequestWebUtil.sendNotificationToEmployee(subject, employee);

            }

           if(status==false) {
               String subject;
               if (leaveRequest.getLeaveCompensatoryStatusMasterId() == leaveStatusMasterOfRejected
                       .getLeaveCompensatoryStatusMasterId()) {
                   log.info("inside the reject ");
                   subject = notificationTemplateConfiguration.leaveRejectedNotificationToEmployee();
               } else {

                   log.info("inside the cancel ");
                   subject = notificationTemplateConfiguration.leaveCancelledNotificationToEmployee();

               }

               leaveRequestWebUtil.sendNotificationToEmployee(subject, employee);
           }
//            // Fetch leaveId safely
//            long leaveId = ParamUtil.getLong(actionRequest, "leaveId");
//            LeaveRequest leaveRequest = leaveRequestLocalService.fetchLeaveRequest(leaveId);
//
//            if (leaveRequest == null) {
//                SessionErrors.add(actionRequest, "leave-error");
//                return;
//            }
//
//            ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
//            EmployeeDetails employee = employeeDetailsLocalService.getEmployeeDetails(leaveRequest.getEmployeeId());
//
//            // Fetch all statuses
//            List<LeaveCompensatoryStatusMaster> statusList = leaveStatusLocalService.getLeaveCompensatoryStatusMasters(-1, -1);
//            long cancelId = 0L, rejectedId = 0L;
//            for (LeaveCompensatoryStatusMaster status : statusList) {
//                if ("Cancelled".equalsIgnoreCase(status.getLeaveCompensatoryStatus())) {
//                    cancelId = status.getLeaveCompensatoryStatusMasterId();
//                }
//                if ("Rejected".equalsIgnoreCase(status.getLeaveCompensatoryStatus())) {
//                    rejectedId = status.getLeaveCompensatoryStatusMasterId();
//                }
//            }
//
//            long previousStatusId = leaveRequest.getLeaveCompensatoryStatusMasterId();
//            boolean isCancelled;
//
//            // Determine action
//            if (ParamUtil.getBoolean(actionRequest, "cancel") && cancelId > 0) {
//                isCancelled = true;
//                leaveRequest.setLeaveCompensatoryStatusMasterId(cancelId);
//                SessionMessages.add(actionRequest, AxHrmsHrLeaveManagementSystemWebPortletConstants.LEAVE_REQUEST_CANCELLED);
//            } else if (ParamUtil.getBoolean(actionRequest, "reject") && rejectedId > 0) {
//                isCancelled = false;
//                leaveRequest.setLeaveCompensatoryStatusMasterId(rejectedId);
//                SessionMessages.add(actionRequest, AxHrmsHrLeaveManagementSystemWebPortletConstants.LEAVE_REQUEST_REJECTED);
//            } else {
//                SessionErrors.add(actionRequest, "invalidAction");
//                return;
//            }
//
//            // Update HR & Manager approval
//            long currentEmpId = employeeDetailsLocalService.findByLrUserId(themeDisplay.getUserId()).getEmployeeId();
//            leaveRequest.setHrApprovalId(currentEmpId);
//            leaveRequest.setManagerApprovalId(currentEmpId);
//
//            leaveRequestLocalService.updateLeaveRequest(leaveRequest);
//
//            // Refund leave balance only if previous status was Approved or Pending
//            LeaveCompensatoryStatusMaster previousStatus = leaveStatusLocalService.fetchLeaveCompensatoryStatusMaster(previousStatusId);
//            if (previousStatus != null) {
//                String prevStatusName = previousStatus.getLeaveCompensatoryStatus();
//                if ("Approved".equalsIgnoreCase(prevStatusName) || "Pending".equalsIgnoreCase(prevStatusName)) {
//                    double totalDays = leaveRequestWebUtil.countLeaveDays(leaveId, 0);
//                    leaveRequestWebUtil.updateLeaveBalance(
//                            LocalDate.now().getYear(),
//                            leaveRequest.getEmployeeId(),
//                            leaveRequest.getLeaveTypeMasterId(),
//                            totalDays
//                    );
//                }
//            }
//
//            // Send notifications
//            String subject = isCancelled ?
//                    notificationTemplateConfiguration.leaveCancelledNotificationToEmployee() :
//                    notificationTemplateConfiguration.leaveRejectedNotificationToEmployee();
//
//            try {
//                String fromName = PrefsPropsUtil.getString(themeDisplay.getCompanyId(), PropsKeys.ADMIN_EMAIL_FROM_NAME);
//                String fromEmailAddress = PrefsPropsUtil.getString(themeDisplay.getCompanyId(), PropsKeys.ADMIN_EMAIL_FROM_ADDRESS);
//
//                leaveRequestWebUtil.sendMailtoEmployee(fromName, fromEmailAddress, leaveId,
//                        new StringBuilder(), mailTemplateConfiguration, false, isCancelled);
//
//                leaveRequestWebUtil.sendNotificationToEmployee(subject, employee);
            } catch (Exception ex) {
                log.error("Failed to send email/notification for leaveId=", ex);
            }
        actionResponse.sendRedirect(PortalUtil.getLayoutFullURL(themeDisplay));

    }
}
