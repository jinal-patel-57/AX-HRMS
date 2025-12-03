package com.ax.hrms.employee.onboarding.employee.web.action;

import com.ax.hrms.employee.onboarding.employee.web.dto.EmployeeDto;
import com.ax.hrms.employee.onboarding.web.constants.AxHrmsEmployeeOnBoardingEmployeeConstants;
import com.ax.hrms.employee.onboarding.web.constants.AxHrmsEmployeeOnboardingWebPortletKeys;
import com.ax.hrms.master.service.EducationLevelMasterLocalService;
import com.ax.hrms.model.Address;
import com.ax.hrms.model.EmployeeAddress;
import com.ax.hrms.model.EmployeeBankAccount;
import com.ax.hrms.model.EmployeeDetails;
import com.ax.hrms.model.EmployeeEducation;
import com.ax.hrms.model.EmployeeExperience;
import com.ax.hrms.model.EmployeeUanEsic;
import com.ax.hrms.model.Nominee;
import com.ax.hrms.service.AddressLocalService;
import com.ax.hrms.service.EmployeeAddressLocalService;
import com.ax.hrms.service.EmployeeBankAccountLocalService;
import com.ax.hrms.service.EmployeeDetailsLocalService;
import com.ax.hrms.service.EmployeeEducationLocalService;
import com.ax.hrms.service.EmployeeExperienceLocalService;
import com.ax.hrms.service.EmployeeUanEsicLocalService;
import com.ax.hrms.service.NomineeLocalService;
import com.liferay.document.library.kernel.service.DLAppServiceUtil;
import com.liferay.document.library.kernel.util.DLUtil;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.service.CountryLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, property = {
		"javax.portlet.name=" + AxHrmsEmployeeOnboardingWebPortletKeys.AX_HRMS_EMPLOYEE_ONBOARDING_EMPLOYEE_WEB,
		"mvc.command.name=/showEmployeeOnboardingURL" }, service = MVCRenderCommand.class)
public class ViewEmployeeOnBoardingMVCRenderCommand implements MVCRenderCommand {

	private Log log = LogFactoryUtil.getLog(ViewEmployeeOnBoardingMVCRenderCommand.class);

	@Reference
	EducationLevelMasterLocalService educationLevelMasterLocalService;

	@Reference
	EmployeeUanEsicLocalService employeeUanEsicLocalService;

	@Reference
	EmployeeDetailsLocalService employeeDetailsLocalService;

	@Reference
	EmployeeAddressLocalService employeeAddressLocalService;

	@Reference
	EmployeeExperienceLocalService employeeExperienceLocalService;

	@Reference
	AddressLocalService addressLocalService;

	@Reference
	EmployeeBankAccountLocalService employeeBankAccountLocalService;

	@Reference
	NomineeLocalService nomineeLocalService;

	@Reference
	EmployeeEducationLocalService employeeEducationLocalService;

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {

		log.info("viewEmployeeOnBoardingMVCRenderCommand >>> render ::: Render Called ::: ");
		
		long employeeId;

		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);

		String viewEmployeeId = ParamUtil.getString(renderRequest, AxHrmsEmployeeOnBoardingEmployeeConstants.EMPLOYEE_ID);

		employeeId = Long.parseLong(viewEmployeeId);

		if (viewEmployeeId != null && !viewEmployeeId.isEmpty()) {		
				employeeId = Long.parseLong(viewEmployeeId);
		}

		EmployeeDto employeeDto = new EmployeeDto();

		EmployeeDetails employeeDetails = null;
		try {
			employeeDetails = employeeDetailsLocalService.getEmployeeDetails(employeeId);
			log.info("viewEmployeeOnBoardingMVCRenderCommand >>> render ::: Retrieved employeeDetails : " + employeeDetails);

			employeeDto.setEmployeeId(employeeDetails.getEmployeeId());
			employeeDto.setPersonalEmail(employeeDetails.getPersonalEmail());
			employeeDto.setDateOfBirth(employeeDetails.getDateOfBirth());
			employeeDto.setMobileNo(employeeDetails.getMobileNo());
			employeeDto.setSkypeId(employeeDetails.getSkypeId());
			employeeDto.setFatherName(employeeDetails.getFatherName());
			employeeDto.setMaritalStatus(employeeDetails.getMaritalStatus());
			employeeDto.setMarriageDate(employeeDetails.getMarriageDate());
			employeeDto.setSpouseName(employeeDetails.getSpouseName());
			employeeDto.setProfilePicId(employeeDetails.getProfilePicId());
			employeeDto.setOfficialEmail(employeeDetails.getOfficialEmail());
			employeeDto.setFirstName(employeeDetails.getFirstName());
			employeeDto.setLastName(employeeDetails.getLastName());
			employeeDto.setJoiningDate(employeeDetails.getJoiningDate());
			employeeDto.setLeavingDate(employeeDetails.getLeavingDate());
			employeeDto.setGender(employeeDetails.getGender());
			FileEntry fileEntry = DLAppServiceUtil.getFileEntry(employeeDto.getProfilePicId());

			if (Validator.isNotNull(fileEntry)) {
				String previewURL = DLUtil.getPreviewURL(fileEntry, fileEntry.getFileVersion(), themeDisplay,StringPool.BLANK);
				renderRequest.setAttribute(AxHrmsEmployeeOnBoardingEmployeeConstants.PROFILE_PIC, previewURL);
			}
			renderRequest.setAttribute(AxHrmsEmployeeOnBoardingEmployeeConstants.EMPLOYEE_DETAIL, employeeDto);
		} catch (PortalException e) {
			e.printStackTrace();
		}

		try {
			List<EmployeeEducation> educationList = employeeEducationLocalService.findByEmployeeId(employeeId);
			List<EmployeeDto> educationDtoList = new ArrayList<>();

			for (EmployeeEducation education : educationList) {
				EmployeeDto educationDto = new EmployeeDto();
				educationDto.setLevelId(education.getLevelId());
				educationDto.setLevelName(educationLevelMasterLocalService.getEducationLevelMaster(education.getLevelId()).getLevelName());
				educationDto.setInstitution(education.getInstitution());
				educationDto.setDegree(education.getDegree());
				educationDto.setStartDate(education.getStartDate());
				educationDto.setPassingYear(education.getPassingYear());
				educationDto.setEndDate(education.getEndDate());
				educationDtoList.add(educationDto);
			}
			renderRequest.setAttribute(AxHrmsEmployeeOnBoardingEmployeeConstants.EDUCATION_LIST, educationDtoList);
		} catch (Exception e1) {
			e1.printStackTrace();
		}

		try {
			EmployeeAddress employeeAddress = employeeAddressLocalService
					.getEmployeeAddress(employeeDetails.getEmployeeAddressId());
			renderRequest.setAttribute(AxHrmsEmployeeOnBoardingEmployeeConstants.EMPLOYEE_ADDRESS, employeeAddress);
			if (employeeAddress.getPresentPermanentSame()) {
				Address presentaddresss = addressLocalService.getAddress(employeeAddress.getPresentAddress());
				Address permanentaddresss = addressLocalService.getAddress(employeeAddress.getPermanentAddress());
				renderRequest.setAttribute(AxHrmsEmployeeOnBoardingEmployeeConstants.PRESENT_ADDRESS, presentaddresss);
				renderRequest.setAttribute(AxHrmsEmployeeOnBoardingEmployeeConstants.PERMANENT_ADDRESS, permanentaddresss);
				log.info("presentaddresss" +presentaddresss);
				log.info("permanentaddresss" +permanentaddresss);
			} else {
				Address presentaddresss = addressLocalService.getAddress(employeeAddress.getPresentAddress());
				Address permanentaddresss = addressLocalService.getAddress(employeeAddress.getPermanentAddress());
				renderRequest.setAttribute(AxHrmsEmployeeOnBoardingEmployeeConstants.PERMANENT_ADDRESS, permanentaddresss);
				renderRequest.setAttribute(AxHrmsEmployeeOnBoardingEmployeeConstants.PRESENT_ADDRESS, presentaddresss);
				log.info("presentaddresss" +presentaddresss);
				log.info("permanentaddresss" +permanentaddresss);
			}
		} catch (PortalException e) {
			log.error("Error retrieving employeeAddress: " + e.getMessage());
		}

		try {
			List<EmployeeExperience> experienceList = employeeExperienceLocalService.findByEmployeeId(employeeId);
			List<EmployeeDto> experienceDtoList = new ArrayList<>();

			for (EmployeeExperience experience : experienceList) {
				EmployeeDto experienceDto = new EmployeeDto();
				experienceDto.setCompanyName(experience.getCompanyName());
				experienceDto.setExperienceJoiningDate(experience.getJoiningDate());
				experienceDto.setRelievingDate(experience.getRelievingDate());
				experienceDto.setExperienceCertificateMediaId(experience.getExperienceCertificateMediaId());
				
				FileEntry fileEntry = DLAppServiceUtil.getFileEntry(experienceDto.getExperienceCertificateMediaId());

				String previewURL = DLUtil.getPreviewURL(fileEntry, fileEntry.getFileVersion(), themeDisplay,StringPool.BLANK);
				renderRequest.setAttribute(AxHrmsEmployeeOnBoardingEmployeeConstants.VIEW_EXPERIENCE_CERTIFICATE, previewURL);
				
				experienceDtoList.add(experienceDto);
			}
			
			log.info("viewEmployeeOnBoardingMVCRenderCommand >>> render ::: experienceList" + experienceDtoList.toString());
			renderRequest.setAttribute(AxHrmsEmployeeOnBoardingEmployeeConstants.EXPERIENCE_LIST, experienceDtoList);
		} catch (Exception e) {
			log.error("error in catch" + e.getMessage());
		}

		try {
			long bankAccountId = employeeDetailsLocalService.getEmployeeDetails(employeeId).getBankAccountId();
			EmployeeBankAccount employeeBankAccount = employeeBankAccountLocalService
					.getEmployeeBankAccount(bankAccountId);
			employeeDto.setAccountNumber(employeeBankAccount.getAccountNumber());
			employeeDto.setAccountType(employeeBankAccount.getAccountType());
			employeeDto.setBeneficiaryName(employeeBankAccount.getBeneficiaryName());
			employeeDto.setIfscCode(employeeBankAccount.getIfscCode());
			employeeDto.setBankName(employeeBankAccount.getBankName());
			employeeDto.setBankBranch(employeeBankAccount.getBankBranch());

			log.info(" viewEmployeeOnBoardingMVCRenderCommand >>> render ::: Retrieved employeeBankAccount: " + employeeBankAccount);
			renderRequest.setAttribute(AxHrmsEmployeeOnBoardingEmployeeConstants.EMPLOYEE_BANK_ACCOUNT, employeeDto);
		} catch (Exception e) {
			log.info("catch error " + e.getMessage());
		}

		try {
			long employeeUanEsicId = employeeDetailsLocalService.getEmployeeDetails(employeeId).getUanEsicId();
			EmployeeUanEsic employeeUanEsic = employeeUanEsicLocalService.getEmployeeUanEsic(employeeUanEsicId);
			employeeDto.setUan(employeeUanEsic.getUan());
			employeeDto.setEsicNo(employeeUanEsic.getEsicNo());
			log.info("viewEmployeeOnBoardingMVCRenderCommand >>> render ::: Retrieved EmployeeUanEsic: " + employeeUanEsic);
			renderRequest.setAttribute(AxHrmsEmployeeOnBoardingEmployeeConstants.EMPLOYEE_UAN_ESIC, employeeDto);
		} catch (Exception e) {
			log.error(e.getMessage());
		}

		try {
			long nomineeId = employeeDetailsLocalService.getEmployeeDetails(employeeId).getNominneeId();
			Nominee nominee = nomineeLocalService.getNominee(nomineeId);
			Address address = addressLocalService.getAddress(nominee.getNomineeAddress());
			employeeDto.setNomineeFirstName(nominee.getNomineeFirstName());
			employeeDto.setNomineeLastName(nominee.getNomineeLastName());
			employeeDto.setNomineeContact(nominee.getNomineeContact());
			employeeDto.setLine1(address.getLine1());
			employeeDto.setLine2(address.getLine2());
			employeeDto.setLine3(address.getLine3());
			employeeDto.setCountry(address.getCountry());
			String countryName = CountryLocalServiceUtil.getCountry(employeeDto.getCountry()).getName();
			employeeDto.setCountryName(countryName);

			employeeDto.setState(address.getState());
			employeeDto.setPincode(address.getPincode());
			employeeDto.setRelationshipWithNominee(nominee.getRelationshipWithNominee());
			employeeDto.setNomineeDob(nominee.getNomineeDob());		
			
			renderRequest.setAttribute(AxHrmsEmployeeOnBoardingEmployeeConstants.NOMINEE, employeeDto);
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return AxHrmsEmployeeOnBoardingEmployeeConstants.VIEW_EMPLOYEE_ONBOARDING_JSP;
	}
}
