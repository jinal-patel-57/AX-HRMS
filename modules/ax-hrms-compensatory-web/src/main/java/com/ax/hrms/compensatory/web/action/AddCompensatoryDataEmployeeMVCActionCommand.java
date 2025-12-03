package com.ax.hrms.compensatory.web.action;

import com.ax.hrms.common.api.api.AxHrmsCommonApi;
import com.ax.hrms.compensatory.web.constants.AxHrmsCompensatoryDataConstants;
import com.ax.hrms.compensatory.web.constants.AxHrmsCompensatoryWebPortletKeys;
import com.ax.hrms.master.service.*;
import com.ax.hrms.model.CompensatoryData;
import com.ax.hrms.service.*;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.RoleLocalService;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Author: Nivid Koradiya
 */
@Component(property = {
                "javax.portlet.name=" + AxHrmsCompensatoryWebPortletKeys.AX_HRMS_COMPENSATORY_EMPLOYEE_WEB_PORTLET,
                "mvc.command.name=/addCompensatoryData"
}, service = MVCActionCommand.class)
public class AddCompensatoryDataEmployeeMVCActionCommand extends BaseMVCActionCommand {

        Log log = LogFactoryUtil.getLog(AddCompensatoryDataEmployeeMVCActionCommand.class);

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
                SimpleDateFormat sdf = new SimpleDateFormat(AxHrmsCompensatoryDataConstants.DATE_FORMATER);
                Date compensationDate = ParamUtil.getDate(actionRequest,
                                AxHrmsCompensatoryDataConstants.COMPENSATION_DATE, sdf);
                int compensationHours = ParamUtil.getInteger(actionRequest,
                                AxHrmsCompensatoryDataConstants.COMPENSATION_HOURS);
                long projectManager = ParamUtil.getLong(actionRequest, AxHrmsCompensatoryDataConstants.PROJECT_MANAGER);
                String description = ParamUtil.getString(actionRequest, AxHrmsCompensatoryDataConstants.DESCRIPTION);
                ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);

                CompensatoryData compensatoryData = compensatoryDataLocalService.createCompensatoryData(
                                CounterLocalServiceUtil.increment(CompensatoryData.class.getName()));
                compensatoryData.setDateOfCompensation(compensationDate);
                compensatoryData.setApprovedHours(0);
                compensatoryData.setEmployeeId(
                                employeeDetailsLocalService.findByLrUserId(themeDisplay.getUserId()).getEmployeeId());
                compensatoryData.setRequestedHours(compensationHours);
                compensatoryData.setManagerId(projectManager);
                compensatoryData.setDescription(description);
                compensatoryData.setLeaveCompensatoryStatusMasterId(
                                leaveCompensatoryStatusMasterLocalService
                                                .findByLeaveCompensatoryStatusName(
                                                                AxHrmsCompensatoryDataConstants.PENDING)
                                                .getLeaveCompensatoryStatusMasterId());

                compensatoryData.setCompanyId(themeDisplay.getCompanyId());
                compensatoryData.setCreatedBy(themeDisplay.getUserId());
                compensatoryData.setGroupId(themeDisplay.getCompanyGroupId());
                compensatoryData.setCreateDate(new Date());
                compensatoryData.setModifiedDate(new Date());

                compensatoryDataLocalService.addCompensatoryData(compensatoryData);

                SessionMessages.add(actionRequest, "compensation-request-submitted");
        }
}
