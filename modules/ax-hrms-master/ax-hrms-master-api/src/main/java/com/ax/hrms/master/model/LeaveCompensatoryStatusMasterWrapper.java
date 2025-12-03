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
 * This class is a wrapper for {@link LeaveCompensatoryStatusMaster}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LeaveCompensatoryStatusMaster
 * @generated
 */
public class LeaveCompensatoryStatusMasterWrapper
	extends BaseModelWrapper<LeaveCompensatoryStatusMaster>
	implements LeaveCompensatoryStatusMaster,
			   ModelWrapper<LeaveCompensatoryStatusMaster> {

	public LeaveCompensatoryStatusMasterWrapper(
		LeaveCompensatoryStatusMaster leaveCompensatoryStatusMaster) {

		super(leaveCompensatoryStatusMaster);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put(
			"leaveCompensatoryStatusMasterId",
			getLeaveCompensatoryStatusMasterId());
		attributes.put("companyId", getCompanyId());
		attributes.put("createdBy", getCreatedBy());
		attributes.put("modifiedBy", getModifiedBy());
		attributes.put("groupId", getGroupId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("leaveCompensatoryStatus", getLeaveCompensatoryStatus());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long leaveCompensatoryStatusMasterId = (Long)attributes.get(
			"leaveCompensatoryStatusMasterId");

		if (leaveCompensatoryStatusMasterId != null) {
			setLeaveCompensatoryStatusMasterId(leaveCompensatoryStatusMasterId);
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

		String leaveCompensatoryStatus = (String)attributes.get(
			"leaveCompensatoryStatus");

		if (leaveCompensatoryStatus != null) {
			setLeaveCompensatoryStatus(leaveCompensatoryStatus);
		}
	}

	@Override
	public LeaveCompensatoryStatusMaster cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the company ID of this leave compensatory status master.
	 *
	 * @return the company ID of this leave compensatory status master
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this leave compensatory status master.
	 *
	 * @return the create date of this leave compensatory status master
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the created by of this leave compensatory status master.
	 *
	 * @return the created by of this leave compensatory status master
	 */
	@Override
	public long getCreatedBy() {
		return model.getCreatedBy();
	}

	/**
	 * Returns the group ID of this leave compensatory status master.
	 *
	 * @return the group ID of this leave compensatory status master
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the leave compensatory status of this leave compensatory status master.
	 *
	 * @return the leave compensatory status of this leave compensatory status master
	 */
	@Override
	public String getLeaveCompensatoryStatus() {
		return model.getLeaveCompensatoryStatus();
	}

	/**
	 * Returns the leave compensatory status master ID of this leave compensatory status master.
	 *
	 * @return the leave compensatory status master ID of this leave compensatory status master
	 */
	@Override
	public long getLeaveCompensatoryStatusMasterId() {
		return model.getLeaveCompensatoryStatusMasterId();
	}

	/**
	 * Returns the modified by of this leave compensatory status master.
	 *
	 * @return the modified by of this leave compensatory status master
	 */
	@Override
	public long getModifiedBy() {
		return model.getModifiedBy();
	}

	/**
	 * Returns the modified date of this leave compensatory status master.
	 *
	 * @return the modified date of this leave compensatory status master
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this leave compensatory status master.
	 *
	 * @return the primary key of this leave compensatory status master
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the company ID of this leave compensatory status master.
	 *
	 * @param companyId the company ID of this leave compensatory status master
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this leave compensatory status master.
	 *
	 * @param createDate the create date of this leave compensatory status master
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the created by of this leave compensatory status master.
	 *
	 * @param createdBy the created by of this leave compensatory status master
	 */
	@Override
	public void setCreatedBy(long createdBy) {
		model.setCreatedBy(createdBy);
	}

	/**
	 * Sets the group ID of this leave compensatory status master.
	 *
	 * @param groupId the group ID of this leave compensatory status master
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the leave compensatory status of this leave compensatory status master.
	 *
	 * @param leaveCompensatoryStatus the leave compensatory status of this leave compensatory status master
	 */
	@Override
	public void setLeaveCompensatoryStatus(String leaveCompensatoryStatus) {
		model.setLeaveCompensatoryStatus(leaveCompensatoryStatus);
	}

	/**
	 * Sets the leave compensatory status master ID of this leave compensatory status master.
	 *
	 * @param leaveCompensatoryStatusMasterId the leave compensatory status master ID of this leave compensatory status master
	 */
	@Override
	public void setLeaveCompensatoryStatusMasterId(
		long leaveCompensatoryStatusMasterId) {

		model.setLeaveCompensatoryStatusMasterId(
			leaveCompensatoryStatusMasterId);
	}

	/**
	 * Sets the modified by of this leave compensatory status master.
	 *
	 * @param modifiedBy the modified by of this leave compensatory status master
	 */
	@Override
	public void setModifiedBy(long modifiedBy) {
		model.setModifiedBy(modifiedBy);
	}

	/**
	 * Sets the modified date of this leave compensatory status master.
	 *
	 * @param modifiedDate the modified date of this leave compensatory status master
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this leave compensatory status master.
	 *
	 * @param primaryKey the primary key of this leave compensatory status master
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	@Override
	public String toXmlString() {
		return model.toXmlString();
	}

	@Override
	protected LeaveCompensatoryStatusMasterWrapper wrap(
		LeaveCompensatoryStatusMaster leaveCompensatoryStatusMaster) {

		return new LeaveCompensatoryStatusMasterWrapper(
			leaveCompensatoryStatusMaster);
	}

}