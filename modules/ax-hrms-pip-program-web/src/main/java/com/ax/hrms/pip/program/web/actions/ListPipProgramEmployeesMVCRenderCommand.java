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

/**
 * @author keval.kathiriya
 */

@Component(immediate = true, property = {

        "javax.portlet.name=" + AxHrmsPipProgramWebPortletKeys.AX_HRMS_PIP_PROGRAM_WEB,
        "mvc.command.name=/"
}, service = MVCRenderCommand.class)


public class ListPipProgramEmployeesMVCRenderCommand implements MVCRenderCommand {

    private static final Log log = LogFactoryUtil.getLog(ListPipProgramEmployeesMVCRenderCommand.class);
    @Reference
    DocumentTypeMasterLocalService documentTypeMasterLocalService;

    @Reference
    PipProgramLocalService pipProgramLocalService;

    @Reference
    EmployeeDetailsLocalService employeeDetailsLocalService;

    @Override
    public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {


        //setting search container
        PortletURL iteratorURL = PortletURLUtil.getCurrent(renderRequest, renderResponse);
        SearchContainer<PipProgramEmployeeDto> customerOrderSearchContainer = new SearchContainer<>(renderRequest, iteratorURL,
                null, StringPool.BLANK);
        customerOrderSearchContainer.setEmptyResultsMessage("No PIP Program Employees Found!");
        customerOrderSearchContainer.setDeltaConfigurable(true);

        List<PipProgram> pipProgramList = pipProgramLocalService.getPipPrograms(-1, -1);
        List<PipProgramEmployeeDto> pipProgramEmployeeDtosList = new ArrayList<>();
        for (PipProgram pipProgram : pipProgramList) {

            PipProgramEmployeeDto pipProgramEmployeeDto = new PipProgramEmployeeDto();
            pipProgramEmployeeDto.setPipProgramId(pipProgram.getPipProgramId());
            pipProgramEmployeeDto.setStatus(pipProgram.getStatus());
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
            pipProgramEmployeeDto.setStartDate(dateFormat.format(pipProgram.getStartDate()));
            pipProgramEmployeeDto.setEndDate(dateFormat.format(pipProgram.getEndDate()));
            pipProgramEmployeeDto.setMeetingDate(dateFormat.format(pipProgram.getMeetingDate()));
            pipProgramEmployeeDto.setNoOfMonths(pipProgram.getNumberOfMonths());
            try {
                EmployeeDetails employeeDetails = employeeDetailsLocalService.getEmployeeDetails(pipProgram.getEmployeeId());
                pipProgramEmployeeDto.setEmployeeName(employeeDetails.getFirstName() + " " + employeeDetails.getLastName());
            } catch (PortalException e) {
                throw new RuntimeException(e);
            }
            pipProgramEmployeeDtosList.add(pipProgramEmployeeDto);
        }

        customerOrderSearchContainer.setResultsAndTotal(pipProgramEmployeeDtosList);
        renderRequest.setAttribute("pipProgramSC", customerOrderSearchContainer);
        renderRequest.setAttribute("count", PipProgramLocalServiceUtil.getPipProgramsCount());
        return "/jsp/listPipProgramEmployees.jsp";

    }

}
