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
 * This class is a wrapper for {@link DepartmentMaster}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DepartmentMaster
 * @generated
 */
public class DepartmentMasterWrapper
	extends BaseModelWrapper<DepartmentMaster>
	implements DepartmentMaster, ModelWrapper<DepartmentMaster> {

	public DepartmentMasterWrapper(DepartmentMaster departmentMaster) {
		super(departmentMaster);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("departmentMasterId", getDepartmentMasterId());
		attributes.put("companyId", getCompanyId());
		attributes.put("createdBy", getCreatedBy());
		attributes.put("modifiedBy", getModifiedBy());
		attributes.put("groupId", getGroupId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("departmentName", getDepartmentName());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long departmentMasterId = (Long)attributes.get("departmentMasterId");

		if (departmentMasterId != null) {
			setDepartmentMasterId(departmentMasterId);
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

		String departmentName = (String)attributes.get("departmentName");

		if (departmentName != null) {
			setDepartmentName(departmentName);
		}
	}

	@Override
	public DepartmentMaster cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the company ID of this department master.
	 *
	 * @return the company ID of this department master
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this department master.
	 *
	 * @return the create date of this department master
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the created by of this department master.
	 *
	 * @return the created by of this department master
	 */
	@Override
	public long getCreatedBy() {
		return model.getCreatedBy();
	}

	/**
	 * Returns the department master ID of this department master.
	 *
	 * @return the department master ID of this department master
	 */
	@Override
	public long getDepartmentMasterId() {
		return model.getDepartmentMasterId();
	}

	/**
	 * Returns the department name of this department master.
	 *
	 * @return the department name of this department master
	 */
	@Override
	public String getDepartmentName() {
		return model.getDepartmentName();
	}

	/**
	 * Returns the group ID of this department master.
	 *
	 * @return the group ID of this department master
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified by of this department master.
	 *
	 * @return the modified by of this department master
	 */
	@Override
	public long getModifiedBy() {
		return model.getModifiedBy();
	}

	/**
	 * Returns the modified date of this department master.
	 *
	 * @return the modified date of this department master
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this department master.
	 *
	 * @return the primary key of this department master
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
	 * Sets the company ID of this department master.
	 *
	 * @param companyId the company ID of this department master
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this department master.
	 *
	 * @param createDate the create date of this department master
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the created by of this department master.
	 *
	 * @param createdBy the created by of this department master
	 */
	@Override
	public void setCreatedBy(long createdBy) {
		model.setCreatedBy(createdBy);
	}

	/**
	 * Sets the department master ID of this department master.
	 *
	 * @param departmentMasterId the department master ID of this department master
	 */
	@Override
	public void setDepartmentMasterId(long departmentMasterId) {
		model.setDepartmentMasterId(departmentMasterId);
	}

	/**
	 * Sets the department name of this department master.
	 *
	 * @param departmentName the department name of this department master
	 */
	@Override
	public void setDepartmentName(String departmentName) {
		model.setDepartmentName(departmentName);
	}

	/**
	 * Sets the group ID of this department master.
	 *
	 * @param groupId the group ID of this department master
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified by of this department master.
	 *
	 * @param modifiedBy the modified by of this department master
	 */
	@Override
	public void setModifiedBy(long modifiedBy) {
		model.setModifiedBy(modifiedBy);
	}

	/**
	 * Sets the modified date of this department master.
	 *
	 * @param modifiedDate the modified date of this department master
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this department master.
	 *
	 * @param primaryKey the primary key of this department master
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
	protected DepartmentMasterWrapper wrap(DepartmentMaster departmentMaster) {
		return new DepartmentMasterWrapper(departmentMaster);
	}

}