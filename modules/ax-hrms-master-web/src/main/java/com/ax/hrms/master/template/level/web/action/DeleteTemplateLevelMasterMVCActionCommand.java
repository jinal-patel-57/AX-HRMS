package com.ax.hrms.master.template.level.web.action;


import com.ax.hrms.master.service.TemplateLevelMasterLocalService;
import com.ax.hrms.master.web.constants.AxHrmsMasterWebPortletKeys;
import com.ax.hrms.master.web.constants.AxHrmsTemplateLevelMasterConstants;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

/**

 Author: Nivid Koradiya
 */
@Component(
        property = {
                "javax.portlet.name=" + AxHrmsMasterWebPortletKeys.AX_HRMS_TEMPLATE_LEVEL_MASTER_WEB_PORTLET,
                "mvc.command.name=/deleteTemplateLevelMaster"
        },
        service = MVCActionCommand.class
)
public class DeleteTemplateLevelMasterMVCActionCommand extends BaseMVCActionCommand {

    @Reference
    TemplateLevelMasterLocalService templateLevelMasterLocalService;

    @Override
    protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
        long templateLevelMasterId = ParamUtil.getLong(actionRequest, AxHrmsTemplateLevelMasterConstants.TEMPLATE_LEVEL_MASTER_ID);
        templateLevelMasterLocalService.deleteTemplateLevelMaster(templateLevelMasterId);
        String iteratorURL = ParamUtil.getString(actionRequest, AxHrmsTemplateLevelMasterConstants.ITERATOR_URL);
        SessionMessages.add(actionRequest, AxHrmsTemplateLevelMasterConstants.SUCCESS_DELETE);
        actionResponse.sendRedirect(iteratorURL);
    }
}
