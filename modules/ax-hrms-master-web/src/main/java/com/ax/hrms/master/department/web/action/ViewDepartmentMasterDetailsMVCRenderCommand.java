package com.ax.hrms.master.department.web.action;

import com.ax.hrms.master.model.DepartmentMaster;


import com.ax.hrms.master.service.DepartmentMasterLocalService;
import com.ax.hrms.master.web.constants.AxDepartmentMasterWebPortletConstants;
import com.ax.hrms.master.web.constants.AxDepartmentMasterWebPortletKeys;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.ParamUtil;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
	    immediate = true,
	    property = {
	       "javax.portlet.name=" + AxDepartmentMasterWebPortletKeys.AXHRMS_DEPARTMENT_MASTER_WEB_PORTLET_KEYS,
	       "mvc.command.name=/viewDepartmentDataById"
	    },
	    service = MVCRenderCommand.class
	)
public class ViewDepartmentMasterDetailsMVCRenderCommand implements MVCRenderCommand{

	@Reference
	DepartmentMasterLocalService departmentMasterLocalService;
	
	private Log log = LogFactoryUtil.getLog(ViewDepartmentMasterDetailsMVCRenderCommand.class);
	
	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
	
		long departmentMasterId =ParamUtil.getLong(renderRequest, AxDepartmentMasterWebPortletConstants.DEPARTMENTS_MASTER_ID);
		try {
			DepartmentMaster getDepartmentMasterRecord=departmentMasterLocalService.getDepartmentMaster(departmentMasterId);
			
			renderRequest.setAttribute(AxDepartmentMasterWebPortletConstants.GET_DEPARTMENT_MASTER_RECORD, getDepartmentMasterRecord);
		} catch (Exception e) {
			log.error(e.getMessage());
		} 
		return AxDepartmentMasterWebPortletConstants.DEPARTMENT_MASTER_RECORD;
	}
}
