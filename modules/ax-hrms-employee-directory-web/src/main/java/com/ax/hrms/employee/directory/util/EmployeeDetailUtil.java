package com.ax.hrms.employee.directory.util;

import com.ax.hrms.master.service.DepartmentMasterLocalService;
import com.ax.hrms.master.service.DesignationMasterLocalService;
import com.ax.hrms.model.CustomEmployeeDetailsDTO;
import com.ax.hrms.model.EmployeeDepartment;
import com.ax.hrms.model.EmployeeDesignation;
import com.ax.hrms.model.EmployeeDetails;
import com.ax.hrms.service.EmployeeDepartmentLocalService;
import com.ax.hrms.service.EmployeeDesignationLocalService;
import com.ax.hrms.service.EmployeeDetailsLocalService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.util.ArrayList;
import java.util.List;

public class EmployeeDetailUtil {
    CustomEmployeeDetailsDTO employeeDetailsDTO = new CustomEmployeeDetailsDTO();
    Log _log = LogFactoryUtil.getLog(EmployeeDetailUtil.class.getName());

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
//    public CustomEmployeeDetailsDTO getEmployeeDetail(long employeeId) throws PortalException {
//        EmployeeDetails employeeDetails = employeeDetailsLocalService.getEmployeeDetails(employeeId);
//        employeeDetailsDTO.setEmployeeId(employeeId);
//        employeeDetailsDTO.setFirstName(employeeDetails.getFirstName());
//        employeeDetailsDTO.setLastName(employeeDetails.getLastName());
//        employeeDetailsDTO.setMobileNo(employeeDetails.getMobileNo());
//        employeeDetailsDTO.setOfficialEmail(employeeDetails.getOfficialEmail());
//        employeeDetailsDTO.setSkypeId(employeeDetails.getSkypeId());
//        employeeDetailsDTO.setDateOfBirth(employeeDetails.getDateOfBirth());
//        employeeDetailsDTO.setDesignationName(designationMasterLocalService.getDesignationMaster(employeeDesignationLocalService.findByEmployeeId(employeeId).getDesignationMasterId()).getDesignationName());
//        List<EmployeeDepartment> employeeDepartments = employeeDepartmentLocalService.findByEmployeeIdGetDepartments(employeeId);
//        List<String> employeesDepartmentName = new ArrayList<>();
//        for(EmployeeDepartment employeeDepartment: employeeDepartments){
//            employeesDepartmentName.add(departmentMasterLocalService.getDepartmentMaster(employeeDepartment.getDepartmentMasterId()).getDepartmentName());
//        }
//        employeeDetailsDTO.setDepartmentList(employeesDepartmentName);
//        employeeDetailsDTO.setleavingDate(employeeDetails.getLeavingDate());
//        return employeeDetailsDTO;
//    }

    public CustomEmployeeDetailsDTO getEmployeeDetail(long employeeId) throws PortalException {

        CustomEmployeeDetailsDTO employeeDetailsDTO = new CustomEmployeeDetailsDTO();

        try {

            EmployeeDetails employeeDetails =
                    employeeDetailsLocalService.getEmployeeDetails(employeeId);

            employeeDetailsDTO.setEmployeeId(employeeId);
            employeeDetailsDTO.setFirstName(employeeDetails.getFirstName());
            employeeDetailsDTO.setLastName(employeeDetails.getLastName());
            employeeDetailsDTO.setMobileNo(employeeDetails.getMobileNo());
            employeeDetailsDTO.setOfficialEmail(employeeDetails.getOfficialEmail());
            employeeDetailsDTO.setSkypeId(employeeDetails.getSkypeId());
            employeeDetailsDTO.setDateOfBirth(employeeDetails.getDateOfBirth());

            try {
                List<EmployeeDesignation> employeeDesignations =
                        employeeDesignationLocalService.findByEmployeeIdToGetAllDesignation(employeeId);

                for (EmployeeDesignation employeeDesignation : employeeDesignations) {

                    if (employeeDesignation.isStatus()) {

                        employeeDetailsDTO.setDesignationName(
                                designationMasterLocalService
                                        .getDesignationMaster(
                                                employeeDesignation.getDesignationMasterId())
                                        .getDesignationName()
                        );
                        break;
                    }
                }
            } catch (Exception e) {
                _log.error("Error fetching designation for employeeId: " + employeeId, e);
            }

            try {
                List<EmployeeDepartment> employeeDepartments =
                        employeeDepartmentLocalService.findByEmployeeIdGetDepartments(employeeId);

                List<String> employeesDepartmentName = new ArrayList<>();

                for (EmployeeDepartment employeeDepartment : employeeDepartments) {

                    if (employeeDepartment.isStatus()) {

                        employeesDepartmentName.add(
                                departmentMasterLocalService
                                        .getDepartmentMaster(
                                                employeeDepartment.getDepartmentMasterId())
                                        .getDepartmentName()
                        );
                    }
                }

                employeeDetailsDTO.setDepartmentList(employeesDepartmentName);

            } catch (Exception e) {
                _log.error("Error fetching department for employeeId: " + employeeId, e);
            }

        } catch (PortalException e) {
            _log.error("Employee not found for employeeId: " + employeeId, e);
            throw e;
        }

        return employeeDetailsDTO;
    }


}
