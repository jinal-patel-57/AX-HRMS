package com.ax.hrms.master.designation.web.action;

import com.ax.hrms.master.model.DesignationMaster;
import com.ax.hrms.master.service.DesignationMasterLocalService;
import com.ax.hrms.master.web.constants.AxHrmsDesignationMasterWebPortletConstants;
import com.ax.hrms.master.web.constants.AxHrmsDesignationMasterWebPortletKeys;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.RoleLocalService;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import com.liferay.portal.kernel.util.WebKeys;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * 
 * @author krish.moradiya
 * @category Master Data : Designation Master Data Process like Delete designation master
 */
@Component(
	    immediate = true,
	    property = {
	        "javax.portlet.name="+ AxHrmsDesignationMasterWebPortletKeys.AXHRMS_DESIGNATIONMASTER_WEB_PORTLET_KEY,
	        "mvc.command.name="+ AxHrmsDesignationMasterWebPortletConstants.DESIGNATION_MASTER_DELETE_MVC_COMMAND_NAME
	    },
	    service = MVCActionCommand.class
	)
public class DeleteDesignationMasterMVCActionCommand extends BaseMVCActionCommand {
	
	private static final Log log = LogFactoryUtil.getLog(DeleteDesignationMasterMVCActionCommand.class);

	@Reference
	private DesignationMasterLocalService designationMasterLocalService;
	@Reference
	private RoleLocalService roleLocalService;

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse)
			throws Exception {
		
		super.hideDefaultErrorMessage(actionRequest);
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
		log.info("DeleteDesignationMasterMVCActionCommand >>> doProcessAction ::: Delete process called");
		long designationMasterId = ParamUtil.getLong(actionRequest, AxHrmsDesignationMasterWebPortletConstants.DESIGNATION_MASTER_ID_VAR,AxHrmsDesignationMasterWebPortletConstants.DEFAULT_LONG_VALUE);
		
		DesignationMaster designationMaster = null;  
		
		try {
			designationMaster = designationMasterLocalService.getDesignationMaster(designationMasterId);
			Role role = roleLocalService.fetchRole(themeDisplay.getCompanyId(),designationMaster.getDesignationName());
			roleLocalService.deleteRole(role);
		} catch (NumberFormatException | PortalException e) {
			log.error("DeleteDesignationMasterMVCActionCommand >>> doProcessAction (MVCActionCommand) ::: Exception is: "+e.getMessage());
		}
		if(designationMasterId > 0) {
			designationMasterLocalService.deleteDesignationMaster(designationMaster);
			SessionMessages.add(actionRequest, AxHrmsDesignationMasterWebPortletConstants.DESIGNATION_DELETED_SUCCESS_MESSAGE_KEY);
		}
		else {
			SessionErrors.add(actionRequest, AxHrmsDesignationMasterWebPortletConstants.DESIGNATION_DELETED_FAILED_MESSAGE_KEY);
		}

		actionResponse.sendRedirect(ParamUtil.getString(actionRequest,AxHrmsDesignationMasterWebPortletConstants.ITERATOR_URL_PARAMETER_NAME));
	}

}
