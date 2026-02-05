//package com.ax.hrms.leave.management.manager.web.action;
//
//import com.ax.hrms.common.api.api.AxHrmsCommonApi;
//import com.ax.hrms.leave.management.web.constants.AxHrmsLeaveManagementSystemWebPortletKeys;
//import com.ax.hrms.master.service.LeaveCompensatoryStatusMasterLocalService;
//import com.ax.hrms.master.service.LeaveTypeMasterLocalService;
//import com.ax.hrms.master.service.ProbationStatusMasterLocalService;
//import com.ax.hrms.model.EmployeeDetails;
//import com.ax.hrms.model.LeaveRequest;
//import com.ax.hrms.service.EmployeeDetailsLocalService;
//import com.ax.hrms.service.LeaveDayTypeLocalService;
//import com.ax.hrms.service.LeaveRequestLocalService;
//import com.liferay.portal.kernel.dao.search.SearchContainer;
//import com.liferay.portal.kernel.log.Log;
//import com.liferay.portal.kernel.log.LogFactoryUtil;
//import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
//import com.liferay.portal.kernel.theme.ThemeDisplay;
//import com.liferay.portal.kernel.util.ParamUtil;
//import com.liferay.portal.kernel.util.WebKeys;
//import org.osgi.service.component.annotations.Component;
//import org.osgi.service.component.annotations.Reference;
//
//import javax.portlet.PortletException;
//import javax.portlet.RenderRequest;
//import javax.portlet.RenderResponse;
//import java.util.ArrayList;
//import java.util.List;
//
///**
// *
// * @author krish.moradiya
// * @implNote : Show/Give List of leave request in view page
// */
//@Component(
//        immediate = true,
//        property = {
//                "javax.portlet.name=" + AxHrmsLeaveManagementSystemWebPortletKeys.AXHRMS_MANAGER_LEAVE_MANAGEMENT_SYSTEM_WEB_PORTLET,
//                "mvc.command.name=/"
//        },
//        service = MVCRenderCommand.class
//)
//public class ListEmployeeLeaveRequestMVCRenderCommand implements MVCRenderCommand {
//
//    private static final Log log = LogFactoryUtil.getLog(ListEmployeeLeaveRequestMVCRenderCommand.class);
//
//    @Reference
//    private LeaveRequestLocalService leaveRequestLocalService;
//
//    @Reference
//    private EmployeeDetailsLocalService employeeDetailsLocalService;
//
//    @Reference
//	private LeaveTypeMasterLocalService leaveTypeMasterLocalService;
//
//	@Reference
//	private LeaveDayTypeLocalService leaveDayTypeLocalService;
//
//	@Reference
//	private LeaveCompensatoryStatusMasterLocalService leaveCompensatoryStatusMasterLocalService;
//
//    @Reference
//    private ProbationStatusMasterLocalService probationStatusMasterLocalService;
//	@Reference
//	private AxHrmsCommonApi axHrmsCommonApi;
//
//
//    @Override
//    public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
//
//        int curValue = ParamUtil.getInteger(renderRequest, SearchContainer.DEFAULT_CUR_PARAM,1);
//        int deltaValue = ParamUtil.getInteger(renderRequest, SearchContainer.DEFAULT_DELTA_PARAM,3);
//
//        ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
//        long userId = themeDisplay.getUserId();
//        System.out.println("kkkkkkkkkkkkkkkk......................"+ employeeDetailsLocalService.getEmployeeIdByLruserid(userId));
//
//
//
//
//        List<EmployeeDetails> employeesUnderManager =
//                employeeDetailsLocalService.findByManagerId(employeeDetailsLocalService.getEmployeeIdByLruserid(userId).get(0));
//        System.out.println("Employees under manager: " + employeesUnderManager.size());
//        System.out.println("Employees: " + employeesUnderManager);
//
////
////        //  Fetch leave requests for all employees under this manager
////        List<LeaveRequest> managerLeaveList = new ArrayList<>();
////        for (EmployeeDetails emp : employeesUnderManager) {
////            long empId = emp.getEmployeeId();
////            System.out.println("Fetching leaves for employee: " + empId);
////
////            List<LeaveRequest> empLeaves = leaveRequestLocalService.findByEmployeeId(empId);
////
////            managerLeaveList.addAll(empLeaves);
////        }
////        System.out.println("Total leaves found for manager's team: " + managerLeaveList.size());
////        renderRequest.setAttribute("managerLeaves", managerLeaveList);
//
//        return "/jsp/ax-hrms-leave-management-manager/listLeaveRequest.jsp";
//    }
//}















package com.ax.hrms.leave.management.manager.web.action;

import com.ax.hrms.common.api.api.AxHrmsCommonApi;
import com.ax.hrms.exception.NoSuchEmployeeDetailsException;
import com.ax.hrms.leave.management.manager.web.dto.LeaveWithEmployeeDTO;
import com.ax.hrms.leave.management.manager.web.util.AxHrmsManagerLeaveRequestWebUtil;
import com.ax.hrms.leave.management.web.constants.AxHrmsLeaveManagementSystemWebPortletKeys;
import com.ax.hrms.leave.management.web.dto.LeaveRequestDto;
import com.ax.hrms.master.model.LeaveCompensatoryStatusMaster;
import com.ax.hrms.master.service.LeaveCompensatoryStatusMasterLocalService;
import com.ax.hrms.master.service.LeaveTypeMasterLocalService;
import com.ax.hrms.master.service.ProbationStatusMasterLocalService;
import com.ax.hrms.model.EmployeeDetails;
import com.ax.hrms.model.LeaveRequest;
import com.ax.hrms.service.EmployeeDetailsLocalService;
import com.ax.hrms.service.LeaveDayTypeLocalService;
import com.ax.hrms.service.LeaveRequestLocalService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Component(
        immediate = true,
        property = {
                "javax.portlet.name=" + AxHrmsLeaveManagementSystemWebPortletKeys.AXHRMS_MANAGER_LEAVE_MANAGEMENT_SYSTEM_WEB_PORTLET,
                "mvc.command.name=/"
        },
        service = MVCRenderCommand.class
)
public class ListEmployeeLeaveRequestMVCRenderCommand implements MVCRenderCommand {
    public static final String APPROVED_ID = "approvedId";
    public static final String REJECTED_ID = "rejectedId";
    public static final String CANCELLED_ID = "cancelId";
    private static final Log log = LogFactoryUtil.getLog(ListEmployeeLeaveRequestMVCRenderCommand.class);
    public static final String APPROVED = "Approved";
    public static final String REJECTED = "Rejected";
    public static final String CANCELLED = "Cancelled";
    @Reference private LeaveRequestLocalService leaveRequestLocalService;
    @Reference private EmployeeDetailsLocalService employeeDetailsLocalService;
    @Reference private LeaveTypeMasterLocalService leaveTypeMasterLocalService;
    @Reference private LeaveDayTypeLocalService leaveDayTypeLocalService;
    @Reference private LeaveCompensatoryStatusMasterLocalService leaveCompensatoryStatusMasterLocalService;
    @Reference private ProbationStatusMasterLocalService probationStatusMasterLocalService;
    @Reference private AxHrmsCommonApi axHrmsCommonApi;
    @Reference AxHrmsManagerLeaveRequestWebUtil axHrmsManagerLeaveRequestWebUtil;
    @Override
    public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
        System.out.println("ListEmployeeLeaveRequestMVCRenderCommand render");
        ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
        long lrUserId = themeDisplay.getUserId();
        List<LeaveCompensatoryStatusMaster> statusList =
                leaveCompensatoryStatusMasterLocalService.getLeaveCompensatoryStatusMasters(-1, -1);
        List<LeaveRequestDto> leaveRequestDtoList = new ArrayList<>();

        // ===========================================
        //  GET EMPLOYEE ID FROM LR USER ID (returns List<BigInteger>)
        // ===========================================
        List<Long> empIdList = employeeDetailsLocalService.getEmployeeIdByLruserid(lrUserId);

        if (empIdList == null || empIdList.isEmpty()) {
            log.error("No employee record found for LR User ID: " + lrUserId);
            renderRequest.setAttribute("managerLeaves", new ArrayList<>());
            return "/jsp/ax-hrms-leave-management-manager/listLeaveRequest.jsp";
        }

        // Convert BigInteger → long
        long managerEmployeeId;
        Object obj = empIdList.get(0);

        if (obj instanceof BigInteger) {
            managerEmployeeId = ((BigInteger) obj).longValue();
        } else {
            managerEmployeeId = Long.parseLong(obj.toString());
        }

        log.info("Manager Employee ID resolved = " + managerEmployeeId);

        // ===========================================
        // GET EMPLOYEES UNDER THIS MANAGER
        // ===========================================
        List<EmployeeDetails> employeesUnderManager =
                employeeDetailsLocalService.findByManagerId(managerEmployeeId);

        log.info("Employees under manager: " + employeesUnderManager.size());
        log.info("Employee List: " + employeesUnderManager);

        // ===========================================
        // FETCH LEAVE REQUESTS FOR ALL EMPLOYEES
        // ===========================================
        List<LeaveRequest> managerLeaveList = new ArrayList<>();
        List<LeaveWithEmployeeDTO> finalList = new ArrayList<>();

        for (EmployeeDetails emp : employeesUnderManager) {
            long empId = emp.getEmployeeId();
            log.info("Fetching leaves for employeeId: " + empId);

            List<LeaveRequest> empLeaves = leaveRequestLocalService.findByEmployeeId(empId);

//            managerLeaveList.addAll(empLeaves);
            for (LeaveRequest lr : empLeaves) {
                try {
                    log.info("Processing Leave Request: " + lr);
                    LeaveRequestDto leaveRequestDto = axHrmsManagerLeaveRequestWebUtil.setLeaveRequestData(
                            lr.getLeaveRequestId());
                    leaveRequestDtoList.add(leaveRequestDto);

                } catch (PortalException e) {
                    throw new RuntimeException(e);
                }
                // Convert statusId → statusName
//                String statusName =  statusList.stream()
//                        .filter(s -> s.getLeaveCompensatoryStatusMasterId() == lr.getLeaveCompensatoryStatusMasterId())
//                        .map(s -> s.getLeaveCompensatoryStatus())
//                        .findFirst()
//                        .orElse("Unknown");

                // Add to final DTO
//                finalList.add(new LeaveWithEmployeeDTO(lr, emp, statusName));
            }
        }

        log.info("Hello from this......................");
        // set leave Status
        long approvedId = axHrmsManagerLeaveRequestWebUtil.getLeaveStatusId(
                APPROVED);
        long rejectedId = axHrmsManagerLeaveRequestWebUtil.getLeaveStatusId(
                REJECTED);
        long cancelId = axHrmsManagerLeaveRequestWebUtil.getLeaveStatusId(
                CANCELLED);
        log.info("Total leave requests found for team = " + managerLeaveList.size());
        log.info(" leave requests found for team = " + managerLeaveList);
        log.info("Total leave requests found = " + finalList.size());

        EmployeeDetails currentEmployee = null;
        try {
            currentEmployee = employeeDetailsLocalService.findByLrUserId(themeDisplay.getUserId());
            renderRequest.setAttribute("currentEmployeeId", currentEmployee.getEmployeeId());
        } catch (NoSuchEmployeeDetailsException e) {
            renderRequest.setAttribute("currentEmployeeId", 0);
            throw new RuntimeException(e);
        }


        renderRequest.setAttribute(APPROVED_ID, approvedId);
        renderRequest.setAttribute(REJECTED_ID, rejectedId);
        renderRequest.setAttribute(CANCELLED_ID, cancelId);
        // Send data to JSP
        renderRequest.setAttribute("managerLeaves", leaveRequestDtoList);

        return "/jsp/ax-hrms-leave-management-manager/listLeaveRequest.jsp";
    }
}
