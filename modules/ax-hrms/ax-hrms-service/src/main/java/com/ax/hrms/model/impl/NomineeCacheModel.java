/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.model.impl;

import com.ax.hrms.model.Nominee;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Nominee in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class NomineeCacheModel implements CacheModel<Nominee>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof NomineeCacheModel)) {
			return false;
		}

		NomineeCacheModel nomineeCacheModel = (NomineeCacheModel)object;

		if (nomineeId == nomineeCacheModel.nomineeId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, nomineeId);
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
		sb.append(", nomineeId=");
		sb.append(nomineeId);
		sb.append(", nomineeFirstName=");
		sb.append(nomineeFirstName);
		sb.append(", nomineeLastName=");
		sb.append(nomineeLastName);
		sb.append(", nomineeContact=");
		sb.append(nomineeContact);
		sb.append(", nomineeAddress=");
		sb.append(nomineeAddress);
		sb.append(", relationshipWithNominee=");
		sb.append(relationshipWithNominee);
		sb.append(", nomineeDob=");
		sb.append(nomineeDob);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Nominee toEntityModel() {
		NomineeImpl nomineeImpl = new NomineeImpl();

		if (uuid == null) {
			nomineeImpl.setUuid("");
		}
		else {
			nomineeImpl.setUuid(uuid);
		}

		nomineeImpl.setCompanyId(companyId);
		nomineeImpl.setCreatedBy(createdBy);
		nomineeImpl.setModifiedBy(modifiedBy);
		nomineeImpl.setGroupId(groupId);

		if (createDate == Long.MIN_VALUE) {
			nomineeImpl.setCreateDate(null);
		}
		else {
			nomineeImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			nomineeImpl.setModifiedDate(null);
		}
		else {
			nomineeImpl.setModifiedDate(new Date(modifiedDate));
		}

		nomineeImpl.setNomineeId(nomineeId);

		if (nomineeFirstName == null) {
			nomineeImpl.setNomineeFirstName("");
		}
		else {
			nomineeImpl.setNomineeFirstName(nomineeFirstName);
		}

		if (nomineeLastName == null) {
			nomineeImpl.setNomineeLastName("");
		}
		else {
			nomineeImpl.setNomineeLastName(nomineeLastName);
		}

		if (nomineeContact == null) {
			nomineeImpl.setNomineeContact("");
		}
		else {
			nomineeImpl.setNomineeContact(nomineeContact);
		}

		nomineeImpl.setNomineeAddress(nomineeAddress);

		if (relationshipWithNominee == null) {
			nomineeImpl.setRelationshipWithNominee("");
		}
		else {
			nomineeImpl.setRelationshipWithNominee(relationshipWithNominee);
		}

		if (nomineeDob == Long.MIN_VALUE) {
			nomineeImpl.setNomineeDob(null);
		}
		else {
			nomineeImpl.setNomineeDob(new Date(nomineeDob));
		}

		nomineeImpl.resetOriginalValues();

		return nomineeImpl;
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

		nomineeId = objectInput.readLong();
		nomineeFirstName = objectInput.readUTF();
		nomineeLastName = objectInput.readUTF();
		nomineeContact = objectInput.readUTF();

		nomineeAddress = objectInput.readLong();
		relationshipWithNominee = objectInput.readUTF();
		nomineeDob = objectInput.readLong();
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

		objectOutput.writeLong(nomineeId);

		if (nomineeFirstName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(nomineeFirstName);
		}

		if (nomineeLastName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(nomineeLastName);
		}

		if (nomineeContact == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(nomineeContact);
		}

		objectOutput.writeLong(nomineeAddress);

		if (relationshipWithNominee == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(relationshipWithNominee);
		}

		objectOutput.writeLong(nomineeDob);
	}

	public String uuid;
	public long companyId;
	public long createdBy;
	public long modifiedBy;
	public long groupId;
	public long createDate;
	public long modifiedDate;
	public long nomineeId;
	public String nomineeFirstName;
	public String nomineeLastName;
	public String nomineeContact;
	public long nomineeAddress;
	public String relationshipWithNominee;
	public long nomineeDob;

}