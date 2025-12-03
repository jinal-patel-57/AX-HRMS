/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.model.impl;

import com.ax.hrms.model.AppraisalMeeting;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing AppraisalMeeting in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class AppraisalMeetingCacheModel
	implements CacheModel<AppraisalMeeting>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof AppraisalMeetingCacheModel)) {
			return false;
		}

		AppraisalMeetingCacheModel appraisalMeetingCacheModel =
			(AppraisalMeetingCacheModel)object;

		if (appraisalMeetingId ==
				appraisalMeetingCacheModel.appraisalMeetingId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, appraisalMeetingId);
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
		sb.append(", appraisalMeetingId=");
		sb.append(appraisalMeetingId);
		sb.append(", appraisalProcessId=");
		sb.append(appraisalProcessId);
		sb.append(", meetingDate=");
		sb.append(meetingDate);
		sb.append(", meetingTime=");
		sb.append(meetingTime);
		sb.append(", status=");
		sb.append(status);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public AppraisalMeeting toEntityModel() {
		AppraisalMeetingImpl appraisalMeetingImpl = new AppraisalMeetingImpl();

		if (uuid == null) {
			appraisalMeetingImpl.setUuid("");
		}
		else {
			appraisalMeetingImpl.setUuid(uuid);
		}

		appraisalMeetingImpl.setCompanyId(companyId);
		appraisalMeetingImpl.setCreatedBy(createdBy);
		appraisalMeetingImpl.setModifiedBy(modifiedBy);
		appraisalMeetingImpl.setGroupId(groupId);

		if (createDate == Long.MIN_VALUE) {
			appraisalMeetingImpl.setCreateDate(null);
		}
		else {
			appraisalMeetingImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			appraisalMeetingImpl.setModifiedDate(null);
		}
		else {
			appraisalMeetingImpl.setModifiedDate(new Date(modifiedDate));
		}

		appraisalMeetingImpl.setAppraisalMeetingId(appraisalMeetingId);
		appraisalMeetingImpl.setAppraisalProcessId(appraisalProcessId);

		if (meetingDate == Long.MIN_VALUE) {
			appraisalMeetingImpl.setMeetingDate(null);
		}
		else {
			appraisalMeetingImpl.setMeetingDate(new Date(meetingDate));
		}

		if (meetingTime == Long.MIN_VALUE) {
			appraisalMeetingImpl.setMeetingTime(null);
		}
		else {
			appraisalMeetingImpl.setMeetingTime(new Date(meetingTime));
		}

		appraisalMeetingImpl.setStatus(status);

		appraisalMeetingImpl.resetOriginalValues();

		return appraisalMeetingImpl;
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

		appraisalMeetingId = objectInput.readLong();

		appraisalProcessId = objectInput.readLong();
		meetingDate = objectInput.readLong();
		meetingTime = objectInput.readLong();

		status = objectInput.readBoolean();
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

		objectOutput.writeLong(appraisalMeetingId);

		objectOutput.writeLong(appraisalProcessId);
		objectOutput.writeLong(meetingDate);
		objectOutput.writeLong(meetingTime);

		objectOutput.writeBoolean(status);
	}

	public String uuid;
	public long companyId;
	public long createdBy;
	public long modifiedBy;
	public long groupId;
	public long createDate;
	public long modifiedDate;
	public long appraisalMeetingId;
	public long appraisalProcessId;
	public long meetingDate;
	public long meetingTime;
	public boolean status;

}