package com.ax.hrms.master.leave.policy.web.dto;

public class LeavePolicyMasterDetails {
	
	long leavePolicyMasterid;
	String description;
	int accrualRate;
	double maximumBalance;
	long leaveTypeMasterId;
	boolean isCheckMax;
	int yearOfPolicy;
	boolean isCarryForward;
	boolean isContinous;
	boolean isApplicableFloater;
	int eligibleAfterMonths;
	String leaveTypeName;
	
	public boolean isApplicableFloater() {
		return isApplicableFloater;
	}
	public void setIsApplicableFloater(boolean isApplicableFloater) {
		this.isApplicableFloater = isApplicableFloater;
	}
	public int getAccrualRate() {
		return accrualRate;
	}
	public void setAccrualRate(int d) {
		this.accrualRate = d;
	}
	public String getLeaveTypeName() {
		return leaveTypeName;
	}
	public void setLeaveTypeName(String leaveTypeName) {
		this.leaveTypeName = leaveTypeName;
	}
	
	public long getLeavePolicyMasterid() {
		return leavePolicyMasterid;
	}
	public void setLeavePolicyMasterid(long leavePolicyMasterid) {
		this.leavePolicyMasterid = leavePolicyMasterid;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public double getMaximumBalance() {
		return maximumBalance;
	}
	public void setMaximumBalance(double maximumBalance) {
		this.maximumBalance = maximumBalance;
	}
	public long getLeaveTypeMasterId() {
		return leaveTypeMasterId;
	}
	public void setLeaveTypeMasterId(long leaveTypeMasterId) {
		this.leaveTypeMasterId = leaveTypeMasterId;
	}
	public boolean isCheckMax() {
		return isCheckMax;
	}
	public void setCheckMax(boolean isCheckMax) {
		this.isCheckMax = isCheckMax;
	}
	public int getYearOfPolicy() {
		return yearOfPolicy;
	}
	public void setYearOfPolicy(int yearOfPolicy) {
		this.yearOfPolicy = yearOfPolicy;
	}
	public boolean isCarryForward() {
		return isCarryForward;
	}
	public void setCarryForward(boolean isCarryForward) {
		this.isCarryForward = isCarryForward;
	}
	public boolean isContinous() {
		return isContinous;
	}
	public void setContinous(boolean isContinous) {
		this.isContinous = isContinous;
	}
	public int getEligibleAfterMonths() {
		return eligibleAfterMonths;
	}
	public void setEligibleAfterMonths(int eligibleAfterMonths) {
		this.eligibleAfterMonths = eligibleAfterMonths;
	}
	public String getPolicyType() {
		return leaveTypeName;
	}
	public void setPolicyType(String policyType) {
		this.leaveTypeName = policyType;
	}
	public LeavePolicyMasterDetails(long leavePolicyMasterid, String description, int accrualRate,
			double maximumBalance, long leaveTypeMasterId, boolean isCheckMax, int yearOfPolicy, boolean isCarryForward,
			boolean isContinous, int eligibleAfterMonths, String leaveTypeName) {
		super();
		this.leavePolicyMasterid = leavePolicyMasterid;
		this.description = description;
		this.accrualRate = accrualRate;
		this.maximumBalance = maximumBalance;
		this.leaveTypeMasterId = leaveTypeMasterId;
		this.isCheckMax = isCheckMax;
		this.yearOfPolicy = yearOfPolicy;
		this.isCarryForward = isCarryForward;
		this.isContinous = isContinous;
		this.eligibleAfterMonths = eligibleAfterMonths;
		this.leaveTypeName = leaveTypeName;
	}
	public LeavePolicyMasterDetails() {
		super();
		
	}
	@Override
	public String toString() {
		return "LeavePolicyMasterDetails [leavePolicyMasterid=" + leavePolicyMasterid + ", description=" + description
				+ ", accrualRate=" + accrualRate + ", maximumBalance=" + maximumBalance + ", leaveTypeMasterId="
				+ leaveTypeMasterId + ", isCheckMax=" + isCheckMax + ", yearOfPolicy=" + yearOfPolicy
				+ ", isCarryForward=" + isCarryForward + ", isContinous=" + isContinous + ", eligibleAfterMonths="
				+ eligibleAfterMonths + ", leaveTypeName=" + leaveTypeName + "]";
	}

}
