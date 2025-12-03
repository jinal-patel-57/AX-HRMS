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
 * This class is a wrapper for {@link EmployeeUanEsic}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeUanEsic
 * @generated
 */
public class EmployeeUanEsicWrapper
	extends BaseModelWrapper<EmployeeUanEsic>
	implements EmployeeUanEsic, ModelWrapper<EmployeeUanEsic> {

	public EmployeeUanEsicWrapper(EmployeeUanEsic employeeUanEsic) {
		super(employeeUanEsic);
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
		attributes.put("uanEsicId", getUanEsicId());
		attributes.put("uan", getUan());
		attributes.put("esicNo", getEsicNo());
		attributes.put("status", isStatus());

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

		Long uanEsicId = (Long)attributes.get("uanEsicId");

		if (uanEsicId != null) {
			setUanEsicId(uanEsicId);
		}

		String uan = (String)attributes.get("uan");

		if (uan != null) {
			setUan(uan);
		}

		String esicNo = (String)attributes.get("esicNo");

		if (esicNo != null) {
			setEsicNo(esicNo);
		}

		Boolean status = (Boolean)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}
	}

	@Override
	public EmployeeUanEsic cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the company ID of this employee uan esic.
	 *
	 * @return the company ID of this employee uan esic
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this employee uan esic.
	 *
	 * @return the create date of this employee uan esic
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the created by of this employee uan esic.
	 *
	 * @return the created by of this employee uan esic
	 */
	@Override
	public long getCreatedBy() {
		return model.getCreatedBy();
	}

	/**
	 * Returns the esic no of this employee uan esic.
	 *
	 * @return the esic no of this employee uan esic
	 */
	@Override
	public String getEsicNo() {
		return model.getEsicNo();
	}

	/**
	 * Returns the group ID of this employee uan esic.
	 *
	 * @return the group ID of this employee uan esic
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified by of this employee uan esic.
	 *
	 * @return the modified by of this employee uan esic
	 */
	@Override
	public long getModifiedBy() {
		return model.getModifiedBy();
	}

	/**
	 * Returns the modified date of this employee uan esic.
	 *
	 * @return the modified date of this employee uan esic
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this employee uan esic.
	 *
	 * @return the primary key of this employee uan esic
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the status of this employee uan esic.
	 *
	 * @return the status of this employee uan esic
	 */
	@Override
	public boolean getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the uan of this employee uan esic.
	 *
	 * @return the uan of this employee uan esic
	 */
	@Override
	public String getUan() {
		return model.getUan();
	}

	/**
	 * Returns the uan esic ID of this employee uan esic.
	 *
	 * @return the uan esic ID of this employee uan esic
	 */
	@Override
	public long getUanEsicId() {
		return model.getUanEsicId();
	}

	/**
	 * Returns the uuid of this employee uan esic.
	 *
	 * @return the uuid of this employee uan esic
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns <code>true</code> if this employee uan esic is status.
	 *
	 * @return <code>true</code> if this employee uan esic is status; <code>false</code> otherwise
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
	 * Sets the company ID of this employee uan esic.
	 *
	 * @param companyId the company ID of this employee uan esic
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this employee uan esic.
	 *
	 * @param createDate the create date of this employee uan esic
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the created by of this employee uan esic.
	 *
	 * @param createdBy the created by of this employee uan esic
	 */
	@Override
	public void setCreatedBy(long createdBy) {
		model.setCreatedBy(createdBy);
	}

	/**
	 * Sets the esic no of this employee uan esic.
	 *
	 * @param esicNo the esic no of this employee uan esic
	 */
	@Override
	public void setEsicNo(String esicNo) {
		model.setEsicNo(esicNo);
	}

	/**
	 * Sets the group ID of this employee uan esic.
	 *
	 * @param groupId the group ID of this employee uan esic
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified by of this employee uan esic.
	 *
	 * @param modifiedBy the modified by of this employee uan esic
	 */
	@Override
	public void setModifiedBy(long modifiedBy) {
		model.setModifiedBy(modifiedBy);
	}

	/**
	 * Sets the modified date of this employee uan esic.
	 *
	 * @param modifiedDate the modified date of this employee uan esic
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this employee uan esic.
	 *
	 * @param primaryKey the primary key of this employee uan esic
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets whether this employee uan esic is status.
	 *
	 * @param status the status of this employee uan esic
	 */
	@Override
	public void setStatus(boolean status) {
		model.setStatus(status);
	}

	/**
	 * Sets the uan of this employee uan esic.
	 *
	 * @param uan the uan of this employee uan esic
	 */
	@Override
	public void setUan(String uan) {
		model.setUan(uan);
	}

	/**
	 * Sets the uan esic ID of this employee uan esic.
	 *
	 * @param uanEsicId the uan esic ID of this employee uan esic
	 */
	@Override
	public void setUanEsicId(long uanEsicId) {
		model.setUanEsicId(uanEsicId);
	}

	/**
	 * Sets the uuid of this employee uan esic.
	 *
	 * @param uuid the uuid of this employee uan esic
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
	protected EmployeeUanEsicWrapper wrap(EmployeeUanEsic employeeUanEsic) {
		return new EmployeeUanEsicWrapper(employeeUanEsic);
	}

}