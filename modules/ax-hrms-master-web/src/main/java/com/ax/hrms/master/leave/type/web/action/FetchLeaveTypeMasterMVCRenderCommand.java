package com.ax.hrms.master.leave.type.web.action;

import com.ax.hrms.master.model.LeaveTypeMaster;
import com.ax.hrms.master.service.LeaveTypeMasterLocalService;
import com.ax.hrms.master.web.constants.AxHrmsLeaveTypeMasterWebPortletConstants;
import com.ax.hrms.master.web.constants.AxHrmsLeaveTypeMasterWebPortletKeys;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;


/**
 * 
 * @author krish.moradiya
 * @category Master Data : Leave Type Master Data Process like Fetch Leave type data and set into register form to edit it
 */
@Component(
	    immediate = true,
	    property = {
	    	"javax.portlet.name=" + AxHrmsLeaveTypeMasterWebPortletKeys.AXHRMS_LEAVE_TYPE_MASTER_WEB_PORTLET_KEYS,
	 	    "mvc.command.name=/fetchLeaveTypeDetails"
	    },
	    service = MVCRenderCommand.class
	)
public class FetchLeaveTypeMasterMVCRenderCommand implements MVCRenderCommand {

	private static Log log = LogFactoryUtil.getLog(FetchLeaveTypeMasterMVCRenderCommand.class);
	
	@Reference
	private LeaveTypeMasterLocalService leaveTypeMasterLocalService;
	
	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {

		log.info("FetchLeaveTypeMasterMVCRenderCommand >>> render (MVCRenderCommand) ::: Leave Type Master Register form with edit data render");
		long leaveTypeMasterId = ParamUtil.getLong(renderRequest, AxHrmsLeaveTypeMasterWebPortletConstants.LEAVE_TYPE_MASTER_ID_VAR, AxHrmsLeaveTypeMasterWebPortletConstants.DEFAULT_LONG_VALUE);
		if(leaveTypeMasterId > 0) {
			try {
				LeaveTypeMaster leaveTypeMaster = leaveTypeMasterLocalService.getLeaveTypeMaster(leaveTypeMasterId);
				renderRequest.setAttribute(AxHrmsLeaveTypeMasterWebPortletConstants.LEAVE_TYPE_MASTER_DATA_ATTRIBUTE_NAME, leaveTypeMaster);
			}catch(Exception e) {
				log.error("FetchLeaveTypeMasterMVCRenderCommand >>> render (MVCRenderCommand) ::: "+e.getMessage());
			}
		}
		return AxHrmsLeaveTypeMasterWebPortletConstants.ADD_LEAVE_TYPE_MASTER_JSP_PATH;
	}

}
