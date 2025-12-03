/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.model.impl;

import com.ax.hrms.model.LeaveBalanceHistory;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing LeaveBalanceHistory in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class LeaveBalanceHistoryCacheModel
	implements CacheModel<LeaveBalanceHistory>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof LeaveBalanceHistoryCacheModel)) {
			return false;
		}

		LeaveBalanceHistoryCacheModel leaveBalanceHistoryCacheModel =
			(LeaveBalanceHistoryCacheModel)object;

		if (leaveBalanceHistoryId ==
				leaveBalanceHistoryCacheModel.leaveBalanceHistoryId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, leaveBalanceHistoryId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(29);

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
		sb.append(", leaveBalanceHistoryId=");
		sb.append(leaveBalanceHistoryId);
		sb.append(", leaveBalanceId=");
		sb.append(leaveBalanceId);
		sb.append(", employeeId=");
		sb.append(employeeId);
		sb.append(", leaveTypeMasterId=");
		sb.append(leaveTypeMasterId);
		sb.append(", year=");
		sb.append(year);
		sb.append(", noOfUsedLeaves=");
		sb.append(noOfUsedLeaves);
		sb.append(", noOfRemainingLeaves=");
		sb.append(noOfRemainingLeaves);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public LeaveBalanceHistory toEntityModel() {
		LeaveBalanceHistoryImpl leaveBalanceHistoryImpl =
			new LeaveBalanceHistoryImpl();

		if (uuid == null) {
			leaveBalanceHistoryImpl.setUuid("");
		}
		else {
			leaveBalanceHistoryImpl.setUuid(uuid);
		}

		leaveBalanceHistoryImpl.setCompanyId(companyId);
		leaveBalanceHistoryImpl.setCreatedBy(createdBy);
		leaveBalanceHistoryImpl.setModifiedBy(modifiedBy);
		leaveBalanceHistoryImpl.setGroupId(groupId);

		if (createDate == Long.MIN_VALUE) {
			leaveBalanceHistoryImpl.setCreateDate(null);
		}
		else {
			leaveBalanceHistoryImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			leaveBalanceHistoryImpl.setModifiedDate(null);
		}
		else {
			leaveBalanceHistoryImpl.setModifiedDate(new Date(modifiedDate));
		}

		leaveBalanceHistoryImpl.setLeaveBalanceHistoryId(leaveBalanceHistoryId);
		leaveBalanceHistoryImpl.setLeaveBalanceId(leaveBalanceId);
		leaveBalanceHistoryImpl.setEmployeeId(employeeId);
		leaveBalanceHistoryImpl.setLeaveTypeMasterId(leaveTypeMasterId);
		leaveBalanceHistoryImpl.setYear(year);
		leaveBalanceHistoryImpl.setNoOfUsedLeaves(noOfUsedLeaves);
		leaveBalanceHistoryImpl.setNoOfRemainingLeaves(noOfRemainingLeaves);

		leaveBalanceHistoryImpl.resetOriginalValues();

		return leaveBalanceHistoryImpl;
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

		leaveBalanceHistoryId = objectInput.readLong();

		leaveBalanceId = objectInput.readLong();

		employeeId = objectInput.readLong();

		leaveTypeMasterId = objectInput.readLong();

		year = objectInput.readInt();

		noOfUsedLeaves = objectInput.readDouble();

		noOfRemainingLeaves = objectInput.readDouble();
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

		objectOutput.writeLong(leaveBalanceHistoryId);

		objectOutput.writeLong(leaveBalanceId);

		objectOutput.writeLong(employeeId);

		objectOutput.writeLong(leaveTypeMasterId);

		objectOutput.writeInt(year);

		objectOutput.writeDouble(noOfUsedLeaves);

		objectOutput.writeDouble(noOfRemainingLeaves);
	}

	public String uuid;
	public long companyId;
	public long createdBy;
	public long modifiedBy;
	public long groupId;
	public long createDate;
	public long modifiedDate;
	public long leaveBalanceHistoryId;
	public long leaveBalanceId;
	public long employeeId;
	public long leaveTypeMasterId;
	public int year;
	public double noOfUsedLeaves;
	public double noOfRemainingLeaves;

}