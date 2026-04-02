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
import com.liferay.petra.sql.dsl.DSLQueryFactoryUtil;
import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import static com.ax.hrms.model.LeaveRequestTable.INSTANCE;

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
        log.info("ListEmployeeLeaveRequestMVCRenderCommand render");
        
        ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
        long lrUserId = themeDisplay.getUserId();
        List<LeaveCompensatoryStatusMaster> statusList =
                leaveCompensatoryStatusMasterLocalService.getLeaveCompensatoryStatusMasters(-1, -1);
        List<LeaveRequestDto> leaveRequestDtoList = new ArrayList<>();


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
        
        long employeeId = ParamUtil.getLong(renderRequest, "employeeId");

        log.info("Manager Employee ID resolved = " + managerEmployeeId);


        List<EmployeeDetails> employeesUnderManager =
                employeeDetailsLocalService.findByManagerId(managerEmployeeId);
    	List<Long> employeeIds;
        if(employeeId>0) {
        	employeeIds = List.of(employeeId);
        	renderRequest.setAttribute("employeeId", employeeId);
        } else {
        	employeeIds = employeesUnderManager.stream()
        			.map(EmployeeDetails::getEmployeeId)
        			.toList();
        }
        
        renderRequest.setAttribute("employeeList", employeesUnderManager);
        
        log.info("Employees under manager: " + employeesUnderManager.size());
        log.info("Employee List: " + employeesUnderManager);


        List<LeaveRequest> managerLeaveList = new ArrayList<>();
        List<LeaveWithEmployeeDTO> finalList = new ArrayList<>();
        if (!employeeIds.isEmpty()) {

            DSLQuery dslQuery =
                    DSLQueryFactoryUtil.select(INSTANCE)
                            .from(INSTANCE)
                            .where(INSTANCE.employeeId.in(
                                    employeeIds.toArray(new Long[0])
                            ))
                            .orderBy(INSTANCE.createDate.descending());
            managerLeaveList =
                    leaveRequestLocalService.dslQuery(dslQuery);
        }


        for (LeaveRequest lr : managerLeaveList) {
            try {
                LeaveRequestDto leaveRequestDto =
                        axHrmsManagerLeaveRequestWebUtil
                                .setLeaveRequestData(lr.getLeaveRequestId());

                leaveRequestDtoList.add(leaveRequestDto);

            } catch (PortalException e) {
                log.error("Error fetching leave request details for ID: " + lr.getLeaveRequestId(), e);
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

        EmployeeDetails currentEmployee = null;
        try {
            currentEmployee = employeeDetailsLocalService.findByLrUserId(themeDisplay.getUserId());
            renderRequest.setAttribute("currentEmployeeId", currentEmployee.getEmployeeId());
        } catch (NoSuchEmployeeDetailsException e) {
            renderRequest.setAttribute("currentEmployeeId", 0);
            log.error("No employee details found for LR User ID: " + themeDisplay.getUserId(), e);
        }


        int deltaValue = ParamUtil.getInteger(renderRequest, SearchContainer.DEFAULT_DELTA_PARAM, 20);
        int curValue = ParamUtil.getInteger(renderRequest, SearchContainer.DEFAULT_CUR_PARAM, 1);
        
        int total = leaveRequestDtoList.size();
        int totalPages = (total + deltaValue - 1) / deltaValue;
        if (totalPages == 0) totalPages = 1;
        if (curValue > totalPages) curValue = totalPages;
        if (curValue < 1) curValue = 1;

        int start = (curValue - 1) * deltaValue;
        int end = Math.min(start + deltaValue, total);

        List<LeaveRequestDto> pagedList = total > 0 ? leaveRequestDtoList.subList(start, end) : leaveRequestDtoList;
        renderRequest.setAttribute("managerLeaves", pagedList);
        renderRequest.setAttribute("totalManagerLeaves", total);
        renderRequest.setAttribute(SearchContainer.DEFAULT_DELTA_PARAM, deltaValue);
        
        
        renderRequest.setAttribute(APPROVED_ID, approvedId);
        renderRequest.setAttribute(REJECTED_ID, rejectedId);
        renderRequest.setAttribute(CANCELLED_ID, cancelId);
        // Send data to JSP
        //renderRequest.setAttribute("managerLeaves", leaveRequestDtoList);

        return "/jsp/ax-hrms-leave-management-manager/listLeaveRequest.jsp";
    }
    
}
