/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.model.impl;

import com.ax.hrms.model.AppraisalReminder;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing AppraisalReminder in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class AppraisalReminderCacheModel
	implements CacheModel<AppraisalReminder>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof AppraisalReminderCacheModel)) {
			return false;
		}

		AppraisalReminderCacheModel appraisalReminderCacheModel =
			(AppraisalReminderCacheModel)object;

		if (appraisalRemainderId ==
				appraisalReminderCacheModel.appraisalRemainderId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, appraisalRemainderId);
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
		sb.append(", appraisalRemainderId=");
		sb.append(appraisalRemainderId);
		sb.append(", employeeId=");
		sb.append(employeeId);
		sb.append(", appraisalRemainderMonth=");
		sb.append(appraisalRemainderMonth);
		sb.append(", appraisalRemainderYear=");
		sb.append(appraisalRemainderYear);
		sb.append(", appraisalProcessId=");
		sb.append(appraisalProcessId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public AppraisalReminder toEntityModel() {
		AppraisalReminderImpl appraisalReminderImpl =
			new AppraisalReminderImpl();

		if (uuid == null) {
			appraisalReminderImpl.setUuid("");
		}
		else {
			appraisalReminderImpl.setUuid(uuid);
		}

		appraisalReminderImpl.setCompanyId(companyId);
		appraisalReminderImpl.setCreatedBy(createdBy);
		appraisalReminderImpl.setModifiedBy(modifiedBy);
		appraisalReminderImpl.setGroupId(groupId);

		if (createDate == Long.MIN_VALUE) {
			appraisalReminderImpl.setCreateDate(null);
		}
		else {
			appraisalReminderImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			appraisalReminderImpl.setModifiedDate(null);
		}
		else {
			appraisalReminderImpl.setModifiedDate(new Date(modifiedDate));
		}

		appraisalReminderImpl.setAppraisalRemainderId(appraisalRemainderId);
		appraisalReminderImpl.setEmployeeId(employeeId);

		if (appraisalRemainderMonth == null) {
			appraisalReminderImpl.setAppraisalRemainderMonth("");
		}
		else {
			appraisalReminderImpl.setAppraisalRemainderMonth(
				appraisalRemainderMonth);
		}

		if (appraisalRemainderYear == null) {
			appraisalReminderImpl.setAppraisalRemainderYear("");
		}
		else {
			appraisalReminderImpl.setAppraisalRemainderYear(
				appraisalRemainderYear);
		}

		appraisalReminderImpl.setAppraisalProcessId(appraisalProcessId);

		appraisalReminderImpl.resetOriginalValues();

		return appraisalReminderImpl;
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

		appraisalRemainderId = objectInput.readLong();

		employeeId = objectInput.readLong();
		appraisalRemainderMonth = objectInput.readUTF();
		appraisalRemainderYear = objectInput.readUTF();

		appraisalProcessId = objectInput.readLong();
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

		objectOutput.writeLong(appraisalRemainderId);

		objectOutput.writeLong(employeeId);

		if (appraisalRemainderMonth == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(appraisalRemainderMonth);
		}

		if (appraisalRemainderYear == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(appraisalRemainderYear);
		}

		objectOutput.writeLong(appraisalProcessId);
	}

	public String uuid;
	public long companyId;
	public long createdBy;
	public long modifiedBy;
	public long groupId;
	public long createDate;
	public long modifiedDate;
	public long appraisalRemainderId;
	public long employeeId;
	public String appraisalRemainderMonth;
	public String appraisalRemainderYear;
	public long appraisalProcessId;

}