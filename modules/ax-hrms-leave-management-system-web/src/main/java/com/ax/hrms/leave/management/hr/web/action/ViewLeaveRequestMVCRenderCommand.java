package com.ax.hrms.leave.management.hr.web.action;

import com.ax.hrms.exception.NoSuchEmployeeDetailsException;
import com.ax.hrms.leave.management.hr.web.util.AxHrmsHrLeaveRequestWebUtil;
import com.ax.hrms.leave.management.web.constants.AxHrmsHrLeaveManagementSystemWebPortletConstants;
import com.ax.hrms.leave.management.web.constants.AxHrmsLeaveManagementSystemWebPortletKeys;
import com.ax.hrms.leave.management.web.dto.LeaveRequestDto;
import com.ax.hrms.master.service.DepartmentMasterLocalService;
import com.ax.hrms.master.service.DesignationMasterLocalService;
import com.ax.hrms.master.service.LeaveCompensatoryStatusMasterLocalService;
import com.ax.hrms.master.service.LeaveTypeMasterLocalService;
import com.ax.hrms.model.Comment;
import com.ax.hrms.model.EmployeeDetails;
import com.ax.hrms.service.CommentLocalService;
import com.ax.hrms.service.EmployeeDepartmentLocalService;
import com.ax.hrms.service.EmployeeDesignationLocalService;
import com.ax.hrms.service.EmployeeDetailsLocalService;
import com.ax.hrms.service.LeaveBalanceLocalService;
import com.ax.hrms.service.LeaveDayTypeLocalService;
import com.ax.hrms.service.LeaveRequestLocalService;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;

import java.util.List;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * 
 * @author keval.kathiriya
 *
 */
@Component(immediate = true, property = {
		"javax.portlet.name=" + AxHrmsLeaveManagementSystemWebPortletKeys.AXHRMS_HR_LEAVE_MANAGEMENT_SYSTEM_WEB_PORTLET,
		"mvc.command.name="
				+ AxHrmsHrLeaveManagementSystemWebPortletConstants.VIEW_LEAVE_REQUEST }, service = MVCRenderCommand.class)

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
			LeaveRequestDto	leaveRequestDto = leaveRequestUtil.setLeaveRequestData(leaveRequestId);
			List<LeaveRequestDto> leaveRequestDtoListForDate = leaveRequestUtil.getLeaveDayTypeData(leaveRequestId);
			
			try {
				List<Comment> commentList = commentLocalService.findByTypeRequestIdAndStatus(1,leaveRequestId, true);
				if (Validator.isNotNull(commentList) && !commentList.isEmpty()) {
					Comment comment = commentList.get(0);
					leaveRequestDto.setComment(comment.getComment());
					String commentByUserName = StringPool.DASH;
					try {
						EmployeeDetails commentedBy = employeeDetailsLocalService.findByLrUserId(comment.getCreatedBy());
						commentByUserName = commentedBy.getFirstName() + " " + commentedBy.getLastName();
					} catch(NoSuchEmployeeDetailsException e) {
                        log.error("No user found for the comment");
                    }
					leaveRequestDto.setCommentedBy(commentByUserName);
				}
			} catch(Exception e) {
                log.error("No comment found");
            }

			renderRequest.setAttribute(AxHrmsHrLeaveManagementSystemWebPortletConstants.LEAVE_REQUEST_DTO, leaveRequestDto);
			renderRequest.setAttribute(AxHrmsHrLeaveManagementSystemWebPortletConstants.LEAVE_DAY_TYPE_LIST,
					leaveRequestDtoListForDate);

		} catch (PortalException e) {
			log.error("ViewLeaveRequestMVCRenderCommand >>> Render >> Error in SetLeaveRequestData Method.!!"
					+ e.getMessage());

		}

		return AxHrmsHrLeaveManagementSystemWebPortletConstants.VIEW_LEAVE_REQUEST_JSP;
	}

	
}
