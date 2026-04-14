package com.ax.hrms.profile.management.action;

import com.ax.hrms.exception.NoSuchEmployeeDetailsException;
import com.ax.hrms.master.service.DepartmentMasterLocalService;
import com.ax.hrms.master.service.DesignationMasterLocalService;
import com.ax.hrms.model.EmployeeAddress;
import com.ax.hrms.profile.management.constants.AxHrmsProfileManagementWebConstants;
import com.ax.hrms.profile.management.constants.AxHrmsProfileManagementWebPortletKeys;
import com.ax.hrms.profile.management.dto.EmployeeDto;
import com.ax.hrms.profile.management.util.EmployeeProfileUtil;
import com.ax.hrms.service.*;
import com.liferay.document.library.kernel.service.DLAppLocalServiceUtil;
import com.liferay.document.library.kernel.util.DLUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.service.CountryLocalService;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import java.util.HashMap;
import java.util.Map;

@Component(
        immediate = true,
        property = {
                "javax.portlet.name="+ AxHrmsProfileManagementWebPortletKeys.AXHRMSPROFILEMANAGEMENTWEB,
                "mvc.command.name="+ AxHrmsProfileManagementWebConstants.EDIT_EMPLOYEE_PROFILE_JSP_FILE
        }
)
public class EditEmployeeProfileMVCRenderCommand implements MVCRenderCommand {
    private static Log log = LogFactoryUtil.getLog(EditEmployeeProfileMVCRenderCommand.class);

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
    @Reference
    NomineeLocalService nomineeLocalService;
    @Override
    public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
        log.info("EditEmployeeProfileMVCRenderCommand >>> Render ::: Edit Employee Profile JSP File Render...");

        ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);

        Map<String,Object> localServiceProvider = new HashMap<>();
        localServiceProvider.put(AxHrmsProfileManagementWebConstants.EMPLOYEE_DETAILS_LOCAL_SERVICE,employeeDetailsLocalService);
        localServiceProvider.put(AxHrmsProfileManagementWebConstants.EMPLOYEE_ADDRESS_LOCAL_SERVICE,employeeAddressLocalService);
        localServiceProvider.put(AxHrmsProfileManagementWebConstants.ADDRESS_LOCAL_SERVICE,addressLocalService);
        localServiceProvider.put(AxHrmsProfileManagementWebConstants.EMPLOYEE_DESIGNATION_LOCAL_SERVICE,employeeDesignationLocalService);
        localServiceProvider.put(AxHrmsProfileManagementWebConstants.EMPLOYEE_DEPARTMENT_LOCAL_SERVICE,employeeDepartmentLocalService);
        localServiceProvider.put(AxHrmsProfileManagementWebConstants.DESIGNATION_MASTER_LOCAL_SERVICE,designationMasterLocalService);
        localServiceProvider.put(AxHrmsProfileManagementWebConstants.DEPARTMENT_MASTER_LOCAL_SERVICE,departmentMasterLocalService);
        localServiceProvider.put(AxHrmsProfileManagementWebConstants.COUNTRY_LOCAL_SERVICE,countryLocalService);
        localServiceProvider.put(AxHrmsProfileManagementWebConstants.NOMINEE_LOCAL_SERVICE,nomineeLocalService);

        EmployeeProfileUtil employeeProfileUtil = new EmployeeProfileUtil(localServiceProvider);

        long employeeId = 0;
        try {
            employeeId = employeeDetailsLocalService.findByLrUserId(themeDisplay.getUserId()).getEmployeeId();
            employeeProfileUtil.setEmployeeDetails(renderRequest, employeeId);
            employeeProfileUtil.setAddress(renderRequest, employeeId);
            employeeProfileUtil.setNominee(renderRequest, employeeId);

            renderRequest.setAttribute(
                    AxHrmsProfileManagementWebConstants.COUNTRY_LIST,
                    countryLocalService.getCountries(-1, -1)
            );

            long employeeAddressId = employeeDetailsLocalService.getEmployeeDetails(employeeId).getEmployeeAddressId();

            EmployeeAddress employeeAddress = employeeAddressLocalService.getEmployeeAddress(employeeAddressId);

            long addressProofFileEntryId = employeeAddress.getEmployeeAddressProofFileEntryId();

            String addressProofPreviewURL = null;

            if (addressProofFileEntryId > 0) {

                FileEntry fileEntry =
                        DLAppLocalServiceUtil.getFileEntry(addressProofFileEntryId);

                addressProofPreviewURL =
                        DLUtil.getPreviewURL(
                                fileEntry,
                                fileEntry.getFileVersion(),
                                themeDisplay,
                                ""
                        );

                renderRequest.setAttribute(
                        "addressProofPreviewURL",
                        addressProofPreviewURL
                );
            }

        } catch (NoSuchEmployeeDetailsException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new PortletException(e);
        }

        return AxHrmsProfileManagementWebConstants.EDIT_EMPLOYEE_PROFILE_JSP_FILE;
    }

}
