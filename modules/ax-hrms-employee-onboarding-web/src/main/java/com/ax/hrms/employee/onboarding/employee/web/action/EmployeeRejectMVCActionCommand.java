package com.ax.hrms.employee.onboarding.employee.web.action;

import com.ax.hrms.common.api.api.AxHrmsCommonApi;
import com.ax.hrms.employee.onboarding.employee.web.util.EmployeeOnBoardingUtil;
import com.ax.hrms.employee.onboarding.web.constants.AxHrmsEmployeeOnBoardingEmployeeConstants;
import com.ax.hrms.employee.onboarding.web.constants.AxHrmsEmployeeOnboardingWebPortletKeys;
import com.ax.hrms.mail.template.config.configuration.MailTemplateConfiguration;
import com.ax.hrms.model.EmployeeDetails;
import com.ax.hrms.service.EmployeeDetailsLocalService;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, property = {
		"javax.portlet.name=" + AxHrmsEmployeeOnboardingWebPortletKeys.AX_HRMS_EMPLOYEE_ONBOARDING_EMPLOYEE_WEB,
		"mvc.command.name=/employeeRejectUrl" }, service = MVCActionCommand.class)

public class EmployeeRejectMVCActionCommand extends BaseMVCActionCommand {

	private Log log = LogFactoryUtil.getLog(EmployeeRejectMVCActionCommand.class);

	@Reference
	EmployeeDetailsLocalService employeeDetailsLocalService;

	@Reference
	MailTemplateConfiguration mailTemplateConfiguration;
	
	@Reference
	AxHrmsCommonApi axHrmsCommonApi;

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {

		log.info("EmployeeRejectMVCActionCommand >>> doProcessAction ::: Action Called :::");
		long employeeId = ParamUtil.getLong(actionRequest, AxHrmsEmployeeOnBoardingEmployeeConstants.EMPLOYEE_ID);
		
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
		String reVerifyDetails = ParamUtil.getString(actionRequest,AxHrmsEmployeeOnBoardingEmployeeConstants.REVIEW);
		EmployeeDetails employee = employeeDetailsLocalService.getEmployeeDetails(employeeId);
		employee.setIsEmployeeOnboarded(false);
		employeeDetailsLocalService.updateEmployeeDetails(employee);
		EmployeeOnBoardingUtil employeeUtil = new EmployeeOnBoardingUtil(employeeDetailsLocalService, axHrmsCommonApi, null, null, null, null,mailTemplateConfiguration);

		employeeUtil.sendNotification(employeeDetailsLocalService.findByEmployeeId(employeeId).getLrUserId(), reVerifyDetails);
		
		String subject = AxHrmsEmployeeOnBoardingEmployeeConstants.RE_UPLOAD_EMPLOYEE_ONBOARDING_DETAILS;
		
		StringBuilder body = new StringBuilder(AxHrmsEmployeeOnBoardingEmployeeConstants.EMPLOYEE_MAIL_HEAD);
		body.append(AxHrmsEmployeeOnBoardingEmployeeConstants.EMPOLYEE_MAIL_CONTENTLINE)
			.append(employee.getFirstName())
			.append(AxHrmsEmployeeOnBoardingEmployeeConstants.SPACE)
			.append(employee.getLastName())
			.append(AxHrmsEmployeeOnBoardingEmployeeConstants.SPACE)
			.append(AxHrmsEmployeeOnBoardingEmployeeConstants.RE_UPLOAD_DOCUMENTS)
			.append(reVerifyDetails);
		
		employeeUtil.sendMailToEmployee(employeeId, themeDisplay, actionRequest,  AxHrmsEmployeeOnBoardingEmployeeConstants.SLASH, reVerifyDetails);
	}
}
