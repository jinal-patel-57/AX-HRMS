/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.model.impl;

import com.ax.hrms.model.EmployeeProbationDetails;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing EmployeeProbationDetails in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class EmployeeProbationDetailsCacheModel
	implements CacheModel<EmployeeProbationDetails>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof EmployeeProbationDetailsCacheModel)) {
			return false;
		}

		EmployeeProbationDetailsCacheModel employeeProbationDetailsCacheModel =
			(EmployeeProbationDetailsCacheModel)object;

		if (probationDetailId ==
				employeeProbationDetailsCacheModel.probationDetailId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, probationDetailId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(27);

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
		sb.append(", probationDetailId=");
		sb.append(probationDetailId);
		sb.append(", probationPeriod=");
		sb.append(probationPeriod);
		sb.append(", probationEndDate=");
		sb.append(probationEndDate);
		sb.append(", probationStatusId=");
		sb.append(probationStatusId);
		sb.append(", isExtended=");
		sb.append(isExtended);
		sb.append(", employeeId=");
		sb.append(employeeId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public EmployeeProbationDetails toEntityModel() {
		EmployeeProbationDetailsImpl employeeProbationDetailsImpl =
			new EmployeeProbationDetailsImpl();

		if (uuid == null) {
			employeeProbationDetailsImpl.setUuid("");
		}
		else {
			employeeProbationDetailsImpl.setUuid(uuid);
		}

		employeeProbationDetailsImpl.setCompanyId(companyId);
		employeeProbationDetailsImpl.setCreatedBy(createdBy);
		employeeProbationDetailsImpl.setModifiedBy(modifiedBy);
		employeeProbationDetailsImpl.setGroupId(groupId);

		if (createDate == Long.MIN_VALUE) {
			employeeProbationDetailsImpl.setCreateDate(null);
		}
		else {
			employeeProbationDetailsImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			employeeProbationDetailsImpl.setModifiedDate(null);
		}
		else {
			employeeProbationDetailsImpl.setModifiedDate(
				new Date(modifiedDate));
		}

		employeeProbationDetailsImpl.setProbationDetailId(probationDetailId);
		employeeProbationDetailsImpl.setProbationPeriod(probationPeriod);

		if (probationEndDate == Long.MIN_VALUE) {
			employeeProbationDetailsImpl.setProbationEndDate(null);
		}
		else {
			employeeProbationDetailsImpl.setProbationEndDate(
				new Date(probationEndDate));
		}

		employeeProbationDetailsImpl.setProbationStatusId(probationStatusId);
		employeeProbationDetailsImpl.setIsExtended(isExtended);
		employeeProbationDetailsImpl.setEmployeeId(employeeId);

		employeeProbationDetailsImpl.resetOriginalValues();

		return employeeProbationDetailsImpl;
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

		probationDetailId = objectInput.readLong();

		probationPeriod = objectInput.readInt();
		probationEndDate = objectInput.readLong();

		probationStatusId = objectInput.readLong();

		isExtended = objectInput.readBoolean();

		employeeId = objectInput.readLong();
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

		objectOutput.writeLong(probationDetailId);

		objectOutput.writeInt(probationPeriod);
		objectOutput.writeLong(probationEndDate);

		objectOutput.writeLong(probationStatusId);

		objectOutput.writeBoolean(isExtended);

		objectOutput.writeLong(employeeId);
	}

	public String uuid;
	public long companyId;
	public long createdBy;
	public long modifiedBy;
	public long groupId;
	public long createDate;
	public long modifiedDate;
	public long probationDetailId;
	public int probationPeriod;
	public long probationEndDate;
	public long probationStatusId;
	public boolean isExtended;
	public long employeeId;

}