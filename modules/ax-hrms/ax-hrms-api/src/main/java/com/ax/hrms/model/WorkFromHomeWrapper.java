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
 * This class is a wrapper for {@link WorkFromHome}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see WorkFromHome
 * @generated
 */
public class WorkFromHomeWrapper
	extends BaseModelWrapper<WorkFromHome>
	implements ModelWrapper<WorkFromHome>, WorkFromHome {

	public WorkFromHomeWrapper(WorkFromHome workFromHome) {
		super(workFromHome);
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
		attributes.put("workFromHomeRequestId", getWorkFromHomeRequestId());
		attributes.put("userId", getUserId());
		attributes.put("reviewerId", getReviewerId());
		attributes.put("teamMailId", getTeamMailId());
		attributes.put("status", getStatus());
		attributes.put("reason", getReason());
		attributes.put("requestDate", getRequestDate());
		attributes.put("startDate", getStartDate());
		attributes.put("endDate", getEndDate());

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

		Long workFromHomeRequestId = (Long)attributes.get(
			"workFromHomeRequestId");

		if (workFromHomeRequestId != null) {
			setWorkFromHomeRequestId(workFromHomeRequestId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Long reviewerId = (Long)attributes.get("reviewerId");

		if (reviewerId != null) {
			setReviewerId(reviewerId);
		}

		String teamMailId = (String)attributes.get("teamMailId");

		if (teamMailId != null) {
			setTeamMailId(teamMailId);
		}

		String status = (String)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		String reason = (String)attributes.get("reason");

		if (reason != null) {
			setReason(reason);
		}

		Date requestDate = (Date)attributes.get("requestDate");

		if (requestDate != null) {
			setRequestDate(requestDate);
		}

		Date startDate = (Date)attributes.get("startDate");

		if (startDate != null) {
			setStartDate(startDate);
		}

		Date endDate = (Date)attributes.get("endDate");

		if (endDate != null) {
			setEndDate(endDate);
		}
	}

	@Override
	public WorkFromHome cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the company ID of this work from home.
	 *
	 * @return the company ID of this work from home
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this work from home.
	 *
	 * @return the create date of this work from home
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the created by of this work from home.
	 *
	 * @return the created by of this work from home
	 */
	@Override
	public long getCreatedBy() {
		return model.getCreatedBy();
	}

	/**
	 * Returns the end date of this work from home.
	 *
	 * @return the end date of this work from home
	 */
	@Override
	public Date getEndDate() {
		return model.getEndDate();
	}

	/**
	 * Returns the group ID of this work from home.
	 *
	 * @return the group ID of this work from home
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified by of this work from home.
	 *
	 * @return the modified by of this work from home
	 */
	@Override
	public long getModifiedBy() {
		return model.getModifiedBy();
	}

	/**
	 * Returns the modified date of this work from home.
	 *
	 * @return the modified date of this work from home
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this work from home.
	 *
	 * @return the primary key of this work from home
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the reason of this work from home.
	 *
	 * @return the reason of this work from home
	 */
	@Override
	public String getReason() {
		return model.getReason();
	}

	/**
	 * Returns the request date of this work from home.
	 *
	 * @return the request date of this work from home
	 */
	@Override
	public Date getRequestDate() {
		return model.getRequestDate();
	}

	/**
	 * Returns the reviewer ID of this work from home.
	 *
	 * @return the reviewer ID of this work from home
	 */
	@Override
	public long getReviewerId() {
		return model.getReviewerId();
	}

	/**
	 * Returns the start date of this work from home.
	 *
	 * @return the start date of this work from home
	 */
	@Override
	public Date getStartDate() {
		return model.getStartDate();
	}

	/**
	 * Returns the status of this work from home.
	 *
	 * @return the status of this work from home
	 */
	@Override
	public String getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the team mail ID of this work from home.
	 *
	 * @return the team mail ID of this work from home
	 */
	@Override
	public String getTeamMailId() {
		return model.getTeamMailId();
	}

	/**
	 * Returns the user ID of this work from home.
	 *
	 * @return the user ID of this work from home
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user uuid of this work from home.
	 *
	 * @return the user uuid of this work from home
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this work from home.
	 *
	 * @return the uuid of this work from home
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns the work from home request ID of this work from home.
	 *
	 * @return the work from home request ID of this work from home
	 */
	@Override
	public long getWorkFromHomeRequestId() {
		return model.getWorkFromHomeRequestId();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the company ID of this work from home.
	 *
	 * @param companyId the company ID of this work from home
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this work from home.
	 *
	 * @param createDate the create date of this work from home
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the created by of this work from home.
	 *
	 * @param createdBy the created by of this work from home
	 */
	@Override
	public void setCreatedBy(long createdBy) {
		model.setCreatedBy(createdBy);
	}

	/**
	 * Sets the end date of this work from home.
	 *
	 * @param endDate the end date of this work from home
	 */
	@Override
	public void setEndDate(Date endDate) {
		model.setEndDate(endDate);
	}

	/**
	 * Sets the group ID of this work from home.
	 *
	 * @param groupId the group ID of this work from home
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified by of this work from home.
	 *
	 * @param modifiedBy the modified by of this work from home
	 */
	@Override
	public void setModifiedBy(long modifiedBy) {
		model.setModifiedBy(modifiedBy);
	}

	/**
	 * Sets the modified date of this work from home.
	 *
	 * @param modifiedDate the modified date of this work from home
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this work from home.
	 *
	 * @param primaryKey the primary key of this work from home
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the reason of this work from home.
	 *
	 * @param reason the reason of this work from home
	 */
	@Override
	public void setReason(String reason) {
		model.setReason(reason);
	}

	/**
	 * Sets the request date of this work from home.
	 *
	 * @param requestDate the request date of this work from home
	 */
	@Override
	public void setRequestDate(Date requestDate) {
		model.setRequestDate(requestDate);
	}

	/**
	 * Sets the reviewer ID of this work from home.
	 *
	 * @param reviewerId the reviewer ID of this work from home
	 */
	@Override
	public void setReviewerId(long reviewerId) {
		model.setReviewerId(reviewerId);
	}

	/**
	 * Sets the start date of this work from home.
	 *
	 * @param startDate the start date of this work from home
	 */
	@Override
	public void setStartDate(Date startDate) {
		model.setStartDate(startDate);
	}

	/**
	 * Sets the status of this work from home.
	 *
	 * @param status the status of this work from home
	 */
	@Override
	public void setStatus(String status) {
		model.setStatus(status);
	}

	/**
	 * Sets the team mail ID of this work from home.
	 *
	 * @param teamMailId the team mail ID of this work from home
	 */
	@Override
	public void setTeamMailId(String teamMailId) {
		model.setTeamMailId(teamMailId);
	}

	/**
	 * Sets the user ID of this work from home.
	 *
	 * @param userId the user ID of this work from home
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user uuid of this work from home.
	 *
	 * @param userUuid the user uuid of this work from home
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this work from home.
	 *
	 * @param uuid the uuid of this work from home
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	/**
	 * Sets the work from home request ID of this work from home.
	 *
	 * @param workFromHomeRequestId the work from home request ID of this work from home
	 */
	@Override
	public void setWorkFromHomeRequestId(long workFromHomeRequestId) {
		model.setWorkFromHomeRequestId(workFromHomeRequestId);
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
	protected WorkFromHomeWrapper wrap(WorkFromHome workFromHome) {
		return new WorkFromHomeWrapper(workFromHome);
	}

}