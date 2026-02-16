package com.ax.hrms.employee.directory.employee.web.action;

import com.ax.hrms.common.api.api.AxHrmsCommonApi;
import com.ax.hrms.employee.directory.util.EmployeeDetailUtil;
import com.ax.hrms.employee.directory.web.constants.AxHrmsEmployeeDirectoryEmployeeWebPortletConstants;
import com.ax.hrms.employee.directory.web.constants.AxHrmsEmployeeDirectoryEmployeeWebPortletKeys;
import com.ax.hrms.master.service.DepartmentMasterLocalService;
import com.ax.hrms.master.service.DesignationMasterLocalService;
import com.ax.hrms.model.CustomEmployeeDetailsDTO;
import com.ax.hrms.model.EmployeeDetails;
import com.ax.hrms.service.EmployeeDepartmentLocalService;
import com.ax.hrms.service.EmployeeDesignationLocalService;
import com.ax.hrms.service.EmployeeDetailsLocalService;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.PortletURLUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.portlet.PortletException;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.liferay.portal.kernel.util.WebKeys;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
		immediate = true,
		property = {
				"javax.portlet.name=" + AxHrmsEmployeeDirectoryEmployeeWebPortletKeys.AXHRMSEMPLOYEEDIRECTORYEMPLOYEEWEB,
				"mvc.command.name=/filterData",
				"mvc.command.name=/"
		},
		service = MVCRenderCommand.class
)

public class ListEmployeeDirectoryEmployeeMVCRenderCommand implements MVCRenderCommand {

	private static Log log = LogFactoryUtil.getLog(ListEmployeeDirectoryEmployeeMVCRenderCommand.class);


	@Reference
	EmployeeDetailsLocalService employeeDetailsLocalService;

	@Reference
	DesignationMasterLocalService designationMasterLocalService;

	@Reference
	DepartmentMasterLocalService departmentMasterLocalService;
	@Reference
	EmployeeDepartmentLocalService employeeDepartmentLocalService;

	@Reference
	EmployeeDesignationLocalService employeeDesignationLocalService;
	@Reference
	AxHrmsCommonApi axHrmsCommonApi;

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {

		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);


		long designationId = ParamUtil.getLong(renderRequest, AxHrmsEmployeeDirectoryEmployeeWebPortletConstants.EMPLOYEEDIRECTORY_SELECTEDDESIGNATION, GetterUtil.DEFAULT_LONG);






		long departmentId = ParamUtil.getLong(renderRequest, AxHrmsEmployeeDirectoryEmployeeWebPortletConstants.EMPLOYEEDIRECTORY_SELECTEDDEPARTMENT, GetterUtil.DEFAULT_LONG);



		List<CustomEmployeeDetailsDTO> employeeDetailsList = new ArrayList<>();

		boolean isHR = axHrmsCommonApi.isRolePerson(themeDisplay,AxHrmsEmployeeDirectoryEmployeeWebPortletConstants.HR_ADMIN);
		renderRequest.setAttribute(AxHrmsEmployeeDirectoryEmployeeWebPortletConstants.IS_HR,isHR);


		String name = ParamUtil.getString(renderRequest, AxHrmsEmployeeDirectoryEmployeeWebPortletConstants.EMPLOYEEDIRECTORY_SELECTEDQUERY, null);

		List<Long> employeeIds = getEmployeeIdsList(departmentId,designationId);

		CustomEmployeeDetailsDTO customEmployeeDetailsDTO = null;
		if(!employeeIds.isEmpty()) {
			for(Long employeeId : employeeIds) {
				customEmployeeDetailsDTO = new CustomEmployeeDetailsDTO();
				EmployeeDetailUtil employeeDetailUtil = new EmployeeDetailUtil(employeeDetailsLocalService,employeeDepartmentLocalService,employeeDesignationLocalService,departmentMasterLocalService,designationMasterLocalService);
				try {
					customEmployeeDetailsDTO = employeeDetailUtil.getEmployeeDetail(employeeId);
					if(customEmployeeDetailsDTO.getleavingDate() == null)
						employeeDetailsList.add(customEmployeeDetailsDTO);
				} catch (PortalException e) {
					log.error("ListEmployeeDirectoryEmployeeMVCRenderCommand >>> render ::: Exception is: "+e.getMessage());
				}
			}
		}

		PortletURL iteratorURL = PortletURLUtil.getCurrent(renderRequest, renderResponse);
		SearchContainer<CustomEmployeeDetailsDTO> directorySearchContainer = new SearchContainer<>(renderRequest, iteratorURL, null,
				StringPool.BLANK);
		directorySearchContainer.setResultsAndTotal(employeeDetailsList);

		renderRequest.setAttribute(AxHrmsEmployeeDirectoryEmployeeWebPortletConstants.EMPLOYEEDIRECTORYSEARCHCONTAINER, directorySearchContainer);
		renderRequest.setAttribute(AxHrmsEmployeeDirectoryEmployeeWebPortletConstants.EMPLOYEEDIRECTORY_DESIGNATIONLIST, designationMasterLocalService.getDesignationMasters(-1,-1));
		renderRequest.setAttribute(AxHrmsEmployeeDirectoryEmployeeWebPortletConstants.EMPLOYEEDIRECTORY_DEPARTMENTLIST, departmentMasterLocalService.getDepartmentMasters(-1,-1));
		renderRequest.setAttribute(AxHrmsEmployeeDirectoryEmployeeWebPortletConstants.EMPLOYEEDIRECTORY_DESIGNATIONVALUE, designationId);
		renderRequest.setAttribute(AxHrmsEmployeeDirectoryEmployeeWebPortletConstants.EMPLOYEEDIRECTORY_DEPARTMENTVALUE, departmentId);
		renderRequest.setAttribute(AxHrmsEmployeeDirectoryEmployeeWebPortletConstants.EMPLOYEEDIRECTORY_SEARCHEDVALUE, name);
		if(!employeeDetailsList.isEmpty()) {



			renderRequest.setAttribute(AxHrmsEmployeeDirectoryEmployeeWebPortletConstants.EMPLOYEEDIRECTORY_EMPLOYEEDETAILS, employeeDetailsList);
			renderRequest.setAttribute(AxHrmsEmployeeDirectoryEmployeeWebPortletConstants.EMPLOYEEDIRECTORY_GET, employeeDetailsList);

			return AxHrmsEmployeeDirectoryEmployeeWebPortletConstants.LIST_EMPLOYEE_DIRECTORY;

		}

		return AxHrmsEmployeeDirectoryEmployeeWebPortletConstants.LIST_EMPLOYEE_DIRECTORY;

	}


private List<Long> getEmployeeIdsList(long departmentId, long designationId) {

	// Use Set to avoid duplicates
	Set<Long> employeeIdSet = new HashSet<>();

	if (departmentId != 0) {
		if (designationId == 0) {
			employeeIdSet.addAll(
					employeeDetailsLocalService.getEmployeeIdByDepartmentId(departmentId)
			);

		} else {
			employeeIdSet.addAll(
					employeeDetailsLocalService.getEmployeeIdByDesignationIdAndDepartmentId(
							designationId, departmentId
					)
			);
		}
	}
	else if (designationId != 0) {
		employeeIdSet.addAll(
				employeeDetailsLocalService.getEmployeeIdByDesignationId(designationId)
		);
	}
	else {
		for (EmployeeDetails employeeDetails :
				employeeDetailsLocalService.getEmployeeDetailses(-1, -1)) {

			if (!employeeDetails.isIsTerminated()) {
				employeeIdSet.add(employeeDetails.getEmployeeId());
			}
		}
	}

	return new ArrayList<>(employeeIdSet);
}

}
