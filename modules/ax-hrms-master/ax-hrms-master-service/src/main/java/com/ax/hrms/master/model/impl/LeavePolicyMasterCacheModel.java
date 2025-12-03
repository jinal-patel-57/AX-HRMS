/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.master.model.impl;

import com.ax.hrms.master.model.LeavePolicyMaster;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing LeavePolicyMaster in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class LeavePolicyMasterCacheModel
	implements CacheModel<LeavePolicyMaster>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof LeavePolicyMasterCacheModel)) {
			return false;
		}

		LeavePolicyMasterCacheModel leavePolicyMasterCacheModel =
			(LeavePolicyMasterCacheModel)object;

		if (leavePolicyMasterId ==
				leavePolicyMasterCacheModel.leavePolicyMasterId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, leavePolicyMasterId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(35);

		sb.append("{leavePolicyMasterId=");
		sb.append(leavePolicyMasterId);
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
		sb.append(", description=");
		sb.append(description);
		sb.append(", accrualRate=");
		sb.append(accrualRate);
		sb.append(", maximumBalance=");
		sb.append(maximumBalance);
		sb.append(", leaveTypeMasterId=");
		sb.append(leaveTypeMasterId);
		sb.append(", isCheckMax=");
		sb.append(isCheckMax);
		sb.append(", yearOfPolicy=");
		sb.append(yearOfPolicy);
		sb.append(", isCarryForward=");
		sb.append(isCarryForward);
		sb.append(", isContinuous=");
		sb.append(isContinuous);
		sb.append(", eligibleAfterMonths=");
		sb.append(eligibleAfterMonths);
		sb.append(", isApplicableFloater=");
		sb.append(isApplicableFloater);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public LeavePolicyMaster toEntityModel() {
		LeavePolicyMasterImpl leavePolicyMasterImpl =
			new LeavePolicyMasterImpl();

		leavePolicyMasterImpl.setLeavePolicyMasterId(leavePolicyMasterId);
		leavePolicyMasterImpl.setCompanyId(companyId);
		leavePolicyMasterImpl.setCreatedBy(createdBy);
		leavePolicyMasterImpl.setModifiedBy(modifiedBy);
		leavePolicyMasterImpl.setGroupId(groupId);

		if (createDate == Long.MIN_VALUE) {
			leavePolicyMasterImpl.setCreateDate(null);
		}
		else {
			leavePolicyMasterImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			leavePolicyMasterImpl.setModifiedDate(null);
		}
		else {
			leavePolicyMasterImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (description == null) {
			leavePolicyMasterImpl.setDescription("");
		}
		else {
			leavePolicyMasterImpl.setDescription(description);
		}

		leavePolicyMasterImpl.setAccrualRate(accrualRate);
		leavePolicyMasterImpl.setMaximumBalance(maximumBalance);
		leavePolicyMasterImpl.setLeaveTypeMasterId(leaveTypeMasterId);
		leavePolicyMasterImpl.setIsCheckMax(isCheckMax);
		leavePolicyMasterImpl.setYearOfPolicy(yearOfPolicy);
		leavePolicyMasterImpl.setIsCarryForward(isCarryForward);
		leavePolicyMasterImpl.setIsContinuous(isContinuous);
		leavePolicyMasterImpl.setEligibleAfterMonths(eligibleAfterMonths);
		leavePolicyMasterImpl.setIsApplicableFloater(isApplicableFloater);

		leavePolicyMasterImpl.resetOriginalValues();

		return leavePolicyMasterImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		leavePolicyMasterId = objectInput.readLong();

		companyId = objectInput.readLong();

		createdBy = objectInput.readLong();

		modifiedBy = objectInput.readLong();

		groupId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		description = objectInput.readUTF();

		accrualRate = objectInput.readDouble();

		maximumBalance = objectInput.readDouble();

		leaveTypeMasterId = objectInput.readLong();

		isCheckMax = objectInput.readBoolean();

		yearOfPolicy = objectInput.readInt();

		isCarryForward = objectInput.readBoolean();

		isContinuous = objectInput.readBoolean();

		eligibleAfterMonths = objectInput.readInt();

		isApplicableFloater = objectInput.readBoolean();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(leavePolicyMasterId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(createdBy);

		objectOutput.writeLong(modifiedBy);

		objectOutput.writeLong(groupId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (description == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(description);
		}

		objectOutput.writeDouble(accrualRate);

		objectOutput.writeDouble(maximumBalance);

		objectOutput.writeLong(leaveTypeMasterId);

		objectOutput.writeBoolean(isCheckMax);

		objectOutput.writeInt(yearOfPolicy);

		objectOutput.writeBoolean(isCarryForward);

		objectOutput.writeBoolean(isContinuous);

		objectOutput.writeInt(eligibleAfterMonths);

		objectOutput.writeBoolean(isApplicableFloater);
	}

	public long leavePolicyMasterId;
	public long companyId;
	public long createdBy;
	public long modifiedBy;
	public long groupId;
	public long createDate;
	public long modifiedDate;
	public String description;
	public double accrualRate;
	public double maximumBalance;
	public long leaveTypeMasterId;
	public boolean isCheckMax;
	public int yearOfPolicy;
	public boolean isCarryForward;
	public boolean isContinuous;
	public int eligibleAfterMonths;
	public boolean isApplicableFloater;

}