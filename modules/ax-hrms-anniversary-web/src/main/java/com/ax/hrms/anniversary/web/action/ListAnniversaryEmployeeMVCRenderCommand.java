package com.ax.hrms.anniversary.web.action;

import com.ax.hrms.anniversary.web.constants.AxHrmsAnniversaryWebPortletKeys;
import com.ax.hrms.anniversary.web.dto.EmployeeDetailsDto;
import com.ax.hrms.anniversary.web.util.AnniversaryUtil;
import com.ax.hrms.common.api.api.AxHrmsCommonApi;
import com.ax.hrms.anniversary.web.constants.AxHrmsAnniversaryWebPortletConstants;
import com.ax.hrms.master.exception.NoSuchWishTypeMasterException;
import com.ax.hrms.master.model.WishTypeMaster;
import com.ax.hrms.master.service.*;
import com.ax.hrms.model.EmployeeDetails;
import com.ax.hrms.service.*;
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
 * @implNote - This is render portlet in which show list of employee whoose anniversary today
 */
@Component(
        immediate = true,
        property = {
                "javax.portlet.name=" + AxHrmsAnniversaryWebPortletKeys.AXHRMSANNIVERSARYWEB,
                "mvc.command.name="+ AxHrmsAnniversaryWebPortletConstants.DEFAULT_PATH
        },
        service = MVCRenderCommand.class
)
public class ListAnniversaryEmployeeMVCRenderCommand implements MVCRenderCommand {

    private static final Log log = LogFactoryUtil.getLog(ListAnniversaryEmployeeMVCRenderCommand.class);

    @Reference
    private EmployeeDetailsLocalService employeeDetailsLocalService;
    @Reference
    private WishTypeMasterLocalService wishTypeMasterLocalService;
    @Reference
    private DepartmentMasterLocalService departmentMasterLocalService;
    @Reference
    private DesignationMasterLocalService designationMasterLocalService;
    @Reference
    private EmployeeDesignationLocalService employeeDesignationLocalService;
    @Reference
    private EmployeeDepartmentLocalService employeeDepartmentLocalService;
    @Reference
    private AxHrmsCommonApi axHrmsCommonApi;
    @Reference
    private LeaveBalanceLocalService leaveBalanceLocalService;
    @Reference
    private LeavePolicyMasterLocalService leavePolicyMasterLocalService;
    @Reference
    private LeaveTypeMasterLocalService leaveTypeMasterLocalService;

    @Override
    public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
        AnniversaryUtil anniversaryEmployeeRetrieverUtil = new AnniversaryUtil(employeeDetailsLocalService,axHrmsCommonApi,leaveBalanceLocalService,leavePolicyMasterLocalService,leaveTypeMasterLocalService,designationMasterLocalService,departmentMasterLocalService);
        List<EmployeeDetails> anniversaryEmployeeDetailList = anniversaryEmployeeRetrieverUtil.getAnniversaryEmployee(employeeDetailsLocalService.getEmployeeDetailses(-1,-1));
        List<EmployeeDetailsDto> employeeDetailsDtoList = anniversaryEmployeeRetrieverUtil.getEmployeeDetailsDtoList(anniversaryEmployeeDetailList,departmentMasterLocalService,designationMasterLocalService,employeeDepartmentLocalService,employeeDesignationLocalService);
        List<WishTypeMaster> wishTypeMasterList = wishTypeMasterLocalService.getWishTypeMasters(-1,-1);

        long anniversaryWishTypeMasterId = 0L;
        try{
            anniversaryWishTypeMasterId = wishTypeMasterLocalService.findByWishType(AxHrmsAnniversaryWebPortletConstants.ANNIVERSARY).getWishTypeMasterId();
        }catch(NoSuchWishTypeMasterException e){
            log.error("ListAnniversaryEmployeeMVCRenderCommand >>> Render ::: NoSuchWishTypeMasterException is: "+e.getMessage());
        }

        renderRequest.setAttribute(AxHrmsAnniversaryWebPortletConstants.ANNIVERSARY_EMPLOYEE_LIST,employeeDetailsDtoList);
        renderRequest.setAttribute(AxHrmsAnniversaryWebPortletConstants.WISH_TYPE_MASTER_LIST,wishTypeMasterList);
        renderRequest.setAttribute(AxHrmsAnniversaryWebPortletConstants.WISH_TYPE_MASTER_ID,anniversaryWishTypeMasterId);
        renderRequest.setAttribute(AxHrmsAnniversaryWebPortletConstants.ANNIVERSARY_WISH_TYPE_MASTER_ID,anniversaryWishTypeMasterId);
        return AxHrmsAnniversaryWebPortletConstants.EMPLOYEE_ANNIVERSARY_LIST_JSP_PATH;
    }
}
