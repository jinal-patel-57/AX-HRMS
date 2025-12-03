package com.ax.hrms.leave.management.hr.web.util;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.ax.hrms.common.api.api.AxHrmsCommonApi;
import com.ax.hrms.exception.NoSuchLeaveBalanceException;
import com.ax.hrms.exception.NoSuchLeaveRequestException;
import com.ax.hrms.leave.management.web.constants.AxHrmsHrLeaveManagementSystemWebPortletConstants;
import com.ax.hrms.leave.management.web.constants.AxHrmsLeaveManagementSystemWebPortletKeys;
import com.ax.hrms.leave.management.web.dto.LeaveRequestDto;
import com.ax.hrms.leave.management.web.notification.SendNotificationToUserHandler;
import com.ax.hrms.mail.template.config.configuration.MailTemplateConfiguration;
import com.ax.hrms.master.exception.NoSuchLeaveCompensatoryStatusMasterException;
import com.ax.hrms.master.model.DepartmentMaster;
import com.ax.hrms.master.model.DesignationMaster;
import com.ax.hrms.master.model.LeaveCompensatoryStatusMaster;
import com.ax.hrms.master.model.LeaveTypeMaster;
import com.ax.hrms.master.service.DepartmentMasterLocalService;
import com.ax.hrms.master.service.DesignationMasterLocalService;
import com.ax.hrms.master.service.LeaveCompensatoryStatusMasterLocalService;
import com.ax.hrms.master.service.LeaveTypeMasterLocalService;
import com.ax.hrms.model.EmployeeDepartment;
import com.ax.hrms.model.EmployeeDesignation;
import com.ax.hrms.model.EmployeeDetails;
import com.ax.hrms.model.LeaveBalance;
import com.ax.hrms.model.LeaveDayType;
import com.ax.hrms.model.LeaveInformToTeamDetail;
import com.ax.hrms.model.LeaveRequest;
import com.ax.hrms.service.EmployeeDepartmentLocalService;
import com.ax.hrms.service.EmployeeDesignationLocalService;
import com.ax.hrms.service.EmployeeDetailsLocalService;
import com.ax.hrms.service.LeaveBalanceLocalService;
import com.ax.hrms.service.LeaveDayTypeLocalService;
import com.ax.hrms.service.LeaveInformToTeamDetailLocalService;
import com.ax.hrms.service.LeaveRequestLocalService;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.UserNotificationDeliveryConstants;
import com.liferay.portal.kernel.model.UserNotificationEvent;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserNotificationEventLocalServiceUtil;

@Component(
		immediate=true,
	    service = AxHrmsHrLeaveRequestWebUtil.class
)
public class AxHrmsHrLeaveRequestWebUtil {
	private static final Log log = LogFactoryUtil.getLog(AxHrmsHrLeaveRequestWebUtil.class);

	@Reference
	LeaveRequestLocalService leaveRequestLocalService;
	@Reference
	AxHrmsCommonApi axHrmsCommonApi;

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
	LeaveCompensatoryStatusMasterLocalService leaveCompensatoryStatusMasterLocalService;

	@Reference
	LeaveInformToTeamDetailLocalService leaveInformToTeamDetailLocalService;

	@Reference
	LeaveTypeMasterLocalService leaveTypeMasterLocalService;

	
	@Reference
	LeaveBalanceLocalService leaveBalanceLocalService;

	@Reference
	LeaveDayTypeLocalService leaveDayTypeLocalService;

	

	
	public String setDateFormat(Date inputDate) {
		SimpleDateFormat outputDateFormat = new SimpleDateFormat(
				AxHrmsHrLeaveManagementSystemWebPortletConstants.DATE_FORMAT);
		String dateStr = null;
		try {

			// Format the current date to the desired format
			dateStr = outputDateFormat.format(inputDate);

		} catch (Exception e) {
			log.error("AxHrmsHrLeaveRequestWebUtil >>> setDateFormat Method >>Error in Set the Date..!!"
					+ e.getMessage());
		}

		return dateStr;

	}

	public void sendNotificationToEmployee(String body, EmployeeDetails employee)  {

		try {
			JSONObject notificationJSON = JSONFactoryUtil.createJSONObject();

			notificationJSON.put("body", body);

			// Notification........
			UserNotificationEvent userNotification = UserNotificationEventLocalServiceUtil.sendUserNotificationEvents(
					employee.getLrUserId(),
					AxHrmsLeaveManagementSystemWebPortletKeys.AXHRMS_HR_LEAVE_MANAGEMENT_SYSTEM_WEB_PORTLET,
					UserNotificationDeliveryConstants.TYPE_WEBSITE, notificationJSON);
			
			

			ServiceContext serviceContext = new ServiceContext();
SendNotificationToUserHandler sendNotificationToUserHandler = new SendNotificationToUserHandler();
sendNotificationToUserHandler.callGetBody(userNotification, serviceContext);
			
			log.info("SENDING NOTIFICATION IN LEAVE REQUEST PORTLET ...." + userNotification.getPayload());


		} catch (Exception e) {
			log.error("Error in notification employee");
		}

	}

	public LeaveRequestDto setLeaveRequestData(Long leaveRequestId)
			throws PortalException {

		LeaveRequestDto leaveRequestDto = new LeaveRequestDto();

		try {
			LeaveRequest leaveRequest = leaveRequestLocalService.findByleaveRequestId(leaveRequestId);


			EmployeeDetails	employeeDetails = employeeDetailsLocalService.findByEmployeeId(leaveRequest.getEmployeeId());
			
			leaveRequestDto.setLeaveRequestId(leaveRequestId);

			leaveRequestDto.setEmployeeName(employeeDetails.getFirstName() + " " + employeeDetails.getLastName());

			EmployeeDepartment emplyeeDepartment = employeeDepartmentLocalService
					.findByEmployeeId(leaveRequest.getEmployeeId());

			DepartmentMaster departmentMaster = departmentMasterLocalService
					.getDepartmentMaster(emplyeeDepartment.getDepartmentMasterId());
			leaveRequestDto.setDepartmentName(departmentMaster.getDepartmentName());

			EmployeeDesignation employeeDesiganation = employeeDesignationLocalService
					.findByEmployeeId(leaveRequest.getEmployeeId());
			DesignationMaster desiganationMaster = designationMasterLocalService
					.getDesignationMaster(employeeDesiganation.getDesignationMasterId());
			leaveRequestDto.setDesignationName(desiganationMaster.getDesignationName());

			String startDateOfLeave = setDateFormat((leaveRequest.getStartDateTime()));
			String endDateOfLeave = setDateFormat((leaveRequest.getEndDateTime()));
			String dateOfRequestDate = setDateFormat((leaveRequest.getDateOfRequest()));

			leaveRequestDto.setStartDateOfLeaveRequest(startDateOfLeave);
			leaveRequestDto.setEndDateOfLeaveRequest(endDateOfLeave);
			leaveRequestDto.setDateOfRequestedLeave(dateOfRequestDate);

			LeaveCompensatoryStatusMaster leaveStatusMaster = leaveCompensatoryStatusMasterLocalService
					.findByLeaveCompensatoryStatusById(leaveRequest.getLeaveCompensatoryStatusMasterId());
			leaveRequestDto.setStatus(leaveStatusMaster.getLeaveCompensatoryStatus());

			double totalDays = 0;


			List<LeaveDayType>	leaveDayTypeList = leaveDayTypeLocalService.findByLeaveRequestId(leaveRequestId);

			for (LeaveDayType leaveDayType : leaveDayTypeList) {
				if (leaveDayType.getIsHalfDay()) {
					totalDays += 0.5;
				} else {
					totalDays += 1;
				}

			}
			leaveRequestDto.setTotalNoOfDays(totalDays);

			LeaveTypeMaster leaveTypeMaster = leaveTypeMasterLocalService
					.findByLeaveTypeMasterId(leaveRequest.getLeaveTypeMasterId());
			leaveRequestDto.setLeaveType(leaveTypeMaster.getLeaveTypeName());
		} catch (NoSuchLeaveRequestException e) {
			log.error("Error in fetch leave Request object in ViewLeaveRequest Render Class !!!!!" + e.getMessage());
		}

		return leaveRequestDto;

	}

	public long getLeaveStatusId(String statusName) {
	
		try {
			LeaveCompensatoryStatusMaster leaveStatusMaster = leaveCompensatoryStatusMasterLocalService.findByLeaveCompensatoryStatusName(statusName);
			return leaveStatusMaster.getLeaveCompensatoryStatusMasterId();

		} catch (NoSuchLeaveCompensatoryStatusMasterException e) {
			log.error("ListLeaveRequestMVCRenderCommand >>> Render >> Error in find " + statusName + "id  service!!!");
		}
		return 0;

	}

	public List<LeaveRequestDto> getLeaveDayTypeData(Long leaveRequestId ) {
		List<LeaveDayType> leaveDayTypeList;
		leaveDayTypeList = leaveDayTypeLocalService.findByLeaveRequestId(leaveRequestId);
		List<LeaveRequestDto> leaveRequestDtoListForDate = new ArrayList<>();

		for (LeaveDayType leaveDayType : leaveDayTypeList) {
			LeaveRequestDto leaveRequestDtoForDate = new LeaveRequestDto();

			String leaveDateStr = setDateFormat((leaveDayType.getLeaveDate()));
			leaveRequestDtoForDate.setLeaveDate(leaveDateStr);
			leaveRequestDtoForDate.setHalfDay(leaveDayType.getIsHalfDay());
			leaveRequestDtoForDate.setFirstHalf(leaveDayType.getIsFirstHalf());

			leaveRequestDtoListForDate.add(leaveRequestDtoForDate);

		}
		return leaveRequestDtoListForDate;
	}

	public StringBuilder getBody(LeaveRequest leaveRequest, EmployeeDetails employee, StringBuilder body)
			throws PortalException {
		AxHrmsHrLeaveRequestWebUtil leaveRequestUtil = new AxHrmsHrLeaveRequestWebUtil();

		// FETCH DATA OF EMPLOYEE DEPARTMENT AND DESIGNATION
		EmployeeDepartment employeeDepartment = employeeDepartmentLocalService
				.findByEmployeeId(employee.getEmployeeId());

		DepartmentMaster departmentMaster = departmentMasterLocalService
				.findByDepartmentNameById(employeeDepartment.getDepartmentMasterId());

		EmployeeDesignation employeeDesignation = employeeDesignationLocalService
				.findByEmployeeId(employee.getEmployeeId());
		DesignationMaster designationMaster = designationMasterLocalService
				.findByDesignationNameById(employeeDesignation.getDesignationMasterId());

		// FETCH DATA OF STATUS
		LeaveCompensatoryStatusMaster status = leaveCompensatoryStatusMasterLocalService
				.findByLeaveCompensatoryStatusById(leaveRequest.getLeaveCompensatoryStatusMasterId());

		// SET DATA OF LEAVE REQUEST IN THE BODY OF MAIL

		body.append(AxHrmsHrLeaveManagementSystemWebPortletConstants.LEAVE_REQUEST_MAIL_STYLE).append(employee.getEmployeeCode())
				.append(AxHrmsHrLeaveManagementSystemWebPortletConstants.LEAVE_REQUEST_MAIL_STYLE)
				.append(employee.getFirstName()).append(" ").append(employee.getLastName())
				.append(AxHrmsHrLeaveManagementSystemWebPortletConstants.LEAVE_REQUEST_MAIL_STYLE)
				.append(departmentMaster.getDepartmentName())
				.append(AxHrmsHrLeaveManagementSystemWebPortletConstants.LEAVE_REQUEST_MAIL_STYLE)
				.append(designationMaster.getDesignationName())
				.append(AxHrmsHrLeaveManagementSystemWebPortletConstants.LEAVE_REQUEST_MAIL_STYLE)
				.append(status.getLeaveCompensatoryStatus())
				.append(AxHrmsHrLeaveManagementSystemWebPortletConstants.LEAVE_REQUEST_MAIL_STYLE)
				.append(leaveRequestUtil.setDateFormat(leaveRequest.getDateOfRequest()))
				.append(AxHrmsHrLeaveManagementSystemWebPortletConstants.LEAVE_REQUEST_MAIL_STYLE)
				.append(leaveRequestUtil.setDateFormat(leaveRequest.getStartDateTime()))
				.append(AxHrmsHrLeaveManagementSystemWebPortletConstants.LEAVE_REQUEST_MAIL_STYLE)
				.append(leaveRequestUtil.setDateFormat(leaveRequest.getEndDateTime())).append(AxHrmsHrLeaveManagementSystemWebPortletConstants.LEAVE_REQUEST_MAIL_STYLE_CLOSING);

		body.append(AxHrmsHrLeaveManagementSystemWebPortletConstants.LEAVE_REQUEST_MAIL_FOOTER);
		return body;
	}

	public void sendMailtoEmployee(String fromName, String fromEmailAddress, Long leaveRequestId,
			StringBuilder body,MailTemplateConfiguration mailTemplateConfiguration,boolean isApprove,boolean isCancelled) {
		try {
			LeaveRequest leaveRequest = leaveRequestLocalService.findByleaveRequestId(leaveRequestId);
			EmployeeDetails employee = employeeDetailsLocalService.getEmployeeDetails(leaveRequest.getEmployeeId());

			body = getBody(leaveRequest, employee, body);

			// SEND MAIL TO EMPLOYEE

			 String mailContent = isApprove ? mailTemplateConfiguration.mailLeaveApproveEmployeeBody() : isCancelled ? mailTemplateConfiguration.mailLeaveCancelEmployeeBody() : mailTemplateConfiguration.mailLeaveRejectEmployeeBody();
             mailContent =  mailContent.replace("${EMPLOYEE_NAME}", employee.getFirstName()+StringPool.SPACE+employee.getLastName());
             mailContent =  mailContent.replace("${BODY}", body);
              
              String subject =  isApprove ? mailTemplateConfiguration.mailLeaveApproveEmployeeSubject() :isCancelled ? mailTemplateConfiguration.mailLeaveCancelEmployeeSubject() : mailTemplateConfiguration.mailLeaveRejectEmployeeSubject();
               
			
			axHrmsCommonApi.sendMail(employee.getOfficialEmail(), fromEmailAddress, fromName, subject, mailContent);

		} catch (Exception e) {
			log.error("ApproveLeaveRequestMVCActionCommand >>>sendMailtoEmployee >>>  " + e.getMessage());
		}

	}

	public void sendMailtoTeam(String fromName, String fromEmailAddress, Long leaveRequestId,
			StringBuilder body,MailTemplateConfiguration mailTemplateConfiguration)  {
		try {


			LeaveRequest leaveRequest = leaveRequestLocalService.findByleaveRequestId(leaveRequestId);
			EmployeeDetails employee = employeeDetailsLocalService.getEmployeeDetails(leaveRequest.getEmployeeId());
			body = getBody(leaveRequest, employee, body);

			// SEND MAIL TO TEAM
			List<LeaveInformToTeamDetail> leaveInformToTeamDetailList = leaveInformToTeamDetailLocalService
					.findByLeaveRequestId(leaveRequestId);

			for (LeaveInformToTeamDetail leaveInformDetail : leaveInformToTeamDetailList) {
				EmployeeDetails teamMember = employeeDetailsLocalService
						.getEmployeeDetails(leaveInformDetail.getEmployeeId());
				 String mailContent =  mailTemplateConfiguration.mailLeaveManagementTeamBody();
	              mailContent =  mailContent.replace("${BODY}", body);
	               
	               String subject = mailTemplateConfiguration.mailLeaveManagementTeamSubject();
	                
				axHrmsCommonApi.sendMail(teamMember.getOfficialEmail(), fromEmailAddress, fromName, subject,
						mailContent);
			}
		} catch (Exception e) {
			log.error("Error in sending team mail >>> "+ e.getMessage());
		}
	}
	
	public double countLeaveDays(Long leaveRequestId, double totalDays) {

		List<LeaveDayType>	leaveDayTypeList = leaveDayTypeLocalService.findByLeaveRequestId(leaveRequestId);

		for (LeaveDayType leaveDayType : leaveDayTypeList) {
			if (leaveDayType.getIsHalfDay()) {
				totalDays += 0.5;
			} else {
				totalDays += 1;
			}

		}
		return totalDays;
	}
	
	public void updateLeaveBalance(int currentYear, long employeeId, long leaveTypeMasterId, double totalDays)
			throws NoSuchLeaveBalanceException {
		LeaveBalance leaveBalance;
		leaveBalance = leaveBalanceLocalService.findByEmployeeIdLeaveTypeMasterIdAndYear(employeeId, leaveTypeMasterId,
				currentYear);
		double remainingLeaveDays = leaveBalance.getNoOfRemainingLeaves();
		double usedLeaveDays = leaveBalance.getNoOfUsedLeaves();
		leaveBalance.setNoOfRemainingLeaves(remainingLeaveDays + totalDays);
		leaveBalance.setNoOfUsedLeaves(usedLeaveDays - totalDays);
		leaveBalanceLocalService.updateLeaveBalance(leaveBalance);
	}

}
