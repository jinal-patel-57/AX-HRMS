package ax.hrms.task.web.action;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.ax.hrms.common.api.api.AxHrmsCommonApi;
import com.ax.hrms.mail.template.config.configuration.MailTemplateConfiguration;
import com.ax.hrms.master.service.PriorityMasterLocalService;
import com.ax.hrms.master.service.ProjectTaskStatusMasterLocalService;
import com.ax.hrms.notification.template.config.configuration.NotificationTemplateConfiguration;
import com.ax.hrms.service.EmployeeDetailsLocalService;
import com.ax.hrms.service.ProjectLocalService;
import com.ax.hrms.service.TaskLocalService;
import com.ax.hrms.service.TaskReviewLocalService;
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
		"mvc.command.name=" + AxHrmsTaskWebConstants.ADD_UPDATE_TASK }, service = MVCActionCommand.class)

public class AddUpdateTaskMVCActionCommand extends BaseMVCActionCommand {
	private static final Log log = LogFactoryUtil.getLog(AddUpdateTaskMVCActionCommand.class);

	@Reference
	private EmployeeDetailsLocalService employeeDetailsLocalService;
	@Reference
	private AxHrmsCommonApi axHrmsCommonApi;
	@Reference
	private ProjectLocalService projectLocalService;
	@Reference
	private TaskLocalService taskLocalService;
	@Reference
	private ProjectTaskStatusMasterLocalService projectTaskStatusMasterLocalService;
	@Reference
	private PriorityMasterLocalService priorityMasterLocalService;
	@Reference
	private TaskReviewLocalService taskReviewLocalService;
	@Reference
	private MailTemplateConfiguration mailTemplateConfiguration;
	
	@Reference
	private NotificationTemplateConfiguration notificationTemplateConfiguration;

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {

		super.hideDefaultErrorMessage(actionRequest);
		super.hideDefaultSuccessMessage(actionRequest);

		try {
			long taskId = ParamUtil.getLong(actionRequest, AxHrmsTaskWebConstants.TASK_ID);

			TaskWebUtil taskWebUtil = new TaskWebUtil(employeeDetailsLocalService, axHrmsCommonApi, projectLocalService,
					taskLocalService, projectTaskStatusMasterLocalService, priorityMasterLocalService,
					taskReviewLocalService);
			if (Validator.isNotNull(taskId)) {
				taskWebUtil.setTaskData(actionRequest, true,mailTemplateConfiguration,notificationTemplateConfiguration);
				SessionMessages.add(actionRequest, AxHrmsTaskWebConstants.TASK_UPDATED_KEY);

			} else {
				taskWebUtil.setTaskData(actionRequest, false,mailTemplateConfiguration,notificationTemplateConfiguration);
				SessionMessages.add(actionRequest, AxHrmsTaskWebConstants.TASK_ADDED_KEY);
			}

		} catch (Exception e) {
			SessionErrors.add(actionRequest, AxHrmsTaskWebConstants.ERROR_KEY);

			log.error("AddUpdateTaskMVCActionCommand >>> Error >>>" + e.getMessage());
		}

		actionResponse.sendRedirect(ParamUtil.getString(actionRequest, AxHrmsTaskWebConstants.BACKURL));

	}
}