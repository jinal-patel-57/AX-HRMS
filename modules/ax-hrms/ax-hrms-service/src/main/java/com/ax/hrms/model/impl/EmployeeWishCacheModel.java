/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.model.impl;

import com.ax.hrms.model.EmployeeWish;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing EmployeeWish in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class EmployeeWishCacheModel
	implements CacheModel<EmployeeWish>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof EmployeeWishCacheModel)) {
			return false;
		}

		EmployeeWishCacheModel employeeWishCacheModel =
			(EmployeeWishCacheModel)object;

		if (wishId == employeeWishCacheModel.wishId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, wishId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(27);

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
		sb.append(", wishId=");
		sb.append(wishId);
		sb.append(", senderId=");
		sb.append(senderId);
		sb.append(", receiverId=");
		sb.append(receiverId);
		sb.append(", content=");
		sb.append(content);
		sb.append(", wishTypeMasterId=");
		sb.append(wishTypeMasterId);
		sb.append(", timeStamp=");
		sb.append(timeStamp);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public EmployeeWish toEntityModel() {
		EmployeeWishImpl employeeWishImpl = new EmployeeWishImpl();

		if (uuid == null) {
			employeeWishImpl.setUuid("");
		}
		else {
			employeeWishImpl.setUuid(uuid);
		}

		employeeWishImpl.setCompanyId(companyId);
		employeeWishImpl.setCreatedBy(createdBy);
		employeeWishImpl.setModifiedBy(modifiedBy);
		employeeWishImpl.setGroupId(groupId);

		if (createDate == Long.MIN_VALUE) {
			employeeWishImpl.setCreateDate(null);
		}
		else {
			employeeWishImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			employeeWishImpl.setModifiedDate(null);
		}
		else {
			employeeWishImpl.setModifiedDate(new Date(modifiedDate));
		}

		employeeWishImpl.setWishId(wishId);
		employeeWishImpl.setSenderId(senderId);
		employeeWishImpl.setReceiverId(receiverId);

		if (content == null) {
			employeeWishImpl.setContent("");
		}
		else {
			employeeWishImpl.setContent(content);
		}

		employeeWishImpl.setWishTypeMasterId(wishTypeMasterId);

		if (timeStamp == Long.MIN_VALUE) {
			employeeWishImpl.setTimeStamp(null);
		}
		else {
			employeeWishImpl.setTimeStamp(new Date(timeStamp));
		}

		employeeWishImpl.resetOriginalValues();

		return employeeWishImpl;
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

		wishId = objectInput.readLong();

		senderId = objectInput.readLong();

		receiverId = objectInput.readLong();
		content = objectInput.readUTF();

		wishTypeMasterId = objectInput.readLong();
		timeStamp = objectInput.readLong();
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

		objectOutput.writeLong(wishId);

		objectOutput.writeLong(senderId);

		objectOutput.writeLong(receiverId);

		if (content == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(content);
		}

		objectOutput.writeLong(wishTypeMasterId);
		objectOutput.writeLong(timeStamp);
	}

	public String uuid;
	public long companyId;
	public long createdBy;
	public long modifiedBy;
	public long groupId;
	public long createDate;
	public long modifiedDate;
	public long wishId;
	public long senderId;
	public long receiverId;
	public String content;
	public long wishTypeMasterId;
	public long timeStamp;

}