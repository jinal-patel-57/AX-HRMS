package com.ax.hrms.pip.program.web.actions;


import com.ax.hrms.model.EmployeeDetails;
import com.ax.hrms.model.PipProgram;
import com.ax.hrms.pip.program.web.constants.AxHrmsPipProgramWebPortletKeys;
import com.ax.hrms.service.EmployeeDetailsLocalService;
import com.ax.hrms.service.PipProgramLocalService;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import java.util.List;


/**

 Author: Nivid Koradiya
 */
@Component(
        property = {
                "javax.portlet.name=" + AxHrmsPipProgramWebPortletKeys.AX_HRMS_PIP_PROGRAM_WEB,
                "mvc.command.name=/terminatePipEmployee"
        },
        service = MVCActionCommand.class
)
public class TerminateEmployeeMVCActionCommand extends BaseMVCActionCommand {
    private static final Log log = LogFactoryUtil.getLog(TerminateEmployeeMVCActionCommand.class);

    @Reference
    PipProgramLocalService pipProgramLocalService;

    @Reference
    EmployeeDetailsLocalService employeeDetailsLocalService;

    @Override
    protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
        ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
        long pipProgramId = ParamUtil.getLong(actionRequest,"pipProgramId");
        PipProgram pipProgram = pipProgramLocalService.getPipProgram(pipProgramId);
        EmployeeDetails employeeDetails = employeeDetailsLocalService.getEmployeeDetails(pipProgram.getEmployeeId());
        long userId = employeeDetails.getLrUserId();
        // Fetch all roles associated with the user
        List<Role> roles = RoleLocalServiceUtil.getUserRoles(userId);
        // Remove each role from the user
        for (Role role : roles) {
            RoleLocalServiceUtil.deleteUserRole(userId, role.getRoleId());
        }

        // Delete the user
        UserLocalServiceUtil.deleteUser(userId);

        // mark as terminated
        employeeDetails.setIsTerminated(true);
        employeeDetailsLocalService.updateEmployeeDetails(employeeDetails);

        // change the status of PIP
        pipProgram.setModifiedBy(themeDisplay.getUserId());
        pipProgram.setStatus("Terminated");

        pipProgramLocalService.updatePipProgram(pipProgram);
    }
}
