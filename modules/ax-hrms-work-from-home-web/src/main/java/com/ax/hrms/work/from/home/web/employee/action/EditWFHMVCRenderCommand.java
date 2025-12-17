package com.ax.hrms.work.from.home.web.employee.action;

import com.ax.hrms.model.WorkFromHome;
import com.ax.hrms.service.WorkFromHomeLocalService;
import com.ax.hrms.work.from.home.web.constants.AxHrmsWorkFromHomePortletKeys;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

@Component(
        property = {
                "javax.portlet.name=" + AxHrmsWorkFromHomePortletKeys.AXHRMSWORKFROMHOME,
                "mvc.command.name=/editWFHForm"
        },
        service = MVCRenderCommand.class
)
public class EditWFHMVCRenderCommand implements MVCRenderCommand {

    @Reference
    private WorkFromHomeLocalService workFromHomeLocalService;

    @Override
    public String render(RenderRequest renderRequest, RenderResponse renderResponse) {
            System.out.println("Hello in the render");
        long wfhId = ParamUtil.getLong(renderRequest, "workFromHomeRequestId");

        if (wfhId > 0) {
            WorkFromHome wfh = workFromHomeLocalService.fetchWorkFromHome(wfhId);
            renderRequest.setAttribute("wfh", wfh);
        }

        return "/jsp/ax-hrms-work-from-home-employee/add_edit_work_from_home.jsp";
    }
}
