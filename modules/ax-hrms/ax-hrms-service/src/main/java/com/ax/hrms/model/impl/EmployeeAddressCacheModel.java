/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.model.impl;

import com.ax.hrms.model.EmployeeAddress;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing EmployeeAddress in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class EmployeeAddressCacheModel
	implements CacheModel<EmployeeAddress>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof EmployeeAddressCacheModel)) {
			return false;
		}

		EmployeeAddressCacheModel employeeAddressCacheModel =
			(EmployeeAddressCacheModel)object;

		if (employeeAddressId == employeeAddressCacheModel.employeeAddressId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, employeeAddressId);
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
		sb.append(", employeeAddressId=");
		sb.append(employeeAddressId);
		sb.append(", presentAddress=");
		sb.append(presentAddress);
		sb.append(", permanentAddress=");
		sb.append(permanentAddress);
		sb.append(", presentPermanentSame=");
		sb.append(presentPermanentSame);
		sb.append(", status=");
		sb.append(status);
		sb.append(", employeeId=");
		sb.append(employeeId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public EmployeeAddress toEntityModel() {
		EmployeeAddressImpl employeeAddressImpl = new EmployeeAddressImpl();

		if (uuid == null) {
			employeeAddressImpl.setUuid("");
		}
		else {
			employeeAddressImpl.setUuid(uuid);
		}

		employeeAddressImpl.setCompanyId(companyId);
		employeeAddressImpl.setCreatedBy(createdBy);
		employeeAddressImpl.setModifiedBy(modifiedBy);
		employeeAddressImpl.setGroupId(groupId);

		if (createDate == Long.MIN_VALUE) {
			employeeAddressImpl.setCreateDate(null);
		}
		else {
			employeeAddressImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			employeeAddressImpl.setModifiedDate(null);
		}
		else {
			employeeAddressImpl.setModifiedDate(new Date(modifiedDate));
		}

		employeeAddressImpl.setEmployeeAddressId(employeeAddressId);
		employeeAddressImpl.setPresentAddress(presentAddress);
		employeeAddressImpl.setPermanentAddress(permanentAddress);
		employeeAddressImpl.setPresentPermanentSame(presentPermanentSame);
		employeeAddressImpl.setStatus(status);
		employeeAddressImpl.setEmployeeId(employeeId);

		employeeAddressImpl.resetOriginalValues();

		return employeeAddressImpl;
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

		employeeAddressId = objectInput.readLong();

		presentAddress = objectInput.readLong();

		permanentAddress = objectInput.readLong();

		presentPermanentSame = objectInput.readBoolean();

		status = objectInput.readBoolean();

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

		objectOutput.writeLong(employeeAddressId);

		objectOutput.writeLong(presentAddress);

		objectOutput.writeLong(permanentAddress);

		objectOutput.writeBoolean(presentPermanentSame);

		objectOutput.writeBoolean(status);

		objectOutput.writeLong(employeeId);
	}

	public String uuid;
	public long companyId;
	public long createdBy;
	public long modifiedBy;
	public long groupId;
	public long createDate;
	public long modifiedDate;
	public long employeeAddressId;
	public long presentAddress;
	public long permanentAddress;
	public boolean presentPermanentSame;
	public boolean status;
	public long employeeId;

}