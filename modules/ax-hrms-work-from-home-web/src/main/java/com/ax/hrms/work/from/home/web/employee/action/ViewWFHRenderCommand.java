
package com.ax.hrms.work.from.home.web.employee.action;

import com.ax.hrms.master.model.LeaveCompensatoryStatusMaster;
import com.ax.hrms.master.service.LeaveCompensatoryStatusMasterLocalService;
import com.ax.hrms.model.EmployeeDetails;
import com.ax.hrms.model.WorkFromHomeRequest;
import com.ax.hrms.service.EmployeeDetailsLocalService;
import com.ax.hrms.service.WorkFromHomeDayTypeLocalService;
import com.ax.hrms.service.WorkFromHomeRequestLocalService;
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

    @Reference
    private WorkFromHomeRequestLocalService  workFromHomeRequestLocalService;

    @Reference
    private EmployeeDetailsLocalService  employeeDetailsLocalService;

    @Reference
    private WorkFromHomeDayTypeLocalService workFromHomeDayTypeLocalService;

    @Override
    public String render(RenderRequest request, RenderResponse response) {

        long wfhId = ParamUtil.getLong(request, "workFromHomeRequestId");

        if (Validator.isNotNull(wfhId)) {

            WorkFromHomeRequest wfh = workFromHomeRequestLocalService.fetchWorkFromHomeRequest(wfhId);

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

                EmployeeDetails employeeDetails=employeeDetailsLocalService.fetchEmployeeDetails(wfh.getEmployeeId());

                String statusName = WFHStatusUtil.getStatusNameById(statusId, statusList);

                // ---------- BUILD DTO ----------
                WFHRequestDto dto = new WFHRequestDto();
                dto.setEmployeeName(employeeDetails.getFirstName()+" "+employeeDetails.getLastName());
                dto.setWorkFromHomeRequestId(wfh.getWorkFromHomeRequestId());
                String teamMail = wfh.getTeamMailId();

                if (teamMail != null) {
                    teamMail = teamMail.replaceAll("\\s*,\\s*", ", ");
                }
                dto.setTeamMailId(teamMail);
                dto.setStatus(statusName);
                dto.setReason(wfh.getReason());
                dto.setRequestDate(wfh.getRequestDate());
                dto.setStartDate(wfh.getStartDate());
                dto.setEndDate(wfh.getEndDate());
                dto.setEmployeeOfficialMailId(employeeDetails.getOfficialEmail());
                WFHStatusUtil.setWorkFromHomeDayTypeData(dto,workFromHomeDayTypeLocalService);
                request.setAttribute("wfh", dto);
            }
        }

        return "/jsp/ax-hrms-work-from-home-employee/view_work_from_home.jsp";
    }
}
