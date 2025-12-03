package com.ax.hrms.model;

import java.util.Date;

public class CustomPolicyDetailsDTO {
	private long policyId;
	String policyName;
	String policyDescription;
	long createdBy;
	long modifiedBy;
	Date createDate;
	Date modifiedDate;
	long policyDocumentId;
	long policyTypeId;
	int year;
	boolean status;
	Date applicableDate;
	String policyType;
	public long getPolicyId() {
		return policyId;
	}
	public void setPolicyId(long policyId) {
		this.policyId = policyId;
	}
	public String getPolicyName() {
		return policyName;
	}
	public void setPolicyName(String policyName) {
		this.policyName = policyName;
	}
	public String getPolicyDescription() {
		return policyDescription;
	}
	public void setPolicyDescription(String policyDescription) {
		this.policyDescription = policyDescription;
	}
	public long getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(long createdBy) {
		this.createdBy = createdBy;
	}
	public long getModifiedBy() {
		return modifiedBy;
	}
	public void setModifiedBy(long modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Date getModifiedDate() {
		return modifiedDate;
	}
	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	public long getPolicyDocumentId() {
		return policyDocumentId;
	}
	public void setPolicyDocumentId(long policyDocumentId) {
		this.policyDocumentId = policyDocumentId;
	}
	public long getPolicyTypeId() {
		return policyTypeId;
	}
	public void setPolicyTypeId(long policyTypeId) {
		this.policyTypeId = policyTypeId;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public Date getApplicableDate() {
		return applicableDate;
	}
	public void setApplicableDate(Date applicableDate) {
		this.applicableDate = applicableDate;
	}
	public String getPolicyType() {
		return policyType;
	}
	public void setPolicyType(String policyType) {
		this.policyType = policyType;
	}
	
	
}
