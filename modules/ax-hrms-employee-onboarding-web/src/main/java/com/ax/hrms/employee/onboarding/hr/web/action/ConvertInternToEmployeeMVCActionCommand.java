package com.ax.hrms.employee.onboarding.hr.web.action;


import com.ax.hrms.common.api.api.AxHrmsCommonApi;
import com.ax.hrms.employee.onboarding.web.constants.AxHrmsEmployeeOnboardingHrWebPortletConstants;
import com.ax.hrms.employee.onboarding.web.constants.AxHrmsEmployeeOnboardingWebPortletKeys;
import com.ax.hrms.master.exception.NoSuchLeavePolicyMasterException;
import com.ax.hrms.master.model.LeavePolicyMaster;
import com.ax.hrms.master.model.LeaveTypeMaster;
import com.ax.hrms.master.service.*;
import com.ax.hrms.model.*;
import com.ax.hrms.probation.config.configuration.action.AxHrmsProbationConfigurationAction;
import com.ax.hrms.service.*;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.RoleLocalService;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import java.text.SimpleDateFormat;
import java.util.*;


/**
 * Author: Nivid Koradiya
 */
@Component(
        property = {
                "javax.portlet.name=" + AxHrmsEmployeeOnboardingWebPortletKeys.AX_HRMS_EMPLOYEE_ONBOARDING_HR_WEB,
                "mvc.command.name=/convertInternToEmployee"
        },
        service = MVCActionCommand.class
)
public class ConvertInternToEmployeeMVCActionCommand extends BaseMVCActionCommand {

    Log log = LogFactoryUtil.getLog(ListEmployeesMVCRenderCommand.class);

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


    @Override
    protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {

        //getting data from the action request
        long employeeId = ParamUtil.getLong(actionRequest, AxHrmsEmployeeOnboardingHrWebPortletConstants.EMPLOYEE_ID);
        String isProbationEnabled = ParamUtil.getString(actionRequest, AxHrmsEmployeeOnboardingHrWebPortletConstants.IS_PROBBATION_ENABLED);
        String insuranceLink = ParamUtil.getString(actionRequest, AxHrmsEmployeeOnboardingHrWebPortletConstants.INSURANCE_LINK);
        String joiningDate = ParamUtil.getString(actionRequest, AxHrmsEmployeeOnboardingHrWebPortletConstants.JOINING_DATE);
        String designation = ParamUtil.getString(actionRequest, AxHrmsEmployeeOnboardingHrWebPortletConstants.DESIGNATION);
        double grossSalaryCTCPM = ParamUtil.getDouble(actionRequest, AxHrmsEmployeeOnboardingHrWebPortletConstants.GROSS_SALARY_CTC_PM);
        double grossSalaryCTCPA = ParamUtil.getDouble(actionRequest, AxHrmsEmployeeOnboardingHrWebPortletConstants.GROSS_SALARY_CTC_PA);

        ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
        EmployeeDetails employeeDetails = employeeDetailsLocalService.getEmployeeDetails(employeeId);

        //adding new salary object to the ddb
        EmployeeSalary employeeSalary = employeeSalaryLocalService.createEmployeeSalary(CounterLocalServiceUtil.increment(EmployeeSalary.class.getName()));
        employeeSalary.setEmployeeId(employeeDetails.getEmployeeId());
        employeeSalary.setGrossSalaryCtcPa(grossSalaryCTCPA);
        employeeSalary.setGrossSalaryCtcPm(grossSalaryCTCPM);
        employeeSalary.setStatus(true);
        employeeSalaryLocalService.addEmployeeSalary(employeeSalary);

        employeeDetails.setInsuranceLink(insuranceLink);

        //setting the joining date
        SimpleDateFormat formatter = new SimpleDateFormat(AxHrmsEmployeeOnboardingHrWebPortletConstants.DATE_FORMAT, Locale.ENGLISH);
        Date joiningDateParsed = formatter.parse(joiningDate);
        employeeDetails.setJoiningDate(joiningDateParsed);
        employeeDetails.setEmployeeType("permanent");
        // Probation data handling and adding the details
        if (isProbationEnabled.equals(AxHrmsEmployeeOnboardingHrWebPortletConstants.ENABLED)) {
            addProbationPeriodDetailsToNewEmployee(employeeDetails, themeDisplay);
            employeeDetails.setIsProbationEnabled(true);
            employeeDetailsLocalService.updateEmployeeDetails(employeeDetails);
        } else {
            employeeDetails.setProbationStatusId(probationStatusMasterLocalService.findByProbationStatusName(AxHrmsEmployeeOnboardingHrWebPortletConstants.COMPLETED).getProbationStatusMasterId());
            employeeDetailsLocalService.updateEmployeeDetails(employeeDetails);
        }

        //deleting the old intern designation
        employeeDesignationLocalService.deleteEmployeeDesignation(employeeDesignationLocalService.findByEmployeeId(employeeId));

        long oldDesignationRoleId = roleLocalService.getRole(themeDisplay.getCompanyId(), "Intern").getRoleId();
        roleLocalService.deleteUserRole(employeeDetails.getLrUserId(), oldDesignationRoleId);

        // Get the role ID for the current designation
        try {
            Role role = roleLocalService.getRole(themeDisplay.getCompanyId(), designation);
            User user = userLocalService.getUser(employeeDetails.getLrUserId());
            long[] roleIds = new long[1];
            roleIds[0] = role.getRoleId();
            RoleLocalServiceUtil.addUserRoles(user.getUserId(), roleIds);
//            RoleLocalServiceUtil.addUserRoles();
        } catch (Exception e) {
            log.error(e);
        }


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

        // adding the leave balance to the employee :
        addLeaveBalanceForNewEmployee(employeeDetails, themeDisplay);

        // sending the mail for insurance and onboarding completion
        sendConversionAndOnBoardingMailToIntern(employeeDetails, themeDisplay);


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

    private void addProbationPeriodDetailsToNewEmployee(EmployeeDetails employeeDetails, ThemeDisplay themeDisplay) {

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

    private void sendConversionAndOnBoardingMailToIntern(EmployeeDetails employeeDetails, ThemeDisplay themeDisplay) {
        String body = "<!DOCTYPE html>\n" +
                "<html>\n" +
                "<body style=\"font-family: Arial, sans-serif; color: #333; background-color: #f4f4f4; padding: 20px;\">\n" +
                "\n" +
                "<div style=\"max-width: 600px; margin: 0 auto; background-color: #fff; padding: 20px; border-radius: 10px; box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);\">\n" +
                "\n" +
                "  <h2 style=\"text-align: center; color: #007bff;\">Welcome to Full-Time Employment!</h2>\n" +
                "\n" +
                "  <p style=\"font-size: 16px;\">Dear <strong>" + employeeDetails.getFirstName() + " " + employeeDetails.getLastName() + " </strong>,</p>\n" +
                "\n" +
                "  <p style=\"font-size: 16px;\">We are excited to inform you that your status has been converted from Intern to Employee. To complete your profile, please fill in the following required information:</p>\n" +
                "\n" +
                "  <ul style=\"list-style-type: disc; padding-left: 20px; font-size: 16px;\">\n" +
                "    <li>Education Details</li>\n" +
                "    <li>UAN and ESIC Details</li>\n" +
                "    <li>Experience Details</li>\n" +
                "  </ul>\n" +
                "\n" +
                "  <p style=\"font-size: 16px;\">Additionally, please apply for insurance using the provided link: <a href=\"" + employeeDetails.getInsuranceLink() + "\" style=\"color: #007bff; text-decoration: none; font-weight: bold;\">Apply for Insurance</a></p>\n" +
                "\n" +
                "  <p style=\"font-size: 16px; text-align: center; background-color: #e9f7ef; padding: 10px; border-radius: 5px; margin: 20px 0;\">Complete the onboarding form using the following link: <a href=\"" + themeDisplay.getURLPortal() + "/group/hrms/employee-onboarding/" + "\" style=\"color: #28a745; text-decoration: none; font-weight: bold;\">Onboarding Form</a></p>\n" +
                "\n" +
                "  <p style=\"font-size: 16px;\">Thank you for your cooperation.</p>\n" +
                "\n" +
                "  <p style=\"font-size: 16px;\">Best regards,<br/><strong>Aixtor Technologies</strong></p>\n" +
                "\n" +
                "</div>\n" +
                "\n" +
                "</body>\n" +
                "</html>\n";
        axHrmsCommonApi.sendMail(employeeDetails.getOfficialEmail(), AxHrmsEmployeeOnboardingHrWebPortletConstants.SENDER_MAIL_ADDRESS, AxHrmsEmployeeOnboardingHrWebPortletConstants.SENDER_NAME, AxHrmsEmployeeOnboardingHrWebPortletConstants.INTERN_CONVERSION_SUBJECT, body);

    }
}



