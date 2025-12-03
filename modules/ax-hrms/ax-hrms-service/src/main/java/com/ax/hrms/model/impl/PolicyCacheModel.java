/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.model.impl;

import com.ax.hrms.model.Policy;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Policy in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class PolicyCacheModel implements CacheModel<Policy>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof PolicyCacheModel)) {
			return false;
		}

		PolicyCacheModel policyCacheModel = (PolicyCacheModel)object;

		if (policyId == policyCacheModel.policyId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, policyId);
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
		sb.append(", policyId=");
		sb.append(policyId);
		sb.append(", policyName=");
		sb.append(policyName);
		sb.append(", policyDescription=");
		sb.append(policyDescription);
		sb.append(", year=");
		sb.append(year);
		sb.append(", status=");
		sb.append(status);
		sb.append(", policyTypeId=");
		sb.append(policyTypeId);
		sb.append(", policyDocumentId=");
		sb.append(policyDocumentId);
		sb.append(", applicableDate=");
		sb.append(applicableDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Policy toEntityModel() {
		PolicyImpl policyImpl = new PolicyImpl();

		if (uuid == null) {
			policyImpl.setUuid("");
		}
		else {
			policyImpl.setUuid(uuid);
		}

		policyImpl.setCompanyId(companyId);
		policyImpl.setCreatedBy(createdBy);
		policyImpl.setModifiedBy(modifiedBy);
		policyImpl.setGroupId(groupId);

		if (createDate == Long.MIN_VALUE) {
			policyImpl.setCreateDate(null);
		}
		else {
			policyImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			policyImpl.setModifiedDate(null);
		}
		else {
			policyImpl.setModifiedDate(new Date(modifiedDate));
		}

		policyImpl.setPolicyId(policyId);

		if (policyName == null) {
			policyImpl.setPolicyName("");
		}
		else {
			policyImpl.setPolicyName(policyName);
		}

		if (policyDescription == null) {
			policyImpl.setPolicyDescription("");
		}
		else {
			policyImpl.setPolicyDescription(policyDescription);
		}

		policyImpl.setYear(year);
		policyImpl.setStatus(status);
		policyImpl.setPolicyTypeId(policyTypeId);
		policyImpl.setPolicyDocumentId(policyDocumentId);

		if (applicableDate == Long.MIN_VALUE) {
			policyImpl.setApplicableDate(null);
		}
		else {
			policyImpl.setApplicableDate(new Date(applicableDate));
		}

		policyImpl.resetOriginalValues();

		return policyImpl;
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

		policyId = objectInput.readLong();
		policyName = objectInput.readUTF();
		policyDescription = objectInput.readUTF();

		year = objectInput.readInt();

		status = objectInput.readBoolean();

		policyTypeId = objectInput.readLong();

		policyDocumentId = objectInput.readLong();
		applicableDate = objectInput.readLong();
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

		objectOutput.writeLong(policyId);

		if (policyName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(policyName);
		}

		if (policyDescription == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(policyDescription);
		}

		objectOutput.writeInt(year);

		objectOutput.writeBoolean(status);

		objectOutput.writeLong(policyTypeId);

		objectOutput.writeLong(policyDocumentId);
		objectOutput.writeLong(applicableDate);
	}

	public String uuid;
	public long companyId;
	public long createdBy;
	public long modifiedBy;
	public long groupId;
	public long createDate;
	public long modifiedDate;
	public long policyId;
	public String policyName;
	public String policyDescription;
	public int year;
	public boolean status;
	public long policyTypeId;
	public long policyDocumentId;
	public long applicableDate;

}