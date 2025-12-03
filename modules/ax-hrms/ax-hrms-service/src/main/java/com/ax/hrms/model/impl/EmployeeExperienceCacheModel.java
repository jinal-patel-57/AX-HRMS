/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.model.impl;

import com.ax.hrms.model.EmployeeExperience;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing EmployeeExperience in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class EmployeeExperienceCacheModel
	implements CacheModel<EmployeeExperience>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof EmployeeExperienceCacheModel)) {
			return false;
		}

		EmployeeExperienceCacheModel employeeExperienceCacheModel =
			(EmployeeExperienceCacheModel)object;

		if (experienceId == employeeExperienceCacheModel.experienceId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, experienceId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(27);

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
		sb.append(", experienceId=");
		sb.append(experienceId);
		sb.append(", companyName=");
		sb.append(companyName);
		sb.append(", joiningDate=");
		sb.append(joiningDate);
		sb.append(", relievingDate=");
		sb.append(relievingDate);
		sb.append(", experienceCertificateMediaId=");
		sb.append(experienceCertificateMediaId);
		sb.append(", employeeId=");
		sb.append(employeeId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public EmployeeExperience toEntityModel() {
		EmployeeExperienceImpl employeeExperienceImpl =
			new EmployeeExperienceImpl();

		if (uuid == null) {
			employeeExperienceImpl.setUuid("");
		}
		else {
			employeeExperienceImpl.setUuid(uuid);
		}

		employeeExperienceImpl.setCompanyId(companyId);
		employeeExperienceImpl.setCreatedBy(createdBy);
		employeeExperienceImpl.setModifiedBy(modifiedBy);
		employeeExperienceImpl.setGroupId(groupId);

		if (createDate == Long.MIN_VALUE) {
			employeeExperienceImpl.setCreateDate(null);
		}
		else {
			employeeExperienceImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			employeeExperienceImpl.setModifiedDate(null);
		}
		else {
			employeeExperienceImpl.setModifiedDate(new Date(modifiedDate));
		}

		employeeExperienceImpl.setExperienceId(experienceId);

		if (companyName == null) {
			employeeExperienceImpl.setCompanyName("");
		}
		else {
			employeeExperienceImpl.setCompanyName(companyName);
		}

		if (joiningDate == Long.MIN_VALUE) {
			employeeExperienceImpl.setJoiningDate(null);
		}
		else {
			employeeExperienceImpl.setJoiningDate(new Date(joiningDate));
		}

		if (relievingDate == Long.MIN_VALUE) {
			employeeExperienceImpl.setRelievingDate(null);
		}
		else {
			employeeExperienceImpl.setRelievingDate(new Date(relievingDate));
		}

		employeeExperienceImpl.setExperienceCertificateMediaId(
			experienceCertificateMediaId);
		employeeExperienceImpl.setEmployeeId(employeeId);

		employeeExperienceImpl.resetOriginalValues();

		return employeeExperienceImpl;
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

		experienceId = objectInput.readLong();
		companyName = objectInput.readUTF();
		joiningDate = objectInput.readLong();
		relievingDate = objectInput.readLong();

		experienceCertificateMediaId = objectInput.readLong();

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

		objectOutput.writeLong(experienceId);

		if (companyName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(companyName);
		}

		objectOutput.writeLong(joiningDate);
		objectOutput.writeLong(relievingDate);

		objectOutput.writeLong(experienceCertificateMediaId);

		objectOutput.writeLong(employeeId);
	}

	public String uuid;
	public long companyId;
	public long createdBy;
	public long modifiedBy;
	public long groupId;
	public long createDate;
	public long modifiedDate;
	public long experienceId;
	public String companyName;
	public long joiningDate;
	public long relievingDate;
	public long experienceCertificateMediaId;
	public long employeeId;

}