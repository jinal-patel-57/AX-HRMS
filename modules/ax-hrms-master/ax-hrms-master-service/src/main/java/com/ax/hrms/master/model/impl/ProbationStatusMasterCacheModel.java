/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.master.model.impl;

import com.ax.hrms.master.model.ProbationStatusMaster;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ProbationStatusMaster in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ProbationStatusMasterCacheModel
	implements CacheModel<ProbationStatusMaster>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof ProbationStatusMasterCacheModel)) {
			return false;
		}

		ProbationStatusMasterCacheModel probationStatusMasterCacheModel =
			(ProbationStatusMasterCacheModel)object;

		if (probationStatusMasterId ==
				probationStatusMasterCacheModel.probationStatusMasterId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, probationStatusMasterId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{probationStatusMasterId=");
		sb.append(probationStatusMasterId);
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
		sb.append(", statusType=");
		sb.append(statusType);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ProbationStatusMaster toEntityModel() {
		ProbationStatusMasterImpl probationStatusMasterImpl =
			new ProbationStatusMasterImpl();

		probationStatusMasterImpl.setProbationStatusMasterId(
			probationStatusMasterId);
		probationStatusMasterImpl.setCompanyId(companyId);
		probationStatusMasterImpl.setCreatedBy(createdBy);
		probationStatusMasterImpl.setModifiedBy(modifiedBy);
		probationStatusMasterImpl.setGroupId(groupId);

		if (createDate == Long.MIN_VALUE) {
			probationStatusMasterImpl.setCreateDate(null);
		}
		else {
			probationStatusMasterImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			probationStatusMasterImpl.setModifiedDate(null);
		}
		else {
			probationStatusMasterImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (statusType == null) {
			probationStatusMasterImpl.setStatusType("");
		}
		else {
			probationStatusMasterImpl.setStatusType(statusType);
		}

		probationStatusMasterImpl.resetOriginalValues();

		return probationStatusMasterImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		probationStatusMasterId = objectInput.readLong();

		companyId = objectInput.readLong();

		createdBy = objectInput.readLong();

		modifiedBy = objectInput.readLong();

		groupId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		statusType = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(probationStatusMasterId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(createdBy);

		objectOutput.writeLong(modifiedBy);

		objectOutput.writeLong(groupId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (statusType == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(statusType);
		}
	}

	public long probationStatusMasterId;
	public long companyId;
	public long createdBy;
	public long modifiedBy;
	public long groupId;
	public long createDate;
	public long modifiedDate;
	public String statusType;

}