package com.ax.hrms.employee.onboarding.hr.web.action;

import com.ax.hrms.employee.onboarding.web.constants.AxHrmsEmployeeOnboardingHrWebPortletConstants;
import com.ax.hrms.employee.onboarding.web.constants.AxHrmsEmployeeOnboardingWebPortletKeys;
import com.ax.hrms.master.model.DepartmentMaster;
import com.ax.hrms.master.model.DesignationMaster;
import com.ax.hrms.master.service.DepartmentMasterLocalService;
import com.ax.hrms.master.service.DesignationMasterLocalService;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import java.util.List;

@Component(
        immediate = true,
        property = {
                "javax.portlet.name=" + AxHrmsEmployeeOnboardingWebPortletKeys.AX_HRMS_EMPLOYEE_ONBOARDING_HR_WEB,
                "mvc.command.name=/onboardingFormHr"
        },
        service = MVCRenderCommand.class
)
public class OnBoardingEmployeeHrMVCRenderCommand implements MVCRenderCommand {

    @Reference
    DepartmentMasterLocalService departmentMasterLocalService;

    @Reference
    DesignationMasterLocalService designationMasterLocalService;

    @Override
    public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {

        List<DepartmentMaster> departmentMasterList = departmentMasterLocalService.getDepartmentMasters(-1,-1);
        renderRequest.setAttribute(AxHrmsEmployeeOnboardingHrWebPortletConstants.DEPARTMENT_MASTER_LIST, departmentMasterList);

        List<DesignationMaster> designationMasterList = designationMasterLocalService.getDesignationMasters(-1,-1);
        renderRequest.setAttribute(AxHrmsEmployeeOnboardingHrWebPortletConstants.DESIGNATION_MASTER_LIST, designationMasterList);
        return AxHrmsEmployeeOnboardingHrWebPortletConstants.EMPLOYEE_ON_BOARDING_HR_FORM_JSP;
    }
}
