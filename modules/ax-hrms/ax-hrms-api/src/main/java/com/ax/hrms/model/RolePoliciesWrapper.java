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
 * This class is a wrapper for {@link RolePolicies}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see RolePolicies
 * @generated
 */
public class RolePoliciesWrapper
	extends BaseModelWrapper<RolePolicies>
	implements ModelWrapper<RolePolicies>, RolePolicies {

	public RolePoliciesWrapper(RolePolicies rolePolicies) {
		super(rolePolicies);
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
		attributes.put("rolePoliciesId", getRolePoliciesId());
		attributes.put("roleId", getRoleId());
		attributes.put("policyId", getPolicyId());

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

		Long rolePoliciesId = (Long)attributes.get("rolePoliciesId");

		if (rolePoliciesId != null) {
			setRolePoliciesId(rolePoliciesId);
		}

		Long roleId = (Long)attributes.get("roleId");

		if (roleId != null) {
			setRoleId(roleId);
		}

		Long policyId = (Long)attributes.get("policyId");

		if (policyId != null) {
			setPolicyId(policyId);
		}
	}

	@Override
	public RolePolicies cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the company ID of this role policies.
	 *
	 * @return the company ID of this role policies
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this role policies.
	 *
	 * @return the create date of this role policies
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the created by of this role policies.
	 *
	 * @return the created by of this role policies
	 */
	@Override
	public long getCreatedBy() {
		return model.getCreatedBy();
	}

	/**
	 * Returns the group ID of this role policies.
	 *
	 * @return the group ID of this role policies
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified by of this role policies.
	 *
	 * @return the modified by of this role policies
	 */
	@Override
	public long getModifiedBy() {
		return model.getModifiedBy();
	}

	/**
	 * Returns the modified date of this role policies.
	 *
	 * @return the modified date of this role policies
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the policy ID of this role policies.
	 *
	 * @return the policy ID of this role policies
	 */
	@Override
	public long getPolicyId() {
		return model.getPolicyId();
	}

	/**
	 * Returns the primary key of this role policies.
	 *
	 * @return the primary key of this role policies
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the role ID of this role policies.
	 *
	 * @return the role ID of this role policies
	 */
	@Override
	public long getRoleId() {
		return model.getRoleId();
	}

	/**
	 * Returns the role policies ID of this role policies.
	 *
	 * @return the role policies ID of this role policies
	 */
	@Override
	public long getRolePoliciesId() {
		return model.getRolePoliciesId();
	}

	/**
	 * Returns the uuid of this role policies.
	 *
	 * @return the uuid of this role policies
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the company ID of this role policies.
	 *
	 * @param companyId the company ID of this role policies
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this role policies.
	 *
	 * @param createDate the create date of this role policies
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the created by of this role policies.
	 *
	 * @param createdBy the created by of this role policies
	 */
	@Override
	public void setCreatedBy(long createdBy) {
		model.setCreatedBy(createdBy);
	}

	/**
	 * Sets the group ID of this role policies.
	 *
	 * @param groupId the group ID of this role policies
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified by of this role policies.
	 *
	 * @param modifiedBy the modified by of this role policies
	 */
	@Override
	public void setModifiedBy(long modifiedBy) {
		model.setModifiedBy(modifiedBy);
	}

	/**
	 * Sets the modified date of this role policies.
	 *
	 * @param modifiedDate the modified date of this role policies
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the policy ID of this role policies.
	 *
	 * @param policyId the policy ID of this role policies
	 */
	@Override
	public void setPolicyId(long policyId) {
		model.setPolicyId(policyId);
	}

	/**
	 * Sets the primary key of this role policies.
	 *
	 * @param primaryKey the primary key of this role policies
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the role ID of this role policies.
	 *
	 * @param roleId the role ID of this role policies
	 */
	@Override
	public void setRoleId(long roleId) {
		model.setRoleId(roleId);
	}

	/**
	 * Sets the role policies ID of this role policies.
	 *
	 * @param rolePoliciesId the role policies ID of this role policies
	 */
	@Override
	public void setRolePoliciesId(long rolePoliciesId) {
		model.setRolePoliciesId(rolePoliciesId);
	}

	/**
	 * Sets the uuid of this role policies.
	 *
	 * @param uuid the uuid of this role policies
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
	protected RolePoliciesWrapper wrap(RolePolicies rolePolicies) {
		return new RolePoliciesWrapper(rolePolicies);
	}

}