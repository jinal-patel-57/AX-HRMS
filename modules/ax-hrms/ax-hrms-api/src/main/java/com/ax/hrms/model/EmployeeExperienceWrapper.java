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
 * This class is a wrapper for {@link EmployeeExperience}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeExperience
 * @generated
 */
public class EmployeeExperienceWrapper
	extends BaseModelWrapper<EmployeeExperience>
	implements EmployeeExperience, ModelWrapper<EmployeeExperience> {

	public EmployeeExperienceWrapper(EmployeeExperience employeeExperience) {
		super(employeeExperience);
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
		attributes.put("experienceId", getExperienceId());
		attributes.put("companyName", getCompanyName());
		attributes.put("joiningDate", getJoiningDate());
		attributes.put("relievingDate", getRelievingDate());
		attributes.put(
			"experienceCertificateMediaId", getExperienceCertificateMediaId());
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

		Long experienceId = (Long)attributes.get("experienceId");

		if (experienceId != null) {
			setExperienceId(experienceId);
		}

		String companyName = (String)attributes.get("companyName");

		if (companyName != null) {
			setCompanyName(companyName);
		}

		Date joiningDate = (Date)attributes.get("joiningDate");

		if (joiningDate != null) {
			setJoiningDate(joiningDate);
		}

		Date relievingDate = (Date)attributes.get("relievingDate");

		if (relievingDate != null) {
			setRelievingDate(relievingDate);
		}

		Long experienceCertificateMediaId = (Long)attributes.get(
			"experienceCertificateMediaId");

		if (experienceCertificateMediaId != null) {
			setExperienceCertificateMediaId(experienceCertificateMediaId);
		}

		Long employeeId = (Long)attributes.get("employeeId");

		if (employeeId != null) {
			setEmployeeId(employeeId);
		}
	}

	@Override
	public EmployeeExperience cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the company ID of this employee experience.
	 *
	 * @return the company ID of this employee experience
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the company name of this employee experience.
	 *
	 * @return the company name of this employee experience
	 */
	@Override
	public String getCompanyName() {
		return model.getCompanyName();
	}

	/**
	 * Returns the create date of this employee experience.
	 *
	 * @return the create date of this employee experience
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the created by of this employee experience.
	 *
	 * @return the created by of this employee experience
	 */
	@Override
	public long getCreatedBy() {
		return model.getCreatedBy();
	}

	/**
	 * Returns the employee ID of this employee experience.
	 *
	 * @return the employee ID of this employee experience
	 */
	@Override
	public long getEmployeeId() {
		return model.getEmployeeId();
	}

	/**
	 * Returns the experience certificate media ID of this employee experience.
	 *
	 * @return the experience certificate media ID of this employee experience
	 */
	@Override
	public long getExperienceCertificateMediaId() {
		return model.getExperienceCertificateMediaId();
	}

	/**
	 * Returns the experience ID of this employee experience.
	 *
	 * @return the experience ID of this employee experience
	 */
	@Override
	public long getExperienceId() {
		return model.getExperienceId();
	}

	/**
	 * Returns the group ID of this employee experience.
	 *
	 * @return the group ID of this employee experience
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the joining date of this employee experience.
	 *
	 * @return the joining date of this employee experience
	 */
	@Override
	public Date getJoiningDate() {
		return model.getJoiningDate();
	}

	/**
	 * Returns the modified by of this employee experience.
	 *
	 * @return the modified by of this employee experience
	 */
	@Override
	public long getModifiedBy() {
		return model.getModifiedBy();
	}

	/**
	 * Returns the modified date of this employee experience.
	 *
	 * @return the modified date of this employee experience
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this employee experience.
	 *
	 * @return the primary key of this employee experience
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the relieving date of this employee experience.
	 *
	 * @return the relieving date of this employee experience
	 */
	@Override
	public Date getRelievingDate() {
		return model.getRelievingDate();
	}

	/**
	 * Returns the uuid of this employee experience.
	 *
	 * @return the uuid of this employee experience
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
	 * Sets the company ID of this employee experience.
	 *
	 * @param companyId the company ID of this employee experience
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the company name of this employee experience.
	 *
	 * @param companyName the company name of this employee experience
	 */
	@Override
	public void setCompanyName(String companyName) {
		model.setCompanyName(companyName);
	}

	/**
	 * Sets the create date of this employee experience.
	 *
	 * @param createDate the create date of this employee experience
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the created by of this employee experience.
	 *
	 * @param createdBy the created by of this employee experience
	 */
	@Override
	public void setCreatedBy(long createdBy) {
		model.setCreatedBy(createdBy);
	}

	/**
	 * Sets the employee ID of this employee experience.
	 *
	 * @param employeeId the employee ID of this employee experience
	 */
	@Override
	public void setEmployeeId(long employeeId) {
		model.setEmployeeId(employeeId);
	}

	/**
	 * Sets the experience certificate media ID of this employee experience.
	 *
	 * @param experienceCertificateMediaId the experience certificate media ID of this employee experience
	 */
	@Override
	public void setExperienceCertificateMediaId(
		long experienceCertificateMediaId) {

		model.setExperienceCertificateMediaId(experienceCertificateMediaId);
	}

	/**
	 * Sets the experience ID of this employee experience.
	 *
	 * @param experienceId the experience ID of this employee experience
	 */
	@Override
	public void setExperienceId(long experienceId) {
		model.setExperienceId(experienceId);
	}

	/**
	 * Sets the group ID of this employee experience.
	 *
	 * @param groupId the group ID of this employee experience
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the joining date of this employee experience.
	 *
	 * @param joiningDate the joining date of this employee experience
	 */
	@Override
	public void setJoiningDate(Date joiningDate) {
		model.setJoiningDate(joiningDate);
	}

	/**
	 * Sets the modified by of this employee experience.
	 *
	 * @param modifiedBy the modified by of this employee experience
	 */
	@Override
	public void setModifiedBy(long modifiedBy) {
		model.setModifiedBy(modifiedBy);
	}

	/**
	 * Sets the modified date of this employee experience.
	 *
	 * @param modifiedDate the modified date of this employee experience
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this employee experience.
	 *
	 * @param primaryKey the primary key of this employee experience
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the relieving date of this employee experience.
	 *
	 * @param relievingDate the relieving date of this employee experience
	 */
	@Override
	public void setRelievingDate(Date relievingDate) {
		model.setRelievingDate(relievingDate);
	}

	/**
	 * Sets the uuid of this employee experience.
	 *
	 * @param uuid the uuid of this employee experience
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
	protected EmployeeExperienceWrapper wrap(
		EmployeeExperience employeeExperience) {

		return new EmployeeExperienceWrapper(employeeExperience);
	}

}