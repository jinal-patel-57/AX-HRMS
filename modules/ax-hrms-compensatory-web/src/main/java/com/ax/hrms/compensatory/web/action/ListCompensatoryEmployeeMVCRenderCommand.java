package com.ax.hrms.compensatory.web.action;

import com.ax.hrms.common.api.api.AxHrmsCommonApi;
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
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.PortletURLUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.PortletException;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Component(immediate = true, property = {
        "javax.portlet.name=" + AxHrmsCompensatoryWebPortletKeys.AX_HRMS_COMPENSATORY_EMPLOYEE_WEB_PORTLET,
        "mvc.command.name=/"}, service = MVCRenderCommand.class)
public class ListCompensatoryEmployeeMVCRenderCommand implements MVCRenderCommand {

    @Reference
    EducationLevelMasterLocalService educationLevelMasterLocalService;

    @Reference
    EmployeeUanEsicLocalService employeeUanEsicLocalService;

    @Reference
    EmployeeDetailsLocalService employeeDetailsLocalService;

    @Reference
    AxHrmsCommonApi axHrmsCommonApi;

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

        int compensatoryDatasCount = 0;

        List<CompensatoryDataDto> compensatoryDataDtoList = new ArrayList<>();


        try {
            ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
            EmployeeDetails employeeDetails = employeeDetailsLocalService.findByLrUserId(themeDisplay.getUserId());
            List<User> managerUserList = axHrmsCommonApi.fetchRolePersonList(themeDisplay.getCompanyId(), AxHrmsCompensatoryDataConstants.MANAGER,-1,-1);
            List<EmployeeDetails> managerList = new ArrayList<>();
            for(User manager : managerUserList){
                managerList.add(employeeDetailsLocalService.findByLrUserId(manager.getUserId()));
            }
            renderRequest.setAttribute(AxHrmsCompensatoryDataConstants.MANAGER_LIST, managerList);

            List<CompensatoryData> compensatoryDataList = compensatoryDataLocalService.findByEmployeeId(employeeDetails.getEmployeeId());
            for (CompensatoryData compensatoryData : compensatoryDataList) {
                CompensatoryDataDto compensatoryDataDto = new CompensatoryDataDto();
                compensatoryDataDto.setCompensatoryDataId(compensatoryData.getCompensatoryDataId());
                compensatoryDataDto.setApprovedHours(compensatoryData.getApprovedHours());
                compensatoryDataDto.setRequestedHours(compensatoryData.getRequestedHours());
                compensatoryDataDto.setDescription(compensatoryData.getDescription());
                SimpleDateFormat dateFormat = new SimpleDateFormat(AxHrmsCompensatoryDataConstants.DATE_FORMATER_DD_MM_YYYY);
                String formattedDate = dateFormat.format(compensatoryData.getDateOfCompensation());
                compensatoryDataDto.setDateOfCompensation(formattedDate);
                compensatoryDataDto.setStatus(leaveCompensatoryStatusMasterLocalService.getLeaveCompensatoryStatusMaster(compensatoryData.getLeaveCompensatoryStatusMasterId()).getLeaveCompensatoryStatus());
                EmployeeDetails managerDetails = employeeDetailsLocalService.getEmployeeDetails(compensatoryData.getManagerId());
                compensatoryDataDto.setManagerName(managerDetails.getFirstName() + StringPool.SPACE + managerDetails.getLastName());

                compensatoryDataDtoList.add(compensatoryDataDto);
                compensatoryDatasCount+=1;
            }
            renderRequest.setAttribute(AxHrmsCompensatoryDataConstants.COMPENSATORY_DATA_LIST, compensatoryDataDtoList);
        } catch (PortalException e) {
            renderRequest.setAttribute(AxHrmsCompensatoryDataConstants.COMPENSATORY_DATA_LIST, compensatoryDataDtoList);
        }



        // adding the managers list to

        PortletURL iteratorURL = PortletURLUtil.getCurrent(renderRequest, renderResponse);
        SearchContainer<CompensatoryDataDto> projectSearchContainer = new SearchContainer<>(renderRequest, iteratorURL, null,
                StringPool.BLANK);
        projectSearchContainer.setResultsAndTotal(compensatoryDataDtoList);

        renderRequest.setAttribute(AxHrmsCompensatoryDataConstants.COMPENSATORY_DATA_COUNT, compensatoryDatasCount);
        renderRequest.setAttribute("projectSearchContainer", projectSearchContainer);
        renderRequest.setAttribute(AxHrmsCompensatoryDataConstants.ITERATOR_URL, renderResponse.createRenderURL());

        return AxHrmsCompensatoryDataConstants.EMPLOYEE_JSP;

    }
}
