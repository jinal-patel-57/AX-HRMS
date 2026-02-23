/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.model.impl;

import com.ax.hrms.model.WorkFromHomeDayType;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing WorkFromHomeDayType in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class WorkFromHomeDayTypeCacheModel
	implements CacheModel<WorkFromHomeDayType>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof WorkFromHomeDayTypeCacheModel)) {
			return false;
		}

		WorkFromHomeDayTypeCacheModel workFromHomeDayTypeCacheModel =
			(WorkFromHomeDayTypeCacheModel)object;

		if (workFromHomeDayTypeId ==
				workFromHomeDayTypeCacheModel.workFromHomeDayTypeId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, workFromHomeDayTypeId);
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
		sb.append(", workFromHomeDayTypeId=");
		sb.append(workFromHomeDayTypeId);
		sb.append(", workFromHomeRequestId=");
		sb.append(workFromHomeRequestId);
		sb.append(", workFromHomeDate=");
		sb.append(workFromHomeDate);
		sb.append(", isHalfDay=");
		sb.append(isHalfDay);
		sb.append(", isFirstHalf=");
		sb.append(isFirstHalf);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public WorkFromHomeDayType toEntityModel() {
		WorkFromHomeDayTypeImpl workFromHomeDayTypeImpl =
			new WorkFromHomeDayTypeImpl();

		if (uuid == null) {
			workFromHomeDayTypeImpl.setUuid("");
		}
		else {
			workFromHomeDayTypeImpl.setUuid(uuid);
		}

		workFromHomeDayTypeImpl.setCompanyId(companyId);
		workFromHomeDayTypeImpl.setCreatedBy(createdBy);
		workFromHomeDayTypeImpl.setModifiedBy(modifiedBy);
		workFromHomeDayTypeImpl.setGroupId(groupId);

		if (createDate == Long.MIN_VALUE) {
			workFromHomeDayTypeImpl.setCreateDate(null);
		}
		else {
			workFromHomeDayTypeImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			workFromHomeDayTypeImpl.setModifiedDate(null);
		}
		else {
			workFromHomeDayTypeImpl.setModifiedDate(new Date(modifiedDate));
		}

		workFromHomeDayTypeImpl.setWorkFromHomeDayTypeId(workFromHomeDayTypeId);
		workFromHomeDayTypeImpl.setWorkFromHomeRequestId(workFromHomeRequestId);

		if (workFromHomeDate == Long.MIN_VALUE) {
			workFromHomeDayTypeImpl.setWorkFromHomeDate(null);
		}
		else {
			workFromHomeDayTypeImpl.setWorkFromHomeDate(
				new Date(workFromHomeDate));
		}

		workFromHomeDayTypeImpl.setIsHalfDay(isHalfDay);
		workFromHomeDayTypeImpl.setIsFirstHalf(isFirstHalf);

		workFromHomeDayTypeImpl.resetOriginalValues();

		return workFromHomeDayTypeImpl;
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

		workFromHomeDayTypeId = objectInput.readLong();

		workFromHomeRequestId = objectInput.readLong();
		workFromHomeDate = objectInput.readLong();

		isHalfDay = objectInput.readBoolean();

		isFirstHalf = objectInput.readBoolean();
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

		objectOutput.writeLong(workFromHomeDayTypeId);

		objectOutput.writeLong(workFromHomeRequestId);
		objectOutput.writeLong(workFromHomeDate);

		objectOutput.writeBoolean(isHalfDay);

		objectOutput.writeBoolean(isFirstHalf);
	}

	public String uuid;
	public long companyId;
	public long createdBy;
	public long modifiedBy;
	public long groupId;
	public long createDate;
	public long modifiedDate;
	public long workFromHomeDayTypeId;
	public long workFromHomeRequestId;
	public long workFromHomeDate;
	public boolean isHalfDay;
	public boolean isFirstHalf;

}