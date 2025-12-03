package com.ax.hrms.master.leave.policy.web.action;

import com.ax.hrms.master.model.LeaveTypeMaster;

import com.ax.hrms.master.service.LeaveTypeMasterLocalService;
import com.ax.hrms.master.web.constants.AxLeavePolicyMasterWebPortletConstants;
import com.ax.hrms.master.web.constants.AxLeavePolicyMasterWebPortletKeys;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;

import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, property = {
		"javax.portlet.name=" + AxLeavePolicyMasterWebPortletKeys.AXHRMS_LEAVE_POLICY_MASTER_WEB_PORTLET_KEY,
		"mvc.command.name=/fetchLeaveTypes" },
service = MVCRenderCommand.class)
public class FetchLeaveTypesMVCRenderCommand implements MVCRenderCommand {

	@Reference
	LeaveTypeMasterLocalService leaveTypeMasterLocalService;

	private Log log = LogFactoryUtil.getLog(FetchLeaveTypesMVCRenderCommand.class);

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {

		try {
			List<LeaveTypeMaster> leaveTypeMasterList = leaveTypeMasterLocalService.getLeaveTypeMasters(-1, -1);
			renderRequest.setAttribute(AxLeavePolicyMasterWebPortletConstants.LEAVE_TYPE_MASTER_LIST,
					leaveTypeMasterList);
		} catch (Exception e) {
			log.error("FetchLeaveTypeMasterListMVCRenderCommand >>> render >>> error in catch " + e.getMessage());
		}
		return AxLeavePolicyMasterWebPortletConstants.ADD_LEAVE_POLICY_MASTER_JSP;
	}
}
