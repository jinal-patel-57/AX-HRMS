/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.model.impl;

import com.ax.hrms.model.Project;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Project in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ProjectCacheModel implements CacheModel<Project>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof ProjectCacheModel)) {
			return false;
		}

		ProjectCacheModel projectCacheModel = (ProjectCacheModel)object;

		if (projectId == projectCacheModel.projectId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, projectId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

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
		sb.append(", projectId=");
		sb.append(projectId);
		sb.append(", projectName=");
		sb.append(projectName);
		sb.append(", description=");
		sb.append(description);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Project toEntityModel() {
		ProjectImpl projectImpl = new ProjectImpl();

		if (uuid == null) {
			projectImpl.setUuid("");
		}
		else {
			projectImpl.setUuid(uuid);
		}

		projectImpl.setCompanyId(companyId);
		projectImpl.setCreatedBy(createdBy);
		projectImpl.setModifiedBy(modifiedBy);
		projectImpl.setGroupId(groupId);

		if (createDate == Long.MIN_VALUE) {
			projectImpl.setCreateDate(null);
		}
		else {
			projectImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			projectImpl.setModifiedDate(null);
		}
		else {
			projectImpl.setModifiedDate(new Date(modifiedDate));
		}

		projectImpl.setProjectId(projectId);

		if (projectName == null) {
			projectImpl.setProjectName("");
		}
		else {
			projectImpl.setProjectName(projectName);
		}

		if (description == null) {
			projectImpl.setDescription("");
		}
		else {
			projectImpl.setDescription(description);
		}

		projectImpl.resetOriginalValues();

		return projectImpl;
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

		projectId = objectInput.readLong();
		projectName = objectInput.readUTF();
		description = objectInput.readUTF();
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

		objectOutput.writeLong(projectId);

		if (projectName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(projectName);
		}

		if (description == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(description);
		}
	}

	public String uuid;
	public long companyId;
	public long createdBy;
	public long modifiedBy;
	public long groupId;
	public long createDate;
	public long modifiedDate;
	public long projectId;
	public String projectName;
	public String description;

}