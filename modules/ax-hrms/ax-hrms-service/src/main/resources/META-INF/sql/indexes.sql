create unique index IX_E21A9208 on ax_Address (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_117B900 on ax_AppraisalEvaluationFormStatus (appraisalProcessId, appraisalFormTemplateId);
create index IX_F7AD3E89 on ax_AppraisalEvaluationFormStatus (status, submissionDate);
create unique index IX_9DB66A0B on ax_AppraisalEvaluationFormStatus (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_D6C6A82 on ax_AppraisalFormTemplates (templateLevelId, templateYear[$COLUMN_LENGTH:75$]);
create index IX_9166628C on ax_AppraisalFormTemplates (templateYear[$COLUMN_LENGTH:75$], templateLevelId);
create unique index IX_48A59454 on ax_AppraisalFormTemplates (uuid_[$COLUMN_LENGTH:75$], groupId);

create unique index IX_E043D293 on ax_AppraisalHistory (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_5F31CEBD on ax_AppraisalMeeting (appraisalProcessId);
create unique index IX_1660BC7A on ax_AppraisalMeeting (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_4962BCE0 on ax_AppraisalMeetingInvitees (appraisalMeetingId);
create unique index IX_FD930851 on ax_AppraisalMeetingInvitees (uuid_[$COLUMN_LENGTH:75$], groupId);

create unique index IX_5DD66BAE on ax_AppraisalProcess (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_C4FBF18E on ax_AppraisalReminder (appraisalProcessId);
create unique index IX_EC06EFCB on ax_AppraisalReminder (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_5ED08DE5 on ax_Attachment (timeTrackerId);
create unique index IX_F50656C7 on ax_Attachment (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_BD0E801D on ax_CompensatoryData (employeeId);
create index IX_B0E787D8 on ax_CompensatoryData (managerId);
create unique index IX_54C37CF6 on ax_CompensatoryData (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_20029821 on ax_EmployeeAddress (employeeId);
create unique index IX_7023F2FA on ax_EmployeeAddress (uuid_[$COLUMN_LENGTH:75$], groupId);

create unique index IX_F82A4517 on ax_EmployeeBankAccount (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_D396A9D1 on ax_EmployeeDepartment (departmentMasterId);
create index IX_A9FA7DD4 on ax_EmployeeDepartment (employeeId, departmentMasterId, status);
create unique index IX_98275504 on ax_EmployeeDepartment (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_979025E4 on ax_EmployeeDesignation (employeeId);
create unique index IX_26DEE73D on ax_EmployeeDesignation (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_B835A06E on ax_EmployeeDetails (firstName[$COLUMN_LENGTH:75$], lastName[$COLUMN_LENGTH:75$]);
create index IX_9163F673 on ax_EmployeeDetails (isTerminated);
create index IX_8BF94020 on ax_EmployeeDetails (leavingDate);
create index IX_3B591D32 on ax_EmployeeDetails (lrUserId);
create unique index IX_89E591C8 on ax_EmployeeDetails (uuid_[$COLUMN_LENGTH:75$], groupId);

create unique index IX_ED50280D on ax_EmployeeDocument (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_F200E55 on ax_EmployeeEducation (employeeId);
create unique index IX_A732F2E on ax_EmployeeEducation (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_11581B43 on ax_EmployeeExperience (employeeId);
create unique index IX_E6DF151C on ax_EmployeeExperience (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_A8F12CB8 on ax_EmployeeOffBoarding (employeeId);
create unique index IX_FFF86411 on ax_EmployeeOffBoarding (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_89756CBB on ax_EmployeeProbationDetails (employeeId);
create unique index IX_8486EA94 on ax_EmployeeProbationDetails (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_EB39BA89 on ax_EmployeeSalary (employeeId, status);
create unique index IX_8655187C on ax_EmployeeSalary (uuid_[$COLUMN_LENGTH:75$], groupId);

create unique index IX_D9B86A50 on ax_EmployeeUanEsic (uuid_[$COLUMN_LENGTH:75$], groupId);

create unique index IX_D62A6799 on ax_EmployeeWish (uuid_[$COLUMN_LENGTH:75$], groupId);

create unique index IX_7EA0E5F on ax_ExtendedProbationDetails (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_81F9802B on ax_Holiday (date_);
create unique index IX_665B4D6C on ax_Holiday (uuid_[$COLUMN_LENGTH:75$], groupId);
create index IX_1A12B0A8 on ax_Holiday (year, isFloater);

create index IX_EA08650E on ax_LeaveBalance (employeeId, leaveTypeMasterId);
create index IX_C9D3B07D on ax_LeaveBalance (employeeId, year, leaveTypeMasterId);
create unique index IX_ECDFE349 on ax_LeaveBalance (uuid_[$COLUMN_LENGTH:75$], groupId);
create index IX_909ED9FA on ax_LeaveBalance (year, leaveTypeMasterId);

create index IX_334E291B on ax_LeaveBalanceHistory (employeeId, year);
create unique index IX_9AA9C603 on ax_LeaveBalanceHistory (uuid_[$COLUMN_LENGTH:75$], groupId);
create index IX_C9D65BE on ax_LeaveBalanceHistory (year);

create index IX_6B3E1134 on ax_LeaveDayType (leaveRequestId);
create unique index IX_32C53AE3 on ax_LeaveDayType (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_3AB3E42E on ax_LeaveInformToTeamDetail (leaveRequestId);
create unique index IX_23B0DDD on ax_LeaveInformToTeamDetail (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_46F99663 on ax_LeaveRequest (employeeId);
create unique index IX_2B0E003C on ax_LeaveRequest (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_710DD372 on ax_LeaveTypeViewPermit (employeeId, leaveTypeMasterId);
create unique index IX_DADFF965 on ax_LeaveTypeViewPermit (uuid_[$COLUMN_LENGTH:75$], groupId);

create unique index IX_D4E00225 on ax_Nominee (uuid_[$COLUMN_LENGTH:75$], groupId);

create unique index IX_B163BC11 on ax_PipProgram (uuid_[$COLUMN_LENGTH:75$], groupId);

create unique index IX_BA53116 on ax_Policy (uuid_[$COLUMN_LENGTH:75$], groupId);
create index IX_F76854CC on ax_Policy (year, policyTypeId);

create unique index IX_B885A1ED on ax_Project (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_59A1EEA6 on ax_ProjectEmployeeDetails (employeeId);
create index IX_C468F1B8 on ax_ProjectEmployeeDetails (projectId, employeeId);
create unique index IX_857A7EFF on ax_ProjectEmployeeDetails (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_57E1B04F on ax_ProjectHistory (managerId);
create index IX_1D8555BB on ax_ProjectHistory (projectId);
create unique index IX_6F306DF on ax_ProjectHistory (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_4B083A5A on ax_RolePolicies (policyId, roleId);
create unique index IX_6DC8CA on ax_RolePolicies (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_B259B1D0 on ax_Task (assignedTo);
create index IX_DA0DA445 on ax_Task (managerId);
create index IX_F40F414E on ax_Task (projectId, assignedTo);
create index IX_4FC92D07 on ax_Task (projectId, managerId);
create unique index IX_750F1CA9 on ax_Task (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_4869A0DF on ax_TaskReview (reviewerId);
create index IX_4A7F66DF on ax_TaskReview (taskId);
create unique index IX_52460C61 on ax_TaskReview (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_8AE9739A on ax_TimeTracker (taskId, employeeId);
create unique index IX_DD4235FF on ax_TimeTracker (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_B1BC1331 on ax_UpcomingProbationEmployee (month, year);
create unique index IX_85B23666 on ax_UpcomingProbationEmployee (uuid_[$COLUMN_LENGTH:75$], groupId);