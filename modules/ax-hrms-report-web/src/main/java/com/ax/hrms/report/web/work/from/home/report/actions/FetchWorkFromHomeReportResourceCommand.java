package com.ax.hrms.report.web.work.from.home.report.actions;

import com.ax.hrms.master.model.DepartmentMaster;
import com.ax.hrms.master.model.DesignationMaster;
import com.ax.hrms.master.model.LeaveCompensatoryStatusMaster;
import com.ax.hrms.master.service.DepartmentMasterLocalService;
import com.ax.hrms.master.service.DesignationMasterLocalService;
import com.ax.hrms.master.service.LeaveCompensatoryStatusMasterLocalService;
import com.ax.hrms.model.EmployeeDepartment;
import com.ax.hrms.model.EmployeeDesignation;
import com.ax.hrms.model.EmployeeDetails;
import com.ax.hrms.model.WorkFromHomeRequest;
import com.ax.hrms.report.web.constants.AxHrmsWorkFromHomeReportWebPortletKeys;
import com.ax.hrms.report.web.portlet.AxHrmsWorkFromHomeReportWebPortlet;
import com.ax.hrms.report.web.util.WFHExcelExportUtil;
import com.ax.hrms.service.EmployeeDepartmentLocalService;
import com.ax.hrms.service.EmployeeDesignationLocalService;
import com.ax.hrms.service.EmployeeDetailsLocalService;
import com.ax.hrms.service.WorkFromHomeRequestLocalService;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.*;

@Component(
        property = {
                "javax.portlet.name=" + AxHrmsWorkFromHomeReportWebPortletKeys.AXHRMSWORKFROMHOMEREPORTWEB,
                "mvc.command.name=/work/from/home/report/export"
        },
        service = MVCResourceCommand.class
)
public class FetchWorkFromHomeReportResourceCommand implements MVCResourceCommand {

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

            for (long employeeId : employeeIds) {

                EmployeeDetails employeeDetails = employeeDetailsLocalService.getEmployeeDetails(employeeId);

                List<WorkFromHomeRequest> workFromHomeRequests =
                        workFromHomeRequestLocalService.findByEmployeeId(employeeId, QueryUtil.ALL_POS,QueryUtil.ALL_POS);

                for (WorkFromHomeRequest workFromHomeRequest : workFromHomeRequests) {

                    if (workFromHomeRequest.getStartDate().before(startDate) || workFromHomeRequest.getEndDate().after(endDate)) {
                        continue;
                    }

                    Map<String, String> row = new LinkedHashMap<>();

                    row.put("Employee Code", employeeDetails.getEmployeeCode());
                    row.put("Employee Name", employeeDetails.getFirstName() + " " + employeeDetails.getLastName());
                    row.put("Employee Email", employeeDetails.getOfficialEmail());

                    EmployeeDepartment employeeDepartment =
                            employeeDepartmentLocalService.findByEmployeeId(employeeDetails.getEmployeeId());

                    DepartmentMaster department =
                            departmentMasterLocalService.fetchDepartmentMaster(employeeDepartment.getDepartmentMasterId());

                    row.put("Department", department != null ? department.getDepartmentName() : "");

                    EmployeeDesignation employeeDesignation =
                            employeeDesignationLocalService.findByEmployeeId(employeeDetails.getEmployeeId());

                    DesignationMaster designationMaster = designationMasterLocalService
                            .getDesignationMaster(employeeDesignation.getDesignationMasterId());

                    row.put("Designation", designationMaster.getDesignationName());

                    long managerUserId = employeeDetails.getManagerId();
                    EmployeeDetails managerDetails = null;
                    if (managerUserId > 0) {
                        managerDetails = employeeDetailsLocalService.getEmployeeDetails(managerUserId);
                    }

                    row.put("Manager", managerDetails != null
                            ? managerDetails.getFirstName() + StringPool.SPACE + managerDetails.getLastName()
                            : "-");

                    row.put("Location", "Ahmedabad");
                    row.put("Employee Type", employeeDetails.getEmployeeType());

                    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

                    String wfhStartDate = sdf.format(workFromHomeRequest.getStartDate());
                    String wfhEndDate = sdf.format(workFromHomeRequest.getEndDate());

                    row.put("Leave Period", wfhStartDate + " - " + wfhEndDate);

                    long days = 0;

                    LocalDate start = workFromHomeRequest.getStartDate().toInstant()
                            .atZone(ZoneId.systemDefault())
                            .toLocalDate();

                    LocalDate end = workFromHomeRequest.getEndDate().toInstant()
                            .atZone(ZoneId.systemDefault())
                            .toLocalDate();

                    for (LocalDate date = start; !date.isAfter(end); date = date.plusDays(1)) {
                        DayOfWeek dayOfWeek = date.getDayOfWeek();
                        if (dayOfWeek != DayOfWeek.SATURDAY && dayOfWeek != DayOfWeek.SUNDAY) {
                            days++;
                        }
                    }

                    row.put("No. Of Days", String.valueOf(days));
                    long statusId = workFromHomeRequest.getStatus();

                    String status = "";
                    if (statusId > 0) {
                        LeaveCompensatoryStatusMaster leaveCompensatoryStatusMaster = leaveCompensatoryStatusMasterLocalService.getLeaveCompensatoryStatusMaster(statusId);
                        status = leaveCompensatoryStatusMaster.getLeaveCompensatoryStatus();
                    }
                    row.put("Status", status);
                    SimpleDateFormat sdfWithTimestamp = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

                    String dateOfRequest = sdfWithTimestamp.format( workFromHomeRequest.getRequestDate());
                    row.put("Date of Request", dateOfRequest);
                    long actionBy = workFromHomeRequest.getReviewerId();

                    String actionByName = "-";

                    if (actionBy > 0) {
                        EmployeeDetails actionByDetails = employeeDetailsLocalService.getEmployeeDetails(actionBy);

                        if (actionByDetails != null) {
                            actionByName = actionByDetails.getFirstName() + StringPool.SPACE + actionByDetails.getLastName();
                        }
                    }
                    row.put("Action By", actionByName);
                    String actionOn = sdfWithTimestamp.format( workFromHomeRequest.getModifiedDate());
                    row.put("Action On", actionOn);
                    row.put("Reason", workFromHomeRequest.getReason());

                    reportData.add(row);
                }
            }

            WFHExcelExportUtil.exportWFHReport(reportData, response, AxHrmsWorkFromHomeReportWebPortletKeys.SHEET_NAME);

        } catch (Exception e) {
            log.error("Exception in WFH Export", e);
        }

        return false;
    }

    private static final Log log = LogFactoryUtil.getLog(FetchWorkFromHomeReportResourceCommand.class);

    @Reference
    private EmployeeDetailsLocalService employeeDetailsLocalService;

    @Reference
    private WorkFromHomeRequestLocalService workFromHomeRequestLocalService;

    @Reference
    private DepartmentMasterLocalService departmentMasterLocalService;

    @Reference
    private EmployeeDepartmentLocalService employeeDepartmentLocalService;

    @Reference
    private EmployeeDesignationLocalService employeeDesignationLocalService;

    @Reference
    private DesignationMasterLocalService designationMasterLocalService;

    @Reference
    LeaveCompensatoryStatusMasterLocalService leaveCompensatoryStatusMasterLocalService;
}
