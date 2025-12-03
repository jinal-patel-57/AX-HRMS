package com.ax.hrms.master.leave.type.web.action;

import com.ax.hrms.master.model.LeaveTypeMaster;
import com.ax.hrms.master.service.LeaveTypeMasterLocalService;
import com.ax.hrms.master.web.constants.AxHrmsLeaveTypeMasterWebPortletConstants;
import com.ax.hrms.master.web.constants.AxHrmsLeaveTypeMasterWebPortletKeys;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

/**
 * 
 * @author krish.moradiya
 * @category Master Data : Leave Type Master Data Process like Delete Leave type
 */
@Component(
	    immediate = true,
	    property = {
	        "javax.portlet.name="+ AxHrmsLeaveTypeMasterWebPortletKeys.AXHRMS_LEAVE_TYPE_MASTER_WEB_PORTLET_KEYS,
	        "mvc.command.name="+ AxHrmsLeaveTypeMasterWebPortletConstants.LEAVE_TYPE_MASTER_DELETE_MVC_COMMAND_NAME
	    },
	    service = MVCActionCommand.class
	)
public class DeleteLeaveTypeMasterMVCActionCommand extends BaseMVCActionCommand {
	
	private static final Log log = LogFactoryUtil.getLog(DeleteLeaveTypeMasterMVCActionCommand.class);

	@Reference
	private LeaveTypeMasterLocalService leaveTypeMasterLocalService;

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse)
			throws Exception {
		
		super.hideDefaultErrorMessage(actionRequest);
		
		log.info("DeleteLeaveTypeMasterMVCActionCommand >>> doProcessAction ::: Delete process called");
		long leaveTypeMasterId = ParamUtil.getLong(actionRequest, AxHrmsLeaveTypeMasterWebPortletConstants.LEAVE_TYPE_MASTER_ID_VAR,AxHrmsLeaveTypeMasterWebPortletConstants.DEFAULT_LONG_VALUE);
		
		LeaveTypeMaster leaveTypeMaster = null;
		
		try {
			leaveTypeMaster = leaveTypeMasterLocalService.getLeaveTypeMaster(leaveTypeMasterId);
		} catch (NumberFormatException | PortalException e) {
			log.error("DeleteLeaveTypeMasterMVCActionCommand >>> doProcessAction (MVCActionCommand) ::: Exception is: "+e.getMessage());
		}
		if(leaveTypeMasterId > 0) {
			leaveTypeMasterLocalService.deleteLeaveTypeMaster(leaveTypeMaster);
			SessionMessages.add(actionRequest, AxHrmsLeaveTypeMasterWebPortletConstants.LEAVE_TYPE_DELETED_MESSAGE_KEY);
		}
		else {
			SessionErrors.add(actionRequest, AxHrmsLeaveTypeMasterWebPortletConstants.LEAVE_TYPE_DELETED_FAILED_MESSAGE_KEY);
		}

		actionResponse.sendRedirect(ParamUtil.getString(actionRequest,AxHrmsLeaveTypeMasterWebPortletConstants.ITERATOR_URL_PARAMETER_NAME));
	}

}
