package com.ax.hrms.employee.onboarding.employee.web.action;

import com.ax.hrms.employee.onboarding.web.constants.AxHrmsEmployeeOnBoardingEmployeeConstants;
import com.ax.hrms.employee.onboarding.web.constants.AxHrmsEmployeeOnboardingWebPortletKeys;
import com.ax.hrms.model.Address;
import com.ax.hrms.model.EmployeeAddress;
import com.ax.hrms.model.EmployeeDetails;
import com.ax.hrms.service.AddressLocalService;
import com.ax.hrms.service.EmployeeAddressLocalService;
import com.ax.hrms.service.EmployeeDetailsLocalService;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, property = {
		"javax.portlet.name=" + AxHrmsEmployeeOnboardingWebPortletKeys.AX_HRMS_EMPLOYEE_ONBOARDING_EMPLOYEE_WEB,
		"mvc.command.name=/addEditEmployeeAddressURL" }, service = MVCActionCommand.class)
public class AddEditEmployeeAddressMVCActionCommand extends BaseMVCActionCommand {

	@Reference
	EmployeeAddressLocalService employeeAddressLocalService;

	@Reference
	AddressLocalService addressLocalService;

	@Reference
	EmployeeDetailsLocalService employeeDetailsLocalService;

	private Log log = LogFactoryUtil.getLog(AddEditEmployeeAddressMVCActionCommand.class);

	private long employeeAddressId = 0;
	private long permanentAddressId = 0;
	private long presentAddressId = 0;
	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);

		boolean sameAsPermanent = ParamUtil.getBoolean(actionRequest,AxHrmsEmployeeOnBoardingEmployeeConstants.SAME_AS_PERMANENT, GetterUtil.DEFAULT_BOOLEAN);

		String flag = ParamUtil.getString(actionRequest, AxHrmsEmployeeOnBoardingEmployeeConstants.UPDATE_FLAG_ADDRESS);
		log.info("AddEditEmployeeAddressMVCActionCommand >>> doProcessAction :::" + flag);
		boolean isUpdate = flag.equals(AxHrmsEmployeeOnBoardingEmployeeConstants.TRUE);

		boolean result = processAddresses(actionRequest,sameAsPermanent, themeDisplay, addressLocalService,employeeAddressLocalService, employeeDetailsLocalService, isUpdate);

		if (result) {
			log.info(AxHrmsEmployeeOnBoardingEmployeeConstants.ADDRESS_SUCCESS);
		} else {
			log.info(AxHrmsEmployeeOnBoardingEmployeeConstants.ADDRESS_FAILED);
		}
	}

	public boolean processAddresses(ActionRequest actionRequest, boolean sameAsPermanent, ThemeDisplay themeDisplay,AddressLocalService addressLocalService, EmployeeAddressLocalService employeeAddressLocalService,EmployeeDetailsLocalService employeeDetailsLocalService, boolean isUpdate) {
		try {
			Address permanentAddress = createOrUpdateAddress(actionRequest, permanentAddressId, true, addressLocalService, isUpdate,sameAsPermanent);
			Address presentAddress = null;
			if (!sameAsPermanent) {
				presentAddress = createOrUpdateAddress(actionRequest, presentAddressId, false, addressLocalService, isUpdate,sameAsPermanent);
			}
			createOrUpdateEmployeeAddress(permanentAddress, presentAddress, themeDisplay, employeeAddressLocalService, employeeDetailsLocalService, isUpdate);
			return true;
		} catch (Exception e) {
			log.error("Error in processAddresses: " + e.getMessage());
			return false;
		}
	}

	private Address createOrUpdateAddress(ActionRequest actionRequest, long addressId, boolean isPermanent, AddressLocalService addressLocalService, boolean isUpdate, boolean sameAsPermanent) throws PortalException {
		Address address;

		if (isUpdate) {
			address = getAddressForUpdate(isPermanent, addressId, sameAsPermanent);
		} else {
			address = addressLocalService.createAddress(CounterLocalServiceUtil.increment(Address.class.getName()));
		}

		setBothTypeAddress(actionRequest, isPermanent, address);

		if (isUpdate) {
			handleAddressUpdate(address, isPermanent, sameAsPermanent);
		} else {
			addNewAddress(address, isPermanent);
		}
		return address;
	}

	private Address setBothTypeAddress(ActionRequest actionRequest, boolean isPermanent,Address address){
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		String line1 = ParamUtil.getString(actionRequest, isPermanent ? AxHrmsEmployeeOnBoardingEmployeeConstants.PERMANENT_ADDRESS_LINE1 : AxHrmsEmployeeOnBoardingEmployeeConstants.PRESENT_ADDRESS_LINE1);
		String line2 = ParamUtil.getString(actionRequest, isPermanent ? AxHrmsEmployeeOnBoardingEmployeeConstants.PERMANENT_ADDRESS_LINE2 : AxHrmsEmployeeOnBoardingEmployeeConstants.PRESENT_ADDRESS_LINE2);
		String line3 = ParamUtil.getString(actionRequest, isPermanent ? AxHrmsEmployeeOnBoardingEmployeeConstants.PERMANENT_ADDRESS_LINE3 : AxHrmsEmployeeOnBoardingEmployeeConstants.PRESENT_ADDRESS_LINE3);
		String state = ParamUtil.getString(actionRequest, isPermanent ? AxHrmsEmployeeOnBoardingEmployeeConstants.PERMANENT_STATE : AxHrmsEmployeeOnBoardingEmployeeConstants.PRESENT_STATE);
		long country = ParamUtil.getLong(actionRequest, isPermanent ? AxHrmsEmployeeOnBoardingEmployeeConstants.PERMANENT_COUNTRY : AxHrmsEmployeeOnBoardingEmployeeConstants.PRESENT_COUNTRY);
		String pincode = ParamUtil.getString(actionRequest, isPermanent ? AxHrmsEmployeeOnBoardingEmployeeConstants.PERMANENT_PINCODE : AxHrmsEmployeeOnBoardingEmployeeConstants.PRESENT_PINCODE);

		address.setCompanyId(themeDisplay.getCompanyId());
		address.setGroupId(themeDisplay.getScopeGroupId());
		address.setCreatedBy(themeDisplay.getUserId());
		address.setModifiedBy(themeDisplay.getUserId());
		address.setLine1(line1);
		address.setLine2(line2);
		address.setLine3(line3);
		address.setState(state);
		address.setCountry(country);
		address.setPincode(pincode);

		return address;
	}

	private Address getAddressForUpdate(boolean isPermanent, long addressId, boolean sameAsPermanent) throws PortalException {
		if (isPermanent) {
			return addressLocalService.getAddress(addressId);
		} else {
			if (!sameAsPermanent) {
				EmployeeAddress employeeAddress = employeeAddressLocalService.getEmployeeAddress(employeeAddressId);
				log.info("employeeAddress ====> " + employeeAddressId);
				return (!employeeAddress.getPresentPermanentSame()) ?
						addressLocalService.getAddress(employeeAddress.getPresentAddress()) :
						addressLocalService.createAddress(CounterLocalServiceUtil.increment(Address.class.getName()));
			} else {
				return addressLocalService.getAddress(addressId);
			}
		}
	}

	private void handleAddressUpdate(Address address, boolean isPermanent, boolean sameAsPermanent) throws PortalException {
		EmployeeAddress employeeAddress = employeeAddressLocalService.getEmployeeAddress(employeeAddressId);
		if (!employeeAddress.getPresentPermanentSame() && sameAsPermanent) {
			log.info("\n\n\n\nDelete Address is : " + employeeAddress.getPresentAddress());
			log.info(address.getAddressId());
			addressLocalService.deleteAddress(employeeAddress.getPresentAddress());
		}
		if (isPermanent) {
			addressLocalService.updateAddress(address);
		} else {
			updateOrAddAddressForPresent(address, sameAsPermanent, employeeAddress);
		}
	}

	private void updateOrAddAddressForPresent(Address address, boolean sameAsPermanent, EmployeeAddress employeeAddress) {
		if (!sameAsPermanent) {
			log.info("employeeAddress ====> " + employeeAddressId);
			if (!employeeAddress.getPresentPermanentSame()) {
				addressLocalService.updateAddress(address);
			} else {
				addressLocalService.addAddress(address);
			}
		}
	}

	private void addNewAddress(Address address, boolean isPermanent) {
		addressLocalService.addAddress(address);
		if (isPermanent) {
			permanentAddressId = address.getAddressId();
		} else {
			presentAddressId = address.getAddressId();
		}
	}


	private EmployeeAddress createOrUpdateEmployeeAddress(Address permanentAddress, Address presentAddress, ThemeDisplay themeDisplay, EmployeeAddressLocalService employeeAddressLocalService, EmployeeDetailsLocalService employeeDetailsLocalService, boolean isUpdate) throws PortalException {
		EmployeeAddress employeeAddress;
		if (isUpdate) {
			employeeAddress = employeeAddressLocalService.getEmployeeAddress(employeeAddressId);
		} else {
			employeeAddress = employeeAddressLocalService.createEmployeeAddress(CounterLocalServiceUtil.increment(EmployeeAddress.class.getName()));
		}

		employeeAddress.setCompanyId(themeDisplay.getCompanyId());
		employeeAddress.setGroupId(themeDisplay.getScopeGroupId());
		employeeAddress.setCreatedBy(themeDisplay.getUserId());
		employeeAddress.setModifiedBy(themeDisplay.getUserId());
		employeeAddress.setPermanentAddress(permanentAddress.getAddressId());
		if (presentAddress != null) {
			employeeAddress.setPresentAddress(presentAddress.getAddressId());
			employeeAddress.setPresentPermanentSame(false);
		} else {
			employeeAddress.setPresentAddress(permanentAddress.getAddressId());
			employeeAddress.setPresentPermanentSame(true);
		}
		employeeAddress.setStatus(true);
		employeeAddressId = employeeAddress.getEmployeeAddressId();

		EmployeeDetails employeeDetails = employeeDetailsLocalService.findByLrUserId(themeDisplay.getUserId());
		employeeDetails.setEmployeeAddressId(employeeAddress.getEmployeeAddressId());
		employeeAddress.setEmployeeId(employeeDetails.getEmployeeId());

		if (isUpdate) {
			employeeAddressLocalService.updateEmployeeAddress(employeeAddress);
		} else {
			employeeAddressId = employeeAddress.getEmployeeAddressId();
			employeeAddressLocalService.addEmployeeAddress(employeeAddress);
		}
		employeeDetailsLocalService.updateEmployeeDetails(employeeDetails);
		return employeeAddress;
	}

}