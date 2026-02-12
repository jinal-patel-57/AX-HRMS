package com.ax.hrms.employee.onboarding.employee.web.action;

import com.ax.hrms.common.api.api.AxHrmsCommonApi;
import com.ax.hrms.employee.onboarding.employee.web.dto.EmployeeDto;
import com.ax.hrms.employee.onboarding.web.constants.AxHrmsEmployeeOnBoardingEmployeeConstants;
import com.ax.hrms.employee.onboarding.web.constants.AxHrmsEmployeeOnboardingWebPortletKeys;
import com.ax.hrms.master.model.DepartmentMaster;
import com.ax.hrms.master.model.DesignationMaster;
import com.ax.hrms.master.model.DocumentTypeMaster;
import com.ax.hrms.master.service.*;
import com.ax.hrms.model.Address;
import com.ax.hrms.model.EmployeeAddress;
import com.ax.hrms.model.EmployeeBankAccount;
import com.ax.hrms.model.EmployeeDepartment;
import com.ax.hrms.model.EmployeeDesignation;
import com.ax.hrms.model.EmployeeDetails;
import com.ax.hrms.model.EmployeeEducation;
import com.ax.hrms.model.EmployeeExperience;
import com.ax.hrms.model.EmployeeSalary;
import com.ax.hrms.model.EmployeeUanEsic;
import com.ax.hrms.model.Nominee;
import com.ax.hrms.service.AddressLocalService;
import com.ax.hrms.service.EmployeeAddressLocalService;
import com.ax.hrms.service.EmployeeBankAccountLocalService;
import com.ax.hrms.service.EmployeeDepartmentLocalService;
import com.ax.hrms.service.EmployeeDesignationLocalService;
import com.ax.hrms.service.EmployeeDetailsLocalService;
import com.ax.hrms.service.EmployeeEducationLocalService;
import com.ax.hrms.service.EmployeeExperienceLocalService;
import com.ax.hrms.service.EmployeeSalaryLocalService;
import com.ax.hrms.service.EmployeeUanEsicLocalService;
import com.ax.hrms.service.NomineeLocalService;
import com.liferay.document.library.kernel.service.DLAppLocalService;
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
		"javax.portlet.name=" + AxHrmsEmployeeOnboardingWebPortletKeys.AX_HRMS_EMPLOYEE_ONBOARDING_HR_WEB,
		"mvc.command.name=/showEmployeeOnboardingURL" }, service = MVCRenderCommand.class)
public class ViewEmployeeOnBoardingMVCRenderCommand implements MVCRenderCommand {

	private Log log = LogFactoryUtil.getLog(ViewEmployeeOnBoardingMVCRenderCommand.class);

	@Reference
	EducationLevelMasterLocalService educationLevelMasterLocalService;
	
	@Reference
	EmployeeDesignationLocalService employeeDesignationLocalService;
	
	@Reference
	DesignationMasterLocalService designationMasterLocalService;
	
	@Reference
	EmployeeDepartmentLocalService employeeDepartmentLocalService;
	
	@Reference
	DepartmentMasterLocalService departmentMasterLocalService;

	@Reference
	EmployeeSalaryLocalService employeeSalaryLocalService;
	
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
	DLAppLocalService dlAppLocalService;

	@Reference
	EmployeeEducationLocalService employeeEducationLocalService;
	@Reference
	private AxHrmsCommonApi axHrmsCommonApi;

	@Reference
	BranchMasterLocalService branchMasterLocalService;

	@Reference
	private DocumentTypeMasterLocalService documentTypeMasterLocalService;

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {

		log.info("viewEmployeeOnBoardingMVCRenderCommand >>> render ::: Render Called ::: ");

		long employeeId;

		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);

		String viewEmployeeId = ParamUtil.getString(renderRequest, AxHrmsEmployeeOnBoardingEmployeeConstants.EMPLOYEE_ID);
		String cmd = ParamUtil.getString(renderRequest, AxHrmsEmployeeOnBoardingEmployeeConstants.CMD);

		boolean isHRAdmin = axHrmsCommonApi.isRolePerson(themeDisplay, "HR Admin");



		employeeId = Long.parseLong(viewEmployeeId);

		if (viewEmployeeId != null && !viewEmployeeId.isEmpty()) {
				employeeId = Long.parseLong(viewEmployeeId);
		}

		EmployeeDto employeeDto = new EmployeeDto();

		EmployeeDetails employeeDetails = null;
		try {
			employeeDetails = employeeDetailsLocalService.getEmployeeDetails(employeeId);
			log.info("viewEmployeeOnBoardingMVCRenderCommand >>> render ::: Retrieved employeeDetails : " + employeeDetails);

			log.info("employee experinec :-" + employeeDetails.getIsExperienced());

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
			employeeDto.setExperienced(employeeDetails.getIsExperienced());
			employeeDto.setEmployeeType(employeeDetails.getEmployeeType());
			log.info("employee code -- " + employeeDetails.getEmployeeCode());
			employeeDto.setEmployeeCode(employeeDetails.getEmployeeCode());
			employeeDto.setLrUserId(employeeDetails.getLrUserId());
			employeeDto.setInsuranceLink(employeeDetails.getInsuranceLink());
			employeeDto.setAadhaarCardFileId(employeeDetails.getAadhaarCardFileId());
			employeeDto.setPanCardFileId(employeeDetails.getPanCardFileId());
			employeeDto.setStipend(employeeDetails.getStipend());

			employeeDto.setAadhaarCardNumber(employeeDetails.getAadhaarCardNumber());
            employeeDto.setPanCardNumber(employeeDetails.getPanCardNumber());
			employeeDto.setNameAsPerAadhaarCard(employeeDetails.getNameAsPerAadhaarCard());
			employeeDto.setExperienceYears(employeeDetails.getExperienceYears());
			employeeDto.setKycDocumentFileEntryId(employeeDetails.getKycDocumentFileEntryId());
			employeeDto.setDocumentTypeMasterId(employeeDetails.getDocumentTypeMasterId());
			try {
				employeeDto.setBranchName(Validator.isNotNull(employeeDetails.getBranchId()) ? branchMasterLocalService.getBranchMaster(employeeDetails.getBranchId()).getBranchName() : "");
			}catch(Exception e){
				log.info("Branch not found for :- "+ employeeDetails.getBranchId());
			}
			long documentTypeMasterId = employeeDto.getDocumentTypeMasterId();
			String documentTypeMasterName = null;

			if (documentTypeMasterId > 0) {
				DocumentTypeMaster documentTypeMaster = documentTypeMasterLocalService.getDocumentTypeMaster(documentTypeMasterId);
				documentTypeMasterName = documentTypeMaster.getDocumentTypeName();
				renderRequest.setAttribute("documentTypeMasterName",documentTypeMasterName);
				log.info("documentTypeMasterName::: "+ documentTypeMasterName);
			}
			try {
				EmployeeAddress employeeAddress = employeeAddressLocalService.getEmployeeAddress(employeeDetails.getEmployeeAddressId());
				
				long addressProofFileEntryId =
						employeeAddress.getEmployeeAddressProofFileEntryId();
				
				employeeDto.setAddressProofId(addressProofFileEntryId);
				
			} catch(Exception e) {
				log.error("Error while fetching address - " + e.getMessage());
			}

			if(employeeDetails.getManagerId()>0) {
				EmployeeDetails reportingManagerDetails = employeeDetailsLocalService.getEmployeeDetails(employeeDetails.getManagerId());
				employeeDto.setReportingManager(reportingManagerDetails.getFirstName()+" "+ reportingManagerDetails.getLastName());
			} else {
				employeeDto.setReportingManager("");
			}

			if(Validator.isNotNull(employeeDto.getProfilePicId()) && employeeDto.getProfilePicId()>0) {
				FileEntry fileEntry = DLAppServiceUtil.getFileEntry(employeeDto.getProfilePicId());

				if (Validator.isNotNull(fileEntry)) {
					String previewURL = DLUtil.getPreviewURL(fileEntry, fileEntry.getFileVersion(), themeDisplay,StringPool.BLANK);
					renderRequest.setAttribute(AxHrmsEmployeeOnBoardingEmployeeConstants.PROFILE_PIC, previewURL);
				}
			}
			if(Validator.isNotNull(employeeDto.getAadhaarCardFileId()) && employeeDto.getAadhaarCardFileId()>0) {
				FileEntry aadhaarCardFile = DLAppServiceUtil.getFileEntry(employeeDto.getAadhaarCardFileId());

				if (Validator.isNotNull(aadhaarCardFile)) {
					String previewURL = DLUtil.getPreviewURL(aadhaarCardFile, aadhaarCardFile.getFileVersion(), themeDisplay,StringPool.BLANK);
					renderRequest.setAttribute(AxHrmsEmployeeOnBoardingEmployeeConstants.AADHAAR_CARD_FILE, previewURL);
				}
			}
			if(Validator.isNotNull(employeeDto.getPanCardFileId()) && employeeDto.getPanCardFileId()>0) {
				FileEntry panCardFile = DLAppServiceUtil.getFileEntry(employeeDto.getPanCardFileId());

				if (Validator.isNotNull(panCardFile)) {
					String previewURL = DLUtil.getPreviewURL(panCardFile, panCardFile.getFileVersion(), themeDisplay,StringPool.BLANK);
					renderRequest.setAttribute(AxHrmsEmployeeOnBoardingEmployeeConstants.PAN_CARD_FILE, previewURL);
				}
			}

			if(Validator.isNotNull(employeeDto.getAddressProofId()) && employeeDto.getAddressProofId()>0) {
				try {
					FileEntry addressProofFile = dlAppLocalService.getFileEntry(employeeDto.getAddressProofId());
					
					if (Validator.isNotNull(addressProofFile)) {
						String previewURL = DLUtil.getPreviewURL(addressProofFile, addressProofFile.getFileVersion(), themeDisplay,StringPool.BLANK);
						
						renderRequest.setAttribute(AxHrmsEmployeeOnBoardingEmployeeConstants.ADDRESS_PROOF_FILE, previewURL);
					}
				}catch(Exception e) {
					log.error("Error while fetching addressproof -- " + e.getMessage());
				}
			}
			if(Validator.isNotNull(employeeDto.getKycDocumentFileEntryId()) && employeeDto.getKycDocumentFileEntryId()>0) {
				FileEntry kycDocumentFile = DLAppServiceUtil.getFileEntry(employeeDto.getKycDocumentFileEntryId());

				if (Validator.isNotNull(kycDocumentFile)) {
					String previewURL = DLUtil.getPreviewURL(kycDocumentFile, kycDocumentFile.getFileVersion(), themeDisplay,StringPool.BLANK);
					log.info("previewURL of kycDocumentFile ::: " + previewURL);
					renderRequest.setAttribute(AxHrmsEmployeeOnBoardingEmployeeConstants.KYC_DOCUMENT_FILE, previewURL);
				}
			}

			
			try {
				EmployeeDesignation employeeDesignation = employeeDesignationLocalService.findByEmployeeId(employeeId);
				if(Validator.isNotNull(employeeDesignation) && employeeDesignation.getEmployeeDesignationId()>0 && employeeDesignation.getDesignationMasterId()>0) {
					DesignationMaster designationMaster = designationMasterLocalService.getDesignationMaster(employeeDesignation.getDesignationMasterId());
					employeeDto.setDesignationMasterId(designationMaster.getDesignationMasterId());
					employeeDto.setDesignationName(designationMaster.getDesignationName());
				}
			} catch(Exception e) {
				log.error("Error while fetching employee's designation - " + e.getMessage());
			}
			try {
				EmployeeDepartment employeeDepartment = employeeDepartmentLocalService.findByEmployeeId(employeeId);
				if(Validator.isNotNull(employeeDepartment) && employeeDepartment.getEmployeeDepartmentId()>0 && employeeDepartment.getDepartmentMasterId()>0) {
					DepartmentMaster departmentMaster = departmentMasterLocalService.getDepartmentMaster(employeeDepartment.getDepartmentMasterId());
					employeeDto.setDepartmentMasterId(departmentMaster.getDepartmentMasterId());
					employeeDto.setDepartmentName(departmentMaster.getDepartmentName());
				}
			} catch(Exception e) {
				log.error("Error while fetching employee's designation - " + e.getMessage());
			}
			try {
				EmployeeSalary employeeSalary = employeeSalaryLocalService.findByEmployeeIdAndStatus(employeeId, true);
				if(Validator.isNotNull(employeeSalary) && employeeSalary.getSalaryId()>0) {
					employeeDto.setGrossSalaryCtcPa(employeeSalary.getGrossSalaryCtcPa());
					employeeDto.setGrossSalaryCtcPm(employeeSalary.getGrossSalaryCtcPm());
				}
			} catch(Exception e) {
				log.error("Error while fetching employee's designation - " + e.getMessage());
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
				try {
					FileEntry fileEntry = DLAppServiceUtil.getFileEntry(education.getEducationCertificateMediaId());
					String previewURL = DLUtil.getPreviewURL(fileEntry, fileEntry.getFileVersion(), themeDisplay,StringPool.BLANK);
					educationDto.setEducationCertificatePreviewUrl(previewURL);
				} catch(Exception e) {
					log.error("Error while fetching education certificate -- " + e.getMessage());
				}
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
//				experienceDto.setExperienceCertificateMediaId(experience.getExperienceCertificateMediaId());

                List<String> previewUrls = new ArrayList<>();

                String mediaIds = experience.getExperienceCertificateMediaId();

                if (Validator.isNotNull(mediaIds) && !mediaIds.isBlank() && !"0".equalsIgnoreCase(mediaIds)) {

                    String[] fileEntryIds = mediaIds.split(StringPool.COMMA);

                    for (String fileEntryIdStr : fileEntryIds) {
                        try {
                            long fileEntryId = Long.parseLong(fileEntryIdStr.trim());

                            FileEntry fileEntry =
                                    DLAppServiceUtil.getFileEntry(fileEntryId);

                            String previewURL =
                                    DLUtil.getPreviewURL(
                                            fileEntry,
                                            fileEntry.getFileVersion(),
                                            themeDisplay,
                                            StringPool.BLANK);

                            previewUrls.add(previewURL);

                        } catch (Exception e) {
                            log.error(
                                    "Unable to load experience certificate fileEntryId = "
                                            + fileEntryIdStr,
                                    e
                            );
                        }
                    }
                }

                experienceDto.setExperienceCertificatePreviewUrls(previewUrls);

//				renderRequest.setAttribute(AxHrmsEmployeeOnBoardingEmployeeConstants.VIEW_EXPERIENCE_CERTIFICATE, previewURL);

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
			employeeDto.setNameAsPerPanCard(employeeBankAccount.getNameAsPerPanCard());

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
			employeeDto.setNomineeCity(address.getCity());
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
		if(cmd.equalsIgnoreCase("view")){
			return AxHrmsEmployeeOnBoardingEmployeeConstants.VIEW_EMPLOYEE_DETAILS_JSP;
		}else {
			renderRequest.setAttribute(AxHrmsEmployeeOnBoardingEmployeeConstants.IS_HR_ADMIN, isHRAdmin);
			return AxHrmsEmployeeOnBoardingEmployeeConstants.VIEW_EMPLOYEE_ONBOARDING_JSP;
		}
	}
}
