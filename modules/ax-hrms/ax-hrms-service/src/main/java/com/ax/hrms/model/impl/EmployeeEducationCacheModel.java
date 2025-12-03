/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.model.impl;

import com.ax.hrms.model.EmployeeEducation;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing EmployeeEducation in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class EmployeeEducationCacheModel
	implements CacheModel<EmployeeEducation>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof EmployeeEducationCacheModel)) {
			return false;
		}

		EmployeeEducationCacheModel employeeEducationCacheModel =
			(EmployeeEducationCacheModel)object;

		if (educationId == employeeEducationCacheModel.educationId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, educationId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(31);

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
		sb.append(", educationId=");
		sb.append(educationId);
		sb.append(", levelId=");
		sb.append(levelId);
		sb.append(", institution=");
		sb.append(institution);
		sb.append(", degree=");
		sb.append(degree);
		sb.append(", startDate=");
		sb.append(startDate);
		sb.append(", passingYear=");
		sb.append(passingYear);
		sb.append(", endDate=");
		sb.append(endDate);
		sb.append(", employeeId=");
		sb.append(employeeId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public EmployeeEducation toEntityModel() {
		EmployeeEducationImpl employeeEducationImpl =
			new EmployeeEducationImpl();

		if (uuid == null) {
			employeeEducationImpl.setUuid("");
		}
		else {
			employeeEducationImpl.setUuid(uuid);
		}

		employeeEducationImpl.setCompanyId(companyId);
		employeeEducationImpl.setCreatedBy(createdBy);
		employeeEducationImpl.setModifiedBy(modifiedBy);
		employeeEducationImpl.setGroupId(groupId);

		if (createDate == Long.MIN_VALUE) {
			employeeEducationImpl.setCreateDate(null);
		}
		else {
			employeeEducationImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			employeeEducationImpl.setModifiedDate(null);
		}
		else {
			employeeEducationImpl.setModifiedDate(new Date(modifiedDate));
		}

		employeeEducationImpl.setEducationId(educationId);
		employeeEducationImpl.setLevelId(levelId);

		if (institution == null) {
			employeeEducationImpl.setInstitution("");
		}
		else {
			employeeEducationImpl.setInstitution(institution);
		}

		if (degree == null) {
			employeeEducationImpl.setDegree("");
		}
		else {
			employeeEducationImpl.setDegree(degree);
		}

		if (startDate == Long.MIN_VALUE) {
			employeeEducationImpl.setStartDate(null);
		}
		else {
			employeeEducationImpl.setStartDate(new Date(startDate));
		}

		if (passingYear == null) {
			employeeEducationImpl.setPassingYear("");
		}
		else {
			employeeEducationImpl.setPassingYear(passingYear);
		}

		if (endDate == Long.MIN_VALUE) {
			employeeEducationImpl.setEndDate(null);
		}
		else {
			employeeEducationImpl.setEndDate(new Date(endDate));
		}

		employeeEducationImpl.setEmployeeId(employeeId);

		employeeEducationImpl.resetOriginalValues();

		return employeeEducationImpl;
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

		educationId = objectInput.readLong();

		levelId = objectInput.readLong();
		institution = objectInput.readUTF();
		degree = objectInput.readUTF();
		startDate = objectInput.readLong();
		passingYear = objectInput.readUTF();
		endDate = objectInput.readLong();

		employeeId = objectInput.readLong();
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

		objectOutput.writeLong(educationId);

		objectOutput.writeLong(levelId);

		if (institution == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(institution);
		}

		if (degree == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(degree);
		}

		objectOutput.writeLong(startDate);

		if (passingYear == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(passingYear);
		}

		objectOutput.writeLong(endDate);

		objectOutput.writeLong(employeeId);
	}

	public String uuid;
	public long companyId;
	public long createdBy;
	public long modifiedBy;
	public long groupId;
	public long createDate;
	public long modifiedDate;
	public long educationId;
	public long levelId;
	public String institution;
	public String degree;
	public long startDate;
	public String passingYear;
	public long endDate;
	public long employeeId;

}