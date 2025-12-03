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
 * This class is a wrapper for {@link EmployeeAddress}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeAddress
 * @generated
 */
public class EmployeeAddressWrapper
	extends BaseModelWrapper<EmployeeAddress>
	implements EmployeeAddress, ModelWrapper<EmployeeAddress> {

	public EmployeeAddressWrapper(EmployeeAddress employeeAddress) {
		super(employeeAddress);
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
		attributes.put("employeeAddressId", getEmployeeAddressId());
		attributes.put("presentAddress", getPresentAddress());
		attributes.put("permanentAddress", getPermanentAddress());
		attributes.put("presentPermanentSame", isPresentPermanentSame());
		attributes.put("status", isStatus());
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

		Long employeeAddressId = (Long)attributes.get("employeeAddressId");

		if (employeeAddressId != null) {
			setEmployeeAddressId(employeeAddressId);
		}

		Long presentAddress = (Long)attributes.get("presentAddress");

		if (presentAddress != null) {
			setPresentAddress(presentAddress);
		}

		Long permanentAddress = (Long)attributes.get("permanentAddress");

		if (permanentAddress != null) {
			setPermanentAddress(permanentAddress);
		}

		Boolean presentPermanentSame = (Boolean)attributes.get(
			"presentPermanentSame");

		if (presentPermanentSame != null) {
			setPresentPermanentSame(presentPermanentSame);
		}

		Boolean status = (Boolean)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		Long employeeId = (Long)attributes.get("employeeId");

		if (employeeId != null) {
			setEmployeeId(employeeId);
		}
	}

	@Override
	public EmployeeAddress cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the company ID of this employee address.
	 *
	 * @return the company ID of this employee address
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this employee address.
	 *
	 * @return the create date of this employee address
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the created by of this employee address.
	 *
	 * @return the created by of this employee address
	 */
	@Override
	public long getCreatedBy() {
		return model.getCreatedBy();
	}

	/**
	 * Returns the employee address ID of this employee address.
	 *
	 * @return the employee address ID of this employee address
	 */
	@Override
	public long getEmployeeAddressId() {
		return model.getEmployeeAddressId();
	}

	/**
	 * Returns the employee ID of this employee address.
	 *
	 * @return the employee ID of this employee address
	 */
	@Override
	public long getEmployeeId() {
		return model.getEmployeeId();
	}

	/**
	 * Returns the group ID of this employee address.
	 *
	 * @return the group ID of this employee address
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified by of this employee address.
	 *
	 * @return the modified by of this employee address
	 */
	@Override
	public long getModifiedBy() {
		return model.getModifiedBy();
	}

	/**
	 * Returns the modified date of this employee address.
	 *
	 * @return the modified date of this employee address
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the permanent address of this employee address.
	 *
	 * @return the permanent address of this employee address
	 */
	@Override
	public long getPermanentAddress() {
		return model.getPermanentAddress();
	}

	/**
	 * Returns the present address of this employee address.
	 *
	 * @return the present address of this employee address
	 */
	@Override
	public long getPresentAddress() {
		return model.getPresentAddress();
	}

	/**
	 * Returns the present permanent same of this employee address.
	 *
	 * @return the present permanent same of this employee address
	 */
	@Override
	public boolean getPresentPermanentSame() {
		return model.getPresentPermanentSame();
	}

	/**
	 * Returns the primary key of this employee address.
	 *
	 * @return the primary key of this employee address
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the status of this employee address.
	 *
	 * @return the status of this employee address
	 */
	@Override
	public boolean getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the uuid of this employee address.
	 *
	 * @return the uuid of this employee address
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns <code>true</code> if this employee address is present permanent same.
	 *
	 * @return <code>true</code> if this employee address is present permanent same; <code>false</code> otherwise
	 */
	@Override
	public boolean isPresentPermanentSame() {
		return model.isPresentPermanentSame();
	}

	/**
	 * Returns <code>true</code> if this employee address is status.
	 *
	 * @return <code>true</code> if this employee address is status; <code>false</code> otherwise
	 */
	@Override
	public boolean isStatus() {
		return model.isStatus();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the company ID of this employee address.
	 *
	 * @param companyId the company ID of this employee address
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this employee address.
	 *
	 * @param createDate the create date of this employee address
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the created by of this employee address.
	 *
	 * @param createdBy the created by of this employee address
	 */
	@Override
	public void setCreatedBy(long createdBy) {
		model.setCreatedBy(createdBy);
	}

	/**
	 * Sets the employee address ID of this employee address.
	 *
	 * @param employeeAddressId the employee address ID of this employee address
	 */
	@Override
	public void setEmployeeAddressId(long employeeAddressId) {
		model.setEmployeeAddressId(employeeAddressId);
	}

	/**
	 * Sets the employee ID of this employee address.
	 *
	 * @param employeeId the employee ID of this employee address
	 */
	@Override
	public void setEmployeeId(long employeeId) {
		model.setEmployeeId(employeeId);
	}

	/**
	 * Sets the group ID of this employee address.
	 *
	 * @param groupId the group ID of this employee address
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified by of this employee address.
	 *
	 * @param modifiedBy the modified by of this employee address
	 */
	@Override
	public void setModifiedBy(long modifiedBy) {
		model.setModifiedBy(modifiedBy);
	}

	/**
	 * Sets the modified date of this employee address.
	 *
	 * @param modifiedDate the modified date of this employee address
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the permanent address of this employee address.
	 *
	 * @param permanentAddress the permanent address of this employee address
	 */
	@Override
	public void setPermanentAddress(long permanentAddress) {
		model.setPermanentAddress(permanentAddress);
	}

	/**
	 * Sets the present address of this employee address.
	 *
	 * @param presentAddress the present address of this employee address
	 */
	@Override
	public void setPresentAddress(long presentAddress) {
		model.setPresentAddress(presentAddress);
	}

	/**
	 * Sets whether this employee address is present permanent same.
	 *
	 * @param presentPermanentSame the present permanent same of this employee address
	 */
	@Override
	public void setPresentPermanentSame(boolean presentPermanentSame) {
		model.setPresentPermanentSame(presentPermanentSame);
	}

	/**
	 * Sets the primary key of this employee address.
	 *
	 * @param primaryKey the primary key of this employee address
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets whether this employee address is status.
	 *
	 * @param status the status of this employee address
	 */
	@Override
	public void setStatus(boolean status) {
		model.setStatus(status);
	}

	/**
	 * Sets the uuid of this employee address.
	 *
	 * @param uuid the uuid of this employee address
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
	protected EmployeeAddressWrapper wrap(EmployeeAddress employeeAddress) {
		return new EmployeeAddressWrapper(employeeAddress);
	}

}