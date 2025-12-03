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
import com.liferay.portal.kernel.util.WebKeys;

import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, property = {
		"javax.portlet.name=" + AxLeavePolicyMasterWebPortletKeys.AXHRMS_LEAVE_POLICY_MASTER_WEB_PORTLET_KEY,
		"mvc.command.name=/addEditLeavePolicy" },
service = MVCActionCommand.class)
public class AddEditLeavePolicyMasterMVCActionCommand extends BaseMVCActionCommand {

	@Reference
	LeavePolicyMasterLocalService leavePolicyMasterLocalService;
	
	@Reference
	LeaveTypeMasterLocalService leaveTypeMasterLocalService;

	private Log log = LogFactoryUtil.getLog(AddEditLeavePolicyMasterMVCActionCommand.class);

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		
		final ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);

		final LeavePolicyMaster leavePolicyMaster;
		Long leaveTypeMasterId = ParamUtil.getLong(actionRequest, AxLeavePolicyMasterWebPortletConstants.LEAVE_TYPE_MASTER_ID);
		String desciption = ParamUtil.getString(actionRequest, AxLeavePolicyMasterWebPortletConstants.DESCRIPTION);
		Double accrualRate = ParamUtil.getDouble(actionRequest, AxLeavePolicyMasterWebPortletConstants.ACCRUAL_RATE);
		Double maximumBalance = ParamUtil.getDouble(actionRequest, AxLeavePolicyMasterWebPortletConstants.MAXIMUM_BALANCE);
		boolean isCheckMax = ParamUtil.getBoolean(actionRequest, AxLeavePolicyMasterWebPortletConstants.IS_CHECK_MAX);
		boolean iscarryforward = ParamUtil.getBoolean(actionRequest, AxLeavePolicyMasterWebPortletConstants.IS_CARRY_FORWARD);
		boolean isContinuos = ParamUtil.getBoolean(actionRequest, AxLeavePolicyMasterWebPortletConstants.IS_CONTINOUS);
		boolean isApplicableFloater = ParamUtil.getBoolean(actionRequest, AxLeavePolicyMasterWebPortletConstants.IS_APPLICABLE_FLOATER,false);
		int eligibleAfterMonths = ParamUtil.getInteger(actionRequest, AxLeavePolicyMasterWebPortletConstants.ELIGIBLE_AFTER_MONTHS);
		int yearOfPolicy=ParamUtil.getInteger(actionRequest, AxLeavePolicyMasterWebPortletConstants.YEAR_OF_POLICY);
		Long leavePolicyMasterId = ParamUtil.getLong(actionRequest, AxLeavePolicyMasterWebPortletConstants.LEAVE_POLICY_MASTER_ID);

		if (leavePolicyMasterId <= 0) {
			try {
				leavePolicyMaster = leavePolicyMasterLocalService.createLeavePolicyMaster(CounterLocalServiceUtil.increment(LeavePolicyMaster.class.getName()));

				leavePolicyMaster.setCompanyId(themeDisplay.getCompanyId());
				leavePolicyMaster.setGroupId(themeDisplay.getScopeGroupId());

				leavePolicyMaster.setCreatedBy(themeDisplay.getUserId());
				leavePolicyMaster.setModifiedBy(themeDisplay.getUserId());
				leavePolicyMaster.setDescription(desciption);
				leavePolicyMaster.setAccrualRate(accrualRate / 12);
				leavePolicyMaster.setMaximumBalance(maximumBalance);
				leavePolicyMaster.setLeaveTypeMasterId(leaveTypeMasterId);
				leavePolicyMaster.setIsCheckMax(isCheckMax);
				leavePolicyMaster.setIsApplicableFloater(isApplicableFloater);
				leavePolicyMaster.setYearOfPolicy(yearOfPolicy);
				leavePolicyMaster.setIsCarryForward(iscarryforward);
				leavePolicyMaster.setIsContinuous(isContinuos);
				leavePolicyMaster.setEligibleAfterMonths(eligibleAfterMonths);

				if(isValidPolicyOfYearForAdd(yearOfPolicy,leaveTypeMasterId)) {
					leavePolicyMasterLocalService.addLeavePolicyMaster(leavePolicyMaster);
					SessionMessages.add(actionRequest, AxLeavePolicyMasterWebPortletConstants.LEAVE_POLICY_MASTER_ADDED);
				}
				else {
					SessionErrors.add(actionRequest,AxLeavePolicyMasterWebPortletConstants.LEAVE_POLICY_EXISTS );
					List<LeaveTypeMaster> leaveTypeMasterList = leaveTypeMasterLocalService.getLeaveTypeMasters(-1, -1);
					actionRequest.setAttribute(AxLeavePolicyMasterWebPortletConstants.LEAVE_TYPE_MASTER_LIST, leaveTypeMasterList);
					actionResponse.setRenderParameter(AxLeavePolicyMasterWebPortletConstants.MVC_PATH,AxLeavePolicyMasterWebPortletConstants.ADD_LEAVE_POLICY_MASTER_JSP);
					super.hideDefaultErrorMessage(actionRequest);
				}

			} catch (Exception e) {
				log.error("An error occurred while adding leave policy master: " + e.getMessage(), e);
			}
		}else {
			
			leavePolicyMaster=leavePolicyMasterLocalService.getLeavePolicyMaster(leavePolicyMasterId);
			
			try {
				leavePolicyMaster.setCompanyId(themeDisplay.getCompanyId());
				leavePolicyMaster.setGroupId(themeDisplay.getScopeGroupId());

				leavePolicyMaster.setCreatedBy(themeDisplay.getUserId());
				leavePolicyMaster.setModifiedBy(themeDisplay.getUserId());
				leavePolicyMaster.setDescription(desciption);
				leavePolicyMaster.setAccrualRate(accrualRate / 12);
				leavePolicyMaster.setMaximumBalance(maximumBalance);
				leavePolicyMaster.setLeaveTypeMasterId(leaveTypeMasterId);
				leavePolicyMaster.setIsCheckMax(isCheckMax);
				leavePolicyMaster.setIsApplicableFloater(isApplicableFloater);
				leavePolicyMaster.setYearOfPolicy(yearOfPolicy);
				leavePolicyMaster.setIsCarryForward(iscarryforward);
				leavePolicyMaster.setIsContinuous(isContinuos);
				leavePolicyMaster.setEligibleAfterMonths(eligibleAfterMonths);
				
				
				if(isValidPolicyOfYearForEdit(yearOfPolicy,leaveTypeMasterId,leavePolicyMasterId)) {
					leavePolicyMasterLocalService.updateLeavePolicyMaster(leavePolicyMaster);

					SessionMessages.add(actionRequest,AxLeavePolicyMasterWebPortletConstants.LEAVE_POLICY_EDITED);
				}else {
					SessionErrors.add(actionRequest,AxLeavePolicyMasterWebPortletConstants.LEAVE_POLICY_EXISTS );
					actionRequest.setAttribute(AxLeavePolicyMasterWebPortletConstants.GET_LEAVE_POLICY_MASTER, leavePolicyMaster);
					
					List<LeaveTypeMaster> leaveTypeMasterList = leaveTypeMasterLocalService.getLeaveTypeMasters(-1, -1);
					actionRequest.setAttribute(AxLeavePolicyMasterWebPortletConstants.LEAVE_TYPE_MASTER_LIST, leaveTypeMasterList);
					actionResponse.setRenderParameter(AxLeavePolicyMasterWebPortletConstants.MVC_PATH,AxLeavePolicyMasterWebPortletConstants.ADD_LEAVE_POLICY_MASTER_JSP);
					super.hideDefaultErrorMessage(actionRequest);
				}
			}catch(Exception e) {
				log.error("Error In Catch While Update Details " + e.getMessage());
			}
		}
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
