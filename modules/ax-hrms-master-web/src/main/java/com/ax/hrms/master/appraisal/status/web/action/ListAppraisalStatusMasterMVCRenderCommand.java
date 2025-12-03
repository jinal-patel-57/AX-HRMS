package com.ax.hrms.master.appraisal.status.web.action;


import com.ax.hrms.master.model.AppraisalStatusMaster;
import com.ax.hrms.master.service.AppraisalStatusMasterLocalService;
import com.ax.hrms.master.service.AppraisalStatusMasterLocalServiceUtil;
import com.ax.hrms.master.service.ProjectTaskStatusMasterLocalServiceUtil;
import com.ax.hrms.master.web.constants.AxHrmsAppraisalStatusMasterConstants;
import com.ax.hrms.master.web.constants.AxHrmsMasterWebPortletKeys;
import com.ax.hrms.master.web.constants.AxHrmsProjectTaskStatusMasterConstants;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.portlet.PortletURLUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.PortletException;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

/**
 * Author: Nivid Koradiya
 */
@Component(
        property = {
                "javax.portlet.name=" + AxHrmsMasterWebPortletKeys.AX_HRMS_APPRAISAL_STATUS_MASTER_WEB_PORTLET,
                "mvc.command.name=/"
        },
        service = MVCRenderCommand.class
)
public class ListAppraisalStatusMasterMVCRenderCommand implements MVCRenderCommand {

    @Reference
    AppraisalStatusMasterLocalService appraisalStatusMasterLocalService;

    @Override
    public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {


        //setting search container
        PortletURL iteratorURL = PortletURLUtil.getCurrent(renderRequest, renderResponse);
        SearchContainer<AppraisalStatusMaster> customerOrderSearchContainer = new SearchContainer<>(renderRequest, iteratorURL,
                null, StringPool.BLANK);
        customerOrderSearchContainer.setEmptyResultsMessage(AxHrmsAppraisalStatusMasterConstants.NO_APPRAISAL_STATUS);
        customerOrderSearchContainer.setDeltaConfigurable(true);
        customerOrderSearchContainer.setResultsAndTotal(appraisalStatusMasterLocalService.getAppraisalStatusMasters(-1,-1));
        renderRequest.setAttribute(AxHrmsAppraisalStatusMasterConstants.APPRAISAL_STATUS_MASTER_SC, customerOrderSearchContainer);
        renderRequest.setAttribute(AxHrmsAppraisalStatusMasterConstants.COUNT, AppraisalStatusMasterLocalServiceUtil.getAppraisalStatusMastersCount());

        // END setting search container
        return AxHrmsAppraisalStatusMasterConstants.APPRAISAL_STATUS_MASTER_LIST_JSP;










    }
}
