package com.ax.hrms.master.department.web.action;

import com.ax.hrms.master.model.DepartmentMaster;

import com.ax.hrms.master.service.DepartmentMasterLocalService;
import com.ax.hrms.master.service.DepartmentMasterLocalServiceUtil;
import com.ax.hrms.master.web.constants.AxDepartmentMasterWebPortletConstants;
import com.ax.hrms.master.web.constants.AxDepartmentMasterWebPortletKeys;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.ParamUtil;

import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, property = {
		"javax.portlet.name=" + AxDepartmentMasterWebPortletKeys.AXHRMS_DEPARTMENT_MASTER_WEB_PORTLET_KEYS,
		"mvc.command.name=/" }, service = MVCRenderCommand.class)

public class ViewDepartmentMasterListMVCRenderCommand implements MVCRenderCommand {

	private Log log = LogFactoryUtil.getLog(ViewDepartmentMasterListMVCRenderCommand.class);

	@Reference
	DepartmentMasterLocalService departmentMasterLocalService;

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {

		int currentPage = ParamUtil.getInteger(renderRequest, SearchContainer.DEFAULT_CUR_PARAM, 1);
        int delta = ParamUtil.getInteger(renderRequest, SearchContainer.DEFAULT_DELTA_PARAM, 5);

        int totalRecords = DepartmentMasterLocalServiceUtil.getDepartmentMastersCount();
        int totalPages = (totalRecords + delta - 1) / delta; // Calculate total pages
        
        if (currentPage > totalPages) {
            currentPage = totalPages;
        }
        
        int start = (currentPage - 1) * delta;
        int end = start + delta;
        
		List<DepartmentMaster> departmentMasters = departmentMasterLocalService.getDepartmentMasters(start, end);

		renderRequest.setAttribute(AxDepartmentMasterWebPortletConstants.DEPARTMENTS_MASTER, departmentMasters);
        renderRequest.setAttribute(AxDepartmentMasterWebPortletConstants.DEPARTMENT_MASTER_COUNT, totalRecords);
        renderRequest.setAttribute(AxDepartmentMasterWebPortletConstants.DELTA, delta);
		return AxDepartmentMasterWebPortletConstants.VIEW_DEPARTMENT_MASTER_JSP;
	}
}
