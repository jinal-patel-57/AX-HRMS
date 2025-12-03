package com.ax.hrms.master.leave.compensatory.status.web.action;

import com.ax.hrms.master.service.LeaveCompensatoryStatusMasterLocalService;
import com.ax.hrms.master.web.constants.AxLeaveCompensatoryStatusMasterWebPortletConstants;
import com.ax.hrms.master.web.constants.AxLeaveCompensatoryStatusMasterWebPortletKeys;
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
		"javax.portlet.name="+AxLeaveCompensatoryStatusMasterWebPortletKeys.AXHRMS_LEAVECOMPENSATORYSTATUSMASTER_WEB_PORTLET_KEYS,
		"mvc.command.name=/deleteLeaveCompensatoryStatus"
	}, service = MVCActionCommand.class)

	public class DeleteLeaveCompensatoryStatusMasterMVCActionCommand extends BaseMVCActionCommand {

	private Log log=LogFactoryUtil.getLog(DeleteLeaveCompensatoryStatusMasterMVCActionCommand.class);

	@Reference
	LeaveCompensatoryStatusMasterLocalService leaveCompensatoryStatusMasterLocalService;

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		
		Long leaveCompensatoryStatusMasterId = ParamUtil.getLong(actionRequest, AxLeaveCompensatoryStatusMasterWebPortletConstants.LEAVECOMPENSATORYSTATUS_MASTER_ID);
		
		try {
			
			leaveCompensatoryStatusMasterLocalService.deleteLeaveCompensatoryStatusMaster(leaveCompensatoryStatusMasterId);
			
			SessionMessages.add(actionRequest, AxLeaveCompensatoryStatusMasterWebPortletConstants.LEAVE_COMPENSATORY_STATUS_DELETED);
			
		}catch (Exception e) {
			SessionMessages.add(actionRequest, AxLeaveCompensatoryStatusMasterWebPortletConstants.LEAVE_COMPENSATORY_STATUS_DELETED_ERROR);
			log.error("Encountred Error " + e.getMessage());
		}
	}

	}
