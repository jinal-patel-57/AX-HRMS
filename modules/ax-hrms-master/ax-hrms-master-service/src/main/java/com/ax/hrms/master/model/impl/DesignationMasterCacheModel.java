/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.master.model.impl;

import com.ax.hrms.master.model.DesignationMaster;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing DesignationMaster in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class DesignationMasterCacheModel
	implements CacheModel<DesignationMaster>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof DesignationMasterCacheModel)) {
			return false;
		}

		DesignationMasterCacheModel designationMasterCacheModel =
			(DesignationMasterCacheModel)object;

		if (designationMasterId ==
				designationMasterCacheModel.designationMasterId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, designationMasterId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{designationMasterId=");
		sb.append(designationMasterId);
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
		sb.append(", designationName=");
		sb.append(designationName);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public DesignationMaster toEntityModel() {
		DesignationMasterImpl designationMasterImpl =
			new DesignationMasterImpl();

		designationMasterImpl.setDesignationMasterId(designationMasterId);
		designationMasterImpl.setCompanyId(companyId);
		designationMasterImpl.setCreatedBy(createdBy);
		designationMasterImpl.setModifiedBy(modifiedBy);
		designationMasterImpl.setGroupId(groupId);

		if (createDate == Long.MIN_VALUE) {
			designationMasterImpl.setCreateDate(null);
		}
		else {
			designationMasterImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			designationMasterImpl.setModifiedDate(null);
		}
		else {
			designationMasterImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (designationName == null) {
			designationMasterImpl.setDesignationName("");
		}
		else {
			designationMasterImpl.setDesignationName(designationName);
		}

		designationMasterImpl.resetOriginalValues();

		return designationMasterImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		designationMasterId = objectInput.readLong();

		companyId = objectInput.readLong();

		createdBy = objectInput.readLong();

		modifiedBy = objectInput.readLong();

		groupId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		designationName = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(designationMasterId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(createdBy);

		objectOutput.writeLong(modifiedBy);

		objectOutput.writeLong(groupId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (designationName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(designationName);
		}
	}

	public long designationMasterId;
	public long companyId;
	public long createdBy;
	public long modifiedBy;
	public long groupId;
	public long createDate;
	public long modifiedDate;
	public String designationName;

}