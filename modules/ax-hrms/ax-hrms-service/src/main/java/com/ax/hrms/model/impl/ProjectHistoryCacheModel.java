/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.model.impl;

import com.ax.hrms.model.ProjectHistory;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ProjectHistory in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ProjectHistoryCacheModel
	implements CacheModel<ProjectHistory>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof ProjectHistoryCacheModel)) {
			return false;
		}

		ProjectHistoryCacheModel projectHistoryCacheModel =
			(ProjectHistoryCacheModel)object;

		if (projectHistoryId == projectHistoryCacheModel.projectHistoryId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, projectHistoryId);
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
		sb.append(", projectHistoryId=");
		sb.append(projectHistoryId);
		sb.append(", projectId=");
		sb.append(projectId);
		sb.append(", projectTaskStatusMasterId=");
		sb.append(projectTaskStatusMasterId);
		sb.append(", managerId=");
		sb.append(managerId);
		sb.append(", startDate=");
		sb.append(startDate);
		sb.append(", isBillble=");
		sb.append(isBillble);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ProjectHistory toEntityModel() {
		ProjectHistoryImpl projectHistoryImpl = new ProjectHistoryImpl();

		if (uuid == null) {
			projectHistoryImpl.setUuid("");
		}
		else {
			projectHistoryImpl.setUuid(uuid);
		}

		projectHistoryImpl.setCompanyId(companyId);
		projectHistoryImpl.setCreatedBy(createdBy);
		projectHistoryImpl.setModifiedBy(modifiedBy);
		projectHistoryImpl.setGroupId(groupId);

		if (createDate == Long.MIN_VALUE) {
			projectHistoryImpl.setCreateDate(null);
		}
		else {
			projectHistoryImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			projectHistoryImpl.setModifiedDate(null);
		}
		else {
			projectHistoryImpl.setModifiedDate(new Date(modifiedDate));
		}

		projectHistoryImpl.setProjectHistoryId(projectHistoryId);
		projectHistoryImpl.setProjectId(projectId);
		projectHistoryImpl.setProjectTaskStatusMasterId(
			projectTaskStatusMasterId);
		projectHistoryImpl.setManagerId(managerId);

		if (startDate == Long.MIN_VALUE) {
			projectHistoryImpl.setStartDate(null);
		}
		else {
			projectHistoryImpl.setStartDate(new Date(startDate));
		}

		projectHistoryImpl.setIsBillble(isBillble);

		projectHistoryImpl.resetOriginalValues();

		return projectHistoryImpl;
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

		projectHistoryId = objectInput.readLong();

		projectId = objectInput.readLong();

		projectTaskStatusMasterId = objectInput.readLong();

		managerId = objectInput.readLong();
		startDate = objectInput.readLong();

		isBillble = objectInput.readBoolean();
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

		objectOutput.writeLong(projectHistoryId);

		objectOutput.writeLong(projectId);

		objectOutput.writeLong(projectTaskStatusMasterId);

		objectOutput.writeLong(managerId);
		objectOutput.writeLong(startDate);

		objectOutput.writeBoolean(isBillble);
	}

	public String uuid;
	public long companyId;
	public long createdBy;
	public long modifiedBy;
	public long groupId;
	public long createDate;
	public long modifiedDate;
	public long projectHistoryId;
	public long projectId;
	public long projectTaskStatusMasterId;
	public long managerId;
	public long startDate;
	public boolean isBillble;

}