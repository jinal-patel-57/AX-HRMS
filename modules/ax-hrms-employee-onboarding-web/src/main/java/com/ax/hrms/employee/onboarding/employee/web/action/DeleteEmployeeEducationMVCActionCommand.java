package com.ax.hrms.employee.onboarding.employee.web.action;

import com.ax.hrms.employee.onboarding.employee.web.util.EmployeeOnBoardingUtil;
import com.ax.hrms.employee.onboarding.web.constants.AxHrmsEmployeeOnBoardingEmployeeConstants;
import com.ax.hrms.employee.onboarding.web.constants.AxHrmsEmployeeOnboardingWebPortletKeys;
import com.ax.hrms.service.EmployeeDetailsLocalService;
import com.ax.hrms.service.EmployeeEducationLocalService;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.util.ParamUtil;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, property = {
		"javax.portlet.name=" + AxHrmsEmployeeOnboardingWebPortletKeys.AX_HRMS_EMPLOYEE_ONBOARDING_EMPLOYEE_WEB,
		"mvc.command.name=/deleteEmployeeEducationURL" }, service = MVCActionCommand.class)
public class DeleteEmployeeEducationMVCActionCommand extends BaseMVCActionCommand {

	@Reference
	EmployeeEducationLocalService employeeEducationLocalService;

	@Reference
	EmployeeDetailsLocalService employeeDetailsLocalService;
	private Log log = LogFactoryUtil.getLog(DeleteEmployeeEducationMVCActionCommand.class);

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		try {
			log.info("DeleteEmployeeEducationMVCActionCommand >>> doProcessAction ::: Action Called ::: ");

			long educationId = ParamUtil.getLong(actionRequest, AxHrmsEmployeeOnBoardingEmployeeConstants.EDUCATION_ID);

			employeeEducationLocalService.deleteEmployeeEducation(educationId);

			EmployeeOnBoardingUtil.deleteEducationIds(educationId);
			actionRequest.setAttribute(AxHrmsEmployeeOnBoardingEmployeeConstants.EDU_CURRENT_INDEX,AxHrmsEmployeeOnBoardingEmployeeConstants.THREE);
		} catch (Exception e) {
			log.error("Error In when Delete Education Details" + e.getMessage());
		}
	}
}
