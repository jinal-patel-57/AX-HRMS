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
 * This class is a wrapper for {@link WishTypeMaster}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see WishTypeMaster
 * @generated
 */
public class WishTypeMasterWrapper
	extends BaseModelWrapper<WishTypeMaster>
	implements ModelWrapper<WishTypeMaster>, WishTypeMaster {

	public WishTypeMasterWrapper(WishTypeMaster wishTypeMaster) {
		super(wishTypeMaster);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("wishTypeMasterId", getWishTypeMasterId());
		attributes.put("companyId", getCompanyId());
		attributes.put("createdBy", getCreatedBy());
		attributes.put("modifiedBy", getModifiedBy());
		attributes.put("groupId", getGroupId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("wishType", getWishType());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long wishTypeMasterId = (Long)attributes.get("wishTypeMasterId");

		if (wishTypeMasterId != null) {
			setWishTypeMasterId(wishTypeMasterId);
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

		String wishType = (String)attributes.get("wishType");

		if (wishType != null) {
			setWishType(wishType);
		}
	}

	@Override
	public WishTypeMaster cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the company ID of this wish type master.
	 *
	 * @return the company ID of this wish type master
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this wish type master.
	 *
	 * @return the create date of this wish type master
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the created by of this wish type master.
	 *
	 * @return the created by of this wish type master
	 */
	@Override
	public long getCreatedBy() {
		return model.getCreatedBy();
	}

	/**
	 * Returns the group ID of this wish type master.
	 *
	 * @return the group ID of this wish type master
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified by of this wish type master.
	 *
	 * @return the modified by of this wish type master
	 */
	@Override
	public long getModifiedBy() {
		return model.getModifiedBy();
	}

	/**
	 * Returns the modified date of this wish type master.
	 *
	 * @return the modified date of this wish type master
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this wish type master.
	 *
	 * @return the primary key of this wish type master
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the wish type of this wish type master.
	 *
	 * @return the wish type of this wish type master
	 */
	@Override
	public String getWishType() {
		return model.getWishType();
	}

	/**
	 * Returns the wish type master ID of this wish type master.
	 *
	 * @return the wish type master ID of this wish type master
	 */
	@Override
	public long getWishTypeMasterId() {
		return model.getWishTypeMasterId();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the company ID of this wish type master.
	 *
	 * @param companyId the company ID of this wish type master
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this wish type master.
	 *
	 * @param createDate the create date of this wish type master
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the created by of this wish type master.
	 *
	 * @param createdBy the created by of this wish type master
	 */
	@Override
	public void setCreatedBy(long createdBy) {
		model.setCreatedBy(createdBy);
	}

	/**
	 * Sets the group ID of this wish type master.
	 *
	 * @param groupId the group ID of this wish type master
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified by of this wish type master.
	 *
	 * @param modifiedBy the modified by of this wish type master
	 */
	@Override
	public void setModifiedBy(long modifiedBy) {
		model.setModifiedBy(modifiedBy);
	}

	/**
	 * Sets the modified date of this wish type master.
	 *
	 * @param modifiedDate the modified date of this wish type master
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this wish type master.
	 *
	 * @param primaryKey the primary key of this wish type master
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the wish type of this wish type master.
	 *
	 * @param wishType the wish type of this wish type master
	 */
	@Override
	public void setWishType(String wishType) {
		model.setWishType(wishType);
	}

	/**
	 * Sets the wish type master ID of this wish type master.
	 *
	 * @param wishTypeMasterId the wish type master ID of this wish type master
	 */
	@Override
	public void setWishTypeMasterId(long wishTypeMasterId) {
		model.setWishTypeMasterId(wishTypeMasterId);
	}

	@Override
	public String toXmlString() {
		return model.toXmlString();
	}

	@Override
	protected WishTypeMasterWrapper wrap(WishTypeMaster wishTypeMaster) {
		return new WishTypeMasterWrapper(wishTypeMaster);
	}

}