/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.model.impl;

import com.ax.hrms.model.ExtendedProbationDetails;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ExtendedProbationDetails in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ExtendedProbationDetailsCacheModel
	implements CacheModel<ExtendedProbationDetails>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof ExtendedProbationDetailsCacheModel)) {
			return false;
		}

		ExtendedProbationDetailsCacheModel extendedProbationDetailsCacheModel =
			(ExtendedProbationDetailsCacheModel)object;

		if (extendedProbationDetailsId ==
				extendedProbationDetailsCacheModel.extendedProbationDetailsId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, extendedProbationDetailsId);
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
		sb.append(", extendedProbationDetailsId=");
		sb.append(extendedProbationDetailsId);
		sb.append(", probationDetailId=");
		sb.append(probationDetailId);
		sb.append(", extendDate=");
		sb.append(extendDate);
		sb.append(", evalutionReview=");
		sb.append(evalutionReview);
		sb.append(", extendedProbationPeriod=");
		sb.append(extendedProbationPeriod);
		sb.append(", extendedProbationEndDate=");
		sb.append(extendedProbationEndDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ExtendedProbationDetails toEntityModel() {
		ExtendedProbationDetailsImpl extendedProbationDetailsImpl =
			new ExtendedProbationDetailsImpl();

		if (uuid == null) {
			extendedProbationDetailsImpl.setUuid("");
		}
		else {
			extendedProbationDetailsImpl.setUuid(uuid);
		}

		extendedProbationDetailsImpl.setCompanyId(companyId);
		extendedProbationDetailsImpl.setCreatedBy(createdBy);
		extendedProbationDetailsImpl.setModifiedBy(modifiedBy);
		extendedProbationDetailsImpl.setGroupId(groupId);

		if (createDate == Long.MIN_VALUE) {
			extendedProbationDetailsImpl.setCreateDate(null);
		}
		else {
			extendedProbationDetailsImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			extendedProbationDetailsImpl.setModifiedDate(null);
		}
		else {
			extendedProbationDetailsImpl.setModifiedDate(
				new Date(modifiedDate));
		}

		extendedProbationDetailsImpl.setExtendedProbationDetailsId(
			extendedProbationDetailsId);
		extendedProbationDetailsImpl.setProbationDetailId(probationDetailId);

		if (extendDate == Long.MIN_VALUE) {
			extendedProbationDetailsImpl.setExtendDate(null);
		}
		else {
			extendedProbationDetailsImpl.setExtendDate(new Date(extendDate));
		}

		if (evalutionReview == null) {
			extendedProbationDetailsImpl.setEvalutionReview("");
		}
		else {
			extendedProbationDetailsImpl.setEvalutionReview(evalutionReview);
		}

		extendedProbationDetailsImpl.setExtendedProbationPeriod(
			extendedProbationPeriod);

		if (extendedProbationEndDate == Long.MIN_VALUE) {
			extendedProbationDetailsImpl.setExtendedProbationEndDate(null);
		}
		else {
			extendedProbationDetailsImpl.setExtendedProbationEndDate(
				new Date(extendedProbationEndDate));
		}

		extendedProbationDetailsImpl.resetOriginalValues();

		return extendedProbationDetailsImpl;
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

		extendedProbationDetailsId = objectInput.readLong();

		probationDetailId = objectInput.readLong();
		extendDate = objectInput.readLong();
		evalutionReview = objectInput.readUTF();

		extendedProbationPeriod = objectInput.readInt();
		extendedProbationEndDate = objectInput.readLong();
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

		objectOutput.writeLong(extendedProbationDetailsId);

		objectOutput.writeLong(probationDetailId);
		objectOutput.writeLong(extendDate);

		if (evalutionReview == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(evalutionReview);
		}

		objectOutput.writeInt(extendedProbationPeriod);
		objectOutput.writeLong(extendedProbationEndDate);
	}

	public String uuid;
	public long companyId;
	public long createdBy;
	public long modifiedBy;
	public long groupId;
	public long createDate;
	public long modifiedDate;
	public long extendedProbationDetailsId;
	public long probationDetailId;
	public long extendDate;
	public String evalutionReview;
	public int extendedProbationPeriod;
	public long extendedProbationEndDate;

}