package com.ax.hrms.employee.onboarding.hr.web.action;

import com.ax.hrms.common.api.api.AxHrmsCommonApi;
import com.ax.hrms.employee.onboarding.employee.web.util.EmployeeBasicDetailsUtil;
import com.ax.hrms.employee.onboarding.web.constants.AxHrmsEmployeeOnBoardingEmployeeConstants;
import com.ax.hrms.employee.onboarding.web.constants.AxHrmsEmployeeOnboardingHrWebPortletConstants;
import com.ax.hrms.employee.onboarding.web.constants.AxHrmsEmployeeOnboardingWebPortletKeys;
import com.ax.hrms.master.model.DepartmentMaster;
import com.ax.hrms.master.model.DesignationMaster;
import com.ax.hrms.master.service.DepartmentMasterLocalService;
import com.ax.hrms.master.service.DesignationMasterLocalService;
import com.ax.hrms.model.EmployeeDepartment;
import com.ax.hrms.model.EmployeeDesignation;
import com.ax.hrms.model.EmployeeDetails;
import com.ax.hrms.model.EmployeeSalary;
import com.ax.hrms.service.EmployeeDepartmentLocalService;
import com.ax.hrms.service.EmployeeDesignationLocalService;
import com.ax.hrms.service.EmployeeDetailsLocalService;
import com.ax.hrms.service.EmployeeSalaryLocalService;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.repository.model.Folder;
import com.liferay.portal.kernel.service.RoleLocalService;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.service.RoleService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.Localization;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.roles.admin.role.type.contributor.provider.RoleTypeContributorProvider;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, property = {
		"javax.portlet.name=" + AxHrmsEmployeeOnboardingWebPortletKeys.AX_HRMS_EMPLOYEE_ONBOARDING_HR_WEB,
		"mvc.command.name=/addEditEmployeeOnBoarding" }, service = MVCActionCommand.class)
public class AddEditEmployeeOnBoardingMVCActionCommmand extends BaseMVCActionCommand {

	@Reference
	EmployeeDetailsLocalService employeeDetailsLocalService;

	@Reference
	EmployeeSalaryLocalService employeeSalaryLocalService;

	@Reference
	AxHrmsCommonApi axHrmsCommonApi;

	@Reference
	UserLocalService userLocalService;

	@Reference
	DepartmentMasterLocalService departmentMasterLocalService;

	@Reference
	DesignationMasterLocalService designationMasterLocalService;

	@Reference
	EmployeeDesignationLocalService employeeDesignationLocalService;

	@Reference
	EmployeeDepartmentLocalService employeeDepartmentLocalService;

	@Reference
	private Localization localization;

	@Reference
	private RoleLocalService roleLocalService;

	@Reference
	private RoleService roleService;

	@Reference
	private RoleTypeContributorProvider roleTypeContributorProvider;

	private Log log = LogFactoryUtil.getLog(AddEditEmployeeOnBoardingMVCActionCommmand.class);

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {

		log.info("AddEditEmployeeOnBoardingMVCActionCommmand >>> doProcessAction ::: Action Called ::: ");

		long employeeId = ParamUtil.getLong(actionRequest, AxHrmsEmployeeOnBoardingEmployeeConstants.EMPLOYEE_ID);

		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		ServiceContext serviceContext = ServiceContextFactory.getInstance(Folder.class.getName(), actionRequest);
		serviceContext.setAddGroupPermissions(true);
		serviceContext.setAddGuestPermissions(false);

		Folder folder = axHrmsCommonApi.createFolder(AxHrmsEmployeeOnBoardingEmployeeConstants.HRMS_DOCUMENT, 0,themeDisplay, serviceContext);
		Folder parentFolder = axHrmsCommonApi.createFolder(String.format("%s%d", themeDisplay.getUser().getScreenName(), themeDisplay.getUserId()),folder.getFolderId(), themeDisplay, serviceContext);
		Folder profilePictureFolder = axHrmsCommonApi.createFolder(AxHrmsEmployeeOnBoardingEmployeeConstants.PROFILE_PICTURE, parentFolder.getFolderId(), themeDisplay,serviceContext);

		UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(actionRequest);
		File file = uploadRequest.getFile(AxHrmsEmployeeOnBoardingEmployeeConstants.EMPLOYEE_PROFILE_PICTURE);
		String fileName = uploadRequest.getFileName(AxHrmsEmployeeOnBoardingEmployeeConstants.EMPLOYEE_PROFILE_PICTURE);

		EmployeeDetails employeeDetails = employeeDetailsLocalService.getEmployeeDetails(ParamUtil.getLong(actionRequest, "employeeId"));
		employeeDetails.setPersonalEmail(ParamUtil.getString(actionRequest, AxHrmsEmployeeOnBoardingEmployeeConstants.PERSONAL_EMAIL));
		employeeDetails.setMobileNo(ParamUtil.getString(actionRequest, AxHrmsEmployeeOnBoardingEmployeeConstants.MOBILE_NUMBER));
		employeeDetails.setSkypeId(ParamUtil.getString(actionRequest, AxHrmsEmployeeOnBoardingEmployeeConstants.SKYPE_ID));
		employeeDetails.setFatherName(ParamUtil.getString(actionRequest, AxHrmsEmployeeOnBoardingEmployeeConstants.FATHER_NAME));
		employeeDetails.setMaritalStatus(ParamUtil.getBoolean(actionRequest, AxHrmsEmployeeOnBoardingEmployeeConstants.MARTIAL_STATUS));
		employeeDetails.setSpouseName(ParamUtil.getString(actionRequest, AxHrmsEmployeeOnBoardingEmployeeConstants.SPOUSE_NAME));

		try {
			SimpleDateFormat formatter = new SimpleDateFormat(AxHrmsEmployeeOnBoardingEmployeeConstants.DATE_FORMAT,Locale.ENGLISH);
			employeeDetails.setDateOfBirth(formatter.parse(ParamUtil.getString(actionRequest, AxHrmsEmployeeOnBoardingEmployeeConstants.DATE_OF_BIRTH)));
			employeeDetails.setMarriageDate(formatter.parse(ParamUtil.getString(actionRequest, AxHrmsEmployeeOnBoardingEmployeeConstants.MARRIAGE_DATE)));
		} catch (Exception e) {
			log.error("Error parsing date format: " + e.getMessage());
		}

		long hrRoleId = RoleLocalServiceUtil.getRole(themeDisplay.getCompanyId(), "HR Admin").getRoleId();
		long[] hrRoles = themeDisplay.getUser().getRoleIds();
		boolean isHr = Arrays.stream(hrRoles).anyMatch(id -> id == hrRoleId);

		if (isHr) {
			String employeeCode = ParamUtil.getString(actionRequest,AxHrmsEmployeeOnboardingHrWebPortletConstants.EMPLOYEE_CODE);
			String firstName = ParamUtil.getString(actionRequest,AxHrmsEmployeeOnboardingHrWebPortletConstants.FIRST_NAME);
			String lastName = ParamUtil.getString(actionRequest,AxHrmsEmployeeOnboardingHrWebPortletConstants.LAST_NAME);
			String middleName = ParamUtil.getString(actionRequest,AxHrmsEmployeeOnboardingHrWebPortletConstants.MIDDLE_NAME);
			boolean isProbationEnabled = ParamUtil.getBoolean(actionRequest,AxHrmsEmployeeOnboardingHrWebPortletConstants.IS_PROBBATION_ENABLED);
			String insuranceLink = ParamUtil.getString(actionRequest,AxHrmsEmployeeOnboardingHrWebPortletConstants.INSURANCE_LINK);
			String joiningDate = ParamUtil.getString(actionRequest,AxHrmsEmployeeOnboardingHrWebPortletConstants.JOINING_DATE);
			String gender = ParamUtil.getString(actionRequest, AxHrmsEmployeeOnboardingHrWebPortletConstants.GENDER);
			long designations = ParamUtil.getLong(actionRequest,AxHrmsEmployeeOnboardingHrWebPortletConstants.DESIGNATION);
			long[] departments = ParamUtil.getLongValues(actionRequest,AxHrmsEmployeeOnboardingHrWebPortletConstants.DEPARTMENT);
			boolean isExperienced = ParamUtil.getBoolean(actionRequest,AxHrmsEmployeeOnboardingHrWebPortletConstants.IS_EXPERIENCED);
			double grossSalaryCTCPM = ParamUtil.getDouble(actionRequest,AxHrmsEmployeeOnboardingHrWebPortletConstants.GROSS_SALARY_CTC_PM);
			double grossSalaryCTCPA = ParamUtil.getDouble(actionRequest,AxHrmsEmployeeOnboardingHrWebPortletConstants.GROSS_SALARY_CTC_PA);

			SimpleDateFormat formatter = new SimpleDateFormat(AxHrmsEmployeeOnboardingHrWebPortletConstants.DATE_FORMAT,Locale.ENGLISH);
			Date joiningDateParsed = formatter.parse(joiningDate);

			employeeDetails.setJoiningDate(joiningDateParsed);
			employeeDetails.setEmployeeCode(employeeCode);
			employeeDetails.setFirstName(firstName);
			employeeDetails.setLastName(lastName);
			employeeDetails.setGender(gender);
			employeeDetails.setIsExperienced(isExperienced);
			employeeDetails.setInsuranceLink(insuranceLink);
			employeeDetails.setIsTerminated(false);
			employeeDetails.setCreatedBy(themeDisplay.getUserId());
			employeeDetails.setGroupId(themeDisplay.getCompanyGroupId());
			employeeDetails.setIsProbationEnabled(isProbationEnabled);

			EmployeeSalary employeeSalary = employeeSalaryLocalService.findByEmployeeIdAndStatus(employeeId, false);
			employeeSalary.setGrossSalaryCtcPa(grossSalaryCTCPA);
			employeeSalary.setGrossSalaryCtcPm(grossSalaryCTCPM);
			employeeSalaryLocalService.updateEmployeeSalary(employeeSalary);

			User user = userLocalService.getUser(employeeDetails.getLrUserId());
			user.setFirstName(firstName);
			user.setLastName(lastName);
			user.setMiddleName(middleName);
			userLocalService.updateUser(user);
			
		
			List<DesignationMaster> oldDesignationMasterList=axHrmsCommonApi.getDesignationMastersFromEmployeeId(employeeId);
			
			for(DesignationMaster old:oldDesignationMasterList) {
				 Role role = roleService.getRole(themeDisplay.getCompanyId(), old.getDesignationName());
				 RoleLocalServiceUtil.deleteUserRole(employeeDetails.getLrUserId(), role.getRoleId());
			}
			
			DesignationMaster designationMaster;
			try {
				EmployeeDesignation employeeDesignation = employeeDesignationLocalService.createEmployeeDesignation(CounterLocalServiceUtil.increment(EmployeeDesignation.class.getName()));

				employeeDesignation.setCompanyId(themeDisplay.getCompanyId());
				employeeDesignation.setCreatedBy(themeDisplay.getUserId());
				employeeDesignation.setGroupId(themeDisplay.getCompanyGroupId());
				employeeDesignation.setCreateDate(new Date());
				employeeDesignation.setModifiedDate(new Date());

				employeeDesignation.setDesignationMasterId(designations);
				employeeDesignation.setStatus(false);
				employeeDesignation.setStartDate(new Date());
				employeeDesignation.setEndDate(new Date());
				employeeDesignation.setEmployeeId(employeeDetails.getEmployeeId());

				designationMaster = designationMasterLocalService.findByDesignationNameById(employeeDesignation.getDesignationMasterId());

				String newDesignationRole = designationMaster.getDesignationName();

				employeeDesignationLocalService.addEmployeeDesignation(employeeDesignation);

				Role newDesignationsRole = roleService.getRole(themeDisplay.getCompanyId(), newDesignationRole);

				RoleLocalServiceUtil.addUserRole(employeeDetails.getLrUserId(), newDesignationsRole);

			} catch (Exception e) {
				log.error(e.getMessage());
			}

			List<DepartmentMaster> oldDepartmentMastersList = axHrmsCommonApi.getDepartmentMastersFromEmployeeId(employeeId); // depratments already assigned to the employee
			List<DepartmentMaster> recievedDepartmentMasterList = new ArrayList<>(); // departments coming from the request
			List<DepartmentMaster> addedDepartmentMasterList = new ArrayList<>();
			List<DepartmentMaster> removedDepartmentMasterList = new ArrayList<>();

			for (long dId : departments) {
				recievedDepartmentMasterList.add(departmentMasterLocalService.getDepartmentMaster(dId));
			}

			// Fill addedDepartmentMasterList
			addedDepartmentMasterList.addAll(recievedDepartmentMasterList.stream()
					.filter(received -> oldDepartmentMastersList.stream()
							.noneMatch(old -> old.getDepartmentMasterId() == (received.getDepartmentMasterId())))
					.collect(Collectors.toList()));

			// Fill removedDepartmentMasterList
			removedDepartmentMasterList.addAll(oldDepartmentMastersList.stream()
					.filter(old -> recievedDepartmentMasterList.stream()
							.noneMatch(received -> received.getDepartmentMasterId() == (old.getDepartmentMasterId())))
					.collect(Collectors.toList()));
			
			DepartmentMaster departmentMaster;
			for (DepartmentMaster added : addedDepartmentMasterList) {
				
				EmployeeDepartment	employeeDepartment = employeeDepartmentLocalService.createEmployeeDepartment(CounterLocalServiceUtil.increment(EmployeeDepartment.class.getName()));

				 employeeDepartment.setCompanyId(themeDisplay.getCompanyId());
		         employeeDepartment.setCreatedBy(themeDisplay.getUserId());
		         employeeDepartment.setGroupId(themeDisplay.getCompanyGroupId());
		         employeeDepartment.setCreateDate(new Date());
		         employeeDepartment.setModifiedDate(new Date());
		         employeeDepartment.setDepartmentMasterId(added.getDepartmentMasterId());
		         
		         
		         employeeDepartment.setStatus(true);
		         employeeDepartment.setDateOfChange(new Date());
		         employeeDepartment.setEmployeeId(employeeDetails.getEmployeeId());
		         
		         employeeDepartmentLocalService.addEmployeeDepartment(employeeDepartment);
		         
		         departmentMaster=departmentMasterLocalService.findByDepartmentNameById(employeeDepartment.getDepartmentMasterId());
		         String newDepartmentName =departmentMaster.getDepartmentName();
				 Role newDesignationsRole = roleService.getRole(themeDisplay.getCompanyId(), newDepartmentName);

				RoleLocalServiceUtil.addUserRole(employeeDetails.getLrUserId(), newDesignationsRole);
		         
		    }
			
			for(DepartmentMaster delete:removedDepartmentMasterList ) {
				
				EmployeeDepartment employeeDepartment=employeeDepartmentLocalService.findByEmployeeIdAndStatusAndDepartmentMasterId(delete.getDepartmentMasterId(), true, employeeId);
				employeeDepartment.setCompanyId(themeDisplay.getCompanyId());
		         employeeDepartment.setCreatedBy(themeDisplay.getUserId());
		         employeeDepartment.setGroupId(themeDisplay.getCompanyGroupId());
		         employeeDepartment.setCreateDate(new Date());
		         employeeDepartment.setModifiedDate(new Date());
		         employeeDepartment.setDepartmentMasterId(delete.getDepartmentMasterId());
		         employeeDepartment.setStatus(false);
		         employeeDepartment.setDateOfChange(new Date());
		         employeeDepartment.setEmployeeId(employeeDetails.getEmployeeId());
				employeeDepartmentLocalService.updateEmployeeDepartment(employeeDepartment);
				
				departmentMaster=departmentMasterLocalService.findByDepartmentNameById(employeeDepartment.getDepartmentMasterId());
				String oldDepartmentName =departmentMaster.getDepartmentName();
				 
				Role role = roleService.getRole(themeDisplay.getCompanyId(), oldDepartmentName);
				RoleLocalServiceUtil.deleteUserRole(employeeDetails.getLrUserId(), role.getRoleId());
				
			}
		}

		EmployeeBasicDetailsUtil employeeBasicDetailsUtil = new EmployeeBasicDetailsUtil();
		employeeBasicDetailsUtil.addEditFileEntry(file, fileName, actionRequest, employeeDetails, profilePictureFolder,serviceContext);

		employeeDetailsLocalService.updateEmployeeDetails(employeeDetails);
	}
}