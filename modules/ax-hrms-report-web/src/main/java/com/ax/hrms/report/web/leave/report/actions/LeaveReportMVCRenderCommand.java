package com.ax.hrms.report.web.leave.report.actions;

import com.ax.hrms.model.EmployeeDetails;
import com.ax.hrms.service.EmployeeDetailsLocalService;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import java.util.List;

import static com.ax.hrms.report.web.constants.AkHrmsLeaveBalanceReportWebPortletKeys.AKHRMSLEAVEREPORTWEB;

@Component(
        property = {
                "javax.portlet.name=" + AKHRMSLEAVEREPORTWEB,
                "mvc.command.name=/"
        },
        service = MVCRenderCommand.class
)
public class LeaveReportMVCRenderCommand implements MVCRenderCommand {

    private static final Log log = LogFactoryUtil.getLog(LeaveReportMVCRenderCommand.class);

    @Reference
    EmployeeDetailsLocalService employeeDetailsLocalService;

    @Override
    public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
        List<EmployeeDetails> employeeList = employeeDetailsLocalService.findByIsTerminated(false);
        renderRequest.setAttribute("employeeList", employeeList);
        return "/jsp/leavereport/leaveReport.jsp";
    }
}
