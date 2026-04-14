package com.ax.hrms.profile.management.action;

import com.ax.hrms.common.api.api.AxHrmsCommonApi;
import com.ax.hrms.model.Address;
import com.ax.hrms.model.EmployeeAddress;
import com.ax.hrms.model.EmployeeDetails;
import com.ax.hrms.model.Nominee;
import com.ax.hrms.profile.management.constants.AxHrmsProfileManagementWebConstants;
import com.ax.hrms.profile.management.constants.AxHrmsProfileManagementWebPortletKeys;
import com.ax.hrms.service.AddressLocalService;
import com.ax.hrms.service.EmployeeAddressLocalService;
import com.ax.hrms.service.EmployeeDetailsLocalService;
import com.ax.hrms.service.NomineeLocalService;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.document.library.kernel.service.DLAppLocalServiceUtil;
import com.liferay.object.rest.dto.v1_0.FileEntry;
import com.liferay.object.rest.dto.v1_0.Folder;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.ResourceConstants;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.role.RoleConstants;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.security.permission.ActionKeys;
import com.liferay.portal.kernel.service.*;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.*;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import java.io.File;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
    private ResourcePermissionLocalService resourcePermissionLocalService;
    @Reference
    NomineeLocalService nomineeLocalService;
    @Reference
    private RoleLocalService roleLocalService;
    @Override
    protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
        log.info("EditEmployeeProfileMVCActionCommand >>> doProcessAction ::: Edit employee profile Action called...");

        ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
        UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(actionRequest);
        try{
            EmployeeDetails oldEmployeeDetailsObj = employeeDetailsLocalService.findByLrUserId(themeDisplay.getUserId());
            EmployeeAddress oldEmployeeAddressObj = employeeAddressLocalService.findByEmployeeId(oldEmployeeDetailsObj.getEmployeeId());
            User oldUserObj = UserLocalServiceUtil.getUser(themeDisplay.getUserId());


            editEmployeeDetails(oldEmployeeDetailsObj,oldUserObj,actionRequest);
            updateNominee(actionRequest, themeDisplay);


            // ================= PROFILE PIC UPLOAD =================
            File profilePicFile = uploadRequest.getFile("profilePic");

            if (Validator.isNotNull(profilePicFile) && profilePicFile.length() > BigDecimal.ZERO.intValue()) {

                log.info("Uploading Profile Picture...");

                ServiceContext serviceContext =
                        ServiceContextFactory.getInstance(
                                Folder.class.getName(), actionRequest);

                serviceContext.setAddGroupPermissions(true);
                serviceContext.setAddGuestPermissions(true);

                String rootFolderName = "HRMS Document";

                User employeeUser =
                        userLocalService.getUser(oldEmployeeDetailsObj.getLrUserId());

                String employeeFolderName =
                        employeeUser.getScreenName() + employeeUser.getUserId();

                String documentFolderName = "Profile Picture";

                String originalFileName =
                        uploadRequest.getFileName("profilePic");

                long oldProfilePicId = oldEmployeeDetailsObj.getProfilePicId();

                long profilePicFileEntryId =
                        axHrmsCommonApi.uploadEmployeeDocument(
                                themeDisplay,
                                serviceContext,
                                profilePicFile,
                                originalFileName,
                                oldProfilePicId,
                                rootFolderName,
                                employeeFolderName,
                                documentFolderName
                        );

                try {
                    User employeeUserDetails =
                            userLocalService.getUser(oldEmployeeDetailsObj.getLrUserId());
                    employeeUserDetails.setPortraitId(oldEmployeeDetailsObj.getProfilePicId());
                    UserLocalServiceUtil.updatePortrait(oldEmployeeDetailsObj.getLrUserId(), FileUtil.getBytes(profilePicFile));
                } catch (Exception e) {
                    log.error("Exception raised due to :: "+e.getMessage());
                }

                if (profilePicFileEntryId > 0) {

                    try {
                        Role guestRole = roleLocalService.getRole(
                                themeDisplay.getCompanyId(),
                                RoleConstants.GUEST);

                        resourcePermissionLocalService.setResourcePermissions(
                                themeDisplay.getCompanyId(),
                                com.liferay.document.library.kernel.model.DLFileEntry.class.getName(),
                                ResourceConstants.SCOPE_INDIVIDUAL,
                                String.valueOf(profilePicFileEntryId),
                                guestRole.getRoleId(),
                                new String[]{
                                        ActionKeys.VIEW,
                                        ActionKeys.DOWNLOAD
                                }
                        );

                    } catch (Exception e) {
                        log.error("Error setting permission for profile pic", e);
                    }

                    oldEmployeeDetailsObj.setProfilePicId(profilePicFileEntryId);
                    employeeDetailsLocalService.updateEmployeeDetails(oldEmployeeDetailsObj);

                    log.info("Profile pic uploaded successfully: " + profilePicFileEntryId);
                }
            }


//            boolean isSamePresentAddress = ParamUtil.getBoolean(
//                    actionRequest,
//                    AxHrmsProfileManagementWebConstants.IS_SAME_PRESENT_ADDRESS,
//                    false
//            );
//
//            List<Address> oldAddressList = getAddressList(oldEmployeeAddressObj);
//
//            Address permanentAddress;
//            Address presentAddress;
//
//            if (!oldAddressList.isEmpty()) {
//
//                //  1. UPDATE PERMANENT ADDRESS
//                permanentAddress = getPermanantAddress(actionRequest, oldAddressList.get(0));
//                addressLocalService.updateAddress(permanentAddress);
//
//                //  2. HANDLE PRESENT ADDRESS
//                if (isSamePresentAddress) {
//
//                    //  Same as permanent
//                    updateAddressIdsInEmployeeAddress(
//                            permanentAddress.getAddressId(),
//                            permanentAddress.getAddressId(),
//                            oldEmployeeAddressObj,
//                            true
//                    );
//
//                } else {
//
//                    if (oldAddressList.size() == 2) {
//
//                        //  Update existing present address
//                        presentAddress = getPresentAddress(actionRequest, oldAddressList.get(1));
//                        addressLocalService.updateAddress(presentAddress);
//
//                    } else {
//
//                        //  Create new present address
//                        presentAddress = addressLocalService.createAddress(
//                                CounterLocalServiceUtil.increment(Address.class.getName())
//                        );
//
//                        presentAddress.setCreatedBy(themeDisplay.getUserId());
//                        presentAddress.setModifiedBy(themeDisplay.getUserId());
//                        presentAddress.setGroupId(themeDisplay.getScopeGroupId());
//
//                        presentAddress = getPresentAddress(actionRequest, presentAddress);
//                        addressLocalService.addAddress(presentAddress);
//                    }
//
//                    //  3. UPDATE MAPPING
//                    updateAddressIdsInEmployeeAddress(
//                            permanentAddress.getAddressId(),
//                            presentAddress.getAddressId(),
//                            oldEmployeeAddressObj,
//                            false
//                    );
//                }
//            }


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
        String city = ParamUtil.getString(actionRequest,AxHrmsProfileManagementWebConstants.PERMANANT_CITY,GetterUtil.DEFAULT_STRING);

        address.setCountry(countryId);
        address.setState(state);
        address.setCity(city);
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
        String city = ParamUtil.getString(actionRequest,AxHrmsProfileManagementWebConstants.PRESENT_CITY,GetterUtil.DEFAULT_STRING);

        address.setCountry(countryId);
        address.setState(state);
        address.setCity(city);
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
            boolean maritalStatus = ParamUtil.getBoolean(actionRequest, "maritalStatus", false);
            Date marriageDate = ParamUtil.getDate(actionRequest, "marriageDate", new SimpleDateFormat("yyyy-MM-dd"));
            String spouseName = ParamUtil.getString(actionRequest, "spouseName");
            if (!maritalStatus) {
                marriageDate = null;
                spouseName = "";
            }
            employeeDetails.setMaritalStatus(maritalStatus);
            employeeDetails.setMarriageDate(marriageDate);
            employeeDetails.setSpouseName(spouseName);
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
    private void updateNominee(ActionRequest actionRequest, ThemeDisplay themeDisplay) {

        try {
            EmployeeDetails employeeDetails =
                    employeeDetailsLocalService.findByLrUserId(themeDisplay.getUserId());

            long nomineeId = employeeDetails.getNominneeId();
            Nominee nominee = null;
            if (nomineeId > 0) {
                nominee = nomineeLocalService.getNominee(nomineeId);

	            Address address = addressLocalService.getAddress(nominee.getNomineeAddress());

	            nominee.setNomineeFirstName(
	                    ParamUtil.getString(actionRequest, AxHrmsProfileManagementWebConstants.NOMINEE_FIRST_NAME));
	            nominee.setNomineeLastName(
	                    ParamUtil.getString(actionRequest, AxHrmsProfileManagementWebConstants.NOMINEE_LAST_NAME));
	            nominee.setNomineeContact(
	                    ParamUtil.getString(actionRequest, AxHrmsProfileManagementWebConstants.NOMINEE_CONTACT));
	            nominee.setRelationshipWithNominee(
	                    ParamUtil.getString(actionRequest, AxHrmsProfileManagementWebConstants.RELATIONSHIP_WITH_NOMINEE));

	            String dob = ParamUtil.getString(actionRequest,
	                    AxHrmsProfileManagementWebConstants.NOMINEE_DOB);
	            if(Validator.isNotNull(dob) && !dob.isBlank()) {
	            	nominee.setNomineeDob(new SimpleDateFormat("yyyy-MM-dd").parse(dob));
	            }

	            address.setLine1(ParamUtil.getString(actionRequest, AxHrmsProfileManagementWebConstants.NOMINEE_LINE1));
	            address.setLine2(ParamUtil.getString(actionRequest, AxHrmsProfileManagementWebConstants.NOMINEE_LINE2));
	            address.setLine3(ParamUtil.getString(actionRequest, AxHrmsProfileManagementWebConstants.NOMINEE_LINE3));
	            address.setCity(ParamUtil.getString(actionRequest, AxHrmsProfileManagementWebConstants.NOMINEE_CITY));
	            address.setState(ParamUtil.getString(actionRequest, AxHrmsProfileManagementWebConstants.NOMINEE_STATE));
	            address.setCountry(ParamUtil.getLong(actionRequest, AxHrmsProfileManagementWebConstants.NOMINEE_COUNTRY));
	            address.setPincode(ParamUtil.getString(actionRequest, AxHrmsProfileManagementWebConstants.NOMINEE_PINCODE));

	            addressLocalService.updateAddress(address);
	            nomineeLocalService.updateNominee(nominee);

        	}

        } catch (Exception e) {
            log.error("Error updating nominee", e);
        }




    }

    @Reference
    private AxHrmsCommonApi axHrmsCommonApi;
    @Reference
    private UserLocalService userLocalService;
}
