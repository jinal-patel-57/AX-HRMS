package com.ax.hrms.master.template.level.web.action;


import com.ax.hrms.master.model.TemplateLevelMaster;
import com.ax.hrms.master.service.TemplateLevelMasterLocalService;
import com.ax.hrms.master.service.TemplateLevelMasterLocalServiceUtil;
import com.ax.hrms.master.web.constants.AxHrmsMasterWebPortletKeys;
import com.ax.hrms.master.web.constants.AxHrmsTemplateLevelMasterConstants;
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
                "javax.portlet.name=" + AxHrmsMasterWebPortletKeys.AX_HRMS_TEMPLATE_LEVEL_MASTER_WEB_PORTLET,
                "mvc.command.name=/"
        },
        service = MVCRenderCommand.class
)
public class ListTemplateLevelMasterMVCRenderCommand implements MVCRenderCommand {

    @Reference
    TemplateLevelMasterLocalService templateLevelMasterLocalService;

    @Override
    public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {


        //setting search container
        PortletURL iteratorURL = PortletURLUtil.getCurrent(renderRequest, renderResponse);
        SearchContainer<TemplateLevelMaster> customerOrderSearchContainer = new SearchContainer<>(renderRequest, iteratorURL,
                null, StringPool.BLANK); // New search container
        customerOrderSearchContainer.setEmptyResultsMessage(AxHrmsTemplateLevelMasterConstants.NO_TEMPLATE_LEVEL_MASTER);
        customerOrderSearchContainer.setDeltaConfigurable(true); // Setting the delta configurable to true
        customerOrderSearchContainer.setResultsAndTotal(templateLevelMasterLocalService.getTemplateLevelMasters(-1,-1)); // Loading all records on the Search Container
        renderRequest.setAttribute(AxHrmsTemplateLevelMasterConstants.TEMPLATE_LEVEL_MASTER_SC, customerOrderSearchContainer);
        renderRequest.setAttribute(AxHrmsTemplateLevelMasterConstants.COUNT, TemplateLevelMasterLocalServiceUtil.getTemplateLevelMastersCount());
        // END setting search container

        return  AxHrmsTemplateLevelMasterConstants.TEMPLATE_LEVEL_MASTER_LIST_JSP;
    }
}
