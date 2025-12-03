/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.model.impl;

import com.ax.hrms.model.AppraisalFormTemplates;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing AppraisalFormTemplates in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class AppraisalFormTemplatesCacheModel
	implements CacheModel<AppraisalFormTemplates>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof AppraisalFormTemplatesCacheModel)) {
			return false;
		}

		AppraisalFormTemplatesCacheModel appraisalFormTemplatesCacheModel =
			(AppraisalFormTemplatesCacheModel)object;

		if (appraisalFormTemplateId ==
				appraisalFormTemplatesCacheModel.appraisalFormTemplateId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, appraisalFormTemplateId);
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
		sb.append(", appraisalFormTemplateId=");
		sb.append(appraisalFormTemplateId);
		sb.append(", templateName=");
		sb.append(templateName);
		sb.append(", templateDocumentId=");
		sb.append(templateDocumentId);
		sb.append(", templateLevelId=");
		sb.append(templateLevelId);
		sb.append(", templateYear=");
		sb.append(templateYear);
		sb.append(", status=");
		sb.append(status);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public AppraisalFormTemplates toEntityModel() {
		AppraisalFormTemplatesImpl appraisalFormTemplatesImpl =
			new AppraisalFormTemplatesImpl();

		if (uuid == null) {
			appraisalFormTemplatesImpl.setUuid("");
		}
		else {
			appraisalFormTemplatesImpl.setUuid(uuid);
		}

		appraisalFormTemplatesImpl.setCompanyId(companyId);
		appraisalFormTemplatesImpl.setCreatedBy(createdBy);
		appraisalFormTemplatesImpl.setModifiedBy(modifiedBy);
		appraisalFormTemplatesImpl.setGroupId(groupId);

		if (createDate == Long.MIN_VALUE) {
			appraisalFormTemplatesImpl.setCreateDate(null);
		}
		else {
			appraisalFormTemplatesImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			appraisalFormTemplatesImpl.setModifiedDate(null);
		}
		else {
			appraisalFormTemplatesImpl.setModifiedDate(new Date(modifiedDate));
		}

		appraisalFormTemplatesImpl.setAppraisalFormTemplateId(
			appraisalFormTemplateId);

		if (templateName == null) {
			appraisalFormTemplatesImpl.setTemplateName("");
		}
		else {
			appraisalFormTemplatesImpl.setTemplateName(templateName);
		}

		appraisalFormTemplatesImpl.setTemplateDocumentId(templateDocumentId);
		appraisalFormTemplatesImpl.setTemplateLevelId(templateLevelId);

		if (templateYear == null) {
			appraisalFormTemplatesImpl.setTemplateYear("");
		}
		else {
			appraisalFormTemplatesImpl.setTemplateYear(templateYear);
		}

		appraisalFormTemplatesImpl.setStatus(status);

		appraisalFormTemplatesImpl.resetOriginalValues();

		return appraisalFormTemplatesImpl;
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

		appraisalFormTemplateId = objectInput.readLong();
		templateName = objectInput.readUTF();

		templateDocumentId = objectInput.readLong();

		templateLevelId = objectInput.readLong();
		templateYear = objectInput.readUTF();

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

		objectOutput.writeLong(appraisalFormTemplateId);

		if (templateName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(templateName);
		}

		objectOutput.writeLong(templateDocumentId);

		objectOutput.writeLong(templateLevelId);

		if (templateYear == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(templateYear);
		}

		objectOutput.writeBoolean(status);
	}

	public String uuid;
	public long companyId;
	public long createdBy;
	public long modifiedBy;
	public long groupId;
	public long createDate;
	public long modifiedDate;
	public long appraisalFormTemplateId;
	public String templateName;
	public long templateDocumentId;
	public long templateLevelId;
	public String templateYear;
	public boolean status;

}