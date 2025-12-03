package com.ax.hrms.pip.program.web.actions;

import com.ax.hrms.master.service.DocumentTypeMasterLocalService;
import com.ax.hrms.model.EmployeeDetails;
import com.ax.hrms.model.PipProgram;
import com.ax.hrms.pip.program.web.constants.AxHrmsPipProgramWebPortletKeys;
import com.ax.hrms.pip.program.web.dto.PipProgramEmployeeDto;
import com.ax.hrms.service.EmployeeDetailsLocalService;
import com.ax.hrms.service.PipProgramLocalService;
import com.ax.hrms.service.PipProgramLocalServiceUtil;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.PortletURLUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.PortletException;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * @author keval.kathiriya
 */

@Component(immediate = true, property = {

        "javax.portlet.name=" + AxHrmsPipProgramWebPortletKeys.AX_HRMS_PIP_PROGRAM_WEB,
        "mvc.command.name=/extendPipProgram"
}, service = MVCRenderCommand.class)


public class ExtendPipProgramMVCRenderCommand implements MVCRenderCommand {

    private static final Log log = LogFactoryUtil.getLog(ExtendPipProgramMVCRenderCommand.class);
    @Reference
    DocumentTypeMasterLocalService documentTypeMasterLocalService;

    @Reference
    PipProgramLocalService pipProgramLocalService;

    @Reference
    EmployeeDetailsLocalService employeeDetailsLocalService;

    @Override
    public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
        long pipProgramId = ParamUtil.getLong(renderRequest,"pipProgramId");
        try {
            PipProgram pipProgram = pipProgramLocalService.getPipProgram(pipProgramId);
            EmployeeDetails employeeDetails =  employeeDetailsLocalService.getEmployeeDetails(pipProgram.getEmployeeId());
            renderRequest.setAttribute("pipProgram", pipProgram);
            renderRequest.setAttribute("employeeName", employeeDetails.getFirstName()  + " " + employeeDetails.getLastName());
        } catch (PortalException e) {
            log.error("ERROR Getting PIP DETAILS FROM DB");
        }
        return "/jsp/addPipProgramForm.jsp";
    }

}
