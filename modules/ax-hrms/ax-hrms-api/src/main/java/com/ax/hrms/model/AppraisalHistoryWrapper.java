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
 * This class is a wrapper for {@link AppraisalHistory}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AppraisalHistory
 * @generated
 */
public class AppraisalHistoryWrapper
	extends BaseModelWrapper<AppraisalHistory>
	implements AppraisalHistory, ModelWrapper<AppraisalHistory> {

	public AppraisalHistoryWrapper(AppraisalHistory appraisalHistory) {
		super(appraisalHistory);
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
		attributes.put("appraisalId", getAppraisalId());
		attributes.put("salaryId", getSalaryId());
		attributes.put("appraisalDate", getAppraisalDate());
		attributes.put("appraisalDocumentId", getAppraisalDocumentId());
		attributes.put("updatedCtcPa", getUpdatedCtcPa());
		attributes.put("updatedCtcPm", getUpdatedCtcPm());
		attributes.put("rating", getRating());
		attributes.put("comments", getComments());

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

		Long appraisalId = (Long)attributes.get("appraisalId");

		if (appraisalId != null) {
			setAppraisalId(appraisalId);
		}

		Long salaryId = (Long)attributes.get("salaryId");

		if (salaryId != null) {
			setSalaryId(salaryId);
		}

		Date appraisalDate = (Date)attributes.get("appraisalDate");

		if (appraisalDate != null) {
			setAppraisalDate(appraisalDate);
		}

		Long appraisalDocumentId = (Long)attributes.get("appraisalDocumentId");

		if (appraisalDocumentId != null) {
			setAppraisalDocumentId(appraisalDocumentId);
		}

		Double updatedCtcPa = (Double)attributes.get("updatedCtcPa");

		if (updatedCtcPa != null) {
			setUpdatedCtcPa(updatedCtcPa);
		}

		Double updatedCtcPm = (Double)attributes.get("updatedCtcPm");

		if (updatedCtcPm != null) {
			setUpdatedCtcPm(updatedCtcPm);
		}

		Double rating = (Double)attributes.get("rating");

		if (rating != null) {
			setRating(rating);
		}

		String comments = (String)attributes.get("comments");

		if (comments != null) {
			setComments(comments);
		}
	}

	@Override
	public AppraisalHistory cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the appraisal date of this appraisal history.
	 *
	 * @return the appraisal date of this appraisal history
	 */
	@Override
	public Date getAppraisalDate() {
		return model.getAppraisalDate();
	}

	/**
	 * Returns the appraisal document ID of this appraisal history.
	 *
	 * @return the appraisal document ID of this appraisal history
	 */
	@Override
	public long getAppraisalDocumentId() {
		return model.getAppraisalDocumentId();
	}

	/**
	 * Returns the appraisal ID of this appraisal history.
	 *
	 * @return the appraisal ID of this appraisal history
	 */
	@Override
	public long getAppraisalId() {
		return model.getAppraisalId();
	}

	/**
	 * Returns the comments of this appraisal history.
	 *
	 * @return the comments of this appraisal history
	 */
	@Override
	public String getComments() {
		return model.getComments();
	}

	/**
	 * Returns the company ID of this appraisal history.
	 *
	 * @return the company ID of this appraisal history
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this appraisal history.
	 *
	 * @return the create date of this appraisal history
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the created by of this appraisal history.
	 *
	 * @return the created by of this appraisal history
	 */
	@Override
	public long getCreatedBy() {
		return model.getCreatedBy();
	}

	/**
	 * Returns the group ID of this appraisal history.
	 *
	 * @return the group ID of this appraisal history
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified by of this appraisal history.
	 *
	 * @return the modified by of this appraisal history
	 */
	@Override
	public long getModifiedBy() {
		return model.getModifiedBy();
	}

	/**
	 * Returns the modified date of this appraisal history.
	 *
	 * @return the modified date of this appraisal history
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this appraisal history.
	 *
	 * @return the primary key of this appraisal history
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the rating of this appraisal history.
	 *
	 * @return the rating of this appraisal history
	 */
	@Override
	public double getRating() {
		return model.getRating();
	}

	/**
	 * Returns the salary ID of this appraisal history.
	 *
	 * @return the salary ID of this appraisal history
	 */
	@Override
	public long getSalaryId() {
		return model.getSalaryId();
	}

	/**
	 * Returns the updated ctc pa of this appraisal history.
	 *
	 * @return the updated ctc pa of this appraisal history
	 */
	@Override
	public double getUpdatedCtcPa() {
		return model.getUpdatedCtcPa();
	}

	/**
	 * Returns the updated ctc pm of this appraisal history.
	 *
	 * @return the updated ctc pm of this appraisal history
	 */
	@Override
	public double getUpdatedCtcPm() {
		return model.getUpdatedCtcPm();
	}

	/**
	 * Returns the uuid of this appraisal history.
	 *
	 * @return the uuid of this appraisal history
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the appraisal date of this appraisal history.
	 *
	 * @param appraisalDate the appraisal date of this appraisal history
	 */
	@Override
	public void setAppraisalDate(Date appraisalDate) {
		model.setAppraisalDate(appraisalDate);
	}

	/**
	 * Sets the appraisal document ID of this appraisal history.
	 *
	 * @param appraisalDocumentId the appraisal document ID of this appraisal history
	 */
	@Override
	public void setAppraisalDocumentId(long appraisalDocumentId) {
		model.setAppraisalDocumentId(appraisalDocumentId);
	}

	/**
	 * Sets the appraisal ID of this appraisal history.
	 *
	 * @param appraisalId the appraisal ID of this appraisal history
	 */
	@Override
	public void setAppraisalId(long appraisalId) {
		model.setAppraisalId(appraisalId);
	}

	/**
	 * Sets the comments of this appraisal history.
	 *
	 * @param comments the comments of this appraisal history
	 */
	@Override
	public void setComments(String comments) {
		model.setComments(comments);
	}

	/**
	 * Sets the company ID of this appraisal history.
	 *
	 * @param companyId the company ID of this appraisal history
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this appraisal history.
	 *
	 * @param createDate the create date of this appraisal history
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the created by of this appraisal history.
	 *
	 * @param createdBy the created by of this appraisal history
	 */
	@Override
	public void setCreatedBy(long createdBy) {
		model.setCreatedBy(createdBy);
	}

	/**
	 * Sets the group ID of this appraisal history.
	 *
	 * @param groupId the group ID of this appraisal history
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified by of this appraisal history.
	 *
	 * @param modifiedBy the modified by of this appraisal history
	 */
	@Override
	public void setModifiedBy(long modifiedBy) {
		model.setModifiedBy(modifiedBy);
	}

	/**
	 * Sets the modified date of this appraisal history.
	 *
	 * @param modifiedDate the modified date of this appraisal history
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this appraisal history.
	 *
	 * @param primaryKey the primary key of this appraisal history
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the rating of this appraisal history.
	 *
	 * @param rating the rating of this appraisal history
	 */
	@Override
	public void setRating(double rating) {
		model.setRating(rating);
	}

	/**
	 * Sets the salary ID of this appraisal history.
	 *
	 * @param salaryId the salary ID of this appraisal history
	 */
	@Override
	public void setSalaryId(long salaryId) {
		model.setSalaryId(salaryId);
	}

	/**
	 * Sets the updated ctc pa of this appraisal history.
	 *
	 * @param updatedCtcPa the updated ctc pa of this appraisal history
	 */
	@Override
	public void setUpdatedCtcPa(double updatedCtcPa) {
		model.setUpdatedCtcPa(updatedCtcPa);
	}

	/**
	 * Sets the updated ctc pm of this appraisal history.
	 *
	 * @param updatedCtcPm the updated ctc pm of this appraisal history
	 */
	@Override
	public void setUpdatedCtcPm(double updatedCtcPm) {
		model.setUpdatedCtcPm(updatedCtcPm);
	}

	/**
	 * Sets the uuid of this appraisal history.
	 *
	 * @param uuid the uuid of this appraisal history
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
	protected AppraisalHistoryWrapper wrap(AppraisalHistory appraisalHistory) {
		return new AppraisalHistoryWrapper(appraisalHistory);
	}

}