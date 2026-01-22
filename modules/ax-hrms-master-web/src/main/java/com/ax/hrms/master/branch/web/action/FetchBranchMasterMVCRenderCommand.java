package com.ax.hrms.master.branch.web.action;

import com.ax.hrms.master.branch.web.dto.BranchDto;
import com.ax.hrms.master.model.BranchMaster;
import com.ax.hrms.master.service.BranchMasterLocalService;
import com.ax.hrms.master.web.constants.AxBranchWebPortletKeys;
import com.ax.hrms.model.Address;
import com.ax.hrms.service.AddressLocalService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.Country;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.service.CountryLocalService;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import java.util.List;

@Component(
        immediate = true,
        property = {
                "javax.portlet.name="+ AxBranchWebPortletKeys.AXHRMS_BRANCHMASTER_WEB_PORTLET_KEYS,
                "mvc.command.name=/fetchBranchDetails"
        },
        service = MVCRenderCommand.class
)
public class FetchBranchMasterMVCRenderCommand implements MVCRenderCommand{
    @Reference
    BranchMasterLocalService branchMasterLocalService;

    @Reference
    AddressLocalService addressLocalService;

    @Reference
    CountryLocalService countryLocalService;
    @Override
    public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
        long branchMasterId = ParamUtil.getLong(renderRequest, "branchMasterId");
        if(Validator.isNotNull(branchMasterId)) {

            try {
                BranchMaster branch = branchMasterLocalService.getBranchMaster(branchMasterId);
                BranchDto branchDto = new BranchDto();
                try {
                    Address address = addressLocalService.getAddress(branch.getAddressId());

                    branchDto.setAddress(address.getLine1());
                    branchDto.setCity(address.getCity());
                    branchDto.setCountryId(address.getCountry());
                    branchDto.setState(address.getState());
                    branchDto.setPincode(address.getPincode());
                } catch (PortalException e) {
                    throw new RuntimeException(e);
                }
                branchDto.setBranchName(branch.getBranchName());
                branchDto.setBranchMasterId(branch.getBranchMasterId());
                renderRequest.setAttribute("branchMaster",branchDto);
            } catch (PortalException e) {
                throw new RuntimeException(e);
            }

        }

            List<Country> countryList = countryLocalService.getCountries(-1,-1);
            renderRequest.setAttribute("countryList",countryList);

            return "/jsp/branch-master/addEditBranch.jsp";


    }
}
