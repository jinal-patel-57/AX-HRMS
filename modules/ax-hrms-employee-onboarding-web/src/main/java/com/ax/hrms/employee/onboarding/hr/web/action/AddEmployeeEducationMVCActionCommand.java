package com.ax.hrms.employee.onboarding.hr.web.action;
import com.ax.hrms.common.api.api.AxHrmsCommonApi;
import com.ax.hrms.employee.onboarding.web.constants.AxHrmsEmployeeOnBoardingEmployeeConstants;
import com.ax.hrms.employee.onboarding.web.constants.AxHrmsEmployeeOnboardingWebPortletKeys;
import com.ax.hrms.model.EmployeeDetails;
import com.ax.hrms.model.EmployeeEducation;
import com.ax.hrms.service.EmployeeDetailsLocalService;
import com.ax.hrms.service.EmployeeEducationLocalService;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.document.library.kernel.service.DLAppLocalServiceUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.repository.model.Folder;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.*;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, property = {
		"javax.portlet.name=" + AxHrmsEmployeeOnboardingWebPortletKeys.AX_HRMS_EMPLOYEE_ONBOARDING_HR_WEB,
		"mvc.command.name=/addEditEmployeeEducationURL" }, service = MVCActionCommand.class)
public class AddEmployeeEducationMVCActionCommand extends BaseMVCActionCommand {

	@Reference
	EmployeeEducationLocalService employeeEducationLocalService;

	@Reference
	EmployeeDetailsLocalService employeeDetailsLocalService;

    @Reference
    AxHrmsCommonApi axHrmsCommonApi;
	private Log log = LogFactoryUtil.getLog(AddEmployeeEducationMVCActionCommand.class);

	private List<Long> educationIds = new ArrayList<>();

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
        ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		log.info("AddEmployeeEducationMVCActionCommand >>> doProcessAction ::: Action Called :::");
		long employeeId = ParamUtil.getLong(actionRequest, AxHrmsEmployeeOnBoardingEmployeeConstants.EMPLOYEE_ID);
		int currentIndex = ParamUtil.getInteger(actionRequest, AxHrmsEmployeeOnBoardingEmployeeConstants.EDUCATION_CURRENT_INDEX, 1);

        log.info("education size :- "+ educationIds.size());

        UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(actionRequest);
        ServiceContext serviceContext = ServiceContextFactory.getInstance(Folder.class.getName(), actionRequest);
        serviceContext.setAddGroupPermissions(true);
        serviceContext.setAddGuestPermissions(false);

        Folder folder = axHrmsCommonApi.createFolder(AxHrmsEmployeeOnBoardingEmployeeConstants.HRMS_DOCUMENT, 0, themeDisplay, serviceContext);

        String parentFolderName = String.valueOf(themeDisplay.getUser().getScreenName() + themeDisplay.getUserId());

        Folder parentfolder = axHrmsCommonApi.createFolder(parentFolderName, folder.getFolderId(), themeDisplay,serviceContext);

        Folder educationCertificateFolder = axHrmsCommonApi.createFolder(AxHrmsEmployeeOnBoardingEmployeeConstants.EDUCATION_CERTIFICATE, parentfolder.getFolderId(),themeDisplay, serviceContext);

        log.info("Step 1");

        for (int index = 1; index <= educationIds.size(); index++) {
			Long educationId = educationIds.get(index - 1);
			log.info("AddEmployeeEducationMVCActionCommand >>> doProcessAction ::: update called ::: ");
			try {

				log.info("AddEmployeeEducationMVCActionCommand >>> doProcessAction ::: Updating record with experience ID " + educationId);
				int dynamicIndex = index;

				long levelName = ParamUtil.getLong(actionRequest, AxHrmsEmployeeOnBoardingEmployeeConstants.LEVEL_NAME + dynamicIndex);
				String institution = ParamUtil.getString(actionRequest, AxHrmsEmployeeOnBoardingEmployeeConstants.INSTITUTION + dynamicIndex);
				String degree = ParamUtil.getString(actionRequest, AxHrmsEmployeeOnBoardingEmployeeConstants.DEGREE + dynamicIndex);
				String startDate = ParamUtil.getString(actionRequest, AxHrmsEmployeeOnBoardingEmployeeConstants.START_DATE + dynamicIndex);
				String endDate = ParamUtil.getString(actionRequest, AxHrmsEmployeeOnBoardingEmployeeConstants.END_DATE + dynamicIndex);
				String passingYear = ParamUtil.getString(actionRequest, AxHrmsEmployeeOnBoardingEmployeeConstants.PASSING_YEAR + dynamicIndex);

				EmployeeEducation employeeEducation = employeeEducationLocalService.getEmployeeEducation(educationId);

				employeeEducation.setCompanyId(themeDisplay.getCompanyId());
				employeeEducation.setGroupId(themeDisplay.getScopeGroupId());
				employeeEducation.setCreatedBy(themeDisplay.getUserId());
				employeeEducation.setModifiedBy(themeDisplay.getUserId());
				employeeEducation.setLevelId(levelName);
				employeeEducation.setInstitution(institution);
				employeeEducation.setDegree(degree);

				SimpleDateFormat formatter = new SimpleDateFormat(AxHrmsEmployeeOnBoardingEmployeeConstants.DATE_FORMAT, Locale.ENGLISH);
				Date sDate = formatter.parse(startDate);
				Date eDate = formatter.parse(endDate);
				employeeEducation.setStartDate(sDate);
				employeeEducation.setEndDate(eDate);
				employeeEducation.setPassingYear(passingYear);

				EmployeeDetails employeeDetails = employeeDetailsLocalService.getEmployeeDetails(employeeId);
				employeeEducation.setEmployeeId(employeeDetails.getEmployeeId());
                log.info("Above side of u;load request.....");



                String fileField = "educationCertificateAttachment" + index;
                String uploadedFileName = generateFileName(uploadRequest.getFileName(fileField));
                File uploadedFile = uploadRequest.getFile(fileField);

                log.info("FileField :- "+ fileField);
                log.info("uploadedFileName :- "+ uploadedFileName);
                log.info("uploadedFile :- "+ uploadedFile);


                long oldEducationCertificationId = employeeEducation.getEducationCertificateMediaId();

                if (uploadedFile != null && uploadedFile.length() > 0 && Validator.isNotNull(uploadedFileName)) {
                    FileEntry fileEntry = DLAppLocalServiceUtil.addFileEntry(
                            themeDisplay.getUserId(),
                            themeDisplay.getScopeGroupId(),
                            educationCertificateFolder.getFolderId(),
                            uploadedFileName,
                            MimeTypesUtil.getContentType(uploadedFile),
                            uploadedFileName,
                            "",
                            "",
                            uploadedFile,
                            serviceContext
                    );
                    employeeEducation.setEducationCertificateMediaId(fileEntry.getFileEntryId());
                    log.info("New file added in the db.....");

                    if (oldEducationCertificationId > 0) {
                        try {
                            DLAppLocalServiceUtil.deleteFileEntry(oldEducationCertificationId);
                            log.info("Deleted old education certificate fileEntryId: " + oldEducationCertificationId);
                        } catch (Exception e) {
                            log.warn("Failed to delete old file entry: " + oldEducationCertificationId, e);
                        }
                    }
                }



                employeeEducationLocalService.updateEmployeeEducation(employeeEducation);
                log.info("Education updated successfully.");
            } catch (Exception e) {
				log.error("Error updating record with experience ID " + educationId + ": ", e);
			}
		}
        log.info("Step 2");

		for (int i = educationIds.size() + 1; i <= currentIndex; i++) {
			log.info("AddEmployeeEducationMVCActionCommand >>> doProcessAction ::: insert called :::");
			long levelName = ParamUtil.getLong(actionRequest, AxHrmsEmployeeOnBoardingEmployeeConstants.LEVEL_NAME + i);
			String institution = ParamUtil.getString(actionRequest, AxHrmsEmployeeOnBoardingEmployeeConstants.INSTITUTION + i);
			String degree = ParamUtil.getString(actionRequest, AxHrmsEmployeeOnBoardingEmployeeConstants.DEGREE + i);
			String startDate = ParamUtil.getString(actionRequest, AxHrmsEmployeeOnBoardingEmployeeConstants.START_DATE + i);
			String endDate = ParamUtil.getString(actionRequest, AxHrmsEmployeeOnBoardingEmployeeConstants.END_DATE + i);
			String passingYear = ParamUtil.getString(actionRequest, AxHrmsEmployeeOnBoardingEmployeeConstants.PASSING_YEAR + i);

			try {
				EmployeeEducation employeeEducation = employeeEducationLocalService.createEmployeeEducation(CounterLocalServiceUtil.increment(EmployeeEducation.class.getName()));
				employeeEducation.setCompanyId(themeDisplay.getCompanyId());
				employeeEducation.setGroupId(themeDisplay.getScopeGroupId());
				employeeEducation.setCreatedBy(themeDisplay.getUserId());
				employeeEducation.setModifiedBy(themeDisplay.getUserId());
				employeeEducation.setLevelId(levelName);
				employeeEducation.setInstitution(institution);
				employeeEducation.setDegree(degree);
				long educationId = employeeEducation.getEducationId();
				educationIds.add(educationId);
			    
				SimpleDateFormat formatter = new SimpleDateFormat(AxHrmsEmployeeOnBoardingEmployeeConstants.DATE_FORMAT, Locale.ENGLISH);
				Date sDate = formatter.parse(startDate);
				Date eDate = formatter.parse(endDate);
				employeeEducation.setStartDate(sDate);
				employeeEducation.setEndDate(eDate);
				employeeEducation.setPassingYear(passingYear);
				
				EmployeeDetails employeeDetails = employeeDetailsLocalService.getEmployeeDetails(employeeId);
				employeeEducation.setEmployeeId(employeeDetails.getEmployeeId());

                String fileField = "educationCertificateAttachment" + i;
                String uploadedFileName = generateFileName(uploadRequest.getFileName(fileField));
                File uploadedFile = uploadRequest.getFile(fileField);

                log.info("FileField :- "+ fileField);
                log.info("uploadedFileName :- "+ uploadedFileName);
                log.info("uploadedFile :- "+ uploadedFile);




                if (uploadedFile != null && uploadedFile.length() > 0 && Validator.isNotNull(uploadedFileName)) {
                    FileEntry fileEntry = DLAppLocalServiceUtil.addFileEntry(
                            themeDisplay.getUserId(),
                            themeDisplay.getScopeGroupId(),
                            educationCertificateFolder.getFolderId(),
                            uploadedFileName,
                            MimeTypesUtil.getContentType(uploadedFile),
                            uploadedFileName,
                            "",
                            "",
                            uploadedFile,
                            serviceContext
                    );
                    employeeEducation.setEducationCertificateMediaId(fileEntry.getFileEntryId());
                    log.info("New file added in the db.....");
                }

				employeeEducationLocalService.addEmployeeEducation(employeeEducation);
                log.info("Education details addedd.............");
			} catch (Exception e) {
                e.printStackTrace();
				e.getMessage();
			}
		}
        log.info("Step  last");

        actionRequest.setAttribute("employeeId", ParamUtil.getLong(actionRequest,"employeeId"));
	}
    private String generateFileName(String original) {
        String timestamp = String.valueOf(System.currentTimeMillis());
        return timestamp + "_" + original.replaceAll("\\s+", "_");
    }
}

