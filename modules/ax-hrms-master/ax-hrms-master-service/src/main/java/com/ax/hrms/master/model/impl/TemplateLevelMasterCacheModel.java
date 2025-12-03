/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.master.model.impl;

import com.ax.hrms.master.model.TemplateLevelMaster;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing TemplateLevelMaster in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class TemplateLevelMasterCacheModel
	implements CacheModel<TemplateLevelMaster>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof TemplateLevelMasterCacheModel)) {
			return false;
		}

		TemplateLevelMasterCacheModel templateLevelMasterCacheModel =
			(TemplateLevelMasterCacheModel)object;

		if (templateLevelMasterId ==
				templateLevelMasterCacheModel.templateLevelMasterId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, templateLevelMasterId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{templateLevelMasterId=");
		sb.append(templateLevelMasterId);
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
	public TemplateLevelMaster toEntityModel() {
		TemplateLevelMasterImpl templateLevelMasterImpl =
			new TemplateLevelMasterImpl();

		templateLevelMasterImpl.setTemplateLevelMasterId(templateLevelMasterId);
		templateLevelMasterImpl.setCompanyId(companyId);
		templateLevelMasterImpl.setCreatedBy(createdBy);
		templateLevelMasterImpl.setModifiedBy(modifiedBy);
		templateLevelMasterImpl.setGroupId(groupId);

		if (createDate == Long.MIN_VALUE) {
			templateLevelMasterImpl.setCreateDate(null);
		}
		else {
			templateLevelMasterImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			templateLevelMasterImpl.setModifiedDate(null);
		}
		else {
			templateLevelMasterImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (levelName == null) {
			templateLevelMasterImpl.setLevelName("");
		}
		else {
			templateLevelMasterImpl.setLevelName(levelName);
		}

		templateLevelMasterImpl.resetOriginalValues();

		return templateLevelMasterImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		templateLevelMasterId = objectInput.readLong();

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
		objectOutput.writeLong(templateLevelMasterId);

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

	public long templateLevelMasterId;
	public long companyId;
	public long createdBy;
	public long modifiedBy;
	public long groupId;
	public long createDate;
	public long modifiedDate;
	public String levelName;

}