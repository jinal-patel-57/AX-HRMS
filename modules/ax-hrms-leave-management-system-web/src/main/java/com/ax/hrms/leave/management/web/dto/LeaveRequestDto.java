package com.ax.hrms.leave.management.web.dto;

import java.util.Date;

/**
 * @author krish.moradiya
 * @implNote : DTO of LeaveRequest
 */
public class LeaveRequestDto {
	
	long userId;
	long employeeId;
	String employeeName;
	String leaveType;
	long leaveTypeId;
	String leaveTypeDescription;
	String leavePeriod;
	int noOfHours;
	double noOfDays;
	long leaveRequestId;
	String leaveRequestStatus;
	double noOfRemainingLeaves;
	boolean isContinuous = false;
	boolean isApplicableFloater;
	String departmentName;
	String designationName;
	Date startDateOfLeave;
	Date endDateOfLeave;
	Date dateOfRequestLeave;
	String status;
	boolean halfDay;
	boolean firstHalf;
	double totalNoOfDays;
	String startDateOfLeaveRequest;
	String endDateOfLeaveRequest;
	String dateOfRequestedLeave;
	
	String leaveDate;

	public boolean getIsContinuous() {
		return isContinuous;
	}

	public void setIsContinous(boolean continuous) {
		isContinuous = continuous;
	}


	public boolean isContinuous() {
		return isContinuous;
	}

	public boolean isApplicableFloater() {
		return isApplicableFloater;
	}

	public void setIsApplicableFloater(boolean applicableFloater) {
		isApplicableFloater = applicableFloater;
	}

	public double getNoOfRemainingLeaves() {
		return noOfRemainingLeaves;
	}

	public void setNoOfRemainingLeaves(double noOfRemainingLeaves) {
		this.noOfRemainingLeaves = noOfRemainingLeaves;
	}

	public String getLeaveRequestStatus() {
		return leaveRequestStatus;
	}

	public void setLeaveRequestStatus(String leaveRequestStatus) {
		this.leaveRequestStatus = leaveRequestStatus;
	}






	public String getLeaveDate() {
		return leaveDate;
	}

	public void setLeaveDate(String leaveDate) {
		this.leaveDate = leaveDate;
	}

	public String getStartDateOfLeaveRequest() {
		return startDateOfLeaveRequest;
	}

	public void setStartDateOfLeaveRequest(String startDateOfLeaveRequest) {
		this.startDateOfLeaveRequest = startDateOfLeaveRequest;
	}

	public String getEndDateOfLeaveRequest() {
		return endDateOfLeaveRequest;
	}

	public void setEndDateOfLeaveRequest(String endDateOfLeaveRequest) {
		this.endDateOfLeaveRequest = endDateOfLeaveRequest;
	}

	public String getDateOfRequestedLeave() {
		return dateOfRequestedLeave;
	}

	public void setDateOfRequestedLeave(String dateOfRequestedLeave) {
		this.dateOfRequestedLeave = dateOfRequestedLeave;
	}

	public double getTotalNoOfDays() {
		return totalNoOfDays;
	}

	public void setTotalNoOfDays(double totalNoOfDays) {
		this.totalNoOfDays = totalNoOfDays;
	}

	public long getLeaveRequestId() {
		return leaveRequestId;
	}

	public void setLeaveRequestId(long leaveRequestId) {
		this.leaveRequestId = leaveRequestId;
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

	public Date getStartDateOfLeave() {
		return startDateOfLeave;
	}

	public void setStartDateOfLeave(Date startDateOfLeave) {
		this.startDateOfLeave = startDateOfLeave;
	}

	public Date getEndDateOfLeave() {
		return endDateOfLeave;
	}

	public void setEndDateOfLeave(Date endDateOfLeave) {
		this.endDateOfLeave = endDateOfLeave;
	}

	public Date getDateOfRequestLeave() {
		return dateOfRequestLeave;
	}

	public void setDateOfRequestLeave(Date dateOfRequestLeave) {
		this.dateOfRequestLeave = dateOfRequestLeave;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public boolean isHalfDay() {
		return halfDay;
	}

	public void setHalfDay(boolean halfDay) {
		this.halfDay = halfDay;
	}

	public boolean isFirstHalf() {
		return firstHalf;
	}

	public void setFirstHalf(boolean firstHalf) {
		this.firstHalf = firstHalf;
	}


	public void setTotalNoOfDays(int totalNoOfDays) {
		this.totalNoOfDays = totalNoOfDays;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(long employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getLeaveType() {
		return leaveType;
	}

	public void setLeaveType(String leaveType) {
		this.leaveType = leaveType;
	}

	public long getLeaveTypeId() {
		return leaveTypeId;
	}

	public void setLeaveTypeId(long leaveTypeId) {
		this.leaveTypeId = leaveTypeId;
	}

	public String getLeaveTypeDescription() {
		return leaveTypeDescription;
	}

	public void setLeaveTypeDescription(String leaveTypeDescription) {
		this.leaveTypeDescription = leaveTypeDescription;
	}


	public String getLeavePeriod() {
		return leavePeriod;
	}

	public void setContinuous(boolean isContinuous) {
		this.isContinuous = isContinuous;
	}

	public void setLeavePeriod(String leavePeriod) {
		this.leavePeriod = leavePeriod;
	}

	public int getNoOfHours() {
		return noOfHours;
	}

	public void setNoOfHours(int noOfHours) {
		this.noOfHours = noOfHours;
	}

	public double getNoOfDays() {
		return noOfDays;
	}

	public void setNoOfDays(double noOfDays) {
		this.noOfDays = noOfDays;
	}

}
