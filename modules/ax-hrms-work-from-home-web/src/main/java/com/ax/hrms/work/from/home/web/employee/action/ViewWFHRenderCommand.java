//package com.ax.hrms.work.from.home.web.employee.action;
//
//import com.ax.hrms.model.WorkFromHome;
//import com.ax.hrms.service.WorkFromHomeLocalServiceUtil;
//import com.ax.hrms.work.from.home.web.constants.AxHrmsWorkFromHomePortletKeys;
//import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
//import com.liferay.portal.kernel.util.ParamUtil;
//import com.liferay.portal.kernel.util.Validator;
//
//import javax.portlet.RenderRequest;
//import javax.portlet.RenderResponse;
//
//import org.osgi.service.component.annotations.Component;
//
//@Component(
//        immediate = true,
//        property = {
//                "javax.portlet.name=" + AxHrmsWorkFromHomePortletKeys.AXHRMSWORKFROMHOME,
//                "mvc.command.name=/viewWFH"
//        },
//        service = MVCRenderCommand.class
//)
//public class ViewWFHRenderCommand implements MVCRenderCommand {
//
//    @Override
//    public String render(RenderRequest request, RenderResponse response) {
//
//        long wfhId = ParamUtil.getLong(request, "workFromHomeRequestId");
//        System.out.println("wfhId = " + wfhId);
//        if (Validator.isNotNull(wfhId)) {
//            WorkFromHome wfh = WorkFromHomeLocalServiceUtil.fetchWorkFromHome(wfhId);
//            System.out.println("wfh = " + wfh);
//            if (wfh != null) {
//                request.setAttribute("wfh", wfh);
//            }
//        }
//
//        return "/jsp/ax-hrms-work-from-home-employee/view_work_from_home.jsp";
//    }
//}









































package com.ax.hrms.work.from.home.web.employee.action;

import com.ax.hrms.master.service.LeaveCompensatoryStatusMasterLocalService;
import com.ax.hrms.model.WorkFromHome;
import com.ax.hrms.master.model.LeaveCompensatoryStatusMaster;
import com.ax.hrms.service.WorkFromHomeLocalServiceUtil;
import com.ax.hrms.work.from.home.web.constants.AxHrmsWorkFromHomePortletKeys;
import com.ax.hrms.work.from.home.web.employee.dto.WFHRequestDto;
import com.ax.hrms.work.from.home.web.employee.util.WFHStatusUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import java.util.List;

@Component(
        immediate = true,
        property = {
                "javax.portlet.name=" + AxHrmsWorkFromHomePortletKeys.AXHRMSWORKFROMHOME,
                "mvc.command.name=/viewWFH"
        },
        service = MVCRenderCommand.class
)
public class ViewWFHRenderCommand implements MVCRenderCommand {

    @Reference
    private LeaveCompensatoryStatusMasterLocalService leaveCompensatoryStatusMasterLocalService;

    @Override
    public String render(RenderRequest request, RenderResponse response) {

        long wfhId = ParamUtil.getLong(request, "workFromHomeRequestId");

        if (Validator.isNotNull(wfhId)) {

            WorkFromHome wfh = WorkFromHomeLocalServiceUtil.fetchWorkFromHome(wfhId);

            if (wfh != null) {

                // ---------- FETCH ALL STATUS MASTER ENTRIES ----------
                List<LeaveCompensatoryStatusMaster> statusList =
                        leaveCompensatoryStatusMasterLocalService.getLeaveCompensatoryStatusMasters(
                                -1, -1
                        );

                // ---------- CONVERT STATUS ID → STATUS NAME ----------
                long statusId = 0;
                try {
                    statusId =wfh.getStatus();
                } catch (Exception ignored) {}

                String statusName = WFHStatusUtil.getStatusNameById(statusId, statusList);

                // ---------- BUILD DTO ----------
                WFHRequestDto dto = new WFHRequestDto();

                dto.setWorkFromHomeRequestId(wfh.getWorkFromHomeRequestId());
                dto.setTeamMailId(wfh.getTeamMailId());
                dto.setStatus(statusName);
                dto.setReason(wfh.getReason());
                dto.setRequestDate(wfh.getRequestDate());
                dto.setStartDate(wfh.getStartDate());
                dto.setEndDate(wfh.getEndDate());

                request.setAttribute("wfh", dto);
            }
        }

        return "/jsp/ax-hrms-work-from-home-employee/view_work_from_home.jsp";
    }
}
