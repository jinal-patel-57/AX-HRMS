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
 * @category Master Data : Leave Type Master Data Process like View Leave type
 */
@Component(
	    immediate = true,
	    property = {
	    	"javax.portlet.name=" + AxHrmsLeaveTypeMasterWebPortletKeys.AXHRMS_LEAVE_TYPE_MASTER_WEB_PORTLET_KEYS,
	 	    "mvc.command.name=/viewLeaveTypeDetail"
	    },
	    service = MVCRenderCommand.class
	)
public class ViewLeaveTypeDetailMVCRenderCommand implements MVCRenderCommand {

	
	private static Log log = LogFactoryUtil.getLog(ViewLeaveTypeDetailMVCRenderCommand.class);
	
	@Reference
	private LeaveTypeMasterLocalService leaveTypeMasterLocalService;
	
	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		long leaveTypeMasterId = ParamUtil.getLong(renderRequest, AxHrmsLeaveTypeMasterWebPortletConstants.LEAVE_TYPE_MASTER_ID_VAR, AxHrmsLeaveTypeMasterWebPortletConstants.DEFAULT_LONG_VALUE);
		if(leaveTypeMasterId > 0) {
			try {					
				LeaveTypeMaster leaveTypeMaster = leaveTypeMasterLocalService.getLeaveTypeMaster(leaveTypeMasterId);
				renderRequest.setAttribute(AxHrmsLeaveTypeMasterWebPortletConstants.LEAVE_TYPE_MASTER_DATA_ATTRIBUTE_NAME, leaveTypeMaster);
			}catch(Exception e) {
				log.error("ViewLeaveTypeDetailMVCRenderCommand >>> render ::: "+e.getMessage());
			}
		}
		return AxHrmsLeaveTypeMasterWebPortletConstants.VIEW_LEAVE_TYPE_MASTER_JSP_PATH;
	}

}
