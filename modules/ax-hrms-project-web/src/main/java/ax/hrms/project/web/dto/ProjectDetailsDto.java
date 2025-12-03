package ax.hrms.project.web.dto;

import java.util.Date;

public class ProjectDetailsDto {
	
	String projectName;
	long projectId;
	String description;
	String projectStatus;
	Date startDateOfProject;
	long managerId;
	String isBillable;
	long projectHistoryId;
	long employeeId;
	long projectEmployeeDetailsId;
	boolean isManager;
	String startDate;
	String listOfAssignee;
	
	
	public String getListOfAssignee() {
		return listOfAssignee;
	}
	public void setListOfAssignee(String listOfAssignee) {
		this.listOfAssignee = listOfAssignee;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public boolean isManager() {
		return isManager;
	}
	public void setManager(boolean isManager) {
		this.isManager = isManager;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public long getProjectId() {
		return projectId;
	}
	public void setProjectId(long projectId) {
		this.projectId = projectId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getProjectStatus() {
		return projectStatus;
	}
	public void setProjectStatus(String projectStatus) {
		this.projectStatus = projectStatus;
	}
	public Date getStartDateOfProject() {
		return startDateOfProject;
	}
	public void setStartDateOfProject(Date startDateOfProject) {
		this.startDateOfProject = startDateOfProject;
	}
	public long getManagerId() {
		return managerId;
	}
	public void setManagerId(long managerId) {
		this.managerId = managerId;
	}
	public String getIsBillable() {
		return isBillable;
	}
	public void setIsBillable(String isBillable) {
		this.isBillable = isBillable;
	}
	public long getProjectHistoryId() {
		return projectHistoryId;
	}
	public void setProjectHistoryId(long projectHistoryId) {
		this.projectHistoryId = projectHistoryId;
	}
	public long getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(long employeeId) {
		this.employeeId = employeeId;
	}
	public long getProjectEmployeeDetailsId() {
		return projectEmployeeDetailsId;
	}
	public void setProjectEmployeeDetailsId(long projectEmployeeDetailsId) {
		this.projectEmployeeDetailsId = projectEmployeeDetailsId;
	}
	
	

}
