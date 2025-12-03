/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.model.impl;

import com.ax.hrms.model.AppraisalEvaluationFormStatus;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing AppraisalEvaluationFormStatus in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class AppraisalEvaluationFormStatusCacheModel
	implements CacheModel<AppraisalEvaluationFormStatus>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof AppraisalEvaluationFormStatusCacheModel)) {
			return false;
		}

		AppraisalEvaluationFormStatusCacheModel
			appraisalEvaluationFormStatusCacheModel =
				(AppraisalEvaluationFormStatusCacheModel)object;

		if (appraisalEvaluationFormStatusId ==
				appraisalEvaluationFormStatusCacheModel.
					appraisalEvaluationFormStatusId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, appraisalEvaluationFormStatusId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(29);

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
		sb.append(", appraisalEvaluationFormStatusId=");
		sb.append(appraisalEvaluationFormStatusId);
		sb.append(", appraisalProcessId=");
		sb.append(appraisalProcessId);
		sb.append(", submissionDate=");
		sb.append(submissionDate);
		sb.append(", employeeId=");
		sb.append(employeeId);
		sb.append(", filledEvaluationDocuemntId=");
		sb.append(filledEvaluationDocuemntId);
		sb.append(", appraisalFormTemplateId=");
		sb.append(appraisalFormTemplateId);
		sb.append(", status=");
		sb.append(status);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public AppraisalEvaluationFormStatus toEntityModel() {
		AppraisalEvaluationFormStatusImpl appraisalEvaluationFormStatusImpl =
			new AppraisalEvaluationFormStatusImpl();

		if (uuid == null) {
			appraisalEvaluationFormStatusImpl.setUuid("");
		}
		else {
			appraisalEvaluationFormStatusImpl.setUuid(uuid);
		}

		appraisalEvaluationFormStatusImpl.setCompanyId(companyId);
		appraisalEvaluationFormStatusImpl.setCreatedBy(createdBy);
		appraisalEvaluationFormStatusImpl.setModifiedBy(modifiedBy);
		appraisalEvaluationFormStatusImpl.setGroupId(groupId);

		if (createDate == Long.MIN_VALUE) {
			appraisalEvaluationFormStatusImpl.setCreateDate(null);
		}
		else {
			appraisalEvaluationFormStatusImpl.setCreateDate(
				new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			appraisalEvaluationFormStatusImpl.setModifiedDate(null);
		}
		else {
			appraisalEvaluationFormStatusImpl.setModifiedDate(
				new Date(modifiedDate));
		}

		appraisalEvaluationFormStatusImpl.setAppraisalEvaluationFormStatusId(
			appraisalEvaluationFormStatusId);
		appraisalEvaluationFormStatusImpl.setAppraisalProcessId(
			appraisalProcessId);

		if (submissionDate == Long.MIN_VALUE) {
			appraisalEvaluationFormStatusImpl.setSubmissionDate(null);
		}
		else {
			appraisalEvaluationFormStatusImpl.setSubmissionDate(
				new Date(submissionDate));
		}

		appraisalEvaluationFormStatusImpl.setEmployeeId(employeeId);
		appraisalEvaluationFormStatusImpl.setFilledEvaluationDocuemntId(
			filledEvaluationDocuemntId);
		appraisalEvaluationFormStatusImpl.setAppraisalFormTemplateId(
			appraisalFormTemplateId);
		appraisalEvaluationFormStatusImpl.setStatus(status);

		appraisalEvaluationFormStatusImpl.resetOriginalValues();

		return appraisalEvaluationFormStatusImpl;
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

		appraisalEvaluationFormStatusId = objectInput.readLong();

		appraisalProcessId = objectInput.readLong();
		submissionDate = objectInput.readLong();

		employeeId = objectInput.readLong();

		filledEvaluationDocuemntId = objectInput.readLong();

		appraisalFormTemplateId = objectInput.readLong();

		status = objectInput.readBoolean();
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

		objectOutput.writeLong(appraisalEvaluationFormStatusId);

		objectOutput.writeLong(appraisalProcessId);
		objectOutput.writeLong(submissionDate);

		objectOutput.writeLong(employeeId);

		objectOutput.writeLong(filledEvaluationDocuemntId);

		objectOutput.writeLong(appraisalFormTemplateId);

		objectOutput.writeBoolean(status);
	}

	public String uuid;
	public long companyId;
	public long createdBy;
	public long modifiedBy;
	public long groupId;
	public long createDate;
	public long modifiedDate;
	public long appraisalEvaluationFormStatusId;
	public long appraisalProcessId;
	public long submissionDate;
	public long employeeId;
	public long filledEvaluationDocuemntId;
	public long appraisalFormTemplateId;
	public boolean status;

}