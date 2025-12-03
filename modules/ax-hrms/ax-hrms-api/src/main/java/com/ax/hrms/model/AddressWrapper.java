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
 * This class is a wrapper for {@link Address}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Address
 * @generated
 */
public class AddressWrapper
	extends BaseModelWrapper<Address>
	implements Address, ModelWrapper<Address> {

	public AddressWrapper(Address address) {
		super(address);
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
		attributes.put("addressId", getAddressId());
		attributes.put("line1", getLine1());
		attributes.put("line2", getLine2());
		attributes.put("line3", getLine3());
		attributes.put("state", getState());
		attributes.put("country", getCountry());
		attributes.put("pincode", getPincode());

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

		Long addressId = (Long)attributes.get("addressId");

		if (addressId != null) {
			setAddressId(addressId);
		}

		String line1 = (String)attributes.get("line1");

		if (line1 != null) {
			setLine1(line1);
		}

		String line2 = (String)attributes.get("line2");

		if (line2 != null) {
			setLine2(line2);
		}

		String line3 = (String)attributes.get("line3");

		if (line3 != null) {
			setLine3(line3);
		}

		String state = (String)attributes.get("state");

		if (state != null) {
			setState(state);
		}

		Long country = (Long)attributes.get("country");

		if (country != null) {
			setCountry(country);
		}

		String pincode = (String)attributes.get("pincode");

		if (pincode != null) {
			setPincode(pincode);
		}
	}

	@Override
	public Address cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the address ID of this address.
	 *
	 * @return the address ID of this address
	 */
	@Override
	public long getAddressId() {
		return model.getAddressId();
	}

	/**
	 * Returns the company ID of this address.
	 *
	 * @return the company ID of this address
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the country of this address.
	 *
	 * @return the country of this address
	 */
	@Override
	public long getCountry() {
		return model.getCountry();
	}

	/**
	 * Returns the create date of this address.
	 *
	 * @return the create date of this address
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the created by of this address.
	 *
	 * @return the created by of this address
	 */
	@Override
	public long getCreatedBy() {
		return model.getCreatedBy();
	}

	/**
	 * Returns the group ID of this address.
	 *
	 * @return the group ID of this address
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the line1 of this address.
	 *
	 * @return the line1 of this address
	 */
	@Override
	public String getLine1() {
		return model.getLine1();
	}

	/**
	 * Returns the line2 of this address.
	 *
	 * @return the line2 of this address
	 */
	@Override
	public String getLine2() {
		return model.getLine2();
	}

	/**
	 * Returns the line3 of this address.
	 *
	 * @return the line3 of this address
	 */
	@Override
	public String getLine3() {
		return model.getLine3();
	}

	/**
	 * Returns the modified by of this address.
	 *
	 * @return the modified by of this address
	 */
	@Override
	public long getModifiedBy() {
		return model.getModifiedBy();
	}

	/**
	 * Returns the modified date of this address.
	 *
	 * @return the modified date of this address
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the pincode of this address.
	 *
	 * @return the pincode of this address
	 */
	@Override
	public String getPincode() {
		return model.getPincode();
	}

	/**
	 * Returns the primary key of this address.
	 *
	 * @return the primary key of this address
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the state of this address.
	 *
	 * @return the state of this address
	 */
	@Override
	public String getState() {
		return model.getState();
	}

	/**
	 * Returns the uuid of this address.
	 *
	 * @return the uuid of this address
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
	 * Sets the address ID of this address.
	 *
	 * @param addressId the address ID of this address
	 */
	@Override
	public void setAddressId(long addressId) {
		model.setAddressId(addressId);
	}

	/**
	 * Sets the company ID of this address.
	 *
	 * @param companyId the company ID of this address
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the country of this address.
	 *
	 * @param country the country of this address
	 */
	@Override
	public void setCountry(long country) {
		model.setCountry(country);
	}

	/**
	 * Sets the create date of this address.
	 *
	 * @param createDate the create date of this address
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the created by of this address.
	 *
	 * @param createdBy the created by of this address
	 */
	@Override
	public void setCreatedBy(long createdBy) {
		model.setCreatedBy(createdBy);
	}

	/**
	 * Sets the group ID of this address.
	 *
	 * @param groupId the group ID of this address
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the line1 of this address.
	 *
	 * @param line1 the line1 of this address
	 */
	@Override
	public void setLine1(String line1) {
		model.setLine1(line1);
	}

	/**
	 * Sets the line2 of this address.
	 *
	 * @param line2 the line2 of this address
	 */
	@Override
	public void setLine2(String line2) {
		model.setLine2(line2);
	}

	/**
	 * Sets the line3 of this address.
	 *
	 * @param line3 the line3 of this address
	 */
	@Override
	public void setLine3(String line3) {
		model.setLine3(line3);
	}

	/**
	 * Sets the modified by of this address.
	 *
	 * @param modifiedBy the modified by of this address
	 */
	@Override
	public void setModifiedBy(long modifiedBy) {
		model.setModifiedBy(modifiedBy);
	}

	/**
	 * Sets the modified date of this address.
	 *
	 * @param modifiedDate the modified date of this address
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the pincode of this address.
	 *
	 * @param pincode the pincode of this address
	 */
	@Override
	public void setPincode(String pincode) {
		model.setPincode(pincode);
	}

	/**
	 * Sets the primary key of this address.
	 *
	 * @param primaryKey the primary key of this address
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the state of this address.
	 *
	 * @param state the state of this address
	 */
	@Override
	public void setState(String state) {
		model.setState(state);
	}

	/**
	 * Sets the uuid of this address.
	 *
	 * @param uuid the uuid of this address
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
	protected AddressWrapper wrap(Address address) {
		return new AddressWrapper(address);
	}

}