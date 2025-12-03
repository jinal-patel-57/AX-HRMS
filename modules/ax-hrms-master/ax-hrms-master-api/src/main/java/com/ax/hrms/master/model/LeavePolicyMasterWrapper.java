/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.master.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link LeavePolicyMaster}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LeavePolicyMaster
 * @generated
 */
public class LeavePolicyMasterWrapper
	extends BaseModelWrapper<LeavePolicyMaster>
	implements LeavePolicyMaster, ModelWrapper<LeavePolicyMaster> {

	public LeavePolicyMasterWrapper(LeavePolicyMaster leavePolicyMaster) {
		super(leavePolicyMaster);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("leavePolicyMasterId", getLeavePolicyMasterId());
		attributes.put("companyId", getCompanyId());
		attributes.put("createdBy", getCreatedBy());
		attributes.put("modifiedBy", getModifiedBy());
		attributes.put("groupId", getGroupId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("description", getDescription());
		attributes.put("accrualRate", getAccrualRate());
		attributes.put("maximumBalance", getMaximumBalance());
		attributes.put("leaveTypeMasterId", getLeaveTypeMasterId());
		attributes.put("isCheckMax", isIsCheckMax());
		attributes.put("yearOfPolicy", getYearOfPolicy());
		attributes.put("isCarryForward", isIsCarryForward());
		attributes.put("isContinuous", isIsContinuous());
		attributes.put("eligibleAfterMonths", getEligibleAfterMonths());
		attributes.put("isApplicableFloater", isIsApplicableFloater());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long leavePolicyMasterId = (Long)attributes.get("leavePolicyMasterId");

		if (leavePolicyMasterId != null) {
			setLeavePolicyMasterId(leavePolicyMasterId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long createdBy = (Long)attributes.get("createdBy");

		if (createdBy != null) {
			setCreatedBy(createdBy);
		}

		Long modifiedBy = (Long)attributes.get("modifiedBy");

		if (modifiedBy != null) {
			setModifiedBy(modifiedBy);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		Double accrualRate = (Double)attributes.get("accrualRate");

		if (accrualRate != null) {
			setAccrualRate(accrualRate);
		}

		Double maximumBalance = (Double)attributes.get("maximumBalance");

		if (maximumBalance != null) {
			setMaximumBalance(maximumBalance);
		}

		Long leaveTypeMasterId = (Long)attributes.get("leaveTypeMasterId");

		if (leaveTypeMasterId != null) {
			setLeaveTypeMasterId(leaveTypeMasterId);
		}

		Boolean isCheckMax = (Boolean)attributes.get("isCheckMax");

		if (isCheckMax != null) {
			setIsCheckMax(isCheckMax);
		}

		Integer yearOfPolicy = (Integer)attributes.get("yearOfPolicy");

		if (yearOfPolicy != null) {
			setYearOfPolicy(yearOfPolicy);
		}

		Boolean isCarryForward = (Boolean)attributes.get("isCarryForward");

		if (isCarryForward != null) {
			setIsCarryForward(isCarryForward);
		}

		Boolean isContinuous = (Boolean)attributes.get("isContinuous");

		if (isContinuous != null) {
			setIsContinuous(isContinuous);
		}

		Integer eligibleAfterMonths = (Integer)attributes.get(
			"eligibleAfterMonths");

		if (eligibleAfterMonths != null) {
			setEligibleAfterMonths(eligibleAfterMonths);
		}

		Boolean isApplicableFloater = (Boolean)attributes.get(
			"isApplicableFloater");

		if (isApplicableFloater != null) {
			setIsApplicableFloater(isApplicableFloater);
		}
	}

	@Override
	public LeavePolicyMaster cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the accrual rate of this leave policy master.
	 *
	 * @return the accrual rate of this leave policy master
	 */
	@Override
	public double getAccrualRate() {
		return model.getAccrualRate();
	}

	/**
	 * Returns the company ID of this leave policy master.
	 *
	 * @return the company ID of this leave policy master
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this leave policy master.
	 *
	 * @return the create date of this leave policy master
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the created by of this leave policy master.
	 *
	 * @return the created by of this leave policy master
	 */
	@Override
	public long getCreatedBy() {
		return model.getCreatedBy();
	}

	/**
	 * Returns the description of this leave policy master.
	 *
	 * @return the description of this leave policy master
	 */
	@Override
	public String getDescription() {
		return model.getDescription();
	}

	/**
	 * Returns the eligible after months of this leave policy master.
	 *
	 * @return the eligible after months of this leave policy master
	 */
	@Override
	public int getEligibleAfterMonths() {
		return model.getEligibleAfterMonths();
	}

	/**
	 * Returns the group ID of this leave policy master.
	 *
	 * @return the group ID of this leave policy master
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the is applicable floater of this leave policy master.
	 *
	 * @return the is applicable floater of this leave policy master
	 */
	@Override
	public boolean getIsApplicableFloater() {
		return model.getIsApplicableFloater();
	}

	/**
	 * Returns the is carry forward of this leave policy master.
	 *
	 * @return the is carry forward of this leave policy master
	 */
	@Override
	public boolean getIsCarryForward() {
		return model.getIsCarryForward();
	}

	/**
	 * Returns the is check max of this leave policy master.
	 *
	 * @return the is check max of this leave policy master
	 */
	@Override
	public boolean getIsCheckMax() {
		return model.getIsCheckMax();
	}

	/**
	 * Returns the is continuous of this leave policy master.
	 *
	 * @return the is continuous of this leave policy master
	 */
	@Override
	public boolean getIsContinuous() {
		return model.getIsContinuous();
	}

	/**
	 * Returns the leave policy master ID of this leave policy master.
	 *
	 * @return the leave policy master ID of this leave policy master
	 */
	@Override
	public long getLeavePolicyMasterId() {
		return model.getLeavePolicyMasterId();
	}

	/**
	 * Returns the leave type master ID of this leave policy master.
	 *
	 * @return the leave type master ID of this leave policy master
	 */
	@Override
	public long getLeaveTypeMasterId() {
		return model.getLeaveTypeMasterId();
	}

	/**
	 * Returns the maximum balance of this leave policy master.
	 *
	 * @return the maximum balance of this leave policy master
	 */
	@Override
	public double getMaximumBalance() {
		return model.getMaximumBalance();
	}

	/**
	 * Returns the modified by of this leave policy master.
	 *
	 * @return the modified by of this leave policy master
	 */
	@Override
	public long getModifiedBy() {
		return model.getModifiedBy();
	}

	/**
	 * Returns the modified date of this leave policy master.
	 *
	 * @return the modified date of this leave policy master
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this leave policy master.
	 *
	 * @return the primary key of this leave policy master
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the year of policy of this leave policy master.
	 *
	 * @return the year of policy of this leave policy master
	 */
	@Override
	public int getYearOfPolicy() {
		return model.getYearOfPolicy();
	}

	/**
	 * Returns <code>true</code> if this leave policy master is is applicable floater.
	 *
	 * @return <code>true</code> if this leave policy master is is applicable floater; <code>false</code> otherwise
	 */
	@Override
	public boolean isIsApplicableFloater() {
		return model.isIsApplicableFloater();
	}

	/**
	 * Returns <code>true</code> if this leave policy master is is carry forward.
	 *
	 * @return <code>true</code> if this leave policy master is is carry forward; <code>false</code> otherwise
	 */
	@Override
	public boolean isIsCarryForward() {
		return model.isIsCarryForward();
	}

	/**
	 * Returns <code>true</code> if this leave policy master is is check max.
	 *
	 * @return <code>true</code> if this leave policy master is is check max; <code>false</code> otherwise
	 */
	@Override
	public boolean isIsCheckMax() {
		return model.isIsCheckMax();
	}

	/**
	 * Returns <code>true</code> if this leave policy master is is continuous.
	 *
	 * @return <code>true</code> if this leave policy master is is continuous; <code>false</code> otherwise
	 */
	@Override
	public boolean isIsContinuous() {
		return model.isIsContinuous();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the accrual rate of this leave policy master.
	 *
	 * @param accrualRate the accrual rate of this leave policy master
	 */
	@Override
	public void setAccrualRate(double accrualRate) {
		model.setAccrualRate(accrualRate);
	}

	/**
	 * Sets the company ID of this leave policy master.
	 *
	 * @param companyId the company ID of this leave policy master
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this leave policy master.
	 *
	 * @param createDate the create date of this leave policy master
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the created by of this leave policy master.
	 *
	 * @param createdBy the created by of this leave policy master
	 */
	@Override
	public void setCreatedBy(long createdBy) {
		model.setCreatedBy(createdBy);
	}

	/**
	 * Sets the description of this leave policy master.
	 *
	 * @param description the description of this leave policy master
	 */
	@Override
	public void setDescription(String description) {
		model.setDescription(description);
	}

	/**
	 * Sets the eligible after months of this leave policy master.
	 *
	 * @param eligibleAfterMonths the eligible after months of this leave policy master
	 */
	@Override
	public void setEligibleAfterMonths(int eligibleAfterMonths) {
		model.setEligibleAfterMonths(eligibleAfterMonths);
	}

	/**
	 * Sets the group ID of this leave policy master.
	 *
	 * @param groupId the group ID of this leave policy master
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets whether this leave policy master is is applicable floater.
	 *
	 * @param isApplicableFloater the is applicable floater of this leave policy master
	 */
	@Override
	public void setIsApplicableFloater(boolean isApplicableFloater) {
		model.setIsApplicableFloater(isApplicableFloater);
	}

	/**
	 * Sets whether this leave policy master is is carry forward.
	 *
	 * @param isCarryForward the is carry forward of this leave policy master
	 */
	@Override
	public void setIsCarryForward(boolean isCarryForward) {
		model.setIsCarryForward(isCarryForward);
	}

	/**
	 * Sets whether this leave policy master is is check max.
	 *
	 * @param isCheckMax the is check max of this leave policy master
	 */
	@Override
	public void setIsCheckMax(boolean isCheckMax) {
		model.setIsCheckMax(isCheckMax);
	}

	/**
	 * Sets whether this leave policy master is is continuous.
	 *
	 * @param isContinuous the is continuous of this leave policy master
	 */
	@Override
	public void setIsContinuous(boolean isContinuous) {
		model.setIsContinuous(isContinuous);
	}

	/**
	 * Sets the leave policy master ID of this leave policy master.
	 *
	 * @param leavePolicyMasterId the leave policy master ID of this leave policy master
	 */
	@Override
	public void setLeavePolicyMasterId(long leavePolicyMasterId) {
		model.setLeavePolicyMasterId(leavePolicyMasterId);
	}

	/**
	 * Sets the leave type master ID of this leave policy master.
	 *
	 * @param leaveTypeMasterId the leave type master ID of this leave policy master
	 */
	@Override
	public void setLeaveTypeMasterId(long leaveTypeMasterId) {
		model.setLeaveTypeMasterId(leaveTypeMasterId);
	}

	/**
	 * Sets the maximum balance of this leave policy master.
	 *
	 * @param maximumBalance the maximum balance of this leave policy master
	 */
	@Override
	public void setMaximumBalance(double maximumBalance) {
		model.setMaximumBalance(maximumBalance);
	}

	/**
	 * Sets the modified by of this leave policy master.
	 *
	 * @param modifiedBy the modified by of this leave policy master
	 */
	@Override
	public void setModifiedBy(long modifiedBy) {
		model.setModifiedBy(modifiedBy);
	}

	/**
	 * Sets the modified date of this leave policy master.
	 *
	 * @param modifiedDate the modified date of this leave policy master
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this leave policy master.
	 *
	 * @param primaryKey the primary key of this leave policy master
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the year of policy of this leave policy master.
	 *
	 * @param yearOfPolicy the year of policy of this leave policy master
	 */
	@Override
	public void setYearOfPolicy(int yearOfPolicy) {
		model.setYearOfPolicy(yearOfPolicy);
	}

	@Override
	public String toXmlString() {
		return model.toXmlString();
	}

	@Override
	protected LeavePolicyMasterWrapper wrap(
		LeavePolicyMaster leavePolicyMaster) {

		return new LeavePolicyMasterWrapper(leavePolicyMaster);
	}

}