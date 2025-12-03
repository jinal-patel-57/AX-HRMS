package com.ax.hrms.employee.directory.util;

import com.ax.hrms.master.service.DepartmentMasterLocalService;
import com.ax.hrms.master.service.DesignationMasterLocalService;
import com.ax.hrms.model.CustomEmployeeDetailsDTO;
import com.ax.hrms.model.EmployeeDepartment;
import com.ax.hrms.model.EmployeeDetails;
import com.ax.hrms.service.EmployeeDepartmentLocalService;
import com.ax.hrms.service.EmployeeDesignationLocalService;
import com.ax.hrms.service.EmployeeDetailsLocalService;
import com.liferay.portal.kernel.exception.PortalException;

import java.util.ArrayList;
import java.util.List;

public class EmployeeDetailUtil {
    CustomEmployeeDetailsDTO employeeDetailsDTO = new CustomEmployeeDetailsDTO();
    static EmployeeDetailsLocalService employeeDetailsLocalService;
    static EmployeeDepartmentLocalService employeeDepartmentLocalService;
    static EmployeeDesignationLocalService employeeDesignationLocalService;
    static DepartmentMasterLocalService departmentMasterLocalService;
    static DesignationMasterLocalService designationMasterLocalService;
    public EmployeeDetailUtil(EmployeeDetailsLocalService employeeDetailsLocalService, EmployeeDepartmentLocalService employeeDepartmentLocalService, EmployeeDesignationLocalService employeeDesignationLocalService, DepartmentMasterLocalService departmentMasterLocalService, DesignationMasterLocalService designationMasterLocalService){
        this.employeeDetailsLocalService = employeeDetailsLocalService;
        this.employeeDepartmentLocalService = employeeDepartmentLocalService;
        this.employeeDesignationLocalService = employeeDesignationLocalService;
        this.departmentMasterLocalService = departmentMasterLocalService;
        this.designationMasterLocalService = designationMasterLocalService;
    }
    public CustomEmployeeDetailsDTO getEmployeeDetail(long employeeId) throws PortalException {
        EmployeeDetails employeeDetails = employeeDetailsLocalService.getEmployeeDetails(employeeId);
        employeeDetailsDTO.setEmployeeId(employeeId);
        employeeDetailsDTO.setFirstName(employeeDetails.getFirstName());
        employeeDetailsDTO.setLastName(employeeDetails.getLastName());
        employeeDetailsDTO.setMobileNo(employeeDetails.getMobileNo());
        employeeDetailsDTO.setOfficialEmail(employeeDetails.getOfficialEmail());
        employeeDetailsDTO.setSkypeId(employeeDetails.getSkypeId());
        employeeDetailsDTO.setDateOfBirth(employeeDetails.getDateOfBirth());
        employeeDetailsDTO.setDesignationName(designationMasterLocalService.getDesignationMaster(employeeDesignationLocalService.findByEmployeeId(employeeId).getDesignationMasterId()).getDesignationName());
        List<EmployeeDepartment> employeeDepartments = employeeDepartmentLocalService.findByEmployeeIdGetDepartments(employeeId);
        List<String> employeesDepartmentName = new ArrayList<>();
        for(EmployeeDepartment employeeDepartment: employeeDepartments){
            employeesDepartmentName.add(departmentMasterLocalService.getDepartmentMaster(employeeDepartment.getDepartmentMasterId()).getDepartmentName());
        }
        employeeDetailsDTO.setDepartmentList(employeesDepartmentName);
        employeeDetailsDTO.setleavingDate(employeeDetails.getLeavingDate());
        return employeeDetailsDTO;
    }

}
