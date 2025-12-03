package com.ax.hrms.master.designation.web.action;

import com.ax.hrms.master.model.DesignationMaster;
import com.ax.hrms.master.service.DesignationMasterLocalService;
import com.ax.hrms.master.web.constants.AxHrmsDesignationMasterWebPortletConstants;
import com.ax.hrms.master.web.constants.AxHrmsDesignationMasterWebPortletKeys;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.*;
import com.liferay.portal.kernel.model.role.RoleConstants;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.security.permission.ActionKeys;
import com.liferay.portal.kernel.service.*;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.*;

import java.util.Locale;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import com.liferay.roles.admin.role.type.contributor.RoleTypeContributor;
import com.liferay.roles.admin.role.type.contributor.provider.RoleTypeContributorProvider;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * 
 * @author krish.moradiya
 * @category Master Data : Designation Master Data Process like Add and Edit
 */
@Component(
	    immediate = true,
	    property = {
	        "javax.portlet.name="+ AxHrmsDesignationMasterWebPortletKeys.AXHRMS_DESIGNATIONMASTER_WEB_PORTLET_KEY,
	        "mvc.command.name=addDesignation"
	    },
	    service = MVCActionCommand.class
	)
public class AddEditDesignationMasterMVCActionCommand extends BaseMVCActionCommand{
	
	private static final Log log = LogFactoryUtil.getLog(AddEditDesignationMasterMVCActionCommand.class);
	
	@Reference
	private DesignationMasterLocalService designationMasterLocalService;

	@Reference
	private Localization localization;

	@Reference
	private RoleLocalService roleLocalService;

	@Reference
	private RoleService roleService;

	@Reference
	private RoleTypeContributorProvider roleTypeContributorProvider;

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		log.info("AddEditDesignationMasterMVCActionCommand >>> doProcessAction ::: Add Edit Designation Action Method Called");
		
		super.hideDefaultErrorMessage(actionRequest);
		super.hideDefaultSuccessMessage(actionRequest);

		String designationName = ParamUtil.getString(actionRequest, AxHrmsDesignationMasterWebPortletConstants.DESIGNATION_NAME, null);
		long designationMasterId = ParamUtil.getLong(actionRequest, AxHrmsDesignationMasterWebPortletConstants.DESIGNATION_MASTER_ID_VAR, AxHrmsDesignationMasterWebPortletConstants.DEFAULT_LONG_VALUE);

		DesignationMaster designationMaster = setDesignationData(actionRequest, designationMasterId);

		if(designationMasterId > 0)
			editDesignationMasterData(actionRequest, actionResponse, designationMasterId, designationName, designationMaster);
		else
			addDesignationMasterData(actionRequest, actionResponse, designationName, designationMaster);
		
	}
	
	private void addDesignationMasterData(ActionRequest actionRequest,ActionResponse actionResponse,String designationName,DesignationMaster designationMaster) {
		if (!Validator.isBlank(designationName)) {	
			try {				
				if (!designationMasterLocalService.isNameExist(designationName)) {
					designationMasterLocalService.addDesignationMaster(designationMaster);
					SessionMessages.add(actionRequest, AxHrmsDesignationMasterWebPortletConstants.DESIGNATION_INSERTED_MESSAGE_KEY);
				} else {
					log.info("AddEditDesignationMasterMVCActionCommand >>> addDesignationMasterData ::: Designation Name Already exists.");
					actionRequest.setAttribute(AxHrmsDesignationMasterWebPortletConstants.EXISTED_DESIGNATION_NAME_PARAMETER_NAME, designationName);					
					SessionErrors.add(actionRequest, AxHrmsDesignationMasterWebPortletConstants.DESIGNATION_ALREADY_EXISTED_MESSAGE_KEY);
					actionResponse.setRenderParameter(AxHrmsDesignationMasterWebPortletConstants.MVC_PATH_PARAM_NAME, AxHrmsDesignationMasterWebPortletConstants.ADD_DESIGNATION_MASTER_JSP_PATH);
				}
			}catch (Exception e) {
				log.info("AddEditDesignationMasterMVCActionCommand >>> addDesignationMasterData ::: Something went wrong. Exception is: "+e.getMessage());
				SessionErrors.add(actionRequest, AxHrmsDesignationMasterWebPortletConstants.SOMETHING_WENT_WRONG_MESSAGE_KEY);
				actionResponse.setRenderParameter(AxHrmsDesignationMasterWebPortletConstants.MVC_PATH_PARAM_NAME, AxHrmsDesignationMasterWebPortletConstants.ADD_DESIGNATION_MASTER_JSP_PATH);
			}
		}
	}
	
	private void editDesignationMasterData(ActionRequest actionRequest,ActionResponse actionResponse,Long designationMasterId, String designationName, DesignationMaster designationMaster) {
		if (!Validator.isBlank(designationName)) {
			try{
				if (!designationMasterLocalService.isNameExist(designationName)) {
					SessionMessages.add(actionRequest, AxHrmsDesignationMasterWebPortletConstants.DESIGNATION_EDITED_MESSAGE_KEY);
					designationMasterLocalService.updateDesignationMaster(designationMaster);
				} else if (designationMasterLocalService.getDesignationIdByName(designationName) == designationMasterId) {
					SessionMessages.add(actionRequest, AxHrmsDesignationMasterWebPortletConstants.DESIGNATION_EDITED_MESSAGE_KEY);
					designationMasterLocalService.updateDesignationMaster(designationMaster);
					actionRequest.setAttribute(AxHrmsDesignationMasterWebPortletConstants.DESIGNATION_MASTER_DATA_VAR, designationMaster);
				} else {
					actionRequest.setAttribute(AxHrmsDesignationMasterWebPortletConstants.DESIGNATION_MASTER_DATA_VAR, designationMaster);
					log.info("AddEditDesignationMasterMVCActionCommand >>> editDesignationMasterData ::: Designation Name Already exists.");
					SessionErrors.add(actionRequest, AxHrmsDesignationMasterWebPortletConstants.DESIGNATION_ALREADY_EXISTED_MESSAGE_KEY);
					actionRequest.setAttribute(AxHrmsDesignationMasterWebPortletConstants.EXISTED_DESIGNATION_NAME_PARAMETER_NAME, designationName);
					actionResponse.setRenderParameter(AxHrmsDesignationMasterWebPortletConstants.MVC_RENDER_COMMAND_NAME_PARAM_NAME, AxHrmsDesignationMasterWebPortletConstants.ADD_DESIGNATION_COMMAND_NAME);
				}
			}catch (Exception e) {
				actionRequest.setAttribute(AxHrmsDesignationMasterWebPortletConstants.DESIGNATION_MASTER_DATA_VAR, designationMaster);
				log.error("AddEditDesignationMasterMVCActionCommand >>> editDesignationMasterData ::: Something went Wrong : " + e.getMessage());
				SessionErrors.add(actionRequest, AxHrmsDesignationMasterWebPortletConstants.SOMETHING_WENT_WRONG_MESSAGE_KEY);
				actionResponse.setRenderParameter(AxHrmsDesignationMasterWebPortletConstants.MVC_PATH_PARAM_NAME, AxHrmsDesignationMasterWebPortletConstants.ADD_DESIGNATION_MASTER_JSP_PATH);
			}
		}
	}

	private DesignationMaster setDesignationData(ActionRequest actionRequest,long designationMasterId) throws PortalException {
		DesignationMaster designationMaster = designationMasterLocalService.createDesignationMaster(CounterLocalServiceUtil.increment(DesignationMaster.class.getName()));

		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		String designationName = ParamUtil.getString(actionRequest, AxHrmsDesignationMasterWebPortletConstants.DESIGNATION_NAME,null);
		
		if(designationMasterId > 0) {
			try {
				designationMaster = designationMasterLocalService.getDesignationMaster(designationMasterId);
				updateRole(designationMaster.getDesignationName(),designationName,actionRequest,themeDisplay);
			} catch (PortalException | NullPointerException e) {
				log.error("AddEditDesignationMasterMVCActionCommand >>> setDesignationData (MVCActionCommand) ::: Exception is: "+e.getMessage());
			}

		}
		else {

			designationMaster.setCreatedBy(themeDisplay.getUserId());
			addRole(designationName, actionRequest,themeDisplay);
		}
		
		designationMaster.setModifiedBy(themeDisplay.getUserId());
		designationMaster.setDesignationName(designationName);
		designationMaster.setGroupId(themeDisplay.getScopeGroupId());
		return designationMaster;
	}
	
	public void addRole(String roleName,ActionRequest actionRequest,ThemeDisplay themeDisplay) throws PortalException {
		
		Map<Locale, String> titleMap = localization.getLocalizationMap(actionRequest, roleName);
		Map<Locale, String> descriptionMap = localization.getLocalizationMap(actionRequest, "description");
		
		ServiceContext serviceContext = ServiceContextFactory.getInstance(Role.class.getName(), actionRequest);

		int type = ParamUtil.getInteger(actionRequest, "roleType", RoleConstants.TYPE_REGULAR);

		RoleTypeContributor roleTypeContributor = roleTypeContributorProvider.getRoleTypeContributor(type);
		try{
			Role role = roleService.getRole(themeDisplay.getCompanyId(),roleName);
			log.info("Roles Company ID: "+themeDisplay.getCompanyId());
			roleService.updateRole(role.getRoleId(),roleName,titleMap,descriptionMap,null,serviceContext);
		}catch(PortalException exception){
			Role role = roleService.addRole("", roleTypeContributor.getClassName(), 0, roleName, titleMap, descriptionMap, type, null, serviceContext);
			log.error("AddEditDesignationMasterMVCActionCommand >>> addRole ::: Exception is: "+exception.getMessage());
		}catch (Exception e){
			log.error("AddEditDesignationMasterMVCActionCommand >>> addRole ::: Exception is: "+e.getMessage());
		}

	}
	public void updateRole(String oldRoleName,String newRoleName,ActionRequest actionRequest,ThemeDisplay themeDisplay) throws PortalException{
		Map<Locale, String> titleMap = localization.getLocalizationMap(actionRequest, oldRoleName);
		Map<Locale, String> descriptionMap = localization.getLocalizationMap(actionRequest, "description");

		ServiceContext serviceContext = ServiceContextFactory.getInstance(Role.class.getName(), actionRequest);

		int type = ParamUtil.getInteger(actionRequest, "roleType", RoleConstants.TYPE_REGULAR);

		RoleTypeContributor roleTypeContributor = roleTypeContributorProvider.getRoleTypeContributor(type);
		try{
			Role role = roleService.getRole(themeDisplay.getCompanyId(),oldRoleName);
			log.info("Roles Company ID: "+themeDisplay.getCompanyId());
			roleService.updateRole(role.getRoleId(),newRoleName,titleMap,descriptionMap,null,serviceContext);
		}catch(PortalException exception){
			roleService.addRole("", roleTypeContributor.getClassName(), 0, newRoleName, titleMap, descriptionMap, type, null, serviceContext);
			log.error("AddEditDesignationMasterMVCActionCommand >>> addRole ::: Exception is: "+exception.getMessage());
		}
	}

}
