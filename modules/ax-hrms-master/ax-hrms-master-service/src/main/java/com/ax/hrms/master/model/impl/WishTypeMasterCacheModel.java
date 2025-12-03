/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.master.model.impl;

import com.ax.hrms.master.model.WishTypeMaster;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing WishTypeMaster in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class WishTypeMasterCacheModel
	implements CacheModel<WishTypeMaster>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof WishTypeMasterCacheModel)) {
			return false;
		}

		WishTypeMasterCacheModel wishTypeMasterCacheModel =
			(WishTypeMasterCacheModel)object;

		if (wishTypeMasterId == wishTypeMasterCacheModel.wishTypeMasterId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, wishTypeMasterId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{wishTypeMasterId=");
		sb.append(wishTypeMasterId);
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
		sb.append(", wishType=");
		sb.append(wishType);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public WishTypeMaster toEntityModel() {
		WishTypeMasterImpl wishTypeMasterImpl = new WishTypeMasterImpl();

		wishTypeMasterImpl.setWishTypeMasterId(wishTypeMasterId);
		wishTypeMasterImpl.setCompanyId(companyId);
		wishTypeMasterImpl.setCreatedBy(createdBy);
		wishTypeMasterImpl.setModifiedBy(modifiedBy);
		wishTypeMasterImpl.setGroupId(groupId);

		if (createDate == Long.MIN_VALUE) {
			wishTypeMasterImpl.setCreateDate(null);
		}
		else {
			wishTypeMasterImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			wishTypeMasterImpl.setModifiedDate(null);
		}
		else {
			wishTypeMasterImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (wishType == null) {
			wishTypeMasterImpl.setWishType("");
		}
		else {
			wishTypeMasterImpl.setWishType(wishType);
		}

		wishTypeMasterImpl.resetOriginalValues();

		return wishTypeMasterImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		wishTypeMasterId = objectInput.readLong();

		companyId = objectInput.readLong();

		createdBy = objectInput.readLong();

		modifiedBy = objectInput.readLong();

		groupId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		wishType = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(wishTypeMasterId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(createdBy);

		objectOutput.writeLong(modifiedBy);

		objectOutput.writeLong(groupId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (wishType == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(wishType);
		}
	}

	public long wishTypeMasterId;
	public long companyId;
	public long createdBy;
	public long modifiedBy;
	public long groupId;
	public long createDate;
	public long modifiedDate;
	public String wishType;

}