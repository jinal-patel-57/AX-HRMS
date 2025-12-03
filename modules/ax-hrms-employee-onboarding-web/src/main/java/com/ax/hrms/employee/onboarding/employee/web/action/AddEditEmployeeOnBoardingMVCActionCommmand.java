package com.ax.hrms.employee.onboarding.employee.web.action;

import com.ax.hrms.common.api.api.AxHrmsCommonApi;

import com.ax.hrms.employee.onboarding.employee.web.util.EmployeeBasicDetailsUtil;
import com.ax.hrms.employee.onboarding.web.constants.AxHrmsEmployeeOnBoardingEmployeeConstants;
import com.ax.hrms.employee.onboarding.web.constants.AxHrmsEmployeeOnboardingWebPortletKeys;
import com.ax.hrms.model.EmployeeDetails;
import com.ax.hrms.service.EmployeeDetailsLocalService;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.repository.model.Folder;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Locale;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, property = {
		"javax.portlet.name=" + AxHrmsEmployeeOnboardingWebPortletKeys.AX_HRMS_EMPLOYEE_ONBOARDING_EMPLOYEE_WEB,
		"mvc.command.name=/addEditEmployeeOnBoarding" }, service = MVCActionCommand.class)
public class AddEditEmployeeOnBoardingMVCActionCommmand extends BaseMVCActionCommand {

	@Reference
	EmployeeDetailsLocalService employeeDetailsLocalService;

	@Reference
	AxHrmsCommonApi axHrmsCommonApi;

	private Log log = LogFactoryUtil.getLog(AddEditEmployeeOnBoardingMVCActionCommmand.class);

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		
		log.info("AddEditEmployeeOnBoardingMVCActionCommmand >>> doProcessAction ::: Action Called ::: ");

		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		ServiceContext serviceContext = ServiceContextFactory.getInstance(Folder.class.getName(), actionRequest);
		serviceContext.setAddGroupPermissions(true);
		serviceContext.setAddGuestPermissions(false);

		Folder folder = axHrmsCommonApi.createFolder(AxHrmsEmployeeOnBoardingEmployeeConstants.HRMS_DOCUMENT, 0, themeDisplay, serviceContext);
		Folder parentFolder = axHrmsCommonApi.createFolder(String.format("%s%d", themeDisplay.getUser().getScreenName(), themeDisplay.getUserId()),folder.getFolderId(), themeDisplay, serviceContext);
		Folder profilePictureFolder = axHrmsCommonApi.createFolder(AxHrmsEmployeeOnBoardingEmployeeConstants.PROFILE_PICTURE, parentFolder.getFolderId(),themeDisplay, serviceContext);

		UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(actionRequest);
		File file = uploadRequest.getFile(AxHrmsEmployeeOnBoardingEmployeeConstants.EMPLOYEE_PROFILE_PICTURE);
		String fileName = uploadRequest.getFileName(AxHrmsEmployeeOnBoardingEmployeeConstants.EMPLOYEE_PROFILE_PICTURE);

		EmployeeDetails employeeDetails = employeeDetailsLocalService.findByLrUserId(themeDisplay.getUserId());
		employeeDetails.setPersonalEmail(ParamUtil.getString(actionRequest, AxHrmsEmployeeOnBoardingEmployeeConstants.PERSONAL_EMAIL));
		employeeDetails.setMobileNo(ParamUtil.getString(actionRequest, AxHrmsEmployeeOnBoardingEmployeeConstants.MOBILE_NUMBER));
		employeeDetails.setSkypeId(ParamUtil.getString(actionRequest, AxHrmsEmployeeOnBoardingEmployeeConstants.SKYPE_ID));
		employeeDetails.setFatherName(ParamUtil.getString(actionRequest, AxHrmsEmployeeOnBoardingEmployeeConstants.FATHER_NAME));
		employeeDetails.setMaritalStatus(ParamUtil.getBoolean(actionRequest, AxHrmsEmployeeOnBoardingEmployeeConstants.MARTIAL_STATUS));
		employeeDetails.setSpouseName(ParamUtil.getString(actionRequest, AxHrmsEmployeeOnBoardingEmployeeConstants.SPOUSE_NAME));

		try {
			SimpleDateFormat formatter = new SimpleDateFormat(AxHrmsEmployeeOnBoardingEmployeeConstants.DATE_FORMAT, Locale.ENGLISH);
			employeeDetails.setDateOfBirth(formatter.parse(ParamUtil.getString(actionRequest, AxHrmsEmployeeOnBoardingEmployeeConstants.DATE_OF_BIRTH)));
			employeeDetails.setMarriageDate(formatter.parse(ParamUtil.getString(actionRequest, AxHrmsEmployeeOnBoardingEmployeeConstants.MARRIAGE_DATE)));
		} catch (Exception e) {
			log.error("Error parsing date format: " + e.getMessage());
		}

		EmployeeBasicDetailsUtil employeeBasicDetailsUtil=new EmployeeBasicDetailsUtil();
		employeeBasicDetailsUtil.addEditFileEntry(file, fileName, actionRequest, employeeDetails, profilePictureFolder, serviceContext);
		employeeDetailsLocalService.updateEmployeeDetails(employeeDetails);
	}
}
