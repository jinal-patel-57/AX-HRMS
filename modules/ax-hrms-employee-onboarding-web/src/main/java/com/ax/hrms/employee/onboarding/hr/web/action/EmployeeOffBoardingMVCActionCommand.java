package com.ax.hrms.employee.onboarding.hr.web.action;

import com.ax.hrms.common.api.api.AxHrmsCommonApi;
import com.ax.hrms.employee.onboarding.web.constants.AxHrmsEmployeeOnboardingHrWebPortletConstants;
import com.ax.hrms.employee.onboarding.web.constants.AxHrmsEmployeeOnboardingWebPortletKeys;
import com.ax.hrms.mail.template.config.configuration.MailTemplateConfiguration;
import com.ax.hrms.model.EmployeeDetails;
import com.ax.hrms.model.EmployeeOffBoarding;
import com.ax.hrms.service.EmployeeDetailsLocalService;
import com.ax.hrms.service.EmployeeExperienceLocalService;
import com.ax.hrms.service.EmployeeOffBoardingLocalService;
import com.liferay.document.library.kernel.model.DLFileEntry;
import com.liferay.document.library.kernel.service.DLAppLocalServiceUtil;
import com.liferay.document.library.kernel.service.DLFileEntryLocalServiceUtil;
import com.liferay.mail.kernel.model.MailMessage;
import com.liferay.mail.kernel.service.MailServiceUtil;
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
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.*;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.MutableRenderParameters;
import java.io.File;
import java.io.UnsupportedEncodingException;

@Component(immediate = true, property = {
        "javax.portlet.name=" + AxHrmsEmployeeOnboardingWebPortletKeys.AX_HRMS_EMPLOYEE_ONBOARDING_HR_WEB,
        "mvc.command.name=/employeeOffBoardingHr"}, service = MVCActionCommand.class)
public class EmployeeOffBoardingMVCActionCommand extends BaseMVCActionCommand {

    @Reference
    MailTemplateConfiguration mailTemplateConfiguration;

    @Reference
    EmployeeExperienceLocalService employeeExperienceLocalService;

    @Reference
    EmployeeDetailsLocalService employeeDetailsLocalService;

    @Reference
    AxHrmsCommonApi axHrmsCommonApi;

    @Reference
    EmployeeOffBoardingLocalService employeeOffBoardingLocalService;

    Log log = LogFactoryUtil.getLog(EmployeeOffBoardingMVCActionCommand.class);

    @Override
    protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
        long employeeId = ParamUtil.getLong(actionRequest, AxHrmsEmployeeOnboardingHrWebPortletConstants.EMPLOYEE_ID);
        String offBoard = ParamUtil.getString(actionRequest, AxHrmsEmployeeOnboardingHrWebPortletConstants.OFF_BOARD);

        EmployeeOffBoarding employeeOffBoarding = employeeOffBoardingLocalService.findByEmployeeId(employeeId);
        EmployeeDetails employeeDetails = employeeDetailsLocalService.getEmployeeDetails(employeeOffBoarding.getEmployeeId());

        if (!areAllCheckBoxSaved(employeeOffBoarding)) {
            String kt = ParamUtil.getString(actionRequest, AxHrmsEmployeeOnboardingHrWebPortletConstants.KT);
            String nda = ParamUtil.getString(actionRequest, AxHrmsEmployeeOnboardingHrWebPortletConstants.NDA);
            String asset = ParamUtil.getString(actionRequest, AxHrmsEmployeeOnboardingHrWebPortletConstants.ASSET);
            String mailAndBiometrics = ParamUtil.getString(actionRequest, AxHrmsEmployeeOnboardingHrWebPortletConstants.MAIL_AND_BIOMETRICS);
            employeeOffBoarding.setKt(kt.equals("on"));
            employeeOffBoarding.setNda(nda.equals("on"));
            employeeOffBoarding.setAssets(asset.equals("on"));
            employeeOffBoarding.setMailAndBiometrics(mailAndBiometrics.equals("on"));
        }


        long file1Id = uploadLettersToDLFileEntry(actionRequest, employeeId, "file1", "Experience Letter");
        if (file1Id > 0) {
            if (employeeOffBoarding.getExperienceLetterId() > 0) {
                DLFileEntryLocalServiceUtil.deleteDLFileEntry(employeeOffBoarding.getExperienceLetterId());
            }
            employeeOffBoarding.setExperienceLetterId(file1Id);
        }
        long file2Id = uploadLettersToDLFileEntry(actionRequest, employeeId, "file2", "Relieving Letter");
        if (file2Id > 0) {
            if (employeeOffBoarding.getRelievingLetterId() > 0) {
                DLFileEntryLocalServiceUtil.deleteDLFileEntry(employeeOffBoarding.getRelievingLetterId());
            }

            employeeOffBoarding.setRelievingLetterId(file2Id);
        }

        String fullAndFinal = ParamUtil.getString(actionRequest, "fullAndFinal");
        if (!fullAndFinal.isEmpty()) {
            employeeOffBoarding.setFullAndFinal(fullAndFinal);
        }

        employeeOffBoardingLocalService.updateEmployeeOffBoarding(employeeOffBoarding);
        if (checkOffBoardingCompleteness(employeeOffBoarding) && offBoard.equals(AxHrmsEmployeeOnboardingHrWebPortletConstants.OFF_BOARD)) {
            terminateEmployee(employeeId);
            try {
                Group group = GroupLocalServiceUtil.fetchGroup(PortalUtil.getDefaultCompanyId(), "Guest");
                String fromName = PrefsPropsUtil.getString(group.getCompanyId(), PropsKeys.ADMIN_EMAIL_FROM_NAME);
                String fromEmailAddress = PrefsPropsUtil.getString(group.getCompanyId(), PropsKeys.ADMIN_EMAIL_FROM_ADDRESS);

                String body = mailTemplateConfiguration.employeeOffBoardingMailBody();
                body = body.replace("${EMPLOYEE_DETAILS}",employeeDetails.getFirstName()  + " " + employeeDetails.getLastName());
                body = body.replace("${FULL_AND_FINAL_DETAILS}", employeeOffBoarding.getFullAndFinal());


                InternetAddress toAddress = null;
                try {
                    toAddress = new InternetAddress(employeeDetails.getPersonalEmail());
                } catch (AddressException e) {
                    log.info("Address exception");
                }
                MailMessage mailMessage = new MailMessage();
                mailMessage.setHTMLFormat(true);
                mailMessage.setSubject(mailTemplateConfiguration.employeeOffBoardingMailSubject());
                mailMessage.setBody(body);
                try {
                    mailMessage.setFrom(new InternetAddress(fromEmailAddress, fromName));
                } catch (UnsupportedEncodingException e) {
                    log.error("Encoding error");
                }
                //adding 2 files
                DLFileEntry dlFileEntry1 = DLFileEntryLocalServiceUtil.getDLFileEntry(employeeOffBoarding.getRelievingLetterId());
                DLFileEntry dlFileEntry2 = DLFileEntryLocalServiceUtil.getDLFileEntry(employeeOffBoarding.getExperienceLetterId());
                File file2 = axHrmsCommonApi.convertDLFileEntryToFile(employeeOffBoarding.getExperienceLetterId());
                File file1 = axHrmsCommonApi.convertDLFileEntryToFile(employeeOffBoarding.getRelievingLetterId());
                mailMessage.addFileAttachment(file1, dlFileEntry1.getFileName());
                mailMessage.addFileAttachment(file2, dlFileEntry2.getFileName());
                mailMessage.setTo(toAddress);
                MailServiceUtil.sendEmail(mailMessage);
            }catch (Exception e){
                log.error("Error sending the Full and final mail.");
            }
            //setting the session message
            SessionMessages.add(actionRequest, "off-boarded");
        } else {
            SessionMessages.add(actionRequest, "draft-saved");
            MutableRenderParameters renderParams = actionResponse.getRenderParameters();
            renderParams.setValue("mvcRenderCommandName", "/employeeOffBoarding");
        }
    }

    private boolean checkOffBoardingCompleteness(EmployeeOffBoarding employeeOffBoarding) {
        boolean isComplete = employeeOffBoarding.getKt();

        if (!employeeOffBoarding.getAssets()) {
            isComplete = false;
        }
        if (!employeeOffBoarding.getNda()) {
            isComplete = false;
        }
        if (!employeeOffBoarding.getMailAndBiometrics()) {
            isComplete = false;
        }
        if (employeeOffBoarding.getExperienceLetterId() == 0) {
            isComplete = false;
        }
        if (employeeOffBoarding.getRelievingLetterId() == 0) {
            isComplete = false;
        }
        if (employeeOffBoarding.getFullAndFinal().isEmpty()) {
            isComplete = false;
        }

        return isComplete;
    }

    private void terminateEmployee(long employeeId) throws PortalException {
        EmployeeDetails employeeDetails = employeeDetailsLocalService.getEmployeeDetails(employeeId);
        long userId = employeeDetails.getLrUserId();
        // Fetch all roles associated with the user
//        List<Role> roles = RoleLocalServiceUtil.getUserRoles(userId);

        User user = UserLocalServiceUtil.getUser(employeeDetails.getLrUserId());
        user.getRoles().forEach(role -> {
            try {
                UserLocalServiceUtil.deleteRoleUser(role.getRoleId(), user);
            } catch (PortalException e) {
                e.printStackTrace();
            }
        });

//        // Remove each role from the user
//        for (Role role : roles) {
//            RoleLocalServiceUtil.deleteUserRole(userId, role.getRoleId());
//        }

        // Delete the user
        UserLocalServiceUtil.deleteUser(userId);

        // mark as terminated
//
//        CustomUserLocalServiceWrapper customUserLocalServiceWrapper = new CustomUserLocalServiceWrapper();
//        customUserLocalServiceWrapper.deleteUser(employeeDetails.getLrUserId());
        employeeDetails.setIsTerminated(true);
        employeeDetailsLocalService.updateEmployeeDetails(employeeDetails);
    }

    private Folder folderNavigatorForOffBoardingFileUpload(String folderName, long employeeId, ThemeDisplay themeDisplay, ServiceContext serviceContext) throws PortalException {
        Folder folder = null;
        EmployeeDetails employeeDetails = employeeDetailsLocalService.getEmployeeDetails(employeeId);
        String empFolderName = employeeDetails.getFirstName() + StringPool.DASH + employeeDetails.getLastName();

        folder = axHrmsCommonApi.createFolder(AxHrmsEmployeeOnboardingHrWebPortletConstants.OFF_BOARDING, 0, themeDisplay, serviceContext);
        folder = axHrmsCommonApi.createFolder(empFolderName, folder.getFolderId(), themeDisplay, serviceContext);
        folder = axHrmsCommonApi.createFolder(folderName, folder.getFolderId(), themeDisplay, serviceContext);
        return folder;
    }

    private boolean areAllCheckBoxSaved(EmployeeOffBoarding employeeOffBoarding) {
        return employeeOffBoarding.getKt() && employeeOffBoarding.getNda() && employeeOffBoarding.getAssets() && employeeOffBoarding.getMailAndBiometrics();
    }

    private long uploadLettersToDLFileEntry(ActionRequest actionRequest, long employeeId, String fieldName, String documentFolder) throws PortalException {
        ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
        UploadPortletRequest uploadPortletRequest = PortalUtil.getUploadPortletRequest(actionRequest);
        ServiceContext serviceContext = ServiceContextFactory.getInstance(Folder.class.getName(), actionRequest);
        serviceContext.setAddGroupPermissions(true);
        serviceContext.setAddGuestPermissions(false);
        File file1 = uploadPortletRequest.getFile(fieldName);
        String file1Name = "";
        long length;
        try {
            length = file1.length();
        } catch (Exception e) {
            length = 0;
        }
        file1Name = uploadPortletRequest.getFileName(fieldName);
        if (file1Name != null && !file1Name.isEmpty() && length != 0) {
            Folder folder1 = folderNavigatorForOffBoardingFileUpload(documentFolder, employeeId, themeDisplay, serviceContext);
            FileEntry entry1 = DLAppLocalServiceUtil.addFileEntry(themeDisplay.getUserId(), themeDisplay.getScopeGroupId(), folder1.getFolderId(), file1Name, MimeTypesUtil.getContentType(file1), file1Name, StringPool.BLANK, StringPool.BLANK, file1, serviceContext);
            return entry1.getFileEntryId();
        } else {
            return 0;
        }
    }
}
