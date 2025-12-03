package com.ax.hrms.profile.management.action;

import com.ax.hrms.master.service.DepartmentMasterLocalService;
import com.ax.hrms.master.service.DesignationMasterLocalService;
import com.ax.hrms.model.Address;
import com.ax.hrms.model.EmployeeAddress;
import com.ax.hrms.model.EmployeeDetails;
import com.ax.hrms.profile.management.constants.AxHrmsProfileManagementWebConstants;
import com.ax.hrms.profile.management.constants.AxHrmsProfileManagementWebPortletKeys;
import com.ax.hrms.service.*;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.CountryLocalService;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import java.util.ArrayList;
import java.util.List;

@Component(
        immediate = true,
        property = {
                "javax.portlet.name="+ AxHrmsProfileManagementWebPortletKeys.AXHRMSPROFILEMANAGEMENTWEB,
                "mvc.command.name="+ AxHrmsProfileManagementWebConstants.EDIT_MVC_COMMAND_NAME
        },
        service = MVCActionCommand.class
)
public class EditEmployeeProfileMVCActionCommand extends BaseMVCActionCommand {

    private static Log log = LogFactoryUtil.getLog(EditEmployeeProfileMVCActionCommand.class);

    @Reference
    EmployeeDetailsLocalService employeeDetailsLocalService;
    @Reference
    EmployeeAddressLocalService employeeAddressLocalService;
    @Reference
    AddressLocalService addressLocalService;
    @Reference
    EmployeeDesignationLocalService employeeDesignationLocalService;
    @Reference
    EmployeeDepartmentLocalService employeeDepartmentLocalService;
    @Reference
    DesignationMasterLocalService designationMasterLocalService;
    @Reference
    DepartmentMasterLocalService departmentMasterLocalService;
    @Reference
    CountryLocalService countryLocalService;
    @Override
    protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
        log.info("EditEmployeeProfileMVCActionCommand >>> doProcessAction ::: Edit employee profile Action called...");

        ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);

        try{
            EmployeeDetails oldEmployeeDetailsObj = employeeDetailsLocalService.findByLrUserId(themeDisplay.getUserId());
            EmployeeAddress oldEmployeeAddressObj = employeeAddressLocalService.findByEmployeeId(oldEmployeeDetailsObj.getEmployeeId());
            User oldUserObj = UserLocalServiceUtil.getUser(themeDisplay.getUserId());


            editEmployeeDetails(oldEmployeeDetailsObj,oldUserObj,actionRequest);

            boolean isSamePresentAddress = ParamUtil.getBoolean(actionRequest,AxHrmsProfileManagementWebConstants.IS_SAME_PRESENT_ADDRESS,GetterUtil.DEFAULT_BOOLEAN);
            if(isSamePresentAddress){
                Address oldPermanantAddressObj = addressLocalService.getAddress(oldEmployeeAddressObj.getPermanentAddress());
                Address newPermanantAddressObj = getPermanantAddress(actionRequest,oldPermanantAddressObj);
                addressLocalService.updateAddress(newPermanantAddressObj);
                if(!oldEmployeeAddressObj.getPresentPermanentSame()){
                    deletePresentAddress(oldEmployeeAddressObj.getPresentAddress());
                }
                updateAddressIdsInEmployeeAddress(newPermanantAddressObj.getAddressId(),newPermanantAddressObj.getAddressId(),oldEmployeeAddressObj,isSamePresentAddress);
            }else{
                List<Address> oldAddressList = getAddressList(oldEmployeeAddressObj);
                Address newPermanantAddressObj;
                Address newPresentAddressObj;
                if(!oldAddressList.isEmpty()) {
                    newPermanantAddressObj = getPermanantAddress(actionRequest, oldAddressList.get(0));
                    if(oldAddressList.size() == 2) {
                        newPresentAddressObj = getPresentAddress(actionRequest, oldAddressList.get(1));
                        addressLocalService.updateAddress(newPresentAddressObj);
                    }
                    else{
                        Address address = addressLocalService.createAddress(CounterLocalServiceUtil.increment(Address.class.getName()));
                        address.setCreatedBy(themeDisplay.getUserId());
                        address.setModifiedBy(themeDisplay.getUserId());
                        address.setGroupId(themeDisplay.getScopeGroupId());
                        addPresentAddress(actionRequest,oldEmployeeAddressObj,isSamePresentAddress,address);
                    }
                    addressLocalService.updateAddress(newPermanantAddressObj);
                }
            }
            SessionMessages.add(actionRequest,AxHrmsProfileManagementWebConstants.UPDATE_SUCCESS_MESSAGE_KEY);
        }catch(Exception exception){

            log.error("EditEmployeeProfileMVCActionCommand >>> doProcessAction ::: Exception Occur when fetching Employee's data and Edit operation : "+ exception.getMessage());
        }
    }

    private Address getPermanantAddress(ActionRequest actionRequest,Address address) {
        long countryId = ParamUtil.getLong(actionRequest,AxHrmsProfileManagementWebConstants.PERMANANT_COUNTRY,GetterUtil.DEFAULT_LONG);
        String line1 = ParamUtil.getString(actionRequest,AxHrmsProfileManagementWebConstants.PERMANANT_LINE1,GetterUtil.DEFAULT_STRING);
        String line2 = ParamUtil.getString(actionRequest,AxHrmsProfileManagementWebConstants.PERMANANT_LINE2,GetterUtil.DEFAULT_STRING);
        String line3 = ParamUtil.getString(actionRequest,AxHrmsProfileManagementWebConstants.PERMANANT_LINE3,GetterUtil.DEFAULT_STRING);
        String pincode = ParamUtil.getString(actionRequest,AxHrmsProfileManagementWebConstants.PERMANANT_PINCODE,GetterUtil.DEFAULT_STRING);
        String state = ParamUtil.getString(actionRequest,AxHrmsProfileManagementWebConstants.PERMANANT_STATE,GetterUtil.DEFAULT_STRING);

        address.setCountry(countryId);
        address.setState(state);
        address.setLine1(line1);
        address.setLine2(line2);
        address.setLine3(line3);
        address.setPincode(pincode);

        return address;
    }
    private Address addPresentAddress(ActionRequest actionRequest,EmployeeAddress employeeAddress,boolean isSamePresentAddress,Address address){

        try{
            address = getPresentAddress(actionRequest,address);
            addressLocalService.addAddress(address);
            employeeAddress.setPresentAddress(address.getAddressId());
            employeeAddress.setPresentPermanentSame(isSamePresentAddress);
            employeeAddressLocalService.updateEmployeeAddress(employeeAddress);
        }catch (Exception exception){
            log.error("EditEmployeeProfileMVCActionCommand >>> addPresentAddress ::: Exception is: "+exception.getMessage());
        }
        return address;
    }
    private Address getPresentAddress(ActionRequest actionRequest,Address address) {
        long countryId = ParamUtil.getLong(actionRequest,AxHrmsProfileManagementWebConstants.PRESENT_COUNTRY,GetterUtil.DEFAULT_LONG);
        String line1 = ParamUtil.getString(actionRequest,AxHrmsProfileManagementWebConstants.PRESENT_LINE1,GetterUtil.DEFAULT_STRING);
        String line2 = ParamUtil.getString(actionRequest,AxHrmsProfileManagementWebConstants.PRESENT_LINE2,GetterUtil.DEFAULT_STRING);
        String line3 = ParamUtil.getString(actionRequest,AxHrmsProfileManagementWebConstants.PRESENT_LINE3,GetterUtil.DEFAULT_STRING);
        String pincode = ParamUtil.getString(actionRequest,AxHrmsProfileManagementWebConstants.PRESENT_PINCODE,GetterUtil.DEFAULT_STRING);
        String state = ParamUtil.getString(actionRequest,AxHrmsProfileManagementWebConstants.PRESENT_STATE,GetterUtil.DEFAULT_STRING);

        address.setCountry(countryId);
        address.setState(state);
        address.setLine1(line1);
        address.setLine2(line2);
        address.setLine3(line3);
        address.setPincode(pincode);

        return address;
    }
    public void updateAddressIdsInEmployeeAddress(long permanantAddressId,long presentAddressId,EmployeeAddress employeeAddress,boolean isSamePresentAddress){
        employeeAddress.setPermanentAddress(permanantAddressId);
        employeeAddress.setPresentAddress(presentAddressId);
        employeeAddress.setPresentPermanentSame(isSamePresentAddress);
        employeeAddressLocalService.updateEmployeeAddress(employeeAddress);
    }

    public EmployeeDetails editEmployeeDetails(EmployeeDetails employeeDetails,User user,ActionRequest actionRequest){
        try{
            String firstName = ParamUtil.getString(actionRequest,AxHrmsProfileManagementWebConstants.FIRST_NAME, GetterUtil.DEFAULT_STRING);
            String middleName = ParamUtil.getString(actionRequest,AxHrmsProfileManagementWebConstants.MIDDLE_NAME, GetterUtil.DEFAULT_STRING);
            String lastName = ParamUtil.getString(actionRequest,AxHrmsProfileManagementWebConstants.LAST_NAME, GetterUtil.DEFAULT_STRING);
            String mobileNumber = ParamUtil.getString(actionRequest,AxHrmsProfileManagementWebConstants.MOBILE_NUMBER, GetterUtil.DEFAULT_STRING);
            String personalEmail = ParamUtil.getString(actionRequest,AxHrmsProfileManagementWebConstants.PERSONAL_EMAIL, GetterUtil.DEFAULT_STRING);

            employeeDetails.setFirstName(firstName);
            user.setMiddleName(middleName);
            employeeDetails.setLastName(lastName);
            employeeDetails.setMobileNo(mobileNumber);
            employeeDetails.setPersonalEmail(personalEmail);

            EmployeeDetails updatedEmployeeDetails = employeeDetailsLocalService.updateEmployeeDetails(employeeDetails);
            UserLocalServiceUtil.updateUser(user);
            return updatedEmployeeDetails;
        }catch (Exception e){
            log.error("EditEmployeeProfileMVCActionCommand >>> editEmployeeDetails ::: Exception is: "+e.getMessage());
        }
        return null;
    }

    public List<Address> getAddressList(EmployeeAddress employeeAddress) throws PortalException {
        List<Address> addressList = new ArrayList<>();
        addressList.add(addressLocalService.getAddress(employeeAddress.getPermanentAddress()));
        if(!employeeAddress.getPresentPermanentSame()){
            addressList.add(addressLocalService.getAddress(employeeAddress.getPresentAddress()));
        }
        return addressList;
    }

    public void deletePresentAddress(long presentAddressId) throws PortalException {
        addressLocalService.deleteAddress(presentAddressId);
    }
}
