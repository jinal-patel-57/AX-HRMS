package com.ax.hrms.hr.appraisal.process.hr.action;


import com.ax.hrms.common.api.api.AxHrmsCommonApi;
import com.ax.hrms.exception.NoSuchEmployeeDetailsException;
import com.ax.hrms.hr.appraisal.process.constants.AxHrmsHrAppraisalProcessHrConstants;
import com.ax.hrms.hr.appraisal.process.constants.AxHrmsHrAppraisalProcessPortletKeys;
import com.ax.hrms.model.AppraisalEvaluationFormStatus;
import com.ax.hrms.model.AppraisalProcess;
import com.ax.hrms.model.AppraisalReminder;
import com.ax.hrms.model.EmployeeDetails;
import com.ax.hrms.service.AppraisalEvaluationFormStatusLocalService;
import com.ax.hrms.service.AppraisalProcessLocalService;
import com.ax.hrms.service.AppraisalReminderLocalService;
import com.ax.hrms.service.EmployeeDetailsLocalService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import java.text.SimpleDateFormat;

/**
 * Author: Nivid Koradiya
 */
@Component(
        property = {
                "javax.portlet.name=" + AxHrmsHrAppraisalProcessPortletKeys.AX_HRMS_HR_APPRAISAL_PROCESS_WEB_PORTLET,
                "mvc.command.name=/submitManagerEvaluationForm"
        },
        service = MVCRenderCommand.class
)
public class SubmitManagerEvaluationFormMVCRenderCommand implements MVCRenderCommand {
    Log log = LogFactoryUtil.getLog(SubmitManagerEvaluationFormMVCRenderCommand.class.getName());

    @Reference
    AppraisalReminderLocalService appraisalReminderLocalService;

    @Reference
    AppraisalProcessLocalService appraisalProcessLocalService;

    @Reference
    AxHrmsCommonApi axHrmsCommonApi;

    @Reference
    EmployeeDetailsLocalService employeeDetailsLocalService;

    @Reference
    AppraisalEvaluationFormStatusLocalService appraisalEvaluationFormStatusLocalService;

    @Override
    public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
        long appraisalEvaluationFormStatusId = ParamUtil.getLong(renderRequest, AxHrmsHrAppraisalProcessHrConstants.APPRAISAL_EVALUATION_FORM_STATUS_ID);
        ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
        try {
            AppraisalEvaluationFormStatus appraisalEvaluationFormStatus = appraisalEvaluationFormStatusLocalService.getAppraisalEvaluationFormStatus(appraisalEvaluationFormStatusId);
            try {
                EmployeeDetails employeeDetails = employeeDetailsLocalService.findByLrUserId(themeDisplay.getUserId());
                if (employeeDetails.getEmployeeId() != appraisalEvaluationFormStatus.getEmployeeId()) {
                    renderRequest.setAttribute(AxHrmsHrAppraisalProcessHrConstants.IS_EMPLOYEE_VALID, false);
                } else {
                    renderRequest.setAttribute(AxHrmsHrAppraisalProcessHrConstants.IS_EMPLOYEE_VALID, true);

                }
                if (appraisalEvaluationFormStatus.getStatus()) {
                    renderRequest.setAttribute(AxHrmsHrAppraisalProcessHrConstants.IS_EMPLOYEE_VALID, false);
                }
            } catch (NoSuchEmployeeDetailsException e) {
                log.info("EMPLOYEE ERROR");
            }


        } catch (PortalException e) {
            log.info("PORTAL EXCEPTION");
        }

        try {
            AppraisalEvaluationFormStatus appraisalEvaluationFormStatus = appraisalEvaluationFormStatusLocalService.getAppraisalEvaluationFormStatus(appraisalEvaluationFormStatusId);
            AppraisalProcess appraisalProcess = appraisalProcessLocalService.getAppraisalProcess(appraisalEvaluationFormStatus.getAppraisalProcessId());
            AppraisalReminder appraisalReminder = appraisalReminderLocalService.findByAppraisalProcessId(appraisalProcess.getAppraisalProcessId());
            EmployeeDetails appraiserEmployeeDetails = employeeDetailsLocalService.getEmployeeDetails(appraisalReminder.getEmployeeId());
            EmployeeDetails reviewerEmployeeDetails = employeeDetailsLocalService.findByEmployeeId(appraisalEvaluationFormStatus.getEmployeeId());
            renderRequest.setAttribute(AxHrmsHrAppraisalProcessHrConstants.APPRAISEE, appraiserEmployeeDetails.getFirstName() + " " + appraiserEmployeeDetails.getLastName());
            renderRequest.setAttribute(AxHrmsHrAppraisalProcessHrConstants.APPRAISAL_EVALUATION_FORM_STATUS_ID, appraisalEvaluationFormStatusId);
            renderRequest.setAttribute(AxHrmsHrAppraisalProcessHrConstants.MANAGER_NAME, reviewerEmployeeDetails.getFirstName() + " " + reviewerEmployeeDetails.getLastName());
            SimpleDateFormat dateFormat = new SimpleDateFormat(AxHrmsHrAppraisalProcessHrConstants.DATE_FORMAT_DATE_MONTH_YEAR);
            renderRequest.setAttribute(AxHrmsHrAppraisalProcessHrConstants.DEADLINE, dateFormat.format(appraisalEvaluationFormStatus.getSubmissionDate()));
        } catch (PortalException e) {
            log.error("Cannot load the data into request!");
        }

        return AxHrmsHrAppraisalProcessHrConstants.MANAGER_EVALUATION_FORM_SUBMISSION_JSP;
    }


}
