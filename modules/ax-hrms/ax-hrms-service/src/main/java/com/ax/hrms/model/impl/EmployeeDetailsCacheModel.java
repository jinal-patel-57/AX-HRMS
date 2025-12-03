/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.model.impl;

import com.ax.hrms.model.EmployeeDetails;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing EmployeeDetails in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class EmployeeDetailsCacheModel
	implements CacheModel<EmployeeDetails>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof EmployeeDetailsCacheModel)) {
			return false;
		}

		EmployeeDetailsCacheModel employeeDetailsCacheModel =
			(EmployeeDetailsCacheModel)object;

		if (employeeId == employeeDetailsCacheModel.employeeId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, employeeId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(77);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", createdBy=");
		sb.append(createdBy);
		sb.append(", modifiedBy=");
		sb.append(modifiedBy);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", employeeId=");
		sb.append(employeeId);
		sb.append(", employeeCode=");
		sb.append(employeeCode);
		sb.append(", lrUserId=");
		sb.append(lrUserId);
		sb.append(", firstName=");
		sb.append(firstName);
		sb.append(", lastName=");
		sb.append(lastName);
		sb.append(", officialEmail=");
		sb.append(officialEmail);
		sb.append(", personalEmail=");
		sb.append(personalEmail);
		sb.append(", joiningDate=");
		sb.append(joiningDate);
		sb.append(", leavingDate=");
		sb.append(leavingDate);
		sb.append(", mobileNo=");
		sb.append(mobileNo);
		sb.append(", gender=");
		sb.append(gender);
		sb.append(", fatherName=");
		sb.append(fatherName);
		sb.append(", dateOfBirth=");
		sb.append(dateOfBirth);
		sb.append(", maritalStatus=");
		sb.append(maritalStatus);
		sb.append(", marriageDate=");
		sb.append(marriageDate);
		sb.append(", spouseName=");
		sb.append(spouseName);
		sb.append(", employeeAddressId=");
		sb.append(employeeAddressId);
		sb.append(", skypeId=");
		sb.append(skypeId);
		sb.append(", nominneeId=");
		sb.append(nominneeId);
		sb.append(", bankAccountId=");
		sb.append(bankAccountId);
		sb.append(", uanEsicId=");
		sb.append(uanEsicId);
		sb.append(", probationStatusId =");
		sb.append(probationStatusId);
		sb.append(", isEmployeeOnboarded=");
		sb.append(isEmployeeOnboarded);
		sb.append(", isExperienced=");
		sb.append(isExperienced);
		sb.append(", isProbationEnabled=");
		sb.append(isProbationEnabled);
		sb.append(", profilePicId=");
		sb.append(profilePicId);
		sb.append(", insuranceLink=");
		sb.append(insuranceLink);
		sb.append(", isTerminated=");
		sb.append(isTerminated);
		sb.append(", appraisalDate=");
		sb.append(appraisalDate);
		sb.append(", employeeType=");
		sb.append(employeeType);
		sb.append(", stipend=");
		sb.append(stipend);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public EmployeeDetails toEntityModel() {
		EmployeeDetailsImpl employeeDetailsImpl = new EmployeeDetailsImpl();

		if (uuid == null) {
			employeeDetailsImpl.setUuid("");
		}
		else {
			employeeDetailsImpl.setUuid(uuid);
		}

		employeeDetailsImpl.setCompanyId(companyId);
		employeeDetailsImpl.setCreatedBy(createdBy);
		employeeDetailsImpl.setModifiedBy(modifiedBy);
		employeeDetailsImpl.setGroupId(groupId);

		if (createDate == Long.MIN_VALUE) {
			employeeDetailsImpl.setCreateDate(null);
		}
		else {
			employeeDetailsImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			employeeDetailsImpl.setModifiedDate(null);
		}
		else {
			employeeDetailsImpl.setModifiedDate(new Date(modifiedDate));
		}

		employeeDetailsImpl.setEmployeeId(employeeId);

		if (employeeCode == null) {
			employeeDetailsImpl.setEmployeeCode("");
		}
		else {
			employeeDetailsImpl.setEmployeeCode(employeeCode);
		}

		employeeDetailsImpl.setLrUserId(lrUserId);

		if (firstName == null) {
			employeeDetailsImpl.setFirstName("");
		}
		else {
			employeeDetailsImpl.setFirstName(firstName);
		}

		if (lastName == null) {
			employeeDetailsImpl.setLastName("");
		}
		else {
			employeeDetailsImpl.setLastName(lastName);
		}

		if (officialEmail == null) {
			employeeDetailsImpl.setOfficialEmail("");
		}
		else {
			employeeDetailsImpl.setOfficialEmail(officialEmail);
		}

		if (personalEmail == null) {
			employeeDetailsImpl.setPersonalEmail("");
		}
		else {
			employeeDetailsImpl.setPersonalEmail(personalEmail);
		}

		if (joiningDate == Long.MIN_VALUE) {
			employeeDetailsImpl.setJoiningDate(null);
		}
		else {
			employeeDetailsImpl.setJoiningDate(new Date(joiningDate));
		}

		if (leavingDate == Long.MIN_VALUE) {
			employeeDetailsImpl.setLeavingDate(null);
		}
		else {
			employeeDetailsImpl.setLeavingDate(new Date(leavingDate));
		}

		if (mobileNo == null) {
			employeeDetailsImpl.setMobileNo("");
		}
		else {
			employeeDetailsImpl.setMobileNo(mobileNo);
		}

		if (gender == null) {
			employeeDetailsImpl.setGender("");
		}
		else {
			employeeDetailsImpl.setGender(gender);
		}

		if (fatherName == null) {
			employeeDetailsImpl.setFatherName("");
		}
		else {
			employeeDetailsImpl.setFatherName(fatherName);
		}

		if (dateOfBirth == Long.MIN_VALUE) {
			employeeDetailsImpl.setDateOfBirth(null);
		}
		else {
			employeeDetailsImpl.setDateOfBirth(new Date(dateOfBirth));
		}

		employeeDetailsImpl.setMaritalStatus(maritalStatus);

		if (marriageDate == Long.MIN_VALUE) {
			employeeDetailsImpl.setMarriageDate(null);
		}
		else {
			employeeDetailsImpl.setMarriageDate(new Date(marriageDate));
		}

		if (spouseName == null) {
			employeeDetailsImpl.setSpouseName("");
		}
		else {
			employeeDetailsImpl.setSpouseName(spouseName);
		}

		employeeDetailsImpl.setEmployeeAddressId(employeeAddressId);

		if (skypeId == null) {
			employeeDetailsImpl.setSkypeId("");
		}
		else {
			employeeDetailsImpl.setSkypeId(skypeId);
		}

		employeeDetailsImpl.setNominneeId(nominneeId);
		employeeDetailsImpl.setBankAccountId(bankAccountId);
		employeeDetailsImpl.setUanEsicId(uanEsicId);
		employeeDetailsImpl.setProbationStatusId(probationStatusId);
		employeeDetailsImpl.setIsEmployeeOnboarded(isEmployeeOnboarded);
		employeeDetailsImpl.setIsExperienced(isExperienced);
		employeeDetailsImpl.setIsProbationEnabled(isProbationEnabled);
		employeeDetailsImpl.setProfilePicId(profilePicId);

		if (insuranceLink == null) {
			employeeDetailsImpl.setInsuranceLink("");
		}
		else {
			employeeDetailsImpl.setInsuranceLink(insuranceLink);
		}

		employeeDetailsImpl.setIsTerminated(isTerminated);

		if (appraisalDate == Long.MIN_VALUE) {
			employeeDetailsImpl.setAppraisalDate(null);
		}
		else {
			employeeDetailsImpl.setAppraisalDate(new Date(appraisalDate));
		}

		if (employeeType == null) {
			employeeDetailsImpl.setEmployeeType("");
		}
		else {
			employeeDetailsImpl.setEmployeeType(employeeType);
		}

		employeeDetailsImpl.setStipend(stipend);

		employeeDetailsImpl.resetOriginalValues();

		return employeeDetailsImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		companyId = objectInput.readLong();

		createdBy = objectInput.readLong();

		modifiedBy = objectInput.readLong();

		groupId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		employeeId = objectInput.readLong();
		employeeCode = objectInput.readUTF();

		lrUserId = objectInput.readLong();
		firstName = objectInput.readUTF();
		lastName = objectInput.readUTF();
		officialEmail = objectInput.readUTF();
		personalEmail = objectInput.readUTF();
		joiningDate = objectInput.readLong();
		leavingDate = objectInput.readLong();
		mobileNo = objectInput.readUTF();
		gender = objectInput.readUTF();
		fatherName = objectInput.readUTF();
		dateOfBirth = objectInput.readLong();

		maritalStatus = objectInput.readBoolean();
		marriageDate = objectInput.readLong();
		spouseName = objectInput.readUTF();

		employeeAddressId = objectInput.readLong();
		skypeId = objectInput.readUTF();

		nominneeId = objectInput.readLong();

		bankAccountId = objectInput.readLong();

		uanEsicId = objectInput.readLong();

		probationStatusId = objectInput.readLong();

		isEmployeeOnboarded = objectInput.readBoolean();

		isExperienced = objectInput.readBoolean();

		isProbationEnabled = objectInput.readBoolean();

		profilePicId = objectInput.readLong();
		insuranceLink = objectInput.readUTF();

		isTerminated = objectInput.readBoolean();
		appraisalDate = objectInput.readLong();
		employeeType = objectInput.readUTF();

		stipend = objectInput.readDouble();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(createdBy);

		objectOutput.writeLong(modifiedBy);

		objectOutput.writeLong(groupId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeLong(employeeId);

		if (employeeCode == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(employeeCode);
		}

		objectOutput.writeLong(lrUserId);

		if (firstName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(firstName);
		}

		if (lastName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(lastName);
		}

		if (officialEmail == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(officialEmail);
		}

		if (personalEmail == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(personalEmail);
		}

		objectOutput.writeLong(joiningDate);
		objectOutput.writeLong(leavingDate);

		if (mobileNo == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(mobileNo);
		}

		if (gender == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(gender);
		}

		if (fatherName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(fatherName);
		}

		objectOutput.writeLong(dateOfBirth);

		objectOutput.writeBoolean(maritalStatus);
		objectOutput.writeLong(marriageDate);

		if (spouseName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(spouseName);
		}

		objectOutput.writeLong(employeeAddressId);

		if (skypeId == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(skypeId);
		}

		objectOutput.writeLong(nominneeId);

		objectOutput.writeLong(bankAccountId);

		objectOutput.writeLong(uanEsicId);

		objectOutput.writeLong(probationStatusId);

		objectOutput.writeBoolean(isEmployeeOnboarded);

		objectOutput.writeBoolean(isExperienced);

		objectOutput.writeBoolean(isProbationEnabled);

		objectOutput.writeLong(profilePicId);

		if (insuranceLink == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(insuranceLink);
		}

		objectOutput.writeBoolean(isTerminated);
		objectOutput.writeLong(appraisalDate);

		if (employeeType == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(employeeType);
		}

		objectOutput.writeDouble(stipend);
	}

	public String uuid;
	public long companyId;
	public long createdBy;
	public long modifiedBy;
	public long groupId;
	public long createDate;
	public long modifiedDate;
	public long employeeId;
	public String employeeCode;
	public long lrUserId;
	public String firstName;
	public String lastName;
	public String officialEmail;
	public String personalEmail;
	public long joiningDate;
	public long leavingDate;
	public String mobileNo;
	public String gender;
	public String fatherName;
	public long dateOfBirth;
	public boolean maritalStatus;
	public long marriageDate;
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
	public boolean isTerminated;
	public long appraisalDate;
	public String employeeType;
	public double stipend;

}