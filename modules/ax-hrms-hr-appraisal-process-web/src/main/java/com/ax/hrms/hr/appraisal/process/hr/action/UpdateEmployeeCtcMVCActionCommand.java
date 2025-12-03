package com.ax.hrms.hr.appraisal.process.hr.action;


import com.ax.hrms.common.api.api.AxHrmsCommonApi;
import com.ax.hrms.hr.appraisal.process.constants.AxHrmsHrAppraisalProcessHrConstants;
import com.ax.hrms.hr.appraisal.process.constants.AxHrmsHrAppraisalProcessPortletKeys;
import com.ax.hrms.mail.template.config.configuration.MailTemplateConfiguration;
import com.ax.hrms.master.model.AppraisalStatusMaster;
import com.ax.hrms.master.service.AppraisalStatusMasterLocalService;
import com.ax.hrms.master.service.DesignationMasterLocalService;
import com.ax.hrms.master.service.TemplateLevelMasterLocalService;
import com.ax.hrms.model.*;
import com.ax.hrms.service.*;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.document.library.kernel.service.DLAppLocalServiceUtil;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.repository.model.Folder;
import com.liferay.portal.kernel.service.GroupLocalServiceUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.servlet.SessionMessages;
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


/**
 * Author: Nivid Koradiya
 */
@Component(
        property = {
                "javax.portlet.name=" + AxHrmsHrAppraisalProcessPortletKeys.AX_HRMS_HR_APPRAISAL_PROCESS_WEB_PORTLET,
                "mvc.command.name=/updateEmployeeCtc"
        },
        service = MVCActionCommand.class
)
public class UpdateEmployeeCtcMVCActionCommand extends BaseMVCActionCommand {

    @Reference
    TemplateLevelMasterLocalService templateLevelMasterLocalService;

    @Reference
    AppraisalFormTemplatesLocalService appraisalFormTemplatesLocalService;

    @Reference
    AppraisalStatusMasterLocalService appraisalStatusMasterLocalService;

    @Reference
    AppraisalProcessLocalService appraisalProcessLocalService;

    @Reference
    MailTemplateConfiguration mailTemplateConfiguration;

    @Reference
    AppraisalReminderLocalService appraisalReminderLocalService;

    @Reference
    DesignationMasterLocalService designationMasterLocalService;

    @Reference
    EmployeeDesignationLocalService employeeDesignationLocalService;

    @Reference
    AxHrmsCommonApi axHrmsCommonApi;

    @Reference
    AppraisalEvaluationFormStatusLocalService appraisalEvaluationFormStatusLocalService;

    @Reference
    EmployeeDetailsLocalService employeeDetailsLocalService;

    @Reference
    AppraisalHistoryLocalService appraisalHistoryLocalService;

    @Reference
    EmployeeSalaryLocalService employeeSalaryLocalService;

    @Override
    protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
        ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
        UploadPortletRequest uploadPortletRequest = PortalUtil.getUploadPortletRequest(actionRequest);

        long appraisalProcessId = ParamUtil.getLong(actionRequest, AxHrmsHrAppraisalProcessHrConstants.APPRAISAL_PROCESS_ID);
        long updatedDesignation = ParamUtil.getLong(actionRequest, AxHrmsHrAppraisalProcessHrConstants.UPDATE_DESIGNATION);
        String comments = ParamUtil.getString(actionRequest, AxHrmsHrAppraisalProcessHrConstants.COMMENTS);
        double updateGrossSalaryPm = ParamUtil.getDouble(actionRequest, AxHrmsHrAppraisalProcessHrConstants.UPDATE_SALARY_PM);
        double updateGrossSalaryPa = ParamUtil.getDouble(actionRequest, AxHrmsHrAppraisalProcessHrConstants.UPDATE_SALARY_PA);
        File file = uploadPortletRequest.getFile(AxHrmsHrAppraisalProcessHrConstants.UPLOAD_DOCUMENT);
        String fileExtension = getFileExtension(uploadPortletRequest.getFileName(AxHrmsHrAppraisalProcessHrConstants.UPLOAD_DOCUMENT));
        String documentName = ParamUtil.getString(actionRequest, AxHrmsHrAppraisalProcessHrConstants.DOCUMENT_NAME) + StringPool.PERIOD + fileExtension;
        ServiceContext serviceContext = ServiceContextFactory.getInstance(Folder.class.getName(), actionRequest);
        serviceContext.setAddGroupPermissions(true);
        serviceContext.setAddGuestPermissions(false);

        Folder folder = folderNavigatorAppraisalDocumentFileUpload(appraisalProcessId, themeDisplay, serviceContext);
        FileEntry entry = DLAppLocalServiceUtil.addFileEntry(themeDisplay.getUserId(), themeDisplay.getScopeGroupId(), folder.getFolderId(), documentName, MimeTypesUtil.getContentType((File) file), documentName, StringPool.BLANK, StringPool.BLANK, file, serviceContext);

        EmployeeDetails employeeDetails = employeeDetailsLocalService.getEmployeeDetails(appraisalReminderLocalService.findByAppraisalProcessId(appraisalProcessId).getEmployeeId());
        AppraisalHistory appraisalHistory = appraisalHistoryLocalService.createAppraisalHistory(CounterLocalServiceUtil.increment(AppraisalHistory.class.getName()));

        EmployeeSalary employeeSalary = employeeSalaryLocalService.findByEmployeeIdAndStatus(employeeDetails.getEmployeeId(), true);
        employeeSalary.setStatus(false); // setting off the old salary.

        EmployeeSalary newEmployeeSalary = employeeSalaryLocalService.createEmployeeSalary(CounterLocalServiceUtil.increment(EmployeeSalary.class.getName()));
        appraisalHistory.setAppraisalDate(new Date());
        appraisalHistory.setAppraisalDocumentId(entry.getFileEntryId());
        appraisalHistory.setUpdatedCtcPa(updateGrossSalaryPa);
        appraisalHistory.setUpdatedCtcPm(updateGrossSalaryPm);
        appraisalHistory.setComments(comments);
        appraisalHistory.setSalaryId(employeeSalary.getSalaryId());
        appraisalHistoryLocalService.addAppraisalHistory(appraisalHistory);

        newEmployeeSalary.setGrossSalaryCtcPm(appraisalHistory.getUpdatedCtcPm());
        newEmployeeSalary.setGrossSalaryCtcPa(appraisalHistory.getUpdatedCtcPa());
        newEmployeeSalary.setEmployeeId(employeeDetails.getEmployeeId());
        newEmployeeSalary.setStatus(true); // setting on the new salary

        employeeSalaryLocalService.updateEmployeeSalary(employeeSalary); // setting off the old salary.
        employeeSalaryLocalService.addEmployeeSalary(newEmployeeSalary); // adding the new salary.

        //Disabling the older designation of employee
        EmployeeDesignation employeeDesignation = employeeDesignationLocalService.findByEmployeeId(employeeDetails.getEmployeeId());
        employeeDesignation.setStatus(false);
        employeeDesignation.setEndDate(new Date());
        employeeDesignationLocalService.updateEmployeeDesignation(employeeDesignation);

        //Setting the new designation of employee
        EmployeeDesignation newEmployeeDesignation = employeeDesignationLocalService.createEmployeeDesignation(CounterLocalServiceUtil.increment(EmployeeDesignation.class.getName()));
        newEmployeeDesignation.setStartDate(new Date());
        newEmployeeDesignation.setStatus(true);
        newEmployeeDesignation.setDesignationMasterId(updatedDesignation);
        newEmployeeDesignation.setEmployeeId(employeeDetails.getEmployeeId());
        employeeDesignationLocalService.addEmployeeDesignation(newEmployeeDesignation);

        // Marking the appraisal process status as completed and salary updated!
        AppraisalStatusMaster appraisalStatusMaster = appraisalStatusMasterLocalService.findBystatus(AxHrmsHrAppraisalProcessHrConstants.COMPLETED);
        AppraisalProcess appraisalProcess = appraisalProcessLocalService.getAppraisalProcess(appraisalProcessId);
        appraisalProcess.setStatus(appraisalStatusMaster.getAppraisalStatusMasterId());
        appraisalProcess.setIsSalaryUpdated(true);
        appraisalProcessLocalService.updateAppraisalProcess(appraisalProcess);

        sendManagerFormFilledNotificationToHrAdmin(entry, employeeDetails, appraisalHistory);
        SessionMessages.add(actionRequest, AxHrmsHrAppraisalProcessHrConstants.CTC_UPDATED);

    }

    private void sendManagerFormFilledNotificationToHrAdmin(FileEntry entry, EmployeeDetails employeeDetails, AppraisalHistory appraisalHistory) {
        Group group = GroupLocalServiceUtil.fetchGroup(PortalUtil.getDefaultCompanyId(), AxHrmsHrAppraisalProcessHrConstants.GUEST);
        String fromName = PrefsPropsUtil.getString(group.getCompanyId(), PropsKeys.ADMIN_EMAIL_FROM_NAME);
        String fromEmailAddress = PrefsPropsUtil.getString(group.getCompanyId(), PropsKeys.ADMIN_EMAIL_FROM_ADDRESS);

        String subjectMail = mailTemplateConfiguration.appraisalDocumentSubject();
        String bodyMail = mailTemplateConfiguration.appraisalDocumentBody();

        bodyMail = bodyMail.replace("${EMPLOYEE_NAME}", employeeDetails.getFirstName() + " " + employeeDetails.getLastName());
        bodyMail = bodyMail.replace("${COMMENTS}", appraisalHistory.getComments());
        bodyMail = bodyMail.replace("${CTC_PM}", String.valueOf(appraisalHistory.getUpdatedCtcPm()));
        bodyMail = bodyMail.replace("${CTC_PA}",String.valueOf(appraisalHistory.getUpdatedCtcPa()));


        File file = axHrmsCommonApi.convertDLFileEntryToFile(entry.getFileEntryId());

        axHrmsCommonApi.sendMailWithAttachment(
                employeeDetails.getOfficialEmail(),
                fromEmailAddress,
                fromName,
                subjectMail,
                bodyMail,
                file,
                entry.getFileName()
        );
    }

    private Folder folderNavigatorAppraisalDocumentFileUpload(long appraisalProcessId, ThemeDisplay themeDisplay, ServiceContext serviceContext) throws PortalException {
        Folder folder = null;
        Calendar cal = Calendar.getInstance();

        EmployeeDetails employeeDetails = employeeDetailsLocalService.getEmployeeDetails(appraisalReminderLocalService.findByAppraisalProcessId(appraisalProcessId).getEmployeeId());
        String empFolderName = employeeDetails.getFirstName() + StringPool.DASH + employeeDetails.getLastName() + StringPool.DASH + appraisalProcessId;
        String docuemntFolderName = AxHrmsHrAppraisalProcessHrConstants.APPRAISAL_DOCUMENT;
        folder = axHrmsCommonApi.createFolder(AxHrmsHrAppraisalProcessHrConstants.APPRAISALS, 0, themeDisplay, serviceContext);
        folder = axHrmsCommonApi.createFolder(String.valueOf(cal.get(Calendar.YEAR)), folder.getFolderId(), themeDisplay, serviceContext);
        folder = axHrmsCommonApi.createFolder(empFolderName, folder.getFolderId(), themeDisplay, serviceContext);
        folder = axHrmsCommonApi.createFolder(docuemntFolderName, folder.getFolderId(), themeDisplay, serviceContext);

        return folder;
    }
    public static String getFileExtension(String fileName) {
        if (fileName.lastIndexOf(StringPool.PERIOD) != -1 && fileName.lastIndexOf(StringPool.PERIOD) != 0) {
            return fileName.substring(fileName.lastIndexOf(StringPool.PERIOD) + 1);
        } else {
            return StringPool.BLANK;
        }
    }
}




