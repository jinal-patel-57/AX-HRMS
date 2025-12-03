package com.ax.hrms.leave.management.employee.web.action;

import com.ax.hrms.common.api.api.AxHrmsCommonApi;
import com.ax.hrms.exception.NoSuchEmployeeDetailsException;
import com.ax.hrms.leave.management.employee.web.util.LeaveRequestUtil;
import com.ax.hrms.leave.management.web.constants.AxHrmsLeaveManagementSystemWebPortletKeys;
import com.ax.hrms.leave.management.web.constants.AxHrmsLeaveManagementWebPortletConstants;
import com.ax.hrms.leave.management.web.dto.LeaveRequestDto;
import com.ax.hrms.master.model.LeavePolicyMaster;
import com.ax.hrms.master.model.LeaveTypeMaster;
import com.ax.hrms.master.service.LeavePolicyMasterLocalService;
import com.ax.hrms.master.service.LeaveTypeMasterLocalService;
import com.ax.hrms.model.EmployeeDetails;
import com.ax.hrms.model.LeaveBalance;
import com.ax.hrms.service.EmployeeDetailsLocalService;
import com.ax.hrms.service.LeaveBalanceLocalService;
import com.ax.hrms.service.LeaveTypeViewPermitLocalService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.service.RoleLocalService;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;

import java.time.Year;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author krish.moradiya
 * @implNote Add Leave Request form render
 */
@Component(
        immediate = true,
        property = {
                "javax.portlet.name=" + AxHrmsLeaveManagementSystemWebPortletKeys.AXHRMS_EMPLOYEE_LEAVE_MANAGEMENT_SYSTEM_WEB_PORTLET,
                "mvc.command.name=/addLeaveRequest"
        },
        service = MVCRenderCommand.class
)
public class AddLeaveRequestMVCRenderCommand implements MVCRenderCommand {

	private static final Log log = LogFactoryUtil.getLog(AddLeaveRequestMVCRenderCommand.class);
	@Reference
	private	LeaveTypeMasterLocalService leaveTypeMasterLocalService;

	@Reference
	private LeavePolicyMasterLocalService leavePolicyMasterLocalService;

	@Reference
	private EmployeeDetailsLocalService employeeDetailsLocalService;

	@Reference
	private LeaveTypeViewPermitLocalService leaveTypeViewPermitLocalService;
	@Reference
	private LeaveBalanceLocalService leaveBalanceLocalService;
	@Reference
	private RoleLocalService roleLocalService;

	@Reference
	private UserLocalService userLocalService;
	

	
	private static int currentYear = Year.now().getValue();
	
	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		List<LeaveRequestDto> listOfLeaveTypeMaster = null;

		List<LeavePolicyMaster> listOfLeavePolicyMaster = leavePolicyMasterLocalService.getLeavePolicyMasters(-1,-1);
		List<EmployeeDetails> listOfEmployeeDetails = employeeDetailsLocalService.getEmployeeDetailses(-1,-1);
		List<LeaveBalance> leaveBalanceList = new ArrayList<>();

		/**
		 * @implNote : listOfFilteredEmployeeDetails is a list of Employee Details in which auth user's role is Employee
		 */
		List<EmployeeDetails> listOfFilteredEmployeeDetails = new ArrayList<>();
		
		for(EmployeeDetails employeeDetails : listOfEmployeeDetails) {
			
			try {
				long employeeRoleId = RoleLocalServiceUtil.getRole(themeDisplay.getCompanyId(), AxHrmsLeaveManagementWebPortletConstants.EMPLOYEE).getRoleId();
				long[] userRoles = userLocalService.getUserById(employeeDetails.getLrUserId()).getRoleIds();
				for(long userRole : userRoles) {
					if(userRole == employeeRoleId)
						listOfFilteredEmployeeDetails.add(employeeDetails);
				}
			} catch (PortalException e) {
				log.error("ViewLeaveRequestFormMVCRenderCommand >>> render ::: PortalException: "+e.getMessage());
			}catch (NullPointerException e) {
				log.error("ViewLeaveRequestFormMVCRenderCommand >>> render ::: NullPointerException: "+e.getMessage());
			}catch(Exception e) {
				log.error("ViewLeaveRequestFormMVCRenderCommand >>> render ::: Exception: "+e.getMessage());
			}
			
		}
		try{
			leaveBalanceList = leaveBalanceLocalService.findByEmployeeIdAndYear(employeeDetailsLocalService.findByLrUserId(themeDisplay.getUserId()).getEmployeeId(), currentYear);
			long hrRoleId = RoleLocalServiceUtil.getRole(themeDisplay.getCompanyId(), AxHrmsLeaveManagementWebPortletConstants.HR).getRoleId();
			long[] hrRoles = themeDisplay.getUser().getRoleIds();
			boolean isHr = Arrays.stream(hrRoles).anyMatch(id -> id == hrRoleId);
			if(isHr) {
				renderRequest.setAttribute(AxHrmsLeaveManagementWebPortletConstants.IS_HR_STATUS, isHr);
			}
		}catch(Exception e){
			log.error("ViewLeaveRequestFormMVCRenderCommand >>> render ::: Exception: "+e.getMessage());
		}
		List<LeaveTypeMaster> leaveTypeMasterList = leaveTypeMasterLocalService.getLeaveTypeMasters(-1,-1);

		try {
			listOfLeaveTypeMaster = LeaveRequestUtil.getListOfLeaveType(leaveTypeMasterList,leaveBalanceList,employeeDetailsLocalService.findByLrUserId(themeDisplay.getUserId()).getEmployeeId(),listOfLeavePolicyMaster);
		} catch (NoSuchEmployeeDetailsException e) {
			e.getMessage();
		}

		
		renderRequest.setAttribute(AxHrmsLeaveManagementWebPortletConstants.EMPLOYEE_DETAILS_LIST,listOfFilteredEmployeeDetails);
		renderRequest.setAttribute(AxHrmsLeaveManagementWebPortletConstants.LEAVE_TYPE_MASTER_LIST, listOfLeaveTypeMaster);
		return AxHrmsLeaveManagementWebPortletConstants.ADD_LEAVE_REQUEST_JSP_PATH;
	}
    
}