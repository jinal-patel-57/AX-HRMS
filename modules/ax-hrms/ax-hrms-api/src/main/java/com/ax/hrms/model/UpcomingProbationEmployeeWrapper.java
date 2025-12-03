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
 * This class is a wrapper for {@link UpcomingProbationEmployee}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see UpcomingProbationEmployee
 * @generated
 */
public class UpcomingProbationEmployeeWrapper
	extends BaseModelWrapper<UpcomingProbationEmployee>
	implements ModelWrapper<UpcomingProbationEmployee>,
			   UpcomingProbationEmployee {

	public UpcomingProbationEmployeeWrapper(
		UpcomingProbationEmployee upcomingProbationEmployee) {

		super(upcomingProbationEmployee);
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
		attributes.put(
			"upcomingProbationEmployeeId", getUpcomingProbationEmployeeId());
		attributes.put("probationDetailId", getProbationDetailId());
		attributes.put("month", getMonth());
		attributes.put("year", getYear());

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

		Long upcomingProbationEmployeeId = (Long)attributes.get(
			"upcomingProbationEmployeeId");

		if (upcomingProbationEmployeeId != null) {
			setUpcomingProbationEmployeeId(upcomingProbationEmployeeId);
		}

		Long probationDetailId = (Long)attributes.get("probationDetailId");

		if (probationDetailId != null) {
			setProbationDetailId(probationDetailId);
		}

		Integer month = (Integer)attributes.get("month");

		if (month != null) {
			setMonth(month);
		}

		Integer year = (Integer)attributes.get("year");

		if (year != null) {
			setYear(year);
		}
	}

	@Override
	public UpcomingProbationEmployee cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the company ID of this upcoming probation employee.
	 *
	 * @return the company ID of this upcoming probation employee
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this upcoming probation employee.
	 *
	 * @return the create date of this upcoming probation employee
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the created by of this upcoming probation employee.
	 *
	 * @return the created by of this upcoming probation employee
	 */
	@Override
	public long getCreatedBy() {
		return model.getCreatedBy();
	}

	/**
	 * Returns the group ID of this upcoming probation employee.
	 *
	 * @return the group ID of this upcoming probation employee
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified by of this upcoming probation employee.
	 *
	 * @return the modified by of this upcoming probation employee
	 */
	@Override
	public long getModifiedBy() {
		return model.getModifiedBy();
	}

	/**
	 * Returns the modified date of this upcoming probation employee.
	 *
	 * @return the modified date of this upcoming probation employee
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the month of this upcoming probation employee.
	 *
	 * @return the month of this upcoming probation employee
	 */
	@Override
	public int getMonth() {
		return model.getMonth();
	}

	/**
	 * Returns the primary key of this upcoming probation employee.
	 *
	 * @return the primary key of this upcoming probation employee
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the probation detail ID of this upcoming probation employee.
	 *
	 * @return the probation detail ID of this upcoming probation employee
	 */
	@Override
	public long getProbationDetailId() {
		return model.getProbationDetailId();
	}

	/**
	 * Returns the upcoming probation employee ID of this upcoming probation employee.
	 *
	 * @return the upcoming probation employee ID of this upcoming probation employee
	 */
	@Override
	public long getUpcomingProbationEmployeeId() {
		return model.getUpcomingProbationEmployeeId();
	}

	/**
	 * Returns the uuid of this upcoming probation employee.
	 *
	 * @return the uuid of this upcoming probation employee
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns the year of this upcoming probation employee.
	 *
	 * @return the year of this upcoming probation employee
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
	 * Sets the company ID of this upcoming probation employee.
	 *
	 * @param companyId the company ID of this upcoming probation employee
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this upcoming probation employee.
	 *
	 * @param createDate the create date of this upcoming probation employee
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the created by of this upcoming probation employee.
	 *
	 * @param createdBy the created by of this upcoming probation employee
	 */
	@Override
	public void setCreatedBy(long createdBy) {
		model.setCreatedBy(createdBy);
	}

	/**
	 * Sets the group ID of this upcoming probation employee.
	 *
	 * @param groupId the group ID of this upcoming probation employee
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified by of this upcoming probation employee.
	 *
	 * @param modifiedBy the modified by of this upcoming probation employee
	 */
	@Override
	public void setModifiedBy(long modifiedBy) {
		model.setModifiedBy(modifiedBy);
	}

	/**
	 * Sets the modified date of this upcoming probation employee.
	 *
	 * @param modifiedDate the modified date of this upcoming probation employee
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the month of this upcoming probation employee.
	 *
	 * @param month the month of this upcoming probation employee
	 */
	@Override
	public void setMonth(int month) {
		model.setMonth(month);
	}

	/**
	 * Sets the primary key of this upcoming probation employee.
	 *
	 * @param primaryKey the primary key of this upcoming probation employee
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the probation detail ID of this upcoming probation employee.
	 *
	 * @param probationDetailId the probation detail ID of this upcoming probation employee
	 */
	@Override
	public void setProbationDetailId(long probationDetailId) {
		model.setProbationDetailId(probationDetailId);
	}

	/**
	 * Sets the upcoming probation employee ID of this upcoming probation employee.
	 *
	 * @param upcomingProbationEmployeeId the upcoming probation employee ID of this upcoming probation employee
	 */
	@Override
	public void setUpcomingProbationEmployeeId(
		long upcomingProbationEmployeeId) {

		model.setUpcomingProbationEmployeeId(upcomingProbationEmployeeId);
	}

	/**
	 * Sets the uuid of this upcoming probation employee.
	 *
	 * @param uuid the uuid of this upcoming probation employee
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	/**
	 * Sets the year of this upcoming probation employee.
	 *
	 * @param year the year of this upcoming probation employee
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
	protected UpcomingProbationEmployeeWrapper wrap(
		UpcomingProbationEmployee upcomingProbationEmployee) {

		return new UpcomingProbationEmployeeWrapper(upcomingProbationEmployee);
	}

}