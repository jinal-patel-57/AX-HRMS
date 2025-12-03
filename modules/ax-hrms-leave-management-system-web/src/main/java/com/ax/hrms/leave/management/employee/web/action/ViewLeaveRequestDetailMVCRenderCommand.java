package com.ax.hrms.leave.management.employee.web.action;

import com.ax.hrms.leave.management.web.constants.AxHrmsLeaveManagementSystemWebPortletKeys;
import com.ax.hrms.leave.management.web.constants.AxHrmsLeaveManagementWebPortletConstants;

import com.ax.hrms.master.model.LeaveTypeMaster;
import com.ax.hrms.master.service.LeaveCompensatoryStatusMasterLocalService;
import com.ax.hrms.master.service.LeavePolicyMasterLocalService;
import com.ax.hrms.master.service.LeaveTypeMasterLocalService;
import com.ax.hrms.model.LeaveDayType;
import com.ax.hrms.model.LeaveInformToTeamDetail;
import com.ax.hrms.model.LeaveRequest;
import com.ax.hrms.service.*;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.ParamUtil;


import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 *
 * @author krish.moradiya
 * @implNote this provide full Leave Request detail in frontend side
 */
@Component(
        immediate = true,
        property = {
                "javax.portlet.name=" + AxHrmsLeaveManagementSystemWebPortletKeys.AXHRMS_EMPLOYEE_LEAVE_MANAGEMENT_SYSTEM_WEB_PORTLET,
                "mvc.command.name=/viewLeaveRequestDetail"
        },
        service = MVCRenderCommand.class
)
public class ViewLeaveRequestDetailMVCRenderCommand implements MVCRenderCommand{

	private static final Log log = LogFactoryUtil.getLog(ViewLeaveRequestDetailMVCRenderCommand.class);
	@Reference
	private LeaveRequestLocalService leaveRequestLocalService;
	
	@Reference
	private LeaveDayTypeLocalService leaveDayTypeLocalService;

	@Reference
	private LeaveTypeMasterLocalService leaveTypeMasterLocalService;
	
	@Reference
	private LeaveInformToTeamDetailLocalService leaveInformToTeamDetailLocalService;
	
	@Reference
	private EmployeeDetailsLocalService employeeDetailsLocalService;

	@Reference
	private HolidayLocalService holidayLocalService;

	@Reference
	private LeavePolicyMasterLocalService leavePolicyMasterLocalService;

	@Reference
	private LeaveCompensatoryStatusMasterLocalService leaveCompensatoryStatusMasterLocalService;
	
	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		long leaveRequestId = ParamUtil.getLong(renderRequest, AxHrmsLeaveManagementWebPortletConstants.LEAVE_REQUEST_ID_VAR,AxHrmsLeaveManagementWebPortletConstants.DEFAULT_LONG_VALUE);
		try {
			LeaveRequest leaveRequest = leaveRequestLocalService.getLeaveRequest(leaveRequestId);
			List<LeaveDayType> leaveDayTypeList = leaveDayTypeLocalService.findByLeaveRequestId(leaveRequestId);
			LeaveTypeMaster leaveTypeMaster = leaveTypeMasterLocalService.getLeaveTypeMaster(leaveRequest.getLeaveTypeMasterId());
			List<LeaveInformToTeamDetail> leaveInformToTeamList = leaveInformToTeamDetailLocalService.findByLeaveRequestId(leaveRequest.getLeaveRequestId());
			Map<Long,String> leaveInformToTeamMap = new HashMap<>();
			for(LeaveInformToTeamDetail leaveInformToTeamDetail: leaveInformToTeamList) {
				String employeeName = employeeDetailsLocalService.findByEmployeeId(leaveInformToTeamDetail.getEmployeeId()).getPersonalEmail();
				leaveInformToTeamMap.put(leaveInformToTeamDetail.getEmployeeId(),employeeName);
			}

			boolean isFestivalFloater = leavePolicyMasterLocalService.findByLeaveTypeMasterId(leaveRequest.getLeaveTypeMasterId()).getIsApplicableFloater();
			if(isFestivalFloater){
				Date date = leaveRequest.getStartDateTime();
				String floaterHolidayName = holidayLocalService.findByDate(date).getHolidayName();
				renderRequest.setAttribute(AxHrmsLeaveManagementWebPortletConstants.FLOATER_HOLIDAY_NAME, floaterHolidayName);
			}

			String leaveRequestStatus = leaveCompensatoryStatusMasterLocalService.findByLeaveCompensatoryStatusById(leaveRequest.getLeaveCompensatoryStatusMasterId()).getLeaveCompensatoryStatus();

			renderRequest.setAttribute(AxHrmsLeaveManagementWebPortletConstants.LEAVE_REQUEST, leaveRequest);
			renderRequest.setAttribute(AxHrmsLeaveManagementWebPortletConstants.LEAVE_DAY_TYPE_LIST, leaveDayTypeList);
			renderRequest.setAttribute(AxHrmsLeaveManagementWebPortletConstants.LEAVE_TYPE_MASTER,leaveTypeMaster);
			renderRequest.setAttribute(AxHrmsLeaveManagementWebPortletConstants.LEAVE_INFORM_TO_TEAM_DETAIL_MAP,leaveInformToTeamMap);
			renderRequest.setAttribute(AxHrmsLeaveManagementWebPortletConstants.STATUS,leaveRequestStatus);
		} catch (Exception e) {
			log.error("ViewLeaveRequestDetailMVCRenderCommand >>> render ::: Exception: "+e.getMessage(), e);
		}
		return AxHrmsLeaveManagementWebPortletConstants.VIEW_LEAVE_REQUEST_JSP_PATH;
	}

}
