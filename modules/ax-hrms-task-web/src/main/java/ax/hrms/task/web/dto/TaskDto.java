package ax.hrms.task.web.dto;

import java.util.Date;
import java.util.List;

import com.liferay.portal.kernel.repository.model.FileEntry;

public class TaskDto {
	String taskName;
	String isSubTask;
	String mainTaskName;
	String projectName;
	String description;
	String projectTaskStatus;
	String priority;
	String isBillable;
	String assignedEmployee;
	String managerName;

	int estimatedHours;
	double duration;
	long projectId;
	long taskId;
	long assignedTo;
	long managerId;
	
	long mainTaskId;
	long projectTaskStatusId;
	long priorityId;
	long assigneeId;
	String managerApproveStatus;
	long timeTrackerId;

	Date startDate;
	Date dueDate;
	Date assignDate;
	Date completeDate;
	Date startTime;
	Date endTime;
	FileEntry file;
	String previewURL;
	List<TaskDto> attachmentList;
	
	
	
	
	
	
	public List<TaskDto> getAttachmentList() {
		return attachmentList;
	}
	public void setAttachmentList(List<TaskDto> attachmentList) {
		this.attachmentList = attachmentList;
	}
	public FileEntry getFile() {
		return file;
	}
	public void setFile(FileEntry file) {
		this.file = file;
	}
	public String getPreviewURL() {
		return previewURL;
	}
	public void setPreviewURL(String previewURL) {
		this.previewURL = previewURL;
	}
	public long getTimeTrackerId() {
		return timeTrackerId;
	}
	public void setTimeTrackerId(long timeTrackerId) {
		this.timeTrackerId = timeTrackerId;
	}
	public double getDuration() {
		return duration;
	}
	public void setDuration(double duration) {
		this.duration = duration;
	}
	public String getManagerApproveStatus() {
		return managerApproveStatus;
	}
	public void setManagerApproveStatus(String managerApproveStatus) {
		this.managerApproveStatus = managerApproveStatus;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public int getEstimatedHours() {
		return estimatedHours;
	}
	public void setEstimatedHours(int estimatedHours) {
		this.estimatedHours = estimatedHours;
	}
	
	public long getMainTaskId() {
		return mainTaskId;
	}
	public void setMainTaskId(long mainTaskId) {
		this.mainTaskId = mainTaskId;
	}
	public long getProjectTaskStatusId() {
		return projectTaskStatusId;
	}
	public void setProjectTaskStatusId(long projectTaskStatusId) {
		this.projectTaskStatusId = projectTaskStatusId;
	}
	public long getPriorityId() {
		return priorityId;
	}
	public void setPriorityId(long priorityId) {
		this.priorityId = priorityId;
	}
	public long getAssigneeId() {
		return assigneeId;
	}
	public void setAssigneeId(long assigneeId) {
		this.assigneeId = assigneeId;
	}
	public String getTaskName() {
		return taskName;
	}
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	public String getIsSubTask() {
		return isSubTask;
	}
	public void setIsSubTask(String isSubTask) {
		this.isSubTask = isSubTask;
	}
	public String getMainTaskName() {
		return mainTaskName;
	}
	public void setMainTaskName(String mainTaskName) {
		this.mainTaskName = mainTaskName;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getProjectTaskStatus() {
		return projectTaskStatus;
	}
	public void setProjectTaskStatus(String projectTaskStatus) {
		this.projectTaskStatus = projectTaskStatus;
	}
	public String getPriority() {
		return priority;
	}
	public void setPriority(String priority) {
		this.priority = priority;
	}
	public String getIsBillable() {
		return isBillable;
	}
	public void setIsBillable(String isBillable) {
		this.isBillable = isBillable;
	}
	public String getAssignedEmployee() {
		return assignedEmployee;
	}
	public void setAssignedEmployee(String assignedEmployee) {
		this.assignedEmployee = assignedEmployee;
	}
	public String getManagerName() {
		return managerName;
	}
	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}
	public long getProjectId() {
		return projectId;
	}
	public void setProjectId(long projectId) {
		this.projectId = projectId;
	}
	public long getTaskId() {
		return taskId;
	}
	public void setTaskId(long taskId) {
		this.taskId = taskId;
	}
	public long getAssignedTo() {
		return assignedTo;
	}
	public void setAssignedTo(long assignedTo) {
		this.assignedTo = assignedTo;
	}
	public long getManagerId() {
		return managerId;
	}
	public void setManagerId(long managerId) {
		this.managerId = managerId;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getDueDate() {
		return dueDate;
	}
	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}
	public Date getAssignDate() {
		return assignDate;
	}
	public void setAssignDate(Date assignDate) {
		this.assignDate = assignDate;
	}
	public Date getCompleteDate() {
		return completeDate;
	}
	public void setCompleteDate(Date completeDate) {
		this.completeDate = completeDate;
	}
	

}
