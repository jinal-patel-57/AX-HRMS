package com.ax.hrms.master.leave.policy.web.action;

import com.ax.hrms.master.model.LeavePolicyMaster;

import com.ax.hrms.master.model.LeaveTypeMaster;
import com.ax.hrms.master.service.LeavePolicyMasterLocalService;
import com.ax.hrms.master.service.LeaveTypeMasterLocalService;
import com.ax.hrms.master.web.constants.AxLeavePolicyMasterWebPortletConstants;
import com.ax.hrms.master.web.constants.AxLeavePolicyMasterWebPortletKeys;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, property = {
		"javax.portlet.name=" + AxLeavePolicyMasterWebPortletKeys.AXHRMS_LEAVE_POLICY_MASTER_WEB_PORTLET_KEY,
		"mvc.command.name=/cloneLeavePolicy" },
service = MVCActionCommand.class)
public class CloneLeavePolicyMVCActionCommand extends BaseMVCActionCommand {

	@Reference
	LeavePolicyMasterLocalService leavePolicyMasterLocalService;
	
	@Reference
	LeaveTypeMasterLocalService leaveTypeMasterLocalService;

	private Log log = LogFactoryUtil.getLog(CloneLeavePolicyMVCActionCommand.class);

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
			log.info("inside mvc");
			long fromYear = ParamUtil.getLong(actionRequest, "fromYear");
			long toYear = ParamUtil.getLong(actionRequest, "toYear");
			log.info("from year -- " + fromYear);
			log.info("to year -- " + toYear);
			
			long[] leaveTypeIds = ParamUtil.getLongValues(actionRequest, "leaveTypeIds");
			log.info("leaveTypeIds -- " + leaveTypeIds);
			
			if(Validator.isNotNull(leaveTypeIds) && leaveTypeIds.length>0) {
				for(long leaveTypeId : leaveTypeIds) {
					try {
						LeavePolicyMaster previousLeavePolicy = leavePolicyMasterLocalService.findByLeaveTypeMasterIdAndYear(leaveTypeId, (int)fromYear);
						try {
							LeavePolicyMaster currentLeavePolicy = leavePolicyMasterLocalService.findByLeaveTypeMasterIdAndYear(leaveTypeId, (int)toYear);	
						} catch(Exception e) {
							log.error("Need to create new policy");
							try {
								LeavePolicyMaster leavePolicyMaster = leavePolicyMasterLocalService.createLeavePolicyMaster(CounterLocalServiceUtil.increment(LeavePolicyMaster.class.getName()));
				
								leavePolicyMaster.setCompanyId(themeDisplay.getCompanyId());
								leavePolicyMaster.setGroupId(themeDisplay.getScopeGroupId());
				
								leavePolicyMaster.setCreatedBy(themeDisplay.getUserId());
								leavePolicyMaster.setModifiedBy(themeDisplay.getUserId());
								leavePolicyMaster.setDescription(previousLeavePolicy.getDescription());
								leavePolicyMaster.setAccrualRate(previousLeavePolicy.getAccrualRate());
								leavePolicyMaster.setMaximumBalance(previousLeavePolicy.getMaximumBalance());
								leavePolicyMaster.setLeaveTypeMasterId(previousLeavePolicy.getLeaveTypeMasterId());
								leavePolicyMaster.setIsCheckMax(previousLeavePolicy.getIsCheckMax());
								leavePolicyMaster.setIsApplicableFloater(previousLeavePolicy.getIsApplicableFloater());
								leavePolicyMaster.setYearOfPolicy((int)toYear);
								leavePolicyMaster.setIsCarryForward(previousLeavePolicy.getIsCarryForward());
								leavePolicyMaster.setIsContinuous(previousLeavePolicy.getIsContinuous());
								leavePolicyMaster.setEligibleAfterMonths(previousLeavePolicy.getEligibleAfterMonths());
				
								if(isValidPolicyOfYearForAdd((int)toYear, previousLeavePolicy.getLeaveTypeMasterId())) {
									leavePolicyMasterLocalService.addLeavePolicyMaster(leavePolicyMaster);
								}
							} catch (Exception ex) {
								log.error("An error occurred while adding leave policy master: " + ex.getMessage());
							}
						}
					} catch (Exception e) {
						log.error("Unable to copy policy -- " + e.getMessage());
					}
				}
			}
			actionResponse.sendRedirect(PortalUtil.getLayoutFullURL(themeDisplay));
			
	}
	
	public boolean isValidPolicyOfYearForAdd(int yearOfPolicy, long leaveTypeMasterId) {
		for (LeavePolicyMaster leavePolicyMaster : leavePolicyMasterLocalService.getLeavePolicyMasters(-1, -1)) {
			if(leavePolicyMaster.getYearOfPolicy() == yearOfPolicy && leavePolicyMaster.getLeaveTypeMasterId() == leaveTypeMasterId)
				return false;
		}
		return true;
	}
	
	public boolean isValidPolicyOfYearForEdit(int yearOfPolicy, long leaveTypeMasterId, long leavePolicyMasterId) {
	    for (LeavePolicyMaster leavePolicyMaster : leavePolicyMasterLocalService.getLeavePolicyMasters(-1, -1)) {
	        if (leavePolicyMaster.getYearOfPolicy() == yearOfPolicy 
	            && leavePolicyMaster.getLeaveTypeMasterId() == leaveTypeMasterId
	            && leavePolicyMaster.getLeavePolicyMasterId() != leavePolicyMasterId) {
	            return false;
	        }
	    }
	    return true;
	}
}
