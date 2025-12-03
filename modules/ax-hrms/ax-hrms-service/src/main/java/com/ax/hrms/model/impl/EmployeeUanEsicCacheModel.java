/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.model.impl;

import com.ax.hrms.model.EmployeeUanEsic;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing EmployeeUanEsic in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class EmployeeUanEsicCacheModel
	implements CacheModel<EmployeeUanEsic>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof EmployeeUanEsicCacheModel)) {
			return false;
		}

		EmployeeUanEsicCacheModel employeeUanEsicCacheModel =
			(EmployeeUanEsicCacheModel)object;

		if (uanEsicId == employeeUanEsicCacheModel.uanEsicId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, uanEsicId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

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
		sb.append(", uanEsicId=");
		sb.append(uanEsicId);
		sb.append(", uan=");
		sb.append(uan);
		sb.append(", esicNo=");
		sb.append(esicNo);
		sb.append(", status=");
		sb.append(status);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public EmployeeUanEsic toEntityModel() {
		EmployeeUanEsicImpl employeeUanEsicImpl = new EmployeeUanEsicImpl();

		if (uuid == null) {
			employeeUanEsicImpl.setUuid("");
		}
		else {
			employeeUanEsicImpl.setUuid(uuid);
		}

		employeeUanEsicImpl.setCompanyId(companyId);
		employeeUanEsicImpl.setCreatedBy(createdBy);
		employeeUanEsicImpl.setModifiedBy(modifiedBy);
		employeeUanEsicImpl.setGroupId(groupId);

		if (createDate == Long.MIN_VALUE) {
			employeeUanEsicImpl.setCreateDate(null);
		}
		else {
			employeeUanEsicImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			employeeUanEsicImpl.setModifiedDate(null);
		}
		else {
			employeeUanEsicImpl.setModifiedDate(new Date(modifiedDate));
		}

		employeeUanEsicImpl.setUanEsicId(uanEsicId);

		if (uan == null) {
			employeeUanEsicImpl.setUan("");
		}
		else {
			employeeUanEsicImpl.setUan(uan);
		}

		if (esicNo == null) {
			employeeUanEsicImpl.setEsicNo("");
		}
		else {
			employeeUanEsicImpl.setEsicNo(esicNo);
		}

		employeeUanEsicImpl.setStatus(status);

		employeeUanEsicImpl.resetOriginalValues();

		return employeeUanEsicImpl;
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

		uanEsicId = objectInput.readLong();
		uan = objectInput.readUTF();
		esicNo = objectInput.readUTF();

		status = objectInput.readBoolean();
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

		objectOutput.writeLong(uanEsicId);

		if (uan == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uan);
		}

		if (esicNo == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(esicNo);
		}

		objectOutput.writeBoolean(status);
	}

	public String uuid;
	public long companyId;
	public long createdBy;
	public long modifiedBy;
	public long groupId;
	public long createDate;
	public long modifiedDate;
	public long uanEsicId;
	public String uan;
	public String esicNo;
	public boolean status;

}