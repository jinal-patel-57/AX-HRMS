package com.ax.hrms.employee.onboarding.hr.web.action;

import com.ax.hrms.employee.onboarding.web.constants.AxHrmsEmployeeOnboardingWebPortletKeys;
import com.ax.hrms.service.EmployeeDetailsLocalService;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import java.io.IOException;

@Component(immediate = true, property = {
        "javax.portlet.name=" + AxHrmsEmployeeOnboardingWebPortletKeys.AX_HRMS_EMPLOYEE_ONBOARDING_HR_WEB,
        "mvc.command.name=/checkEmailExists" }, service = MVCResourceCommand.class)
public class CheckEmailExistsMVCResourceCommand extends BaseMVCResourceCommand {
Log log = LogFactoryUtil.getLog(CheckEmailExistsMVCResourceCommand.class.getName());
    @Reference
    EmployeeDetailsLocalService employeeDetailsLocalService;

    @Reference
    UserLocalService userLocalService;
    @Override
    protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws Exception {

        ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
        String email = ParamUtil.getString(resourceRequest, "email");
        log.info("Email"+ email);
        boolean exists = false;
        try {
            User user = userLocalService.fetchUserByEmailAddress(themeDisplay.getCompanyId(), email);
            exists = (user != null);
        } catch (Exception e) {
            // ignore – treat as not exists
        }

        JSONObject json = JSONFactoryUtil.createJSONObject();
        json.put("exists", exists);
        log.info("Exists"+ exists);

        try {
            resourceResponse.setContentType("application/json");
            resourceResponse.getWriter().write(json.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
