package com.ax.hrms.report.web.month.wise.leave.balance.report.actions;

import com.ax.hrms.model.EmployeeDetails;
import com.ax.hrms.model.LeaveBalanceHistoryTable;
import com.ax.hrms.report.web.constants.AxHrmsMonthWiseLeaveBalanceReportWebPortletKeys;
import com.ax.hrms.service.EmployeeDetailsLocalService;
import com.ax.hrms.service.LeaveBalanceHistoryLocalService;
import com.liferay.petra.sql.dsl.DSLQueryFactoryUtil;
import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import java.time.LocalDate;
import java.time.Year;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Component(
        property = {
                "javax.portlet.name=" + AxHrmsMonthWiseLeaveBalanceReportWebPortletKeys.AXHRMSMONTHWISELEAVEBALANCEREPORTWEB,
                "mvc.command.name=/"
        },
        service = MVCRenderCommand.class
)
public class MonthWiseLeaveBalanceMVCRenderCommand implements MVCRenderCommand {
    
	private static final Log log = LogFactoryUtil.getLog(MonthWiseLeaveBalanceMVCRenderCommand.class);

    @Reference
    EmployeeDetailsLocalService employeeDetailsLocalService;
    
    @Reference
    LeaveBalanceHistoryLocalService leaveBalanceHistoryLocalService;
	
	@Override
    public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {

        List<EmployeeDetails> employeeList = employeeDetailsLocalService.findByIsTerminated(false);
        renderRequest.setAttribute("employeeList", employeeList);
        int currentYear = Year.now().getValue();
        int currentMonth = LocalDate.now().getMonthValue();

        List<Integer> yearList = Arrays.asList(
                currentYear,
                currentYear - 1,
                currentYear - 2
        );

        renderRequest.setAttribute("yearList", yearList);
        renderRequest.setAttribute("currentYear", currentYear);
        renderRequest.setAttribute("currentMonth", currentMonth);
        return "/jsp/monthwiseleavebalance/monthwiseleaveBalanceExport.jsp";
    }


}
