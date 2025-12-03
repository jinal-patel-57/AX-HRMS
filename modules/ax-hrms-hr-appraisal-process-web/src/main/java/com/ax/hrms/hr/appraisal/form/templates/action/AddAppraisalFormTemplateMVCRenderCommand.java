package com.ax.hrms.hr.appraisal.form.templates.action;

import com.ax.hrms.hr.appraisal.form.templates.constants.AxHrmsHrAppraisalFormTemplatesPortletKey;
import com.ax.hrms.hr.appraisal.form.templates.constants.AxHrmsHrAppraisalFormTemplatesWebConstants;
import com.ax.hrms.master.model.TemplateLevelMaster;
import com.ax.hrms.master.service.TemplateLevelMasterLocalService;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import java.util.List;

/**
 * @author krish.moradiya
 * @implNote : Appraisal Form Template form Render with year and level id also upload file
 */
@Component(
        immediate = true,
        property = {
                "javax.portlet.name="+ AxHrmsHrAppraisalFormTemplatesPortletKey.AXHRMS_HR_APPRAISAL_FORM_TEMPLATES_PORTLET_KEY,
                "mvc.command.name="+ AxHrmsHrAppraisalFormTemplatesWebConstants.ADD_APPRAISAL_FORM_TEMPLATES_JSP_PATH
        }
)
public class AddAppraisalFormTemplateMVCRenderCommand implements MVCRenderCommand {
    @Reference
    private TemplateLevelMasterLocalService templateLevelMasterLocalService;
    @Override
    public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
        List<TemplateLevelMaster> templateLevelMasterList = templateLevelMasterLocalService.getTemplateLevelMasters(-1,-1);
        renderRequest.setAttribute(AxHrmsHrAppraisalFormTemplatesWebConstants.TEMPLATE_LEVEL_MASTER_LIST,templateLevelMasterList);
        return AxHrmsHrAppraisalFormTemplatesWebConstants.ADD_APPRAISAL_FORM_TEMPLATES_JSP_PATH;
    }
}
