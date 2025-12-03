package com.ax.hrms.birthday.web.dto;

public class BirthdayEmployeeDto {
	String employeeName;
	String subject;
	long wishType;
	String wishes;
	String wishtypeName;
	long employeeId;
	long wishId;
	String departmentName;
	String designationName;
	
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
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public long getWishType() {
		return wishType;
	}
	public void setWishType(long wishType) {
		this.wishType = wishType;
	}
	public String getWishes() {
		return wishes;
	}
	public void setWishes(String wishes) {
		this.wishes = wishes;
	}
	public String getWishtypeName() {
		return wishtypeName;
	}
	public void setWishtypeName(String wishtypeName) {
		this.wishtypeName = wishtypeName;
	}
	public long getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(long employeeId) {
		this.employeeId = employeeId;
	}
	public long getWishId() {
		return wishId;
	}
	public void setWishId(long wishId) {
		this.wishId = wishId;
	}

}
