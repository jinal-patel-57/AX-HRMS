/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.model.impl;

import com.ax.hrms.model.Address;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Address in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class AddressCacheModel implements CacheModel<Address>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof AddressCacheModel)) {
			return false;
		}

		AddressCacheModel addressCacheModel = (AddressCacheModel)object;

		if (addressId == addressCacheModel.addressId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, addressId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(29);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", createdBy=");
		sb.append(createdBy);
		sb.append(", modifiedBy=");
		sb.append(modifiedBy);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", addressId=");
		sb.append(addressId);
		sb.append(", line1=");
		sb.append(line1);
		sb.append(", line2=");
		sb.append(line2);
		sb.append(", line3=");
		sb.append(line3);
		sb.append(", state=");
		sb.append(state);
		sb.append(", country=");
		sb.append(country);
		sb.append(", pincode=");
		sb.append(pincode);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Address toEntityModel() {
		AddressImpl addressImpl = new AddressImpl();

		if (uuid == null) {
			addressImpl.setUuid("");
		}
		else {
			addressImpl.setUuid(uuid);
		}

		addressImpl.setCompanyId(companyId);
		addressImpl.setCreatedBy(createdBy);
		addressImpl.setModifiedBy(modifiedBy);
		addressImpl.setGroupId(groupId);

		if (createDate == Long.MIN_VALUE) {
			addressImpl.setCreateDate(null);
		}
		else {
			addressImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			addressImpl.setModifiedDate(null);
		}
		else {
			addressImpl.setModifiedDate(new Date(modifiedDate));
		}

		addressImpl.setAddressId(addressId);

		if (line1 == null) {
			addressImpl.setLine1("");
		}
		else {
			addressImpl.setLine1(line1);
		}

		if (line2 == null) {
			addressImpl.setLine2("");
		}
		else {
			addressImpl.setLine2(line2);
		}

		if (line3 == null) {
			addressImpl.setLine3("");
		}
		else {
			addressImpl.setLine3(line3);
		}

		if (state == null) {
			addressImpl.setState("");
		}
		else {
			addressImpl.setState(state);
		}

		addressImpl.setCountry(country);

		if (pincode == null) {
			addressImpl.setPincode("");
		}
		else {
			addressImpl.setPincode(pincode);
		}

		addressImpl.resetOriginalValues();

		return addressImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		companyId = objectInput.readLong();

		createdBy = objectInput.readLong();

		modifiedBy = objectInput.readLong();

		groupId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		addressId = objectInput.readLong();
		line1 = objectInput.readUTF();
		line2 = objectInput.readUTF();
		line3 = objectInput.readUTF();
		state = objectInput.readUTF();

		country = objectInput.readLong();
		pincode = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(createdBy);

		objectOutput.writeLong(modifiedBy);

		objectOutput.writeLong(groupId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeLong(addressId);

		if (line1 == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(line1);
		}

		if (line2 == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(line2);
		}

		if (line3 == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(line3);
		}

		if (state == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(state);
		}

		objectOutput.writeLong(country);

		if (pincode == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(pincode);
		}
	}

	public String uuid;
	public long companyId;
	public long createdBy;
	public long modifiedBy;
	public long groupId;
	public long createDate;
	public long modifiedDate;
	public long addressId;
	public String line1;
	public String line2;
	public String line3;
	public String state;
	public long country;
	public String pincode;

}