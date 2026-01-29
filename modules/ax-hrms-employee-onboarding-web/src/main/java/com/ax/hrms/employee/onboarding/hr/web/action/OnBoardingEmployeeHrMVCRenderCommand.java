package com.ax.hrms.employee.onboarding.hr.web.action;

import com.ax.hrms.employee.onboarding.web.constants.AxHrmsEmployeeOnboardingHrWebPortletConstants;
import com.ax.hrms.employee.onboarding.web.constants.AxHrmsEmployeeOnboardingWebPortletKeys;
import com.ax.hrms.master.model.BranchMaster;
import com.ax.hrms.master.model.DepartmentMaster;
import com.ax.hrms.master.model.DesignationMaster;
import com.ax.hrms.master.service.BranchMasterLocalService;
import com.ax.hrms.master.service.DepartmentMasterLocalService;
import com.ax.hrms.master.service.DesignationMasterLocalService;
import com.ax.hrms.model.EmployeeAddress;
import com.ax.hrms.model.EmployeeDetails;
import com.ax.hrms.module.config.configuration.ModuleConfiguration;
import com.ax.hrms.service.EmployeeAddressLocalService;
import com.ax.hrms.service.EmployeeDetailsLocalService;
import com.liferay.document.library.kernel.service.DLAppLocalServiceUtil;
import com.liferay.document.library.kernel.util.DLUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;
import com.ax.hrms.service.EmployeeDetailsLocalService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.service.RoleLocalService;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component(
        immediate = true,
        property = {
                "javax.portlet.name=" + AxHrmsEmployeeOnboardingWebPortletKeys.AX_HRMS_EMPLOYEE_ONBOARDING_HR_WEB,
                "mvc.command.name=/onboardingFormHr"
        },
        service = MVCRenderCommand.class
)
public class OnBoardingEmployeeHrMVCRenderCommand implements MVCRenderCommand {

    private static final Log log = LogFactoryUtil.getLog(OnBoardingEmployeeHrMVCRenderCommand.class);

    @Reference
    DepartmentMasterLocalService departmentMasterLocalService;

    @Reference
    DesignationMasterLocalService designationMasterLocalService;

    @Reference
    ModuleConfiguration moduleConfiguration;

    @Reference
    EmployeeDetailsLocalService employeeDetailsLocalService;

    @Reference
    private RoleLocalService roleLocalService;

    @Reference
    private UserLocalService userLocalService;

    @Reference
    private BranchMasterLocalService branchMasterLocalService;

    @Override
    public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {


        ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);


        List<DepartmentMaster> departmentMasterList = departmentMasterLocalService.getDepartmentMasters(-1,-1);
        renderRequest.setAttribute(AxHrmsEmployeeOnboardingHrWebPortletConstants.DEPARTMENT_MASTER_LIST, departmentMasterList);

        List<DesignationMaster> designationMasterList = designationMasterLocalService.getDesignationMasters(-1,-1);
        renderRequest.setAttribute(AxHrmsEmployeeOnboardingHrWebPortletConstants.DESIGNATION_MASTER_LIST, designationMasterList);
        renderRequest.setAttribute(AxHrmsEmployeeOnboardingHrWebPortletConstants.EMPLOYEE_CODE_PATTERN, generateEmployeeCode());
        renderRequest.setAttribute(AxHrmsEmployeeOnboardingHrWebPortletConstants.DOMAIN, moduleConfiguration.domainName());

        List<BranchMaster> branchMasterList = branchMasterLocalService.getBranchMasters(-1,-1);
        renderRequest.setAttribute("branchMasterList", branchMasterList);
        List<EmployeeDetails> listOfEmployeeDetails = employeeDetailsLocalService.getEmployeeDetailses(-1,-1);


        /**
         * @implNote : listOfFilteredEmployeeDetails is a list of Employee Details in which auth user's role is Employee
         */
        List<EmployeeDetails> listOfFilteredEmployeeDetails = new ArrayList<>();

        for(EmployeeDetails employeeDetails : listOfEmployeeDetails) {

            try {
                long employeeRoleId = RoleLocalServiceUtil.getRole(themeDisplay.getCompanyId(), AxHrmsEmployeeOnboardingHrWebPortletConstants.EMPLOYEE).getRoleId();
                long[] userRoles = userLocalService.getUserById(employeeDetails.getLrUserId()).getRoleIds();
                for(long userRole : userRoles) {
                    if(userRole == employeeRoleId)
                        listOfFilteredEmployeeDetails.add(employeeDetails);
                }
            } catch (PortalException e) {
                log.error("ViewLeaveRequestFormMVCRenderCommand >>> render ::: PortalException: "+e.getMessage());
            }catch (NullPointerException e) {
                log.error("ViewLeaveRequestFormMVCRenderCommand >>> render ::: NullPointerException: "+e.getMessage());
            }catch(Exception e) {
                log.error("ViewLeaveRequestFormMVCRenderCommand >>> render ::: Exception: "+e.getMessage());
            }

        }
        renderRequest.setAttribute(AxHrmsEmployeeOnboardingHrWebPortletConstants.EMPLOYEE_DETAILS_LIST,listOfFilteredEmployeeDetails);

        return AxHrmsEmployeeOnboardingHrWebPortletConstants.EMPLOYEE_ON_BOARDING_HR_FORM_JSP;
    }
    public String generateEmployeeCode() {

        String pattern = moduleConfiguration.employeeCodePattern();

        LocalDate today = LocalDate.now();

        int serialNo = getTodayEmployeeCount() + 1;


        log.info("Serial no :- "+ serialNo);

        Map<String, String> replacements = new HashMap<>();
        replacements.put("yyyy", String.valueOf(today.getYear()));
        replacements.put("MM", String.format("%02d", today.getMonthValue()));
        replacements.put("dd", String.format("%02d", today.getDayOfMonth()));
        replacements.put("no", String.valueOf(serialNo));

        String employeeCode = pattern;

        for (Map.Entry<String, String> entry : replacements.entrySet()) {
            employeeCode = employeeCode.replace(entry.getKey(), entry.getValue());
        }

        return employeeCode;
    }


    public int getTodayEmployeeCount() {

        try {
            LocalDate today = LocalDate.now();

            Date startOfDay = Date.from(today.atStartOfDay(ZoneId.systemDefault()).toInstant());
            Date endOfDay = Date.from(today.atTime(23, 59, 59).atZone(ZoneId.systemDefault()).toInstant());

            DynamicQuery dq = employeeDetailsLocalService.dynamicQuery();

            dq.add(RestrictionsFactoryUtil.ge("createDate", startOfDay));
            dq.add(RestrictionsFactoryUtil.le("createDate", endOfDay));

            return (int) employeeDetailsLocalService.dynamicQueryCount(dq);

        }catch (Exception e){
            e.printStackTrace();
        }
        return 0;
    }



}
