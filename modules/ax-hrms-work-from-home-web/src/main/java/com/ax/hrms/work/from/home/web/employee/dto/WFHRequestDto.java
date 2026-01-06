package com.ax.hrms.work.from.home.web.employee.dto;

import java.util.Date;

public class WFHRequestDto {

    private long workFromHomeRequestId;
    private String employeeName;
    private String teamMailId;
    private String reason;
    private String status;
    private Date requestDate;
    private Date startDate;
    private Date endDate;
    private String modifiedBy;
    // ---------------- Getters and Setters ----------------
    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }
    public long getWorkFromHomeRequestId() {
        return workFromHomeRequestId;
    }

    public void setWorkFromHomeRequestId(long workFromHomeRequestId) {
        this.workFromHomeRequestId = workFromHomeRequestId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getTeamMailId() {
        return teamMailId;
    }

    public void setTeamMailId(String teamMailId) {
        this.teamMailId = teamMailId;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(Date requestDate) {
        this.requestDate = requestDate;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}