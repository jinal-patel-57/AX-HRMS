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
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
    private UserLocalService userLocalService;

    @Reference
    private AxHrmsCommonApi axHrmsCommonApi;

    @Override
    public String render(RenderRequest renderRequest, RenderResponse renderResponse) {

        ThemeDisplay themeDisplay =
                (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);

        long currentUserId = themeDisplay.getUserId();

        boolean isHRAdmin =
                axHrmsCommonApi.isRolePerson(themeDisplay, "HR Admin");

        boolean isManager =
                axHrmsCommonApi.isRolePerson(themeDisplay, "Manager");

        // ✅ SearchContainer owns pagination
        PortletURL iteratorURL = renderResponse.createRenderURL();

        SearchContainer<WFHRequestDto> searchContainer =
                new SearchContainer<>(
                        renderRequest,
                        iteratorURL,
                        null,
                        "no-wfh-request-found"
                );

        int start = searchContainer.getStart();
        int end = searchContainer.getEnd();

        List<WorkFromHomeRequest> wfhRequestList = new ArrayList<>();
        int totalWFHRequests = 0;

        try {

            if (isHRAdmin) {

                // HR Admin → ALL requests

                log.info("inside the hr admin");
                totalWFHRequests =
                        workFromHomeRequestLocalService.getWorkFromHomeRequestsCount();
                log.info("total wfh requests: " + totalWFHRequests);
                wfhRequestList =
                        workFromHomeRequestLocalService.getWorkFromHomeRequests(start, end);
                log.info("total wfh requests: " + wfhRequestList.size());
            } else if (isManager) {

                // Find manager employee record
                EmployeeDetails managerEmployee =
                        employeeDetailsLocalService.findByLrUserId(currentUserId);

                if (managerEmployee != null) {

                    // Employees under this manager
                    List<EmployeeDetails> teamEmployees =
                            employeeDetailsLocalService.findByManagerId(
                                    managerEmployee.getEmployeeId());

                    List<Long> teamUserIds = teamEmployees.stream()
                            .map(EmployeeDetails::getEmployeeId)
                            .collect(Collectors.toList());

                    log.info("teamUserIds :: "+teamUserIds);
                    if (!teamUserIds.isEmpty()) {

                        List<WorkFromHomeRequest> allRequests =
                                workFromHomeRequestLocalService
                                        .getWorkFromHomeRequests(-1, -1)
                                        .stream()
                                        .filter(req ->
                                                teamUserIds.contains(req.getEmployeeId()))
                                        .collect(Collectors.toList());

                        totalWFHRequests = allRequests.size();

                        wfhRequestList = allRequests.stream()
                                .skip(start)
                                .limit(end - start)
                                .collect(Collectors.toList());
                    }
                }
            }

            // Fetch status master
            List<LeaveCompensatoryStatusMaster> statusList =
                    leaveStatusLocalService.getLeaveCompensatoryStatusMasters(-1, -1);

            // Convert to DTO
            List<WFHRequestDto> dtoList = new ArrayList<>();
            log.info("outside the hr admin");
            for (WorkFromHomeRequest wfh : wfhRequestList) {
                 log.info("inside the loop ::"+wfh.toString());
//                User user = userLocalService.fetchUser(wfh.getUserId());
                EmployeeDetails employeeDetails=employeeDetailsLocalService.findByEmployeeId(wfh.getEmployeeId());

                WFHRequestDto dto = new WFHRequestDto();
                dto.setWorkFromHomeRequestId(wfh.getWorkFromHomeRequestId());
                dto.setEmployeeName(employeeDetails != null ? employeeDetails.getFirstName()+"  "+employeeDetails.getLastName() : "Unknown");
                dto.setTeamMailId(wfh.getTeamMailId());
                dto.setReason(wfh.getReason());
                dto.setStatus(
                        WFHStatusUtil.getStatusNameById(wfh.getStatus(), statusList)
                );
                dto.setRequestDate(wfh.getRequestDate());
                dto.setStartDate(wfh.getStartDate());
                dto.setEndDate(wfh.getEndDate());

                dtoList.add(dto);
            }
            log.info("Outside the loops ok.......");
            searchContainer.setResultsAndTotal(
                    () -> dtoList,
                    totalWFHRequests
            );
            log.info("here ok.....");
            renderRequest.setAttribute("wfhSC", searchContainer);

        } catch (Exception e) {
            log.error("Error while listing WFH requests", e);
        }

        return "/jsp/ax-hrms-work-from-home-hr/list_work_from_home_hr.jsp";
    }
}
