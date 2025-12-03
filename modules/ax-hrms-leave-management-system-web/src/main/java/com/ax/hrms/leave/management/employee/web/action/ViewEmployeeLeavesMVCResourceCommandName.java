package com.ax.hrms.leave.management.employee.web.action;


import com.ax.hrms.leave.management.employee.web.util.LeaveRequestUtil;
import com.ax.hrms.leave.management.web.constants.AxHrmsLeaveManagementSystemWebPortletKeys;
import com.ax.hrms.leave.management.web.constants.AxHrmsLeaveManagementWebPortletConstants;
import com.ax.hrms.leave.management.web.dto.LeaveRequestDto;
import com.ax.hrms.master.model.LeavePolicyMaster;
import com.ax.hrms.master.model.LeaveTypeMaster;
import com.ax.hrms.master.service.LeavePolicyMasterLocalService;
import com.ax.hrms.master.service.LeaveTypeMasterLocalService;
import com.ax.hrms.model.LeaveBalance;
import com.ax.hrms.service.EmployeeDetailsLocalService;
import com.ax.hrms.service.LeaveBalanceLocalService;
import com.ax.hrms.service.LeaveTypeViewPermitLocalService;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.service.RoleLocalService;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.util.ParamUtil;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import java.io.PrintWriter;
import java.time.Year;
import java.util.List;

/**
 * @author krish.moradiya
 * @implNote : Resource Command in which after HR select employee name than they see only that employee list in leaveTypeList DropDown
 */
@Component(
        immediate = true,
        property = {
                "javax.portlet.name=" + AxHrmsLeaveManagementSystemWebPortletKeys.AXHRMS_EMPLOYEE_LEAVE_MANAGEMENT_SYSTEM_WEB_PORTLET,
                "mvc.command.name=/viewEmployeeLeavesDetail"
        },
        service = MVCResourceCommand.class
)
public class ViewEmployeeLeavesMVCResourceCommandName extends BaseMVCResourceCommand {

	@Reference
	private LeaveTypeMasterLocalService leaveTypeMasterLocalService;

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
	protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws Exception {


		long employeeId = ParamUtil.getLong(resourceRequest,AxHrmsLeaveManagementWebPortletConstants.EMPLOYEE_ID_PARAM_NAME, AxHrmsLeaveManagementWebPortletConstants.DEFAULT_LONG_VALUE);
		List<LeaveRequestDto> listOfLeaveTypeMaster = null;

		List<LeavePolicyMaster> listOfLeavePolicyMaster = leavePolicyMasterLocalService.getLeavePolicyMasters(-1,-1);

		List<LeaveTypeMaster> leaveTypeMasterList = leaveTypeMasterLocalService.getLeaveTypeMasters(-1,-1);
		List<LeaveBalance> leaveBalanceList = leaveBalanceLocalService.findByEmployeeIdAndYear(employeeId,currentYear);


		listOfLeaveTypeMaster = LeaveRequestUtil.getListOfLeaveType(leaveTypeMasterList,leaveBalanceList,employeeId,listOfLeavePolicyMaster);

		
        JSONObject jsonobj =  JSONFactoryUtil.createJSONObject();
		PrintWriter printout=resourceResponse.getWriter();
		jsonobj.put(AxHrmsLeaveManagementWebPortletConstants.DATA,listOfLeaveTypeMaster);
		jsonobj.put(AxHrmsLeaveManagementWebPortletConstants.STATUS, AxHrmsLeaveManagementWebPortletConstants.SUCCESS);
		printout.write(jsonobj.toString());
	    printout.close();

	}


}
