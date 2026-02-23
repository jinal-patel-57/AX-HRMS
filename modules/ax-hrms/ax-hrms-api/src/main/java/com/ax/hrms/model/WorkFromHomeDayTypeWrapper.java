/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
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
 * This class is a wrapper for {@link WorkFromHomeDayType}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see WorkFromHomeDayType
 * @generated
 */
public class WorkFromHomeDayTypeWrapper
	extends BaseModelWrapper<WorkFromHomeDayType>
	implements ModelWrapper<WorkFromHomeDayType>, WorkFromHomeDayType {

	public WorkFromHomeDayTypeWrapper(WorkFromHomeDayType workFromHomeDayType) {
		super(workFromHomeDayType);
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
		attributes.put("workFromHomeDayTypeId", getWorkFromHomeDayTypeId());
		attributes.put("workFromHomeRequestId", getWorkFromHomeRequestId());
		attributes.put("workFromHomeDate", getWorkFromHomeDate());
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

		Long workFromHomeDayTypeId = (Long)attributes.get(
			"workFromHomeDayTypeId");

		if (workFromHomeDayTypeId != null) {
			setWorkFromHomeDayTypeId(workFromHomeDayTypeId);
		}

		Long workFromHomeRequestId = (Long)attributes.get(
			"workFromHomeRequestId");

		if (workFromHomeRequestId != null) {
			setWorkFromHomeRequestId(workFromHomeRequestId);
		}

		Date workFromHomeDate = (Date)attributes.get("workFromHomeDate");

		if (workFromHomeDate != null) {
			setWorkFromHomeDate(workFromHomeDate);
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
	public WorkFromHomeDayType cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the company ID of this work from home day type.
	 *
	 * @return the company ID of this work from home day type
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this work from home day type.
	 *
	 * @return the create date of this work from home day type
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the created by of this work from home day type.
	 *
	 * @return the created by of this work from home day type
	 */
	@Override
	public long getCreatedBy() {
		return model.getCreatedBy();
	}

	/**
	 * Returns the group ID of this work from home day type.
	 *
	 * @return the group ID of this work from home day type
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the is first half of this work from home day type.
	 *
	 * @return the is first half of this work from home day type
	 */
	@Override
	public boolean getIsFirstHalf() {
		return model.getIsFirstHalf();
	}

	/**
	 * Returns the is half day of this work from home day type.
	 *
	 * @return the is half day of this work from home day type
	 */
	@Override
	public boolean getIsHalfDay() {
		return model.getIsHalfDay();
	}

	/**
	 * Returns the modified by of this work from home day type.
	 *
	 * @return the modified by of this work from home day type
	 */
	@Override
	public long getModifiedBy() {
		return model.getModifiedBy();
	}

	/**
	 * Returns the modified date of this work from home day type.
	 *
	 * @return the modified date of this work from home day type
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this work from home day type.
	 *
	 * @return the primary key of this work from home day type
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the uuid of this work from home day type.
	 *
	 * @return the uuid of this work from home day type
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns the work from home date of this work from home day type.
	 *
	 * @return the work from home date of this work from home day type
	 */
	@Override
	public Date getWorkFromHomeDate() {
		return model.getWorkFromHomeDate();
	}

	/**
	 * Returns the work from home day type ID of this work from home day type.
	 *
	 * @return the work from home day type ID of this work from home day type
	 */
	@Override
	public long getWorkFromHomeDayTypeId() {
		return model.getWorkFromHomeDayTypeId();
	}

	/**
	 * Returns the work from home request ID of this work from home day type.
	 *
	 * @return the work from home request ID of this work from home day type
	 */
	@Override
	public long getWorkFromHomeRequestId() {
		return model.getWorkFromHomeRequestId();
	}

	/**
	 * Returns <code>true</code> if this work from home day type is is first half.
	 *
	 * @return <code>true</code> if this work from home day type is is first half; <code>false</code> otherwise
	 */
	@Override
	public boolean isIsFirstHalf() {
		return model.isIsFirstHalf();
	}

	/**
	 * Returns <code>true</code> if this work from home day type is is half day.
	 *
	 * @return <code>true</code> if this work from home day type is is half day; <code>false</code> otherwise
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
	 * Sets the company ID of this work from home day type.
	 *
	 * @param companyId the company ID of this work from home day type
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this work from home day type.
	 *
	 * @param createDate the create date of this work from home day type
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the created by of this work from home day type.
	 *
	 * @param createdBy the created by of this work from home day type
	 */
	@Override
	public void setCreatedBy(long createdBy) {
		model.setCreatedBy(createdBy);
	}

	/**
	 * Sets the group ID of this work from home day type.
	 *
	 * @param groupId the group ID of this work from home day type
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets whether this work from home day type is is first half.
	 *
	 * @param isFirstHalf the is first half of this work from home day type
	 */
	@Override
	public void setIsFirstHalf(boolean isFirstHalf) {
		model.setIsFirstHalf(isFirstHalf);
	}

	/**
	 * Sets whether this work from home day type is is half day.
	 *
	 * @param isHalfDay the is half day of this work from home day type
	 */
	@Override
	public void setIsHalfDay(boolean isHalfDay) {
		model.setIsHalfDay(isHalfDay);
	}

	/**
	 * Sets the modified by of this work from home day type.
	 *
	 * @param modifiedBy the modified by of this work from home day type
	 */
	@Override
	public void setModifiedBy(long modifiedBy) {
		model.setModifiedBy(modifiedBy);
	}

	/**
	 * Sets the modified date of this work from home day type.
	 *
	 * @param modifiedDate the modified date of this work from home day type
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this work from home day type.
	 *
	 * @param primaryKey the primary key of this work from home day type
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the uuid of this work from home day type.
	 *
	 * @param uuid the uuid of this work from home day type
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	/**
	 * Sets the work from home date of this work from home day type.
	 *
	 * @param workFromHomeDate the work from home date of this work from home day type
	 */
	@Override
	public void setWorkFromHomeDate(Date workFromHomeDate) {
		model.setWorkFromHomeDate(workFromHomeDate);
	}

	/**
	 * Sets the work from home day type ID of this work from home day type.
	 *
	 * @param workFromHomeDayTypeId the work from home day type ID of this work from home day type
	 */
	@Override
	public void setWorkFromHomeDayTypeId(long workFromHomeDayTypeId) {
		model.setWorkFromHomeDayTypeId(workFromHomeDayTypeId);
	}

	/**
	 * Sets the work from home request ID of this work from home day type.
	 *
	 * @param workFromHomeRequestId the work from home request ID of this work from home day type
	 */
	@Override
	public void setWorkFromHomeRequestId(long workFromHomeRequestId) {
		model.setWorkFromHomeRequestId(workFromHomeRequestId);
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
	protected WorkFromHomeDayTypeWrapper wrap(
		WorkFromHomeDayType workFromHomeDayType) {

		return new WorkFromHomeDayTypeWrapper(workFromHomeDayType);
	}

}