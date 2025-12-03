package com.ax.hrms.leave.management.employee.web.action;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.ax.hrms.common.api.api.AxHrmsCommonApi;
import com.ax.hrms.exception.NoSuchEmployeeDetailsException;
import com.ax.hrms.leave.management.employee.web.util.LeaveRequestUtil;
import com.ax.hrms.leave.management.web.constants.AxHrmsLeaveManagementSystemWebPortletKeys;
import com.ax.hrms.leave.management.web.constants.AxHrmsLeaveManagementWebPortletConstants;
import com.ax.hrms.leave.management.web.dto.LeaveRequestDto;
import com.ax.hrms.master.model.LeaveCompensatoryStatusMaster;
import com.ax.hrms.master.model.LeaveTypeMaster;
import com.ax.hrms.master.model.ProbationStatusMaster;
import com.ax.hrms.master.service.LeaveCompensatoryStatusMasterLocalService;
import com.ax.hrms.master.service.LeaveTypeMasterLocalService;
import com.ax.hrms.master.service.ProbationStatusMasterLocalService;
import com.ax.hrms.model.EmployeeDetails;
import com.ax.hrms.model.LeaveDayType;
import com.ax.hrms.model.LeaveRequest;
import com.ax.hrms.service.EmployeeDetailsLocalService;
import com.ax.hrms.service.LeaveDayTypeLocalService;
import com.ax.hrms.service.LeaveRequestLocalService;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;

/**
 * 
 * @author krish.moradiya
 * @implNote : Show/Give List of leave request in view page
 */
@Component(
        immediate = true,
        property = {
                "javax.portlet.name=" + AxHrmsLeaveManagementSystemWebPortletKeys.AXHRMS_EMPLOYEE_LEAVE_MANAGEMENT_SYSTEM_WEB_PORTLET,
                "mvc.command.name=/"
        },
        service = MVCRenderCommand.class
)
public class ListEmployeeLeaveRequestMVCRenderCommand implements MVCRenderCommand {

    private static final Log log = LogFactoryUtil.getLog(ListEmployeeLeaveRequestMVCRenderCommand.class);

    @Reference
    private LeaveRequestLocalService leaveRequestLocalService;
    
    @Reference
    private EmployeeDetailsLocalService employeeDetailsLocalService;
    
    @Reference
	private LeaveTypeMasterLocalService leaveTypeMasterLocalService;
	
	@Reference
	private LeaveDayTypeLocalService leaveDayTypeLocalService;
	
	@Reference
	private LeaveCompensatoryStatusMasterLocalService leaveCompensatoryStatusMasterLocalService;

    @Reference
    private ProbationStatusMasterLocalService probationStatusMasterLocalService;
	@Reference
	private AxHrmsCommonApi axHrmsCommonApi;
    

    @Override
    public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {

        int curValue = ParamUtil.getInteger(renderRequest, SearchContainer.DEFAULT_CUR_PARAM,1);
        int deltaValue = ParamUtil.getInteger(renderRequest, SearchContainer.DEFAULT_DELTA_PARAM,3);

        ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
        long userId = themeDisplay.getUserId();
        boolean isApplicableForLeave = true;

        List<LeaveRequestDto> listOfEmployeesLeaveRequest = new ArrayList<>();

        List<ProbationStatusMaster> probationStatusMasterList = probationStatusMasterLocalService.getProbationStatusMasters(-1,-1);
        long[] probationStatusMasterIds = new long[2];
        int count = 0;
        for(ProbationStatusMaster probationStatusMaster : probationStatusMasterList){
            if(probationStatusMaster.getStatusType().equalsIgnoreCase(AxHrmsLeaveManagementWebPortletConstants.IN_PROBATION) || probationStatusMaster.getStatusType().equalsIgnoreCase(AxHrmsLeaveManagementWebPortletConstants.EXTENDED))
                probationStatusMasterIds[count++] = probationStatusMaster.getProbationStatusMasterId();
        }
        
        EmployeeDetails employeeDetails = null;
		try {
			employeeDetails = employeeDetailsLocalService.findByLrUserId(userId);
            for(long probationStatusId : probationStatusMasterIds){
                if(employeeDetails.getProbationStatusId() == probationStatusId)
                    isApplicableForLeave = false;
            }

            if(employeeDetails != null) {
                List<LeaveRequest> listOfLeaveRequest = leaveRequestLocalService.findByEmployeeId(employeeDetails.getEmployeeId());
                List<LeaveTypeMaster> listOfLeaveTypeMaster = leaveTypeMasterLocalService.getLeaveTypeMasters(-1, -1);
                List<LeaveDayType> listOfLeaveDayType = leaveDayTypeLocalService.getLeaveDayTypes(-1, -1);
                List<LeaveCompensatoryStatusMaster> listOfLeaveCompensatoryStatusMasters = leaveCompensatoryStatusMasterLocalService.getLeaveCompensatoryStatusMasters(-1, -1);

                listOfEmployeesLeaveRequest = LeaveRequestUtil.getListOfLeaveRequest(employeeDetails,listOfLeaveRequest,listOfLeaveTypeMaster,listOfLeaveDayType,listOfLeaveCompensatoryStatusMasters);
            }

		} catch (NoSuchEmployeeDetailsException exception) {
			log.error("ListEmployeeLeaveRequestMVCRenderCommand >>> render ::: NoSuchEmployeeDetailsException is: "+exception.getMessage());
		}catch(NullPointerException exception){
            log.error("ListEmployeeLeaveRequestMVCRenderCommand >>> render ::: NullPointerException is: "+exception.getMessage());
        }catch(Exception exception){
            log.error("ListEmployeeLeaveRequestMVCRenderCommand >>> render ::: Exception Occur when fetching auth user's Leave Requests: "+exception.getMessage());
        }
        
        int totalLeaveRequest = listOfEmployeesLeaveRequest.size();
        int totalPageContainer = (totalLeaveRequest + deltaValue - 1) / deltaValue;

        if (curValue > totalPageContainer) {
            curValue = totalPageContainer;
        }

        int start = (curValue - 1) * deltaValue;
        int end = start + deltaValue;

        if(end > totalLeaveRequest)
            end = totalLeaveRequest;
        if(totalLeaveRequest == 0)
            start = 0;
        
        boolean isIntern = axHrmsCommonApi.isRolePerson(themeDisplay, "Intern");
		boolean isContractor = axHrmsCommonApi.isRolePerson(themeDisplay, "Contractor");
		
		isApplicableForLeave = isApplicableForLeave && !isIntern && !isContractor;
        renderRequest.setAttribute(AxHrmsLeaveManagementWebPortletConstants.TOTAL_LEAVE_REQUEST_OF_EMPLOYEE, totalLeaveRequest);
        renderRequest.setAttribute(SearchContainer.DEFAULT_DELTA_PARAM, deltaValue);
        renderRequest.setAttribute(AxHrmsLeaveManagementWebPortletConstants.LEAVE_REQUEST_LIST_VAR, listOfEmployeesLeaveRequest.subList(start,end));
        renderRequest.setAttribute(AxHrmsLeaveManagementWebPortletConstants.IS_APPLICABLE_FOR_LEAVE, isApplicableForLeave);
        renderRequest.setAttribute(AxHrmsLeaveManagementWebPortletConstants.ITERATOR_URL_VARIABLE_NAME, renderResponse.createRenderURL());

        return AxHrmsLeaveManagementWebPortletConstants.LIST_OF_LEAVE_REQUEST_JSP_PATH;
    }
}
