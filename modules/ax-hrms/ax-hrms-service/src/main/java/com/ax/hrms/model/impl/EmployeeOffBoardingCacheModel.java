/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.model.impl;

import com.ax.hrms.model.EmployeeOffBoarding;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing EmployeeOffBoarding in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class EmployeeOffBoardingCacheModel
	implements CacheModel<EmployeeOffBoarding>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof EmployeeOffBoardingCacheModel)) {
			return false;
		}

		EmployeeOffBoardingCacheModel employeeOffBoardingCacheModel =
			(EmployeeOffBoardingCacheModel)object;

		if (employeeOffBoardingId ==
				employeeOffBoardingCacheModel.employeeOffBoardingId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, employeeOffBoardingId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(35);

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
		sb.append(", employeeOffBoardingId=");
		sb.append(employeeOffBoardingId);
		sb.append(", kt=");
		sb.append(kt);
		sb.append(", assets=");
		sb.append(assets);
		sb.append(", nda=");
		sb.append(nda);
		sb.append(", mailAndBiometrics=");
		sb.append(mailAndBiometrics);
		sb.append(", employeeId=");
		sb.append(employeeId);
		sb.append(", experienceLetterId=");
		sb.append(experienceLetterId);
		sb.append(", fullAndFinal=");
		sb.append(fullAndFinal);
		sb.append(", relievingLetterId=");
		sb.append(relievingLetterId);
		sb.append(", status=");
		sb.append(status);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public EmployeeOffBoarding toEntityModel() {
		EmployeeOffBoardingImpl employeeOffBoardingImpl =
			new EmployeeOffBoardingImpl();

		if (uuid == null) {
			employeeOffBoardingImpl.setUuid("");
		}
		else {
			employeeOffBoardingImpl.setUuid(uuid);
		}

		employeeOffBoardingImpl.setCompanyId(companyId);
		employeeOffBoardingImpl.setCreatedBy(createdBy);
		employeeOffBoardingImpl.setModifiedBy(modifiedBy);
		employeeOffBoardingImpl.setGroupId(groupId);

		if (createDate == Long.MIN_VALUE) {
			employeeOffBoardingImpl.setCreateDate(null);
		}
		else {
			employeeOffBoardingImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			employeeOffBoardingImpl.setModifiedDate(null);
		}
		else {
			employeeOffBoardingImpl.setModifiedDate(new Date(modifiedDate));
		}

		employeeOffBoardingImpl.setEmployeeOffBoardingId(employeeOffBoardingId);
		employeeOffBoardingImpl.setKt(kt);
		employeeOffBoardingImpl.setAssets(assets);
		employeeOffBoardingImpl.setNda(nda);
		employeeOffBoardingImpl.setMailAndBiometrics(mailAndBiometrics);
		employeeOffBoardingImpl.setEmployeeId(employeeId);
		employeeOffBoardingImpl.setExperienceLetterId(experienceLetterId);

		if (fullAndFinal == null) {
			employeeOffBoardingImpl.setFullAndFinal("");
		}
		else {
			employeeOffBoardingImpl.setFullAndFinal(fullAndFinal);
		}

		employeeOffBoardingImpl.setRelievingLetterId(relievingLetterId);
		employeeOffBoardingImpl.setStatus(status);

		employeeOffBoardingImpl.resetOriginalValues();

		return employeeOffBoardingImpl;
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

		employeeOffBoardingId = objectInput.readLong();

		kt = objectInput.readBoolean();

		assets = objectInput.readBoolean();

		nda = objectInput.readBoolean();

		mailAndBiometrics = objectInput.readBoolean();

		employeeId = objectInput.readLong();

		experienceLetterId = objectInput.readLong();
		fullAndFinal = objectInput.readUTF();

		relievingLetterId = objectInput.readLong();

		status = objectInput.readBoolean();
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

		objectOutput.writeLong(employeeOffBoardingId);

		objectOutput.writeBoolean(kt);

		objectOutput.writeBoolean(assets);

		objectOutput.writeBoolean(nda);

		objectOutput.writeBoolean(mailAndBiometrics);

		objectOutput.writeLong(employeeId);

		objectOutput.writeLong(experienceLetterId);

		if (fullAndFinal == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(fullAndFinal);
		}

		objectOutput.writeLong(relievingLetterId);

		objectOutput.writeBoolean(status);
	}

	public String uuid;
	public long companyId;
	public long createdBy;
	public long modifiedBy;
	public long groupId;
	public long createDate;
	public long modifiedDate;
	public long employeeOffBoardingId;
	public boolean kt;
	public boolean assets;
	public boolean nda;
	public boolean mailAndBiometrics;
	public long employeeId;
	public long experienceLetterId;
	public String fullAndFinal;
	public long relievingLetterId;
	public boolean status;

}