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
 * This class is a wrapper for {@link CompensatoryData}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CompensatoryData
 * @generated
 */
public class CompensatoryDataWrapper
	extends BaseModelWrapper<CompensatoryData>
	implements CompensatoryData, ModelWrapper<CompensatoryData> {

	public CompensatoryDataWrapper(CompensatoryData compensatoryData) {
		super(compensatoryData);
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
		attributes.put("compensatoryDataId", getCompensatoryDataId());
		attributes.put("employeeId", getEmployeeId());
		attributes.put("dateOfCompensation", getDateOfCompensation());
		attributes.put("requestedHours", getRequestedHours());
		attributes.put("approvedHours", getApprovedHours());
		attributes.put("managerId", getManagerId());
		attributes.put(
			"leaveCompensatoryStatusMasterId",
			getLeaveCompensatoryStatusMasterId());
		attributes.put("description", getDescription());

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

		Long compensatoryDataId = (Long)attributes.get("compensatoryDataId");

		if (compensatoryDataId != null) {
			setCompensatoryDataId(compensatoryDataId);
		}

		Long employeeId = (Long)attributes.get("employeeId");

		if (employeeId != null) {
			setEmployeeId(employeeId);
		}

		Date dateOfCompensation = (Date)attributes.get("dateOfCompensation");

		if (dateOfCompensation != null) {
			setDateOfCompensation(dateOfCompensation);
		}

		Integer requestedHours = (Integer)attributes.get("requestedHours");

		if (requestedHours != null) {
			setRequestedHours(requestedHours);
		}

		Integer approvedHours = (Integer)attributes.get("approvedHours");

		if (approvedHours != null) {
			setApprovedHours(approvedHours);
		}

		Long managerId = (Long)attributes.get("managerId");

		if (managerId != null) {
			setManagerId(managerId);
		}

		Long leaveCompensatoryStatusMasterId = (Long)attributes.get(
			"leaveCompensatoryStatusMasterId");

		if (leaveCompensatoryStatusMasterId != null) {
			setLeaveCompensatoryStatusMasterId(leaveCompensatoryStatusMasterId);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}
	}

	@Override
	public CompensatoryData cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the approved hours of this compensatory data.
	 *
	 * @return the approved hours of this compensatory data
	 */
	@Override
	public int getApprovedHours() {
		return model.getApprovedHours();
	}

	/**
	 * Returns the company ID of this compensatory data.
	 *
	 * @return the company ID of this compensatory data
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the compensatory data ID of this compensatory data.
	 *
	 * @return the compensatory data ID of this compensatory data
	 */
	@Override
	public long getCompensatoryDataId() {
		return model.getCompensatoryDataId();
	}

	/**
	 * Returns the create date of this compensatory data.
	 *
	 * @return the create date of this compensatory data
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the created by of this compensatory data.
	 *
	 * @return the created by of this compensatory data
	 */
	@Override
	public long getCreatedBy() {
		return model.getCreatedBy();
	}

	/**
	 * Returns the date of compensation of this compensatory data.
	 *
	 * @return the date of compensation of this compensatory data
	 */
	@Override
	public Date getDateOfCompensation() {
		return model.getDateOfCompensation();
	}

	/**
	 * Returns the description of this compensatory data.
	 *
	 * @return the description of this compensatory data
	 */
	@Override
	public String getDescription() {
		return model.getDescription();
	}

	/**
	 * Returns the employee ID of this compensatory data.
	 *
	 * @return the employee ID of this compensatory data
	 */
	@Override
	public long getEmployeeId() {
		return model.getEmployeeId();
	}

	/**
	 * Returns the group ID of this compensatory data.
	 *
	 * @return the group ID of this compensatory data
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the leave compensatory status master ID of this compensatory data.
	 *
	 * @return the leave compensatory status master ID of this compensatory data
	 */
	@Override
	public long getLeaveCompensatoryStatusMasterId() {
		return model.getLeaveCompensatoryStatusMasterId();
	}

	/**
	 * Returns the manager ID of this compensatory data.
	 *
	 * @return the manager ID of this compensatory data
	 */
	@Override
	public long getManagerId() {
		return model.getManagerId();
	}

	/**
	 * Returns the modified by of this compensatory data.
	 *
	 * @return the modified by of this compensatory data
	 */
	@Override
	public long getModifiedBy() {
		return model.getModifiedBy();
	}

	/**
	 * Returns the modified date of this compensatory data.
	 *
	 * @return the modified date of this compensatory data
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this compensatory data.
	 *
	 * @return the primary key of this compensatory data
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the requested hours of this compensatory data.
	 *
	 * @return the requested hours of this compensatory data
	 */
	@Override
	public int getRequestedHours() {
		return model.getRequestedHours();
	}

	/**
	 * Returns the uuid of this compensatory data.
	 *
	 * @return the uuid of this compensatory data
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
	 * Sets the approved hours of this compensatory data.
	 *
	 * @param approvedHours the approved hours of this compensatory data
	 */
	@Override
	public void setApprovedHours(int approvedHours) {
		model.setApprovedHours(approvedHours);
	}

	/**
	 * Sets the company ID of this compensatory data.
	 *
	 * @param companyId the company ID of this compensatory data
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the compensatory data ID of this compensatory data.
	 *
	 * @param compensatoryDataId the compensatory data ID of this compensatory data
	 */
	@Override
	public void setCompensatoryDataId(long compensatoryDataId) {
		model.setCompensatoryDataId(compensatoryDataId);
	}

	/**
	 * Sets the create date of this compensatory data.
	 *
	 * @param createDate the create date of this compensatory data
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the created by of this compensatory data.
	 *
	 * @param createdBy the created by of this compensatory data
	 */
	@Override
	public void setCreatedBy(long createdBy) {
		model.setCreatedBy(createdBy);
	}

	/**
	 * Sets the date of compensation of this compensatory data.
	 *
	 * @param dateOfCompensation the date of compensation of this compensatory data
	 */
	@Override
	public void setDateOfCompensation(Date dateOfCompensation) {
		model.setDateOfCompensation(dateOfCompensation);
	}

	/**
	 * Sets the description of this compensatory data.
	 *
	 * @param description the description of this compensatory data
	 */
	@Override
	public void setDescription(String description) {
		model.setDescription(description);
	}

	/**
	 * Sets the employee ID of this compensatory data.
	 *
	 * @param employeeId the employee ID of this compensatory data
	 */
	@Override
	public void setEmployeeId(long employeeId) {
		model.setEmployeeId(employeeId);
	}

	/**
	 * Sets the group ID of this compensatory data.
	 *
	 * @param groupId the group ID of this compensatory data
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the leave compensatory status master ID of this compensatory data.
	 *
	 * @param leaveCompensatoryStatusMasterId the leave compensatory status master ID of this compensatory data
	 */
	@Override
	public void setLeaveCompensatoryStatusMasterId(
		long leaveCompensatoryStatusMasterId) {

		model.setLeaveCompensatoryStatusMasterId(
			leaveCompensatoryStatusMasterId);
	}

	/**
	 * Sets the manager ID of this compensatory data.
	 *
	 * @param managerId the manager ID of this compensatory data
	 */
	@Override
	public void setManagerId(long managerId) {
		model.setManagerId(managerId);
	}

	/**
	 * Sets the modified by of this compensatory data.
	 *
	 * @param modifiedBy the modified by of this compensatory data
	 */
	@Override
	public void setModifiedBy(long modifiedBy) {
		model.setModifiedBy(modifiedBy);
	}

	/**
	 * Sets the modified date of this compensatory data.
	 *
	 * @param modifiedDate the modified date of this compensatory data
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this compensatory data.
	 *
	 * @param primaryKey the primary key of this compensatory data
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the requested hours of this compensatory data.
	 *
	 * @param requestedHours the requested hours of this compensatory data
	 */
	@Override
	public void setRequestedHours(int requestedHours) {
		model.setRequestedHours(requestedHours);
	}

	/**
	 * Sets the uuid of this compensatory data.
	 *
	 * @param uuid the uuid of this compensatory data
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
	protected CompensatoryDataWrapper wrap(CompensatoryData compensatoryData) {
		return new CompensatoryDataWrapper(compensatoryData);
	}

}