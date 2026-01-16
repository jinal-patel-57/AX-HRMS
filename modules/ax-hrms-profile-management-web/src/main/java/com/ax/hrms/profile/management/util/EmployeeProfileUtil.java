package com.ax.hrms.profile.management.util;

import com.ax.hrms.master.service.DepartmentMasterLocalService;
import com.ax.hrms.master.service.DesignationMasterLocalService;
import com.ax.hrms.model.Address;
import com.ax.hrms.model.EmployeeAddress;
import com.ax.hrms.model.EmployeeDetails;
import com.ax.hrms.model.Nominee;
import com.ax.hrms.profile.management.constants.AxHrmsProfileManagementWebConstants;
import com.ax.hrms.service.*;
import com.liferay.document.library.kernel.service.DLAppLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.service.CountryLocalService;

import javax.portlet.RenderRequest;
import java.util.Map;

public class EmployeeProfileUtil {

	private static final Log log = LogFactoryUtil.getLog(EmployeeProfileUtil.class);

	private EmployeeDetailsLocalService employeeDetailsLocalService;
	private EmployeeAddressLocalService employeeAddressLocalService;
	private AddressLocalService addressLocalService;
	private EmployeeDesignationLocalService employeeDesignationLocalService;
	private EmployeeDepartmentLocalService employeeDepartmentLocalService;
	private DesignationMasterLocalService designationMasterLocalService;
	private DepartmentMasterLocalService departmentMasterLocalService;
	private CountryLocalService countryLocalService;
	private EmployeeEducationLocalService employeeEducationLocalService;
	private EmployeeExperienceLocalService employeeExperienceLocalService;
	private NomineeLocalService nomineeLocalService;

	private EmployeeProfileUtil() {}
	
	public EmployeeProfileUtil(Map<String,Object> localServiceProviderMap) {
		try{
			this.employeeDetailsLocalService = (EmployeeDetailsLocalService) localServiceProviderMap.get(AxHrmsProfileManagementWebConstants.EMPLOYEE_DETAILS_LOCAL_SERVICE);
			this.employeeAddressLocalService = (EmployeeAddressLocalService) localServiceProviderMap.get(AxHrmsProfileManagementWebConstants.EMPLOYEE_ADDRESS_LOCAL_SERVICE);
			this.addressLocalService = (AddressLocalService) localServiceProviderMap.get(AxHrmsProfileManagementWebConstants.ADDRESS_LOCAL_SERVICE);
			this.employeeDesignationLocalService = (EmployeeDesignationLocalService) localServiceProviderMap.get(AxHrmsProfileManagementWebConstants.EMPLOYEE_DESIGNATION_LOCAL_SERVICE);
			this.employeeDepartmentLocalService = (EmployeeDepartmentLocalService) localServiceProviderMap.get(AxHrmsProfileManagementWebConstants.EMPLOYEE_DEPARTMENT_LOCAL_SERVICE);
			this.designationMasterLocalService = (DesignationMasterLocalService) localServiceProviderMap.get(AxHrmsProfileManagementWebConstants.DESIGNATION_MASTER_LOCAL_SERVICE);
			this.departmentMasterLocalService = (DepartmentMasterLocalService) localServiceProviderMap.get(AxHrmsProfileManagementWebConstants.DEPARTMENT_MASTER_LOCAL_SERVICE);
			this.countryLocalService = (CountryLocalService) localServiceProviderMap.get(AxHrmsProfileManagementWebConstants.COUNTRY_LOCAL_SERVICE);
			this.employeeEducationLocalService = (EmployeeEducationLocalService) localServiceProviderMap.get(AxHrmsProfileManagementWebConstants.EMPLOYEE_EDUCATION_LOCAL_SERVICE);
			this.employeeExperienceLocalService = (EmployeeExperienceLocalService) localServiceProviderMap.get(AxHrmsProfileManagementWebConstants.EMPLOYEE_EXPERIENCE_LOCAL_SERVICE);
			this.nomineeLocalService = (NomineeLocalService) localServiceProviderMap.get(AxHrmsProfileManagementWebConstants.NOMINEE_LOCAL_SERVICE);
		}catch (Exception e){
			log.error("EmployeeProfileUtil >>> EmployeeProfileUtil (Constructor) ::: Exception occur when set Local Services in Util class");
		}
	}

	public void setEmployeeDetails(RenderRequest renderRequest, Long employeeId) {
		try {
			log.info("EmployeeOnBoardingUtil >>> setEmployeeDetails ::: employee details called In Util");
			EmployeeDetails employeeDetails = employeeDetailsLocalService.getEmployeeDetails(employeeId);

			long profilePicId = employeeDetails.getProfilePicId();
			long aadhaarCardId = employeeDetails.getAadhaarCardFileId();
			long panCardId = employeeDetails.getPanCardFileId();

			if (profilePicId > 0) {
				FileEntry profilePicPathName = DLAppLocalServiceUtil.getFileEntry(profilePicId);
				String profilePicName = profilePicPathName.getFileName();
				renderRequest.setAttribute(AxHrmsProfileManagementWebConstants.PROFILE_PIC_NAME, profilePicName);
			}
			if (aadhaarCardId > 0) {
				FileEntry aadhaarCardFile = DLAppLocalServiceUtil.getFileEntry(aadhaarCardId);
				String aadhaarCardFileName = aadhaarCardFile.getFileName();
				renderRequest.setAttribute(AxHrmsProfileManagementWebConstants.AADHAAR_CARD_FILE_NAME, aadhaarCardFileName);
			}
			if (panCardId > 0) {
				FileEntry panCardFile = DLAppLocalServiceUtil.getFileEntry(panCardId);
				String panCardFileName = panCardFile.getFileName();
				renderRequest.setAttribute(AxHrmsProfileManagementWebConstants.PAN_CARD_FILE_NAME, panCardFileName);
			}


			log.info("EmployeeOnBoardingUtil >>> setEmployeeDetails ::: Retrieved employeeDetails: " + employeeDetails);
			renderRequest.setAttribute(AxHrmsProfileManagementWebConstants.EMPLOYEE_DETAIL, employeeDetails);

		} catch (PortalException e) {
			e.printStackTrace();
		}
	}
	public void setAddress(RenderRequest renderRequest, Long employeeId) {
		try {
			long employeeAddressId = employeeDetailsLocalService.getEmployeeDetails(employeeId).getEmployeeAddressId();
			log.info("EmployeeOnBoardingUtil >>> setAddress ::: employeeAddressId ======>>>>>" + employeeAddressId);
			EmployeeAddress employeeAddress = employeeAddressLocalService.getEmployeeAddress(employeeAddressId);
			log.info("EmployeeOnBoardingUtil >>> setAddress :::employeeAddressss >>>>>>>>>>>>. " + employeeAddress);
			renderRequest.setAttribute(AxHrmsProfileManagementWebConstants.EMPLOYEE_ADDRESS, employeeAddress);
			if (employeeAddressId > 0) {
				renderRequest.setAttribute(AxHrmsProfileManagementWebConstants.ADDRESS_FLAG_STATUS, AxHrmsProfileManagementWebConstants.TRUE);
			}
			if (employeeAddress.getPresentPermanentSame()) {
				Address presentaddresss = addressLocalService.getAddress(employeeAddress.getPresentAddress());
				Address permanentaddresss = addressLocalService.getAddress(employeeAddress.getPermanentAddress());
				log.info("presentaddresss ===>" + presentaddresss);
				log.info("permanentaddresss ===>" + permanentaddresss);
				renderRequest.setAttribute(AxHrmsProfileManagementWebConstants.PRESENT_ADDRESS, presentaddresss);
				renderRequest.setAttribute(AxHrmsProfileManagementWebConstants.PERMANENT_ADDRESS, permanentaddresss);
			} else {
				Address presentaddresss = addressLocalService.getAddress(employeeAddress.getPresentAddress());
				Address permanentaddresss = addressLocalService.getAddress(employeeAddress.getPermanentAddress());

				log.info("presentaddresss ===>" + presentaddresss);
				log.info("permanentaddresss ===>" + permanentaddresss);
				renderRequest.setAttribute(AxHrmsProfileManagementWebConstants.PERMANENT_ADDRESS, permanentaddresss);
				renderRequest.setAttribute(AxHrmsProfileManagementWebConstants.PRESENT_ADDRESS, presentaddresss);
			}
			renderRequest.setAttribute(AxHrmsProfileManagementWebConstants.IS_SAME_PRESENT_ADDRESS,employeeAddress.getPresentPermanentSame());



		} catch (PortalException e) {
			log.error("Error retrieving employeeAddress: " + e.getMessage());
		}
	}

	public void setNominee(RenderRequest renderRequest, Long employeeId) {
		try {
			log.info("EmployeeOnBoardingUtil >> setNominee ::: nominee details called");
			long nomineeId = employeeDetailsLocalService.getEmployeeDetails(employeeId).getNominneeId();
			Nominee nominee = nomineeLocalService.getNominee(nomineeId);
			Address address = addressLocalService.getAddress(nominee.getNomineeAddress());
			renderRequest.setAttribute(AxHrmsProfileManagementWebConstants.ADDRESS, address);
			renderRequest.setAttribute(AxHrmsProfileManagementWebConstants.NOMINEE, nominee);
		} catch (Exception e) {
			log.error(e.getMessage());
		}
	}
	

	
	
}
