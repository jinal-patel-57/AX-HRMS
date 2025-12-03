/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.model.impl;

import com.ax.hrms.model.AppraisalHistory;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing AppraisalHistory in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class AppraisalHistoryCacheModel
	implements CacheModel<AppraisalHistory>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof AppraisalHistoryCacheModel)) {
			return false;
		}

		AppraisalHistoryCacheModel appraisalHistoryCacheModel =
			(AppraisalHistoryCacheModel)object;

		if (appraisalId == appraisalHistoryCacheModel.appraisalId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, appraisalId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(31);

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
		sb.append(", appraisalId=");
		sb.append(appraisalId);
		sb.append(", salaryId=");
		sb.append(salaryId);
		sb.append(", appraisalDate=");
		sb.append(appraisalDate);
		sb.append(", appraisalDocumentId=");
		sb.append(appraisalDocumentId);
		sb.append(", updatedCtcPa=");
		sb.append(updatedCtcPa);
		sb.append(", updatedCtcPm=");
		sb.append(updatedCtcPm);
		sb.append(", rating=");
		sb.append(rating);
		sb.append(", comments=");
		sb.append(comments);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public AppraisalHistory toEntityModel() {
		AppraisalHistoryImpl appraisalHistoryImpl = new AppraisalHistoryImpl();

		if (uuid == null) {
			appraisalHistoryImpl.setUuid("");
		}
		else {
			appraisalHistoryImpl.setUuid(uuid);
		}

		appraisalHistoryImpl.setCompanyId(companyId);
		appraisalHistoryImpl.setCreatedBy(createdBy);
		appraisalHistoryImpl.setModifiedBy(modifiedBy);
		appraisalHistoryImpl.setGroupId(groupId);

		if (createDate == Long.MIN_VALUE) {
			appraisalHistoryImpl.setCreateDate(null);
		}
		else {
			appraisalHistoryImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			appraisalHistoryImpl.setModifiedDate(null);
		}
		else {
			appraisalHistoryImpl.setModifiedDate(new Date(modifiedDate));
		}

		appraisalHistoryImpl.setAppraisalId(appraisalId);
		appraisalHistoryImpl.setSalaryId(salaryId);

		if (appraisalDate == Long.MIN_VALUE) {
			appraisalHistoryImpl.setAppraisalDate(null);
		}
		else {
			appraisalHistoryImpl.setAppraisalDate(new Date(appraisalDate));
		}

		appraisalHistoryImpl.setAppraisalDocumentId(appraisalDocumentId);
		appraisalHistoryImpl.setUpdatedCtcPa(updatedCtcPa);
		appraisalHistoryImpl.setUpdatedCtcPm(updatedCtcPm);
		appraisalHistoryImpl.setRating(rating);

		if (comments == null) {
			appraisalHistoryImpl.setComments("");
		}
		else {
			appraisalHistoryImpl.setComments(comments);
		}

		appraisalHistoryImpl.resetOriginalValues();

		return appraisalHistoryImpl;
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

		appraisalId = objectInput.readLong();

		salaryId = objectInput.readLong();
		appraisalDate = objectInput.readLong();

		appraisalDocumentId = objectInput.readLong();

		updatedCtcPa = objectInput.readDouble();

		updatedCtcPm = objectInput.readDouble();

		rating = objectInput.readDouble();
		comments = objectInput.readUTF();
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

		objectOutput.writeLong(appraisalId);

		objectOutput.writeLong(salaryId);
		objectOutput.writeLong(appraisalDate);

		objectOutput.writeLong(appraisalDocumentId);

		objectOutput.writeDouble(updatedCtcPa);

		objectOutput.writeDouble(updatedCtcPm);

		objectOutput.writeDouble(rating);

		if (comments == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(comments);
		}
	}

	public String uuid;
	public long companyId;
	public long createdBy;
	public long modifiedBy;
	public long groupId;
	public long createDate;
	public long modifiedDate;
	public long appraisalId;
	public long salaryId;
	public long appraisalDate;
	public long appraisalDocumentId;
	public double updatedCtcPa;
	public double updatedCtcPm;
	public double rating;
	public String comments;

}