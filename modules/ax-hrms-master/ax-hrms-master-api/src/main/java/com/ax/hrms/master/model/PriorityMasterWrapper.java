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
 * This class is a wrapper for {@link PriorityMaster}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PriorityMaster
 * @generated
 */
public class PriorityMasterWrapper
	extends BaseModelWrapper<PriorityMaster>
	implements ModelWrapper<PriorityMaster>, PriorityMaster {

	public PriorityMasterWrapper(PriorityMaster priorityMaster) {
		super(priorityMaster);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("priorityMasterId", getPriorityMasterId());
		attributes.put("companyId", getCompanyId());
		attributes.put("createdBy", getCreatedBy());
		attributes.put("modifiedBy", getModifiedBy());
		attributes.put("groupId", getGroupId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("priorityName", getPriorityName());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long priorityMasterId = (Long)attributes.get("priorityMasterId");

		if (priorityMasterId != null) {
			setPriorityMasterId(priorityMasterId);
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

		String priorityName = (String)attributes.get("priorityName");

		if (priorityName != null) {
			setPriorityName(priorityName);
		}
	}

	@Override
	public PriorityMaster cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the company ID of this priority master.
	 *
	 * @return the company ID of this priority master
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this priority master.
	 *
	 * @return the create date of this priority master
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the created by of this priority master.
	 *
	 * @return the created by of this priority master
	 */
	@Override
	public long getCreatedBy() {
		return model.getCreatedBy();
	}

	/**
	 * Returns the group ID of this priority master.
	 *
	 * @return the group ID of this priority master
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified by of this priority master.
	 *
	 * @return the modified by of this priority master
	 */
	@Override
	public long getModifiedBy() {
		return model.getModifiedBy();
	}

	/**
	 * Returns the modified date of this priority master.
	 *
	 * @return the modified date of this priority master
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this priority master.
	 *
	 * @return the primary key of this priority master
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the priority master ID of this priority master.
	 *
	 * @return the priority master ID of this priority master
	 */
	@Override
	public long getPriorityMasterId() {
		return model.getPriorityMasterId();
	}

	/**
	 * Returns the priority name of this priority master.
	 *
	 * @return the priority name of this priority master
	 */
	@Override
	public String getPriorityName() {
		return model.getPriorityName();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the company ID of this priority master.
	 *
	 * @param companyId the company ID of this priority master
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this priority master.
	 *
	 * @param createDate the create date of this priority master
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the created by of this priority master.
	 *
	 * @param createdBy the created by of this priority master
	 */
	@Override
	public void setCreatedBy(long createdBy) {
		model.setCreatedBy(createdBy);
	}

	/**
	 * Sets the group ID of this priority master.
	 *
	 * @param groupId the group ID of this priority master
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified by of this priority master.
	 *
	 * @param modifiedBy the modified by of this priority master
	 */
	@Override
	public void setModifiedBy(long modifiedBy) {
		model.setModifiedBy(modifiedBy);
	}

	/**
	 * Sets the modified date of this priority master.
	 *
	 * @param modifiedDate the modified date of this priority master
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this priority master.
	 *
	 * @param primaryKey the primary key of this priority master
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the priority master ID of this priority master.
	 *
	 * @param priorityMasterId the priority master ID of this priority master
	 */
	@Override
	public void setPriorityMasterId(long priorityMasterId) {
		model.setPriorityMasterId(priorityMasterId);
	}

	/**
	 * Sets the priority name of this priority master.
	 *
	 * @param priorityName the priority name of this priority master
	 */
	@Override
	public void setPriorityName(String priorityName) {
		model.setPriorityName(priorityName);
	}

	@Override
	public String toXmlString() {
		return model.toXmlString();
	}

	@Override
	protected PriorityMasterWrapper wrap(PriorityMaster priorityMaster) {
		return new PriorityMasterWrapper(priorityMaster);
	}

}