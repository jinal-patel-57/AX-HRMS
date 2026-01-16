package com.ax.hrms.report.web.actions;

import com.ax.hrms.model.EmployeeDetails;
import com.ax.hrms.model.LeaveBalanceHistoryTable;
import static com.ax.hrms.report.web.constants.AkHrmsLeaveBalanceReportWebPortletKeys.*;
import com.ax.hrms.service.EmployeeDetailsLocalService;
import com.ax.hrms.service.LeaveBalanceHistoryLocalService;
import com.liferay.petra.sql.dsl.DSLQueryFactoryUtil;
import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;

import java.time.Year;
import java.util.ArrayList;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
        property = {
                "javax.portlet.name=" + AKHRMSLEAVEBALANCEREPORTWEB,
                "mvc.command.name=/"
        },
        service = MVCRenderCommand.class
)
public class LeaveBalanceMVCRenderCommand implements MVCRenderCommand {
    
	private static final Log log = LogFactoryUtil.getLog(LeaveBalanceMVCRenderCommand.class);

    @Reference
    EmployeeDetailsLocalService employeeDetailsLocalService;
    
    @Reference
    LeaveBalanceHistoryLocalService leaveBalanceHistoryLocalService;
	
	@Override
    public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {

        List<EmployeeDetails> employeeList = employeeDetailsLocalService.findByIsTerminated(false);
        renderRequest.setAttribute("employeeList", employeeList);
        List<Integer> yearList = new ArrayList<>(getDistinctYearsDesc());

        int currentYear = Year.now().getValue();
        boolean containsCurrentYear = yearList.contains(currentYear);
        if(!containsCurrentYear) {
        	yearList.add(currentYear);
        }
        renderRequest.setAttribute("yearList",yearList);
        return "/jsp/leavebalance/leaveBalanceExport.jsp";
    }

    public List<Integer> getDistinctYearsDesc() {

        DSLQuery dslQuery = DSLQueryFactoryUtil.selectDistinct(LeaveBalanceHistoryTable.INSTANCE.year)
            .from(LeaveBalanceHistoryTable.INSTANCE)
            .orderBy(LeaveBalanceHistoryTable.INSTANCE.year.descending());
        log.info(" list -- " + leaveBalanceHistoryLocalService.dslQuery(dslQuery));
        return leaveBalanceHistoryLocalService.dslQuery(dslQuery);
    }
}
