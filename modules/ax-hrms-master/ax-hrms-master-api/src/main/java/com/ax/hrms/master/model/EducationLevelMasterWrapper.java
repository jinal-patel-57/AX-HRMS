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
 * This class is a wrapper for {@link EducationLevelMaster}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EducationLevelMaster
 * @generated
 */
public class EducationLevelMasterWrapper
	extends BaseModelWrapper<EducationLevelMaster>
	implements EducationLevelMaster, ModelWrapper<EducationLevelMaster> {

	public EducationLevelMasterWrapper(
		EducationLevelMaster educationLevelMaster) {

		super(educationLevelMaster);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("educationLevelMasterId", getEducationLevelMasterId());
		attributes.put("companyId", getCompanyId());
		attributes.put("createdBy", getCreatedBy());
		attributes.put("modifiedBy", getModifiedBy());
		attributes.put("groupId", getGroupId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("levelName", getLevelName());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long educationLevelMasterId = (Long)attributes.get(
			"educationLevelMasterId");

		if (educationLevelMasterId != null) {
			setEducationLevelMasterId(educationLevelMasterId);
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

		String levelName = (String)attributes.get("levelName");

		if (levelName != null) {
			setLevelName(levelName);
		}
	}

	@Override
	public EducationLevelMaster cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the company ID of this education level master.
	 *
	 * @return the company ID of this education level master
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this education level master.
	 *
	 * @return the create date of this education level master
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the created by of this education level master.
	 *
	 * @return the created by of this education level master
	 */
	@Override
	public long getCreatedBy() {
		return model.getCreatedBy();
	}

	/**
	 * Returns the education level master ID of this education level master.
	 *
	 * @return the education level master ID of this education level master
	 */
	@Override
	public long getEducationLevelMasterId() {
		return model.getEducationLevelMasterId();
	}

	/**
	 * Returns the group ID of this education level master.
	 *
	 * @return the group ID of this education level master
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the level name of this education level master.
	 *
	 * @return the level name of this education level master
	 */
	@Override
	public String getLevelName() {
		return model.getLevelName();
	}

	/**
	 * Returns the modified by of this education level master.
	 *
	 * @return the modified by of this education level master
	 */
	@Override
	public long getModifiedBy() {
		return model.getModifiedBy();
	}

	/**
	 * Returns the modified date of this education level master.
	 *
	 * @return the modified date of this education level master
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this education level master.
	 *
	 * @return the primary key of this education level master
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
	 * Sets the company ID of this education level master.
	 *
	 * @param companyId the company ID of this education level master
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this education level master.
	 *
	 * @param createDate the create date of this education level master
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the created by of this education level master.
	 *
	 * @param createdBy the created by of this education level master
	 */
	@Override
	public void setCreatedBy(long createdBy) {
		model.setCreatedBy(createdBy);
	}

	/**
	 * Sets the education level master ID of this education level master.
	 *
	 * @param educationLevelMasterId the education level master ID of this education level master
	 */
	@Override
	public void setEducationLevelMasterId(long educationLevelMasterId) {
		model.setEducationLevelMasterId(educationLevelMasterId);
	}

	/**
	 * Sets the group ID of this education level master.
	 *
	 * @param groupId the group ID of this education level master
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the level name of this education level master.
	 *
	 * @param levelName the level name of this education level master
	 */
	@Override
	public void setLevelName(String levelName) {
		model.setLevelName(levelName);
	}

	/**
	 * Sets the modified by of this education level master.
	 *
	 * @param modifiedBy the modified by of this education level master
	 */
	@Override
	public void setModifiedBy(long modifiedBy) {
		model.setModifiedBy(modifiedBy);
	}

	/**
	 * Sets the modified date of this education level master.
	 *
	 * @param modifiedDate the modified date of this education level master
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this education level master.
	 *
	 * @param primaryKey the primary key of this education level master
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
	protected EducationLevelMasterWrapper wrap(
		EducationLevelMaster educationLevelMaster) {

		return new EducationLevelMasterWrapper(educationLevelMaster);
	}

}