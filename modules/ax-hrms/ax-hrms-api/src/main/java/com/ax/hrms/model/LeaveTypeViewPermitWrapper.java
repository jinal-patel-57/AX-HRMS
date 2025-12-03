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
 * This class is a wrapper for {@link LeaveTypeViewPermit}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LeaveTypeViewPermit
 * @generated
 */
public class LeaveTypeViewPermitWrapper
	extends BaseModelWrapper<LeaveTypeViewPermit>
	implements LeaveTypeViewPermit, ModelWrapper<LeaveTypeViewPermit> {

	public LeaveTypeViewPermitWrapper(LeaveTypeViewPermit leaveTypeViewPermit) {
		super(leaveTypeViewPermit);
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
		attributes.put("leaveTypeViewPermitId", getLeaveTypeViewPermitId());
		attributes.put("leaveTypeMasterId", getLeaveTypeMasterId());
		attributes.put("employeeId", getEmployeeId());
		attributes.put(
			"yearOfLeaveTypeViewPermit", getYearOfLeaveTypeViewPermit());

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

		Long leaveTypeViewPermitId = (Long)attributes.get(
			"leaveTypeViewPermitId");

		if (leaveTypeViewPermitId != null) {
			setLeaveTypeViewPermitId(leaveTypeViewPermitId);
		}

		Long leaveTypeMasterId = (Long)attributes.get("leaveTypeMasterId");

		if (leaveTypeMasterId != null) {
			setLeaveTypeMasterId(leaveTypeMasterId);
		}

		Long employeeId = (Long)attributes.get("employeeId");

		if (employeeId != null) {
			setEmployeeId(employeeId);
		}

		Integer yearOfLeaveTypeViewPermit = (Integer)attributes.get(
			"yearOfLeaveTypeViewPermit");

		if (yearOfLeaveTypeViewPermit != null) {
			setYearOfLeaveTypeViewPermit(yearOfLeaveTypeViewPermit);
		}
	}

	@Override
	public LeaveTypeViewPermit cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the company ID of this leave type view permit.
	 *
	 * @return the company ID of this leave type view permit
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this leave type view permit.
	 *
	 * @return the create date of this leave type view permit
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the created by of this leave type view permit.
	 *
	 * @return the created by of this leave type view permit
	 */
	@Override
	public long getCreatedBy() {
		return model.getCreatedBy();
	}

	/**
	 * Returns the employee ID of this leave type view permit.
	 *
	 * @return the employee ID of this leave type view permit
	 */
	@Override
	public long getEmployeeId() {
		return model.getEmployeeId();
	}

	/**
	 * Returns the group ID of this leave type view permit.
	 *
	 * @return the group ID of this leave type view permit
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the leave type master ID of this leave type view permit.
	 *
	 * @return the leave type master ID of this leave type view permit
	 */
	@Override
	public long getLeaveTypeMasterId() {
		return model.getLeaveTypeMasterId();
	}

	/**
	 * Returns the leave type view permit ID of this leave type view permit.
	 *
	 * @return the leave type view permit ID of this leave type view permit
	 */
	@Override
	public long getLeaveTypeViewPermitId() {
		return model.getLeaveTypeViewPermitId();
	}

	/**
	 * Returns the modified by of this leave type view permit.
	 *
	 * @return the modified by of this leave type view permit
	 */
	@Override
	public long getModifiedBy() {
		return model.getModifiedBy();
	}

	/**
	 * Returns the modified date of this leave type view permit.
	 *
	 * @return the modified date of this leave type view permit
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this leave type view permit.
	 *
	 * @return the primary key of this leave type view permit
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the uuid of this leave type view permit.
	 *
	 * @return the uuid of this leave type view permit
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns the year of leave type view permit of this leave type view permit.
	 *
	 * @return the year of leave type view permit of this leave type view permit
	 */
	@Override
	public int getYearOfLeaveTypeViewPermit() {
		return model.getYearOfLeaveTypeViewPermit();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the company ID of this leave type view permit.
	 *
	 * @param companyId the company ID of this leave type view permit
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this leave type view permit.
	 *
	 * @param createDate the create date of this leave type view permit
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the created by of this leave type view permit.
	 *
	 * @param createdBy the created by of this leave type view permit
	 */
	@Override
	public void setCreatedBy(long createdBy) {
		model.setCreatedBy(createdBy);
	}

	/**
	 * Sets the employee ID of this leave type view permit.
	 *
	 * @param employeeId the employee ID of this leave type view permit
	 */
	@Override
	public void setEmployeeId(long employeeId) {
		model.setEmployeeId(employeeId);
	}

	/**
	 * Sets the group ID of this leave type view permit.
	 *
	 * @param groupId the group ID of this leave type view permit
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the leave type master ID of this leave type view permit.
	 *
	 * @param leaveTypeMasterId the leave type master ID of this leave type view permit
	 */
	@Override
	public void setLeaveTypeMasterId(long leaveTypeMasterId) {
		model.setLeaveTypeMasterId(leaveTypeMasterId);
	}

	/**
	 * Sets the leave type view permit ID of this leave type view permit.
	 *
	 * @param leaveTypeViewPermitId the leave type view permit ID of this leave type view permit
	 */
	@Override
	public void setLeaveTypeViewPermitId(long leaveTypeViewPermitId) {
		model.setLeaveTypeViewPermitId(leaveTypeViewPermitId);
	}

	/**
	 * Sets the modified by of this leave type view permit.
	 *
	 * @param modifiedBy the modified by of this leave type view permit
	 */
	@Override
	public void setModifiedBy(long modifiedBy) {
		model.setModifiedBy(modifiedBy);
	}

	/**
	 * Sets the modified date of this leave type view permit.
	 *
	 * @param modifiedDate the modified date of this leave type view permit
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this leave type view permit.
	 *
	 * @param primaryKey the primary key of this leave type view permit
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the uuid of this leave type view permit.
	 *
	 * @param uuid the uuid of this leave type view permit
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	/**
	 * Sets the year of leave type view permit of this leave type view permit.
	 *
	 * @param yearOfLeaveTypeViewPermit the year of leave type view permit of this leave type view permit
	 */
	@Override
	public void setYearOfLeaveTypeViewPermit(int yearOfLeaveTypeViewPermit) {
		model.setYearOfLeaveTypeViewPermit(yearOfLeaveTypeViewPermit);
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
	protected LeaveTypeViewPermitWrapper wrap(
		LeaveTypeViewPermit leaveTypeViewPermit) {

		return new LeaveTypeViewPermitWrapper(leaveTypeViewPermit);
	}

}