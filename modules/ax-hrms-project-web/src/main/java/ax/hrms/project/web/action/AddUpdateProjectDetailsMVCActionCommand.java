package ax.hrms.project.web.action;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.ax.hrms.common.api.api.AxHrmsCommonApi;
import com.ax.hrms.mail.template.config.configuration.MailTemplateConfiguration;
import com.ax.hrms.master.service.ProjectTaskStatusMasterLocalService;
import com.ax.hrms.notification.template.config.configuration.NotificationTemplateConfiguration;
import com.ax.hrms.service.EmployeeDetailsLocalService;
import com.ax.hrms.service.ProjectEmployeeDetailsLocalService;
import com.ax.hrms.service.ProjectHistoryLocalService;
import com.ax.hrms.service.ProjectLocalService;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import ax.hrms.project.web.constants.AxHrmsProjectWebConstants;
import ax.hrms.project.web.constants.AxHrmsProjectWebPortletKeys;
import ax.hrms.project.web.util.ProjectWebUtil;

@Component(immediate = true, property = {
		"javax.portlet.name=" + AxHrmsProjectWebPortletKeys.AXHRMSPROJECTWEB,
		"mvc.command.name="+AxHrmsProjectWebConstants.ADD_UPDATE_PROJECT}, service = MVCActionCommand.class)

public class AddUpdateProjectDetailsMVCActionCommand extends BaseMVCActionCommand {
	
	private static final Log log = LogFactoryUtil.getLog(AddUpdateProjectDetailsMVCActionCommand.class);
	
	@Reference
	private ProjectLocalService projectLocalService;
	@Reference
	private ProjectHistoryLocalService projectHistoryLocalService;
	@Reference
	private ProjectEmployeeDetailsLocalService projectEmployeeDetailsLocalService;
	@Reference
	private EmployeeDetailsLocalService employeeDetailsLocalService;
	@Reference
	private ProjectTaskStatusMasterLocalService projectTaskStatusMasterLocalService;
	@Reference
	private AxHrmsCommonApi axHrmsCommonApi;
	@Reference
	private MailTemplateConfiguration mailTemplateConfiguration;
	
	@Reference
	private NotificationTemplateConfiguration notificationTemplateConfiguration;
	


	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		ProjectWebUtil projectWebUtil = new ProjectWebUtil(projectLocalService, projectHistoryLocalService, projectEmployeeDetailsLocalService, employeeDetailsLocalService, projectTaskStatusMasterLocalService, axHrmsCommonApi,mailTemplateConfiguration);
		super.hideDefaultErrorMessage(actionRequest);
		super.hideDefaultSuccessMessage(actionRequest);
		long projectId = ParamUtil.getLong(actionRequest,AxHrmsProjectWebConstants.PROJECT_ID);
		try {
			if(Validator.isNotNull(projectId)) {
				projectWebUtil.addUpdate(actionRequest,true,notificationTemplateConfiguration);
				SessionMessages.add(actionRequest,AxHrmsProjectWebConstants.UPDATE_PROJECT_MESSAGE);
			}else {
		projectWebUtil.addUpdate(actionRequest,false,notificationTemplateConfiguration);
		SessionMessages.add(actionRequest,AxHrmsProjectWebConstants.ADD_PROJECT_MESSAGE);
			}

		}catch(Exception e) {
			SessionErrors.add(actionRequest,AxHrmsProjectWebConstants.ERROR_MESSAGE);

			log.error(" AddUpdateProjectDetailsMVCActionCommand >> Action >>>" +e.getMessage());
		}
		
	
		actionResponse.sendRedirect(PortalUtil.getLayoutFullURL(themeDisplay));


	}
	
		
		
	}
	
	
	


