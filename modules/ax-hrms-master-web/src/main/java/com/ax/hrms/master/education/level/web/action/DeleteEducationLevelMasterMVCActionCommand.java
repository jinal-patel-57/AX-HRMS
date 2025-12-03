package com.ax.hrms.master.education.level.web.action;

import com.ax.hrms.master.service.EducationLevelMasterLocalService;
import com.ax.hrms.master.web.constants.AxEducationLevelMasterWebPortletConstants;
import com.ax.hrms.master.web.constants.AxEducationLevelMasterWebPortletKeys;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;


/**

Author: Himanshu Jha
*/

@Component(immediate = true, property = {
		"javax.portlet.name="+AxEducationLevelMasterWebPortletKeys.AXHRMS_EDUCATIONLEVELMASTER_WEB_PORTLET_KEYS,
        "mvc.command.name=/deleteEducationLevel"
}, service = MVCActionCommand.class)

public class DeleteEducationLevelMasterMVCActionCommand extends BaseMVCActionCommand {
	
	private Log log=LogFactoryUtil.getLog(DeleteEducationLevelMasterMVCActionCommand.class);
	
	@Reference
	EducationLevelMasterLocalService educationLevelMasterLocalService;

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		
		Long educationLevelMasterId = ParamUtil.getLong(actionRequest, AxEducationLevelMasterWebPortletConstants.EDUCATIONLEVEL_MASTER_ID);
		
		try {
			
			educationLevelMasterLocalService.deleteEducationLevelMaster(educationLevelMasterId);
			
			SessionMessages.add(actionRequest, AxEducationLevelMasterWebPortletConstants.EDUCATION_LEVEL_DELETED);
	
		}catch (Exception e) {
			SessionMessages.add(actionRequest, AxEducationLevelMasterWebPortletConstants.EDUCATION_LEVEL_DELETED_ERROR);
			log.error(e.getMessage());
		}
	}

}
