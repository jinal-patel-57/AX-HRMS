package com.ax.hrms.policy.process.management.employee.web.action;

import com.ax.hrms.master.service.PolicyTypeMasterLocalService;
import com.ax.hrms.model.Policy;
import com.ax.hrms.policy.process.management.web.constants.AxHrmsPolicyProcessManagementEmployeeWebPortletKeys;
import com.ax.hrms.policy.process.management.web.constants.AxHrmsPolicyProcessManagementWebPortletConstants;
import com.ax.hrms.service.PolicyLocalService;
import com.liferay.document.library.kernel.model.DLFolderConstants;
import com.liferay.document.library.kernel.service.DLAppServiceUtil;
import com.liferay.document.library.kernel.service.DLFolderLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;


@Component(
        immediate = true,
        property = {
                "javax.portlet.name=" + AxHrmsPolicyProcessManagementEmployeeWebPortletKeys.AXHRMSPOLICYPROCESSMANAGEMENTEMPLOYEEWEB,
                "mvc.command.name=/downloadPolicy"
        },
        service = MVCResourceCommand.class
)



public class DownloadPolicyProcessManagementEmployee  extends BaseMVCResourceCommand {

    @Reference
    PolicyLocalService policyLocalService;
    @Reference
    PolicyTypeMasterLocalService policyTypeMasterLocalService;

    private static final Log log = LogFactoryUtil.getLog(DownloadPolicyProcessManagementEmployee.class);
    @Override
    protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws PortalException, IOException {

        long searchKeyWord = ParamUtil.getLong(resourceRequest, AxHrmsPolicyProcessManagementWebPortletConstants.Policy_Id_Policy_Process_Management, 0);
        System.out.println(searchKeyWord);

        Policy policy = policyLocalService.getPolicy(searchKeyWord);

        ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
        resourceRequest.setAttribute(AxHrmsPolicyProcessManagementWebPortletConstants.ThemeDisplay_Policy_Process_Management, themeDisplay);
        long groupId = themeDisplay.getScopeGroupId();
        long parentFolderId = DLFolderConstants.DEFAULT_PARENT_FOLDER_ID;
        long policyTypeFolder=0;

        try {
            long policyFolder = DLFolderLocalServiceUtil.getFolder(groupId, parentFolderId, AxHrmsPolicyProcessManagementWebPortletConstants.Policy_Documents_Policy_Process_Management).getFolderId();
            long yearFolder = DLFolderLocalServiceUtil.getFolder(groupId, policyFolder, AxHrmsPolicyProcessManagementWebPortletConstants.Year_Policy_Process_Management +policy.getYear()).getFolderId();

            String policyName = policyTypeMasterLocalService.getPolicyTypeMaster(policy.getPolicyTypeId()).getPolicyType();

            policyTypeFolder = DLFolderLocalServiceUtil.getFolder(groupId, yearFolder, policyName).getFolderId();
            log.info(policyTypeFolder);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        String url= null;
        try {
            List<FileEntry> fileEntries = DLAppServiceUtil.getFileEntries(groupId, policyTypeFolder);
            for (FileEntry file : fileEntries) {
                    url = themeDisplay.getPortalURL() + themeDisplay.getPathContext() + AxHrmsPolicyProcessManagementWebPortletConstants.Slash_Document_Policy_Process_Management + themeDisplay.getScopeGroupId() + AxHrmsPolicyProcessManagementWebPortletConstants.Slash_Policy_Process_Management +
                            file.getFolderId() +  AxHrmsPolicyProcessManagementWebPortletConstants.Slash_Policy_Process_Management +file.getTitle() ;
                }
        } catch (Exception e) {
            e.printStackTrace();
        }


        System.out.println("Url =============================== "+url);
        
        JSONObject responseObj = JSONFactoryUtil.createJSONObject();
        PrintWriter writer = null;

        writer = resourceResponse.getWriter();
        responseObj.put(AxHrmsPolicyProcessManagementWebPortletConstants.Download_Url_Policy_Process_Management, url);
        responseObj.put(AxHrmsPolicyProcessManagementWebPortletConstants.Policy_Status_Policy_Process_Management, AxHrmsPolicyProcessManagementWebPortletConstants.Success_Policy_Process_Management);
        log.info(AxHrmsPolicyProcessManagementWebPortletConstants.RetrivedSuccessfully_Policy_Process_Management);

        writer.write(responseObj.toString());
        writer.close();

    }
}
