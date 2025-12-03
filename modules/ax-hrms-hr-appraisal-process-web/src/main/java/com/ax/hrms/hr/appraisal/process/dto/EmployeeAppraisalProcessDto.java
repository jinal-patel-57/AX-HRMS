package com.ax.hrms.hr.appraisal.process.dto;

public class EmployeeAppraisalProcessDto {

    String employeeFullName;
    String designations;
    String departments;
    String appraisalDate;
    int noOfYearsCompleted;
    String appraisalStatus;
    int actionStatus;
    long appraisalProcessId;
    long appraisalMeetingId;
    String appraisalMeetingTime;
    String appraisalMeetingDate;
    String listOfAttendees;

    public String getListOfAttendees() {
        return listOfAttendees;
    }

    public void setListOfAttendees(String listOfAttendees) {
        this.listOfAttendees = listOfAttendees;
    }

    public String getAppraisalMeetingTime() {
        return appraisalMeetingTime;
    }

    public void setAppraisalMeetingTime(String appraisalMeetingTime) {
        this.appraisalMeetingTime = appraisalMeetingTime;
    }

    public String getAppraisalMeetingDate() {
        return appraisalMeetingDate;
    }

    public void setAppraisalMeetingDate(String appraisalMeetingDate) {
        this.appraisalMeetingDate = appraisalMeetingDate;
    }

    public long getAppraisalMeetingId() {
        return appraisalMeetingId;
    }

    public void setAppraisalMeetingId(long appraisalMeetingId) {
        this.appraisalMeetingId = appraisalMeetingId;
    }

    public long getAppraisalProcessId() {
        return appraisalProcessId;
    }

    public void setAppraisalProcessId(long appraisalProcessId) {
        this.appraisalProcessId = appraisalProcessId;
    }

    public String getEmployeeFullName() {
        return employeeFullName;
    }

    public void setEmployeeFullName(String employeeFullName) {
        this.employeeFullName = employeeFullName;
    }

    public String getDesignations() {
        return designations;
    }

    public void setDesignations(String designations) {
        this.designations = designations;
    }

    public String getDepartments() {
        return departments;
    }

    public void setDepartments(String departments) {
        this.departments = departments;
    }

    public String getAppraisalDate() {
        return appraisalDate;
    }

    public void setAppraisalDate(String appraisalDate) {
        this.appraisalDate = appraisalDate;
    }

    public int getNoOfYearsCompleted() {
        return noOfYearsCompleted;
    }

    public void setNoOfYearsCompleted(int noOfYearsCompleted) {
        this.noOfYearsCompleted = noOfYearsCompleted;
    }


    public String getAppraisalStatus() {
        return appraisalStatus;
    }

    public void setAppraisalStatus(String appraisalStatus) {
        this.appraisalStatus = appraisalStatus;
    }


    public int getActionStatus() {
        return actionStatus;
    }

    public void setActionStatus(int actionStatus) {
        this.actionStatus = actionStatus;
    }



//    Pending
//    On Hold
//    Completed
//    Cancelled
//    In Self Evaluation
//    In Peer Evaluation
//    In Manager Evaluation
//    Meeting schedule pending
//    Meeting scheduled
//    Final Updation Pending

//    employee name, designation, department, appraisal date and no of years completed
}
