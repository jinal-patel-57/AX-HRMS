    package com.ax.hrms.employee.onboarding.hr.web.action;

    import com.ax.hrms.common.api.api.AxHrmsCommonApi;
    import com.ax.hrms.employee.onboarding.employee.web.util.EmployeeBasicDetailsUtil;
    import com.ax.hrms.employee.onboarding.web.constants.AxHrmsEmployeeOnBoardingEmployeeConstants;
    import com.ax.hrms.employee.onboarding.web.constants.AxHrmsEmployeeOnboardingHrWebPortletConstants;
    import com.ax.hrms.employee.onboarding.web.constants.AxHrmsEmployeeOnboardingWebPortletKeys;
import com.ax.hrms.exception.NoSuchEmployeeSalaryException;
import com.ax.hrms.master.model.DepartmentMaster;
    import com.ax.hrms.master.model.DesignationMaster;
    import com.ax.hrms.master.model.DocumentTypeMaster;
    import com.ax.hrms.master.service.DepartmentMasterLocalService;
    import com.ax.hrms.master.service.DesignationMasterLocalService;
    import com.ax.hrms.master.service.DocumentTypeMasterLocalService;
    import com.ax.hrms.master.service.ProbationStatusMasterLocalService;
    import com.ax.hrms.model.EmployeeDepartment;
    import com.ax.hrms.model.EmployeeDesignation;
    import com.ax.hrms.model.EmployeeDetails;
    import com.ax.hrms.model.EmployeeSalary;
    import com.ax.hrms.service.EmployeeDepartmentLocalService;
    import com.ax.hrms.service.EmployeeDesignationLocalService;
    import com.ax.hrms.service.EmployeeDetailsLocalService;
    import com.ax.hrms.service.EmployeeSalaryLocalService;
    import com.ax.hrms.service.persistence.EmployeeDetailsPersistence;
    import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
    import com.liferay.portal.kernel.dao.orm.DynamicQuery;
    import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
    import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
    import com.liferay.portal.kernel.exception.PortalException;
    import com.liferay.portal.kernel.log.Log;
    import com.liferay.portal.kernel.log.LogFactoryUtil;
    import com.liferay.portal.kernel.model.Role;
    import com.liferay.portal.kernel.model.User;
    import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
    import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
    import com.liferay.portal.kernel.repository.model.Folder;
    import com.liferay.portal.kernel.service.RoleLocalService;
    import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
    import com.liferay.portal.kernel.service.RoleService;
    import com.liferay.portal.kernel.service.ServiceContext;
    import com.liferay.portal.kernel.service.ServiceContextFactory;
    import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
    import com.liferay.portal.kernel.upload.UploadPortletRequest;
    import com.liferay.portal.kernel.util.*;
    import com.liferay.roles.admin.role.type.contributor.provider.RoleTypeContributorProvider;

    import java.io.File;
    import java.text.SimpleDateFormat;
    import java.util.ArrayList;
    import java.util.Arrays;
    import java.util.Date;
    import java.util.List;
    import java.util.Locale;
    import java.util.stream.Collectors;

    import javax.portlet.ActionRequest;
    import javax.portlet.ActionResponse;

    import org.osgi.service.component.annotations.Component;
    import org.osgi.service.component.annotations.Reference;

    @Component(immediate = true, property = {
            "javax.portlet.name=" + AxHrmsEmployeeOnboardingWebPortletKeys.AX_HRMS_EMPLOYEE_ONBOARDING_HR_WEB,
            "mvc.command.name=/addEditEmployeeOnBoarding" }, service = MVCActionCommand.class)
    public class AddEditEmployeeOnBoardingMVCActionCommmand extends BaseMVCActionCommand {

        @Reference
        EmployeeDetailsLocalService employeeDetailsLocalService;

        @Reference
        EmployeeSalaryLocalService employeeSalaryLocalService;

        @Reference
        AxHrmsCommonApi axHrmsCommonApi;

        @Reference
        UserLocalService userLocalService;

        @Reference
        DepartmentMasterLocalService departmentMasterLocalService;

        @Reference
        DesignationMasterLocalService designationMasterLocalService;

        @Reference
        EmployeeDesignationLocalService employeeDesignationLocalService;

        @Reference
        EmployeeDepartmentLocalService employeeDepartmentLocalService;

        @Reference
        private Localization localization;

        @Reference
        private RoleLocalService roleLocalService;

        @Reference
        private RoleService roleService;

        @Reference
        private RoleTypeContributorProvider roleTypeContributorProvider;

        @Reference
        private ProbationStatusMasterLocalService probationStatusMasterLocalService;

        @Reference
        private DocumentTypeMasterLocalService documentTypeMasterLocalService;


        private Log log = LogFactoryUtil.getLog(AddEditEmployeeOnBoardingMVCActionCommmand.class);


        @Override
        protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {

            log.info("AddEditEmployeeOnBoardingMVCActionCommmand >>> doProcessAction ::: Action Called ::: ");



            long employeeId = ParamUtil.getLong(actionRequest, AxHrmsEmployeeOnBoardingEmployeeConstants.EMPLOYEE_ID);

            ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
            ServiceContext serviceContext = ServiceContextFactory.getInstance(Folder.class.getName(), actionRequest);
            serviceContext.setAddGroupPermissions(true);
            serviceContext.setAddGuestPermissions(false);
            long oldManagerId = 0l;
            String kycSourceType = ParamUtil.getString(actionRequest, "kycSourceType");

            EmployeeDetails employeeUser = employeeDetailsLocalService.getEmployeeDetails(employeeId);
            User employeeLrUser = userLocalService.getUser(employeeUser.getLrUserId());

            Folder folder = axHrmsCommonApi.createFolder(AxHrmsEmployeeOnBoardingEmployeeConstants.HRMS_DOCUMENT, 0,themeDisplay, serviceContext);
            Folder parentFolder = axHrmsCommonApi.createFolder(String.format("%s%d", employeeLrUser.getScreenName(), employeeLrUser.getUserId()),folder.getFolderId(), themeDisplay, serviceContext);
            Folder profilePictureFolder = axHrmsCommonApi.createFolder(AxHrmsEmployeeOnBoardingEmployeeConstants.PROFILE_PICTURE, parentFolder.getFolderId(), themeDisplay,serviceContext);
            Folder aadhaarCardFolder = axHrmsCommonApi.createFolder(AxHrmsEmployeeOnBoardingEmployeeConstants.AADHAAR_CARD_FOLDER, parentFolder.getFolderId(), themeDisplay,serviceContext);
            Folder panCardFolder = axHrmsCommonApi.createFolder(AxHrmsEmployeeOnBoardingEmployeeConstants.PAN_CARD_FOLDER, parentFolder.getFolderId(), themeDisplay,serviceContext);

            UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(actionRequest);
            File file = uploadRequest.getFile(AxHrmsEmployeeOnBoardingEmployeeConstants.EMPLOYEE_PROFILE_PICTURE);
            String fileName = generateFileName(uploadRequest.getFileName(AxHrmsEmployeeOnBoardingEmployeeConstants.EMPLOYEE_PROFILE_PICTURE));

            File aadhaarFile = uploadRequest.getFile(AxHrmsEmployeeOnBoardingEmployeeConstants.AADHAAR_CARD);
            String aadhaarFileName = generateFileName(uploadRequest.getFileName(AxHrmsEmployeeOnBoardingEmployeeConstants.AADHAAR_CARD));

            File panFile = uploadRequest.getFile(AxHrmsEmployeeOnBoardingEmployeeConstants.PAN_CARD);
            String panFileName = generateFileName(uploadRequest.getFileName(AxHrmsEmployeeOnBoardingEmployeeConstants.PAN_CARD));
            String boodGroup =ParamUtil.getString(actionRequest, "bloodGroup");



		EmployeeDetails employeeDetails = employeeDetailsLocalService.getEmployeeDetails(ParamUtil.getLong(actionRequest, "employeeId"));
		employeeDetails.setPersonalEmail(ParamUtil.getString(actionRequest, AxHrmsEmployeeOnBoardingEmployeeConstants.PERSONAL_EMAIL));
		employeeDetails.setMobileNo(ParamUtil.getString(actionRequest, AxHrmsEmployeeOnBoardingEmployeeConstants.MOBILE_NUMBER));
		employeeDetails.setSkypeId(ParamUtil.getString(actionRequest, AxHrmsEmployeeOnBoardingEmployeeConstants.SKYPE_ID,""));
		employeeDetails.setFatherName(ParamUtil.getString(actionRequest, AxHrmsEmployeeOnBoardingEmployeeConstants.FATHER_NAME));
		employeeDetails.setMaritalStatus(ParamUtil.getBoolean(actionRequest, AxHrmsEmployeeOnBoardingEmployeeConstants.MARTIAL_STATUS));
		employeeDetails.setSpouseName(ParamUtil.getString(actionRequest, AxHrmsEmployeeOnBoardingEmployeeConstants.SPOUSE_NAME));
        employeeDetails.setNameAsPerAadhaarCard(ParamUtil.getString(actionRequest, AxHrmsEmployeeOnBoardingEmployeeConstants.NAME_AS_PER_AADHAAR_CARD));
        employeeDetails.setBloodGroup(boodGroup);
        employeeDetails.setAadhaarCardNumber(ParamUtil.getString(actionRequest, AxHrmsEmployeeOnBoardingEmployeeConstants.AADHAR_NUMBER));
        employeeDetails.setPanCardNumber(ParamUtil.getString(actionRequest, AxHrmsEmployeeOnBoardingEmployeeConstants.PAN_NUMBER));

            User lrUser =
                    userLocalService.getUser(employeeDetails.getLrUserId());
            
            long documentTypeMasterId = ParamUtil.getLong(
                    actionRequest,
                    "kycDocumentType"
            );
            DocumentTypeMaster selectedDocType =
                    documentTypeMasterLocalService.getDocumentTypeMaster(documentTypeMasterId);
            log.info("selectedDocType.getDocumentTypeName() :: "+selectedDocType.getDocumentTypeName());

            UploadPortletRequest uploadPortletRequest =
                    PortalUtil.getUploadPortletRequest(actionRequest);

            File kycFile =
                    uploadPortletRequest.getFile("kycDocumentFile");

            String originalFileName =
                    uploadPortletRequest.getFileName("kycDocumentFile");

            String employeeFolderName =
                    lrUser.getScreenName() + lrUser.getUserId();
//            long kycFileEntryId = axHrmsCommonApi.uploadEmployeeDocument(
//                    themeDisplay,
//                    serviceContext,
//                    kycFile,
//                    originalFileName,
//                    employeeDetails.getKycDocumentFileEntryId(),
//                    AxHrmsEmployeeOnboardingWebPortletKeys.ROOT_FOLDER_HRMS_DOCUMENT,
//                    employeeFolderName,
//                    AxHrmsEmployeeOnboardingWebPortletKeys.FOLDER_KYC_DOCUMENT
//            );
            long kycFileEntryId=0;
            if ("PAN_NEW".equals(kycSourceType) || "AADHAAR_NEW".equals(kycSourceType)) {

                if (kycFile != null && kycFile.length() > 0) {

                    kycFileEntryId = axHrmsCommonApi.uploadEmployeeDocument(
                            themeDisplay,
                            serviceContext,
                            kycFile,
                            originalFileName,
                            employeeDetails.getKycDocumentFileEntryId(),
                            AxHrmsEmployeeOnboardingWebPortletKeys.ROOT_FOLDER_HRMS_DOCUMENT,
                            employeeFolderName,
                            AxHrmsEmployeeOnboardingWebPortletKeys.FOLDER_KYC_DOCUMENT
                    );

                }

            } else if ("PAN_EXISTING".equals(kycSourceType)) {

                kycFileEntryId = employeeDetails.getPanCardFileId();

            } else if ("AADHAAR_EXISTING".equals(kycSourceType)) {

                kycFileEntryId = employeeDetails.getAadhaarCardFileId();
            } else{
                kycFileEntryId = axHrmsCommonApi.uploadEmployeeDocument(
                    themeDisplay,
                    serviceContext,
                    kycFile,
                    originalFileName,
                    employeeDetails.getKycDocumentFileEntryId(),
                    AxHrmsEmployeeOnboardingWebPortletKeys.ROOT_FOLDER_HRMS_DOCUMENT,
                    employeeFolderName,
                    AxHrmsEmployeeOnboardingWebPortletKeys.FOLDER_KYC_DOCUMENT
            );
            }

            employeeDetails.setDocumentTypeMasterId(documentTypeMasterId);
            employeeDetails.setKycDocumentFileEntryId(kycFileEntryId);
            try {
                SimpleDateFormat formatter = new SimpleDateFormat(AxHrmsEmployeeOnBoardingEmployeeConstants.DATE_FORMAT,Locale.ENGLISH);
                log.info("Date of DOB :-"+ ParamUtil.getString(actionRequest, AxHrmsEmployeeOnBoardingEmployeeConstants.DATE_OF_BIRTH));
                employeeDetails.setDateOfBirth(formatter.parse(ParamUtil.getString(actionRequest, AxHrmsEmployeeOnBoardingEmployeeConstants.DATE_OF_BIRTH)));
                log.info("Set dob"+ employeeDetails.getDateOfBirth());
                String marriageDate = ParamUtil.getString(actionRequest, AxHrmsEmployeeOnBoardingEmployeeConstants.MARRIAGE_DATE);
                if(Validator.isNotNull(marriageDate)) {
                    employeeDetails.setMarriageDate(formatter.parse(ParamUtil.getString(actionRequest, AxHrmsEmployeeOnBoardingEmployeeConstants.MARRIAGE_DATE)));
                }
            } catch (Exception e) {
                log.error("Error parsing date format: " + e.getMessage());
            }

            long hrRoleId = RoleLocalServiceUtil.getRole(themeDisplay.getCompanyId(), "HR Admin").getRoleId();
            long[] hrRoles = themeDisplay.getUser().getRoleIds();
            boolean isHr = Arrays.stream(hrRoles).anyMatch(id -> id == hrRoleId);

            if (isHr) {
                String employeeCode = ParamUtil.getString(actionRequest,AxHrmsEmployeeOnboardingHrWebPortletConstants.EMPLOYEE_CODE);
                String firstName = ParamUtil.getString(actionRequest,AxHrmsEmployeeOnboardingHrWebPortletConstants.FIRST_NAME);
                String lastName = ParamUtil.getString(actionRequest,AxHrmsEmployeeOnboardingHrWebPortletConstants.LAST_NAME);
                String middleName = ParamUtil.getString(actionRequest,AxHrmsEmployeeOnboardingHrWebPortletConstants.MIDDLE_NAME);
                String isProbationEnabled = ParamUtil.getString(actionRequest,AxHrmsEmployeeOnboardingHrWebPortletConstants.IS_PROBBATION_ENABLED);
                String insuranceLink = ParamUtil.getString(actionRequest,AxHrmsEmployeeOnboardingHrWebPortletConstants.INSURANCE_LINK);
                String joiningDate = ParamUtil.getString(actionRequest,AxHrmsEmployeeOnboardingHrWebPortletConstants.JOINING_DATE);
                String gender = ParamUtil.getString(actionRequest, AxHrmsEmployeeOnboardingHrWebPortletConstants.GENDER);
                long designations = ParamUtil.getLong(actionRequest,AxHrmsEmployeeOnboardingHrWebPortletConstants.DESIGNATION);
                long[] departments = ParamUtil.getLongValues(actionRequest,AxHrmsEmployeeOnboardingHrWebPortletConstants.DEPARTMENT);
                String isExperienced = ParamUtil.getString(actionRequest,AxHrmsEmployeeOnboardingHrWebPortletConstants.IS_EXPERIENCED);
                double grossSalaryCTCPM = ParamUtil.getDouble(actionRequest,AxHrmsEmployeeOnboardingHrWebPortletConstants.GROSS_SALARY_CTC_PM);
                double grossSalaryCTCPA = ParamUtil.getDouble(actionRequest,AxHrmsEmployeeOnboardingHrWebPortletConstants.GROSS_SALARY_CTC_PA);
                long branchId = ParamUtil.getLong(actionRequest,AxHrmsEmployeeOnboardingHrWebPortletConstants.BRANCH);

                log.info("BranchId in update :-"+ branchId);

                SimpleDateFormat formatter = new SimpleDateFormat(AxHrmsEmployeeOnboardingHrWebPortletConstants.DATE_FORMAT,Locale.ENGLISH);
                Date joiningDateParsed = formatter.parse(joiningDate);

                employeeDetails.setJoiningDate(joiningDateParsed);
//                employeeDetails.setEmployeeCode(employeeCode);
                employeeDetails.setFirstName(firstName);
                employeeDetails.setLastName(lastName);
                employeeDetails.setGender(gender);
                employeeDetails.setIsExperienced(isExperienced.equalsIgnoreCase("yes"));
                employeeDetails.setInsuranceLink(insuranceLink);
                employeeDetails.setIsTerminated(false);
                employeeDetails.setCreatedBy(themeDisplay.getUserId());
                employeeDetails.setGroupId(themeDisplay.getCompanyGroupId());
                employeeDetails.setIsProbationEnabled(isProbationEnabled.equalsIgnoreCase("Enabled"));
                if(!isProbationEnabled.equalsIgnoreCase("Enabled")) {
                employeeDetails.setProbationStatusId( probationStatusMasterLocalService.findByProbationStatusName(AxHrmsEmployeeOnboardingHrWebPortletConstants.COMPLETED).getProbationStatusMasterId());
                }
                employeeDetails.setBranchId(branchId);
                employeeDetails.setExperienceYears(isExperienced.equalsIgnoreCase("yes") ?ParamUtil.getDouble(actionRequest, AxHrmsEmployeeOnBoardingEmployeeConstants.EXPERIENCE_YEAR):0);
                if(employeeDetails.getEmployeeType().equalsIgnoreCase("intern")) {
                    employeeDetails.setStipend(ParamUtil.getDouble(actionRequest, AxHrmsEmployeeOnBoardingEmployeeConstants.STIPEND));
                }else{
                    try {
                        EmployeeSalary employeeSalary = employeeSalaryLocalService.findByEmployeeIdAndStatus(employeeId, true);

                        log.info("employee salary -- " + employeeSalary);

                        employeeSalary.setGrossSalaryCtcPa(grossSalaryCTCPA);
                        employeeSalary.setGrossSalaryCtcPm(grossSalaryCTCPM);
                        log.info("before update ");
                        employeeSalaryLocalService.updateEmployeeSalary(employeeSalary);
                    } catch(NoSuchEmployeeSalaryException nsese) {
                        log.error("No active salary record found for employee." + nsese.getMessage());
                    }
                }

                log.info("Manager id in the employee side: " + ParamUtil.getLong(actionRequest, "manager"));
                oldManagerId = employeeDetails.getManagerId();
                employeeDetails.setManagerId(ParamUtil.getLong(actionRequest, "manager"));
                log.info("Old Manager: "   + oldManagerId);

//                updateEmployeeWithManager(themeDisplay.getCompanyId(),employeeDetails,ParamUtil.getLong(actionRequest, "manager"),oldManagerId);


                

               log.info("after update ");
                User user = userLocalService.getUser(employeeDetails.getLrUserId());
                user.setFirstName(firstName);
                user.setLastName(lastName);
                user.setMiddleName(middleName);
                userLocalService.updateUser(user);
                log.info("user information updated"+user.toString());

                List<DesignationMaster> oldDesignationMasterList=axHrmsCommonApi.getDesignationMastersFromEmployeeId(employeeId);
              
                for(DesignationMaster old:oldDesignationMasterList) {
                    try {
                    	Role role = roleService.getRole(themeDisplay.getCompanyId(), old.getDesignationName());
                        RoleLocalServiceUtil.deleteUserRole(employeeDetails.getLrUserId(), role.getRoleId());
                        log.info("role information updated"+role);
                        EmployeeDesignation employeeDesignation = employeeDesignationLocalService.findByEmployeeDesignationStatusAndEmployeeId(old.getDesignationMasterId(),true,employeeDetails.getEmployeeId());
                        log.info("employee designation -- " + employeeDesignation);
                        employeeDesignation.setStatus(false);
                        employeeDesignation.setEndDate(new Date());
                        employeeDesignationLocalService.updateEmployeeDesignation(employeeDesignation);
                    }catch(PortalException e) {
                    	log.error("Error while fetching designation role");
                    }

                }
                
                log.info("employee details updated"+employeeDetails.toString());
                DesignationMaster designationMaster;
                try {



                    EmployeeDesignation employeeDesignation = employeeDesignationLocalService.createEmployeeDesignation(CounterLocalServiceUtil.increment(EmployeeDesignation.class.getName()));

                    employeeDesignation.setCompanyId(themeDisplay.getCompanyId());
                    employeeDesignation.setCreatedBy(themeDisplay.getUserId());
                    employeeDesignation.setGroupId(themeDisplay.getCompanyGroupId());
                    employeeDesignation.setCreateDate(new Date());
                    employeeDesignation.setModifiedDate(new Date());

                    employeeDesignation.setDesignationMasterId(designations);
                    employeeDesignation.setStatus(true);
                    employeeDesignation.setStartDate(new Date());
                    employeeDesignation.setEmployeeId(employeeDetails.getEmployeeId());

                    designationMaster = designationMasterLocalService.findByDesignationNameById(employeeDesignation.getDesignationMasterId());

                    String newDesignationRole = designationMaster.getDesignationName();

                    employeeDesignationLocalService.addEmployeeDesignation(employeeDesignation);

                    Role newDesignationsRole = roleService.getRole(themeDisplay.getCompanyId(), newDesignationRole);

                    RoleLocalServiceUtil.addUserRole(employeeDetails.getLrUserId(), newDesignationsRole);

                } catch (Exception e) {
                    log.info("Error while creating employee designation");
                    log.error(e.getMessage());
                }

                List<DepartmentMaster> oldDepartmentMastersList = axHrmsCommonApi.getDepartmentMastersFromEmployeeId(employeeId); // depratments already assigned to the employee
                List<DepartmentMaster> recievedDepartmentMasterList = new ArrayList<>(); // departments coming from the request
                List<DepartmentMaster> addedDepartmentMasterList = new ArrayList<>();
                List<DepartmentMaster> removedDepartmentMasterList = new ArrayList<>();
                for (long dId : departments) {
                    recievedDepartmentMasterList.add(departmentMasterLocalService.getDepartmentMaster(dId));
                }

                // Fill addedDepartmentMasterList
                addedDepartmentMasterList.addAll(recievedDepartmentMasterList.stream()
                        .filter(received -> oldDepartmentMastersList.stream()
                                .noneMatch(old -> old.getDepartmentMasterId() == (received.getDepartmentMasterId())))
                        .collect(Collectors.toList()));
                // Fill removedDepartmentMasterList
                removedDepartmentMasterList.addAll(oldDepartmentMastersList.stream()
                        .filter(old -> recievedDepartmentMasterList.stream()
                                .noneMatch(received -> received.getDepartmentMasterId() == (old.getDepartmentMasterId())))
                        .collect(Collectors.toList()));
                DepartmentMaster departmentMaster;
                
                for(DepartmentMaster delete:removedDepartmentMasterList ) {
                    EmployeeDepartment employeeDepartment=employeeDepartmentLocalService.findByEmployeeIdAndStatusAndDepartmentMasterId(delete.getDepartmentMasterId(), true, employeeId);
                    employeeDepartment.setCompanyId(themeDisplay.getCompanyId());
                     employeeDepartment.setCreatedBy(themeDisplay.getUserId());
                     employeeDepartment.setGroupId(themeDisplay.getCompanyGroupId());
                     employeeDepartment.setCreateDate(new Date());
                     employeeDepartment.setModifiedDate(new Date());
                     employeeDepartment.setDepartmentMasterId(delete.getDepartmentMasterId());
                     employeeDepartment.setStatus(false);
                     employeeDepartment.setDateOfChange(new Date());
                     employeeDepartment.setEmployeeId(employeeDetails.getEmployeeId());
                    employeeDepartmentLocalService.updateEmployeeDepartment(employeeDepartment);
                    departmentMaster=departmentMasterLocalService.findByDepartmentNameById(employeeDepartment.getDepartmentMasterId());
                    String oldDepartmentName =departmentMaster.getDepartmentName();

                    Role role = roleService.getRole(themeDisplay.getCompanyId(), oldDepartmentName);
                    RoleLocalServiceUtil.deleteUserRole(employeeDetails.getLrUserId(), role.getRoleId());

                }
                
                for (DepartmentMaster added : addedDepartmentMasterList) {

                    EmployeeDepartment	employeeDepartment = employeeDepartmentLocalService.createEmployeeDepartment(CounterLocalServiceUtil.increment(EmployeeDepartment.class.getName()));

                     employeeDepartment.setCompanyId(themeDisplay.getCompanyId());
                     employeeDepartment.setCreatedBy(themeDisplay.getUserId());
                     employeeDepartment.setGroupId(themeDisplay.getCompanyGroupId());
                     employeeDepartment.setCreateDate(new Date());
                     employeeDepartment.setModifiedDate(new Date());
                     employeeDepartment.setDepartmentMasterId(added.getDepartmentMasterId());

                     employeeDepartment.setStatus(true);
                     employeeDepartment.setDateOfChange(new Date());
                     employeeDepartment.setEmployeeId(employeeDetails.getEmployeeId());
                     employeeDepartmentLocalService.addEmployeeDepartment(employeeDepartment);

                     departmentMaster=departmentMasterLocalService.findByDepartmentNameById(employeeDepartment.getDepartmentMasterId());
                     String newDepartmentName =departmentMaster.getDepartmentName();
                     Role newDesignationsRole = roleService.getRole(themeDisplay.getCompanyId(), newDepartmentName);

                    RoleLocalServiceUtil.addUserRole(employeeDetails.getLrUserId(), newDesignationsRole);

                }

                
            }
            EmployeeBasicDetailsUtil employeeBasicDetailsUtil = new EmployeeBasicDetailsUtil();
//            employeeBasicDetailsUtil.addEditFileEntry(file, fileName, actionRequest, employeeDetails, profilePictureFolder,serviceContext);
//            employeeBasicDetailsUtil.addEditFileEntry(aadhaarFile, aadhaarFileName, actionRequest, employeeDetails, aadhaarCardFolder,serviceContext);
//            employeeBasicDetailsUtil.addEditFileEntry(panFile, panFileName, actionRequest, employeeDetails, panCardFolder,serviceContext);
            long profilePicId = employeeBasicDetailsUtil.addEditFileEntry( file,  fileName, actionRequest, employeeDetails,employeeDetails.getProfilePicId(),"PROFILE", profilePictureFolder, serviceContext);
            employeeBasicDetailsUtil.addEditFileEntry( aadhaarFile, aadhaarFileName, actionRequest, employeeDetails, employeeDetails.getAadhaarCardFileId(),"AADHAAR", aadhaarCardFolder, serviceContext);
            employeeBasicDetailsUtil.addEditFileEntry( panFile, panFileName, actionRequest,  employeeDetails, employeeDetails.getPanCardFileId(), "PAN", panCardFolder, serviceContext);
            lrUser.setPortraitId(profilePicId);
            UserLocalServiceUtil.updatePortrait(lrUser.getUserId(), FileUtil.getBytes(file));

            employeeDetailsLocalService.updateEmployeeDetails(employeeDetails);
            updateEmployeeWithManager(themeDisplay.getCompanyId(), employeeDetails, employeeDetails.getManagerId(),oldManagerId);
            
        }

        
        public void updateEmployeeWithManager(long companyId, EmployeeDetails employeeDetails, long newManagerId, long oldManagerId) {
        	String managerRoleName = "Manager";
        	
        		try {
        			log.info(" Starting Manager Update Logic");
        			log.info("Company ID      : " + companyId);
        			log.info("Employee ID     : " + employeeDetails.getEmployeeId());
        			log.info("Old Manager ID  : " + oldManagerId);
        			log.info("New Manager ID  : " + newManagerId);
        			
        			Role managerRole = RoleLocalServiceUtil.getRole(companyId, managerRoleName);
        			log.info("managerRole -- " + managerRole);
        			
        			long managerRoleId = managerRole.getRoleId();
        			log.info("managerRoleId -- " + managerRoleId);
        			
        			UserLocalServiceUtil.addRoleUsers(managerRoleId, new long[]{employeeDetailsLocalService.getEmployeeDetails(newManagerId).getLrUserId()});
        			log.info("oldManagerId -- " + oldManagerId);
        			if(oldManagerId>0) {
        				List<EmployeeDetails> managerDetailsList = employeeDetailsLocalService.findByManagerId(oldManagerId);
        				log.info("managerDetailsList -- " + managerDetailsList);
        				if(Validator.isNull(managerDetailsList) || managerDetailsList.isEmpty() || managerDetailsList.size() == 0) {
        					log.info("oldManagerId -- " + oldManagerId);
        					EmployeeDetails oldManager = employeeDetailsLocalService.getEmployeeDetails(oldManagerId);
        					log.info("oldManager -- " + oldManager);
        					long oldManagerUserId = oldManager.getLrUserId();
        					log.info("oldManagerUserId -- " + oldManagerUserId);
        					UserLocalServiceUtil.deleteRoleUser(managerRole.getRoleId(), oldManagerUserId);
        				}
        			}
        		} catch(Exception e) {
        			log.error("Unable to fetch manager role -- " + e.getMessage());
        		}
        	
        	
        }
        private String generateFileName(String original) {
            return System.currentTimeMillis() + "_" + original.replaceAll("\\s+", "_");
        }
        
//        public void updateEmployeeWithManager(
//                long companyId,
//                EmployeeDetails employeeDetails,
//                long newManagerId,
//                long oldManagerId) {
//
//            String managerRoleName = "Manager";
//
//            try {
//                System.out.println("==============================================");
//                System.out.println(" Starting Manager Update Logic");
//                System.out.println("Company ID      : " + companyId);
//                System.out.println("Employee ID     : " + employeeDetails.getEmployeeId());
//                System.out.println("Old Manager ID  : " + oldManagerId);
//                System.out.println("New Manager ID  : " + newManagerId);
//                System.out.println("==============================================");
//
//
//
//                Role managerRole = RoleLocalServiceUtil.getRole(companyId, managerRoleName);
//                long managerRoleId = managerRole.getRoleId();
//
//                System.out.println("✔ Manager Role ID fetched: " + managerRoleId);
//
//                // ================================================================
//                //  CHECK NEW MANAGER — GIVE MANAGER ROLE IF NOT ALREADY HAS
//                // ================================================================
//                EmployeeDetails newManagerDetails =
//                        employeeDetailsLocalService.fetchEmployeeDetailsByLrUserId(newManagerId);
//                EmployeeDetails oldManagerDetails =
//                        employeeDetailsLocalService.getEmployeeDetails(oldManagerId);
//                long newManagerUserId = newManagerDetails.getLrUserId();
//                long oldManagerUserId = oldManagerDetails.getLrUserId();
//                boolean newManagerHasRole =
//                        userLocalService.hasRoleUser(managerRoleId, newManagerUserId);
//
//
//                System.out.println("Checking if NEW manager has Manager role → " + newManagerHasRole);
//
//                if (!newManagerHasRole) {
//                    userLocalService.addRoleUsers(managerRoleId, new long[]{newManagerUserId});
//                    System.out.println("➡ Manager role assigned to NEW manager (ID: " + newManagerId + ")");
//                } else {
//                    System.out.println("✔ NEW manager already has Manager role.");
//                }
//
//                // ================================================================
//                //  ASSIGN EMPLOYEE TO NEW MANAGER
//                // ================================================================
//                System.out.println("Updating employee’s managerId to → " + newManagerId);
//                employeeDetails.setManagerId(newManagerId);
//    //            employeeDetailsLocalService.updateEmployeeDetails(employeeDetails);
//
//                System.out.println("✔ Employee updated with new manager successfully.");
//
//                // ================================================================
//                //  CHECK OLD MANAGER — REMOVE MANAGER ROLE IF NO EMPLOYEES LEFT
//                // ================================================================
//                if (oldManagerId > 0 && oldManagerId != newManagerId) {
//
//                    System.out.println("----------------------------------------------");
//                    System.out.println("Checking OLD manager’s remaining subordinates…");
//
//                    List<EmployeeDetails> list =
//                            employeeDetailsLocalService.findByManagerId(oldManagerId);
//
//                    int count = 0;
//                    for (EmployeeDetails e : list) {
//                        if (e.getEmployeeId() != employeeDetails.getEmployeeId()) {
//                            count++;
//                        }
//                    }
//
//                    System.out.println("Old Manager (ID: " + oldManagerId + ") subordinate count → " + count);
//
//                    if (count == 0) {
//
//                        boolean oldManagerHasRole =
//                                userLocalService.hasRoleUser(managerRoleId, oldManagerUserId);
//
//                        System.out.println("Old manager has Manager role? → " + oldManagerHasRole);
//
//                        if (oldManagerHasRole) {
//                            userLocalService.deleteRoleUser(managerRoleId, oldManagerUserId);
//
//                            System.out.println(" Manager role removed from OLD manager (ID: " + oldManagerUserId + ")");
//                        } else {
//                            System.out.println("✔ OLD manager already does NOT have manager role.");
//                        }
//                    } else {
//                        System.out.println("✔ OLD manager still has employees → role not removed.");
//                    }
//                }
//
//                System.out.println("==============================================");
//                System.out.println("🎉 Manager update process completed successfully");
//                System.out.println("==============================================");
//
//            } catch (Exception e) {
//                System.out.println(" ERROR OCCURRED IN updateEmployeeWithManager()");
//                e.printStackTrace();
//            }
//        }


    }