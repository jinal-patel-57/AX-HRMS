package ax.hrms.attendance.reconciliation.web.dto;

public class MissingAttendanceRecord {

	public MissingAttendanceRecord() {
	}

	public MissingAttendanceRecord(
		String employeeCode, String employeeName, String date, String reason) {

		this.employeeCode = employeeCode;
		this.employeeName = employeeName;
		this.date = date;
		this.reason = reason;
	}

	public String getDate() {
		return date;
	}

	public String getEmployeeCode() {
		return employeeCode;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public String getReason() {
		return reason;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public void setEmployeeCode(String employeeCode) {
		this.employeeCode = employeeCode;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	private String date;
	private String employeeCode;
	private String employeeName;
	private String reason;

}
