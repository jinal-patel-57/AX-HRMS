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
 * This class is a wrapper for {@link AppraisalEvaluationFormStatus}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AppraisalEvaluationFormStatus
 * @generated
 */
public class AppraisalEvaluationFormStatusWrapper
	extends BaseModelWrapper<AppraisalEvaluationFormStatus>
	implements AppraisalEvaluationFormStatus,
			   ModelWrapper<AppraisalEvaluationFormStatus> {

	public AppraisalEvaluationFormStatusWrapper(
		AppraisalEvaluationFormStatus appraisalEvaluationFormStatus) {

		super(appraisalEvaluationFormStatus);
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
		attributes.put(
			"appraisalEvaluationFormStatusId",
			getAppraisalEvaluationFormStatusId());
		attributes.put("appraisalProcessId", getAppraisalProcessId());
		attributes.put("submissionDate", getSubmissionDate());
		attributes.put("employeeId", getEmployeeId());
		attributes.put(
			"filledEvaluationDocuemntId", getFilledEvaluationDocuemntId());
		attributes.put("appraisalFormTemplateId", getAppraisalFormTemplateId());
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

		Long appraisalEvaluationFormStatusId = (Long)attributes.get(
			"appraisalEvaluationFormStatusId");

		if (appraisalEvaluationFormStatusId != null) {
			setAppraisalEvaluationFormStatusId(appraisalEvaluationFormStatusId);
		}

		Long appraisalProcessId = (Long)attributes.get("appraisalProcessId");

		if (appraisalProcessId != null) {
			setAppraisalProcessId(appraisalProcessId);
		}

		Date submissionDate = (Date)attributes.get("submissionDate");

		if (submissionDate != null) {
			setSubmissionDate(submissionDate);
		}

		Long employeeId = (Long)attributes.get("employeeId");

		if (employeeId != null) {
			setEmployeeId(employeeId);
		}

		Long filledEvaluationDocuemntId = (Long)attributes.get(
			"filledEvaluationDocuemntId");

		if (filledEvaluationDocuemntId != null) {
			setFilledEvaluationDocuemntId(filledEvaluationDocuemntId);
		}

		Long appraisalFormTemplateId = (Long)attributes.get(
			"appraisalFormTemplateId");

		if (appraisalFormTemplateId != null) {
			setAppraisalFormTemplateId(appraisalFormTemplateId);
		}

		Boolean status = (Boolean)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}
	}

	@Override
	public AppraisalEvaluationFormStatus cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the appraisal evaluation form status ID of this appraisal evaluation form status.
	 *
	 * @return the appraisal evaluation form status ID of this appraisal evaluation form status
	 */
	@Override
	public long getAppraisalEvaluationFormStatusId() {
		return model.getAppraisalEvaluationFormStatusId();
	}

	/**
	 * Returns the appraisal form template ID of this appraisal evaluation form status.
	 *
	 * @return the appraisal form template ID of this appraisal evaluation form status
	 */
	@Override
	public long getAppraisalFormTemplateId() {
		return model.getAppraisalFormTemplateId();
	}

	/**
	 * Returns the appraisal process ID of this appraisal evaluation form status.
	 *
	 * @return the appraisal process ID of this appraisal evaluation form status
	 */
	@Override
	public long getAppraisalProcessId() {
		return model.getAppraisalProcessId();
	}

	/**
	 * Returns the company ID of this appraisal evaluation form status.
	 *
	 * @return the company ID of this appraisal evaluation form status
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this appraisal evaluation form status.
	 *
	 * @return the create date of this appraisal evaluation form status
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the created by of this appraisal evaluation form status.
	 *
	 * @return the created by of this appraisal evaluation form status
	 */
	@Override
	public long getCreatedBy() {
		return model.getCreatedBy();
	}

	/**
	 * Returns the employee ID of this appraisal evaluation form status.
	 *
	 * @return the employee ID of this appraisal evaluation form status
	 */
	@Override
	public long getEmployeeId() {
		return model.getEmployeeId();
	}

	/**
	 * Returns the filled evaluation docuemnt ID of this appraisal evaluation form status.
	 *
	 * @return the filled evaluation docuemnt ID of this appraisal evaluation form status
	 */
	@Override
	public long getFilledEvaluationDocuemntId() {
		return model.getFilledEvaluationDocuemntId();
	}

	/**
	 * Returns the group ID of this appraisal evaluation form status.
	 *
	 * @return the group ID of this appraisal evaluation form status
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified by of this appraisal evaluation form status.
	 *
	 * @return the modified by of this appraisal evaluation form status
	 */
	@Override
	public long getModifiedBy() {
		return model.getModifiedBy();
	}

	/**
	 * Returns the modified date of this appraisal evaluation form status.
	 *
	 * @return the modified date of this appraisal evaluation form status
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this appraisal evaluation form status.
	 *
	 * @return the primary key of this appraisal evaluation form status
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the status of this appraisal evaluation form status.
	 *
	 * @return the status of this appraisal evaluation form status
	 */
	@Override
	public boolean getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the submission date of this appraisal evaluation form status.
	 *
	 * @return the submission date of this appraisal evaluation form status
	 */
	@Override
	public Date getSubmissionDate() {
		return model.getSubmissionDate();
	}

	/**
	 * Returns the uuid of this appraisal evaluation form status.
	 *
	 * @return the uuid of this appraisal evaluation form status
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns <code>true</code> if this appraisal evaluation form status is status.
	 *
	 * @return <code>true</code> if this appraisal evaluation form status is status; <code>false</code> otherwise
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
	 * Sets the appraisal evaluation form status ID of this appraisal evaluation form status.
	 *
	 * @param appraisalEvaluationFormStatusId the appraisal evaluation form status ID of this appraisal evaluation form status
	 */
	@Override
	public void setAppraisalEvaluationFormStatusId(
		long appraisalEvaluationFormStatusId) {

		model.setAppraisalEvaluationFormStatusId(
			appraisalEvaluationFormStatusId);
	}

	/**
	 * Sets the appraisal form template ID of this appraisal evaluation form status.
	 *
	 * @param appraisalFormTemplateId the appraisal form template ID of this appraisal evaluation form status
	 */
	@Override
	public void setAppraisalFormTemplateId(long appraisalFormTemplateId) {
		model.setAppraisalFormTemplateId(appraisalFormTemplateId);
	}

	/**
	 * Sets the appraisal process ID of this appraisal evaluation form status.
	 *
	 * @param appraisalProcessId the appraisal process ID of this appraisal evaluation form status
	 */
	@Override
	public void setAppraisalProcessId(long appraisalProcessId) {
		model.setAppraisalProcessId(appraisalProcessId);
	}

	/**
	 * Sets the company ID of this appraisal evaluation form status.
	 *
	 * @param companyId the company ID of this appraisal evaluation form status
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this appraisal evaluation form status.
	 *
	 * @param createDate the create date of this appraisal evaluation form status
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the created by of this appraisal evaluation form status.
	 *
	 * @param createdBy the created by of this appraisal evaluation form status
	 */
	@Override
	public void setCreatedBy(long createdBy) {
		model.setCreatedBy(createdBy);
	}

	/**
	 * Sets the employee ID of this appraisal evaluation form status.
	 *
	 * @param employeeId the employee ID of this appraisal evaluation form status
	 */
	@Override
	public void setEmployeeId(long employeeId) {
		model.setEmployeeId(employeeId);
	}

	/**
	 * Sets the filled evaluation docuemnt ID of this appraisal evaluation form status.
	 *
	 * @param filledEvaluationDocuemntId the filled evaluation docuemnt ID of this appraisal evaluation form status
	 */
	@Override
	public void setFilledEvaluationDocuemntId(long filledEvaluationDocuemntId) {
		model.setFilledEvaluationDocuemntId(filledEvaluationDocuemntId);
	}

	/**
	 * Sets the group ID of this appraisal evaluation form status.
	 *
	 * @param groupId the group ID of this appraisal evaluation form status
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified by of this appraisal evaluation form status.
	 *
	 * @param modifiedBy the modified by of this appraisal evaluation form status
	 */
	@Override
	public void setModifiedBy(long modifiedBy) {
		model.setModifiedBy(modifiedBy);
	}

	/**
	 * Sets the modified date of this appraisal evaluation form status.
	 *
	 * @param modifiedDate the modified date of this appraisal evaluation form status
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this appraisal evaluation form status.
	 *
	 * @param primaryKey the primary key of this appraisal evaluation form status
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets whether this appraisal evaluation form status is status.
	 *
	 * @param status the status of this appraisal evaluation form status
	 */
	@Override
	public void setStatus(boolean status) {
		model.setStatus(status);
	}

	/**
	 * Sets the submission date of this appraisal evaluation form status.
	 *
	 * @param submissionDate the submission date of this appraisal evaluation form status
	 */
	@Override
	public void setSubmissionDate(Date submissionDate) {
		model.setSubmissionDate(submissionDate);
	}

	/**
	 * Sets the uuid of this appraisal evaluation form status.
	 *
	 * @param uuid the uuid of this appraisal evaluation form status
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
	protected AppraisalEvaluationFormStatusWrapper wrap(
		AppraisalEvaluationFormStatus appraisalEvaluationFormStatus) {

		return new AppraisalEvaluationFormStatusWrapper(
			appraisalEvaluationFormStatus);
	}

}