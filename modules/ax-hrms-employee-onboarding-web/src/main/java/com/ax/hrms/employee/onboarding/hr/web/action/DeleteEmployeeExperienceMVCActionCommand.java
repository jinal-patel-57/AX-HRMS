package com.ax.hrms.employee.onboarding.hr.web.action;

import com.ax.hrms.employee.onboarding.employee.web.util.EmployeeOnBoardingUtil;
import com.ax.hrms.employee.onboarding.web.constants.AxHrmsEmployeeOnBoardingEmployeeConstants;
import com.ax.hrms.employee.onboarding.web.constants.AxHrmsEmployeeOnboardingWebPortletKeys;
import com.ax.hrms.model.EmployeeExperience;
import com.ax.hrms.service.EmployeeDetailsLocalService;
import com.ax.hrms.service.EmployeeExperienceLocalService;
import com.liferay.document.library.kernel.service.DLAppLocalServiceUtil;
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
		"javax.portlet.name=" + AxHrmsEmployeeOnboardingWebPortletKeys.AX_HRMS_EMPLOYEE_ONBOARDING_HR_WEB,
		"mvc.command.name=/deleteEmployeeExperienceURL" }, service = MVCActionCommand.class)
public class DeleteEmployeeExperienceMVCActionCommand extends BaseMVCActionCommand {

	@Reference
	EmployeeExperienceLocalService employeeExperienceLocalService;

	@Reference
	EmployeeDetailsLocalService employeeDetailsLocalService;
	
	private Log log = LogFactoryUtil.getLog(DeleteEmployeeExperienceMVCActionCommand.class);
	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		
		log.info("DeleteEmployeeExperienceMVCActionCommand >>> doProcessAction ::: ActionCalled ::: ");

		long experienceId = ParamUtil.getLong(actionRequest, AxHrmsEmployeeOnBoardingEmployeeConstants.EXPERIENCE_ID);
		try {
			EmployeeExperience employeeExperience = employeeExperienceLocalService.getEmployeeExperience(experienceId);
			long experienceCertificateMediaId = employeeExperience.getExperienceCertificateMediaId();
			if (experienceCertificateMediaId > 0) {
				DLAppLocalServiceUtil.deleteFileEntry(experienceCertificateMediaId);
			}
			employeeExperienceLocalService.deleteEmployeeExperience(experienceId);
			EmployeeOnBoardingUtil.deleteExperienceIds(experienceId);
			actionRequest.setAttribute(AxHrmsEmployeeOnBoardingEmployeeConstants.EXPERINCE_CURRENT_INDEX,AxHrmsEmployeeOnBoardingEmployeeConstants.FOUR);
		} catch (Exception e) {
			log.error("error in delete experience " + e.getMessage());
		}
	}
}
