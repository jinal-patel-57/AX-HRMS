package com.ax.hrms.work.from.home.web.action;



import com.ax.hrms.model.WorkFromHome;
import com.ax.hrms.service.WorkFromHomeLocalService;
import com.ax.hrms.work.from.home.web.constants.AxHrmsWorkFromHomePortletKeys;
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
import java.util.List;

/**
 * Listing WFH Records
 */
@Component(
        property = {
                "javax.portlet.name=" + AxHrmsWorkFromHomePortletKeys.AXHRMSWORKFROMHOME,
                "mvc.command.name=/"
        },
        service = MVCRenderCommand.class
)
public class ListWorkFromHomeRequestMVCRenderCommand implements MVCRenderCommand {

    @Reference
    WorkFromHomeLocalService workFromHomeLocalService;

    @Override
    public String render(RenderRequest renderRequest, RenderResponse renderResponse)
            throws PortletException {

        // Set search container
        PortletURL iteratorURL = PortletURLUtil.getCurrent(renderRequest, renderResponse);

        SearchContainer<WorkFromHome> wfhSC = new SearchContainer<>(
                renderRequest,
                iteratorURL,
                null,
                "No Work From Home requests found!"
        );

        wfhSC.setDeltaConfigurable(true);

        // Get data
        java.util.List<WorkFromHome> list =
                workFromHomeLocalService.getWorkFromHomes(-1, -1);

        // Correct method
        wfhSC.setResultsAndTotal(list);

        // Set attributes for JSP
        renderRequest.setAttribute("wfhSC", wfhSC);
        renderRequest.setAttribute("count", list.size());

        return AxHrmsWorkFromHomePortletKeys.WFH_LIST_JSP;
    }
}

