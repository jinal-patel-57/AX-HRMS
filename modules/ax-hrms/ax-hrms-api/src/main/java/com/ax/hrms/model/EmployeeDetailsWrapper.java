/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.model;

import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link EmployeeDetails}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeDetails
 * @generated
 */
public class EmployeeDetailsWrapper
	extends BaseModelWrapper<EmployeeDetails>
	implements EmployeeDetails, ModelWrapper<EmployeeDetails> {

	public EmployeeDetailsWrapper(EmployeeDetails employeeDetails) {
		super(employeeDetails);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("companyId", getCompanyId());
		attributes.put("createdBy", getCreatedBy());
		attributes.put("modifiedBy", getModifiedBy());
		attributes.put("groupId", getGroupId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("employeeId", getEmployeeId());
		attributes.put("employeeCode", getEmployeeCode());
		attributes.put("lrUserId", getLrUserId());
		attributes.put("firstName", getFirstName());
		attributes.put("lastName", getLastName());
		attributes.put("officialEmail", getOfficialEmail());
		attributes.put("personalEmail", getPersonalEmail());
		attributes.put("joiningDate", getJoiningDate());
		attributes.put("leavingDate", getLeavingDate());
		attributes.put("mobileNo", getMobileNo());
		attributes.put("gender", getGender());
		attributes.put("fatherName", getFatherName());
		attributes.put("dateOfBirth", getDateOfBirth());
		attributes.put("maritalStatus", isMaritalStatus());
		attributes.put("marriageDate", getMarriageDate());
		attributes.put("spouseName", getSpouseName());
		attributes.put("employeeAddressId", getEmployeeAddressId());
		attributes.put("skypeId", getSkypeId());
		attributes.put("nominneeId", getNominneeId());
		attributes.put("bankAccountId", getBankAccountId());
		attributes.put("uanEsicId", getUanEsicId());
		attributes.put("probationStatusId", getProbationStatusId());
		attributes.put("isEmployeeOnboarded", isIsEmployeeOnboarded());
		attributes.put("isExperienced", isIsExperienced());
		attributes.put("isProbationEnabled", isIsProbationEnabled());
		attributes.put("profilePicId", getProfilePicId());
		attributes.put("insuranceLink", getInsuranceLink());
		attributes.put("isTerminated", isIsTerminated());
		attributes.put("appraisalDate", getAppraisalDate());
		attributes.put("employeeType", getEmployeeType());
		attributes.put("stipend", getStipend());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long createdBy = (Long)attributes.get("createdBy");

		if (createdBy != null) {
			setCreatedBy(createdBy);
		}

		Long modifiedBy = (Long)attributes.get("modifiedBy");

		if (modifiedBy != null) {
			setModifiedBy(modifiedBy);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Long employeeId = (Long)attributes.get("employeeId");

		if (employeeId != null) {
			setEmployeeId(employeeId);
		}

		String employeeCode = (String)attributes.get("employeeCode");

		if (employeeCode != null) {
			setEmployeeCode(employeeCode);
		}

		Long lrUserId = (Long)attributes.get("lrUserId");

		if (lrUserId != null) {
			setLrUserId(lrUserId);
		}

		String firstName = (String)attributes.get("firstName");

		if (firstName != null) {
			setFirstName(firstName);
		}

		String lastName = (String)attributes.get("lastName");

		if (lastName != null) {
			setLastName(lastName);
		}

		String officialEmail = (String)attributes.get("officialEmail");

		if (officialEmail != null) {
			setOfficialEmail(officialEmail);
		}

		String personalEmail = (String)attributes.get("personalEmail");

		if (personalEmail != null) {
			setPersonalEmail(personalEmail);
		}

		Date joiningDate = (Date)attributes.get("joiningDate");

		if (joiningDate != null) {
			setJoiningDate(joiningDate);
		}

		Date leavingDate = (Date)attributes.get("leavingDate");

		if (leavingDate != null) {
			setLeavingDate(leavingDate);
		}

		String mobileNo = (String)attributes.get("mobileNo");

		if (mobileNo != null) {
			setMobileNo(mobileNo);
		}

		String gender = (String)attributes.get("gender");

		if (gender != null) {
			setGender(gender);
		}

		String fatherName = (String)attributes.get("fatherName");

		if (fatherName != null) {
			setFatherName(fatherName);
		}

		Date dateOfBirth = (Date)attributes.get("dateOfBirth");

		if (dateOfBirth != null) {
			setDateOfBirth(dateOfBirth);
		}

		Boolean maritalStatus = (Boolean)attributes.get("maritalStatus");

		if (maritalStatus != null) {
			setMaritalStatus(maritalStatus);
		}

		Date marriageDate = (Date)attributes.get("marriageDate");

		if (marriageDate != null) {
			setMarriageDate(marriageDate);
		}

		String spouseName = (String)attributes.get("spouseName");

		if (spouseName != null) {
			setSpouseName(spouseName);
		}

		Long employeeAddressId = (Long)attributes.get("employeeAddressId");

		if (employeeAddressId != null) {
			setEmployeeAddressId(employeeAddressId);
		}

		String skypeId = (String)attributes.get("skypeId");

		if (skypeId != null) {
			setSkypeId(skypeId);
		}

		Long nominneeId = (Long)attributes.get("nominneeId");

		if (nominneeId != null) {
			setNominneeId(nominneeId);
		}

		Long bankAccountId = (Long)attributes.get("bankAccountId");

		if (bankAccountId != null) {
			setBankAccountId(bankAccountId);
		}

		Long uanEsicId = (Long)attributes.get("uanEsicId");

		if (uanEsicId != null) {
			setUanEsicId(uanEsicId);
		}

		Long probationStatusId = (Long)attributes.get("probationStatusId");

		if (probationStatusId != null) {
			setProbationStatusId(probationStatusId);
		}

		Boolean isEmployeeOnboarded = (Boolean)attributes.get(
			"isEmployeeOnboarded");

		if (isEmployeeOnboarded != null) {
			setIsEmployeeOnboarded(isEmployeeOnboarded);
		}

		Boolean isExperienced = (Boolean)attributes.get("isExperienced");

		if (isExperienced != null) {
			setIsExperienced(isExperienced);
		}

		Boolean isProbationEnabled = (Boolean)attributes.get(
			"isProbationEnabled");

		if (isProbationEnabled != null) {
			setIsProbationEnabled(isProbationEnabled);
		}

		Long profilePicId = (Long)attributes.get("profilePicId");

		if (profilePicId != null) {
			setProfilePicId(profilePicId);
		}

		String insuranceLink = (String)attributes.get("insuranceLink");

		if (insuranceLink != null) {
			setInsuranceLink(insuranceLink);
		}

		Boolean isTerminated = (Boolean)attributes.get("isTerminated");

		if (isTerminated != null) {
			setIsTerminated(isTerminated);
		}

		Date appraisalDate = (Date)attributes.get("appraisalDate");

		if (appraisalDate != null) {
			setAppraisalDate(appraisalDate);
		}

		String employeeType = (String)attributes.get("employeeType");

		if (employeeType != null) {
			setEmployeeType(employeeType);
		}

		Double stipend = (Double)attributes.get("stipend");

		if (stipend != null) {
			setStipend(stipend);
		}
	}

	@Override
	public EmployeeDetails cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the appraisal date of this employee details.
	 *
	 * @return the appraisal date of this employee details
	 */
	@Override
	public Date getAppraisalDate() {
		return model.getAppraisalDate();
	}

	/**
	 * Returns the bank account ID of this employee details.
	 *
	 * @return the bank account ID of this employee details
	 */
	@Override
	public long getBankAccountId() {
		return model.getBankAccountId();
	}

	/**
	 * Returns the company ID of this employee details.
	 *
	 * @return the company ID of this employee details
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this employee details.
	 *
	 * @return the create date of this employee details
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the created by of this employee details.
	 *
	 * @return the created by of this employee details
	 */
	@Override
	public long getCreatedBy() {
		return model.getCreatedBy();
	}

	/**
	 * Returns the date of birth of this employee details.
	 *
	 * @return the date of birth of this employee details
	 */
	@Override
	public Date getDateOfBirth() {
		return model.getDateOfBirth();
	}

	/**
	 * Returns the employee address ID of this employee details.
	 *
	 * @return the employee address ID of this employee details
	 */
	@Override
	public long getEmployeeAddressId() {
		return model.getEmployeeAddressId();
	}

	/**
	 * Returns the employee code of this employee details.
	 *
	 * @return the employee code of this employee details
	 */
	@Override
	public String getEmployeeCode() {
		return model.getEmployeeCode();
	}

	/**
	 * Returns the employee ID of this employee details.
	 *
	 * @return the employee ID of this employee details
	 */
	@Override
	public long getEmployeeId() {
		return model.getEmployeeId();
	}

	/**
	 * Returns the employee type of this employee details.
	 *
	 * @return the employee type of this employee details
	 */
	@Override
	public String getEmployeeType() {
		return model.getEmployeeType();
	}

	/**
	 * Returns the father name of this employee details.
	 *
	 * @return the father name of this employee details
	 */
	@Override
	public String getFatherName() {
		return model.getFatherName();
	}

	/**
	 * Returns the first name of this employee details.
	 *
	 * @return the first name of this employee details
	 */
	@Override
	public String getFirstName() {
		return model.getFirstName();
	}

	/**
	 * Returns the gender of this employee details.
	 *
	 * @return the gender of this employee details
	 */
	@Override
	public String getGender() {
		return model.getGender();
	}

	/**
	 * Returns the group ID of this employee details.
	 *
	 * @return the group ID of this employee details
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the insurance link of this employee details.
	 *
	 * @return the insurance link of this employee details
	 */
	@Override
	public String getInsuranceLink() {
		return model.getInsuranceLink();
	}

	/**
	 * Returns the is employee onboarded of this employee details.
	 *
	 * @return the is employee onboarded of this employee details
	 */
	@Override
	public boolean getIsEmployeeOnboarded() {
		return model.getIsEmployeeOnboarded();
	}

	/**
	 * Returns the is experienced of this employee details.
	 *
	 * @return the is experienced of this employee details
	 */
	@Override
	public boolean getIsExperienced() {
		return model.getIsExperienced();
	}

	/**
	 * Returns the is probation enabled of this employee details.
	 *
	 * @return the is probation enabled of this employee details
	 */
	@Override
	public boolean getIsProbationEnabled() {
		return model.getIsProbationEnabled();
	}

	/**
	 * Returns the is terminated of this employee details.
	 *
	 * @return the is terminated of this employee details
	 */
	@Override
	public boolean getIsTerminated() {
		return model.getIsTerminated();
	}

	/**
	 * Returns the joining date of this employee details.
	 *
	 * @return the joining date of this employee details
	 */
	@Override
	public Date getJoiningDate() {
		return model.getJoiningDate();
	}

	/**
	 * Returns the last name of this employee details.
	 *
	 * @return the last name of this employee details
	 */
	@Override
	public String getLastName() {
		return model.getLastName();
	}

	/**
	 * Returns the leaving date of this employee details.
	 *
	 * @return the leaving date of this employee details
	 */
	@Override
	public Date getLeavingDate() {
		return model.getLeavingDate();
	}

	/**
	 * Returns the lr user ID of this employee details.
	 *
	 * @return the lr user ID of this employee details
	 */
	@Override
	public long getLrUserId() {
		return model.getLrUserId();
	}

	/**
	 * Returns the lr user uuid of this employee details.
	 *
	 * @return the lr user uuid of this employee details
	 */
	@Override
	public String getLrUserUuid() {
		return model.getLrUserUuid();
	}

	/**
	 * Returns the marital status of this employee details.
	 *
	 * @return the marital status of this employee details
	 */
	@Override
	public boolean getMaritalStatus() {
		return model.getMaritalStatus();
	}

	/**
	 * Returns the marriage date of this employee details.
	 *
	 * @return the marriage date of this employee details
	 */
	@Override
	public Date getMarriageDate() {
		return model.getMarriageDate();
	}

	/**
	 * Returns the mobile no of this employee details.
	 *
	 * @return the mobile no of this employee details
	 */
	@Override
	public String getMobileNo() {
		return model.getMobileNo();
	}

	/**
	 * Returns the modified by of this employee details.
	 *
	 * @return the modified by of this employee details
	 */
	@Override
	public long getModifiedBy() {
		return model.getModifiedBy();
	}

	/**
	 * Returns the modified date of this employee details.
	 *
	 * @return the modified date of this employee details
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the nominnee ID of this employee details.
	 *
	 * @return the nominnee ID of this employee details
	 */
	@Override
	public long getNominneeId() {
		return model.getNominneeId();
	}

	/**
	 * Returns the official email of this employee details.
	 *
	 * @return the official email of this employee details
	 */
	@Override
	public String getOfficialEmail() {
		return model.getOfficialEmail();
	}

	/**
	 * Returns the personal email of this employee details.
	 *
	 * @return the personal email of this employee details
	 */
	@Override
	public String getPersonalEmail() {
		return model.getPersonalEmail();
	}

	/**
	 * Returns the primary key of this employee details.
	 *
	 * @return the primary key of this employee details
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the probation status ID of this employee details.
	 *
	 * @return the probation status ID of this employee details
	 */
	@Override
	public long getProbationStatusId() {
		return model.getProbationStatusId();
	}

	/**
	 * Returns the profile pic ID of this employee details.
	 *
	 * @return the profile pic ID of this employee details
	 */
	@Override
	public long getProfilePicId() {
		return model.getProfilePicId();
	}

	/**
	 * Returns the skype ID of this employee details.
	 *
	 * @return the skype ID of this employee details
	 */
	@Override
	public String getSkypeId() {
		return model.getSkypeId();
	}

	/**
	 * Returns the spouse name of this employee details.
	 *
	 * @return the spouse name of this employee details
	 */
	@Override
	public String getSpouseName() {
		return model.getSpouseName();
	}

	/**
	 * Returns the stipend of this employee details.
	 *
	 * @return the stipend of this employee details
	 */
	@Override
	public double getStipend() {
		return model.getStipend();
	}

	/**
	 * Returns the uan esic ID of this employee details.
	 *
	 * @return the uan esic ID of this employee details
	 */
	@Override
	public long getUanEsicId() {
		return model.getUanEsicId();
	}

	/**
	 * Returns the uuid of this employee details.
	 *
	 * @return the uuid of this employee details
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns <code>true</code> if this employee details is is employee onboarded.
	 *
	 * @return <code>true</code> if this employee details is is employee onboarded; <code>false</code> otherwise
	 */
	@Override
	public boolean isIsEmployeeOnboarded() {
		return model.isIsEmployeeOnboarded();
	}

	/**
	 * Returns <code>true</code> if this employee details is is experienced.
	 *
	 * @return <code>true</code> if this employee details is is experienced; <code>false</code> otherwise
	 */
	@Override
	public boolean isIsExperienced() {
		return model.isIsExperienced();
	}

	/**
	 * Returns <code>true</code> if this employee details is is probation enabled.
	 *
	 * @return <code>true</code> if this employee details is is probation enabled; <code>false</code> otherwise
	 */
	@Override
	public boolean isIsProbationEnabled() {
		return model.isIsProbationEnabled();
	}

	/**
	 * Returns <code>true</code> if this employee details is is terminated.
	 *
	 * @return <code>true</code> if this employee details is is terminated; <code>false</code> otherwise
	 */
	@Override
	public boolean isIsTerminated() {
		return model.isIsTerminated();
	}

	/**
	 * Returns <code>true</code> if this employee details is marital status.
	 *
	 * @return <code>true</code> if this employee details is marital status; <code>false</code> otherwise
	 */
	@Override
	public boolean isMaritalStatus() {
		return model.isMaritalStatus();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the appraisal date of this employee details.
	 *
	 * @param appraisalDate the appraisal date of this employee details
	 */
	@Override
	public void setAppraisalDate(Date appraisalDate) {
		model.setAppraisalDate(appraisalDate);
	}

	/**
	 * Sets the bank account ID of this employee details.
	 *
	 * @param bankAccountId the bank account ID of this employee details
	 */
	@Override
	public void setBankAccountId(long bankAccountId) {
		model.setBankAccountId(bankAccountId);
	}

	/**
	 * Sets the company ID of this employee details.
	 *
	 * @param companyId the company ID of this employee details
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this employee details.
	 *
	 * @param createDate the create date of this employee details
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the created by of this employee details.
	 *
	 * @param createdBy the created by of this employee details
	 */
	@Override
	public void setCreatedBy(long createdBy) {
		model.setCreatedBy(createdBy);
	}

	/**
	 * Sets the date of birth of this employee details.
	 *
	 * @param dateOfBirth the date of birth of this employee details
	 */
	@Override
	public void setDateOfBirth(Date dateOfBirth) {
		model.setDateOfBirth(dateOfBirth);
	}

	/**
	 * Sets the employee address ID of this employee details.
	 *
	 * @param employeeAddressId the employee address ID of this employee details
	 */
	@Override
	public void setEmployeeAddressId(long employeeAddressId) {
		model.setEmployeeAddressId(employeeAddressId);
	}

	/**
	 * Sets the employee code of this employee details.
	 *
	 * @param employeeCode the employee code of this employee details
	 */
	@Override
	public void setEmployeeCode(String employeeCode) {
		model.setEmployeeCode(employeeCode);
	}

	/**
	 * Sets the employee ID of this employee details.
	 *
	 * @param employeeId the employee ID of this employee details
	 */
	@Override
	public void setEmployeeId(long employeeId) {
		model.setEmployeeId(employeeId);
	}

	/**
	 * Sets the employee type of this employee details.
	 *
	 * @param employeeType the employee type of this employee details
	 */
	@Override
	public void setEmployeeType(String employeeType) {
		model.setEmployeeType(employeeType);
	}

	/**
	 * Sets the father name of this employee details.
	 *
	 * @param fatherName the father name of this employee details
	 */
	@Override
	public void setFatherName(String fatherName) {
		model.setFatherName(fatherName);
	}

	/**
	 * Sets the first name of this employee details.
	 *
	 * @param firstName the first name of this employee details
	 */
	@Override
	public void setFirstName(String firstName) {
		model.setFirstName(firstName);
	}

	/**
	 * Sets the gender of this employee details.
	 *
	 * @param gender the gender of this employee details
	 */
	@Override
	public void setGender(String gender) {
		model.setGender(gender);
	}

	/**
	 * Sets the group ID of this employee details.
	 *
	 * @param groupId the group ID of this employee details
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the insurance link of this employee details.
	 *
	 * @param insuranceLink the insurance link of this employee details
	 */
	@Override
	public void setInsuranceLink(String insuranceLink) {
		model.setInsuranceLink(insuranceLink);
	}

	/**
	 * Sets whether this employee details is is employee onboarded.
	 *
	 * @param isEmployeeOnboarded the is employee onboarded of this employee details
	 */
	@Override
	public void setIsEmployeeOnboarded(boolean isEmployeeOnboarded) {
		model.setIsEmployeeOnboarded(isEmployeeOnboarded);
	}

	/**
	 * Sets whether this employee details is is experienced.
	 *
	 * @param isExperienced the is experienced of this employee details
	 */
	@Override
	public void setIsExperienced(boolean isExperienced) {
		model.setIsExperienced(isExperienced);
	}

	/**
	 * Sets whether this employee details is is probation enabled.
	 *
	 * @param isProbationEnabled the is probation enabled of this employee details
	 */
	@Override
	public void setIsProbationEnabled(boolean isProbationEnabled) {
		model.setIsProbationEnabled(isProbationEnabled);
	}

	/**
	 * Sets whether this employee details is is terminated.
	 *
	 * @param isTerminated the is terminated of this employee details
	 */
	@Override
	public void setIsTerminated(boolean isTerminated) {
		model.setIsTerminated(isTerminated);
	}

	/**
	 * Sets the joining date of this employee details.
	 *
	 * @param joiningDate the joining date of this employee details
	 */
	@Override
	public void setJoiningDate(Date joiningDate) {
		model.setJoiningDate(joiningDate);
	}

	/**
	 * Sets the last name of this employee details.
	 *
	 * @param lastName the last name of this employee details
	 */
	@Override
	public void setLastName(String lastName) {
		model.setLastName(lastName);
	}

	/**
	 * Sets the leaving date of this employee details.
	 *
	 * @param leavingDate the leaving date of this employee details
	 */
	@Override
	public void setLeavingDate(Date leavingDate) {
		model.setLeavingDate(leavingDate);
	}

	/**
	 * Sets the lr user ID of this employee details.
	 *
	 * @param lrUserId the lr user ID of this employee details
	 */
	@Override
	public void setLrUserId(long lrUserId) {
		model.setLrUserId(lrUserId);
	}

	/**
	 * Sets the lr user uuid of this employee details.
	 *
	 * @param lrUserUuid the lr user uuid of this employee details
	 */
	@Override
	public void setLrUserUuid(String lrUserUuid) {
		model.setLrUserUuid(lrUserUuid);
	}

	/**
	 * Sets whether this employee details is marital status.
	 *
	 * @param maritalStatus the marital status of this employee details
	 */
	@Override
	public void setMaritalStatus(boolean maritalStatus) {
		model.setMaritalStatus(maritalStatus);
	}

	/**
	 * Sets the marriage date of this employee details.
	 *
	 * @param marriageDate the marriage date of this employee details
	 */
	@Override
	public void setMarriageDate(Date marriageDate) {
		model.setMarriageDate(marriageDate);
	}

	/**
	 * Sets the mobile no of this employee details.
	 *
	 * @param mobileNo the mobile no of this employee details
	 */
	@Override
	public void setMobileNo(String mobileNo) {
		model.setMobileNo(mobileNo);
	}

	/**
	 * Sets the modified by of this employee details.
	 *
	 * @param modifiedBy the modified by of this employee details
	 */
	@Override
	public void setModifiedBy(long modifiedBy) {
		model.setModifiedBy(modifiedBy);
	}

	/**
	 * Sets the modified date of this employee details.
	 *
	 * @param modifiedDate the modified date of this employee details
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the nominnee ID of this employee details.
	 *
	 * @param nominneeId the nominnee ID of this employee details
	 */
	@Override
	public void setNominneeId(long nominneeId) {
		model.setNominneeId(nominneeId);
	}

	/**
	 * Sets the official email of this employee details.
	 *
	 * @param officialEmail the official email of this employee details
	 */
	@Override
	public void setOfficialEmail(String officialEmail) {
		model.setOfficialEmail(officialEmail);
	}

	/**
	 * Sets the personal email of this employee details.
	 *
	 * @param personalEmail the personal email of this employee details
	 */
	@Override
	public void setPersonalEmail(String personalEmail) {
		model.setPersonalEmail(personalEmail);
	}

	/**
	 * Sets the primary key of this employee details.
	 *
	 * @param primaryKey the primary key of this employee details
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the probation status ID of this employee details.
	 *
	 * @param probationStatusId the probation status ID of this employee details
	 */
	@Override
	public void setProbationStatusId(long probationStatusId) {
		model.setProbationStatusId(probationStatusId);
	}

	/**
	 * Sets the profile pic ID of this employee details.
	 *
	 * @param profilePicId the profile pic ID of this employee details
	 */
	@Override
	public void setProfilePicId(long profilePicId) {
		model.setProfilePicId(profilePicId);
	}

	/**
	 * Sets the skype ID of this employee details.
	 *
	 * @param skypeId the skype ID of this employee details
	 */
	@Override
	public void setSkypeId(String skypeId) {
		model.setSkypeId(skypeId);
	}

	/**
	 * Sets the spouse name of this employee details.
	 *
	 * @param spouseName the spouse name of this employee details
	 */
	@Override
	public void setSpouseName(String spouseName) {
		model.setSpouseName(spouseName);
	}

	/**
	 * Sets the stipend of this employee details.
	 *
	 * @param stipend the stipend of this employee details
	 */
	@Override
	public void setStipend(double stipend) {
		model.setStipend(stipend);
	}

	/**
	 * Sets the uan esic ID of this employee details.
	 *
	 * @param uanEsicId the uan esic ID of this employee details
	 */
	@Override
	public void setUanEsicId(long uanEsicId) {
		model.setUanEsicId(uanEsicId);
	}

	/**
	 * Sets the uuid of this employee details.
	 *
	 * @param uuid the uuid of this employee details
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	@Override
	public String toXmlString() {
		return model.toXmlString();
	}

	@Override
	public StagedModelType getStagedModelType() {
		return model.getStagedModelType();
	}

	@Override
	protected EmployeeDetailsWrapper wrap(EmployeeDetails employeeDetails) {
		return new EmployeeDetailsWrapper(employeeDetails);
	}

}