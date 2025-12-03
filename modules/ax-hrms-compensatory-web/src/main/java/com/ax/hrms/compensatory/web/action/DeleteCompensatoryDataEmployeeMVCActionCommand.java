package com.ax.hrms.compensatory.web.action;


import com.ax.hrms.common.api.api.AxHrmsCommonApi;
import com.ax.hrms.compensatory.web.constants.AxHrmsCompensatoryDataConstants;
import com.ax.hrms.compensatory.web.constants.AxHrmsCompensatoryWebPortletKeys;
import com.ax.hrms.master.service.*;
import com.ax.hrms.service.*;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.RoleLocalService;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;


/**
 * Author: Nivid Koradiya
 */
@Component(
        property = {
                "javax.portlet.name=" + AxHrmsCompensatoryWebPortletKeys.AX_HRMS_COMPENSATORY_EMPLOYEE_WEB_PORTLET,
                "mvc.command.name=/deleteCompensatoryData"
        },
        service = MVCActionCommand.class
)
public class DeleteCompensatoryDataEmployeeMVCActionCommand extends BaseMVCActionCommand {

    Log log= LogFactoryUtil.getLog(DeleteCompensatoryDataEmployeeMVCActionCommand.class);

    @Reference
    UserLocalService userLocalService;

    @Reference
    AxHrmsCommonApi axHrmsCommonApi;

    @Reference
    RoleLocalService roleLocalService;

    @Reference
    EmployeeDetailsLocalService employeeDetailsLocalService;

    @Reference
    EmployeeSalaryLocalService employeeSalaryLocalService;

    @Reference
    LeaveTypeMasterLocalService leaveTypeMasterLocalService;

    @Reference
    LeavePolicyMasterLocalService leavePolicyMasterLocalService;

    @Reference
    LeaveBalanceLocalService leaveBalanceLocalService;

    @Reference
    EmployeeProbationDetailsLocalService employeeProbationDetailsLocalService;

    @Reference
    ProbationStatusMasterLocalService probationStatusMasterLocalService;

    @Reference
    DepartmentMasterLocalService departmentMasterLocalService;

    @Reference
    DesignationMasterLocalService designationMasterLocalService;

    @Reference
    EmployeeDepartmentLocalService employeeDepartmentLocalService;

    @Reference
    EmployeeDesignationLocalService employeeDesignationLocalService;

    @Reference
    CompensatoryDataLocalService compensatoryDataLocalService;

    @Reference
    LeaveCompensatoryStatusMasterLocalService leaveCompensatoryStatusMasterLocalService;

    @Override
    protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
        long compensatoryDataId = ParamUtil.getLong(actionRequest, AxHrmsCompensatoryDataConstants.COMPENSATORY_DATA_ID);
        compensatoryDataLocalService.deleteCompensatoryData(compensatoryDataId);
        SessionMessages.add(actionRequest, AxHrmsCompensatoryDataConstants.COMPENSATION_REQUEST_DELETED);
    }
}



