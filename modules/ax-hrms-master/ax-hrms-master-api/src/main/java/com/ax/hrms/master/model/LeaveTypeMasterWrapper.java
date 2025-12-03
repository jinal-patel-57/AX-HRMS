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
 * This class is a wrapper for {@link LeaveTypeMaster}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LeaveTypeMaster
 * @generated
 */
public class LeaveTypeMasterWrapper
	extends BaseModelWrapper<LeaveTypeMaster>
	implements LeaveTypeMaster, ModelWrapper<LeaveTypeMaster> {

	public LeaveTypeMasterWrapper(LeaveTypeMaster leaveTypeMaster) {
		super(leaveTypeMaster);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("leaveTypeMasterId", getLeaveTypeMasterId());
		attributes.put("companyId", getCompanyId());
		attributes.put("createdBy", getCreatedBy());
		attributes.put("modifiedBy", getModifiedBy());
		attributes.put("groupId", getGroupId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("leaveTypeName", getLeaveTypeName());
		attributes.put("description", getDescription());
		attributes.put("isActive", isIsActive());
		attributes.put("isAppearForAll", isIsAppearForAll());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long leaveTypeMasterId = (Long)attributes.get("leaveTypeMasterId");

		if (leaveTypeMasterId != null) {
			setLeaveTypeMasterId(leaveTypeMasterId);
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

		String leaveTypeName = (String)attributes.get("leaveTypeName");

		if (leaveTypeName != null) {
			setLeaveTypeName(leaveTypeName);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		Boolean isActive = (Boolean)attributes.get("isActive");

		if (isActive != null) {
			setIsActive(isActive);
		}

		Boolean isAppearForAll = (Boolean)attributes.get("isAppearForAll");

		if (isAppearForAll != null) {
			setIsAppearForAll(isAppearForAll);
		}
	}

	@Override
	public LeaveTypeMaster cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the company ID of this leave type master.
	 *
	 * @return the company ID of this leave type master
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this leave type master.
	 *
	 * @return the create date of this leave type master
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the created by of this leave type master.
	 *
	 * @return the created by of this leave type master
	 */
	@Override
	public long getCreatedBy() {
		return model.getCreatedBy();
	}

	/**
	 * Returns the description of this leave type master.
	 *
	 * @return the description of this leave type master
	 */
	@Override
	public String getDescription() {
		return model.getDescription();
	}

	/**
	 * Returns the group ID of this leave type master.
	 *
	 * @return the group ID of this leave type master
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the is active of this leave type master.
	 *
	 * @return the is active of this leave type master
	 */
	@Override
	public boolean getIsActive() {
		return model.getIsActive();
	}

	/**
	 * Returns the is appear for all of this leave type master.
	 *
	 * @return the is appear for all of this leave type master
	 */
	@Override
	public boolean getIsAppearForAll() {
		return model.getIsAppearForAll();
	}

	/**
	 * Returns the leave type master ID of this leave type master.
	 *
	 * @return the leave type master ID of this leave type master
	 */
	@Override
	public long getLeaveTypeMasterId() {
		return model.getLeaveTypeMasterId();
	}

	/**
	 * Returns the leave type name of this leave type master.
	 *
	 * @return the leave type name of this leave type master
	 */
	@Override
	public String getLeaveTypeName() {
		return model.getLeaveTypeName();
	}

	/**
	 * Returns the modified by of this leave type master.
	 *
	 * @return the modified by of this leave type master
	 */
	@Override
	public long getModifiedBy() {
		return model.getModifiedBy();
	}

	/**
	 * Returns the modified date of this leave type master.
	 *
	 * @return the modified date of this leave type master
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this leave type master.
	 *
	 * @return the primary key of this leave type master
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns <code>true</code> if this leave type master is is active.
	 *
	 * @return <code>true</code> if this leave type master is is active; <code>false</code> otherwise
	 */
	@Override
	public boolean isIsActive() {
		return model.isIsActive();
	}

	/**
	 * Returns <code>true</code> if this leave type master is is appear for all.
	 *
	 * @return <code>true</code> if this leave type master is is appear for all; <code>false</code> otherwise
	 */
	@Override
	public boolean isIsAppearForAll() {
		return model.isIsAppearForAll();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the company ID of this leave type master.
	 *
	 * @param companyId the company ID of this leave type master
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this leave type master.
	 *
	 * @param createDate the create date of this leave type master
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the created by of this leave type master.
	 *
	 * @param createdBy the created by of this leave type master
	 */
	@Override
	public void setCreatedBy(long createdBy) {
		model.setCreatedBy(createdBy);
	}

	/**
	 * Sets the description of this leave type master.
	 *
	 * @param description the description of this leave type master
	 */
	@Override
	public void setDescription(String description) {
		model.setDescription(description);
	}

	/**
	 * Sets the group ID of this leave type master.
	 *
	 * @param groupId the group ID of this leave type master
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets whether this leave type master is is active.
	 *
	 * @param isActive the is active of this leave type master
	 */
	@Override
	public void setIsActive(boolean isActive) {
		model.setIsActive(isActive);
	}

	/**
	 * Sets whether this leave type master is is appear for all.
	 *
	 * @param isAppearForAll the is appear for all of this leave type master
	 */
	@Override
	public void setIsAppearForAll(boolean isAppearForAll) {
		model.setIsAppearForAll(isAppearForAll);
	}

	/**
	 * Sets the leave type master ID of this leave type master.
	 *
	 * @param leaveTypeMasterId the leave type master ID of this leave type master
	 */
	@Override
	public void setLeaveTypeMasterId(long leaveTypeMasterId) {
		model.setLeaveTypeMasterId(leaveTypeMasterId);
	}

	/**
	 * Sets the leave type name of this leave type master.
	 *
	 * @param leaveTypeName the leave type name of this leave type master
	 */
	@Override
	public void setLeaveTypeName(String leaveTypeName) {
		model.setLeaveTypeName(leaveTypeName);
	}

	/**
	 * Sets the modified by of this leave type master.
	 *
	 * @param modifiedBy the modified by of this leave type master
	 */
	@Override
	public void setModifiedBy(long modifiedBy) {
		model.setModifiedBy(modifiedBy);
	}

	/**
	 * Sets the modified date of this leave type master.
	 *
	 * @param modifiedDate the modified date of this leave type master
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this leave type master.
	 *
	 * @param primaryKey the primary key of this leave type master
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
	protected LeaveTypeMasterWrapper wrap(LeaveTypeMaster leaveTypeMaster) {
		return new LeaveTypeMasterWrapper(leaveTypeMaster);
	}

}