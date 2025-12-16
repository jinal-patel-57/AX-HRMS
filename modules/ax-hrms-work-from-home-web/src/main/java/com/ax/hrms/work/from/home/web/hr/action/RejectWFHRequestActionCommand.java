package com.ax.hrms.work.from.home.web.hr.action;

import com.ax.hrms.model.WorkFromHome;
import com.ax.hrms.service.WorkFromHomeLocalService;
import com.ax.hrms.master.model.LeaveCompensatoryStatusMaster;
import com.ax.hrms.master.service.LeaveCompensatoryStatusMasterLocalService;
import com.ax.hrms.work.from.home.web.constants.AxHrmsWorkFromHomePortletKeys;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.ParamUtil;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
        immediate = true,
        property = {
                "javax.portlet.name=" + AxHrmsWorkFromHomePortletKeys.AXHRMSWORKFROMHOMEHR,
                "mvc.command.name=/wfh/reject"
        },
        service = MVCActionCommand.class
)
public class RejectWFHRequestActionCommand implements MVCActionCommand {

    @Reference
    private WorkFromHomeLocalService workFromHomeLocalService;

    @Reference
    private LeaveCompensatoryStatusMasterLocalService leaveStatusLocalService;

    @Override
    public boolean processAction(ActionRequest actionRequest, ActionResponse actionResponse)
            throws PortletException {

        try {
            long wfhId = ParamUtil.getLong(actionRequest, "wfhId");

            WorkFromHome wfh = workFromHomeLocalService.fetchWorkFromHome(wfhId);

            if (wfh == null) {
                SessionErrors.add(actionRequest, "wfh-error");
                return false;
            }

            // Fetch all statuses from master table
            java.util.List<LeaveCompensatoryStatusMaster> statusList =
                    leaveStatusLocalService.getLeaveCompensatoryStatusMasters(-1, -1);

            // Find REJECTED status ID
            long rejectedId = statusList.stream()
                    .filter(s -> "Rejected".equalsIgnoreCase(s.getLeaveCompensatoryStatus()))
                    .map(LeaveCompensatoryStatusMaster::getLeaveCompensatoryStatusMasterId)
                    .findFirst()
                    .orElse(0L);

            if (rejectedId == 0) {
                SessionErrors.add(actionRequest, "wfh-error");
                return false;
            }

            // Update the status
            wfh.setStatus(rejectedId);
            workFromHomeLocalService.updateWorkFromHome(wfh);

            // Success message (matches your JSP)
            SessionMessages.add(actionRequest, "wfh-rejected");

        } catch (Exception e) {
            e.printStackTrace();
            SessionErrors.add(actionRequest, "wfh-error");
        }

        return true;
    }
}
