package com.ax.hrms.pip.program.web.dto;

public class PipProgramEmployeeDto {
    long pipProgramId;
    String employeeName;
    String startDate;
    String endDate;
    String meetingDate;
    int noOfMonths;
    String status;

    public long getPipProgramId() {
        return pipProgramId;
    }

    public void setPipProgramId(long pipProgramId) {
        this.pipProgramId = pipProgramId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getMeetingDate() {
        return meetingDate;
    }

    public void setMeetingDate(String meetingDate) {
        this.meetingDate = meetingDate;
    }

    public int getNoOfMonths() {
        return noOfMonths;
    }

    public void setNoOfMonths(int noOfMonths) {
        this.noOfMonths = noOfMonths;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
