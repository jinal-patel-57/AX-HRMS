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

            SimpleDateFormat displayFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");

            for (long employeeId : employeeIds) {

                EmployeeDetails employeeDetails = employeeDetailsLocalService.getEmployeeDetails(employeeId);

                List<LeaveRequest> leaveRequests =
                        leaveRequestLocalService.findByEmployeeId(employeeId);

                List<LeaveRequest> sortedLeaveRequests = new ArrayList<>(leaveRequests);
                sortedLeaveRequests.sort(Comparator.comparing(LeaveRequest::getDateOfRequest));

                // Running balance PER EMPLOYEE
                int runningBalance = 0;

                for (LeaveRequest leaveRequest : leaveRequests) {

                    LeaveTypeMaster leaveTypeMaster =
                            leaveTypeMasterLocalService.fetchLeaveTypeMaster(
                                    leaveRequest.getLeaveTypeMasterId());

                    if (leaveTypeMaster == null ||
                            !AxHrmsCompensatoryReportWebPortletKeys.COMP_OFF
                                    .equalsIgnoreCase(leaveTypeMaster.getLeaveTypeName())) {
                        continue;
                    }

                    if (leaveRequest.getStartDateTime().before(startDate)
                            || leaveRequest.getEndDateTime().after(endDate)) {
                        continue;
                    }

                    Map<String, String> row = new LinkedHashMap<>();

                    row.put("Employee Code", employeeDetails.getEmployeeCode());
                    row.put("Employee Name", employeeDetails.getFirstName() + StringPool.SPACE + employeeDetails.getLastName());
                    row.put("Employee Email", employeeDetails.getOfficialEmail());

                    EmployeeDepartment employeeDepartment =
                            employeeDepartmentLocalService.findByEmployeeId(employeeDetails.getEmployeeId());

                    DepartmentMaster departmentMaster = employeeDepartment != null
                            ? departmentMasterLocalService.fetchDepartmentMaster(
                            employeeDepartment.getDepartmentMasterId())
                            : null;

                    row.put("Department", departmentMaster != null ? departmentMaster.getDepartmentName() : "-");

                    EmployeeDesignation employeeDesignation =
                            employeeDesignationLocalService.findByEmployeeId(employeeDetails.getEmployeeId());

                    DesignationMaster designationMaster = employeeDesignation != null
                            ? designationMasterLocalService.fetchDesignationMaster(
                            employeeDesignation.getDesignationMasterId())
                            : null;

                    row.put("Designation", designationMaster != null ? designationMaster.getDesignationName() : "-");

                    long managerId = employeeDetails.getManagerId();
                    EmployeeDetails manager = managerId > 0
                            ? employeeDetailsLocalService.fetchEmployeeDetails(managerId)
                            : null;

                    row.put("Manager", manager != null
                            ? manager.getFirstName() + StringPool.SPACE + manager.getLastName()
                            : "-");

                    row.put("Location", "Ahmedabad");
                    row.put("Employee Type", employeeDetails.getEmployeeType());

                    row.put("Start Date", displayFormat.format(leaveRequest.getStartDateTime()));
                    row.put("End Date", displayFormat.format(leaveRequest.getEndDateTime()));

                    LeaveCompensatoryStatusMaster statusMaster =
                            leaveCompensatoryStatusMasterLocalService
                                    .fetchLeaveCompensatoryStatusMaster(
                                            leaveRequest.getLeaveCompensatoryStatusMasterId());

                    String statusName = statusMaster != null
                            ? statusMaster.getLeaveCompensatoryStatus()
                            : "-";

                    row.put("Status", statusName);

                    // Balance logic
                    if (AxHrmsCompensatoryReportWebPortletKeys.APPROVED.equalsIgnoreCase(statusName)) {
                        runningBalance++;
                    }

                    row.put("Balance", String.valueOf(runningBalance));

                    EmployeeDetails actionBy = leaveRequest.getManagerApprovalId() > 0
                            ? employeeDetailsLocalService.fetchEmployeeDetails(
                            leaveRequest.getManagerApprovalId())
                            : null;

                    row.put("Action By", actionBy != null
                            ? actionBy.getFirstName() + StringPool.SPACE + actionBy.getLastName()
                            : "-");

                    String actionOn = leaveRequest.getModifiedDate() != null
                            ? displayFormat.format(leaveRequest.getModifiedDate())
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
