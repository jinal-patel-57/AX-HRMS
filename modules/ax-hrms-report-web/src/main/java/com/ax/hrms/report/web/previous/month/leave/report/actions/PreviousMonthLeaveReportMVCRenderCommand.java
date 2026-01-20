package com.ax.hrms.report.web.previous.month.leave.report.actions;

import com.ax.hrms.model.EmployeeDetails;
import com.ax.hrms.report.web.constants.AxHrmsPreviousMonthLeaveReportWebPortletKeys;
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
                "javax.portlet.name=" + AxHrmsPreviousMonthLeaveReportWebPortletKeys.AXHRMSPREVIOUSMONTHLEAVEREPORTWEB,
                "mvc.command.name=/"
        },
        service = MVCRenderCommand.class
)
public class PreviousMonthLeaveReportMVCRenderCommand implements MVCRenderCommand  {

    @Override
    public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {

        List<EmployeeDetails> employeeList = employeeDetailsLocalService.findByIsTerminated(false);
        renderRequest.setAttribute("employeeList", employeeList);
        return "/jsp/previousmonthleavereport/previousMonthLeaveReportExport.jsp";
    }

    @Reference
    EmployeeDetailsLocalService employeeDetailsLocalService;
}
