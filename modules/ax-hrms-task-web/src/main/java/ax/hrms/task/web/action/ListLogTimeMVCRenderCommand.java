package ax.hrms.task.web.action;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.ax.hrms.common.api.api.AxHrmsCommonApi;
import com.ax.hrms.model.TimeTracker;
import com.ax.hrms.service.AttachmentLocalService;
import com.ax.hrms.service.EmployeeDetailsLocalService;
import com.ax.hrms.service.ProjectLocalService;
import com.ax.hrms.service.TaskLocalService;
import com.ax.hrms.service.TaskReviewLocalService;
import com.ax.hrms.service.TimeTrackerLocalService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;

import ax.hrms.task.web.constants.AxHrmsTaskWebConstants;
import ax.hrms.task.web.constants.AxHrmsTaskWebPortletKeys;
import ax.hrms.task.web.dto.TaskDto;
import ax.hrms.task.web.util.TaskWebUtil;

@Component(immediate = true, property = {
		"javax.portlet.name=" + AxHrmsTaskWebPortletKeys.AXHRMSTASKWEB ,
		"mvc.command.name="+AxHrmsTaskWebConstants.LIST_LOG_TIME}, service = MVCRenderCommand.class)



public class ListLogTimeMVCRenderCommand implements MVCRenderCommand{
	private static final Log log = LogFactoryUtil.getLog(ListLogTimeMVCRenderCommand.class); 

	@Reference
	private TimeTrackerLocalService timeTrackerLocalService;
	@Reference
	private AxHrmsCommonApi axHrmsCommonApi;
	@Reference
	private EmployeeDetailsLocalService employeeDetailsLocalService;
	
	@Reference
	private AttachmentLocalService attachmentLocalService;
	@Reference
	private TaskReviewLocalService taskReviewLocalService;
	@Reference
	private TaskLocalService taskLocalService;
	@Reference
	private ProjectLocalService projectLocalService;
	
	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long taskId = ParamUtil.getLong(renderRequest,AxHrmsTaskWebConstants.TASK_ID);
		
		boolean isManager = axHrmsCommonApi.isRolePerson(themeDisplay, AxHrmsTaskWebConstants.IS_MANAGER);
		List<TimeTracker> timeTrackerList;
		try {
		if(isManager) {
			timeTrackerList = timeTrackerLocalService.findByTaskId(taskId);
		}else {
			timeTrackerList = timeTrackerLocalService.findByTaskIdAndEmployeeId(taskId, employeeDetailsLocalService.findByLrUserId(themeDisplay.getUserId()).getEmployeeId());
		}
		
		List<TaskDto> timeTrackerDtoList = getTimeTrackerData(timeTrackerList,themeDisplay);
		
		
		renderRequest.setAttribute(AxHrmsTaskWebConstants.TIME_TRACKER_DTO_LIST, timeTrackerDtoList);
				}
		catch(Exception e) {
			log.error("ListLogTimeMVCRenderCommand >>> render >>>"+ e.getMessage());
		}
		
		
		return AxHrmsTaskWebConstants.LIST_LOG_TIME_JSP;
	}
	private List<TaskDto> getTimeTrackerData(List<TimeTracker> timeTrackerList,ThemeDisplay themeDisplay) throws PortalException{
		List<TaskDto> timeDtoList = new ArrayList<>();
		TaskWebUtil taskWebUtil = new TaskWebUtil(employeeDetailsLocalService, axHrmsCommonApi, projectLocalService, taskLocalService, taskReviewLocalService, timeTrackerLocalService, attachmentLocalService);
		for(TimeTracker timeTracker : timeTrackerList) {
			timeDtoList.add(taskWebUtil.convertTimeTrackerDataIntoDto(timeTracker,themeDisplay));
		}
		return timeDtoList;
	}
	

}
