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
 * This class is a wrapper for {@link Holiday}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Holiday
 * @generated
 */
public class HolidayWrapper
	extends BaseModelWrapper<Holiday>
	implements Holiday, ModelWrapper<Holiday> {

	public HolidayWrapper(Holiday holiday) {
		super(holiday);
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
		attributes.put("holidayId", getHolidayId());
		attributes.put("holidayName", getHolidayName());
		attributes.put("date", getDate());
		attributes.put("description", getDescription());
		attributes.put("year", getYear());
		attributes.put("isFloater", getIsFloater());

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

		Long holidayId = (Long)attributes.get("holidayId");

		if (holidayId != null) {
			setHolidayId(holidayId);
		}

		String holidayName = (String)attributes.get("holidayName");

		if (holidayName != null) {
			setHolidayName(holidayName);
		}

		Date date = (Date)attributes.get("date");

		if (date != null) {
			setDate(date);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		Integer year = (Integer)attributes.get("year");

		if (year != null) {
			setYear(year);
		}

		Boolean isFloater = (Boolean)attributes.get("isFloater");

		if (isFloater != null) {
			setIsFloater(isFloater);
		}
	}

	@Override
	public Holiday cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the company ID of this holiday.
	 *
	 * @return the company ID of this holiday
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this holiday.
	 *
	 * @return the create date of this holiday
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the created by of this holiday.
	 *
	 * @return the created by of this holiday
	 */
	@Override
	public long getCreatedBy() {
		return model.getCreatedBy();
	}

	/**
	 * Returns the date of this holiday.
	 *
	 * @return the date of this holiday
	 */
	@Override
	public Date getDate() {
		return model.getDate();
	}

	/**
	 * Returns the description of this holiday.
	 *
	 * @return the description of this holiday
	 */
	@Override
	public String getDescription() {
		return model.getDescription();
	}

	/**
	 * Returns the group ID of this holiday.
	 *
	 * @return the group ID of this holiday
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the holiday ID of this holiday.
	 *
	 * @return the holiday ID of this holiday
	 */
	@Override
	public long getHolidayId() {
		return model.getHolidayId();
	}

	/**
	 * Returns the holiday name of this holiday.
	 *
	 * @return the holiday name of this holiday
	 */
	@Override
	public String getHolidayName() {
		return model.getHolidayName();
	}

	/**
	 * Returns the is floater of this holiday.
	 *
	 * @return the is floater of this holiday
	 */
	@Override
	public Boolean getIsFloater() {
		return model.getIsFloater();
	}

	/**
	 * Returns the modified by of this holiday.
	 *
	 * @return the modified by of this holiday
	 */
	@Override
	public long getModifiedBy() {
		return model.getModifiedBy();
	}

	/**
	 * Returns the modified date of this holiday.
	 *
	 * @return the modified date of this holiday
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this holiday.
	 *
	 * @return the primary key of this holiday
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the uuid of this holiday.
	 *
	 * @return the uuid of this holiday
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns the year of this holiday.
	 *
	 * @return the year of this holiday
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
	 * Sets the company ID of this holiday.
	 *
	 * @param companyId the company ID of this holiday
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this holiday.
	 *
	 * @param createDate the create date of this holiday
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the created by of this holiday.
	 *
	 * @param createdBy the created by of this holiday
	 */
	@Override
	public void setCreatedBy(long createdBy) {
		model.setCreatedBy(createdBy);
	}

	/**
	 * Sets the date of this holiday.
	 *
	 * @param date the date of this holiday
	 */
	@Override
	public void setDate(Date date) {
		model.setDate(date);
	}

	/**
	 * Sets the description of this holiday.
	 *
	 * @param description the description of this holiday
	 */
	@Override
	public void setDescription(String description) {
		model.setDescription(description);
	}

	/**
	 * Sets the group ID of this holiday.
	 *
	 * @param groupId the group ID of this holiday
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the holiday ID of this holiday.
	 *
	 * @param holidayId the holiday ID of this holiday
	 */
	@Override
	public void setHolidayId(long holidayId) {
		model.setHolidayId(holidayId);
	}

	/**
	 * Sets the holiday name of this holiday.
	 *
	 * @param holidayName the holiday name of this holiday
	 */
	@Override
	public void setHolidayName(String holidayName) {
		model.setHolidayName(holidayName);
	}

	/**
	 * Sets the is floater of this holiday.
	 *
	 * @param isFloater the is floater of this holiday
	 */
	@Override
	public void setIsFloater(Boolean isFloater) {
		model.setIsFloater(isFloater);
	}

	/**
	 * Sets the modified by of this holiday.
	 *
	 * @param modifiedBy the modified by of this holiday
	 */
	@Override
	public void setModifiedBy(long modifiedBy) {
		model.setModifiedBy(modifiedBy);
	}

	/**
	 * Sets the modified date of this holiday.
	 *
	 * @param modifiedDate the modified date of this holiday
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this holiday.
	 *
	 * @param primaryKey the primary key of this holiday
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the uuid of this holiday.
	 *
	 * @param uuid the uuid of this holiday
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	/**
	 * Sets the year of this holiday.
	 *
	 * @param year the year of this holiday
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
	protected HolidayWrapper wrap(Holiday holiday) {
		return new HolidayWrapper(holiday);
	}

}