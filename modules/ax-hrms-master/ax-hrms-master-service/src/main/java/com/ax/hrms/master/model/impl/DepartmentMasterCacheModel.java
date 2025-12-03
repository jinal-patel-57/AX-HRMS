/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.master.model.impl;

import com.ax.hrms.master.model.DepartmentMaster;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing DepartmentMaster in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class DepartmentMasterCacheModel
	implements CacheModel<DepartmentMaster>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof DepartmentMasterCacheModel)) {
			return false;
		}

		DepartmentMasterCacheModel departmentMasterCacheModel =
			(DepartmentMasterCacheModel)object;

		if (departmentMasterId ==
				departmentMasterCacheModel.departmentMasterId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, departmentMasterId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{departmentMasterId=");
		sb.append(departmentMasterId);
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
		sb.append(", departmentName=");
		sb.append(departmentName);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public DepartmentMaster toEntityModel() {
		DepartmentMasterImpl departmentMasterImpl = new DepartmentMasterImpl();

		departmentMasterImpl.setDepartmentMasterId(departmentMasterId);
		departmentMasterImpl.setCompanyId(companyId);
		departmentMasterImpl.setCreatedBy(createdBy);
		departmentMasterImpl.setModifiedBy(modifiedBy);
		departmentMasterImpl.setGroupId(groupId);

		if (createDate == Long.MIN_VALUE) {
			departmentMasterImpl.setCreateDate(null);
		}
		else {
			departmentMasterImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			departmentMasterImpl.setModifiedDate(null);
		}
		else {
			departmentMasterImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (departmentName == null) {
			departmentMasterImpl.setDepartmentName("");
		}
		else {
			departmentMasterImpl.setDepartmentName(departmentName);
		}

		departmentMasterImpl.resetOriginalValues();

		return departmentMasterImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		departmentMasterId = objectInput.readLong();

		companyId = objectInput.readLong();

		createdBy = objectInput.readLong();

		modifiedBy = objectInput.readLong();

		groupId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		departmentName = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(departmentMasterId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(createdBy);

		objectOutput.writeLong(modifiedBy);

		objectOutput.writeLong(groupId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (departmentName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(departmentName);
		}
	}

	public long departmentMasterId;
	public long companyId;
	public long createdBy;
	public long modifiedBy;
	public long groupId;
	public long createDate;
	public long modifiedDate;
	public String departmentName;

}