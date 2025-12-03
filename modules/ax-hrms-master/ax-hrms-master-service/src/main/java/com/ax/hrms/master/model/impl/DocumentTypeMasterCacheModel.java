/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.master.model.impl;

import com.ax.hrms.master.model.DocumentTypeMaster;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing DocumentTypeMaster in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class DocumentTypeMasterCacheModel
	implements CacheModel<DocumentTypeMaster>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof DocumentTypeMasterCacheModel)) {
			return false;
		}

		DocumentTypeMasterCacheModel documentTypeMasterCacheModel =
			(DocumentTypeMasterCacheModel)object;

		if (documentTypeMasterId ==
				documentTypeMasterCacheModel.documentTypeMasterId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, documentTypeMasterId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{documentTypeMasterId=");
		sb.append(documentTypeMasterId);
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
		sb.append(", documentTypeName=");
		sb.append(documentTypeName);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public DocumentTypeMaster toEntityModel() {
		DocumentTypeMasterImpl documentTypeMasterImpl =
			new DocumentTypeMasterImpl();

		documentTypeMasterImpl.setDocumentTypeMasterId(documentTypeMasterId);
		documentTypeMasterImpl.setCompanyId(companyId);
		documentTypeMasterImpl.setCreatedBy(createdBy);
		documentTypeMasterImpl.setModifiedBy(modifiedBy);
		documentTypeMasterImpl.setGroupId(groupId);

		if (createDate == Long.MIN_VALUE) {
			documentTypeMasterImpl.setCreateDate(null);
		}
		else {
			documentTypeMasterImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			documentTypeMasterImpl.setModifiedDate(null);
		}
		else {
			documentTypeMasterImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (documentTypeName == null) {
			documentTypeMasterImpl.setDocumentTypeName("");
		}
		else {
			documentTypeMasterImpl.setDocumentTypeName(documentTypeName);
		}

		documentTypeMasterImpl.resetOriginalValues();

		return documentTypeMasterImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		documentTypeMasterId = objectInput.readLong();

		companyId = objectInput.readLong();

		createdBy = objectInput.readLong();

		modifiedBy = objectInput.readLong();

		groupId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		documentTypeName = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(documentTypeMasterId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(createdBy);

		objectOutput.writeLong(modifiedBy);

		objectOutput.writeLong(groupId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (documentTypeName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(documentTypeName);
		}
	}

	public long documentTypeMasterId;
	public long companyId;
	public long createdBy;
	public long modifiedBy;
	public long groupId;
	public long createDate;
	public long modifiedDate;
	public String documentTypeName;

}