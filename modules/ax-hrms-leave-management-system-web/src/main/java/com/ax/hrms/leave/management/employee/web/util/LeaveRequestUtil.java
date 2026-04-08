package com.ax.hrms.leave.management.employee.web.util;

import com.ax.hrms.common.api.api.AxHrmsCommonApi;
import com.ax.hrms.exception.NoSuchEmployeeDepartmentException;
import com.ax.hrms.exception.NoSuchEmployeeDesignationException;
import com.ax.hrms.leave.management.hr.web.util.AxHrmsHrLeaveRequestWebUtil;
import com.ax.hrms.leave.management.web.constants.AxHrmsHrLeaveManagementSystemWebPortletConstants;
import com.ax.hrms.leave.management.web.constants.AxHrmsLeaveManagementSystemWebPortletKeys;
import com.ax.hrms.leave.management.web.dto.LeaveRequestDto;
import com.ax.hrms.leave.management.web.notification.SendNotificationToUserHandler;
import com.ax.hrms.mail.template.config.configuration.MailTemplateConfiguration;
import com.ax.hrms.master.model.*;
import com.ax.hrms.master.service.DepartmentMasterLocalService;
import com.ax.hrms.master.service.DesignationMasterLocalService;
import com.ax.hrms.master.service.LeaveCompensatoryStatusMasterLocalService;
import com.ax.hrms.master.service.LeaveTypeMasterLocalService;
import com.ax.hrms.model.*;
import com.ax.hrms.service.*;
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
import com.liferay.portal.kernel.util.Validator;
import org.osgi.service.component.annotations.Reference;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.Year;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author krish.moradiya
 * @implNote : This is UTIL Class which handle Complex Leave Data fetching and managing that
 */
public class LeaveRequestUtil {

	private static Log log = LogFactoryUtil.getLog(LeaveRequestUtil.class);

	private static int currentYear = Year.now().getValue();

    public static StringBuilder getBody(LeaveRequest leaveRequest, EmployeeDetails employee, StringBuilder body,EmployeeDepartmentLocalService employeeDepartmentLocalService,DepartmentMasterLocalService departmentMasterLocalService,EmployeeDesignationLocalService employeeDesignationLocalService,DesignationMasterLocalService designationMasterLocalService,LeaveCompensatoryStatusMasterLocalService leaveCompensatoryStatusMasterLocalService)
            throws PortalException {
        AxHrmsHrLeaveRequestWebUtil leaveRequestUtil = new AxHrmsHrLeaveRequestWebUtil();
        String departmentName = StringPool.DASH;
        try {
        	// FETCH DATA OF EMPLOYEE DEPARTMENT AND DESIGNATION
        	EmployeeDepartment employeeDepartment = employeeDepartmentLocalService
        			.findByEmployeeId(employee.getEmployeeId());
        	
        	DepartmentMaster departmentMaster = departmentMasterLocalService
        			.findByDepartmentNameById(employeeDepartment.getDepartmentMasterId());
        	departmentName = departmentMaster.getDepartmentName();
        } catch (NoSuchEmployeeDepartmentException nsede) {
        	log.error("Unable to fetch department " + nsede.getMessage());
        }
        
        String designationName = StringPool.DASH;
        try {
        	EmployeeDesignation employeeDesignation = employeeDesignationLocalService
        			.findByEmployeeId(employee.getEmployeeId());
        	DesignationMaster designationMaster = designationMasterLocalService
        			.findByDesignationNameById(employeeDesignation.getDesignationMasterId());
        	designationName = designationMaster.getDesignationName();
        } catch(NoSuchEmployeeDesignationException nsede) {
        	log.error("Unable to get designation " + nsede.getMessage());
        }

        // FETCH DATA OF STATUS
        LeaveCompensatoryStatusMaster status = leaveCompensatoryStatusMasterLocalService
                .findByLeaveCompensatoryStatusById(leaveRequest.getLeaveCompensatoryStatusMasterId());

        // SET DATA OF LEAVE REQUEST IN THE BODY OF MAIL

        body.append(AxHrmsHrLeaveManagementSystemWebPortletConstants.LEAVE_REQUEST_MAIL_STYLE).append(employee.getEmployeeCode())
                .append(AxHrmsHrLeaveManagementSystemWebPortletConstants.LEAVE_REQUEST_MAIL_STYLE)
                .append(employee.getFirstName()).append(" ").append(employee.getLastName()).append(AxHrmsHrLeaveManagementSystemWebPortletConstants.LEAVE_REQUEST_MAIL_STYLE_CLOSING)
                .append(AxHrmsHrLeaveManagementSystemWebPortletConstants.LEAVE_REQUEST_MAIL_STYLE)
                .append(departmentName).append(AxHrmsHrLeaveManagementSystemWebPortletConstants.LEAVE_REQUEST_MAIL_STYLE_CLOSING)
                .append(AxHrmsHrLeaveManagementSystemWebPortletConstants.LEAVE_REQUEST_MAIL_STYLE)
                .append(designationName).append(AxHrmsHrLeaveManagementSystemWebPortletConstants.LEAVE_REQUEST_MAIL_STYLE_CLOSING)
                .append(AxHrmsHrLeaveManagementSystemWebPortletConstants.LEAVE_REQUEST_MAIL_STYLE)
                .append(status.getLeaveCompensatoryStatus()).append(AxHrmsHrLeaveManagementSystemWebPortletConstants.LEAVE_REQUEST_MAIL_STYLE_CLOSING)
                .append(AxHrmsHrLeaveManagementSystemWebPortletConstants.LEAVE_REQUEST_MAIL_STYLE)
                .append(leaveRequestUtil.setDateFormat(leaveRequest.getDateOfRequest())).append(AxHrmsHrLeaveManagementSystemWebPortletConstants.LEAVE_REQUEST_MAIL_STYLE_CLOSING)
                .append(AxHrmsHrLeaveManagementSystemWebPortletConstants.LEAVE_REQUEST_MAIL_STYLE)
                .append(leaveRequestUtil.setDateFormat(leaveRequest.getStartDateTime())).append(AxHrmsHrLeaveManagementSystemWebPortletConstants.LEAVE_REQUEST_MAIL_STYLE_CLOSING)
                .append(AxHrmsHrLeaveManagementSystemWebPortletConstants.LEAVE_REQUEST_MAIL_STYLE)
                .append(leaveRequestUtil.setDateFormat(leaveRequest.getEndDateTime())).append(AxHrmsHrLeaveManagementSystemWebPortletConstants.LEAVE_REQUEST_MAIL_STYLE_CLOSING)
				.append("</tr>");
        body.append(AxHrmsHrLeaveManagementSystemWebPortletConstants.LEAVE_REQUEST_MAIL_FOOTER);
        return body;
    }

	public static List<LeaveRequestDto> getListOfLeaveType(List<LeaveTypeMaster> leaveTypeMasterList, List<LeaveBalance> leaveBalanceList, long employeeId, List<LeavePolicyMaster> leavePolicyMasterList) {
		log.info("GetLeaveTypeFilterUsingLeaveBalanceUtil >>> getListOfLeaveType ::: current year :::"+currentYear);
		List<LeaveRequestDto> leaveTypeMap = new ArrayList<>();
		LeavePolicyMaster leavePolicyMaster = null;
		try {

			for(LeaveBalance leaveBalance : leaveBalanceList) {
				LeaveRequestDto leaveRequestDetailDto = new LeaveRequestDto();

				LeaveTypeMaster leaveTypeMaster = getLeaveTypeMasterByLeaveTypeMasterId(leaveBalance.getLeaveTypeMasterId(),leaveTypeMasterList);
				if(leaveTypeMaster != null) {
					leavePolicyMaster = getLeavePolicyMasterByLeaveTypeMasterId(leaveTypeMaster.getLeaveTypeMasterId(),leavePolicyMasterList);
					leaveRequestDetailDto.setLeaveType(leaveTypeMaster.getLeaveTypeName());
					leaveRequestDetailDto.setLeaveTypeId(leaveTypeMaster.getLeaveTypeMasterId());
					if(leavePolicyMaster != null){
						leaveRequestDetailDto.setIsContinous(leavePolicyMaster.getIsContinuous());
						leaveRequestDetailDto.setIsApplicableFloater(leavePolicyMaster.getIsApplicableFloater());
                        if(leavePolicyMaster.getIsApplicableFloater()){
                            leaveRequestDetailDto.setIsContinous(false);
                        }
					}
				}
				leaveRequestDetailDto.setNoOfRemainingLeaves(leaveBalance.getNoOfRemainingLeaves());



				leaveRequestDetailDto.setEmployeeId(employeeId);

				if(currentYear == leaveBalance.getYear())
					leaveTypeMap.add(leaveRequestDetailDto);
			}
		}catch(NullPointerException e) {
			log.error("GetLeaveTypeFilterUsingLeaveBalanceUtil >>> getListOfLeaveType ::: NullPointerException is :::"+e.getMessage());
		} catch(Exception e) {
			log.error("GetLeaveTypeFilterUsingLeaveBalanceUtil >>> getListOfLeaveType ::: "+e.getMessage());
		}
		return leaveTypeMap;
	}

	private static List<LeaveBalance> getLeaveBalanceByEmployeeId(List<LeaveBalance> leaveBalance, long employeeId) {
		try {
			List<LeaveBalance> leaveBalanceLists = leaveBalance.stream()
					.filter(leaveBalanceObj -> leaveBalanceObj.getEmployeeId() == employeeId)
					.collect(Collectors.toList());

			if(!leaveBalanceLists.isEmpty())
				return leaveBalanceLists;
		} catch(Exception e) {
			log.error("GetLeaveTypeFilterUsingLeaveBalanceUtil >>> getLeaveBalanceByEmployeeId ::: "+e.getMessage());
		}
		return new ArrayList<>();
	}

	private static LeaveTypeMaster getLeaveTypeMasterByLeaveTypeMasterId(long leaveTypeMasterId,List<LeaveTypeMaster> leaveTypeMasterList) {
		Optional<LeaveTypeMaster> result = leaveTypeMasterList.stream()
				.filter(leaveTypeMaster -> leaveTypeMaster.getLeaveTypeMasterId() == leaveTypeMasterId)
				.findFirst();

		if(result.isPresent())
			return result.get();
		else
			return null;

	}

	private static LeavePolicyMaster getLeavePolicyMasterByLeaveTypeMasterId(long leaveTypeMasterId,List<LeavePolicyMaster> leavePolicyMasterList){
		Optional<LeavePolicyMaster> leavePolicyMasterResult = leavePolicyMasterList.stream()
				.filter(leavePolicyMasterObj -> leavePolicyMasterObj.getLeaveTypeMasterId() == leaveTypeMasterId)
				.findFirst();
		if(leavePolicyMasterResult.isPresent())
			return leavePolicyMasterResult.get();
		else
			return null;
	}
	public static List<LeaveRequestDto> getListOfLeaveRequest(EmployeeDetails employeeDetails, List<LeaveRequest> leaveRequestList, List<LeaveTypeMaster> leaveTypeMasterList, List<LeaveDayType> leaveDayTypeList, List<LeaveCompensatoryStatusMaster> leaveCompensatoryStatusMasterList,EmployeeDetailsLocalService employeeDetailsLocalService) {
		List<LeaveRequestDto> listOfLeaveRequestOfEmployee = new ArrayList<>();
		List<LeaveTypeMaster> listOfLeaveTypeMaster = leaveTypeMasterList;
		List<LeaveDayType> listOfLeaveDayType = leaveDayTypeList;
		List<LeaveCompensatoryStatusMaster> listOfLeaveCompensatoryStatusMasters = leaveCompensatoryStatusMasterList;

		try {
			for (LeaveRequest leaveRequest : leaveRequestList) {
				LeaveRequestDto leaveRequestDetails = new LeaveRequestDto();

				// Set Employee Details
				setEmployeeDetailsInLeaveRequest(leaveRequestDetails, employeeDetails);

				leaveRequestDetails.setLeaveRequestId(leaveRequest.getLeaveRequestId());

				if (Validator.isNotNull(leaveRequest.getModifiedBy())){
					EmployeeDetails modifiedUser = employeeDetailsLocalService.findByLrUserId(leaveRequest.getModifiedBy());

					leaveRequestDetails.setModifiedUser(modifiedUser.getFirstName() + " " + modifiedUser.getLastName());
				}else{
					leaveRequestDetails.setModifiedUser("");
				}

				// Set LeaveTypeMaster details
				Optional<LeaveTypeMaster> result = listOfLeaveTypeMaster.stream()
						.filter(leaveTypeMaster -> leaveTypeMaster.getLeaveTypeMasterId() == leaveRequest.getLeaveTypeMasterId())
						.findFirst();
				if (result.isPresent()) {
					LeaveTypeMaster leaveTypeMaster = result.get();
					setLeaveTypeDetailsInLeaveRequest(leaveRequestDetails, leaveTypeMaster);
				}

				// Set LeaveCompensatoryStatusMaster details
				Optional<LeaveCompensatoryStatusMaster> leaveCompensatoryStatusMasterObj = listOfLeaveCompensatoryStatusMasters.stream()
						.filter(leaveCompensatoryStatusMaster -> leaveCompensatoryStatusMaster.getLeaveCompensatoryStatusMasterId() == leaveRequest.getLeaveCompensatoryStatusMasterId())
						.findFirst();
				if (leaveCompensatoryStatusMasterObj.isPresent()) {
					LeaveCompensatoryStatusMaster leaveCompensatoryStatusMaster = leaveCompensatoryStatusMasterObj.get();
					leaveRequestDetails.setLeaveRequestStatus(leaveCompensatoryStatusMaster.getLeaveCompensatoryStatus());
				}

				// Set LeaveDayType details
				List<LeaveDayType> leaveDayTypeListFiltered = listOfLeaveDayType.stream()
						.filter(leaveDayType -> leaveDayType.getLeaveRequestId() == leaveRequest.getLeaveRequestId())
						.collect(Collectors.toList());
				if (!leaveDayTypeListFiltered.isEmpty()) {
					setLeaveDayTypeDetailsInLeaveRequest(leaveRequestDetails, leaveDayTypeListFiltered, leaveRequest);
				}

				listOfLeaveRequestOfEmployee.add(leaveRequestDetails);
			}
		} catch (Exception e) {
			e.getMessage();
		}

		return listOfLeaveRequestOfEmployee;
	}

	private static void setEmployeeDetailsInLeaveRequest(LeaveRequestDto leaveRequestDetails, EmployeeDetails employeeDetails) {
		leaveRequestDetails.setUserId(employeeDetails.getLrUserId());
		leaveRequestDetails.setEmployeeId(employeeDetails.getEmployeeId());
		leaveRequestDetails.setEmployeeName(employeeDetails.getFirstName() + " " + employeeDetails.getLastName());

	}

	private static void setLeaveTypeDetailsInLeaveRequest(LeaveRequestDto leaveRequestDetails, LeaveTypeMaster leaveTypeMaster) {
		leaveRequestDetails.setLeaveType(leaveTypeMaster.getLeaveTypeName());
		leaveRequestDetails.setLeaveTypeId(leaveTypeMaster.getLeaveTypeMasterId());
		leaveRequestDetails.setLeaveTypeDescription(leaveTypeMaster.getDescription());
	}

	public static void setLeaveDayTypeDetailsInLeaveRequest(LeaveRequestDto leaveRequestDetails, List<LeaveDayType> listOfLeaveDayTypes, LeaveRequest leaveRequest) {
		int noOfHoursInLeaveDayType = 0;
		for (LeaveDayType leaveDayType : listOfLeaveDayTypes) {
			if (leaveDayType.getIsHalfDay())
				noOfHoursInLeaveDayType += 4;
			else
				noOfHoursInLeaveDayType += 8;
		}
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(AxHrmsHrLeaveManagementSystemWebPortletConstants.DD_MMM_YYYY);
		leaveRequestDetails.setLeavePeriod(simpleDateFormat.format(leaveRequest.getStartDateTime()) + AxHrmsHrLeaveManagementSystemWebPortletConstants.TO + simpleDateFormat.format(leaveRequest.getEndDateTime()));
		leaveRequestDetails.setNoOfDays(noOfHoursInLeaveDayType / 8.0);
		leaveRequestDetails.setNoOfHours(noOfHoursInLeaveDayType);
	}

	public static double calculateDaysBetween(Date startDate, Date endDate) {
		LocalDateTime startDateTime = startDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
		LocalDateTime endDateTime = endDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();

		return ChronoUnit.DAYS.between(startDateTime, endDateTime);
	}


    public static void sendNotificationToManager(String body, EmployeeDetails employee)  {

        try {
            JSONObject notificationJSON = JSONFactoryUtil.createJSONObject();

            notificationJSON.put("body", body);

            // Notification........
            UserNotificationEvent userNotification = UserNotificationEventLocalServiceUtil.sendUserNotificationEvents(
                    employee.getLrUserId(),
                    AxHrmsLeaveManagementSystemWebPortletKeys.AXHRMS_EMPLOYEE_LEAVE_MANAGEMENT_SYSTEM_WEB_PORTLET,
                    UserNotificationDeliveryConstants.TYPE_WEBSITE, notificationJSON);



            ServiceContext serviceContext = new ServiceContext();
            SendNotificationToUserHandler sendNotificationToUserHandler = new SendNotificationToUserHandler();
            sendNotificationToUserHandler.callGetBody(userNotification, serviceContext);

            log.info("SENDING NOTIFICATION IN LEAVE REQUEST PORTLET ...." + userNotification.getPayload());


        } catch (Exception e) {
            log.error("Error in notification employee");
        }

    }


    public static void sendMailtoManager(String fromName, String fromEmailAddress,StringBuilder body,long leaveRequestId, Long employeeId,
                                    MailTemplateConfiguration mailTemplateConfiguration,EmployeeDetailsLocalService employeeDetailsLocalService,LeaveRequestLocalService leaveRequestLocalService,EmployeeDepartmentLocalService employeeDepartmentLocalService, DepartmentMasterLocalService departmentMasterLocalService,EmployeeDesignationLocalService employeeDesignationLocalService,DesignationMasterLocalService designationMasterLocalService,LeaveCompensatoryStatusMasterLocalService leaveCompensatoryStatusMasterLocalService,AxHrmsCommonApi axHrmsCommonApi) {
        try {
            log.info("SENDING MAIL TO MANAGER");
            log.info("body :: "+body.toString());
            LeaveRequest leaveRequest = leaveRequestLocalService.findByleaveRequestId(leaveRequestId);
            EmployeeDetails employee = employeeDetailsLocalService.getEmployeeDetails(employeeId);
            EmployeeDetails employee1 = employeeDetailsLocalService.getEmployeeDetails(leaveRequest.getEmployeeId());

            body = getBody(leaveRequest, employee1, body,employeeDepartmentLocalService,departmentMasterLocalService,employeeDesignationLocalService,designationMasterLocalService,leaveCompensatoryStatusMasterLocalService);
            log.info("body after calling getboody   function  ----> :: "+body.toString());
            // SEND MAIL TO EMPLOYE

            String mailContent = mailTemplateConfiguration.mailLeaveRequestManagerBody();
            mailContent =  mailContent.replace("${EMPLOYEE_NAME}", employee.getFirstName()+ StringPool.SPACE+employee.getLastName());
            mailContent =  mailContent.replace("${BODY}", body);
                log.info("SENDING MAIL TO MANAGER ...." + mailContent);
//            String subject =  isApprove ? mailTemplateConfiguration.mailLeaveApproveEmployeeSubject() :isCancelled ? mailTemplateConfiguration.mailLeaveCancelEmployeeSubject() : mailTemplateConfiguration.mailLeaveRejectEmployeeSubject();
         log.info("mail is senting to "+employee.getFirstName()+" "+employee.getFirstName());
            String subject=mailTemplateConfiguration.mailLeaveRequestManagerSubject();
            axHrmsCommonApi.sendMail(employee.getOfficialEmail(), fromEmailAddress, fromName, subject, mailContent);

        } catch (Exception e) {
            log.error("ApproveLeaveRequestMVCActionCommand >>>sendMailtoEmployee >>>  " + e.getMessage());
        }

    }
}
