package com.ax.hrms.leave.balance.report.web.actions;

import com.ax.hrms.leave.balance.report.web.constants.AkHrmsLeaveBalanceReportWebPortletKeys;
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

@Component(
        property = {
                "javax.portlet.name=" + AkHrmsLeaveBalanceReportWebPortletKeys.AKHRMSLEAVEBALANCEREPORTWEB,
                "mvc.command.name=/"
        },
        service = MVCRenderCommand.class
)
public class IntialMVCRenderCommand implements MVCRenderCommand {
    @Override
    public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {

        List<EmployeeDetails> employeeList = employeeDetailsLocalService.findByIsTerminated(false);
        renderRequest.setAttribute("employeeList", employeeList);
        return "/leaveBalanceExport.jsp";
    }

    private static final Log _log = LogFactoryUtil.getLog(IntialMVCRenderCommand.class);

    @Reference
    EmployeeDetailsLocalService employeeDetailsLocalService;
}
