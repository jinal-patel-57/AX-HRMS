package com.ax.hrms.master.leave.compensatory.status.web.action;

import com.ax.hrms.master.exception.NoSuchLeaveCompensatoryStatusMasterException;
import com.ax.hrms.master.model.LeaveCompensatoryStatusMaster;
import com.ax.hrms.master.service.LeaveCompensatoryStatusMasterLocalService;
import com.ax.hrms.master.web.constants.AxLeaveCompensatoryStatusMasterWebPortletConstants;
import com.ax.hrms.master.web.constants.AxLeaveCompensatoryStatusMasterWebPortletKeys;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.Date;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**

Author: Himanshu Jha
*/

@Component(
	    immediate = true,
	    property = {
	        "javax.portlet.name="+ AxLeaveCompensatoryStatusMasterWebPortletKeys.AXHRMS_LEAVECOMPENSATORYSTATUSMASTER_WEB_PORTLET_KEYS,
	        "mvc.command.name=/addEditLeaveCompensatoryStatus"
	    },
	    service = MVCActionCommand.class
)

public class AddEditLeaveCompensatoryStatusMasterMVCActionCommand extends BaseMVCActionCommand {
	
	@Reference
	LeaveCompensatoryStatusMasterLocalService leaveCompensatoryStatusMasterLocalService;


	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		
		String leaveCompensatoryStatusName = ParamUtil.getString(actionRequest, AxLeaveCompensatoryStatusMasterWebPortletConstants.LEAVECOMPENSATORYSTATUS_NAME, null);
		long leaveCompensatoryStatusMasterId = ParamUtil.getLong(actionRequest, AxLeaveCompensatoryStatusMasterWebPortletConstants.LEAVECOMPENSATORYSTATUS_MASTER_ID, AxLeaveCompensatoryStatusMasterWebPortletConstants.DEFAULT_LONG_VALUE);

		if (leaveCompensatoryStatusMasterId <= 0) {
		   if (isLevelMasterAvailable(leaveCompensatoryStatusName, 0)) {
		       LeaveCompensatoryStatusMaster leaveCompensatoryStatusMaster = leaveCompensatoryStatusMasterLocalService.createLeaveCompensatoryStatusMaster(CounterLocalServiceUtil.increment(LeaveCompensatoryStatusMaster.class.getName()));
		       
		       ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		       leaveCompensatoryStatusMaster.setLeaveCompensatoryStatus(leaveCompensatoryStatusName);
		       leaveCompensatoryStatusMaster.setCompanyId(themeDisplay.getCompanyId());
		       leaveCompensatoryStatusMaster.setCreatedBy(themeDisplay.getUserId());
		       leaveCompensatoryStatusMaster.setGroupId(themeDisplay.getCompanyGroupId());
		       leaveCompensatoryStatusMaster.setCreateDate(new Date());
		       leaveCompensatoryStatusMaster.setModifiedDate(new Date());
		       leaveCompensatoryStatusMasterLocalService.addLeaveCompensatoryStatusMaster(leaveCompensatoryStatusMaster);
		       
		       SessionMessages.add(actionRequest, AxLeaveCompensatoryStatusMasterWebPortletConstants.LEAVE_COMPENSATORY_STATUS_ADDED);
		       }
		       else {
		           SessionErrors.add(actionRequest, AxLeaveCompensatoryStatusMasterWebPortletConstants.LEAVE_COMPENSATORY_STATUS_EXISTS);
		           super.hideDefaultErrorMessage(actionRequest);

		           actionResponse.setRenderParameter(AxLeaveCompensatoryStatusMasterWebPortletConstants.LEAVECOMPENSATORYSTATUS_PATH, AxLeaveCompensatoryStatusMasterWebPortletConstants.FORM_LEAVE_COMPENSATORY_STATUS_MASTER);
		       }
		}

		else {
		   if (isLevelMasterAvailable(leaveCompensatoryStatusName, leaveCompensatoryStatusMasterId) && isLevelNameValid(leaveCompensatoryStatusName)) {
			 
		       LeaveCompensatoryStatusMaster leaveCompensatoryStatusMaster = leaveCompensatoryStatusMasterLocalService.getLeaveCompensatoryStatusMaster(leaveCompensatoryStatusMasterId);
		       leaveCompensatoryStatusMaster.setLeaveCompensatoryStatus(leaveCompensatoryStatusName);
		       ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		       leaveCompensatoryStatusMaster.setModifiedBy(themeDisplay.getUserId());
		       
		       leaveCompensatoryStatusMasterLocalService.updateLeaveCompensatoryStatusMaster(leaveCompensatoryStatusMaster);
		         
		       SessionMessages.add(actionRequest, AxLeaveCompensatoryStatusMasterWebPortletConstants.LEAVE_COMPENSATORY_STATUS_UPDATED);
		   }
		   else {
		       SessionErrors.add(actionRequest, AxLeaveCompensatoryStatusMasterWebPortletConstants.LEAVE_COMPENSATORY_STATUS_EXISTS);
		       super.hideDefaultErrorMessage(actionRequest);
		       
		       actionResponse.setRenderParameter(AxLeaveCompensatoryStatusMasterWebPortletConstants.LEAVECOMPENSATORYSTATUS_PATH, AxLeaveCompensatoryStatusMasterWebPortletConstants.FORM_LEAVE_COMPENSATORY_STATUS_MASTER);
		   }
		}
		}

		private boolean isLevelMasterAvailable(String leaveCompensatoryStatusName, long id) { 
		try {
		   
		   LeaveCompensatoryStatusMaster name = leaveCompensatoryStatusMasterLocalService.findByLeaveCompensatoryStatusName(leaveCompensatoryStatusName);
		   return (id>0 && name.getLeaveCompensatoryStatusMasterId() == id);
		} catch (NoSuchLeaveCompensatoryStatusMasterException e) {
		   return true;
		}
	}

	private boolean isLevelNameValid(String leaveCompensatoryStatusName) { 
		return Validator.isNotNull(leaveCompensatoryStatusName) && Validator.isName(leaveCompensatoryStatusName);
		}
}