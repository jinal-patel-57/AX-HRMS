package com.ax.hrms.employee.onboarding.employee.web.action;

import com.ax.hrms.common.api.api.AxHrmsCommonApi;
import com.ax.hrms.employee.onboarding.employee.web.util.EmployeeOnBoardingUtil;
import com.ax.hrms.employee.onboarding.web.constants.AxHrmsEmployeeOnBoardingEmployeeConstants;
import com.ax.hrms.employee.onboarding.web.constants.AxHrmsEmployeeOnboardingHrWebPortletConstants;
import com.ax.hrms.employee.onboarding.web.constants.AxHrmsEmployeeOnboardingWebPortletKeys;
import com.ax.hrms.exception.NoSuchEmployeeDetailsException;
import com.ax.hrms.mail.template.config.configuration.MailTemplateConfiguration;
import com.ax.hrms.master.model.DocumentTypeMaster;
import com.ax.hrms.master.model.EducationLevelMaster;
import com.ax.hrms.master.service.DocumentTypeMasterLocalService;
import com.ax.hrms.master.service.EducationLevelMasterLocalService;
import com.ax.hrms.model.EmployeeDetails;
import com.ax.hrms.service.AddressLocalService;
import com.ax.hrms.service.EmployeeAddressLocalService;
import com.ax.hrms.service.EmployeeBankAccountLocalService;
import com.ax.hrms.service.EmployeeDetailsLocalService;
import com.ax.hrms.service.EmployeeEducationLocalService;
import com.ax.hrms.service.EmployeeExperienceLocalService;
import com.ax.hrms.service.EmployeeUanEsicLocalService;
import com.ax.hrms.service.NomineeLocalService;
import com.liferay.document.library.kernel.service.DLAppLocalService;
import com.liferay.document.library.util.DLURLHelper;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Country;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.service.CountryLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.awt.print.Book;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, property = {
		"javax.portlet.name=" + AxHrmsEmployeeOnboardingWebPortletKeys.AX_HRMS_EMPLOYEE_ONBOARDING_EMPLOYEE_WEB,
		"mvc.command.name=/" }, service = MVCRenderCommand.class)
public class FetchEmployeeOnboardingMVCRenderCommand implements MVCRenderCommand {

	private Log log = LogFactoryUtil.getLog(FetchEmployeeOnboardingMVCRenderCommand.class);

	@Reference
	EducationLevelMasterLocalService educationLevelMasterLocalService;

	@Reference
	EmployeeUanEsicLocalService employeeUanEsicLocalService;

	@Reference
	MailTemplateConfiguration mailTemplateConfiguration;

	@Reference
	EmployeeDetailsLocalService employeeDetailsLocalService;

	@Reference
	EmployeeAddressLocalService employeeAddressLocalService;

	@Reference
	AddressLocalService addressLocalService;

	@Reference
	EmployeeBankAccountLocalService employeeBankAccountLocalService;

	@Reference
	NomineeLocalService nomineeLocalService;
	
	@Reference
	AxHrmsCommonApi axHrmsCommonApi;

	@Reference
	EmployeeEducationLocalService employeeEducationLocalService;

	@Reference
	EmployeeExperienceLocalService employeeExperienceLocalService;

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {

		log.info("FetchEmployeeOnboardingMVCRenderCommand >>> render ::: Render Called :::");
		try {
			ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
			long employeeId = employeeDetailsLocalService.findByLrUserId(themeDisplay.getUserId()).getEmployeeId();
			String eduCurrentIndex = ParamUtil.getString(renderRequest, AxHrmsEmployeeOnBoardingEmployeeConstants.EDU_CURRENT_INDEX);
	        renderRequest.setAttribute(AxHrmsEmployeeOnBoardingEmployeeConstants.EDU_CURRENT_INDEX, eduCurrentIndex);
	        log.info("before jsp -- " +eduCurrentIndex);
	        
	        String experienceCurIndex = ParamUtil.getString(renderRequest, AxHrmsEmployeeOnBoardingEmployeeConstants.EXPERINCE_CURRENT_INDEX);
	        renderRequest.setAttribute(AxHrmsEmployeeOnBoardingEmployeeConstants.EXPERINCE_CURRENT_INDEX, experienceCurIndex);
	        log.info("before jsp -- " +experienceCurIndex);
			boolean isOnBoarded = employeeDetailsLocalService.findByLrUserId(themeDisplay.getUserId()).getIsEmployeeOnboarded();
			if (isOnBoarded){
				renderRequest.setAttribute("isOnBoarded", Boolean.TRUE);
				return AxHrmsEmployeeOnBoardingEmployeeConstants.ADD_EMPLOYEE_ONBOARDING_JSP;
			}

			EmployeeOnBoardingUtil employeeOnBoardingUtil=new EmployeeOnBoardingUtil(employeeDetailsLocalService,axHrmsCommonApi, employeeAddressLocalService, employeeBankAccountLocalService, addressLocalService, nomineeLocalService,mailTemplateConfiguration);
			employeeOnBoardingUtil.setEmployeeDetails(renderRequest, employeeId);
			employeeOnBoardingUtil.setAddress(renderRequest, employeeId,themeDisplay);
			employeeOnBoardingUtil.setNominee(renderRequest, employeeId);
			employeeOnBoardingUtil.setBankAccount(renderRequest, employeeId);
			employeeOnBoardingUtil.setUanEsic(renderRequest, employeeId,employeeUanEsicLocalService);
			log.info("beforeeeee log");

			employeeOnBoardingUtil.setEducationList(renderRequest, employeeId, employeeEducationLocalService);
			employeeOnBoardingUtil.setExperience(renderRequest, employeeId, employeeExperienceLocalService);

			List<Country> countryList = CountryLocalServiceUtil.getCountries(-1, -1);
			List<EducationLevelMaster> educationLevelMastersList = educationLevelMasterLocalService.getEducationLevelMasters(-1, -1);
			EmployeeDetails employeeDetails;
			employeeDetails = employeeDetailsLocalService.getEmployeeDetails(employeeId);
			renderRequest.setAttribute(AxHrmsEmployeeOnboardingHrWebPortletConstants.IS_EXPERIENCED, employeeDetails.getIsExperienced());
			renderRequest.setAttribute(AxHrmsEmployeeOnBoardingEmployeeConstants.COUNTRY_LIST, countryList);
			renderRequest.setAttribute(AxHrmsEmployeeOnBoardingEmployeeConstants.EDUCATION_LEVEL_MASTERS_LIST,educationLevelMastersList);

			List<DocumentTypeMaster> kycDocumentTypes = documentTypeMasterLocalService.fetchByIsDocumentUsedForKYC();
			if (kycDocumentTypes != null && !kycDocumentTypes.isEmpty()) {
				renderRequest.setAttribute("kycDocumentTypes", kycDocumentTypes);
			}
			long kycFileEntryId = 0;

			if (Validator.isNotNull(employeeDetails)) {
				kycFileEntryId = employeeDetails.getKycDocumentFileEntryId();
			}

			long documentTypeMasterId = employeeDetails.getDocumentTypeMasterId();
			String kycDocumentUrl = null;

			if (kycFileEntryId > 0) {
				FileEntry fileEntry =
						dlAppLocalService.getFileEntry(kycFileEntryId);

				kycDocumentUrl =
						dlurlHelper.getPreviewURL(
								fileEntry,
								fileEntry.getFileVersion(),
								themeDisplay,
								StringPool.BLANK
						);

				renderRequest.setAttribute("kycDocumentUrl",kycDocumentUrl);
				renderRequest.setAttribute("documentTypeMasterId",documentTypeMasterId);

			}

		} catch (NoSuchEmployeeDetailsException ex) {
			log.warn("Employee details not found", ex);
		} catch (PortalException ex) {
			log.error("Portal exception occurred while processing employee data", ex);
		}
        return AxHrmsEmployeeOnBoardingEmployeeConstants.ADD_EMPLOYEE_ONBOARDING_JSP;
	}

	@Reference
	private DocumentTypeMasterLocalService documentTypeMasterLocalService;
	@Reference
	private DLAppLocalService dlAppLocalService;
	@Reference
	private DLURLHelper dlurlHelper;
}
