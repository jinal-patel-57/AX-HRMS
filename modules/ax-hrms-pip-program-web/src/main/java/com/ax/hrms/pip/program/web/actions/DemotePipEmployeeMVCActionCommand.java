package com.ax.hrms.pip.program.web.actions;


import com.ax.hrms.master.model.DesignationMaster;
import com.ax.hrms.master.service.DesignationMasterLocalService;
import com.ax.hrms.model.EmployeeDesignation;
import com.ax.hrms.model.EmployeeDetails;
import com.ax.hrms.model.PipProgram;
import com.ax.hrms.pip.program.web.constants.AxHrmsPipProgramWebPortletKeys;
import com.ax.hrms.service.EmployeeDesignationLocalService;
import com.ax.hrms.service.EmployeeDetailsLocalService;
import com.ax.hrms.service.PipProgramLocalService;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.RoleLocalService;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import java.util.Date;


/**

 Author: Nivid Koradiya
 */
@Component(
        property = {
                "javax.portlet.name=" + AxHrmsPipProgramWebPortletKeys.AX_HRMS_PIP_PROGRAM_WEB,
                "mvc.command.name=/demotePipEmployee"
        },
        service = MVCActionCommand.class
)
public class DemotePipEmployeeMVCActionCommand extends BaseMVCActionCommand {
    private static final Log log = LogFactoryUtil.getLog(DemotePipEmployeeMVCActionCommand.class);

    @Reference
    PipProgramLocalService pipProgramLocalService;

    @Reference
    EmployeeDetailsLocalService employeeDetailsLocalService;

    @Reference
    EmployeeDesignationLocalService employeeDesignationLocalService;

    @Reference
    DesignationMasterLocalService designationMasterLocalService;

    @Reference
    RoleLocalService roleLocalService;



    @Override
    protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
        log.info("ACTION >>>>>>>>>>>::::::::;");
        long pipProgramId = ParamUtil.getLong(actionRequest,"pipProgramId");
        PipProgram pipProgram = pipProgramLocalService.getPipProgram(pipProgramId);
        ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
        long designationMasterId = ParamUtil.getLong(actionRequest,"designationSelect");
        EmployeeDetails employeeDetails = employeeDetailsLocalService.getEmployeeDetails(pipProgram.getEmployeeId());
        EmployeeDesignation employeeDesignation = employeeDesignationLocalService.findByEmployeeId(employeeDetails.getEmployeeId());
        DesignationMaster designationMaster = designationMasterLocalService.getDesignationMaster(designationMasterId);
        employeeDesignation.setDesignationMasterId(designationMaster.getDesignationMasterId());
        employeeDesignationLocalService.updateEmployeeDesignation(employeeDesignation);

        pipProgram.setModifiedDate(new Date());
        pipProgram.setModifiedBy(themeDisplay.getUserId());
        pipProgram.setStatus("Demoted");//        'Active', 'Completed', 'Terminated', 'Demoted', 'Extended'

        //deleting the old intern designation
        EmployeeDesignation employeeDesignationOld = employeeDesignationLocalService.findByEmployeeId(pipProgram.getEmployeeId());
        DesignationMaster designationMasterOld = designationMasterLocalService.getDesignationMaster(employeeDesignationOld.getDesignationMasterId());
        long oldDesignationRoleId = roleLocalService.getRole(themeDisplay.getCompanyId(), designationMasterOld.getDesignationName()).getRoleId();
        employeeDesignationLocalService.deleteEmployeeDesignation(employeeDesignationOld);
        roleLocalService.deleteUserRole(employeeDetails.getLrUserId(), oldDesignationRoleId);
        // Get the role ID for the current designation
        try {
            Role role = roleLocalService.getRole(themeDisplay.getCompanyId(), designationMaster.getDesignationName());
            long[] roleIds = new long[1];
            roleIds[0] = role.getRoleId();
            RoleLocalServiceUtil.addUserRoles(employeeDetails.getLrUserId(), roleIds);
        } catch (Exception e) {
            log.error(e);
        }
        pipProgramLocalService.updatePipProgram(pipProgram);

    }
}
