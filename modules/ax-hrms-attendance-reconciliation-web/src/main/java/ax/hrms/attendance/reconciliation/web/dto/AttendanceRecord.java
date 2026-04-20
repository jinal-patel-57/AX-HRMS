package ax.hrms.attendance.reconciliation.web.dto;

import java.time.LocalDate;

public class AttendanceRecord {

	public LocalDate getDate() {
		return date;
	}

	public String getEmployeeCode() {
		return employeeCode;
	}

	public Long getEmployeeId() {
		return employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public String getFirstPunch() {
		return firstPunch;
	}

	public String getLastPunch() {
		return lastPunch;
	}

	public String getTotalTime() {
		return totalTime;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public void setEmployeeCode(String employeeCode) {
		this.employeeCode = employeeCode;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public void setFirstPunch(String firstPunch) {
		this.firstPunch = firstPunch;
	}

	public void setLastPunch(String lastPunch) {
		this.lastPunch = lastPunch;
	}

	public void setTotalTime(String totalTime) {
		this.totalTime = totalTime;
	}

	private LocalDate date;
	private String employeeCode;
	private Long employeeId;
	private String employeeName;
	private String firstPunch;
	private String lastPunch;
	private String totalTime;

}
