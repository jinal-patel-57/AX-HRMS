package com.ax.hrms.report.web.compensatory.report.actions;

import com.ax.hrms.master.model.DepartmentMaster;
import com.ax.hrms.master.model.DesignationMaster;
import com.ax.hrms.master.model.LeaveCompensatoryStatusMaster;
import com.ax.hrms.master.model.LeaveTypeMaster;
import com.ax.hrms.master.service.DepartmentMasterLocalService;
import com.ax.hrms.master.service.DesignationMasterLocalService;
import com.ax.hrms.master.service.LeaveCompensatoryStatusMasterLocalService;
import com.ax.hrms.master.service.LeaveTypeMasterLocalService;
import com.ax.hrms.model.EmployeeDepartment;
import com.ax.hrms.model.EmployeeDesignation;
import com.ax.hrms.model.EmployeeDetails;
import com.ax.hrms.model.LeaveRequest;
import com.ax.hrms.report.web.constants.AxHrmsCompensatoryReportWebPortletKeys;
import com.ax.hrms.report.web.util.CompensatoryOffExcelExportUtil;
import com.ax.hrms.service.EmployeeDepartmentLocalService;
import com.ax.hrms.service.EmployeeDesignationLocalService;
import com.ax.hrms.service.EmployeeDetailsLocalService;
import com.ax.hrms.service.LeaveRequestLocalService;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;

@Component(
        property = {
                "javax.portlet.name=" + AxHrmsCompensatoryReportWebPortletKeys.AXHRMSCOMPENSATORYREPORTWEB,
                "mvc.command.name=/comp/off/report/export"
        },
        service = MVCResourceCommand.class
)
public class FetchCompensatoryOffReportResourceCommand implements MVCResourceCommand{

    @Override
    public boolean serveResource(ResourceRequest request, ResourceResponse response) {

        try {

            String employeeType = ParamUtil.getString(request, "employeeType");
            boolean isPreviousMonth = ParamUtil.getBoolean(request, "previousMonth");

            String fromDateStr = ParamUtil.getString(request, "fromDate");
            String toDateStr = ParamUtil.getString(request, "toDate");

            List<Map<String, String>> reportData = new ArrayList<>();

            long[] employeeIds;

            if ("ALL".equalsIgnoreCase(employeeType)) {
                List<EmployeeDetails> allEmployees =
                        employeeDetailsLocalService.findByIsTerminated(false);

                employeeIds = allEmployees.stream()
                        .mapToLong(EmployeeDetails::getEmployeeId)
                        .toArray();

            } else {
                employeeIds = ParamUtil.getLongValues(request, "employeeIds");
            }

            Date startDate;
            Date endDate;

            if (isPreviousMonth) {
                LocalDate now = LocalDate.now();
                LocalDate prevMonth = now.minusMonths(1);

                LocalDate firstDay = prevMonth.withDayOfMonth(1);
                LocalDate lastDay = prevMonth.withDayOfMonth(prevMonth.lengthOfMonth());

                startDate = Date.from(firstDay.atStartOfDay(ZoneId.systemDefault()).toInstant());
                endDate = Date.from(lastDay.atTime(23, 59, 59)
                        .atZone(ZoneId.systemDefault()).toInstant());
            } else {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                startDate = sdf.parse(fromDateStr);
                endDate = sdf.parse(toDateStr);
            }

            SimpleDateFormat displayFormat = new SimpleDateFormat("dd/MM/yyyy");

            for (long employeeId : employeeIds) {

                EmployeeDetails emp = employeeDetailsLocalService.getEmployeeDetails(employeeId);

                List<LeaveRequest> leaveRequests =
                        leaveRequestLocalService.findByEmployeeId(employeeId);

                for (LeaveRequest leaveRequest : leaveRequests) {

                    LeaveTypeMaster leaveTypeMaster =
                            leaveTypeMasterLocalService.fetchLeaveTypeMaster(
                                    leaveRequest.getLeaveTypeMasterId());

                    if (leaveTypeMaster == null) {
                        continue;
                    }

                    if (!AxHrmsCompensatoryReportWebPortletKeys.COMP_OFF
                            .equalsIgnoreCase(leaveTypeMaster.getLeaveTypeName().trim())) {
                        continue;
                    }

                    if (leaveRequest.getStartDateTime().before(startDate)
                            || leaveRequest.getEndDateTime().after(endDate)) {
                        continue;
                    }

                    Map<String, String> row = new LinkedHashMap<>();

                    row.put("Employee Code", emp.getEmployeeCode());
                    row.put("Employee Name", emp.getFirstName() + StringPool.SPACE + emp.getLastName());
                    row.put("Employee Email", emp.getOfficialEmail());

                    EmployeeDepartment empDept =
                            employeeDepartmentLocalService.findByEmployeeId(emp.getEmployeeId());

                    DepartmentMaster dept = empDept != null
                            ? departmentMasterLocalService.fetchDepartmentMaster(empDept.getDepartmentMasterId())
                            : null;

                    row.put("Department", dept != null ? dept.getDepartmentName() : "-");

                    EmployeeDesignation employeeDesignation =
                            employeeDesignationLocalService.findByEmployeeId(emp.getEmployeeId());

                    DesignationMaster designationMaster = employeeDesignation != null
                            ? designationMasterLocalService.fetchDesignationMaster(
                            employeeDesignation.getDesignationMasterId())
                            : null;

                    row.put("Designation", designationMaster != null ? designationMaster.getDesignationName() : "-");

                    long managerId = emp.getManagerId();
                    EmployeeDetails manager = null;
                    if (managerId > 0) {
                        manager = employeeDetailsLocalService.fetchEmployeeDetails(managerId);
                    }

                    row.put("Manager", manager != null
                            ? manager.getFirstName() + StringPool.SPACE + manager.getLastName()
                            : "-");

                    row.put("Location", "Ahmedabad");
                    row.put("Employee Type", emp.getEmployeeType());

                    row.put("Start Date", displayFormat.format(leaveRequest.getStartDateTime()));
                    row.put("End Date", displayFormat.format(leaveRequest.getEndDateTime()));

                    String statusName = "";
                    long statusId = leaveRequest.getLeaveCompensatoryStatusMasterId();
                    if (statusId > 0) {
                        LeaveCompensatoryStatusMaster leaveCompensatoryStatusMaster = leaveCompensatoryStatusMasterLocalService.getLeaveCompensatoryStatusMaster(statusId);
                        statusName = leaveCompensatoryStatusMaster.getLeaveCompensatoryStatus();
                    }

                    row.put("Status", statusName);
                    long actionById = leaveRequest.getManagerApprovalId();
                    EmployeeDetails actionByEmp = null;

                    if (actionById > 0) {
                        actionByEmp = employeeDetailsLocalService.fetchEmployeeDetails(actionById);
                    }

                    String actionByName = actionByEmp != null
                            ? actionByEmp.getFirstName() + StringPool.SPACE + actionByEmp.getLastName()
                            : "-";

                    row.put("Action By", actionByName);

                    SimpleDateFormat displayDateTimeFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

                    String actionOn = leaveRequest.getModifiedDate() != null
                            ? displayDateTimeFormat.format(leaveRequest.getModifiedDate())
                            : "-";

                    row.put("Action On", actionOn);
                    row.put("Reason", leaveRequest.getReason());

                    reportData.add(row);
                }
            }

            CompensatoryOffExcelExportUtil.exportCompOffReport(
                    reportData,
                    response,
                    AxHrmsCompensatoryReportWebPortletKeys.FILE_NAME
            );

        } catch (Exception e) {
            log.error("Exception in Comp Off Export", e);
        }

        return false;
    }


    private static final Log log =
            LogFactoryUtil.getLog(FetchCompensatoryOffReportResourceCommand.class);

    @Reference
    private EmployeeDetailsLocalService employeeDetailsLocalService;

    @Reference
    private LeaveRequestLocalService leaveRequestLocalService;

    @Reference
    private LeaveTypeMasterLocalService leaveTypeMasterLocalService;

    @Reference
    private EmployeeDepartmentLocalService employeeDepartmentLocalService;

    @Reference
    private DepartmentMasterLocalService departmentMasterLocalService;

    @Reference
    private EmployeeDesignationLocalService employeeDesignationLocalService;

    @Reference
    private DesignationMasterLocalService designationMasterLocalService;

    @Reference
    private LeaveCompensatoryStatusMasterLocalService leaveCompensatoryStatusMasterLocalService;
}
