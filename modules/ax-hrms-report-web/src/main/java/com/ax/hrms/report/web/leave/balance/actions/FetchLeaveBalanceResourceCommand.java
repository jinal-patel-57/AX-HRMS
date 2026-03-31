package com.ax.hrms.report.web.leave.balance.actions;

import com.ax.hrms.master.model.LeaveCompensatoryStatusMaster;
import com.ax.hrms.master.model.LeaveTypeMaster;
import com.ax.hrms.master.service.LeaveCompensatoryStatusMasterLocalService;
import com.ax.hrms.master.service.LeaveTypeMasterLocalService;
import com.ax.hrms.model.*;

import static com.ax.hrms.report.web.constants.AkHrmsLeaveBalanceReportWebPortletKeys.*;

import com.ax.hrms.report.web.util.ExcelExportUtil;
import com.ax.hrms.service.*;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import java.time.Year;
import java.util.*;


@Component(
        property = {
                "javax.portlet.name=" + AKHRMSLEAVEBALANCEREPORTWEB,
                "mvc.command.name=/leave_balance/export"
        },
        service = MVCResourceCommand.class
)
public class FetchLeaveBalanceResourceCommand implements MVCResourceCommand {

    public static final String EMPLOYEE_IDS = "employeeIds";

	public static final String YEAR = "year";

	public static final String EMPLOYEE_TYPE = "employeeType";
	
	@Override
    public boolean serveResource(ResourceRequest request, ResourceResponse response) {

        try {
            String employeeType = ParamUtil.getString(request, EMPLOYEE_TYPE);
            int year = ParamUtil.getInteger(request, YEAR);
            log.info("year -- " + year);
            List<LeaveTypeMaster> leaveTypes = leaveTypeMasterLocalService.getLeaveTypeMasters(QueryUtil.ALL_POS, QueryUtil.ALL_POS);

            Map<String, Map<String, Double>> leaveBalanceData = new LinkedHashMap<>();

			/*
			 * long[] employeeIds; if (ALL.equalsIgnoreCase(employeeType)) {
			 * List<EmployeeDetails> allEmployees =
			 * employeeDetailsLocalService.findByIsTerminated(false); employeeIds =
			 * allEmployees.stream().mapToLong(EmployeeDetails::getEmployeeId).toArray(); }
			 * else { employeeIds = ParamUtil.getLongValues(request, EMPLOYEE_IDS); }
			 */
            
            List<EmployeeDetails> employeeList;

            if (ALL.equalsIgnoreCase(employeeType)) {
                employeeList = new ArrayList<>(employeeDetailsLocalService.findByIsTerminated(false));
            } else {
                long[] rawIds = ParamUtil.getLongValues(request, EMPLOYEE_IDS);
                log.info("employeeIds :-"+ rawIds);
                employeeList = new ArrayList<>();
                for (long id : rawIds) {
                    employeeList.add(employeeDetailsLocalService.getEmployeeDetails(id));
                }
            }
            
            employeeList.sort(Comparator
            	    .comparing(
            	        EmployeeDetails::getJoiningDate,
            	        Comparator.nullsLast(Comparator.naturalOrder())
            	    )
            	    .thenComparing(e -> (e.getFirstName() + " " + e.getLastName()).toLowerCase())
            	);
            log.info("employeeList size: " + employeeList.size());
            List<LeaveCompensatoryStatusMaster> statuses =
                    leaveCompensatoryStatusMasterLocalService.getLeaveCompensatoryStatusMasters(-1, -1);

            long approved = 0;
            long pending = 0;

            for (LeaveCompensatoryStatusMaster status : statuses) {
                String name = status.getLeaveCompensatoryStatus().toLowerCase();

                if ("approved".equals(name)) {
                    approved = status.getLeaveCompensatoryStatusMasterId();
                } else if ("pending".equals(name)) {
                    pending = status.getLeaveCompensatoryStatusMasterId();
                }
            }

            Calendar cal = Calendar.getInstance();
            cal.set(Calendar.HOUR_OF_DAY, 0);
            cal.set(Calendar.MINUTE, 0);
            cal.set(Calendar.SECOND, 0);
            cal.set(Calendar.MILLISECOND, 0);

            Date today = cal.getTime();
            
            for (EmployeeDetails employeeDetails : employeeList) {

                //EmployeeDetails employeeDetails = employeeDetailsLocalService.getEmployeeDetails(employeeId);

                JSONObject employeeDetailsJson = JSONFactoryUtil.createJSONObject();
                employeeDetailsJson.put(EMPLOYEE_ID, employeeDetails.getEmployeeCode());
                employeeDetailsJson.put(EMPLOYEE_NAME, employeeDetails.getFirstName() + StringPool.SPACE + employeeDetails.getLastName());
                employeeDetailsJson.put(EMPLOYEE_EMAIL, employeeDetails.getOfficialEmail());
                

                Map<String, Double> leaveTypeBalanceMap = new LinkedHashMap<>();



                for (LeaveTypeMaster leaveType : leaveTypes) {

                    long leaveTypeMasterId = leaveType.getLeaveTypeMasterId();
                    
                    log.info("cur year -- " + Year.now().getValue()); 
                    if(Year.now().getValue() == year) {
                    	LeaveBalance leaveBalance = null;
                    	try {
                    		leaveBalance = leaveBalanceLocalService.findByEmployeeIdLeaveTypeMasterIdAndYear(employeeDetails.getEmployeeId(), leaveTypeMasterId, year);
                    	} catch (Exception e) {
                    		log.warn("LeaveBalance not found for employeeId=" + employeeDetails.getEmployeeId() +
                    				", leaveTypeId=" + leaveTypeMasterId);
                    	}
                    	double remainingLeaves = (leaveBalance != null) ? leaveBalance.getNoOfRemainingLeaves() : 0.0;

                        List<LeaveRequest> leaveRequestList = leaveRequestLocalService.findByEmployeeIdAndLeaveTypeId(employeeDetails.getEmployeeId(),leaveTypeMasterId);

                        double totalDays = 0.0;
                        for(LeaveRequest leaveRequest : leaveRequestList){
                            long status = leaveRequest.getLeaveCompensatoryStatusMasterId();

                            if (approved != status &&
                                    pending != status) {
                                continue;
                            }
                            if (leaveRequest.getEndDateTime().before(today)) {
                                continue;
                            }

                                List<LeaveDayType> leaveDayTypeList = leaveDayTypeLocalService.findByLeaveRequestId(leaveRequest.getLeaveRequestId());
                                for(LeaveDayType leaveDayType : leaveDayTypeList){
                                    if (leaveDayType.getLeaveDate().after(today)) {
                                        totalDays += leaveDayType.isIsHalfDay() ? 0.5 : 1.0;
                                    }
                                }

                        }

                        log.info("total days which is after this today:- "+ totalDays);
                        log.info("remaining balance :- "+ remainingLeaves+totalDays);




                        double finalBalance = remainingLeaves + totalDays;

                        leaveTypeBalanceMap.put(leaveType.getLeaveTypeName(), finalBalance);

                    } else {
                    	LeaveBalanceHistory leaveBalanceHistory = null;
                    	try {
                    		leaveBalanceHistory = leaveBalanceHistoryLocalService.findByEmployeeIdLeaveTypeMasterIdAndYear(employeeDetails.getEmployeeId(), leaveTypeMasterId, year);
                    	} catch (Exception e) {
                    		log.warn("LeaveBalance not found for employeeId=" + employeeDetails.getEmployeeId() +
                    				", leaveTypeId=" + leaveTypeMasterId);
                    	}
                    	double remainingLeaves = (leaveBalanceHistory != null) ? leaveBalanceHistory.getNoOfRemainingLeaves() : 0.0;
                    	leaveTypeBalanceMap.put(leaveType.getLeaveTypeName(), remainingLeaves);
                    }
                }
                log.info("leaveTypeBalanceMap -- " + leaveTypeBalanceMap);
                leaveBalanceData.put(employeeDetailsJson.toString(), leaveTypeBalanceMap);
            }
            ExcelExportUtil.exportLeaveBalance(leaveBalanceData, response, LEAVE_BALANCE_EXPORT_FILE_NAME);
        } catch (Exception e) {
            log.error("Exception occurred in LeaveBalanceExportResourceCommand", e);
        }

        return false;
    }

    private static final Log log = LogFactoryUtil.getLog(FetchLeaveBalanceResourceCommand.class);

    @Reference
    private LeaveTypeMasterLocalService leaveTypeMasterLocalService;
    @Reference
    private LeaveBalanceHistoryLocalService leaveBalanceHistoryLocalService;
    @Reference
    private LeaveBalanceLocalService leaveBalanceLocalService;
    @Reference
    private EmployeeDetailsLocalService employeeDetailsLocalService;

    @Reference
    private LeaveRequestLocalService leaveRequestLocalService;

    @Reference
    private LeaveDayTypeLocalService leaveDayTypeLocalService;

    @Reference
    private LeaveCompensatoryStatusMasterLocalService leaveCompensatoryStatusMasterLocalService;
}
