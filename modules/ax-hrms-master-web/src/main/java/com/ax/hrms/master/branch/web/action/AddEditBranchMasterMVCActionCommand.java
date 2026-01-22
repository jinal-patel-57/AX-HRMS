package com.ax.hrms.master.branch.web.action;

import com.ax.hrms.master.model.BranchMaster;
import com.ax.hrms.master.service.BranchMasterLocalService;
import com.ax.hrms.master.web.constants.AxBranchWebPortletKeys;
import com.ax.hrms.master.web.constants.AxEducationLevelMasterWebPortletKeys;
import com.ax.hrms.model.Address;
import com.ax.hrms.service.AddressLocalService;
import com.liferay.counter.kernel.service.CounterLocalService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import java.io.IOException;
import java.util.Date;

@Component(
        immediate = true,
        property = {
                "javax.portlet.name=" + AxBranchWebPortletKeys.AXHRMS_BRANCHMASTER_WEB_PORTLET_KEYS,
                "mvc.command.name=/saveBranchDetails"
        },
        service = MVCActionCommand.class
)
public class AddEditBranchMasterMVCActionCommand extends BaseMVCActionCommand {

    @Reference
    private BranchMasterLocalService branchMasterLocalService;

    @Reference
    private AddressLocalService addressLocalService;

    @Reference
    private CounterLocalService counterLocalService;

    @Override
    public void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) {
         ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
        super.hideDefaultErrorMessage(actionRequest);
        super.hideDefaultSuccessMessage(actionRequest);

        long branchMasterId = ParamUtil.getLong(actionRequest, "branchMasterId");

        String branchName = ParamUtil.getString(actionRequest, "branchName");
        String addressLine1 = ParamUtil.getString(actionRequest, "address");
        String city = ParamUtil.getString(actionRequest, "city");
        String state = ParamUtil.getString(actionRequest, "state");
        long country = ParamUtil.getLong(actionRequest, "country");
        String pincode = ParamUtil.getString(actionRequest, "pincode");

        try {
            ServiceContext serviceContext =
                    ServiceContextFactory.getInstance(BranchMaster.class.getName(), actionRequest);

            BranchMaster branchMaster;
            Address address;

            /* =======================
               ADD
            ======================= */
            if (branchMasterId == 0) {

                long addressId = counterLocalService.increment(Address.class.getName());
                address = addressLocalService.createAddress(addressId);

                address.setLine1(addressLine1);
                address.setCity(city);
                address.setState(state);
                address.setCountry(country);
                address.setPincode(pincode);

                addressLocalService.addAddress(address);

                long newBranchId = counterLocalService.increment(BranchMaster.class.getName());
                branchMaster = branchMasterLocalService.createBranchMaster(newBranchId);

                branchMaster.setCompanyId(serviceContext.getCompanyId());
                branchMaster.setGroupId(serviceContext.getScopeGroupId());
                branchMaster.setCreatedBy(serviceContext.getUserId());
                branchMaster.setCreateDate(new Date());

                branchMaster.setBranchName(branchName);
                branchMaster.setAddressId(addressId);

                branchMasterLocalService.addBranchMaster(branchMaster);
                SessionMessages.add(actionRequest,"branch-added" );

            }
            /* =======================
               UPDATE
            ======================= */
            else {

                branchMaster = branchMasterLocalService.getBranchMaster(branchMasterId);
                address = addressLocalService.getAddress(branchMaster.getAddressId());

                address.setLine1(addressLine1);
                address.setCity(city);
                address.setState(state);
                address.setCountry(country);
                address.setPincode(pincode);

                addressLocalService.updateAddress(address);

                branchMaster.setBranchName(branchName);
                branchMaster.setModifiedBy(serviceContext.getUserId());
                branchMaster.setModifiedDate(new Date());

                branchMasterLocalService.updateBranchMaster(branchMaster);
                SessionMessages.add(actionRequest, "branch-updated");

            }

            actionResponse.sendRedirect(PortalUtil.getLayoutFullURL(themeDisplay));
        } catch (PortalException | IOException e) {
            throw new RuntimeException(e);
        }

    }
}
