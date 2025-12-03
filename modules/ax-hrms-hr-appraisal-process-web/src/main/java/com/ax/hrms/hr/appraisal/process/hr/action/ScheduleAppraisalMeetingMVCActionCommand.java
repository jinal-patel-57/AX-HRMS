package com.ax.hrms.hr.appraisal.process.hr.action;


import com.ax.hrms.common.api.api.AxHrmsCommonApi;
import com.ax.hrms.hr.appraisal.process.constants.AxHrmsHrAppraisalProcessHrConstants;
import com.ax.hrms.hr.appraisal.process.constants.AxHrmsHrAppraisalProcessPortletKeys;
import com.ax.hrms.mail.template.config.configuration.MailTemplateConfiguration;
import com.ax.hrms.model.AppraisalMeeting;
import com.ax.hrms.model.AppraisalMeetingInvitees;
import com.ax.hrms.model.AppraisalProcess;
import com.ax.hrms.model.EmployeeDetails;
import com.ax.hrms.service.*;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.GroupLocalServiceUtil;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.*;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;


/**
 * Author: Nivid Koradiya
 */
@Component(
        property = {
                "javax.portlet.name=" + AxHrmsHrAppraisalProcessPortletKeys.AX_HRMS_HR_APPRAISAL_PROCESS_WEB_PORTLET,
                "mvc.command.name=/scheduleAppraisalMeeting"
        },
        service = MVCActionCommand.class
)
public class ScheduleAppraisalMeetingMVCActionCommand extends BaseMVCActionCommand {

    Log log = LogFactoryUtil.getLog(ScheduleAppraisalMeetingMVCActionCommand.class);

    @Reference
    MailTemplateConfiguration mailTemplateConfiguration;

    @Reference
    AppraisalFormTemplatesLocalService appraisalFormTemplatesLocalService;

    @Reference
    AppraisalProcessLocalService appraisalProcessLocalService;

    @Reference
    AppraisalReminderLocalService appraisalReminderLocalService;

    @Reference
    AxHrmsCommonApi axHrmsCommonApi;

    @Reference
    AppraisalEvaluationFormStatusLocalService appraisalEvaluationFormStatusLocalService;

    @Reference
    EmployeeDetailsLocalService employeeDetailsLocalService;

    @Reference
    AppraisalMeetingLocalService appraisalMeetingLocalService;

    @Reference
    AppraisalMeetingInviteesLocalService appraisalMeetingInviteesLocalService;

    @Override
    protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {

        long appraisalProcessId = ParamUtil.getLong(actionRequest, AxHrmsHrAppraisalProcessHrConstants.APPRAISAL_PROCESS_ID);
        long meetingId = ParamUtil.getLong(actionRequest, AxHrmsHrAppraisalProcessHrConstants.MEETING_ID);
        String users = ParamUtil.getString(actionRequest, AxHrmsHrAppraisalProcessHrConstants.TEAM_ID);
        DateFormat dateFormat = new SimpleDateFormat(AxHrmsHrAppraisalProcessHrConstants.DATE_FORMAT);
        Date meetingDate = ParamUtil.getDate(actionRequest, AxHrmsHrAppraisalProcessHrConstants.MEETING_DATE, dateFormat);
        Date updateMeetingDate = ParamUtil.getDate(actionRequest, AxHrmsHrAppraisalProcessHrConstants.UPDATE_MEETING_DATE, dateFormat);
        String meetingTime = ParamUtil.getString(actionRequest, AxHrmsHrAppraisalProcessHrConstants.MEETING_TIME);
        String updateMeetingTime = ParamUtil.getString(actionRequest, AxHrmsHrAppraisalProcessHrConstants.UPDATE_MEETING_TIME);

        ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);

        if (meetingId > 0) {
            AppraisalMeeting appraisalMeeting = appraisalMeetingLocalService.getAppraisalMeeting(meetingId);
            String oldDate = new SimpleDateFormat(AxHrmsHrAppraisalProcessHrConstants.DATE_FORMAT_DATE_MONTH_YEAR).format(appraisalMeeting.getMeetingDate());
            String oldTime = new SimpleDateFormat(AxHrmsHrAppraisalProcessHrConstants.TIME_FORMAT).format(appraisalMeeting.getMeetingDate());
            String[] time = updateMeetingTime.split(":");
            updateMeetingDate.setHours(Integer.parseInt(time[0]));
            updateMeetingDate.setMinutes(Integer.parseInt(time[1]));
            appraisalMeeting.setMeetingDate(updateMeetingDate);
            appraisalMeeting.setStatus(false);
            // setting modified by
            appraisalMeeting.setModifiedDate(new Date());
            appraisalMeeting.setModifiedBy(themeDisplay.getUserId());
            appraisalMeetingLocalService.updateAppraisalMeeting(appraisalMeeting);   // un-comment before final test
            List<AppraisalMeetingInvitees> appraisalMeetingInviteesListOld = appraisalMeetingInviteesLocalService.findByAppraisalMeetingId(meetingId);
            List<EmployeeDetails> receivedEmployeeDetails = new ArrayList<>();
            EmployeeDetails appraiseeEmployeeDetails = getApraiseeEmployeeDetailsFromAppraisalProcessId(appraisalProcessId);
            String updatedDateStr = new SimpleDateFormat(AxHrmsHrAppraisalProcessHrConstants.DATE_FORMAT_DATE_MONTH_YEAR).format(updateMeetingDate);

            String[] userStringList = users.split(AxHrmsHrAppraisalProcessHrConstants.COMMA);
            for (String user : userStringList) {
                log.info(user);
                long userId = Long.parseLong(user);
                EmployeeDetails employeeDetails = employeeDetailsLocalService.findByLrUserId(userId);
                receivedEmployeeDetails.add(employeeDetails);
                boolean found = false;
                found = appraisalMeetingInviteesListOld.stream().anyMatch(invitee -> invitee.getEmployeeId() == employeeDetails.getEmployeeId());

                if (!found) {
                    AppraisalMeetingInvitees appraisalMeetingInvitees = appraisalMeetingInviteesLocalService.createAppraisalMeetingInvitees(CounterLocalServiceUtil.increment(AppraisalMeetingInvitees.class.getName()));
                    // audit fields
                    appraisalMeetingInvitees.setCompanyId(themeDisplay.getCompanyId());
                    appraisalMeetingInvitees.setCreatedBy(themeDisplay.getUserId());
                    appraisalMeetingInvitees.setGroupId(themeDisplay.getCompanyGroupId());
                    appraisalMeetingInvitees.setCreateDate(new Date());
                    appraisalMeetingInvitees.setModifiedDate(new Date());

                    appraisalMeetingInvitees.setAppraisalMeetingId(appraisalMeeting.getAppraisalMeetingId());
                    appraisalMeetingInvitees.setEmployeeId(employeeDetails.getEmployeeId());
                    appraisalMeetingInviteesLocalService.addAppraisalMeetingInvitees(appraisalMeetingInvitees);
                    sendMeetingInviteMailToInvitee(appraiseeEmployeeDetails, employeeDetails, updatedDateStr, updateMeetingTime);
                }
            }

            List<AppraisalMeetingInvitees> removedAppraisalMeetingInviteesList = getRemovedAppraiaslMeetingInviteesList(receivedEmployeeDetails, appraisalMeetingInviteesListOld);
            List<AppraisalMeetingInvitees> nonChangedInvitees = getNonChangedAppraisalMeetingInvitees(appraisalMeetingInviteesListOld, removedAppraisalMeetingInviteesList);
            List<EmployeeDetails> newInviteesList = getNewAppraiaslMeetingInviteesList(receivedEmployeeDetails, appraisalMeetingInviteesListOld);


            for (AppraisalMeetingInvitees appraisalMeetingInvitee : removedAppraisalMeetingInviteesList) {
                sendRemovedMeetingMailToInvitee(appraiseeEmployeeDetails, employeeDetailsLocalService.getEmployeeDetails(appraisalMeetingInvitee.getEmployeeId()), oldDate, oldTime);
                appraisalMeetingInviteesLocalService.deleteAppraisalMeetingInvitees(appraisalMeetingInvitee.getAppraisalMeetingInviteeId());
            }

            for (AppraisalMeetingInvitees appraisalMeetingInvitee : nonChangedInvitees) {
                sendUpdatedMeetingInviteMailToInvitee(appraiseeEmployeeDetails, employeeDetailsLocalService.getEmployeeDetails(appraisalMeetingInvitee.getEmployeeId()), updatedDateStr, updateMeetingTime, oldDate, oldTime);
            }

            for (EmployeeDetails employeeDetails : newInviteesList) {
                sendMeetingInviteMailToInvitee(appraiseeEmployeeDetails, employeeDetails, new SimpleDateFormat(AxHrmsHrAppraisalProcessHrConstants.DATE_FORMAT_DATE_MONTH_YEAR).format(updateMeetingDate), updateMeetingTime);
            }

            SessionMessages.add(actionRequest, AxHrmsHrAppraisalProcessHrConstants.MEETING_UPDATED);
        } else {
            // getting appraisal process object
            AppraisalProcess appraisalProcess = appraisalProcessLocalService.getAppraisalProcess(appraisalProcessId);

            // creating a appraisal meeting
            AppraisalMeeting appraisalMeeting = appraisalMeetingLocalService.createAppraisalMeeting(CounterLocalServiceUtil.increment(AppraisalMeeting.class.getName()));

            // audit fields
            appraisalMeeting.setCompanyId(themeDisplay.getCompanyId());
            appraisalMeeting.setCreatedBy(themeDisplay.getUserId());
            appraisalMeeting.setGroupId(themeDisplay.getCompanyGroupId());
            appraisalMeeting.setCreateDate(new Date());
            appraisalMeeting.setModifiedDate(new Date());


            String[] time = meetingTime.split(":");
            meetingDate.setHours(Integer.parseInt(time[0]));
            meetingDate.setMinutes(Integer.parseInt(time[1]));
            // main fields
            appraisalMeeting.setMeetingDate(meetingDate);
            appraisalMeeting.setStatus(false);
            appraisalMeeting.setAppraisalProcessId(appraisalProcess.getAppraisalProcessId());

            appraisalMeetingLocalService.addAppraisalMeeting(appraisalMeeting);
            // appraisal meeting saved END


            // updating the appraisal process
            appraisalProcess.setIsMeetingScheduled(true); // setting the status of meeting as scheduled
            appraisalProcessLocalService.updateAppraisalProcess(appraisalProcess);

            EmployeeDetails apriseeEmployeeDetails = getApraiseeEmployeeDetailsFromAppraisalProcessId(appraisalProcessId);

            users += "," + apriseeEmployeeDetails.getLrUserId(); // adding the self userid to list of invitees.
            String[] userStringList = users.split(AxHrmsHrAppraisalProcessHrConstants.COMMA);
            for (String user : userStringList) {
                log.info(user);
                long userId = Long.parseLong(user);
                EmployeeDetails employeeDetails = employeeDetailsLocalService.findByLrUserId(userId);
                AppraisalMeetingInvitees appraisalMeetingInvitees = appraisalMeetingInviteesLocalService.createAppraisalMeetingInvitees(CounterLocalServiceUtil.increment(AppraisalMeetingInvitees.class.getName()));
                // audit fields
                appraisalMeetingInvitees.setCompanyId(themeDisplay.getCompanyId());
                appraisalMeetingInvitees.setCreatedBy(themeDisplay.getUserId());
                appraisalMeetingInvitees.setGroupId(themeDisplay.getCompanyGroupId());
                appraisalMeetingInvitees.setCreateDate(new Date());
                appraisalMeetingInvitees.setModifiedDate(new Date());

                appraisalMeetingInvitees.setAppraisalMeetingId(appraisalMeeting.getAppraisalMeetingId());
                appraisalMeetingInvitees.setEmployeeId(employeeDetails.getEmployeeId());
                appraisalMeetingInviteesLocalService.addAppraisalMeetingInvitees(appraisalMeetingInvitees);
                sendMeetingInviteMailToInvitee(apriseeEmployeeDetails, employeeDetails, new SimpleDateFormat(AxHrmsHrAppraisalProcessHrConstants.DATE_FORMAT_DATE_MONTH_YEAR).format(meetingDate), meetingTime);
            }
            SessionMessages.add(actionRequest, AxHrmsHrAppraisalProcessHrConstants.MEETING_SCHEDULED);

        }
    }

    private void sendMeetingInviteMailToInvitee(EmployeeDetails appraiseEmployeeDetails, EmployeeDetails inviteeEmployeeDetails, String meetingDate, String meetingTime) {

        String mailBody = mailTemplateConfiguration.appraisalMeetingScheduledBody();
        String mailSubject = mailTemplateConfiguration.appraisalMeetingScheduledSubject();

        mailBody = mailBody.replace("${EMPLOYEE_NAME}", inviteeEmployeeDetails.getFirstName() + " " + appraiseEmployeeDetails.getLastName());
        mailBody = mailBody.replace("${APPRAISE_NAME}", appraiseEmployeeDetails.getFirstName() + " " + appraiseEmployeeDetails.getLastName());
        mailBody = mailBody.replace("${MEETING_DATE}", meetingDate);
            mailBody = mailBody.replace("${MEETING_TIME}", meetingTime);

        Group group = GroupLocalServiceUtil.fetchGroup(PortalUtil.getDefaultCompanyId(), AxHrmsHrAppraisalProcessHrConstants.GUEST);
        String fromName = PrefsPropsUtil.getString(group.getCompanyId(), PropsKeys.ADMIN_EMAIL_FROM_NAME);
        String fromEmailAddress = PrefsPropsUtil.getString(group.getCompanyId(), PropsKeys.ADMIN_EMAIL_FROM_ADDRESS);
        axHrmsCommonApi.sendMail(inviteeEmployeeDetails.getOfficialEmail(), fromEmailAddress, fromName, mailSubject, mailBody);
    }

    private void sendUpdatedMeetingInviteMailToInvitee(EmployeeDetails appraiseEmployeeDetails, EmployeeDetails inviteeEmployeeDetails, String meetingDate, String meetingTime, String oldMeetingDate, String oldMeetingTime) {

        String body=mailTemplateConfiguration.appraisalMeetingUpdatedBody();
        String subject= mailTemplateConfiguration.appraisalMeetingUpdatedSubject();
        body= body.replace("${EMPLOYEE_NAME}",inviteeEmployeeDetails.getFirstName() + " " + appraiseEmployeeDetails.getLastName());
        body= body.replace("${APPRAISEE_NAME}", appraiseEmployeeDetails.getFirstName() + " " + appraiseEmployeeDetails.getLastName()); ;
        body= body.replace("${NEW_DATE}",meetingDate);
        body= body.replace("${NEW_TIME}", meetingTime);
        body= body.replace("${MEETING_DATE}",oldMeetingDate);
        body= body.replace("${MEETING_TIME}",oldMeetingTime);
//        body= body.replace("${}",);
        Group group = GroupLocalServiceUtil.fetchGroup(PortalUtil.getDefaultCompanyId(), AxHrmsHrAppraisalProcessHrConstants.GUEST);
        String fromName = PrefsPropsUtil.getString(group.getCompanyId(), PropsKeys.ADMIN_EMAIL_FROM_NAME);
        String fromEmailAddress = PrefsPropsUtil.getString(group.getCompanyId(), PropsKeys.ADMIN_EMAIL_FROM_ADDRESS);
        axHrmsCommonApi.sendMail(inviteeEmployeeDetails.getOfficialEmail(), fromEmailAddress, fromName, subject, body);
    }

    private void sendRemovedMeetingMailToInvitee(EmployeeDetails appraiseEmployeeDetails, EmployeeDetails inviteeEmployeeDetails, String meetingDate, String meetingTime) {

       String body= mailTemplateConfiguration.appraisalMeetingInvitationCancellationBody();
       String subject = mailTemplateConfiguration.appraisalMeetingInvitationCancellationSubject();

        body = body.replace("${EMPLOYEE_NAME}", inviteeEmployeeDetails.getFirstName() + " " + inviteeEmployeeDetails.getLastName());
        body = body.replace("${APPRAISEE_NAME}", appraiseEmployeeDetails.getFirstName() + " " + appraiseEmployeeDetails.getLastName());
        body = body.replace("${MEETING_DATE}", meetingDate);
        body = body.replace("${MEETING_TIME}",meetingTime);
//        body = body.replace("${}",);
        log.info("SENDING MAIL--->");
        Group group = GroupLocalServiceUtil.fetchGroup(PortalUtil.getDefaultCompanyId(), AxHrmsHrAppraisalProcessHrConstants.GUEST);
        String fromName = PrefsPropsUtil.getString(group.getCompanyId(), PropsKeys.ADMIN_EMAIL_FROM_NAME);
        String fromEmailAddress = PrefsPropsUtil.getString(group.getCompanyId(), PropsKeys.ADMIN_EMAIL_FROM_ADDRESS);
        axHrmsCommonApi.sendMail(inviteeEmployeeDetails.getOfficialEmail(), fromEmailAddress, fromName, subject, body);
    }

    private EmployeeDetails getApraiseeEmployeeDetailsFromAppraisalProcessId(long appraisalProcessId) throws PortalException {
        return employeeDetailsLocalService.getEmployeeDetails(appraisalReminderLocalService.findByAppraisalProcessId(appraisalProcessId).getEmployeeId());
    }

    private List<AppraisalMeetingInvitees> getRemovedAppraiaslMeetingInviteesList(List<EmployeeDetails> receivedEmployeeDetails, List<AppraisalMeetingInvitees> appraisalMeetingInviteesListOld) {
        List<AppraisalMeetingInvitees> removedAppraisalMeetingInviteesList = new ArrayList<>();
        for (AppraisalMeetingInvitees oldInvitee : appraisalMeetingInviteesListOld) {
            boolean found = receivedEmployeeDetails.stream()
                    .anyMatch(receivedEmployee -> receivedEmployee.getEmployeeId() == oldInvitee.getEmployeeId());
            if (!found) {
                removedAppraisalMeetingInviteesList.add(oldInvitee);
            }
        }
        return removedAppraisalMeetingInviteesList;
    }

    private List<EmployeeDetails> getNewAppraiaslMeetingInviteesList(List<EmployeeDetails> receivedEmployeeDetails, List<AppraisalMeetingInvitees> appraisalMeetingInviteesListOld) throws PortalException {
        List<EmployeeDetails> newInviteesEmployeeDetails = new ArrayList<>();
        for (EmployeeDetails employeeDetails : receivedEmployeeDetails) {
            boolean isFound = false;
            for (AppraisalMeetingInvitees appraisalMeetingInvitee : appraisalMeetingInviteesListOld) {
                if (appraisalMeetingInvitee.getEmployeeId() == employeeDetails.getEmployeeId()) {
                    isFound = true;
                }
            }
            if (!isFound) {
                newInviteesEmployeeDetails.add(employeeDetails);
            }
        }
        return newInviteesEmployeeDetails;
    }

    private List<AppraisalMeetingInvitees> getNonChangedAppraisalMeetingInvitees(List<AppraisalMeetingInvitees> appraisalMeetingInviteesListOld, List<AppraisalMeetingInvitees> removedAppraisalMeetingInviteesList) {
        return appraisalMeetingInviteesListOld.stream()
                .filter(oldInvitee -> removedAppraisalMeetingInviteesList.stream()
                        .noneMatch(removedInvitee -> removedInvitee.equals(oldInvitee)))
                .collect(Collectors.toList());

    }
}



