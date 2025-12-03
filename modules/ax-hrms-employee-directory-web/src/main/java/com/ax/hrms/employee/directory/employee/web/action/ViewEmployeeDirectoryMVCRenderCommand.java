package com.ax.hrms.employee.directory.employee.web.action;

import com.ax.hrms.employee.directory.dto.EmployeeDto;
import com.ax.hrms.employee.directory.util.EmployeeUtil;
import com.ax.hrms.employee.directory.web.constants.AxHrmsEmployeeDirectoryEmployeeWebPortletConstants;
import com.ax.hrms.employee.directory.web.constants.AxHrmsEmployeeDirectoryEmployeeWebPortletKeys;
import com.ax.hrms.master.service.DepartmentMasterLocalService;
import com.ax.hrms.master.service.DesignationMasterLocalService;
import com.ax.hrms.service.*;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.service.CountryLocalService;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import java.util.HashMap;
import java.util.Map;

@Component(
		immediate = true,
		property = {
				"javax.portlet.name=" + AxHrmsEmployeeDirectoryEmployeeWebPortletKeys.AXHRMSEMPLOYEEDIRECTORYEMPLOYEEWEB,
				"mvc.command.name=/viewEmployeeFullDirectory"
		},
		service = MVCRenderCommand.class
)

public class ViewEmployeeDirectoryMVCRenderCommand implements MVCRenderCommand {

	private static Log log = LogFactoryUtil.getLog(ViewEmployeeDirectoryMVCRenderCommand.class);


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
		Map<String,Object> localServiceProvider = new HashMap<>();
		localServiceProvider.put(AxHrmsEmployeeDirectoryEmployeeWebPortletConstants.EMPLOYEE_DETAILS_LOCAL_SERVICE,employeeDetailsLocalService);
		localServiceProvider.put(AxHrmsEmployeeDirectoryEmployeeWebPortletConstants.EMPLOYEE_ADDRESS_LOCAL_SERVICE,employeeAddressLocalService);
		localServiceProvider.put(AxHrmsEmployeeDirectoryEmployeeWebPortletConstants.ADDRESS_LOCAL_SERVICE,addressLocalService);
		localServiceProvider.put(AxHrmsEmployeeDirectoryEmployeeWebPortletConstants.EMPLOYEE_DESIGNATION_LOCAL_SERVICE,employeeDesignationLocalService);
		localServiceProvider.put(AxHrmsEmployeeDirectoryEmployeeWebPortletConstants.EMPLOYEE_DEPARTMENT_LOCAL_SERVICE,employeeDepartmentLocalService);
		localServiceProvider.put(AxHrmsEmployeeDirectoryEmployeeWebPortletConstants.DESIGNATION_MASTER_LOCAL_SERVICE,designationMasterLocalService);
		localServiceProvider.put(AxHrmsEmployeeDirectoryEmployeeWebPortletConstants.DEPARTMENT_MASTER_LOCAL_SERVICE,departmentMasterLocalService);
		localServiceProvider.put(AxHrmsEmployeeDirectoryEmployeeWebPortletConstants.COUNTRY_LOCAL_SERVICE,countryLocalService);

		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long employeeId = ParamUtil.getLong(renderRequest,"employeeId",GetterUtil.DEFAULT_LONG);

		try {
			EmployeeUtil employeeUtil = new EmployeeUtil(localServiceProvider);
			EmployeeDto employeeDto = employeeUtil.setEmployeeBasicDetail(employeeId,themeDisplay);
			renderRequest.setAttribute(AxHrmsEmployeeDirectoryEmployeeWebPortletConstants.EMPLOYEE_PROFILE_DETAIL,employeeDto);
			renderRequest.setAttribute(AxHrmsEmployeeDirectoryEmployeeWebPortletConstants.IS_SAME_PRESENT_ADDRESS,employeeDto.isSamePresentAddress());
		} catch (Exception e) {
			log.error("ViewEmployeeProfileDetailMVCRenderCommand >>> Render ::: Exception is: "+e.getMessage());
		}
		return AxHrmsEmployeeDirectoryEmployeeWebPortletConstants.VIEW_EMPLOYEE_DIRECTORY_JSP_URL;
	}

}
