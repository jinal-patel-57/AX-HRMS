package com.ax.hrms.employee.details.report.actions;

import com.ax.hrms.model.EmployeeDetails;
import com.ax.hrms.report.web.constants.AkHrmsEmployeeDetailsReportWebPortletKeys;
import com.ax.hrms.service.EmployeeDetailsLocalService;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import java.util.List;

@Component(
        property = {
                "javax.portlet.name=" + AkHrmsEmployeeDetailsReportWebPortletKeys.AKHRMSEMPLOYEEDETAILSREPORTWEB,
                "mvc.command.name=/"
        },
        service = MVCRenderCommand.class
)
public class EmployeeDetailsReportMVCRenderCommand implements MVCRenderCommand  {

    @Override
    public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {

        List<EmployeeDetails> employeeList = employeeDetailsLocalService.findByIsTerminated(false);
        renderRequest.setAttribute("employeeList", employeeList);
        return "/jsp/employeedetailsreport/employeeDetailsReportExport.jsp";
    }

    @Reference
    EmployeeDetailsLocalService employeeDetailsLocalService;
}
