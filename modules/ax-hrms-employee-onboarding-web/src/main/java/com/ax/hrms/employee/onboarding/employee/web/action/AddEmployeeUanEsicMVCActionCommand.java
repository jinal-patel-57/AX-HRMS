package com.ax.hrms.employee.onboarding.employee.web.action;

import com.ax.hrms.employee.onboarding.web.constants.AxHrmsEmployeeOnBoardingEmployeeConstants;
import com.ax.hrms.employee.onboarding.web.constants.AxHrmsEmployeeOnboardingWebPortletKeys;
import com.ax.hrms.model.EmployeeDetails;
import com.ax.hrms.model.EmployeeUanEsic;
import com.ax.hrms.service.EmployeeDetailsLocalService;
import com.ax.hrms.service.EmployeeUanEsicLocalService;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
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
		"mvc.command.name=/addEditEmployeeUanEsicURL" }, service = MVCActionCommand.class)
public class AddEmployeeUanEsicMVCActionCommand extends BaseMVCActionCommand {

	@Reference
	EmployeeUanEsicLocalService employeeUanEsicLocalService;

	@Reference
	EmployeeDetailsLocalService employeeDetailsLocalService;
	
	private Log log = LogFactoryUtil.getLog(AddEmployeeUanEsicMVCActionCommand.class);

	private long employeeUanEsicId=0;
	
	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {

		log.info("AddEmployeeUanEsicMVCActionCommand >>> doProcessAction ::: Action Called :::");
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
		String uan = ParamUtil.getString(actionRequest, AxHrmsEmployeeOnBoardingEmployeeConstants.UAN);
		String esicNo = ParamUtil.getString(actionRequest, AxHrmsEmployeeOnBoardingEmployeeConstants.ESIC_NUMBER);
        String flag = ParamUtil.getString(actionRequest, AxHrmsEmployeeOnBoardingEmployeeConstants.UPDATE_FLAG_UAN_ESIC);

		if(flag.equals(AxHrmsEmployeeOnBoardingEmployeeConstants.FALSE)) {
				try {
					EmployeeUanEsic employeeUanEsic = employeeUanEsicLocalService.createEmployeeUanEsic(CounterLocalServiceUtil.increment(EmployeeUanEsic.class.getName()));
					employeeUanEsic.setCompanyId(themeDisplay.getCompanyId());
					employeeUanEsic.setGroupId(themeDisplay.getScopeGroupId());
					employeeUanEsic.setCreatedBy(themeDisplay.getUserId());
					employeeUanEsic.setModifiedBy(themeDisplay.getUserId());
					
					employeeUanEsicId=employeeUanEsic.getUanEsicId();
					employeeUanEsic.setUan(uan);
					employeeUanEsic.setEsicNo(esicNo);
					employeeUanEsic.setStatus(true);

					EmployeeDetails employeeDetails = employeeDetailsLocalService.findByLrUserId(themeDisplay.getUserId());
					employeeDetails.setUanEsicId(employeeUanEsic.getUanEsicId());
					employeeDetailsLocalService.updateEmployeeDetails(employeeDetails);
					employeeUanEsicLocalService.addEmployeeUanEsic(employeeUanEsic);
				} catch (Exception e) {
					log.error("error in catch while insert EmployeeUanEsic Details" + e.getMessage());
				}
		} else {
			try {
				EmployeeUanEsic employeeUanEsic = employeeUanEsicLocalService.getEmployeeUanEsic(employeeUanEsicId);
				employeeUanEsic.setCompanyId(themeDisplay.getCompanyId());
				employeeUanEsic.setGroupId(themeDisplay.getScopeGroupId());
				employeeUanEsic.setCreatedBy(themeDisplay.getUserId());
				employeeUanEsic.setModifiedBy(themeDisplay.getUserId());
				employeeUanEsic.setUan(uan);
				employeeUanEsic.setEsicNo(esicNo);
				employeeUanEsic.setStatus(true);
				employeeUanEsicLocalService.updateEmployeeUanEsic(employeeUanEsic);
			} catch (Exception e) {
				log.error("error in catch while update EmployeeUanEsic Details" + e.getMessage());
			}
		}
	}
}
