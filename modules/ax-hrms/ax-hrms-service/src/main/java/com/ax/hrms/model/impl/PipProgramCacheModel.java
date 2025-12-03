/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.model.impl;

import com.ax.hrms.model.PipProgram;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing PipProgram in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class PipProgramCacheModel
	implements CacheModel<PipProgram>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof PipProgramCacheModel)) {
			return false;
		}

		PipProgramCacheModel pipProgramCacheModel =
			(PipProgramCacheModel)object;

		if (pipProgramId == pipProgramCacheModel.pipProgramId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, pipProgramId);
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
		sb.append(", pipProgramId=");
		sb.append(pipProgramId);
		sb.append(", employeeId=");
		sb.append(employeeId);
		sb.append(", startDate=");
		sb.append(startDate);
		sb.append(", endDate=");
		sb.append(endDate);
		sb.append(", numberOfMonths=");
		sb.append(numberOfMonths);
		sb.append(", improvementAreas=");
		sb.append(improvementAreas);
		sb.append(", meetingDate=");
		sb.append(meetingDate);
		sb.append(", status=");
		sb.append(status);
		sb.append(", isExtended=");
		sb.append(isExtended);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public PipProgram toEntityModel() {
		PipProgramImpl pipProgramImpl = new PipProgramImpl();

		if (uuid == null) {
			pipProgramImpl.setUuid("");
		}
		else {
			pipProgramImpl.setUuid(uuid);
		}

		pipProgramImpl.setCompanyId(companyId);
		pipProgramImpl.setCreatedBy(createdBy);
		pipProgramImpl.setModifiedBy(modifiedBy);
		pipProgramImpl.setGroupId(groupId);

		if (createDate == Long.MIN_VALUE) {
			pipProgramImpl.setCreateDate(null);
		}
		else {
			pipProgramImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			pipProgramImpl.setModifiedDate(null);
		}
		else {
			pipProgramImpl.setModifiedDate(new Date(modifiedDate));
		}

		pipProgramImpl.setPipProgramId(pipProgramId);
		pipProgramImpl.setEmployeeId(employeeId);

		if (startDate == Long.MIN_VALUE) {
			pipProgramImpl.setStartDate(null);
		}
		else {
			pipProgramImpl.setStartDate(new Date(startDate));
		}

		if (endDate == Long.MIN_VALUE) {
			pipProgramImpl.setEndDate(null);
		}
		else {
			pipProgramImpl.setEndDate(new Date(endDate));
		}

		pipProgramImpl.setNumberOfMonths(numberOfMonths);

		if (improvementAreas == null) {
			pipProgramImpl.setImprovementAreas("");
		}
		else {
			pipProgramImpl.setImprovementAreas(improvementAreas);
		}

		if (meetingDate == Long.MIN_VALUE) {
			pipProgramImpl.setMeetingDate(null);
		}
		else {
			pipProgramImpl.setMeetingDate(new Date(meetingDate));
		}

		if (status == null) {
			pipProgramImpl.setStatus("");
		}
		else {
			pipProgramImpl.setStatus(status);
		}

		pipProgramImpl.setIsExtended(isExtended);

		pipProgramImpl.resetOriginalValues();

		return pipProgramImpl;
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

		pipProgramId = objectInput.readLong();

		employeeId = objectInput.readLong();
		startDate = objectInput.readLong();
		endDate = objectInput.readLong();

		numberOfMonths = objectInput.readInt();
		improvementAreas = objectInput.readUTF();
		meetingDate = objectInput.readLong();
		status = objectInput.readUTF();

		isExtended = objectInput.readBoolean();
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

		objectOutput.writeLong(pipProgramId);

		objectOutput.writeLong(employeeId);
		objectOutput.writeLong(startDate);
		objectOutput.writeLong(endDate);

		objectOutput.writeInt(numberOfMonths);

		if (improvementAreas == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(improvementAreas);
		}

		objectOutput.writeLong(meetingDate);

		if (status == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(status);
		}

		objectOutput.writeBoolean(isExtended);
	}

	public String uuid;
	public long companyId;
	public long createdBy;
	public long modifiedBy;
	public long groupId;
	public long createDate;
	public long modifiedDate;
	public long pipProgramId;
	public long employeeId;
	public long startDate;
	public long endDate;
	public int numberOfMonths;
	public String improvementAreas;
	public long meetingDate;
	public String status;
	public boolean isExtended;

}