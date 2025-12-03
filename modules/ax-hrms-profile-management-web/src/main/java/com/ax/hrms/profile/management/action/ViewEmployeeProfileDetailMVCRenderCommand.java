package com.ax.hrms.profile.management.action;

import com.ax.hrms.exception.NoSuchEmployeeDetailsException;
import com.ax.hrms.master.service.DepartmentMasterLocalService;
import com.ax.hrms.master.service.DesignationMasterLocalService;
import com.ax.hrms.profile.management.constants.AxHrmsProfileManagementWebConstants;
import com.ax.hrms.profile.management.constants.AxHrmsProfileManagementWebPortletKeys;
import com.ax.hrms.profile.management.dto.EmployeeDto;
import com.ax.hrms.profile.management.util.EmployeeProfileUtil;
import com.ax.hrms.service.*;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.liferay.portal.kernel.service.CountryLocalService;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.HashMap;
import java.util.Map;

@Component(
        immediate = true,
        property = {
                "javax.portlet.name="+ AxHrmsProfileManagementWebPortletKeys.AXHRMSPROFILEMANAGEMENTWEB,
                "mvc.command.name="+ AxHrmsProfileManagementWebConstants.DEFAULT_PATH
        }
)
public class ViewEmployeeProfileDetailMVCRenderCommand implements MVCRenderCommand{
	
	private static Log log = LogFactoryUtil.getLog(ViewEmployeeProfileDetailMVCRenderCommand.class);

	@Reference
	EmployeeDetailsLocalService employeeDetailsLocalService;
	@Reference
	EmployeeAddressLocalService employeeAddressLocalService;
	@Reference
	AddressLocalService addressLocalService;
	@Reference
	EmployeeDesignationLocalService employeeDesignationLocalService;
	@Reference
	EmployeeDepartmentLocalService employeeDepartmentLocalService;
	@Reference
	DesignationMasterLocalService designationMasterLocalService;
	@Reference
	DepartmentMasterLocalService departmentMasterLocalService;
	@Reference
	CountryLocalService countryLocalService;

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		log.info("ViewEmployeeProfileDetailMVCRenderCommand >>> Render ::: View Employee Profile JSP File Render...");

		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);

		Map<String,Object> localServiceProvider = new HashMap<>();
		localServiceProvider.put(AxHrmsProfileManagementWebConstants.EMPLOYEE_DETAILS_LOCAL_SERVICE,employeeDetailsLocalService);
		localServiceProvider.put(AxHrmsProfileManagementWebConstants.EMPLOYEE_ADDRESS_LOCAL_SERVICE,employeeAddressLocalService);
		localServiceProvider.put(AxHrmsProfileManagementWebConstants.ADDRESS_LOCAL_SERVICE,addressLocalService);
		localServiceProvider.put(AxHrmsProfileManagementWebConstants.EMPLOYEE_DESIGNATION_LOCAL_SERVICE,employeeDesignationLocalService);
		localServiceProvider.put(AxHrmsProfileManagementWebConstants.EMPLOYEE_DEPARTMENT_LOCAL_SERVICE,employeeDepartmentLocalService);
		localServiceProvider.put(AxHrmsProfileManagementWebConstants.DESIGNATION_MASTER_LOCAL_SERVICE,designationMasterLocalService);
		localServiceProvider.put(AxHrmsProfileManagementWebConstants.DEPARTMENT_MASTER_LOCAL_SERVICE,departmentMasterLocalService);
		localServiceProvider.put(AxHrmsProfileManagementWebConstants.COUNTRY_LOCAL_SERVICE,countryLocalService);

		EmployeeProfileUtil employeeProfileUtil = new EmployeeProfileUtil(localServiceProvider);

        try {
            EmployeeDto employeeDetail = employeeProfileUtil.setEmployeeBasicDetail(employeeDetailsLocalService.findByLrUserId(themeDisplay.getUserId()).getEmployeeId(),themeDisplay);
			renderRequest.setAttribute(AxHrmsProfileManagementWebConstants.EMPLOYEE_PROFILE_DETAIL,employeeDetail);
			renderRequest.setAttribute(AxHrmsProfileManagementWebConstants.IS_SAME_PRESENT_ADDRESS,employeeDetail.isSamePresentAddress());
        } catch (NoSuchEmployeeDetailsException e) {
			log.error("ViewEmployeeProfileDetailMVCRenderCommand >>> Render ::: Exception is: "+e.getMessage());
        }
        return AxHrmsProfileManagementWebConstants.VIEW_EMPLOYEE_PROFILE_JSP_FILE;
	}

}
