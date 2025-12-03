package com.ax.hrms.master.department.web.action;

import com.ax.hrms.master.model.DepartmentMaster;


import com.ax.hrms.master.service.DepartmentMasterLocalService;
import com.ax.hrms.master.web.constants.AxDepartmentMasterWebPortletConstants;
import com.ax.hrms.master.web.constants.AxDepartmentMasterWebPortletKeys;
import com.liferay.portal.kernel.exception.PortalException;
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
	       "mvc.command.name=/showDepartmentDataById"
	    },
	    service = MVCRenderCommand.class
	)
public class FetchDepartmentMasterMVCRenderCommand implements MVCRenderCommand {
	
private Log log = LogFactoryUtil.getLog(FetchDepartmentMasterMVCRenderCommand.class);
    
	@Reference
	DepartmentMasterLocalService departmentMasterLocalService;
	
	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		
		long departmentMasterId =ParamUtil.getLong(renderRequest, AxDepartmentMasterWebPortletConstants.DEPARTMENTS_MASTER_ID);
		
		try {
			DepartmentMaster getdepartmentMaster=departmentMasterLocalService.getDepartmentMaster(departmentMasterId);
			renderRequest.setAttribute(AxDepartmentMasterWebPortletConstants.GET_DEPARTMENT_MASTER, getdepartmentMaster);
			
		} catch (PortalException e) {
			log.error(e.getMessage());
		}
		
		return AxDepartmentMasterWebPortletConstants.ADD_DEPARTMENT_MASTER_JSP;
	}
}
