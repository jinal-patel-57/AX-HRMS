/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.model.impl;

import com.ax.hrms.model.WorkFromHomeRequest;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing WorkFromHomeRequest in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class WorkFromHomeRequestCacheModel
	implements CacheModel<WorkFromHomeRequest>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof WorkFromHomeRequestCacheModel)) {
			return false;
		}

		WorkFromHomeRequestCacheModel workFromHomeRequestCacheModel =
			(WorkFromHomeRequestCacheModel)object;

		if (workFromHomeRequestId ==
				workFromHomeRequestCacheModel.workFromHomeRequestId) {

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
		sb.append(", employeeId=");
		sb.append(employeeId);
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
	public WorkFromHomeRequest toEntityModel() {
		WorkFromHomeRequestImpl workFromHomeRequestImpl =
			new WorkFromHomeRequestImpl();

		if (uuid == null) {
			workFromHomeRequestImpl.setUuid("");
		}
		else {
			workFromHomeRequestImpl.setUuid(uuid);
		}

		workFromHomeRequestImpl.setCompanyId(companyId);
		workFromHomeRequestImpl.setCreatedBy(createdBy);
		workFromHomeRequestImpl.setModifiedBy(modifiedBy);
		workFromHomeRequestImpl.setGroupId(groupId);

		if (createDate == Long.MIN_VALUE) {
			workFromHomeRequestImpl.setCreateDate(null);
		}
		else {
			workFromHomeRequestImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			workFromHomeRequestImpl.setModifiedDate(null);
		}
		else {
			workFromHomeRequestImpl.setModifiedDate(new Date(modifiedDate));
		}

		workFromHomeRequestImpl.setWorkFromHomeRequestId(workFromHomeRequestId);
		workFromHomeRequestImpl.setEmployeeId(employeeId);
		workFromHomeRequestImpl.setReviewerId(reviewerId);

		if (teamMailId == null) {
			workFromHomeRequestImpl.setTeamMailId("");
		}
		else {
			workFromHomeRequestImpl.setTeamMailId(teamMailId);
		}

		workFromHomeRequestImpl.setStatus(status);

		if (reason == null) {
			workFromHomeRequestImpl.setReason("");
		}
		else {
			workFromHomeRequestImpl.setReason(reason);
		}

		if (requestDate == Long.MIN_VALUE) {
			workFromHomeRequestImpl.setRequestDate(null);
		}
		else {
			workFromHomeRequestImpl.setRequestDate(new Date(requestDate));
		}

		if (startDate == Long.MIN_VALUE) {
			workFromHomeRequestImpl.setStartDate(null);
		}
		else {
			workFromHomeRequestImpl.setStartDate(new Date(startDate));
		}

		if (endDate == Long.MIN_VALUE) {
			workFromHomeRequestImpl.setEndDate(null);
		}
		else {
			workFromHomeRequestImpl.setEndDate(new Date(endDate));
		}

		workFromHomeRequestImpl.resetOriginalValues();

		return workFromHomeRequestImpl;
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

		employeeId = objectInput.readLong();

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

		objectOutput.writeLong(employeeId);

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
	public long employeeId;
	public long reviewerId;
	public String teamMailId;
	public long status;
	public String reason;
	public long requestDate;
	public long startDate;
	public long endDate;

}