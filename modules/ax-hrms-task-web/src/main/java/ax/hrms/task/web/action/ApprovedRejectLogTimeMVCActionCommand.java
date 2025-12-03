package ax.hrms.task.web.action;

import java.util.Date;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.ax.hrms.common.api.api.AxHrmsCommonApi;
import com.ax.hrms.model.EmployeeDetails;
import com.ax.hrms.model.Task;
import com.ax.hrms.model.TimeTracker;
import com.ax.hrms.notification.template.config.configuration.NotificationTemplateConfiguration;
import com.ax.hrms.service.AttachmentLocalService;
import com.ax.hrms.service.EmployeeDetailsLocalService;
import com.ax.hrms.service.ProjectLocalService;
import com.ax.hrms.service.TaskLocalService;
import com.ax.hrms.service.TaskReviewLocalService;
import com.ax.hrms.service.TimeTrackerLocalService;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import ax.hrms.task.web.constants.AxHrmsTaskWebConstants;
import ax.hrms.task.web.constants.AxHrmsTaskWebPortletKeys;
import ax.hrms.task.web.util.TaskWebUtil;

@Component(immediate = true, property = { "javax.portlet.name=" + AxHrmsTaskWebPortletKeys.AXHRMSTASKWEB,
"mvc.command.name="+AxHrmsTaskWebConstants.APPROVE_REJECT_LOG_TIME}, service = MVCActionCommand.class)




public class ApprovedRejectLogTimeMVCActionCommand extends BaseMVCActionCommand{
	
	private static final Log log = LogFactoryUtil.getLog(ApprovedRejectLogTimeMVCActionCommand.class);
	
	@Reference
	private TimeTrackerLocalService timeTrackerLocalService;
	
	@Reference
	private AttachmentLocalService attachmentLocalService;
	
	@Reference
	private AxHrmsCommonApi axHrmsCommonApi;
	
	@Reference
	private EmployeeDetailsLocalService employeeDetailsLocalService;
	@Reference
	private TaskLocalService taskLocalService;
	
	@Reference
	private ProjectLocalService projectLocalService; 
	
	@Reference
	private TaskReviewLocalService taskReviewLocalService;

	@Reference
	private NotificationTemplateConfiguration notificationTemplateConfiguration;

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
try {
		String command = ParamUtil.getString(actionRequest,AxHrmsTaskWebConstants.COMMAND);
		long timeTrackerId = ParamUtil.getLong(actionRequest,AxHrmsTaskWebConstants.TIME_TRACKER_ID);
		String status;
		
		TimeTracker timeTracker = timeTrackerLocalService.getTimeTracker(timeTrackerId);
		if(Validator.isNotNull(command)) {
			timeTracker.setManagerApproveStatus(AxHrmsTaskWebConstants.APPROVED);
			status = timeTracker.getManagerApproveStatus();
			SessionMessages.add(actionRequest,AxHrmsTaskWebConstants.APPROVED_LOG_TIME_KEY);
		}
		else {
			timeTracker.setManagerApproveStatus(AxHrmsTaskWebConstants.REJECTED);
			status = timeTracker.getManagerApproveStatus();
			SessionMessages.add(actionRequest,AxHrmsTaskWebConstants.REJECTED_LOG_TIME_KEY);
			
		}
		timeTracker.setModifiedBy(themeDisplay.getUserId());
		timeTracker.setModifiedDate(new Date());
		timeTrackerLocalService.updateTimeTracker(timeTracker);
		sendNotificationForLogTime(actionRequest, status);
}catch(Exception e) {
	log.error("ApprovedRejectLogTimeMVCActionCommand >>> "+ e.getMessage());
}
		actionResponse.sendRedirect(ParamUtil.getString(actionRequest, AxHrmsTaskWebConstants.BACKURL));
	}
	
	private  void sendNotificationForLogTime(ActionRequest actionRequest,String status) throws Exception {
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		TaskWebUtil taskWebUtil = new TaskWebUtil(employeeDetailsLocalService, axHrmsCommonApi, projectLocalService, taskLocalService, taskReviewLocalService, timeTrackerLocalService, attachmentLocalService);
		
		EmployeeDetails managerPerson = employeeDetailsLocalService.findByLrUserId(themeDisplay.getUserId());
		long timeTrackerId = ParamUtil.getLong(actionRequest,AxHrmsTaskWebConstants.TIME_TRACKER_ID);
		TimeTracker timeTracker = timeTrackerLocalService.getTimeTracker(timeTrackerId);
		Task task = taskLocalService.getTask(timeTracker.getTaskId());
//		String body = AxHrmsTaskWebConstants.YOUR_LOG_TIME_OF+ task.getTaskName() + AxHrmsTaskWebConstants.IS+status+AxHrmsTaskWebConstants.BY+ managerPerson.getFirstName()+ StringPool.SPACE + managerPerson.getLastName();
		
		String notificationContent = status.equals(AxHrmsTaskWebConstants.APPROVED) ? notificationTemplateConfiguration.notificationApproveLogTime() : notificationTemplateConfiguration.notificationRejectLogTime();
		notificationContent = notificationContent.replace("${STATUS}", status);
		notificationContent = notificationContent.replace("${TASK_NAME}", task.getTaskName());
		notificationContent = notificationContent.replace("${MANAGER_NAME}", managerPerson.getFirstName()+ StringPool.SPACE + managerPerson.getLastName());
		
		
		
		taskWebUtil.sendNotificationToEmployee(task.getAssignedTo(), notificationContent);
	}
	

}
