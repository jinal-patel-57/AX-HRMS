package com.ax.hrms.compensatory.web.dto;

public class CompensatoryDataDto {
    long compensatoryDataId;
    String description;
    String dateOfCompensation;
    String status;
    int approvedHours;
    int requestedHours;
    String managerName;

    public long getCompensatoryDataId() {
        return compensatoryDataId;
    }

    public void setCompensatoryDataId(long compensatoryDataId) {
        this.compensatoryDataId = compensatoryDataId;
    }

    public String getDateOfCompensation() {
        return dateOfCompensation;
    }

    public void setDateOfCompensation(String dateOfCompensation) {
        this.dateOfCompensation = dateOfCompensation;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getApprovedHours() {
        return approvedHours;
    }

    public void setApprovedHours(int approvedHours) {
        this.approvedHours = approvedHours;
    }

    public int getRequestedHours() {
        return requestedHours;
    }

    public void setRequestedHours(int requestedHours) {
        this.requestedHours = requestedHours;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}
