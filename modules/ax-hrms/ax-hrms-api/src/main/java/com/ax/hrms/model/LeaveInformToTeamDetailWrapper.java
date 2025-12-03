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
 * This class is a wrapper for {@link LeaveInformToTeamDetail}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LeaveInformToTeamDetail
 * @generated
 */
public class LeaveInformToTeamDetailWrapper
	extends BaseModelWrapper<LeaveInformToTeamDetail>
	implements LeaveInformToTeamDetail, ModelWrapper<LeaveInformToTeamDetail> {

	public LeaveInformToTeamDetailWrapper(
		LeaveInformToTeamDetail leaveInformToTeamDetail) {

		super(leaveInformToTeamDetail);
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
		attributes.put("leaveInformId", getLeaveInformId());
		attributes.put("leaveRequestId", getLeaveRequestId());
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

		Long leaveInformId = (Long)attributes.get("leaveInformId");

		if (leaveInformId != null) {
			setLeaveInformId(leaveInformId);
		}

		Long leaveRequestId = (Long)attributes.get("leaveRequestId");

		if (leaveRequestId != null) {
			setLeaveRequestId(leaveRequestId);
		}

		Long employeeId = (Long)attributes.get("employeeId");

		if (employeeId != null) {
			setEmployeeId(employeeId);
		}
	}

	@Override
	public LeaveInformToTeamDetail cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the company ID of this leave inform to team detail.
	 *
	 * @return the company ID of this leave inform to team detail
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this leave inform to team detail.
	 *
	 * @return the create date of this leave inform to team detail
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the created by of this leave inform to team detail.
	 *
	 * @return the created by of this leave inform to team detail
	 */
	@Override
	public long getCreatedBy() {
		return model.getCreatedBy();
	}

	/**
	 * Returns the employee ID of this leave inform to team detail.
	 *
	 * @return the employee ID of this leave inform to team detail
	 */
	@Override
	public long getEmployeeId() {
		return model.getEmployeeId();
	}

	/**
	 * Returns the group ID of this leave inform to team detail.
	 *
	 * @return the group ID of this leave inform to team detail
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the leave inform ID of this leave inform to team detail.
	 *
	 * @return the leave inform ID of this leave inform to team detail
	 */
	@Override
	public long getLeaveInformId() {
		return model.getLeaveInformId();
	}

	/**
	 * Returns the leave request ID of this leave inform to team detail.
	 *
	 * @return the leave request ID of this leave inform to team detail
	 */
	@Override
	public long getLeaveRequestId() {
		return model.getLeaveRequestId();
	}

	/**
	 * Returns the modified by of this leave inform to team detail.
	 *
	 * @return the modified by of this leave inform to team detail
	 */
	@Override
	public long getModifiedBy() {
		return model.getModifiedBy();
	}

	/**
	 * Returns the modified date of this leave inform to team detail.
	 *
	 * @return the modified date of this leave inform to team detail
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this leave inform to team detail.
	 *
	 * @return the primary key of this leave inform to team detail
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the uuid of this leave inform to team detail.
	 *
	 * @return the uuid of this leave inform to team detail
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
	 * Sets the company ID of this leave inform to team detail.
	 *
	 * @param companyId the company ID of this leave inform to team detail
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this leave inform to team detail.
	 *
	 * @param createDate the create date of this leave inform to team detail
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the created by of this leave inform to team detail.
	 *
	 * @param createdBy the created by of this leave inform to team detail
	 */
	@Override
	public void setCreatedBy(long createdBy) {
		model.setCreatedBy(createdBy);
	}

	/**
	 * Sets the employee ID of this leave inform to team detail.
	 *
	 * @param employeeId the employee ID of this leave inform to team detail
	 */
	@Override
	public void setEmployeeId(long employeeId) {
		model.setEmployeeId(employeeId);
	}

	/**
	 * Sets the group ID of this leave inform to team detail.
	 *
	 * @param groupId the group ID of this leave inform to team detail
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the leave inform ID of this leave inform to team detail.
	 *
	 * @param leaveInformId the leave inform ID of this leave inform to team detail
	 */
	@Override
	public void setLeaveInformId(long leaveInformId) {
		model.setLeaveInformId(leaveInformId);
	}

	/**
	 * Sets the leave request ID of this leave inform to team detail.
	 *
	 * @param leaveRequestId the leave request ID of this leave inform to team detail
	 */
	@Override
	public void setLeaveRequestId(long leaveRequestId) {
		model.setLeaveRequestId(leaveRequestId);
	}

	/**
	 * Sets the modified by of this leave inform to team detail.
	 *
	 * @param modifiedBy the modified by of this leave inform to team detail
	 */
	@Override
	public void setModifiedBy(long modifiedBy) {
		model.setModifiedBy(modifiedBy);
	}

	/**
	 * Sets the modified date of this leave inform to team detail.
	 *
	 * @param modifiedDate the modified date of this leave inform to team detail
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this leave inform to team detail.
	 *
	 * @param primaryKey the primary key of this leave inform to team detail
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the uuid of this leave inform to team detail.
	 *
	 * @param uuid the uuid of this leave inform to team detail
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
	protected LeaveInformToTeamDetailWrapper wrap(
		LeaveInformToTeamDetail leaveInformToTeamDetail) {

		return new LeaveInformToTeamDetailWrapper(leaveInformToTeamDetail);
	}

}