package com.ax.hrms.employee.onboarding.web.constants;

public class AxHrmsEmployeeOnBoardingEmployeeConstants {

	//FetchEmployeeOnboardingMVCRenderCommand
	public static final String ADD_EMPLOYEE_ONBOARDING_JSP="/jsp/ax-hrms-employee-onboarding-employee/addEditEmployeeOnBoarding.jsp";
	public static final String VIEW_EMPLOYEE_ONBOARDING_JSP="/jsp/ax-hrms-employee-onboarding-employee/viewEmployeeOnBoarding.jsp";
	public static final String COUNTRY_LIST="countryList";
	public static final String EDUCATION_LEVEL_MASTERS_LIST="educationLevelMastersList";
	
	//COMMON USED
	public static final String DATE_FORMAT ="yyyy-MM-dd";
	public static final String FALSE ="false";
	
	//AddEditEmployeeAddressMVCActionCommand
	public static final String SAME_AS_PERMANENT="sameAsPermanent";
	public static final String ON="on";
	public static final String UPDATE_FLAG_ADDRESS="updateFlagAddress";
	public static final String TRUE="true";
	public static final String ADDRESS_SUCCESS="Address Insert And Update Complete Successfully.";
	public static final String ADDRESS_FAILED="Address Insert And Update failed.";
	
	//1)PERMANENTADDRESS
	public static final String PERMANENT_ADDRESS_LINE1="permanentAddressLine1";
	public static final String PERMANENT_ADDRESS_LINE2="permanentAddressLine2";
	public static final String PERMANENT_ADDRESS_LINE3="permanentAddressLine3";
	public static final String PERMANENT_STATE="permanentState";
	public static final String PERMANENT_COUNTRY="permanentCountry";
	public static final String PERMANENT_PINCODE="permanentPincode";
	
	//2)PRESENTADDRESS
	public static final String PRESENT_ADDRESS_LINE1="presentaddressLine1";
	public static final String PRESENT_ADDRESS_LINE2="presentaddressLine2";
	public static final String PRESENT_ADDRESS_LINE3="presentaddressLine3";
	public static final String PRESENT_STATE="presentstate";
	public static final String PRESENT_COUNTRY="presentCountry";
	public static final String PRESENT_PINCODE="presentpinCode";
	
	//id
	public static final String PERMANENT_ADDRESS_ID="permanentAddressId";
	public static final String PRESENT_ADDRESS_ID="presentAddressId";
	public static final String EMPLOYEE_ADDRESS_ID="employeeAddressId";
	
	//AddEditEmployeeOnBoardingMVCActionCommmand
	
	public static final String PERSONAL_EMAIL ="personalEmail";
	public static final String DATE_OF_BIRTH ="dateOfBirth";
	public static final String MOBILE_NUMBER ="mobileNo";
	public static final String SKYPE_ID ="skypeId";
	public static final String FATHER_NAME ="fatherName";
	public static final String MARTIAL_STATUS ="maritalStatus";
	public static final String MARRIAGE_DATE ="marriageDate";
	public static final String SPOUSE_NAME ="spouseName";
	
	
	public static final String HRMS_DOCUMENT="HRMS Document";
	public static final String PROFILE_PICTURE="Profile Picture";
	public static final String EMPLOYEE_PROFILE_PICTURE="employeeProfilePicture";
	
	//AddEmployeeBankAccountMVCActionCommand
	public static final String ACCOUNT_NUMBER ="accountNumber";
	public static final String ACCOUNT_TYPE ="accountType";
	public static final String BENEFICIARY_NAME ="beneficiaryName";
	public static final String BANK_NAME ="bankName";
	public static final String IFSC_CODE ="ifscCode";
	public static final String BANK_BRANCH ="bankBranch";
	public static final String BANK_ACCOUNT_ID ="bankAccountId";
	public static final String UPDATE_FLAG_BANK ="updateFlagBank";
	
	
	//AddEmployeeEducationMVCActionCommand
	public static final String EDUCATION_CURRENT_INDEX="educationCurrentIndex";
	public static final String FIRST_VISIT_EDUCATION ="firstVisitEducation";
	public static final String LEVEL_NAME="levelName";
	public static final String INSTITUTION="institution";
	
	public static final String DEGREE="degree";
	public static final String START_DATE="startDate";
	public static final String END_DATE="endDate";
	public static final String PASSING_YEAR="passingYear";
	
	//AddEmployeeExperienceMVCActionCommand
	public static final String FIRST_VISIT="firstVisit";
	public static final String CURRENT_INDEX ="currentIndex";
	public static final String COMPANY_NAME="companyName";
	public static final String JOINING_DATE="joiningDate";
	
	public static final String RELIEVING_DATE="relievingDate";
	public static final String EXPERIENCE_CERTIFICATE_ATTACHEMENT="experienceCertificateAttachment";
	public static final String EXPERIENCE_CERTIFICATE="Experince Certificate";
	
	
	//AddEmployeeNomineeMVCActionCommand
	public static final String UPDATE_FLAG_NOMINEE ="updateFlagNominee";
	public static final String NOMINEE_FIRST_NAME="nomineeFirstName";
	public static final String NOMINEE_LAST_NAME="nomineeLastName";
	
	public static final String NOMINEE_CONTACT="nomineeContact";
	public static final String NOMINEE_ADDRESS="nomineeAddress";
	public static final String RELATIONSHIP_WITH_NOMINEE="relationshipWithNominee";
	public static final String NOMINEE_JOB="nomineeDob";
	public static final String EMPLOYEE_ONBOARDING_VERIFICATION="Employee On-Boarding Details Verification";
	public static final String VERIFY_DOCUMENTS="Verify Details and Document of this Employee";
	
	//AddEmployeeUanEsicMVCActionCommand
	public static final String UAN="uan";
	public static final String UAN_ESIC_ID="uanEsicId";
	public static final String ESIC_NUMBER="esicNo";
	public static final String UPDATE_FLAG_UAN_ESIC="updateFlagUanEsic";
	
	
	public static final String MAIL_HEAD = "</div>\n <div style=\"padding: 20px;\">\n <p>Dear HR team,</p>\n ";
	
	public static final String MAIL_CONTENTLINE = "<p>Check the Employee on-Boarding Details of : </p>\n";

	public static final String MAIL_FOOTER = "<p>This mail is sent automatically via AX_HRMS Systems, Please contact Admin if any information is found suspectful.</p>\n </div>\n ";
	public static final String NORMAL = "normal";
	public static final String P_P_STATE = "p_p_state";
	public static final String P_P_MODE = "p_p_mode";
	public static final String VIEW = "view";
	public static final String MVC_RENDER_COMMAND_NAME = "mvcRenderCommandName";
	
	public static final String SHOW_EMPLOYEE_ONBOARDING_URL="/showEmployeeOnboardingURL";
	public static final String EMPLOYEE_ID = "employeeId";
	
	
	//for employee
	public static final String EMPLOYEE_MAIL_HEAD = "</div>\n <div style=\"padding: 20px;\">\n <p>Dear Employee,</p>\n ";
	
	public static final String EMPOLYEE_MAIL_CONTENTLINE = "<p>Re-Upload Your Documents :</p>\n";
	
	public static final String EMPOLYEE_ON_BOARDING_SUCCESS = "<p>Employee on Boarding Details completely successfully.. :</p>\n";
	
	//showEmployeeOnBoardingStatusMVCRenderCommand
	public static final String EMPLOYEE_DETAIL="employeeDetail";
	public static final String SHOW_EMPLOYEE_ONBOARDING_STATUS_PAGE="/jsp/ax-hrms-employee-onboarding-employee/showEmployeeOnBoardingStatus.jsp";
	
	//EmployeeRejectMVCActionCommand
	public static final String REVIEW="review";
	
	public static final String RE_UPLOAD_EMPLOYEE_ONBOARDING_DETAILS="Re-Upload EmpolyeeOnboarding Details";
	
	public static final String SPACE=" ";
	
	public static final String SLASH="/";
	
	public static final String RE_UPLOAD_DOCUMENTS="please re-upload this document and details ===> ";
	
	//EmployeeApprovalMVCActionCommand
	public static final String EMPLOYEE="employee";
	
	public static final String VERIFICATION_SUCCESSFULL="Your Verification Successfull From HR Side....";
	
	public static final String APPROVED_EMPLOYEE_DETAILS="Approved EmpolyeeOnboarding Details";
	
	//DeleteEmployeeExperienceMVCActionCommand
	public static final String EXPERIENCE_ID="experienceId";
	
	public static final String EXPERINCE_CURRENT_INDEX="ExperienceCurIndex";
	 
	public static final String FOUR="4";
	
	//DeleteEmployeeEducationMVCActionCommand
	
	public static final String EDUCATION_ID="educationId";
	
	public static final String EDU_CURRENT_INDEX="EdCurIndex";
	
	public static final String THREE="3";
	
	//viewEmployeeOnBoardingMVCRenderCommand
	public static final String PROFILE_PIC="profilePic";
	
	public static final String EDUCATION_LIST="educationList";
	
	public static final String EMPLOYEE_ADDRESS="employeeAddress";
	
	public static final String PRESENT_ADDRESS="presentaddresss";
	
	public static final String PERMANENT_ADDRESS="permanentaddresss";
	
	public static final String EXPERIENCE_LIST="experienceList";
	
	public static final String EMPLOYEE_BANK_ACCOUNT="employeeBankAccount";
	
	public static final String EMPLOYEE_UAN_ESIC="employeeUanEsic";
	
	public static final String NOMINEE="nominee";
	
	public static final String VIEW_EXPERIENCE_CERTIFICATE="experienceCertificate";
	
	//SendNotificationToUserHandler
	public static final String BODY="body";
	
	//EmployeeOnBoardingUtil >>> sendMail && sendMailToEmployee
	public static final String BR="<br/>";
	
	public static final String  CHECK_THE_DETAILS="Check the Details, ";
	
	public static final String  LINK_HREF="<br> LINK --<a href=\"";
	
	public static final String CLICK_HERE = "\">CLICK HERE</a>"; 
	
	//EmployeeOnBoardingUtil >>>setEmployeeDetails
	public static final String PROFILE_PIC_NAME="profilePicName";
	
	public static final String ADDRESS="address";
	
	public static final String EDUCATION_LIST_SIZE="educationListSize";
	
	public static final String EXPERIENCE_LIST_SIZE="experienceListSize";
	
	public static final String FLAG_STATUS="flagStatus";
	
	public static final String FLAG_STATUSS="flagStatuss";
	
	public static final String ADDRESS_FLAG_STATUS="addressFlagStatus";
}
