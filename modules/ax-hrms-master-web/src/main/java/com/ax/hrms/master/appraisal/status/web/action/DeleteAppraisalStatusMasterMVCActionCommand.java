package com.ax.hrms.master.appraisal.status.web.action;


import com.ax.hrms.master.service.AppraisalStatusMasterLocalService;
import com.ax.hrms.master.web.constants.AxHrmsAppraisalStatusMasterConstants;
import com.ax.hrms.master.web.constants.AxHrmsMasterWebPortletKeys;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

/**

 Author: Nivid Koradiya
 */
@Component(
        property = {
                "javax.portlet.name=" + AxHrmsMasterWebPortletKeys.AX_HRMS_APPRAISAL_STATUS_MASTER_WEB_PORTLET,
                "mvc.command.name=/deleteAppraisalStatusMasterDetails"
        },
        service = MVCActionCommand.class
)
public class DeleteAppraisalStatusMasterMVCActionCommand extends BaseMVCActionCommand {

    @Reference
    AppraisalStatusMasterLocalService appraisalStatusMasterLocalService;


    @Override
    protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
        long appraisalStatusMasterId = ParamUtil.getLong(actionRequest, AxHrmsAppraisalStatusMasterConstants.APPRAISAL_STATUS_MASTER_ID);
        appraisalStatusMasterLocalService.deleteAppraisalStatusMaster(appraisalStatusMasterId);
        String iteratorURL = ParamUtil.getString(actionRequest, AxHrmsAppraisalStatusMasterConstants.ITERATOR_URL);
        SessionMessages.add(actionRequest, AxHrmsAppraisalStatusMasterConstants.SUCCESS_DELETE);
        actionResponse.sendRedirect(iteratorURL);
    }
}
