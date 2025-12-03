create table ax_Address (
	uuid_ VARCHAR(75) null,
	companyId LONG,
	createdBy LONG,
	modifiedBy LONG,
	groupId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	addressId LONG not null primary key,
	line1 VARCHAR(75) null,
	line2 VARCHAR(75) null,
	line3 VARCHAR(75) null,
	state_ VARCHAR(75) null,
	country LONG,
	pincode VARCHAR(75) null
);

create table ax_AppraisalEvaluationFormStatus (
	uuid_ VARCHAR(75) null,
	companyId LONG,
	createdBy LONG,
	modifiedBy LONG,
	groupId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	appraisalEvaluationFormStatusId LONG not null primary key,
	appraisalProcessId LONG,
	submissionDate DATE null,
	employeeId LONG,
	filledEvaluationDocuemntId LONG,
	appraisalFormTemplateId LONG,
	status BOOLEAN
);

create table ax_AppraisalFormTemplates (
	uuid_ VARCHAR(75) null,
	companyId LONG,
	createdBy LONG,
	modifiedBy LONG,
	groupId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	appraisalFormTemplateId LONG not null primary key,
	templateName VARCHAR(75) null,
	templateDocumentId LONG,
	templateLevelId LONG,
	templateYear VARCHAR(75) null,
	status BOOLEAN
);

create table ax_AppraisalHistory (
	uuid_ VARCHAR(75) null,
	companyId LONG,
	createdBy LONG,
	modifiedBy LONG,
	groupId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	appraisalId LONG not null primary key,
	salaryId LONG,
	appraisalDate DATE null,
	appraisalDocumentId LONG,
	updatedCtcPa DOUBLE,
	updatedCtcPm DOUBLE,
	rating DOUBLE,
	comments VARCHAR(1000) null
);

create table ax_AppraisalMeeting (
	uuid_ VARCHAR(75) null,
	companyId LONG,
	createdBy LONG,
	modifiedBy LONG,
	groupId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	appraisalMeetingId LONG not null primary key,
	appraisalProcessId LONG,
	meetingDate DATE null,
	meetingTime DATE null,
	status BOOLEAN
);

create table ax_AppraisalMeetingInvitees (
	uuid_ VARCHAR(75) null,
	companyId LONG,
	createdBy LONG,
	modifiedBy LONG,
	groupId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	appraisalMeetingInviteeId LONG not null primary key,
	employeeId LONG,
	appraisalMeetingId LONG
);

create table ax_AppraisalProcess (
	uuid_ VARCHAR(75) null,
	companyId LONG,
	createdBy LONG,
	modifiedBy LONG,
	groupId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	appraisalProcessId LONG not null primary key,
	isSelfEvalutionFormSent BOOLEAN,
	isSelfEvalutionFormFilled BOOLEAN,
	arePeerEvaluationFormSent BOOLEAN,
	arePeerEvaluationFormFilled BOOLEAN,
	isManagementFormSent BOOLEAN,
	isManagementFormFilled BOOLEAN,
	isMeetingScheduled BOOLEAN,
	isMeetingDone BOOLEAN,
	isSalaryUpdated BOOLEAN,
	status LONG
);

create table ax_AppraisalReminder (
	uuid_ VARCHAR(75) null,
	companyId LONG,
	createdBy LONG,
	modifiedBy LONG,
	groupId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	appraisalRemainderId LONG not null primary key,
	employeeId LONG,
	appraisalRemainderMonth VARCHAR(75) null,
	appraisalRemainderYear VARCHAR(75) null,
	appraisalProcessId LONG
);

create table ax_Attachment (
	uuid_ VARCHAR(75) null,
	companyId LONG,
	createdBy LONG,
	modifiedBy LONG,
	groupId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	attachmentId LONG not null primary key,
	timeTrackerId LONG
);

create table ax_CompensatoryData (
	uuid_ VARCHAR(75) null,
	companyId LONG,
	createdBy LONG,
	modifiedBy LONG,
	groupId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	compensatoryDataId LONG not null primary key,
	employeeId LONG,
	dateOfCompensation DATE null,
	requestedHours INTEGER,
	approvedHours INTEGER,
	managerId LONG,
	leaveCompensatoryStatusMasterId LONG,
	description VARCHAR(75) null
);

create table ax_EmployeeAddress (
	uuid_ VARCHAR(75) null,
	companyId LONG,
	createdBy LONG,
	modifiedBy LONG,
	groupId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	employeeAddressId LONG not null primary key,
	presentAddress LONG,
	permanentAddress LONG,
	presentPermanentSame BOOLEAN,
	status BOOLEAN,
	employeeId LONG
);

create table ax_EmployeeBankAccount (
	uuid_ VARCHAR(75) null,
	companyId LONG,
	createdBy LONG,
	modifiedBy LONG,
	groupId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	bankAccountId LONG not null primary key,
	accountNumber VARCHAR(75) null,
	accountType VARCHAR(75) null,
	beneficiaryName VARCHAR(75) null,
	bankName VARCHAR(75) null,
	status BOOLEAN,
	ifscCode VARCHAR(75) null,
	bankBranch VARCHAR(75) null,
	employeeId LONG
);

create table ax_EmployeeDepartment (
	uuid_ VARCHAR(75) null,
	companyId LONG,
	createdBy LONG,
	modifiedBy LONG,
	groupId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	employeeDepartmentId LONG not null primary key,
	departmentMasterId LONG,
	status BOOLEAN,
	dateOfChange DATE null,
	employeeId LONG
);

create table ax_EmployeeDesignation (
	uuid_ VARCHAR(75) null,
	companyId LONG,
	createdBy LONG,
	modifiedBy LONG,
	groupId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	employeeDesignationId LONG not null primary key,
	designationMasterId LONG,
	status BOOLEAN,
	startDate DATE null,
	endDate DATE null,
	employeeId LONG
);

create table ax_EmployeeDetails (
	uuid_ VARCHAR(75) null,
	companyId LONG,
	createdBy LONG,
	modifiedBy LONG,
	groupId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	employeeId LONG not null primary key,
	employeeCode VARCHAR(75) null,
	lrUserId LONG,
	firstName VARCHAR(75) null,
	lastName VARCHAR(75) null,
	officialEmail VARCHAR(75) null,
	personalEmail VARCHAR(75) null,
	joiningDate DATE null,
	leavingDate DATE null,
	mobileNo VARCHAR(75) null,
	gender VARCHAR(75) null,
	fatherName VARCHAR(75) null,
	dateOfBirth DATE null,
	maritalStatus BOOLEAN,
	marriageDate DATE null,
	spouseName VARCHAR(75) null,
	employeeAddressId LONG,
	skypeId VARCHAR(75) null,
	nominneeId LONG,
	bankAccountId LONG,
	uanEsicId LONG,
	probationStatusId  LONG,
	isEmployeeOnboarded BOOLEAN,
	isExperienced BOOLEAN,
	isProbationEnabled BOOLEAN,
	profilePicId LONG,
	insuranceLink VARCHAR(1000) null,
	isTerminated BOOLEAN,
	appraisalDate DATE null,
	employeeType VARCHAR(75) null,
	stipend DOUBLE
);

create table ax_EmployeeDocument (
	uuid_ VARCHAR(75) null,
	companyId LONG,
	createdBy LONG,
	modifiedBy LONG,
	groupId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	documentId LONG not null primary key,
	documentTypeId LONG,
	documentNumber VARCHAR(75) null,
	documentName VARCHAR(75) null,
	documentMediaId LONG,
	documentStatus BOOLEAN,
	employeeId LONG
);

create table ax_EmployeeEducation (
	uuid_ VARCHAR(75) null,
	companyId LONG,
	createdBy LONG,
	modifiedBy LONG,
	groupId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	educationId LONG not null primary key,
	levelId LONG,
	institution VARCHAR(75) null,
	degree VARCHAR(75) null,
	startDate DATE null,
	passingYear VARCHAR(75) null,
	endDate DATE null,
	employeeId LONG
);

create table ax_EmployeeExperience (
	uuid_ VARCHAR(75) null,
	companyId LONG,
	createdBy LONG,
	modifiedBy LONG,
	groupId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	experienceId LONG not null primary key,
	companyName VARCHAR(75) null,
	joiningDate DATE null,
	relievingDate DATE null,
	experienceCertificateMediaId LONG,
	employeeId LONG
);

create table ax_EmployeeOffBoarding (
	uuid_ VARCHAR(75) null,
	companyId LONG,
	createdBy LONG,
	modifiedBy LONG,
	groupId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	employeeOffBoardingId LONG not null primary key,
	kt BOOLEAN,
	assets BOOLEAN,
	nda BOOLEAN,
	mailAndBiometrics BOOLEAN,
	employeeId LONG,
	experienceLetterId LONG,
	fullAndFinal VARCHAR(2000) null,
	relievingLetterId LONG,
	status BOOLEAN
);

create table ax_EmployeeProbationDetails (
	uuid_ VARCHAR(75) null,
	companyId LONG,
	createdBy LONG,
	modifiedBy LONG,
	groupId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	probationDetailId LONG not null primary key,
	probationPeriod INTEGER,
	probationEndDate DATE null,
	probationStatusId LONG,
	isExtended BOOLEAN,
	employeeId LONG
);

create table ax_EmployeeSalary (
	uuid_ VARCHAR(75) null,
	companyId LONG,
	createdBy LONG,
	modifiedBy LONG,
	groupId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	salaryId LONG not null primary key,
	grossSalaryCtcPm DOUBLE,
	grossSalaryCtcPa DOUBLE,
	employeeId LONG,
	status BOOLEAN
);

create table ax_EmployeeUanEsic (
	uuid_ VARCHAR(75) null,
	companyId LONG,
	createdBy LONG,
	modifiedBy LONG,
	groupId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	uanEsicId LONG not null primary key,
	uan VARCHAR(75) null,
	esicNo VARCHAR(75) null,
	status BOOLEAN
);

create table ax_EmployeeWish (
	uuid_ VARCHAR(75) null,
	companyId LONG,
	createdBy LONG,
	modifiedBy LONG,
	groupId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	wishId LONG not null primary key,
	senderId LONG,
	receiverId LONG,
	content TEXT null,
	wishTypeMasterId LONG,
	timeStamp DATE null
);

create table ax_ExtendedProbationDetails (
	uuid_ VARCHAR(75) null,
	companyId LONG,
	createdBy LONG,
	modifiedBy LONG,
	groupId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	extendedProbationDetailsId LONG not null primary key,
	probationDetailId LONG,
	extendDate DATE null,
	evalutionReview VARCHAR(500) null,
	extendedProbationPeriod INTEGER,
	extendedProbationEndDate DATE null
);

create table ax_Holiday (
	uuid_ VARCHAR(75) null,
	companyId LONG,
	createdBy LONG,
	modifiedBy LONG,
	groupId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	holidayId LONG not null primary key,
	holidayName VARCHAR(75) null,
	date_ DATE null,
	description VARCHAR(75) null,
	year INTEGER,
	isFloater BOOLEAN
);

create table ax_LeaveBalance (
	uuid_ VARCHAR(75) null,
	companyId LONG,
	createdBy LONG,
	modifiedBy LONG,
	groupId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	leaveBalanceId LONG not null primary key,
	employeeId LONG,
	leaveTypeMasterId LONG,
	year INTEGER,
	noOfUsedLeaves DOUBLE,
	noOfRemainingLeaves DOUBLE
);

create table ax_LeaveBalanceHistory (
	uuid_ VARCHAR(75) null,
	companyId LONG,
	createdBy LONG,
	modifiedBy LONG,
	groupId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	leaveBalanceHistoryId LONG not null primary key,
	leaveBalanceId LONG,
	employeeId LONG,
	leaveTypeMasterId LONG,
	year INTEGER,
	noOfUsedLeaves DOUBLE,
	noOfRemainingLeaves DOUBLE
);

create table ax_LeaveDayType (
	uuid_ VARCHAR(75) null,
	companyId LONG,
	createdBy LONG,
	modifiedBy LONG,
	groupId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	leaveDayTypeId LONG not null primary key,
	leaveRequestId LONG,
	leaveDate DATE null,
	isHalfDay BOOLEAN,
	isFirstHalf BOOLEAN
);

create table ax_LeaveInformToTeamDetail (
	uuid_ VARCHAR(75) null,
	companyId LONG,
	createdBy LONG,
	modifiedBy LONG,
	groupId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	leaveInformId LONG not null primary key,
	leaveRequestId LONG,
	employeeId LONG
);

create table ax_LeaveRequest (
	uuid_ VARCHAR(75) null,
	companyId LONG,
	createdBy LONG,
	modifiedBy LONG,
	groupId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	leaveRequestId LONG not null primary key,
	employeeId LONG,
	leaveTypeMasterId LONG,
	startDateTime DATE null,
	endDateTime DATE null,
	reason VARCHAR(250) null,
	leaveCompensatoryStatusMasterId LONG,
	hrApprovalId LONG,
	managerApprovalId LONG,
	dateOfRequest DATE null
);

create table ax_LeaveTypeViewPermit (
	uuid_ VARCHAR(75) null,
	companyId LONG,
	createdBy LONG,
	modifiedBy LONG,
	groupId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	leaveTypeViewPermitId LONG not null primary key,
	leaveTypeMasterId LONG,
	employeeId LONG,
	yearOfLeaveTypeViewPermit INTEGER
);

create table ax_Nominee (
	uuid_ VARCHAR(75) null,
	companyId LONG,
	createdBy LONG,
	modifiedBy LONG,
	groupId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	nomineeId LONG not null primary key,
	nomineeFirstName VARCHAR(75) null,
	nomineeLastName VARCHAR(75) null,
	nomineeContact VARCHAR(75) null,
	nomineeAddress LONG,
	relationshipWithNominee VARCHAR(75) null,
	nomineeDob DATE null
);

create table ax_PipProgram (
	uuid_ VARCHAR(75) null,
	companyId LONG,
	createdBy LONG,
	modifiedBy LONG,
	groupId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	pipProgramId LONG not null primary key,
	employeeId LONG,
	startDate DATE null,
	endDate DATE null,
	numberOfMonths INTEGER,
	improvementAreas VARCHAR(2000) null,
	meetingDate DATE null,
	status VARCHAR(75) null,
	isExtended BOOLEAN
);

create table ax_Policy (
	uuid_ VARCHAR(75) null,
	companyId LONG,
	createdBy LONG,
	modifiedBy LONG,
	groupId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	policyId LONG not null primary key,
	policyName VARCHAR(75) null,
	policyDescription VARCHAR(75) null,
	year INTEGER,
	status BOOLEAN,
	policyTypeId LONG,
	policyDocumentId LONG,
	applicableDate DATE null
);

create table ax_Project (
	uuid_ VARCHAR(75) null,
	companyId LONG,
	createdBy LONG,
	modifiedBy LONG,
	groupId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	projectId LONG not null primary key,
	projectName VARCHAR(75) null,
	description VARCHAR(256) null
);

create table ax_ProjectEmployeeDetails (
	uuid_ VARCHAR(75) null,
	companyId LONG,
	createdBy LONG,
	modifiedBy LONG,
	groupId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	projectEmployeeDetailsId LONG not null primary key,
	projectId LONG,
	employeeId LONG
);

create table ax_ProjectHistory (
	uuid_ VARCHAR(75) null,
	companyId LONG,
	createdBy LONG,
	modifiedBy LONG,
	groupId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	projectHistoryId LONG not null primary key,
	projectId LONG,
	projectTaskStatusMasterId LONG,
	managerId LONG,
	startDate DATE null,
	isBillble BOOLEAN
);

create table ax_RolePolicies (
	uuid_ VARCHAR(75) null,
	companyId LONG,
	createdBy LONG,
	modifiedBy LONG,
	groupId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	rolePoliciesId LONG not null primary key,
	roleId LONG,
	policyId LONG
);

create table ax_Task (
	uuid_ VARCHAR(75) null,
	companyId LONG,
	createdBy LONG,
	modifiedBy LONG,
	groupId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	taskId LONG not null primary key,
	taskName VARCHAR(75) null,
	description VARCHAR(256) null,
	projectId LONG,
	mainTaskId LONG,
	assignedTo LONG,
	projectTaskStatusMasterId LONG,
	priorityMasterId LONG,
	estimatedHours INTEGER,
	managerId LONG,
	assignDate DATE null,
	startDate DATE null,
	dueDate DATE null,
	completeDate DATE null,
	isBillble BOOLEAN,
	isSubTask BOOLEAN
);

create table ax_TaskReview (
	uuid_ VARCHAR(75) null,
	companyId LONG,
	createdBy LONG,
	modifiedBy LONG,
	groupId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	taskReviewId LONG not null primary key,
	taskId LONG,
	reviewerId LONG,
	review TEXT null,
	dateOfReview DATE null
);

create table ax_TimeTracker (
	uuid_ VARCHAR(75) null,
	companyId LONG,
	createdBy LONG,
	modifiedBy LONG,
	groupId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	timeTrackerId LONG not null primary key,
	taskId LONG,
	employeeId LONG,
	startTime DATE null,
	endTime DATE null,
	duration DOUBLE,
	description VARCHAR(500) null,
	managerApproveStatus VARCHAR(75) null
);

create table ax_UpcomingProbationEmployee (
	uuid_ VARCHAR(75) null,
	companyId LONG,
	createdBy LONG,
	modifiedBy LONG,
	groupId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	upcomingProbationEmployeeId LONG not null primary key,
	probationDetailId LONG,
	month INTEGER,
	year INTEGER
);