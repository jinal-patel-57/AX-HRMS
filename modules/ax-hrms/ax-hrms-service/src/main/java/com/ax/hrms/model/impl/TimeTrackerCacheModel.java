/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.model.impl;

import com.ax.hrms.model.TimeTracker;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing TimeTracker in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class TimeTrackerCacheModel
	implements CacheModel<TimeTracker>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof TimeTrackerCacheModel)) {
			return false;
		}

		TimeTrackerCacheModel timeTrackerCacheModel =
			(TimeTrackerCacheModel)object;

		if (timeTrackerId == timeTrackerCacheModel.timeTrackerId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, timeTrackerId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(31);

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
		sb.append(", timeTrackerId=");
		sb.append(timeTrackerId);
		sb.append(", taskId=");
		sb.append(taskId);
		sb.append(", employeeId=");
		sb.append(employeeId);
		sb.append(", startTime=");
		sb.append(startTime);
		sb.append(", endTime=");
		sb.append(endTime);
		sb.append(", duration=");
		sb.append(duration);
		sb.append(", description=");
		sb.append(description);
		sb.append(", managerApproveStatus=");
		sb.append(managerApproveStatus);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public TimeTracker toEntityModel() {
		TimeTrackerImpl timeTrackerImpl = new TimeTrackerImpl();

		if (uuid == null) {
			timeTrackerImpl.setUuid("");
		}
		else {
			timeTrackerImpl.setUuid(uuid);
		}

		timeTrackerImpl.setCompanyId(companyId);
		timeTrackerImpl.setCreatedBy(createdBy);
		timeTrackerImpl.setModifiedBy(modifiedBy);
		timeTrackerImpl.setGroupId(groupId);

		if (createDate == Long.MIN_VALUE) {
			timeTrackerImpl.setCreateDate(null);
		}
		else {
			timeTrackerImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			timeTrackerImpl.setModifiedDate(null);
		}
		else {
			timeTrackerImpl.setModifiedDate(new Date(modifiedDate));
		}

		timeTrackerImpl.setTimeTrackerId(timeTrackerId);
		timeTrackerImpl.setTaskId(taskId);
		timeTrackerImpl.setEmployeeId(employeeId);

		if (startTime == Long.MIN_VALUE) {
			timeTrackerImpl.setStartTime(null);
		}
		else {
			timeTrackerImpl.setStartTime(new Date(startTime));
		}

		if (endTime == Long.MIN_VALUE) {
			timeTrackerImpl.setEndTime(null);
		}
		else {
			timeTrackerImpl.setEndTime(new Date(endTime));
		}

		timeTrackerImpl.setDuration(duration);

		if (description == null) {
			timeTrackerImpl.setDescription("");
		}
		else {
			timeTrackerImpl.setDescription(description);
		}

		if (managerApproveStatus == null) {
			timeTrackerImpl.setManagerApproveStatus("");
		}
		else {
			timeTrackerImpl.setManagerApproveStatus(managerApproveStatus);
		}

		timeTrackerImpl.resetOriginalValues();

		return timeTrackerImpl;
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

		timeTrackerId = objectInput.readLong();

		taskId = objectInput.readLong();

		employeeId = objectInput.readLong();
		startTime = objectInput.readLong();
		endTime = objectInput.readLong();

		duration = objectInput.readDouble();
		description = objectInput.readUTF();
		managerApproveStatus = objectInput.readUTF();
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

		objectOutput.writeLong(timeTrackerId);

		objectOutput.writeLong(taskId);

		objectOutput.writeLong(employeeId);
		objectOutput.writeLong(startTime);
		objectOutput.writeLong(endTime);

		objectOutput.writeDouble(duration);

		if (description == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(description);
		}

		if (managerApproveStatus == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(managerApproveStatus);
		}
	}

	public String uuid;
	public long companyId;
	public long createdBy;
	public long modifiedBy;
	public long groupId;
	public long createDate;
	public long modifiedDate;
	public long timeTrackerId;
	public long taskId;
	public long employeeId;
	public long startTime;
	public long endTime;
	public double duration;
	public String description;
	public String managerApproveStatus;

}