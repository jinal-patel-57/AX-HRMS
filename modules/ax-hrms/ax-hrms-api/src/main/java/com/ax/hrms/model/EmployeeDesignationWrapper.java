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
 * This class is a wrapper for {@link EmployeeDesignation}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeDesignation
 * @generated
 */
public class EmployeeDesignationWrapper
	extends BaseModelWrapper<EmployeeDesignation>
	implements EmployeeDesignation, ModelWrapper<EmployeeDesignation> {

	public EmployeeDesignationWrapper(EmployeeDesignation employeeDesignation) {
		super(employeeDesignation);
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
		attributes.put("employeeDesignationId", getEmployeeDesignationId());
		attributes.put("designationMasterId", getDesignationMasterId());
		attributes.put("status", isStatus());
		attributes.put("startDate", getStartDate());
		attributes.put("endDate", getEndDate());
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

		Long employeeDesignationId = (Long)attributes.get(
			"employeeDesignationId");

		if (employeeDesignationId != null) {
			setEmployeeDesignationId(employeeDesignationId);
		}

		Long designationMasterId = (Long)attributes.get("designationMasterId");

		if (designationMasterId != null) {
			setDesignationMasterId(designationMasterId);
		}

		Boolean status = (Boolean)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		Date startDate = (Date)attributes.get("startDate");

		if (startDate != null) {
			setStartDate(startDate);
		}

		Date endDate = (Date)attributes.get("endDate");

		if (endDate != null) {
			setEndDate(endDate);
		}

		Long employeeId = (Long)attributes.get("employeeId");

		if (employeeId != null) {
			setEmployeeId(employeeId);
		}
	}

	@Override
	public EmployeeDesignation cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the company ID of this employee designation.
	 *
	 * @return the company ID of this employee designation
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this employee designation.
	 *
	 * @return the create date of this employee designation
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the created by of this employee designation.
	 *
	 * @return the created by of this employee designation
	 */
	@Override
	public long getCreatedBy() {
		return model.getCreatedBy();
	}

	/**
	 * Returns the designation master ID of this employee designation.
	 *
	 * @return the designation master ID of this employee designation
	 */
	@Override
	public long getDesignationMasterId() {
		return model.getDesignationMasterId();
	}

	/**
	 * Returns the employee designation ID of this employee designation.
	 *
	 * @return the employee designation ID of this employee designation
	 */
	@Override
	public long getEmployeeDesignationId() {
		return model.getEmployeeDesignationId();
	}

	/**
	 * Returns the employee ID of this employee designation.
	 *
	 * @return the employee ID of this employee designation
	 */
	@Override
	public long getEmployeeId() {
		return model.getEmployeeId();
	}

	/**
	 * Returns the end date of this employee designation.
	 *
	 * @return the end date of this employee designation
	 */
	@Override
	public Date getEndDate() {
		return model.getEndDate();
	}

	/**
	 * Returns the group ID of this employee designation.
	 *
	 * @return the group ID of this employee designation
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified by of this employee designation.
	 *
	 * @return the modified by of this employee designation
	 */
	@Override
	public long getModifiedBy() {
		return model.getModifiedBy();
	}

	/**
	 * Returns the modified date of this employee designation.
	 *
	 * @return the modified date of this employee designation
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this employee designation.
	 *
	 * @return the primary key of this employee designation
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the start date of this employee designation.
	 *
	 * @return the start date of this employee designation
	 */
	@Override
	public Date getStartDate() {
		return model.getStartDate();
	}

	/**
	 * Returns the status of this employee designation.
	 *
	 * @return the status of this employee designation
	 */
	@Override
	public boolean getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the uuid of this employee designation.
	 *
	 * @return the uuid of this employee designation
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns <code>true</code> if this employee designation is status.
	 *
	 * @return <code>true</code> if this employee designation is status; <code>false</code> otherwise
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
	 * Sets the company ID of this employee designation.
	 *
	 * @param companyId the company ID of this employee designation
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this employee designation.
	 *
	 * @param createDate the create date of this employee designation
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the created by of this employee designation.
	 *
	 * @param createdBy the created by of this employee designation
	 */
	@Override
	public void setCreatedBy(long createdBy) {
		model.setCreatedBy(createdBy);
	}

	/**
	 * Sets the designation master ID of this employee designation.
	 *
	 * @param designationMasterId the designation master ID of this employee designation
	 */
	@Override
	public void setDesignationMasterId(long designationMasterId) {
		model.setDesignationMasterId(designationMasterId);
	}

	/**
	 * Sets the employee designation ID of this employee designation.
	 *
	 * @param employeeDesignationId the employee designation ID of this employee designation
	 */
	@Override
	public void setEmployeeDesignationId(long employeeDesignationId) {
		model.setEmployeeDesignationId(employeeDesignationId);
	}

	/**
	 * Sets the employee ID of this employee designation.
	 *
	 * @param employeeId the employee ID of this employee designation
	 */
	@Override
	public void setEmployeeId(long employeeId) {
		model.setEmployeeId(employeeId);
	}

	/**
	 * Sets the end date of this employee designation.
	 *
	 * @param endDate the end date of this employee designation
	 */
	@Override
	public void setEndDate(Date endDate) {
		model.setEndDate(endDate);
	}

	/**
	 * Sets the group ID of this employee designation.
	 *
	 * @param groupId the group ID of this employee designation
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified by of this employee designation.
	 *
	 * @param modifiedBy the modified by of this employee designation
	 */
	@Override
	public void setModifiedBy(long modifiedBy) {
		model.setModifiedBy(modifiedBy);
	}

	/**
	 * Sets the modified date of this employee designation.
	 *
	 * @param modifiedDate the modified date of this employee designation
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this employee designation.
	 *
	 * @param primaryKey the primary key of this employee designation
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the start date of this employee designation.
	 *
	 * @param startDate the start date of this employee designation
	 */
	@Override
	public void setStartDate(Date startDate) {
		model.setStartDate(startDate);
	}

	/**
	 * Sets whether this employee designation is status.
	 *
	 * @param status the status of this employee designation
	 */
	@Override
	public void setStatus(boolean status) {
		model.setStatus(status);
	}

	/**
	 * Sets the uuid of this employee designation.
	 *
	 * @param uuid the uuid of this employee designation
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
	protected EmployeeDesignationWrapper wrap(
		EmployeeDesignation employeeDesignation) {

		return new EmployeeDesignationWrapper(employeeDesignation);
	}

}