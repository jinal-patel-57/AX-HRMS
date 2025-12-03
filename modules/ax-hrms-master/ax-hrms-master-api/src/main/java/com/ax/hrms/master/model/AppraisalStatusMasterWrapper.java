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
 * This class is a wrapper for {@link AppraisalStatusMaster}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AppraisalStatusMaster
 * @generated
 */
public class AppraisalStatusMasterWrapper
	extends BaseModelWrapper<AppraisalStatusMaster>
	implements AppraisalStatusMaster, ModelWrapper<AppraisalStatusMaster> {

	public AppraisalStatusMasterWrapper(
		AppraisalStatusMaster appraisalStatusMaster) {

		super(appraisalStatusMaster);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("appraisalStatusMasterId", getAppraisalStatusMasterId());
		attributes.put("companyId", getCompanyId());
		attributes.put("createdBy", getCreatedBy());
		attributes.put("modifiedBy", getModifiedBy());
		attributes.put("groupId", getGroupId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("status", getStatus());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long appraisalStatusMasterId = (Long)attributes.get(
			"appraisalStatusMasterId");

		if (appraisalStatusMasterId != null) {
			setAppraisalStatusMasterId(appraisalStatusMasterId);
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

		String status = (String)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}
	}

	@Override
	public AppraisalStatusMaster cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the appraisal status master ID of this appraisal status master.
	 *
	 * @return the appraisal status master ID of this appraisal status master
	 */
	@Override
	public long getAppraisalStatusMasterId() {
		return model.getAppraisalStatusMasterId();
	}

	/**
	 * Returns the company ID of this appraisal status master.
	 *
	 * @return the company ID of this appraisal status master
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this appraisal status master.
	 *
	 * @return the create date of this appraisal status master
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the created by of this appraisal status master.
	 *
	 * @return the created by of this appraisal status master
	 */
	@Override
	public long getCreatedBy() {
		return model.getCreatedBy();
	}

	/**
	 * Returns the group ID of this appraisal status master.
	 *
	 * @return the group ID of this appraisal status master
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified by of this appraisal status master.
	 *
	 * @return the modified by of this appraisal status master
	 */
	@Override
	public long getModifiedBy() {
		return model.getModifiedBy();
	}

	/**
	 * Returns the modified date of this appraisal status master.
	 *
	 * @return the modified date of this appraisal status master
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this appraisal status master.
	 *
	 * @return the primary key of this appraisal status master
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the status of this appraisal status master.
	 *
	 * @return the status of this appraisal status master
	 */
	@Override
	public String getStatus() {
		return model.getStatus();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the appraisal status master ID of this appraisal status master.
	 *
	 * @param appraisalStatusMasterId the appraisal status master ID of this appraisal status master
	 */
	@Override
	public void setAppraisalStatusMasterId(long appraisalStatusMasterId) {
		model.setAppraisalStatusMasterId(appraisalStatusMasterId);
	}

	/**
	 * Sets the company ID of this appraisal status master.
	 *
	 * @param companyId the company ID of this appraisal status master
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this appraisal status master.
	 *
	 * @param createDate the create date of this appraisal status master
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the created by of this appraisal status master.
	 *
	 * @param createdBy the created by of this appraisal status master
	 */
	@Override
	public void setCreatedBy(long createdBy) {
		model.setCreatedBy(createdBy);
	}

	/**
	 * Sets the group ID of this appraisal status master.
	 *
	 * @param groupId the group ID of this appraisal status master
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified by of this appraisal status master.
	 *
	 * @param modifiedBy the modified by of this appraisal status master
	 */
	@Override
	public void setModifiedBy(long modifiedBy) {
		model.setModifiedBy(modifiedBy);
	}

	/**
	 * Sets the modified date of this appraisal status master.
	 *
	 * @param modifiedDate the modified date of this appraisal status master
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this appraisal status master.
	 *
	 * @param primaryKey the primary key of this appraisal status master
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the status of this appraisal status master.
	 *
	 * @param status the status of this appraisal status master
	 */
	@Override
	public void setStatus(String status) {
		model.setStatus(status);
	}

	@Override
	public String toXmlString() {
		return model.toXmlString();
	}

	@Override
	protected AppraisalStatusMasterWrapper wrap(
		AppraisalStatusMaster appraisalStatusMaster) {

		return new AppraisalStatusMasterWrapper(appraisalStatusMaster);
	}

}