/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.master.model.impl;

import com.ax.hrms.master.model.LeaveTypeMaster;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing LeaveTypeMaster in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class LeaveTypeMasterCacheModel
	implements CacheModel<LeaveTypeMaster>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof LeaveTypeMasterCacheModel)) {
			return false;
		}

		LeaveTypeMasterCacheModel leaveTypeMasterCacheModel =
			(LeaveTypeMasterCacheModel)object;

		if (leaveTypeMasterId == leaveTypeMasterCacheModel.leaveTypeMasterId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, leaveTypeMasterId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{leaveTypeMasterId=");
		sb.append(leaveTypeMasterId);
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
		sb.append(", leaveTypeName=");
		sb.append(leaveTypeName);
		sb.append(", description=");
		sb.append(description);
		sb.append(", isActive=");
		sb.append(isActive);
		sb.append(", isAppearForAll=");
		sb.append(isAppearForAll);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public LeaveTypeMaster toEntityModel() {
		LeaveTypeMasterImpl leaveTypeMasterImpl = new LeaveTypeMasterImpl();

		leaveTypeMasterImpl.setLeaveTypeMasterId(leaveTypeMasterId);
		leaveTypeMasterImpl.setCompanyId(companyId);
		leaveTypeMasterImpl.setCreatedBy(createdBy);
		leaveTypeMasterImpl.setModifiedBy(modifiedBy);
		leaveTypeMasterImpl.setGroupId(groupId);

		if (createDate == Long.MIN_VALUE) {
			leaveTypeMasterImpl.setCreateDate(null);
		}
		else {
			leaveTypeMasterImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			leaveTypeMasterImpl.setModifiedDate(null);
		}
		else {
			leaveTypeMasterImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (leaveTypeName == null) {
			leaveTypeMasterImpl.setLeaveTypeName("");
		}
		else {
			leaveTypeMasterImpl.setLeaveTypeName(leaveTypeName);
		}

		if (description == null) {
			leaveTypeMasterImpl.setDescription("");
		}
		else {
			leaveTypeMasterImpl.setDescription(description);
		}

		leaveTypeMasterImpl.setIsActive(isActive);
		leaveTypeMasterImpl.setIsAppearForAll(isAppearForAll);

		leaveTypeMasterImpl.resetOriginalValues();

		return leaveTypeMasterImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		leaveTypeMasterId = objectInput.readLong();

		companyId = objectInput.readLong();

		createdBy = objectInput.readLong();

		modifiedBy = objectInput.readLong();

		groupId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		leaveTypeName = objectInput.readUTF();
		description = objectInput.readUTF();

		isActive = objectInput.readBoolean();

		isAppearForAll = objectInput.readBoolean();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(leaveTypeMasterId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(createdBy);

		objectOutput.writeLong(modifiedBy);

		objectOutput.writeLong(groupId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (leaveTypeName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(leaveTypeName);
		}

		if (description == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(description);
		}

		objectOutput.writeBoolean(isActive);

		objectOutput.writeBoolean(isAppearForAll);
	}

	public long leaveTypeMasterId;
	public long companyId;
	public long createdBy;
	public long modifiedBy;
	public long groupId;
	public long createDate;
	public long modifiedDate;
	public String leaveTypeName;
	public String description;
	public boolean isActive;
	public boolean isAppearForAll;

}