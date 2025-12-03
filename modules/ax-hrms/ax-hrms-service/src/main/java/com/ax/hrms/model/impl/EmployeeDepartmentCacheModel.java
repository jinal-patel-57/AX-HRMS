/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.model.impl;

import com.ax.hrms.model.EmployeeDepartment;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing EmployeeDepartment in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class EmployeeDepartmentCacheModel
	implements CacheModel<EmployeeDepartment>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof EmployeeDepartmentCacheModel)) {
			return false;
		}

		EmployeeDepartmentCacheModel employeeDepartmentCacheModel =
			(EmployeeDepartmentCacheModel)object;

		if (employeeDepartmentId ==
				employeeDepartmentCacheModel.employeeDepartmentId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, employeeDepartmentId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

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
		sb.append(", employeeDepartmentId=");
		sb.append(employeeDepartmentId);
		sb.append(", departmentMasterId=");
		sb.append(departmentMasterId);
		sb.append(", status=");
		sb.append(status);
		sb.append(", dateOfChange=");
		sb.append(dateOfChange);
		sb.append(", employeeId=");
		sb.append(employeeId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public EmployeeDepartment toEntityModel() {
		EmployeeDepartmentImpl employeeDepartmentImpl =
			new EmployeeDepartmentImpl();

		if (uuid == null) {
			employeeDepartmentImpl.setUuid("");
		}
		else {
			employeeDepartmentImpl.setUuid(uuid);
		}

		employeeDepartmentImpl.setCompanyId(companyId);
		employeeDepartmentImpl.setCreatedBy(createdBy);
		employeeDepartmentImpl.setModifiedBy(modifiedBy);
		employeeDepartmentImpl.setGroupId(groupId);

		if (createDate == Long.MIN_VALUE) {
			employeeDepartmentImpl.setCreateDate(null);
		}
		else {
			employeeDepartmentImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			employeeDepartmentImpl.setModifiedDate(null);
		}
		else {
			employeeDepartmentImpl.setModifiedDate(new Date(modifiedDate));
		}

		employeeDepartmentImpl.setEmployeeDepartmentId(employeeDepartmentId);
		employeeDepartmentImpl.setDepartmentMasterId(departmentMasterId);
		employeeDepartmentImpl.setStatus(status);

		if (dateOfChange == Long.MIN_VALUE) {
			employeeDepartmentImpl.setDateOfChange(null);
		}
		else {
			employeeDepartmentImpl.setDateOfChange(new Date(dateOfChange));
		}

		employeeDepartmentImpl.setEmployeeId(employeeId);

		employeeDepartmentImpl.resetOriginalValues();

		return employeeDepartmentImpl;
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

		employeeDepartmentId = objectInput.readLong();

		departmentMasterId = objectInput.readLong();

		status = objectInput.readBoolean();
		dateOfChange = objectInput.readLong();

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

		objectOutput.writeLong(employeeDepartmentId);

		objectOutput.writeLong(departmentMasterId);

		objectOutput.writeBoolean(status);
		objectOutput.writeLong(dateOfChange);

		objectOutput.writeLong(employeeId);
	}

	public String uuid;
	public long companyId;
	public long createdBy;
	public long modifiedBy;
	public long groupId;
	public long createDate;
	public long modifiedDate;
	public long employeeDepartmentId;
	public long departmentMasterId;
	public boolean status;
	public long dateOfChange;
	public long employeeId;

}