package com.ax.hrms.hr.appraisal.form.templates.action;

import com.ax.hrms.hr.appraisal.form.templates.constants.AxHrmsHrAppraisalFormTemplatesPortletKey;
import com.ax.hrms.hr.appraisal.form.templates.constants.AxHrmsHrAppraisalFormTemplatesWebConstants;
import com.ax.hrms.master.service.TemplateLevelMasterLocalService;
import com.ax.hrms.model.AppraisalFormTemplates;
import com.ax.hrms.service.AppraisalFormTemplatesLocalService;
import com.liferay.document.library.kernel.service.DLAppService;
import com.liferay.document.library.kernel.service.DLFolderLocalService;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

/**
 * @author krish.moradiya
 * @implNote : Using this class, Perform delete action of Appraisal Form Template
 */
@Component(
        immediate = true,
        property = {
                "javax.portlet.name=" + AxHrmsHrAppraisalFormTemplatesPortletKey.AXHRMS_HR_APPRAISAL_FORM_TEMPLATES_PORTLET_KEY,
                "mvc.command.name=/deleteAppraisalFormTemplate"
        },
        service = MVCActionCommand.class
)
public class DeleteAppraisalFormTemplateMVCActionCommand  extends BaseMVCActionCommand {
    @Reference
    AppraisalFormTemplatesLocalService appraisalFormTemplatesLocalService;
    @Reference
    DLAppService dlAppService;
    @Reference
    TemplateLevelMasterLocalService templateLevelMasterLocalService;
    @Reference
    DLFolderLocalService dlFolderLocalService;
    @Override
    protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
        long appraisalFormTemplateId = ParamUtil.getLong(actionRequest, AxHrmsHrAppraisalFormTemplatesWebConstants.APPRAISAL_FORM_TEMPLATE_ID, GetterUtil.DEFAULT_LONG);
        if(appraisalFormTemplateId > 0){
            AppraisalFormTemplates appraisalFormTemplates = appraisalFormTemplatesLocalService.fetchAppraisalFormTemplates(appraisalFormTemplateId);
            FileEntry fileEntry = dlAppService.getFileEntry(appraisalFormTemplates.getTemplateDocumentId());
            long folderId = fileEntry.getFolderId();
            dlAppService.deleteFileEntry(fileEntry.getFileEntryId());
            appraisalFormTemplatesLocalService.deleteAppraisalFormTemplates(appraisalFormTemplateId);
            dlFolderLocalService.deleteDLFolder(folderId);

            SessionMessages.add(actionRequest,AxHrmsHrAppraisalFormTemplatesWebConstants.DELETE_APPRAISAL_FORM_TEMPLATE);
        }
        actionResponse.sendRedirect(ParamUtil.getString(actionRequest,AxHrmsHrAppraisalFormTemplatesWebConstants.ITERATOR_URL));
    }
}
