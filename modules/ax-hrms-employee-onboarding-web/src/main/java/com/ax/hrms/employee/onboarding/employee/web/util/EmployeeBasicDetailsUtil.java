package com.ax.hrms.employee.onboarding.employee.web.util;

import com.ax.hrms.model.EmployeeDetails;

import com.liferay.document.library.kernel.model.DLVersionNumberIncrease;
import com.liferay.document.library.kernel.service.DLAppLocalServiceUtil;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.repository.model.Folder;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.MimeTypesUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.File;
import java.nio.file.Files;

import javax.portlet.ActionRequest;

public class EmployeeBasicDetailsUtil {

	private Log log = LogFactoryUtil.getLog(EmployeeBasicDetailsUtil.class);
	
	public void addEditFileEntry(File file,String fileName,ActionRequest actionRequest,EmployeeDetails employeeDetails
			,Folder profilePictureFolder,ServiceContext serviceContext) {
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
		if (file != null && file.exists() && fileName != null) {
			long userId = themeDisplay.getUserId();
			long profilePicId = employeeDetails.getProfilePicId();
			try {	
				if (profilePicId == 0) {
							FileEntry entry = DLAppLocalServiceUtil.addFileEntry(themeDisplay.getUserId(),
									themeDisplay.getScopeGroupId(), profilePictureFolder.getFolderId(), fileName,
									MimeTypesUtil.getContentType(file), fileName, StringPool.BLANK, StringPool.BLANK, file,
									serviceContext);
							log.info("AddEditEmployeeOnBoardingMVCActionCommmand >>> doProcessAction >>> ::: entry =" + entry.getFileEntryId());
							employeeDetails.setProfilePicId(entry.getFileEntryId());
		        }else {
		            FileEntry existingFileEntry = DLAppLocalServiceUtil.getFileEntry(profilePicId);
		            String mimeType = MimeTypesUtil.getContentType(file);
		            byte[] fileContent = Files.readAllBytes(file.toPath());
		            FileEntry updatedFileEntry = DLAppLocalServiceUtil.updateFileEntry(userId,profilePicId,fileName,mimeType,fileName,null,existingFileEntry.getDescription(),StringPool.BLANK,DLVersionNumberIncrease.MAJOR,fileContent,null,null,serviceContext);
		            User user = themeDisplay.getUser();
		            user.setPortraitId(updatedFileEntry.getFileEntryId());
		            String  profilePicName =updatedFileEntry.getFileName();
					log.info("AddEditEmployeeOnBoardingMVCActionCommmand >>> doProcessAction >>> ::: proilePicName ==>" + profilePicName);
		            user.setAgreedToTermsOfUse(true);
		            UserLocalServiceUtil.updateUser(user);   
		        }
		    } catch (PortalException | SystemException | java.io.IOException e) {
		        log.error("Error updating file entry for user ID " + userId + ": ", e);
		    }
		} else {
			log.error("File does not exist or file name is null");
		}
	}	
}
