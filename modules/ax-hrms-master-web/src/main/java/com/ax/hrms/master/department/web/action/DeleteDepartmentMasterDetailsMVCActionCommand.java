package com.ax.hrms.master.department.web.action;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.ax.hrms.master.exception.NoSuchDepartmentMasterException;
import com.ax.hrms.master.model.DepartmentMaster;
import com.ax.hrms.master.service.DepartmentMasterLocalService;
import com.ax.hrms.master.web.constants.AxDepartmentMasterWebPortletConstants;
import com.ax.hrms.master.web.constants.AxDepartmentMasterWebPortletKeys;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.RoleLocalService;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;

@Component(
	    immediate = true,
	    property = {
	       "javax.portlet.name=" + AxDepartmentMasterWebPortletKeys.AXHRMS_DEPARTMENT_MASTER_WEB_PORTLET_KEYS,
	       "mvc.command.name=/deleteRecordById"
	    },
	    service = MVCActionCommand.class
	)
public class DeleteDepartmentMasterDetailsMVCActionCommand extends BaseMVCActionCommand{

	private Log log=LogFactoryUtil.getLog(DeleteDepartmentMasterDetailsMVCActionCommand.class);
	
	@Reference
	DepartmentMasterLocalService departmentMasterLocalService;
	
	@Reference
	private RoleLocalService roleLocalService;
	
	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		
		Long departmentMasterId = ParamUtil.getLong(actionRequest, AxDepartmentMasterWebPortletConstants.DEPARTMENTS_MASTER_ID);
		
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
		if (departmentMasterId == null || departmentMasterId <= 0) {
	        SessionErrors.add(actionRequest, AxDepartmentMasterWebPortletConstants.DEPARTMENTID_REQUIRED);
	        return;
	    }
		
	    try {
	    	DepartmentMaster departmentMaster = departmentMasterLocalService.getDepartmentMaster(departmentMasterId);
			Role role = roleLocalService.fetchRole(themeDisplay.getCompanyId(),departmentMaster.getDepartmentName());
			roleLocalService.deleteRole(role);
	    	departmentMasterLocalService.deleteDepartmentMaster(departmentMasterId);
	        SessionMessages.add(actionRequest, AxDepartmentMasterWebPortletConstants.DEPARTMENT_DELETED);
	        actionResponse.sendRedirect(ParamUtil.getString(actionRequest, AxDepartmentMasterWebPortletConstants.ITERATOR_URL));
	    } catch (NoSuchDepartmentMasterException nsde) {
	        SessionErrors.add(actionRequest, AxDepartmentMasterWebPortletConstants.DEPARTMENT_NOT_FOUND);
	    } catch (Exception e) {
	        log.error("Error deleting department: " + e.getMessage(), e);
	    }
	}
}
