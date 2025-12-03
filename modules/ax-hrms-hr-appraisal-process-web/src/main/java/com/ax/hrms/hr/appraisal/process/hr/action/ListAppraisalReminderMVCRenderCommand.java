package com.ax.hrms.hr.appraisal.process.hr.action;


import com.ax.hrms.common.api.api.AxHrmsCommonApi;
import com.ax.hrms.hr.appraisal.process.constants.AxHrmsHrAppraisalProcessPortletKeys;
import com.ax.hrms.hr.appraisal.process.constants.AxHrmsHrAppraisalReminderHrConstants;
import com.ax.hrms.hr.appraisal.process.dto.EmployeeAppraisalReminderDto;
import com.ax.hrms.link.config.configuration.LinksConfiguration;
import com.ax.hrms.model.EmployeeDetails;
import com.ax.hrms.service.AppraisalReminderLocalService;
import com.ax.hrms.service.AppraisalReminderLocalServiceUtil;
import com.ax.hrms.service.EmployeeDetailsLocalService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
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
                "javax.portlet.name=" + AxHrmsHrAppraisalProcessPortletKeys.AX_HRMS_HR_APPRAISAL_PROCESS_REMINDER_WEB_PORTLET,
                "mvc.command.name=/"
        },
        service = MVCRenderCommand.class
)
public class ListAppraisalReminderMVCRenderCommand implements MVCRenderCommand {
    Log log = LogFactoryUtil.getLog(ListAppraisalReminderMVCRenderCommand.class.getName());
    @Reference
    AppraisalReminderLocalService appraisalReminderLocalService;

    @Reference
    LinksConfiguration linksConfiguration;

    @Reference
    AxHrmsCommonApi axHrmsCommonApi;
    @Reference
    EmployeeDetailsLocalService employeeDetailsLocalService;
    @Override
    public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
        List<EmployeeAppraisalReminderDto> employeeAppraisalReminderDtoList = new ArrayList<>();
        appraisalReminderLocalService.getAppraisalReminders(-1,-1).forEach(appraisalReminder -> {

            EmployeeAppraisalReminderDto employeeAppraisalReminderDto = new EmployeeAppraisalReminderDto();
            try {
                EmployeeDetails employeeDetails = employeeDetailsLocalService.getEmployeeDetails(appraisalReminder.getEmployeeId());
                employeeAppraisalReminderDto.setEmployeeFullName(employeeDetails.getFirstName() + " " + employeeDetails.getLastName());
                employeeAppraisalReminderDto.setAppraisalDate(formatDate(convertToCurrentYear(employeeDetails.getJoiningDate())));
                employeeAppraisalReminderDto.setNoOfYearsCompleted(calculateYearsDifference(employeeDetails.getJoiningDate(),new Date()));

            } catch (PortalException e) {
                log.error("Cannot find employee from appraisal Reminder!");
            }

            StringBuilder departments = new StringBuilder();
            axHrmsCommonApi.getDepartmentMastersFromEmployeeId(appraisalReminder.getEmployeeId()).forEach(departmentMaster -> departments.append(departmentMaster.getDepartmentName()).append(", "));
            departments.delete(departments.length()-2, departments.length());
            employeeAppraisalReminderDto.setDepartments(departments.toString());


            StringBuilder designations = new StringBuilder();
            axHrmsCommonApi.getDesignationMastersFromEmployeeId(appraisalReminder.getEmployeeId()).forEach(designationMaster -> designations.append(designationMaster.getDesignationName()).append(", "));
            designations.delete(designations.length()-2, designations.length());
            employeeAppraisalReminderDto.setDesignations(designations.toString());

            employeeAppraisalReminderDtoList.add(employeeAppraisalReminderDto);

        });
        renderRequest.setAttribute(AxHrmsHrAppraisalReminderHrConstants.APPRAISAL_REMINDER_LIST, employeeAppraisalReminderDtoList);
        renderRequest.setAttribute(AxHrmsHrAppraisalReminderHrConstants.APPRAISAL_PROCESS_PAGE_LINK, linksConfiguration.appraisalProcessManagementPageLink());
        renderRequest.setAttribute(AxHrmsHrAppraisalReminderHrConstants.COUNT, AppraisalReminderLocalServiceUtil.getAppraisalRemindersCount());

        return AxHrmsHrAppraisalReminderHrConstants.APPRAISAL_REMINDER_JSP;
    }


    public static Date convertToCurrentYear(Date oldDate) {
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

    public static String formatDate(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat(AxHrmsHrAppraisalReminderHrConstants.DATE_FORMAT_DATE_MONTH_YEAR);
        return sdf.format(date);
    }

    public static int calculateYearsDifference(Date startDate, Date endDate) {
        Calendar startCalendar = Calendar.getInstance();
        startCalendar.setTime(startDate);
        int startYear = startCalendar.get(Calendar.YEAR);

        Calendar endCalendar = Calendar.getInstance();
        endCalendar.setTime(endDate);
        int endYear = endCalendar.get(Calendar.YEAR);

        return endYear - startYear;
    }
}
