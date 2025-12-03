package com.ax.hrms.hr.appraisal.process.hr.action;


import com.ax.hrms.common.api.api.AxHrmsCommonApi;
import com.ax.hrms.hr.appraisal.process.constants.AxHrmsHrAppraisalProcessHrConstants;
import com.ax.hrms.hr.appraisal.process.constants.AxHrmsHrAppraisalProcessPortletKeys;
import com.ax.hrms.master.service.AppraisalStatusMasterLocalService;
import com.ax.hrms.master.service.TemplateLevelMasterLocalService;
import com.ax.hrms.model.AppraisalEvaluationFormStatus;
import com.ax.hrms.model.AppraisalProcess;
import com.ax.hrms.model.EmployeeDetails;
import com.ax.hrms.service.*;
import com.liferay.document.library.kernel.service.DLAppLocalServiceUtil;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.repository.model.Folder;
import com.liferay.portal.kernel.service.GroupLocalServiceUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.*;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import java.io.File;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


/**
 * Author: Nivid Koradiya
 */
@Component(
        property = {
                "javax.portlet.name=" + AxHrmsHrAppraisalProcessPortletKeys.AX_HRMS_HR_APPRAISAL_PROCESS_WEB_PORTLET,
                "mvc.command.name=/uploadSelfEvaluationForm"
        },
        service = MVCActionCommand.class
)
public class UploadSelfEvaluationFormMVCActionCommand extends BaseMVCActionCommand {

    Log log = LogFactoryUtil.getLog(UploadSelfEvaluationFormMVCActionCommand.class);

    @Reference
    TemplateLevelMasterLocalService templateLevelMasterLocalService;

    @Reference
    AppraisalFormTemplatesLocalService appraisalFormTemplatesLocalService;

    @Reference
    AppraisalStatusMasterLocalService appraisalStatusMasterLocalService;

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

    @Override
    protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
        ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
        long appraisalEvaluationFormStatusId = ParamUtil.getLong(actionRequest, AxHrmsHrAppraisalProcessHrConstants.APPRAISAL_EVALUATION_FORM_STATUS_ID);
        UploadPortletRequest uploadPortletRequest = PortalUtil.getUploadPortletRequest(actionRequest);
        File file = uploadPortletRequest.getFile(AxHrmsHrAppraisalProcessHrConstants.FILE);
        String fileName = uploadPortletRequest.getFileName(AxHrmsHrAppraisalProcessHrConstants.FILE);
        ServiceContext serviceContext = ServiceContextFactory.getInstance(Folder.class.getName(), actionRequest);
        serviceContext.setAddGroupPermissions(true);
        serviceContext.setAddGuestPermissions(false);

        Folder folder = folderNavigatorForSelfAppraisalFileUpload(appraisalEvaluationFormStatusId, themeDisplay, serviceContext);

        FileEntry entry = DLAppLocalServiceUtil.addFileEntry(themeDisplay.getUserId(), themeDisplay.getScopeGroupId(), folder.getFolderId(), fileName, MimeTypesUtil.getContentType((java.io.File) file), fileName, StringPool.BLANK, StringPool.BLANK, file, serviceContext);

        //setting the status and doc id into appraisal evaluation file status
        AppraisalEvaluationFormStatus appraisalEvaluationFormStatus = appraisalEvaluationFormStatusLocalService.getAppraisalEvaluationFormStatus(appraisalEvaluationFormStatusId);
        appraisalEvaluationFormStatus.setStatus(true);
        appraisalEvaluationFormStatus.setFilledEvaluationDocuemntId(entry.getFileEntryId());
        appraisalEvaluationFormStatusLocalService.updateAppraisalEvaluationFormStatus(appraisalEvaluationFormStatus);

        // updating the appraisal process:
        AppraisalProcess appraisalProcess = appraisalProcessLocalService.getAppraisalProcess(appraisalEvaluationFormStatus.getAppraisalProcessId());
        appraisalProcess.setIsSelfEvalutionFormFilled(true);
        appraisalProcessLocalService.updateAppraisalProcess(appraisalProcess);

        // Notify HR Via Email Notifications
        sendSelfFormFilledNotificationToHrAdmin(entry, employeeDetailsLocalService.getEmployeeDetails(appraisalReminderLocalService.findByAppraisalProcessId(appraisalProcess.getAppraisalProcessId()).getEmployeeId()));
    }

    private void sendSelfFormFilledNotificationToHrAdmin(FileEntry entry, EmployeeDetails employeeDetails) {
        Group group = GroupLocalServiceUtil.fetchGroup(PortalUtil.getDefaultCompanyId(), AxHrmsHrAppraisalProcessHrConstants.GUEST);
        String fromName = PrefsPropsUtil.getString(group.getCompanyId(), PropsKeys.ADMIN_EMAIL_FROM_NAME);
        String fromEmailAddress = PrefsPropsUtil.getString(group.getCompanyId(), PropsKeys.ADMIN_EMAIL_FROM_ADDRESS);
        List<User> hrUsers = axHrmsCommonApi.fetchHrAdminList(GroupLocalServiceUtil.fetchGroup(PortalUtil.getDefaultCompanyId(), AxHrmsHrAppraisalProcessHrConstants.GUEST).getCompanyId());
        String htmlBody = "<body style=\"font-family: Arial, sans-serif; line-height: 1.6; background-color: #f4f4f4; padding: 20px; margin: 0;\">" +
                "<div style=\"max-width: 600px; margin: auto; background: #fff; padding: 20px; border-radius: 5px; box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);\">" +
                "<h2 style=\"color: #333;\">New Self Evaluation Form Submitted</h2>" +
                "<p style=\"margin-bottom: 20px; color: #666;\">Hello HR Team,</p>" +
                "<p style=\"margin-bottom: 10px;\">A new self-evaluation form has been submitted for the appraisal process. Below are the details:</p>" +
                "<table style=\"width: 100%; border-collapse: collapse; margin-bottom: 20px;\">" +
                "<tr>" +
                "<td style=\"padding: 8px; background-color: #f2f2f2; border: 1px solid #ddd;\">Employee Name</td>" +
                "<td style=\"padding: 8px; border: 1px solid #ddd;\">" + employeeDetails.getFirstName() + " " + employeeDetails.getLastName() + "</td>" +
                "</tr>" +
                "<tr>" +
                "<td style=\"padding: 8px; background-color: #f2f2f2; border: 1px solid #ddd;\">Date Time of Filling form</td>" +
                "<td style=\"padding: 8px; border: 1px solid #ddd;\">" + new Date().toString() + "</td>" +
                "</tr>" +
                "</table>" +
                "<p style=\"margin-bottom: 20px;\">Please review the submitted form and take necessary actions accordingly.</p>" +
                "</div>" +
                "</body>";
        File file = axHrmsCommonApi.convertDLFileEntryToFile(entry.getFileEntryId());
        for (User hrUser : hrUsers) {
            axHrmsCommonApi.sendMailWithAttachment(
                    hrUser.getEmailAddress(),
                    fromEmailAddress,
                    fromName,
                    "NEW SELF APPRAISAL FORM UPLOADED",
                    htmlBody,
                    file,
                    entry.getFileName()
            );
        }
    }

    private Folder folderNavigatorForSelfAppraisalFileUpload(long appraisalEvaluationFormStatusId, ThemeDisplay themeDisplay, ServiceContext serviceContext) throws PortalException {
        Folder folder = null;
        Calendar cal = Calendar.getInstance();

        long appraisalProcessId =  appraisalEvaluationFormStatusLocalService.getAppraisalEvaluationFormStatus(appraisalEvaluationFormStatusId).getAppraisalProcessId();
        EmployeeDetails employeeDetails = employeeDetailsLocalService.getEmployeeDetails(appraisalReminderLocalService.findByAppraisalProcessId(appraisalProcessId).getEmployeeId());

        String empFolderName = employeeDetails.getFirstName() + AxHrmsHrAppraisalProcessHrConstants.HYPHEN + employeeDetails.getLastName() + AxHrmsHrAppraisalProcessHrConstants.HYPHEN + appraisalProcessId;

        folder = axHrmsCommonApi.createFolder(AxHrmsHrAppraisalProcessHrConstants.APPRAISALS, 0, themeDisplay, serviceContext);
        folder = axHrmsCommonApi.createFolder(String.valueOf(cal.get(Calendar.YEAR)), folder.getFolderId(), themeDisplay, serviceContext);
        folder = axHrmsCommonApi.createFolder(empFolderName, folder.getFolderId(), themeDisplay, serviceContext);
        folder = axHrmsCommonApi.createFolder(AxHrmsHrAppraisalProcessHrConstants.SELF_CAPITAL, folder.getFolderId(), themeDisplay, serviceContext);

        return folder;
    }
}




