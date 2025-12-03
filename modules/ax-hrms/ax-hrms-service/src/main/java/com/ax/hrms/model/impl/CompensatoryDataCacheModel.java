/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.model.impl;

import com.ax.hrms.model.CompensatoryData;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing CompensatoryData in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class CompensatoryDataCacheModel
	implements CacheModel<CompensatoryData>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof CompensatoryDataCacheModel)) {
			return false;
		}

		CompensatoryDataCacheModel compensatoryDataCacheModel =
			(CompensatoryDataCacheModel)object;

		if (compensatoryDataId ==
				compensatoryDataCacheModel.compensatoryDataId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, compensatoryDataId);
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
		sb.append(", compensatoryDataId=");
		sb.append(compensatoryDataId);
		sb.append(", employeeId=");
		sb.append(employeeId);
		sb.append(", dateOfCompensation=");
		sb.append(dateOfCompensation);
		sb.append(", requestedHours=");
		sb.append(requestedHours);
		sb.append(", approvedHours=");
		sb.append(approvedHours);
		sb.append(", managerId=");
		sb.append(managerId);
		sb.append(", leaveCompensatoryStatusMasterId=");
		sb.append(leaveCompensatoryStatusMasterId);
		sb.append(", description=");
		sb.append(description);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public CompensatoryData toEntityModel() {
		CompensatoryDataImpl compensatoryDataImpl = new CompensatoryDataImpl();

		if (uuid == null) {
			compensatoryDataImpl.setUuid("");
		}
		else {
			compensatoryDataImpl.setUuid(uuid);
		}

		compensatoryDataImpl.setCompanyId(companyId);
		compensatoryDataImpl.setCreatedBy(createdBy);
		compensatoryDataImpl.setModifiedBy(modifiedBy);
		compensatoryDataImpl.setGroupId(groupId);

		if (createDate == Long.MIN_VALUE) {
			compensatoryDataImpl.setCreateDate(null);
		}
		else {
			compensatoryDataImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			compensatoryDataImpl.setModifiedDate(null);
		}
		else {
			compensatoryDataImpl.setModifiedDate(new Date(modifiedDate));
		}

		compensatoryDataImpl.setCompensatoryDataId(compensatoryDataId);
		compensatoryDataImpl.setEmployeeId(employeeId);

		if (dateOfCompensation == Long.MIN_VALUE) {
			compensatoryDataImpl.setDateOfCompensation(null);
		}
		else {
			compensatoryDataImpl.setDateOfCompensation(
				new Date(dateOfCompensation));
		}

		compensatoryDataImpl.setRequestedHours(requestedHours);
		compensatoryDataImpl.setApprovedHours(approvedHours);
		compensatoryDataImpl.setManagerId(managerId);
		compensatoryDataImpl.setLeaveCompensatoryStatusMasterId(
			leaveCompensatoryStatusMasterId);

		if (description == null) {
			compensatoryDataImpl.setDescription("");
		}
		else {
			compensatoryDataImpl.setDescription(description);
		}

		compensatoryDataImpl.resetOriginalValues();

		return compensatoryDataImpl;
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

		compensatoryDataId = objectInput.readLong();

		employeeId = objectInput.readLong();
		dateOfCompensation = objectInput.readLong();

		requestedHours = objectInput.readInt();

		approvedHours = objectInput.readInt();

		managerId = objectInput.readLong();

		leaveCompensatoryStatusMasterId = objectInput.readLong();
		description = objectInput.readUTF();
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

		objectOutput.writeLong(compensatoryDataId);

		objectOutput.writeLong(employeeId);
		objectOutput.writeLong(dateOfCompensation);

		objectOutput.writeInt(requestedHours);

		objectOutput.writeInt(approvedHours);

		objectOutput.writeLong(managerId);

		objectOutput.writeLong(leaveCompensatoryStatusMasterId);

		if (description == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(description);
		}
	}

	public String uuid;
	public long companyId;
	public long createdBy;
	public long modifiedBy;
	public long groupId;
	public long createDate;
	public long modifiedDate;
	public long compensatoryDataId;
	public long employeeId;
	public long dateOfCompensation;
	public int requestedHours;
	public int approvedHours;
	public long managerId;
	public long leaveCompensatoryStatusMasterId;
	public String description;

}