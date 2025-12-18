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
 * This class is a wrapper for {@link WorkFromHomeRequest}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see WorkFromHomeRequest
 * @generated
 */
public class WorkFromHomeRequestWrapper
	extends BaseModelWrapper<WorkFromHomeRequest>
	implements ModelWrapper<WorkFromHomeRequest>, WorkFromHomeRequest {

	public WorkFromHomeRequestWrapper(WorkFromHomeRequest workFromHomeRequest) {
		super(workFromHomeRequest);
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
		attributes.put("employeeId", getEmployeeId());
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

		Long employeeId = (Long)attributes.get("employeeId");

		if (employeeId != null) {
			setEmployeeId(employeeId);
		}

		Long reviewerId = (Long)attributes.get("reviewerId");

		if (reviewerId != null) {
			setReviewerId(reviewerId);
		}

		String teamMailId = (String)attributes.get("teamMailId");

		if (teamMailId != null) {
			setTeamMailId(teamMailId);
		}

		Long status = (Long)attributes.get("status");

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
	public WorkFromHomeRequest cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the company ID of this work from home request.
	 *
	 * @return the company ID of this work from home request
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this work from home request.
	 *
	 * @return the create date of this work from home request
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the created by of this work from home request.
	 *
	 * @return the created by of this work from home request
	 */
	@Override
	public long getCreatedBy() {
		return model.getCreatedBy();
	}

	/**
	 * Returns the employee ID of this work from home request.
	 *
	 * @return the employee ID of this work from home request
	 */
	@Override
	public long getEmployeeId() {
		return model.getEmployeeId();
	}

	/**
	 * Returns the end date of this work from home request.
	 *
	 * @return the end date of this work from home request
	 */
	@Override
	public Date getEndDate() {
		return model.getEndDate();
	}

	/**
	 * Returns the group ID of this work from home request.
	 *
	 * @return the group ID of this work from home request
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified by of this work from home request.
	 *
	 * @return the modified by of this work from home request
	 */
	@Override
	public long getModifiedBy() {
		return model.getModifiedBy();
	}

	/**
	 * Returns the modified date of this work from home request.
	 *
	 * @return the modified date of this work from home request
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this work from home request.
	 *
	 * @return the primary key of this work from home request
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the reason of this work from home request.
	 *
	 * @return the reason of this work from home request
	 */
	@Override
	public String getReason() {
		return model.getReason();
	}

	/**
	 * Returns the request date of this work from home request.
	 *
	 * @return the request date of this work from home request
	 */
	@Override
	public Date getRequestDate() {
		return model.getRequestDate();
	}

	/**
	 * Returns the reviewer ID of this work from home request.
	 *
	 * @return the reviewer ID of this work from home request
	 */
	@Override
	public long getReviewerId() {
		return model.getReviewerId();
	}

	/**
	 * Returns the start date of this work from home request.
	 *
	 * @return the start date of this work from home request
	 */
	@Override
	public Date getStartDate() {
		return model.getStartDate();
	}

	/**
	 * Returns the status of this work from home request.
	 *
	 * @return the status of this work from home request
	 */
	@Override
	public long getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the team mail ID of this work from home request.
	 *
	 * @return the team mail ID of this work from home request
	 */
	@Override
	public String getTeamMailId() {
		return model.getTeamMailId();
	}

	/**
	 * Returns the uuid of this work from home request.
	 *
	 * @return the uuid of this work from home request
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns the work from home request ID of this work from home request.
	 *
	 * @return the work from home request ID of this work from home request
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
	 * Sets the company ID of this work from home request.
	 *
	 * @param companyId the company ID of this work from home request
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this work from home request.
	 *
	 * @param createDate the create date of this work from home request
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the created by of this work from home request.
	 *
	 * @param createdBy the created by of this work from home request
	 */
	@Override
	public void setCreatedBy(long createdBy) {
		model.setCreatedBy(createdBy);
	}

	/**
	 * Sets the employee ID of this work from home request.
	 *
	 * @param employeeId the employee ID of this work from home request
	 */
	@Override
	public void setEmployeeId(long employeeId) {
		model.setEmployeeId(employeeId);
	}

	/**
	 * Sets the end date of this work from home request.
	 *
	 * @param endDate the end date of this work from home request
	 */
	@Override
	public void setEndDate(Date endDate) {
		model.setEndDate(endDate);
	}

	/**
	 * Sets the group ID of this work from home request.
	 *
	 * @param groupId the group ID of this work from home request
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified by of this work from home request.
	 *
	 * @param modifiedBy the modified by of this work from home request
	 */
	@Override
	public void setModifiedBy(long modifiedBy) {
		model.setModifiedBy(modifiedBy);
	}

	/**
	 * Sets the modified date of this work from home request.
	 *
	 * @param modifiedDate the modified date of this work from home request
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this work from home request.
	 *
	 * @param primaryKey the primary key of this work from home request
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the reason of this work from home request.
	 *
	 * @param reason the reason of this work from home request
	 */
	@Override
	public void setReason(String reason) {
		model.setReason(reason);
	}

	/**
	 * Sets the request date of this work from home request.
	 *
	 * @param requestDate the request date of this work from home request
	 */
	@Override
	public void setRequestDate(Date requestDate) {
		model.setRequestDate(requestDate);
	}

	/**
	 * Sets the reviewer ID of this work from home request.
	 *
	 * @param reviewerId the reviewer ID of this work from home request
	 */
	@Override
	public void setReviewerId(long reviewerId) {
		model.setReviewerId(reviewerId);
	}

	/**
	 * Sets the start date of this work from home request.
	 *
	 * @param startDate the start date of this work from home request
	 */
	@Override
	public void setStartDate(Date startDate) {
		model.setStartDate(startDate);
	}

	/**
	 * Sets the status of this work from home request.
	 *
	 * @param status the status of this work from home request
	 */
	@Override
	public void setStatus(long status) {
		model.setStatus(status);
	}

	/**
	 * Sets the team mail ID of this work from home request.
	 *
	 * @param teamMailId the team mail ID of this work from home request
	 */
	@Override
	public void setTeamMailId(String teamMailId) {
		model.setTeamMailId(teamMailId);
	}

	/**
	 * Sets the uuid of this work from home request.
	 *
	 * @param uuid the uuid of this work from home request
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	/**
	 * Sets the work from home request ID of this work from home request.
	 *
	 * @param workFromHomeRequestId the work from home request ID of this work from home request
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
	protected WorkFromHomeRequestWrapper wrap(
		WorkFromHomeRequest workFromHomeRequest) {

		return new WorkFromHomeRequestWrapper(workFromHomeRequest);
	}

}