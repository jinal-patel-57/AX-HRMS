package com.ax.hrms.probation.management.hr.web.dto;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author krish.moradiya
 */
public class EmployeeProbationDetailDto {
    String employeeCode;
    long employeeId;
    String employeeName;
    String departmentName;
    String designationName;

    Date joiningDate;
    Date probationEndDate;
    long probationStatusMasterId;

    public String getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode;
    }

    public long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(long employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getDesignationName() {
        return designationName;
    }

    public void setDesignationName(String designationName) {
        this.designationName = designationName;
    }

    public Date getJoiningDate() {
        return joiningDate;
    }

    public void setJoiningDate(Date joiningDate) {
        this.joiningDate = joiningDate;
    }

    public Date getProbationEndDate() {
        return probationEndDate;
    }

    public void setProbationEndDate(Date probationEndDate) {
        this.probationEndDate = probationEndDate;
    }

    public long getProbationStatusMasterId() {
        return probationStatusMasterId;
    }

    public void setProbationStatusMasterId(long probationStatusMasterId) {
        this.probationStatusMasterId = probationStatusMasterId;
    }

    public String getDateString(Date date){
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return dateFormat.format(date);
    }

}
