package com.ax.hrms.master.probation.status.web.action;

import com.ax.hrms.master.service.ProbationStatusMasterLocalService;
import com.ax.hrms.master.web.constants.AxProbationStatusMasterWebPortletConstants;
import com.ax.hrms.master.web.constants.AxProbationStatusMasterWebPortletKeys;
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
		"javax.portlet.name="+AxProbationStatusMasterWebPortletKeys.AXHRMS_PROBATIONSTATUSMASTER_WEB_PORTLET_KEYS,
        "mvc.command.name=/deleteProbationStatus"
}, service = MVCActionCommand.class)


public class DeleteProbationStatusMasterMVCActionCommand extends BaseMVCActionCommand {
	
	private Log log=LogFactoryUtil.getLog(DeleteProbationStatusMasterMVCActionCommand.class);
	
	@Reference
	ProbationStatusMasterLocalService probationStatusMasterLocalService;

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		
		Long probationStatusMasterId = ParamUtil.getLong(actionRequest, AxProbationStatusMasterWebPortletConstants.PROBATIONSTATUS_MASTER_ID);
		
		
		try {
			
			probationStatusMasterLocalService.deleteProbationStatusMaster(probationStatusMasterId);
			
			SessionMessages.add(actionRequest, AxProbationStatusMasterWebPortletConstants.PROBATION_STATUS_DELETED);

			
		}catch (Exception e) {
			SessionMessages.add(actionRequest, AxProbationStatusMasterWebPortletConstants.PROBATION_STATUS_DELETED_ERROR);
			log.error(e.getMessage());
		}
	}

}
