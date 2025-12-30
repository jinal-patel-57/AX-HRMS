package com.ax.hrms.employee.onboarding.hr.web.action;

import com.ax.hrms.common.api.api.AxHrmsCommonApi;
import com.ax.hrms.employee.onboarding.web.constants.AxHrmsEmployeeOnBoardingEmployeeConstants;
import com.ax.hrms.employee.onboarding.web.constants.AxHrmsEmployeeOnboardingWebPortletKeys;
import com.ax.hrms.model.EmployeeDetails;
import com.ax.hrms.model.EmployeeExperience;
import com.ax.hrms.service.EmployeeDetailsLocalService;
import com.ax.hrms.service.EmployeeExperienceLocalService;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.document.library.kernel.service.DLAppLocalServiceUtil;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.repository.model.Folder;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.*;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@Component(immediate = true, property = {"javax.portlet.name=" + AxHrmsEmployeeOnboardingWebPortletKeys.AX_HRMS_EMPLOYEE_ONBOARDING_HR_WEB, "mvc.command.name=/addEditEmployeeExperienceURL"}, service = MVCActionCommand.class)
public class AddEmployeeExperienceMVCActionCommand extends BaseMVCActionCommand {

    private static final Log log = LogFactoryUtil.getLog(AddEmployeeExperienceMVCActionCommand.class);

    @Reference
    private EmployeeExperienceLocalService employeeExperienceLocalService;

    @Reference
    private EmployeeDetailsLocalService employeeDetailsLocalService;

    @Reference
    private AxHrmsCommonApi axHrmsCommonApi;

    @Reference
    private UserLocalService userLocalService;

    @Override
    protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {

        log.info("HR Experience Action Called");
        try {

            ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);

            long employeeId = ParamUtil.getLong(actionRequest, AxHrmsEmployeeOnBoardingEmployeeConstants.EMPLOYEE_ID);

            int currentIndex = ParamUtil.getInteger(actionRequest, AxHrmsEmployeeOnBoardingEmployeeConstants.CURRENT_INDEX, 1);

            EmployeeDetails employeeDetails = employeeDetailsLocalService.getEmployeeDetails(employeeId);

            User employeeUser = userLocalService.getUser(employeeDetails.getLrUserId());

            ServiceContext serviceContext = ServiceContextFactory.getInstance(Folder.class.getName(), actionRequest);
            serviceContext.setAddGroupPermissions(true);
            serviceContext.setAddGuestPermissions(false);

            Folder rootFolder = axHrmsCommonApi.createFolder(AxHrmsEmployeeOnBoardingEmployeeConstants.HRMS_DOCUMENT, 0, themeDisplay, serviceContext);

            Folder userFolder = axHrmsCommonApi.createFolder(employeeUser.getScreenName() + employeeUser.getUserId(), rootFolder.getFolderId(), themeDisplay, serviceContext);

            Folder experienceFolder = axHrmsCommonApi.createFolder(AxHrmsEmployeeOnBoardingEmployeeConstants.EXPERIENCE_CERTIFICATE, userFolder.getFolderId(), themeDisplay, serviceContext);

            List<Long> experienceIds = employeeExperienceLocalService.findByEmployeeId(employeeId).stream().map(EmployeeExperience::getExperienceId).collect(Collectors.toList());

            SimpleDateFormat formatter = new SimpleDateFormat(AxHrmsEmployeeOnBoardingEmployeeConstants.DATE_FORMAT, Locale.ENGLISH);

            UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(actionRequest);

            /* ================= UPDATE EXISTING RECORDS ================= */
            int existingCount = experienceIds.size();

            for (int i = 1; i <= experienceIds.size(); i++) {
                log.info("update time");
                log.info("employee id :-" + employeeId);

                String joiningDateStr = ParamUtil.getString(actionRequest, AxHrmsEmployeeOnBoardingEmployeeConstants.JOINING_DATE + i);

                String relievingDateStr = ParamUtil.getString(actionRequest, AxHrmsEmployeeOnBoardingEmployeeConstants.RELIEVING_DATE + i);

                if (Validator.isNull(joiningDateStr) || Validator.isNull(relievingDateStr)) {

                    log.info("HR: Skipping empty existing row index = " + i);
                    continue;
                }

                EmployeeExperience experience = employeeExperienceLocalService.getEmployeeExperience(experienceIds.get(i - 1));

                log.info("experience id :-" + experienceIds.get(i - 1));
                String inputName = AxHrmsEmployeeOnBoardingEmployeeConstants.EXPERIENCE_CERTIFICATE_ATTACHEMENT + i;

                File[] files = uploadRequest.getFiles(inputName);
                String[] fileNames = uploadRequest.getFileNames(inputName);


                // Existing attachments
                String existingMediaIds = experience.getExperienceCertificateMediaId();
                log.info("existingMediaIds :-" + existingMediaIds);


                experience.setCompanyName(ParamUtil.getString(actionRequest, AxHrmsEmployeeOnBoardingEmployeeConstants.COMPANY_NAME + i));

                experience.setJoiningDate(formatter.parse(joiningDateStr));
                experience.setRelievingDate(formatter.parse(relievingDateStr));


                boolean hasNewFiles = hasValidUpload(files);

                if (hasNewFiles) {

                    // delete ONLY this experience old files
                    String oldMediaIds = experience.getExperienceCertificateMediaId();

                    if (Validator.isNotNull(oldMediaIds)) {
                        for (String id : oldMediaIds.split(StringPool.COMMA)) {
                            DLAppLocalServiceUtil.deleteFileEntry(Long.parseLong(id));
                        }
                    }

                    StringBuilder mediaIdsBuilder = new StringBuilder();

                    if (files != null && files.length > 0) {

                        for (int f = 0; f < files.length; f++) {

                            File file = files[f];
                            String fileName = generateFileName(fileNames[f]);
                            log.info("fileName :-" + fileName);
                            if (file != null && file.exists() && file.length() > 0) {
                                FileEntry entry = DLAppLocalServiceUtil.addFileEntry(themeDisplay.getUserId(), themeDisplay.getScopeGroupId(), experienceFolder.getFolderId(), fileName, MimeTypesUtil.getContentType(file), fileName, StringPool.BLANK, StringPool.BLANK, file, serviceContext);

                                log.info("UPDATE Experience >>> Uploaded FileEntryId = " + entry.getFileEntryId());

                                if (mediaIdsBuilder.length() > 0) {
                                    mediaIdsBuilder.append(StringPool.COMMA);
                                }

                                mediaIdsBuilder.append(entry.getFileEntryId());
                            }
                        }
                        experience.setExperienceCertificateMediaId(mediaIdsBuilder.toString());
                    }
                }

                employeeExperienceLocalService.updateEmployeeExperience(experience);
            }

            UploadPortletRequest uploadPortletRequest = PortalUtil.getUploadPortletRequest(actionRequest);

            /* ================= ADD NEW RECORDS ================= */

            for (int i = existingCount + 1; i <= currentIndex; i++) {
                log.info("add data");
                log.info("employee id :-" + employeeId);

                String joiningDateStr = ParamUtil.getString(actionRequest, AxHrmsEmployeeOnBoardingEmployeeConstants.JOINING_DATE + i);

                String relievingDateStr = ParamUtil.getString(actionRequest, AxHrmsEmployeeOnBoardingEmployeeConstants.RELIEVING_DATE + i);

                if (Validator.isNull(joiningDateStr) || Validator.isNull(relievingDateStr)) {

                    log.info("HR: Skipping empty new row index = " + i);
                    continue;
                }

                EmployeeExperience experience = employeeExperienceLocalService.createEmployeeExperience(CounterLocalServiceUtil.increment(EmployeeExperience.class.getName()));

                experience.setCompanyId(themeDisplay.getCompanyId());
                experience.setGroupId(themeDisplay.getScopeGroupId());
                experience.setCreatedBy(themeDisplay.getUserId());
                experience.setModifiedBy(themeDisplay.getUserId());
                experience.setEmployeeId(employeeId);

                experience.setCompanyName(ParamUtil.getString(actionRequest, AxHrmsEmployeeOnBoardingEmployeeConstants.COMPANY_NAME + i));

                experience.setJoiningDate(formatter.parse(joiningDateStr));
                experience.setRelievingDate(formatter.parse(relievingDateStr));

                // Handle multiple attachments
                String inputName = AxHrmsEmployeeOnBoardingEmployeeConstants.EXPERIENCE_CERTIFICATE_ATTACHEMENT + i;
                File[] files = uploadPortletRequest.getFiles(inputName);
                String[] fileNames = uploadPortletRequest.getFileNames(inputName);
                log.info("ADD Experience >>> File input name: " + inputName);
                if (files != null) {
                    log.info("ADD Experience >>> Total files received: " + files.length);
                } else {
                    log.info("ADD Experience >>> No files received (files array is null)");
                }
                StringBuilder mediaIdsBuilder = new StringBuilder();

                if (files != null && files.length > 0) {

                    for (int f = 0; f < files.length; f++) {
                        File file = files[f];
                        String fileName = generateFileName(fileNames[f]);
                        log.info("ADD Experience >>> Processing file index: " + f);
                        log.info("ADD Experience >>> Original File Name: " + fileName);

                        if (file != null && file.exists() && fileName != null) {
                            FileEntry entry = DLAppLocalServiceUtil.addFileEntry(themeDisplay.getUserId(), themeDisplay.getScopeGroupId(), experienceFolder.getFolderId(), fileName, MimeTypesUtil.getContentType(file), fileName, StringPool.BLANK, StringPool.BLANK, file, serviceContext);
                            log.info("ADD Experience >>> File uploaded successfully, FileEntryId: " + entry.getFileEntryId());
                            if (mediaIdsBuilder.length() > 0) {
                                mediaIdsBuilder.append(StringPool.COMMA);
                            }
                            mediaIdsBuilder.append(entry.getFileEntryId());
                        }

                    }



                    experience.setExperienceCertificateMediaId(mediaIdsBuilder.toString());
                }

                employeeExperienceLocalService.addEmployeeExperience(experience);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private boolean hasValidUpload(File[] files) {
        if (files == null) return false;
        for (File file : files) {
            if (file != null && file.exists() && file.length() > 0) {
                return true;
            }
        }
        return false;
    }

    private String generateFileName(String original) {
        return System.currentTimeMillis() + "_" + original.replaceAll("\\s+", "_");
    }
}
