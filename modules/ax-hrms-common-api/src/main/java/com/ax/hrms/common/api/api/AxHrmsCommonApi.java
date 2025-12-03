package com.ax.hrms.common.api.api;

import java.io.File;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.ax.hrms.master.model.DepartmentMaster;
import com.ax.hrms.master.model.DesignationMaster;
import com.ax.hrms.service.AddressLocalService;
import com.ax.hrms.service.EmployeeAddressLocalService;
import com.ax.hrms.service.EmployeeDetailsLocalService;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.repository.model.Folder;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.theme.ThemeDisplay;

import javax.portlet.ActionRequest;

/**
 * @author nivid.koradiya
 */
public interface AxHrmsCommonApi {
    public void sendMail(String toEmailAddress,String fromEmailAddress, String fromName, String subject, String body);
    public String generatePassword(int length) ;
    public String generateUserName(String firstName, String middleName, String lastName, ThemeDisplay themeDisplay) ;
    public List<DepartmentMaster> getDepartmentMastersFromEmployeeId(long employeeId) ;
    public List<DesignationMaster> getDesignationMastersFromEmployeeId(long employeeId) ;
    public Map<User,String> createNewEmployeeUser(String firstName, String middleName , String lastName, String email, ThemeDisplay themeDisplay, long[] roles);
    public File convertDLFileEntryToFile(long fileEntryId) ;
    public void sendMailWithAttachment(String toEmailAddress, String fromEmailAddress, String fromName, String subject, String body, File file, String filename) ;
    public Folder createFolder(String folderName, long parentFolderId, ThemeDisplay themeDisplay, ServiceContext serviceContext);
    public String setDateFormat(Date inputDate) ;
    public boolean isRolePerson(ThemeDisplay themeDisplay,String roleName);
    public List<User> fetchHrAdminList(long companyId);
    public List<User> fetchRolePersonList(long companyId,String roleName,int start,int end);

    public boolean processAddresses(ActionRequest actionRequest, boolean sameAsPermanent, ThemeDisplay themeDisplay,
                                    AddressLocalService addressLocalService, EmployeeAddressLocalService employeeAddressLocalService,
                                    EmployeeDetailsLocalService employeeDetailsLocalService, boolean isUpdate);
    public Calendar setDateAndTime(String date,String time) ;
    }