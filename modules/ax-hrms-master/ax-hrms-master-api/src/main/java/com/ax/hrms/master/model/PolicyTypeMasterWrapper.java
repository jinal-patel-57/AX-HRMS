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
 * This class is a wrapper for {@link PolicyTypeMaster}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PolicyTypeMaster
 * @generated
 */
public class PolicyTypeMasterWrapper
	extends BaseModelWrapper<PolicyTypeMaster>
	implements ModelWrapper<PolicyTypeMaster>, PolicyTypeMaster {

	public PolicyTypeMasterWrapper(PolicyTypeMaster policyTypeMaster) {
		super(policyTypeMaster);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("policyTypeMasterID", getPolicyTypeMasterID());
		attributes.put("companyId", getCompanyId());
		attributes.put("createdBy", getCreatedBy());
		attributes.put("modifiedBy", getModifiedBy());
		attributes.put("groupId", getGroupId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("policyType", getPolicyType());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long policyTypeMasterID = (Long)attributes.get("policyTypeMasterID");

		if (policyTypeMasterID != null) {
			setPolicyTypeMasterID(policyTypeMasterID);
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

		String policyType = (String)attributes.get("policyType");

		if (policyType != null) {
			setPolicyType(policyType);
		}
	}

	@Override
	public PolicyTypeMaster cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the company ID of this policy type master.
	 *
	 * @return the company ID of this policy type master
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this policy type master.
	 *
	 * @return the create date of this policy type master
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the created by of this policy type master.
	 *
	 * @return the created by of this policy type master
	 */
	@Override
	public long getCreatedBy() {
		return model.getCreatedBy();
	}

	/**
	 * Returns the group ID of this policy type master.
	 *
	 * @return the group ID of this policy type master
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified by of this policy type master.
	 *
	 * @return the modified by of this policy type master
	 */
	@Override
	public long getModifiedBy() {
		return model.getModifiedBy();
	}

	/**
	 * Returns the modified date of this policy type master.
	 *
	 * @return the modified date of this policy type master
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the policy type of this policy type master.
	 *
	 * @return the policy type of this policy type master
	 */
	@Override
	public String getPolicyType() {
		return model.getPolicyType();
	}

	/**
	 * Returns the policy type master ID of this policy type master.
	 *
	 * @return the policy type master ID of this policy type master
	 */
	@Override
	public long getPolicyTypeMasterID() {
		return model.getPolicyTypeMasterID();
	}

	/**
	 * Returns the primary key of this policy type master.
	 *
	 * @return the primary key of this policy type master
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
	 * Sets the company ID of this policy type master.
	 *
	 * @param companyId the company ID of this policy type master
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this policy type master.
	 *
	 * @param createDate the create date of this policy type master
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the created by of this policy type master.
	 *
	 * @param createdBy the created by of this policy type master
	 */
	@Override
	public void setCreatedBy(long createdBy) {
		model.setCreatedBy(createdBy);
	}

	/**
	 * Sets the group ID of this policy type master.
	 *
	 * @param groupId the group ID of this policy type master
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified by of this policy type master.
	 *
	 * @param modifiedBy the modified by of this policy type master
	 */
	@Override
	public void setModifiedBy(long modifiedBy) {
		model.setModifiedBy(modifiedBy);
	}

	/**
	 * Sets the modified date of this policy type master.
	 *
	 * @param modifiedDate the modified date of this policy type master
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the policy type of this policy type master.
	 *
	 * @param policyType the policy type of this policy type master
	 */
	@Override
	public void setPolicyType(String policyType) {
		model.setPolicyType(policyType);
	}

	/**
	 * Sets the policy type master ID of this policy type master.
	 *
	 * @param policyTypeMasterID the policy type master ID of this policy type master
	 */
	@Override
	public void setPolicyTypeMasterID(long policyTypeMasterID) {
		model.setPolicyTypeMasterID(policyTypeMasterID);
	}

	/**
	 * Sets the primary key of this policy type master.
	 *
	 * @param primaryKey the primary key of this policy type master
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
	protected PolicyTypeMasterWrapper wrap(PolicyTypeMaster policyTypeMaster) {
		return new PolicyTypeMasterWrapper(policyTypeMaster);
	}

}