package com.ax.hrms.work.from.home.web.employee.action;

import com.ax.hrms.model.WorkFromHomeRequest;
import com.ax.hrms.service.WorkFromHomeRequestLocalService;
import com.ax.hrms.work.from.home.web.constants.AxHrmsWorkFromHomePortletKeys;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
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

    private static final Log log = LogFactoryUtil.getLog(EditWFHMVCRenderCommand.class);

    @Reference
    private WorkFromHomeRequestLocalService workFromHomeRequestLocalService;

    @Override
    public String render(RenderRequest renderRequest, RenderResponse renderResponse) {
            log.info("Hello in the render");
        long wfhId = ParamUtil.getLong(renderRequest, "workFromHomeRequestId");

        if (wfhId > 0) {
            WorkFromHomeRequest wfh = workFromHomeRequestLocalService.fetchWorkFromHomeRequest(wfhId);
            renderRequest.setAttribute("wfh", wfh);
        }

        return "/jsp/ax-hrms-work-from-home-employee/add_edit_work_from_home.jsp";
    }
}
