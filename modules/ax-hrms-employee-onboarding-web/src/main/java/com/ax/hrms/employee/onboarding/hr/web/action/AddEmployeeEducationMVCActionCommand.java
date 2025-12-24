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
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.repository.model.Folder;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.*;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
		immediate = true,
		property = {
				"javax.portlet.name=" + AxHrmsEmployeeOnboardingWebPortletKeys.AX_HRMS_EMPLOYEE_ONBOARDING_HR_WEB,
				"mvc.command.name=/addEditEmployeeEducationURL"
		},
		service = MVCActionCommand.class
)
public class AddEmployeeEducationMVCActionCommand extends BaseMVCActionCommand {

	private static final Log log =
			LogFactoryUtil.getLog(AddEmployeeEducationMVCActionCommand.class);

	@Reference
	private EmployeeEducationLocalService employeeEducationLocalService;

	@Reference
	private EmployeeDetailsLocalService employeeDetailsLocalService;

	@Reference
	private AxHrmsCommonApi axHrmsCommonApi;

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse)
			throws Exception {

		ThemeDisplay themeDisplay =
				(ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);

		long employeeId = ParamUtil.getLong(
				actionRequest,
				AxHrmsEmployeeOnBoardingEmployeeConstants.EMPLOYEE_ID
		);

		int currentIndex = ParamUtil.getInteger(
				actionRequest,
				AxHrmsEmployeeOnBoardingEmployeeConstants.EDUCATION_CURRENT_INDEX,
				1
		);

		UploadPortletRequest uploadRequest =
				PortalUtil.getUploadPortletRequest(actionRequest);

		ServiceContext serviceContext =
				ServiceContextFactory.getInstance(Folder.class.getName(), actionRequest);

		serviceContext.setAddGroupPermissions(true);
		serviceContext.setAddGuestPermissions(false);

		Folder rootFolder =
				axHrmsCommonApi.createFolder(
						AxHrmsEmployeeOnBoardingEmployeeConstants.HRMS_DOCUMENT,
						0,
						themeDisplay,
						serviceContext
				);

		Folder userFolder =
				axHrmsCommonApi.createFolder(
						themeDisplay.getUser().getScreenName() + themeDisplay.getUserId(),
						rootFolder.getFolderId(),
						themeDisplay,
						serviceContext
				);

		Folder educationFolder =
				axHrmsCommonApi.createFolder(
						AxHrmsEmployeeOnBoardingEmployeeConstants.EDUCATION_CERTIFICATE,
						userFolder.getFolderId(),
						themeDisplay,
						serviceContext
				);

		// ✅ FETCH EXISTING EDUCATION IDS FROM DB (CRITICAL FIX)
		List<Long> existingEducationIds =
				employeeEducationLocalService.findByEmployeeId(employeeId)
						.stream()
						.map(EmployeeEducation::getEducationId)
						.collect(Collectors.toList());

		SimpleDateFormat formatter =
				new SimpleDateFormat(
						AxHrmsEmployeeOnBoardingEmployeeConstants.DATE_FORMAT,
						Locale.ENGLISH
				);

        /* =====================================================
           UPDATE EXISTING RECORDS
           ===================================================== */
		for (int i = 1; i <= existingEducationIds.size(); i++) {

			long educationId = existingEducationIds.get(i - 1);
			EmployeeEducation education =
					employeeEducationLocalService.getEmployeeEducation(educationId);

			populateEducationFields(
					actionRequest,
					education,
					i,
					formatter,
					employeeId,
					themeDisplay
			);

			handleFileUpload(
					uploadRequest,
					education,
					"educationCertificateAttachment" + i,
					educationFolder,
					themeDisplay,
					serviceContext,
					true
			);

			employeeEducationLocalService.updateEmployeeEducation(education);
		}

        /* =====================================================
           INSERT NEW RECORDS
           ===================================================== */
		for (int i = existingEducationIds.size() + 1; i <= currentIndex; i++) {

			EmployeeEducation education =
					employeeEducationLocalService.createEmployeeEducation(
							CounterLocalServiceUtil.increment(
									EmployeeEducation.class.getName()
							)
					);

			populateEducationFields(
					actionRequest,
					education,
					i,
					formatter,
					employeeId,
					themeDisplay
			);

			handleFileUpload(
					uploadRequest,
					education,
					"educationCertificateAttachment" + i,
					educationFolder,
					themeDisplay,
					serviceContext,
					false
			);

			employeeEducationLocalService.addEmployeeEducation(education);
		}

		actionRequest.setAttribute("employeeId", employeeId);
	}

	/* =====================================================
       COMMON FIELD POPULATOR
       ===================================================== */
	private void populateEducationFields(
			ActionRequest request,
			EmployeeEducation education,
			int index,
			SimpleDateFormat formatter,
			long employeeId,
			ThemeDisplay themeDisplay
	) throws Exception {

		education.setCompanyId(themeDisplay.getCompanyId());
		education.setGroupId(themeDisplay.getScopeGroupId());
		education.setCreatedBy(themeDisplay.getUserId());
		education.setModifiedBy(themeDisplay.getUserId());

		education.setLevelId(
				ParamUtil.getLong(request,
						AxHrmsEmployeeOnBoardingEmployeeConstants.LEVEL_NAME + index)
		);

		education.setInstitution(
				ParamUtil.getString(request,
						AxHrmsEmployeeOnBoardingEmployeeConstants.INSTITUTION + index)
		);

		education.setDegree(
				ParamUtil.getString(request,
						AxHrmsEmployeeOnBoardingEmployeeConstants.DEGREE + index)
		);

		education.setStartDate(
				formatter.parse(
						ParamUtil.getString(request,
								AxHrmsEmployeeOnBoardingEmployeeConstants.START_DATE + index)
				)
		);

		education.setEndDate(
				formatter.parse(
						ParamUtil.getString(request,
								AxHrmsEmployeeOnBoardingEmployeeConstants.END_DATE + index)
				)
		);

		education.setPassingYear(
				ParamUtil.getString(request,
						AxHrmsEmployeeOnBoardingEmployeeConstants.PASSING_YEAR + index)
		);

		EmployeeDetails details =
				employeeDetailsLocalService.getEmployeeDetails(employeeId);

		education.setEmployeeId(details.getEmployeeId());
	}

	/* =====================================================
       FILE UPLOAD HANDLER (NULL SAFE)
       ===================================================== */
	private void handleFileUpload(
			UploadPortletRequest uploadRequest,
			EmployeeEducation education,
			String fileField,
			Folder folder,
			ThemeDisplay themeDisplay,
			ServiceContext serviceContext,
			boolean isUpdate
	) throws Exception {

		String originalFileName = uploadRequest.getFileName(fileField);
		File uploadedFile = uploadRequest.getFile(fileField);

		if (Validator.isNull(originalFileName)
				|| uploadedFile == null
				|| uploadedFile.length() == 0) {
			return;
		}

		String newFileName = generateFileName(originalFileName);

		FileEntry fileEntry =
				DLAppLocalServiceUtil.addFileEntry(
						themeDisplay.getUserId(),
						themeDisplay.getScopeGroupId(),
						folder.getFolderId(),
						newFileName,
						MimeTypesUtil.getContentType(uploadedFile),
						newFileName,
						"",
						"",
						uploadedFile,
						serviceContext
				);

		if (isUpdate && education.getEducationCertificateMediaId() > 0) {
			DLAppLocalServiceUtil.deleteFileEntry(
					education.getEducationCertificateMediaId()
			);
		}

		education.setEducationCertificateMediaId(
				fileEntry.getFileEntryId()
		);
	}

	private String generateFileName(String original) {
		return System.currentTimeMillis() + "_" + original.replaceAll("\\s+", "_");
	}
}
