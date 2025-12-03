package com.ax.hrms.leave.report.web.action;

import java.time.Year;
import java.util.ArrayList;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.ax.hrms.leave.report.web.Dto.LeaveReportDto;
import com.ax.hrms.leave.report.web.constants.AxHrmsLeaveReportWebConstants;
import com.ax.hrms.leave.report.web.constants.AxHrmsLeaveReportWebPortletKeys;
import com.ax.hrms.master.service.LeaveTypeMasterLocalService;
import com.ax.hrms.model.LeaveBalance;
import com.ax.hrms.service.EmployeeDetailsLocalService;
import com.ax.hrms.service.LeaveBalanceLocalService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;

@Component(
	    immediate = true,
	    property = {
	        "javax.portlet.name=" + AxHrmsLeaveReportWebPortletKeys.AXHRMSLEAVEREPORTWEB,
	        "mvc.command.name=/"
	    },
	    service = MVCRenderCommand.class
	)

public class FetchLeaveReportMVCRenderCommand implements MVCRenderCommand {
	
	private static final Log log = LogFactoryUtil.getLog(FetchLeaveReportMVCRenderCommand.class);
	@Reference
	LeaveBalanceLocalService leaveBalanceLocalService;
	
	@Reference
	EmployeeDetailsLocalService employeeDetailsLocalService;
	@Reference
	LeaveTypeMasterLocalService leaveTypeMasterLocalService;

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		
		
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		try {
		
		int year = Year.now().getValue();
		
		
		renderRequest.setAttribute(AxHrmsLeaveReportWebConstants.CURRENT_YEAR, year);
		List<LeaveBalance> leaveReportList = leaveBalanceLocalService.findByEmployeeId(employeeDetailsLocalService.findByLrUserId(themeDisplay.getUserId()).getEmployeeId()); 
		List<LeaveReportDto> leaveReportDtoList = getLeaveReportData(leaveReportList);
		
		renderRequest.setAttribute(AxHrmsLeaveReportWebConstants.LEAVE_REPORT_DTO_LIST, leaveReportDtoList);
		}catch(Exception e) {
			log.error("FetchLeaveReportMVCRenderCommand >>> "+ e.getMessage());
		}
		return AxHrmsLeaveReportWebConstants.VIEW_LEAVEREPORT;
	}
	private List<LeaveReportDto> getLeaveReportData(List<LeaveBalance> leaveReportList) throws PortalException{
		List<LeaveReportDto> leaveReportDtoList= new ArrayList<>();
		for(LeaveBalance leaveReport :leaveReportList ) {
			LeaveReportDto leaveDto = new LeaveReportDto();
			leaveDto.setLeaveTypeName(leaveTypeMasterLocalService.getLeaveTypeMaster(leaveReport.getLeaveTypeMasterId()).getLeaveTypeName());
			leaveDto.setRemainingDays(leaveReport.getNoOfRemainingLeaves());
			leaveDto.setUsedDays(leaveReport.getNoOfUsedLeaves());
			leaveDto.setYear(leaveReport.getYear());
			leaveReportDtoList.add(leaveDto);
			
			
			
		}
		return leaveReportDtoList;
	}

}
