package com.ax.hrms.hr.appraisal.process.hr.action;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.ax.hrms.hr.appraisal.process.constants.AxHrmsHrAppraisalProcessPortletKeys;
import com.ax.hrms.master.exception.NoSuchAppraisalStatusMasterException;
import com.ax.hrms.master.service.AppraisalStatusMasterLocalService;
import com.ax.hrms.model.AppraisalProcess;
import com.ax.hrms.model.AppraisalReminder;
import com.ax.hrms.model.EmployeeDetails;
import com.ax.hrms.service.AppraisalProcessLocalService;
import com.ax.hrms.service.AppraisalReminderLocalService;
import com.ax.hrms.service.EmployeeDetailsLocalService;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;

@Component(
        property = {
                "javax.portlet.name=" + AxHrmsHrAppraisalProcessPortletKeys.AX_HRMS_HR_APPRAISAL_PROCESS_WEB_PORTLET,
                "mvc.command.name=/addApprasialEmployee"
        },
        service = MVCActionCommand.class
)

public class AddApprasialEmployeeMVCActionCommand extends BaseMVCActionCommand{
	
	private static final Log log = LogFactoryUtil.getLog(AddApprasialEmployeeMVCActionCommand.class);
	@Reference
	AppraisalReminderLocalService appraisalReminderLocalService;
	
	@Reference
	AppraisalProcessLocalService appraisalProcessLocalService;
	
	@Reference
	AppraisalStatusMasterLocalService appraisalStatusMasterLocalService;
	
	@Reference
	EmployeeDetailsLocalService employeeDetailsLocalService;

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {

		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long employeeId = ParamUtil.getLong(actionRequest,"employeeId");
		
		 Calendar cal = new GregorianCalendar();
	       cal.setTime(new Date());
		 AppraisalReminder appraisalReminder = appraisalReminderLocalService.createAppraisalReminder(CounterLocalServiceUtil.increment(AppraisalReminder.class.getName()));
         //Audit fields
         appraisalReminder.setCreateDate(new Date());
         appraisalReminder.setModifiedDate(new Date());
         // Main Field
         appraisalReminder.setAppraisalRemainderMonth(cal.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.getDefault()));
         appraisalReminder.setAppraisalRemainderYear(String.valueOf(cal.get(Calendar.YEAR)));
         appraisalReminder.setEmployeeId(employeeId);


         AppraisalProcess appraisalProcess = appraisalProcessLocalService.createAppraisalProcess(CounterLocalServiceUtil.increment(AppraisalProcess.class.getName()));
         appraisalProcess.setIsSelfEvalutionFormFilled(false);
         appraisalProcess.setIsSelfEvalutionFormSent(false);
         appraisalProcess.setArePeerEvaluationFormFilled(false);
         appraisalProcess.setArePeerEvaluationFormSent(false); 
         appraisalProcess.setIsManagementFormSent(false);
         appraisalProcess.setIsManagementFormFilled(false);
         appraisalProcess.setIsMeetingScheduled(false);
         appraisalProcess.setIsMeetingDone(false);
         appraisalProcess.setIsSalaryUpdated(false);
         
         // add appraisal date in employee details table
         
         EmployeeDetails employeeDetails = employeeDetailsLocalService.getEmployeeDetails(employeeId);
         employeeDetails.setAppraisalDate(new Date());
         employeeDetailsLocalService.updateEmployeeDetails(employeeDetails);

         try {
             appraisalProcess.setStatus(appraisalStatusMasterLocalService.findBystatus("Pending").getAppraisalStatusMasterId());

         } catch (NoSuchAppraisalStatusMasterException e) {
             log.error("UNABLE TO FETCH APPRAISAL STATUS MASTER!");
         }
         appraisalProcessLocalService.addAppraisalProcess(appraisalProcess);

         appraisalReminder.setAppraisalProcessId(appraisalProcess.getAppraisalProcessId());
         //adding records to database.
         appraisalReminderLocalService.addAppraisalReminder(appraisalReminder);
         
         actionResponse.sendRedirect(PortalUtil.getLayoutFullURL(themeDisplay));
	}

}
