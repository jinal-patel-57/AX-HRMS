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
 * This class is a wrapper for {@link ProjectHistory}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProjectHistory
 * @generated
 */
public class ProjectHistoryWrapper
	extends BaseModelWrapper<ProjectHistory>
	implements ModelWrapper<ProjectHistory>, ProjectHistory {

	public ProjectHistoryWrapper(ProjectHistory projectHistory) {
		super(projectHistory);
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
		attributes.put("projectHistoryId", getProjectHistoryId());
		attributes.put("projectId", getProjectId());
		attributes.put(
			"projectTaskStatusMasterId", getProjectTaskStatusMasterId());
		attributes.put("managerId", getManagerId());
		attributes.put("startDate", getStartDate());
		attributes.put("isBillble", isIsBillble());

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

		Long projectHistoryId = (Long)attributes.get("projectHistoryId");

		if (projectHistoryId != null) {
			setProjectHistoryId(projectHistoryId);
		}

		Long projectId = (Long)attributes.get("projectId");

		if (projectId != null) {
			setProjectId(projectId);
		}

		Long projectTaskStatusMasterId = (Long)attributes.get(
			"projectTaskStatusMasterId");

		if (projectTaskStatusMasterId != null) {
			setProjectTaskStatusMasterId(projectTaskStatusMasterId);
		}

		Long managerId = (Long)attributes.get("managerId");

		if (managerId != null) {
			setManagerId(managerId);
		}

		Date startDate = (Date)attributes.get("startDate");

		if (startDate != null) {
			setStartDate(startDate);
		}

		Boolean isBillble = (Boolean)attributes.get("isBillble");

		if (isBillble != null) {
			setIsBillble(isBillble);
		}
	}

	@Override
	public ProjectHistory cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the company ID of this project history.
	 *
	 * @return the company ID of this project history
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this project history.
	 *
	 * @return the create date of this project history
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the created by of this project history.
	 *
	 * @return the created by of this project history
	 */
	@Override
	public long getCreatedBy() {
		return model.getCreatedBy();
	}

	/**
	 * Returns the group ID of this project history.
	 *
	 * @return the group ID of this project history
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the is billble of this project history.
	 *
	 * @return the is billble of this project history
	 */
	@Override
	public boolean getIsBillble() {
		return model.getIsBillble();
	}

	/**
	 * Returns the manager ID of this project history.
	 *
	 * @return the manager ID of this project history
	 */
	@Override
	public long getManagerId() {
		return model.getManagerId();
	}

	/**
	 * Returns the modified by of this project history.
	 *
	 * @return the modified by of this project history
	 */
	@Override
	public long getModifiedBy() {
		return model.getModifiedBy();
	}

	/**
	 * Returns the modified date of this project history.
	 *
	 * @return the modified date of this project history
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this project history.
	 *
	 * @return the primary key of this project history
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the project history ID of this project history.
	 *
	 * @return the project history ID of this project history
	 */
	@Override
	public long getProjectHistoryId() {
		return model.getProjectHistoryId();
	}

	/**
	 * Returns the project ID of this project history.
	 *
	 * @return the project ID of this project history
	 */
	@Override
	public long getProjectId() {
		return model.getProjectId();
	}

	/**
	 * Returns the project task status master ID of this project history.
	 *
	 * @return the project task status master ID of this project history
	 */
	@Override
	public long getProjectTaskStatusMasterId() {
		return model.getProjectTaskStatusMasterId();
	}

	/**
	 * Returns the start date of this project history.
	 *
	 * @return the start date of this project history
	 */
	@Override
	public Date getStartDate() {
		return model.getStartDate();
	}

	/**
	 * Returns the uuid of this project history.
	 *
	 * @return the uuid of this project history
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns <code>true</code> if this project history is is billble.
	 *
	 * @return <code>true</code> if this project history is is billble; <code>false</code> otherwise
	 */
	@Override
	public boolean isIsBillble() {
		return model.isIsBillble();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the company ID of this project history.
	 *
	 * @param companyId the company ID of this project history
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this project history.
	 *
	 * @param createDate the create date of this project history
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the created by of this project history.
	 *
	 * @param createdBy the created by of this project history
	 */
	@Override
	public void setCreatedBy(long createdBy) {
		model.setCreatedBy(createdBy);
	}

	/**
	 * Sets the group ID of this project history.
	 *
	 * @param groupId the group ID of this project history
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets whether this project history is is billble.
	 *
	 * @param isBillble the is billble of this project history
	 */
	@Override
	public void setIsBillble(boolean isBillble) {
		model.setIsBillble(isBillble);
	}

	/**
	 * Sets the manager ID of this project history.
	 *
	 * @param managerId the manager ID of this project history
	 */
	@Override
	public void setManagerId(long managerId) {
		model.setManagerId(managerId);
	}

	/**
	 * Sets the modified by of this project history.
	 *
	 * @param modifiedBy the modified by of this project history
	 */
	@Override
	public void setModifiedBy(long modifiedBy) {
		model.setModifiedBy(modifiedBy);
	}

	/**
	 * Sets the modified date of this project history.
	 *
	 * @param modifiedDate the modified date of this project history
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this project history.
	 *
	 * @param primaryKey the primary key of this project history
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the project history ID of this project history.
	 *
	 * @param projectHistoryId the project history ID of this project history
	 */
	@Override
	public void setProjectHistoryId(long projectHistoryId) {
		model.setProjectHistoryId(projectHistoryId);
	}

	/**
	 * Sets the project ID of this project history.
	 *
	 * @param projectId the project ID of this project history
	 */
	@Override
	public void setProjectId(long projectId) {
		model.setProjectId(projectId);
	}

	/**
	 * Sets the project task status master ID of this project history.
	 *
	 * @param projectTaskStatusMasterId the project task status master ID of this project history
	 */
	@Override
	public void setProjectTaskStatusMasterId(long projectTaskStatusMasterId) {
		model.setProjectTaskStatusMasterId(projectTaskStatusMasterId);
	}

	/**
	 * Sets the start date of this project history.
	 *
	 * @param startDate the start date of this project history
	 */
	@Override
	public void setStartDate(Date startDate) {
		model.setStartDate(startDate);
	}

	/**
	 * Sets the uuid of this project history.
	 *
	 * @param uuid the uuid of this project history
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
	protected ProjectHistoryWrapper wrap(ProjectHistory projectHistory) {
		return new ProjectHistoryWrapper(projectHistory);
	}

}