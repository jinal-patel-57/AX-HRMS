package com.ax.hrms.compensatory.web.action;

import com.ax.hrms.common.api.api.AxHrmsCommonApi;
import com.ax.hrms.compensatory.web.constants.AxHrmsCompensatoryDataConstants;
import com.ax.hrms.compensatory.web.constants.AxHrmsCompensatoryWebPortletKeys;
import com.ax.hrms.compensatory.web.dto.CompensatoryDataDto;
import com.ax.hrms.exception.NoSuchEmployeeDetailsException;
import com.ax.hrms.master.service.LeaveCompensatoryStatusMasterLocalService;
import com.ax.hrms.model.CompensatoryData;
import com.ax.hrms.model.EmployeeDetails;
import com.ax.hrms.service.CompensatoryDataLocalService;
import com.ax.hrms.service.EmployeeDetailsLocalService;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.text.SimpleDateFormat;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, property = {
        "javax.portlet.name=" + AxHrmsCompensatoryWebPortletKeys.AX_HRMS_COMPENSATORY_MANAGER_WEB_PORTLET,
        "mvc.command.name=/viewCompensatoryData"}, service = MVCRenderCommand.class)
public class ViewCompensatoryDataManagerMVCRenderCommand implements MVCRenderCommand {

    @Reference
    EmployeeDetailsLocalService employeeDetailsLocalService;

    @Reference
    AxHrmsCommonApi axHrmsCommonApi;

    @Reference
    CompensatoryDataLocalService compensatoryDataLocalService;

    @Reference
    LeaveCompensatoryStatusMasterLocalService leaveCompensatoryStatusMasterLocalService;

    @Reference
    UserLocalService userLocalService;
 
    private static final Log log = LogFactoryUtil.getLog(ViewCompensatoryDataManagerMVCRenderCommand.class);
    
    @Override
    public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
        try {
            log.info("inside the render");
            ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
            
            long compensatoryDataId = ParamUtil.getLong(renderRequest, "compensatoryDataId");
            log.info("compensatoryDataId :: " + compensatoryDataId);
            
            CompensatoryData compensatoryData = compensatoryDataLocalService.getCompensatoryData(compensatoryDataId);

            CompensatoryDataDto compensatoryDataDto = new CompensatoryDataDto();
            compensatoryDataDto.setCompensatoryDataId(compensatoryData.getCompensatoryDataId());
//            compensatoryDataDto.setApprovedHours(compensatoryData.getApprovedHours());
//            compensatoryDataDto.setRequestedHours(compensatoryData.getRequestedHours());

            int requestedHours = compensatoryData.getRequestedHours();
            int approvedHours = compensatoryData.getApprovedHours();
            compensatoryDataDto.setRequestedHours(requestedHours);
            compensatoryDataDto.setApprovedHours(approvedHours);

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
            SimpleDateFormat dateFormat = new SimpleDateFormat(AxHrmsCompensatoryDataConstants.DATE_FORMATER_DD_MMM_YYYY);
            try {
                EmployeeDetails modifiedByEmployeeDetails = employeeDetailsLocalService.findByLrUserId(compensatoryData.getModifiedBy());
                compensatoryDataDto.setModifiedBy(modifiedByEmployeeDetails.getFirstName() + " " + modifiedByEmployeeDetails.getLastName());
            }catch (NoSuchEmployeeDetailsException noSuchEmployeeDetailsException){
                log.error("noSuchEmployeeDetailsException "+noSuchEmployeeDetailsException.getMessage());
            }
            EmployeeDetails employee = employeeDetailsLocalService.getEmployeeDetails(compensatoryData.getEmployeeId());
            String formattedDate = dateFormat.format(compensatoryData.getDateOfCompensation());
            compensatoryDataDto.setDateOfCompensation(formattedDate);
            compensatoryDataDto.setDescription((Validator.isNotNull(compensatoryData.getDescription()) && !compensatoryData.getDescription().isBlank())?compensatoryData.getDescription():"-");
            compensatoryDataDto.setStatus(leaveCompensatoryStatusMasterLocalService.getLeaveCompensatoryStatusMaster(compensatoryData.getLeaveCompensatoryStatusMasterId()).getLeaveCompensatoryStatus());
            EmployeeDetails managerDetails = employeeDetailsLocalService.getEmployeeDetails(compensatoryData.getManagerId());
            compensatoryDataDto.setManagerName(managerDetails.getFirstName() + StringPool.SPACE + managerDetails.getLastName());
            compensatoryDataDto.setEmployeeName(employee.getFirstName() + StringPool.SPACE + employee.getLastName());

            SimpleDateFormat time = new SimpleDateFormat("HH:mm");

            compensatoryDataDto.setStartTime(
                    Validator.isNotNull(compensatoryData.getStartTime())
                            ? time.format(compensatoryData.getStartTime())
                            : "-"
            );

            compensatoryDataDto.setEndTime(
                    Validator.isNotNull(compensatoryData.getEndTime())
                            ? time.format(compensatoryData.getEndTime())
                            : "-"
            );

            renderRequest.setAttribute("compensatoryData", compensatoryDataDto);
        }catch (Exception e){
            log.error("Error in ViewCompensatoryDataManagerMVCRenderCommand: " + e.getMessage(), e);
        }

        return "/jsp/viewCompensatoryRequest.jsp";

    }
}
