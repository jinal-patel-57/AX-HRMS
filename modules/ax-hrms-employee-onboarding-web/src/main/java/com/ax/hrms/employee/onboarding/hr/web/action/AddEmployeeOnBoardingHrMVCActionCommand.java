package com.ax.hrms.employee.onboarding.hr.web.action;


import com.ax.hrms.common.api.api.AxHrmsCommonApi;
import com.ax.hrms.employee.onboarding.web.constants.AxHrmsEmployeeOnboardingHrWebPortletConstants;
import com.ax.hrms.employee.onboarding.web.constants.AxHrmsEmployeeOnboardingWebPortletKeys;
import com.ax.hrms.link.config.configuration.LinksConfiguration;
import com.ax.hrms.mail.template.config.configuration.MailTemplateConfiguration;
import com.ax.hrms.master.exception.NoSuchLeavePolicyMasterException;
import com.ax.hrms.master.model.LeavePolicyMaster;
import com.ax.hrms.master.model.LeaveTypeMaster;
import com.ax.hrms.master.service.*;
import com.ax.hrms.model.*;
import com.ax.hrms.probation.config.configuration.action.AxHrmsProbationConfigurationAction;
import com.ax.hrms.service.*;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.role.RoleConstants;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.*;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.Localization;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.roles.admin.role.type.contributor.RoleTypeContributor;
import com.liferay.roles.admin.role.type.contributor.provider.RoleTypeContributorProvider;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.swing.*;
import java.text.SimpleDateFormat;
import java.util.*;


/**
 * Author: Nivid Koradiya
 */
@Component(
        property = {
                "javax.portlet.name=" + AxHrmsEmployeeOnboardingWebPortletKeys.AX_HRMS_EMPLOYEE_ONBOARDING_HR_WEB,
                "mvc.command.name=/addEmployeeOnboardingHr"
        },
        service = MVCActionCommand.class
)
public class AddEmployeeOnBoardingHrMVCActionCommand extends BaseMVCActionCommand {

    Log log = LogFactoryUtil.getLog(ListEmployeesMVCRenderCommand.class);

    @Reference
    MailTemplateConfiguration mailTemplateConfiguration;

    @Reference
    LinksConfiguration linksConfiguration;

    @Reference
    UserLocalService userLocalService;

    @Reference
    AxHrmsCommonApi axHrmsCommonApi;

    @Reference
    RoleLocalService roleLocalService;

    @Reference
    EmployeeDetailsLocalService employeeDetailsLocalService;

    @Reference
    EmployeeSalaryLocalService employeeSalaryLocalService;

    @Reference
    LeaveTypeMasterLocalService leaveTypeMasterLocalService;

    @Reference
    LeavePolicyMasterLocalService leavePolicyMasterLocalService;

    @Reference
    LeaveBalanceLocalService leaveBalanceLocalService;

    @Reference
    EmployeeProbationDetailsLocalService employeeProbationDetailsLocalService;

    @Reference
    ProbationStatusMasterLocalService probationStatusMasterLocalService;

    @Reference
    DepartmentMasterLocalService departmentMasterLocalService;

    @Reference
    DesignationMasterLocalService designationMasterLocalService;

    @Reference
    EmployeeDepartmentLocalService employeeDepartmentLocalService;

    @Reference
    EmployeeDesignationLocalService employeeDesignationLocalService;

    @Reference
    private Localization localization;


    @Reference
    private RoleService roleService;

    @Reference
    private RoleTypeContributorProvider roleTypeContributorProvider;

    @Override
    protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {

        ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);

//        checkRolePrerequisite(themeDisplay,actionRequest);
        //getting data from the action request
        String employeeCode = ParamUtil.getString(actionRequest, AxHrmsEmployeeOnboardingHrWebPortletConstants.EMPLOYEE_CODE);
        String firstName = ParamUtil.getString(actionRequest, AxHrmsEmployeeOnboardingHrWebPortletConstants.FIRST_NAME);
        String lastName = ParamUtil.getString(actionRequest, AxHrmsEmployeeOnboardingHrWebPortletConstants.LAST_NAME);
        String middleName = ParamUtil.getString(actionRequest, AxHrmsEmployeeOnboardingHrWebPortletConstants.MIDDLE_NAME);
        String officialEmailId = ParamUtil.getString(actionRequest, AxHrmsEmployeeOnboardingHrWebPortletConstants.OFFICIAL_EMAIL_ID);
        String isProbationEnabled = ParamUtil.getString(actionRequest, AxHrmsEmployeeOnboardingHrWebPortletConstants.IS_PROBBATION_ENABLED);
        String insuranceLink = ParamUtil.getString(actionRequest, AxHrmsEmployeeOnboardingHrWebPortletConstants.INSURANCE_LINK);
        String joiningDate = ParamUtil.getString(actionRequest, AxHrmsEmployeeOnboardingHrWebPortletConstants.JOINING_DATE);
        String gender = ParamUtil.getString(actionRequest, AxHrmsEmployeeOnboardingHrWebPortletConstants.GENDER);
        String[] designations = ParamUtil.getStringValues(actionRequest, AxHrmsEmployeeOnboardingHrWebPortletConstants.DESIGNATION);
        String[] departments = ParamUtil.getStringValues(actionRequest, AxHrmsEmployeeOnboardingHrWebPortletConstants.DEPARTMENT);
        String isExperienced = ParamUtil.getString(actionRequest, AxHrmsEmployeeOnboardingHrWebPortletConstants.IS_EXPERIENCED);
        double grossSalaryCTCPM = ParamUtil.getDouble(actionRequest, AxHrmsEmployeeOnboardingHrWebPortletConstants.GROSS_SALARY_CTC_PM);
        double grossSalaryCTCPA = ParamUtil.getDouble(actionRequest, AxHrmsEmployeeOnboardingHrWebPortletConstants.GROSS_SALARY_CTC_PA);
        String typeOfEmployee = ParamUtil.getString(actionRequest, "typeOfEmployee");
        double stipend = ParamUtil.getDouble(actionRequest, "stipend");


        EmployeeDetails employeeDetails = employeeDetailsLocalService.createEmployeeDetails(CounterLocalServiceUtil.increment(EmployeeDetails.class.getName()));
        // converting role names into role IDS
        List<Long> roleIds = new ArrayList<>();
        long employeeRoleId = RoleLocalServiceUtil.getRole(themeDisplay.getCompanyId(), "Employee").getRoleId(); // finds the role EMPLOYEE and assigns it to every employee onboarded on the portal
        roleIds.add(employeeRoleId);
        log.info(employeeRoleId + " role");
        for (String designation : designations) {
            // Get the role ID for the current designation
            long designationRoleId = RoleLocalServiceUtil.getRole(themeDisplay.getCompanyId(), designation).getRoleId();
            EmployeeDesignation employeeDesignation = employeeDesignationLocalService.createEmployeeDesignation(CounterLocalServiceUtil.increment(EmployeeDesignation.class.getName()));
            employeeDesignation.setCompanyId(themeDisplay.getCompanyId());
            employeeDesignation.setCreatedBy(themeDisplay.getUserId());
            employeeDesignation.setGroupId(themeDisplay.getCompanyGroupId());
            employeeDesignation.setCreateDate(new Date());
            employeeDesignation.setModifiedDate(new Date());

            employeeDesignation.setDesignationMasterId(designationMasterLocalService.findByDesignationName(designation).getDesignationMasterId());
            employeeDesignation.setStatus(true);
            employeeDesignation.setStartDate(new Date());
            employeeDesignation.setEmployeeId(employeeDetails.getEmployeeId());

            employeeDesignationLocalService.addEmployeeDesignation(employeeDesignation);
            // Add the role ID to the array
            roleIds.add(designationRoleId);
        }

        for (String department : departments) {
            // Get the role ID for the current department
            long departmentRoleId = RoleLocalServiceUtil.getRole(themeDisplay.getCompanyId(), department).getRoleId();


            EmployeeDepartment employeeDepartment = employeeDepartmentLocalService.createEmployeeDepartment(CounterLocalServiceUtil.increment(EmployeeDepartment.class.getName()));
            employeeDepartment.setCompanyId(themeDisplay.getCompanyId());
            employeeDepartment.setCreatedBy(themeDisplay.getUserId());
            employeeDepartment.setGroupId(themeDisplay.getCompanyGroupId());
            employeeDepartment.setCreateDate(new Date());
            employeeDepartment.setModifiedDate(new Date());

            employeeDepartment.setDepartmentMasterId(departmentMasterLocalService.findByDepartmentName(department).getDepartmentMasterId());
            employeeDepartment.setStatus(true);
            employeeDepartment.setDateOfChange(new Date());
            employeeDepartment.setEmployeeId(employeeDetails.getEmployeeId());

            employeeDepartmentLocalService.addEmployeeDepartment(employeeDepartment);


            // Add the role ID to the array
            roleIds.add(departmentRoleId);
        }

        long[] roles = roleIds.stream().mapToLong(Long::longValue).toArray();

        //creating new user in the database of Liferay and sending the message also.
        Map<User, String> userPassMap = axHrmsCommonApi.createNewEmployeeUser(firstName, middleName, lastName, officialEmailId, themeDisplay, roles);

        User user = null;
        String password = AxHrmsEmployeeOnboardingHrWebPortletConstants.BALNK_STRING;
        log.info("before for loop -- " + userPassMap);
        for (Map.Entry<User, String> entry : userPassMap.entrySet()) {
        	log.info("inside for loop -- " + entry.getKey() + "----" + entry.getValue());
            user = entry.getKey();
            password = entry.getValue();
        }
        assert user != null;
        long userId = user.getUserId();

        SimpleDateFormat formatter = new SimpleDateFormat(AxHrmsEmployeeOnboardingHrWebPortletConstants.DATE_FORMAT, Locale.ENGLISH);
        Date joiningDateParsed = formatter.parse(joiningDate);

        //converting iExperienced from string to bool
        boolean isExperiencedBool;
        isExperiencedBool = isExperienced.equals(AxHrmsEmployeeOnboardingHrWebPortletConstants.YES);

        //Audit fields
        employeeDetails.setCompanyId(themeDisplay.getCompanyId());
        employeeDetails.setCreatedBy(themeDisplay.getUserId());
        employeeDetails.setGroupId(themeDisplay.getCompanyGroupId());
        employeeDetails.setCreateDate(new Date());
        employeeDetails.setModifiedDate(new Date());
        employeeDetails.setLrUserId(userId);
        employeeDetails.setJoiningDate(joiningDateParsed);
        employeeDetails.setEmployeeCode(employeeCode);
        employeeDetails.setCompanyId(themeDisplay.getCompanyId());
        employeeDetails.setFirstName(firstName);
        employeeDetails.setLastName(lastName);
        employeeDetails.setOfficialEmail(officialEmailId);
        employeeDetails.setGender(gender);
        employeeDetails.setIsTerminated(false);
        employeeDetails.setIsEmployeeOnboarded(false);
        employeeDetails.setCreatedBy(themeDisplay.getUserId());
        employeeDetails.setGroupId(themeDisplay.getCompanyGroupId());
        employeeDetails.setProbationStatusId(0);
        if (typeOfEmployee.equals(AxHrmsEmployeeOnboardingHrWebPortletConstants.INTERN)) {
            employeeDetails.setStipend(stipend);
        }

        employeeDetailsLocalService.addEmployeeDetails(employeeDetails);


        if (!typeOfEmployee.equals(AxHrmsEmployeeOnboardingHrWebPortletConstants.INTERN)) {
            //adding new salary object to the ddb
            EmployeeSalary employeeSalary = employeeSalaryLocalService.createEmployeeSalary(CounterLocalServiceUtil.increment(EmployeeSalary.class.getName()));
            employeeSalary.setEmployeeId(employeeDetails.getEmployeeId());
            employeeSalary.setGrossSalaryCtcPa(grossSalaryCTCPA);
            employeeSalary.setGrossSalaryCtcPm(grossSalaryCTCPM);
            employeeSalary.setStatus(true);
            employeeSalaryLocalService.addEmployeeSalary(employeeSalary);
        }


        boolean contractor = typeOfEmployee.equals(AxHrmsEmployeeOnboardingHrWebPortletConstants.INTERN) || typeOfEmployee.equals("contractor");
        if (contractor) {
            employeeDetails.setIsExperienced(false);
            employeeDetails.setIsProbationEnabled(false);
        } else {
            employeeDetails.setIsExperienced(isExperiencedBool);
            employeeDetails.setInsuranceLink(insuranceLink);
            addLeaveBalanceForNewEmployee(employeeDetails, themeDisplay);
        }
        employeeDetails.setEmployeeType(typeOfEmployee);

        //adding probation status
        if (isProbationEnabled.equals(AxHrmsEmployeeOnboardingHrWebPortletConstants.ENABLED)) {
            adddProationPeriodDetailsToNewEmployee(employeeDetails, themeDisplay);
            employeeDetails.setIsProbationEnabled(true);
            employeeDetailsLocalService.updateEmployeeDetails(employeeDetails);
        } else {
            employeeDetails.setProbationStatusId(probationStatusMasterLocalService.findByProbationStatusName(AxHrmsEmployeeOnboardingHrWebPortletConstants.COMPLETED).getProbationStatusMasterId());
            employeeDetailsLocalService.updateEmployeeDetails(employeeDetails);

        }

        if (contractor) {
            sendCredentialMailToInternAndContractor(employeeDetails, password, themeDisplay);
        } else {
            sendCredentialMailToEmployee(employeeDetails, password, themeDisplay);
        }
        //Send OnBoarding Mail :
    }


    private void addLeaveBalanceForNewEmployee(EmployeeDetails employeeDetails, ThemeDisplay themeDisplay) {
        List<LeaveTypeMaster> leaveTypeMasterList = leaveTypeMasterLocalService.findByActiveAndAppearForAll(true, true);
        for (LeaveTypeMaster ltm : leaveTypeMasterList) {
            try {
                //getting year
                Date date = new Date();
                Calendar calendar = new GregorianCalendar();
                calendar.setTime(date);
                int year = calendar.get(Calendar.YEAR);
                //year-end

                LeavePolicyMaster lpm = leavePolicyMasterLocalService.findByLeaveTypeMasterIdAndYearOfPolicyAndEligibleAfterMonths(ltm.getLeaveTypeMasterId(), year, AxHrmsEmployeeOnboardingHrWebPortletConstants.ZERO);
                LeaveBalance lb = leaveBalanceLocalService.createLeaveBalance(CounterLocalServiceUtil.increment(LeaveBalance.class.getName()));
                lb.setCompanyId(themeDisplay.getCompanyId());
                lb.setCreatedBy(themeDisplay.getUserId());
                lb.setGroupId(themeDisplay.getCompanyGroupId());
                lb.setCreateDate(new Date());
                lb.setModifiedDate(new Date());

                lb.setEmployeeId(employeeDetails.getEmployeeId());
                lb.setEmployeeId(employeeDetails.getEmployeeId());
                lb.setLeaveTypeMasterId(ltm.getLeaveTypeMasterId());
                lb.setYear(year);
                lb.setNoOfUsedLeaves(0);

                if (lpm.getIsApplicableFloater()) {
                    lb.setNoOfRemainingLeaves(Math.round(lpm.getAccrualRate() * 12));
                } else {
                    int leftMonthsOfCurrentYear = 12 - (calendar.get(Calendar.MONTH) + 1);
                    lb.setNoOfRemainingLeaves(Math.round(lpm.getAccrualRate() * leftMonthsOfCurrentYear));
                }
                leaveBalanceLocalService.addLeaveBalance(lb);
            } catch (NoSuchLeavePolicyMasterException e) {
                log.error("Error while getting leave policy");
            }
        }
    }

    private void adddProationPeriodDetailsToNewEmployee(EmployeeDetails employeeDetails, ThemeDisplay themeDisplay) {

        //Probation Details for new Employee
        int probationPeriod = Integer.parseInt(AxHrmsProbationConfigurationAction.probationPeriod());

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(employeeDetails.getJoiningDate());
        calendar.add(Calendar.MONTH, probationPeriod);

        EmployeeProbationDetails employeeProbationDetails = employeeProbationDetailsLocalService.createEmployeeProbationDetails(CounterLocalServiceUtil.increment(EmployeeProbationDetails.class.getName()));

        employeeProbationDetails.setCompanyId(themeDisplay.getCompanyId());
        employeeProbationDetails.setCreatedBy(themeDisplay.getUserId());
        employeeProbationDetails.setGroupId(themeDisplay.getCompanyGroupId());
        employeeProbationDetails.setCreateDate(new Date());
        employeeProbationDetails.setModifiedDate(new Date());

        employeeProbationDetails.setEmployeeId(employeeDetails.getEmployeeId());
        employeeProbationDetails.setProbationPeriod(probationPeriod);
        employeeProbationDetails.setProbationEndDate(calendar.getTime());
        employeeProbationDetails.setIsExtended(false);

        long probationStatusMasterId = 0L;
        try {
            probationStatusMasterId = probationStatusMasterLocalService.findByProbationStatusName(AxHrmsEmployeeOnboardingHrWebPortletConstants.IN_PROBATION).getProbationStatusMasterId();
        } catch (Exception e) {
            log.info("Error fetching probation status master ID");
        }
        employeeDetails.setProbationStatusId(probationStatusMasterId);
        employeeDetailsLocalService.updateEmployeeDetails(employeeDetails);
        employeeProbationDetails.setProbationStatusId(probationStatusMasterId);
        employeeProbationDetailsLocalService.addEmployeeProbationDetails(employeeProbationDetails);
    }

    private void sendCredentialMailToEmployee(EmployeeDetails employeeDetails, String password, ThemeDisplay themeDisplay) {
        String subject = mailTemplateConfiguration.mailOnBoardingPermanentAndTemporaryEmployeesSubject();
        String body = mailTemplateConfiguration.mailOnBoardingPermanentAndTemporaryEmployeesBody();

        body = body.replace("${EMPLOYEE_MAIL}", employeeDetails.getOfficialEmail());
        body = body.replace("${EMPLOYEE_NAME}", employeeDetails.getFirstName() + " " + employeeDetails.getLastName());
        body = body.replace("${EMPLOYEE_PASSWORD}", password);
        body = body.replace("${LOGIN_LINK}", themeDisplay.getURLPortal() + linksConfiguration.loginLink());
        body = body.replace("${ONBOARDING_LINK}", themeDisplay.getURLPortal() + linksConfiguration.employeeOnBoardingLink());
        body = body.replace("${INSURANCE_LINK}", employeeDetails.getInsuranceLink());

        axHrmsCommonApi.sendMail(employeeDetails.getOfficialEmail(), AxHrmsEmployeeOnboardingHrWebPortletConstants.SENDER_MAIL_ADDRESS, AxHrmsEmployeeOnboardingHrWebPortletConstants.SENDER_NAME, subject, body);

    }

    private void sendCredentialMailToInternAndContractor(EmployeeDetails employeeDetails, String password, ThemeDisplay themeDisplay) {
        String subject = mailTemplateConfiguration.mailOnBoardingInternAndContractorEmployeesSubject();
        String body = mailTemplateConfiguration.mailOnBoardingInternAndContractorEmployeesBody();

        body = body.replace("${EMPLOYEE_NAME}", employeeDetails.getFirstName() + " " + employeeDetails.getLastName());
        body = body.replace("${EMPLOYEE_MAIL}", employeeDetails.getOfficialEmail());
        body = body.replace("${EMPLOYEE_PASSWORD}", password);
        body = body.replace("${LOGIN_LINK}", themeDisplay.getURLPortal() + linksConfiguration.loginLink());
        body = body.replace("${ONBOARDING_LINK}", themeDisplay.getURLPortal() + linksConfiguration.employeeOnBoardingLink());

        axHrmsCommonApi.sendMail(employeeDetails.getOfficialEmail(), AxHrmsEmployeeOnboardingHrWebPortletConstants.SENDER_MAIL_ADDRESS, AxHrmsEmployeeOnboardingHrWebPortletConstants.SENDER_NAME, subject, body);

    }

    private void checkRolePrerequisite(ThemeDisplay themeDisplay, ActionRequest actionRequest) throws PortalException {
        List<String> roleNameList = new ArrayList<>();
        roleNameList.add("Employee");
        roleNameList.add("Contractor");

        for (String roleName : roleNameList) {


            Map<Locale, String> titleMap = localization.getLocalizationMap(actionRequest, roleName);
            Map<Locale, String> descriptionMap = localization.getLocalizationMap(actionRequest, "description");

            ServiceContext serviceContext = ServiceContextFactory.getInstance(Role.class.getName(), actionRequest);

            int type = 1;
            RoleTypeContributor roleTypeContributor = roleTypeContributorProvider.getRoleTypeContributor(type);
            try {
                roleService.getRole(themeDisplay.getCompanyId(), roleName);
            } catch (PortalException exception) {
                roleService.addRole("", roleTypeContributor.getClassName(), 0, roleName, titleMap, descriptionMap, type, null, serviceContext);
            } catch (Exception e) {
                log.error("AddEditDesignationMasterMVCActionCommand >>> addRole ::: Exception is: " + e.getMessage());
            }
        }
    }

}



