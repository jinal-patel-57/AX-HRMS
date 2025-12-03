package com.ax.hrms.anniversary.web.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.ax.hrms.anniversary.web.constants.AxHrmsAnniversaryWebPortletConstants;
import com.ax.hrms.anniversary.web.constants.AxHrmsAnniversaryWebPortletKeys;
import com.ax.hrms.anniversary.web.dto.EmployeeDetailsDto;
import com.ax.hrms.anniversary.web.notification.SendNotificationToUserHandler;
import com.ax.hrms.common.api.api.AxHrmsCommonApi;
import com.ax.hrms.mail.template.config.configuration.MailTemplateConfiguration;
import com.ax.hrms.master.model.DepartmentMaster;
import com.ax.hrms.master.model.DesignationMaster;
import com.ax.hrms.master.model.LeavePolicyMaster;
import com.ax.hrms.master.service.DepartmentMasterLocalService;
import com.ax.hrms.master.service.DesignationMasterLocalService;
import com.ax.hrms.master.service.LeavePolicyMasterLocalService;
import com.ax.hrms.master.service.LeaveTypeMasterLocalService;
import com.ax.hrms.model.EmployeeDesignation;
import com.ax.hrms.model.EmployeeDetails;
import com.ax.hrms.model.LeaveBalance;
import com.ax.hrms.notification.template.config.configuration.NotificationTemplateConfiguration;
import com.ax.hrms.service.EmployeeDepartmentLocalService;
import com.ax.hrms.service.EmployeeDesignationLocalService;
import com.ax.hrms.service.EmployeeDetailsLocalService;
import com.ax.hrms.service.LeaveBalanceLocalService;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.UserNotificationDeliveryConstants;
import com.liferay.portal.kernel.model.UserNotificationEvent;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserNotificationEventLocalServiceUtil;
import com.liferay.portal.kernel.util.PrefsPropsUtil;
import com.liferay.portal.kernel.util.PropsKeys;

/**
 * @author krish.moradiya
 * @implNote - this is Util class which have many method to filter employee whoose JoiningDate Match with current date/ whoose Anniversary today
 */
public class AnniversaryUtil {

	private EmployeeDetailsLocalService employeeDetailsLocalService;
	private AxHrmsCommonApi axHrmsCommonApi;
	private LeaveBalanceLocalService leaveBalanceLocalService;
	private LeavePolicyMasterLocalService leavePolicyMasterLocalService;
	private LeaveTypeMasterLocalService leaveTypeMasterLocalService;
	private DepartmentMasterLocalService departmentMasterLocalService;
	private DesignationMasterLocalService designationMasterLocalService;

	private final Log log = LogFactoryUtil.getLog(AnniversaryUtil.class);
	
	private int currentMonth = Calendar.getInstance().get(Calendar.MONTH);
	private int currentDate = Calendar.getInstance().get(Calendar.DATE);
	private int currentYear = Calendar.getInstance().get(Calendar.YEAR);

	List<Integer> monthNumbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

	public AnniversaryUtil(EmployeeDetailsLocalService employeeDetailsLocalService,AxHrmsCommonApi axHrmsCommonApi,LeaveBalanceLocalService leaveBalanceLocalService,LeavePolicyMasterLocalService leavePolicyMasterLocalService,LeaveTypeMasterLocalService leaveTypeMasterLocalService,DesignationMasterLocalService designationMasterLocalService,DepartmentMasterLocalService departmentMasterLocalService){
		this.employeeDetailsLocalService = employeeDetailsLocalService;
		this.axHrmsCommonApi = axHrmsCommonApi;
		this.leaveBalanceLocalService = leaveBalanceLocalService;
		this.leaveTypeMasterLocalService = leaveTypeMasterLocalService;
		this.leavePolicyMasterLocalService = leavePolicyMasterLocalService;
		this.designationMasterLocalService = designationMasterLocalService;
		this.departmentMasterLocalService = departmentMasterLocalService;
	}
	
	private static Calendar toCalendar(Date date){
		Calendar calendarDate = Calendar.getInstance();
		calendarDate.setTime(date);
		return calendarDate;
	}

	private int getCompletedMonthNumber(Calendar joiningDate){
		int joiningYear = joiningDate.get(Calendar.YEAR);
		
		return (currentYear-joiningYear)*12;
	}
	
	private boolean compareDateWithCurrentDateAndMonth(Date date) {
		if (date == null) {
			throw new IllegalArgumentException(AxHrmsAnniversaryWebPortletConstants.DATE_OBJECT_NULL_MESSAGE);
		}
		Calendar joiningDate = toCalendar(date);

		return (joiningDate.get(Calendar.MONTH) == currentMonth && joiningDate.get(Calendar.DATE) == currentDate && joiningDate.get(Calendar.YEAR) != currentYear);
	}
	
	public List<EmployeeDetails> getAnniversaryEmployee(List<EmployeeDetails> employeeDetails) {
		try {			
			List<EmployeeDetails> employeeDetailsList = employeeDetails.stream()
					.filter(employeeDetailsObj -> compareDateWithCurrentDateAndMonth(employeeDetailsObj.getJoiningDate()))
					.collect(Collectors.toList());
			
			if(!employeeDetailsList.isEmpty())
				return employeeDetailsList;
		}catch(Exception e) {
			log.error("AnniversaryEmployeeRetrieverUtil >>> getAnniversaryEm ::: "+e.getMessage());
		}
		return new ArrayList<>();
	}

	public List<EmployeeDetailsDto> getEmployeeDetailsDtoList(List<EmployeeDetails> employeeDetailsList,DepartmentMasterLocalService departmentMasterLocalService,DesignationMasterLocalService designationMasterLocalService,EmployeeDepartmentLocalService employeeDepartmentLocalService,EmployeeDesignationLocalService employeeDesignationLocalService){

		List<EmployeeDetailsDto> employeeDetailsDtoList = new ArrayList<>();
		try {
		if(!employeeDetailsList.isEmpty()){
			for(EmployeeDetails employeeDetails : employeeDetailsList){
				EmployeeDetailsDto employeeDetailsDto = new EmployeeDetailsDto();
				employeeDetailsDto.setEmployeeId(employeeDetails.getEmployeeId());
				employeeDetailsDto.setEmployeeName(employeeDetails.getFirstName()+AxHrmsAnniversaryWebPortletConstants.ONE_SPACE+employeeDetails.getLastName());
				try{
				
					
				List<DepartmentMaster> departmentMasterList = 	axHrmsCommonApi.getDepartmentMastersFromEmployeeId(employeeDetails.getEmployeeId());
				StringBuilder departmentName = new StringBuilder();
				for(DepartmentMaster department:departmentMasterList) {
					departmentName.append(department.getDepartmentName());
					departmentName.append(",");
				}
				String department = departmentName.toString();
				department = department.substring(0,department.length()-1);
				employeeDetailsDto.setDepartmentName(department);

				}catch (Exception e) {
					log.error("getEmployeeDto >>> "+ e.getMessage());
					e.printStackTrace();
				}
				try{
				
					EmployeeDesignation employeeDesignation = employeeDesignationLocalService
							.findByEmployeeId(employeeDetails.getEmployeeId());
					DesignationMaster designationMaster = designationMasterLocalService
							.getDesignationMaster(employeeDesignation.getDesignationMasterId());
					employeeDetailsDto.setDesignationName(designationMaster.getDesignationName());

				}catch (Exception e) {
					log.error("getEmployeeDto >>> "+ e.getMessage());
					e.printStackTrace();				}
				employeeDetailsDto.setEmployeeCode(employeeDetails.getEmployeeCode());
				employeeDetailsDtoList.add(employeeDetailsDto);
			}
		}
		}catch(Exception e) {
			log.error("Anniversary >>> getEmployeeDetailsDtoList >>>"+ e.getMessage());
		}

		return employeeDetailsDtoList;
	}

	public void sendMailAndNotificationToHr(Group group,StringBuilder body,EmployeeDepartmentLocalService employeeDepartmentLocalService,EmployeeDesignationLocalService employeeDesignationLocalService,MailTemplateConfiguration mailTemplateConfiguration,NotificationTemplateConfiguration notificationTemplateConfiguration) throws Exception {
		try{
			String fromName = PrefsPropsUtil.getString(group.getCompanyId(), PropsKeys.ADMIN_EMAIL_FROM_NAME);
			String fromEmailAddress = PrefsPropsUtil.getString(group.getCompanyId(), PropsKeys.ADMIN_EMAIL_FROM_ADDRESS);

			List<EmployeeDetails> anniversaryEmployeeDetails = getAnniversaryEmployee(employeeDetailsLocalService.getEmployeeDetailses(-1,-1));
			if(!anniversaryEmployeeDetails.isEmpty()){
				List<EmployeeDetailsDto> employeeDetailsDtoList = getEmployeeDetailsDtoList(anniversaryEmployeeDetails,departmentMasterLocalService,designationMasterLocalService,employeeDepartmentLocalService,employeeDesignationLocalService);

//				DepartmentMaster hrDepartmentMaster = departmentMasterLocalService.findByDepartmentName(AxHrmsAnniversaryWebPortletConstants.HR_ADMIN);
				List<User> hrUserList = axHrmsCommonApi.fetchRolePersonList(group.getCompanyId(), "HR Admin", -1, -1);

//				List<EmployeeDepartment> hrDepartmentList = employeeDepartmentLocalService.findBydepartmentMasterId(hrDepartmentMaster.getDepartmentMasterId());
				for(EmployeeDetailsDto employee: employeeDetailsDtoList){
					
					body.append(AxHrmsAnniversaryWebPortletConstants.BODY_TR_START)
							.append(employee.getEmployeeCode())
							.append(AxHrmsAnniversaryWebPortletConstants.BODY_TD_FIRST)
							.append(employee.getEmployeeName())
							.append(AxHrmsAnniversaryWebPortletConstants.BODY_TD_SECOND)
							.append(employee.getDepartmentName())
							.append(AxHrmsAnniversaryWebPortletConstants.BODY_TD_THIRD)
							.append(employee.getDesignationName()).append(AxHrmsAnniversaryWebPortletConstants.BODY_TR_END);

					sendNotificationToHr(hrUserList, employee, notificationTemplateConfiguration);
				}
				body.append(AxHrmsAnniversaryWebPortletConstants.ANNIVERSARY_REMMINDER_MAIL_FOOTER);
				//SEND MAIL TO HR
				for (User hrDepartment : hrUserList) {
					EmployeeDetails hrPerson = employeeDetailsLocalService.findByLrUserId(hrDepartment.getUserId());
					 String mailContent =  mailTemplateConfiguration.mailDailySchedulerAnniversaryBody();
		              mailContent =  mailContent.replace("${TABLE}", body);
		               
		               String subject = mailTemplateConfiguration.mailDailySchedulerAnniversarySubject();
		                
					axHrmsCommonApi.sendMail(hrPerson.getOfficialEmail(), fromEmailAddress, fromName,
							subject, mailContent);

				}
			}
		}catch(Exception e){
			log.error("AnniversaryEmployeeRetrieverUtil >>> sendMailAndNotificationToHr ::: NoSuchDepartmentMasterException");
		}




	}
	public void sendNotificationToHr(List<User> hrDepartmentList,EmployeeDetailsDto employee,NotificationTemplateConfiguration notificationTemplateConfiguration) throws Exception {

		JSONObject notificationJSON = JSONFactoryUtil.createJSONObject();
		Calendar cal = Calendar.getInstance();

		int month = cal.get(Calendar.MONTH) + 1;
		for (User hrDepartment : hrDepartmentList) {
			EmployeeDetails hrPerson = employeeDetailsLocalService.findByLrUserId(hrDepartment.getUserId());
			String notificationContent =  notificationTemplateConfiguration.notificationAnniversary();
			notificationContent = notificationContent.replace("${EMPLOYEE_CODE}", employee.getEmployeeCode());
			notificationContent = notificationContent.replace("${EMPLOYEE_NAME}",  employee.getEmployeeName());
			notificationContent = notificationContent.replace("${DEPARTMENT_NAME}", employee.getDepartmentName());
			notificationContent = notificationContent.replace("${DESIGNATION_NAME}",employee.getDesignationName() );
			notificationContent = notificationContent.replace("${DATE}", String.valueOf(cal.get(Calendar.DATE)));
			notificationContent = notificationContent.replace("${MONTH}",String.valueOf( month));
			notificationContent = notificationContent.replace("${YEAR}", String.valueOf(cal.get(Calendar.YEAR)));

			notificationJSON.put(AxHrmsAnniversaryWebPortletConstants.BODY, notificationContent);



			// Notification........
			UserNotificationEvent userNotificationEvent = UserNotificationEventLocalServiceUtil.sendUserNotificationEvents(
					hrPerson.getLrUserId(), AxHrmsAnniversaryWebPortletKeys.AXHRMSANNIVERSARYWEB,
					UserNotificationDeliveryConstants.TYPE_WEBSITE, notificationJSON);

			ServiceContext serviceContext = new ServiceContext();
			SendNotificationToUserHandler sendNotificationToUserHandler = new SendNotificationToUserHandler();
			sendNotificationToUserHandler.callGetBody(userNotificationEvent, serviceContext);

		}
	}

	private static boolean isAlreadyLeaveTypeInLeaveBalance(List<LeaveBalance> leaveBalanceList, long leaveTypeMasterId,long employeeId,int year){
		Optional<LeaveBalance> result = leaveBalanceList.stream()
				.filter(leaveBalance -> ((leaveBalance.getLeaveTypeMasterId() == leaveTypeMasterId) && (leaveBalance.getEmployeeId() == employeeId) && (leaveBalance.getYear() == year)))
				.findFirst();
		return result.isPresent();
	}

	public static double roundToNearestHalf(double num) {
		return Math.round(num * 2) / 2.0;
	}

	public void addLoyaltyLeave(List<EmployeeDetails> employeeDetailsList,long groupId,long userId,long companyId){
		try{
			List<LeavePolicyMaster> leavePolicyMasterList = leavePolicyMasterLocalService.getLeavePolicyMasters(-1,-1);
			List<LeaveBalance> leaveBalanceList = leaveBalanceLocalService.getLeaveBalances(-1,-1);
			for(EmployeeDetails employeeDetails: employeeDetailsList){
				for(LeavePolicyMaster leavePolicyMaster: leavePolicyMasterList){
					if(!isAlreadyLeaveTypeInLeaveBalance(leaveBalanceList,leavePolicyMaster.getLeaveTypeMasterId(),employeeDetails.getEmployeeId(),currentYear) && leaveTypeMasterLocalService.getLeaveTypeMaster(leavePolicyMaster.getLeaveTypeMasterId()).getIsAppearForAll() && leavePolicyMaster.getEligibleAfterMonths() <= getCompletedMonthNumber(toCalendar(employeeDetails.getJoiningDate()))){

						LeaveBalance lb = leaveBalanceLocalService.createLeaveBalance(CounterLocalServiceUtil.increment(LeaveBalance.class.getName()));

						lb.setCreatedBy(userId);
						lb.setGroupId(groupId);
						lb.setCompanyId(companyId);

						lb.setEmployeeId(employeeDetails.getEmployeeId());
						lb.setLeaveTypeMasterId(leavePolicyMaster.getLeaveTypeMasterId());
						lb.setYear(Calendar.getInstance().get(Calendar.YEAR));
						lb.setNoOfUsedLeaves(0);
						int joiningMonth = toCalendar(employeeDetails.getJoiningDate()).get(Calendar.MONTH)+1;
						lb.setNoOfRemainingLeaves(roundToNearestHalf(leavePolicyMaster.getAccrualRate() * (12-joiningMonth)));

						if(joiningMonth < 10 && joiningMonth >= 0)
							leaveBalanceLocalService.addLeaveBalance(lb);
					}
				}
			}
		}catch (Exception e){
			log.error("AnniversaryEmployeeRetrieverUtil >>> addLoyaltyLeave ::: Here error coming...");
		}


	}
}
