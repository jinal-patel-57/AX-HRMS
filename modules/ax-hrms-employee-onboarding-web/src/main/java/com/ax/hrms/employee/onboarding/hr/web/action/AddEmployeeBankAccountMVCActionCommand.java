package com.ax.hrms.employee.onboarding.hr.web.action;
import com.ax.hrms.employee.onboarding.web.constants.AxHrmsEmployeeOnBoardingEmployeeConstants;
import com.ax.hrms.employee.onboarding.web.constants.AxHrmsEmployeeOnboardingWebPortletKeys;
import com.ax.hrms.model.EmployeeBankAccount;
import com.ax.hrms.model.EmployeeDetails;
import com.ax.hrms.service.EmployeeBankAccountLocalService;
import com.ax.hrms.service.EmployeeDetailsLocalService;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, property = {
		"javax.portlet.name=" + AxHrmsEmployeeOnboardingWebPortletKeys.AX_HRMS_EMPLOYEE_ONBOARDING_HR_WEB,
		"mvc.command.name=/addEditEmployeeBankAccountURL" }, service = MVCActionCommand.class)
public class AddEmployeeBankAccountMVCActionCommand extends BaseMVCActionCommand {

	private Log log = LogFactoryUtil.getLog(AddEmployeeBankAccountMVCActionCommand.class);

	@Reference
	EmployeeBankAccountLocalService employeeBankAccountLocalService;

	@Reference
	EmployeeDetailsLocalService employeeDetailsLocalService;

	private long employeeBankAccountId=0;
	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		log.info("AddEmployeeBankAccountMVCActionCommand >>> doProcessAction ::: Action Called :::");

		String accountNumber = ParamUtil.getString(actionRequest, AxHrmsEmployeeOnBoardingEmployeeConstants.ACCOUNT_NUMBER);
		String accountType = ParamUtil.getString(actionRequest, AxHrmsEmployeeOnBoardingEmployeeConstants.ACCOUNT_TYPE);
		String beneficiaryName = ParamUtil.getString(actionRequest, AxHrmsEmployeeOnBoardingEmployeeConstants.BENEFICIARY_NAME);
		String bankName = ParamUtil.getString(actionRequest, AxHrmsEmployeeOnBoardingEmployeeConstants.BANK_NAME);
		String ifscCode = ParamUtil.getString(actionRequest, AxHrmsEmployeeOnBoardingEmployeeConstants.IFSC_CODE);
		String bankBranch = ParamUtil.getString(actionRequest, AxHrmsEmployeeOnBoardingEmployeeConstants.BANK_BRANCH);
		long employeeId = ParamUtil.getLong(actionRequest,AxHrmsEmployeeOnBoardingEmployeeConstants.EMPLOYEE_ID);
		
		String flag = ParamUtil.getString(actionRequest, AxHrmsEmployeeOnBoardingEmployeeConstants.UPDATE_FLAG_BANK);
		
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);

		log.info("Bank Flag ===>" + flag);
		if (!areAnyFieldsEmpty(accountNumber, accountType, beneficiaryName, bankName, ifscCode, bankBranch)) {

		if(flag.equals(AxHrmsEmployeeOnBoardingEmployeeConstants.FALSE)){
			try {
				EmployeeBankAccount employeeBankAccount = employeeBankAccountLocalService.createEmployeeBankAccount(CounterLocalServiceUtil.increment(EmployeeBankAccount.class.getName()));

				employeeBankAccount.setCompanyId(themeDisplay.getCompanyId());
				employeeBankAccount.setGroupId(themeDisplay.getScopeGroupId());
				employeeBankAccount.setCreatedBy(themeDisplay.getUserId());
				employeeBankAccount.setModifiedBy(themeDisplay.getUserId());

				employeeBankAccount.setAccountNumber(accountNumber);
				employeeBankAccount.setAccountType(accountType);
				employeeBankAccount.setBeneficiaryName(beneficiaryName);
				employeeBankAccount.setBankName(bankName);
				employeeBankAccount.setIfscCode(ifscCode);
				employeeBankAccount.setBankBranch(bankBranch);
				employeeBankAccount.setStatus(true);
				
				employeeBankAccountId=employeeBankAccount.getBankAccountId();
				EmployeeDetails employeeDetails = employeeDetailsLocalService.findByLrUserId(themeDisplay.getUserId());
				employeeBankAccount.setEmployeeId(employeeDetails.getEmployeeId());

				employeeDetails.setBankAccountId(employeeBankAccount.getBankAccountId());
				employeeDetailsLocalService.updateEmployeeDetails(employeeDetails);

				employeeBankAccountLocalService.addEmployeeBankAccount(employeeBankAccount);
			} catch (Exception e) {
				log.error("error in catch ==>" + e.getMessage());
			}
		} else {
			try {
				EmployeeBankAccount employeeBankAccount = employeeBankAccountLocalService.getEmployeeBankAccount(employeeBankAccountId);

				employeeBankAccount.setCompanyId(themeDisplay.getCompanyId());
				employeeBankAccount.setGroupId(themeDisplay.getScopeGroupId());
				employeeBankAccount.setCreatedBy(themeDisplay.getUserId());
				employeeBankAccount.setModifiedBy(themeDisplay.getUserId());
				employeeBankAccount.setAccountNumber(accountNumber);
				employeeBankAccount.setAccountType(accountType);
				employeeBankAccount.setBeneficiaryName(beneficiaryName);
				employeeBankAccount.setBankName(bankName);
				employeeBankAccount.setIfscCode(ifscCode);
				employeeBankAccount.setBankBranch(bankBranch);
				employeeBankAccount.setStatus(true);
				EmployeeDetails employeeDetails = employeeDetailsLocalService.getEmployeeDetails(employeeId);
				employeeBankAccount.setEmployeeId(employeeDetails.getEmployeeId());

				employeeBankAccountLocalService.updateEmployeeBankAccount(employeeBankAccount);
			} catch (Exception e) {
				log.error("error in bankAccount while Update");
			}
		}
		}
	}
	private boolean areAnyFieldsEmpty(String... fields) {
	    for (String field : fields) {
	        if (field == null || field.trim().isEmpty()) {
	            return true;
	        }
	    }
	    return false;
	}
}