package com.ax.hrms.work.from.home.web.hr.action;

import com.ax.hrms.master.model.LeaveCompensatoryStatusMaster;
import com.ax.hrms.master.service.LeaveCompensatoryStatusMasterLocalService;
import com.ax.hrms.model.EmployeeDetails;
import com.ax.hrms.model.WorkFromHomeRequest;
import com.ax.hrms.service.EmployeeDetailsLocalService;
import com.ax.hrms.service.WorkFromHomeDayTypeLocalService;
import com.ax.hrms.service.WorkFromHomeRequestLocalService;
import com.ax.hrms.work.from.home.web.constants.AxHrmsWorkFromHomePortletKeys;
import com.ax.hrms.work.from.home.web.hr.dto.WFHRequestDto;
import com.ax.hrms.work.from.home.web.hr.util.WFHStatusUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
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
    private WorkFromHomeRequestLocalService workFromHomeRequestLocalService;

    @Reference
    private LeaveCompensatoryStatusMasterLocalService leaveStatusLocalService;

    @Reference
    private EmployeeDetailsLocalService employeeDetailsLocalService;

    @Reference
    private WorkFromHomeDayTypeLocalService workFromHomeDayTypeLocalService;
    @Override
    public String render(RenderRequest request, RenderResponse response) throws PortletException {

        long wfhId = Long.parseLong(request.getParameter("wfhId"));
        EmployeeDetails employeeDetails=null;
        WorkFromHomeRequest wfh = workFromHomeRequestLocalService.fetchWorkFromHomeRequest(wfhId);
        try {
             employeeDetails=employeeDetailsLocalService.getEmployeeDetails(wfh.getEmployeeId());
        } catch (PortalException e) {
            throw new RuntimeException(e);
        }
        if (wfh != null) {

            // Convert Entity → DTO
            WFHRequestDto dto = new WFHRequestDto();

            dto.setWorkFromHomeRequestId(wfh.getWorkFromHomeRequestId());
            String teamMail = wfh.getTeamMailId();

            if (teamMail != null) {
                teamMail = teamMail.replace(" ,", ",").replace(", ", ",");
            }
            dto.setTeamMailId(teamMail);
            dto.setReason(wfh.getReason());
            dto.setRequestDate(wfh.getRequestDate());
            dto.setStartDate(wfh.getStartDate());
            dto.setEndDate(wfh.getEndDate());
            dto.setEmployeeOfficialMailId(employeeDetails.getOfficialEmail());
            dto.setEmployeeName(employeeDetails.getFirstName()+" "+employeeDetails.getLastName());
            // Get all status values
            List<LeaveCompensatoryStatusMaster> statusList =
                    leaveStatusLocalService.getLeaveCompensatoryStatusMasters(-1, -1);

            // Convert status ID → Name using util
            String readableStatus = WFHStatusUtil.getStatusNameById(wfh.getStatus(), statusList);
            WFHStatusUtil.setWorkFromHomeDayTypeData(dto,workFromHomeDayTypeLocalService);

            dto.setStatus(readableStatus);



            request.setAttribute("wfh", dto);
        }

        return "/jsp/ax-hrms-work-from-home-hr/view_work_from_home.jsp";
    }
}