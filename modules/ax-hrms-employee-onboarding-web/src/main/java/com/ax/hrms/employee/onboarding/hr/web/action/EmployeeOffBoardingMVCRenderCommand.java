package com.ax.hrms.employee.onboarding.hr.web.action;

import com.ax.hrms.employee.onboarding.web.constants.AxHrmsEmployeeOnboardingHrWebPortletConstants;
import com.ax.hrms.employee.onboarding.web.constants.AxHrmsEmployeeOnboardingWebPortletKeys;
import com.ax.hrms.exception.NoSuchEmployeeOffBoardingException;
import com.ax.hrms.master.service.ProjectTaskStatusMasterLocalServiceUtil;
import com.ax.hrms.model.EmployeeDetails;
import com.ax.hrms.model.EmployeeOffBoarding;
import com.ax.hrms.service.EmployeeDetailsLocalService;
import com.ax.hrms.service.EmployeeOffBoardingLocalService;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.document.library.kernel.exception.NoSuchFileEntryException;
import com.liferay.document.library.kernel.model.DLFileEntry;
import com.liferay.document.library.kernel.service.DLFileEntryLocalServiceUtil;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.PortletURLUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.PortletException;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

@Component(
        immediate = true,
        property = {
                "javax.portlet.name=" + AxHrmsEmployeeOnboardingWebPortletKeys.AX_HRMS_EMPLOYEE_ONBOARDING_HR_WEB,
                "mvc.command.name=/employeeOffBoarding"
        },
        service = MVCRenderCommand.class
)
public class EmployeeOffBoardingMVCRenderCommand implements MVCRenderCommand {
    Log log = LogFactoryUtil.getLog(EmployeeOffBoardingMVCRenderCommand.class);

    @Reference
    EmployeeDetailsLocalService employeeDetailsLocalService;

    @Reference
    EmployeeOffBoardingLocalService employeeOffBoardingLocalService;

    @Override
    public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
        long employeeId = ParamUtil.getLong(renderRequest, AxHrmsEmployeeOnboardingHrWebPortletConstants.EMPLOYEE_ID);
        renderRequest.setAttribute(AxHrmsEmployeeOnboardingHrWebPortletConstants.EMPLOYEE_ID, employeeId);
        EmployeeOffBoarding employeeOffBoarding;
        try {
            employeeOffBoarding = getEmployeeOffBoarding(employeeId);
        } catch (Exception e) {
            employeeOffBoarding = createEmployeeOffBoarding(employeeId);
        }

        renderRequest.setAttribute(AxHrmsEmployeeOnboardingHrWebPortletConstants.EMPLOYEE_OFF_BOARDING, employeeOffBoarding);
        if(employeeOffBoarding.getKt() && employeeOffBoarding.getAssets() && employeeOffBoarding.getMailAndBiometrics() && employeeOffBoarding.getNda()){
            renderRequest.setAttribute(AxHrmsEmployeeOnboardingHrWebPortletConstants.ALL_CHECKED, true);
        }
        else {
            renderRequest.setAttribute(AxHrmsEmployeeOnboardingHrWebPortletConstants.ALL_CHECKED, false);
        }
        setFileNamesInRequest(renderRequest, employeeOffBoarding);

        return AxHrmsEmployeeOnboardingHrWebPortletConstants.EMPLOYEE_OFF_BOARDING_HR_JSP;
    }

    private EmployeeOffBoarding getEmployeeOffBoarding(long employeeId) throws NoSuchEmployeeOffBoardingException {
        return employeeOffBoardingLocalService.findByEmployeeId(employeeId);
    }

    private EmployeeOffBoarding createEmployeeOffBoarding(long employeeId) {
        EmployeeOffBoarding employeeOffBoarding = employeeOffBoardingLocalService.createEmployeeOffBoarding(
                CounterLocalServiceUtil.increment(EmployeeOffBoarding.class.getName())
        );
        employeeOffBoarding.setEmployeeId(employeeId);
        employeeOffBoarding.setExperienceLetterId(0);
        employeeOffBoarding.setRelievingLetterId(0);
        employeeOffBoarding.setFullAndFinal("");
        employeeOffBoarding.setNda(false);
        employeeOffBoarding.setKt(false);
        employeeOffBoarding.setMailAndBiometrics(false);
        employeeOffBoarding.setAssets(false);
        employeeOffBoardingLocalService.addEmployeeOffBoarding(employeeOffBoarding);
        return employeeOffBoarding;
    }

    private void setFileNamesInRequest(RenderRequest renderRequest, EmployeeOffBoarding employeeOffBoarding) {
        renderRequest.setAttribute(AxHrmsEmployeeOnboardingHrWebPortletConstants.EXPERIENCE_LETTER_FILE_NAME, getFileName(employeeOffBoarding.getExperienceLetterId()));
        renderRequest.setAttribute(AxHrmsEmployeeOnboardingHrWebPortletConstants.RELIEVING_LETTER_FILE_NAME, getFileName(employeeOffBoarding.getRelievingLetterId()));
        renderRequest.setAttribute(AxHrmsEmployeeOnboardingHrWebPortletConstants.FULL_AND_FINAL_LETTER_FILE_NAME, employeeOffBoarding.getFullAndFinal());
    }

    private String getFileName(long fileEntryId) {
        if (fileEntryId == 0) {
            return StringPool.BLANK;
        }
        try {
            DLFileEntry fileEntry = DLFileEntryLocalServiceUtil.getDLFileEntry(fileEntryId);
            return fileEntry.getFileName();
        } catch (Exception e) {
            return StringPool.BLANK;
        }
    }
}
