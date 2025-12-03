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
 * This class is a wrapper for {@link Policy}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Policy
 * @generated
 */
public class PolicyWrapper
	extends BaseModelWrapper<Policy> implements ModelWrapper<Policy>, Policy {

	public PolicyWrapper(Policy policy) {
		super(policy);
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
		attributes.put("policyId", getPolicyId());
		attributes.put("policyName", getPolicyName());
		attributes.put("policyDescription", getPolicyDescription());
		attributes.put("year", getYear());
		attributes.put("status", getStatus());
		attributes.put("policyTypeId", getPolicyTypeId());
		attributes.put("policyDocumentId", getPolicyDocumentId());
		attributes.put("applicableDate", getApplicableDate());

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

		Long policyId = (Long)attributes.get("policyId");

		if (policyId != null) {
			setPolicyId(policyId);
		}

		String policyName = (String)attributes.get("policyName");

		if (policyName != null) {
			setPolicyName(policyName);
		}

		String policyDescription = (String)attributes.get("policyDescription");

		if (policyDescription != null) {
			setPolicyDescription(policyDescription);
		}

		Integer year = (Integer)attributes.get("year");

		if (year != null) {
			setYear(year);
		}

		Boolean status = (Boolean)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		Long policyTypeId = (Long)attributes.get("policyTypeId");

		if (policyTypeId != null) {
			setPolicyTypeId(policyTypeId);
		}

		Long policyDocumentId = (Long)attributes.get("policyDocumentId");

		if (policyDocumentId != null) {
			setPolicyDocumentId(policyDocumentId);
		}

		Date applicableDate = (Date)attributes.get("applicableDate");

		if (applicableDate != null) {
			setApplicableDate(applicableDate);
		}
	}

	@Override
	public Policy cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the applicable date of this policy.
	 *
	 * @return the applicable date of this policy
	 */
	@Override
	public Date getApplicableDate() {
		return model.getApplicableDate();
	}

	/**
	 * Returns the company ID of this policy.
	 *
	 * @return the company ID of this policy
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this policy.
	 *
	 * @return the create date of this policy
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the created by of this policy.
	 *
	 * @return the created by of this policy
	 */
	@Override
	public long getCreatedBy() {
		return model.getCreatedBy();
	}

	/**
	 * Returns the group ID of this policy.
	 *
	 * @return the group ID of this policy
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified by of this policy.
	 *
	 * @return the modified by of this policy
	 */
	@Override
	public long getModifiedBy() {
		return model.getModifiedBy();
	}

	/**
	 * Returns the modified date of this policy.
	 *
	 * @return the modified date of this policy
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the policy description of this policy.
	 *
	 * @return the policy description of this policy
	 */
	@Override
	public String getPolicyDescription() {
		return model.getPolicyDescription();
	}

	/**
	 * Returns the policy document ID of this policy.
	 *
	 * @return the policy document ID of this policy
	 */
	@Override
	public long getPolicyDocumentId() {
		return model.getPolicyDocumentId();
	}

	/**
	 * Returns the policy ID of this policy.
	 *
	 * @return the policy ID of this policy
	 */
	@Override
	public long getPolicyId() {
		return model.getPolicyId();
	}

	/**
	 * Returns the policy name of this policy.
	 *
	 * @return the policy name of this policy
	 */
	@Override
	public String getPolicyName() {
		return model.getPolicyName();
	}

	/**
	 * Returns the policy type ID of this policy.
	 *
	 * @return the policy type ID of this policy
	 */
	@Override
	public long getPolicyTypeId() {
		return model.getPolicyTypeId();
	}

	/**
	 * Returns the primary key of this policy.
	 *
	 * @return the primary key of this policy
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the status of this policy.
	 *
	 * @return the status of this policy
	 */
	@Override
	public Boolean getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the uuid of this policy.
	 *
	 * @return the uuid of this policy
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns the year of this policy.
	 *
	 * @return the year of this policy
	 */
	@Override
	public int getYear() {
		return model.getYear();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the applicable date of this policy.
	 *
	 * @param applicableDate the applicable date of this policy
	 */
	@Override
	public void setApplicableDate(Date applicableDate) {
		model.setApplicableDate(applicableDate);
	}

	/**
	 * Sets the company ID of this policy.
	 *
	 * @param companyId the company ID of this policy
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this policy.
	 *
	 * @param createDate the create date of this policy
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the created by of this policy.
	 *
	 * @param createdBy the created by of this policy
	 */
	@Override
	public void setCreatedBy(long createdBy) {
		model.setCreatedBy(createdBy);
	}

	/**
	 * Sets the group ID of this policy.
	 *
	 * @param groupId the group ID of this policy
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified by of this policy.
	 *
	 * @param modifiedBy the modified by of this policy
	 */
	@Override
	public void setModifiedBy(long modifiedBy) {
		model.setModifiedBy(modifiedBy);
	}

	/**
	 * Sets the modified date of this policy.
	 *
	 * @param modifiedDate the modified date of this policy
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the policy description of this policy.
	 *
	 * @param policyDescription the policy description of this policy
	 */
	@Override
	public void setPolicyDescription(String policyDescription) {
		model.setPolicyDescription(policyDescription);
	}

	/**
	 * Sets the policy document ID of this policy.
	 *
	 * @param policyDocumentId the policy document ID of this policy
	 */
	@Override
	public void setPolicyDocumentId(long policyDocumentId) {
		model.setPolicyDocumentId(policyDocumentId);
	}

	/**
	 * Sets the policy ID of this policy.
	 *
	 * @param policyId the policy ID of this policy
	 */
	@Override
	public void setPolicyId(long policyId) {
		model.setPolicyId(policyId);
	}

	/**
	 * Sets the policy name of this policy.
	 *
	 * @param policyName the policy name of this policy
	 */
	@Override
	public void setPolicyName(String policyName) {
		model.setPolicyName(policyName);
	}

	/**
	 * Sets the policy type ID of this policy.
	 *
	 * @param policyTypeId the policy type ID of this policy
	 */
	@Override
	public void setPolicyTypeId(long policyTypeId) {
		model.setPolicyTypeId(policyTypeId);
	}

	/**
	 * Sets the primary key of this policy.
	 *
	 * @param primaryKey the primary key of this policy
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the status of this policy.
	 *
	 * @param status the status of this policy
	 */
	@Override
	public void setStatus(Boolean status) {
		model.setStatus(status);
	}

	/**
	 * Sets the uuid of this policy.
	 *
	 * @param uuid the uuid of this policy
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	/**
	 * Sets the year of this policy.
	 *
	 * @param year the year of this policy
	 */
	@Override
	public void setYear(int year) {
		model.setYear(year);
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
	protected PolicyWrapper wrap(Policy policy) {
		return new PolicyWrapper(policy);
	}

}