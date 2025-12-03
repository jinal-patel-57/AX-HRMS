package com.ax.hrms.birthday.web.action;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.ax.hrms.birthday.web.dto.BirthdayEmployeeDto;
import com.ax.hrms.birthday.web.util.BirthdayWebUtil;
import com.ax.hrms.constants.AxHrmsBirthdayWebPortletConstants;
import com.ax.hrms.constants.AxHrmsBirthdayWebPortletKeys;
import com.ax.hrms.master.service.DepartmentMasterLocalService;
import com.ax.hrms.master.service.DesignationMasterLocalService;
import com.ax.hrms.master.service.WishTypeMasterLocalService;
import com.ax.hrms.model.EmployeeDetails;
import com.ax.hrms.service.EmployeeDepartmentLocalService;
import com.ax.hrms.service.EmployeeDesignationLocalService;
import com.ax.hrms.service.EmployeeDetailsLocalService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;

/**
 * 
 * @author keval.kathiriya
 *
 */
@Component(immediate = true, property = {
		"javax.portlet.name=" + AxHrmsBirthdayWebPortletKeys.AXHRMSEMPLOYEEBIRTHDAYWEB,
		"mvc.command.name=" + AxHrmsBirthdayWebPortletConstants.DEFAULT_PATH }, service = MVCRenderCommand.class)
public class ListBirthdayEmployeeMVCRenderCommand implements MVCRenderCommand {
	private static final Log log = LogFactoryUtil.getLog(ListBirthdayEmployeeMVCRenderCommand.class);

	@Reference
	private EmployeeDetailsLocalService employeeDetailsLocalService;

	@Reference
	private EmployeeDepartmentLocalService employeeDepartmentLocalService;

	@Reference
	private EmployeeDesignationLocalService employeeDesignationLocalService;

	@Reference
	private DepartmentMasterLocalService departmentMasterLocalService;

	@Reference
	private DesignationMasterLocalService designationMasterLocalService;
	@Reference
	private WishTypeMasterLocalService wishTypeMasterLocalService;

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {

		BirthdayWebUtil birthdayWebUtil = new BirthdayWebUtil(employeeDetailsLocalService, employeeDepartmentLocalService, employeeDesignationLocalService, departmentMasterLocalService, designationMasterLocalService, wishTypeMasterLocalService);
		
				
		List<EmployeeDetails> birthdayListOfEmployee = birthdayWebUtil.getBirthdayEmployee();

		List<BirthdayEmployeeDto> birthdayEmployeeDtoList = new ArrayList<>();

		try {
			birthdayEmployeeDtoList = birthdayWebUtil.convertIntoBirthdayEmployeeDto(birthdayListOfEmployee);
		} catch (PortalException e) {
			log.error(
					"ListBirthdayEmployeeMVCRenderCommand >>> Render >>>Error in  ConvertIntoBirthdayEmployeeDto Method."
							+ e.getMessage());
		}

		if(birthdayEmployeeDtoList.size()==0)
		{
		renderRequest.setAttribute(AxHrmsBirthdayWebPortletConstants.IS_LIST_EMPTY, true);
		}
		renderRequest.setAttribute(AxHrmsBirthdayWebPortletConstants.BIRTHDAY_LIST_OF_EMPLOYEE, birthdayEmployeeDtoList);

		return AxHrmsBirthdayWebPortletConstants.VIEW_BIRTHDAY_EMPLOYEE_JSP;
	}

}
