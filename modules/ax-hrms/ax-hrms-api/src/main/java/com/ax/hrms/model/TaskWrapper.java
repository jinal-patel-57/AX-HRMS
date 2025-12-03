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
 * This class is a wrapper for {@link Task}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Task
 * @generated
 */
public class TaskWrapper
	extends BaseModelWrapper<Task> implements ModelWrapper<Task>, Task {

	public TaskWrapper(Task task) {
		super(task);
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
		attributes.put("taskId", getTaskId());
		attributes.put("taskName", getTaskName());
		attributes.put("description", getDescription());
		attributes.put("projectId", getProjectId());
		attributes.put("mainTaskId", getMainTaskId());
		attributes.put("assignedTo", getAssignedTo());
		attributes.put(
			"projectTaskStatusMasterId", getProjectTaskStatusMasterId());
		attributes.put("priorityMasterId", getPriorityMasterId());
		attributes.put("estimatedHours", getEstimatedHours());
		attributes.put("managerId", getManagerId());
		attributes.put("assignDate", getAssignDate());
		attributes.put("startDate", getStartDate());
		attributes.put("dueDate", getDueDate());
		attributes.put("completeDate", getCompleteDate());
		attributes.put("isBillble", isIsBillble());
		attributes.put("isSubTask", isIsSubTask());

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

		Long taskId = (Long)attributes.get("taskId");

		if (taskId != null) {
			setTaskId(taskId);
		}

		String taskName = (String)attributes.get("taskName");

		if (taskName != null) {
			setTaskName(taskName);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		Long projectId = (Long)attributes.get("projectId");

		if (projectId != null) {
			setProjectId(projectId);
		}

		Long mainTaskId = (Long)attributes.get("mainTaskId");

		if (mainTaskId != null) {
			setMainTaskId(mainTaskId);
		}

		Long assignedTo = (Long)attributes.get("assignedTo");

		if (assignedTo != null) {
			setAssignedTo(assignedTo);
		}

		Long projectTaskStatusMasterId = (Long)attributes.get(
			"projectTaskStatusMasterId");

		if (projectTaskStatusMasterId != null) {
			setProjectTaskStatusMasterId(projectTaskStatusMasterId);
		}

		Long priorityMasterId = (Long)attributes.get("priorityMasterId");

		if (priorityMasterId != null) {
			setPriorityMasterId(priorityMasterId);
		}

		Integer estimatedHours = (Integer)attributes.get("estimatedHours");

		if (estimatedHours != null) {
			setEstimatedHours(estimatedHours);
		}

		Long managerId = (Long)attributes.get("managerId");

		if (managerId != null) {
			setManagerId(managerId);
		}

		Date assignDate = (Date)attributes.get("assignDate");

		if (assignDate != null) {
			setAssignDate(assignDate);
		}

		Date startDate = (Date)attributes.get("startDate");

		if (startDate != null) {
			setStartDate(startDate);
		}

		Date dueDate = (Date)attributes.get("dueDate");

		if (dueDate != null) {
			setDueDate(dueDate);
		}

		Date completeDate = (Date)attributes.get("completeDate");

		if (completeDate != null) {
			setCompleteDate(completeDate);
		}

		Boolean isBillble = (Boolean)attributes.get("isBillble");

		if (isBillble != null) {
			setIsBillble(isBillble);
		}

		Boolean isSubTask = (Boolean)attributes.get("isSubTask");

		if (isSubTask != null) {
			setIsSubTask(isSubTask);
		}
	}

	@Override
	public Task cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the assign date of this task.
	 *
	 * @return the assign date of this task
	 */
	@Override
	public Date getAssignDate() {
		return model.getAssignDate();
	}

	/**
	 * Returns the assigned to of this task.
	 *
	 * @return the assigned to of this task
	 */
	@Override
	public long getAssignedTo() {
		return model.getAssignedTo();
	}

	/**
	 * Returns the company ID of this task.
	 *
	 * @return the company ID of this task
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the complete date of this task.
	 *
	 * @return the complete date of this task
	 */
	@Override
	public Date getCompleteDate() {
		return model.getCompleteDate();
	}

	/**
	 * Returns the create date of this task.
	 *
	 * @return the create date of this task
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the created by of this task.
	 *
	 * @return the created by of this task
	 */
	@Override
	public long getCreatedBy() {
		return model.getCreatedBy();
	}

	/**
	 * Returns the description of this task.
	 *
	 * @return the description of this task
	 */
	@Override
	public String getDescription() {
		return model.getDescription();
	}

	/**
	 * Returns the due date of this task.
	 *
	 * @return the due date of this task
	 */
	@Override
	public Date getDueDate() {
		return model.getDueDate();
	}

	/**
	 * Returns the estimated hours of this task.
	 *
	 * @return the estimated hours of this task
	 */
	@Override
	public int getEstimatedHours() {
		return model.getEstimatedHours();
	}

	/**
	 * Returns the group ID of this task.
	 *
	 * @return the group ID of this task
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the is billble of this task.
	 *
	 * @return the is billble of this task
	 */
	@Override
	public boolean getIsBillble() {
		return model.getIsBillble();
	}

	/**
	 * Returns the is sub task of this task.
	 *
	 * @return the is sub task of this task
	 */
	@Override
	public boolean getIsSubTask() {
		return model.getIsSubTask();
	}

	/**
	 * Returns the main task ID of this task.
	 *
	 * @return the main task ID of this task
	 */
	@Override
	public long getMainTaskId() {
		return model.getMainTaskId();
	}

	/**
	 * Returns the manager ID of this task.
	 *
	 * @return the manager ID of this task
	 */
	@Override
	public long getManagerId() {
		return model.getManagerId();
	}

	/**
	 * Returns the modified by of this task.
	 *
	 * @return the modified by of this task
	 */
	@Override
	public long getModifiedBy() {
		return model.getModifiedBy();
	}

	/**
	 * Returns the modified date of this task.
	 *
	 * @return the modified date of this task
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this task.
	 *
	 * @return the primary key of this task
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the priority master ID of this task.
	 *
	 * @return the priority master ID of this task
	 */
	@Override
	public long getPriorityMasterId() {
		return model.getPriorityMasterId();
	}

	/**
	 * Returns the project ID of this task.
	 *
	 * @return the project ID of this task
	 */
	@Override
	public long getProjectId() {
		return model.getProjectId();
	}

	/**
	 * Returns the project task status master ID of this task.
	 *
	 * @return the project task status master ID of this task
	 */
	@Override
	public long getProjectTaskStatusMasterId() {
		return model.getProjectTaskStatusMasterId();
	}

	/**
	 * Returns the start date of this task.
	 *
	 * @return the start date of this task
	 */
	@Override
	public Date getStartDate() {
		return model.getStartDate();
	}

	/**
	 * Returns the task ID of this task.
	 *
	 * @return the task ID of this task
	 */
	@Override
	public long getTaskId() {
		return model.getTaskId();
	}

	/**
	 * Returns the task name of this task.
	 *
	 * @return the task name of this task
	 */
	@Override
	public String getTaskName() {
		return model.getTaskName();
	}

	/**
	 * Returns the uuid of this task.
	 *
	 * @return the uuid of this task
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns <code>true</code> if this task is is billble.
	 *
	 * @return <code>true</code> if this task is is billble; <code>false</code> otherwise
	 */
	@Override
	public boolean isIsBillble() {
		return model.isIsBillble();
	}

	/**
	 * Returns <code>true</code> if this task is is sub task.
	 *
	 * @return <code>true</code> if this task is is sub task; <code>false</code> otherwise
	 */
	@Override
	public boolean isIsSubTask() {
		return model.isIsSubTask();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the assign date of this task.
	 *
	 * @param assignDate the assign date of this task
	 */
	@Override
	public void setAssignDate(Date assignDate) {
		model.setAssignDate(assignDate);
	}

	/**
	 * Sets the assigned to of this task.
	 *
	 * @param assignedTo the assigned to of this task
	 */
	@Override
	public void setAssignedTo(long assignedTo) {
		model.setAssignedTo(assignedTo);
	}

	/**
	 * Sets the company ID of this task.
	 *
	 * @param companyId the company ID of this task
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the complete date of this task.
	 *
	 * @param completeDate the complete date of this task
	 */
	@Override
	public void setCompleteDate(Date completeDate) {
		model.setCompleteDate(completeDate);
	}

	/**
	 * Sets the create date of this task.
	 *
	 * @param createDate the create date of this task
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the created by of this task.
	 *
	 * @param createdBy the created by of this task
	 */
	@Override
	public void setCreatedBy(long createdBy) {
		model.setCreatedBy(createdBy);
	}

	/**
	 * Sets the description of this task.
	 *
	 * @param description the description of this task
	 */
	@Override
	public void setDescription(String description) {
		model.setDescription(description);
	}

	/**
	 * Sets the due date of this task.
	 *
	 * @param dueDate the due date of this task
	 */
	@Override
	public void setDueDate(Date dueDate) {
		model.setDueDate(dueDate);
	}

	/**
	 * Sets the estimated hours of this task.
	 *
	 * @param estimatedHours the estimated hours of this task
	 */
	@Override
	public void setEstimatedHours(int estimatedHours) {
		model.setEstimatedHours(estimatedHours);
	}

	/**
	 * Sets the group ID of this task.
	 *
	 * @param groupId the group ID of this task
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets whether this task is is billble.
	 *
	 * @param isBillble the is billble of this task
	 */
	@Override
	public void setIsBillble(boolean isBillble) {
		model.setIsBillble(isBillble);
	}

	/**
	 * Sets whether this task is is sub task.
	 *
	 * @param isSubTask the is sub task of this task
	 */
	@Override
	public void setIsSubTask(boolean isSubTask) {
		model.setIsSubTask(isSubTask);
	}

	/**
	 * Sets the main task ID of this task.
	 *
	 * @param mainTaskId the main task ID of this task
	 */
	@Override
	public void setMainTaskId(long mainTaskId) {
		model.setMainTaskId(mainTaskId);
	}

	/**
	 * Sets the manager ID of this task.
	 *
	 * @param managerId the manager ID of this task
	 */
	@Override
	public void setManagerId(long managerId) {
		model.setManagerId(managerId);
	}

	/**
	 * Sets the modified by of this task.
	 *
	 * @param modifiedBy the modified by of this task
	 */
	@Override
	public void setModifiedBy(long modifiedBy) {
		model.setModifiedBy(modifiedBy);
	}

	/**
	 * Sets the modified date of this task.
	 *
	 * @param modifiedDate the modified date of this task
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this task.
	 *
	 * @param primaryKey the primary key of this task
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the priority master ID of this task.
	 *
	 * @param priorityMasterId the priority master ID of this task
	 */
	@Override
	public void setPriorityMasterId(long priorityMasterId) {
		model.setPriorityMasterId(priorityMasterId);
	}

	/**
	 * Sets the project ID of this task.
	 *
	 * @param projectId the project ID of this task
	 */
	@Override
	public void setProjectId(long projectId) {
		model.setProjectId(projectId);
	}

	/**
	 * Sets the project task status master ID of this task.
	 *
	 * @param projectTaskStatusMasterId the project task status master ID of this task
	 */
	@Override
	public void setProjectTaskStatusMasterId(long projectTaskStatusMasterId) {
		model.setProjectTaskStatusMasterId(projectTaskStatusMasterId);
	}

	/**
	 * Sets the start date of this task.
	 *
	 * @param startDate the start date of this task
	 */
	@Override
	public void setStartDate(Date startDate) {
		model.setStartDate(startDate);
	}

	/**
	 * Sets the task ID of this task.
	 *
	 * @param taskId the task ID of this task
	 */
	@Override
	public void setTaskId(long taskId) {
		model.setTaskId(taskId);
	}

	/**
	 * Sets the task name of this task.
	 *
	 * @param taskName the task name of this task
	 */
	@Override
	public void setTaskName(String taskName) {
		model.setTaskName(taskName);
	}

	/**
	 * Sets the uuid of this task.
	 *
	 * @param uuid the uuid of this task
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
	protected TaskWrapper wrap(Task task) {
		return new TaskWrapper(task);
	}

}