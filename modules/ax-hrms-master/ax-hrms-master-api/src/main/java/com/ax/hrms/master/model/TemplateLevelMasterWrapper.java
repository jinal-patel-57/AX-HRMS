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
 * This class is a wrapper for {@link TemplateLevelMaster}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TemplateLevelMaster
 * @generated
 */
public class TemplateLevelMasterWrapper
	extends BaseModelWrapper<TemplateLevelMaster>
	implements ModelWrapper<TemplateLevelMaster>, TemplateLevelMaster {

	public TemplateLevelMasterWrapper(TemplateLevelMaster templateLevelMaster) {
		super(templateLevelMaster);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("templateLevelMasterId", getTemplateLevelMasterId());
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
		Long templateLevelMasterId = (Long)attributes.get(
			"templateLevelMasterId");

		if (templateLevelMasterId != null) {
			setTemplateLevelMasterId(templateLevelMasterId);
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
	public TemplateLevelMaster cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the company ID of this template level master.
	 *
	 * @return the company ID of this template level master
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this template level master.
	 *
	 * @return the create date of this template level master
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the created by of this template level master.
	 *
	 * @return the created by of this template level master
	 */
	@Override
	public long getCreatedBy() {
		return model.getCreatedBy();
	}

	/**
	 * Returns the group ID of this template level master.
	 *
	 * @return the group ID of this template level master
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the level name of this template level master.
	 *
	 * @return the level name of this template level master
	 */
	@Override
	public String getLevelName() {
		return model.getLevelName();
	}

	/**
	 * Returns the modified by of this template level master.
	 *
	 * @return the modified by of this template level master
	 */
	@Override
	public long getModifiedBy() {
		return model.getModifiedBy();
	}

	/**
	 * Returns the modified date of this template level master.
	 *
	 * @return the modified date of this template level master
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this template level master.
	 *
	 * @return the primary key of this template level master
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the template level master ID of this template level master.
	 *
	 * @return the template level master ID of this template level master
	 */
	@Override
	public long getTemplateLevelMasterId() {
		return model.getTemplateLevelMasterId();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the company ID of this template level master.
	 *
	 * @param companyId the company ID of this template level master
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this template level master.
	 *
	 * @param createDate the create date of this template level master
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the created by of this template level master.
	 *
	 * @param createdBy the created by of this template level master
	 */
	@Override
	public void setCreatedBy(long createdBy) {
		model.setCreatedBy(createdBy);
	}

	/**
	 * Sets the group ID of this template level master.
	 *
	 * @param groupId the group ID of this template level master
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the level name of this template level master.
	 *
	 * @param levelName the level name of this template level master
	 */
	@Override
	public void setLevelName(String levelName) {
		model.setLevelName(levelName);
	}

	/**
	 * Sets the modified by of this template level master.
	 *
	 * @param modifiedBy the modified by of this template level master
	 */
	@Override
	public void setModifiedBy(long modifiedBy) {
		model.setModifiedBy(modifiedBy);
	}

	/**
	 * Sets the modified date of this template level master.
	 *
	 * @param modifiedDate the modified date of this template level master
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this template level master.
	 *
	 * @param primaryKey the primary key of this template level master
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the template level master ID of this template level master.
	 *
	 * @param templateLevelMasterId the template level master ID of this template level master
	 */
	@Override
	public void setTemplateLevelMasterId(long templateLevelMasterId) {
		model.setTemplateLevelMasterId(templateLevelMasterId);
	}

	@Override
	public String toXmlString() {
		return model.toXmlString();
	}

	@Override
	protected TemplateLevelMasterWrapper wrap(
		TemplateLevelMaster templateLevelMaster) {

		return new TemplateLevelMasterWrapper(templateLevelMaster);
	}

}