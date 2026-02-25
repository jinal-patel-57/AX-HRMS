package com.hrms.utility;

import com.ax.hrms.common.api.api.AxHrmsCommonApi;
import com.ax.hrms.link.config.configuration.LinksConfiguration;
import com.ax.hrms.mail.template.config.configuration.MailTemplateConfiguration;
import com.ax.hrms.master.exception.NoSuchLeaveTypeMasterException;
import com.ax.hrms.master.model.LeaveTypeMaster;
import com.ax.hrms.master.service.DepartmentMasterLocalService;
import com.ax.hrms.master.service.DesignationMasterLocalService;
import com.ax.hrms.master.service.LeavePolicyMasterLocalService;
import com.ax.hrms.master.service.LeaveTypeMasterLocalService;
import com.ax.hrms.master.service.ProbationStatusMasterLocalService;
import com.ax.hrms.model.Address;
import com.ax.hrms.model.EmployeeAddress;
import com.ax.hrms.model.EmployeeDepartment;
import com.ax.hrms.model.EmployeeDesignation;
import com.ax.hrms.model.EmployeeDetails;
import com.ax.hrms.model.EmployeeDetailsTable;
import com.ax.hrms.model.EmployeeSalary;
import com.ax.hrms.model.LeaveBalance;
import com.ax.hrms.service.AddressLocalService;
import com.ax.hrms.service.EmployeeAddressLocalService;
import com.ax.hrms.service.EmployeeDepartmentLocalService;
import com.ax.hrms.service.EmployeeDesignationLocalService;
import com.ax.hrms.service.EmployeeDetailsLocalService;
import com.ax.hrms.service.EmployeeProbationDetailsLocalService;
import com.ax.hrms.service.EmployeeSalaryLocalService;
import com.ax.hrms.service.LeaveBalanceLocalService;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.petra.sql.dsl.DSLQueryFactoryUtil;
import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.RoleLocalService;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.service.RoleService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.Localization;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.PrefsPropsUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.roles.admin.role.type.contributor.provider.RoleTypeContributorProvider;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.apache.poi.ss.usermodel.Workbook;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
	immediate = true,
	property = {
			"com.liferay.portlet.display-category=category.hidden",
			"com.liferay.portlet.header-portlet-css=/css/main.css", 
			"com.liferay.portlet.instanceable=false",
			"javax.portlet.display-name=Import Employee Leaves Utility", 
			"javax.portlet.init-param.template-path=/",
			"javax.portlet.init-param.view-template=/jsp/importemployeeleaves/view.jsp",
			"javax.portlet.name=ImportEmployeeLeaves", 
			"javax.portlet.resource-bundle=content.Language",
			"javax.portlet.security-role-ref=administrator,power-user,user"
	},
	service = Portlet.class
)
public class ImportEmployeesLeavesUtility extends MVCPortlet {

	private Log log = LogFactoryUtil.getLog(ImportEmployeesLeavesUtility.class);
	private final Random random = new Random();
	@Reference
	AxHrmsCommonApi axHrmsCommonApi;
	
	@Reference
    MailTemplateConfiguration mailTemplateConfiguration;

    @Reference
    LinksConfiguration linksConfiguration;

    @Reference
    UserLocalService userLocalService;

    @Reference
    RoleLocalService roleLocalService;

    @Reference
    EmployeeDetailsLocalService employeeDetailsLocalService;

    @Reference
    EmployeeSalaryLocalService employeeSalaryLocalService;

    @Reference
    LeaveTypeMasterLocalService leaveTypeMasterLocalService;

    @Reference
    LeavePolicyMasterLocalService leavePolicyMasterLocalService;

    @Reference
    LeaveBalanceLocalService leaveBalanceLocalService;

    @Reference
    EmployeeProbationDetailsLocalService employeeProbationDetailsLocalService;

    @Reference
    ProbationStatusMasterLocalService probationStatusMasterLocalService;

    @Reference
    DepartmentMasterLocalService departmentMasterLocalService;
    
    @Reference
	EmployeeAddressLocalService employeeAddressLocalService;

	@Reference
	AddressLocalService addressLocalService;

    @Reference
    DesignationMasterLocalService designationMasterLocalService;

    @Reference
    EmployeeDepartmentLocalService employeeDepartmentLocalService;

    @Reference
    EmployeeDesignationLocalService employeeDesignationLocalService;

    @Reference
    private Localization localization;


    @Reference
    private RoleService roleService;

    @Reference
    private RoleTypeContributorProvider roleTypeContributorProvider;
	
	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
		throws IOException, PortletException {
		log.info("inside render");
		
		super.render(renderRequest, renderResponse);
	}
	
	@Override
	public void processAction(ActionRequest actionRequest, ActionResponse actionResponse) throws IOException, PortletException {
		
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
		UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(actionRequest);
		File zohoEmployeesFile = uploadRequest.getFile("zohoEmployeeLeavesFile");
		String fileName = uploadRequest.getFileName("zohoEmployeeLeavesFile");
		Workbook workbook = axHrmsCommonApi.getWorkbook(fileName, zohoEmployeesFile);
		
		Map<String, Map<String, Object>> zohoEmployeeMap = axHrmsCommonApi.readExcelSheetForImportEmployee(workbook.getSheetAt(0));
		log.info("after read -- " + zohoEmployeeMap);
		zohoEmployeeMap.forEach((outerKey, innerMap) -> {
			try {
				log.info("Outer: " + outerKey);
			    if(!"0".equalsIgnoreCase(outerKey) && Validator.isNotNull(innerMap) && Validator.isNotNull(innerMap.get("2")) && Validator.isNotNull(innerMap.get("2").toString())) {
			    	log.info("innerMap -- " + innerMap);
			    	
			    	EmployeeDetailsTable employeeDetailsTable = EmployeeDetailsTable.INSTANCE;
			    	String officialEmail = innerMap.get("2").toString().trim();
			    	DSLQuery dslQuery = DSLQueryFactoryUtil.select(employeeDetailsTable).from(employeeDetailsTable).where(employeeDetailsTable.officialEmail.eq(officialEmail));
			    	
			    	List<EmployeeDetails> employeeList = employeeDetailsLocalService.dslQuery(dslQuery);
			    	if(Validator.isNotNull(employeeList) && employeeList.size()>0) {
			    		EmployeeDetails employeeDetails = employeeList.get(0); 
			    		log.info("employee details - " + employeeDetails);
			    		addLeaveBalanceForNewEmployee(employeeDetails, themeDisplay, innerMap.get("4").toString().trim(), "Earned Leave");
			    		addLeaveBalanceForNewEmployee(employeeDetails, themeDisplay, innerMap.get("5").toString().trim(), "Loyalty Leave");
			    		addLeaveBalanceForNewEmployee(employeeDetails, themeDisplay, innerMap.get("6").toString().trim(), "Paternity Leave");
			    		addLeaveBalanceForNewEmployee(employeeDetails, themeDisplay, innerMap.get("7").toString().trim(), "Personal Floater");
			    		addLeaveBalanceForNewEmployee(employeeDetails, themeDisplay, innerMap.get("10").toString().trim(), "Unpaid Leave");
			    		addLeaveBalanceForNewEmployee(employeeDetails, themeDisplay, innerMap.get("12").toString().trim(), "Compensatory Off");
			    		addLeaveBalanceForNewEmployee(employeeDetails, themeDisplay, innerMap.get("13").toString().trim(), "Festival Floater");
			    	}
			    }
			} catch (Exception e) {
				e.printStackTrace();
			}
		}); 
		
		String redirect = ParamUtil.getString(actionRequest, "redirect");
		if (Validator.isNotNull(redirect)) {
			String url = themeDisplay.getURLHome();
			log.info("url -- " + url);
			String baseUrl = url.substring(0, url.lastIndexOf("/"));
			log.info("baseUrl -- " + baseUrl);
			String newUrl = baseUrl + "/employee-onboarding-hr";
			log.info("newUrl -- " + newUrl);
			actionResponse.sendRedirect(newUrl);  
		}
		actionResponse.sendRedirect(redirect);
	}

	private void addLeaveBalanceForNewEmployee(EmployeeDetails employeeDetails, ThemeDisplay themeDisplay, String leaveCount, String typeOfLeave) {
		
		Calendar todayCal = Calendar.getInstance();
	    int currentYear = todayCal.get(Calendar.YEAR);
		
	    if(Validator.isNotNull(leaveCount) && !leaveCount.isBlank()) {
	    	LeaveTypeMaster leaveTypeMaster;
			try {
				log.info("type of leave -- " + typeOfLeave);
				log.info("leave count -- " + leaveCount);
				leaveTypeMaster = leaveTypeMasterLocalService.findByLeaveTypeName(typeOfLeave);
				log.info("Leave type master :- " + leaveTypeMaster);
				LeaveBalance lb = leaveBalanceLocalService.createLeaveBalance(CounterLocalServiceUtil.increment(LeaveBalance.class.getName()));
				lb.setCompanyId(themeDisplay.getCompanyId());
				lb.setCreatedBy(themeDisplay.getUserId());
				lb.setGroupId(themeDisplay.getCompanyGroupId());
				lb.setCreateDate(new Date());
				lb.setModifiedDate(new Date());
				lb.setEmployeeId(employeeDetails.getEmployeeId());
				lb.setLeaveTypeMasterId(leaveTypeMaster.getLeaveTypeMasterId());
				lb.setYear(currentYear);
				lb.setNoOfUsedLeaves(0);
				
				String leaveValue = Validator.isNull(leaveCount) ? "" : leaveCount.trim();

				double remainingLeaves = 0.0;

				log.info("leaveValue -- " + leaveValue);
				if (!leaveValue.isEmpty() && !"-".equals(leaveValue)) {
				    try {
				        double count = Double.parseDouble(leaveValue);
				        if (count > 0) {
				            remainingLeaves = count;
				        }
				    } catch (NumberFormatException e) {
				        log.error("NumberFormatException -- " + e.getMessage());
				    }
				}
				log.info("remainingLeaves -- " + remainingLeaves);

				lb.setNoOfRemainingLeaves(remainingLeaves);
				
				leaveBalanceLocalService.addLeaveBalance(lb);
			} catch (NoSuchLeaveTypeMasterException e) {
				log.error("NoSuchLeaveTypeMasterException -- " + e.getMessage());
			}
	    } else {
	    	log.info("Blank leave -- " + leaveCount);
	    }
	}
	
	public Map<User, String> createNewEmployeeUser(String firstName, String middleName, String lastName, String email, ThemeDisplay themeDisplay, long[] roles, String employeeCode) {
        String password = generatePassword(8);
        User user = null;
        Map<User, String> retMp = new HashMap<>();
        try {
            user = userLocalService.addUser(themeDisplay.getUserId(), themeDisplay.getCompanyId(), false, password, password, false,
            		employeeCode, email, themeDisplay.getLocale(), firstName, middleName, lastName, 0L, 0L,
                    false, 1, 1, 2000, "jobTitle", 1, new long[]{themeDisplay.getScopeGroupId()}, null, roles, null, false, new ServiceContext());
            user.setStatus(WorkflowConstants.STATUS_APPROVED);
            user.setPasswordReset(true);
            user.setEmailAddressVerified(true);
            userLocalService.updateUser(user);
            //sending mail for new user on-boarding
            retMp.put(user, password);
            return retMp;
        } catch (Exception e) {
        	log.error("ERROR CREATING THE NEW EMPLOYEE USER -- " + e.getMessage());
        	e.printStackTrace();
        }
        retMp.put(user, password);
        return retMp;
    }
	
	public String generatePassword(int length) {
        StringBuilder password = new StringBuilder();
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789@#$";

        for (int i = 0; i < length; i++) {
            password.append(chars.charAt(random.nextInt(chars.length())));
        }

        return password.toString();
    }

    public String generateUserName(String firstName, String middleName, String lastName, ThemeDisplay themeDisplay) {
        String username = "";
        username = firstName + "." + lastName;
        try {
            userLocalService.getUserByScreenName(themeDisplay.getCompanyId(), username);
            username = firstName + "." + middleName + "." + lastName;
            return username;
        } catch (PortalException e) {
            return username;
        }

    }
	
	private void sendCredentialMailToEmployee(EmployeeDetails employeeDetails, String password, ThemeDisplay themeDisplay) {
        String subject = mailTemplateConfiguration.mailOnBoardingPermanentAndTemporaryEmployeesSubject();
        String body = mailTemplateConfiguration.mailOnBoardingPermanentAndTemporaryEmployeesBody();

        body = body.replace("${EMPLOYEE_MAIL}", employeeDetails.getOfficialEmail());
        body = body.replace("${EMPLOYEE_NAME}", employeeDetails.getFirstName() + " " + employeeDetails.getLastName());
        body = body.replace("${EMPLOYEE_PASSWORD}", password);
        body = body.replace("${LOGIN_LINK}", themeDisplay.getURLPortal() + linksConfiguration.loginLink());
        body = body.replace("${ONBOARDING_LINK}", themeDisplay.getURLPortal() + linksConfiguration.employeeOnBoardingLink());
        body = body.replace("${INSURANCE_LINK}", "#");

        axHrmsCommonApi.sendMail(employeeDetails.getOfficialEmail(), PrefsPropsUtil.getString(themeDisplay.getCompanyId(), "admin.email.from.address"), PrefsPropsUtil.getString(themeDisplay.getCompanyId(), "admin.email.from.name"), subject, body);

    }
	
}