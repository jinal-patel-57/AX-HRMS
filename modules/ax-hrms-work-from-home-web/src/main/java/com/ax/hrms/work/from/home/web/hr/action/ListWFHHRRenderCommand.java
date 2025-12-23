package com.ax.hrms.work.from.home.web.hr.action;

import com.ax.hrms.common.api.api.AxHrmsCommonApi;
import com.ax.hrms.master.model.LeaveCompensatoryStatusMaster;
import com.ax.hrms.master.service.LeaveCompensatoryStatusMasterLocalService;
import com.ax.hrms.model.EmployeeDetails;
import com.ax.hrms.model.WorkFromHomeRequest;
import com.ax.hrms.service.EmployeeDetailsLocalService;
import com.ax.hrms.service.WorkFromHomeRequestLocalService;
import com.ax.hrms.work.from.home.web.constants.AxHrmsWorkFromHomePortletKeys;
import com.ax.hrms.work.from.home.web.employee.util.WFHStatusUtil;
import com.ax.hrms.work.from.home.web.hr.dto.WFHRequestDto;

import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.PortletURLUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import java.util.ArrayList;
import java.util.List;

@Component(
        property = {
                "javax.portlet.name=" + AxHrmsWorkFromHomePortletKeys.AXHRMSWORKFROMHOMEHR,
                "mvc.command.name=/"
        },
        service = MVCRenderCommand.class
)
public class ListWFHHRRenderCommand implements MVCRenderCommand {

    private static final Log log = LogFactoryUtil.getLog(ListWFHHRRenderCommand.class);

    @Reference
    private WorkFromHomeRequestLocalService workFromHomeRequestLocalService;

    @Reference
    private EmployeeDetailsLocalService employeeDetailsLocalService;

    @Reference
    private LeaveCompensatoryStatusMasterLocalService leaveStatusLocalService;

    @Reference
    private AxHrmsCommonApi axHrmsCommonApi;

    @Override
    public String render(RenderRequest renderRequest, RenderResponse renderResponse) {

        ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
        long currentUserId = themeDisplay.getUserId();

        boolean isHRAdmin = axHrmsCommonApi.isRolePerson(themeDisplay, "HR Admin");
        boolean isManager = axHrmsCommonApi.isRolePerson(themeDisplay, "Manager");

        // Setup SearchContainer like employee version
        PortletURL iteratorURL = PortletURLUtil.getCurrent(renderRequest, renderResponse);
        SearchContainer<WFHRequestDto> searchContainer =
                new SearchContainer<>(renderRequest, iteratorURL, null, "no-wfh-request-found");

        // Pagination params like employee version
        int cur = ParamUtil.getInteger(renderRequest, SearchContainer.DEFAULT_CUR_PARAM, 1);
        int delta = ParamUtil.getInteger(renderRequest, SearchContainer.DEFAULT_DELTA_PARAM, 20);
        int start = (cur - 1) * delta;
        int end = start + delta;

        List<WorkFromHomeRequest> wfhRequestList = new ArrayList<>();
        int totalWFHRequests = 0;

        try {
            if (isHRAdmin) {
                // HR Admin → fetch all requests
                totalWFHRequests = workFromHomeRequestLocalService.getWorkFromHomeRequestsCount();
                if (start >= totalWFHRequests) {
                    start = 0;
                    end = delta;
                }
                end = Math.min(totalWFHRequests, end);
                wfhRequestList = workFromHomeRequestLocalService.getWorkFromHomeRequests(start, end);

            } else if (isManager) {
                // Manager → fetch requests for their team
                EmployeeDetails managerEmployee = employeeDetailsLocalService.findByLrUserId(currentUserId);

                if (managerEmployee != null) {
                    List<EmployeeDetails> teamEmployees = employeeDetailsLocalService.findByManagerId(managerEmployee.getEmployeeId());

                    if (!teamEmployees.isEmpty()) {
                        // Count total WFH requests for the team
                        totalWFHRequests = 0;
                        for (EmployeeDetails emp : teamEmployees) {
                            totalWFHRequests += workFromHomeRequestLocalService.countByEmployeeId(emp.getEmployeeId());
                        }

                        if (start >= totalWFHRequests) {
                            start = 0;
                            end = delta;
                        }
                        end = Math.min(totalWFHRequests, start + delta);

                        int toFetch = end - start;
                        int skipped = 0;
                        wfhRequestList = new ArrayList<>();

                        for (EmployeeDetails emp : teamEmployees) {
                            int empCount = workFromHomeRequestLocalService.countByEmployeeId(emp.getEmployeeId());

                            if (skipped + empCount <= start) {
                                skipped += empCount;
                                continue;
                            }

                            int empStart = Math.max(0, start - skipped);
                            int empEnd = Math.min(empCount, empStart + toFetch);

                            wfhRequestList.addAll(
                                    workFromHomeRequestLocalService.findByEmployeeId(emp.getEmployeeId(), empStart, empEnd)
                            );

                            toFetch -= (empEnd - empStart);
                            skipped += empCount;

                            if (toFetch <= 0) break;
                        }
                    }
                }
            }

            // Fetch status master
            List<LeaveCompensatoryStatusMaster> statusList = leaveStatusLocalService.getLeaveCompensatoryStatusMasters(-1, -1);

            // Convert WFH records to DTO
            List<WFHRequestDto> dtoList = new ArrayList<>();
            for (WorkFromHomeRequest wfh : wfhRequestList) {
                EmployeeDetails employeeDetails = employeeDetailsLocalService.fetchEmployeeDetails(wfh.getEmployeeId());

                WFHRequestDto dto = new WFHRequestDto();
                dto.setWorkFromHomeRequestId(wfh.getWorkFromHomeRequestId());
                dto.setEmployeeName(employeeDetails != null
                        ? employeeDetails.getFirstName() + " " + employeeDetails.getLastName()
                        : "Unknown");
                dto.setTeamMailId(wfh.getTeamMailId());
                dto.setReason(wfh.getReason());
                dto.setStatus(WFHStatusUtil.getStatusNameById(wfh.getStatus(), statusList));
                dto.setRequestDate(wfh.getRequestDate());
                dto.setStartDate(wfh.getStartDate());
                dto.setEndDate(wfh.getEndDate());

                dtoList.add(dto);
            }

            // Set results and total like employee version
            searchContainer.setDelta(delta);
            searchContainer.setDeltaConfigurable(true);
            searchContainer.setResultsAndTotal(() -> dtoList, totalWFHRequests);

            renderRequest.setAttribute("wfhSC", searchContainer);
            renderRequest.setAttribute("totalWFHRequest", totalWFHRequests);
            renderRequest.setAttribute("delta", delta);

        } catch (Exception e) {
            log.error("Error while listing WFH requests", e);
        }

        return "/jsp/ax-hrms-work-from-home-hr/list_work_from_home_hr.jsp";
    }
}
