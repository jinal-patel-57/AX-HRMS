package com.ax.hrms.master.branch.web.action;

import com.ax.hrms.master.model.BranchMaster;
import com.ax.hrms.master.service.BranchMasterLocalService;
import com.ax.hrms.master.web.constants.AxBranchWebPortletKeys;
import com.ax.hrms.service.AddressLocalService;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

@Component(
        immediate = true,
        property = {
                "javax.portlet.name=" + AxBranchWebPortletKeys.AXHRMS_BRANCHMASTER_WEB_PORTLET_KEYS,
                "mvc.command.name=/deleteBranch"
        },
        service = MVCActionCommand.class
)
public class DeleteBranchMVCActionCommand extends BaseMVCActionCommand {
    @Reference
    private BranchMasterLocalService branchMasterLocalService;

    @Reference
    private AddressLocalService addressLocalService;
    @Override
    protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
        ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
        super.hideDefaultErrorMessage(actionRequest);
        super.hideDefaultSuccessMessage(actionRequest);
        long branchMasterId = ParamUtil.getLong(actionRequest, "branchMasterId");

        BranchMaster branchMaster = branchMasterLocalService.getBranchMaster(branchMasterId);
        addressLocalService.deleteAddress(branchMaster.getAddressId());
        branchMasterLocalService.deleteBranchMaster(branchMasterId);
        SessionMessages.add(actionRequest,"branch-deleted");

        actionResponse.sendRedirect(PortalUtil.getLayoutFullURL(themeDisplay));


    }
}
