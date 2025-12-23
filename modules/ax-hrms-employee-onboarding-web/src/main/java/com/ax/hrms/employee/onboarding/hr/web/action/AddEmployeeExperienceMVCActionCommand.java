package com.ax.hrms.employee.onboarding.hr.web.action;
import com.ax.hrms.common.api.api.AxHrmsCommonApi;
import com.ax.hrms.employee.onboarding.web.constants.AxHrmsEmployeeOnBoardingEmployeeConstants;
import com.ax.hrms.employee.onboarding.web.constants.AxHrmsEmployeeOnboardingWebPortletKeys;
import com.ax.hrms.model.EmployeeDetails;
import com.ax.hrms.model.EmployeeEducation;
import com.ax.hrms.model.EmployeeExperience;
import com.ax.hrms.service.EmployeeDetailsLocalService;
import com.ax.hrms.service.EmployeeExperienceLocalService;
import com.liferay.adaptive.media.exception.AMRuntimeException.IOException;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.document.library.kernel.model.DLVersionNumberIncrease;
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
import com.liferay.portal.kernel.util.MimeTypesUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, property = {
		"javax.portlet.name=" + AxHrmsEmployeeOnboardingWebPortletKeys.AX_HRMS_EMPLOYEE_ONBOARDING_HR_WEB,
		"mvc.command.name=/addEditEmployeeExperienceURL" }, service = MVCActionCommand.class)
public class AddEmployeeExperienceMVCActionCommand extends BaseMVCActionCommand {

	@Reference
	EmployeeExperienceLocalService employeeExperienceLocalService;

	@Reference
	EmployeeDetailsLocalService employeeDetailsLocalService;

	@Reference
	AxHrmsCommonApi axHrmsCommonApi;
	
	@Reference
	UserLocalService userLocalService;

	private static Log log = LogFactoryUtil.getLog(AddEmployeeExperienceMVCActionCommand.class);

	private List<Long> experienceIds = new ArrayList<>();

	 long fileEntryId = 0;

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		
		EmployeeExperience employeeExperience = null;
		
		log.info("AddEmployeeExperienceMVCActionCommand >>> doProcessAction ::: Action Called :::");

		long employeeId = ParamUtil.getLong(actionRequest,AxHrmsEmployeeOnBoardingEmployeeConstants.EMPLOYEE_ID);
		EmployeeDetails employeeDetails = employeeDetailsLocalService.getEmployeeDetails(employeeId);
		User employeeUser = userLocalService.getUser(employeeDetails.getLrUserId());
		
		boolean firstVisit = ParamUtil.getBoolean(actionRequest, AxHrmsEmployeeOnBoardingEmployeeConstants.FIRST_VISIT);

		if (firstVisit)experienceIds.clear();
		
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
		int currentIndex = ParamUtil.getInteger(actionRequest, AxHrmsEmployeeOnBoardingEmployeeConstants.CURRENT_INDEX,1);

		log.info("AddEmployeeExperienceMVCActionCommand >>> doProcessAction ::: " + currentIndex);

		ServiceContext serviceContext = ServiceContextFactory.getInstance(Folder.class.getName(), actionRequest);
		serviceContext.setAddGroupPermissions(true);
		serviceContext.setAddGuestPermissions(false);

		Folder folder = axHrmsCommonApi.createFolder(AxHrmsEmployeeOnBoardingEmployeeConstants.HRMS_DOCUMENT, 0, themeDisplay, serviceContext);

		String parentFolderName = String.valueOf(themeDisplay.getUser().getScreenName() + themeDisplay.getUserId());

		Folder parentfolder = axHrmsCommonApi.createFolder(parentFolderName, folder.getFolderId(), themeDisplay,serviceContext);

		Folder profilePictureFolder = axHrmsCommonApi.createFolder(AxHrmsEmployeeOnBoardingEmployeeConstants.EXPERIENCE_CERTIFICATE, parentfolder.getFolderId(),themeDisplay, serviceContext);

		List<Long> experienceIds =
			    employeeExperienceLocalService.findByEmployeeId(employeeId)
			        .stream()
			        .map(EmployeeExperience::getExperienceId)
			        .collect(Collectors.toList());
		
		for (int index = 1; index <= experienceIds.size(); index++) {
			
			Long experienceId = experienceIds.get(index - 1);
			
			try {
				
				log.info("AddEmployeeExperienceMVCActionCommand >>> doProcessAction ::: Updating record with experience ID " + experienceId);
				int dynamicIndex = index;

				String companyName = ParamUtil.getString(actionRequest,AxHrmsEmployeeOnBoardingEmployeeConstants.COMPANY_NAME + dynamicIndex);
				String joiningDateStr = ParamUtil.getString(actionRequest,AxHrmsEmployeeOnBoardingEmployeeConstants.JOINING_DATE + dynamicIndex);
				String relievingDateStr = ParamUtil.getString(actionRequest,AxHrmsEmployeeOnBoardingEmployeeConstants.RELIEVING_DATE + dynamicIndex);

				employeeExperience = employeeExperienceLocalService.getEmployeeExperience(experienceId);

				UploadPortletRequest uploadPortletRequest = PortalUtil.getUploadPortletRequest(actionRequest);
				
				String fileName = generateFileName(uploadPortletRequest.getFileName(AxHrmsEmployeeOnBoardingEmployeeConstants.EXPERIENCE_CERTIFICATE_ATTACHEMENT + dynamicIndex));

				File file = uploadPortletRequest.getFile(AxHrmsEmployeeOnBoardingEmployeeConstants.EXPERIENCE_CERTIFICATE_ATTACHEMENT + dynamicIndex);

				long existingFileEntryId = employeeExperience.getExperienceCertificateMediaId();

				if (file != null && file.exists() && fileName != null && file.length()>0) {
					try {
						
						long userId = themeDisplay.getUserId();
						
						DLVersionNumberIncrease dlVersionNumberIncrease = DLVersionNumberIncrease.MAJOR;

						FileEntry fileEntry = DLAppLocalServiceUtil.addFileEntry(userId, themeDisplay.getScopeGroupId(), profilePictureFolder.getFolderId(), fileName,
						            MimeTypesUtil.getContentType(file), fileName, "", "", file, serviceContext);
						    
						    employeeExperience.setExperienceCertificateMediaId(fileEntry.getFileEntryId());
						    log.info("New file added in the db.....");
				
						    if (existingFileEntryId > 0) {
						        try {
						            DLAppLocalServiceUtil.deleteFileEntry(existingFileEntryId);
						            log.info("Deleted old experience certificate fileEntryId: " + existingFileEntryId);
						        } catch (Exception e) {
						            log.warn("Failed to delete old file entry: " + existingFileEntryId, e);
						        }
						    }
						
					}catch(Exception e) {
						log.error("error while updating file entry -- " + e.getMessage());
					}
				} else {
					log.error("Error: File does not exist or file name is null");
				}
				
				employeeExperience.setCompanyName(companyName);
				SimpleDateFormat formatter = new SimpleDateFormat(AxHrmsEmployeeOnBoardingEmployeeConstants.DATE_FORMAT,Locale.ENGLISH);
				if(Validator.isNotNull(joiningDateStr) && !joiningDateStr.isBlank()) {
					Date joiningDate = formatter.parse(joiningDateStr);
					employeeExperience.setJoiningDate(joiningDate);
				}
				if(Validator.isNotNull(relievingDateStr) && !relievingDateStr.isBlank()) {
					Date relievingDate = formatter.parse(relievingDateStr);
					employeeExperience.setRelievingDate(relievingDate);
				}

				employeeExperienceLocalService.updateEmployeeExperience(employeeExperience);
			} catch (Exception e) {
				log.error("Error updating record with experience ID " + experienceId + ": ", e);
			}
		}

		for (int i = experienceIds.size() + 1; i <= currentIndex; i++) {

			String companyName = ParamUtil.getString(actionRequest,AxHrmsEmployeeOnBoardingEmployeeConstants.COMPANY_NAME + i);
			String joiningDate = ParamUtil.getString(actionRequest,AxHrmsEmployeeOnBoardingEmployeeConstants.JOINING_DATE + i);
			String relievingDate = ParamUtil.getString(actionRequest,AxHrmsEmployeeOnBoardingEmployeeConstants.RELIEVING_DATE + i);
			try {
				employeeExperience = employeeExperienceLocalService.createEmployeeExperience(CounterLocalServiceUtil.increment(EmployeeExperience.class.getName()));

				employeeExperience.setCompanyId(themeDisplay.getCompanyId());
				employeeExperience.setGroupId(themeDisplay.getScopeGroupId());
				employeeExperience.setCreatedBy(themeDisplay.getUserId());
				employeeExperience.setModifiedBy(themeDisplay.getUserId());
				employeeExperience.setCompanyName(companyName);

				long experienceId = employeeExperience.getExperienceId();
				experienceIds.add(experienceId);

				UploadPortletRequest uploadPortletRequest = PortalUtil.getUploadPortletRequest(actionRequest);
				String fileName = uploadPortletRequest.getFileName(AxHrmsEmployeeOnBoardingEmployeeConstants.EXPERIENCE_CERTIFICATE_ATTACHEMENT + i);
				File file = uploadPortletRequest.getFile(AxHrmsEmployeeOnBoardingEmployeeConstants.EXPERIENCE_CERTIFICATE_ATTACHEMENT + i);

				if (file != null && file.exists() && fileName != null) {
					try {
						FileEntry entry = DLAppLocalServiceUtil.addFileEntry(themeDisplay.getUserId(),themeDisplay.getScopeGroupId(), profilePictureFolder.getFolderId(), fileName,MimeTypesUtil.getContentType(file), fileName, StringPool.BLANK, StringPool.BLANK, file,serviceContext);
						log.info("AddEmployeeExperienceMVCActionCommand >>> doProcessAction ::: entry ==>" + entry.getFileEntryId());
						employeeExperience.setExperienceCertificateMediaId(entry.getFileEntryId());
						fileEntryId = employeeExperience.getExperienceCertificateMediaId();
					} catch(Exception e) {
						log.error("error while uploading file -- " + e.getMessage());
					}
				} else {
					log.error("error when upload file");
				}

				SimpleDateFormat formatter = new SimpleDateFormat(AxHrmsEmployeeOnBoardingEmployeeConstants.DATE_FORMAT,Locale.ENGLISH);
				Date jDate = formatter.parse(joiningDate);
				Date rDate = formatter.parse(relievingDate);
				employeeExperience.setJoiningDate(jDate);
				employeeExperience.setRelievingDate(rDate);
				employeeExperience.setEmployeeId(employeeDetails.getEmployeeId());
				employeeExperienceLocalService.addEmployeeExperience(employeeExperience);
			} catch (Exception e) {
				e.getMessage();
			}
			
			actionRequest.setAttribute("employeeId", ParamUtil.getLong(actionRequest,"employeeId"));
		}
	}
	
	private String generateFileName(String original) {
	    String timestamp = String.valueOf(System.currentTimeMillis());
	    return timestamp + "_" + original.replaceAll("\\s+", "_");
	}

	public byte[] readFileContent(File file) throws IOException, java.io.IOException {
		try (FileInputStream fis = new FileInputStream(file);
				ByteArrayOutputStream baos = new ByteArrayOutputStream()) {

			byte[] buffer = new byte[1024];
			int bytesRead;

			while ((bytesRead = fis.read(buffer)) != -1) {
				baos.write(buffer, 0, bytesRead);
			}
			return baos.toByteArray();
		}
	}
}