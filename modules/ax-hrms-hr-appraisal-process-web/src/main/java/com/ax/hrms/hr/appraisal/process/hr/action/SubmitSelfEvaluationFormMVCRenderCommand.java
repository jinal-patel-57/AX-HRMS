package com.ax.hrms.hr.appraisal.process.hr.action;


import com.ax.hrms.common.api.api.AxHrmsCommonApi;
import com.ax.hrms.exception.NoSuchEmployeeDetailsException;
import com.ax.hrms.hr.appraisal.process.constants.AxHrmsHrAppraisalProcessHrConstants;
import com.ax.hrms.hr.appraisal.process.constants.AxHrmsHrAppraisalProcessPortletKeys;
import com.ax.hrms.model.AppraisalEvaluationFormStatus;
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
                "mvc.command.name=/submitSelfEvaluationForm"
        },
        service = MVCRenderCommand.class
)
public class SubmitSelfEvaluationFormMVCRenderCommand implements MVCRenderCommand {
    Log log = LogFactoryUtil.getLog(SubmitSelfEvaluationFormMVCRenderCommand.class.getName());

    @Reference
    AppraisalReminderLocalService appraisalReminderLocalService;

    @Reference
    AxHrmsCommonApi axHrmsCommonApi;

    @Reference
    AppraisalProcessLocalService appraisalProcessLocalService;

    @Reference
    AppraisalEvaluationFormStatusLocalService appraisalEvaluationFormStatusLocalService;

    @Reference
    EmployeeDetailsLocalService employeeDetailsLocalService;



    @Override
    public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
        long appraisalEvaluationFormStatusId = ParamUtil.getLong(renderRequest, AxHrmsHrAppraisalProcessHrConstants.APPRAISAL_EVALUATION_FORM_STATUS_ID);
        ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
        try {
            AppraisalEvaluationFormStatus appraisalEvaluationFormStatus = appraisalEvaluationFormStatusLocalService.getAppraisalEvaluationFormStatus(appraisalEvaluationFormStatusId);

            try {
                EmployeeDetails employeeDetails = employeeDetailsLocalService.findByLrUserId(themeDisplay.getUserId());
                if(employeeDetails.getEmployeeId() != appraisalEvaluationFormStatus.getEmployeeId()){
                    renderRequest.setAttribute(AxHrmsHrAppraisalProcessHrConstants.IS_EMPLOYEE_VALID , false);
                }
                else{
                    renderRequest.setAttribute(AxHrmsHrAppraisalProcessHrConstants.IS_EMPLOYEE_VALID , true);
                }
                if(appraisalEvaluationFormStatus.getStatus()){
                    renderRequest.setAttribute(AxHrmsHrAppraisalProcessHrConstants.IS_EMPLOYEE_VALID , false);
                }

            } catch (NoSuchEmployeeDetailsException e) {
                log.info("EMPLOYEE ERROR");
            }

        } catch (PortalException e) {
            log.info("PORTAL EXCEPTION");
        }

        try {
            AppraisalEvaluationFormStatus appraisalEvaluationFormStatus = appraisalEvaluationFormStatusLocalService.getAppraisalEvaluationFormStatus(appraisalEvaluationFormStatusId);
            EmployeeDetails appraiserName = employeeDetailsLocalService.findByEmployeeId(appraisalEvaluationFormStatus.getEmployeeId());
            renderRequest.setAttribute(AxHrmsHrAppraisalProcessHrConstants.APPRAISEE,appraiserName.getFirstName() + " " + appraiserName.getLastName());
            renderRequest.setAttribute(AxHrmsHrAppraisalProcessHrConstants.APPRAISAL_EVALUATION_FORM_STATUS_ID,appraisalEvaluationFormStatusId);
            SimpleDateFormat dateFormat = new SimpleDateFormat(AxHrmsHrAppraisalProcessHrConstants.DATE_FORMAT_DATE_MONTH_YEAR);
            renderRequest.setAttribute(AxHrmsHrAppraisalProcessHrConstants.DEADLINE, dateFormat.format(appraisalEvaluationFormStatus.getSubmissionDate()));
        } catch (PortalException e) {
            log.error("Failed to load form");
        }

       return AxHrmsHrAppraisalProcessHrConstants.SELF_EVALUATION_FORM_SUBMISSION_JSP;
    }


}
