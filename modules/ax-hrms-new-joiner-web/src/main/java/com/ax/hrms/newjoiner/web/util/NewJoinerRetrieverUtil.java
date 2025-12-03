package com.ax.hrms.newjoiner.web.util;

import com.ax.hrms.master.service.DepartmentMasterLocalService;
import com.ax.hrms.master.service.DesignationMasterLocalService;
import com.ax.hrms.model.EmployeeDetails;
import com.ax.hrms.newjoiner.web.constants.AxHrmsNewJoinerWebPortletConstants;
import com.ax.hrms.newjoiner.web.dto.NewJoinerDto;
import com.ax.hrms.service.EmployeeDepartmentLocalService;
import com.ax.hrms.service.EmployeeDesignationLocalService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class NewJoinerRetrieverUtil {
    private static final Log log = LogFactoryUtil.getLog(NewJoinerRetrieverUtil.class);
    private NewJoinerRetrieverUtil(){}

    private static boolean isWithinLastFifteenDays(Date date) {
        if (date == null) {
            throw new IllegalArgumentException(AxHrmsNewJoinerWebPortletConstants.DATE_OBJECT_NULL_MESSAGE);
        }
        Calendar currentDateTime = Calendar.getInstance();
        currentDateTime.set(Calendar.HOUR_OF_DAY, 0);
        currentDateTime.set(Calendar.MINUTE, 0);
        currentDateTime.set(Calendar.SECOND, 0);
        currentDateTime.set(Calendar.MILLISECOND, 0);
        Calendar joiningDate = Calendar.getInstance();
        joiningDate.setTime(date);
        long differenceInMillis = currentDateTime.getTimeInMillis() - joiningDate.getTimeInMillis();
        long differenceInDays = differenceInMillis / (24 * 60 * 60 * 1000);
        return (differenceInDays >= 0 && differenceInDays < 15);
    }

    private static List<EmployeeDetails> getNewJoinerEmployeeDetails(List<EmployeeDetails> employeeDetailsList){
        try {
            List<EmployeeDetails> newJoinerList = employeeDetailsList.stream()
                    .filter(employeeDetailsObj -> isWithinLastFifteenDays(employeeDetailsObj.getJoiningDate()))
                    .collect(Collectors.toList());

            if(!newJoinerList.isEmpty())
                return newJoinerList;
        }catch(Exception e) {
            log.error("NewJoinerRetrieverUtil >>> getNewJoinerDetails >>> Exception is: ::: "+e.getMessage());
        }
        return new ArrayList<>();
    }

    public static List<NewJoinerDto> getNewJoinerList(List<EmployeeDetails> employeeDetailsList, DepartmentMasterLocalService departmentMasterLocalService, DesignationMasterLocalService designationMasterLocalService, EmployeeDepartmentLocalService employeeDepartmentLocalService, EmployeeDesignationLocalService employeeDesignationLocalService){
        employeeDetailsList = getNewJoinerEmployeeDetails(employeeDetailsList);
        List<NewJoinerDto> newJoinerDtoList = new ArrayList<>();
        if(!employeeDetailsList.isEmpty()){
            for(EmployeeDetails employeeDetails : employeeDetailsList){
                NewJoinerDto newJoinerDto = new NewJoinerDto();
                newJoinerDto.setEmployeeId(employeeDetails.getEmployeeId());
                newJoinerDto.setEmployeeName(employeeDetails.getFirstName()+AxHrmsNewJoinerWebPortletConstants.ONE_SPACE+employeeDetails.getLastName());
                try{
                    newJoinerDto.setDepartmentName(departmentMasterLocalService.getDepartmentMaster(employeeDepartmentLocalService.findByEmployeeId(employeeDetails.getEmployeeId()).getDepartmentMasterId()).getDepartmentName());
                }catch (PortalException | NullPointerException e) {
                    newJoinerDto.setDepartmentName(AxHrmsNewJoinerWebPortletConstants.DASH);
                }
                try{
                    newJoinerDto.setDesignationName(designationMasterLocalService.getDesignationMaster(employeeDesignationLocalService.findByEmployeeId(employeeDetails.getEmployeeId()).getDesignationMasterId()).getDesignationName());
                }catch (PortalException | NullPointerException e) {
                    newJoinerDto.setDesignationName(AxHrmsNewJoinerWebPortletConstants.DASH);
                }
                newJoinerDto.setEmployeeCode(employeeDetails.getEmployeeCode());
                newJoinerDtoList.add(newJoinerDto);
            }
        }

        return newJoinerDtoList;
    }


}
