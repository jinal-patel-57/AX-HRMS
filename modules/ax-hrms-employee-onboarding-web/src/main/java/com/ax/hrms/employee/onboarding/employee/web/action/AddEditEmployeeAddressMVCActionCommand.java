package com.ax.hrms.employee.onboarding.employee.web.action;

import com.ax.hrms.common.api.api.AxHrmsCommonApi;
import com.ax.hrms.employee.onboarding.employee.web.util.EmployeeBasicDetailsUtil;
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
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.repository.model.Folder;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.*;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.io.File;

@Component(immediate = true, property = {
		"javax.portlet.name=" + AxHrmsEmployeeOnboardingWebPortletKeys.AX_HRMS_EMPLOYEE_ONBOARDING_EMPLOYEE_WEB,
		"mvc.command.name=/addEditEmployeeAddressURL" }, service = MVCActionCommand.class)
public class  AddEditEmployeeAddressMVCActionCommand extends BaseMVCActionCommand {

	@Reference
	EmployeeAddressLocalService employeeAddressLocalService;

	@Reference
	AddressLocalService addressLocalService;

	@Reference
	EmployeeDetailsLocalService employeeDetailsLocalService;

	@Reference
	private UserLocalService userLocalService;

	@Reference
	private AxHrmsCommonApi axHrmsCommonApi;

	private Log log = LogFactoryUtil.getLog(AddEditEmployeeAddressMVCActionCommand.class);

	private long employeeAddressId = 0;
	private long permanentAddressId = 0;
	private long presentAddressId = 0;
	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		ServiceContext serviceContext = ServiceContextFactory.getInstance(Folder.class.getName(), actionRequest);

		employeeAddressId = 0;
		permanentAddressId =0;
		presentAddressId=0;
		
	    serviceContext.setAddGroupPermissions(true);
	    serviceContext.setAddGuestPermissions(false);
		boolean sameAsPermanent = ParamUtil.getBoolean(actionRequest,AxHrmsEmployeeOnBoardingEmployeeConstants.SAME_AS_PERMANENT, GetterUtil.DEFAULT_BOOLEAN);

		String flag = ParamUtil.getString(actionRequest, AxHrmsEmployeeOnBoardingEmployeeConstants.UPDATE_FLAG_ADDRESS);
		log.info("AddEditEmployeeAddressMVCActionCommand >>> doProcessAction :::" + flag);
		boolean isUpdate = flag.equals(AxHrmsEmployeeOnBoardingEmployeeConstants.TRUE);

		boolean result = processAddresses(actionRequest,sameAsPermanent, themeDisplay, addressLocalService,employeeAddressLocalService, employeeDetailsLocalService, isUpdate, serviceContext);

		if (result) {
			log.info(AxHrmsEmployeeOnBoardingEmployeeConstants.ADDRESS_SUCCESS);
		} else {
			log.info(AxHrmsEmployeeOnBoardingEmployeeConstants.ADDRESS_FAILED);
		}
	}

	public boolean processAddresses(ActionRequest actionRequest, boolean sameAsPermanent, ThemeDisplay themeDisplay,AddressLocalService addressLocalService, EmployeeAddressLocalService employeeAddressLocalService,EmployeeDetailsLocalService employeeDetailsLocalService, boolean isUpdate, ServiceContext serviceContext) {
		try {
			log.info("isUpdate  -- " + isUpdate );
			log.info("sameAsPermanent  -- " + sameAsPermanent);
			log.info("permanentAddressId  -- " + permanentAddressId);
			Long employeeId = ParamUtil.getLong(actionRequest,"employeeId");
			log.info("employeeId-- " + employeeId);
			if(isUpdate) {
				EmployeeAddress employeeAddress = employeeAddressLocalService.findByEmployeeId(employeeId);
				permanentAddressId = employeeAddress.getPermanentAddress();
				presentAddressId = employeeAddress.getPresentAddress();
				employeeAddressId = employeeAddress.getEmployeeAddressId();
			}
			Address permanentAddress = createOrUpdateAddress(actionRequest, permanentAddressId, true, addressLocalService, isUpdate,sameAsPermanent, serviceContext);
			Address presentAddress = null;
			if (!sameAsPermanent) {
				presentAddress = createOrUpdateAddress(actionRequest, presentAddressId, false, addressLocalService, isUpdate,sameAsPermanent, serviceContext);
			}
			createOrUpdateEmployeeAddress(actionRequest,permanentAddress, presentAddress, themeDisplay, employeeAddressLocalService, employeeDetailsLocalService, isUpdate,serviceContext);
			return true;
		} catch (Exception e) {
			log.error("Error in processAddresses: " + e.getMessage());
			e.printStackTrace();
			return false;
		}
	}

	private Address createOrUpdateAddress(ActionRequest actionRequest, long addressId, boolean isPermanent, AddressLocalService addressLocalService, boolean isUpdate, boolean sameAsPermanent, ServiceContext serviceContext) throws PortalException {
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
        String city= ParamUtil.getString(actionRequest, isPermanent ? AxHrmsEmployeeOnBoardingEmployeeConstants.PERMANENT_CITY : AxHrmsEmployeeOnBoardingEmployeeConstants.PRESENT_CITY);

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
        address.setCity(city);
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


	private EmployeeAddress createOrUpdateEmployeeAddress(ActionRequest actionRequest,Address permanentAddress, Address presentAddress, ThemeDisplay themeDisplay, EmployeeAddressLocalService employeeAddressLocalService, EmployeeDetailsLocalService employeeDetailsLocalService, boolean isUpdate,ServiceContext serviceContext) throws PortalException {
		EmployeeAddress employeeAddress;
        UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(actionRequest);


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
        File addressProofFile =
                uploadRequest.getFile(
                        AxHrmsEmployeeOnBoardingEmployeeConstants.ADDRESS_PROOF_FILE);

        if (Validator.isNotNull(addressProofFile) && addressProofFile.length() > 0) {

            String addressProofFileName =
                    System.currentTimeMillis() + "_" +
                            AxHrmsEmployeeOnBoardingEmployeeConstants.ADDRESS_PROOF_FILE
                                    .replaceAll("\\s+", "_");

            long employeeId = ParamUtil.getLong(actionRequest, "employeeId");

            EmployeeDetails employeeDetails =
                    employeeDetailsLocalService.getEmployeeDetails(
                            ParamUtil.getLong(actionRequest, "employeeId"));

            EmployeeBasicDetailsUtil employeeBasicDetailsUtil =
                    new EmployeeBasicDetailsUtil();


//            EmployeeAddress employeeAddress =
//                    employeeAddressLocalService.findByEmployeeId(employeeId);

            EmployeeDetails employeeUser =
                    employeeDetailsLocalService.getEmployeeDetails(employeeId);

            User employeeLrUser =
                    userLocalService.getUser(employeeUser.getLrUserId());

            Folder folder =
                    axHrmsCommonApi.createFolder(
                            AxHrmsEmployeeOnBoardingEmployeeConstants.HRMS_DOCUMENT,
                            0,
                            themeDisplay,
                            serviceContext);

            Folder parentFolder =
                    axHrmsCommonApi.createFolder(
                            String.format("%s%d",
                                    employeeLrUser.getScreenName(),
                                    employeeLrUser.getUserId()),
                            folder.getFolderId(),
                            themeDisplay,
                            serviceContext);

            Folder addressProofFolder =
                    axHrmsCommonApi.createFolder(
                            AxHrmsEmployeeOnBoardingEmployeeConstants.ADDRESS_PROOF_FOLDER,
                            parentFolder.getFolderId(),
                            themeDisplay,
                            serviceContext);


            try {
                long addressProofFileEntryId = 0;
                if (isUpdate) {
                    addressProofFileEntryId = employeeBasicDetailsUtil.addEditFileEntry(
                            addressProofFile,
                            addressProofFileName,
                            actionRequest,
                            employeeDetails,
                            employeeAddress.getEmployeeAddressProofFileEntryId(),
                            "ADDRESS_PROOF",
                            addressProofFolder,
                            serviceContext
                    );
                } else {
                    addressProofFileEntryId = employeeBasicDetailsUtil.addEditFileEntry(
                            addressProofFile,
                            addressProofFileName,
                            actionRequest,
                            employeeDetails,
                            0,
                            "ADDRESS_PROOF",
                            addressProofFolder,
                            serviceContext
                    );
                }

                employeeAddress.setEmployeeAddressProofFileEntryId(addressProofFileEntryId);
            } catch (Exception e) {
                log.error("error while adding address proof :: " + e);
            }
        }

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