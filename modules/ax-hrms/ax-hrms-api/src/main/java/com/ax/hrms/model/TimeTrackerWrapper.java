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
 * This class is a wrapper for {@link TimeTracker}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TimeTracker
 * @generated
 */
public class TimeTrackerWrapper
	extends BaseModelWrapper<TimeTracker>
	implements ModelWrapper<TimeTracker>, TimeTracker {

	public TimeTrackerWrapper(TimeTracker timeTracker) {
		super(timeTracker);
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
		attributes.put("timeTrackerId", getTimeTrackerId());
		attributes.put("taskId", getTaskId());
		attributes.put("employeeId", getEmployeeId());
		attributes.put("startTime", getStartTime());
		attributes.put("endTime", getEndTime());
		attributes.put("duration", getDuration());
		attributes.put("description", getDescription());
		attributes.put("managerApproveStatus", getManagerApproveStatus());

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

		Long timeTrackerId = (Long)attributes.get("timeTrackerId");

		if (timeTrackerId != null) {
			setTimeTrackerId(timeTrackerId);
		}

		Long taskId = (Long)attributes.get("taskId");

		if (taskId != null) {
			setTaskId(taskId);
		}

		Long employeeId = (Long)attributes.get("employeeId");

		if (employeeId != null) {
			setEmployeeId(employeeId);
		}

		Date startTime = (Date)attributes.get("startTime");

		if (startTime != null) {
			setStartTime(startTime);
		}

		Date endTime = (Date)attributes.get("endTime");

		if (endTime != null) {
			setEndTime(endTime);
		}

		Double duration = (Double)attributes.get("duration");

		if (duration != null) {
			setDuration(duration);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		String managerApproveStatus = (String)attributes.get(
			"managerApproveStatus");

		if (managerApproveStatus != null) {
			setManagerApproveStatus(managerApproveStatus);
		}
	}

	@Override
	public TimeTracker cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the company ID of this time tracker.
	 *
	 * @return the company ID of this time tracker
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this time tracker.
	 *
	 * @return the create date of this time tracker
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the created by of this time tracker.
	 *
	 * @return the created by of this time tracker
	 */
	@Override
	public long getCreatedBy() {
		return model.getCreatedBy();
	}

	/**
	 * Returns the description of this time tracker.
	 *
	 * @return the description of this time tracker
	 */
	@Override
	public String getDescription() {
		return model.getDescription();
	}

	/**
	 * Returns the duration of this time tracker.
	 *
	 * @return the duration of this time tracker
	 */
	@Override
	public double getDuration() {
		return model.getDuration();
	}

	/**
	 * Returns the employee ID of this time tracker.
	 *
	 * @return the employee ID of this time tracker
	 */
	@Override
	public long getEmployeeId() {
		return model.getEmployeeId();
	}

	/**
	 * Returns the end time of this time tracker.
	 *
	 * @return the end time of this time tracker
	 */
	@Override
	public Date getEndTime() {
		return model.getEndTime();
	}

	/**
	 * Returns the group ID of this time tracker.
	 *
	 * @return the group ID of this time tracker
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the manager approve status of this time tracker.
	 *
	 * @return the manager approve status of this time tracker
	 */
	@Override
	public String getManagerApproveStatus() {
		return model.getManagerApproveStatus();
	}

	/**
	 * Returns the modified by of this time tracker.
	 *
	 * @return the modified by of this time tracker
	 */
	@Override
	public long getModifiedBy() {
		return model.getModifiedBy();
	}

	/**
	 * Returns the modified date of this time tracker.
	 *
	 * @return the modified date of this time tracker
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this time tracker.
	 *
	 * @return the primary key of this time tracker
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the start time of this time tracker.
	 *
	 * @return the start time of this time tracker
	 */
	@Override
	public Date getStartTime() {
		return model.getStartTime();
	}

	/**
	 * Returns the task ID of this time tracker.
	 *
	 * @return the task ID of this time tracker
	 */
	@Override
	public long getTaskId() {
		return model.getTaskId();
	}

	/**
	 * Returns the time tracker ID of this time tracker.
	 *
	 * @return the time tracker ID of this time tracker
	 */
	@Override
	public long getTimeTrackerId() {
		return model.getTimeTrackerId();
	}

	/**
	 * Returns the uuid of this time tracker.
	 *
	 * @return the uuid of this time tracker
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
	 * Sets the company ID of this time tracker.
	 *
	 * @param companyId the company ID of this time tracker
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this time tracker.
	 *
	 * @param createDate the create date of this time tracker
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the created by of this time tracker.
	 *
	 * @param createdBy the created by of this time tracker
	 */
	@Override
	public void setCreatedBy(long createdBy) {
		model.setCreatedBy(createdBy);
	}

	/**
	 * Sets the description of this time tracker.
	 *
	 * @param description the description of this time tracker
	 */
	@Override
	public void setDescription(String description) {
		model.setDescription(description);
	}

	/**
	 * Sets the duration of this time tracker.
	 *
	 * @param duration the duration of this time tracker
	 */
	@Override
	public void setDuration(double duration) {
		model.setDuration(duration);
	}

	/**
	 * Sets the employee ID of this time tracker.
	 *
	 * @param employeeId the employee ID of this time tracker
	 */
	@Override
	public void setEmployeeId(long employeeId) {
		model.setEmployeeId(employeeId);
	}

	/**
	 * Sets the end time of this time tracker.
	 *
	 * @param endTime the end time of this time tracker
	 */
	@Override
	public void setEndTime(Date endTime) {
		model.setEndTime(endTime);
	}

	/**
	 * Sets the group ID of this time tracker.
	 *
	 * @param groupId the group ID of this time tracker
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the manager approve status of this time tracker.
	 *
	 * @param managerApproveStatus the manager approve status of this time tracker
	 */
	@Override
	public void setManagerApproveStatus(String managerApproveStatus) {
		model.setManagerApproveStatus(managerApproveStatus);
	}

	/**
	 * Sets the modified by of this time tracker.
	 *
	 * @param modifiedBy the modified by of this time tracker
	 */
	@Override
	public void setModifiedBy(long modifiedBy) {
		model.setModifiedBy(modifiedBy);
	}

	/**
	 * Sets the modified date of this time tracker.
	 *
	 * @param modifiedDate the modified date of this time tracker
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this time tracker.
	 *
	 * @param primaryKey the primary key of this time tracker
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the start time of this time tracker.
	 *
	 * @param startTime the start time of this time tracker
	 */
	@Override
	public void setStartTime(Date startTime) {
		model.setStartTime(startTime);
	}

	/**
	 * Sets the task ID of this time tracker.
	 *
	 * @param taskId the task ID of this time tracker
	 */
	@Override
	public void setTaskId(long taskId) {
		model.setTaskId(taskId);
	}

	/**
	 * Sets the time tracker ID of this time tracker.
	 *
	 * @param timeTrackerId the time tracker ID of this time tracker
	 */
	@Override
	public void setTimeTrackerId(long timeTrackerId) {
		model.setTimeTrackerId(timeTrackerId);
	}

	/**
	 * Sets the uuid of this time tracker.
	 *
	 * @param uuid the uuid of this time tracker
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
	protected TimeTrackerWrapper wrap(TimeTracker timeTracker) {
		return new TimeTrackerWrapper(timeTracker);
	}

}