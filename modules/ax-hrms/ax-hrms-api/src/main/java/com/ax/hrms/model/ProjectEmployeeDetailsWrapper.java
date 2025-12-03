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
 * This class is a wrapper for {@link ProjectEmployeeDetails}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProjectEmployeeDetails
 * @generated
 */
public class ProjectEmployeeDetailsWrapper
	extends BaseModelWrapper<ProjectEmployeeDetails>
	implements ModelWrapper<ProjectEmployeeDetails>, ProjectEmployeeDetails {

	public ProjectEmployeeDetailsWrapper(
		ProjectEmployeeDetails projectEmployeeDetails) {

		super(projectEmployeeDetails);
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
			"projectEmployeeDetailsId", getProjectEmployeeDetailsId());
		attributes.put("projectId", getProjectId());
		attributes.put("employeeId", getEmployeeId());

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

		Long projectEmployeeDetailsId = (Long)attributes.get(
			"projectEmployeeDetailsId");

		if (projectEmployeeDetailsId != null) {
			setProjectEmployeeDetailsId(projectEmployeeDetailsId);
		}

		Long projectId = (Long)attributes.get("projectId");

		if (projectId != null) {
			setProjectId(projectId);
		}

		Long employeeId = (Long)attributes.get("employeeId");

		if (employeeId != null) {
			setEmployeeId(employeeId);
		}
	}

	@Override
	public ProjectEmployeeDetails cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the company ID of this project employee details.
	 *
	 * @return the company ID of this project employee details
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this project employee details.
	 *
	 * @return the create date of this project employee details
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the created by of this project employee details.
	 *
	 * @return the created by of this project employee details
	 */
	@Override
	public long getCreatedBy() {
		return model.getCreatedBy();
	}

	/**
	 * Returns the employee ID of this project employee details.
	 *
	 * @return the employee ID of this project employee details
	 */
	@Override
	public long getEmployeeId() {
		return model.getEmployeeId();
	}

	/**
	 * Returns the group ID of this project employee details.
	 *
	 * @return the group ID of this project employee details
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified by of this project employee details.
	 *
	 * @return the modified by of this project employee details
	 */
	@Override
	public long getModifiedBy() {
		return model.getModifiedBy();
	}

	/**
	 * Returns the modified date of this project employee details.
	 *
	 * @return the modified date of this project employee details
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this project employee details.
	 *
	 * @return the primary key of this project employee details
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the project employee details ID of this project employee details.
	 *
	 * @return the project employee details ID of this project employee details
	 */
	@Override
	public long getProjectEmployeeDetailsId() {
		return model.getProjectEmployeeDetailsId();
	}

	/**
	 * Returns the project ID of this project employee details.
	 *
	 * @return the project ID of this project employee details
	 */
	@Override
	public long getProjectId() {
		return model.getProjectId();
	}

	/**
	 * Returns the uuid of this project employee details.
	 *
	 * @return the uuid of this project employee details
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
	 * Sets the company ID of this project employee details.
	 *
	 * @param companyId the company ID of this project employee details
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this project employee details.
	 *
	 * @param createDate the create date of this project employee details
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the created by of this project employee details.
	 *
	 * @param createdBy the created by of this project employee details
	 */
	@Override
	public void setCreatedBy(long createdBy) {
		model.setCreatedBy(createdBy);
	}

	/**
	 * Sets the employee ID of this project employee details.
	 *
	 * @param employeeId the employee ID of this project employee details
	 */
	@Override
	public void setEmployeeId(long employeeId) {
		model.setEmployeeId(employeeId);
	}

	/**
	 * Sets the group ID of this project employee details.
	 *
	 * @param groupId the group ID of this project employee details
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified by of this project employee details.
	 *
	 * @param modifiedBy the modified by of this project employee details
	 */
	@Override
	public void setModifiedBy(long modifiedBy) {
		model.setModifiedBy(modifiedBy);
	}

	/**
	 * Sets the modified date of this project employee details.
	 *
	 * @param modifiedDate the modified date of this project employee details
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this project employee details.
	 *
	 * @param primaryKey the primary key of this project employee details
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the project employee details ID of this project employee details.
	 *
	 * @param projectEmployeeDetailsId the project employee details ID of this project employee details
	 */
	@Override
	public void setProjectEmployeeDetailsId(long projectEmployeeDetailsId) {
		model.setProjectEmployeeDetailsId(projectEmployeeDetailsId);
	}

	/**
	 * Sets the project ID of this project employee details.
	 *
	 * @param projectId the project ID of this project employee details
	 */
	@Override
	public void setProjectId(long projectId) {
		model.setProjectId(projectId);
	}

	/**
	 * Sets the uuid of this project employee details.
	 *
	 * @param uuid the uuid of this project employee details
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
	protected ProjectEmployeeDetailsWrapper wrap(
		ProjectEmployeeDetails projectEmployeeDetails) {

		return new ProjectEmployeeDetailsWrapper(projectEmployeeDetails);
	}

}