/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
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
 * This class is a wrapper for {@link BranchMaster}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see BranchMaster
 * @generated
 */
public class BranchMasterWrapper
	extends BaseModelWrapper<BranchMaster>
	implements BranchMaster, ModelWrapper<BranchMaster> {

	public BranchMasterWrapper(BranchMaster branchMaster) {
		super(branchMaster);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("branchMasterId", getBranchMasterId());
		attributes.put("companyId", getCompanyId());
		attributes.put("createdBy", getCreatedBy());
		attributes.put("modifiedBy", getModifiedBy());
		attributes.put("groupId", getGroupId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("branchName", getBranchName());
		attributes.put("addressId", getAddressId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long branchMasterId = (Long)attributes.get("branchMasterId");

		if (branchMasterId != null) {
			setBranchMasterId(branchMasterId);
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

		String branchName = (String)attributes.get("branchName");

		if (branchName != null) {
			setBranchName(branchName);
		}

		Long addressId = (Long)attributes.get("addressId");

		if (addressId != null) {
			setAddressId(addressId);
		}
	}

	@Override
	public BranchMaster cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the address ID of this branch master.
	 *
	 * @return the address ID of this branch master
	 */
	@Override
	public long getAddressId() {
		return model.getAddressId();
	}

	/**
	 * Returns the branch master ID of this branch master.
	 *
	 * @return the branch master ID of this branch master
	 */
	@Override
	public long getBranchMasterId() {
		return model.getBranchMasterId();
	}

	/**
	 * Returns the branch name of this branch master.
	 *
	 * @return the branch name of this branch master
	 */
	@Override
	public String getBranchName() {
		return model.getBranchName();
	}

	/**
	 * Returns the company ID of this branch master.
	 *
	 * @return the company ID of this branch master
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this branch master.
	 *
	 * @return the create date of this branch master
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the created by of this branch master.
	 *
	 * @return the created by of this branch master
	 */
	@Override
	public long getCreatedBy() {
		return model.getCreatedBy();
	}

	/**
	 * Returns the group ID of this branch master.
	 *
	 * @return the group ID of this branch master
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified by of this branch master.
	 *
	 * @return the modified by of this branch master
	 */
	@Override
	public long getModifiedBy() {
		return model.getModifiedBy();
	}

	/**
	 * Returns the modified date of this branch master.
	 *
	 * @return the modified date of this branch master
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this branch master.
	 *
	 * @return the primary key of this branch master
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
	 * Sets the address ID of this branch master.
	 *
	 * @param addressId the address ID of this branch master
	 */
	@Override
	public void setAddressId(long addressId) {
		model.setAddressId(addressId);
	}

	/**
	 * Sets the branch master ID of this branch master.
	 *
	 * @param branchMasterId the branch master ID of this branch master
	 */
	@Override
	public void setBranchMasterId(long branchMasterId) {
		model.setBranchMasterId(branchMasterId);
	}

	/**
	 * Sets the branch name of this branch master.
	 *
	 * @param branchName the branch name of this branch master
	 */
	@Override
	public void setBranchName(String branchName) {
		model.setBranchName(branchName);
	}

	/**
	 * Sets the company ID of this branch master.
	 *
	 * @param companyId the company ID of this branch master
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this branch master.
	 *
	 * @param createDate the create date of this branch master
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the created by of this branch master.
	 *
	 * @param createdBy the created by of this branch master
	 */
	@Override
	public void setCreatedBy(long createdBy) {
		model.setCreatedBy(createdBy);
	}

	/**
	 * Sets the group ID of this branch master.
	 *
	 * @param groupId the group ID of this branch master
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified by of this branch master.
	 *
	 * @param modifiedBy the modified by of this branch master
	 */
	@Override
	public void setModifiedBy(long modifiedBy) {
		model.setModifiedBy(modifiedBy);
	}

	/**
	 * Sets the modified date of this branch master.
	 *
	 * @param modifiedDate the modified date of this branch master
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this branch master.
	 *
	 * @param primaryKey the primary key of this branch master
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
	protected BranchMasterWrapper wrap(BranchMaster branchMaster) {
		return new BranchMasterWrapper(branchMaster);
	}

}