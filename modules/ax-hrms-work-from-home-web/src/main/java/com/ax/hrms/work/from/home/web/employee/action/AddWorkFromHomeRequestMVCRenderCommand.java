package com.ax.hrms.work.from.home.web.employee.action;

import com.ax.hrms.master.service.LeavePolicyMasterLocalService;
import com.ax.hrms.master.service.LeaveTypeMasterLocalService;
import com.ax.hrms.model.EmployeeDetails;
import com.ax.hrms.model.WorkFromHomeRequest;
import com.ax.hrms.service.EmployeeDetailsLocalService;
import com.ax.hrms.service.LeaveBalanceLocalService;
import com.ax.hrms.service.LeaveTypeViewPermitLocalService;
import com.ax.hrms.work.from.home.web.constants.AxHrmsWorkFromHomePortletKeys;
import com.ax.hrms.work.from.home.web.constants.WFHActionConstants;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.service.RoleLocalService;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import java.util.ArrayList;
import java.util.List;

@Component(
        property = {
                "javax.portlet.name=" + AxHrmsWorkFromHomePortletKeys.AXHRMSWORKFROMHOME,
                "mvc.command.name=/addWFHForm"
        },
        service = MVCRenderCommand.class
)
public class AddWorkFromHomeRequestMVCRenderCommand implements MVCRenderCommand{
    private static final Log log = LogFactoryUtil.getLog(AddWorkFromHomeRequestMVCRenderCommand.class);

    @Reference
    private LeaveTypeMasterLocalService leaveTypeMasterLocalService;

    @Reference
    private LeavePolicyMasterLocalService leavePolicyMasterLocalService;

    @Reference
    private EmployeeDetailsLocalService employeeDetailsLocalService;

    @Reference
    private LeaveTypeViewPermitLocalService leaveTypeViewPermitLocalService;
    @Reference
    private LeaveBalanceLocalService leaveBalanceLocalService;
    @Reference
    private RoleLocalService roleLocalService;

    @Reference
    private UserLocalService userLocalService;
    @Override
    public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {

        ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
        List<EmployeeDetails> listOfEmployeeDetails = employeeDetailsLocalService.getEmployeeDetailses(-1,-1);
        List<EmployeeDetails> listOfFilteredEmployeeDetails = new ArrayList<>();

        for(EmployeeDetails employeeDetails : listOfEmployeeDetails) {

            try {
                long employeeRoleId = RoleLocalServiceUtil.getRole(themeDisplay.getCompanyId(), WFHActionConstants.EMPLOYEE).getRoleId();
                long[] userRoles = userLocalService.getUserById(employeeDetails.getLrUserId()).getRoleIds();
                for(long userRole : userRoles) {
                    if(userRole == employeeRoleId)
                        listOfFilteredEmployeeDetails.add(employeeDetails);
                }
            } catch (PortalException e) {
                log.error("ViewLeaveRequestFormMVCRenderCommand >>> render ::: PortalException: "+e.getMessage());
            }catch (NullPointerException e) {
                log.error("ViewLeaveRequestFormMVCRenderCommand >>> render ::: NullPointerException: "+e.getMessage());
            }catch(Exception e) {
                log.error("ViewLeaveRequestFormMVCRenderCommand >>> render ::: Exception: "+e.getMessage());
            }

        }
        renderRequest.setAttribute(WFHActionConstants.EMPLOYEE_DETAILS_LIST,listOfFilteredEmployeeDetails);

        return "/jsp/ax-hrms-work-from-home-employee/add_edit_work_from_home.jsp";
    }
}
