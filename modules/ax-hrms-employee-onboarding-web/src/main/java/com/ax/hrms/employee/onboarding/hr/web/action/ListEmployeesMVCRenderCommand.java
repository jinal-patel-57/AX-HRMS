package com.ax.hrms.employee.onboarding.hr.web.action;

import com.ax.hrms.employee.onboarding.web.constants.AxHrmsEmployeeOnboardingHrWebPortletConstants;
import com.ax.hrms.employee.onboarding.web.constants.AxHrmsEmployeeOnboardingWebPortletKeys;
import com.ax.hrms.master.service.ProjectTaskStatusMasterLocalServiceUtil;
import com.ax.hrms.model.EmployeeDetails;
import com.ax.hrms.service.EmployeeDepartmentLocalServiceUtil;
import com.ax.hrms.service.EmployeeDetailsLocalService;
import com.ax.hrms.service.EmployeeDetailsLocalServiceUtil;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.portlet.PortletURLUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.PortletException;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

@Component(
        immediate = true,
        property = {
                "javax.portlet.name=" + AxHrmsEmployeeOnboardingWebPortletKeys.AX_HRMS_EMPLOYEE_ONBOARDING_HR_WEB,
                "mvc.command.name=/"
        },
        service = MVCRenderCommand.class
)
public class ListEmployeesMVCRenderCommand implements MVCRenderCommand {

    @Reference
    EmployeeDetailsLocalService employeeDetailsLocalService;
    @Override
    public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {

        PortletURL iteratorURL = PortletURLUtil.getCurrent(renderRequest, renderResponse);
        SearchContainer<EmployeeDetails> customerOrderSearchContainer = new SearchContainer<>(renderRequest, iteratorURL,
                null, StringPool.BLANK); // New search container
        customerOrderSearchContainer.setDeltaConfigurable(true); // Setting the delta configurable to true
        customerOrderSearchContainer.setResultsAndTotal(employeeDetailsLocalService.getEmployeeDetailses(-1,-1)); // Loading all records on the Search Container
        renderRequest.setAttribute(AxHrmsEmployeeOnboardingHrWebPortletConstants.EMPLOYEE_ON_BOARDING_HR_SC, customerOrderSearchContainer);
        renderRequest.setAttribute(AxHrmsEmployeeOnboardingHrWebPortletConstants.COUNT, EmployeeDetailsLocalServiceUtil.getEmployeeDetailsesCount());
        // END setting search container

        return AxHrmsEmployeeOnboardingHrWebPortletConstants.EMPLOYEE_ON_BOARDING_HR_LIST_JSP;
    }
}
