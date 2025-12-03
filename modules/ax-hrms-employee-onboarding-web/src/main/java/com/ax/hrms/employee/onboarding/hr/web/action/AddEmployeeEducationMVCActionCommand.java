package com.ax.hrms.employee.onboarding.hr.web.action;
import com.ax.hrms.employee.onboarding.web.constants.AxHrmsEmployeeOnBoardingEmployeeConstants;
import com.ax.hrms.employee.onboarding.web.constants.AxHrmsEmployeeOnboardingWebPortletKeys;
import com.ax.hrms.model.EmployeeDetails;
import com.ax.hrms.model.EmployeeEducation;
import com.ax.hrms.service.EmployeeDetailsLocalService;
import com.ax.hrms.service.EmployeeEducationLocalService;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, property = {
		"javax.portlet.name=" + AxHrmsEmployeeOnboardingWebPortletKeys.AX_HRMS_EMPLOYEE_ONBOARDING_HR_WEB,
		"mvc.command.name=/addEditEmployeeEducationURL" }, service = MVCActionCommand.class)
public class AddEmployeeEducationMVCActionCommand extends BaseMVCActionCommand {

	@Reference
	EmployeeEducationLocalService employeeEducationLocalService;

	@Reference
	EmployeeDetailsLocalService employeeDetailsLocalService;
	private Log log = LogFactoryUtil.getLog(AddEmployeeEducationMVCActionCommand.class);

	private List<Long> educationIds = new ArrayList<>();

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {

		log.info("AddEmployeeEducationMVCActionCommand >>> doProcessAction ::: Action Called :::");
		long employeeId = ParamUtil.getLong(actionRequest, AxHrmsEmployeeOnBoardingEmployeeConstants.EMPLOYEE_ID);
		int currentIndex = ParamUtil.getInteger(actionRequest, AxHrmsEmployeeOnBoardingEmployeeConstants.EDUCATION_CURRENT_INDEX, 1);

		for (int index = 1; index <= educationIds.size(); index++) {
			Long educationId = educationIds.get(index - 1);
			log.info("AddEmployeeEducationMVCActionCommand >>> doProcessAction ::: update called ::: ");
			try {
				ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
				log.info("AddEmployeeEducationMVCActionCommand >>> doProcessAction ::: Updating record with experience ID " + educationId);
				int dynamicIndex = index;

				long levelName = ParamUtil.getLong(actionRequest, AxHrmsEmployeeOnBoardingEmployeeConstants.LEVEL_NAME + dynamicIndex);
				String institution = ParamUtil.getString(actionRequest, AxHrmsEmployeeOnBoardingEmployeeConstants.INSTITUTION + dynamicIndex);
				String degree = ParamUtil.getString(actionRequest, AxHrmsEmployeeOnBoardingEmployeeConstants.DEGREE + dynamicIndex);
				String startDate = ParamUtil.getString(actionRequest, AxHrmsEmployeeOnBoardingEmployeeConstants.START_DATE + dynamicIndex);
				String endDate = ParamUtil.getString(actionRequest, AxHrmsEmployeeOnBoardingEmployeeConstants.END_DATE + dynamicIndex);
				String passingYear = ParamUtil.getString(actionRequest, AxHrmsEmployeeOnBoardingEmployeeConstants.PASSING_YEAR + dynamicIndex);

				EmployeeEducation employeeEducation = employeeEducationLocalService.getEmployeeEducation(educationId);

				employeeEducation.setCompanyId(themeDisplay.getCompanyId());
				employeeEducation.setGroupId(themeDisplay.getScopeGroupId());
				employeeEducation.setCreatedBy(themeDisplay.getUserId());
				employeeEducation.setModifiedBy(themeDisplay.getUserId());
				employeeEducation.setLevelId(levelName);
				employeeEducation.setInstitution(institution);
				employeeEducation.setDegree(degree);

				SimpleDateFormat formatter = new SimpleDateFormat(AxHrmsEmployeeOnBoardingEmployeeConstants.DATE_FORMAT, Locale.ENGLISH);
				Date sDate = formatter.parse(startDate);
				Date eDate = formatter.parse(endDate);
				employeeEducation.setStartDate(sDate);
				employeeEducation.setEndDate(eDate);
				employeeEducation.setPassingYear(passingYear);
				
				EmployeeDetails employeeDetails = employeeDetailsLocalService.getEmployeeDetails(employeeId);
				employeeEducation.setEmployeeId(employeeDetails.getEmployeeId());
				employeeEducationLocalService.updateEmployeeEducation(employeeEducation);
			} catch (Exception e) {
				log.error("Error updating record with experience ID " + educationId + ": ", e);
			}
		}

		for (int i = educationIds.size() + 1; i <= currentIndex; i++) {
			log.info("AddEmployeeEducationMVCActionCommand >>> doProcessAction ::: insert called :::");
			long levelName = ParamUtil.getLong(actionRequest, AxHrmsEmployeeOnBoardingEmployeeConstants.LEVEL_NAME + i);
			String institution = ParamUtil.getString(actionRequest, AxHrmsEmployeeOnBoardingEmployeeConstants.INSTITUTION + i);
			String degree = ParamUtil.getString(actionRequest, AxHrmsEmployeeOnBoardingEmployeeConstants.DEGREE + i);
			String startDate = ParamUtil.getString(actionRequest, AxHrmsEmployeeOnBoardingEmployeeConstants.START_DATE + i);
			String endDate = ParamUtil.getString(actionRequest, AxHrmsEmployeeOnBoardingEmployeeConstants.END_DATE + i);
			String passingYear = ParamUtil.getString(actionRequest, AxHrmsEmployeeOnBoardingEmployeeConstants.PASSING_YEAR + i);
			
			try {
				ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
				EmployeeEducation employeeEducation = employeeEducationLocalService.createEmployeeEducation(CounterLocalServiceUtil.increment(EmployeeEducation.class.getName()));
				employeeEducation.setCompanyId(themeDisplay.getCompanyId());
				employeeEducation.setGroupId(themeDisplay.getScopeGroupId());
				employeeEducation.setCreatedBy(themeDisplay.getUserId());
				employeeEducation.setModifiedBy(themeDisplay.getUserId());
				employeeEducation.setLevelId(levelName);
				employeeEducation.setInstitution(institution);
				employeeEducation.setDegree(degree);
				long educationId = employeeEducation.getEducationId();
				educationIds.add(educationId);
			    
				SimpleDateFormat formatter = new SimpleDateFormat(AxHrmsEmployeeOnBoardingEmployeeConstants.DATE_FORMAT, Locale.ENGLISH);
				Date sDate = formatter.parse(startDate);
				Date eDate = formatter.parse(endDate);
				employeeEducation.setStartDate(sDate);
				employeeEducation.setEndDate(eDate);
				employeeEducation.setPassingYear(passingYear);
				
				EmployeeDetails employeeDetails = employeeDetailsLocalService.getEmployeeDetails(employeeId);
				employeeEducation.setEmployeeId(employeeDetails.getEmployeeId());

				employeeEducationLocalService.addEmployeeEducation(employeeEducation);
			} catch (Exception e) {
				e.getMessage();
			}
		}
		actionRequest.setAttribute("employeeId", ParamUtil.getLong(actionRequest,"employeeId"));
	}
}

