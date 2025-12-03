package com.ax.hrms.employee.directory.util;

import com.ax.hrms.employee.directory.dto.EmployeeDto;
import com.ax.hrms.employee.directory.web.constants.AxHrmsCommonEmployeeConstants;
import com.ax.hrms.master.model.DepartmentMaster;
import com.ax.hrms.master.service.DepartmentMasterLocalService;
import com.ax.hrms.master.service.DesignationMasterLocalService;
import com.ax.hrms.model.Address;
import com.ax.hrms.model.EmployeeAddress;
import com.ax.hrms.model.EmployeeDepartment;
import com.ax.hrms.model.EmployeeDetails;
import com.ax.hrms.service.*;
import com.liferay.document.library.kernel.service.DLAppServiceUtil;
import com.liferay.document.library.kernel.util.DLUtil;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.service.CountryLocalService;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.Validator;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class EmployeeUtil {

	private static final Log log = LogFactoryUtil.getLog(EmployeeUtil.class);

	private EmployeeDetailsLocalService employeeDetailsLocalService;
	private EmployeeAddressLocalService employeeAddressLocalService;
	private AddressLocalService addressLocalService;
	private EmployeeDesignationLocalService employeeDesignationLocalService;
	private EmployeeDepartmentLocalService employeeDepartmentLocalService;
	private DesignationMasterLocalService designationMasterLocalService;
	private DepartmentMasterLocalService departmentMasterLocalService;
	private CountryLocalService countryLocalService;

	private EmployeeUtil() {}

	public EmployeeUtil(Map<String,Object> localServiceProviderMap) {
		try{
			this.employeeDetailsLocalService = (EmployeeDetailsLocalService) localServiceProviderMap.get(AxHrmsCommonEmployeeConstants.EMPLOYEE_DETAILS_LOCAL_SERVICE);
			this.employeeAddressLocalService = (EmployeeAddressLocalService) localServiceProviderMap.get(AxHrmsCommonEmployeeConstants.EMPLOYEE_ADDRESS_LOCAL_SERVICE);
			this.addressLocalService = (AddressLocalService) localServiceProviderMap.get(AxHrmsCommonEmployeeConstants.ADDRESS_LOCAL_SERVICE);
			this.employeeDesignationLocalService = (EmployeeDesignationLocalService) localServiceProviderMap.get(AxHrmsCommonEmployeeConstants.EMPLOYEE_DESIGNATION_LOCAL_SERVICE);
			this.employeeDepartmentLocalService = (EmployeeDepartmentLocalService) localServiceProviderMap.get(AxHrmsCommonEmployeeConstants.EMPLOYEE_DEPARTMENT_LOCAL_SERVICE);
			this.designationMasterLocalService = (DesignationMasterLocalService) localServiceProviderMap.get(AxHrmsCommonEmployeeConstants.DESIGNATION_MASTER_LOCAL_SERVICE);
			this.departmentMasterLocalService = (DepartmentMasterLocalService) localServiceProviderMap.get(AxHrmsCommonEmployeeConstants.DEPARTMENT_MASTER_LOCAL_SERVICE);
			this.countryLocalService = (CountryLocalService) localServiceProviderMap.get(AxHrmsCommonEmployeeConstants.COUNTRY_LOCAL_SERVICE);
		}catch (Exception e){
			log.error("EmployeeProfileUtil >>> EmployeeProfileUtil (Constructor) ::: Exception occur when set Local Services in Util class");
		}
	}
	
	public EmployeeDto setEmployeeBasicDetail(long employeeId, ThemeDisplay themeDisplay) {
		EmployeeDetails employeeDetails = employeeDetailsLocalService.fetchEmployeeDetails(employeeId);
		User user = UserLocalServiceUtil.fetchUserById(employeeDetails.getLrUserId());
		EmployeeAddress employeeAddress = employeeAddressLocalService.fetchEmployeeAddress(employeeDetails.getEmployeeAddressId());
		List<Address> addressList = new ArrayList<>();

		EmployeeDto employeeDto = new EmployeeDto(employeeAddress);
		employeeDto.setEmployeeId(employeeDetails.getEmployeeId());
		employeeDto.setFirstName(employeeDetails.getFirstName());
		employeeDto.setMiddleName(user.getMiddleName());
		employeeDto.setLastName(employeeDetails.getLastName());
		employeeDto.setGender(employeeDetails.getGender());
		employeeDto.setMobileNumber(employeeDetails.getMobileNo());
		employeeDto.setPersonalEmailId(employeeDetails.getPersonalEmail());
		employeeDto.setOfficialEmailId(employeeDetails.getOfficialEmail());
		employeeDto.setJoiningDate(employeeDetails.getJoiningDate());
		
		try {
			long designationId = employeeDesignationLocalService.findByEmployeeId(employeeId).getDesignationMasterId();
			employeeDto.setDesignationName(designationMasterLocalService.getDesignationMaster(designationId).getDesignationName());
			employeeDto.setDesignationId(designationId);
			
			List<Long> departmentIds = new ArrayList<>();
			List<String> departmentNames = new ArrayList<>();
			for(EmployeeDepartment employeeDepartment : employeeDepartmentLocalService.findByEmployeeIdGetDepartments(employeeId)) {
				DepartmentMaster departmentMaster = departmentMasterLocalService.fetchDepartmentMaster(employeeDepartment.getDepartmentMasterId());
				departmentIds.add(departmentMaster.getDepartmentMasterId());
				departmentNames.add(departmentMaster.getDepartmentName());
			}
			employeeDto.setDepartmentId(departmentIds);
			employeeDto.setDepartmentNames(departmentNames);

			boolean isSamePresentAddress = false;
			if(employeeAddress != null){
				isSamePresentAddress = employeeAddress.getPresentPermanentSame();
				addressList.add(addressLocalService.fetchAddress(employeeAddress.getPermanentAddress()));
				employeeDto.setPermanantCountry(countryLocalService.getCountry(addressList.get(0).getCountry()).getName());
				employeeDto.setPermanantCountryId(addressList.get(0).getCountry());

				if(!isSamePresentAddress) {
					addressList.add(addressLocalService.fetchAddress(employeeAddress.getPresentAddress()));
					employeeDto.setPresentCountry(countryLocalService.getCountry(addressList.get(1).getCountry()).getName());
					employeeDto.setPresentCountryId(addressList.get(1).getCountry());
				}
			}else{
				employeeDto.setPermanantCountry(AxHrmsCommonEmployeeConstants.NA);
				employeeDto.setPermanantCountryId(0);
				employeeDto.setPresentCountry(AxHrmsCommonEmployeeConstants.NA);
				employeeDto.setPresentCountryId(0);
			}

			employeeDto.setSamePresentAddress(isSamePresentAddress);
			employeeDto.setAddressList(addressList);

			FileEntry profileImageFileEntry = DLAppServiceUtil.getFileEntry(employeeDetails.getProfilePicId());
			if (Validator.isNotNull(profileImageFileEntry)) {
				String previewURL = DLUtil.getPreviewURL(profileImageFileEntry, profileImageFileEntry.getFileVersion(), themeDisplay, StringPool.BLANK);
				employeeDto.setPreviewUrl(previewURL);
			}

		} catch (PortalException e) {
			log.error("EmployeeProfileUtil >>> setEmployeeBasicDetail ::: Exception is: "+e.getMessage());
		}

        return employeeDto;
    }
	
	
}
