package com.ax.hrms.leave.management.hr.web.action;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.ax.hrms.leave.management.hr.web.util.AxHrmsHrLeaveRequestWebUtil;
import com.ax.hrms.leave.management.web.constants.AxHrmsHrLeaveManagementSystemWebPortletConstants;
import com.ax.hrms.leave.management.web.constants.AxHrmsLeaveManagementSystemWebPortletKeys;
import com.ax.hrms.leave.management.web.dto.LeaveRequestDto;
import com.ax.hrms.master.service.DepartmentMasterLocalService;
import com.ax.hrms.master.service.DesignationMasterLocalService;
import com.ax.hrms.master.service.LeaveCompensatoryStatusMasterLocalService;
import com.ax.hrms.master.service.LeaveTypeMasterLocalService;
import com.ax.hrms.model.LeaveRequest;
import com.ax.hrms.service.EmployeeDepartmentLocalService;
import com.ax.hrms.service.EmployeeDesignationLocalService;
import com.ax.hrms.service.EmployeeDetailsLocalService;
import com.ax.hrms.service.LeaveDayTypeLocalService;
import com.ax.hrms.service.LeaveRequestLocalService;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.ParamUtil;

/**
 * 
 * @author keval.kathiriya
 *
 */
@Component(immediate = true, property = {
		"javax.portlet.name=" + AxHrmsLeaveManagementSystemWebPortletKeys.AXHRMS_HR_LEAVE_MANAGEMENT_SYSTEM_WEB_PORTLET,
		"mvc.command.name="
				+ AxHrmsHrLeaveManagementSystemWebPortletConstants.DEFAULT_JSP }, service = MVCRenderCommand.class)

public class ListLeaveRequestMVCRenderCommand implements MVCRenderCommand {
	private static final Log log = LogFactoryUtil.getLog(ListLeaveRequestMVCRenderCommand.class);

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
	LeaveDayTypeLocalService leaveDayTypeLocalService;
	
	@Reference
	AxHrmsHrLeaveRequestWebUtil leaveRequestWebUtil;

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse)  {
		int curValue = ParamUtil.getInteger(renderRequest, SearchContainer.DEFAULT_CUR_PARAM, 1);
		int deltaValue = ParamUtil.getInteger(renderRequest, SearchContainer.DEFAULT_DELTA_PARAM, 3);

		int totalLeaveRequest = leaveRequestLocalService.getLeaveRequestsCount();
		int totalPageContainer = (totalLeaveRequest + deltaValue - 1) / deltaValue;

		if (curValue > totalPageContainer) {
			curValue = totalPageContainer;
		}

		int start = (curValue - 1) * deltaValue;
		int end = start + deltaValue;

		List<LeaveRequest> leaveRequestList = leaveRequestLocalService.getLeaveRequests(start, end);

		List<LeaveRequestDto> leaveRequestDtoList = new ArrayList<>();
		try {
			for (LeaveRequest leaveRequest : leaveRequestList) {
				LeaveRequestDto leaveRequestDto = leaveRequestWebUtil.setLeaveRequestData(
						leaveRequest.getLeaveRequestId());
				leaveRequestDtoList.add(leaveRequestDto);

			}

			// set leave Status

			long approvedId = leaveRequestWebUtil.getLeaveStatusId(
					AxHrmsHrLeaveManagementSystemWebPortletConstants.APPROVED);
			long rejectedId = leaveRequestWebUtil.getLeaveStatusId(
					AxHrmsHrLeaveManagementSystemWebPortletConstants.REJECTED);
			long cancelId = leaveRequestWebUtil.getLeaveStatusId(
					AxHrmsHrLeaveManagementSystemWebPortletConstants.CANCELLED);

			renderRequest.setAttribute(AxHrmsHrLeaveManagementSystemWebPortletConstants.TOTAL_LEAVE_REQUEST,
					totalLeaveRequest);
			renderRequest.setAttribute(SearchContainer.DEFAULT_DELTA_PARAM, deltaValue);
			renderRequest.setAttribute(AxHrmsHrLeaveManagementSystemWebPortletConstants.LEAVE_REQUEST_LIST,
					leaveRequestDtoList);
			renderRequest.setAttribute(AxHrmsHrLeaveManagementSystemWebPortletConstants.APPROVED_ID, approvedId);
			renderRequest.setAttribute(AxHrmsHrLeaveManagementSystemWebPortletConstants.REJECTED_ID, rejectedId);
			renderRequest.setAttribute(AxHrmsHrLeaveManagementSystemWebPortletConstants.CANCELLED_ID, cancelId);

			renderRequest.setAttribute(AxHrmsHrLeaveManagementSystemWebPortletConstants.ITERATOR_URL,
					renderResponse.createRenderURL());

		} catch (Exception e) {
			log.error("ListLeaveRequestMVCRenderCommand >>> Render >>> " + e.getMessage());
		}
		return AxHrmsHrLeaveManagementSystemWebPortletConstants.LIST_VIEW_LEAVE_REQUEST_JSP;
	}

}
