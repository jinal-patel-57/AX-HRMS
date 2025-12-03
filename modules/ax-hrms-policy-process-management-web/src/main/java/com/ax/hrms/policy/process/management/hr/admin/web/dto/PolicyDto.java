package com.ax.hrms.policy.process.management.hr.admin.web.dto;

import java.util.List;

import com.liferay.portal.kernel.repository.model.FileEntry;

public class PolicyDto {
	boolean isSamePolicyType;
	long policyId;
	long rolePolicyId;
	long policyTypeId;
	long policyDocumentId;
	
	String policyName;
	String roleName;
	String description;
	String policyTypeName;
	String date;
	List<String> roleNameList;
	FileEntry file;
	boolean status;
	int year;
	String previewURL;
	
	
	
	
	
	
	
	
	
	

	public String getPreviewURL() {
		return previewURL;
	}

	public void setPreviewURL(String previewURL) {
		this.previewURL = previewURL;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public FileEntry getFile() {
		return file;
	}

	public void setFile(FileEntry file) {
		this.file = file;
	}

	
	public long getPolicyId() {
		return policyId;
	}

	public void setPolicyId(long policyId) {
		this.policyId = policyId;
	}

	public long getRolePolicyId() {
		return rolePolicyId;
	}

	public void setRolePolicyId(long rolePolicyId) {
		this.rolePolicyId = rolePolicyId;
	}

	public long getPolicyTypeId() {
		return policyTypeId;
	}

	public void setPolicyTypeId(long policyTypeId) {
		this.policyTypeId = policyTypeId;
	}

	public long getPolicyDocumentId() {
		return policyDocumentId;
	}

	public void setPolicyDocumentId(long policyDocumentId) {
		this.policyDocumentId = policyDocumentId;
	}

	public String getPolicyName() {
		return policyName;
	}

	public void setPolicyName(String policyName) {
		this.policyName = policyName;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPolicyTypeName() {
		return policyTypeName;
	}

	public void setPolicyTypeName(String policyTypeName) {
		this.policyTypeName = policyTypeName;
	}

	

	public boolean isStatus() {
		return status;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public List<String> getRoleNameList() {
		return roleNameList;
	}

	public void setRoleNameList(List<String> roleNameList) {
		this.roleNameList = roleNameList;
	}

	public boolean isSamePolicyType() {
		return isSamePolicyType;
	}

	public void setSamePolicyType(boolean isSamePolicyType) {
		this.isSamePolicyType = isSamePolicyType;
	}

}
