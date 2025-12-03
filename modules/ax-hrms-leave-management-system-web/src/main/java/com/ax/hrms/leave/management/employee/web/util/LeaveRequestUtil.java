package com.ax.hrms.leave.management.employee.web.util;

import com.ax.hrms.leave.management.web.constants.AxHrmsHrLeaveManagementSystemWebPortletConstants;
import com.ax.hrms.leave.management.web.dto.LeaveRequestDto;
import com.ax.hrms.master.model.LeaveCompensatoryStatusMaster;
import com.ax.hrms.master.model.LeavePolicyMaster;
import com.ax.hrms.master.model.LeaveTypeMaster;
import com.ax.hrms.model.EmployeeDetails;
import com.ax.hrms.model.LeaveBalance;
import com.ax.hrms.model.LeaveDayType;
import com.ax.hrms.model.LeaveRequest;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.Year;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author krish.moradiya
 * @implNote : This is UTIL Class which handle Complex Leave Data fetching and managing that
 */
public class LeaveRequestUtil {

	private LeaveRequestUtil() {
	}

	private static Log log = LogFactoryUtil.getLog(LeaveRequestUtil.class);

	private static int currentYear = Year.now().getValue();

	public static List<LeaveRequestDto> getListOfLeaveType(List<LeaveTypeMaster> leaveTypeMasterList, List<LeaveBalance> leaveBalanceList, long employeeId, List<LeavePolicyMaster> leavePolicyMasterList) {
		log.info("GetLeaveTypeFilterUsingLeaveBalanceUtil >>> getListOfLeaveType ::: current year :::"+currentYear);
		List<LeaveRequestDto> leaveTypeMap = new ArrayList<>();
		LeavePolicyMaster leavePolicyMaster = null;
		try {

			for(LeaveBalance leaveBalance : leaveBalanceList) {
				LeaveRequestDto leaveRequestDetailDto = new LeaveRequestDto();

				LeaveTypeMaster leaveTypeMaster = getLeaveTypeMasterByLeaveTypeMasterId(leaveBalance.getLeaveTypeMasterId(),leaveTypeMasterList);
				if(leaveTypeMaster != null) {
					leavePolicyMaster = getLeavePolicyMasterByLeaveTypeMasterId(leaveTypeMaster.getLeaveTypeMasterId(),leavePolicyMasterList);
					leaveRequestDetailDto.setLeaveType(leaveTypeMaster.getLeaveTypeName());
					leaveRequestDetailDto.setLeaveTypeId(leaveTypeMaster.getLeaveTypeMasterId());
					if(leavePolicyMaster != null){
						leaveRequestDetailDto.setIsContinous(leavePolicyMaster.getIsContinuous());
						leaveRequestDetailDto.setIsApplicableFloater(leavePolicyMaster.getIsApplicableFloater());
					}
				}
				leaveRequestDetailDto.setNoOfRemainingLeaves(leaveBalance.getNoOfRemainingLeaves());



				leaveRequestDetailDto.setEmployeeId(employeeId);

				if(currentYear == leaveBalance.getYear())
					leaveTypeMap.add(leaveRequestDetailDto);
			}
		}catch(NullPointerException e) {
			log.error("GetLeaveTypeFilterUsingLeaveBalanceUtil >>> getListOfLeaveType ::: NullPointerException is :::"+e.getMessage());
		} catch(Exception e) {
			log.error("GetLeaveTypeFilterUsingLeaveBalanceUtil >>> getListOfLeaveType ::: "+e.getMessage());
		}
		return leaveTypeMap;
	}

	private static List<LeaveBalance> getLeaveBalanceByEmployeeId(List<LeaveBalance> leaveBalance, long employeeId) {
		try {
			List<LeaveBalance> leaveBalanceLists = leaveBalance.stream()
					.filter(leaveBalanceObj -> leaveBalanceObj.getEmployeeId() == employeeId)
					.collect(Collectors.toList());

			if(!leaveBalanceLists.isEmpty())
				return leaveBalanceLists;
		} catch(Exception e) {
			log.error("GetLeaveTypeFilterUsingLeaveBalanceUtil >>> getLeaveBalanceByEmployeeId ::: "+e.getMessage());
		}
		return new ArrayList<>();
	}

	private static LeaveTypeMaster getLeaveTypeMasterByLeaveTypeMasterId(long leaveTypeMasterId,List<LeaveTypeMaster> leaveTypeMasterList) {
		Optional<LeaveTypeMaster> result = leaveTypeMasterList.stream()
				.filter(leaveTypeMaster -> leaveTypeMaster.getLeaveTypeMasterId() == leaveTypeMasterId)
				.findFirst();

		if(result.isPresent())
			return result.get();
		else
			return null;

	}

	private static LeavePolicyMaster getLeavePolicyMasterByLeaveTypeMasterId(long leaveTypeMasterId,List<LeavePolicyMaster> leavePolicyMasterList){
		Optional<LeavePolicyMaster> leavePolicyMasterResult = leavePolicyMasterList.stream()
				.filter(leavePolicyMasterObj -> leavePolicyMasterObj.getLeaveTypeMasterId() == leaveTypeMasterId)
				.findFirst();
		if(leavePolicyMasterResult.isPresent())
			return leavePolicyMasterResult.get();
		else
			return null;
	}
	public static List<LeaveRequestDto> getListOfLeaveRequest(EmployeeDetails employeeDetails, List<LeaveRequest> leaveRequestList, List<LeaveTypeMaster> leaveTypeMasterList, List<LeaveDayType> leaveDayTypeList, List<LeaveCompensatoryStatusMaster> leaveCompensatoryStatusMasterList) {
		List<LeaveRequestDto> listOfLeaveRequestOfEmployee = new ArrayList<>();
		List<LeaveTypeMaster> listOfLeaveTypeMaster = leaveTypeMasterList;
		List<LeaveDayType> listOfLeaveDayType = leaveDayTypeList;
		List<LeaveCompensatoryStatusMaster> listOfLeaveCompensatoryStatusMasters = leaveCompensatoryStatusMasterList;

		try {
			for (LeaveRequest leaveRequest : leaveRequestList) {
				LeaveRequestDto leaveRequestDetails = new LeaveRequestDto();

				// Set Employee Details
				setEmployeeDetailsInLeaveRequest(leaveRequestDetails, employeeDetails);

				leaveRequestDetails.setLeaveRequestId(leaveRequest.getLeaveRequestId());

				// Set LeaveTypeMaster details
				Optional<LeaveTypeMaster> result = listOfLeaveTypeMaster.stream()
						.filter(leaveTypeMaster -> leaveTypeMaster.getLeaveTypeMasterId() == leaveRequest.getLeaveTypeMasterId())
						.findFirst();
				if (result.isPresent()) {
					LeaveTypeMaster leaveTypeMaster = result.get();
					setLeaveTypeDetailsInLeaveRequest(leaveRequestDetails, leaveTypeMaster);
				}

				// Set LeaveCompensatoryStatusMaster details
				Optional<LeaveCompensatoryStatusMaster> leaveCompensatoryStatusMasterObj = listOfLeaveCompensatoryStatusMasters.stream()
						.filter(leaveCompensatoryStatusMaster -> leaveCompensatoryStatusMaster.getLeaveCompensatoryStatusMasterId() == leaveRequest.getLeaveCompensatoryStatusMasterId())
						.findFirst();
				if (leaveCompensatoryStatusMasterObj.isPresent()) {
					LeaveCompensatoryStatusMaster leaveCompensatoryStatusMaster = leaveCompensatoryStatusMasterObj.get();
					leaveRequestDetails.setLeaveRequestStatus(leaveCompensatoryStatusMaster.getLeaveCompensatoryStatus());
				}

				// Set LeaveDayType details
				List<LeaveDayType> leaveDayTypeListFiltered = listOfLeaveDayType.stream()
						.filter(leaveDayType -> leaveDayType.getLeaveRequestId() == leaveRequest.getLeaveRequestId())
						.collect(Collectors.toList());
				if (!leaveDayTypeListFiltered.isEmpty()) {
					setLeaveDayTypeDetailsInLeaveRequest(leaveRequestDetails, leaveDayTypeListFiltered, leaveRequest);
				}

				listOfLeaveRequestOfEmployee.add(leaveRequestDetails);
			}
		} catch (Exception e) {
			e.getMessage();
		}

		return listOfLeaveRequestOfEmployee;
	}

	private static void setEmployeeDetailsInLeaveRequest(LeaveRequestDto leaveRequestDetails, EmployeeDetails employeeDetails) {
		leaveRequestDetails.setUserId(employeeDetails.getLrUserId());
		leaveRequestDetails.setEmployeeId(employeeDetails.getEmployeeId());
		leaveRequestDetails.setEmployeeName(employeeDetails.getFirstName() + " " + employeeDetails.getLastName());
	}

	private static void setLeaveTypeDetailsInLeaveRequest(LeaveRequestDto leaveRequestDetails, LeaveTypeMaster leaveTypeMaster) {
		leaveRequestDetails.setLeaveType(leaveTypeMaster.getLeaveTypeName());
		leaveRequestDetails.setLeaveTypeId(leaveTypeMaster.getLeaveTypeMasterId());
		leaveRequestDetails.setLeaveTypeDescription(leaveTypeMaster.getDescription());
	}

	private static void setLeaveDayTypeDetailsInLeaveRequest(LeaveRequestDto leaveRequestDetails, List<LeaveDayType> listOfLeaveDayTypes, LeaveRequest leaveRequest) {
		int noOfHoursInLeaveDayType = 0;
		for (LeaveDayType leaveDayType : listOfLeaveDayTypes) {
			if (leaveDayType.getIsHalfDay())
				noOfHoursInLeaveDayType += 4;
			else
				noOfHoursInLeaveDayType += 8;
		}
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(AxHrmsHrLeaveManagementSystemWebPortletConstants.DD_MM_YYYY);
		leaveRequestDetails.setLeavePeriod(simpleDateFormat.format(leaveRequest.getStartDateTime()) + AxHrmsHrLeaveManagementSystemWebPortletConstants.TO + simpleDateFormat.format(leaveRequest.getEndDateTime()));
		leaveRequestDetails.setNoOfDays(noOfHoursInLeaveDayType / 8.0);
		leaveRequestDetails.setNoOfHours(noOfHoursInLeaveDayType);
	}

	public static double calculateDaysBetween(Date startDate, Date endDate) {
		LocalDateTime startDateTime = startDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
		LocalDateTime endDateTime = endDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();

		return ChronoUnit.DAYS.between(startDateTime, endDateTime);
	}
}
