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
 * This class is a wrapper for {@link TaskReview}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TaskReview
 * @generated
 */
public class TaskReviewWrapper
	extends BaseModelWrapper<TaskReview>
	implements ModelWrapper<TaskReview>, TaskReview {

	public TaskReviewWrapper(TaskReview taskReview) {
		super(taskReview);
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
		attributes.put("taskReviewId", getTaskReviewId());
		attributes.put("taskId", getTaskId());
		attributes.put("reviewerId", getReviewerId());
		attributes.put("review", getReview());
		attributes.put("dateOfReview", getDateOfReview());

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

		Long taskReviewId = (Long)attributes.get("taskReviewId");

		if (taskReviewId != null) {
			setTaskReviewId(taskReviewId);
		}

		Long taskId = (Long)attributes.get("taskId");

		if (taskId != null) {
			setTaskId(taskId);
		}

		Long reviewerId = (Long)attributes.get("reviewerId");

		if (reviewerId != null) {
			setReviewerId(reviewerId);
		}

		String review = (String)attributes.get("review");

		if (review != null) {
			setReview(review);
		}

		Date dateOfReview = (Date)attributes.get("dateOfReview");

		if (dateOfReview != null) {
			setDateOfReview(dateOfReview);
		}
	}

	@Override
	public TaskReview cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the company ID of this task review.
	 *
	 * @return the company ID of this task review
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this task review.
	 *
	 * @return the create date of this task review
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the created by of this task review.
	 *
	 * @return the created by of this task review
	 */
	@Override
	public long getCreatedBy() {
		return model.getCreatedBy();
	}

	/**
	 * Returns the date of review of this task review.
	 *
	 * @return the date of review of this task review
	 */
	@Override
	public Date getDateOfReview() {
		return model.getDateOfReview();
	}

	/**
	 * Returns the group ID of this task review.
	 *
	 * @return the group ID of this task review
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified by of this task review.
	 *
	 * @return the modified by of this task review
	 */
	@Override
	public long getModifiedBy() {
		return model.getModifiedBy();
	}

	/**
	 * Returns the modified date of this task review.
	 *
	 * @return the modified date of this task review
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this task review.
	 *
	 * @return the primary key of this task review
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the review of this task review.
	 *
	 * @return the review of this task review
	 */
	@Override
	public String getReview() {
		return model.getReview();
	}

	/**
	 * Returns the reviewer ID of this task review.
	 *
	 * @return the reviewer ID of this task review
	 */
	@Override
	public long getReviewerId() {
		return model.getReviewerId();
	}

	/**
	 * Returns the task ID of this task review.
	 *
	 * @return the task ID of this task review
	 */
	@Override
	public long getTaskId() {
		return model.getTaskId();
	}

	/**
	 * Returns the task review ID of this task review.
	 *
	 * @return the task review ID of this task review
	 */
	@Override
	public long getTaskReviewId() {
		return model.getTaskReviewId();
	}

	/**
	 * Returns the uuid of this task review.
	 *
	 * @return the uuid of this task review
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
	 * Sets the company ID of this task review.
	 *
	 * @param companyId the company ID of this task review
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this task review.
	 *
	 * @param createDate the create date of this task review
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the created by of this task review.
	 *
	 * @param createdBy the created by of this task review
	 */
	@Override
	public void setCreatedBy(long createdBy) {
		model.setCreatedBy(createdBy);
	}

	/**
	 * Sets the date of review of this task review.
	 *
	 * @param dateOfReview the date of review of this task review
	 */
	@Override
	public void setDateOfReview(Date dateOfReview) {
		model.setDateOfReview(dateOfReview);
	}

	/**
	 * Sets the group ID of this task review.
	 *
	 * @param groupId the group ID of this task review
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified by of this task review.
	 *
	 * @param modifiedBy the modified by of this task review
	 */
	@Override
	public void setModifiedBy(long modifiedBy) {
		model.setModifiedBy(modifiedBy);
	}

	/**
	 * Sets the modified date of this task review.
	 *
	 * @param modifiedDate the modified date of this task review
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this task review.
	 *
	 * @param primaryKey the primary key of this task review
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the review of this task review.
	 *
	 * @param review the review of this task review
	 */
	@Override
	public void setReview(String review) {
		model.setReview(review);
	}

	/**
	 * Sets the reviewer ID of this task review.
	 *
	 * @param reviewerId the reviewer ID of this task review
	 */
	@Override
	public void setReviewerId(long reviewerId) {
		model.setReviewerId(reviewerId);
	}

	/**
	 * Sets the task ID of this task review.
	 *
	 * @param taskId the task ID of this task review
	 */
	@Override
	public void setTaskId(long taskId) {
		model.setTaskId(taskId);
	}

	/**
	 * Sets the task review ID of this task review.
	 *
	 * @param taskReviewId the task review ID of this task review
	 */
	@Override
	public void setTaskReviewId(long taskReviewId) {
		model.setTaskReviewId(taskReviewId);
	}

	/**
	 * Sets the uuid of this task review.
	 *
	 * @param uuid the uuid of this task review
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
	protected TaskReviewWrapper wrap(TaskReview taskReview) {
		return new TaskReviewWrapper(taskReview);
	}

}