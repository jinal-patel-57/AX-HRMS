package ax.hrms.task.web.action;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.ax.hrms.common.api.api.AxHrmsCommonApi;
import com.ax.hrms.notification.template.config.configuration.NotificationTemplateConfiguration;
import com.ax.hrms.service.AttachmentLocalService;
import com.ax.hrms.service.EmployeeDetailsLocalService;
import com.ax.hrms.service.ProjectLocalService;
import com.ax.hrms.service.TaskLocalService;
import com.ax.hrms.service.TaskReviewLocalService;
import com.ax.hrms.service.TimeTrackerLocalService;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;

import ax.hrms.task.web.constants.AxHrmsTaskWebConstants;
import ax.hrms.task.web.constants.AxHrmsTaskWebPortletKeys;
import ax.hrms.task.web.util.TaskWebUtil;

@Component(immediate = true, property = { "javax.portlet.name=" + AxHrmsTaskWebPortletKeys.AXHRMSTASKWEB,
		"mvc.command.name="+AxHrmsTaskWebConstants.ADD_UPDATE_LOG_TIME }, service = MVCActionCommand.class)

public class AddUpdateLogTimeMVCActionCommand extends BaseMVCActionCommand {
	private static final Log log = LogFactoryUtil.getLog(AddUpdateLogTimeMVCActionCommand.class);

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
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		super.hideDefaultErrorMessage(actionRequest);
		super.hideDefaultSuccessMessage(actionRequest);
		long timeTrackerId = ParamUtil.getLong(actionRequest, AxHrmsTaskWebConstants.TIME_TRACKER_ID);
		try {

			TaskWebUtil taskWebUtil = new TaskWebUtil(employeeDetailsLocalService, axHrmsCommonApi, projectLocalService,
					taskLocalService, taskReviewLocalService, timeTrackerLocalService, attachmentLocalService);
			if (Validator.isNotNull(timeTrackerId)) {
				taskWebUtil.setLogTime(actionRequest,true);
				SessionMessages.add(actionRequest, AxHrmsTaskWebConstants.UPDATE_LOG_TIME_KEY);

			} else {
				taskWebUtil.setLogTime(actionRequest,false);
				SessionMessages.add(actionRequest, AxHrmsTaskWebConstants.ADD_LOG_TIME_KEY);
			}

		} catch (Exception e) {
			e.printStackTrace();
			SessionErrors.add(actionRequest, AxHrmsTaskWebConstants.ERROR_KEY);
			log.error("AddUpdateLogTimeMVCActionCommand >>>" + e.getMessage());
		}
		actionResponse.sendRedirect(ParamUtil.getString(actionRequest, AxHrmsTaskWebConstants.BACKURL));

	}

}
