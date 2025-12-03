package com.ax.hrms.employee.onboarding.hr.web.action;

import com.ax.hrms.common.api.api.AxHrmsCommonApi;
import com.ax.hrms.employee.onboarding.employee.web.util.EmployeeOnBoardingUtil;
import com.ax.hrms.employee.onboarding.web.constants.AxHrmsEmployeeOnBoardingEmployeeConstants;
import com.ax.hrms.employee.onboarding.web.constants.AxHrmsEmployeeOnboardingHrWebPortletConstants;
import com.ax.hrms.employee.onboarding.web.constants.AxHrmsEmployeeOnboardingWebPortletKeys;
import com.ax.hrms.mail.template.config.configuration.MailTemplateConfiguration;
import com.ax.hrms.master.model.DepartmentMaster;
import com.ax.hrms.master.model.DesignationMaster;
import com.ax.hrms.master.model.EducationLevelMaster;
import com.ax.hrms.master.service.DepartmentMasterLocalService;
import com.ax.hrms.master.service.DesignationMasterLocalService;
import com.ax.hrms.master.service.EducationLevelMasterLocalService;
import com.ax.hrms.model.EmployeeDepartment;
import com.ax.hrms.model.EmployeeDesignation;
import com.ax.hrms.model.EmployeeDetails;
import com.ax.hrms.model.EmployeeSalary;
import com.ax.hrms.service.AddressLocalService;
import com.ax.hrms.service.EmployeeAddressLocalService;
import com.ax.hrms.service.EmployeeBankAccountLocalService;
import com.ax.hrms.service.EmployeeDepartmentLocalService;
import com.ax.hrms.service.EmployeeDesignationLocalService;
import com.ax.hrms.service.EmployeeDetailsLocalService;
import com.ax.hrms.service.EmployeeEducationLocalService;
import com.ax.hrms.service.EmployeeExperienceLocalService;
import com.ax.hrms.service.EmployeeSalaryLocalService;
import com.ax.hrms.service.EmployeeUanEsicLocalService;
import com.ax.hrms.service.NomineeLocalService;
import com.liferay.document.library.kernel.service.DLAppLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Country;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.service.CountryLocalServiceUtil;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, property = {
        "javax.portlet.name=" + AxHrmsEmployeeOnboardingWebPortletKeys.AX_HRMS_EMPLOYEE_ONBOARDING_HR_WEB,
        "mvc.command.name=/viewEmployeeOnBoarding"}, service = MVCRenderCommand.class)
public class FetchEmployeeOnboardingMVCRenderCommand implements MVCRenderCommand {

    private Log log = LogFactoryUtil.getLog(FetchEmployeeOnboardingMVCRenderCommand.class);

    @Reference
    EducationLevelMasterLocalService educationLevelMasterLocalService;

    @Reference
    EmployeeUanEsicLocalService employeeUanEsicLocalService;

    @Reference
    EmployeeDetailsLocalService employeeDetailsLocalService;

    @Reference
    EmployeeAddressLocalService employeeAddressLocalService;

    @Reference
    AddressLocalService addressLocalService;

    @Reference
    EmployeeBankAccountLocalService employeeBankAccountLocalService;

    @Reference
    NomineeLocalService nomineeLocalService;

    @Reference
    EmployeeEducationLocalService employeeEducationLocalService;

    @Reference
    EmployeeExperienceLocalService employeeExperienceLocalService;

    @Reference
    AxHrmsCommonApi axHrmsCommonApi;

    @Reference
    UserLocalService userLocalService;

    @Reference
    DesignationMasterLocalService designationMasterLocalService;

    @Reference
    EmployeeDesignationLocalService employeeDesignationLocalService;

    @Reference
    DepartmentMasterLocalService departmentMasterLocalService;

    @Reference
    EmployeeDepartmentLocalService employeeDepartmentLocalService;

    @Reference
    MailTemplateConfiguration mailTemplateConfiguration;

    @Reference
    EmployeeSalaryLocalService employeeSalaryLocalService;

    @Override
    public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {

        EmployeeOnBoardingUtil employeeOnBoardingUtil = new EmployeeOnBoardingUtil(employeeDetailsLocalService, axHrmsCommonApi, employeeAddressLocalService, employeeBankAccountLocalService, addressLocalService, nomineeLocalService,mailTemplateConfiguration);

        Long employeeId = ParamUtil.getLong(renderRequest, AxHrmsEmployeeOnBoardingEmployeeConstants.EMPLOYEE_ID);

        renderRequest.setAttribute(AxHrmsEmployeeOnBoardingEmployeeConstants.EMPLOYEE_ID, employeeId);

        ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
        EmployeeDetails employeeDetails;
        try {
            List<DesignationMaster> designationMastersList = designationMasterLocalService.getDesignationMasters(-1, -1); //Fetch all Designation List

            List<DepartmentMaster> departmentMastersList = departmentMasterLocalService.getDepartmentMasters(-1, -1);  //Fetch All Department List

            EmployeeDesignation employeeDesignation = employeeDesignationLocalService.findByEmployeeId(employeeId); //fetch employeeDesignation by EmployeeId

            EmployeeDepartment employeeDepartment = employeeDepartmentLocalService.findByEmployeeId(employeeId); //fetch employeeDepartment by employeeId

            List<DepartmentMaster> employeeDepratmentList = axHrmsCommonApi.getDepartmentMastersFromEmployeeId(employeeId); //fetch employeeDepartmentList by Id and status is true

            List<EmployeeDepartment> employeeDepartments = employeeDepartmentLocalService.getEmployeeDepartments(-1, -1); // fetch All employeeDepartments

            EmployeeSalary employeeSalary = employeeSalaryLocalService.findByEmployeeIdAndStatus(employeeId, true);

            renderRequest.setAttribute(AxHrmsEmployeeOnboardingHrWebPortletConstants.DESIGNATION_MASTER_LIST, designationMastersList);
            renderRequest.setAttribute(AxHrmsEmployeeOnboardingHrWebPortletConstants.DEPARTMENT_MASTER_LIST, departmentMastersList);
            renderRequest.setAttribute(AxHrmsEmployeeOnboardingHrWebPortletConstants.EMPLOYEE_DESIGNATION, employeeDesignation);
            renderRequest.setAttribute(AxHrmsEmployeeOnboardingHrWebPortletConstants.EMPOYEE_DEPARTMENT, employeeDepartment);
            renderRequest.setAttribute(AxHrmsEmployeeOnboardingHrWebPortletConstants.EMPLOYEE_DEPARTMENTLIST, employeeDepratmentList);
            renderRequest.setAttribute(AxHrmsEmployeeOnboardingHrWebPortletConstants.EMPLOYEE_SALARY, employeeSalary);

            List<Long> departmentIds = new ArrayList<>();

            for (EmployeeDepartment tempEmployeeDepartment : employeeDepartments) {
                if (tempEmployeeDepartment.getEmployeeId() == employeeId && tempEmployeeDepartment.getStatus()) {
                    departmentIds.add(tempEmployeeDepartment.getDepartmentMasterId());
                }
            }
            renderRequest.setAttribute(AxHrmsEmployeeOnboardingHrWebPortletConstants.DEPARTMENT_IDS, departmentIds);

            employeeDetails = employeeDetailsLocalService.getEmployeeDetails(employeeId);
            try {
                FileEntry profilePicPathName = DLAppLocalServiceUtil.getFileEntry(employeeDetails.getProfilePicId());
                if (profilePicPathName.getFileName() != null) {
                    renderRequest.setAttribute(AxHrmsEmployeeOnboardingHrWebPortletConstants.PROFILE_PIC_NAME, profilePicPathName.getFileName());
                }
            } catch (Exception e) {
                log.error("ERROR gettig Profile PIC.");
            }

            long hrRoleId = RoleLocalServiceUtil.getRole(themeDisplay.getCompanyId(), AxHrmsEmployeeOnboardingHrWebPortletConstants.HR_ADMIN).getRoleId();
            long[] hrRoles = themeDisplay.getUser().getRoleIds();
            boolean isHr = Arrays.stream(hrRoles).anyMatch(id -> id == hrRoleId);

            if (isHr) {
                renderRequest.setAttribute(AxHrmsEmployeeOnboardingHrWebPortletConstants.IS_HR_STATUS, isHr);
            }
            User user = userLocalService.getUser(employeeDetails.getLrUserId());
            renderRequest.setAttribute(AxHrmsEmployeeOnboardingHrWebPortletConstants.EMPLOYEE_USER, user);
            renderRequest.setAttribute(AxHrmsEmployeeOnboardingHrWebPortletConstants.EMPLOYEE_DETAIL, employeeDetails);
        } catch (PortalException e) {
            log.error("Error In EmployeeBasic Details" + e.getMessage());
        }

        employeeOnBoardingUtil.setEducationList(renderRequest, employeeId, employeeEducationLocalService);

        employeeOnBoardingUtil.setExperience(renderRequest, employeeId, employeeExperienceLocalService);

        employeeOnBoardingUtil.setUanEsic(renderRequest, employeeId, employeeUanEsicLocalService);

        employeeOnBoardingUtil.setNominee(renderRequest, employeeId);

        employeeOnBoardingUtil.setAddress(renderRequest, employeeId);

        employeeOnBoardingUtil.setBankAccount(renderRequest, employeeId);

        List<Country> countryList = CountryLocalServiceUtil.getCountries(-1, -1);
        List<EducationLevelMaster> educationLevelMastersList = educationLevelMasterLocalService.getEducationLevelMasters(-1, -1);

        renderRequest.setAttribute(AxHrmsEmployeeOnBoardingEmployeeConstants.COUNTRY_LIST, countryList);
        renderRequest.setAttribute(AxHrmsEmployeeOnBoardingEmployeeConstants.EDUCATION_LEVEL_MASTERS_LIST, educationLevelMastersList);

        return AxHrmsEmployeeOnBoardingEmployeeConstants.ADD_EMPLOYEE_ONBOARDING_JSP;
    }
}
