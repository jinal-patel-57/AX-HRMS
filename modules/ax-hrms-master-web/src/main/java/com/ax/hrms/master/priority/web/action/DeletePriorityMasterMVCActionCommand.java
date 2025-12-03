package com.ax.hrms.master.priority.web.action;

import com.ax.hrms.master.model.PriorityMaster;
import com.ax.hrms.master.service.PriorityMasterLocalService;
import com.ax.hrms.master.web.constants.AxHrmsPriorityMasterWebPortletConstants;
import com.ax.hrms.master.web.constants.AxHrmsMasterWebPortletKeys;
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
 * @category Master Table : Priority for delete priority
 */
@Component(
	    immediate = true,
	    property = {
	        "javax.portlet.name="+ AxHrmsMasterWebPortletKeys.AXHRMS_PRIORITY_MASTER_WEB_PORTLET_KEYS,
	        "mvc.command.name=/deletePriorityMaster"
	    },
	    service = MVCActionCommand.class
	)
public class DeletePriorityMasterMVCActionCommand extends BaseMVCActionCommand {
	
	private static final Log log = LogFactoryUtil.getLog(DeletePriorityMasterMVCActionCommand.class);

	@Reference
	private PriorityMasterLocalService priorityMasterLocalService;

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse)
			throws Exception {
		
		super.hideDefaultErrorMessage(actionRequest);
		
		log.info("DeletePriorityMasterMVCActionCommand >>> doProcessAction ::: Delete process called");
		long priorityMasterId = ParamUtil.getLong(actionRequest, AxHrmsPriorityMasterWebPortletConstants.PRIORITY_MASTER_ID_VAR,AxHrmsPriorityMasterWebPortletConstants.DEFAULT_LONG_VALUE);
		
		PriorityMaster priorityMaster = null;
		
		try {
			priorityMaster = priorityMasterLocalService.getPriorityMaster(priorityMasterId);
		} catch (NumberFormatException | PortalException e) {
			log.error("DeletePriorityMasterMVCActionCommand >>> doProcessAction (MVCActionCommand) ::: Exception is: "+e.getMessage());
		}
		if(priorityMasterId > 0) {
			priorityMasterLocalService.deletePriorityMaster(priorityMaster);
			SessionMessages.add(actionRequest, AxHrmsPriorityMasterWebPortletConstants.PRIORITY_DELETED_MESSAGE_KEY);
		}
		else {
			SessionErrors.add(actionRequest, AxHrmsPriorityMasterWebPortletConstants.PRIORITY_DELETED_FAILED_MESSAGE_KEY);
		}

		actionResponse.sendRedirect(ParamUtil.getString(actionRequest,AxHrmsPriorityMasterWebPortletConstants.ITERATOR_URL_PARAMETER_NAME));
	}

}
