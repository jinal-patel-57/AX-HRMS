//package com.ax.hrms.work.from.home.web.hr.action;
//
//import com.ax.hrms.model.WorkFromHome;
//import com.ax.hrms.service.WorkFromHomeLocalService;
//import com.ax.hrms.work.from.home.web.constants.AxHrmsWorkFromHomePortletKeys;
//import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
//
//import javax.portlet.PortletException;
//import javax.portlet.RenderRequest;
//import javax.portlet.RenderResponse;
//
//import org.osgi.service.component.annotations.Component;
//import org.osgi.service.component.annotations.Reference;
//
//@Component(
//        property = {
//                "javax.portlet.name=" + AxHrmsWorkFromHomePortletKeys.AXHRMSWORKFROMHOMEHR,
//                "mvc.command.name=/wfh/view"
//        },
//        service = MVCRenderCommand.class
//)
//public class ViewWFHHRRenderCommand implements MVCRenderCommand {
//
//    @Reference
//    private WorkFromHomeLocalService workFromHomeLocalService;
//
//    @Override
//    public String render(RenderRequest request, RenderResponse response) throws PortletException {
//
//        long wfhId = Long.parseLong(request.getParameter("wfhId"));
//
//        WorkFromHome wfh = workFromHomeLocalService.fetchWorkFromHome(wfhId);
//        request.setAttribute("wfh", wfh);
//
//        return "/jsp/ax-hrms-work-from-home-hr/view_work_from_home.jsp";
//    }
//}



































package com.ax.hrms.work.from.home.web.hr.action;

import com.ax.hrms.model.WorkFromHome;
import com.ax.hrms.service.WorkFromHomeLocalService;
import com.ax.hrms.work.from.home.web.constants.AxHrmsWorkFromHomePortletKeys;
import com.ax.hrms.work.from.home.web.hr.dto.WFHRequestDto;
import com.ax.hrms.master.model.LeaveCompensatoryStatusMaster;
import com.ax.hrms.master.service.LeaveCompensatoryStatusMasterLocalService;
import com.ax.hrms.work.from.home.web.employee.util.WFHStatusUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.List;

@Component(
        property = {
                "javax.portlet.name=" + AxHrmsWorkFromHomePortletKeys.AXHRMSWORKFROMHOMEHR,
                "mvc.command.name=/wfh/view"
        },
        service = MVCRenderCommand.class
)
public class ViewWFHHRRenderCommand implements MVCRenderCommand {

    @Reference
    private WorkFromHomeLocalService workFromHomeLocalService;

    @Reference
    private LeaveCompensatoryStatusMasterLocalService leaveStatusLocalService;

    @Override
    public String render(RenderRequest request, RenderResponse response) throws PortletException {

        long wfhId = Long.parseLong(request.getParameter("wfhId"));

        WorkFromHome wfh = workFromHomeLocalService.fetchWorkFromHome(wfhId);

        if (wfh != null) {

            // Convert Entity → DTO
            WFHRequestDto dto = new WFHRequestDto();

            dto.setWorkFromHomeRequestId(wfh.getWorkFromHomeRequestId());
            dto.setTeamMailId(wfh.getTeamMailId());
            dto.setReason(wfh.getReason());
            dto.setRequestDate(wfh.getRequestDate());
            dto.setStartDate(wfh.getStartDate());
            dto.setEndDate(wfh.getEndDate());

            // Get all status values
            List<LeaveCompensatoryStatusMaster> statusList =
                    leaveStatusLocalService.getLeaveCompensatoryStatusMasters(-1, -1);

            // Convert status ID → Name using util
            String readableStatus = WFHStatusUtil.getStatusNameById(wfh.getStatus(), statusList);

            dto.setStatus(readableStatus);

            // Put DTO in request
            request.setAttribute("wfh", dto);
        }

        return "/jsp/ax-hrms-work-from-home-hr/view_work_from_home.jsp";
    }
}