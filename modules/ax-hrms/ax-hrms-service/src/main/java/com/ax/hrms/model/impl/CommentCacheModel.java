/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.model.impl;

import com.ax.hrms.model.Comment;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Comment in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class CommentCacheModel implements CacheModel<Comment>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof CommentCacheModel)) {
			return false;
		}

		CommentCacheModel commentCacheModel = (CommentCacheModel)object;

		if (commentId == commentCacheModel.commentId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, commentId);
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
		sb.append(", commentId=");
		sb.append(commentId);
		sb.append(", type=");
		sb.append(type);
		sb.append(", action=");
		sb.append(action);
		sb.append(", comment=");
		sb.append(comment);
		sb.append(", status=");
		sb.append(status);
		sb.append(", requestId=");
		sb.append(requestId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Comment toEntityModel() {
		CommentImpl commentImpl = new CommentImpl();

		if (uuid == null) {
			commentImpl.setUuid("");
		}
		else {
			commentImpl.setUuid(uuid);
		}

		commentImpl.setCompanyId(companyId);
		commentImpl.setCreatedBy(createdBy);
		commentImpl.setModifiedBy(modifiedBy);
		commentImpl.setGroupId(groupId);

		if (createDate == Long.MIN_VALUE) {
			commentImpl.setCreateDate(null);
		}
		else {
			commentImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			commentImpl.setModifiedDate(null);
		}
		else {
			commentImpl.setModifiedDate(new Date(modifiedDate));
		}

		commentImpl.setCommentId(commentId);
		commentImpl.setType(type);

		if (action == null) {
			commentImpl.setAction("");
		}
		else {
			commentImpl.setAction(action);
		}

		if (comment == null) {
			commentImpl.setComment("");
		}
		else {
			commentImpl.setComment(comment);
		}

		commentImpl.setStatus(status);
		commentImpl.setRequestId(requestId);

		commentImpl.resetOriginalValues();

		return commentImpl;
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

		commentId = objectInput.readLong();

		type = objectInput.readLong();
		action = objectInput.readUTF();
		comment = objectInput.readUTF();

		status = objectInput.readBoolean();

		requestId = objectInput.readLong();
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

		objectOutput.writeLong(commentId);

		objectOutput.writeLong(type);

		if (action == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(action);
		}

		if (comment == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(comment);
		}

		objectOutput.writeBoolean(status);

		objectOutput.writeLong(requestId);
	}

	public String uuid;
	public long companyId;
	public long createdBy;
	public long modifiedBy;
	public long groupId;
	public long createDate;
	public long modifiedDate;
	public long commentId;
	public long type;
	public String action;
	public String comment;
	public boolean status;
	public long requestId;

}