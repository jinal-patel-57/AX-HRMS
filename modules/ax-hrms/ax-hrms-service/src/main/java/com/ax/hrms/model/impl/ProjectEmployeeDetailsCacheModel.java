/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.model.impl;

import com.ax.hrms.model.ProjectEmployeeDetails;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ProjectEmployeeDetails in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ProjectEmployeeDetailsCacheModel
	implements CacheModel<ProjectEmployeeDetails>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof ProjectEmployeeDetailsCacheModel)) {
			return false;
		}

		ProjectEmployeeDetailsCacheModel projectEmployeeDetailsCacheModel =
			(ProjectEmployeeDetailsCacheModel)object;

		if (projectEmployeeDetailsId ==
				projectEmployeeDetailsCacheModel.projectEmployeeDetailsId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, projectEmployeeDetailsId);
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
		sb.append(", projectEmployeeDetailsId=");
		sb.append(projectEmployeeDetailsId);
		sb.append(", projectId=");
		sb.append(projectId);
		sb.append(", employeeId=");
		sb.append(employeeId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ProjectEmployeeDetails toEntityModel() {
		ProjectEmployeeDetailsImpl projectEmployeeDetailsImpl =
			new ProjectEmployeeDetailsImpl();

		if (uuid == null) {
			projectEmployeeDetailsImpl.setUuid("");
		}
		else {
			projectEmployeeDetailsImpl.setUuid(uuid);
		}

		projectEmployeeDetailsImpl.setCompanyId(companyId);
		projectEmployeeDetailsImpl.setCreatedBy(createdBy);
		projectEmployeeDetailsImpl.setModifiedBy(modifiedBy);
		projectEmployeeDetailsImpl.setGroupId(groupId);

		if (createDate == Long.MIN_VALUE) {
			projectEmployeeDetailsImpl.setCreateDate(null);
		}
		else {
			projectEmployeeDetailsImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			projectEmployeeDetailsImpl.setModifiedDate(null);
		}
		else {
			projectEmployeeDetailsImpl.setModifiedDate(new Date(modifiedDate));
		}

		projectEmployeeDetailsImpl.setProjectEmployeeDetailsId(
			projectEmployeeDetailsId);
		projectEmployeeDetailsImpl.setProjectId(projectId);
		projectEmployeeDetailsImpl.setEmployeeId(employeeId);

		projectEmployeeDetailsImpl.resetOriginalValues();

		return projectEmployeeDetailsImpl;
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

		projectEmployeeDetailsId = objectInput.readLong();

		projectId = objectInput.readLong();

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

		objectOutput.writeLong(projectEmployeeDetailsId);

		objectOutput.writeLong(projectId);

		objectOutput.writeLong(employeeId);
	}

	public String uuid;
	public long companyId;
	public long createdBy;
	public long modifiedBy;
	public long groupId;
	public long createDate;
	public long modifiedDate;
	public long projectEmployeeDetailsId;
	public long projectId;
	public long employeeId;

}