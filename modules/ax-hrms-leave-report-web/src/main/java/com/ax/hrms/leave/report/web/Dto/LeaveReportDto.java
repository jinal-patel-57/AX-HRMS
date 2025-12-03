package com.ax.hrms.leave.report.web.Dto;

public class LeaveReportDto {
	String leaveTypeName;
	double remainingDays;
	double usedDays;
	int year;
	public String getLeaveTypeName() {
		return leaveTypeName;
	}
	public void setLeaveTypeName(String leaveTypeName) {
		this.leaveTypeName = leaveTypeName;
	}
	public double getRemainingDays() {
		return remainingDays;
	}
	public void setRemainingDays(double remainingDays) {
		this.remainingDays = remainingDays;
	}
	public double getUsedDays() {
		return usedDays;
	}
	public void setUsedDays(double usedDays) {
		this.usedDays = usedDays;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	

	
	

}
