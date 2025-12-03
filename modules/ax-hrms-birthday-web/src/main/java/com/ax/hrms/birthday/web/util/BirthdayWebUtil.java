package com.ax.hrms.birthday.web.util;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.osgi.service.component.annotations.Reference;

import com.ax.hrms.birthday.web.dto.BirthdayEmployeeDto;
import com.ax.hrms.birthday.web.notification.SendNotificationToUserHandler;
import com.ax.hrms.common.api.api.AxHrmsCommonApi;
import com.ax.hrms.constants.AxHrmsBirthdayWebPortletConstants;
import com.ax.hrms.constants.AxHrmsBirthdayWebPortletKeys;
import com.ax.hrms.mail.template.config.configuration.MailTemplateConfiguration;
import com.ax.hrms.master.model.DepartmentMaster;
import com.ax.hrms.master.model.DesignationMaster;
import com.ax.hrms.master.model.WishTypeMaster;
import com.ax.hrms.master.service.DepartmentMasterLocalService;
import com.ax.hrms.master.service.DesignationMasterLocalService;
import com.ax.hrms.master.service.WishTypeMasterLocalService;
import com.ax.hrms.model.EmployeeDepartment;
import com.ax.hrms.model.EmployeeDesignation;
import com.ax.hrms.model.EmployeeDetails;
import com.ax.hrms.model.EmployeeWish;
import com.ax.hrms.notification.template.config.configuration.NotificationTemplateConfiguration;
import com.ax.hrms.service.EmployeeDepartmentLocalService;
import com.ax.hrms.service.EmployeeDesignationLocalService;
import com.ax.hrms.service.EmployeeDetailsLocalService;
import com.ax.hrms.service.EmployeeWishLocalService;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.UserNotificationDeliveryConstants;
import com.liferay.portal.kernel.model.UserNotificationEvent;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserNotificationEventLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.Validator;


public class BirthdayWebUtil {
	
	private static final Log log = LogFactoryUtil.getLog(BirthdayWebUtil.class);

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

	
	@Reference
	private EmployeeWishLocalService employeeWishLocalService;

	

	
	public BirthdayWebUtil(EmployeeDetailsLocalService employeeDetailsLocalService,
			EmployeeDepartmentLocalService employeeDepartmentLocalService,
			EmployeeDesignationLocalService employeeDesignationLocalService,
			DepartmentMasterLocalService departmentMasterLocalService,
			DesignationMasterLocalService designationMasterLocalService,
			WishTypeMasterLocalService wishTypeMasterLocalService) {
		super();
		this.employeeDetailsLocalService = employeeDetailsLocalService;
		this.employeeDepartmentLocalService = employeeDepartmentLocalService;
		this.employeeDesignationLocalService = employeeDesignationLocalService;
		this.departmentMasterLocalService = departmentMasterLocalService;
		this.designationMasterLocalService = designationMasterLocalService;
		this.wishTypeMasterLocalService = wishTypeMasterLocalService;
	}

	public BirthdayWebUtil(EmployeeDetailsLocalService employeeDetailsLocalService,
			WishTypeMasterLocalService wishTypeMasterLocalService, EmployeeWishLocalService employeeWishLocalService) {
		super();
		this.employeeDetailsLocalService = employeeDetailsLocalService;
		this.wishTypeMasterLocalService = wishTypeMasterLocalService;
		this.employeeWishLocalService = employeeWishLocalService;
	}

	public List<BirthdayEmployeeDto> convertIntoBirthdayEmployeeDto(List<EmployeeDetails> birthdayEmployeeList)
			throws PortalException {

		List<BirthdayEmployeeDto> birthdayEmployeeDtoList = new ArrayList<>();

		for (EmployeeDetails employee : birthdayEmployeeList) {
			BirthdayEmployeeDto birthdayEmployeeDto = new BirthdayEmployeeDto();

			birthdayEmployeeDto.setEmployeeId(employee.getEmployeeId());
			birthdayEmployeeDto.setEmployeeName(employee.getFirstName() + " " + employee.getLastName());
			birthdayEmployeeDto.setWishtypeName(AxHrmsBirthdayWebPortletConstants.BIRTHDAY);
			EmployeeDepartment employeeDepartment = employeeDepartmentLocalService
					.findByEmployeeId(employee.getEmployeeId());
			DepartmentMaster departmentMaster = departmentMasterLocalService
					.getDepartmentMaster(employeeDepartment.getDepartmentMasterId());
			birthdayEmployeeDto.setDepartmentName(departmentMaster.getDepartmentName());

			EmployeeDesignation employeeDesignation = employeeDesignationLocalService
					.findByEmployeeId(employee.getEmployeeId());
			DesignationMaster designationMaster = designationMasterLocalService
					.getDesignationMaster(employeeDesignation.getDesignationMasterId());
			birthdayEmployeeDto.setDesignationName(designationMaster.getDesignationName());

			birthdayEmployeeDtoList.add(birthdayEmployeeDto);

		}

		return birthdayEmployeeDtoList;

	}
	
	public List<EmployeeDetails> getBirthdayEmployee() {

		List<EmployeeDetails> employeeDetailsList = employeeDetailsLocalService.findByIsTerminated(false);
		List<EmployeeDetails> birthdayListOfEmployee = new ArrayList<>();

		for(EmployeeDetails employee:employeeDetailsList) {
		
				if(Validator.isNotNull(employee.getDateOfBirth())) {
				Calendar currentDate = Calendar.getInstance();
				Calendar dob = Calendar.getInstance();
				dob.setTime(employee.getDateOfBirth());

				if(currentDate.get(Calendar.DATE)==dob.get(Calendar.DATE)&&(currentDate.get(Calendar.MONTH)+1)==(dob.get(Calendar.MONTH)+1)) {
					birthdayListOfEmployee.add(employee);
				}
				}
		}

		return birthdayListOfEmployee;

	}
	
	public void setDataWish(String wishes, Long employeeId, ThemeDisplay themeDisplay) throws PortalException {
		EmployeeWish employeeWish = employeeWishLocalService
				.createEmployeeWish(CounterLocalServiceUtil.increment(EmployeeWish.class.getName()));

		EmployeeDetails senderEmployee = employeeDetailsLocalService.findByLrUserId(themeDisplay.getUserId());

		WishTypeMaster wishTypeMaster = wishTypeMasterLocalService
				.findByWishType(AxHrmsBirthdayWebPortletConstants.BIRTHDAY);

		// set audit field
		employeeWish.setCompanyId(themeDisplay.getCompanyId());
		employeeWish.setCreatedBy(themeDisplay.getUserId());
		employeeWish.setCreateDate(new Date());
		employeeWish.setGroupId(themeDisplay.getScopeGroupId());
		employeeWish.setModifiedBy(themeDisplay.getUserId());
		employeeWish.setModifiedDate(new Date());

		// set wish field
		employeeWish.setSenderId(senderEmployee.getEmployeeId());
		employeeWish.setReceiverId(employeeId);
		employeeWish.setContent(wishes);
		employeeWish.setTimeStamp(new Date());
		employeeWish.setWishTypeMasterId(wishTypeMaster.getWishTypeMasterId());
		employeeWishLocalService.addEmployeeWish(employeeWish);
	}

	
	public void sendMailAndNotificationToHr(String fromName, String fromEmailAddress,StringBuilder body,AxHrmsCommonApi axHrmsCommonApi,long companyId,MailTemplateConfiguration mailTemplateConfiguration,NotificationTemplateConfiguration notitifcationTemplateConfiguration)
			throws Exception {
		List<EmployeeDetails> birthdayListOfEmployee = getBirthdayEmployee();
		if(Validator.isNotNull(birthdayListOfEmployee) && birthdayListOfEmployee.size()!=0) {

		List<User> hrUserList = axHrmsCommonApi.fetchRolePersonList(companyId, "HR Admin", -1, -1);

		for (EmployeeDetails employee : birthdayListOfEmployee) {
			List<DepartmentMaster> departmentMasterList = 	axHrmsCommonApi.getDepartmentMastersFromEmployeeId(employee.getEmployeeId());
			StringBuilder departmentName = new StringBuilder();
			for(DepartmentMaster department:departmentMasterList) {
				departmentName.append(department.getDepartmentName());
				departmentName.append(",");
			}
			String department = departmentName.toString();
			department = department.substring(0,department.length()-1);
			
			EmployeeDesignation employeeDesignation = employeeDesignationLocalService
					.findByEmployeeId(employee.getEmployeeId());
			DesignationMaster designationMaster = designationMasterLocalService
					.findByDesignationNameById(employeeDesignation.getDesignationMasterId());
			

			body.append(AxHrmsBirthdayWebPortletConstants.BODY_PART_1).append(AxHrmsBirthdayWebPortletConstants.BODY_PART_2)
					.append(employee.getEmployeeCode())
					.append(AxHrmsBirthdayWebPortletConstants.BODY_PART_2)
					.append(employee.getFirstName()).append(" ").append(employee.getLastName())
					.append(AxHrmsBirthdayWebPortletConstants.BODY_PART_2)
					.append(department)
					.append(AxHrmsBirthdayWebPortletConstants.BODY_PART_2)
					.append(designationMaster.getDesignationName()).append(AxHrmsBirthdayWebPortletConstants.BODY_LAST_PART);
			
			//SEND NOTIFICATION TO HR
			sendNotificationToHr(hrUserList, employee, department, designationMaster,notitifcationTemplateConfiguration);



		}
		body.append(AxHrmsBirthdayWebPortletConstants.HR_BIRTHDAY_REMMINDER_MAIL_FOOTER);



		//SEND MAIL TO HR
		for (User hrUser : hrUserList) {
			EmployeeDetails hrPerson = employeeDetailsLocalService.findByLrUserId(hrUser.getUserId());
			 String mailContent =  mailTemplateConfiguration.mailDailySchedulerBirthdayBody();
             mailContent =  mailContent.replace("${TABLE}", body);
              
              String subject = mailTemplateConfiguration.mailDailySchedulerBirthdaySubject();
               
			axHrmsCommonApi.sendMail(hrPerson.getOfficialEmail(), fromEmailAddress, fromName,
					subject, mailContent);

		}
		}

	}
	
	public void sendNotificationToHr(List<User> hrUserList,EmployeeDetails employee,String departmentMaster,DesignationMaster designationMaster,NotificationTemplateConfiguration notificationTemplateConfiguration) throws Exception {

		JSONObject notificationJSON = JSONFactoryUtil.createJSONObject();
		Calendar cal = Calendar.getInstance();
		int month = cal.get(Calendar.MONTH) + 1;
		for (User hrUser : hrUserList) {
			
			String notificationContent =  notificationTemplateConfiguration.notificationBirthday();
			notificationContent = notificationContent.replace("${EMPLOYEE_CODE}", employee.getEmployeeCode());
			notificationContent = notificationContent.replace("${EMPLOYEE_NAME}",  employee.getFirstName()+StringPool.SPACE+employee.getLastName());
			notificationContent = notificationContent.replace("${DEPARTMENT_NAME}", departmentMaster);
			notificationContent = notificationContent.replace("${DESIGNATION_NAME}",designationMaster.getDesignationName() );
			notificationContent = notificationContent.replace("${DATE}", String.valueOf(cal.get(Calendar.DATE)));
			notificationContent = notificationContent.replace("${MONTH}",String.valueOf( month));
			notificationContent = notificationContent.replace("${YEAR}", String.valueOf(cal.get(Calendar.YEAR)));

		
			notificationJSON.put(AxHrmsBirthdayWebPortletConstants.BODY, notificationContent);

			// Notification........
			UserNotificationEvent userNotificationEvent = UserNotificationEventLocalServiceUtil.sendUserNotificationEvents(
					hrUser.getUserId(), AxHrmsBirthdayWebPortletKeys.AXHRMSEMPLOYEEBIRTHDAYWEB,
					UserNotificationDeliveryConstants.TYPE_WEBSITE, notificationJSON);

			ServiceContext serviceContext = new ServiceContext();
			SendNotificationToUserHandler sendNotificationToUserHandler = new SendNotificationToUserHandler();
			sendNotificationToUserHandler.callGetBody(userNotificationEvent, serviceContext);
		}
	}
	
}
