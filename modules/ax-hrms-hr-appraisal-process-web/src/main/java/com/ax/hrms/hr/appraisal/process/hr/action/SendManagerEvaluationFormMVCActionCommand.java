package com.ax.hrms.hr.appraisal.process.hr.action;


import com.ax.hrms.common.api.api.AxHrmsCommonApi;
import com.ax.hrms.hr.appraisal.process.constants.AxHrmsHrAppraisalProcessHrConstants;
import com.ax.hrms.hr.appraisal.process.constants.AxHrmsHrAppraisalProcessPortletKeys;
import com.ax.hrms.mail.template.config.configuration.MailTemplateConfiguration;
import com.ax.hrms.master.model.TemplateLevelMaster;
import com.ax.hrms.master.service.AppraisalStatusMasterLocalService;
import com.ax.hrms.master.service.TemplateLevelMasterLocalService;
import com.ax.hrms.model.AppraisalEvaluationFormStatus;
import com.ax.hrms.model.AppraisalFormTemplates;
import com.ax.hrms.model.AppraisalProcess;
import com.ax.hrms.model.EmployeeDetails;
import com.ax.hrms.service.*;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.document.library.kernel.service.DLFileEntryLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.Layout;
import com.liferay.portal.kernel.portlet.PortletURLFactoryUtil;
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
import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * Author: Nivid Koradiya
 */
@Component(
        property = {
                "javax.portlet.name=" + AxHrmsHrAppraisalProcessPortletKeys.AX_HRMS_HR_APPRAISAL_PROCESS_WEB_PORTLET,
                "mvc.command.name=/sendManagerEvaluationForm"
        },
        service = MVCActionCommand.class
)
public class SendManagerEvaluationFormMVCActionCommand extends BaseMVCActionCommand {

    Log log = LogFactoryUtil.getLog(SendManagerEvaluationFormMVCActionCommand.class);

    @Reference
    UserLocalService userLocalService;

    @Reference
    MailTemplateConfiguration mailTemplateConfiguration;

    @Reference
    TemplateLevelMasterLocalService templateLevelMasterLocalService;

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
    AppraisalStatusMasterLocalService appraisalStatusMasterLocalService;


    @Override
    protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {

        long appraisalProcessId = ParamUtil.getLong(actionRequest, AxHrmsHrAppraisalProcessHrConstants.APPRAISAL_PROCESS_ID);
        String users = ParamUtil.getString(actionRequest, AxHrmsHrAppraisalProcessHrConstants.TEAM_ID);
        DateFormat dateFormat = new SimpleDateFormat(AxHrmsHrAppraisalProcessHrConstants.DATE_FORMAT);
        Date submissionDate = ParamUtil.getDate(actionRequest, AxHrmsHrAppraisalProcessHrConstants.SUBMISSION_DATE, dateFormat);

        AppraisalProcess appraisalProcess = appraisalProcessLocalService.getAppraisalProcess(appraisalProcessId);
        appraisalProcess.setIsManagementFormSent(true);
        appraisalProcess.setStatus(appraisalStatusMasterLocalService.findBystatus(AxHrmsHrAppraisalProcessHrConstants.IN_MANAGER_EVALUATION).getAppraisalStatusMasterId());

        appraisalProcessLocalService.updateAppraisalProcess(appraisalProcess);

        String[] userStringList = users.split(",");
        for (String user : userStringList) {
            log.info(user);
            long userId = Long.parseLong(user);

            // create appraisal eval form status
            EmployeeDetails appraiseeDetails = employeeDetailsLocalService.getEmployeeDetails(appraisalReminderLocalService.findByAppraisalProcessId(appraisalProcessId).getEmployeeId());
            AppraisalEvaluationFormStatus appraisalEvaluationFormStatus = appraisalEvaluationFormStatusLocalService.createAppraisalEvaluationFormStatus(CounterLocalServiceUtil.increment(AppraisalEvaluationFormStatusService.class.getName()));
            // Send the form
            EmployeeDetails employeeDetails = employeeDetailsLocalService.findByLrUserId(userId);
            long employeeId = employeeDetails.getEmployeeId();
            long appraisalFormTemplateId = sendCurrentYearManagerEvaluationForm(employeeDetails, actionRequest, appraisalEvaluationFormStatus.getAppraisalEvaluationFormStatusId(),appraiseeDetails);
            log.info(generateManagerEvaluationSubmissionLink(actionRequest, appraisalEvaluationFormStatus.getAppraisalEvaluationFormStatusId()));

            ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
            // The code sets the status, company ID, user ID, group ID, and creation and modification dates for the new appraisal FORM STATUS.
            appraisalEvaluationFormStatus.setCompanyId(themeDisplay.getCompanyId());
            appraisalEvaluationFormStatus.setCreatedBy(themeDisplay.getUserId());
            appraisalEvaluationFormStatus.setGroupId(themeDisplay.getCompanyGroupId());
            appraisalEvaluationFormStatus.setCreateDate(new Date());
            appraisalEvaluationFormStatus.setModifiedDate(new Date());

            appraisalEvaluationFormStatus.setSubmissionDate(submissionDate);
            appraisalEvaluationFormStatus.setAppraisalProcessId(appraisalProcessId);
            appraisalEvaluationFormStatus.setEmployeeId(employeeId);
            appraisalEvaluationFormStatus.setAppraisalFormTemplateId(appraisalFormTemplateId);
            appraisalEvaluationFormStatus.setStatus(false); // setting false as it is remaining to be filled

            appraisalEvaluationFormStatusLocalService.addAppraisalEvaluationFormStatus(appraisalEvaluationFormStatus);
        }


        SessionMessages.add(actionRequest, AxHrmsHrAppraisalProcessHrConstants.MANAGER_FORM_SENT);

    }

    private long sendCurrentYearManagerEvaluationForm(EmployeeDetails employeeDetails, ActionRequest actionRequest, long appraisalFormStatusId, EmployeeDetails appraiseeDetails) throws PortalException {
        TemplateLevelMaster templateLevelMaster = templateLevelMasterLocalService.findBylevelName(AxHrmsHrAppraisalProcessHrConstants.MANAGER);

        AppraisalFormTemplates appraisalFormTemplates=appraisalFormTemplatesLocalService.findByTemplateYearAndTemplateLevelId(getCurrentYearAsString(),templateLevelMaster.getTemplateLevelMasterId());

        Group group = GroupLocalServiceUtil.fetchGroup(PortalUtil.getDefaultCompanyId(), AxHrmsHrAppraisalProcessHrConstants.GUEST);
        String fromName = PrefsPropsUtil.getString(group.getCompanyId(), PropsKeys.ADMIN_EMAIL_FROM_NAME);
        String fromEmailAddress = PrefsPropsUtil.getString(group.getCompanyId(), PropsKeys.ADMIN_EMAIL_FROM_ADDRESS);

        String body=mailTemplateConfiguration.managerEvaluationFormMailBody();
        String subject=mailTemplateConfiguration.managerEvaluationFormMailSubject();

        body= body.replace("${EMPLOYEE_NAME}", employeeDetails.getFirstName() + " " + employeeDetails.getLastName());
        body= body.replace("${APPRAISEE_NAME}", appraiseeDetails.getFirstName() + " " + appraiseeDetails.getLastName());
        body= body.replace("${MANAGER_FORM_LINK}", generateManagerEvaluationSubmissionLink(actionRequest, appraisalFormStatusId));
        axHrmsCommonApi.sendMailWithAttachment(
                employeeDetails.getOfficialEmail(), fromEmailAddress, fromName, subject, body,
                axHrmsCommonApi.convertDLFileEntryToFile(appraisalFormTemplates.getTemplateDocumentId()), DLFileEntryLocalServiceUtil.getDLFileEntry(appraisalFormTemplates.getTemplateDocumentId()).getFileName()
        );
        return appraisalFormTemplates.getAppraisalFormTemplateId();
    }

    private String getCurrentYearAsString() {
        Date currentDate = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat(AxHrmsHrAppraisalProcessHrConstants.YYYY);
        return dateFormat.format(currentDate);
    }

    private String generateManagerEvaluationSubmissionLink(ActionRequest actionRequest, long appraisalFormStatusId) {
        //code not prepared
        ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
        Layout plId = themeDisplay.getLayout();
        PortletURL programListRenderUrl = PortletURLFactoryUtil.getPortletURLFactory().create(actionRequest,
                AxHrmsHrAppraisalProcessPortletKeys.AX_HRMS_HR_APPRAISAL_PROCESS_WEB_PORTLET, plId, PortletRequest.RENDER_PHASE);
        String[] p_p_state = {AxHrmsHrAppraisalProcessHrConstants.NORMAL};
        programListRenderUrl.getParameterMap().put(AxHrmsHrAppraisalProcessHrConstants.P_P_STATE, p_p_state);
        String[] view = {AxHrmsHrAppraisalProcessHrConstants.VIEW};
        programListRenderUrl.getParameterMap().put(AxHrmsHrAppraisalProcessHrConstants.P_P_MODE, view);
        String[] mvcRenderCommandName = {AxHrmsHrAppraisalProcessHrConstants.SUBMIT_MANAGER_EVALUATION_FORM_URL};
        programListRenderUrl.getParameterMap().put(AxHrmsHrAppraisalProcessHrConstants.MVC_RENDER_COMMAND_NAME, mvcRenderCommandName);
        String[] appraisalFormStatusIdParam = {String.valueOf(appraisalFormStatusId)};
        programListRenderUrl.getParameterMap().put(AxHrmsHrAppraisalProcessHrConstants.APPRAISAL_EVALUATION_FORM_STATUS_ID, appraisalFormStatusIdParam);
        return programListRenderUrl.toString();
    }
}



