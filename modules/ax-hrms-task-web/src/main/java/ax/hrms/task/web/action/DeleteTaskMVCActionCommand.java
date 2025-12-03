package ax.hrms.task.web.action;

import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.ax.hrms.model.TaskReview;
import com.ax.hrms.service.TaskLocalService;
import com.ax.hrms.service.TaskReviewLocalService;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;

import ax.hrms.task.web.constants.AxHrmsTaskWebConstants;
import ax.hrms.task.web.constants.AxHrmsTaskWebPortletKeys;

@Component(immediate = true, property = { "javax.portlet.name=" + AxHrmsTaskWebPortletKeys.AXHRMSTASKWEB,
"mvc.command.name="+AxHrmsTaskWebConstants.DELETE_TASK }, service = MVCActionCommand.class)


public class DeleteTaskMVCActionCommand extends BaseMVCActionCommand {
	private static final Log log = LogFactoryUtil.getLog(DeleteTaskMVCActionCommand.class);


	@Reference
	private TaskReviewLocalService taskReviewLocalService;
	
	@Reference
	private TaskLocalService taskLocalService;
	
	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		super.hideDefaultErrorMessage(actionRequest);
		super.hideDefaultSuccessMessage(actionRequest);

		try {
		long taskId = ParamUtil.getLong(actionRequest,AxHrmsTaskWebConstants.TASK_ID);
		// delete task of review in review table
		List<TaskReview> taskReviewList = taskReviewLocalService.findByTaskId(taskId);
		for(TaskReview taskReview : taskReviewList) {
			taskReviewLocalService.deleteTaskReview(taskReview.getTaskReviewId());
		}
		// delete task from task table
		taskLocalService.deleteTask(taskId);
		SessionMessages.add(actionRequest,AxHrmsTaskWebConstants.TASK_DELETED_KEY);
		
		}catch(Exception e) {
			SessionErrors.add(actionRequest,AxHrmsTaskWebConstants.ERROR_KEY);

			log.error("DeleteTaskMVCActionCommand >>> Action >>> "+ e.getMessage());
		}
		
	
		actionResponse.sendRedirect(ParamUtil.getString(actionRequest,AxHrmsTaskWebConstants.BACKURL));		
		
	}

}
