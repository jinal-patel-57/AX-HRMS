package com.ax.hrms.employee.onboarding.hr.web.action;

import com.ax.hrms.employee.onboarding.web.constants.AxHrmsEmployeeOnboardingHrWebPortletConstants;
import com.ax.hrms.employee.onboarding.web.constants.AxHrmsEmployeeOnboardingWebPortletKeys;
import com.ax.hrms.master.model.DepartmentMaster;
import com.ax.hrms.master.model.DesignationMaster;
import com.ax.hrms.master.service.DepartmentMasterLocalService;
import com.ax.hrms.master.service.DesignationMasterLocalService;
import com.ax.hrms.model.EmployeeDesignation;
import com.ax.hrms.model.EmployeeDetails;
import com.ax.hrms.service.EmployeeDetailsLocalService;
import com.ax.hrms.service.EmployeeDetailsLocalServiceUtil;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.PortletURLUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.PortletException;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import java.util.List;

@Component(
        immediate = true,
        property = {
                "javax.portlet.name=" + AxHrmsEmployeeOnboardingWebPortletKeys.AX_HRMS_EMPLOYEE_ONBOARDING_HR_WEB,
                "mvc.command.name=/convertInternToEmployee"
        },
        service = MVCRenderCommand.class
)
public class ConvertInternToEmployeeMVCRenderCommand implements MVCRenderCommand {

    @Reference
    EmployeeDetailsLocalService employeeDetailsLocalService;

    @Reference
    DesignationMasterLocalService designationMasterLocalService;

    @Reference
    DepartmentMasterLocalService departmentMasterLocalService;

    @Override
    public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
        long employeeId = ParamUtil.getLong(renderRequest, "employeeId");

        try {
            EmployeeDetails employeeDetails = employeeDetailsLocalService.getEmployeeDetails(employeeId);
            renderRequest.setAttribute("employee", employeeDetails);
        } catch (PortalException e) {
            throw new RuntimeException(e);
        }

        List<DepartmentMaster> departmentMasterList = departmentMasterLocalService.getDepartmentMasters(-1, -1);
        renderRequest.setAttribute(AxHrmsEmployeeOnboardingHrWebPortletConstants.DEPARTMENT_MASTER_LIST, departmentMasterList);

        List<DesignationMaster> designationMasterList = designationMasterLocalService.getDesignationMasters(-1, -1);
        renderRequest.setAttribute(AxHrmsEmployeeOnboardingHrWebPortletConstants.DESIGNATION_MASTER_LIST, designationMasterList);
        return AxHrmsEmployeeOnboardingHrWebPortletConstants.CONVERT_INTERN_TO_EMPLOYEE_JSP;
    }
}
