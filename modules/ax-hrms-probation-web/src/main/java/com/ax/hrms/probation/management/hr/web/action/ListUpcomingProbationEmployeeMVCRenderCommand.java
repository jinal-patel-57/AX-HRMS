package com.ax.hrms.probation.management.hr.web.action;

import com.ax.hrms.exception.NoSuchEmployeeDepartmentException;
import com.ax.hrms.exception.NoSuchEmployeeDesignationException;
import com.ax.hrms.master.exception.NoSuchProbationStatusMasterException;
import com.ax.hrms.master.model.DepartmentMaster;
import com.ax.hrms.master.model.DesignationMaster;
import com.ax.hrms.master.service.DepartmentMasterLocalService;
import com.ax.hrms.master.service.DesignationMasterLocalService;
import com.ax.hrms.master.service.ProbationStatusMasterLocalService;
import com.ax.hrms.model.EmployeeDetails;
import com.ax.hrms.model.EmployeeProbationDetails;
import com.ax.hrms.model.UpcomingProbationEmployee;
import com.ax.hrms.probation.management.hr.web.constants.AxHrmsProbationHrWebConstants;
import com.ax.hrms.probation.management.hr.web.constants.AxHrmsProbationHrWebPortletKey;
import com.ax.hrms.probation.management.hr.web.dto.EmployeeProbationDetailDto;
import com.ax.hrms.service.*;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @author krish.moradiya
 */
@Component(
		immediate = true,
		property = {
			"javax.portlet.name=" + AxHrmsProbationHrWebPortletKey.AX_HRMS_PROBATION_HR_WEB_PORTLET_KEY,
			"mvc.command.name=" + AxHrmsProbationHrWebConstants.DEFAULT_PATH
		},
		service = MVCRenderCommand.class
)
public class ListUpcomingProbationEmployeeMVCRenderCommand implements MVCRenderCommand{

	@Reference
	EmployeeProbationDetailsLocalService employeeProbationDetailsLocalService;
	@Reference
	UpcomingProbationEmployeeLocalService upcomingProbationEmployeeLocalService;
	@Reference
	EmployeeDetailsLocalService employeeDetailsLocalService;
	@Reference
	DepartmentMasterLocalService departmentMasterLocalService;
	@Reference
	DesignationMasterLocalService designationMasterLocalService;
	@Reference
	EmployeeDepartmentLocalService employeeDepartmentLocalService;
	@Reference
	EmployeeDesignationLocalService employeeDesignationLocalService;
	@Reference
	ProbationStatusMasterLocalService probationStatusMasterLocalService;

	private static final Log log = LogFactoryUtil.getLog(ListUpcomingProbationEmployeeMVCRenderCommand.class);

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {

		Calendar currentDateCalendar = Calendar.getInstance();
		int currentMonth = currentDateCalendar.get(Calendar.MONTH)+1;
		int currentYear = currentDateCalendar.get(Calendar.YEAR);

		long inProbationStatusId = 0L;
		long extendedStatusId = 0L;

		List<EmployeeProbationDetailDto> employeeProbationDetailDtoList = new ArrayList<>();

        try {
            inProbationStatusId = probationStatusMasterLocalService.findByProbationStatusName(AxHrmsProbationHrWebConstants.IN_PROBATION).getProbationStatusMasterId();
            extendedStatusId = probationStatusMasterLocalService.findByProbationStatusName(AxHrmsProbationHrWebConstants.EXTENDED).getProbationStatusMasterId();
        } catch (NoSuchProbationStatusMasterException e) {
            log.error("ListUpcomingProbationEmployeeMVCRenderCommand >>> Render ::: Probation Status Master not fetch Exception : "+e.getMessage());
        }

		try {
			List<UpcomingProbationEmployee> listOfUpcomingProbationEmployees = upcomingProbationEmployeeLocalService.findByMonthAndYear(currentMonth, currentYear);

			for (UpcomingProbationEmployee upcomingProbationEmployee : listOfUpcomingProbationEmployees) {
				EmployeeProbationDetails employeeProbationDetails = employeeProbationDetailsLocalService.fetchEmployeeProbationDetails(upcomingProbationEmployee.getProbationDetailId());
				EmployeeDetails employeeDetails = employeeDetailsLocalService.fetchEmployeeDetails(employeeProbationDetails.getEmployeeId());
				EmployeeProbationDetailDto employeeProbationDetailDto = getEmployeeProbationDetailDto(employeeProbationDetails, employeeDetails);

				Date probationEndDate = employeeProbationDetailDto.getProbationEndDate();
				Calendar calendar = Calendar.getInstance();
				calendar.setTime(probationEndDate);
				int probationEndMonth = calendar.get(Calendar.MONTH)+1;
				int probationEndYear = calendar.get(Calendar.YEAR);

				boolean isCurrentProbationEndDate = (probationEndMonth == currentMonth) && (probationEndYear == currentYear);


				if (employeeProbationDetailDto.getProbationStatusMasterId() == inProbationStatusId || employeeProbationDetailDto.getProbationStatusMasterId() == extendedStatusId && isCurrentProbationEndDate)
					employeeProbationDetailDtoList.add(employeeProbationDetailDto);
			}
		}catch(Exception e){
			log.error("ListUpcomingProbationEmployeeMVCRenderCommand >>> Render ::: Exception : " + e.getMessage());
		}
		renderRequest.setAttribute(AxHrmsProbationHrWebConstants.UPCOMING_PROBATION_EMPLOYEE_DETAIL_LIST,employeeProbationDetailDtoList);
		return AxHrmsProbationHrWebConstants.LIST_OF_UPCOMING_PROBATION_EMPLOYEE_JSP_PATH;
	}

	private EmployeeProbationDetailDto getEmployeeProbationDetailDto(EmployeeProbationDetails employeeProbationDetails,EmployeeDetails employeeDetails){
        return setEmployeeProbationDetailDto(employeeDetails,employeeProbationDetails);
	}
	private EmployeeProbationDetailDto setEmployeeProbationDetailDto(EmployeeDetails employeeDetails, EmployeeProbationDetails employeeProbationDetails){
		EmployeeProbationDetailDto employeeProbationDetailDto = new EmployeeProbationDetailDto();

		// Set Department name and Designation Name
		try {
			DepartmentMaster departmentMaster = departmentMasterLocalService.fetchDepartmentMaster(employeeDepartmentLocalService.findByEmployeeId(employeeDetails.getEmployeeId()).getDepartmentMasterId());
			DesignationMaster designationMaster = designationMasterLocalService.fetchDesignationMaster(employeeDesignationLocalService.findByEmployeeId(employeeDetails.getEmployeeId()).getDesignationMasterId());

			employeeProbationDetailDto.setDepartmentName(departmentMaster.getDepartmentName());
			employeeProbationDetailDto.setDesignationName(designationMaster.getDesignationName());
		} catch (NoSuchEmployeeDepartmentException | NoSuchEmployeeDesignationException e) {
			log.error("ListUpcomingProbationEmployeeMVCRenderCommand >>> getEmployeeProbationDetailDto ::: Exception is: "+e.getMessage());
		}

		//Set Employee related data
		employeeProbationDetailDto.setEmployeeId(employeeDetails.getEmployeeId());
		employeeProbationDetailDto.setEmployeeCode(employeeDetails.getEmployeeCode());
		employeeProbationDetailDto.setEmployeeName(employeeDetails.getFirstName()+AxHrmsProbationHrWebConstants.ONE_SPACE+employeeDetails.getLastName());
		employeeProbationDetailDto.setJoiningDate(employeeDetails.getJoiningDate());
		employeeProbationDetailDto.setProbationEndDate(employeeProbationDetails.getProbationEndDate());
		employeeProbationDetailDto.setProbationStatusMasterId(employeeDetails.getProbationStatusId());

		return employeeProbationDetailDto;
	}
}
