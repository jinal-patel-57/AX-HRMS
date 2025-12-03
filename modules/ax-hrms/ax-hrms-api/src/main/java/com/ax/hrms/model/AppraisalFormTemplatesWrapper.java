/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.model;

import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link AppraisalFormTemplates}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AppraisalFormTemplates
 * @generated
 */
public class AppraisalFormTemplatesWrapper
	extends BaseModelWrapper<AppraisalFormTemplates>
	implements AppraisalFormTemplates, ModelWrapper<AppraisalFormTemplates> {

	public AppraisalFormTemplatesWrapper(
		AppraisalFormTemplates appraisalFormTemplates) {

		super(appraisalFormTemplates);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("companyId", getCompanyId());
		attributes.put("createdBy", getCreatedBy());
		attributes.put("modifiedBy", getModifiedBy());
		attributes.put("groupId", getGroupId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("appraisalFormTemplateId", getAppraisalFormTemplateId());
		attributes.put("templateName", getTemplateName());
		attributes.put("templateDocumentId", getTemplateDocumentId());
		attributes.put("templateLevelId", getTemplateLevelId());
		attributes.put("templateYear", getTemplateYear());
		attributes.put("status", isStatus());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long createdBy = (Long)attributes.get("createdBy");

		if (createdBy != null) {
			setCreatedBy(createdBy);
		}

		Long modifiedBy = (Long)attributes.get("modifiedBy");

		if (modifiedBy != null) {
			setModifiedBy(modifiedBy);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Long appraisalFormTemplateId = (Long)attributes.get(
			"appraisalFormTemplateId");

		if (appraisalFormTemplateId != null) {
			setAppraisalFormTemplateId(appraisalFormTemplateId);
		}

		String templateName = (String)attributes.get("templateName");

		if (templateName != null) {
			setTemplateName(templateName);
		}

		Long templateDocumentId = (Long)attributes.get("templateDocumentId");

		if (templateDocumentId != null) {
			setTemplateDocumentId(templateDocumentId);
		}

		Long templateLevelId = (Long)attributes.get("templateLevelId");

		if (templateLevelId != null) {
			setTemplateLevelId(templateLevelId);
		}

		String templateYear = (String)attributes.get("templateYear");

		if (templateYear != null) {
			setTemplateYear(templateYear);
		}

		Boolean status = (Boolean)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}
	}

	@Override
	public AppraisalFormTemplates cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the appraisal form template ID of this appraisal form templates.
	 *
	 * @return the appraisal form template ID of this appraisal form templates
	 */
	@Override
	public long getAppraisalFormTemplateId() {
		return model.getAppraisalFormTemplateId();
	}

	/**
	 * Returns the company ID of this appraisal form templates.
	 *
	 * @return the company ID of this appraisal form templates
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this appraisal form templates.
	 *
	 * @return the create date of this appraisal form templates
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the created by of this appraisal form templates.
	 *
	 * @return the created by of this appraisal form templates
	 */
	@Override
	public long getCreatedBy() {
		return model.getCreatedBy();
	}

	/**
	 * Returns the group ID of this appraisal form templates.
	 *
	 * @return the group ID of this appraisal form templates
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified by of this appraisal form templates.
	 *
	 * @return the modified by of this appraisal form templates
	 */
	@Override
	public long getModifiedBy() {
		return model.getModifiedBy();
	}

	/**
	 * Returns the modified date of this appraisal form templates.
	 *
	 * @return the modified date of this appraisal form templates
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this appraisal form templates.
	 *
	 * @return the primary key of this appraisal form templates
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the status of this appraisal form templates.
	 *
	 * @return the status of this appraisal form templates
	 */
	@Override
	public boolean getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the template document ID of this appraisal form templates.
	 *
	 * @return the template document ID of this appraisal form templates
	 */
	@Override
	public long getTemplateDocumentId() {
		return model.getTemplateDocumentId();
	}

	/**
	 * Returns the template level ID of this appraisal form templates.
	 *
	 * @return the template level ID of this appraisal form templates
	 */
	@Override
	public long getTemplateLevelId() {
		return model.getTemplateLevelId();
	}

	/**
	 * Returns the template name of this appraisal form templates.
	 *
	 * @return the template name of this appraisal form templates
	 */
	@Override
	public String getTemplateName() {
		return model.getTemplateName();
	}

	/**
	 * Returns the template year of this appraisal form templates.
	 *
	 * @return the template year of this appraisal form templates
	 */
	@Override
	public String getTemplateYear() {
		return model.getTemplateYear();
	}

	/**
	 * Returns the uuid of this appraisal form templates.
	 *
	 * @return the uuid of this appraisal form templates
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns <code>true</code> if this appraisal form templates is status.
	 *
	 * @return <code>true</code> if this appraisal form templates is status; <code>false</code> otherwise
	 */
	@Override
	public boolean isStatus() {
		return model.isStatus();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the appraisal form template ID of this appraisal form templates.
	 *
	 * @param appraisalFormTemplateId the appraisal form template ID of this appraisal form templates
	 */
	@Override
	public void setAppraisalFormTemplateId(long appraisalFormTemplateId) {
		model.setAppraisalFormTemplateId(appraisalFormTemplateId);
	}

	/**
	 * Sets the company ID of this appraisal form templates.
	 *
	 * @param companyId the company ID of this appraisal form templates
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this appraisal form templates.
	 *
	 * @param createDate the create date of this appraisal form templates
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the created by of this appraisal form templates.
	 *
	 * @param createdBy the created by of this appraisal form templates
	 */
	@Override
	public void setCreatedBy(long createdBy) {
		model.setCreatedBy(createdBy);
	}

	/**
	 * Sets the group ID of this appraisal form templates.
	 *
	 * @param groupId the group ID of this appraisal form templates
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified by of this appraisal form templates.
	 *
	 * @param modifiedBy the modified by of this appraisal form templates
	 */
	@Override
	public void setModifiedBy(long modifiedBy) {
		model.setModifiedBy(modifiedBy);
	}

	/**
	 * Sets the modified date of this appraisal form templates.
	 *
	 * @param modifiedDate the modified date of this appraisal form templates
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this appraisal form templates.
	 *
	 * @param primaryKey the primary key of this appraisal form templates
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets whether this appraisal form templates is status.
	 *
	 * @param status the status of this appraisal form templates
	 */
	@Override
	public void setStatus(boolean status) {
		model.setStatus(status);
	}

	/**
	 * Sets the template document ID of this appraisal form templates.
	 *
	 * @param templateDocumentId the template document ID of this appraisal form templates
	 */
	@Override
	public void setTemplateDocumentId(long templateDocumentId) {
		model.setTemplateDocumentId(templateDocumentId);
	}

	/**
	 * Sets the template level ID of this appraisal form templates.
	 *
	 * @param templateLevelId the template level ID of this appraisal form templates
	 */
	@Override
	public void setTemplateLevelId(long templateLevelId) {
		model.setTemplateLevelId(templateLevelId);
	}

	/**
	 * Sets the template name of this appraisal form templates.
	 *
	 * @param templateName the template name of this appraisal form templates
	 */
	@Override
	public void setTemplateName(String templateName) {
		model.setTemplateName(templateName);
	}

	/**
	 * Sets the template year of this appraisal form templates.
	 *
	 * @param templateYear the template year of this appraisal form templates
	 */
	@Override
	public void setTemplateYear(String templateYear) {
		model.setTemplateYear(templateYear);
	}

	/**
	 * Sets the uuid of this appraisal form templates.
	 *
	 * @param uuid the uuid of this appraisal form templates
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	@Override
	public String toXmlString() {
		return model.toXmlString();
	}

	@Override
	public StagedModelType getStagedModelType() {
		return model.getStagedModelType();
	}

	@Override
	protected AppraisalFormTemplatesWrapper wrap(
		AppraisalFormTemplates appraisalFormTemplates) {

		return new AppraisalFormTemplatesWrapper(appraisalFormTemplates);
	}

}