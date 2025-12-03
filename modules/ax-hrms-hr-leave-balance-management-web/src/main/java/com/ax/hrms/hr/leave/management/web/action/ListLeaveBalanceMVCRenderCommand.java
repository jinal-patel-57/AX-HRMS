package com.ax.hrms.hr.leave.management.web.action;

import com.ax.hrms.hr.leave.management.web.constants.AxHrmsHrLeaveManagementWebPortletKeys;
import com.ax.hrms.hr.leave.management.web.dto.EmployeeLeaveListDto;
import com.ax.hrms.master.model.LeaveTypeMaster;
import com.ax.hrms.master.service.EducationLevelMasterLocalService;
import com.ax.hrms.master.service.LeaveCompensatoryStatusMasterLocalService;
import com.ax.hrms.master.service.LeaveTypeMasterLocalService;
import com.ax.hrms.model.EmployeeDetails;
import com.ax.hrms.model.LeaveBalance;
import com.ax.hrms.service.*;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import java.util.*;

@Component(immediate = true, property = {"javax.portlet.name=" + AxHrmsHrLeaveManagementWebPortletKeys.AXHRMSHRLEAVEMANAGEMENTWEB, "mvc.command.name=/"}, service = MVCRenderCommand.class)
public class ListLeaveBalanceMVCRenderCommand implements MVCRenderCommand {


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

    @Reference
    LeaveBalanceLocalService leaveBalanceLocalService;

    @Reference
    LeaveTypeMasterLocalService leaveTypeMasterLocalService;

    @Override
    public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
        long employeeId = ParamUtil.getLong(renderRequest, "employeeId");
        renderRequest.setAttribute("employeeList", getActiveEmployees());
        if (employeeId > 0) {
            List<LeaveTypeMaster> leaveTypeMasterList = leaveTypeMasterLocalService.getLeaveTypeMasters(-1, -1);
            List<EmployeeLeaveListDto> listCustomEmployeeLeave = new ArrayList<>();
            for (LeaveTypeMaster leaveTypeMaster : leaveTypeMasterList) {
                double val;
                Calendar calendar = Calendar.getInstance();
                int year = calendar.get(Calendar.YEAR);
                try {
                    val = leaveBalanceLocalService.findByEmployeeIdLeaveTypeMasterIdAndYear(employeeId, leaveTypeMaster.getLeaveTypeMasterId(), year).getNoOfRemainingLeaves();
                } catch (Exception e) {
                    val = 0;
                }
                EmployeeLeaveListDto employeeLeaveListDto = new EmployeeLeaveListDto();
                employeeLeaveListDto.setLeaveAmount(val);
                employeeLeaveListDto.setLeaveTypeMasterId(leaveTypeMaster.getLeaveTypeMasterId());
                employeeLeaveListDto.setLeaveName(leaveTypeMaster.getLeaveTypeName());
                listCustomEmployeeLeave.add(employeeLeaveListDto);
            }

            renderRequest.setAttribute("employeeId", employeeId);
            renderRequest.setAttribute("listCustomEmployeeLeave", listCustomEmployeeLeave);
        }

        return "/jsp/listEmployeeLeaves.jsp";
    }

    private List<EmployeeDetails> getActiveEmployees(){
        List<EmployeeDetails> allEmployeeList= employeeDetailsLocalService.getEmployeeDetailses(-1,-1);
        List<EmployeeDetails> reqList= new ArrayList<>();
        for (EmployeeDetails employeeDetails : allEmployeeList) {
            if(!employeeDetails.isIsTerminated()){
                reqList.add(employeeDetails);
            }
        }
        return reqList;
    }
}
