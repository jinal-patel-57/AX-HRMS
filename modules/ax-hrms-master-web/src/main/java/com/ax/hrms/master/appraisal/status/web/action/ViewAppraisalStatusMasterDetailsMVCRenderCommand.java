package com.ax.hrms.master.appraisal.status.web.action;


import com.ax.hrms.master.model.AppraisalStatusMaster;
import com.ax.hrms.master.service.AppraisalStatusMasterLocalService;
import com.ax.hrms.master.web.constants.AxHrmsAppraisalStatusMasterConstants;
import com.ax.hrms.master.web.constants.AxHrmsMasterWebPortletKeys;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

/**
 * Author: Nivid Koradiya
 */
@Component(
        property = {
                "javax.portlet.name=" + AxHrmsMasterWebPortletKeys.AX_HRMS_APPRAISAL_STATUS_MASTER_WEB_PORTLET,
                "mvc.command.name=/viewAppraisalStatusMaster"
        },
        service = MVCRenderCommand.class
)
public class ViewAppraisalStatusMasterDetailsMVCRenderCommand implements MVCRenderCommand {

    @Reference
    AppraisalStatusMasterLocalService appraisalStatusMasterLocalService;

    @Override
    public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
        Log log = LogFactoryUtil.getLog(AppraisalStatusMasterLocalService.class);

        long appraisalStatusMasterId = ParamUtil.getLong(renderRequest, AxHrmsAppraisalStatusMasterConstants.APPRAISAL_STATUS_MASTER_ID);
        AppraisalStatusMaster appraisalStatusMaster = null;
        try {
            appraisalStatusMaster = appraisalStatusMasterLocalService.getAppraisalStatusMaster(appraisalStatusMasterId);
        } catch (PortalException e) {
            log.error("Failed to get appraisal status master");
        }
        renderRequest.setAttribute(AxHrmsAppraisalStatusMasterConstants.APPRAISAL_STATUS_MASTER, appraisalStatusMaster);
        return AxHrmsAppraisalStatusMasterConstants.APPRAISAL_STATUS_MASTER_VIEW_JSP;

    }
}
