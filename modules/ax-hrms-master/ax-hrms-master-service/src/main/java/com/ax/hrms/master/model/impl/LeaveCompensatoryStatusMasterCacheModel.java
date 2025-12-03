/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.master.model.impl;

import com.ax.hrms.master.model.LeaveCompensatoryStatusMaster;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing LeaveCompensatoryStatusMaster in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class LeaveCompensatoryStatusMasterCacheModel
	implements CacheModel<LeaveCompensatoryStatusMaster>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof LeaveCompensatoryStatusMasterCacheModel)) {
			return false;
		}

		LeaveCompensatoryStatusMasterCacheModel
			leaveCompensatoryStatusMasterCacheModel =
				(LeaveCompensatoryStatusMasterCacheModel)object;

		if (leaveCompensatoryStatusMasterId ==
				leaveCompensatoryStatusMasterCacheModel.
					leaveCompensatoryStatusMasterId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, leaveCompensatoryStatusMasterId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{leaveCompensatoryStatusMasterId=");
		sb.append(leaveCompensatoryStatusMasterId);
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
		sb.append(", leaveCompensatoryStatus=");
		sb.append(leaveCompensatoryStatus);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public LeaveCompensatoryStatusMaster toEntityModel() {
		LeaveCompensatoryStatusMasterImpl leaveCompensatoryStatusMasterImpl =
			new LeaveCompensatoryStatusMasterImpl();

		leaveCompensatoryStatusMasterImpl.setLeaveCompensatoryStatusMasterId(
			leaveCompensatoryStatusMasterId);
		leaveCompensatoryStatusMasterImpl.setCompanyId(companyId);
		leaveCompensatoryStatusMasterImpl.setCreatedBy(createdBy);
		leaveCompensatoryStatusMasterImpl.setModifiedBy(modifiedBy);
		leaveCompensatoryStatusMasterImpl.setGroupId(groupId);

		if (createDate == Long.MIN_VALUE) {
			leaveCompensatoryStatusMasterImpl.setCreateDate(null);
		}
		else {
			leaveCompensatoryStatusMasterImpl.setCreateDate(
				new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			leaveCompensatoryStatusMasterImpl.setModifiedDate(null);
		}
		else {
			leaveCompensatoryStatusMasterImpl.setModifiedDate(
				new Date(modifiedDate));
		}

		if (leaveCompensatoryStatus == null) {
			leaveCompensatoryStatusMasterImpl.setLeaveCompensatoryStatus("");
		}
		else {
			leaveCompensatoryStatusMasterImpl.setLeaveCompensatoryStatus(
				leaveCompensatoryStatus);
		}

		leaveCompensatoryStatusMasterImpl.resetOriginalValues();

		return leaveCompensatoryStatusMasterImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		leaveCompensatoryStatusMasterId = objectInput.readLong();

		companyId = objectInput.readLong();

		createdBy = objectInput.readLong();

		modifiedBy = objectInput.readLong();

		groupId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		leaveCompensatoryStatus = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(leaveCompensatoryStatusMasterId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(createdBy);

		objectOutput.writeLong(modifiedBy);

		objectOutput.writeLong(groupId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (leaveCompensatoryStatus == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(leaveCompensatoryStatus);
		}
	}

	public long leaveCompensatoryStatusMasterId;
	public long companyId;
	public long createdBy;
	public long modifiedBy;
	public long groupId;
	public long createDate;
	public long modifiedDate;
	public String leaveCompensatoryStatus;

}