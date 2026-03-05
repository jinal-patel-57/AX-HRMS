package com.ax.hrms.hr.dashboard.leave.report.web.action;

import com.ax.hrms.common.api.api.AxHrmsCommonApi;
import com.ax.hrms.hr.dashboard.leave.report.web.constants.AxHrmsHrDashboardLeaveReportWebPortletKeys;
import com.ax.hrms.hr.dashboard.leave.report.web.dto.TodaysLeaveEmployee;
import com.ax.hrms.master.exception.NoSuchLeaveCompensatoryStatusMasterException;
import com.ax.hrms.master.model.DepartmentMaster;
import com.ax.hrms.master.model.DesignationMaster;
import com.ax.hrms.master.service.DepartmentMasterLocalService;
import com.ax.hrms.master.service.DesignationMasterLocalService;
import com.ax.hrms.master.service.LeaveCompensatoryStatusMasterLocalService;
import com.ax.hrms.model.*;
import com.ax.hrms.service.*;

import com.liferay.petra.sql.dsl.DSLQueryFactoryUtil;
import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.*;

@Component(
        immediate = true,
        property = {
                "javax.portlet.name="+ AxHrmsHrDashboardLeaveReportWebPortletKeys.AXHRMSHRDASHBOARDWFHREPORTWEB,
                "mvc.command.name=/"
        },
        service = MVCRenderCommand.class
)
public class ListTodaysWFHEmployeesMVCRenderCommand implements MVCRenderCommand {

    public static final String HR_ADMIN = "HR Admin";
    private static final Log log =
            LogFactoryUtil.getLog(ListTodaysWFHEmployeesMVCRenderCommand.class);

    @Reference
    private WorkFromHomeRequestLocalService workFromHomeRequestLocalService;

    @Reference
    private WorkFromHomeDayTypeLocalService workFromHomeDayTypeLocalService;

    @Reference
    private EmployeeDetailsLocalService employeeDetailsLocalService;

    @Reference
    private EmployeeDepartmentLocalService employeeDepartmentLocalService;

    @Reference
    private EmployeeDesignationLocalService employeeDesignationLocalService;

    @Reference
    private DepartmentMasterLocalService departmentMasterLocalService;

    @Reference
    private DesignationMasterLocalService designationMasterLocalService;

    @Reference
    private LeaveCompensatoryStatusMasterLocalService leaveCompensatoryStatusMasterLocalService;

    @Reference
    private AxHrmsCommonApi axHrmsCommonApi;

    @Override
    public String render(RenderRequest renderRequest, RenderResponse renderResponse)
            throws PortletException {

        log.info("===== Inside ListTodaysWFHEmployeesMVCRenderCommand =====");
        ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
        

        Calendar cal = Calendar.getInstance();

        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        Date startOfDay = cal.getTime();

        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);
        cal.set(Calendar.MILLISECOND, 999);
        Date endOfDay = cal.getTime();

        log.info("Start Of Today : " + startOfDay);
        log.info("End Of Today   : " + endOfDay);

        // Fetch today's WFH day records
        WorkFromHomeDayTypeTable wfhDayTypeTable =
                WorkFromHomeDayTypeTable.INSTANCE;

        DSLQuery dslQuery = DSLQueryFactoryUtil
                .select(wfhDayTypeTable)
                .from(wfhDayTypeTable)
                .where(
                        wfhDayTypeTable.workFromHomeDate.gte(startOfDay)
                                .and(wfhDayTypeTable.workFromHomeDate.lte(endOfDay))
                );

        List<WorkFromHomeDayType> todaysWFHDays =
                workFromHomeDayTypeLocalService.dslQuery(dslQuery);

        log.info("Total WFH Day Records Found For Today : " + todaysWFHDays.size());

        List<TodaysLeaveEmployee> todaysWFHEmployees = new ArrayList<>();

        long approvedStatusId = 0;
        long pendingStatusId = 0;

        try {
            approvedStatusId =
                    leaveCompensatoryStatusMasterLocalService
                            .findByLeaveCompensatoryStatusName("Approved")
                            .getLeaveCompensatoryStatusMasterId();

            pendingStatusId =
                    leaveCompensatoryStatusMasterLocalService
                            .findByLeaveCompensatoryStatusName("Pending")
                            .getLeaveCompensatoryStatusMasterId();

            log.info("Approved Status ID : " + approvedStatusId);
            log.info("Pending Status ID  : " + pendingStatusId);

        } catch (NoSuchLeaveCompensatoryStatusMasterException e) {
            log.error("Status master not found", e);
        }

        for (WorkFromHomeDayType day : todaysWFHDays) {

            log.info("Processing WFH Day ID : " + day.getWorkFromHomeDayTypeId());
            log.info("WFH Date : " + day.getWorkFromHomeDate());

            try {

                WorkFromHomeRequest wfhRequest =
                        workFromHomeRequestLocalService
                                .getWorkFromHomeRequest(day.getWorkFromHomeRequestId());

                log.info("WFH Request ID : " + wfhRequest.getWorkFromHomeRequestId());
                log.info("WFH Status     : " + wfhRequest.getStatus());

                if (wfhRequest.getStatus() == approvedStatusId
                        || wfhRequest.getStatus() == pendingStatusId) {

                    log.info("WFH Request is Approved or Pending");

                    TodaysLeaveEmployee dto = new TodaysLeaveEmployee();

                    EmployeeDetails employee =
                            employeeDetailsLocalService
                                    .getEmployeeDetails(wfhRequest.getEmployeeId());

                    log.info("Employee ID : " + employee.getEmployeeId());
                    log.info("Employee Name : " + employee.getFirstName() + " " + employee.getLastName());

                    dto.setName(employee.getFirstName() + " " + employee.getLastName());
                    dto.setDepartmentName("-");
                    dto.setDesignationName("-");

                    //  Department
                    try {
                        EmployeeDepartment empDept =
                                employeeDepartmentLocalService
                                        .findByEmployeeId(employee.getEmployeeId());

                        DepartmentMaster dept =
                                departmentMasterLocalService
                                        .getDepartmentMaster(empDept.getDepartmentMasterId());

                        dto.setDepartmentName(dept.getDepartmentName());

                        log.info("Department : " + dept.getDepartmentName());

                    } catch (Exception e) {
                        log.error("Unable to fetch department for employeeId : "
                                + employee.getEmployeeId(), e);
                    }

                    //  Designation
                    try {
                        EmployeeDesignation empDesig =
                                employeeDesignationLocalService
                                        .findByEmployeeId(employee.getEmployeeId());

                        DesignationMaster desig =
                                designationMasterLocalService
                                        .getDesignationMaster(empDesig.getDesignationMasterId());

                        dto.setDesignationName(desig.getDesignationName());

                        log.info("Designation : " + desig.getDesignationName());

                    } catch (Exception e) {
                        log.error("Unable to fetch designation for employeeId : "
                                + employee.getEmployeeId(), e);
                    }
                    dto.setStatus(leaveCompensatoryStatusMasterLocalService.getLeaveCompensatoryStatusMaster(wfhRequest.getStatus()).getLeaveCompensatoryStatus());
                    boolean isReportingManager = employeeDetailsLocalService.findByEmployeeId(employee.getManagerId()).getLrUserId() == themeDisplay.getUserId();
                    dto.setReportingManager(isReportingManager);
                    todaysWFHEmployees.add(dto);

                } else {
                    log.info("WFH Request Skipped (Not Approved/Pending)");
                }

            } catch (Exception e) {
                log.error("Unable to fetch WFH request for DayTypeId : "
                        + day.getWorkFromHomeDayTypeId(), e);
            }
        }

        log.info("Final Today's WFH Employee Count : " + todaysWFHEmployees.size());

        renderRequest.setAttribute("todaysWFH", todaysWFHEmployees);

        log.info("===== Exiting ListTodaysWFHEmployeesMVCRenderCommand =====");


        boolean isHrAdmin = false;
        try {
            isHrAdmin = RoleLocalServiceUtil.hasUserRole(
                    themeDisplay.getUserId(),
                    themeDisplay.getCompanyId(),
                    HR_ADMIN,
                    true
            );
        } catch (PortalException e) {
            throw new RuntimeException(e);
        }
        boolean isManager = axHrmsCommonApi.isRolePerson(themeDisplay, "Manager");

        renderRequest.setAttribute("isHrAdmin",isHrAdmin);
        renderRequest.setAttribute("isManager",isManager);

        return "/jsp/dashboardWFHreport/listTodaysWFHEmployees.jsp";
    }}