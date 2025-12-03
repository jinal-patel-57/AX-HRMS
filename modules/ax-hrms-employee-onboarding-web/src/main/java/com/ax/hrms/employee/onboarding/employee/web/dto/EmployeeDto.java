package com.ax.hrms.employee.onboarding.employee.web.dto;

import java.util.Date;

public class EmployeeDto {

	
	//Basic Details 
	public long employeeId;
	public long lrUserId;
	public String employeeCode;
	public String firstName;
	public String lastName;
	public String officialEmail;
	public String personalEmail;
	public Date joiningDate;
	public Date leavingDate;
	public String mobileNo;
	public String gender;
	public String fatherName;
	public Date dateOfBirth;
	public boolean maritalStatus;
	public Date marriageDate;
	public String spouseName;
	public long employeeAddressId;
	public String skypeId;
	public long nominneeId;
	public long bankAccountId;
	public long uanEsicId;
	public long probationStatusId;
	public boolean isEmployeeOnboarded;
	public boolean isExperienced;
	public boolean isProbationEnabled;
	public long profilePicId;
	public String insuranceLink;
	
	//address
	public String line1;
	public String line2;
	public String line3;
	public String state;
	public long country;
	public String countryName;
	public String pincode;
	
	//education
	public long levelId;
	public String levelName;
	public String institution;
	public String degree;
	public Date StartDate;
	public String passingYear;
	public Date endDate;
	
	//experience
	public long experienceId;
	public long getExperienceId() {
		return experienceId;
	}
	public void setExperienceId(long experienceId) {
		this.experienceId = experienceId;
	}
	public String companyName;
	public Date experienceJoiningDate;
	public Date relievingDate;
	public long experienceCertificateMediaId;
	public String experienceCertificateMediaName;
	
	//bankDetails
	public String accountNumber;
	public String accountType;
	public String beneficiaryName;
	public String bankName;
	public boolean status;
	public String ifscCode;
	public String bankBranch;
	
	//uanesic
	public String uan;
	public String esicNo;
	
	//nominee details 
	public String nomineeFirstName;
	public String nomineeLastName;
	public String nomineeContact;
	public long nomineeAddress;
	public String relationshipWithNominee;
	public Date nomineeDob;
	
	public long getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(long employeeId) {
		this.employeeId = employeeId;
	}
	public long getLrUserId() {
		return lrUserId;
	}
	public void setLrUserId(long lrUserId) {
		this.lrUserId = lrUserId;
	}
	public String getEmployeeCode() {
		return employeeCode;
	}
	public void setEmployeeCode(String employeeCode) {
		this.employeeCode = employeeCode;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getOfficialEmail() {
		return officialEmail;
	}
	public void setOfficialEmail(String officialEmail) {
		this.officialEmail = officialEmail;
	}
	public String getPersonalEmail() {
		return personalEmail;
	}
	public void setPersonalEmail(String personalEmail) {
		this.personalEmail = personalEmail;
	}
	public Date getJoiningDate() {
		return joiningDate;
	}
	public void setJoiningDate(Date joiningDate) {
		this.joiningDate = joiningDate;
	}
	public Date getLeavingDate() {
		return leavingDate;
	}
	public void setLeavingDate(Date leavingDate) {
		this.leavingDate = leavingDate;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getFatherName() {
		return fatherName;
	}
	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public boolean isMaritalStatus() {
		return maritalStatus;
	}
	public void setMaritalStatus(boolean maritalStatus) {
		this.maritalStatus = maritalStatus;
	}
	
	public String getSpouseName() {
		return spouseName;
	}
	public void setSpouseName(String spouseName) {
		this.spouseName = spouseName;
	}
	public long getEmployeeAddressId() {
		return employeeAddressId;
	}
	public void setEmployeeAddressId(long employeeAddressId) {
		this.employeeAddressId = employeeAddressId;
	}
	public String getSkypeId() {
		return skypeId;
	}
	public void setSkypeId(String skypeId) {
		this.skypeId = skypeId;
	}
	public long getNominneeId() {
		return nominneeId;
	}
	public void setNominneeId(long nominneeId) {
		this.nominneeId = nominneeId;
	}
	public long getBankAccountId() {
		return bankAccountId;
	}
	public void setBankAccountId(long bankAccountId) {
		this.bankAccountId = bankAccountId;
	}
	public long getUanEsicId() {
		return uanEsicId;
	}
	public void setUanEsicId(long uanEsicId) {
		this.uanEsicId = uanEsicId;
	}
	public long getProbationStatusId() {
		return probationStatusId;
	}
	public void setProbationStatusId(long probationStatusId) {
		this.probationStatusId = probationStatusId;
	}
	public boolean isEmployeeOnboarded() {
		return isEmployeeOnboarded;
	}
	public void setEmployeeOnboarded(boolean isEmployeeOnboarded) {
		this.isEmployeeOnboarded = isEmployeeOnboarded;
	}
	public boolean isExperienced() {
		return isExperienced;
	}
	public void setExperienced(boolean isExperienced) {
		this.isExperienced = isExperienced;
	}
	public boolean isProbationEnabled() {
		return isProbationEnabled;
	}
	public void setProbationEnabled(boolean isProbationEnabled) {
		this.isProbationEnabled = isProbationEnabled;
	}
	public long getProfilePicId() {
		return profilePicId;
	}
	public void setProfilePicId(long profilePicId) {
		this.profilePicId = profilePicId;
	}
	
	public String getInsuranceLink() {
		return insuranceLink;
	}
	public void setInsuranceLink(String insuranceLink) {
		this.insuranceLink = insuranceLink;
	}
	public Date getMarriageDate() {
		return marriageDate;
	}
	public void setMarriageDate(Date marriageDate) {
		this.marriageDate = marriageDate;
	}

	public long getLevelId() {
		return levelId;
	}
	public void setLevelId(long levelId) {
		this.levelId = levelId;
	}
	public String getInstitution() {
		return institution;
	}
	public void setInstitution(String institution) {
		this.institution = institution;
	}
	public String getDegree() {
		return degree;
	}
	public void setDegree(String degree) {
		this.degree = degree;
	}
	public Date getStartDate() {
		return StartDate;
	}
	public void setStartDate(Date startDate) {
		StartDate = startDate;
	}
	public String getPassingYear() {
		return passingYear;
	}
	public void setPassingYear(String passingYear) {
		this.passingYear = passingYear;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
	
	public String getLevelName() {
		return levelName;
	}
	public void setLevelName(String levelName) {
		this.levelName = levelName;
	}
	
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public Date getExperienceJoiningDate() {
		return experienceJoiningDate;
	}
	public void setExperienceJoiningDate(Date experienceJoiningDate) {
		this.experienceJoiningDate = experienceJoiningDate;
	}
	public Date getRelievingDate() {
		return relievingDate;
	}
	public void setRelievingDate(Date relievingDate) {
		this.relievingDate = relievingDate;
	}
	public long getExperienceCertificateMediaId() {
		return experienceCertificateMediaId;
	}
	public void setExperienceCertificateMediaId(long experienceCertificateMediaId) {
		this.experienceCertificateMediaId = experienceCertificateMediaId;
	}
	
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public String getBeneficiaryName() {
		return beneficiaryName;
	}
	public void setBeneficiaryName(String beneficiaryName) {
		this.beneficiaryName = beneficiaryName;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public String getIfscCode() {
		return ifscCode;
	}
	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}
	public String getBankBranch() {
		return bankBranch;
	}
	public void setBankBranch(String bankBranch) {
		this.bankBranch = bankBranch;
	}
	
	
	
	public String getUan() {
		return uan;
	}
	public void setUan(String uan) {
		this.uan = uan;
	}
	public String getEsicNo() {
		return esicNo;
	}
	public void setEsicNo(String esicNo) {
		this.esicNo = esicNo;
	}
	public String getNomineeFirstName() {
		return nomineeFirstName;
	}
	public void setNomineeFirstName(String nomineeFirstName) {
		this.nomineeFirstName = nomineeFirstName;
	}
	public String getNomineeLastName() {
		return nomineeLastName;
	}
	public void setNomineeLastName(String nomineeLastName) {
		this.nomineeLastName = nomineeLastName;
	}
	public String getNomineeContact() {
		return nomineeContact;
	}
	public void setNomineeContact(String nomineeContact) {
		this.nomineeContact = nomineeContact;
	}
	public long getNomineeAddress() {
		return nomineeAddress;
	}
	public void setNomineeAddress(long nomineeAddress) {
		this.nomineeAddress = nomineeAddress;
	}
	public String getRelationshipWithNominee() {
		return relationshipWithNominee;
	}
	public void setRelationshipWithNominee(String relationshipWithNominee) {
		this.relationshipWithNominee = relationshipWithNominee;
	}
	public Date getNomineeDob() {
		return nomineeDob;
	}
	public void setNomineeDob(Date nomineeDob) {
		this.nomineeDob = nomineeDob;
	}
	
	public String getLine1() {
		return line1;
	}
	public void setLine1(String line1) {
		this.line1 = line1;
	}
	public String getLine2() {
		return line2;
	}
	public void setLine2(String line2) {
		this.line2 = line2;
	}
	public String getLine3() {
		return line3;
	}
	public void setLine3(String line3) {
		this.line3 = line3;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public long getCountry() {
		return country;
	}
	public void setCountry(long country) {
		this.country = country;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	
	
	
	public String getExperienceCertificateMediaName() {
		return experienceCertificateMediaName;
	}
	public void setExperienceCertificateMediaName(String experienceCertificateMediaName) {
		this.experienceCertificateMediaName = experienceCertificateMediaName;
	}
	public String getCountryName() {
		return countryName;
	}
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	@Override
	public String toString() {
		return "EmployeeDto [employeeId=" + employeeId + ", lrUserId=" + lrUserId + ", employeeCode=" + employeeCode
				+ ", firstName=" + firstName + ", lastName=" + lastName + ", officialEmail=" + officialEmail
				+ ", personalEmail=" + personalEmail + ", joiningDate=" + joiningDate + ", leavingDate=" + leavingDate
				+ ", mobileNo=" + mobileNo + ", gender=" + gender + ", fatherName=" + fatherName + ", dateOfBirth="
				+ dateOfBirth + ", maritalStatus=" + maritalStatus + ", marriageDate=" + marriageDate + ", spouseName="
				+ spouseName + ", employeeAddressId=" + employeeAddressId + ", skypeId=" + skypeId + ", nominneeId="
				+ nominneeId + ", bankAccountId=" + bankAccountId + ", uanEsicId=" + uanEsicId + ", probationStatusId="
				+ probationStatusId + ", isEmployeeOnboarded=" + isEmployeeOnboarded + ", isExperienced="
				+ isExperienced + ", isProbationEnabled=" + isProbationEnabled + ", profilePicId=" + profilePicId
				+ ", insuranceLink=" + insuranceLink + ", levelId=" + levelId + ", levelName=" + levelName
				+ ", institution=" + institution + ", degree=" + degree + ", StartDate=" + StartDate + ", passingYear="
				+ passingYear + ", endDate=" + endDate + ", companyName=" + companyName + ", experienceJoiningDate="
				+ experienceJoiningDate + ", relievingDate=" + relievingDate + ", experienceCertificateMediaId="
				+ experienceCertificateMediaId + ", accountNumber=" + accountNumber + ", accountType=" + accountType
				+ ", beneficiaryName=" + beneficiaryName + ", bankName=" + bankName + ", status=" + status
				+ ", ifscCode=" + ifscCode + ", bankBranch=" + bankBranch + ", uan=" + uan + ", esicNo=" + esicNo
				+ ", nomineeFirstName=" + nomineeFirstName + ", nomineeLastName=" + nomineeLastName
				+ ", nomineeContact=" + nomineeContact + ", nomineeAddress=" + nomineeAddress
				+ ", relationshipWithNominee=" + relationshipWithNominee + ", nomineeDob=" + nomineeDob
				+ ", getEmployeeId()=" + getEmployeeId() + ", getLrUserId()=" + getLrUserId() + ", getEmployeeCode()="
				+ getEmployeeCode() + ", getFirstName()=" + getFirstName() + ", getLastName()=" + getLastName()
				+ ", getOfficialEmail()=" + getOfficialEmail() + ", getPersonalEmail()=" + getPersonalEmail()
				+ ", getJoiningDate()=" + getJoiningDate() + ", getLeavingDate()=" + getLeavingDate()
				+ ", getMobileNo()=" + getMobileNo() + ", getGender()=" + getGender() + ", getFatherName()="
				+ getFatherName() + ", getDateOfBirth()=" + getDateOfBirth() + ", isMaritalStatus()="
				+ isMaritalStatus() + ", getSpouseName()=" + getSpouseName() + ", getEmployeeAddressId()="
				+ getEmployeeAddressId() + ", getSkypeId()=" + getSkypeId() + ", getNominneeId()=" + getNominneeId()
				+ ", getBankAccountId()=" + getBankAccountId() + ", getUanEsicId()=" + getUanEsicId()
				+ ", getProbationStatusId()=" + getProbationStatusId() + ", isEmployeeOnboarded()="
				+ isEmployeeOnboarded() + ", isExperienced()=" + isExperienced() + ", isProbationEnabled()="
				+ isProbationEnabled() + ", getProfilePicId()=" + getProfilePicId() + ", getInsuranceLink()="
				+ getInsuranceLink() + ", getMarriageDate()=" + getMarriageDate() + ", getLevelId()=" + getLevelId()
				+ ", getInstitution()=" + getInstitution() + ", getDegree()=" + getDegree() + ", getStartDate()="
				+ getStartDate() + ", getPassingYear()=" + getPassingYear() + ", getEndDate()=" + getEndDate()
				+ ", getLevelName()=" + getLevelName() + ", getCompanyName()=" + getCompanyName()
				+ ", getExperienceJoiningDate()=" + getExperienceJoiningDate() + ", getRelievingDate()="
				+ getRelievingDate() + ", getExperienceCertificateMediaId()=" + getExperienceCertificateMediaId()
				+ ", getAccountNumber()=" + getAccountNumber() + ", getAccountType()=" + getAccountType()
				+ ", getBeneficiaryName()=" + getBeneficiaryName() + ", getBankName()=" + getBankName()
				+ ", isStatus()=" + isStatus() + ", getIfscCode()=" + getIfscCode() + ", getBankBranch()="
				+ getBankBranch() + ", getUan()=" + getUan() + ", getEsicNo()=" + getEsicNo()
				+ ", getNomineeFirstName()=" + getNomineeFirstName() + ", getNomineeLastName()=" + getNomineeLastName()
				+ ", getNomineeContact()=" + getNomineeContact() + ", getNomineeAddress()=" + getNomineeAddress()
				+ ", getRelationshipWithNominee()=" + getRelationshipWithNominee() + ", getNomineeDob()="
				+ getNomineeDob() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
}
