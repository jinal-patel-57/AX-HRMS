package com.ax.hrms.master.branch.web.action;

import com.ax.hrms.master.branch.web.dto.BranchDto;
import com.ax.hrms.master.model.BranchMaster;
import com.ax.hrms.master.service.BranchMasterLocalService;
import com.ax.hrms.master.web.constants.AxBranchWebPortletKeys;
import com.ax.hrms.model.Address;
import com.ax.hrms.service.AddressLocalService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.service.CountryLocalService;
import com.liferay.portal.kernel.util.ParamUtil;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
@Component(
        immediate = true,
        property = {
                "javax.portlet.name="+ AxBranchWebPortletKeys.AXHRMS_BRANCHMASTER_WEB_PORTLET_KEYS,
                "mvc.command.name=/viewBranchDetails"
        },
        service = MVCRenderCommand.class
)
public class ViewBranchMasterMVCRenderCommand implements MVCRenderCommand {
    @Reference
    private BranchMasterLocalService branchMasterLocalService;

    @Reference
    private AddressLocalService addressLocalService;

    @Reference
    private CountryLocalService countryLocalService;

    @Override
    public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {

        long branchMasterId = ParamUtil.getLong(renderRequest, "branchMasterId");

        try {
            BranchMaster branch = branchMasterLocalService.getBranchMaster(branchMasterId);
            BranchDto branchDto = new BranchDto();
            try {
                Address address = addressLocalService.getAddress(branch.getAddressId());

                branchDto.setAddress(address.getLine1());
                branchDto.setCity(address.getCity());
                branchDto.setCountry(countryLocalService.getCountry(address.getCountry()).getName());
                branchDto.setState(address.getState());
                branchDto.setPincode(address.getPincode());
                branchDto.setCountryId(address.getCountry());
            } catch (PortalException e) {
                throw new RuntimeException(e);
            }
            branchDto.setBranchName(branch.getBranchName());
            branchDto.setBranchMasterId(branch.getBranchMasterId());
            renderRequest.setAttribute("branch",branchDto);
        } catch (PortalException e) {
            throw new RuntimeException(e);
        }

        return "/jsp/branch-master/viewBranch.jsp";
    }
}
