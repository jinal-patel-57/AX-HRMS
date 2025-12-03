create table ax_master_AppraisalStatusMaster (
	appraisalStatusMasterId LONG not null primary key,
	companyId LONG,
	createdBy LONG,
	modifiedBy LONG,
	groupId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	status VARCHAR(75) null
);

create table ax_master_DepartmentMaster (
	departmentMasterId LONG not null primary key,
	companyId LONG,
	createdBy LONG,
	modifiedBy LONG,
	groupId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	departmentName VARCHAR(75) null
);

create table ax_master_DesignationMaster (
	designationMasterId LONG not null primary key,
	companyId LONG,
	createdBy LONG,
	modifiedBy LONG,
	groupId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	designationName VARCHAR(75) null
);

create table ax_master_DocumentTypeMaster (
	documentTypeMasterId LONG not null primary key,
	companyId LONG,
	createdBy LONG,
	modifiedBy LONG,
	groupId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	documentTypeName VARCHAR(75) null
);

create table ax_master_EducationLevelMaster (
	educationLevelMasterId LONG not null primary key,
	companyId LONG,
	createdBy LONG,
	modifiedBy LONG,
	groupId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	levelName VARCHAR(75) null
);

create table ax_master_LeaveCompensatoryStatusMaster (
	leaveCompensatoryStatusMasterId LONG not null primary key,
	companyId LONG,
	createdBy LONG,
	modifiedBy LONG,
	groupId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	leaveCompensatoryStatus VARCHAR(75) null
);

create table ax_master_LeavePolicyMaster (
	leavePolicyMasterId LONG not null primary key,
	companyId LONG,
	createdBy LONG,
	modifiedBy LONG,
	groupId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	description VARCHAR(75) null,
	accrualRate DOUBLE,
	maximumBalance DOUBLE,
	leaveTypeMasterId LONG,
	isCheckMax BOOLEAN,
	yearOfPolicy INTEGER,
	isCarryForward BOOLEAN,
	isContinuous BOOLEAN,
	eligibleAfterMonths INTEGER,
	isApplicableFloater BOOLEAN
);

create table ax_master_LeaveTypeMaster (
	leaveTypeMasterId LONG not null primary key,
	companyId LONG,
	createdBy LONG,
	modifiedBy LONG,
	groupId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	leaveTypeName VARCHAR(75) null,
	description VARCHAR(250) null,
	isActive BOOLEAN,
	isAppearForAll BOOLEAN
);

create table ax_master_PolicyTypeMaster (
	policyTypeMasterID LONG not null primary key,
	companyId LONG,
	createdBy LONG,
	modifiedBy LONG,
	groupId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	policyType VARCHAR(75) null
);

create table ax_master_PriorityMaster (
	priorityMasterId LONG not null primary key,
	companyId LONG,
	createdBy LONG,
	modifiedBy LONG,
	groupId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	priorityName VARCHAR(75) null
);

create table ax_master_ProbationStatusMaster (
	probationStatusMasterId LONG not null primary key,
	companyId LONG,
	createdBy LONG,
	modifiedBy LONG,
	groupId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	statusType VARCHAR(75) null
);

create table ax_master_ProjectTaskStatusMaster (
	projectTaskStatusMasterId LONG not null primary key,
	companyId LONG,
	createdBy LONG,
	modifiedBy LONG,
	groupId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	projectTaskStatusName VARCHAR(75) null,
	isApplicableForProject BOOLEAN,
	isApplicableForTask BOOLEAN
);

create table ax_master_TemplateLevelMaster (
	templateLevelMasterId LONG not null primary key,
	companyId LONG,
	createdBy LONG,
	modifiedBy LONG,
	groupId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	levelName VARCHAR(75) null
);

create table ax_master_WishTypeMaster (
	wishTypeMasterId LONG not null primary key,
	companyId LONG,
	createdBy LONG,
	modifiedBy LONG,
	groupId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	wishType VARCHAR(75) null
);