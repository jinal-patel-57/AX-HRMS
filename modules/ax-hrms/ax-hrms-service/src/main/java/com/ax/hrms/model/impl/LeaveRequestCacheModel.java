/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.model.impl;

import com.ax.hrms.model.LeaveRequest;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing LeaveRequest in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class LeaveRequestCacheModel
	implements CacheModel<LeaveRequest>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof LeaveRequestCacheModel)) {
			return false;
		}

		LeaveRequestCacheModel leaveRequestCacheModel =
			(LeaveRequestCacheModel)object;

		if (leaveRequestId == leaveRequestCacheModel.leaveRequestId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, leaveRequestId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(35);

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
		sb.append(", leaveRequestId=");
		sb.append(leaveRequestId);
		sb.append(", employeeId=");
		sb.append(employeeId);
		sb.append(", leaveTypeMasterId=");
		sb.append(leaveTypeMasterId);
		sb.append(", startDateTime=");
		sb.append(startDateTime);
		sb.append(", endDateTime=");
		sb.append(endDateTime);
		sb.append(", reason=");
		sb.append(reason);
		sb.append(", leaveCompensatoryStatusMasterId=");
		sb.append(leaveCompensatoryStatusMasterId);
		sb.append(", hrApprovalId=");
		sb.append(hrApprovalId);
		sb.append(", managerApprovalId=");
		sb.append(managerApprovalId);
		sb.append(", dateOfRequest=");
		sb.append(dateOfRequest);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public LeaveRequest toEntityModel() {
		LeaveRequestImpl leaveRequestImpl = new LeaveRequestImpl();

		if (uuid == null) {
			leaveRequestImpl.setUuid("");
		}
		else {
			leaveRequestImpl.setUuid(uuid);
		}

		leaveRequestImpl.setCompanyId(companyId);
		leaveRequestImpl.setCreatedBy(createdBy);
		leaveRequestImpl.setModifiedBy(modifiedBy);
		leaveRequestImpl.setGroupId(groupId);

		if (createDate == Long.MIN_VALUE) {
			leaveRequestImpl.setCreateDate(null);
		}
		else {
			leaveRequestImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			leaveRequestImpl.setModifiedDate(null);
		}
		else {
			leaveRequestImpl.setModifiedDate(new Date(modifiedDate));
		}

		leaveRequestImpl.setLeaveRequestId(leaveRequestId);
		leaveRequestImpl.setEmployeeId(employeeId);
		leaveRequestImpl.setLeaveTypeMasterId(leaveTypeMasterId);

		if (startDateTime == Long.MIN_VALUE) {
			leaveRequestImpl.setStartDateTime(null);
		}
		else {
			leaveRequestImpl.setStartDateTime(new Date(startDateTime));
		}

		if (endDateTime == Long.MIN_VALUE) {
			leaveRequestImpl.setEndDateTime(null);
		}
		else {
			leaveRequestImpl.setEndDateTime(new Date(endDateTime));
		}

		if (reason == null) {
			leaveRequestImpl.setReason("");
		}
		else {
			leaveRequestImpl.setReason(reason);
		}

		leaveRequestImpl.setLeaveCompensatoryStatusMasterId(
			leaveCompensatoryStatusMasterId);
		leaveRequestImpl.setHrApprovalId(hrApprovalId);
		leaveRequestImpl.setManagerApprovalId(managerApprovalId);

		if (dateOfRequest == Long.MIN_VALUE) {
			leaveRequestImpl.setDateOfRequest(null);
		}
		else {
			leaveRequestImpl.setDateOfRequest(new Date(dateOfRequest));
		}

		leaveRequestImpl.resetOriginalValues();

		return leaveRequestImpl;
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

		leaveRequestId = objectInput.readLong();

		employeeId = objectInput.readLong();

		leaveTypeMasterId = objectInput.readLong();
		startDateTime = objectInput.readLong();
		endDateTime = objectInput.readLong();
		reason = objectInput.readUTF();

		leaveCompensatoryStatusMasterId = objectInput.readLong();

		hrApprovalId = objectInput.readLong();

		managerApprovalId = objectInput.readLong();
		dateOfRequest = objectInput.readLong();
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

		objectOutput.writeLong(leaveRequestId);

		objectOutput.writeLong(employeeId);

		objectOutput.writeLong(leaveTypeMasterId);
		objectOutput.writeLong(startDateTime);
		objectOutput.writeLong(endDateTime);

		if (reason == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(reason);
		}

		objectOutput.writeLong(leaveCompensatoryStatusMasterId);

		objectOutput.writeLong(hrApprovalId);

		objectOutput.writeLong(managerApprovalId);
		objectOutput.writeLong(dateOfRequest);
	}

	public String uuid;
	public long companyId;
	public long createdBy;
	public long modifiedBy;
	public long groupId;
	public long createDate;
	public long modifiedDate;
	public long leaveRequestId;
	public long employeeId;
	public long leaveTypeMasterId;
	public long startDateTime;
	public long endDateTime;
	public String reason;
	public long leaveCompensatoryStatusMasterId;
	public long hrApprovalId;
	public long managerApprovalId;
	public long dateOfRequest;

}