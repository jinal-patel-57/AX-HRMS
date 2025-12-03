package com.ax.hrms.master.template.level.web.action;


import com.ax.hrms.master.model.TemplateLevelMaster;
import com.ax.hrms.master.service.TemplateLevelMasterLocalService;
import com.ax.hrms.master.web.constants.AxHrmsMasterWebPortletKeys;
import com.ax.hrms.master.web.constants.AxHrmsTemplateLevelMasterConstants;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

/**
 * Author: Nivid Koradiya
 */
@Component(
        property = {
                "javax.portlet.name=" + AxHrmsMasterWebPortletKeys.AX_HRMS_TEMPLATE_LEVEL_MASTER_WEB_PORTLET,
                "mvc.command.name=/viewTemplateLevelMaster"
        },
        service = MVCRenderCommand.class
)
public class ViewTemplateLevelMasterDetailsMVCRenderCommand implements MVCRenderCommand {

    @Reference
    TemplateLevelMasterLocalService templateLevelMasterLocalService;

    @Override
    public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {

        long templateLevelMasterId = ParamUtil.getLong(renderRequest, AxHrmsTemplateLevelMasterConstants.TEMPLATE_LEVEL_MASTER_ID);
        TemplateLevelMaster templateLevelMaster = null;
        try {
            templateLevelMaster = templateLevelMasterLocalService.getTemplateLevelMaster(templateLevelMasterId);
        } catch (PortalException e) {
            Log log = LogFactoryUtil.getLog(FetchTemplateLevelMasterMVCRenderCommand.class);
            log.error(e);
        }
        renderRequest.setAttribute(AxHrmsTemplateLevelMasterConstants.TEMPLATE_LEVEL_MASTER, templateLevelMaster);
        return AxHrmsTemplateLevelMasterConstants.TEMPLATE_LEVEL_MASTER_VIEW_JSP;
    }
}
