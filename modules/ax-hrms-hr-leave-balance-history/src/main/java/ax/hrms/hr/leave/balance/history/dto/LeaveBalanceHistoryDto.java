package ax.hrms.hr.leave.balance.history.dto;

public class LeaveBalanceHistoryDto {
	String employeeName;
	String LeaveTypeName;
	int year;
	double noOfRemainingLeave;
	double noOfUsedLeave;
	long employeeId;
	long leaveTypeId;
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getLeaveTypeName() {
		return LeaveTypeName;
	}
	public void setLeaveTypeName(String leaveTypeName) {
		LeaveTypeName = leaveTypeName;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public double getNoOfRemainingLeave() {
		return noOfRemainingLeave;
	}
	public void setNoOfRemainingLeave(double noOfRemainingLeave) {
		this.noOfRemainingLeave = noOfRemainingLeave;
	}
	public double getNoOfUsedLeave() {
		return noOfUsedLeave;
	}
	public void setNoOfUsedLeave(double noOfUsedLeave) {
		this.noOfUsedLeave = noOfUsedLeave;
	}
	public long getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(long employeeId) {
		this.employeeId = employeeId;
	}
	public long getLeaveTypeId() {
		return leaveTypeId;
	}
	public void setLeaveTypeId(long leaveTypeId) {
		this.leaveTypeId = leaveTypeId;
	}
	
	

}
