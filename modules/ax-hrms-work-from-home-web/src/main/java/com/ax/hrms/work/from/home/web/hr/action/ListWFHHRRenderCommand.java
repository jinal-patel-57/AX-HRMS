//package com.ax.hrms.work.from.home.web.hr.action;
//
//
//import com.ax.hrms.model.WorkFromHome;
//import com.ax.hrms.service.WorkFromHomeLocalService;
//import com.ax.hrms.work.from.home.web.constants.AxHrmsWorkFromHomePortletKeys;
//import com.ax.hrms.work.from.home.web.hr.dto.WFHRequestDto;
//import com.liferay.portal.kernel.dao.search.SearchContainer;
//import com.liferay.portal.kernel.portlet.PortletURLUtil;
//import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
//import com.liferay.portal.kernel.model.User;
//import com.liferay.portal.kernel.service.UserLocalService;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import javax.portlet.PortletException;
//import javax.portlet.PortletURL;
//import javax.portlet.RenderRequest;
//import javax.portlet.RenderResponse;
//
//import org.osgi.service.component.annotations.Component;
//import org.osgi.service.component.annotations.Reference;
//
//@Component(property = {"javax.portlet.name=" + AxHrmsWorkFromHomePortletKeys.AXHRMSWORKFROMHOMEHR, "mvc.command.name=/"}, service = MVCRenderCommand.class)
//public class ListWFHHRRenderCommand implements MVCRenderCommand {
//
//    @Reference
//    private WorkFromHomeLocalService workFromHomeLocalService;
//
//    @Reference
//    private UserLocalService userLocalService;
//
//    @Override
//    public String render(RenderRequest request, RenderResponse response) throws PortletException {
//        PortletURL iteratorURL = PortletURLUtil.getCurrent(request, response);
//        System.out.println("Heleo dkvhsdfiusdhf");
//        // Get SearchContainer from JSP
//        SearchContainer<WFHRequestDto> searchContainer = new SearchContainer<>(request, iteratorURL, null, "No Work From Home requests found.");
//
/// /        int start = 0;
/// /        int end = 20; // default
/// /
/// /        if (searchContainer != null) {
/// /            start = searchContainer.getStart();
/// /            end = searchContainer.getEnd();
/// /        }
/// /
/// /        // Fetch paginated WFH entries
/// /        List<WorkFromHome> wfhListRaw = workFromHomeLocalService.getWorkFromHomes(start, end);
/// /
/// /        int total = workFromHomeLocalService.getWorkFromHomesCount();
/// /
/// /
/// /
/// /        searchContainer.setResultsAndTotal(() -> workFromHomeLocalService.getWorkFromHomes(searchContainer.getStart(), searchContainer.getEnd()), total);
/// /
/// /        // Correct method
/// /        request.setAttribute("wfhSC", searchContainer);
/// /        request.setAttribute("totalWFH", total);
//
//
//
//        int start = searchContainer.getStart();
//        int end = searchContainer.getEnd();
//
//        // Fetch WorkFromHome records
//        List<WorkFromHome> wfhListRaw = workFromHomeLocalService.getWorkFromHomes(start, end);
//        int total = workFromHomeLocalService.getWorkFromHomesCount();
//
//        // Convert to DTO
//        List<WFHRequestDto> dtoList = new ArrayList<>();
//        for (WorkFromHome wfh : workFromHomeLocalService.getWorkFromHomes(start, end)) {
//            User user = userLocalService.fetchUser(wfh.getUserId());
//            WFHRequestDto dto = new WFHRequestDto();
//            dto.setWorkFromHomeRequestId(wfh.getWorkFromHomeRequestId());
//            dto.setEmployeeName(user != null ? user.getFullName() : "Unknown");
//            dto.setTeamMailId(wfh.getTeamMailId());
//            dto.setReason(wfh.getReason());
/// /            dto.setStatus(wfh.getStatus());
//            dto.setRequestDate(wfh.getRequestDate());
//            dto.setStartDate(wfh.getStartDate());
//            dto.setEndDate(wfh.getEndDate());
//            dtoList.add(dto);
//        }
//
//        // Set results and total in SearchContainer
//        searchContainer.setResultsAndTotal(() -> dtoList, total);
//
//        request.setAttribute("wfhSC", searchContainer);
//        request.setAttribute("totalWFH", total);
//
//        return "/jsp/ax-hrms-work-from-home-hr/list_work_from_home_hr.jsp";
//    }
//}


//
//package com.ax.hrms.work.from.home.web.hr.action;
//
//import com.ax.hrms.master.model.LeaveCompensatoryStatusMaster;
//import com.ax.hrms.master.service.LeaveCompensatoryStatusMasterLocalService;
//import com.ax.hrms.model.WorkFromHome;
//import com.ax.hrms.service.WorkFromHomeLocalService;
//import com.ax.hrms.work.from.home.web.constants.AxHrmsWorkFromHomePortletKeys;
//import com.ax.hrms.work.from.home.web.employee.util.WFHStatusUtil;
//import com.ax.hrms.work.from.home.web.hr.dto.WFHRequestDto;
//import com.liferay.portal.kernel.dao.search.SearchContainer;
//import com.liferay.portal.kernel.model.User;
//import com.liferay.portal.kernel.portlet.PortletURLUtil;
//import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
//import com.liferay.portal.kernel.service.UserLocalService;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import javax.portlet.PortletException;
//import javax.portlet.PortletURL;
//import javax.portlet.RenderRequest;
//import javax.portlet.RenderResponse;
//
//import org.osgi.service.component.annotations.Component;
//import org.osgi.service.component.annotations.Reference;
//
//@Component(
//        property = {
//                "javax.portlet.name=" + AxHrmsWorkFromHomePortletKeys.AXHRMSWORKFROMHOMEHR,
//                "mvc.command.name=/"
//        },
//        service = MVCRenderCommand.class
//)
//public class ListWFHHRRenderCommand implements MVCRenderCommand {
//
//    @Reference
//    private WorkFromHomeLocalService workFromHomeLocalService;
//
//    @Reference
//    private UserLocalService userLocalService;
//
//    @Reference
//    private LeaveCompensatoryStatusMasterLocalService leaveStatusLocalService;
//
//    @Override
//    public String render(RenderRequest request, RenderResponse response) throws PortletException {
//
//        // Create SearchContainer
//        PortletURL iteratorURL = PortletURLUtil.getCurrent(request, response);
//        SearchContainer<WFHRequestDto> searchContainer =
//                new SearchContainer<>(request, iteratorURL, null, "No Work From Home requests found.");
//
//        int start = searchContainer.getStart();
//        int end = searchContainer.getEnd();
//
//        // Fetch records
//        List<WorkFromHome> wfhList = workFromHomeLocalService.getWorkFromHomes(start, end);
//        int total = workFromHomeLocalService.getWorkFromHomesCount();
//
//        // Fetch LeaveCompensatoryStatusMaster list for status mapping
//        List<LeaveCompensatoryStatusMaster> statusList =
//                leaveStatusLocalService.getLeaveCompensatoryStatusMasters(-1, -1);
//
//        // Convert WorkFromHome → WFHRequestDto
//        List<WFHRequestDto> dtoList = new ArrayList<>();
//
//        for (WorkFromHome wfh : wfhList) {
//
//            User user = userLocalService.fetchUser(wfh.getUserId());
//
//            WFHRequestDto dto = new WFHRequestDto();
//            dto.setWorkFromHomeRequestId(wfh.getWorkFromHomeRequestId());
//            dto.setEmployeeName(user != null ? user.getFullName() : "Unknown");
//            dto.setTeamMailId(wfh.getTeamMailId());
//            dto.setReason(wfh.getReason());
//
//            // Status mapping from LeaveCompensatoryStatusMaster
//            String statusName = WFHStatusUtil.getStatusNameById(
//                    wfh.getStatus(),   // statusId
//                    statusList
//            );
//            dto.setStatus(statusName);
//
//            dto.setRequestDate(wfh.getRequestDate());
//            dto.setStartDate(wfh.getStartDate());
//            dto.setEndDate(wfh.getEndDate());
//
//            dtoList.add(dto);
//        }
//
//        // Apply results to SearchContainer
//        searchContainer.setResultsAndTotal(() -> dtoList, total);
//
//        // Set attributes for JSP
//        request.setAttribute("wfhSC", searchContainer);
//        request.setAttribute("totalWFH", total);
//
//        return "/jsp/ax-hrms-work-from-home-hr/list_work_from_home_hr.jsp";
//    }
//}














package com.ax.hrms.work.from.home.web.hr.action;

import com.ax.hrms.master.model.LeaveCompensatoryStatusMaster;
import com.ax.hrms.master.service.LeaveCompensatoryStatusMasterLocalService;
import com.ax.hrms.model.WorkFromHome;
import com.ax.hrms.service.WorkFromHomeLocalService;
import com.ax.hrms.work.from.home.web.constants.AxHrmsWorkFromHomePortletKeys;
import com.ax.hrms.work.from.home.web.employee.util.WFHStatusUtil;
import com.ax.hrms.work.from.home.web.hr.dto.WFHRequestDto;

import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.portlet.PortletURLUtil;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * HR – Work From Home List Page Renderer
 */
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
    private WorkFromHomeLocalService workFromHomeLocalService;

    @Reference
    private UserLocalService userLocalService;

    @Reference
    private LeaveCompensatoryStatusMasterLocalService leaveStatusLocalService;

    @Override
    public String render(RenderRequest renderRequest, RenderResponse renderResponse) {

        log.info("===== Entering ListWFHHRRenderCommand#render() =====");

        try {
            // Pagination parameters
            int curValue = ParamUtil.getInteger(renderRequest, SearchContainer.DEFAULT_CUR_PARAM, 1);
            int deltaValue = ParamUtil.getInteger(renderRequest, SearchContainer.DEFAULT_DELTA_PARAM, 3);

            log.info("Pagination - Current Page: " + curValue + ", Delta: " + deltaValue);

            int totalWFHRequests = workFromHomeLocalService.getWorkFromHomesCount();
            log.info("Total WFH Requests found: " + totalWFHRequests);

            int totalPageContainer = (totalWFHRequests + deltaValue - 1) / deltaValue;

            if (curValue > totalPageContainer && totalPageContainer > 0) {
                curValue = totalPageContainer;
                log.warn("Current page exceeded number of pages. Reset to: " + curValue);
            }

            int start = (curValue - 1) * deltaValue;
            int end = start + deltaValue;

            log.info("Fetching records from index " + start + " to " + end);

            // Fetch WFH entities
            List<WorkFromHome> wfhList = workFromHomeLocalService.getWorkFromHomes(start, end);

            if (wfhList == null || wfhList.isEmpty()) {
                log.warn("No WFH records found for the given range.");
            }

            // Fetch status list
            List<LeaveCompensatoryStatusMaster> statusList =
                    leaveStatusLocalService.getLeaveCompensatoryStatusMasters(-1, -1);

            log.info("Status Master List fetched. Total statuses: " + statusList.size());

            List<WFHRequestDto> wfhRequestDtoList = new ArrayList<>();

            for (WorkFromHome wfh : wfhList) {

                log.info("Processing WFH Request ID: " + wfh.getWorkFromHomeRequestId());

                User user = userLocalService.fetchUser(wfh.getUserId());
                if (user != null) {
                    log.debug("Fetched user: " + user.getFullName());
                } else {
                    log.warn("User not found for ID: " + wfh.getUserId());
                }

                WFHRequestDto dto = new WFHRequestDto();
                dto.setWorkFromHomeRequestId(wfh.getWorkFromHomeRequestId());
                dto.setEmployeeName(user != null ? user.getFullName() : "Unknown");

                dto.setTeamMailId(wfh.getTeamMailId());
                dto.setReason(wfh.getReason());

                // Status mapping
                String statusName = WFHStatusUtil.getStatusNameById(
                        wfh.getStatus(),
                        statusList
                );

                log.debug("Mapped Status ID " + wfh.getStatus() + " to Status Name: " + statusName);

                dto.setStatus(statusName);

                dto.setRequestDate(wfh.getRequestDate());
                dto.setStartDate(wfh.getStartDate());
                dto.setEndDate(wfh.getEndDate());

                wfhRequestDtoList.add(dto);
            }

            // Set JSP attributes
            renderRequest.setAttribute("wfhRequestList", wfhRequestDtoList);
            renderRequest.setAttribute("totalWFHRequest", totalWFHRequests);
            renderRequest.setAttribute(SearchContainer.DEFAULT_DELTA_PARAM, deltaValue);
            renderRequest.setAttribute("iteratorURL", renderResponse.createRenderURL());

            // Setup SearchContainer
            SearchContainer<WFHRequestDto> searchContainer = new SearchContainer<>(
                    renderRequest,
                    renderResponse.createRenderURL(),
                    null,
                    "no-wfh-request-found"
            );

            searchContainer.setResultsAndTotal(wfhRequestDtoList);

            renderRequest.setAttribute("wfhSC", searchContainer);

            log.info("WFH DTO List prepared successfully. Total DTOs: " + wfhRequestDtoList.size());

        } catch (Exception e) {
            log.error("Exception in ListWFHHRRenderCommand: ", e);
        }

        log.info("===== Exiting ListWFHHRRenderCommand#render() =====");

        return "/jsp/ax-hrms-work-from-home-hr/list_work_from_home_hr.jsp";
    }
}