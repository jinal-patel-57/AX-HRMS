package com.ax.hrms.hr.appraisal.process.dto;

public class EmployeeAppraisalReminderDto {

    String employeeFullName;

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

    String designations;
    String departments;
    String appraisalDate;
    int noOfYearsCompleted;
//    employee name, designation, department, appraisal date and no of years completed
}
