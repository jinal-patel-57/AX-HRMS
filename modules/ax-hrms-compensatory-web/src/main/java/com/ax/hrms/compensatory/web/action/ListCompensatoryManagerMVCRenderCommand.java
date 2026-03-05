package com.ax.hrms.compensatory.web.action;

import com.ax.hrms.compensatory.web.constants.AxHrmsCompensatoryDataConstants;
import com.ax.hrms.compensatory.web.constants.AxHrmsCompensatoryWebPortletKeys;
import com.ax.hrms.compensatory.web.dto.CompensatoryDataDto;
import com.ax.hrms.exception.NoSuchEmployeeDetailsException;
import com.ax.hrms.master.service.EducationLevelMasterLocalService;
import com.ax.hrms.master.service.LeaveCompensatoryStatusMasterLocalService;
import com.ax.hrms.model.CompensatoryData;
import com.ax.hrms.model.EmployeeDetails;
import com.ax.hrms.service.*;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component(immediate = true, property = {"javax.portlet.name=" + AxHrmsCompensatoryWebPortletKeys.AX_HRMS_COMPENSATORY_MANAGER_WEB_PORTLET, "mvc.command.name=/"}, service = MVCRenderCommand.class)
public class ListCompensatoryManagerMVCRenderCommand implements MVCRenderCommand {

    Log log = LogFactoryUtil.getLog(ListCompensatoryManagerMVCRenderCommand.class);
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
        int deltaValue = ParamUtil.getInteger(renderRequest, SearchContainer.DEFAULT_DELTA_PARAM, 20);
        ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);

        int compensatoryDatasCount = 0;


        List<CompensatoryDataDto> compensatoryDataDtoList = new ArrayList<>();
        try {
            EmployeeDetails employeeDetails = employeeDetailsLocalService.findByLrUserId(themeDisplay.getUserId());

            long hrRoleId = RoleLocalServiceUtil.getRole(themeDisplay.getCompanyId(), AxHrmsCompensatoryDataConstants.HR_ADMIN).getRoleId();
            long[] hrRoles = themeDisplay.getUser().getRoleIds();
            boolean isHr = Arrays.stream(hrRoles).anyMatch(id -> id == hrRoleId);

            List<CompensatoryData> compensatoryDataList = new ArrayList<>();
            if(isHr) {
                // for hr admin person
                renderRequest.setAttribute(AxHrmsCompensatoryDataConstants.IS_HR, isHr);
                compensatoryDataList = compensatoryDataLocalService.getCompensatoryDatas(-1,-1);
            }else {
                // for managet person
                compensatoryDataList = compensatoryDataLocalService.findByManagerId(employeeDetails.getEmployeeId());
            }
            for (CompensatoryData compensatoryData : compensatoryDataList) {
                CompensatoryDataDto compensatoryDataDto = new CompensatoryDataDto();
                compensatoryDataDto.setCompensatoryDataId(compensatoryData.getCompensatoryDataId());
                compensatoryDataDto.setApprovedHours(compensatoryData.getApprovedHours());
                compensatoryDataDto.setRequestedHours(compensatoryData.getRequestedHours());

                int requestedHours = compensatoryData.getRequestedHours();
                int approvedHours = compensatoryData.getApprovedHours();
                if (requestedHours == 4) {
                    compensatoryDataDto.setRequestedCompensationType("Half Day");
                } else if (requestedHours == 8) {
                    compensatoryDataDto.setRequestedCompensationType("Full Day");
                }
                if (approvedHours == 4) {
                    compensatoryDataDto.setApprovedCompensationType("Half Day");
                } else if (approvedHours == 8) {
                    compensatoryDataDto.setApprovedCompensationType("Full Day");
                }


                compensatoryDataDto.setDescription(compensatoryData.getDescription());
                compensatoryDataDto.setEmployeeId(compensatoryData.getEmployeeId());
                try {
                    EmployeeDetails modifiedByEmployeeDetails = employeeDetailsLocalService.findByLrUserId(compensatoryData.getModifiedBy());
                    compensatoryDataDto.setModifiedBy(modifiedByEmployeeDetails.getFirstName() + " " + modifiedByEmployeeDetails.getLastName());
                }catch (NoSuchEmployeeDetailsException noSuchEmployeeDetailsException){
                    log.error("noSuchEmployeeDetailsException "+noSuchEmployeeDetailsException.getMessage());
                }
                log.info(compensatoryDataDto.getEmployeeName()+ "    "+compensatoryDataDto.getDateOfCompensation()+ "   "+compensatoryDataDto.getRequestedCompensationType()+"   "+compensatoryDataDto.getApprovedCompensationType());
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
                String formattedDate = dateFormat.format(compensatoryData.getDateOfCompensation());
                compensatoryDataDto.setDateOfCompensation(formattedDate);
                compensatoryDataDto.setStatus(leaveCompensatoryStatusMasterLocalService.getLeaveCompensatoryStatusMaster(compensatoryData.getLeaveCompensatoryStatusMasterId()).getLeaveCompensatoryStatus());
                EmployeeDetails managerDetails = employeeDetailsLocalService.getEmployeeDetails(compensatoryData.getManagerId());
                compensatoryDataDto.setManagerName(managerDetails.getFirstName() + StringPool.SPACE + managerDetails.getLastName());
                EmployeeDetails employee = employeeDetailsLocalService.getEmployeeDetails(compensatoryData.getEmployeeId());
                compensatoryDataDto.setEmployeeName(employee.getFirstName()+ StringPool.SPACE + employee.getLastName());
                SimpleDateFormat time = new SimpleDateFormat("HH:mm");

                compensatoryDataDto.setStartTime(
                        Validator.isNotNull(compensatoryData.getStartTime())
                                ? time.format(compensatoryData.getStartTime())
                                : ""
                );

                compensatoryDataDto.setEndTime(
                        Validator.isNotNull(compensatoryData.getEndTime())
                                ? time.format(compensatoryData.getEndTime())
                                : ""
                );
                compensatoryDataDtoList.add(compensatoryDataDto);
                compensatoryDatasCount += 1;
            }

            renderRequest.setAttribute(AxHrmsCompensatoryDataConstants.COMPENSATORY_DATA_LIST, compensatoryDataDtoList);
        } catch (PortalException e) {
            renderRequest.setAttribute(AxHrmsCompensatoryDataConstants.COMPENSATORY_DATA_LIST, compensatoryDataDtoList);
        }

        // adding the managers list to

        EmployeeDetails currentEmployee = null;
        try {
            currentEmployee = employeeDetailsLocalService.findByLrUserId(themeDisplay.getUserId());
            renderRequest.setAttribute("currentEmployeeId", currentEmployee.getEmployeeId());
        } catch (NoSuchEmployeeDetailsException e) {
            renderRequest.setAttribute("currentEmployeeId", 0);
            throw new RuntimeException(e);
        }


        renderRequest.setAttribute(AxHrmsCompensatoryDataConstants.COMPENSATORY_DATA_COUNT, compensatoryDatasCount);
        renderRequest.setAttribute(SearchContainer.DEFAULT_DELTA_PARAM, deltaValue);
        renderRequest.setAttribute(AxHrmsCompensatoryDataConstants.ITERATOR_URL, renderResponse.createRenderURL());

        return AxHrmsCompensatoryDataConstants.MANAGER_JSP;

    }
}
