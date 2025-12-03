/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.model.impl;

import com.ax.hrms.model.Holiday;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Holiday in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class HolidayCacheModel implements CacheModel<Holiday>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof HolidayCacheModel)) {
			return false;
		}

		HolidayCacheModel holidayCacheModel = (HolidayCacheModel)object;

		if (holidayId == holidayCacheModel.holidayId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, holidayId);
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
		sb.append(", holidayId=");
		sb.append(holidayId);
		sb.append(", holidayName=");
		sb.append(holidayName);
		sb.append(", date=");
		sb.append(date);
		sb.append(", description=");
		sb.append(description);
		sb.append(", year=");
		sb.append(year);
		sb.append(", isFloater=");
		sb.append(isFloater);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Holiday toEntityModel() {
		HolidayImpl holidayImpl = new HolidayImpl();

		if (uuid == null) {
			holidayImpl.setUuid("");
		}
		else {
			holidayImpl.setUuid(uuid);
		}

		holidayImpl.setCompanyId(companyId);
		holidayImpl.setCreatedBy(createdBy);
		holidayImpl.setModifiedBy(modifiedBy);
		holidayImpl.setGroupId(groupId);

		if (createDate == Long.MIN_VALUE) {
			holidayImpl.setCreateDate(null);
		}
		else {
			holidayImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			holidayImpl.setModifiedDate(null);
		}
		else {
			holidayImpl.setModifiedDate(new Date(modifiedDate));
		}

		holidayImpl.setHolidayId(holidayId);

		if (holidayName == null) {
			holidayImpl.setHolidayName("");
		}
		else {
			holidayImpl.setHolidayName(holidayName);
		}

		if (date == Long.MIN_VALUE) {
			holidayImpl.setDate(null);
		}
		else {
			holidayImpl.setDate(new Date(date));
		}

		if (description == null) {
			holidayImpl.setDescription("");
		}
		else {
			holidayImpl.setDescription(description);
		}

		holidayImpl.setYear(year);
		holidayImpl.setIsFloater(isFloater);

		holidayImpl.resetOriginalValues();

		return holidayImpl;
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

		holidayId = objectInput.readLong();
		holidayName = objectInput.readUTF();
		date = objectInput.readLong();
		description = objectInput.readUTF();

		year = objectInput.readInt();

		isFloater = objectInput.readBoolean();
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

		objectOutput.writeLong(holidayId);

		if (holidayName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(holidayName);
		}

		objectOutput.writeLong(date);

		if (description == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(description);
		}

		objectOutput.writeInt(year);

		objectOutput.writeBoolean(isFloater);
	}

	public String uuid;
	public long companyId;
	public long createdBy;
	public long modifiedBy;
	public long groupId;
	public long createDate;
	public long modifiedDate;
	public long holidayId;
	public String holidayName;
	public long date;
	public String description;
	public int year;
	public boolean isFloater;

}