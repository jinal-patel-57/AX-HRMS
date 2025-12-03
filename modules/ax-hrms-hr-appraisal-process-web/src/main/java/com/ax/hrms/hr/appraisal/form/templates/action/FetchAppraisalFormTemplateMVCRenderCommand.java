package com.ax.hrms.hr.appraisal.form.templates.action;

import com.ax.hrms.hr.appraisal.form.templates.constants.AxHrmsHrAppraisalFormTemplatesPortletKey;
import com.ax.hrms.hr.appraisal.form.templates.constants.AxHrmsHrAppraisalFormTemplatesWebConstants;
import com.ax.hrms.master.model.TemplateLevelMaster;
import com.ax.hrms.master.service.TemplateLevelMasterLocalService;
import com.ax.hrms.model.AppraisalFormTemplates;
import com.ax.hrms.service.AppraisalFormTemplatesLocalService;
import com.liferay.document.library.kernel.service.DLAppService;
import com.liferay.document.library.kernel.service.DLFileEntryLocalService;
import com.liferay.document.library.kernel.util.DLUtil;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import java.util.List;

/**
 * @author krish.moradiya
 * @implNote : Using this class, Fetch Data and fill up in AddAppraisalFormTemplate form to EditThat
 */
@Component(
        immediate = true,
        property = {
                "javax.portlet.name=" + AxHrmsHrAppraisalFormTemplatesPortletKey.AXHRMS_HR_APPRAISAL_FORM_TEMPLATES_PORTLET_KEY,
                "mvc.command.name="+ AxHrmsHrAppraisalFormTemplatesWebConstants.FETCH_FORM_TEMPLATE_DETAIL_URL
        },
        service = MVCRenderCommand.class
)
public class FetchAppraisalFormTemplateMVCRenderCommand implements MVCRenderCommand {

    @Reference
    AppraisalFormTemplatesLocalService appraisalFormTemplatesLocalService;
    @Reference
    DLFileEntryLocalService dlFileEntryLocalService;
    @Reference
    DLAppService dlAppLocalService;
    @Reference
    TemplateLevelMasterLocalService templateLevelMasterLocalService;
    private static final Log log = LogFactoryUtil.getLog(FetchAppraisalFormTemplateMVCRenderCommand.class);
    @Override
    public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
        ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);

        long appraisalFormTemplateId = ParamUtil.getLong(renderRequest,AxHrmsHrAppraisalFormTemplatesWebConstants.APPRAISAL_FORM_TEMPLATE_ID, GetterUtil.DEFAULT_LONG);
        AppraisalFormTemplates appraisalFormTemplate = appraisalFormTemplatesLocalService.fetchAppraisalFormTemplates(appraisalFormTemplateId);
        String filePreviewUrl = AxHrmsHrAppraisalFormTemplatesWebConstants.BLANK;
        String fileName = AxHrmsHrAppraisalFormTemplatesWebConstants.BLANK;
        try {
            FileEntry fileEntry = dlAppLocalService.getFileEntry(appraisalFormTemplate.getTemplateDocumentId());
            filePreviewUrl = DLUtil.getPreviewURL(fileEntry, fileEntry.getFileVersion(), themeDisplay, StringPool.BLANK);
            fileName = fileEntry.getFileName();
        } catch (PortalException e) {
            log.error("FetchAppraisalFormTemplateMVCRenderCommand >>> render ::: Exception is: "+e.getMessage());
        }

        List<TemplateLevelMaster> templateLevelMasterList = templateLevelMasterLocalService.getTemplateLevelMasters(-1,-1);
        renderRequest.setAttribute(AxHrmsHrAppraisalFormTemplatesWebConstants.TEMPLATE_LEVEL_MASTER_LIST,templateLevelMasterList);
        renderRequest.setAttribute(AxHrmsHrAppraisalFormTemplatesWebConstants.URL,filePreviewUrl);
        renderRequest.setAttribute(AxHrmsHrAppraisalFormTemplatesWebConstants.FILE_NAME,fileName);
        renderRequest.setAttribute(AxHrmsHrAppraisalFormTemplatesWebConstants.APPRAISAL_FORM_TEMPLATE,appraisalFormTemplate);
        return AxHrmsHrAppraisalFormTemplatesWebConstants.ADD_APPRAISAL_FORM_TEMPLATES_JSP_PATH;
    }
}
