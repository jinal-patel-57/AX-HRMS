package com.ax.hrms.master.leave.type.web.action;

import com.ax.hrms.master.model.LeaveTypeMaster;
import com.ax.hrms.master.service.LeaveTypeMasterLocalService;
import com.ax.hrms.master.web.constants.AxHrmsLeaveTypeMasterWebPortletConstants;
import com.ax.hrms.master.web.constants.AxHrmsLeaveTypeMasterWebPortletKeys;
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
 * @category Master Data : Leave Type Master Data Process like list out all the leave type
 */
@Component(
        immediate = true,
        property = {
                "javax.portlet.name=" + AxHrmsLeaveTypeMasterWebPortletKeys.AXHRMS_LEAVE_TYPE_MASTER_WEB_PORTLET_KEYS,
                "mvc.command.name="+ AxHrmsLeaveTypeMasterWebPortletConstants.DEFAULT_JSP_PATH
        },
        service = MVCRenderCommand.class
)
public class ListLeaveTypeMasterMVCRenderCommand implements MVCRenderCommand {

    private static final Log log = LogFactoryUtil.getLog(ListLeaveTypeMasterMVCRenderCommand.class);

    @Reference
    private LeaveTypeMasterLocalService leaveTypeMasterLocalService;

    @Override
    public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
        List<LeaveTypeMaster> leaveTypeMasterList = null;

        int curValue = ParamUtil.getInteger(renderRequest, SearchContainer.DEFAULT_CUR_PARAM,1);
        int deltaValue = ParamUtil.getInteger(renderRequest, SearchContainer.DEFAULT_DELTA_PARAM,3);

        int totalLeaveTypeMaster = leaveTypeMasterLocalService.getLeaveTypeMastersCount();
        int totalPageContainer = (totalLeaveTypeMaster + deltaValue - 1) / deltaValue;

        if (curValue > totalPageContainer) {
            curValue = totalPageContainer;
        }

        int start = (curValue - 1) * deltaValue;
        int end = start + deltaValue;

        log.info("ListLeaveTypeMasterMVCRenderCommand >>> render ::: Leave Master Default List render");

        leaveTypeMasterList = leaveTypeMasterLocalService.getLeaveTypeMasters(start,end);
        renderRequest.setAttribute(AxHrmsLeaveTypeMasterWebPortletConstants.TOTAL_LEAVE_TYPE_MASTER, totalLeaveTypeMaster);
        renderRequest.setAttribute(SearchContainer.DEFAULT_DELTA_PARAM, deltaValue);
        renderRequest.setAttribute(AxHrmsLeaveTypeMasterWebPortletConstants.LEAVE_TYPE_MASTER_LIST_VAR, leaveTypeMasterList);
        renderRequest.setAttribute(AxHrmsLeaveTypeMasterWebPortletConstants.ITERATOR_URL_VARIMPLE_NAME, renderResponse.createRenderURL());

        return AxHrmsLeaveTypeMasterWebPortletConstants.LIST_OF_LEAVE_TYPE_MASTER_JSP_PATH;
    }
}
