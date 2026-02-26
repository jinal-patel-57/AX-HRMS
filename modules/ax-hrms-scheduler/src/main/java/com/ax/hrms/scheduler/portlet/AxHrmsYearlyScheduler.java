package com.ax.hrms.scheduler.portlet;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import com.ax.hrms.common.api.api.AxHrmsCommonApi;
import com.ax.hrms.constants.AxHrmsBirthdayWebPortletConstants;
import com.ax.hrms.mail.template.config.configuration.MailTemplateConfiguration;
import com.ax.hrms.master.model.DepartmentMaster;
import com.ax.hrms.master.model.DesignationMaster;
import com.ax.hrms.master.service.DesignationMasterLocalService;
import com.ax.hrms.model.EmployeeDesignation;
import com.ax.hrms.model.EmployeeDetails;
import com.ax.hrms.notification.template.config.configuration.NotificationTemplateConfiguration;
import com.ax.hrms.service.EmployeeDesignationLocalService;
import com.ax.hrms.service.EmployeeDetailsLocalService;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.util.PrefsPropsUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.Validator;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.ax.hrms.master.exception.NoSuchLeavePolicyMasterException;
import com.ax.hrms.master.model.LeavePolicyMaster;
import com.ax.hrms.master.service.LeavePolicyMasterLocalService;
import com.ax.hrms.model.LeaveBalance;
import com.ax.hrms.model.LeaveBalanceHistory;
import com.ax.hrms.service.LeaveBalanceHistoryLocalService;
import com.ax.hrms.service.LeaveBalanceLocalService;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.dispatch.executor.BaseDispatchTaskExecutor;
import com.liferay.dispatch.executor.DispatchTaskExecutor;
import com.liferay.dispatch.executor.DispatchTaskExecutorOutput;
import com.liferay.dispatch.model.DispatchTrigger;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.service.GroupLocalServiceUtil;
import com.liferay.portal.kernel.util.PortalUtil;

@Component(
        property = {
                "dispatch.task.executor.name=Ax Hrms Yearly Scheduler", "dispatch.task.executor.type=Ax Hrms Yearly Scheduler"
        },
        service = DispatchTaskExecutor.class
)

public class AxHrmsYearlyScheduler extends BaseDispatchTaskExecutor{
	private static final Log log = LogFactoryUtil.getLog(AxHrmsYearlyScheduler.class);
	
	@Reference
	private LeaveBalanceHistoryLocalService leaveBalanceHistoryLocalService;
	
	@Reference
	private LeaveBalanceLocalService leaveBalanceLocalService;
	
	@Reference
	private LeavePolicyMasterLocalService leavePolicyMasterLocalService;

	@Reference
	private EmployeeDetailsLocalService employeeDetailsLocalService;

	@Reference
	private AxHrmsCommonApi axHrmsCommonApi;

	@Reference
	private EmployeeDesignationLocalService employeeDesignationLocalService;

	@Reference
	private DesignationMasterLocalService designationMasterLocalService;

	@Reference
	private MailTemplateConfiguration mailTemplateConfiguration;

	@Override
	public String getName() {
		return "Ax Hrms Yearly Scheduler";
	}

	@Override
	public void doExecute(DispatchTrigger dispatchTrigger, DispatchTaskExecutorOutput dispatchTaskExecutorOutput)
			throws Exception {
		try {
		addLeaveEntryInHistoryTable();
		updateLeaveBalance();

		}catch(Exception e) {
			log.info("Error:"+ e.getMessage());
			try {
				Group group = GroupLocalServiceUtil.fetchGroup(PortalUtil.getDefaultCompanyId(), "Guest");
				String fromName = PrefsPropsUtil.getString(group.getCompanyId(), PropsKeys.ADMIN_EMAIL_FROM_NAME);
				String fromEmailAddress = PrefsPropsUtil.getString(group.getCompanyId(), PropsKeys.ADMIN_EMAIL_FROM_ADDRESS);
				sendMailAndNotificationToHr(fromName, fromEmailAddress, e.getMessage(), group.getCompanyId());
				log.info("mail sent to HR Admin related to Yearly Scheduler Fail.");
			}catch (Exception e1){
				e1.printStackTrace();
			}
		}
	}
	
	private void addLeaveEntryInHistoryTable() {
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
        Group group = GroupLocalServiceUtil.fetchGroup(PortalUtil.getDefaultCompanyId(), "Guest");

		
		List<LeaveBalance> leaveBalanceList = leaveBalanceLocalService.findByYear(year-1);
		
		for(LeaveBalance leaveBalance: leaveBalanceList) {
		LeaveBalanceHistory leaveBalanceHistory = leaveBalanceHistoryLocalService.createLeaveBalanceHistory(CounterLocalServiceUtil.increment(LeaveBalance.class.getName()));
		leaveBalanceHistory.setCompanyId(group.getCompanyId());
		leaveBalanceHistory.setCreateDate(new Date());
		leaveBalanceHistory.setModifiedDate(new Date());
		leaveBalanceHistory.setGroupId(group.getGroupId());
		
		leaveBalanceHistory.setEmployeeId(leaveBalance.getEmployeeId());
		leaveBalanceHistory.setLeaveBalanceId(leaveBalance.getLeaveBalanceId());
		leaveBalanceHistory.setLeaveTypeMasterId(leaveBalance.getLeaveTypeMasterId());
		leaveBalanceHistory.setNoOfRemainingLeaves(leaveBalance.getNoOfRemainingLeaves());
		leaveBalanceHistory.setNoOfUsedLeaves(leaveBalance.getNoOfUsedLeaves());
		leaveBalanceHistory.setYear(leaveBalance.getYear());
		leaveBalanceHistoryLocalService.addLeaveBalanceHistory(leaveBalanceHistory);
		
		}
		
	}
	
	
	private void updateLeaveBalance() throws NoSuchLeavePolicyMasterException {
	        Calendar cal = Calendar.getInstance();
	        int year = cal.get(Calendar.YEAR);
	        
	        List<LeavePolicyMaster> leavePolicyMasterList = leavePolicyMasterLocalService.findByYear(year);
	        
	        for (LeavePolicyMaster leavePolicy : leavePolicyMasterList) {
	            List<LeaveBalance> leaveBalanceList = leaveBalanceLocalService.findByLeaveTypeMasterIdAndYear(leavePolicy.getLeaveTypeMasterId(), year-1);
	            
	            for (LeaveBalance leaveBalance : leaveBalanceList) {
	                double updatedRemainingLeaves;
	                
	                if (leavePolicy.getIsCarryForward()) {
	                    double remainingLeave = leaveBalance.getNoOfRemainingLeaves();
	                    double annualAccrual = Math.round(leavePolicy.getAccrualRate() * 12);
	                    
	                    if (leavePolicy.getIsCheckMax()) {
	                        double totalLeave = remainingLeave + annualAccrual;
	                        updatedRemainingLeaves = Math.min(totalLeave, leavePolicy.getMaximumBalance());
	                    } else {
	                        updatedRemainingLeaves = remainingLeave + annualAccrual;
	                    }
	                } else {
	                    updatedRemainingLeaves = Math.round(leavePolicy.getAccrualRate() * 12);
	                }
	                
	                leaveBalance.setNoOfRemainingLeaves(updatedRemainingLeaves);
	                leaveBalance.setNoOfUsedLeaves(0);
	                leaveBalance.setModifiedDate(new Date());
	                leaveBalance.setYear(year);
	                
	                leaveBalanceLocalService.updateLeaveBalance(leaveBalance);
	            }
	        }
	}


	public void sendMailAndNotificationToHr(String fromName, String fromEmailAddress, String body, long companyId)
			throws Exception {


try {
	List<User> hrUserList = axHrmsCommonApi.fetchRolePersonList(companyId, "HR Admin", -1, -1);



	//SEND MAIL TO HR
	String mailContent = mailTemplateConfiguration.mailYearlySchedulerFailBody();
	mailContent = mailContent.replace("${MESSAGE}",
			Objects.toString(body,
					"Unknown error occurred during Yearly Scheduler execution."));

	String subject = mailTemplateConfiguration.mailYearlySchedulerFailSubject();
	for (User hrUser : hrUserList) {
		EmployeeDetails hrPerson = employeeDetailsLocalService.findByLrUserId(hrUser.getUserId());

		axHrmsCommonApi.sendMail(hrPerson.getOfficialEmail(), fromEmailAddress, fromName,
				subject, mailContent);

	}
}catch (Exception e){
	e.printStackTrace();
}


	}


}
