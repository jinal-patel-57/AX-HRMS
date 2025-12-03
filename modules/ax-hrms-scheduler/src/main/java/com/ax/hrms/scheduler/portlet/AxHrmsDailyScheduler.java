package com.ax.hrms.scheduler.portlet;


import com.ax.hrms.anniversary.web.constants.AxHrmsAnniversaryWebPortletConstants;
import com.ax.hrms.anniversary.web.util.AnniversaryUtil;
import com.ax.hrms.birthday.web.scheduler.AxHrmsBirthdayJobScheduler;
import com.ax.hrms.birthday.web.util.BirthdayWebUtil;
import com.ax.hrms.common.api.api.AxHrmsCommonApi;
import com.ax.hrms.constants.AxHrmsBirthdayWebPortletConstants;
import com.ax.hrms.mail.template.config.configuration.MailTemplateConfiguration;
import com.ax.hrms.master.model.TemplateLevelMaster;
import com.ax.hrms.master.service.DepartmentMasterLocalService;
import com.ax.hrms.master.service.DesignationMasterLocalService;
import com.ax.hrms.master.service.LeavePolicyMasterLocalService;
import com.ax.hrms.master.service.LeaveTypeMasterLocalService;
import com.ax.hrms.master.service.TemplateLevelMasterLocalService;
import com.ax.hrms.master.service.WishTypeMasterLocalService;
import com.ax.hrms.model.AppraisalEvaluationFormStatus;
import com.ax.hrms.model.EmployeeDetails;
import com.ax.hrms.model.PipProgram;
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

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Component(
        property = {
                "dispatch.task.executor.name=Ax Hrms Daily Scheduler", "dispatch.task.executor.type=Ax Hrms Daily Scheduler"
        },
        service = DispatchTaskExecutor.class
)
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
			sendMailForPendingAppraisalEvaluation();
	        sendNotificationAndMailToHrForPipMeetings();
			sendMailAndNotificationToHrForBirthdayWishes(fromName, fromEmailAddress,group.getCompanyId());
			sendMailAndNotificationToHrForAnniversaryWishes(group, group.getGroupId(),
					group.getCreatorUserId(), group.getCompanyId());
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
            if (
                    cal2.get(Calendar.YEAR) == cal.get(Calendar.YEAR) &&
                            cal2.get(Calendar.MONTH) == cal.get(Calendar.MONTH) &&
                            cal2.get(Calendar.DATE) == cal.get(Calendar.DATE)) {
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
            EmployeeDetails apprisee = employeeDetailsLocalService.getEmployeeDetails(
                    appraisalReminderLocalService.findByAppraisalProcessId(appraisalEvaluationFormStatus.getAppraisalProcessId()).getEmployeeId());
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
            axHrmsCommonApi.sendMail(
                    hrAdmin.getEmailAddress(),
                    fromEmailAddress,
                    fromName,
                    "PENDING APPRAISAL FORMS!",
                    htmlBuilder.toString()
            );
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

                        UserNotificationEvent userNotificationEvent = UserNotificationEventLocalServiceUtil.sendUserNotificationEvents(
                                hrAdmin.getUserId(), AxHrmsSchedulerPortletKeys.AXHRMSSCHEDULER,
                                UserNotificationDeliveryConstants.TYPE_WEBSITE, notificationJSON);
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
            axHrmsCommonApi.sendMail(
                    hrAdmin.getEmailAddress(),
                    fromEmailAddress,
                    fromName,
                    "UPCOMING PIP PROGRAM MEETINGS",
                    htmlBuilder.toString()
            );

        }


    }
    private void sendMailAndNotificationToHrForBirthdayWishes(String fromName, String fromEmailAddress,long companyId)
			throws Exception {
		StringBuilder body = new StringBuilder(AxHrmsBirthdayWebPortletConstants.HR_BIRTHDAY_REMMINDER_MAIL_HEAD);

		BirthdayWebUtil birthdayWebUtil = new BirthdayWebUtil(employeeDetailsLocalService,
				employeeDepartmentLocalService, employeeDesignationLocalService, departmentMasterLocalService,
				designationMasterLocalService, wishTypeMasterLocalService);

		birthdayWebUtil.sendMailAndNotificationToHr(fromName, fromEmailAddress, body,
				axHrmsCommonApi,companyId,mailTemplateConfiguration,notificationTemplateConfiguration);

	}

	private void sendMailAndNotificationToHrForAnniversaryWishes(Group group, long groupId,
			long userId, long companyId) throws Exception {
		StringBuilder body = new StringBuilder(AxHrmsAnniversaryWebPortletConstants.ANNIVERSARY_REMMINDER_MAIL_HEAD);

		AnniversaryUtil anniversaryEmployeeRetrieverUtil = new AnniversaryUtil(employeeDetailsLocalService,axHrmsCommonApi,leaveBalanceLocalService,leavePolicyMasterLocalService,leaveTypeMasterLocalService,designationMasterLocalService,departmentMasterLocalService);

		anniversaryEmployeeRetrieverUtil.sendMailAndNotificationToHr(group,body,employeeDepartmentLocalService,employeeDesignationLocalService,mailTemplateConfiguration,notificationTemplateConfiguration);
		anniversaryEmployeeRetrieverUtil.addLoyaltyLeave(anniversaryEmployeeRetrieverUtil.getAnniversaryEmployee(employeeDetailsLocalService.getEmployeeDetailses(-1,-1)),groupId,userId,companyId);
	}

}
