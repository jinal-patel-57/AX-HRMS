package com.ax.hrms.hr.appraisal.form.templates.action;

import com.ax.hrms.hr.appraisal.form.templates.constants.AxHrmsHrAppraisalFormTemplatesPortletKey;
import com.ax.hrms.hr.appraisal.form.templates.constants.AxHrmsHrAppraisalFormTemplatesWebConstants;
import com.ax.hrms.hr.appraisal.form.templates.dto.AppraisalFormTemplateDto;
import com.ax.hrms.hr.appraisal.form.templates.util.AppraisalFormTemplateDetailUtil;
import com.ax.hrms.master.service.TemplateLevelMasterLocalService;
import com.ax.hrms.model.AppraisalFormTemplates;
import com.ax.hrms.service.AppraisalFormTemplatesLocalService;
import com.liferay.document.library.kernel.service.DLAppService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

/**
 * @author krish.moradiya
 * @implNote : Using this class, View Appraisal Form Detail in Frontend side
 */
@Component(
        immediate = true,
        property = {
                "javax.portlet.name="+ AxHrmsHrAppraisalFormTemplatesPortletKey.AXHRMS_HR_APPRAISAL_FORM_TEMPLATES_PORTLET_KEY,
                "mvc.command.name=/viewAppraisalFormTemplate"
        }
)
public class ViewAppraisalFormTemplateDetail implements MVCRenderCommand {
    @Reference
    AppraisalFormTemplatesLocalService appraisalFormTemplatesLocalService;
    @Reference
    DLAppService dlAppService;
    @Reference
    TemplateLevelMasterLocalService templateLevelMasterLocalService;
    private static final Log log = LogFactoryUtil.getLog(ViewAppraisalFormTemplateDetail.class);
    @Override
    public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
        long appraisalFormTemplateId = ParamUtil.getLong(renderRequest,"appraisalFormTemplateId", GetterUtil.DEFAULT_LONG);
        if(appraisalFormTemplateId > 0){
            AppraisalFormTemplates appraisalFormTemplates = appraisalFormTemplatesLocalService.fetchAppraisalFormTemplates(appraisalFormTemplateId);
            try {
                AppraisalFormTemplateDto appraisalFormTemplateDto = AppraisalFormTemplateDetailUtil.getAppraisalFormTemplateDetails(appraisalFormTemplates,
                        dlAppService.getFileEntry(appraisalFormTemplates.getTemplateDocumentId()),
                        templateLevelMasterLocalService.fetchTemplateLevelMaster(appraisalFormTemplates.getTemplateLevelId()));
                renderRequest.setAttribute(AxHrmsHrAppraisalFormTemplatesWebConstants.APPRAISAL_FORM_TEMPLATE,appraisalFormTemplateDto);
            } catch (PortalException e) {
                log.error("ViewAppraisalFormTemplateDetail >>> render ::: Exception is: "+e.getMessage());
            }
        }
        return AxHrmsHrAppraisalFormTemplatesWebConstants.VIEW_APPRAISAL_FORM_TEMPLATE_DETAIL_JSP_PATH;
    }
}
