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
import com.ax.hrms.model.EmployeeDepartment;
import com.ax.hrms.model.EmployeeDesignation;
import com.ax.hrms.model.EmployeeDetails;
import com.ax.hrms.model.LeaveDayType;
import com.ax.hrms.model.LeaveDayTypeTable;
import com.ax.hrms.model.LeaveRequest;
import com.ax.hrms.service.EmployeeDepartmentLocalService;
import com.ax.hrms.service.EmployeeDesignationLocalService;
import com.ax.hrms.service.EmployeeDetailsLocalService;
import com.ax.hrms.service.LeaveDayTypeLocalService;
import com.ax.hrms.service.LeaveRequestLocalService;
import com.liferay.petra.sql.dsl.DSLQueryFactoryUtil;
import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, property = {
		"javax.portlet.name=" + AxHrmsHrDashboardLeaveReportWebPortletKeys.AXHRMSHRDASHBOARDLEAVEREPORTWEB,
		"mvc.command.name=/"}, service = MVCRenderCommand.class)
public class ListTodaysLeaveEmployeesMVCRenderCommand implements MVCRenderCommand {
	private static final Log log = LogFactoryUtil.getLog(ListTodaysLeaveEmployeesMVCRenderCommand.class);

	@Reference
	LeaveRequestLocalService leaveRequestLocalService;
	
	@Reference
	LeaveDayTypeLocalService leaveDayTypeLocalService;
	
	@Reference
	EmployeeDetailsLocalService employeeDetailsLocalService;
	
	@Reference
	EmployeeDepartmentLocalService employeeDepartmentLocalService;
	
	@Reference
    LeaveCompensatoryStatusMasterLocalService leaveCompensatoryStatusMasterLocalService;
	
	@Reference
	EmployeeDesignationLocalService employeeDesignationLocalService;
	
	@Reference
	DesignationMasterLocalService designationMasterLocalService;
	
	@Reference
	DepartmentMasterLocalService departmentMasterLocalService;

	@Reference
	AxHrmsCommonApi axHrmsCommonApi;

	
	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);

		log.info("inside render");
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
		
		log.info("start today -- " + startOfDay);
		log.info("End today -- " + endOfDay);
		//List<LeaveDayType> todaysLeaves = leaveDayTypeLocalService.findByLeaveDate(today);
		LeaveDayTypeTable leaveDayTypeTable = LeaveDayTypeTable.INSTANCE;

		DSLQuery dslQuery = DSLQueryFactoryUtil.select(
		        leaveDayTypeTable
		).from(
		        leaveDayTypeTable
		).where(
		        leaveDayTypeTable.leaveDate.gte(startOfDay)
		        .and(leaveDayTypeTable.leaveDate.lte(endOfDay))
		);
		List<LeaveDayType> todaysLeaves = leaveDayTypeLocalService.dslQuery(dslQuery);

		
		List<TodaysLeaveEmployee> todaysLeaveEmployees = new ArrayList<>();
		
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

        } catch (NoSuchLeaveCompensatoryStatusMasterException e) {
            log.error("Status master not found", e);
        }
		
		for(LeaveDayType leaveDayType:todaysLeaves) {
			TodaysLeaveEmployee todaysLeaveEmployee = new TodaysLeaveEmployee();
			try {
				LeaveRequest leaveRequest = leaveRequestLocalService.getLeaveRequest(leaveDayType.getLeaveRequestId());
				if(leaveRequest.getLeaveCompensatoryStatusMasterId() == approvedStatusId || leaveRequest.getLeaveCompensatoryStatusMasterId() == pendingStatusId) {
					EmployeeDetails employeeDetails = employeeDetailsLocalService.getEmployeeDetails(leaveRequest.getEmployeeId());
					todaysLeaveEmployee.setName(employeeDetails.getFirstName() + " " + employeeDetails.getLastName());
					todaysLeaveEmployee.setDepartmentName("-");
					todaysLeaveEmployee.setDesignationName("-");
					try {
						EmployeeDepartment employeeDepartment = employeeDepartmentLocalService.findByEmployeeId(employeeDetails.getEmployeeId());
						DepartmentMaster department = departmentMasterLocalService.getDepartmentMaster(employeeDepartment.getDepartmentMasterId());
						todaysLeaveEmployee.setDepartmentName(department.getDepartmentName());
					} catch(Exception e) {
						log.error("Unable to fetch department-- "+e.getMessage());
					}
					
					try {
						EmployeeDesignation employeeDesignation = employeeDesignationLocalService.findByEmployeeId(employeeDetails.getEmployeeId());
						DesignationMaster designation = designationMasterLocalService.getDesignationMaster(employeeDesignation.getDesignationMasterId());
						todaysLeaveEmployee.setDesignationName(designation.getDesignationName());
					} catch(Exception e) {
						log.error("Unable to fetch designation-- "+e.getMessage());
					}
					todaysLeaveEmployee.setStatus(leaveCompensatoryStatusMasterLocalService.getLeaveCompensatoryStatusMaster(leaveRequest.getLeaveCompensatoryStatusMasterId()).getLeaveCompensatoryStatus());
					boolean isReportingManager = employeeDetailsLocalService.findByEmployeeId(employeeDetails.getManagerId()).getLrUserId() == themeDisplay.getUserId();
					todaysLeaveEmployee.setReportingManager(isReportingManager);
					todaysLeaveEmployees.add(todaysLeaveEmployee);
					log.info("todaysLeaveEmployee -- " + todaysLeaveEmployee);
				}
			} catch (PortalException e) {
				log.error("Unable to fetch leave request -- " + e.getMessage());
			}
		}
		renderRequest.setAttribute("todaysLeaves", todaysLeaveEmployees);
		boolean isHrAdmin = axHrmsCommonApi.isRolePerson(themeDisplay, "HR Admin");
		boolean isManager = axHrmsCommonApi.isRolePerson(themeDisplay, "Manager");
		renderRequest.setAttribute("isHrAdmin", isHrAdmin);
		renderRequest.setAttribute("isManager", isManager);
		return "/jsp/dashboardleavereport/listTodaysLeaveEmployees.jsp";
	}

}
