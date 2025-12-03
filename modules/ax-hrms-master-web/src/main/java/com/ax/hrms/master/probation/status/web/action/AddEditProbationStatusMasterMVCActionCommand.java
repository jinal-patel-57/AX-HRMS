package com.ax.hrms.master.probation.status.web.action;

import com.ax.hrms.master.exception.NoSuchProbationStatusMasterException;
import com.ax.hrms.master.model.ProbationStatusMaster;
import com.ax.hrms.master.service.ProbationStatusMasterLocalService;
import com.ax.hrms.master.web.constants.AxProbationStatusMasterWebPortletConstants;
import com.ax.hrms.master.web.constants.AxProbationStatusMasterWebPortletKeys;
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
	        "javax.portlet.name="+ AxProbationStatusMasterWebPortletKeys.AXHRMS_PROBATIONSTATUSMASTER_WEB_PORTLET_KEYS,
	        "mvc.command.name=/addEditProbationStatus"
	    },
	    service = MVCActionCommand.class
)

public class AddEditProbationStatusMasterMVCActionCommand extends BaseMVCActionCommand {
	
	@Reference
	ProbationStatusMasterLocalService probationStatusMasterLocalService;


	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		
		String probationStatusName = ParamUtil.getString(actionRequest, AxProbationStatusMasterWebPortletConstants.PROBATIONSTATUS_NAME, null);
		long probationStatusMasterId = ParamUtil.getLong(actionRequest, AxProbationStatusMasterWebPortletConstants.PROBATIONSTATUS_MASTER_ID, AxProbationStatusMasterWebPortletConstants.DEFAULT_LONG_VALUE);

		if (probationStatusMasterId <= 0) {
		   if (isLevelMasterAvailable(probationStatusName, 0)) {
		       ProbationStatusMaster probationStatusMaster = probationStatusMasterLocalService.createProbationStatusMaster(CounterLocalServiceUtil.increment(ProbationStatusMaster.class.getName()));
		       
		       ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		       probationStatusMaster.setStatusType(probationStatusName);
		       probationStatusMaster.setCompanyId(themeDisplay.getCompanyId());
		       probationStatusMaster.setCreatedBy(themeDisplay.getUserId());
		       probationStatusMaster.setGroupId(themeDisplay.getCompanyGroupId());
		       probationStatusMaster.setCreateDate(new Date());
		       probationStatusMaster.setModifiedDate(new Date());
		       probationStatusMasterLocalService.addProbationStatusMaster(probationStatusMaster);
		       
		       SessionMessages.add(actionRequest, AxProbationStatusMasterWebPortletConstants.PROBATION_STATUS_ADDED);
		       }
		       else {
		           SessionErrors.add(actionRequest, AxProbationStatusMasterWebPortletConstants.PROBATION_STATUS_EXISTS);
		           super.hideDefaultErrorMessage(actionRequest);

		           actionResponse.setRenderParameter(AxProbationStatusMasterWebPortletConstants.PROBATIONSTATUS_PATH, AxProbationStatusMasterWebPortletConstants.FORM_PROBATION_STATUS_MASTER);
		       }
		}

		else {
		   if (isLevelMasterAvailable(probationStatusName, probationStatusMasterId) && isLevelNameValid(probationStatusName)) {
			 
		       ProbationStatusMaster probationStatusMaster = probationStatusMasterLocalService.getProbationStatusMaster(probationStatusMasterId);
		       probationStatusMaster.setStatusType(probationStatusName);
		       ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		       probationStatusMaster.setModifiedBy(themeDisplay.getUserId());
		       
		       probationStatusMasterLocalService.updateProbationStatusMaster(probationStatusMaster);
		         
		       SessionMessages.add(actionRequest, AxProbationStatusMasterWebPortletConstants.PROBATION_STATUS_UPDATED);
		   }
		   else {
		       SessionErrors.add(actionRequest, AxProbationStatusMasterWebPortletConstants.PROBATION_STATUS_EXISTS);
		       super.hideDefaultErrorMessage(actionRequest);
		       
		       actionResponse.setRenderParameter(AxProbationStatusMasterWebPortletConstants.PROBATIONSTATUS_PATH, AxProbationStatusMasterWebPortletConstants.FORM_PROBATION_STATUS_MASTER);
		   }
		}
		}

		private boolean isLevelMasterAvailable(String probationStatusName, long id) {
			
		try {
		   
		   ProbationStatusMaster name = probationStatusMasterLocalService.findByProbationStatusName(probationStatusName);
		   
		   return (id>0 && name.getProbationStatusMasterId() == id);
		} catch (NoSuchProbationStatusMasterException e) {
		   return true;
		}
	}

	private boolean isLevelNameValid(String probationStatusName) { 
		return Validator.isNotNull(probationStatusName) && Validator.isName(probationStatusName);
		}
}