package com.ax.hrms.hr.leave.management.web.dto;

public class EmployeeLeaveListDto {
    public String getLeaveName() {
        return leaveName;
    }

    public void setLeaveName(String leaveName) {
        this.leaveName = leaveName;
    }

    public double getLeaveAmount() {
        return leaveAmount;
    }

    public void setLeaveAmount(double leaveAmount) {
        this.leaveAmount = leaveAmount;
    }

    public long getLeaveTypeMasterId() {
        return leaveTypeMasterId;
    }

    public void setLeaveTypeMasterId(long leaveTypeMasterId) {
        this.leaveTypeMasterId = leaveTypeMasterId;
    }

    String leaveName;
    double leaveAmount;
    long leaveTypeMasterId;
}
