package com.ax.hrms.leave.management.manager.web.action;

import com.ax.hrms.leave.management.hr.web.util.AxHrmsHrLeaveRequestWebUtil;
import com.ax.hrms.leave.management.web.constants.AxHrmsHrLeaveManagementSystemWebPortletConstants;
import com.ax.hrms.leave.management.web.constants.AxHrmsLeaveManagementSystemWebPortletKeys;
import com.ax.hrms.leave.management.web.dto.LeaveRequestDto;
import com.ax.hrms.master.service.DepartmentMasterLocalService;
import com.ax.hrms.master.service.DesignationMasterLocalService;
import com.ax.hrms.master.service.LeaveCompensatoryStatusMasterLocalService;
import com.ax.hrms.master.service.LeaveTypeMasterLocalService;
import com.ax.hrms.service.*;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import java.util.List;

/**
 * 
 * @author keval.kathiriya
 *
 */
@Component(immediate = true, property = {
		"javax.portlet.name=" + AxHrmsLeaveManagementSystemWebPortletKeys.AXHRMS_MANAGER_LEAVE_MANAGEMENT_SYSTEM_WEB_PORTLET,
		"mvc.command.name=/leave/view"}, service = MVCRenderCommand.class)

public class ViewLeaveRequestMVCRenderCommand implements MVCRenderCommand {
	private static final Log log = LogFactoryUtil.getLog(ViewLeaveRequestMVCRenderCommand.class);

	@Reference
	EmployeeDetailsLocalService employeeDetailsLocalService;

	@Reference
	EmployeeDepartmentLocalService employeeDepartmentLocalService;

	@Reference
	EmployeeDesignationLocalService employeeDesignationLocalService;

	@Reference
	LeaveTypeMasterLocalService leaveTypeMasterLocalService;

	@Reference
	LeaveRequestLocalService leaveRequestLocalService;

	@Reference
	LeaveCompensatoryStatusMasterLocalService leaveCompensatoryStatusMasterLocalService;

	@Reference
	DepartmentMasterLocalService departmentMasterLocalService;

	@Reference
	DesignationMasterLocalService designationMasterLocalService;

	@Reference
	LeaveBalanceLocalService leaveBalanceLocalService;

	@Reference
	LeaveDayTypeLocalService leaveDayTypeLocalService;
	
	@Reference
	AxHrmsHrLeaveRequestWebUtil leaveRequestUtil;
	
	@Reference
    CommentLocalService commentLocalService;

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse)  {
		Long leaveRequestId = ParamUtil.getLong(renderRequest,
				AxHrmsHrLeaveManagementSystemWebPortletConstants.LEAVE_REQUEST_ID);
		try {
            log.info("I am here ok....");
			LeaveRequestDto	leaveRequestDto = leaveRequestUtil.setLeaveRequestData(leaveRequestId);
			List<LeaveRequestDto> leaveRequestDtoListForDate = leaveRequestUtil.getLeaveDayTypeData(leaveRequestId);

			renderRequest.setAttribute(AxHrmsHrLeaveManagementSystemWebPortletConstants.LEAVE_REQUEST_DTO, leaveRequestDto);
			renderRequest.setAttribute(AxHrmsHrLeaveManagementSystemWebPortletConstants.LEAVE_DAY_TYPE_LIST,
					leaveRequestDtoListForDate);

		} catch (PortalException e) {
			log.error("ViewLeaveRequestMVCRenderCommand >>> Render >> Error in SetLeaveRequestData Method.!!"
					+ e.getMessage());

		}

		return AxHrmsHrLeaveManagementSystemWebPortletConstants.VIEW_LEAVE_REQUEST_JSP_MANAGER;
	}

	
}
