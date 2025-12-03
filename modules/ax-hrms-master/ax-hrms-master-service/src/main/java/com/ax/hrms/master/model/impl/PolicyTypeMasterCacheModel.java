/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.master.model.impl;

import com.ax.hrms.master.model.PolicyTypeMaster;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing PolicyTypeMaster in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class PolicyTypeMasterCacheModel
	implements CacheModel<PolicyTypeMaster>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof PolicyTypeMasterCacheModel)) {
			return false;
		}

		PolicyTypeMasterCacheModel policyTypeMasterCacheModel =
			(PolicyTypeMasterCacheModel)object;

		if (policyTypeMasterID ==
				policyTypeMasterCacheModel.policyTypeMasterID) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, policyTypeMasterID);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{policyTypeMasterID=");
		sb.append(policyTypeMasterID);
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
		sb.append(", policyType=");
		sb.append(policyType);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public PolicyTypeMaster toEntityModel() {
		PolicyTypeMasterImpl policyTypeMasterImpl = new PolicyTypeMasterImpl();

		policyTypeMasterImpl.setPolicyTypeMasterID(policyTypeMasterID);
		policyTypeMasterImpl.setCompanyId(companyId);
		policyTypeMasterImpl.setCreatedBy(createdBy);
		policyTypeMasterImpl.setModifiedBy(modifiedBy);
		policyTypeMasterImpl.setGroupId(groupId);

		if (createDate == Long.MIN_VALUE) {
			policyTypeMasterImpl.setCreateDate(null);
		}
		else {
			policyTypeMasterImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			policyTypeMasterImpl.setModifiedDate(null);
		}
		else {
			policyTypeMasterImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (policyType == null) {
			policyTypeMasterImpl.setPolicyType("");
		}
		else {
			policyTypeMasterImpl.setPolicyType(policyType);
		}

		policyTypeMasterImpl.resetOriginalValues();

		return policyTypeMasterImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		policyTypeMasterID = objectInput.readLong();

		companyId = objectInput.readLong();

		createdBy = objectInput.readLong();

		modifiedBy = objectInput.readLong();

		groupId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		policyType = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(policyTypeMasterID);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(createdBy);

		objectOutput.writeLong(modifiedBy);

		objectOutput.writeLong(groupId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (policyType == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(policyType);
		}
	}

	public long policyTypeMasterID;
	public long companyId;
	public long createdBy;
	public long modifiedBy;
	public long groupId;
	public long createDate;
	public long modifiedDate;
	public String policyType;

}