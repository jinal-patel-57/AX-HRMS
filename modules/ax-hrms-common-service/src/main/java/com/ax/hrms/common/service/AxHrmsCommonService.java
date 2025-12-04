package com.ax.hrms.common.service;

import com.ax.hrms.common.api.api.AxHrmsCommonApi;
import com.ax.hrms.common.constants.AxHrmsCommonConstants;
import com.ax.hrms.master.model.DepartmentMaster;
import com.ax.hrms.master.model.DesignationMaster;
import com.ax.hrms.master.service.DepartmentMasterLocalService;
import com.ax.hrms.master.service.DesignationMasterLocalService;
import com.ax.hrms.model.Address;
import com.ax.hrms.model.EmployeeAddress;
import com.ax.hrms.model.EmployeeDepartment;
import com.ax.hrms.model.EmployeeDesignation;
import com.ax.hrms.model.EmployeeDetails;
import com.ax.hrms.service.AddressLocalService;
import com.ax.hrms.service.EmployeeAddressLocalService;
import com.ax.hrms.service.EmployeeDepartmentLocalService;
import com.ax.hrms.service.EmployeeDesignationLocalService;
import com.ax.hrms.service.EmployeeDetailsLocalService;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.document.library.kernel.model.DLFileEntry;
import com.liferay.document.library.kernel.service.DLAppLocalServiceUtil;
import com.liferay.document.library.kernel.service.DLFileEntryLocalServiceUtil;
import com.liferay.mail.kernel.model.MailMessage;
import com.liferay.mail.kernel.service.MailServiceUtil;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.repository.model.Folder;
import com.liferay.portal.kernel.service.RoleLocalService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.workflow.WorkflowConstants;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.portlet.ActionRequest;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author krish.moradiya
 */
@Component(
        immediate = true,
        service = AxHrmsCommonApi.class
)
public class AxHrmsCommonService implements AxHrmsCommonApi {
    private final Random random = new Random();
    Log log = LogFactoryUtil.getLog(AxHrmsCommonService.class.getName());

    @Reference
    DesignationMasterLocalService designationMasterLocalService;
    @Reference
    EmployeeDesignationLocalService employeeDesignationLocalService;
    @Reference
    UserLocalService userLocalService;
    @Reference
    DepartmentMasterLocalService departmentMasterLocalService;
    @Reference
    EmployeeDepartmentLocalService employeeDepartmentLocalService;
    @Reference
    EmployeeDetailsLocalService employeeDetailsLocalService;
    @Reference
    RoleLocalService roleLocalService;


    @Override
    public void sendMail(String toEmailAddress, String fromEmailAddress, String fromName, String subject, String body) {
        InternetAddress toAddress = null;
        try {
            toAddress = new InternetAddress(toEmailAddress);
        } catch (AddressException e) {
            log.info("Address exception");
        }
        MailMessage mailMessage = new MailMessage();
        mailMessage.setHTMLFormat(true);
        mailMessage.setSubject(subject);
        mailMessage.setBody(body);
        try {
            mailMessage.setFrom(new InternetAddress(fromEmailAddress, fromName));
        } catch (UnsupportedEncodingException e) {
            log.error("Encoding error");
        }
        mailMessage.setTo(toAddress);
        MailServiceUtil.sendEmail(mailMessage);


    }

    @Override
    public String generatePassword(int length) {
        StringBuilder password = new StringBuilder();
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789@#$";

        for (int i = 0; i < length; i++) {
            password.append(chars.charAt(random.nextInt(chars.length())));
        }

        return password.toString();
    }

    @Override
    public Map<User, String> createNewEmployeeUser(String firstName, String middleName, String lastName, String email, ThemeDisplay themeDisplay, long[] roles) {
        String password = generatePassword(8);
        User user = null;
        Map<User, String> retMp = new HashMap<>();
        try {
            user = userLocalService.addUser(themeDisplay.getUserId(), themeDisplay.getCompanyId(), false, password, password, false,
                    generateUserName(firstName, middleName, lastName, themeDisplay), email, themeDisplay.getLocale(), firstName, middleName, lastName, 0L, 0L,
                    false, 1, 1, 2000, "jobTitle", 1, new long[]{themeDisplay.getScopeGroupId()}, null, roles, null, false, new ServiceContext());
            user.setStatus(WorkflowConstants.STATUS_APPROVED);
            user.setPasswordReset(true);
            user.setEmailAddressVerified(true);
            userLocalService.updateUser(user);
            //sending mail for new user on-boarding
            retMp.put(user, password);
            return retMp;
        } catch (Exception e) {
        	log.error("ERROR CREATING THE NEW EMPLOYEE USER -- " + e.getMessage());
        	e.printStackTrace();
        }
        retMp.put(user, password);
        return retMp;
    }

    @Override
    public String generateUserName(String firstName, String middleName, String lastName, ThemeDisplay themeDisplay) {
        String username = "";
        username = firstName + "." + lastName;
        try {
            userLocalService.getUserByScreenName(themeDisplay.getCompanyId(), username);
            username = firstName + "." + middleName + "." + lastName;
            return username;
        } catch (PortalException e) {
            return username;
        }

    }


    public List<DepartmentMaster> getDepartmentMastersFromEmployeeId(long employeeId) {
        List<DepartmentMaster> depList = new ArrayList<>();
        DynamicQuery dq1 = employeeDepartmentLocalService.dynamicQuery();
        dq1.add(PropertyFactoryUtil.forName("employeeId").eq(employeeId));
        dq1.add(PropertyFactoryUtil.forName("status").eq(true));
        List<EmployeeDepartment> employeeDepartments = employeeDepartmentLocalService.dynamicQuery(dq1);
        employeeDepartments.forEach(employeeDepartment -> {
            try {
                DepartmentMaster depMaster = departmentMasterLocalService.getDepartmentMaster(employeeDepartment.getDepartmentMasterId());
                depList.add(depMaster);
            } catch (PortalException e) {
                log.error("Cannot Fetch Such Department Master using EmployeeDepartment");
            }
        });
        return depList;
    }

    public List<DesignationMaster> getDesignationMastersFromEmployeeId(long employeeId) {
        List<DesignationMaster> desigList = new ArrayList<>();
        DynamicQuery dq2 = employeeDesignationLocalService.dynamicQuery();
        dq2.add(PropertyFactoryUtil.forName("employeeId").eq(employeeId));
        dq2.add(PropertyFactoryUtil.forName("status").eq(true));
        List<EmployeeDesignation> employeeDesignations = employeeDesignationLocalService.dynamicQuery(dq2);
        employeeDesignations.forEach(employeeDesignation -> {
            try {
                DesignationMaster desName = designationMasterLocalService.getDesignationMaster(employeeDesignation.getDesignationMasterId());
                desigList.add(desName);
            } catch (PortalException e) {
                log.error("Cannot Fetch Such Designation Master using EmployeeDesignation");
            }
        });
        return desigList;
    }

    @Override
    public File convertDLFileEntryToFile(long fileEntryId) {
        DLFileEntry dlFileEntry = null;
        try {
            dlFileEntry = DLFileEntryLocalServiceUtil.getDLFileEntry(fileEntryId);
            InputStream is = dlFileEntry.getContentStream();
            File convertedFile = File.createTempFile("temp", ".tmp");
            FileOutputStream fos = new FileOutputStream(convertedFile);
            // Creating a buffer for file conversion
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = is.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }
            fos.close();
            is.close();
            return convertedFile;
        } catch (Exception e) {
            log.error("ERROR CONVERTING DL FILE TO File type");
        }
        return null;
    }

    @Override
    public void sendMailWithAttachment(String toEmailAddress, String fromEmailAddress, String fromName, String subject, String body, File file, String filename) {
        InternetAddress toAddress = null;
        try {
            toAddress = new InternetAddress(toEmailAddress);
        } catch (AddressException e) {
            log.info("Address exception");
        }
        MailMessage mailMessage = new MailMessage();
        mailMessage.setHTMLFormat(true);
        mailMessage.setSubject(subject);
        mailMessage.setBody(body);
        try {
            mailMessage.setFrom(new InternetAddress(fromEmailAddress, fromName));
        } catch (UnsupportedEncodingException e) {
            log.error("Encoding error");
        }
        mailMessage.addFileAttachment(file, filename);

        mailMessage.setTo(toAddress);
        MailServiceUtil.sendEmail(mailMessage);
    }

    @Override
    public Folder createFolder(String folderName, long parentFolderId, ThemeDisplay themeDisplay, ServiceContext serviceContext) {
        Folder folder = null;
        try {
            folder = DLAppLocalServiceUtil.getFolder(themeDisplay.getScopeGroupId(), parentFolderId, folderName);
        } catch (Exception e) {
            try {
                folder = DLAppLocalServiceUtil.addFolder(StringPool.BLANK, themeDisplay.getUserId(), themeDisplay.getScopeGroupId(), parentFolderId, folderName, StringPool.BLANK, serviceContext);
            } catch (PortalException ex) {
                log.error("FOLDER COMMON API FAILED TO CREATE THE FOLDER OR GET THE FOLDER !");
            }
        }
        return folder;
    }

    public String setDateFormat(Date inputDate) {
        SimpleDateFormat outputDateFormat = new SimpleDateFormat("dd-MMM-yyyy");
        String dateStr = null;
        try {

            // Format the current date to the desired format
            dateStr = outputDateFormat.format(inputDate);

        } catch (Exception e) {
            log.error("AxCommonService >>> setDateFormat Method >>Error in Set Date Format..!!"
                    + e.getMessage());
        }

        return dateStr;

    }

    public boolean isRolePerson(ThemeDisplay themeDisplay, String roleName) {
        try {
            Role managerRole = roleLocalService.getRole(themeDisplay.getCompanyId(), roleName);
            long managerRoleId = managerRole.getRoleId();
            List<Role> roleList = roleLocalService.getUserRoles(themeDisplay.getUserId());
            for (Role role : roleList) {
                if (role.getRoleId() == managerRoleId) {
                    return true;
                }

            }

        } catch (Exception e) {
            log.error("AxCommonService >>> isRolePerson >>> " + e.getMessage());
        }
        return false;
    }

    @Override
    public List<User> fetchHrAdminList(long companyId) {
        Role hrRole = null;
        try {
            hrRole = roleLocalService.getRole(companyId, "HR Admin");
        } catch (PortalException e) {
            log.error("CANNOT FETCH HR ADMINS");
        }

        assert hrRole != null;
        return userLocalService.getRoleUsers(hrRole.getRoleId());
    }


    @Override
    public List<User> fetchRolePersonList(long companyId, String roleName, int start, int end) {
        Role hrRole = null;
        try {
            hrRole = roleLocalService.getRole(companyId, roleName);
        } catch (PortalException e) {
            log.error("CANNOT FETCH YOUR ROLE PERSON");
        }
        List<User> lrHrAdminUsers = userLocalService.getRoleUsers(hrRole.getRoleId(), start, end);
        return lrHrAdminUsers;
    }

    @Override
    public boolean processAddresses(ActionRequest actionRequest, boolean sameAsPermanent, ThemeDisplay themeDisplay, AddressLocalService addressLocalService, EmployeeAddressLocalService employeeAddressLocalService, EmployeeDetailsLocalService employeeDetailsLocalService, boolean isUpdate) {
         long employeeAddressId = 0;
         long permanentAddressId = 0;
         long presentAddressId = 0;
        try {
            long employeeId = ParamUtil.getLong(actionRequest, "employeeId");
            actionRequest.setAttribute("employeeId",employeeId);

            String permanentAddressLine1 = ParamUtil.getString(actionRequest, AxHrmsCommonConstants.PERMANENT_ADDRESS_LINE1);
            String permanentAddressLine2 = ParamUtil.getString(actionRequest, AxHrmsCommonConstants.PERMANENT_ADDRESS_LINE2);
            String permanentAddressLine3 = ParamUtil.getString(actionRequest, AxHrmsCommonConstants.PERMANENT_ADDRESS_LINE3);
            String permanentState = ParamUtil.getString(actionRequest, AxHrmsCommonConstants.PERMANENT_STATE);
            long permanentCountry = ParamUtil.getLong(actionRequest, AxHrmsCommonConstants.PERMANENT_COUNTRY);
            String permanentPincode = ParamUtil.getString(actionRequest, AxHrmsCommonConstants.PERMANENT_PINCODE);

            String presentAddressLine1 = ParamUtil.getString(actionRequest, AxHrmsCommonConstants.PRESENT_ADDRESS_LINE1);
            String presentAddressLine2 = ParamUtil.getString(actionRequest, AxHrmsCommonConstants.PRESENT_ADDRESS_LINE2);
            String presentAddressLine3 = ParamUtil.getString(actionRequest, AxHrmsCommonConstants.PRESENT_ADDRESS_LINE3);
            String presentState = ParamUtil.getString(actionRequest, AxHrmsCommonConstants.PRESENT_STATE);
            long presentCountry = ParamUtil.getLong(actionRequest, AxHrmsCommonConstants.PRESENT_COUNTRY);
            String presentPincode = ParamUtil.getString(actionRequest, AxHrmsCommonConstants.PRESENT_PINCODE);

            Address permanentAddress;
            Address presentAddress = null;

            if (isUpdate) {
                permanentAddress = addressLocalService.getAddress(permanentAddressId);
                if (!sameAsPermanent) {
                    presentAddress = addressLocalService.getAddress(presentAddressId);
                }
            } else {
                permanentAddress = addressLocalService
                        .createAddress(CounterLocalServiceUtil.increment(Address.class.getName()));
                if (!sameAsPermanent) {
                    presentAddress = addressLocalService
                            .createAddress(CounterLocalServiceUtil.increment(Address.class.getName()));
                }
            }

            permanentAddress.setCompanyId(themeDisplay.getCompanyId());
            permanentAddress.setGroupId(themeDisplay.getScopeGroupId());
            permanentAddress.setCreatedBy(themeDisplay.getUserId());
            permanentAddress.setModifiedBy(themeDisplay.getUserId());
            permanentAddress.setLine1(permanentAddressLine1);
            permanentAddress.setLine2(permanentAddressLine2);
            permanentAddress.setLine3(permanentAddressLine3);
            permanentAddress.setState(permanentState);
            permanentAddress.setCountry(permanentCountry);
            permanentAddress.setPincode(permanentPincode);

            if (isUpdate) {
                addressLocalService.updateAddress(permanentAddress);
            } else {
                permanentAddressId = permanentAddress.getAddressId();

                addressLocalService.addAddress(permanentAddress);
            }

            if (!sameAsPermanent) {
                presentAddress.setCompanyId(themeDisplay.getCompanyId());
                presentAddress.setGroupId(themeDisplay.getScopeGroupId());
                presentAddress.setCreatedBy(themeDisplay.getUserId());
                presentAddress.setModifiedBy(themeDisplay.getUserId());
                presentAddress.setLine1(presentAddressLine1);
                presentAddress.setLine2(presentAddressLine2);
                presentAddress.setLine3(presentAddressLine3);
                presentAddress.setState(presentState);
                presentAddress.setCountry(presentCountry);
                presentAddress.setPincode(presentPincode);

                if (isUpdate) {
                    addressLocalService.updateAddress(presentAddress);
                } else {
                    addressLocalService.addAddress(presentAddress);
                }
            }

            EmployeeAddress employeeAddress;
            employeeAddress = (isUpdate) ? employeeAddressLocalService.getEmployeeAddress(employeeAddressId) : employeeAddressLocalService.createEmployeeAddress(CounterLocalServiceUtil.increment(EmployeeAddress.class.getName()));

            employeeAddress.setCompanyId(themeDisplay.getCompanyId());
            employeeAddress.setGroupId(themeDisplay.getScopeGroupId());
            employeeAddress.setCreatedBy(themeDisplay.getUserId());
            employeeAddress.setModifiedBy(themeDisplay.getUserId());
            employeeAddress.setPermanentAddress(permanentAddress.getAddressId());

            if (sameAsPermanent) {
                employeeAddress.setPresentAddress(permanentAddress.getAddressId());
                employeeAddress.setPresentPermanentSame(true);
            } else {
                employeeAddress.setPresentAddress(presentAddress.getAddressId());
                employeeAddress.setPresentPermanentSame(false);
            }
            employeeAddress.setStatus(true);
            EmployeeDetails employeeDetails;
            if (employeeId > 0) {
                employeeDetails = employeeDetailsLocalService.getEmployeeDetails(employeeId);
            } else {
                employeeDetails = employeeDetailsLocalService.findByLrUserId(themeDisplay.getUserId());
            }


            employeeDetails.setEmployeeAddressId(employeeAddress.getEmployeeAddressId());
            employeeAddress.setEmployeeId(employeeDetails.getEmployeeId());

            if (isUpdate) {
                employeeAddressLocalService.updateEmployeeAddress(employeeAddress);
            } else {
                employeeAddressLocalService.addEmployeeAddress(employeeAddress);
            }
            employeeDetailsLocalService.updateEmployeeDetails(employeeDetails);
            return true;
        } catch (Exception e) {
            log.error("Error in processAddresses: " + e.getMessage());
            return false;
        }
    }
    
    
    public Calendar setDateAndTime(String date,String time) {
    	Calendar cal = Calendar.getInstance();
		
		String[] dateArray = date.split("-");
		String[] timeArray = time.split(":");
		cal.set(Calendar.HOUR, Integer.parseInt(timeArray[0]));
		cal.set(Calendar.MINUTE, Integer.parseInt(timeArray[1]));
		cal.set(Calendar.SECOND, 0);
		
		cal.set(Calendar.DATE, Integer.parseInt(dateArray[2]));
		cal.set(Calendar.MONTH, Integer.parseInt(dateArray[1])-1);
		cal.set(Calendar.YEAR, Integer.parseInt(dateArray[0]));
		return cal;
    }
    
    
}