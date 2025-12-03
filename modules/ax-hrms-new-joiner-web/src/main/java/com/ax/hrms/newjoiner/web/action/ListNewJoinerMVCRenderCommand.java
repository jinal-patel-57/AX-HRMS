package com.ax.hrms.newjoiner.web.action;

import com.ax.hrms.master.exception.NoSuchWishTypeMasterException;
import com.ax.hrms.master.model.WishTypeMaster;
import com.ax.hrms.master.service.DepartmentMasterLocalService;
import com.ax.hrms.master.service.DesignationMasterLocalService;
import com.ax.hrms.master.service.WishTypeMasterLocalService;

import com.ax.hrms.newjoiner.web.constants.AxHrmsNewJoinerWebPortletConstants;
import com.ax.hrms.newjoiner.web.constants.AxHrmsNewJoinerWebPortletKeys;
import com.ax.hrms.newjoiner.web.dto.NewJoinerDto;
import com.ax.hrms.newjoiner.web.util.NewJoinerRetrieverUtil;
import com.ax.hrms.service.EmployeeDepartmentLocalService;
import com.ax.hrms.service.EmployeeDesignationLocalService;
import com.ax.hrms.service.EmployeeDetailsLocalService;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import java.util.List;

/**
 * @author krish.moradiya
 * @implNote - This is render portlet in which show list of new joineeList of Last 15 Days
 */
@Component(
        immediate = true,
        property = {
                "javax.portlet.name=" + AxHrmsNewJoinerWebPortletKeys.AXHRMSNEWJOINERWEB,
                "mvc.command.name="+ AxHrmsNewJoinerWebPortletConstants.DEFAULT_PATH
        },
        service = MVCRenderCommand.class
)
public class ListNewJoinerMVCRenderCommand implements MVCRenderCommand{

    private static final Log log = LogFactoryUtil.getLog(ListNewJoinerMVCRenderCommand.class);

    @Reference
    EmployeeDetailsLocalService employeeDetailsLocalService;
    @Reference
    DepartmentMasterLocalService departmentMasterLocalService;
    @Reference
    DesignationMasterLocalService designationMasterLocalService;
    @Reference
    EmployeeDepartmentLocalService employeeDepartmentLocalService;
    @Reference
    EmployeeDesignationLocalService employeeDesignationLocalService;
    @Reference
    private WishTypeMasterLocalService wishTypeMasterLocalService;

    @Override
    public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {

        List<WishTypeMaster> wishTypeMasterList = wishTypeMasterLocalService.getWishTypeMasters(-1,-1);

        long newJoinerWishMasterId = 0L;
        try{
            newJoinerWishMasterId = wishTypeMasterLocalService.findByWishType(AxHrmsNewJoinerWebPortletConstants.NEW_JOINEE).getWishTypeMasterId();
        }catch(NoSuchWishTypeMasterException e){
            log.error("ListNewJoinerMVCRenderCommand >>> Render ::: NoSuchWishTypeMasterException is: "+e.getMessage());
        }
        List<NewJoinerDto> newJoinerList = NewJoinerRetrieverUtil.getNewJoinerList(employeeDetailsLocalService.getEmployeeDetailses(-1,-1),departmentMasterLocalService,designationMasterLocalService,employeeDepartmentLocalService,employeeDesignationLocalService);
        renderRequest.setAttribute(AxHrmsNewJoinerWebPortletConstants.NEW_JOINER_LIST,newJoinerList);
        renderRequest.setAttribute(AxHrmsNewJoinerWebPortletConstants.WISH_TYPE_MASTER_LIST,wishTypeMasterList);
        renderRequest.setAttribute(AxHrmsNewJoinerWebPortletConstants.WISH_TYPE_MASTER_ID,newJoinerWishMasterId);
        renderRequest.setAttribute(AxHrmsNewJoinerWebPortletConstants.NEW_JOINER_WISH_TYPE_MASTER_ID,newJoinerWishMasterId);
        return AxHrmsNewJoinerWebPortletConstants.LIST_OF_NEW_JOINER_JSP_PATH;
    }
}
