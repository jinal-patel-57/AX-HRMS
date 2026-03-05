package com.ax.hrms.hr.dashboard.leave.report.web.dto;

public class TodaysLeaveEmployee {
	
	public String name;
	public String departmentName;
	public String designationName;
	public String status;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	public boolean isReportingManager;


	public boolean isReportingManager() {
		return isReportingManager;
	}

	public void setReportingManager(boolean reportingManager) {
		isReportingManager = reportingManager;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public String getDesignationName() {
		return designationName;
	}
	public void setDesignationName(String designationName) {
		this.designationName = designationName;
	}
}
