package ax.hrms.task.web.action;

import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.ax.hrms.common.api.api.AxHrmsCommonApi;
import com.ax.hrms.model.Attachment;
import com.ax.hrms.service.AttachmentLocalService;
import com.ax.hrms.service.EmployeeDetailsLocalService;
import com.ax.hrms.service.ProjectLocalService;
import com.ax.hrms.service.TaskLocalService;
import com.ax.hrms.service.TaskReviewLocalService;
import com.ax.hrms.service.TimeTrackerLocalService;
import com.liferay.document.library.kernel.service.DLAppLocalServiceUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;

import ax.hrms.task.web.constants.AxHrmsTaskWebConstants;
import ax.hrms.task.web.constants.AxHrmsTaskWebPortletKeys;
import ax.hrms.task.web.util.TaskWebUtil;

@Component(immediate = true, property = { "javax.portlet.name=" + AxHrmsTaskWebPortletKeys.AXHRMSTASKWEB,
"mvc.command.name="+AxHrmsTaskWebConstants.DELETE_LOG_TIME}, service = MVCActionCommand.class)



public class DeleteLogTimeMVCActionCommand extends BaseMVCActionCommand {
	private static final Log log = LogFactoryUtil.getLog(DeleteLogTimeMVCActionCommand.class); 
	
	@Reference
	private TimeTrackerLocalService timeTrackerLocalService;
	@Reference
	private AttachmentLocalService attachmentLocalService;
	
	
	@Reference
	private AxHrmsCommonApi axHrmsCommonApi;
	
	@Reference
	private EmployeeDetailsLocalService employeeDetailsLocalService;
	
	
	@Reference
	private TaskReviewLocalService taskReviewLocalService;
	
	@Reference
	private TaskLocalService taskLocalService;
	
	@Reference
	private ProjectLocalService projectLocalService; 
	

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		
		long timeTrackerId = ParamUtil.getLong(actionRequest,AxHrmsTaskWebConstants.TIME_TRACKER_ID);
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		try {
	List<Attachment> attachmentList = 	attachmentLocalService.findByTimeTrackerId(timeTrackerId);
	
	//First delete all the attachment from the document and media And after that delete attachment from the table.
	for(Attachment attachment: attachmentList) {
	DLAppLocalServiceUtil.deleteFileEntry(attachment.getAttachmentId());
	attachmentLocalService.deleteAttachment(attachment);
	}
	
	timeTrackerLocalService.deleteTimeTracker(timeTrackerId);
	sendNotificationForDeleteLogTime(themeDisplay);
	SessionMessages.add(actionRequest,AxHrmsTaskWebConstants.TIMETRACKER_DELETED_KEY);
		
	
	}catch(Exception e) {
		log.error("DeleteLogTimeMVCActionCommand >>> Action >>> "+ e.getMessage());
		SessionErrors.add(actionRequest, AxHrmsTaskWebConstants.ERROR_KEY);
		
	}
		actionResponse.sendRedirect(ParamUtil.getString(actionRequest, AxHrmsTaskWebConstants.BACKURL));

}
	
	private void sendNotificationForDeleteLogTime(ThemeDisplay themeDisplay) throws  Exception {
		TaskWebUtil taskWebUtil = new TaskWebUtil(employeeDetailsLocalService, axHrmsCommonApi, projectLocalService, taskLocalService, taskReviewLocalService, timeTrackerLocalService, attachmentLocalService);
		String body = AxHrmsTaskWebConstants.YOU_DELETED_LOG_TIME;
		taskWebUtil.sendNotificationToEmployee(employeeDetailsLocalService.findByLrUserId(themeDisplay.getUserId()).getEmployeeId(), body);
	}
}
