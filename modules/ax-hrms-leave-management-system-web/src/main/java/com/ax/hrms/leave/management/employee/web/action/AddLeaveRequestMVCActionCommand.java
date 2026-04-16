package com.ax.hrms.leave.management.employee.web.action;

import java.util.List;
import com.ax.hrms.common.api.api.AxHrmsCommonApi;
import com.ax.hrms.exception.NoSuchLeaveBalanceException;
import com.ax.hrms.leave.management.employee.web.util.LeaveRequestUtil;
import com.ax.hrms.leave.management.web.constants.AxHrmsHrLeaveManagementSystemWebPortletConstants;
import com.ax.hrms.leave.management.web.constants.AxHrmsLeaveManagementSystemWebPortletKeys;
import com.ax.hrms.leave.management.web.constants.AxHrmsLeaveManagementWebPortletConstants;
import com.ax.hrms.mail.template.config.configuration.MailTemplateConfiguration;
import com.ax.hrms.master.exception.NoSuchLeaveCompensatoryStatusMasterException;
import com.ax.hrms.master.service.DepartmentMasterLocalService;
import com.ax.hrms.master.service.DesignationMasterLocalService;
import com.ax.hrms.master.service.LeaveCompensatoryStatusMasterLocalService;
import com.ax.hrms.model.*;
import com.ax.hrms.notification.template.config.configuration.NotificationTemplateConfiguration;
import com.ax.hrms.service.*;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.petra.sql.dsl.DSLFunctionFactoryUtil;
import com.liferay.petra.sql.dsl.DSLQueryFactoryUtil;
import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.*;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;


/**
 * @author krish.moradiya
 * @implNote : Add Leave Request in leave balance and other...
 */
@Component(immediate = true, property = {"javax.portlet.name=" + AxHrmsLeaveManagementSystemWebPortletKeys.AXHRMS_EMPLOYEE_LEAVE_MANAGEMENT_SYSTEM_WEB_PORTLET, "mvc.command.name=" + AxHrmsLeaveManagementWebPortletConstants.ADD_LEAVE_REQUEST_MVC_COMMAND_NAME}, service = MVCActionCommand.class)

public class AddLeaveRequestMVCActionCommand extends BaseMVCActionCommand {


    private static final Log log = LogFactoryUtil.getLog(AddLeaveRequestMVCActionCommand.class);

    @Reference
    private LeaveRequestLocalService leaveRequestLocalService;
    @Reference
    private LeaveDayTypeLocalService leaveDayTypeLocalService;
    @Reference
    private EmployeeDetailsLocalService employeeDetailsLocalService;
    @Reference
    private LeaveInformToTeamDetailLocalService leaveInformToTeamDetailLocalService;
    @Reference
    private LeaveCompensatoryStatusMasterLocalService leaveCompensatoryStatusMasterLocalService;
    @Reference
    private LeaveBalanceLocalService leaveBalanceLocalService;
    @Reference
    NotificationTemplateConfiguration notificationTemplateConfiguration;
    @Reference
    MailTemplateConfiguration mailTemplateConfiguration;
    @Reference
    AxHrmsCommonApi axHrmsCommonApi;
    @Reference
    DepartmentMasterLocalService departmentMasterLocalService;
    @Reference
    HolidayLocalService holidayLocalService;
    @Reference
    DesignationMasterLocalService designationMasterLocalService;

    @Reference
    EmployeeDepartmentLocalService employeeDepartmentLocalService;

    @Reference
    EmployeeDesignationLocalService employeeDesignationLocalService;


    @Override
    protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
        log.info("AddEditLeaveRequestMVCActionCommand >>> doProcessAction ::: Add Edit Leave Request Action Method Called");
        ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
        long companyId = themeDisplay.getCompanyId();
        String roleName = "HR Admin";
        long employeeId = ParamUtil.getLong(actionRequest, AxHrmsLeaveManagementWebPortletConstants.EMPLOYEE_ID_PARAM_NAME, AxHrmsLeaveManagementWebPortletConstants.DEFAULT_LONG_VALUE);
        super.hideDefaultErrorMessage(actionRequest);
        super.hideDefaultSuccessMessage(actionRequest);
        EmployeeDetails eligibleEmployee = employeeDetailsLocalService.getEmployeeDetails(employeeId);
        if(eligibleEmployee.getIsProbationEnabled()){
            SessionErrors.add(actionRequest, AxHrmsLeaveManagementWebPortletConstants.LEAVE_REQUEST_NOT_INSERTED_MESSAGE_KEY_BECAUSE_OF_PROBATION);
            actionResponse.sendRedirect(PortalUtil.getLayoutFullURL(themeDisplay));
            return;
        }

        if(eligibleEmployee.getEmployeeType().equalsIgnoreCase("intern") || eligibleEmployee.getEmployeeType().equalsIgnoreCase("Contractor")){
            SessionErrors.add(actionRequest,AxHrmsLeaveManagementWebPortletConstants.LEAVE_REQUEST_NOT_INSERTED_MESSAGE_KEY_BECAUSE_OF_UNAUTHORIZED);
            actionResponse.sendRedirect(PortalUtil.getLayoutFullURL(themeDisplay));
            return;
        }

        long overlapCount = getOverlapCount(actionRequest, employeeId);

        log.info("overlapped count " + overlapCount);
        
        if(overlapCount>0) {
        	log.info("overlapped");
        	SessionErrors.add(actionRequest,AxHrmsLeaveManagementWebPortletConstants.LEAVE_REQUEST_NOT_INSERTED_MESSAGE_KEY_BECAUSE_OF_OVERLAPPED);
        	actionResponse.sendRedirect(PortalUtil.getLayoutFullURL(themeDisplay));
            return;
        }

        long leaveRequestId = ParamUtil.getLong(actionRequest, AxHrmsLeaveManagementWebPortletConstants.LEAVE_REQUEST_ID_VAR, AxHrmsLeaveManagementWebPortletConstants.DEFAULT_LONG_VALUE);
        log.info("leaveRequestId: " + leaveRequestId);
        LeaveRequest leaveRequest = setLeaveRequestData(actionRequest, leaveRequestId);
        log.info("leaveRequest = " + leaveRequest);
        if (leaveRequest != null) {
            try {
                addLeaveRequestData(actionRequest, leaveRequest);
                SessionMessages.add(actionRequest, AxHrmsLeaveManagementWebPortletConstants.LEAVE_REQUEST_INSERTED_MESSAGE_KEY);
                String fromName = PrefsPropsUtil.getString(themeDisplay.getCompanyId(), PropsKeys.ADMIN_EMAIL_FROM_NAME);
                String fromEmailAddress = PrefsPropsUtil.getString(themeDisplay.getCompanyId(), PropsKeys.ADMIN_EMAIL_FROM_ADDRESS);
                String managerNotification = notificationTemplateConfiguration.leaveRequestedNotificationToManager();
                StringBuilder employeeMailBody = new StringBuilder(AxHrmsHrLeaveManagementSystemWebPortletConstants.LEAVE_REQUEST_MAIL_HEAD);
                Role role = RoleLocalServiceUtil.fetchRole(companyId, roleName);
                List<User> users = UserLocalServiceUtil.getRoleUsers(role.getRoleId());
                EmployeeDetails employee = employeeDetailsLocalService.getEmployeeDetails(leaveRequest.getEmployeeId());
                if(Validator.isNotNull(employee.getManagerId())) {
                    EmployeeDetails manager = employeeDetailsLocalService.findByEmployeeId(employee.getManagerId());
                    LeaveRequestUtil.sendNotificationToManager(managerNotification, manager);

                    LeaveRequestUtil.sendMailtoManager(fromName, fromEmailAddress, employeeMailBody, leaveRequest.getLeaveRequestId(), manager.getEmployeeId(), mailTemplateConfiguration, employeeDetailsLocalService, leaveRequestLocalService, employeeDepartmentLocalService, departmentMasterLocalService, employeeDesignationLocalService, designationMasterLocalService, leaveCompensatoryStatusMasterLocalService, axHrmsCommonApi);
                }
                for (User user : users) {
                    try {
                        log.info("User: " + user.getFullName() + " | Email: " + user.getEmailAddress() + "  ,,,,, " + user.getUserId());
                        EmployeeDetails employeeDetails = employeeDetailsLocalService.findByLrUserId(user.getUserId());
                        log.info("Employee Id: " + employeeDetails.toString());
                        LeaveRequestUtil.sendNotificationToManager(managerNotification, employeeDetails);
                        StringBuilder hrMailBody = new StringBuilder(AxHrmsHrLeaveManagementSystemWebPortletConstants.LEAVE_REQUEST_MAIL_HEAD);
                        LeaveRequestUtil.sendMailtoManager(fromName, fromEmailAddress, hrMailBody, leaveRequest.getLeaveRequestId(), employeeDetails.getEmployeeId(), mailTemplateConfiguration, employeeDetailsLocalService, leaveRequestLocalService, employeeDepartmentLocalService, departmentMasterLocalService, employeeDesignationLocalService, designationMasterLocalService, leaveCompensatoryStatusMasterLocalService, axHrmsCommonApi);
                    } catch (Exception e) {
                        log.info("Error for not getting user : " + e.getMessage());
                    }
                }

            } catch (Exception e) {
                log.info("exception raised ::::   " + e.getMessage());
                SessionErrors.add(actionRequest, AxHrmsLeaveManagementWebPortletConstants.LEAVE_REQUEST_NOT_INSERTED_MESSAGE_KEY);
            }
        } else {
            SessionErrors.add(actionRequest, AxHrmsLeaveManagementWebPortletConstants.LEAVE_REQUEST_NOT_INSERTED_MESSAGE_KEY);
        }

        
      actionResponse.sendRedirect(PortalUtil.getLayoutFullURL(themeDisplay));


    }

	private long getOverlapCount(ActionRequest actionRequest, long employeeId) {
		String start = ParamUtil.getString(actionRequest, AxHrmsLeaveManagementWebPortletConstants.START_DATE);
        String end = ParamUtil.getString(actionRequest, AxHrmsLeaveManagementWebPortletConstants.END_DATE);
        DateFormat dateFormat = new SimpleDateFormat(AxHrmsLeaveManagementWebPortletConstants.LIFERAY_DB_DATETIME_FORMAT);
        Date startDate = null;
        Date endDate = null;
        try {
            startDate = dateFormat.parse(start + AxHrmsLeaveManagementWebPortletConstants.DEFAULT_TIME);
            endDate = dateFormat.parse(end + AxHrmsLeaveManagementWebPortletConstants.DEFAULT_TIME);
        } catch (ParseException e1) {
            log.info("AddEditLeaveRequestMVCActionCommand >>> setLeaveRequestData ::: Exception: " + e1.getMessage());
        }
        
        long approvedStatusId = 0;
        long pendingStatusId = 0;

        try {
            approvedStatusId =
                leaveCompensatoryStatusMasterLocalService
                    .findByLeaveCompensatoryStatusName("Approved")
                    .getLeaveCompensatoryStatusMasterId();

            pendingStatusId =
                leaveCompensatoryStatusMasterLocalService
                    .findByLeaveCompensatoryStatusName("Pending")
                    .getLeaveCompensatoryStatusMasterId();

        } catch (NoSuchLeaveCompensatoryStatusMasterException e) {
            log.error("Status master not found", e);
        }
        Long[] validStatusIds = new Long[] {approvedStatusId, pendingStatusId};
        

        ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);

        List<LeaveDayType> newDays =
                getNewLeaveDayTypesFromRequest(actionRequest, dateFormat, themeDisplay);

        List<LeaveRequest> overlappingRequests =
                leaveRequestLocalService.dslQuery(
                        DSLQueryFactoryUtil.select(
                                LeaveRequestTable.INSTANCE
                        ).from(
                                LeaveRequestTable.INSTANCE
                        ).where(
                                LeaveRequestTable.INSTANCE.employeeId.eq(employeeId)
                                        .and(LeaveRequestTable.INSTANCE.startDateTime.lte(endDate))
                                        .and(LeaveRequestTable.INSTANCE.endDateTime.gte(startDate))
                                        .and(LeaveRequestTable.INSTANCE.leaveCompensatoryStatusMasterId.in(validStatusIds))
                        )
                );

        // Compare
        for (LeaveRequest existingRequest : overlappingRequests) {

            List<LeaveDayType> existingDays =
                    leaveDayTypeLocalService.findByLeaveRequestId(existingRequest.getLeaveRequestId());

            for (LeaveDayType newDay : newDays) {
                for (LeaveDayType existingDay : existingDays) {

                    if (isSameDate(newDay.getLeaveDate(), existingDay.getLeaveDate())) {

                        //  Full day conflict
                        if (!newDay.getIsHalfDay() || !existingDay.getIsHalfDay()) {
                            return 1;
                        }

                        //  Same half conflict
                        if (newDay.getIsFirstHalf() == existingDay.getIsFirstHalf()) {
                            return 1;
                        }

                        // First + Second → allowed
                    }
                }
            }
        }

        return 0;
	}

    private List<LeaveDayType> getNewLeaveDayTypesFromRequest(
            ActionRequest actionRequest,
            DateFormat dateFormat,
            ThemeDisplay themeDisplay) {

        List<LeaveDayType> leaveDayTypes = new ArrayList<>();

        String start = ParamUtil.getString(actionRequest, AxHrmsLeaveManagementWebPortletConstants.START_DATE);
        String end = ParamUtil.getString(actionRequest, AxHrmsLeaveManagementWebPortletConstants.END_DATE);

        Date startDate = null;
        Date endDate = null;

        try {
            startDate = dateFormat.parse(start + AxHrmsLeaveManagementWebPortletConstants.DEFAULT_TIME);
            endDate = dateFormat.parse(end + AxHrmsLeaveManagementWebPortletConstants.DEFAULT_TIME);
        } catch (ParseException e) {
            log.error("Error parsing dates", e);
            return leaveDayTypes;
        }

        Date[] leaveDatesArray = getDatesBetween(startDate, endDate);

        for (Date date : leaveDatesArray) {

            int day = date.getDate();
            String actualDate = (day < 10) ? "0" + day : String.valueOf(day);

            String dateString = ParamUtil.getString(
                    actionRequest,
                    AxHrmsLeaveManagementWebPortletConstants.DAY + actualDate + AxHrmsLeaveManagementWebPortletConstants.DATE
            );

            Date leaveDate = null;
            try {
                leaveDate = dateFormat.parse(dateString + AxHrmsLeaveManagementWebPortletConstants.DEFAULT_TIME);
            } catch (ParseException e) {
                log.error("Error parsing leaveDate", e);
                continue;
            }

            boolean isHalf = ParamUtil.getBoolean(
                    actionRequest,
                    AxHrmsLeaveManagementWebPortletConstants.DAY + actualDate + AxHrmsLeaveManagementWebPortletConstants.IS_HALF,
                    false
            );

            boolean isFirstHalf = false;

            if (isHalf) {
                String halfType = ParamUtil.getString(
                        actionRequest,
                        AxHrmsLeaveManagementWebPortletConstants.DAY + actualDate + AxHrmsLeaveManagementWebPortletConstants.HALF_TYPE
                );

                isFirstHalf = AxHrmsLeaveManagementWebPortletConstants.FIRST_HALF.equals(halfType);
            }

            LeaveDayType temp = leaveDayTypeLocalService.createLeaveDayType(0); // ID = 0 (not persisted)

            temp.setLeaveDate(leaveDate);
            temp.setIsHalfDay(isHalf);
            temp.setIsFirstHalf(isFirstHalf);

            leaveDayTypes.add(temp);
        }

        return leaveDayTypes;
    }

    private boolean isSameDate(Date d1, Date d2) {
        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();
        c1.setTime(d1);
        c2.setTime(d2);

        return c1.get(Calendar.YEAR) == c2.get(Calendar.YEAR)
                && c1.get(Calendar.DAY_OF_YEAR) == c2.get(Calendar.DAY_OF_YEAR);
    }

    private void addLeaveRequestData(ActionRequest actionRequest, LeaveRequest leaveRequest) {
        leaveRequestLocalService.addLeaveRequest(leaveRequest);
        SessionMessages.add(actionRequest, AxHrmsLeaveManagementWebPortletConstants.LEAVE_REQUEST_INSERTED_MESSAGE_KEY);
    }

    private LeaveRequest setLeaveRequestData(ActionRequest actionRequest, long leaveRequestId) throws NullPointerException {

        boolean updateLeaveStatus = false;

        log.info("reach here....");
        ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
        long employeeId = ParamUtil.getLong(actionRequest, AxHrmsLeaveManagementWebPortletConstants.EMPLOYEE_ID_PARAM_NAME, AxHrmsLeaveManagementWebPortletConstants.DEFAULT_LONG_VALUE);
        String reason = ParamUtil.getString(actionRequest, AxHrmsLeaveManagementWebPortletConstants.REASON, null);
        long leaveTypeMasterId = ParamUtil.getLong(actionRequest, AxHrmsLeaveManagementWebPortletConstants.LEAVE_TYPE, AxHrmsLeaveManagementWebPortletConstants.DEFAULT_LONG_VALUE);
        log.info("leaveTypeMasterId:------------------------------> " + leaveTypeMasterId);
        DateFormat dateFormat = new SimpleDateFormat(AxHrmsLeaveManagementWebPortletConstants.LIFERAY_DB_DATETIME_FORMAT);
        String start = ParamUtil.getString(actionRequest, AxHrmsLeaveManagementWebPortletConstants.START_DATE);
        String end = ParamUtil.getString(actionRequest, AxHrmsLeaveManagementWebPortletConstants.END_DATE);

        Date startDate = null;
        Date endDate = null;
        try {
            startDate = dateFormat.parse(start + AxHrmsLeaveManagementWebPortletConstants.DEFAULT_TIME);
            endDate = dateFormat.parse(end + AxHrmsLeaveManagementWebPortletConstants.DEFAULT_TIME);
        } catch (ParseException e1) {
            log.info("AddEditLeaveRequestMVCActionCommand >>> setLeaveRequestData ::: Exception: " + e1.getMessage());
        }
        
        Date[] leaveDatesArray = getDatesBetween(startDate, endDate);
        int[] leaveDates = new int[leaveDatesArray.length];
        int count = 0;
        for (Date date : leaveDatesArray) {
            leaveDates[count] = date.getDate();
            log.info("AddEditLeaveRequestMVCActionCommand >>> setLeaveRequestData ::: leaveDate: " + leaveDates[count]);
            count++;
        }
        LeaveRequest leaveRequest = null;
        if (leaveRequestId > 0) {
            try {
                leaveRequest = leaveRequestLocalService.getLeaveRequest(leaveRequestId);
            } catch (PortalException e) {
                log.error("AddEditLeaveRequestMVCActionCommand >>> setLeaveRequestData (MVCActionCommand) ::: Exception is: " + e.getMessage());
            }
        } else {
            leaveRequest = leaveRequestLocalService.createLeaveRequest(CounterLocalServiceUtil.increment(LeaveRequest.class.getName()));
            leaveRequest.setCreatedBy(themeDisplay.getUserId());
            log.info("leaveRequestId: " + leaveRequest.getLeaveRequestId());
        }
        try {
            if (leaveRequest != null) {
                leaveRequest.setModifiedBy(themeDisplay.getUserId());
                leaveRequest.setGroupId(themeDisplay.getScopeGroupId());
                leaveRequest.setEmployeeId(employeeId);
                leaveRequest.setStartDateTime(startDate);
                leaveRequest.setEndDateTime(endDate);
                leaveRequest.setReason(reason);
                leaveRequest.setLeaveTypeMasterId(leaveTypeMasterId);
                leaveRequest.setLeaveCompensatoryStatusMasterId(leaveCompensatoryStatusMasterLocalService.findByLeaveCompensatoryStatusName(AxHrmsLeaveManagementWebPortletConstants.PENDING).getLeaveCompensatoryStatusMasterId());
                leaveRequest.setDateOfRequest(new Date());

                addLeaveDayTypeData(leaveDates, actionRequest, dateFormat, leaveRequest.getLeaveRequestId(), themeDisplay);
                addLeaveInformDetails(leaveRequest.getLeaveRequestId(), actionRequest, themeDisplay);
                updateLeaveStatus = updateLeaveBalance(leaveRequest.getLeaveRequestId(), employeeId, leaveTypeMasterId);
            }

        } catch (NullPointerException nullException) {
            log.error("AddEditLeaveRequestMVCActionCommand >>> setLeaveRequestData (MVCActionCommand) ::: NullPointerException is: " + nullException.getMessage());
        } catch (Exception e) {
            log.error("AddEditLeaveRequestMVCActionCommand >>> setLeaveRequestData (MVCActionCommand) ::: Exception is: " + e.getMessage());
        }
        if (updateLeaveStatus) return leaveRequest;
        else return null;
    }

    public  Date[] getDatesBetween(Date startDate, Date endDate) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(startDate);

        List<Date> datesBetween = new ArrayList<>();
        int year = calendar.get(Calendar.YEAR);
        List<Holiday> holidays=null;
        try {
             holidays = holidayLocalService.findByYear(year);
        }catch (Exception e) {
            log.info("Error raised due to ::"+e.getMessage());
        }
        while (calendar.getTime().compareTo(endDate) < 0 || calendar.getTime().compareTo(endDate) == 0) {
            Date result = calendar.getTime();

//            if (calendar.getTime().getDay() != 6 && calendar.getTime().getDay() != 0) datesBetween.add(result);

            boolean isWeekend =
                    result.getDay() == 0 || result.getDay() == 6;

            boolean isHoliday = false;
           if(Validator.isNotNull(holidays)) {
               for (Holiday holiday : holidays) {
                   if (isSameDate(result, holiday.getDate())) {
                       isHoliday = true;
                       break;
                   }
               }
           }

            //  Skip BOTH weekend AND holiday
            if (!isWeekend && !isHoliday) {
                datesBetween.add(result);
            }

            calendar.add(Calendar.DATE, 1);
        }

        return datesBetween.toArray(new Date[0]);
    }

    private void addLeaveDayTypeData(int[] leaveDates, ActionRequest actionRequest, DateFormat dateFormat, long leaveRequestId, ThemeDisplay themeDisplay) {
        LeaveDayType leaveDayType = null;
        for (int i : leaveDates) {
            String actualDate = "";
            if (i / 10 == 0) actualDate = "0" + i;
            else actualDate = "" + i;

            leaveDayType = leaveDayTypeLocalService.createLeaveDayType(CounterLocalServiceUtil.increment(LeaveDayType.class.getName()));
            String dateString = ParamUtil.getString(actionRequest, AxHrmsLeaveManagementWebPortletConstants.DAY + actualDate + AxHrmsLeaveManagementWebPortletConstants.DATE);
            Date leaveDate = null;
            try {
                leaveDate = dateFormat.parse(dateString + AxHrmsLeaveManagementWebPortletConstants.DEFAULT_TIME);
            } catch (ParseException e1) {
                log.error("AddEditLeaveRequestMVCActionCommand >>> addLeaveDayTypeData (MVCActionCommand) ::: Exception is: " + e1.getMessage());
            }
            boolean isHalf = ParamUtil.getBoolean(actionRequest, AxHrmsLeaveManagementWebPortletConstants.DAY + actualDate + AxHrmsLeaveManagementWebPortletConstants.IS_HALF, false);
            boolean isFirstHalf = false;
            if (isHalf) {
                isFirstHalf = (ParamUtil.getString(actionRequest, AxHrmsLeaveManagementWebPortletConstants.DAY + actualDate + AxHrmsLeaveManagementWebPortletConstants.HALF_TYPE, null)).equals(AxHrmsLeaveManagementWebPortletConstants.FIRST_HALF) ? true : false;
            }

            leaveDayType.setLeaveRequestId(leaveRequestId);
            leaveDayType.setLeaveDate(leaveDate);
            leaveDayType.setIsHalfDay(isHalf);
            leaveDayType.setIsFirstHalf(isFirstHalf);

            leaveDayType.setCreatedBy(themeDisplay.getUserId());
            leaveDayType.setModifiedBy(themeDisplay.getUserId());
            leaveDayType.setGroupId(themeDisplay.getScopeGroupId());

            leaveDayTypeLocalService.addLeaveDayType(leaveDayType);
        }
    }

    private void addLeaveInformDetails(long leaveRequestId, ActionRequest actionRequest, ThemeDisplay themeDisplay) {
        String teamIdString = ParamUtil.getString(actionRequest, AxHrmsLeaveManagementWebPortletConstants.TEAM_ID, GetterUtil.DEFAULT_STRING);

        String[] teamIds = (!teamIdString.equals("")) ? teamIdString.split(",") : new String[0];
        try {
            if (!teamIdString.equals("")) {
                for (String teamId : teamIds) {
                    LeaveInformToTeamDetail leaveInformToTeamDetail = leaveInformToTeamDetailLocalService.createLeaveInformToTeamDetail(CounterLocalServiceUtil.increment(LeaveInformToTeamDetail.class.getName()));
                    leaveInformToTeamDetail.setCreatedBy(themeDisplay.getUserId());
                    leaveInformToTeamDetail.setModifiedBy(themeDisplay.getUserId());
                    leaveInformToTeamDetail.setGroupId(themeDisplay.getScopeGroupId());

                    leaveInformToTeamDetail.setLeaveRequestId(leaveRequestId);
                    leaveInformToTeamDetail.setEmployeeId(Long.parseLong(teamId));
                    leaveInformToTeamDetailLocalService.addLeaveInformToTeamDetail(leaveInformToTeamDetail);
                }
            }
        } catch (Exception e) {
            log.error("AddEditLeaveRequestMVCActionCommand >>> addLeaveInformDetails (MVCActionCommand) ::: Exception is: " + e.getMessage());
        }

    }

    private boolean updateLeaveBalance(long leaveRequestId, long employeeId, long leaveTypeMasterId) throws NoSuchLeaveBalanceException {
        boolean leaveBalanceUpdateStatus = false;
        List<LeaveDayType> listOfLeaveDayType = leaveDayTypeLocalService.findByLeaveRequestId(leaveRequestId);
        int noOfHoursInLeaveDayType = 0;
        for (LeaveDayType leaveDayTypeTemp : listOfLeaveDayType) {
            if (leaveDayTypeTemp.getIsHalfDay()) noOfHoursInLeaveDayType += 4;
            else noOfHoursInLeaveDayType += 8;
        }
        LeaveBalance leaveBalance = null;

        try {
            leaveBalance = leaveBalanceLocalService.findByEmployeeIdAndLeaveTypeMasterId(employeeId, leaveTypeMasterId);
        } catch (NoSuchLeaveBalanceException e) {
            log.error("AddEditLeaveRequestMVCActionCommand >>> updateLeaveBalance (MVCActionCommand) ::: Exception is: " + e.getMessage());
        }

        if (leaveBalance != null && (leaveBalance.getNoOfRemainingLeaves() - (noOfHoursInLeaveDayType / 8.0)) >= 0) {
            try {
                leaveBalance.setNoOfUsedLeaves(leaveBalance.getNoOfUsedLeaves() + (noOfHoursInLeaveDayType / 8.0));
                leaveBalance.setNoOfRemainingLeaves(leaveBalance.getNoOfRemainingLeaves() - (noOfHoursInLeaveDayType / 8.0));
                LeaveBalance updatedLeaveBalance = leaveBalanceLocalService.updateLeaveBalance(leaveBalance);
                log.error("AddEditLeaveRequestMVCActionCommand >>> updateLeaveBalance (MVCActionCommand) ::: Update Status is: " + leaveBalance.equals(updatedLeaveBalance));
                if (leaveBalance.equals(updatedLeaveBalance)) {
                    leaveBalanceUpdateStatus = true;
                }
            } catch (Exception e) {
                log.error("AddEditLeaveRequestMVCActionCommand >>> updateLeaveBalance (MVCActionCommand) ::: Exception is: " + e.getMessage());
            }
        }

        return leaveBalanceUpdateStatus;
    }
}
