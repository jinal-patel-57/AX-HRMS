/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.model.impl;

import com.ax.hrms.model.LeaveDayType;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing LeaveDayType in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class LeaveDayTypeCacheModel
	implements CacheModel<LeaveDayType>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof LeaveDayTypeCacheModel)) {
			return false;
		}

		LeaveDayTypeCacheModel leaveDayTypeCacheModel =
			(LeaveDayTypeCacheModel)object;

		if (leaveDayTypeId == leaveDayTypeCacheModel.leaveDayTypeId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, leaveDayTypeId);
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
		sb.append(", leaveDayTypeId=");
		sb.append(leaveDayTypeId);
		sb.append(", leaveRequestId=");
		sb.append(leaveRequestId);
		sb.append(", leaveDate=");
		sb.append(leaveDate);
		sb.append(", isHalfDay=");
		sb.append(isHalfDay);
		sb.append(", isFirstHalf=");
		sb.append(isFirstHalf);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public LeaveDayType toEntityModel() {
		LeaveDayTypeImpl leaveDayTypeImpl = new LeaveDayTypeImpl();

		if (uuid == null) {
			leaveDayTypeImpl.setUuid("");
		}
		else {
			leaveDayTypeImpl.setUuid(uuid);
		}

		leaveDayTypeImpl.setCompanyId(companyId);
		leaveDayTypeImpl.setCreatedBy(createdBy);
		leaveDayTypeImpl.setModifiedBy(modifiedBy);
		leaveDayTypeImpl.setGroupId(groupId);

		if (createDate == Long.MIN_VALUE) {
			leaveDayTypeImpl.setCreateDate(null);
		}
		else {
			leaveDayTypeImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			leaveDayTypeImpl.setModifiedDate(null);
		}
		else {
			leaveDayTypeImpl.setModifiedDate(new Date(modifiedDate));
		}

		leaveDayTypeImpl.setLeaveDayTypeId(leaveDayTypeId);
		leaveDayTypeImpl.setLeaveRequestId(leaveRequestId);

		if (leaveDate == Long.MIN_VALUE) {
			leaveDayTypeImpl.setLeaveDate(null);
		}
		else {
			leaveDayTypeImpl.setLeaveDate(new Date(leaveDate));
		}

		leaveDayTypeImpl.setIsHalfDay(isHalfDay);
		leaveDayTypeImpl.setIsFirstHalf(isFirstHalf);

		leaveDayTypeImpl.resetOriginalValues();

		return leaveDayTypeImpl;
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

		leaveDayTypeId = objectInput.readLong();

		leaveRequestId = objectInput.readLong();
		leaveDate = objectInput.readLong();

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

		objectOutput.writeLong(leaveDayTypeId);

		objectOutput.writeLong(leaveRequestId);
		objectOutput.writeLong(leaveDate);

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
	public long leaveDayTypeId;
	public long leaveRequestId;
	public long leaveDate;
	public boolean isHalfDay;
	public boolean isFirstHalf;

}