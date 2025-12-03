package com.ax.hrms.hr.appraisal.form.templates.action;

import com.ax.hrms.hr.appraisal.form.templates.constants.AxHrmsHrAppraisalFormTemplatesPortletKey;
import com.ax.hrms.hr.appraisal.form.templates.constants.AxHrmsHrAppraisalFormTemplatesWebConstants;
import com.ax.hrms.hr.appraisal.form.templates.dto.AppraisalFormTemplateDto;
import com.ax.hrms.hr.appraisal.form.templates.util.AppraisalFormTemplateDetailUtil;
import com.ax.hrms.master.service.TemplateLevelMasterLocalService;
import com.ax.hrms.model.AppraisalFormTemplates;
import com.ax.hrms.service.AppraisalFormTemplatesLocalService;
import com.liferay.document.library.kernel.service.DLFileEntryLocalService;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import java.util.List;

/**
 * @author krish.moradiya
 * @implNote : Using this class, Show all data in List at View file
 */
@Component(
        immediate = true,
        property = {
                "javax.portlet.name=" + AxHrmsHrAppraisalFormTemplatesPortletKey.AXHRMS_HR_APPRAISAL_FORM_TEMPLATES_PORTLET_KEY,
                "mvc.command.name="+ AxHrmsHrAppraisalFormTemplatesWebConstants.DEFAULT_PATH
        },
        service = MVCRenderCommand.class
)
public class ListAppraisalFormTemplatesMVCRenderCommand implements MVCRenderCommand{

    @Reference
    AppraisalFormTemplatesLocalService appraisalFormTemplatesLocalService;
    @Reference
    DLFileEntryLocalService dlFileEntryLocalService;
    @Reference
    TemplateLevelMasterLocalService templateLevelMasterLocalService;

    private static final Log log = LogFactoryUtil.getLog(ListAppraisalFormTemplatesMVCRenderCommand.class);

    @Override
    public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {

        List<AppraisalFormTemplates> appraisalFormTemplatesList = null;

        int curValue = ParamUtil.getInteger(renderRequest, SearchContainer.DEFAULT_CUR_PARAM,1);
        int deltaValue = ParamUtil.getInteger(renderRequest, SearchContainer.DEFAULT_DELTA_PARAM,3);

        int totalAppraisalFormTemplates = appraisalFormTemplatesLocalService.getAppraisalFormTemplatesesCount();
        int totalPageContainer = (totalAppraisalFormTemplates  + deltaValue - 1) / deltaValue;

        if (curValue > totalPageContainer) {
            curValue = totalPageContainer;
        }

        int start = (curValue - 1) * deltaValue;
        int end = start + deltaValue;

        if(end > totalAppraisalFormTemplates)
            end = totalAppraisalFormTemplates;
        if(totalAppraisalFormTemplates == 0)
            start = 0;

        appraisalFormTemplatesList = appraisalFormTemplatesLocalService.getAppraisalFormTemplateses(-1, -1);

        AppraisalFormTemplateDetailUtil.setLocalServices(dlFileEntryLocalService,templateLevelMasterLocalService);

        List<AppraisalFormTemplateDto> appraisalFormTemplateDtoList = AppraisalFormTemplateDetailUtil.getAppraisalFormTemplateList(appraisalFormTemplatesList);

        renderRequest.setAttribute(AxHrmsHrAppraisalFormTemplatesWebConstants.TOTAL_APPRAISAL_FORM_TEMPLATE, totalAppraisalFormTemplates);
        renderRequest.setAttribute(SearchContainer.DEFAULT_DELTA_PARAM, deltaValue);
        renderRequest.setAttribute(AxHrmsHrAppraisalFormTemplatesWebConstants.APPRAISAL_FORM_TEMPLATE_LIST, appraisalFormTemplateDtoList.subList(start,end));
        renderRequest.setAttribute(AxHrmsHrAppraisalFormTemplatesWebConstants.ITERATOR_URL_CASE, renderResponse.createRenderURL());

        return AxHrmsHrAppraisalFormTemplatesWebConstants.LIST_APPRAISAL_FORM_TEMPLATES_JSP_PATH;
    }
}
