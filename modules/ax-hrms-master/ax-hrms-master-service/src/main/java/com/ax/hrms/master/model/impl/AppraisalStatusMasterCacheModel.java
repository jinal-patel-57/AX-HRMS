/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.master.model.impl;

import com.ax.hrms.master.model.AppraisalStatusMaster;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing AppraisalStatusMaster in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class AppraisalStatusMasterCacheModel
	implements CacheModel<AppraisalStatusMaster>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof AppraisalStatusMasterCacheModel)) {
			return false;
		}

		AppraisalStatusMasterCacheModel appraisalStatusMasterCacheModel =
			(AppraisalStatusMasterCacheModel)object;

		if (appraisalStatusMasterId ==
				appraisalStatusMasterCacheModel.appraisalStatusMasterId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, appraisalStatusMasterId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{appraisalStatusMasterId=");
		sb.append(appraisalStatusMasterId);
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
		sb.append(", status=");
		sb.append(status);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public AppraisalStatusMaster toEntityModel() {
		AppraisalStatusMasterImpl appraisalStatusMasterImpl =
			new AppraisalStatusMasterImpl();

		appraisalStatusMasterImpl.setAppraisalStatusMasterId(
			appraisalStatusMasterId);
		appraisalStatusMasterImpl.setCompanyId(companyId);
		appraisalStatusMasterImpl.setCreatedBy(createdBy);
		appraisalStatusMasterImpl.setModifiedBy(modifiedBy);
		appraisalStatusMasterImpl.setGroupId(groupId);

		if (createDate == Long.MIN_VALUE) {
			appraisalStatusMasterImpl.setCreateDate(null);
		}
		else {
			appraisalStatusMasterImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			appraisalStatusMasterImpl.setModifiedDate(null);
		}
		else {
			appraisalStatusMasterImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (status == null) {
			appraisalStatusMasterImpl.setStatus("");
		}
		else {
			appraisalStatusMasterImpl.setStatus(status);
		}

		appraisalStatusMasterImpl.resetOriginalValues();

		return appraisalStatusMasterImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		appraisalStatusMasterId = objectInput.readLong();

		companyId = objectInput.readLong();

		createdBy = objectInput.readLong();

		modifiedBy = objectInput.readLong();

		groupId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		status = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(appraisalStatusMasterId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(createdBy);

		objectOutput.writeLong(modifiedBy);

		objectOutput.writeLong(groupId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (status == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(status);
		}
	}

	public long appraisalStatusMasterId;
	public long companyId;
	public long createdBy;
	public long modifiedBy;
	public long groupId;
	public long createDate;
	public long modifiedDate;
	public String status;

}