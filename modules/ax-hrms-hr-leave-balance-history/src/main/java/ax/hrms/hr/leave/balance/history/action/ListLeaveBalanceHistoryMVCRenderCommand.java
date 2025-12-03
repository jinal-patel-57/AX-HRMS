package ax.hrms.hr.leave.balance.history.action;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.ax.hrms.master.service.LeaveTypeMasterLocalService;
import com.ax.hrms.model.EmployeeDetails;
import com.ax.hrms.model.LeaveBalanceHistory;
import com.ax.hrms.service.EmployeeDetailsLocalService;
import com.ax.hrms.service.LeaveBalanceHistoryLocalService;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.PortletURLUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;

import ax.hrms.hr.leave.balance.history.constants.AxHrmsHrLeaveBalanceHistoryConstants;
import ax.hrms.hr.leave.balance.history.constants.AxHrmsHrLeaveBalanceHistoryPortletKeys;
import ax.hrms.hr.leave.balance.history.dto.LeaveBalanceHistoryDto;
import ax.hrms.hr.leave.balance.history.util.LeaveBalanceHistoryUtil;

@Component(immediate = true, property = {"javax.portlet.name="+AxHrmsHrLeaveBalanceHistoryPortletKeys.AXHRMSHRLEAVEBALANCEHISTORY , 
		"mvc.command.name=/"}, 
service = MVCRenderCommand.class)

public class ListLeaveBalanceHistoryMVCRenderCommand implements MVCRenderCommand{
	private static final Log log = LogFactoryUtil.getLog(ListLeaveBalanceHistoryMVCRenderCommand.class);
	
	@Reference
	private LeaveBalanceHistoryLocalService leaveBalanceHistoryLocalService;
	
	@Reference
	private EmployeeDetailsLocalService employeeDetailsLocalService;
	
	@Reference
	private LeaveTypeMasterLocalService leaveTypeMasterLocalService;
	
	
	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		try {
		
			
			
			
			Integer year = ParamUtil.getInteger(renderRequest,AxHrmsHrLeaveBalanceHistoryConstants.SELECTED_YEAR,0);
			long employeeId = ParamUtil.getLong(renderRequest,AxHrmsHrLeaveBalanceHistoryConstants.SELECTED_EMPLOYEE);
			
			LeaveBalanceHistoryUtil leaveBalanceUtil = new LeaveBalanceHistoryUtil(employeeDetailsLocalService, leaveBalanceHistoryLocalService, leaveTypeMasterLocalService);
			List<LeaveBalanceHistory> leaveBalanceHistoryList = new ArrayList<>();
			
			if(Validator.isNotNull(employeeId)&& year==0) {
				leaveBalanceHistoryList = leaveBalanceHistoryLocalService.findByEmployeeId(employeeId);
				renderRequest.setAttribute(AxHrmsHrLeaveBalanceHistoryConstants.SELECTED_EMPLOYEE,employeeId);

				
			}
			else if(Validator.isNull(employeeId) && year!=0) {
				leaveBalanceHistoryList = leaveBalanceHistoryLocalService.findByYear(year);
				renderRequest.setAttribute(AxHrmsHrLeaveBalanceHistoryConstants.SELECTED_YEAR,year);

				
			}
			else if(Validator.isNotNull(employeeId) && year!=0) {
				leaveBalanceHistoryList = leaveBalanceHistoryLocalService.findByEmployeeIdAndYear(employeeId, year);
				renderRequest.setAttribute(AxHrmsHrLeaveBalanceHistoryConstants.SELECTED_EMPLOYEE,employeeId);
				renderRequest.setAttribute(AxHrmsHrLeaveBalanceHistoryConstants.SELECTED_YEAR,year);

				
			}else {
			
				leaveBalanceHistoryList = leaveBalanceHistoryLocalService.getLeaveBalanceHistories(-1, -1);
			}
			
			
			
			
		
		PortletURL iteratorURL = PortletURLUtil.getCurrent(renderRequest, renderResponse);
		SearchContainer<LeaveBalanceHistoryDto> leaveBalanceHistorySearchContainer = new SearchContainer<>(renderRequest, iteratorURL, null,
				StringPool.BLANK);
		List<LeaveBalanceHistoryDto> leaveBalanceHistoryDtoList = leaveBalanceUtil.getLeaveData(leaveBalanceHistoryList);
		leaveBalanceHistorySearchContainer.setResultsAndTotal(leaveBalanceHistoryDtoList);
		List<Integer> yearList = leaveBalanceHistoryLocalService.getAllYear();
		
		List<EmployeeDetails> employeeDetailsList = employeeDetailsLocalService.getEmployeeDetailses(-1, -1);
			
		
		

		renderRequest.setAttribute(AxHrmsHrLeaveBalanceHistoryConstants.LEAVE_BALANCE_HISTROY_SEARCH_CONTAINER, leaveBalanceHistorySearchContainer);
		renderRequest.setAttribute(AxHrmsHrLeaveBalanceHistoryConstants.ITERATOR_URL,renderResponse.createRenderURL());
		renderRequest.setAttribute(AxHrmsHrLeaveBalanceHistoryConstants.YEAR_LIST,yearList);
		renderRequest.setAttribute(AxHrmsHrLeaveBalanceHistoryConstants.EMPLOYEE_DETAILS_LIST,employeeDetailsList);
	
		
		}catch(Exception e) {
			log.error("ListLeaveBalanceHistoryMVCRenderCommand >>> "+ e.getMessage());
		}

		
		return AxHrmsHrLeaveBalanceHistoryConstants.LIST_LEAVE_BALANCE_HISTROY_JSP;
	}

	
	
}
