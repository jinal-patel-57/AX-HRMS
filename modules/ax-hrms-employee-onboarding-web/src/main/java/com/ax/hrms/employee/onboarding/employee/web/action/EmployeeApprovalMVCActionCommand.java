package com.ax.hrms.employee.onboarding.employee.web.action;

import com.ax.hrms.common.api.api.AxHrmsCommonApi;
import com.ax.hrms.employee.onboarding.employee.web.util.EmployeeOnBoardingUtil;
import com.ax.hrms.employee.onboarding.web.constants.AxHrmsEmployeeOnBoardingEmployeeConstants;
import com.ax.hrms.employee.onboarding.web.constants.AxHrmsEmployeeOnboardingWebPortletKeys;
import com.ax.hrms.exception.NoSuchEmployeeDetailsException;
import com.ax.hrms.mail.template.config.configuration.MailTemplateConfiguration;
import com.ax.hrms.model.EmployeeDetails;
import com.ax.hrms.service.EmployeeDetailsLocalService;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, property = {
		"javax.portlet.name=" + AxHrmsEmployeeOnboardingWebPortletKeys.AX_HRMS_EMPLOYEE_ONBOARDING_EMPLOYEE_WEB,
		"mvc.command.name=/employeeApprovalUrl" }, service = MVCActionCommand.class)

public class EmployeeApprovalMVCActionCommand extends BaseMVCActionCommand {

	private Log log = LogFactoryUtil.getLog(EmployeeApprovalMVCActionCommand.class);

	@Reference
	EmployeeDetailsLocalService employeeDetailsLocalService;

	@Reference
	MailTemplateConfiguration mailTemplateConfiguration;

	@Reference
	AxHrmsCommonApi axHrmsCommonApi;

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {

		log.info("EmployeeApprovalMVCActionCommand >>> doProcessAction ::: Action Called :::");
		long employeeId = ParamUtil.getLong(actionRequest, AxHrmsEmployeeOnBoardingEmployeeConstants.EMPLOYEE_ID, GetterUtil.DEFAULT_LONG);
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);

		try {
			if (employeeId != 0) {
				EmployeeDetails employee = employeeDetailsLocalService.getEmployeeDetails(employeeId);
				employee.setIsEmployeeOnboarded(true);
				employeeDetailsLocalService.updateEmployeeDetails(employee);

				actionRequest.setAttribute(AxHrmsEmployeeOnBoardingEmployeeConstants.EMPLOYEE, employee);
				EmployeeOnBoardingUtil employeeUtil = new EmployeeOnBoardingUtil(employeeDetailsLocalService,axHrmsCommonApi, null, null, null, null,mailTemplateConfiguration);
				employeeUtil.sendNotification(employeeDetailsLocalService.findByEmployeeId(employeeId).getLrUserId(),AxHrmsEmployeeOnBoardingEmployeeConstants.VERIFICATION_SUCCESSFULL);


				employeeUtil.sendMailToEmployeeApproved(employeeId, themeDisplay, actionRequest, "");
				log.info("EmployeeApprovalMVCActionCommand >>> doProcessAction ::: Approved mail sent ::: ");
			}
		} catch (NoSuchEmployeeDetailsException e) {
			log.error("Employee details not found for ID: " + employeeId);
		} catch (Exception e) {
			log.error("Error fetching employee details: " + e.getMessage());
		}
	}
}