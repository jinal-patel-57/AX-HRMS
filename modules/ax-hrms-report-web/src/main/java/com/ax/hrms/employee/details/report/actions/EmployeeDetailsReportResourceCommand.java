package com.ax.hrms.employee.details.report.actions;

import static com.ax.hrms.report.web.constants.AkHrmsLeaveBalanceReportWebPortletKeys.ALL;

import com.ax.hrms.master.model.DepartmentMaster;
import com.ax.hrms.master.model.DesignationMaster;
import com.ax.hrms.master.service.DepartmentMasterLocalService;
import com.ax.hrms.master.service.DesignationMasterLocalService;
import com.ax.hrms.model.Address;
import com.ax.hrms.model.EmployeeAddress;
import com.ax.hrms.model.EmployeeBankAccount;
import com.ax.hrms.model.EmployeeDepartment;
import com.ax.hrms.model.EmployeeDesignation;
import com.ax.hrms.model.EmployeeDetails;
import com.ax.hrms.model.EmployeeSalary;
import com.ax.hrms.model.EmployeeUanEsic;
import com.ax.hrms.model.Nominee;
import com.ax.hrms.report.web.constants.AkHrmsEmployeeDetailsReportWebPortletKeys;
import com.ax.hrms.report.web.util.EmployeeDetailsExcelExportUtil;
import com.ax.hrms.service.AddressLocalService;
import com.ax.hrms.service.EmployeeAddressLocalService;
import com.ax.hrms.service.EmployeeBankAccountLocalService;
import com.ax.hrms.service.EmployeeDepartmentLocalService;
import com.ax.hrms.service.EmployeeDesignationLocalService;
import com.ax.hrms.service.EmployeeDetailsLocalService;
import com.ax.hrms.service.EmployeeSalaryLocalService;
import com.ax.hrms.service.EmployeeUanEsicLocalService;
import com.ax.hrms.service.LeaveDayTypeLocalService;
import com.ax.hrms.service.LeaveRequestLocalService;
import com.ax.hrms.service.NomineeLocalService;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
        property = {
                "javax.portlet.name=" + AkHrmsEmployeeDetailsReportWebPortletKeys.AKHRMSEMPLOYEEDETAILSREPORTWEB,
                "mvc.command.name=/export/employeeDetails"
        },
        service = MVCResourceCommand.class
)
public class EmployeeDetailsReportResourceCommand implements MVCResourceCommand {


    public static final String EMPLOYEE_IDS = "employeeIds";

    public static final String EMPLOYEE_TYPE = "employeeType";

    @Override
    public boolean serveResource(ResourceRequest request, ResourceResponse response) {

        try {
        	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

            String employeeType = ParamUtil.getString(request, EMPLOYEE_TYPE);

            long[] employeeIds;

            if (ALL.equalsIgnoreCase(employeeType)) {
                List<EmployeeDetails> allEmployees =
                        employeeDetailsLocalService.findByIsTerminated(false);
                employeeIds = allEmployees.stream()
                        .mapToLong(EmployeeDetails::getEmployeeId)
                        .toArray();

            } else {
                employeeIds = ParamUtil.getLongValues(request, EMPLOYEE_IDS);
            }

            JSONArray employeesArr = JSONFactoryUtil.createJSONArray();
            for (long employeeId : employeeIds) {

                EmployeeDetails employeeDetails =
                        employeeDetailsLocalService.getEmployeeDetails(employeeId);

                JSONObject employeeDetailsJson = JSONFactoryUtil.createJSONObject();
                employeeDetailsJson.put("putX", "-");
                employeeDetailsJson.put("code", employeeDetails.getEmployeeCode());
                employeeDetailsJson.put("panName", employeeDetails.getNameAsPerAadhaarCard());
                try {
                	EmployeeSalary employeeSalary = employeeSalaryLocalService.findByEmployeeIdAndStatus(employeeId, true);
                	employeeDetailsJson.put("grossSalaryPm", employeeSalary.getGrossSalaryCtcPm());
                	employeeDetailsJson.put("grossSalaryPa", employeeSalary.getGrossSalaryCtcPa());
                } catch(Exception e) {
                	log.error("Error while fetching salary -- "+ e.getMessage());
                	employeeDetailsJson.put("grossSalaryPm", 0.0);
                	employeeDetailsJson.put("grossSalaryPa", 0.0);
                }
                Date joiningDate = employeeDetails.getJoiningDate();
                employeeDetailsJson.put("joiningDate", sdf.format(joiningDate));
                employeeDetailsJson.put("officialEmail", employeeDetails.getOfficialEmail());
                
                try {
					EmployeeDepartment employeeDepartment = employeeDepartmentLocalService.findByEmployeeId(employeeDetails.getEmployeeId());
					DepartmentMaster department = departmentMasterLocalService.getDepartmentMaster(employeeDepartment.getDepartmentMasterId());
					employeeDetailsJson.put("department", department.getDepartmentName());
				} catch(Exception e) {
					log.error("Unable to fetch department-- "+e.getMessage());
					employeeDetailsJson.put("department", "-");
				}
				
				try {
					EmployeeDesignation employeeDesignation = employeeDesignationLocalService.findByEmployeeId(employeeDetails.getEmployeeId());
					DesignationMaster designation = designationMasterLocalService.getDesignationMaster(employeeDesignation.getDesignationMasterId());
					employeeDetailsJson.put("designation", designation.getDesignationName());
				} catch(Exception e) {
					log.error("Unable to fetch designation-- "+e.getMessage());
					employeeDetailsJson.put("designation", "-");
				}
				employeeDetailsJson.put("branch", "Ahmedabad");
				
				if(Validator.isNotNull(employeeDetails.getBankAccountId()) && employeeDetails.getBankAccountId()>0) {
					try {
						EmployeeBankAccount employeeBankAccount = employeeBankAccountLocalService.getEmployeeBankAccount(employeeDetails.getBankAccountId());
						employeeDetailsJson.put("bankName", employeeBankAccount.getBankName());
						employeeDetailsJson.put("ifsc", employeeBankAccount.getIfscCode());
						employeeDetailsJson.put("savingBankAccount", employeeBankAccount.getAccountNumber());
					} catch(Exception e) {
						log.error("Error while fetching employee bank account -- " + e.getMessage());
						employeeDetailsJson.put("bankName", "-");
						employeeDetailsJson.put("ifsc", "-");
						employeeDetailsJson.put("savingBankAccount", "-");
					}
				} else {
					employeeDetailsJson.put("bankName", "-");
					employeeDetailsJson.put("ifsc", "-");
					employeeDetailsJson.put("savingBankAccount", "-");
				}
				employeeDetailsJson.put("pan", employeeDetails.getPanCardNumber());
				employeeDetailsJson.put("personalEmail", employeeDetails.getPersonalEmail());
				log.info("mobile No -- " + employeeDetails.getMobileNo());
				employeeDetailsJson.put("mobileNo", employeeDetails.getMobileNo());
				employeeDetailsJson.put("gender", employeeDetails.getGender());
				employeeDetailsJson.put("fhName", employeeDetails.getFatherName());
				String employeeDobStr = Validator.isNotNull(employeeDetails.getDateOfBirth())?sdf.format(employeeDetails.getDateOfBirth()):"";
				employeeDetailsJson.put("dateOfBirth", employeeDobStr);
				employeeDetailsJson.put("maritalStatus", employeeDetails.isMaritalStatus()?"Married":"Single");
				employeeDetailsJson.put("nameAsPerAadhar", employeeDetails.getNameAsPerAadhaarCard());
				employeeDetailsJson.put("kycDoc", "Aadhar Card");
				
				try {
					long employeeAddressId = employeeDetails.getEmployeeAddressId();
		            EmployeeAddress employeeAddress = employeeAddressLocalService.getEmployeeAddress(employeeAddressId);
		            if (employeeAddress.getPresentPermanentSame()) {
		                Address presentaddress = addressLocalService.getAddress(employeeAddress.getPresentAddress());
		                String address = getAddressString(presentaddress);
		                employeeDetailsJson.put("presentAddress", address);
		                employeeDetailsJson.put("permanentAddress", address);
		            } else {
		                Address presentaddress = addressLocalService.getAddress(employeeAddress.getPresentAddress());
		                Address permanentaddress = addressLocalService.getAddress(employeeAddress.getPermanentAddress());
		                employeeDetailsJson.put("presentAddress", getAddressString(presentaddress));
		                employeeDetailsJson.put("permanentAddress", getAddressString(permanentaddress));
		            }
				} catch(Exception e) {
					log.error("Error while fetching employeeAddress - " + e.getMessage());
					employeeDetailsJson.put("presentAddress", "-");
	                employeeDetailsJson.put("permanentAddress", "-");
				}
				
				try {
					EmployeeUanEsic employeeUanEsic = employeeUanEsicLocalService.getEmployeeUanEsic(employeeDetails.getUanEsicId());
					employeeDetailsJson.put("uan", employeeUanEsic.getUan());
					employeeDetailsJson.put("esic", employeeUanEsic.getEsicNo());
				} catch(Exception e) {
					log.error("Error while fetching employee uan esic -- " + e.getMessage());
					employeeDetailsJson.put("uan", "-");
					employeeDetailsJson.put("esic", "-");
				}
				
				try {
					Nominee nominee = nomineeLocalService.getNominee(employeeDetails.getNominneeId());
					employeeDetailsJson.put("nomineeName", nominee.getNomineeFirstName() + " " + nominee.getNomineeLastName());
					employeeDetailsJson.put("relation", nominee.getRelationshipWithNominee());
					String nomineeDOBStr = Validator.isNotNull(nominee.getNomineeDob())?sdf.format(nominee.getNomineeDob()):"";
					employeeDetailsJson.put("nomineeDob", nomineeDOBStr);
				} catch(Exception e) {
					log.error("Error while fetching nominee -- " + e.getMessage());
					employeeDetailsJson.put("nomineeName", "-");
					employeeDetailsJson.put("relation", "-");
					employeeDetailsJson.put("nomineeDob", "-");
				}
                employeeDetailsJson.put("coEmployeeCode", "-");
                employeeDetailsJson.put("spouseName", employeeDetails.getSpouseName());
                employeesArr.put(employeeDetailsJson);
            }

			EmployeeDetailsExcelExportUtil.exportEmployeeExcel(employeesArr, response);

        } catch (Exception e) {
            log.error("Exception in Leave Export", e);
        }

        return false;
    }

	private String getAddressString(Address address) {
		List<String> parts = new ArrayList<>();
		String addressStr = "";
		if(Validator.isNotNull(address)) {
			parts.add(address.getLine1());
			if (Validator.isNotNull(address.getLine2())) {
				parts.add(address.getLine2());
			}
			if (Validator.isNotNull(address.getLine3())) {
				parts.add(address.getLine3());
			}
			if (Validator.isNotNull(address.getCity())) {
				parts.add(address.getCity());
			}
			if (Validator.isNotNull(address.getState())) {
				parts.add(address.getState());
			}
			addressStr = StringUtil.merge(parts, ", ");
			if (Validator.isNotNull(address.getPincode())) {
				addressStr = addressStr + " - " + address.getPincode();
			}
		} 
		return addressStr;
	}

    private static final Log log = LogFactoryUtil.getLog(EmployeeDetailsReportResourceCommand.class);

    @Reference
    NomineeLocalService nomineeLocalService;
    
    @Reference
    EmployeeUanEsicLocalService employeeUanEsicLocalService;
    
    @Reference
    EmployeeBankAccountLocalService employeeBankAccountLocalService;
    
    @Reference
    EmployeeAddressLocalService employeeAddressLocalService;
    
    @Reference
    AddressLocalService addressLocalService;
    
    @Reference
	EmployeeDepartmentLocalService employeeDepartmentLocalService;
	
	@Reference
	EmployeeDesignationLocalService employeeDesignationLocalService;
	
	@Reference
	DesignationMasterLocalService designationMasterLocalService;
	
	@Reference
	DepartmentMasterLocalService departmentMasterLocalService;
    
    @Reference
    private EmployeeSalaryLocalService employeeSalaryLocalService;

    @Reference
    private EmployeeDetailsLocalService employeeDetailsLocalService;

    @Reference
    private LeaveRequestLocalService leaveRequestLocalService;

    @Reference
    private LeaveDayTypeLocalService leaveDayTypeLocalService;

}
