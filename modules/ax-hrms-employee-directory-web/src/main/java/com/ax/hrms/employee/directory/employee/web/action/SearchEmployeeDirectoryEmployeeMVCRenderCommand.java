package com.ax.hrms.employee.directory.employee.web.action;

import com.ax.hrms.employee.directory.util.EmployeeDetailUtil;
import com.ax.hrms.employee.directory.web.constants.AxHrmsEmployeeDirectoryEmployeeWebPortletConstants;
import com.ax.hrms.employee.directory.web.constants.AxHrmsEmployeeDirectoryEmployeeWebPortletKeys;
import com.ax.hrms.master.service.DepartmentMasterLocalService;
import com.ax.hrms.master.service.DesignationMasterLocalService;
import com.ax.hrms.model.CustomEmployeeDetailsDTO;
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
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;



@Component(
	    immediate = true,
	    property = {
	        "javax.portlet.name=" + AxHrmsEmployeeDirectoryEmployeeWebPortletKeys.AXHRMSEMPLOYEEDIRECTORYEMPLOYEEWEB,
	        "mvc.command.name=/serachData"
	    },
	    service = MVCRenderCommand.class
	)

public class SearchEmployeeDirectoryEmployeeMVCRenderCommand implements MVCRenderCommand {

	private static Log log = LogFactoryUtil.getLog(SearchEmployeeDirectoryEmployeeMVCRenderCommand.class);
	
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

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {

		int curValue = ParamUtil.getInteger(renderRequest, SearchContainer.DEFAULT_CUR_PARAM, 1);
        int deltaValue = ParamUtil.getInteger(renderRequest, SearchContainer.DEFAULT_DELTA_PARAM, 3);

        String name = ParamUtil.getString(renderRequest, AxHrmsEmployeeDirectoryEmployeeWebPortletConstants.SEARCH_QUERY, GetterUtil.DEFAULT_STRING);
		renderRequest.setAttribute(AxHrmsEmployeeDirectoryEmployeeWebPortletConstants.EMPLOYEEDIRECTORY_SEARCHEDVALUE, name);
		name = name.toLowerCase();

		List<Long> employeeIdByName = employeeDetailsLocalService.getEmployeeIdByNameString(AxHrmsEmployeeDirectoryEmployeeWebPortletConstants.MODULO_OPERATOR+name+AxHrmsEmployeeDirectoryEmployeeWebPortletConstants.MODULO_OPERATOR);

		List<CustomEmployeeDetailsDTO> employeeDetailsList = new ArrayList<>();
		CustomEmployeeDetailsDTO customEmployeeDetailsDTO = null;
        if(name != null) {
			for(Long employeeId : employeeIdByName) {
				customEmployeeDetailsDTO = new CustomEmployeeDetailsDTO();
				EmployeeDetailUtil employeeDetailUtil = new EmployeeDetailUtil(employeeDetailsLocalService,employeeDepartmentLocalService,employeeDesignationLocalService,departmentMasterLocalService,designationMasterLocalService);
                try {
					customEmployeeDetailsDTO = employeeDetailUtil.getEmployeeDetail(employeeId);
					if(customEmployeeDetailsDTO.getleavingDate() == null)
						employeeDetailsList.add(customEmployeeDetailsDTO);
                } catch (PortalException e) {
					log.error("SearchEmployeeDirectoryEmployeeMVCRenderCommand >>> render ::: Exception is: "+e.getMessage());
                }
            }
        }


		PortletURL iteratorURL = PortletURLUtil.getCurrent(renderRequest, renderResponse);
		SearchContainer<CustomEmployeeDetailsDTO> directorySearchContainer = new SearchContainer<>(renderRequest, iteratorURL, null, StringPool.BLANK);
		directorySearchContainer.setResultsAndTotal(employeeDetailsList);

			renderRequest.setAttribute(AxHrmsEmployeeDirectoryEmployeeWebPortletConstants.EMPLOYEEDIRECTORYSEARCHCONTAINER, directorySearchContainer);
			renderRequest.setAttribute(AxHrmsEmployeeDirectoryEmployeeWebPortletConstants.EMPLOYEEDIRECTORY_DESIGNATIONLIST, designationMasterLocalService.getDesignationMasters(-1, -1));
			renderRequest.setAttribute(AxHrmsEmployeeDirectoryEmployeeWebPortletConstants.EMPLOYEEDIRECTORY_DEPARTMENTLIST, departmentMasterLocalService.getDepartmentMasters(-1, -1));
			if(!employeeDetailsList.isEmpty()) {

				int totalOfHoliday = employeeDetailsList.size();
				int totalPageContainer = (totalOfHoliday + deltaValue - 1) / deltaValue;

				if (curValue > totalPageContainer) {
					curValue = totalPageContainer;
				}

				int start = (curValue - 1) * deltaValue;
				int end = Math.min(start + deltaValue, totalOfHoliday);

				employeeDetailsList = employeeDetailsList.subList(start, end);

				renderRequest.setAttribute(AxHrmsEmployeeDirectoryEmployeeWebPortletConstants.EMPLOYEEDIRECTORY_EMPLOYEEDETAILS, employeeDetailsList);
				renderRequest.setAttribute(AxHrmsEmployeeDirectoryEmployeeWebPortletConstants.EMPLOYEEDIRECTORY_TOTAL, totalOfHoliday);
				renderRequest.setAttribute(AxHrmsEmployeeDirectoryEmployeeWebPortletConstants.EMPLOYEEDIRECTORY_GET, employeeDetailsList);

				return AxHrmsEmployeeDirectoryEmployeeWebPortletConstants.LIST_EMPLOYEE_DIRECTORY;
			}
        
	        else {

				return AxHrmsEmployeeDirectoryEmployeeWebPortletConstants.EMPLOYEEDIRECTORY_EMPLOYEEPAGE;
			}

	}
}