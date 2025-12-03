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
 * This class is a wrapper for {@link DesignationMaster}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DesignationMaster
 * @generated
 */
public class DesignationMasterWrapper
	extends BaseModelWrapper<DesignationMaster>
	implements DesignationMaster, ModelWrapper<DesignationMaster> {

	public DesignationMasterWrapper(DesignationMaster designationMaster) {
		super(designationMaster);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("designationMasterId", getDesignationMasterId());
		attributes.put("companyId", getCompanyId());
		attributes.put("createdBy", getCreatedBy());
		attributes.put("modifiedBy", getModifiedBy());
		attributes.put("groupId", getGroupId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("designationName", getDesignationName());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long designationMasterId = (Long)attributes.get("designationMasterId");

		if (designationMasterId != null) {
			setDesignationMasterId(designationMasterId);
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

		String designationName = (String)attributes.get("designationName");

		if (designationName != null) {
			setDesignationName(designationName);
		}
	}

	@Override
	public DesignationMaster cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the company ID of this designation master.
	 *
	 * @return the company ID of this designation master
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this designation master.
	 *
	 * @return the create date of this designation master
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the created by of this designation master.
	 *
	 * @return the created by of this designation master
	 */
	@Override
	public long getCreatedBy() {
		return model.getCreatedBy();
	}

	/**
	 * Returns the designation master ID of this designation master.
	 *
	 * @return the designation master ID of this designation master
	 */
	@Override
	public long getDesignationMasterId() {
		return model.getDesignationMasterId();
	}

	/**
	 * Returns the designation name of this designation master.
	 *
	 * @return the designation name of this designation master
	 */
	@Override
	public String getDesignationName() {
		return model.getDesignationName();
	}

	/**
	 * Returns the group ID of this designation master.
	 *
	 * @return the group ID of this designation master
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified by of this designation master.
	 *
	 * @return the modified by of this designation master
	 */
	@Override
	public long getModifiedBy() {
		return model.getModifiedBy();
	}

	/**
	 * Returns the modified date of this designation master.
	 *
	 * @return the modified date of this designation master
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this designation master.
	 *
	 * @return the primary key of this designation master
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
	 * Sets the company ID of this designation master.
	 *
	 * @param companyId the company ID of this designation master
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this designation master.
	 *
	 * @param createDate the create date of this designation master
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the created by of this designation master.
	 *
	 * @param createdBy the created by of this designation master
	 */
	@Override
	public void setCreatedBy(long createdBy) {
		model.setCreatedBy(createdBy);
	}

	/**
	 * Sets the designation master ID of this designation master.
	 *
	 * @param designationMasterId the designation master ID of this designation master
	 */
	@Override
	public void setDesignationMasterId(long designationMasterId) {
		model.setDesignationMasterId(designationMasterId);
	}

	/**
	 * Sets the designation name of this designation master.
	 *
	 * @param designationName the designation name of this designation master
	 */
	@Override
	public void setDesignationName(String designationName) {
		model.setDesignationName(designationName);
	}

	/**
	 * Sets the group ID of this designation master.
	 *
	 * @param groupId the group ID of this designation master
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified by of this designation master.
	 *
	 * @param modifiedBy the modified by of this designation master
	 */
	@Override
	public void setModifiedBy(long modifiedBy) {
		model.setModifiedBy(modifiedBy);
	}

	/**
	 * Sets the modified date of this designation master.
	 *
	 * @param modifiedDate the modified date of this designation master
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this designation master.
	 *
	 * @param primaryKey the primary key of this designation master
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
	protected DesignationMasterWrapper wrap(
		DesignationMaster designationMaster) {

		return new DesignationMasterWrapper(designationMaster);
	}

}