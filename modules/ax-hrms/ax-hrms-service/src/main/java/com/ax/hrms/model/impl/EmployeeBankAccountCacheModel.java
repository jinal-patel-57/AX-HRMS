/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.model.impl;

import com.ax.hrms.model.EmployeeBankAccount;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing EmployeeBankAccount in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class EmployeeBankAccountCacheModel
	implements CacheModel<EmployeeBankAccount>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof EmployeeBankAccountCacheModel)) {
			return false;
		}

		EmployeeBankAccountCacheModel employeeBankAccountCacheModel =
			(EmployeeBankAccountCacheModel)object;

		if (bankAccountId == employeeBankAccountCacheModel.bankAccountId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, bankAccountId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(33);

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
		sb.append(", bankAccountId=");
		sb.append(bankAccountId);
		sb.append(", accountNumber=");
		sb.append(accountNumber);
		sb.append(", accountType=");
		sb.append(accountType);
		sb.append(", beneficiaryName=");
		sb.append(beneficiaryName);
		sb.append(", bankName=");
		sb.append(bankName);
		sb.append(", status=");
		sb.append(status);
		sb.append(", ifscCode=");
		sb.append(ifscCode);
		sb.append(", bankBranch=");
		sb.append(bankBranch);
		sb.append(", employeeId=");
		sb.append(employeeId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public EmployeeBankAccount toEntityModel() {
		EmployeeBankAccountImpl employeeBankAccountImpl =
			new EmployeeBankAccountImpl();

		if (uuid == null) {
			employeeBankAccountImpl.setUuid("");
		}
		else {
			employeeBankAccountImpl.setUuid(uuid);
		}

		employeeBankAccountImpl.setCompanyId(companyId);
		employeeBankAccountImpl.setCreatedBy(createdBy);
		employeeBankAccountImpl.setModifiedBy(modifiedBy);
		employeeBankAccountImpl.setGroupId(groupId);

		if (createDate == Long.MIN_VALUE) {
			employeeBankAccountImpl.setCreateDate(null);
		}
		else {
			employeeBankAccountImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			employeeBankAccountImpl.setModifiedDate(null);
		}
		else {
			employeeBankAccountImpl.setModifiedDate(new Date(modifiedDate));
		}

		employeeBankAccountImpl.setBankAccountId(bankAccountId);

		if (accountNumber == null) {
			employeeBankAccountImpl.setAccountNumber("");
		}
		else {
			employeeBankAccountImpl.setAccountNumber(accountNumber);
		}

		if (accountType == null) {
			employeeBankAccountImpl.setAccountType("");
		}
		else {
			employeeBankAccountImpl.setAccountType(accountType);
		}

		if (beneficiaryName == null) {
			employeeBankAccountImpl.setBeneficiaryName("");
		}
		else {
			employeeBankAccountImpl.setBeneficiaryName(beneficiaryName);
		}

		if (bankName == null) {
			employeeBankAccountImpl.setBankName("");
		}
		else {
			employeeBankAccountImpl.setBankName(bankName);
		}

		employeeBankAccountImpl.setStatus(status);

		if (ifscCode == null) {
			employeeBankAccountImpl.setIfscCode("");
		}
		else {
			employeeBankAccountImpl.setIfscCode(ifscCode);
		}

		if (bankBranch == null) {
			employeeBankAccountImpl.setBankBranch("");
		}
		else {
			employeeBankAccountImpl.setBankBranch(bankBranch);
		}

		employeeBankAccountImpl.setEmployeeId(employeeId);

		employeeBankAccountImpl.resetOriginalValues();

		return employeeBankAccountImpl;
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

		bankAccountId = objectInput.readLong();
		accountNumber = objectInput.readUTF();
		accountType = objectInput.readUTF();
		beneficiaryName = objectInput.readUTF();
		bankName = objectInput.readUTF();

		status = objectInput.readBoolean();
		ifscCode = objectInput.readUTF();
		bankBranch = objectInput.readUTF();

		employeeId = objectInput.readLong();
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

		objectOutput.writeLong(bankAccountId);

		if (accountNumber == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(accountNumber);
		}

		if (accountType == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(accountType);
		}

		if (beneficiaryName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(beneficiaryName);
		}

		if (bankName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(bankName);
		}

		objectOutput.writeBoolean(status);

		if (ifscCode == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(ifscCode);
		}

		if (bankBranch == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(bankBranch);
		}

		objectOutput.writeLong(employeeId);
	}

	public String uuid;
	public long companyId;
	public long createdBy;
	public long modifiedBy;
	public long groupId;
	public long createDate;
	public long modifiedDate;
	public long bankAccountId;
	public String accountNumber;
	public String accountType;
	public String beneficiaryName;
	public String bankName;
	public boolean status;
	public String ifscCode;
	public String bankBranch;
	public long employeeId;

}