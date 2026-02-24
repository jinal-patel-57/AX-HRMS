package com.ax.hrms.employee.details.report.actions;

import static com.ax.hrms.report.web.constants.AkHrmsLeaveBalanceReportWebPortletKeys.ALL;

import com.ax.hrms.master.model.DepartmentMaster;
import com.ax.hrms.master.model.DesignationMaster;
import com.ax.hrms.master.model.DocumentTypeMaster;
import com.ax.hrms.master.service.DepartmentMasterLocalService;
import com.ax.hrms.master.service.DesignationMasterLocalService;
import com.ax.hrms.master.service.DocumentTypeMasterLocalService;
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
import com.liferay.petra.string.StringPool;
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


    public static final String EMPLOYEE_NAME = "Employee Name";

	public static final String SPOUSE_NAME = "spouseName";

    public static final String CO_EMPLOYEE_CODE = "coEmployeeCode";

    public static final String NOMINEE_DOB = "nomineeDob";

    public static final String RELATION = "relation";

    public static final String NOMINEE_NAME = "nomineeName";

    public static final String ESIC = "esic";

    public static final String UAN = "uan";

    public static final String PERMANENT_ADDRESS = "permanentAddress";

    public static final String PRESENT_ADDRESS = "presentAddress";

    public static final String MARRIED = "Married";

    public static final String SINGLE = "Single";

    public static final String AADHAR_CARD = "Aadhar Card";

    public static final String KYC_DOC = "kycDoc";

    public static final String NAME_AS_PER_AADHAR = "nameAsPerAadhar";

    public static final String MARITAL_STATUS = "maritalStatus";

    public static final String DATE_OF_BIRTH = "dateOfBirth";

    public static final String FH_NAME = "fhName";

    public static final String GENDER = "gender";

    public static final String MOBILE_NO = "mobileNo";

    public static final String PERSONAL_EMAIL = "personalEmail";

    public static final String PAN = "pan";

    public static final String SAVING_BANK_ACCOUNT = "savingBankAccount";

    public static final String IFSC = "ifsc";

    public static final String BANK_NAME = "bankName";

    public static final String AHMEDABAD = "Ahmedabad";

    public static final String BRANCH = "branch";

    public static final String DESIGNATION2 = "designation";

    public static final String DEPARTMENT2 = "department";

    public static final String OFFICIAL_EMAIL = "officialEmail";

    public static final String JOINING_DATE = "joiningDate";

    public static final String GROSS_SALARY_PA = "grossSalaryPa";

    public static final String GROSS_SALARY_PM = "grossSalaryPm";

    public static final String PAN_NAME = "panName";

    public static final String CODE = "code";

    public static final String PUT_X = "putX";

    public static final String DD_MM_YYYY = "dd/MM/yyyy";

	public static final String EMPLOYEE_IDS = "employeeIds";

    public static final String EMPLOYEE_TYPE = "employeeType";

    @Override
    public boolean serveResource(ResourceRequest request, ResourceResponse response) {

        try {
        	SimpleDateFormat sdf = new SimpleDateFormat(DD_MM_YYYY);

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
                employeeDetailsJson.put(PUT_X, StringPool.DASH);
                employeeDetailsJson.put("employeeName", employeeDetails.getFirstName() + " " + employeeDetails.getLastName());
                employeeDetailsJson.put(CODE, employeeDetails.getEmployeeCode());
                
                try {
                	EmployeeSalary employeeSalary = employeeSalaryLocalService.findByEmployeeIdAndStatus(employeeId, true);
                	employeeDetailsJson.put(GROSS_SALARY_PM, employeeSalary.getGrossSalaryCtcPm());
                	employeeDetailsJson.put(GROSS_SALARY_PA, employeeSalary.getGrossSalaryCtcPa());
                } catch(Exception e) {
                	log.error("Error while fetching salary -- "+ e.getMessage());
                	employeeDetailsJson.put(GROSS_SALARY_PM, 0.0);
                	employeeDetailsJson.put(GROSS_SALARY_PA, 0.0);
                }
                Date joiningDate = employeeDetails.getJoiningDate();
                employeeDetailsJson.put(JOINING_DATE, sdf.format(joiningDate));
                employeeDetailsJson.put(OFFICIAL_EMAIL, employeeDetails.getOfficialEmail());
                
                try {
					EmployeeDepartment employeeDepartment = employeeDepartmentLocalService.findByEmployeeId(employeeDetails.getEmployeeId());
					DepartmentMaster department = departmentMasterLocalService.getDepartmentMaster(employeeDepartment.getDepartmentMasterId());
					employeeDetailsJson.put(DEPARTMENT2, department.getDepartmentName());
				} catch(Exception e) {
					log.error("Unable to fetch department-- "+e.getMessage());
					employeeDetailsJson.put(DEPARTMENT2, StringPool.DASH);
				}
				
				try {
					EmployeeDesignation employeeDesignation = employeeDesignationLocalService.findByEmployeeId(employeeDetails.getEmployeeId());
					DesignationMaster designation = designationMasterLocalService.getDesignationMaster(employeeDesignation.getDesignationMasterId());
					employeeDetailsJson.put(DESIGNATION2, designation.getDesignationName());
				} catch(Exception e) {
					log.error("Unable to fetch designation-- "+e.getMessage());
					employeeDetailsJson.put(DESIGNATION2, StringPool.DASH);
				}
				employeeDetailsJson.put(BRANCH, AHMEDABAD);
				
				if(Validator.isNotNull(employeeDetails.getBankAccountId()) && employeeDetails.getBankAccountId()>0) {
					try {
						EmployeeBankAccount employeeBankAccount = employeeBankAccountLocalService.getEmployeeBankAccount(employeeDetails.getBankAccountId());
						employeeDetailsJson.put(BANK_NAME, !employeeBankAccount.getBankName().isBlank()?employeeBankAccount.getBankName():StringPool.DASH);
						employeeDetailsJson.put(IFSC, !employeeBankAccount.getIfscCode().isBlank()?employeeBankAccount.getIfscCode():StringPool.DASH);
						employeeDetailsJson.put(SAVING_BANK_ACCOUNT, !employeeBankAccount.getAccountNumber().isBlank()?employeeBankAccount.getAccountNumber():StringPool.DASH);
						employeeDetailsJson.put(PAN_NAME, !employeeBankAccount.getNameAsPerPanCard().isBlank()?employeeBankAccount.getNameAsPerPanCard():StringPool.DASH);
					} catch(Exception e) {
						log.error("Error while fetching employee bank account -- " + e.getMessage());
						employeeDetailsJson.put(BANK_NAME, StringPool.DASH);
						employeeDetailsJson.put(IFSC, StringPool.DASH);
						employeeDetailsJson.put(SAVING_BANK_ACCOUNT, StringPool.DASH);
						employeeDetailsJson.put(PAN_NAME, StringPool.DASH);
					}
				} else {
					employeeDetailsJson.put(BANK_NAME, StringPool.DASH);
					employeeDetailsJson.put(IFSC, StringPool.DASH);
					employeeDetailsJson.put(SAVING_BANK_ACCOUNT, StringPool.DASH);
					employeeDetailsJson.put(PAN_NAME, StringPool.DASH);
				}
				employeeDetailsJson.put(PAN, !employeeDetails.getPanCardNumber().isBlank()?employeeDetails.getPanCardNumber():StringPool.DASH);
				employeeDetailsJson.put(PERSONAL_EMAIL, !employeeDetails.getPersonalEmail().isBlank()?employeeDetails.getPersonalEmail():StringPool.DASH);
				log.info("mobile No -- " + employeeDetails.getMobileNo());
				employeeDetailsJson.put(MOBILE_NO, !employeeDetails.getMobileNo().isBlank()?employeeDetails.getMobileNo():StringPool.DASH);
				employeeDetailsJson.put(GENDER, employeeDetails.getGender());
				employeeDetailsJson.put(FH_NAME, !employeeDetails.getFatherName().isBlank()?employeeDetails.getFatherName():StringPool.DASH);
				String employeeDobStr = Validator.isNotNull(employeeDetails.getDateOfBirth())?sdf.format(employeeDetails.getDateOfBirth()):StringPool.DASH;
				employeeDetailsJson.put(DATE_OF_BIRTH, employeeDobStr);
				employeeDetailsJson.put(MARITAL_STATUS, employeeDetails.isMaritalStatus()?MARRIED:SINGLE);
				employeeDetailsJson.put(NAME_AS_PER_AADHAR, !employeeDetails.getNameAsPerAadhaarCard().isBlank()?employeeDetails.getNameAsPerAadhaarCard():StringPool.DASH);
				try {
					DocumentTypeMaster documentTypeMaster = documentTypeLocalService.getDocumentTypeMaster(employeeDetails.getDocumentTypeMasterId());
					if(Validator.isNotNull(documentTypeMaster)) {
						employeeDetailsJson.put(KYC_DOC, documentTypeMaster.getDocumentTypeName());
					} else {
						employeeDetailsJson.put(KYC_DOC, AADHAR_CARD);
					}
				}catch(Exception e) {
					log.error("Error while fetching kyc document - " + e.getMessage());
					employeeDetailsJson.put(KYC_DOC, AADHAR_CARD);
				}
				
				try {
					long employeeAddressId = employeeDetails.getEmployeeAddressId();
		            EmployeeAddress employeeAddress = employeeAddressLocalService.getEmployeeAddress(employeeAddressId);
		            if (employeeAddress.getPresentPermanentSame()) {
		                Address presentaddress = addressLocalService.getAddress(employeeAddress.getPresentAddress());
		                String address = getAddressString(presentaddress);
		                employeeDetailsJson.put(PRESENT_ADDRESS, address);
		                employeeDetailsJson.put(PERMANENT_ADDRESS, address);
		            } else {
		                Address presentaddress = addressLocalService.getAddress(employeeAddress.getPresentAddress());
		                Address permanentaddress = addressLocalService.getAddress(employeeAddress.getPermanentAddress());
		                employeeDetailsJson.put(PRESENT_ADDRESS, getAddressString(presentaddress));
		                employeeDetailsJson.put(PERMANENT_ADDRESS, getAddressString(permanentaddress));
		            }
				} catch(Exception e) {
					log.error("Error while fetching employeeAddress - " + e.getMessage());
					employeeDetailsJson.put(PRESENT_ADDRESS, StringPool.DASH);
	                employeeDetailsJson.put(PERMANENT_ADDRESS, StringPool.DASH);
				}
				
				try {
					EmployeeUanEsic employeeUanEsic = employeeUanEsicLocalService.getEmployeeUanEsic(employeeDetails.getUanEsicId());
					employeeDetailsJson.put(UAN, !employeeUanEsic.getUan().isBlank()?employeeUanEsic.getUan():StringPool.DASH);
					employeeDetailsJson.put(ESIC, !employeeUanEsic.getEsicNo().isBlank()?employeeUanEsic.getEsicNo():StringPool.DASH);
				} catch(Exception e) {
					log.error("Error while fetching employee uan esic -- " + e.getMessage());
					employeeDetailsJson.put(UAN, StringPool.DASH);
					employeeDetailsJson.put(ESIC, StringPool.DASH);
				}
				
				try {
					Nominee nominee = nomineeLocalService.getNominee(employeeDetails.getNominneeId());
					employeeDetailsJson.put(NOMINEE_NAME, !nominee.getNomineeFirstName().isBlank()?nominee.getNomineeFirstName() + " " + nominee.getNomineeLastName():StringPool.DASH);
					employeeDetailsJson.put(RELATION, !nominee.getRelationshipWithNominee().isBlank()?nominee.getRelationshipWithNominee():StringPool.DASH);
					String nomineeDOBStr = Validator.isNotNull(nominee.getNomineeDob())?sdf.format(nominee.getNomineeDob()):"";
					employeeDetailsJson.put(NOMINEE_DOB, nomineeDOBStr);
				} catch(Exception e) {
					log.error("Error while fetching nominee -- " + e.getMessage());
					employeeDetailsJson.put(NOMINEE_NAME, StringPool.DASH);
					employeeDetailsJson.put(RELATION, StringPool.DASH);
					employeeDetailsJson.put(NOMINEE_DOB, StringPool.DASH);
				}
                employeeDetailsJson.put(CO_EMPLOYEE_CODE, StringPool.DASH);
                employeeDetailsJson.put(SPOUSE_NAME, !employeeDetails.getSpouseName().isBlank()?employeeDetails.getSpouseName():StringPool.DASH);
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
		String addressStr = StringPool.BLANK;
		if(Validator.isNotNull(address) && !address.getLine1().isBlank()) {
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
		} else {
			addressStr = StringPool.DASH;
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
	DocumentTypeMasterLocalService documentTypeLocalService;
    
    @Reference
    private EmployeeSalaryLocalService employeeSalaryLocalService;

    @Reference
    private EmployeeDetailsLocalService employeeDetailsLocalService;

    @Reference
    private LeaveRequestLocalService leaveRequestLocalService;

    @Reference
    private LeaveDayTypeLocalService leaveDayTypeLocalService;

}
