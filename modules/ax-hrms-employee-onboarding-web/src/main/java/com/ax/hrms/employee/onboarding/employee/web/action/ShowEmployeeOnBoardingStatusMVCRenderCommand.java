package com.ax.hrms.employee.onboarding.employee.web.action;

import com.ax.hrms.employee.onboarding.web.constants.AxHrmsEmployeeOnBoardingEmployeeConstants;
import com.ax.hrms.employee.onboarding.web.constants.AxHrmsEmployeeOnboardingWebPortletKeys;
import com.ax.hrms.exception.NoSuchEmployeeDetailsException;
import com.ax.hrms.model.EmployeeDetails;
import com.ax.hrms.service.EmployeeDetailsLocalService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, property = {
		"javax.portlet.name=" + AxHrmsEmployeeOnboardingWebPortletKeys.AX_HRMS_EMPLOYEE_ONBOARDING_EMPLOYEE_WEB,
		"mvc.command.name=/showEmployeeOnBoardingStatus" }, service = MVCRenderCommand.class)
public class ShowEmployeeOnBoardingStatusMVCRenderCommand implements MVCRenderCommand {
	private Log log = LogFactoryUtil.getLog(ShowEmployeeOnBoardingStatusMVCRenderCommand.class);

	@Reference
	EmployeeDetailsLocalService employeeDetailsLocalService;

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		
		log.info("showEmployeeOnBoardingStatusMVCRenderCommand >>> render ::: Render Called :::");

		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
		try {
			long employeeId = employeeDetailsLocalService.findByLrUserId(themeDisplay.getUserId()).getEmployeeId();
			
			EmployeeDetails employeeDetails=employeeDetailsLocalService.getEmployeeDetails(employeeId);
		
			boolean isEmployeeOnBoarded=employeeDetails.getIsEmployeeOnboarded();
			if(isEmployeeOnBoarded) {
				renderRequest.setAttribute(AxHrmsEmployeeOnBoardingEmployeeConstants.EMPLOYEE_DETAIL, employeeDetails);
			}
		} catch (NoSuchEmployeeDetailsException e1) {
			e1.printStackTrace();
		} catch (PortalException e) {
			e.printStackTrace();
		}
		
		return AxHrmsEmployeeOnBoardingEmployeeConstants.SHOW_EMPLOYEE_ONBOARDING_STATUS_PAGE;
	}
}
