/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.model.impl;

import com.ax.hrms.model.EmployeeDocument;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing EmployeeDocument in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class EmployeeDocumentCacheModel
	implements CacheModel<EmployeeDocument>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof EmployeeDocumentCacheModel)) {
			return false;
		}

		EmployeeDocumentCacheModel employeeDocumentCacheModel =
			(EmployeeDocumentCacheModel)object;

		if (documentId == employeeDocumentCacheModel.documentId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, documentId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(29);

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
		sb.append(", documentId=");
		sb.append(documentId);
		sb.append(", documentTypeId=");
		sb.append(documentTypeId);
		sb.append(", documentNumber=");
		sb.append(documentNumber);
		sb.append(", documentName=");
		sb.append(documentName);
		sb.append(", documentMediaId=");
		sb.append(documentMediaId);
		sb.append(", documentStatus=");
		sb.append(documentStatus);
		sb.append(", employeeId=");
		sb.append(employeeId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public EmployeeDocument toEntityModel() {
		EmployeeDocumentImpl employeeDocumentImpl = new EmployeeDocumentImpl();

		if (uuid == null) {
			employeeDocumentImpl.setUuid("");
		}
		else {
			employeeDocumentImpl.setUuid(uuid);
		}

		employeeDocumentImpl.setCompanyId(companyId);
		employeeDocumentImpl.setCreatedBy(createdBy);
		employeeDocumentImpl.setModifiedBy(modifiedBy);
		employeeDocumentImpl.setGroupId(groupId);

		if (createDate == Long.MIN_VALUE) {
			employeeDocumentImpl.setCreateDate(null);
		}
		else {
			employeeDocumentImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			employeeDocumentImpl.setModifiedDate(null);
		}
		else {
			employeeDocumentImpl.setModifiedDate(new Date(modifiedDate));
		}

		employeeDocumentImpl.setDocumentId(documentId);
		employeeDocumentImpl.setDocumentTypeId(documentTypeId);

		if (documentNumber == null) {
			employeeDocumentImpl.setDocumentNumber("");
		}
		else {
			employeeDocumentImpl.setDocumentNumber(documentNumber);
		}

		if (documentName == null) {
			employeeDocumentImpl.setDocumentName("");
		}
		else {
			employeeDocumentImpl.setDocumentName(documentName);
		}

		employeeDocumentImpl.setDocumentMediaId(documentMediaId);
		employeeDocumentImpl.setDocumentStatus(documentStatus);
		employeeDocumentImpl.setEmployeeId(employeeId);

		employeeDocumentImpl.resetOriginalValues();

		return employeeDocumentImpl;
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

		documentId = objectInput.readLong();

		documentTypeId = objectInput.readLong();
		documentNumber = objectInput.readUTF();
		documentName = objectInput.readUTF();

		documentMediaId = objectInput.readLong();

		documentStatus = objectInput.readBoolean();

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

		objectOutput.writeLong(documentId);

		objectOutput.writeLong(documentTypeId);

		if (documentNumber == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(documentNumber);
		}

		if (documentName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(documentName);
		}

		objectOutput.writeLong(documentMediaId);

		objectOutput.writeBoolean(documentStatus);

		objectOutput.writeLong(employeeId);
	}

	public String uuid;
	public long companyId;
	public long createdBy;
	public long modifiedBy;
	public long groupId;
	public long createDate;
	public long modifiedDate;
	public long documentId;
	public long documentTypeId;
	public String documentNumber;
	public String documentName;
	public long documentMediaId;
	public boolean documentStatus;
	public long employeeId;

}