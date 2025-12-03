package com.ax.hrms.master.department.web.action;

import com.ax.hrms.master.model.DepartmentMaster;
import com.ax.hrms.master.service.DepartmentMasterLocalService;
import com.ax.hrms.master.web.constants.AxDepartmentMasterWebPortletConstants;
import com.ax.hrms.master.web.constants.AxDepartmentMasterWebPortletKeys;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.RoleConstants;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.RoleLocalService;
import com.liferay.portal.kernel.service.RoleService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.Localization;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.roles.admin.role.type.contributor.RoleTypeContributor;
import com.liferay.roles.admin.role.type.contributor.provider.RoleTypeContributorProvider;

import java.util.Locale;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, property = {
		"javax.portlet.name=" + AxDepartmentMasterWebPortletKeys.AXHRMS_DEPARTMENT_MASTER_WEB_PORTLET_KEYS,
		"mvc.command.name=/saveDepartmentsDetails" }, service = MVCActionCommand.class)
public class AddEditDepartmentMasterActionCommand extends BaseMVCActionCommand {

	private Log log = LogFactoryUtil.getLog(AddEditDepartmentMasterActionCommand.class);

	@Reference
	DepartmentMasterLocalService departmentMasterLocalService;

	@Reference
	private RoleLocalService roleLocalService;

	@Reference
	Localization localization;

	@Reference
	private RoleService roleService;

	@Reference
	private RoleTypeContributorProvider roleTypeContributorProvider;

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {

		final ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);

		final DepartmentMaster departmentMaster;

		String departmentName = ParamUtil.getString(actionRequest,AxDepartmentMasterWebPortletConstants.DEPARTMENT_NAME);

		Long departmentMasterId = ParamUtil.getLong(actionRequest,AxDepartmentMasterWebPortletConstants.DEPARTMENTS_MASTER_ID);

		if (departmentMasterId <= 0) {
			// Insert Employee Master Details
			try {
				if (!(departmentMasterLocalService.isNameExist(departmentName.toLowerCase()))) {

					departmentMaster = departmentMasterLocalService.createDepartmentMaster(CounterLocalServiceUtil.increment(DepartmentMaster.class.getName()));
					departmentMaster.setCompanyId(themeDisplay.getCompanyId());
					departmentMaster.setGroupId(themeDisplay.getScopeGroupId());

					departmentMaster.setCreatedBy(themeDisplay.getUserId());
					departmentMaster.setModifiedBy(themeDisplay.getUserId());

					departmentMaster.setDepartmentName(departmentName);
					
					addRole(departmentName, actionRequest);
					departmentMasterLocalService.addDepartmentMaster(departmentMaster);

					SessionMessages.add(actionRequest, AxDepartmentMasterWebPortletConstants.DEPARTMENT_ADDED);
				} else {
					SessionErrors.add(actionRequest, AxDepartmentMasterWebPortletConstants.DEPARTMENT_EXISTS);
					actionRequest.setAttribute(AxDepartmentMasterWebPortletConstants.EXISTED_DEPARTMENT_NAME,departmentName);
					actionResponse.setRenderParameter(AxDepartmentMasterWebPortletConstants.MVC_PATH,AxDepartmentMasterWebPortletConstants.ADD_DEPARTMENT_MASTER_JSP);
					super.hideDefaultErrorMessage(actionRequest);
				}
			} catch (Exception e) {
				log.info("Error in catch ===> " + e.getMessage());
			}
		} else {
			// Updated Employee Master Details
			departmentMaster = departmentMasterLocalService.getDepartmentMaster(departmentMasterId);
			try {
				if (!departmentMasterLocalService.isNameExist(departmentName)|| departmentMaster.getDepartmentMasterId() == departmentMasterLocalService.findByDepartmentName(departmentName).getDepartmentMasterId()) {
					departmentMaster.setCompanyId(themeDisplay.getCompanyId());
					departmentMaster.setGroupId(themeDisplay.getScopeGroupId());
					departmentMaster.setModifiedBy(themeDisplay.getUserId());

					updateRole(departmentMaster.getDepartmentName(), departmentName, actionRequest, themeDisplay);
					departmentMaster.setDepartmentName(departmentName);
					departmentMasterLocalService.updateDepartmentMaster(departmentMaster);
				} else {
					SessionErrors.add(actionRequest, AxDepartmentMasterWebPortletConstants.DEPARTMENT_EXISTS);
					actionRequest.setAttribute(AxDepartmentMasterWebPortletConstants.EXISTED_DEPARTMENT_NAME,departmentName);
					actionResponse.setRenderParameter(AxDepartmentMasterWebPortletConstants.MVC_PATH,AxDepartmentMasterWebPortletConstants.ADD_DEPARTMENT_MASTER_JSP);
					super.hideDefaultErrorMessage(actionRequest);
				}
			} catch (Exception e) {
				log.info("Error  in Update Empolyee Master Details " + e.getMessage());
			}
		}
	}

	public void addRole(String departmentName, ActionRequest actionRequest) throws PortalException {
		try {
			Map<Locale, String> titleMap = localization.getLocalizationMap(actionRequest, departmentName);

			Map<Locale, String> defaultDescription = localization.getLocalizationMap(actionRequest,"This is an autogenerated role from the workflow definition.");

			Map<Locale, String> descriptionMap = localization.getLocalizationMap(actionRequest, "description",defaultDescription);

			ServiceContext serviceContext = ServiceContextFactory.getInstance(Role.class.getName(), actionRequest);

			int type = ParamUtil.getInteger(actionRequest, "roleType", RoleConstants.TYPE_REGULAR);

			RoleTypeContributor roleTypeContributor = roleTypeContributorProvider.getRoleTypeContributor(type);

			roleService.addRole(roleTypeContributor.getClassName(), 0, departmentName, titleMap, descriptionMap, type,null, serviceContext);
		} catch (Exception e) {
			log.error("error while add role ===>" + e.getMessage());
		}
	}

	public void updateRole(String olddepartmentName, String newDepartmentName, ActionRequest actionRequest,ThemeDisplay themeDisplay) throws PortalException {
		try {
			Map<Locale, String> titleMap = localization.getLocalizationMap(actionRequest, olddepartmentName);

			Map<Locale, String> defaultDescription = localization.getLocalizationMap(actionRequest,"This is an autogenerated role from the workflow definition.");

			Map<Locale, String> descriptionMap = localization.getLocalizationMap(actionRequest, "description",defaultDescription);

			ServiceContext serviceContext = ServiceContextFactory.getInstance(Role.class.getName(), actionRequest);

			Role role = roleService.getRole(themeDisplay.getCompanyId(), olddepartmentName);

			roleService.updateRole(role.getRoleId(), newDepartmentName, titleMap, descriptionMap, null, serviceContext);
		} catch (Exception e) {
			log.error("error while add role ===>" + e.getMessage());
		}
	}
}
