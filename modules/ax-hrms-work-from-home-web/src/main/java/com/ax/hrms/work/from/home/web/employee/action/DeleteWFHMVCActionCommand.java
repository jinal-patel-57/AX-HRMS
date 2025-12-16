package com.ax.hrms.work.from.home.web.employee.action;

import com.ax.hrms.service.WorkFromHomeLocalService;
import com.ax.hrms.work.from.home.web.constants.AxHrmsWorkFromHomePortletKeys;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
        property = {
                "javax.portlet.name=" + AxHrmsWorkFromHomePortletKeys.AXHRMSWORKFROMHOME,
                "mvc.command.name=/deleteWFH"
        },
        service = MVCActionCommand.class
)
public class DeleteWFHMVCActionCommand extends BaseMVCActionCommand {

    @Reference
    private WorkFromHomeLocalService workFromHomeLocalService;

    @Override
    protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {

        long wfhId = ParamUtil.getLong(actionRequest, "workFromHomeRequestId");

        if (wfhId > 0) {
            workFromHomeLocalService.deleteWorkFromHome(wfhId);

            // success message
            SessionMessages.add(actionRequest, "delete-success");
        }

        // Hide default error message
        SessionMessages.add(actionRequest, PortalUtil.getPortletId(actionRequest) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
    }
}
