create index IX_D04E9CF0 on ax_master_AppraisalStatusMaster (status[$COLUMN_LENGTH:75$]);

create index IX_C8516B60 on ax_master_DepartmentMaster (departmentName[$COLUMN_LENGTH:75$]);

create index IX_E024F2C8 on ax_master_DesignationMaster (designationName[$COLUMN_LENGTH:75$]);

create index IX_D8E7ED26 on ax_master_DocumentTypeMaster (documentTypeName[$COLUMN_LENGTH:75$]);

create index IX_8EDEDF66 on ax_master_EducationLevelMaster (levelName[$COLUMN_LENGTH:75$]);

create index IX_80EBEB9D on ax_master_LeaveCompensatoryStatusMaster (leaveCompensatoryStatus[$COLUMN_LENGTH:75$]);

create index IX_11DC6DAC on ax_master_LeavePolicyMaster (leaveTypeMasterId, yearOfPolicy, eligibleAfterMonths);
create index IX_DD75AFD6 on ax_master_LeavePolicyMaster (yearOfPolicy);

create index IX_4743F073 on ax_master_LeaveTypeMaster (isActive, isAppearForAll);
create index IX_1F0EB848 on ax_master_LeaveTypeMaster (leaveTypeName[$COLUMN_LENGTH:75$]);

create index IX_3C8F85E9 on ax_master_PolicyTypeMaster (policyType[$COLUMN_LENGTH:75$]);

create index IX_643DE284 on ax_master_PriorityMaster (priorityName[$COLUMN_LENGTH:75$]);

create index IX_724928E5 on ax_master_ProbationStatusMaster (statusType[$COLUMN_LENGTH:75$]);

create index IX_905D26A0 on ax_master_ProjectTaskStatusMaster (projectTaskStatusName[$COLUMN_LENGTH:75$], isApplicableForProject, isApplicableForTask);

create index IX_1AE0E042 on ax_master_TemplateLevelMaster (levelName[$COLUMN_LENGTH:75$]);

create index IX_CAC67B53 on ax_master_WishTypeMaster (wishType[$COLUMN_LENGTH:75$]);