package com.ax.hrms.leave.management.employee.web.action;

import com.ax.hrms.exception.NoSuchLeaveBalanceException;
import com.ax.hrms.leave.management.web.constants.AxHrmsLeaveManagementSystemWebPortletKeys;
import com.ax.hrms.leave.management.web.constants.AxHrmsLeaveManagementWebPortletConstants;
import com.ax.hrms.master.service.LeaveCompensatoryStatusMasterLocalService;
import com.ax.hrms.model.LeaveBalance;
import com.ax.hrms.model.LeaveDayType;
import com.ax.hrms.model.LeaveInformToTeamDetail;
import com.ax.hrms.model.LeaveRequest;
import com.ax.hrms.service.EmployeeDetailsLocalService;
import com.ax.hrms.service.LeaveBalanceLocalService;
import com.ax.hrms.service.LeaveDayTypeLocalService;
import com.ax.hrms.service.LeaveInformToTeamDetailLocalService;
import com.ax.hrms.service.LeaveRequestLocalService;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author krish.moradiya
 * @implNote : Add Leave Request in leave balance and other...
 */
@Component(
        immediate = true,
        property = {
                "javax.portlet.name="+ AxHrmsLeaveManagementSystemWebPortletKeys.AXHRMS_EMPLOYEE_LEAVE_MANAGEMENT_SYSTEM_WEB_PORTLET,
                "mvc.command.name="+AxHrmsLeaveManagementWebPortletConstants.ADD_LEAVE_REQUEST_MVC_COMMAND_NAME
        },
        service = MVCActionCommand.class
)

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

    
    @Override
    protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
        log.info("AddEditLeaveRequestMVCActionCommand >>> doProcessAction ::: Add Edit Leave Request Action Method Called");

        super.hideDefaultErrorMessage(actionRequest);
        super.hideDefaultSuccessMessage(actionRequest);

        long leaveRequestId = ParamUtil.getLong(actionRequest, AxHrmsLeaveManagementWebPortletConstants.LEAVE_REQUEST_ID_VAR, AxHrmsLeaveManagementWebPortletConstants.DEFAULT_LONG_VALUE);

        LeaveRequest leaveRequest = setLeaveRequestData(actionRequest,leaveRequestId);
        
        if(leaveRequest != null) {
        	try {        	
            	addLeaveRequestData(actionRequest, leaveRequest);
            	SessionMessages.add(actionRequest, AxHrmsLeaveManagementWebPortletConstants.LEAVE_REQUEST_INSERTED_MESSAGE_KEY);
            }catch(Exception e) {
            	SessionErrors.add(actionRequest, AxHrmsLeaveManagementWebPortletConstants.LEAVE_REQUEST_NOT_INSERTED_MESSAGE_KEY);
            }
        }else {
        	SessionErrors.add(actionRequest, AxHrmsLeaveManagementWebPortletConstants.LEAVE_REQUEST_NOT_INSERTED_MESSAGE_KEY);
        }

        

    }
    private void addLeaveRequestData(ActionRequest actionRequest,LeaveRequest leaveRequest) {
        leaveRequestLocalService.addLeaveRequest(leaveRequest);
        SessionMessages.add(actionRequest, AxHrmsLeaveManagementWebPortletConstants.LEAVE_REQUEST_INSERTED_MESSAGE_KEY);
    }

    private LeaveRequest setLeaveRequestData(ActionRequest actionRequest, long leaveRequestId) throws NullPointerException {

    	boolean updateLeaveStatus = false;
        

        ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
        long employeeId = ParamUtil.getLong(actionRequest,AxHrmsLeaveManagementWebPortletConstants.EMPLOYEE_ID_PARAM_NAME,AxHrmsLeaveManagementWebPortletConstants.DEFAULT_LONG_VALUE);
        String reason = ParamUtil.getString(actionRequest,AxHrmsLeaveManagementWebPortletConstants.REASON,null);
        long leaveTypeMasterId = ParamUtil.getLong(actionRequest, AxHrmsLeaveManagementWebPortletConstants.LEAVE_TYPE,AxHrmsLeaveManagementWebPortletConstants.DEFAULT_LONG_VALUE);

        DateFormat dateFormat = new SimpleDateFormat(AxHrmsLeaveManagementWebPortletConstants.LIFERAY_DB_DATETIME_FORMAT);
        String start = ParamUtil.getString(actionRequest,AxHrmsLeaveManagementWebPortletConstants.START_DATE);
        String end = ParamUtil.getString(actionRequest,AxHrmsLeaveManagementWebPortletConstants.END_DATE);
        
        Date startDate = null;
        Date endDate = null;
		try {
			startDate = dateFormat.parse(start+AxHrmsLeaveManagementWebPortletConstants.DEFAULT_TIME);
			endDate = dateFormat.parse(end+AxHrmsLeaveManagementWebPortletConstants.DEFAULT_TIME);
		} catch (ParseException e1) {
			log.info("AddEditLeaveRequestMVCActionCommand >>> setLeaveRequestData ::: Exception: "+e1.getMessage());
		}
		
        
        Date[] leaveDatesArray = getDatesBetween(startDate,endDate);
        int[] leaveDates = new int[leaveDatesArray.length];
        int count = 0;
        for(Date date : leaveDatesArray){
            leaveDates[count] = date.getDate();
            log.info("AddEditLeaveRequestMVCActionCommand >>> setLeaveRequestData ::: leaveDate: "+leaveDates[count]);
            count++;
        }
        LeaveRequest leaveRequest = null;
        if(leaveRequestId > 0) {
            try {
                leaveRequest = leaveRequestLocalService.getLeaveRequest(leaveRequestId);
            } catch (PortalException e) {
                log.error("AddEditLeaveRequestMVCActionCommand >>> setLeaveRequestData (MVCActionCommand) ::: Exception is: "+e.getMessage());
            }
        }
        else {
            leaveRequest = leaveRequestLocalService.createLeaveRequest(CounterLocalServiceUtil.increment(LeaveRequest.class.getName()));
            leaveRequest.setCreatedBy(themeDisplay.getUserId());
        }
        try{
            if(leaveRequest != null){
                leaveRequest.setModifiedBy(themeDisplay.getUserId());
                leaveRequest.setGroupId(themeDisplay.getScopeGroupId());
                leaveRequest.setEmployeeId(employeeId);
                leaveRequest.setStartDateTime(startDate);
                leaveRequest.setEndDateTime(endDate);
                leaveRequest.setReason(reason);
                leaveRequest.setLeaveTypeMasterId(leaveTypeMasterId);
                leaveRequest.setLeaveCompensatoryStatusMasterId(leaveCompensatoryStatusMasterLocalService.findByLeaveCompensatoryStatusName(AxHrmsLeaveManagementWebPortletConstants.PENDING).getLeaveCompensatoryStatusMasterId());
                leaveRequest.setDateOfRequest(new Date());

                addLeaveDayTypeData(leaveDates,actionRequest,dateFormat,leaveRequest.getLeaveRequestId(),themeDisplay);
                addLeaveInformDetails(leaveRequest.getLeaveRequestId(),actionRequest,themeDisplay);
                updateLeaveStatus = updateLeaveBalance(leaveRequest.getLeaveRequestId(), employeeId, leaveTypeMasterId);
            }

        }catch(NullPointerException nullException) {
        	log.error("AddEditLeaveRequestMVCActionCommand >>> setLeaveRequestData (MVCActionCommand) ::: NullPointerException is: "+nullException.getMessage());
        }
        catch(Exception e){
            log.error("AddEditLeaveRequestMVCActionCommand >>> setLeaveRequestData (MVCActionCommand) ::: Exception is: "+e.getMessage());
        }
        if(updateLeaveStatus)
        	return leaveRequest;
        else
        	return null;
    }

    public static Date[] getDatesBetween(Date startDate, Date endDate) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(startDate);

        List<Date> datesBetween = new ArrayList<>();
        
        while(calendar.getTime().compareTo(endDate) < 0 || calendar.getTime().compareTo(endDate) == 0) {
            Date result = calendar.getTime();
            
            if(calendar.getTime().getDay() != 6 && calendar.getTime().getDay() != 0)
            	datesBetween.add(result);
            
            calendar.add(Calendar.DATE, 1);
        }

        return datesBetween.toArray(new Date[0]);
    }

    private void addLeaveDayTypeData(int[] leaveDates, ActionRequest actionRequest, DateFormat dateFormat,long leaveRequestId,ThemeDisplay themeDisplay){
        LeaveDayType leaveDayType = null;
        for(int i : leaveDates){
        	String actualDate = "";
        	if(i/10 == 0)
        		actualDate = "0"+i;
        	else
        		actualDate = ""+i;

            leaveDayType = leaveDayTypeLocalService.createLeaveDayType(CounterLocalServiceUtil.increment(LeaveDayType.class.getName()));
            String dateString = ParamUtil.getString(actionRequest, AxHrmsLeaveManagementWebPortletConstants.DAY +actualDate+ AxHrmsLeaveManagementWebPortletConstants.DATE);
            Date leaveDate = null;
    		try {
    			leaveDate = dateFormat.parse(dateString+AxHrmsLeaveManagementWebPortletConstants.DEFAULT_TIME);
    		} catch (ParseException e1) {
    			log.error("AddEditLeaveRequestMVCActionCommand >>> addLeaveDayTypeData (MVCActionCommand) ::: Exception is: "+e1.getMessage());
    		} 
            boolean isHalf = ParamUtil.getBoolean(actionRequest,AxHrmsLeaveManagementWebPortletConstants.DAY +actualDate+AxHrmsLeaveManagementWebPortletConstants.IS_HALF,false);
            boolean isFirstHalf = false;
            if(isHalf){
                isFirstHalf = (ParamUtil.getString(actionRequest,AxHrmsLeaveManagementWebPortletConstants.DAY +actualDate+AxHrmsLeaveManagementWebPortletConstants.HALF_TYPE,null)).equals(AxHrmsLeaveManagementWebPortletConstants.FIRST_HALF) ? true : false;
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
    
    private void addLeaveInformDetails(long leaveRequestId,ActionRequest actionRequest,ThemeDisplay themeDisplay) {
    	String teamIdString = ParamUtil.getString(actionRequest, AxHrmsLeaveManagementWebPortletConstants.TEAM_ID, GetterUtil.DEFAULT_STRING);

    	String[] teamIds = (!teamIdString.equals("")) ? teamIdString.split(",") : new String[0];
        try{
            if(!teamIdString.equals("")){
                for(String teamId: teamIds) {
                    LeaveInformToTeamDetail leaveInformToTeamDetail = leaveInformToTeamDetailLocalService.createLeaveInformToTeamDetail(CounterLocalServiceUtil.increment(LeaveInformToTeamDetail.class.getName()));
                    leaveInformToTeamDetail.setCreatedBy(themeDisplay.getUserId());
                    leaveInformToTeamDetail.setModifiedBy(themeDisplay.getUserId());
                    leaveInformToTeamDetail.setGroupId(themeDisplay.getScopeGroupId());

                    leaveInformToTeamDetail.setLeaveRequestId(leaveRequestId);
                    leaveInformToTeamDetail.setEmployeeId(Long.parseLong(teamId));
                    leaveInformToTeamDetailLocalService.addLeaveInformToTeamDetail(leaveInformToTeamDetail);
                }
            }
        }catch(Exception e){
            log.error("AddEditLeaveRequestMVCActionCommand >>> addLeaveInformDetails (MVCActionCommand) ::: Exception is: "+e.getMessage());
        }

    }
    
    private boolean updateLeaveBalance(long leaveRequestId,long employeeId,long leaveTypeMasterId) throws NoSuchLeaveBalanceException {
    	boolean leaveBalanceUpdateStatus = false;
    	List<LeaveDayType> listOfLeaveDayType = leaveDayTypeLocalService.findByLeaveRequestId(leaveRequestId);
        int noOfHoursInLeaveDayType = 0;
        for(LeaveDayType leaveDayTypeTemp : listOfLeaveDayType){
            if(leaveDayTypeTemp.getIsHalfDay())
                noOfHoursInLeaveDayType += 4;
            else
                noOfHoursInLeaveDayType += 8;
        }
    	LeaveBalance leaveBalance = null;
    	
    	try {
			leaveBalance = leaveBalanceLocalService.findByEmployeeIdAndLeaveTypeMasterId(employeeId, leaveTypeMasterId);
		} catch (NoSuchLeaveBalanceException e) {
			log.error("AddEditLeaveRequestMVCActionCommand >>> updateLeaveBalance (MVCActionCommand) ::: Exception is: "+e.getMessage());
		}

        if(leaveBalance != null && (leaveBalance.getNoOfRemainingLeaves()-(noOfHoursInLeaveDayType/8.0)) >= 0) {
            try {
                leaveBalance.setNoOfUsedLeaves(leaveBalance.getNoOfUsedLeaves()+(noOfHoursInLeaveDayType/8.0));
                leaveBalance.setNoOfRemainingLeaves(leaveBalance.getNoOfRemainingLeaves()-(noOfHoursInLeaveDayType/8.0));
                LeaveBalance updatedLeaveBalance = leaveBalanceLocalService.updateLeaveBalance(leaveBalance);
                log.error("AddEditLeaveRequestMVCActionCommand >>> updateLeaveBalance (MVCActionCommand) ::: Update Status is: "+leaveBalance.equals(updatedLeaveBalance));
                if(leaveBalance.equals(updatedLeaveBalance)) {
                    leaveBalanceUpdateStatus = true;
                }
            }catch(Exception e) {
                log.error("AddEditLeaveRequestMVCActionCommand >>> updateLeaveBalance (MVCActionCommand) ::: Exception is: "+e.getMessage());
            }
        }
    	
    	return leaveBalanceUpdateStatus;
    }
}
