/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.master.model.impl;

import com.ax.hrms.master.model.EducationLevelMaster;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing EducationLevelMaster in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class EducationLevelMasterCacheModel
	implements CacheModel<EducationLevelMaster>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof EducationLevelMasterCacheModel)) {
			return false;
		}

		EducationLevelMasterCacheModel educationLevelMasterCacheModel =
			(EducationLevelMasterCacheModel)object;

		if (educationLevelMasterId ==
				educationLevelMasterCacheModel.educationLevelMasterId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, educationLevelMasterId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{educationLevelMasterId=");
		sb.append(educationLevelMasterId);
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
		sb.append(", levelName=");
		sb.append(levelName);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public EducationLevelMaster toEntityModel() {
		EducationLevelMasterImpl educationLevelMasterImpl =
			new EducationLevelMasterImpl();

		educationLevelMasterImpl.setEducationLevelMasterId(
			educationLevelMasterId);
		educationLevelMasterImpl.setCompanyId(companyId);
		educationLevelMasterImpl.setCreatedBy(createdBy);
		educationLevelMasterImpl.setModifiedBy(modifiedBy);
		educationLevelMasterImpl.setGroupId(groupId);

		if (createDate == Long.MIN_VALUE) {
			educationLevelMasterImpl.setCreateDate(null);
		}
		else {
			educationLevelMasterImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			educationLevelMasterImpl.setModifiedDate(null);
		}
		else {
			educationLevelMasterImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (levelName == null) {
			educationLevelMasterImpl.setLevelName("");
		}
		else {
			educationLevelMasterImpl.setLevelName(levelName);
		}

		educationLevelMasterImpl.resetOriginalValues();

		return educationLevelMasterImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		educationLevelMasterId = objectInput.readLong();

		companyId = objectInput.readLong();

		createdBy = objectInput.readLong();

		modifiedBy = objectInput.readLong();

		groupId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		levelName = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(educationLevelMasterId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(createdBy);

		objectOutput.writeLong(modifiedBy);

		objectOutput.writeLong(groupId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (levelName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(levelName);
		}
	}

	public long educationLevelMasterId;
	public long companyId;
	public long createdBy;
	public long modifiedBy;
	public long groupId;
	public long createDate;
	public long modifiedDate;
	public String levelName;

}