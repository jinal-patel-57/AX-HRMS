package com.ax.hrms.master.priority.web.action;

import com.ax.hrms.master.model.PriorityMaster;
import com.ax.hrms.master.service.PriorityMasterLocalService;
import com.ax.hrms.master.web.constants.AxHrmsMasterWebPortletKeys;
import com.ax.hrms.master.web.constants.AxHrmsPriorityMasterWebPortletConstants;
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
 * @category Master Table : Priority for Add and Edit
 */
@Component(
	    immediate = true,
	    property = {
	        "javax.portlet.name="+ AxHrmsMasterWebPortletKeys.AXHRMS_PRIORITY_MASTER_WEB_PORTLET_KEYS,
	        "mvc.command.name=/addPriorityMaster"
	    },
	    service = MVCActionCommand.class
	)
public class AddEditPriorityMasterMVCActionCommand extends BaseMVCActionCommand{
	
	private static final Log log = LogFactoryUtil.getLog(AddEditPriorityMasterMVCActionCommand.class);
	
	@Reference
	private PriorityMasterLocalService priorityMasterLocalService;

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		log.info("AddEditPriorityMasterMVCActionCommand >>> doProcessAction ::: Add Edit Priority Action Method Called");
		
		super.hideDefaultErrorMessage(actionRequest);
		super.hideDefaultSuccessMessage(actionRequest);

		long priorityMasterId = ParamUtil.getLong(actionRequest,AxHrmsPriorityMasterWebPortletConstants.PRIORITY_MASTER_ID_VAR, AxHrmsPriorityMasterWebPortletConstants.DEFAULT_LONG_VALUE);

		PriorityMaster priorityMaster = setPriorityMasterData(actionRequest,priorityMasterId);

		if(priorityMasterId > 0)
			editPriorityMasterData(actionRequest, actionResponse, priorityMaster);
		else
			addPriorityMasterData(actionRequest, actionResponse, priorityMaster);
		
	}
	private void addPriorityMasterData(ActionRequest actionRequest,ActionResponse actionResponse,PriorityMaster priorityMaster) {
		if (!Validator.isBlank(priorityMaster.getPriorityName())) {
			try{
				if (!priorityMasterLocalService.isPriorityNameExist(priorityMaster.getPriorityName())) {
					priorityMasterLocalService.addPriorityMaster(priorityMaster);
					SessionMessages.add(actionRequest, AxHrmsPriorityMasterWebPortletConstants.PRIORITY_INSERTED_MESSAGE_KEY);
				} else {
					log.info("AddEditPriorityMasterMVCActionCommand >>> addPriorityMasterData ::: Priority Name Already exists.");
					actionRequest.setAttribute(AxHrmsPriorityMasterWebPortletConstants.EXISTED_PRIORITY_MASTER_ATTRIBUTE_NAME, priorityMaster);
					SessionErrors.add(actionRequest, AxHrmsPriorityMasterWebPortletConstants.PRIORITY_ALREADY_EXISTED_MESSAGE_KEY);
					actionResponse.setRenderParameter(AxHrmsPriorityMasterWebPortletConstants.MVC_PATH_PARAM_NAME, AxHrmsPriorityMasterWebPortletConstants.ADD_PRIORITY_MASTER_JSP_PATH);
				}
			}catch (Exception e) {
				log.error("AddEditPriorityMasterMVCActionCommand >>> addPriorityMasterData ::: Something went Wrong : " + e.getMessage());
				SessionErrors.add(actionRequest, AxHrmsPriorityMasterWebPortletConstants.SOMETHING_WENT_WRONG_MESSAGE_KEY);
				actionResponse.setRenderParameter(AxHrmsPriorityMasterWebPortletConstants.MVC_PATH_PARAM_NAME, AxHrmsPriorityMasterWebPortletConstants.ADD_PRIORITY_MASTER_JSP_PATH);
			}
		}
	}
	
	private void editPriorityMasterData(ActionRequest actionRequest,ActionResponse actionResponse, PriorityMaster priorityMaster) {
		if (!Validator.isBlank(priorityMaster.getPriorityName())) {
			try{
				if (!priorityMasterLocalService.isPriorityNameExist(priorityMaster.getPriorityName())) {
					SessionMessages.add(actionRequest, AxHrmsPriorityMasterWebPortletConstants.PRIORITY_EDITED_MESSAGE_KEY);
					priorityMasterLocalService.updatePriorityMaster(priorityMaster);
				} else if (priorityMasterLocalService.getPriorityIdByPriorityName(priorityMaster.getPriorityName()) == priorityMaster.getPriorityMasterId()) {
					actionRequest.setAttribute(AxHrmsPriorityMasterWebPortletConstants.PRIORITY_MASTER_DATA_ATTRIBUTE_NAME,priorityMaster);
					priorityMasterLocalService.updatePriorityMaster(priorityMaster);
					SessionMessages.add(actionRequest, AxHrmsPriorityMasterWebPortletConstants.PRIORITY_EDITED_MESSAGE_KEY);
				} else {
					log.info("AddEditPriorityMasterMVCActionCommand >>> addPriorityMasterData ::: Priority Name Already exists.");
					actionRequest.setAttribute(AxHrmsPriorityMasterWebPortletConstants.PRIORITY_MASTER_DATA_ATTRIBUTE_NAME,priorityMaster);
					actionRequest.setAttribute(AxHrmsPriorityMasterWebPortletConstants.EXISTED_PRIORITY_MASTER_ATTRIBUTE_NAME, priorityMaster);
					SessionErrors.add(actionRequest, AxHrmsPriorityMasterWebPortletConstants.PRIORITY_ALREADY_EXISTED_MESSAGE_KEY);
					actionResponse.setRenderParameter(AxHrmsPriorityMasterWebPortletConstants.MVC_PATH_PARAM_NAME, AxHrmsPriorityMasterWebPortletConstants.ADD_PRIORITY_MASTER_JSP_PATH);
				}
			}catch (Exception e) {
					actionRequest.setAttribute(AxHrmsPriorityMasterWebPortletConstants.PRIORITY_MASTER_DATA_ATTRIBUTE_NAME,priorityMaster);
					log.error("AddEditPriorityMasterMVCActionCommand >>> editPriorityMasterData ::: Something went Wrong : " + e.getMessage());
					SessionErrors.add(actionRequest, AxHrmsPriorityMasterWebPortletConstants.SOMETHING_WENT_WRONG_MESSAGE_KEY);
					actionResponse.setRenderParameter(AxHrmsPriorityMasterWebPortletConstants.MVC_PATH_PARAM_NAME, AxHrmsPriorityMasterWebPortletConstants.ADD_PRIORITY_MASTER_JSP_PATH);
			}
		}
	}

	private PriorityMaster setPriorityMasterData(ActionRequest actionRequest, long priorityMasterId) {
		
		PriorityMaster priorityMaster = null;
		
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		String priorityName = ParamUtil.getString(actionRequest,AxHrmsPriorityMasterWebPortletConstants.PRIORITY_NAME_PARAMETER_NAME,null);
		
		if(priorityMasterId > 0) {
			try {
				priorityMaster = priorityMasterLocalService.getPriorityMaster(priorityMasterId);
			} catch (PortalException e) {
				log.error("AddEditPriorityMasterMVCActionCommand >>> setPriorityMasterData (MVCActionCommand) ::: Exception is: "+e.getMessage());
			}
		}
		else {
			priorityMaster = priorityMasterLocalService.createPriorityMaster(CounterLocalServiceUtil.increment(PriorityMaster.class.getName()));
			priorityMaster.setCreatedBy(themeDisplay.getUserId());
		}
		try{
			priorityMaster.setModifiedBy(themeDisplay.getUserId());
			priorityMaster.setPriorityName(priorityName);
			priorityMaster.setGroupId(themeDisplay.getScopeGroupId());
		}catch(Exception e){
			log.error("AddEditPriorityMasterMVCActionCommand >>> setPriorityMasterData (MVCActionCommand) ::: Exception is: "+e.getMessage());
		}
		return priorityMaster;
	}
}
