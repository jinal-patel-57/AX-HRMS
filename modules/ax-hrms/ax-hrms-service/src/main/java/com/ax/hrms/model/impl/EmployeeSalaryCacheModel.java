/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.model.impl;

import com.ax.hrms.model.EmployeeSalary;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing EmployeeSalary in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class EmployeeSalaryCacheModel
	implements CacheModel<EmployeeSalary>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof EmployeeSalaryCacheModel)) {
			return false;
		}

		EmployeeSalaryCacheModel employeeSalaryCacheModel =
			(EmployeeSalaryCacheModel)object;

		if (salaryId == employeeSalaryCacheModel.salaryId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, salaryId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

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
		sb.append(", salaryId=");
		sb.append(salaryId);
		sb.append(", grossSalaryCtcPm=");
		sb.append(grossSalaryCtcPm);
		sb.append(", grossSalaryCtcPa=");
		sb.append(grossSalaryCtcPa);
		sb.append(", employeeId=");
		sb.append(employeeId);
		sb.append(", status=");
		sb.append(status);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public EmployeeSalary toEntityModel() {
		EmployeeSalaryImpl employeeSalaryImpl = new EmployeeSalaryImpl();

		if (uuid == null) {
			employeeSalaryImpl.setUuid("");
		}
		else {
			employeeSalaryImpl.setUuid(uuid);
		}

		employeeSalaryImpl.setCompanyId(companyId);
		employeeSalaryImpl.setCreatedBy(createdBy);
		employeeSalaryImpl.setModifiedBy(modifiedBy);
		employeeSalaryImpl.setGroupId(groupId);

		if (createDate == Long.MIN_VALUE) {
			employeeSalaryImpl.setCreateDate(null);
		}
		else {
			employeeSalaryImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			employeeSalaryImpl.setModifiedDate(null);
		}
		else {
			employeeSalaryImpl.setModifiedDate(new Date(modifiedDate));
		}

		employeeSalaryImpl.setSalaryId(salaryId);
		employeeSalaryImpl.setGrossSalaryCtcPm(grossSalaryCtcPm);
		employeeSalaryImpl.setGrossSalaryCtcPa(grossSalaryCtcPa);
		employeeSalaryImpl.setEmployeeId(employeeId);
		employeeSalaryImpl.setStatus(status);

		employeeSalaryImpl.resetOriginalValues();

		return employeeSalaryImpl;
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

		salaryId = objectInput.readLong();

		grossSalaryCtcPm = objectInput.readDouble();

		grossSalaryCtcPa = objectInput.readDouble();

		employeeId = objectInput.readLong();

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

		objectOutput.writeLong(salaryId);

		objectOutput.writeDouble(grossSalaryCtcPm);

		objectOutput.writeDouble(grossSalaryCtcPa);

		objectOutput.writeLong(employeeId);

		objectOutput.writeBoolean(status);
	}

	public String uuid;
	public long companyId;
	public long createdBy;
	public long modifiedBy;
	public long groupId;
	public long createDate;
	public long modifiedDate;
	public long salaryId;
	public double grossSalaryCtcPm;
	public double grossSalaryCtcPa;
	public long employeeId;
	public boolean status;

}