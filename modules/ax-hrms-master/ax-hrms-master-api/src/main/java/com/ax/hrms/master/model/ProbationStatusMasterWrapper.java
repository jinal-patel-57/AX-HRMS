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
 * This class is a wrapper for {@link ProbationStatusMaster}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProbationStatusMaster
 * @generated
 */
public class ProbationStatusMasterWrapper
	extends BaseModelWrapper<ProbationStatusMaster>
	implements ModelWrapper<ProbationStatusMaster>, ProbationStatusMaster {

	public ProbationStatusMasterWrapper(
		ProbationStatusMaster probationStatusMaster) {

		super(probationStatusMaster);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("probationStatusMasterId", getProbationStatusMasterId());
		attributes.put("companyId", getCompanyId());
		attributes.put("createdBy", getCreatedBy());
		attributes.put("modifiedBy", getModifiedBy());
		attributes.put("groupId", getGroupId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("statusType", getStatusType());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long probationStatusMasterId = (Long)attributes.get(
			"probationStatusMasterId");

		if (probationStatusMasterId != null) {
			setProbationStatusMasterId(probationStatusMasterId);
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

		String statusType = (String)attributes.get("statusType");

		if (statusType != null) {
			setStatusType(statusType);
		}
	}

	@Override
	public ProbationStatusMaster cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the company ID of this probation status master.
	 *
	 * @return the company ID of this probation status master
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this probation status master.
	 *
	 * @return the create date of this probation status master
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the created by of this probation status master.
	 *
	 * @return the created by of this probation status master
	 */
	@Override
	public long getCreatedBy() {
		return model.getCreatedBy();
	}

	/**
	 * Returns the group ID of this probation status master.
	 *
	 * @return the group ID of this probation status master
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified by of this probation status master.
	 *
	 * @return the modified by of this probation status master
	 */
	@Override
	public long getModifiedBy() {
		return model.getModifiedBy();
	}

	/**
	 * Returns the modified date of this probation status master.
	 *
	 * @return the modified date of this probation status master
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this probation status master.
	 *
	 * @return the primary key of this probation status master
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the probation status master ID of this probation status master.
	 *
	 * @return the probation status master ID of this probation status master
	 */
	@Override
	public long getProbationStatusMasterId() {
		return model.getProbationStatusMasterId();
	}

	/**
	 * Returns the status type of this probation status master.
	 *
	 * @return the status type of this probation status master
	 */
	@Override
	public String getStatusType() {
		return model.getStatusType();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the company ID of this probation status master.
	 *
	 * @param companyId the company ID of this probation status master
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this probation status master.
	 *
	 * @param createDate the create date of this probation status master
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the created by of this probation status master.
	 *
	 * @param createdBy the created by of this probation status master
	 */
	@Override
	public void setCreatedBy(long createdBy) {
		model.setCreatedBy(createdBy);
	}

	/**
	 * Sets the group ID of this probation status master.
	 *
	 * @param groupId the group ID of this probation status master
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified by of this probation status master.
	 *
	 * @param modifiedBy the modified by of this probation status master
	 */
	@Override
	public void setModifiedBy(long modifiedBy) {
		model.setModifiedBy(modifiedBy);
	}

	/**
	 * Sets the modified date of this probation status master.
	 *
	 * @param modifiedDate the modified date of this probation status master
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this probation status master.
	 *
	 * @param primaryKey the primary key of this probation status master
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the probation status master ID of this probation status master.
	 *
	 * @param probationStatusMasterId the probation status master ID of this probation status master
	 */
	@Override
	public void setProbationStatusMasterId(long probationStatusMasterId) {
		model.setProbationStatusMasterId(probationStatusMasterId);
	}

	/**
	 * Sets the status type of this probation status master.
	 *
	 * @param statusType the status type of this probation status master
	 */
	@Override
	public void setStatusType(String statusType) {
		model.setStatusType(statusType);
	}

	@Override
	public String toXmlString() {
		return model.toXmlString();
	}

	@Override
	protected ProbationStatusMasterWrapper wrap(
		ProbationStatusMaster probationStatusMaster) {

		return new ProbationStatusMasterWrapper(probationStatusMaster);
	}

}