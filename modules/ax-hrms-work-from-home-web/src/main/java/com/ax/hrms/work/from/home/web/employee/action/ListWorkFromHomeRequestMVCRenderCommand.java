//package com.ax.hrms.work.from.home.web.employee.action;
//
//
//
//import com.ax.hrms.model.WorkFromHome;
//import com.ax.hrms.service.WorkFromHomeLocalService;
//import com.ax.hrms.work.from.home.web.constants.AxHrmsWorkFromHomePortletKeys;
//import com.liferay.portal.kernel.dao.search.SearchContainer;
//import com.liferay.portal.kernel.portlet.PortletURLUtil;
//import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
//
//import org.osgi.service.component.annotations.Component;
//import org.osgi.service.component.annotations.Reference;
//
//import javax.portlet.PortletException;
//import javax.portlet.PortletURL;
//import javax.portlet.RenderRequest;
//import javax.portlet.RenderResponse;
//
/// **
// * Listing WFH Records
// */
//@Component(
//        property = {
//                "javax.portlet.name=" + AxHrmsWorkFromHomePortletKeys.AXHRMSWORKFROMHOME,
//                "mvc.command.name=/"
//        },
//        service = MVCRenderCommand.class
//)
//public class ListWorkFromHomeRequestMVCRenderCommand implements MVCRenderCommand {
//
//    @Reference
//    WorkFromHomeLocalService workFromHomeLocalService;
//
//    @Override
//    public String render(RenderRequest renderRequest, RenderResponse renderResponse)
//            throws PortletException {
//
//        // Set search container
//        PortletURL iteratorURL = PortletURLUtil.getCurrent(renderRequest, renderResponse);
//
//        SearchContainer<WorkFromHome> wfhSC = new SearchContainer<>(
//                renderRequest,
//                iteratorURL,
//                null,
//                "No Work From Home requests found!"
//        );
//
//        wfhSC.setDeltaConfigurable(true);
//
//        // Get data
//        java.util.List<WorkFromHome> list =
//                workFromHomeLocalService.getWorkFromHomes(-1, -1);
//
//        // Correct method
//        wfhSC.setResultsAndTotal(list);
//
//        // Set attributes for JSP
//        renderRequest.setAttribute("wfhSC", wfhSC);
//        renderRequest.setAttribute("count", list.size());
//
//        return AxHrmsWorkFromHomePortletKeys.WFH_LIST_JSP;
//    }
//}
//


//
//package com.ax.hrms.work.from.home.web.employee.action;
//
//import com.ax.hrms.master.service.LeaveCompensatoryStatusMasterLocalService;
//import com.ax.hrms.model.WorkFromHome;
//import com.ax.hrms.master.model.LeaveCompensatoryStatusMaster;
//import com.ax.hrms.service.WorkFromHomeLocalService;
//import com.ax.hrms.work.from.home.web.constants.AxHrmsWorkFromHomePortletKeys;
//import com.ax.hrms.work.from.home.web.employee.dto.WFHRequestDto;
//import com.ax.hrms.work.from.home.web.employee.util.WFHStatusUtil;
//import com.liferay.portal.kernel.dao.search.SearchContainer;
//import com.liferay.portal.kernel.model.User;
//import com.liferay.portal.kernel.portlet.PortletURLUtil;
//import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
//import com.liferay.portal.kernel.service.UserLocalService;
//
//import org.osgi.service.component.annotations.Component;
//import org.osgi.service.component.annotations.Reference;
//
//import javax.portlet.PortletException;
//import javax.portlet.PortletURL;
//import javax.portlet.RenderRequest;
//import javax.portlet.RenderResponse;
//import java.util.ArrayList;
//import java.util.List;
//
/// **
// * Listing WFH Records for Employee
// */
//@Component(
//        property = {
//                "javax.portlet.name=" + AxHrmsWorkFromHomePortletKeys.AXHRMSWORKFROMHOME,
//                "mvc.command.name=/"
//        },
//        service = MVCRenderCommand.class
//)
//public class ListWorkFromHomeRequestMVCRenderCommand implements MVCRenderCommand {
//
//    @Reference
//    private WorkFromHomeLocalService workFromHomeLocalService;
//
//    @Reference
//    private UserLocalService userLocalService;
//
//    @Reference
//    private LeaveCompensatoryStatusMasterLocalService leaveCompensatoryStatusMasterLocalService;
//
//    @Override
//    public String render(RenderRequest renderRequest, RenderResponse renderResponse)
//            throws PortletException {
//
//        // Set search container
//        PortletURL iteratorURL = PortletURLUtil.getCurrent(renderRequest, renderResponse);
//
//        SearchContainer<WFHRequestDto> wfhSC = new SearchContainer<>(
//                renderRequest,
//                iteratorURL,
//                null,
//                "No Work From Home requests found!"
//        );
//
//        wfhSC.setDeltaConfigurable(true);
//
//        // Fetch all WFH entries
//        List<WorkFromHome> wfhListRaw = workFromHomeLocalService.getWorkFromHomes(-1, -1);
//
//        // Fetch all statuses from LeaveCompensatoryStatusMaster
//        List<LeaveCompensatoryStatusMaster> statusList =
//                leaveCompensatoryStatusMasterLocalService.getLeaveCompensatoryStatusMasters(-1, -1);
//
//        // Convert WorkFromHome to DTO
//        List<WFHRequestDto> dtoList = new ArrayList<>();
//        for (WorkFromHome wfh : wfhListRaw) {
//            WFHRequestDto dto = new WFHRequestDto();
//            dto.setWorkFromHomeRequestId(wfh.getWorkFromHomeRequestId());
//
//            User user = userLocalService.fetchUser(wfh.getUserId());
//            dto.setEmployeeName(user != null ? user.getFullName() : "");
//
//            dto.setTeamMailId(wfh.getTeamMailId());
//            dto.setReason(wfh.getReason());
//            dto.setRequestDate(wfh.getRequestDate());
//            dto.setStartDate(wfh.getStartDate());
//            dto.setEndDate(wfh.getEndDate());
//
//            // Resolve status name using LeaveCompensatoryStatusMaster
//            dto.setStatus(WFHStatusUtil.getStatusNameById(wfh.getStatus(), statusList));
//
//            dtoList.add(dto);
//        }
//
//        // Bind DTO list to SearchContainer
//        wfhSC.setResultsAndTotal(() -> dtoList, dtoList.size());
//
//        // Set attributes for JSP
//        renderRequest.setAttribute("wfhSC", wfhSC);
//        renderRequest.setAttribute("count", dtoList.size());
//
//        return AxHrmsWorkFromHomePortletKeys.WFH_LIST_JSP;
//    }
//}


package com.ax.hrms.work.from.home.web.employee.action;

import com.ax.hrms.exception.NoSuchEmployeeDetailsException;
import com.ax.hrms.master.model.LeaveCompensatoryStatusMaster;
import com.ax.hrms.master.service.LeaveCompensatoryStatusMasterLocalService;
import com.ax.hrms.model.EmployeeDetails;
import com.ax.hrms.model.WorkFromHomeRequest;
import com.ax.hrms.service.EmployeeDetailsLocalService;
import com.ax.hrms.service.WorkFromHomeRequestLocalService;
import com.ax.hrms.work.from.home.web.constants.AxHrmsWorkFromHomePortletKeys;
import com.ax.hrms.work.from.home.web.employee.dto.WFHRequestDto;
import com.ax.hrms.work.from.home.web.employee.util.WFHStatusUtil;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.PortletURLUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.PortletException;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import java.util.ArrayList;
import java.util.List;

@Component(property = {"javax.portlet.name=" + AxHrmsWorkFromHomePortletKeys.AXHRMSWORKFROMHOME, "mvc.command.name=/"}, service = MVCRenderCommand.class)
public class ListWorkFromHomeRequestMVCRenderCommand implements MVCRenderCommand {
Log log = LogFactoryUtil.getLog(ListWorkFromHomeRequestMVCRenderCommand.class.getName());
    @Reference
    private WorkFromHomeRequestLocalService workFromHomeRequestLocalService;

    @Reference
    private UserLocalService userLocalService;

    @Reference
    private LeaveCompensatoryStatusMasterLocalService leaveCompensatoryStatusMasterLocalService;

    @Reference
    EmployeeDetailsLocalService employeeDetailsLocalService;


    @Override
    public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
        ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
        // Setup SearchContainer
        PortletURL iteratorURL = PortletURLUtil.getCurrent(renderRequest, renderResponse);

        SearchContainer<WFHRequestDto> wfhSC = new SearchContainer<>(renderRequest, iteratorURL, null, "no-wfh-request-found");

        // Create iterator URL
        long userId = themeDisplay.getUserId();
        EmployeeDetails employee;
        int total = 0;
        try {
            employee = employeeDetailsLocalService.findByLrUserId(userId);
             total =
                    workFromHomeRequestLocalService
                            .countByEmployeeId(employee.getEmployeeId());
            // Pagination values
            int cur = ParamUtil.getInteger(renderRequest, SearchContainer.DEFAULT_CUR_PARAM, 1);
            int delta = ParamUtil.getInteger(renderRequest, SearchContainer.DEFAULT_DELTA_PARAM, 20);

//        int total = workFromHomeRequestLocalService.getWorkFromHomeRequestsCount();



            int start = (cur - 1) * delta;
            int end = start + delta;

            if (start >= total) {
                start = 0;
                end = wfhSC.getDelta();
            }

            // Get employee details for logged-in user
//        EmployeeDetails employeeDetail = null;
//        try {
//            employeeDetail = employeeDetailsLocalService.findByLrUserId(userId);
//        } catch (NoSuchEmployeeDetailsException e) {
//            throw new RuntimeException(e);
//        }
            // Fetch paginated WFH records
//        List<WorkFromHomeRequest> wfhList = workFromHomeRequestLocalService.getWorkFromHomeRequests(start, end);
            List<WorkFromHomeRequest> wfhList = workFromHomeRequestLocalService.findByEmployeeId(employee.getEmployeeId(), start, end);
            // Fetch all statuses
//         total =wfhList.size();

            List<LeaveCompensatoryStatusMaster> statusList = leaveCompensatoryStatusMasterLocalService.getLeaveCompensatoryStatusMasters(-1, -1);

            List<WFHRequestDto> dtoList = new ArrayList<>();

            // Convert to DTO
            for (WorkFromHomeRequest wfh : wfhList) {

//            User user = userLocalService.fetchUser(wfh.getUserId());
                EmployeeDetails employeeDetails = employeeDetailsLocalService.fetchEmployeeDetails(wfh.getEmployeeId());
                WFHRequestDto dto = new WFHRequestDto();
                dto.setWorkFromHomeRequestId(wfh.getWorkFromHomeRequestId());
                dto.setEmployeeName(employeeDetails != null ? employeeDetails.getFirstName() + " " + employeeDetails.getLastName() : "");
                dto.setTeamMailId(wfh.getTeamMailId());
                dto.setReason(wfh.getReason());
                dto.setRequestDate(wfh.getRequestDate());
                dto.setStartDate(wfh.getStartDate());
                dto.setEndDate(wfh.getEndDate());
                dto.setStatus(WFHStatusUtil.getStatusNameById(wfh.getStatus(), statusList));
                try {
                    EmployeeDetails modifiedByEmployeeDetails = employeeDetailsLocalService.findByLrUserId(wfh.getModifiedBy());
                    dto.setModifiedBy(modifiedByEmployeeDetails.getFirstName() + " " + modifiedByEmployeeDetails.getLastName());
                }catch (NoSuchEmployeeDetailsException noSuchEmployeeDetailsException){
                    log.error("noSuchEmployeeDetailsException "+noSuchEmployeeDetailsException.getMessage());
                }
                dtoList.add(dto);
            }


            wfhSC.setDelta(delta);
            wfhSC.setDeltaConfigurable(true);
//        wfhSC.setResultsAndTotal(
//                () -> dtoList,
//                total
//        );
            wfhSC.setResultsAndTotal(() -> dtoList,  // supplier
                    total           // correct total count
            );
            // Set attributes for JSP
            renderRequest.setAttribute("wfhSC", wfhSC);
            renderRequest.setAttribute("totalWFHRequest", total);
            renderRequest.setAttribute("delta", delta);
        } catch (NoSuchEmployeeDetailsException e) {

            log.info("No employee Details are exists for this user."+ e.getMessage());
        }


        return AxHrmsWorkFromHomePortletKeys.WFH_LIST_JSP;
    }
}
