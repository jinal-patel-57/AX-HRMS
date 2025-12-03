/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.master.model.impl;

import com.ax.hrms.master.model.PriorityMaster;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing PriorityMaster in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class PriorityMasterCacheModel
	implements CacheModel<PriorityMaster>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof PriorityMasterCacheModel)) {
			return false;
		}

		PriorityMasterCacheModel priorityMasterCacheModel =
			(PriorityMasterCacheModel)object;

		if (priorityMasterId == priorityMasterCacheModel.priorityMasterId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, priorityMasterId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{priorityMasterId=");
		sb.append(priorityMasterId);
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
		sb.append(", priorityName=");
		sb.append(priorityName);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public PriorityMaster toEntityModel() {
		PriorityMasterImpl priorityMasterImpl = new PriorityMasterImpl();

		priorityMasterImpl.setPriorityMasterId(priorityMasterId);
		priorityMasterImpl.setCompanyId(companyId);
		priorityMasterImpl.setCreatedBy(createdBy);
		priorityMasterImpl.setModifiedBy(modifiedBy);
		priorityMasterImpl.setGroupId(groupId);

		if (createDate == Long.MIN_VALUE) {
			priorityMasterImpl.setCreateDate(null);
		}
		else {
			priorityMasterImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			priorityMasterImpl.setModifiedDate(null);
		}
		else {
			priorityMasterImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (priorityName == null) {
			priorityMasterImpl.setPriorityName("");
		}
		else {
			priorityMasterImpl.setPriorityName(priorityName);
		}

		priorityMasterImpl.resetOriginalValues();

		return priorityMasterImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		priorityMasterId = objectInput.readLong();

		companyId = objectInput.readLong();

		createdBy = objectInput.readLong();

		modifiedBy = objectInput.readLong();

		groupId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		priorityName = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(priorityMasterId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(createdBy);

		objectOutput.writeLong(modifiedBy);

		objectOutput.writeLong(groupId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (priorityName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(priorityName);
		}
	}

	public long priorityMasterId;
	public long companyId;
	public long createdBy;
	public long modifiedBy;
	public long groupId;
	public long createDate;
	public long modifiedDate;
	public String priorityName;

}