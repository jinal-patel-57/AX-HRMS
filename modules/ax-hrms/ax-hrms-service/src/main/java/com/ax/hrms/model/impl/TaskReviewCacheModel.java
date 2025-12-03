/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.model.impl;

import com.ax.hrms.model.TaskReview;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing TaskReview in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class TaskReviewCacheModel
	implements CacheModel<TaskReview>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof TaskReviewCacheModel)) {
			return false;
		}

		TaskReviewCacheModel taskReviewCacheModel =
			(TaskReviewCacheModel)object;

		if (taskReviewId == taskReviewCacheModel.taskReviewId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, taskReviewId);
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
		sb.append(", taskReviewId=");
		sb.append(taskReviewId);
		sb.append(", taskId=");
		sb.append(taskId);
		sb.append(", reviewerId=");
		sb.append(reviewerId);
		sb.append(", review=");
		sb.append(review);
		sb.append(", dateOfReview=");
		sb.append(dateOfReview);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public TaskReview toEntityModel() {
		TaskReviewImpl taskReviewImpl = new TaskReviewImpl();

		if (uuid == null) {
			taskReviewImpl.setUuid("");
		}
		else {
			taskReviewImpl.setUuid(uuid);
		}

		taskReviewImpl.setCompanyId(companyId);
		taskReviewImpl.setCreatedBy(createdBy);
		taskReviewImpl.setModifiedBy(modifiedBy);
		taskReviewImpl.setGroupId(groupId);

		if (createDate == Long.MIN_VALUE) {
			taskReviewImpl.setCreateDate(null);
		}
		else {
			taskReviewImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			taskReviewImpl.setModifiedDate(null);
		}
		else {
			taskReviewImpl.setModifiedDate(new Date(modifiedDate));
		}

		taskReviewImpl.setTaskReviewId(taskReviewId);
		taskReviewImpl.setTaskId(taskId);
		taskReviewImpl.setReviewerId(reviewerId);

		if (review == null) {
			taskReviewImpl.setReview("");
		}
		else {
			taskReviewImpl.setReview(review);
		}

		if (dateOfReview == Long.MIN_VALUE) {
			taskReviewImpl.setDateOfReview(null);
		}
		else {
			taskReviewImpl.setDateOfReview(new Date(dateOfReview));
		}

		taskReviewImpl.resetOriginalValues();

		return taskReviewImpl;
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

		taskReviewId = objectInput.readLong();

		taskId = objectInput.readLong();

		reviewerId = objectInput.readLong();
		review = objectInput.readUTF();
		dateOfReview = objectInput.readLong();
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

		objectOutput.writeLong(taskReviewId);

		objectOutput.writeLong(taskId);

		objectOutput.writeLong(reviewerId);

		if (review == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(review);
		}

		objectOutput.writeLong(dateOfReview);
	}

	public String uuid;
	public long companyId;
	public long createdBy;
	public long modifiedBy;
	public long groupId;
	public long createDate;
	public long modifiedDate;
	public long taskReviewId;
	public long taskId;
	public long reviewerId;
	public String review;
	public long dateOfReview;

}