/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.model.impl;

import com.ax.hrms.model.UpcomingProbationEmployee;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing UpcomingProbationEmployee in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class UpcomingProbationEmployeeCacheModel
	implements CacheModel<UpcomingProbationEmployee>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof UpcomingProbationEmployeeCacheModel)) {
			return false;
		}

		UpcomingProbationEmployeeCacheModel
			upcomingProbationEmployeeCacheModel =
				(UpcomingProbationEmployeeCacheModel)object;

		if (upcomingProbationEmployeeId ==
				upcomingProbationEmployeeCacheModel.
					upcomingProbationEmployeeId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, upcomingProbationEmployeeId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

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
		sb.append(", upcomingProbationEmployeeId=");
		sb.append(upcomingProbationEmployeeId);
		sb.append(", probationDetailId=");
		sb.append(probationDetailId);
		sb.append(", month=");
		sb.append(month);
		sb.append(", year=");
		sb.append(year);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public UpcomingProbationEmployee toEntityModel() {
		UpcomingProbationEmployeeImpl upcomingProbationEmployeeImpl =
			new UpcomingProbationEmployeeImpl();

		if (uuid == null) {
			upcomingProbationEmployeeImpl.setUuid("");
		}
		else {
			upcomingProbationEmployeeImpl.setUuid(uuid);
		}

		upcomingProbationEmployeeImpl.setCompanyId(companyId);
		upcomingProbationEmployeeImpl.setCreatedBy(createdBy);
		upcomingProbationEmployeeImpl.setModifiedBy(modifiedBy);
		upcomingProbationEmployeeImpl.setGroupId(groupId);

		if (createDate == Long.MIN_VALUE) {
			upcomingProbationEmployeeImpl.setCreateDate(null);
		}
		else {
			upcomingProbationEmployeeImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			upcomingProbationEmployeeImpl.setModifiedDate(null);
		}
		else {
			upcomingProbationEmployeeImpl.setModifiedDate(
				new Date(modifiedDate));
		}

		upcomingProbationEmployeeImpl.setUpcomingProbationEmployeeId(
			upcomingProbationEmployeeId);
		upcomingProbationEmployeeImpl.setProbationDetailId(probationDetailId);
		upcomingProbationEmployeeImpl.setMonth(month);
		upcomingProbationEmployeeImpl.setYear(year);

		upcomingProbationEmployeeImpl.resetOriginalValues();

		return upcomingProbationEmployeeImpl;
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

		upcomingProbationEmployeeId = objectInput.readLong();

		probationDetailId = objectInput.readLong();

		month = objectInput.readInt();

		year = objectInput.readInt();
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

		objectOutput.writeLong(upcomingProbationEmployeeId);

		objectOutput.writeLong(probationDetailId);

		objectOutput.writeInt(month);

		objectOutput.writeInt(year);
	}

	public String uuid;
	public long companyId;
	public long createdBy;
	public long modifiedBy;
	public long groupId;
	public long createDate;
	public long modifiedDate;
	public long upcomingProbationEmployeeId;
	public long probationDetailId;
	public int month;
	public int year;

}