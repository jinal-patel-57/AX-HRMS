package com.ax.hrms.work.from.home.web.hr.dto;

import java.util.Date;
import java.util.List;

public class WFHRequestDto {

    private long workFromHomeRequestId;
    private String employeeName;
    private String teamMailId;
    private String reason;
    private String status;
    private Date requestDate;
    private Date startDate;
    private Date endDate;
    private String employeeOfficialMailId;
    private String modifiedBy;
    private long employeeId;

    private Date workFromHomeDate;
    private boolean isHalfDay;
    private boolean isFirstHalf;

    private List<WFHRequestDto> wfhDayTypeList;

    private double noOfDays;

    public Date getWorkFromHomeDate() {
        return workFromHomeDate;
    }

    public void setWorkFromHomeDate(Date workFromHomeDate) {
        this.workFromHomeDate = workFromHomeDate;
    }

    public boolean isHalfDay() {
        return isHalfDay;
    }

    public void setHalfDay(boolean halfDay) {
        isHalfDay = halfDay;
    }

    public boolean isFirstHalf() {
        return isFirstHalf;
    }


    public void setFirstHalf(boolean firstHalf) {
        isFirstHalf = firstHalf;
    }

    public List<WFHRequestDto> getWfhDayTypeList() {
        return wfhDayTypeList;
    }

    public void setWfhDayTypeList(List<WFHRequestDto> wfhDayTypeList) {
        this.wfhDayTypeList = wfhDayTypeList;
    }

    public double getNoOfDays() {
        return noOfDays;
    }

    public void setNoOfDays(double noOfDays) {
        this.noOfDays = noOfDays;
    }

    public String getEmployeeOfficialMailId() {
        return employeeOfficialMailId;
    }

    public void setEmployeeOfficialMailId(String employeeOfficialMailId) {
        this.employeeOfficialMailId = employeeOfficialMailId;
    }

    public long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(long employeeId) {
        this.employeeId = employeeId;
    }

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
