package com.ax.hrms.master.branch.web.action;

import com.ax.hrms.master.branch.web.dto.BranchDto;
import com.ax.hrms.master.model.BranchMaster;
import com.ax.hrms.master.service.BranchMasterLocalService;
import com.ax.hrms.master.web.constants.AxBranchWebPortletKeys;
import com.ax.hrms.master.web.constants.AxEducationLevelMasterWebPortletKeys;
import com.ax.hrms.model.Address;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.ax.hrms.service.AddressLocalService;
import com.liferay.portal.kernel.service.CountryLocalService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import java.util.ArrayList;
import java.util.List;

@Component(
        immediate = true,
        property = {
                "javax.portlet.name="+ AxBranchWebPortletKeys.AXHRMS_BRANCHMASTER_WEB_PORTLET_KEYS,
                "mvc.command.name=/"
        },
        service = MVCRenderCommand.class
)
public class ListBranchMasterMVCActionRenderCommand implements MVCRenderCommand  {
    @Reference
    BranchMasterLocalService branchMasterLocalService;

    @Reference
    AddressLocalService addressLocalService;

    @Reference
    CountryLocalService countryLocalService;
    @Override
    public String render(RenderRequest renderRequest, RenderResponse renderResponse)
            throws PortletException {

        List<BranchMaster> branchMasterList =
                branchMasterLocalService.getBranchMasters(-1, -1);

        List<BranchDto> branchDtoList = new ArrayList<>();

        for (BranchMaster branch : branchMasterList) {
            BranchDto branchDto = new BranchDto();
            try {
                Address address = addressLocalService.getAddress(branch.getAddressId());

                branchDto.setAddress(address.getLine1());
                branchDto.setCity(address.getCity());
                branchDto.setState(address.getState());
                branchDto.setCountry(
                        countryLocalService.getCountry(address.getCountry()).getName()
                );
                branchDto.setPincode(address.getPincode());

            } catch (PortalException e) {
                throw new RuntimeException(e);
            }

            branchDto.setBranchName(branch.getBranchName());
            branchDto.setBranchMasterId(branch.getBranchMasterId());
            branchDtoList.add(branchDto);
        }

        renderRequest.setAttribute("branchList", branchDtoList);
        renderRequest.setAttribute("branchCount", branchDtoList.size());

        return "/jsp/branch-master/listBranch.jsp";
    }


}
