/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.model.impl;

import com.ax.hrms.model.Attachment;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Attachment in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class AttachmentCacheModel
	implements CacheModel<Attachment>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof AttachmentCacheModel)) {
			return false;
		}

		AttachmentCacheModel attachmentCacheModel =
			(AttachmentCacheModel)object;

		if (attachmentId == attachmentCacheModel.attachmentId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, attachmentId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

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
		sb.append(", attachmentId=");
		sb.append(attachmentId);
		sb.append(", timeTrackerId=");
		sb.append(timeTrackerId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Attachment toEntityModel() {
		AttachmentImpl attachmentImpl = new AttachmentImpl();

		if (uuid == null) {
			attachmentImpl.setUuid("");
		}
		else {
			attachmentImpl.setUuid(uuid);
		}

		attachmentImpl.setCompanyId(companyId);
		attachmentImpl.setCreatedBy(createdBy);
		attachmentImpl.setModifiedBy(modifiedBy);
		attachmentImpl.setGroupId(groupId);

		if (createDate == Long.MIN_VALUE) {
			attachmentImpl.setCreateDate(null);
		}
		else {
			attachmentImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			attachmentImpl.setModifiedDate(null);
		}
		else {
			attachmentImpl.setModifiedDate(new Date(modifiedDate));
		}

		attachmentImpl.setAttachmentId(attachmentId);
		attachmentImpl.setTimeTrackerId(timeTrackerId);

		attachmentImpl.resetOriginalValues();

		return attachmentImpl;
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

		attachmentId = objectInput.readLong();

		timeTrackerId = objectInput.readLong();
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

		objectOutput.writeLong(attachmentId);

		objectOutput.writeLong(timeTrackerId);
	}

	public String uuid;
	public long companyId;
	public long createdBy;
	public long modifiedBy;
	public long groupId;
	public long createDate;
	public long modifiedDate;
	public long attachmentId;
	public long timeTrackerId;

}