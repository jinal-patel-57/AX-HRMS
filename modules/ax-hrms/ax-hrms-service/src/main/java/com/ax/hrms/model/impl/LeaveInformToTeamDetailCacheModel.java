/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.model.impl;

import com.ax.hrms.model.LeaveInformToTeamDetail;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing LeaveInformToTeamDetail in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class LeaveInformToTeamDetailCacheModel
	implements CacheModel<LeaveInformToTeamDetail>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof LeaveInformToTeamDetailCacheModel)) {
			return false;
		}

		LeaveInformToTeamDetailCacheModel leaveInformToTeamDetailCacheModel =
			(LeaveInformToTeamDetailCacheModel)object;

		if (leaveInformId == leaveInformToTeamDetailCacheModel.leaveInformId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, leaveInformId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

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
		sb.append(", leaveInformId=");
		sb.append(leaveInformId);
		sb.append(", leaveRequestId=");
		sb.append(leaveRequestId);
		sb.append(", employeeId=");
		sb.append(employeeId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public LeaveInformToTeamDetail toEntityModel() {
		LeaveInformToTeamDetailImpl leaveInformToTeamDetailImpl =
			new LeaveInformToTeamDetailImpl();

		if (uuid == null) {
			leaveInformToTeamDetailImpl.setUuid("");
		}
		else {
			leaveInformToTeamDetailImpl.setUuid(uuid);
		}

		leaveInformToTeamDetailImpl.setCompanyId(companyId);
		leaveInformToTeamDetailImpl.setCreatedBy(createdBy);
		leaveInformToTeamDetailImpl.setModifiedBy(modifiedBy);
		leaveInformToTeamDetailImpl.setGroupId(groupId);

		if (createDate == Long.MIN_VALUE) {
			leaveInformToTeamDetailImpl.setCreateDate(null);
		}
		else {
			leaveInformToTeamDetailImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			leaveInformToTeamDetailImpl.setModifiedDate(null);
		}
		else {
			leaveInformToTeamDetailImpl.setModifiedDate(new Date(modifiedDate));
		}

		leaveInformToTeamDetailImpl.setLeaveInformId(leaveInformId);
		leaveInformToTeamDetailImpl.setLeaveRequestId(leaveRequestId);
		leaveInformToTeamDetailImpl.setEmployeeId(employeeId);

		leaveInformToTeamDetailImpl.resetOriginalValues();

		return leaveInformToTeamDetailImpl;
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

		leaveInformId = objectInput.readLong();

		leaveRequestId = objectInput.readLong();

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

		objectOutput.writeLong(leaveInformId);

		objectOutput.writeLong(leaveRequestId);

		objectOutput.writeLong(employeeId);
	}

	public String uuid;
	public long companyId;
	public long createdBy;
	public long modifiedBy;
	public long groupId;
	public long createDate;
	public long modifiedDate;
	public long leaveInformId;
	public long leaveRequestId;
	public long employeeId;

}