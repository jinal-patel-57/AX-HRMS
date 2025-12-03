/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.model.impl;

import com.ax.hrms.model.AppraisalMeetingInvitees;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing AppraisalMeetingInvitees in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class AppraisalMeetingInviteesCacheModel
	implements CacheModel<AppraisalMeetingInvitees>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof AppraisalMeetingInviteesCacheModel)) {
			return false;
		}

		AppraisalMeetingInviteesCacheModel appraisalMeetingInviteesCacheModel =
			(AppraisalMeetingInviteesCacheModel)object;

		if (appraisalMeetingInviteeId ==
				appraisalMeetingInviteesCacheModel.appraisalMeetingInviteeId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, appraisalMeetingInviteeId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

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
		sb.append(", appraisalMeetingInviteeId=");
		sb.append(appraisalMeetingInviteeId);
		sb.append(", employeeId=");
		sb.append(employeeId);
		sb.append(", appraisalMeetingId=");
		sb.append(appraisalMeetingId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public AppraisalMeetingInvitees toEntityModel() {
		AppraisalMeetingInviteesImpl appraisalMeetingInviteesImpl =
			new AppraisalMeetingInviteesImpl();

		if (uuid == null) {
			appraisalMeetingInviteesImpl.setUuid("");
		}
		else {
			appraisalMeetingInviteesImpl.setUuid(uuid);
		}

		appraisalMeetingInviteesImpl.setCompanyId(companyId);
		appraisalMeetingInviteesImpl.setCreatedBy(createdBy);
		appraisalMeetingInviteesImpl.setModifiedBy(modifiedBy);
		appraisalMeetingInviteesImpl.setGroupId(groupId);

		if (createDate == Long.MIN_VALUE) {
			appraisalMeetingInviteesImpl.setCreateDate(null);
		}
		else {
			appraisalMeetingInviteesImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			appraisalMeetingInviteesImpl.setModifiedDate(null);
		}
		else {
			appraisalMeetingInviteesImpl.setModifiedDate(
				new Date(modifiedDate));
		}

		appraisalMeetingInviteesImpl.setAppraisalMeetingInviteeId(
			appraisalMeetingInviteeId);
		appraisalMeetingInviteesImpl.setEmployeeId(employeeId);
		appraisalMeetingInviteesImpl.setAppraisalMeetingId(appraisalMeetingId);

		appraisalMeetingInviteesImpl.resetOriginalValues();

		return appraisalMeetingInviteesImpl;
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

		appraisalMeetingInviteeId = objectInput.readLong();

		employeeId = objectInput.readLong();

		appraisalMeetingId = objectInput.readLong();
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

		objectOutput.writeLong(appraisalMeetingInviteeId);

		objectOutput.writeLong(employeeId);

		objectOutput.writeLong(appraisalMeetingId);
	}

	public String uuid;
	public long companyId;
	public long createdBy;
	public long modifiedBy;
	public long groupId;
	public long createDate;
	public long modifiedDate;
	public long appraisalMeetingInviteeId;
	public long employeeId;
	public long appraisalMeetingId;

}