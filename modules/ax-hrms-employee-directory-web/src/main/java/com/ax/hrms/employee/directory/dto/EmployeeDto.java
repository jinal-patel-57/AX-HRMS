package com.ax.hrms.employee.directory.dto;

import com.ax.hrms.model.Address;
import com.ax.hrms.model.EmployeeAddress;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EmployeeDto {

	long employeeId;
	String firstName;
	String middleName;
	String lastName;
	String gender;
	String mobileNumber;
	String personalEmailId;
	String officialEmailId;
	Date joiningDate;
	
	long designationId;
	List<Long> departmentId;
	String designationName;
	List<String> departmentNames;
	
	EmployeeAddress employeeAddress;

	List<Address> addressList;
	boolean isSamePresentAddress = false;
	String permanantCountry;
	String presentCountry;
	String previewUrl;
	long permanantCountryId;
	long presentCountryId;

	private EmployeeDto() {}
	
	public EmployeeDto(EmployeeAddress employeeAddress) {
		this.employeeAddress = employeeAddress;
		addressList = new ArrayList<>();
	}
	
	public long getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(long employeeId) {
		this.employeeId = employeeId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getPersonalEmailId() {
		return personalEmailId;
	}
	public void setPersonalEmailId(String personalEmailId) {
		this.personalEmailId = personalEmailId;
	}
	public String getOfficialEmailId() {
		return officialEmailId;
	}
	public void setOfficialEmailId(String officialEmailId) {
		this.officialEmailId = officialEmailId;
	}
	public Date getJoiningDate() {
		return joiningDate;
	}
	public void setJoiningDate(Date joiningDate) {
		this.joiningDate = joiningDate;
	}
	public long getDesignationId() {
		return designationId;
	}
	public void setDesignationId(long designationId) {
		this.designationId = designationId;
	}
	
	public String getDesignationName() {
		return designationName;
	}
	public void setDesignationName(String designationName) {
		this.designationName = designationName;
	}

	public List<Long> getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(List<Long> departmentId) {
		this.departmentId = departmentId;
	}

	public List<String> getDepartmentNames() {
		return departmentNames;
	}

	public void setDepartmentNames(List<String> departmentNames) {
		this.departmentNames = departmentNames;
	}

	public EmployeeAddress getEmployeeAddress() {
		return employeeAddress;
	}

	public void setEmployeeAddress(EmployeeAddress employeeAddress) {
		this.employeeAddress = employeeAddress;
	}

	public String getFullName(){
		return getFirstName()+" "+getMiddleName()+" "+getLastName();
	}

	public List<Address> getAddressList() {
		return addressList;
	}

	public void setAddressList(List<Address> addressList) {
		this.addressList = addressList;
	}

	public boolean isSamePresentAddress() {
		return isSamePresentAddress;
	}

	public void setSamePresentAddress(boolean samePresentAddress) {
		isSamePresentAddress = samePresentAddress;
	}

	public String getPermanantCountry() {
		return permanantCountry;
	}

	public void setPermanantCountry(String permanantCountry) {
		this.permanantCountry = permanantCountry;
	}

	public String getPresentCountry() {
		return presentCountry;
	}

	public void setPresentCountry(String presentCountry) {
		this.presentCountry = presentCountry;
	}

	public String getPreviewUrl() {
		return previewUrl;
	}

	public void setPreviewUrl(String previewUrl) {
		this.previewUrl = previewUrl;
	}

	public long getPermanantCountryId() {
		return permanantCountryId;
	}

	public void setPermanantCountryId(long permanantCountryId) {
		this.permanantCountryId = permanantCountryId;
	}

	public long getPresentCountryId() {
		return presentCountryId;
	}

	public void setPresentCountryId(long presentCountryId) {
		this.presentCountryId = presentCountryId;
	}
}
