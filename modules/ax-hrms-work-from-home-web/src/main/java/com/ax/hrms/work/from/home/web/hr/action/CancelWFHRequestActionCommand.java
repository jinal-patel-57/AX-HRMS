package com.ax.hrms.work.from.home.web.hr.action;

import com.ax.hrms.master.model.LeaveCompensatoryStatusMaster;
import com.ax.hrms.master.service.LeaveCompensatoryStatusMasterLocalService;
import com.ax.hrms.model.WorkFromHome;
import com.ax.hrms.service.WorkFromHomeLocalService;

import com.ax.hrms.work.from.home.web.constants.AxHrmsWorkFromHomePortletKeys;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.servlet.SessionErrors;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.List;

@Component(
        property = {
                "javax.portlet.name=" + AxHrmsWorkFromHomePortletKeys.AXHRMSWORKFROMHOMEHR,
                "mvc.command.name=/wfh/cancel"
        },
        service = MVCActionCommand.class
)
public class CancelWFHRequestActionCommand implements MVCActionCommand {


    @Reference
    private WorkFromHomeLocalService workFromHomeLocalService;

    @Reference
    private LeaveCompensatoryStatusMasterLocalService leaveStatusLocalService;

    @Override
    public boolean processAction(ActionRequest request, ActionResponse response)
            throws PortletException {

        try {
            long wfhId = Long.parseLong(request.getParameter("wfhId"));

            WorkFromHome wfh = workFromHomeLocalService.fetchWorkFromHome(wfhId);

            if (wfh == null) {
                SessionErrors.add(request, "wfhNotFound");
                return false;
            }

            // 🔥 Fetch all statuses
            List<LeaveCompensatoryStatusMaster> statusList =
                    leaveStatusLocalService.getLeaveCompensatoryStatusMasters(-1, -1);

            // 🔥 Find CANCELLED/REJECTED ID (rename if needed)
            long cancelledId = statusList.stream()
                    .filter(s -> "Canceled".equalsIgnoreCase(s.getLeaveCompensatoryStatus()))
                    .map(LeaveCompensatoryStatusMaster::getLeaveCompensatoryStatusMasterId)
                    .findFirst()
                    .orElse(0L);

            if (cancelledId == 0) {
                SessionErrors.add(request, "statusNotFound");
                return false;
            }

            // 🔥 Update WFH status
            wfh.setStatus(cancelledId);
            workFromHomeLocalService.updateWorkFromHome(wfh);

            SessionMessages.add(request, "wfhCancelled");

        } catch (Exception e) {
            SessionErrors.add(request, "cancelError");
        }

        return true;
    }
}
