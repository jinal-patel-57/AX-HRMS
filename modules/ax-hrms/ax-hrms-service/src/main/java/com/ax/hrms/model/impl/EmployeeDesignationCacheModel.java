/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.model.impl;

import com.ax.hrms.model.EmployeeDesignation;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing EmployeeDesignation in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class EmployeeDesignationCacheModel
	implements CacheModel<EmployeeDesignation>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof EmployeeDesignationCacheModel)) {
			return false;
		}

		EmployeeDesignationCacheModel employeeDesignationCacheModel =
			(EmployeeDesignationCacheModel)object;

		if (employeeDesignationId ==
				employeeDesignationCacheModel.employeeDesignationId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, employeeDesignationId);
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
		sb.append(", employeeDesignationId=");
		sb.append(employeeDesignationId);
		sb.append(", designationMasterId=");
		sb.append(designationMasterId);
		sb.append(", status=");
		sb.append(status);
		sb.append(", startDate=");
		sb.append(startDate);
		sb.append(", endDate=");
		sb.append(endDate);
		sb.append(", employeeId=");
		sb.append(employeeId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public EmployeeDesignation toEntityModel() {
		EmployeeDesignationImpl employeeDesignationImpl =
			new EmployeeDesignationImpl();

		if (uuid == null) {
			employeeDesignationImpl.setUuid("");
		}
		else {
			employeeDesignationImpl.setUuid(uuid);
		}

		employeeDesignationImpl.setCompanyId(companyId);
		employeeDesignationImpl.setCreatedBy(createdBy);
		employeeDesignationImpl.setModifiedBy(modifiedBy);
		employeeDesignationImpl.setGroupId(groupId);

		if (createDate == Long.MIN_VALUE) {
			employeeDesignationImpl.setCreateDate(null);
		}
		else {
			employeeDesignationImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			employeeDesignationImpl.setModifiedDate(null);
		}
		else {
			employeeDesignationImpl.setModifiedDate(new Date(modifiedDate));
		}

		employeeDesignationImpl.setEmployeeDesignationId(employeeDesignationId);
		employeeDesignationImpl.setDesignationMasterId(designationMasterId);
		employeeDesignationImpl.setStatus(status);

		if (startDate == Long.MIN_VALUE) {
			employeeDesignationImpl.setStartDate(null);
		}
		else {
			employeeDesignationImpl.setStartDate(new Date(startDate));
		}

		if (endDate == Long.MIN_VALUE) {
			employeeDesignationImpl.setEndDate(null);
		}
		else {
			employeeDesignationImpl.setEndDate(new Date(endDate));
		}

		employeeDesignationImpl.setEmployeeId(employeeId);

		employeeDesignationImpl.resetOriginalValues();

		return employeeDesignationImpl;
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

		employeeDesignationId = objectInput.readLong();

		designationMasterId = objectInput.readLong();

		status = objectInput.readBoolean();
		startDate = objectInput.readLong();
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

		objectOutput.writeLong(employeeDesignationId);

		objectOutput.writeLong(designationMasterId);

		objectOutput.writeBoolean(status);
		objectOutput.writeLong(startDate);
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
	public long employeeDesignationId;
	public long designationMasterId;
	public boolean status;
	public long startDate;
	public long endDate;
	public long employeeId;

}