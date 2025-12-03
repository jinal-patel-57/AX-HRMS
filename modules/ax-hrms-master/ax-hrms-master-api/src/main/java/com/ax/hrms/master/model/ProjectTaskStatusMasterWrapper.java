/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.master.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link ProjectTaskStatusMaster}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProjectTaskStatusMaster
 * @generated
 */
public class ProjectTaskStatusMasterWrapper
	extends BaseModelWrapper<ProjectTaskStatusMaster>
	implements ModelWrapper<ProjectTaskStatusMaster>, ProjectTaskStatusMaster {

	public ProjectTaskStatusMasterWrapper(
		ProjectTaskStatusMaster projectTaskStatusMaster) {

		super(projectTaskStatusMaster);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put(
			"projectTaskStatusMasterId", getProjectTaskStatusMasterId());
		attributes.put("companyId", getCompanyId());
		attributes.put("createdBy", getCreatedBy());
		attributes.put("modifiedBy", getModifiedBy());
		attributes.put("groupId", getGroupId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("projectTaskStatusName", getProjectTaskStatusName());
		attributes.put("isApplicableForProject", isIsApplicableForProject());
		attributes.put("isApplicableForTask", isIsApplicableForTask());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long projectTaskStatusMasterId = (Long)attributes.get(
			"projectTaskStatusMasterId");

		if (projectTaskStatusMasterId != null) {
			setProjectTaskStatusMasterId(projectTaskStatusMasterId);
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

		String projectTaskStatusName = (String)attributes.get(
			"projectTaskStatusName");

		if (projectTaskStatusName != null) {
			setProjectTaskStatusName(projectTaskStatusName);
		}

		Boolean isApplicableForProject = (Boolean)attributes.get(
			"isApplicableForProject");

		if (isApplicableForProject != null) {
			setIsApplicableForProject(isApplicableForProject);
		}

		Boolean isApplicableForTask = (Boolean)attributes.get(
			"isApplicableForTask");

		if (isApplicableForTask != null) {
			setIsApplicableForTask(isApplicableForTask);
		}
	}

	@Override
	public ProjectTaskStatusMaster cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the company ID of this project task status master.
	 *
	 * @return the company ID of this project task status master
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this project task status master.
	 *
	 * @return the create date of this project task status master
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the created by of this project task status master.
	 *
	 * @return the created by of this project task status master
	 */
	@Override
	public long getCreatedBy() {
		return model.getCreatedBy();
	}

	/**
	 * Returns the group ID of this project task status master.
	 *
	 * @return the group ID of this project task status master
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the is applicable for project of this project task status master.
	 *
	 * @return the is applicable for project of this project task status master
	 */
	@Override
	public boolean getIsApplicableForProject() {
		return model.getIsApplicableForProject();
	}

	/**
	 * Returns the is applicable for task of this project task status master.
	 *
	 * @return the is applicable for task of this project task status master
	 */
	@Override
	public boolean getIsApplicableForTask() {
		return model.getIsApplicableForTask();
	}

	/**
	 * Returns the modified by of this project task status master.
	 *
	 * @return the modified by of this project task status master
	 */
	@Override
	public long getModifiedBy() {
		return model.getModifiedBy();
	}

	/**
	 * Returns the modified date of this project task status master.
	 *
	 * @return the modified date of this project task status master
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this project task status master.
	 *
	 * @return the primary key of this project task status master
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the project task status master ID of this project task status master.
	 *
	 * @return the project task status master ID of this project task status master
	 */
	@Override
	public long getProjectTaskStatusMasterId() {
		return model.getProjectTaskStatusMasterId();
	}

	/**
	 * Returns the project task status name of this project task status master.
	 *
	 * @return the project task status name of this project task status master
	 */
	@Override
	public String getProjectTaskStatusName() {
		return model.getProjectTaskStatusName();
	}

	/**
	 * Returns <code>true</code> if this project task status master is is applicable for project.
	 *
	 * @return <code>true</code> if this project task status master is is applicable for project; <code>false</code> otherwise
	 */
	@Override
	public boolean isIsApplicableForProject() {
		return model.isIsApplicableForProject();
	}

	/**
	 * Returns <code>true</code> if this project task status master is is applicable for task.
	 *
	 * @return <code>true</code> if this project task status master is is applicable for task; <code>false</code> otherwise
	 */
	@Override
	public boolean isIsApplicableForTask() {
		return model.isIsApplicableForTask();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the company ID of this project task status master.
	 *
	 * @param companyId the company ID of this project task status master
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this project task status master.
	 *
	 * @param createDate the create date of this project task status master
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the created by of this project task status master.
	 *
	 * @param createdBy the created by of this project task status master
	 */
	@Override
	public void setCreatedBy(long createdBy) {
		model.setCreatedBy(createdBy);
	}

	/**
	 * Sets the group ID of this project task status master.
	 *
	 * @param groupId the group ID of this project task status master
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets whether this project task status master is is applicable for project.
	 *
	 * @param isApplicableForProject the is applicable for project of this project task status master
	 */
	@Override
	public void setIsApplicableForProject(boolean isApplicableForProject) {
		model.setIsApplicableForProject(isApplicableForProject);
	}

	/**
	 * Sets whether this project task status master is is applicable for task.
	 *
	 * @param isApplicableForTask the is applicable for task of this project task status master
	 */
	@Override
	public void setIsApplicableForTask(boolean isApplicableForTask) {
		model.setIsApplicableForTask(isApplicableForTask);
	}

	/**
	 * Sets the modified by of this project task status master.
	 *
	 * @param modifiedBy the modified by of this project task status master
	 */
	@Override
	public void setModifiedBy(long modifiedBy) {
		model.setModifiedBy(modifiedBy);
	}

	/**
	 * Sets the modified date of this project task status master.
	 *
	 * @param modifiedDate the modified date of this project task status master
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this project task status master.
	 *
	 * @param primaryKey the primary key of this project task status master
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the project task status master ID of this project task status master.
	 *
	 * @param projectTaskStatusMasterId the project task status master ID of this project task status master
	 */
	@Override
	public void setProjectTaskStatusMasterId(long projectTaskStatusMasterId) {
		model.setProjectTaskStatusMasterId(projectTaskStatusMasterId);
	}

	/**
	 * Sets the project task status name of this project task status master.
	 *
	 * @param projectTaskStatusName the project task status name of this project task status master
	 */
	@Override
	public void setProjectTaskStatusName(String projectTaskStatusName) {
		model.setProjectTaskStatusName(projectTaskStatusName);
	}

	@Override
	public String toXmlString() {
		return model.toXmlString();
	}

	@Override
	protected ProjectTaskStatusMasterWrapper wrap(
		ProjectTaskStatusMaster projectTaskStatusMaster) {

		return new ProjectTaskStatusMasterWrapper(projectTaskStatusMaster);
	}

}