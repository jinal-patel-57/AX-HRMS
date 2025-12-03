package ax.hrms.hr.leave.balance.history.util;

import java.util.ArrayList;
import java.util.List;

import com.ax.hrms.master.service.LeaveTypeMasterLocalService;
import com.ax.hrms.model.EmployeeDetails;
import com.ax.hrms.model.LeaveBalanceHistory;
import com.ax.hrms.service.EmployeeDetailsLocalService;
import com.ax.hrms.service.LeaveBalanceHistoryLocalService;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;

import ax.hrms.hr.leave.balance.history.dto.LeaveBalanceHistoryDto;

public class LeaveBalanceHistoryUtil {
	
	private EmployeeDetailsLocalService employeeDetailsLocalService;
	private LeaveBalanceHistoryLocalService leaveBalanceHistoryLocalService;
	private LeaveTypeMasterLocalService leaveTypeMasterLocalService;
	
	
	public LeaveBalanceHistoryUtil(EmployeeDetailsLocalService employeeDetailsLocalService,
			LeaveBalanceHistoryLocalService leaveBalanceHistoryLocalService,
			LeaveTypeMasterLocalService leaveTypeMasterLocalService) {
		super();
		this.employeeDetailsLocalService = employeeDetailsLocalService;
		this.leaveBalanceHistoryLocalService = leaveBalanceHistoryLocalService;
		this.leaveTypeMasterLocalService = leaveTypeMasterLocalService;
	}

	
	
	
	
	public List<LeaveBalanceHistoryDto> getLeaveData(List<LeaveBalanceHistory> leavebalanceHistoryList) throws PortalException{
		List<LeaveBalanceHistoryDto> leaveBalanceDtoList = new ArrayList<>();
		
		for(LeaveBalanceHistory leaveBalanceHistory: leavebalanceHistoryList) {
			LeaveBalanceHistoryDto leaveHistoryDto = new LeaveBalanceHistoryDto();
			leaveHistoryDto.setEmployeeId(leaveBalanceHistory.getEmployeeId());
			
			EmployeeDetails employee = employeeDetailsLocalService.getEmployeeDetails(leaveBalanceHistory.getEmployeeId());
			leaveHistoryDto.setEmployeeName(employee.getFirstName() + StringPool.SPACE + employee.getLastName() );
			leaveHistoryDto.setLeaveTypeId(leaveBalanceHistory.getLeaveTypeMasterId());
			leaveHistoryDto.setLeaveTypeName(leaveTypeMasterLocalService.findByLeaveTypeMasterId(leaveBalanceHistory.getLeaveTypeMasterId()).getLeaveTypeName());
			leaveHistoryDto.setYear(leaveBalanceHistory.getYear());
			leaveHistoryDto.setNoOfRemainingLeave(leaveBalanceHistory.getNoOfRemainingLeaves());
			leaveHistoryDto.setNoOfUsedLeave(leaveBalanceHistory.getNoOfUsedLeaves());
			leaveBalanceDtoList.add(leaveHistoryDto);
		}
		
		return leaveBalanceDtoList;
		
	}
}
