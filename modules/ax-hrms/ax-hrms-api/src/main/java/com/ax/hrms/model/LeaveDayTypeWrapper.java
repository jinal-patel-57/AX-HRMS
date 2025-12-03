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
 * This class is a wrapper for {@link LeaveDayType}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LeaveDayType
 * @generated
 */
public class LeaveDayTypeWrapper
	extends BaseModelWrapper<LeaveDayType>
	implements LeaveDayType, ModelWrapper<LeaveDayType> {

	public LeaveDayTypeWrapper(LeaveDayType leaveDayType) {
		super(leaveDayType);
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
		attributes.put("leaveDayTypeId", getLeaveDayTypeId());
		attributes.put("leaveRequestId", getLeaveRequestId());
		attributes.put("leaveDate", getLeaveDate());
		attributes.put("isHalfDay", isIsHalfDay());
		attributes.put("isFirstHalf", isIsFirstHalf());

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

		Long leaveDayTypeId = (Long)attributes.get("leaveDayTypeId");

		if (leaveDayTypeId != null) {
			setLeaveDayTypeId(leaveDayTypeId);
		}

		Long leaveRequestId = (Long)attributes.get("leaveRequestId");

		if (leaveRequestId != null) {
			setLeaveRequestId(leaveRequestId);
		}

		Date leaveDate = (Date)attributes.get("leaveDate");

		if (leaveDate != null) {
			setLeaveDate(leaveDate);
		}

		Boolean isHalfDay = (Boolean)attributes.get("isHalfDay");

		if (isHalfDay != null) {
			setIsHalfDay(isHalfDay);
		}

		Boolean isFirstHalf = (Boolean)attributes.get("isFirstHalf");

		if (isFirstHalf != null) {
			setIsFirstHalf(isFirstHalf);
		}
	}

	@Override
	public LeaveDayType cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the company ID of this leave day type.
	 *
	 * @return the company ID of this leave day type
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this leave day type.
	 *
	 * @return the create date of this leave day type
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the created by of this leave day type.
	 *
	 * @return the created by of this leave day type
	 */
	@Override
	public long getCreatedBy() {
		return model.getCreatedBy();
	}

	/**
	 * Returns the group ID of this leave day type.
	 *
	 * @return the group ID of this leave day type
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the is first half of this leave day type.
	 *
	 * @return the is first half of this leave day type
	 */
	@Override
	public boolean getIsFirstHalf() {
		return model.getIsFirstHalf();
	}

	/**
	 * Returns the is half day of this leave day type.
	 *
	 * @return the is half day of this leave day type
	 */
	@Override
	public boolean getIsHalfDay() {
		return model.getIsHalfDay();
	}

	/**
	 * Returns the leave date of this leave day type.
	 *
	 * @return the leave date of this leave day type
	 */
	@Override
	public Date getLeaveDate() {
		return model.getLeaveDate();
	}

	/**
	 * Returns the leave day type ID of this leave day type.
	 *
	 * @return the leave day type ID of this leave day type
	 */
	@Override
	public long getLeaveDayTypeId() {
		return model.getLeaveDayTypeId();
	}

	/**
	 * Returns the leave request ID of this leave day type.
	 *
	 * @return the leave request ID of this leave day type
	 */
	@Override
	public long getLeaveRequestId() {
		return model.getLeaveRequestId();
	}

	/**
	 * Returns the modified by of this leave day type.
	 *
	 * @return the modified by of this leave day type
	 */
	@Override
	public long getModifiedBy() {
		return model.getModifiedBy();
	}

	/**
	 * Returns the modified date of this leave day type.
	 *
	 * @return the modified date of this leave day type
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this leave day type.
	 *
	 * @return the primary key of this leave day type
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the uuid of this leave day type.
	 *
	 * @return the uuid of this leave day type
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns <code>true</code> if this leave day type is is first half.
	 *
	 * @return <code>true</code> if this leave day type is is first half; <code>false</code> otherwise
	 */
	@Override
	public boolean isIsFirstHalf() {
		return model.isIsFirstHalf();
	}

	/**
	 * Returns <code>true</code> if this leave day type is is half day.
	 *
	 * @return <code>true</code> if this leave day type is is half day; <code>false</code> otherwise
	 */
	@Override
	public boolean isIsHalfDay() {
		return model.isIsHalfDay();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the company ID of this leave day type.
	 *
	 * @param companyId the company ID of this leave day type
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this leave day type.
	 *
	 * @param createDate the create date of this leave day type
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the created by of this leave day type.
	 *
	 * @param createdBy the created by of this leave day type
	 */
	@Override
	public void setCreatedBy(long createdBy) {
		model.setCreatedBy(createdBy);
	}

	/**
	 * Sets the group ID of this leave day type.
	 *
	 * @param groupId the group ID of this leave day type
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets whether this leave day type is is first half.
	 *
	 * @param isFirstHalf the is first half of this leave day type
	 */
	@Override
	public void setIsFirstHalf(boolean isFirstHalf) {
		model.setIsFirstHalf(isFirstHalf);
	}

	/**
	 * Sets whether this leave day type is is half day.
	 *
	 * @param isHalfDay the is half day of this leave day type
	 */
	@Override
	public void setIsHalfDay(boolean isHalfDay) {
		model.setIsHalfDay(isHalfDay);
	}

	/**
	 * Sets the leave date of this leave day type.
	 *
	 * @param leaveDate the leave date of this leave day type
	 */
	@Override
	public void setLeaveDate(Date leaveDate) {
		model.setLeaveDate(leaveDate);
	}

	/**
	 * Sets the leave day type ID of this leave day type.
	 *
	 * @param leaveDayTypeId the leave day type ID of this leave day type
	 */
	@Override
	public void setLeaveDayTypeId(long leaveDayTypeId) {
		model.setLeaveDayTypeId(leaveDayTypeId);
	}

	/**
	 * Sets the leave request ID of this leave day type.
	 *
	 * @param leaveRequestId the leave request ID of this leave day type
	 */
	@Override
	public void setLeaveRequestId(long leaveRequestId) {
		model.setLeaveRequestId(leaveRequestId);
	}

	/**
	 * Sets the modified by of this leave day type.
	 *
	 * @param modifiedBy the modified by of this leave day type
	 */
	@Override
	public void setModifiedBy(long modifiedBy) {
		model.setModifiedBy(modifiedBy);
	}

	/**
	 * Sets the modified date of this leave day type.
	 *
	 * @param modifiedDate the modified date of this leave day type
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this leave day type.
	 *
	 * @param primaryKey the primary key of this leave day type
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the uuid of this leave day type.
	 *
	 * @param uuid the uuid of this leave day type
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
	protected LeaveDayTypeWrapper wrap(LeaveDayType leaveDayType) {
		return new LeaveDayTypeWrapper(leaveDayType);
	}

}