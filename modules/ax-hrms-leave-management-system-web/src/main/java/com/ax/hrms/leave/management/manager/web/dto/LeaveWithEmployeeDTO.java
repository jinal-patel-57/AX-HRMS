package com.ax.hrms.leave.management.manager.web.dto;

import com.ax.hrms.model.EmployeeDetails;
import com.ax.hrms.model.LeaveRequest;

public class LeaveWithEmployeeDTO {
    private LeaveRequest leave;
    private EmployeeDetails employee;
    private String statusName;

    public void setLeave(LeaveRequest leave) {
        this.leave = leave;
    }

    public void setEmployee(EmployeeDetails employee) {
        this.employee = employee;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    public LeaveWithEmployeeDTO(LeaveRequest leave, EmployeeDetails emp, String status) {
        this.leave = leave;
        this.employee = emp;
        statusName = status;
    }

    public LeaveRequest getLeave() { return leave; }
    public EmployeeDetails getEmployee() { return employee; }
}
