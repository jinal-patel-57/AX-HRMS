package com.ax.hrms.hr.appraisal.form.templates.action;

import com.ax.hrms.common.api.api.AxHrmsCommonApi;
import com.ax.hrms.exception.NoSuchAppraisalFormTemplatesException;
import com.ax.hrms.hr.appraisal.form.templates.constants.AxHrmsHrAppraisalFormTemplatesPortletKey;
import com.ax.hrms.hr.appraisal.form.templates.constants.AxHrmsHrAppraisalFormTemplatesWebConstants;
import com.ax.hrms.master.model.TemplateLevelMaster;
import com.ax.hrms.master.service.TemplateLevelMasterLocalService;
import com.ax.hrms.model.AppraisalFormTemplates;
import com.ax.hrms.service.AppraisalFormTemplatesLocalService;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.document.library.kernel.model.DLFileEntry;
import com.liferay.document.library.kernel.model.DLFolder;
import com.liferay.document.library.kernel.model.DLVersionNumberIncrease;
import com.liferay.document.library.kernel.service.DLAppLocalServiceUtil;
import com.liferay.document.library.kernel.service.DLAppService;
import com.liferay.document.library.kernel.service.DLFileEntryLocalService;
import com.liferay.document.library.kernel.service.DLFolderLocalService;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.repository.model.Folder;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.*;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.io.File;
import java.nio.file.Files;
import java.util.Map;

/**
 * @author krish.moradiya
 * @implNote : In this HR add Appraisal Form Template and also update using this Java Class
 */
@Component(
        immediate = true,
        property = {
                "javax.portlet.name=" + AxHrmsHrAppraisalFormTemplatesPortletKey.AXHRMS_HR_APPRAISAL_FORM_TEMPLATES_PORTLET_KEY,
                "mvc.command.name="+AxHrmsHrAppraisalFormTemplatesWebConstants.ADD_APPRAISAL_FORM_TEMPLATE_URL
        },
        service = MVCActionCommand.class
)
public class AddEditAppraisalFormTemplateMVCActionCommand extends BaseMVCActionCommand {

    private static final Log log = LogFactoryUtil.getLog(AddEditAppraisalFormTemplateMVCActionCommand.class);

    @Reference
    private AxHrmsCommonApi axHrmsCommonApi;

    @Reference
    private DLFolderLocalService dlFolderLocalService;

    @Reference
    private DLAppService dlAppService;

    @Reference
    private DLFileEntryLocalService dlFileEntryLocalService;

    @Reference
    private TemplateLevelMasterLocalService templateLevelMasterLocalService;

    @Reference
    private AppraisalFormTemplatesLocalService appraisalFormTemplatesLocalService;

    @Override
    protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
        super.hideDefaultErrorMessage(actionRequest);
        super.hideDefaultSuccessMessage(actionRequest);
        ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
        String namespace = PortalUtil.getPortletNamespace(themeDisplay.getPpid());
        long appraisalFormTemplateId = ParamUtil.getLong(actionRequest, AxHrmsHrAppraisalFormTemplatesWebConstants.APPRAISAL_FORM_TEMPLATE_ID, GetterUtil.DEFAULT_LONG);
        AppraisalFormTemplates appraisalFormTemplates = setAppraisalFormTemplateData(actionRequest);

        if (appraisalFormTemplateId == 0) {
            handleNewTemplate(actionRequest, actionResponse, themeDisplay, namespace, appraisalFormTemplates);
        } else {
            handleExistingTemplate(actionRequest, actionResponse, themeDisplay, namespace, appraisalFormTemplateId, appraisalFormTemplates);
        }
    }

    private void handleNewTemplate(ActionRequest actionRequest, ActionResponse actionResponse, ThemeDisplay themeDisplay, String namespace, AppraisalFormTemplates appraisalFormTemplates) {
        if (isExistCombinationOfLevelAndYear(appraisalFormTemplates.getTemplateLevelId(), appraisalFormTemplates.getTemplateYear(), appraisalFormTemplates.getAppraisalFormTemplateId())) {
            handleExistingEntry(actionRequest, actionResponse, appraisalFormTemplates);
        } else {
            try {
                TemplateLevelMaster templateLevelMaster = templateLevelMasterLocalService.fetchTemplateLevelMaster(appraisalFormTemplates.getTemplateLevelId());
                createFile(namespace, themeDisplay, actionRequest, templateLevelMaster, appraisalFormTemplates);
            } catch (Exception exception) {
                log.error("Exception at insert form template: " + exception.getMessage());
                SessionErrors.add(actionRequest, AxHrmsHrAppraisalFormTemplatesWebConstants.APPRAISAL_FORM_NOT_ADDED);
            }
        }
    }
    private void handleExistingEntry(ActionRequest actionRequest, ActionResponse actionResponse, AppraisalFormTemplates appraisalFormTemplates) {
        SessionErrors.add(actionRequest, AxHrmsHrAppraisalFormTemplatesWebConstants.EXISTED_ENTRY);
        actionRequest.setAttribute(AxHrmsHrAppraisalFormTemplatesWebConstants.EXISTED_APPRAISAL_FORM_TEMPLATE, appraisalFormTemplates);
        actionResponse.setRenderParameter(AxHrmsHrAppraisalFormTemplatesWebConstants.MVC_RENDER_COMMAND_NAME, AxHrmsHrAppraisalFormTemplatesWebConstants.ADD_APPRAISAL_FORM_TEMPLATES_JSP_PATH);
    }
    private void updateTemplate(ActionRequest actionRequest, ThemeDisplay themeDisplay, String namespace, long appraisalFormTemplateId, AppraisalFormTemplates appraisalFormTemplates) throws PortalException {
        AppraisalFormTemplates tempAppraisalFormTemplate = appraisalFormTemplatesLocalService.getAppraisalFormTemplates(appraisalFormTemplateId);
        TemplateLevelMaster temporalTemplateLevelMaster = templateLevelMasterLocalService.fetchTemplateLevelMaster(tempAppraisalFormTemplate.getTemplateLevelId());
        TemplateLevelMaster templateLevelMaster = templateLevelMasterLocalService.fetchTemplateLevelMaster(appraisalFormTemplates.getTemplateLevelId());

        String yearFolderName = AxHrmsHrAppraisalFormTemplatesWebConstants.YEAR_SPACE + appraisalFormTemplates.getTemplateYear();
        String levelFolderName = templateLevelMaster.getLevelName();

        ServiceContext serviceContext = ServiceContextFactory.getInstance(Folder.class.getName(), actionRequest);
        Folder levelFolder = getOrCreateFolderStructure(themeDisplay, yearFolderName, levelFolderName, serviceContext);

        UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(actionRequest);
        File file = uploadRequest.getFile(namespace + AxHrmsHrAppraisalFormTemplatesWebConstants.FORM_TEMPLATE_FILE);
        String fileName = uploadRequest.getFileName(namespace + AxHrmsHrAppraisalFormTemplatesWebConstants.FORM_TEMPLATE_FILE);
        String mimeType = MimeTypesUtil.getContentType(file);

        List<FileEntry> listFileEntries = dlAppService.getFileEntries(levelFolder.getRepositoryId(), levelFolder.getFolderId());

        Map<String,String> stringProviderMap = new HashMap<>();
        stringProviderMap.put(AxHrmsHrAppraisalFormTemplatesWebConstants.FILENAME,fileName);
        stringProviderMap.put(AxHrmsHrAppraisalFormTemplatesWebConstants.MIMETYPE,mimeType);
        stringProviderMap.put(AxHrmsHrAppraisalFormTemplatesWebConstants.LEVEL_FOLDER_NAME,levelFolderName);
        stringProviderMap.put(AxHrmsHrAppraisalFormTemplatesWebConstants.YEAR_FOLDER_NAME,yearFolderName);

        if (!listFileEntries.isEmpty() && file.exists()) {
            updateFileEntry(themeDisplay, stringProviderMap, listFileEntries, file, appraisalFormTemplates, serviceContext, actionRequest);
        }
        if (!tempAppraisalFormTemplate.getTemplateYear().equals(appraisalFormTemplates.getTemplateYear()) || tempAppraisalFormTemplate.getTemplateLevelId() != appraisalFormTemplates.getTemplateLevelId()) {
            moveFileToNewFolder(themeDisplay, tempAppraisalFormTemplate, appraisalFormTemplates, file, serviceContext,temporalTemplateLevelMaster,stringProviderMap);
        }
        appraisalFormTemplatesLocalService.updateAppraisalFormTemplates(appraisalFormTemplates);
        SessionMessages.add(actionRequest, AxHrmsHrAppraisalFormTemplatesWebConstants.ADD_FORM_TEMPLATE_UPDATED_SUCCESSFULLY);
    }
    private Folder getOrCreateFolderStructure(ThemeDisplay themeDisplay, String yearFolderName, String levelFolderName, ServiceContext serviceContext) {
        Folder parentFolder = axHrmsCommonApi.createFolder(AxHrmsHrAppraisalFormTemplatesWebConstants.APPRAISAL_FORM_TEMPLATE_FOLDER_NAME, 0, themeDisplay, serviceContext);
        Folder yearFolder = axHrmsCommonApi.createFolder(yearFolderName, parentFolder.getFolderId(), themeDisplay, serviceContext);
        return axHrmsCommonApi.createFolder(levelFolderName, yearFolder.getFolderId(), themeDisplay, serviceContext);
    }

    private void handleExistingTemplate(ActionRequest actionRequest, ActionResponse actionResponse, ThemeDisplay themeDisplay, String namespace, long appraisalFormTemplateId, AppraisalFormTemplates appraisalFormTemplates) {
        if (isExistCombinationOfLevelAndYear(appraisalFormTemplates.getTemplateLevelId(), appraisalFormTemplates.getTemplateYear(), appraisalFormTemplateId)) {
            handleExistingEntry(actionRequest, actionResponse, appraisalFormTemplates);
        } else {
            try {
                updateTemplate(actionRequest, themeDisplay, namespace, appraisalFormTemplateId, appraisalFormTemplates);
            } catch (Exception exception) {
                log.error("Exception at update form template: " + exception.getMessage());
                SessionErrors.add(actionRequest, AxHrmsHrAppraisalFormTemplatesWebConstants.ADD_FORM_TEMPLATE_NOT_UPDATED);
            }
        }
    }

    private void updateFileEntry(ThemeDisplay themeDisplay, Map<String,String> stringProviderMap, List<FileEntry> listFileEntries, File file, AppraisalFormTemplates appraisalFormTemplates, ServiceContext serviceContext, ActionRequest actionRequest) throws PortalException {
        try{
            String fileName = stringProviderMap.get(AxHrmsHrAppraisalFormTemplatesWebConstants.FILENAME);
            String mimeType = stringProviderMap.get(AxHrmsHrAppraisalFormTemplatesWebConstants.MIMETYPE);

            FileEntry existingFileEntry = DLAppLocalServiceUtil.getFileEntry(listFileEntries.get(0).getFileEntryId());
            byte[] fileContent = Files.readAllBytes(file.toPath());

            FileEntry updatedFileEntry = DLAppLocalServiceUtil.updateFileEntry(
                    themeDisplay.getUserId(),
                    appraisalFormTemplatesLocalService.getAppraisalFormTemplates(appraisalFormTemplates.getAppraisalFormTemplateId()).getTemplateDocumentId(), fileName, mimeType, fileName, null,
                    existingFileEntry.getDescription(), StringPool.BLANK, DLVersionNumberIncrease.MAJOR, fileContent, null, null, serviceContext
            );

            User user = themeDisplay.getUser();
            user.setPortraitId(updatedFileEntry.getFileEntryId());
            user.setAgreedToTermsOfUse(true);
            UserLocalServiceUtil.updateUser(user);
            SessionMessages.add(actionRequest, AxHrmsHrAppraisalFormTemplatesWebConstants.ADD_FORM_TEMPLATE_UPDATED_SUCCESSFULLY);
        }catch(IOException e){
            log.error("AddEditAppraisalFormTemplateMVCActionCommand >>> updateFileEntry ::: IO Exception");
        }
    }


    private void moveFileToNewFolder(ThemeDisplay themeDisplay, AppraisalFormTemplates tempAppraisalFormTemplate, AppraisalFormTemplates appraisalFormTemplates, File file, ServiceContext serviceContext,TemplateLevelMaster temporalTemplateLevelMaster,Map<String,String> stringProviderMap) throws PortalException {
        String fileName = stringProviderMap.get(AxHrmsHrAppraisalFormTemplatesWebConstants.FILENAME);
        String mimeType = stringProviderMap.get(AxHrmsHrAppraisalFormTemplatesWebConstants.MIMETYPE);
        String levelFolderName = stringProviderMap.get(AxHrmsHrAppraisalFormTemplatesWebConstants.LEVEL_FOLDER_NAME);
        String yearFolderName = stringProviderMap.get(AxHrmsHrAppraisalFormTemplatesWebConstants.YEAR_FOLDER_NAME);

        DLFileEntry currentFile;
        if (tempAppraisalFormTemplate.getTemplateDocumentId() == appraisalFormTemplates.getTemplateDocumentId()) {
            if (!dlFileEntryLocalService.fetchDLFileEntry(tempAppraisalFormTemplate.getTemplateDocumentId()).getFileName().equals(fileName)) {
                DLAppLocalServiceUtil.updateFileEntry(themeDisplay.getUserId(), tempAppraisalFormTemplate.getTemplateDocumentId(), fileName, mimeType, fileName, null, dlFileEntryLocalService.fetchDLFileEntry(tempAppraisalFormTemplate.getTemplateDocumentId()).getDescription(), null, DLVersionNumberIncrease.MAJOR, file, null, null, serviceContext);
            }
            currentFile = dlFileEntryLocalService.fetchDLFileEntry(tempAppraisalFormTemplate.getTemplateDocumentId());
        } else {
            currentFile = dlFileEntryLocalService.fetchDLFileEntry(appraisalFormTemplates.getTemplateDocumentId());
        }

        DLFolder dlFolder = getDlFolderByName(0L, themeDisplay, AxHrmsHrAppraisalFormTemplatesWebConstants.APPRAISAL_FORM_TEMPLATE_FOLDER_NAME, yearFolderName, levelFolderName);
        currentFile.setFolderId(dlFolder.getFolderId());
        currentFile.setTreePath(dlFolder.getTreePath());
        deleteDlFolder(temporalTemplateLevelMaster.getLevelName(), themeDisplay, 0L, AxHrmsHrAppraisalFormTemplatesWebConstants.APPRAISAL_FORM_TEMPLATE_FOLDER_NAME, AxHrmsHrAppraisalFormTemplatesWebConstants.YEAR_SPACE + tempAppraisalFormTemplate.getTemplateYear());
        dlFileEntryLocalService.updateDLFileEntry(currentFile);
    }

    public AppraisalFormTemplates setAppraisalFormTemplateData(ActionRequest actionRequest) {
        AppraisalFormTemplates appraisalFormTemplates = null;
        ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);

        String templateName = ParamUtil.getString(actionRequest,AxHrmsHrAppraisalFormTemplatesWebConstants.TEMPLATE_NAME, GetterUtil.DEFAULT_STRING);
        long levelId = ParamUtil.getLong(actionRequest,AxHrmsHrAppraisalFormTemplatesWebConstants.LEVEL_NAME, GetterUtil.DEFAULT_LONG);
        String yearOfTemplate = ParamUtil.getString(actionRequest,AxHrmsHrAppraisalFormTemplatesWebConstants.YEAR_OF_TEMPLATE,GetterUtil.DEFAULT_STRING);
        long appraisalFormTemplateId = ParamUtil.getLong(actionRequest,AxHrmsHrAppraisalFormTemplatesWebConstants.APPRAISAL_FORM_TEMPLATE_ID,GetterUtil.DEFAULT_LONG);

        try{
            if(appraisalFormTemplateId == 0){
                appraisalFormTemplates = appraisalFormTemplatesLocalService.createAppraisalFormTemplates(CounterLocalServiceUtil.increment(AppraisalFormTemplates.class.getName()));
                appraisalFormTemplates.setCreatedBy(themeDisplay.getUserId());
                appraisalFormTemplates.setTemplateName(templateName);
                appraisalFormTemplates.setTemplateLevelId(levelId);
                appraisalFormTemplates.setTemplateYear(yearOfTemplate);
                appraisalFormTemplates.setModifiedBy(themeDisplay.getUserId());
                appraisalFormTemplates.setGroupId(themeDisplay.getScopeGroupId());
            }else{
                appraisalFormTemplates = appraisalFormTemplatesLocalService.fetchAppraisalFormTemplates(appraisalFormTemplateId);
                appraisalFormTemplates.setTemplateName(templateName);
                appraisalFormTemplates.setTemplateLevelId(levelId);
                appraisalFormTemplates.setTemplateYear(yearOfTemplate);
                appraisalFormTemplates.setModifiedBy(themeDisplay.getUserId());
                appraisalFormTemplates.setGroupId(themeDisplay.getScopeGroupId());
            }
        }catch(Exception exception){
            log.error("AddEditAppraisalFormTemplateMVCActionCommand >>> setAppraisalFormTemplateData ::: PortalException Occur");
        }
        return appraisalFormTemplates;
    }

    public boolean isExistCombinationOfLevelAndYear(long templateLevelId,String year,long newAppraisalFormTemplateId){
        try{
            AppraisalFormTemplates appraisalFormTemplates = appraisalFormTemplatesLocalService.findByTemplateLevelIdAndTemplateYear(templateLevelId,year);
            log.info("AddEditAppraisalFormTemplateMVCActionCommand >>> isExistCombinationOfLevelAndYear ::: TemplateId is: "+appraisalFormTemplates.getAppraisalFormTemplateId());
            if(appraisalFormTemplates.getAppraisalFormTemplateId() == newAppraisalFormTemplateId)
                return false;
        }catch(NoSuchAppraisalFormTemplatesException exception){
            log.error("AddEditAppraisalFormTemplateMVCActionCommand >>> checkCombinationOfLevelAndYear ::: NoSuchAppraisalFormTemplatesException Occur...");
            return false;
        }
        return true;
    }

    public void addFileEntry(List<FileEntry> listFileEntries,File file,Folder levelFolder,AppraisalFormTemplates appraisalFormTemplates,String fileName,ServiceContext serviceContext,ActionRequest actionRequest){
        ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
        try{
            if(listFileEntries.isEmpty() && file.exists()){

                FileEntry entry = DLAppLocalServiceUtil.addFileEntry(themeDisplay.getUserId(),
                        themeDisplay.getScopeGroupId(), levelFolder.getFolderId(), fileName,
                        MimeTypesUtil.getContentType(file), fileName, StringPool.BLANK, StringPool.BLANK, file,
                        serviceContext);
                appraisalFormTemplates.setTemplateDocumentId(entry.getFileEntryId());
                appraisalFormTemplatesLocalService.addAppraisalFormTemplates(appraisalFormTemplates);
                SessionMessages.add(actionRequest,AxHrmsHrAppraisalFormTemplatesWebConstants.ADD_FORM_TEMPLATE_SUCCESSFULLY);
            }
        }catch (PortalException exception){
            log.error("AddEditAppraisalFormTemplateMVCActionCommand >>> addFileEntry ::: Exception is: "+exception.getMessage());
        }
    }
    public void createFile(String namespace,ThemeDisplay themeDisplay,ActionRequest actionRequest,TemplateLevelMaster templateLevelMaster,AppraisalFormTemplates appraisalFormTemplates) throws PortalException{
        String yearFolderName = AxHrmsHrAppraisalFormTemplatesWebConstants.YEAR_SPACE+appraisalFormTemplates.getTemplateYear();
        String levelFolderName = templateLevelMaster.getLevelName();

        ServiceContext serviceContext = ServiceContextFactory.getInstance(Folder.class.getName(), actionRequest);
        serviceContext.setAddGroupPermissions(true);
        serviceContext.setAddGuestPermissions(false);

        Folder parentFolder = axHrmsCommonApi.createFolder(AxHrmsHrAppraisalFormTemplatesWebConstants.APPRAISAL_FORM_TEMPLATE_FOLDER_NAME, 0, themeDisplay, serviceContext);
        Folder yearFolder = axHrmsCommonApi.createFolder(yearFolderName,parentFolder.getFolderId(), themeDisplay, serviceContext);
        Folder levelFolder = axHrmsCommonApi.createFolder(levelFolderName, yearFolder.getFolderId(),themeDisplay, serviceContext);

        //Upload System Setup
        UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(actionRequest);
        File file = uploadRequest.getFile(namespace +AxHrmsHrAppraisalFormTemplatesWebConstants.FORM_TEMPLATE_FILE);
        String fileName = uploadRequest.getFileName(namespace+AxHrmsHrAppraisalFormTemplatesWebConstants.FORM_TEMPLATE_FILE);

        List<FileEntry> listFileEntries = dlAppService.getFileEntries(levelFolder.getRepositoryId(),levelFolder.getFolderId());
        addFileEntry(listFileEntries,file,levelFolder,appraisalFormTemplates,fileName,serviceContext,actionRequest);
    }

    public DLFolder getDlFolderByName(long parentFolderId,ThemeDisplay themeDisplay,String parentFolderName,String yearFolderName,String levelName){
        DLFolder mainFolder = dlFolderLocalService.fetchFolder(themeDisplay.getScopeGroupId(),parentFolderId,parentFolderName);
        DLFolder yearDlFolder = dlFolderLocalService.fetchFolder(themeDisplay.getScopeGroupId(),mainFolder.getFolderId(),yearFolderName);
        return dlFolderLocalService.fetchFolder(themeDisplay.getScopeGroupId(),yearDlFolder.getFolderId(),levelName);
    }
    public void deleteDlFolder(String levelFolderName,ThemeDisplay themeDisplay,long parentFolderId,String parentFolderName,String yearFolderName){
        DLFolder mainFolder = dlFolderLocalService.fetchFolder(themeDisplay.getScopeGroupId(),parentFolderId,parentFolderName);
        DLFolder yearDlFolder = dlFolderLocalService.fetchFolder(themeDisplay.getScopeGroupId(),mainFolder.getFolderId(),yearFolderName);
        dlFolderLocalService.deleteDLFolder(dlFolderLocalService.fetchFolder(themeDisplay.getScopeGroupId(), yearDlFolder.getFolderId(), levelFolderName));
    }
}