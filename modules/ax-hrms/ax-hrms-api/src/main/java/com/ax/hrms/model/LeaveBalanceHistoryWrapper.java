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
 * This class is a wrapper for {@link LeaveBalanceHistory}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LeaveBalanceHistory
 * @generated
 */
public class LeaveBalanceHistoryWrapper
	extends BaseModelWrapper<LeaveBalanceHistory>
	implements LeaveBalanceHistory, ModelWrapper<LeaveBalanceHistory> {

	public LeaveBalanceHistoryWrapper(LeaveBalanceHistory leaveBalanceHistory) {
		super(leaveBalanceHistory);
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
		attributes.put("leaveBalanceHistoryId", getLeaveBalanceHistoryId());
		attributes.put("leaveBalanceId", getLeaveBalanceId());
		attributes.put("employeeId", getEmployeeId());
		attributes.put("leaveTypeMasterId", getLeaveTypeMasterId());
		attributes.put("year", getYear());
		attributes.put("noOfUsedLeaves", getNoOfUsedLeaves());
		attributes.put("noOfRemainingLeaves", getNoOfRemainingLeaves());

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

		Long leaveBalanceHistoryId = (Long)attributes.get(
			"leaveBalanceHistoryId");

		if (leaveBalanceHistoryId != null) {
			setLeaveBalanceHistoryId(leaveBalanceHistoryId);
		}

		Long leaveBalanceId = (Long)attributes.get("leaveBalanceId");

		if (leaveBalanceId != null) {
			setLeaveBalanceId(leaveBalanceId);
		}

		Long employeeId = (Long)attributes.get("employeeId");

		if (employeeId != null) {
			setEmployeeId(employeeId);
		}

		Long leaveTypeMasterId = (Long)attributes.get("leaveTypeMasterId");

		if (leaveTypeMasterId != null) {
			setLeaveTypeMasterId(leaveTypeMasterId);
		}

		Integer year = (Integer)attributes.get("year");

		if (year != null) {
			setYear(year);
		}

		Double noOfUsedLeaves = (Double)attributes.get("noOfUsedLeaves");

		if (noOfUsedLeaves != null) {
			setNoOfUsedLeaves(noOfUsedLeaves);
		}

		Double noOfRemainingLeaves = (Double)attributes.get(
			"noOfRemainingLeaves");

		if (noOfRemainingLeaves != null) {
			setNoOfRemainingLeaves(noOfRemainingLeaves);
		}
	}

	@Override
	public LeaveBalanceHistory cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the company ID of this leave balance history.
	 *
	 * @return the company ID of this leave balance history
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this leave balance history.
	 *
	 * @return the create date of this leave balance history
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the created by of this leave balance history.
	 *
	 * @return the created by of this leave balance history
	 */
	@Override
	public long getCreatedBy() {
		return model.getCreatedBy();
	}

	/**
	 * Returns the employee ID of this leave balance history.
	 *
	 * @return the employee ID of this leave balance history
	 */
	@Override
	public long getEmployeeId() {
		return model.getEmployeeId();
	}

	/**
	 * Returns the group ID of this leave balance history.
	 *
	 * @return the group ID of this leave balance history
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the leave balance history ID of this leave balance history.
	 *
	 * @return the leave balance history ID of this leave balance history
	 */
	@Override
	public long getLeaveBalanceHistoryId() {
		return model.getLeaveBalanceHistoryId();
	}

	/**
	 * Returns the leave balance ID of this leave balance history.
	 *
	 * @return the leave balance ID of this leave balance history
	 */
	@Override
	public long getLeaveBalanceId() {
		return model.getLeaveBalanceId();
	}

	/**
	 * Returns the leave type master ID of this leave balance history.
	 *
	 * @return the leave type master ID of this leave balance history
	 */
	@Override
	public long getLeaveTypeMasterId() {
		return model.getLeaveTypeMasterId();
	}

	/**
	 * Returns the modified by of this leave balance history.
	 *
	 * @return the modified by of this leave balance history
	 */
	@Override
	public long getModifiedBy() {
		return model.getModifiedBy();
	}

	/**
	 * Returns the modified date of this leave balance history.
	 *
	 * @return the modified date of this leave balance history
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the no of remaining leaves of this leave balance history.
	 *
	 * @return the no of remaining leaves of this leave balance history
	 */
	@Override
	public double getNoOfRemainingLeaves() {
		return model.getNoOfRemainingLeaves();
	}

	/**
	 * Returns the no of used leaves of this leave balance history.
	 *
	 * @return the no of used leaves of this leave balance history
	 */
	@Override
	public double getNoOfUsedLeaves() {
		return model.getNoOfUsedLeaves();
	}

	/**
	 * Returns the primary key of this leave balance history.
	 *
	 * @return the primary key of this leave balance history
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the uuid of this leave balance history.
	 *
	 * @return the uuid of this leave balance history
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns the year of this leave balance history.
	 *
	 * @return the year of this leave balance history
	 */
	@Override
	public int getYear() {
		return model.getYear();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the company ID of this leave balance history.
	 *
	 * @param companyId the company ID of this leave balance history
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this leave balance history.
	 *
	 * @param createDate the create date of this leave balance history
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the created by of this leave balance history.
	 *
	 * @param createdBy the created by of this leave balance history
	 */
	@Override
	public void setCreatedBy(long createdBy) {
		model.setCreatedBy(createdBy);
	}

	/**
	 * Sets the employee ID of this leave balance history.
	 *
	 * @param employeeId the employee ID of this leave balance history
	 */
	@Override
	public void setEmployeeId(long employeeId) {
		model.setEmployeeId(employeeId);
	}

	/**
	 * Sets the group ID of this leave balance history.
	 *
	 * @param groupId the group ID of this leave balance history
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the leave balance history ID of this leave balance history.
	 *
	 * @param leaveBalanceHistoryId the leave balance history ID of this leave balance history
	 */
	@Override
	public void setLeaveBalanceHistoryId(long leaveBalanceHistoryId) {
		model.setLeaveBalanceHistoryId(leaveBalanceHistoryId);
	}

	/**
	 * Sets the leave balance ID of this leave balance history.
	 *
	 * @param leaveBalanceId the leave balance ID of this leave balance history
	 */
	@Override
	public void setLeaveBalanceId(long leaveBalanceId) {
		model.setLeaveBalanceId(leaveBalanceId);
	}

	/**
	 * Sets the leave type master ID of this leave balance history.
	 *
	 * @param leaveTypeMasterId the leave type master ID of this leave balance history
	 */
	@Override
	public void setLeaveTypeMasterId(long leaveTypeMasterId) {
		model.setLeaveTypeMasterId(leaveTypeMasterId);
	}

	/**
	 * Sets the modified by of this leave balance history.
	 *
	 * @param modifiedBy the modified by of this leave balance history
	 */
	@Override
	public void setModifiedBy(long modifiedBy) {
		model.setModifiedBy(modifiedBy);
	}

	/**
	 * Sets the modified date of this leave balance history.
	 *
	 * @param modifiedDate the modified date of this leave balance history
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the no of remaining leaves of this leave balance history.
	 *
	 * @param noOfRemainingLeaves the no of remaining leaves of this leave balance history
	 */
	@Override
	public void setNoOfRemainingLeaves(double noOfRemainingLeaves) {
		model.setNoOfRemainingLeaves(noOfRemainingLeaves);
	}

	/**
	 * Sets the no of used leaves of this leave balance history.
	 *
	 * @param noOfUsedLeaves the no of used leaves of this leave balance history
	 */
	@Override
	public void setNoOfUsedLeaves(double noOfUsedLeaves) {
		model.setNoOfUsedLeaves(noOfUsedLeaves);
	}

	/**
	 * Sets the primary key of this leave balance history.
	 *
	 * @param primaryKey the primary key of this leave balance history
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the uuid of this leave balance history.
	 *
	 * @param uuid the uuid of this leave balance history
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	/**
	 * Sets the year of this leave balance history.
	 *
	 * @param year the year of this leave balance history
	 */
	@Override
	public void setYear(int year) {
		model.setYear(year);
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
	protected LeaveBalanceHistoryWrapper wrap(
		LeaveBalanceHistory leaveBalanceHistory) {

		return new LeaveBalanceHistoryWrapper(leaveBalanceHistory);
	}

}