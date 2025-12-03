package com.ax.hrms.master.priority.web.action;

import com.ax.hrms.master.model.PriorityMaster;
import com.ax.hrms.master.service.PriorityMasterLocalService;
import com.ax.hrms.master.web.constants.AxHrmsMasterWebPortletKeys;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import java.util.List;

/**
 * 
 * @author krish.moradiya
 * @category Master Table : Priority for list of all priorities
 */
@Component(
        immediate = true,
        property = {
                "javax.portlet.name=" + AxHrmsMasterWebPortletKeys.AXHRMS_PRIORITY_MASTER_WEB_PORTLET_KEYS,
                "mvc.command.name=/"
        },
        service = MVCRenderCommand.class
)
public class ListPriorityMasterMVCRenderCommand implements MVCRenderCommand {

    private static final Log log = LogFactoryUtil.getLog(ListPriorityMasterMVCRenderCommand.class);

    @Reference
    private PriorityMasterLocalService priorityMasterLocalService;

    @Override
    public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
        List<PriorityMaster> priorityMastersList = null;

        int curValue = ParamUtil.getInteger(renderRequest, SearchContainer.DEFAULT_CUR_PARAM,1);
        int deltaValue = ParamUtil.getInteger(renderRequest, SearchContainer.DEFAULT_DELTA_PARAM,3);

        int totalPriorityMaster = priorityMasterLocalService.getPriorityMastersCount();
        int totalPageContainer = (totalPriorityMaster + deltaValue - 1) / deltaValue;

        if (curValue > totalPageContainer) {
            curValue = totalPageContainer;
        }

        int start = (curValue - 1) * deltaValue;
        int end = start + deltaValue;

        log.info("ListPriorityMasterMVCRenderCommand >>> render ::: Priority Master Default List render");

        priorityMastersList = priorityMasterLocalService.getPriorityMasters(start,end);
        renderRequest.setAttribute("totalPriorityMaster", totalPriorityMaster);
        renderRequest.setAttribute(SearchContainer.DEFAULT_DELTA_PARAM, deltaValue);
        renderRequest.setAttribute("priorityMasterList", priorityMastersList);
        renderRequest.setAttribute("iteratorURL", renderResponse.createRenderURL());

        return "/jsp/priority-master/listPriorityMaster.jsp";
    }
}
