/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.model.impl;

import com.ax.hrms.model.Task;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Task in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class TaskCacheModel implements CacheModel<Task>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof TaskCacheModel)) {
			return false;
		}

		TaskCacheModel taskCacheModel = (TaskCacheModel)object;

		if (taskId == taskCacheModel.taskId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, taskId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(47);

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
		sb.append(", taskId=");
		sb.append(taskId);
		sb.append(", taskName=");
		sb.append(taskName);
		sb.append(", description=");
		sb.append(description);
		sb.append(", projectId=");
		sb.append(projectId);
		sb.append(", mainTaskId=");
		sb.append(mainTaskId);
		sb.append(", assignedTo=");
		sb.append(assignedTo);
		sb.append(", projectTaskStatusMasterId=");
		sb.append(projectTaskStatusMasterId);
		sb.append(", priorityMasterId=");
		sb.append(priorityMasterId);
		sb.append(", estimatedHours=");
		sb.append(estimatedHours);
		sb.append(", managerId=");
		sb.append(managerId);
		sb.append(", assignDate=");
		sb.append(assignDate);
		sb.append(", startDate=");
		sb.append(startDate);
		sb.append(", dueDate=");
		sb.append(dueDate);
		sb.append(", completeDate=");
		sb.append(completeDate);
		sb.append(", isBillble=");
		sb.append(isBillble);
		sb.append(", isSubTask=");
		sb.append(isSubTask);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Task toEntityModel() {
		TaskImpl taskImpl = new TaskImpl();

		if (uuid == null) {
			taskImpl.setUuid("");
		}
		else {
			taskImpl.setUuid(uuid);
		}

		taskImpl.setCompanyId(companyId);
		taskImpl.setCreatedBy(createdBy);
		taskImpl.setModifiedBy(modifiedBy);
		taskImpl.setGroupId(groupId);

		if (createDate == Long.MIN_VALUE) {
			taskImpl.setCreateDate(null);
		}
		else {
			taskImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			taskImpl.setModifiedDate(null);
		}
		else {
			taskImpl.setModifiedDate(new Date(modifiedDate));
		}

		taskImpl.setTaskId(taskId);

		if (taskName == null) {
			taskImpl.setTaskName("");
		}
		else {
			taskImpl.setTaskName(taskName);
		}

		if (description == null) {
			taskImpl.setDescription("");
		}
		else {
			taskImpl.setDescription(description);
		}

		taskImpl.setProjectId(projectId);
		taskImpl.setMainTaskId(mainTaskId);
		taskImpl.setAssignedTo(assignedTo);
		taskImpl.setProjectTaskStatusMasterId(projectTaskStatusMasterId);
		taskImpl.setPriorityMasterId(priorityMasterId);
		taskImpl.setEstimatedHours(estimatedHours);
		taskImpl.setManagerId(managerId);

		if (assignDate == Long.MIN_VALUE) {
			taskImpl.setAssignDate(null);
		}
		else {
			taskImpl.setAssignDate(new Date(assignDate));
		}

		if (startDate == Long.MIN_VALUE) {
			taskImpl.setStartDate(null);
		}
		else {
			taskImpl.setStartDate(new Date(startDate));
		}

		if (dueDate == Long.MIN_VALUE) {
			taskImpl.setDueDate(null);
		}
		else {
			taskImpl.setDueDate(new Date(dueDate));
		}

		if (completeDate == Long.MIN_VALUE) {
			taskImpl.setCompleteDate(null);
		}
		else {
			taskImpl.setCompleteDate(new Date(completeDate));
		}

		taskImpl.setIsBillble(isBillble);
		taskImpl.setIsSubTask(isSubTask);

		taskImpl.resetOriginalValues();

		return taskImpl;
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

		taskId = objectInput.readLong();
		taskName = objectInput.readUTF();
		description = objectInput.readUTF();

		projectId = objectInput.readLong();

		mainTaskId = objectInput.readLong();

		assignedTo = objectInput.readLong();

		projectTaskStatusMasterId = objectInput.readLong();

		priorityMasterId = objectInput.readLong();

		estimatedHours = objectInput.readInt();

		managerId = objectInput.readLong();
		assignDate = objectInput.readLong();
		startDate = objectInput.readLong();
		dueDate = objectInput.readLong();
		completeDate = objectInput.readLong();

		isBillble = objectInput.readBoolean();

		isSubTask = objectInput.readBoolean();
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

		objectOutput.writeLong(taskId);

		if (taskName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(taskName);
		}

		if (description == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(description);
		}

		objectOutput.writeLong(projectId);

		objectOutput.writeLong(mainTaskId);

		objectOutput.writeLong(assignedTo);

		objectOutput.writeLong(projectTaskStatusMasterId);

		objectOutput.writeLong(priorityMasterId);

		objectOutput.writeInt(estimatedHours);

		objectOutput.writeLong(managerId);
		objectOutput.writeLong(assignDate);
		objectOutput.writeLong(startDate);
		objectOutput.writeLong(dueDate);
		objectOutput.writeLong(completeDate);

		objectOutput.writeBoolean(isBillble);

		objectOutput.writeBoolean(isSubTask);
	}

	public String uuid;
	public long companyId;
	public long createdBy;
	public long modifiedBy;
	public long groupId;
	public long createDate;
	public long modifiedDate;
	public long taskId;
	public String taskName;
	public String description;
	public long projectId;
	public long mainTaskId;
	public long assignedTo;
	public long projectTaskStatusMasterId;
	public long priorityMasterId;
	public int estimatedHours;
	public long managerId;
	public long assignDate;
	public long startDate;
	public long dueDate;
	public long completeDate;
	public boolean isBillble;
	public boolean isSubTask;

}