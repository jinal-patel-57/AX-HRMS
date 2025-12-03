package com.ax.hrms.compensatory.web.action;

import com.ax.hrms.compensatory.web.constants.AxHrmsCompensatoryDataConstants;
import com.ax.hrms.compensatory.web.constants.AxHrmsCompensatoryWebPortletKeys;
import com.ax.hrms.compensatory.web.dto.CompensatoryDataDto;
import com.ax.hrms.master.service.EducationLevelMasterLocalService;
import com.ax.hrms.master.service.LeaveCompensatoryStatusMasterLocalService;
import com.ax.hrms.model.CompensatoryData;
import com.ax.hrms.model.EmployeeDetails;
import com.ax.hrms.service.*;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Component(immediate = true, property = {"javax.portlet.name=" + AxHrmsCompensatoryWebPortletKeys.AX_HRMS_COMPENSATORY_MANAGER_WEB_PORTLET, "mvc.command.name=/"}, service = MVCRenderCommand.class)
public class ListCompensatoryManagerMVCRenderCommand implements MVCRenderCommand {


    @Reference
    EducationLevelMasterLocalService educationLevelMasterLocalService;

    @Reference
    EmployeeUanEsicLocalService employeeUanEsicLocalService;

    @Reference
    EmployeeDetailsLocalService employeeDetailsLocalService;

    @Reference
    EmployeeAddressLocalService employeeAddressLocalService;

    @Reference
    AddressLocalService addressLocalService;

    @Reference
    EmployeeBankAccountLocalService employeeBankAccountLocalService;

    @Reference
    NomineeLocalService nomineeLocalService;

    @Reference
    EmployeeEducationLocalService employeeEducationLocalService;

    @Reference
    EmployeeExperienceLocalService employeeExperienceLocalService;

    @Reference
    CompensatoryDataLocalService compensatoryDataLocalService;

    @Reference
    LeaveCompensatoryStatusMasterLocalService leaveCompensatoryStatusMasterLocalService;

    @Reference
    ProjectEmployeeDetailsLocalService projectEmployeeDetailsLocalService;

    @Reference
    ProjectHistoryLocalService projectHistoryLocalService;

    @Override
    public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {

        int curValue = ParamUtil.getInteger(renderRequest, SearchContainer.DEFAULT_CUR_PARAM, 1);
        int deltaValue = ParamUtil.getInteger(renderRequest, SearchContainer.DEFAULT_DELTA_PARAM, 3);

        int compensatoryDatasCount = 0;


        List<CompensatoryDataDto> compensatoryDataDtoList = new ArrayList<>();
        try {
            ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
            EmployeeDetails employeeDetails = employeeDetailsLocalService.findByLrUserId(themeDisplay.getUserId());

            List<CompensatoryData> compensatoryDataList = compensatoryDataLocalService.findByManagerId(employeeDetails.getEmployeeId());
            for (CompensatoryData compensatoryData : compensatoryDataList) {
                CompensatoryDataDto compensatoryDataDto = new CompensatoryDataDto();
                compensatoryDataDto.setCompensatoryDataId(compensatoryData.getCompensatoryDataId());
                compensatoryDataDto.setApprovedHours(compensatoryData.getApprovedHours());
                compensatoryDataDto.setRequestedHours(compensatoryData.getRequestedHours());
                compensatoryDataDto.setDescription(compensatoryData.getDescription());
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
                String formattedDate = dateFormat.format(compensatoryData.getDateOfCompensation());
                compensatoryDataDto.setDateOfCompensation(formattedDate);
                compensatoryDataDto.setStatus(leaveCompensatoryStatusMasterLocalService.getLeaveCompensatoryStatusMaster(compensatoryData.getLeaveCompensatoryStatusMasterId()).getLeaveCompensatoryStatus());
                EmployeeDetails managerDetails = employeeDetailsLocalService.getEmployeeDetails(compensatoryData.getManagerId());
                compensatoryDataDto.setManagerName(managerDetails.getFirstName() + StringPool.SPACE + managerDetails.getLastName());
                compensatoryDataDtoList.add(compensatoryDataDto);
                compensatoryDatasCount += 1;
            }
            renderRequest.setAttribute(AxHrmsCompensatoryDataConstants.COMPENSATORY_DATA_LIST, compensatoryDataDtoList);
        } catch (PortalException e) {
            renderRequest.setAttribute(AxHrmsCompensatoryDataConstants.COMPENSATORY_DATA_LIST, compensatoryDataDtoList);

        }

        // adding the managers list to

        renderRequest.setAttribute(AxHrmsCompensatoryDataConstants.COMPENSATORY_DATA_COUNT, compensatoryDatasCount);
        renderRequest.setAttribute(SearchContainer.DEFAULT_DELTA_PARAM, deltaValue);
        renderRequest.setAttribute(AxHrmsCompensatoryDataConstants.ITERATOR_URL, renderResponse.createRenderURL());

        return AxHrmsCompensatoryDataConstants.MANAGER_JSP;

    }
}
