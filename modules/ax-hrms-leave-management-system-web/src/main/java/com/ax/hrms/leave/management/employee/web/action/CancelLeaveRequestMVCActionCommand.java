package com.ax.hrms.leave.management.employee.web.action;

import com.ax.hrms.exception.NoSuchLeaveBalanceException;
import com.ax.hrms.leave.management.web.constants.AxHrmsLeaveManagementSystemWebPortletKeys;
import com.ax.hrms.leave.management.web.constants.AxHrmsLeaveManagementWebPortletConstants;
import com.ax.hrms.master.service.LeaveCompensatoryStatusMasterLocalService;

import com.ax.hrms.model.LeaveBalance;
import com.ax.hrms.model.LeaveDayType;
import com.ax.hrms.model.LeaveRequest;
import com.ax.hrms.service.LeaveBalanceLocalService;
import com.ax.hrms.service.LeaveDayTypeLocalService;
import com.ax.hrms.service.LeaveRequestLocalService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;

import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

/**
 * @author krish.moradiya
 * @implNote : User can cancel leave Request
 */
@Component(
	    immediate = true,
	    property = {
	        "javax.portlet.name="+ AxHrmsLeaveManagementSystemWebPortletKeys.AXHRMS_EMPLOYEE_LEAVE_MANAGEMENT_SYSTEM_WEB_PORTLET,
	        "mvc.command.name=/cancelLeaveRequest"
	    },
	    service = MVCActionCommand.class
	)
public class CancelLeaveRequestMVCActionCommand extends BaseMVCActionCommand {

	private static final Log log = LogFactoryUtil.getLog(CancelLeaveRequestMVCActionCommand.class);

	@Reference
	private LeaveRequestLocalService leaveRequestLocalService;
	@Reference
	private LeaveCompensatoryStatusMasterLocalService leaveCompensatoryStatusMasterLocalService;
	@Reference
	private LeaveDayTypeLocalService leaveDayTypeLocalService;
	@Reference
	private LeaveBalanceLocalService leaveBalanceLocalService;
	
	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse)
			throws Exception {
		
		super.hideDefaultErrorMessage(actionRequest);
		
		log.info("CancelLeaveRequestMVCActionCommand >>> doProcessAction ::: Delete process called");
		long leaveRequestId = ParamUtil.getLong(actionRequest, AxHrmsLeaveManagementWebPortletConstants.LEAVE_REQUEST_ID_VAR,AxHrmsLeaveManagementWebPortletConstants.DEFAULT_LONG_VALUE);
		
		LeaveRequest leaveRequest = null;
		
		try {
			leaveRequest = leaveRequestLocalService.getLeaveRequest(leaveRequestId);
			if(leaveRequestId > 0) {
				leaveRequest.setLeaveCompensatoryStatusMasterId(leaveCompensatoryStatusMasterLocalService.findByLeaveCompensatoryStatusName(AxHrmsLeaveManagementWebPortletConstants.CANCELLED).getLeaveCompensatoryStatusMasterId());
				boolean isBalanceUpdated = updateLeaveBalance(leaveRequestId, leaveRequest.getEmployeeId(), leaveRequest.getLeaveTypeMasterId());
				if(isBalanceUpdated) {
					leaveRequestLocalService.updateLeaveRequest(leaveRequest);
					SessionMessages.add(actionRequest, AxHrmsLeaveManagementWebPortletConstants.LEAVE_REQUEST_CANCEL_MESSAGE_KEY);
				}
				else {
					SessionErrors.add(actionRequest, AxHrmsLeaveManagementWebPortletConstants.LEAVE_REQUEST_CANCEL_FAILED_MESSAGE_KEY);
				}
			}
			else {
				SessionErrors.add(actionRequest, AxHrmsLeaveManagementWebPortletConstants.LEAVE_REQUEST_CANCEL_FAILED_MESSAGE_KEY);
			}
		} catch (NumberFormatException | PortalException | NullPointerException e) {
			log.error("CancelLeaveRequestMVCActionCommand >>> doProcessAction (MVCActionCommand) ::: Exception is: "+e.getMessage());
		}

		actionResponse.sendRedirect(ParamUtil.getString(actionRequest,AxHrmsLeaveManagementWebPortletConstants.ITERATOR_URL_PARAMETER_NAME));
	}

	private boolean updateLeaveBalance(long leaveRequestId,long employeeId,long leaveTypeMasterId) {
    	boolean leaveBalanceUpdateStatus = false;
    	List<LeaveDayType> listOfLeaveDayType = leaveDayTypeLocalService.findByLeaveRequestId(leaveRequestId);
		int noOfHoursInLeaveDayType = 0;
		for(LeaveDayType leaveDayType : listOfLeaveDayType){
			if(leaveDayType.getIsHalfDay())
				noOfHoursInLeaveDayType += 4;
			else
				noOfHoursInLeaveDayType += 8;
		}
    	LeaveBalance leaveBalance = null;
    	
    	try {
			leaveBalance = leaveBalanceLocalService.findByEmployeeIdAndLeaveTypeMasterId(employeeId, leaveTypeMasterId);
			leaveBalance.setNoOfUsedLeaves(leaveBalance.getNoOfUsedLeaves()-(noOfHoursInLeaveDayType/8.0));
			leaveBalance.setNoOfRemainingLeaves(leaveBalance.getNoOfRemainingLeaves()+(noOfHoursInLeaveDayType/8.0));
			leaveBalanceLocalService.updateLeaveBalance(leaveBalance);
			leaveBalanceUpdateStatus = true;
		} catch (NoSuchLeaveBalanceException | NullPointerException e) {
			log.error("CancelLeaveRequestMVCActionCommand >>> updateLeaveBalance ::: Exception : "+e.getMessage());
		}



    	
    	return leaveBalanceUpdateStatus;
    }
}
