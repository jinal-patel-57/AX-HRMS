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
 * This class is a wrapper for {@link EmployeeEducation}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeEducation
 * @generated
 */
public class EmployeeEducationWrapper
	extends BaseModelWrapper<EmployeeEducation>
	implements EmployeeEducation, ModelWrapper<EmployeeEducation> {

	public EmployeeEducationWrapper(EmployeeEducation employeeEducation) {
		super(employeeEducation);
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
		attributes.put("educationId", getEducationId());
		attributes.put("levelId", getLevelId());
		attributes.put("institution", getInstitution());
		attributes.put("degree", getDegree());
		attributes.put("startDate", getStartDate());
		attributes.put("passingYear", getPassingYear());
		attributes.put("endDate", getEndDate());
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

		Long educationId = (Long)attributes.get("educationId");

		if (educationId != null) {
			setEducationId(educationId);
		}

		Long levelId = (Long)attributes.get("levelId");

		if (levelId != null) {
			setLevelId(levelId);
		}

		String institution = (String)attributes.get("institution");

		if (institution != null) {
			setInstitution(institution);
		}

		String degree = (String)attributes.get("degree");

		if (degree != null) {
			setDegree(degree);
		}

		Date startDate = (Date)attributes.get("startDate");

		if (startDate != null) {
			setStartDate(startDate);
		}

		String passingYear = (String)attributes.get("passingYear");

		if (passingYear != null) {
			setPassingYear(passingYear);
		}

		Date endDate = (Date)attributes.get("endDate");

		if (endDate != null) {
			setEndDate(endDate);
		}

		Long employeeId = (Long)attributes.get("employeeId");

		if (employeeId != null) {
			setEmployeeId(employeeId);
		}
	}

	@Override
	public EmployeeEducation cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the company ID of this employee education.
	 *
	 * @return the company ID of this employee education
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this employee education.
	 *
	 * @return the create date of this employee education
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the created by of this employee education.
	 *
	 * @return the created by of this employee education
	 */
	@Override
	public long getCreatedBy() {
		return model.getCreatedBy();
	}

	/**
	 * Returns the degree of this employee education.
	 *
	 * @return the degree of this employee education
	 */
	@Override
	public String getDegree() {
		return model.getDegree();
	}

	/**
	 * Returns the education ID of this employee education.
	 *
	 * @return the education ID of this employee education
	 */
	@Override
	public long getEducationId() {
		return model.getEducationId();
	}

	/**
	 * Returns the employee ID of this employee education.
	 *
	 * @return the employee ID of this employee education
	 */
	@Override
	public long getEmployeeId() {
		return model.getEmployeeId();
	}

	/**
	 * Returns the end date of this employee education.
	 *
	 * @return the end date of this employee education
	 */
	@Override
	public Date getEndDate() {
		return model.getEndDate();
	}

	/**
	 * Returns the group ID of this employee education.
	 *
	 * @return the group ID of this employee education
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the institution of this employee education.
	 *
	 * @return the institution of this employee education
	 */
	@Override
	public String getInstitution() {
		return model.getInstitution();
	}

	/**
	 * Returns the level ID of this employee education.
	 *
	 * @return the level ID of this employee education
	 */
	@Override
	public long getLevelId() {
		return model.getLevelId();
	}

	/**
	 * Returns the modified by of this employee education.
	 *
	 * @return the modified by of this employee education
	 */
	@Override
	public long getModifiedBy() {
		return model.getModifiedBy();
	}

	/**
	 * Returns the modified date of this employee education.
	 *
	 * @return the modified date of this employee education
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the passing year of this employee education.
	 *
	 * @return the passing year of this employee education
	 */
	@Override
	public String getPassingYear() {
		return model.getPassingYear();
	}

	/**
	 * Returns the primary key of this employee education.
	 *
	 * @return the primary key of this employee education
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the start date of this employee education.
	 *
	 * @return the start date of this employee education
	 */
	@Override
	public Date getStartDate() {
		return model.getStartDate();
	}

	/**
	 * Returns the uuid of this employee education.
	 *
	 * @return the uuid of this employee education
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
	 * Sets the company ID of this employee education.
	 *
	 * @param companyId the company ID of this employee education
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this employee education.
	 *
	 * @param createDate the create date of this employee education
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the created by of this employee education.
	 *
	 * @param createdBy the created by of this employee education
	 */
	@Override
	public void setCreatedBy(long createdBy) {
		model.setCreatedBy(createdBy);
	}

	/**
	 * Sets the degree of this employee education.
	 *
	 * @param degree the degree of this employee education
	 */
	@Override
	public void setDegree(String degree) {
		model.setDegree(degree);
	}

	/**
	 * Sets the education ID of this employee education.
	 *
	 * @param educationId the education ID of this employee education
	 */
	@Override
	public void setEducationId(long educationId) {
		model.setEducationId(educationId);
	}

	/**
	 * Sets the employee ID of this employee education.
	 *
	 * @param employeeId the employee ID of this employee education
	 */
	@Override
	public void setEmployeeId(long employeeId) {
		model.setEmployeeId(employeeId);
	}

	/**
	 * Sets the end date of this employee education.
	 *
	 * @param endDate the end date of this employee education
	 */
	@Override
	public void setEndDate(Date endDate) {
		model.setEndDate(endDate);
	}

	/**
	 * Sets the group ID of this employee education.
	 *
	 * @param groupId the group ID of this employee education
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the institution of this employee education.
	 *
	 * @param institution the institution of this employee education
	 */
	@Override
	public void setInstitution(String institution) {
		model.setInstitution(institution);
	}

	/**
	 * Sets the level ID of this employee education.
	 *
	 * @param levelId the level ID of this employee education
	 */
	@Override
	public void setLevelId(long levelId) {
		model.setLevelId(levelId);
	}

	/**
	 * Sets the modified by of this employee education.
	 *
	 * @param modifiedBy the modified by of this employee education
	 */
	@Override
	public void setModifiedBy(long modifiedBy) {
		model.setModifiedBy(modifiedBy);
	}

	/**
	 * Sets the modified date of this employee education.
	 *
	 * @param modifiedDate the modified date of this employee education
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the passing year of this employee education.
	 *
	 * @param passingYear the passing year of this employee education
	 */
	@Override
	public void setPassingYear(String passingYear) {
		model.setPassingYear(passingYear);
	}

	/**
	 * Sets the primary key of this employee education.
	 *
	 * @param primaryKey the primary key of this employee education
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the start date of this employee education.
	 *
	 * @param startDate the start date of this employee education
	 */
	@Override
	public void setStartDate(Date startDate) {
		model.setStartDate(startDate);
	}

	/**
	 * Sets the uuid of this employee education.
	 *
	 * @param uuid the uuid of this employee education
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
	protected EmployeeEducationWrapper wrap(
		EmployeeEducation employeeEducation) {

		return new EmployeeEducationWrapper(employeeEducation);
	}

}