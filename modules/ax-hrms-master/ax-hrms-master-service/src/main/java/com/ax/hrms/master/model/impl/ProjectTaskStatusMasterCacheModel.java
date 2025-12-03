/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.master.model.impl;

import com.ax.hrms.master.model.ProjectTaskStatusMaster;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ProjectTaskStatusMaster in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ProjectTaskStatusMasterCacheModel
	implements CacheModel<ProjectTaskStatusMaster>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof ProjectTaskStatusMasterCacheModel)) {
			return false;
		}

		ProjectTaskStatusMasterCacheModel projectTaskStatusMasterCacheModel =
			(ProjectTaskStatusMasterCacheModel)object;

		if (projectTaskStatusMasterId ==
				projectTaskStatusMasterCacheModel.projectTaskStatusMasterId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, projectTaskStatusMasterId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{projectTaskStatusMasterId=");
		sb.append(projectTaskStatusMasterId);
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
		sb.append(", projectTaskStatusName=");
		sb.append(projectTaskStatusName);
		sb.append(", isApplicableForProject=");
		sb.append(isApplicableForProject);
		sb.append(", isApplicableForTask=");
		sb.append(isApplicableForTask);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ProjectTaskStatusMaster toEntityModel() {
		ProjectTaskStatusMasterImpl projectTaskStatusMasterImpl =
			new ProjectTaskStatusMasterImpl();

		projectTaskStatusMasterImpl.setProjectTaskStatusMasterId(
			projectTaskStatusMasterId);
		projectTaskStatusMasterImpl.setCompanyId(companyId);
		projectTaskStatusMasterImpl.setCreatedBy(createdBy);
		projectTaskStatusMasterImpl.setModifiedBy(modifiedBy);
		projectTaskStatusMasterImpl.setGroupId(groupId);

		if (createDate == Long.MIN_VALUE) {
			projectTaskStatusMasterImpl.setCreateDate(null);
		}
		else {
			projectTaskStatusMasterImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			projectTaskStatusMasterImpl.setModifiedDate(null);
		}
		else {
			projectTaskStatusMasterImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (projectTaskStatusName == null) {
			projectTaskStatusMasterImpl.setProjectTaskStatusName("");
		}
		else {
			projectTaskStatusMasterImpl.setProjectTaskStatusName(
				projectTaskStatusName);
		}

		projectTaskStatusMasterImpl.setIsApplicableForProject(
			isApplicableForProject);
		projectTaskStatusMasterImpl.setIsApplicableForTask(isApplicableForTask);

		projectTaskStatusMasterImpl.resetOriginalValues();

		return projectTaskStatusMasterImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		projectTaskStatusMasterId = objectInput.readLong();

		companyId = objectInput.readLong();

		createdBy = objectInput.readLong();

		modifiedBy = objectInput.readLong();

		groupId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		projectTaskStatusName = objectInput.readUTF();

		isApplicableForProject = objectInput.readBoolean();

		isApplicableForTask = objectInput.readBoolean();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(projectTaskStatusMasterId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(createdBy);

		objectOutput.writeLong(modifiedBy);

		objectOutput.writeLong(groupId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (projectTaskStatusName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(projectTaskStatusName);
		}

		objectOutput.writeBoolean(isApplicableForProject);

		objectOutput.writeBoolean(isApplicableForTask);
	}

	public long projectTaskStatusMasterId;
	public long companyId;
	public long createdBy;
	public long modifiedBy;
	public long groupId;
	public long createDate;
	public long modifiedDate;
	public String projectTaskStatusName;
	public boolean isApplicableForProject;
	public boolean isApplicableForTask;

}