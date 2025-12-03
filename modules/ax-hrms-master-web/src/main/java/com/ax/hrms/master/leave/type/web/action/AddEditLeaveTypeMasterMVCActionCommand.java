package com.ax.hrms.master.leave.type.web.action;

import com.ax.hrms.master.model.LeaveTypeMaster;

import com.ax.hrms.master.service.LeaveTypeMasterLocalService;
import com.ax.hrms.master.web.constants.AxHrmsLeaveTypeMasterWebPortletKeys;
import com.ax.hrms.master.web.constants.AxHrmsPriorityMasterWebPortletConstants;
import com.ax.hrms.master.web.constants.AxHrmsLeaveTypeMasterWebPortletConstants;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import java.io.IOException;

/**
 * 
 * @author krish.moradiya
 * @category Master Data : Leave Type Master Data Process like Add and Edit
 */
@Component(
	    immediate = true,
	    property = {
	        "javax.portlet.name="+ AxHrmsLeaveTypeMasterWebPortletKeys.AXHRMS_LEAVE_TYPE_MASTER_WEB_PORTLET_KEYS,
	        "mvc.command.name=/addEditLeaveType"
	    },
	    service = MVCActionCommand.class
	)
public class AddEditLeaveTypeMasterMVCActionCommand extends BaseMVCActionCommand{
	
	private static final Log log = LogFactoryUtil.getLog(AddEditLeaveTypeMasterMVCActionCommand.class);
	
	@Reference
	private LeaveTypeMasterLocalService leaveTypeMasterLocalService;

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		log.info("AddEditLeaveTypeMasterMVCActionCommand >>> doProcessAction ::: Add Edit Leave Type Action Method Called");
		
		super.hideDefaultErrorMessage(actionRequest);
		super.hideDefaultSuccessMessage(actionRequest);

		long leaveTypeMasterId = ParamUtil.getLong(actionRequest,AxHrmsLeaveTypeMasterWebPortletConstants.LEAVE_TYPE_MASTER_ID_VAR, AxHrmsLeaveTypeMasterWebPortletConstants.DEFAULT_LONG_VALUE);

		LeaveTypeMaster leaveTypeMaster = setLeaveTypeMasterData(actionRequest,leaveTypeMasterId);

		if(leaveTypeMasterId > 0)
			editLeaveTypeMasterData(actionRequest, actionResponse, leaveTypeMaster);
		else
			addLeaveTypeMasterData(actionRequest, actionResponse, leaveTypeMaster);
		
	}
	private void addLeaveTypeMasterData(ActionRequest actionRequest,ActionResponse actionResponse,LeaveTypeMaster leaveTypeMaster) {
		if (!Validator.isBlank(leaveTypeMaster.getLeaveTypeName())) {
			try{
				if (!leaveTypeMasterLocalService.isLeaveTypeNameExists(leaveTypeMaster.getLeaveTypeName())) {
					leaveTypeMasterLocalService.addLeaveTypeMaster(leaveTypeMaster);
					SessionMessages.add(actionRequest, AxHrmsLeaveTypeMasterWebPortletConstants.LEAVE_TYPE_INSERTED_MESSAGE_KEY);
				} else {
					log.info("AddEditLeaveTypeMasterMVCActionCommand >>> addLeaveTypeMasterData ::: Leave Type Name Already exists.");
					actionRequest.setAttribute(AxHrmsLeaveTypeMasterWebPortletConstants.EXISTED_LEAVE_TYPE_MASTER_ATTRIBUTE_NAME, leaveTypeMaster);
					SessionErrors.add(actionRequest, AxHrmsLeaveTypeMasterWebPortletConstants.LEAVE_TYPE_ALREADY_EXISTED_MESSAGE_KEY);
					actionResponse.setRenderParameter(AxHrmsLeaveTypeMasterWebPortletConstants.MVC_PATH_PARAM_NAME, AxHrmsLeaveTypeMasterWebPortletConstants.ADD_LEAVE_TYPE_MASTER_JSP_PATH);
				}
			}catch (Exception e) {
				log.error("AddEditLeaveTypeMasterMVCActionCommand >>> addLeaveTypeMasterData ::: Something went Wrong : " + e.getMessage());
				SessionErrors.add(actionRequest, AxHrmsLeaveTypeMasterWebPortletConstants.SOMETHING_WENT_WRONG_MESSAGE_KEY);
				actionResponse.setRenderParameter(AxHrmsLeaveTypeMasterWebPortletConstants.MVC_PATH_PARAM_NAME, AxHrmsLeaveTypeMasterWebPortletConstants.ADD_LEAVE_TYPE_MASTER_JSP_PATH);
			}
		}
	}
	
	private void editLeaveTypeMasterData(ActionRequest actionRequest,ActionResponse actionResponse, LeaveTypeMaster leaveTypeMaster) {
		if (!Validator.isBlank(leaveTypeMaster.getLeaveTypeName())) {
			try{
				if (!leaveTypeMasterLocalService.isLeaveTypeNameExists(leaveTypeMaster.getLeaveTypeName())) {
					SessionMessages.add(actionRequest, AxHrmsLeaveTypeMasterWebPortletConstants.LEAVE_TYPE_EDITED_MESSAGE_KEY);
					leaveTypeMasterLocalService.updateLeaveTypeMaster(leaveTypeMaster);
				} else if (leaveTypeMasterLocalService.getLeaveTypeMasterIdByName(leaveTypeMaster.getLeaveTypeName()) == leaveTypeMaster.getLeaveTypeMasterId()) {
					actionRequest.setAttribute(AxHrmsLeaveTypeMasterWebPortletConstants.LEAVE_TYPE_MASTER_DATA_ATTRIBUTE_NAME, leaveTypeMaster);
					leaveTypeMasterLocalService.updateLeaveTypeMaster(leaveTypeMaster);
					SessionMessages.add(actionRequest, AxHrmsLeaveTypeMasterWebPortletConstants.LEAVE_TYPE_EDITED_MESSAGE_KEY);
				} else {
					actionRequest.setAttribute(AxHrmsLeaveTypeMasterWebPortletConstants.LEAVE_TYPE_MASTER_DATA_ATTRIBUTE_NAME, leaveTypeMaster);
					log.info("AddEditLeaveTypeMasterMVCActionCommand >>> addLeaveTypeMasterData ::: Leave Type Name Already exists.");
					actionRequest.setAttribute(AxHrmsLeaveTypeMasterWebPortletConstants.EXISTED_LEAVE_TYPE_MASTER_ATTRIBUTE_NAME, leaveTypeMaster);
					SessionErrors.add(actionRequest, AxHrmsLeaveTypeMasterWebPortletConstants.LEAVE_TYPE_ALREADY_EXISTED_MESSAGE_KEY);
					actionResponse.setRenderParameter(AxHrmsLeaveTypeMasterWebPortletConstants.MVC_PATH_PARAM_NAME, AxHrmsLeaveTypeMasterWebPortletConstants.ADD_LEAVE_TYPE_MASTER_JSP_PATH);
				}
			}catch (Exception e) {
				actionRequest.setAttribute(AxHrmsLeaveTypeMasterWebPortletConstants.LEAVE_TYPE_MASTER_DATA_ATTRIBUTE_NAME, leaveTypeMaster);
				log.error("AddEditLeaveTypeMasterMVCActionCommand >>> editLeaveTypeMasterData ::: Something went Wrong : " + e.getMessage());
				SessionErrors.add(actionRequest, AxHrmsLeaveTypeMasterWebPortletConstants.SOMETHING_WENT_WRONG_MESSAGE_KEY);
				actionResponse.setRenderParameter(AxHrmsLeaveTypeMasterWebPortletConstants.MVC_PATH_PARAM_NAME, AxHrmsLeaveTypeMasterWebPortletConstants.ADD_LEAVE_TYPE_MASTER_JSP_PATH);
			}
		}
	}

	private LeaveTypeMaster setLeaveTypeMasterData(ActionRequest actionRequest, long leaveTypeMasterId) {
		
		LeaveTypeMaster leaveTypeMaster = null;
		
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		String leaveTypeName = ParamUtil.getString(actionRequest,AxHrmsLeaveTypeMasterWebPortletConstants.LEAVE_TYPE_NAME_PARAMETER_NAME,null);
		String description = ParamUtil.getString(actionRequest,AxHrmsLeaveTypeMasterWebPortletConstants.DESCRIPTION_PARAMETER_NAME,null);
		boolean isActive = ParamUtil.getBoolean(actionRequest,AxHrmsLeaveTypeMasterWebPortletConstants.IS_ACTIVE_PARAMETER_NAME,false);
		boolean isAppearForAll = ParamUtil.getBoolean(actionRequest,AxHrmsLeaveTypeMasterWebPortletConstants.IS_APPEAR_FOR_ALL_PARAMETER_NAME,false);
		
		if(leaveTypeMasterId > 0) {
			try {
				leaveTypeMaster = leaveTypeMasterLocalService.getLeaveTypeMaster(leaveTypeMasterId);
			} catch (PortalException e) {
				log.error("AddEditLeaveTypeMasterMVCActionCommand >>> setLeaveTypeMasterData (MVCActionCommand) ::: Exception is: "+e.getMessage());
			}
		}
		else {
			leaveTypeMaster = leaveTypeMasterLocalService.createLeaveTypeMaster(CounterLocalServiceUtil.increment(LeaveTypeMaster.class.getName()));
			leaveTypeMaster.setCreatedBy(themeDisplay.getUserId());
		}

		try{
			leaveTypeMaster.setModifiedBy(themeDisplay.getUserId());
			leaveTypeMaster.setLeaveTypeName(leaveTypeName);
			leaveTypeMaster.setDescription(description);
			leaveTypeMaster.setIsActive(isActive);
			leaveTypeMaster.setIsAppearForAll(isAppearForAll);
			leaveTypeMaster.setGroupId(themeDisplay.getScopeGroupId());
		}catch (Exception e){
			log.error("AddEditLeaveTypeMasterMVCActionCommand >>> setLeaveTypeMasterData (MVCActionCommand) ::: Exception is: "+e.getMessage());
		}
		return leaveTypeMaster;
	}
}
