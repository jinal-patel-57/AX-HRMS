/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.model.impl;

import com.ax.hrms.model.AppraisalProcess;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing AppraisalProcess in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class AppraisalProcessCacheModel
	implements CacheModel<AppraisalProcess>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof AppraisalProcessCacheModel)) {
			return false;
		}

		AppraisalProcessCacheModel appraisalProcessCacheModel =
			(AppraisalProcessCacheModel)object;

		if (appraisalProcessId ==
				appraisalProcessCacheModel.appraisalProcessId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, appraisalProcessId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(37);

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
		sb.append(", appraisalProcessId=");
		sb.append(appraisalProcessId);
		sb.append(", isSelfEvalutionFormSent=");
		sb.append(isSelfEvalutionFormSent);
		sb.append(", isSelfEvalutionFormFilled=");
		sb.append(isSelfEvalutionFormFilled);
		sb.append(", arePeerEvaluationFormSent=");
		sb.append(arePeerEvaluationFormSent);
		sb.append(", arePeerEvaluationFormFilled=");
		sb.append(arePeerEvaluationFormFilled);
		sb.append(", isManagementFormSent=");
		sb.append(isManagementFormSent);
		sb.append(", isManagementFormFilled=");
		sb.append(isManagementFormFilled);
		sb.append(", isMeetingScheduled=");
		sb.append(isMeetingScheduled);
		sb.append(", isMeetingDone=");
		sb.append(isMeetingDone);
		sb.append(", isSalaryUpdated=");
		sb.append(isSalaryUpdated);
		sb.append(", status=");
		sb.append(status);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public AppraisalProcess toEntityModel() {
		AppraisalProcessImpl appraisalProcessImpl = new AppraisalProcessImpl();

		if (uuid == null) {
			appraisalProcessImpl.setUuid("");
		}
		else {
			appraisalProcessImpl.setUuid(uuid);
		}

		appraisalProcessImpl.setCompanyId(companyId);
		appraisalProcessImpl.setCreatedBy(createdBy);
		appraisalProcessImpl.setModifiedBy(modifiedBy);
		appraisalProcessImpl.setGroupId(groupId);

		if (createDate == Long.MIN_VALUE) {
			appraisalProcessImpl.setCreateDate(null);
		}
		else {
			appraisalProcessImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			appraisalProcessImpl.setModifiedDate(null);
		}
		else {
			appraisalProcessImpl.setModifiedDate(new Date(modifiedDate));
		}

		appraisalProcessImpl.setAppraisalProcessId(appraisalProcessId);
		appraisalProcessImpl.setIsSelfEvalutionFormSent(
			isSelfEvalutionFormSent);
		appraisalProcessImpl.setIsSelfEvalutionFormFilled(
			isSelfEvalutionFormFilled);
		appraisalProcessImpl.setArePeerEvaluationFormSent(
			arePeerEvaluationFormSent);
		appraisalProcessImpl.setArePeerEvaluationFormFilled(
			arePeerEvaluationFormFilled);
		appraisalProcessImpl.setIsManagementFormSent(isManagementFormSent);
		appraisalProcessImpl.setIsManagementFormFilled(isManagementFormFilled);
		appraisalProcessImpl.setIsMeetingScheduled(isMeetingScheduled);
		appraisalProcessImpl.setIsMeetingDone(isMeetingDone);
		appraisalProcessImpl.setIsSalaryUpdated(isSalaryUpdated);
		appraisalProcessImpl.setStatus(status);

		appraisalProcessImpl.resetOriginalValues();

		return appraisalProcessImpl;
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

		appraisalProcessId = objectInput.readLong();

		isSelfEvalutionFormSent = objectInput.readBoolean();

		isSelfEvalutionFormFilled = objectInput.readBoolean();

		arePeerEvaluationFormSent = objectInput.readBoolean();

		arePeerEvaluationFormFilled = objectInput.readBoolean();

		isManagementFormSent = objectInput.readBoolean();

		isManagementFormFilled = objectInput.readBoolean();

		isMeetingScheduled = objectInput.readBoolean();

		isMeetingDone = objectInput.readBoolean();

		isSalaryUpdated = objectInput.readBoolean();

		status = objectInput.readLong();
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

		objectOutput.writeLong(appraisalProcessId);

		objectOutput.writeBoolean(isSelfEvalutionFormSent);

		objectOutput.writeBoolean(isSelfEvalutionFormFilled);

		objectOutput.writeBoolean(arePeerEvaluationFormSent);

		objectOutput.writeBoolean(arePeerEvaluationFormFilled);

		objectOutput.writeBoolean(isManagementFormSent);

		objectOutput.writeBoolean(isManagementFormFilled);

		objectOutput.writeBoolean(isMeetingScheduled);

		objectOutput.writeBoolean(isMeetingDone);

		objectOutput.writeBoolean(isSalaryUpdated);

		objectOutput.writeLong(status);
	}

	public String uuid;
	public long companyId;
	public long createdBy;
	public long modifiedBy;
	public long groupId;
	public long createDate;
	public long modifiedDate;
	public long appraisalProcessId;
	public boolean isSelfEvalutionFormSent;
	public boolean isSelfEvalutionFormFilled;
	public boolean arePeerEvaluationFormSent;
	public boolean arePeerEvaluationFormFilled;
	public boolean isManagementFormSent;
	public boolean isManagementFormFilled;
	public boolean isMeetingScheduled;
	public boolean isMeetingDone;
	public boolean isSalaryUpdated;
	public long status;

}