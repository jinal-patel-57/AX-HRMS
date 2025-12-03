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
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.PortletException;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author keval.kathiriya
 */

@Component(immediate = true, property = {

        "javax.portlet.name=" + AxHrmsPipProgramWebPortletKeys.AX_HRMS_PIP_PROGRAM_WEB,
        "mvc.command.name=/pipProgramForm"
}, service = MVCRenderCommand.class)


public class PipProgramFormMVCRenderCommand implements MVCRenderCommand {

    private static final Log log = LogFactoryUtil.getLog(PipProgramFormMVCRenderCommand.class);
    @Reference
    DocumentTypeMasterLocalService documentTypeMasterLocalService;

    @Reference
    PipProgramLocalService pipProgramLocalService;

    @Reference
    EmployeeDetailsLocalService employeeDetailsLocalService;

    @Override
    public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {

        log.info("FORM JSP LOADING >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        List<EmployeeDetails> employeeList = employeeDetailsLocalService.getEmployeeDetailses(-1,-1);
        List<EmployeeDetails> filteredEmployeeList = employeeList.stream()
                .filter(employee -> !employee.getIsTerminated())
                .collect(Collectors.toList());
        renderRequest.setAttribute("employeeList", filteredEmployeeList);
        return "/jsp/addPipProgramForm.jsp";

    }

}
