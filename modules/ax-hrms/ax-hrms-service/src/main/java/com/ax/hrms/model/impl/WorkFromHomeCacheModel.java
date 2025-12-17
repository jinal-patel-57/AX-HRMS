/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.model.impl;

import com.ax.hrms.model.WorkFromHome;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing WorkFromHome in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class WorkFromHomeCacheModel
	implements CacheModel<WorkFromHome>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof WorkFromHomeCacheModel)) {
			return false;
		}

		WorkFromHomeCacheModel workFromHomeCacheModel =
			(WorkFromHomeCacheModel)object;

		if (workFromHomeRequestId ==
				workFromHomeCacheModel.workFromHomeRequestId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, workFromHomeRequestId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(33);

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
		sb.append(", workFromHomeRequestId=");
		sb.append(workFromHomeRequestId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", reviewerId=");
		sb.append(reviewerId);
		sb.append(", teamMailId=");
		sb.append(teamMailId);
		sb.append(", status=");
		sb.append(status);
		sb.append(", reason=");
		sb.append(reason);
		sb.append(", requestDate=");
		sb.append(requestDate);
		sb.append(", startDate=");
		sb.append(startDate);
		sb.append(", endDate=");
		sb.append(endDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public WorkFromHome toEntityModel() {
		WorkFromHomeImpl workFromHomeImpl = new WorkFromHomeImpl();

		if (uuid == null) {
			workFromHomeImpl.setUuid("");
		}
		else {
			workFromHomeImpl.setUuid(uuid);
		}

		workFromHomeImpl.setCompanyId(companyId);
		workFromHomeImpl.setCreatedBy(createdBy);
		workFromHomeImpl.setModifiedBy(modifiedBy);
		workFromHomeImpl.setGroupId(groupId);

		if (createDate == Long.MIN_VALUE) {
			workFromHomeImpl.setCreateDate(null);
		}
		else {
			workFromHomeImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			workFromHomeImpl.setModifiedDate(null);
		}
		else {
			workFromHomeImpl.setModifiedDate(new Date(modifiedDate));
		}

		workFromHomeImpl.setWorkFromHomeRequestId(workFromHomeRequestId);
		workFromHomeImpl.setUserId(userId);
		workFromHomeImpl.setReviewerId(reviewerId);

		if (teamMailId == null) {
			workFromHomeImpl.setTeamMailId("");
		}
		else {
			workFromHomeImpl.setTeamMailId(teamMailId);
		}

		workFromHomeImpl.setStatus(status);

		if (reason == null) {
			workFromHomeImpl.setReason("");
		}
		else {
			workFromHomeImpl.setReason(reason);
		}

		if (requestDate == Long.MIN_VALUE) {
			workFromHomeImpl.setRequestDate(null);
		}
		else {
			workFromHomeImpl.setRequestDate(new Date(requestDate));
		}

		if (startDate == Long.MIN_VALUE) {
			workFromHomeImpl.setStartDate(null);
		}
		else {
			workFromHomeImpl.setStartDate(new Date(startDate));
		}

		if (endDate == Long.MIN_VALUE) {
			workFromHomeImpl.setEndDate(null);
		}
		else {
			workFromHomeImpl.setEndDate(new Date(endDate));
		}

		workFromHomeImpl.resetOriginalValues();

		return workFromHomeImpl;
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

		workFromHomeRequestId = objectInput.readLong();

		userId = objectInput.readLong();

		reviewerId = objectInput.readLong();
		teamMailId = objectInput.readUTF();

		status = objectInput.readLong();
		reason = objectInput.readUTF();
		requestDate = objectInput.readLong();
		startDate = objectInput.readLong();
		endDate = objectInput.readLong();
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

		objectOutput.writeLong(workFromHomeRequestId);

		objectOutput.writeLong(userId);

		objectOutput.writeLong(reviewerId);

		if (teamMailId == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(teamMailId);
		}

		objectOutput.writeLong(status);

		if (reason == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(reason);
		}

		objectOutput.writeLong(requestDate);
		objectOutput.writeLong(startDate);
		objectOutput.writeLong(endDate);
	}

	public String uuid;
	public long companyId;
	public long createdBy;
	public long modifiedBy;
	public long groupId;
	public long createDate;
	public long modifiedDate;
	public long workFromHomeRequestId;
	public long userId;
	public long reviewerId;
	public String teamMailId;
	public long status;
	public String reason;
	public long requestDate;
	public long startDate;
	public long endDate;

}