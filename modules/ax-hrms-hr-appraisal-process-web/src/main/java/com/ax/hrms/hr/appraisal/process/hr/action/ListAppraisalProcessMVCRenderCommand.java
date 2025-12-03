package com.ax.hrms.hr.appraisal.process.hr.action;


import com.ax.hrms.common.api.api.AxHrmsCommonApi;
import com.ax.hrms.hr.appraisal.process.constants.AxHrmsHrAppraisalProcessHrConstants;
import com.ax.hrms.hr.appraisal.process.constants.AxHrmsHrAppraisalProcessPortletKeys;
import com.ax.hrms.hr.appraisal.process.dto.EmployeeAppraisalProcessDto;
import com.ax.hrms.master.service.AppraisalStatusMasterLocalService;
import com.ax.hrms.model.AppraisalMeeting;
import com.ax.hrms.model.AppraisalMeetingInvitees;
import com.ax.hrms.model.AppraisalProcess;
import com.ax.hrms.model.EmployeeDetails;
import com.ax.hrms.service.*;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Author: Nivid Koradiya
 */
@Component(
        property = {
                "javax.portlet.name=" + AxHrmsHrAppraisalProcessPortletKeys.AX_HRMS_HR_APPRAISAL_PROCESS_WEB_PORTLET,
                "mvc.command.name=/"
        },
        service = MVCRenderCommand.class
)
public class ListAppraisalProcessMVCRenderCommand implements MVCRenderCommand {
    Log log = LogFactoryUtil.getLog(ListAppraisalProcessMVCRenderCommand.class.getName());
    @Reference
    AppraisalReminderLocalService appraisalReminderLocalService;

    @Reference
    AxHrmsCommonApi axHrmsCommonApi;

    @Reference
    UserLocalService userLocalService;

    @Reference
    AppraisalProcessLocalService appraisalProcessLocalService;

    @Reference
    EmployeeDetailsLocalService employeeDetailsLocalService;

    @Reference
    AppraisalStatusMasterLocalService appraisalStatusMasterLocalService;

    @Reference
    AppraisalMeetingLocalService appraisalMeetingLocalService;

    @Reference
    AppraisalMeetingInviteesLocalService appraisalMeetingInviteesLocalService;

    @Override
    public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
            List<EmployeeAppraisalProcessDto> appraisalProcessDtoList = new ArrayList<>();
        ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);

        boolean isHr = axHrmsCommonApi.isRolePerson(themeDisplay,"HR Admin");
        if(!isHr){
            renderRequest.setAttribute("isHr", false);
        }
        else{
            renderRequest.setAttribute("isHr", true);
        }

        //FOR LOOP
        appraisalReminderLocalService.getAppraisalReminders(-1, -1).forEach(appraisalReminder -> {

            EmployeeAppraisalProcessDto employeeAppraisalProcessDto = new EmployeeAppraisalProcessDto();
            try {
                EmployeeDetails employeeDetails = employeeDetailsLocalService.getEmployeeDetails(appraisalReminder.getEmployeeId());
                employeeAppraisalProcessDto.setEmployeeFullName(employeeDetails.getFirstName() + " " + employeeDetails.getLastName());
                employeeAppraisalProcessDto.setAppraisalDate(formatDate(convertOldDateToCurrentYearDate(employeeDetails.getJoiningDate())));
                employeeAppraisalProcessDto.setNoOfYearsCompleted(calculateYearsDifference(employeeDetails.getJoiningDate(), new Date()));

            } catch (PortalException e) {
                log.error("Cannot find employee from appraisal Reminder!");
            }

            StringBuilder departments = new StringBuilder();
            axHrmsCommonApi.getDepartmentMastersFromEmployeeId(appraisalReminder.getEmployeeId()).forEach(departmentMaster -> departments.append(departmentMaster.getDepartmentName()).append(", "));
            departments.delete(departments.length() - 2, departments.length());
            employeeAppraisalProcessDto.setDepartments(departments.toString());


            StringBuilder designations = new StringBuilder();
            axHrmsCommonApi.getDesignationMastersFromEmployeeId(appraisalReminder.getEmployeeId()).forEach(designationMaster -> designations.append(designationMaster.getDesignationName()).append(", "));
            designations.delete(designations.length() - 2, designations.length());
            employeeAppraisalProcessDto.setDesignations(designations.toString());

            try {
                AppraisalProcess appraisalProcess = appraisalProcessLocalService.getAppraisalProcess(appraisalReminder.getAppraisalProcessId());
                employeeAppraisalProcessDto.setAppraisalStatus(getAppraisalStatusByProcessId(appraisalProcess.getAppraisalProcessId()));            // for maintaining the status of the appraisal process
                employeeAppraisalProcessDto.setActionStatus(getActionStatusFromProcess(appraisalProcess));

                // SETTING THE TIME AND DATE FOR MEETING IF MEETING IS AVAILABLE:
                if (employeeAppraisalProcessDto.getActionStatus() == 4) {
                    AppraisalMeeting appraisalMeeting = appraisalMeetingLocalService.findByAppraisalProcessId(appraisalProcess.getAppraisalProcessId());
                    List<AppraisalMeetingInvitees> appraisalMeetingInvitees = new ArrayList<>();
                    appraisalMeetingInviteesLocalService.getAppraisalMeetingInviteeses(-1, -1).forEach(appraisalMeetingz -> {
                        if (appraisalMeetingz.getAppraisalMeetingId() == appraisalMeeting.getAppraisalMeetingId()) {
                            appraisalMeetingInvitees.add(appraisalMeetingz);
                        }
                    });
                    StringBuilder ami = new StringBuilder();
                    int i = 1;
                    for (AppraisalMeetingInvitees appraisalMeetingInvitee : appraisalMeetingInvitees) {
                        try {
                            long lrUserId = employeeDetailsLocalService.getEmployeeDetails(appraisalMeetingInvitee.getEmployeeId()).getLrUserId();
                            ami.append(String.valueOf(lrUserId));
                            if (i != appraisalMeetingInvitees.size()) {
                                ami.append(",");
                            }
                            i++;
                        } catch (PortalException e) {
                            log.error("Cannot get LR User Id");
                        }
                    }
                    employeeAppraisalProcessDto.setListOfAttendees(ami.toString());

                    SimpleDateFormat dateFormat = new SimpleDateFormat(AxHrmsHrAppraisalProcessHrConstants.DATE_FORMAT);
                    String formattedDate = dateFormat.format(appraisalMeeting.getMeetingDate());
                    SimpleDateFormat timeFormat = new SimpleDateFormat(AxHrmsHrAppraisalProcessHrConstants.TIME_FORMAT);
                    String formattedTime = timeFormat.format(appraisalMeeting.getMeetingDate());

                    employeeAppraisalProcessDto.setAppraisalMeetingId(appraisalMeeting.getAppraisalMeetingId());
                    employeeAppraisalProcessDto.setAppraisalMeetingDate(formattedDate);
                    employeeAppraisalProcessDto.setAppraisalMeetingTime(formattedTime);
                }

            } catch (PortalException e) {
                log.error("ERROR Getting the appraisal process with appraisal reminder!");
            }

            employeeAppraisalProcessDto.setAppraisalProcessId(appraisalReminder.getAppraisalProcessId());

            appraisalProcessDtoList.add(employeeAppraisalProcessDto);


        });
        List<User> listOfFilteredEmployeeDetails = new ArrayList<>();
        List<User> listOfUsers = userLocalService.getUsers(-1, -1);
        for (User employeeDetails : listOfUsers) {

            try {
                long employeeRoleId = RoleLocalServiceUtil.getRole(themeDisplay.getCompanyId(), AxHrmsHrAppraisalProcessHrConstants.EMPLOYEE).getRoleId();
                long[] userRoles = userLocalService.getUserById(employeeDetails.getUserId()).getRoleIds();
                for (long userRole : userRoles) {
                    if (userRole == employeeRoleId)
                        listOfFilteredEmployeeDetails.add(employeeDetails);
                }
            } catch (Exception e) {
                log.error("ListAppraisalProcessMVCRenderCommand >>> render ::: Exception: " + e.getMessage());
            }

        }
        List<EmployeeDetails> employeeList = employeeDetailsLocalService.findByIsTerminated(false);
        
        renderRequest.setAttribute("userList", listOfFilteredEmployeeDetails);
        renderRequest.setAttribute("employeeList", employeeList);
        renderRequest.setAttribute(AxHrmsHrAppraisalProcessHrConstants.APPRAISAL_PROCESS_LIST, appraisalProcessDtoList);
        renderRequest.setAttribute(AxHrmsHrAppraisalProcessHrConstants.COUNT, AppraisalReminderLocalServiceUtil.getAppraisalRemindersCount());

        return AxHrmsHrAppraisalProcessHrConstants.APPRAISAL_PROCESS_JSP;
    }


    private Date convertOldDateToCurrentYearDate(Date oldDate) {
        Calendar currentCalendar = Calendar.getInstance();
        int currentYear = currentCalendar.get(Calendar.YEAR);

        Calendar oldCalendar = Calendar.getInstance();
        oldCalendar.setTime(oldDate);
        int dayOfMonth = oldCalendar.get(Calendar.DAY_OF_MONTH);
        int month = oldCalendar.get(Calendar.MONTH); // Month is 0-based in Calendar class

        Calendar newCalendar = Calendar.getInstance();
        newCalendar.set(currentYear, month, dayOfMonth);

        return newCalendar.getTime();
    }

    private String formatDate(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat(AxHrmsHrAppraisalProcessHrConstants.DATE_FORMAT_DATE_MONTH_YEAR);
        return sdf.format(date);
    }

    private int calculateYearsDifference(Date startDate, Date endDate) {
        Calendar startCalendar = Calendar.getInstance();
        startCalendar.setTime(startDate);
        int startYear = startCalendar.get(Calendar.YEAR);

        Calendar endCalendar = Calendar.getInstance();
        endCalendar.setTime(endDate);
        int endYear = endCalendar.get(Calendar.YEAR);

        return endYear - startYear;
    }

    private String getAppraisalStatusByProcessId(long appraisalProcessId) throws PortalException {
        return appraisalStatusMasterLocalService.getAppraisalStatusMaster(appraisalProcessLocalService.getAppraisalProcess(appraisalProcessId).getStatus()).getStatus();
    }

    private int getActionStatusFromProcess(AppraisalProcess appraisalProcess) {
        if (appraisalProcess.getIsSalaryUpdated()) {
            return 5;
        } else if (appraisalProcess.isIsMeetingScheduled()) {
            return 4;
        } else if (appraisalProcess.getIsManagementFormSent()) {
            return 3;
        } else if (appraisalProcess.getArePeerEvaluationFormSent()) {
            return 2;
        } else if (appraisalProcess.getIsSelfEvalutionFormSent()) {
            return 1;
        } else {
            return 0;
        }
    }
}
