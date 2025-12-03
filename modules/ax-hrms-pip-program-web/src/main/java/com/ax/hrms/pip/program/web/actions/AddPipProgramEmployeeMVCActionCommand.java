package com.ax.hrms.pip.program.web.actions;


import com.ax.hrms.common.api.api.AxHrmsCommonApi;
import com.ax.hrms.mail.template.config.configuration.MailTemplateConfiguration;
import com.ax.hrms.model.EmployeeDetails;
import com.ax.hrms.model.PipProgram;
import com.ax.hrms.pip.program.web.constants.AxHrmsPipProgramWebPortletKeys;
import com.ax.hrms.service.EmployeeDetailsLocalService;
import com.ax.hrms.service.PipProgramLocalService;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.GroupLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.*;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


/**

 Author: Nivid Koradiya
 */
@Component(
        property = {
                "javax.portlet.name=" + AxHrmsPipProgramWebPortletKeys.AX_HRMS_PIP_PROGRAM_WEB,
                "mvc.command.name=/addPipProgramEmployee"
        },
        service = MVCActionCommand.class
)
public class AddPipProgramEmployeeMVCActionCommand extends BaseMVCActionCommand {
    private static final Log log = LogFactoryUtil.getLog(AddPipProgramEmployeeMVCActionCommand.class);

    @Reference
    MailTemplateConfiguration mailTemplateConfiguration;

    @Reference
    PipProgramLocalService pipProgramLocalService;

    @Reference
    EmployeeDetailsLocalService employeeDetailsLocalService;

    @Reference
    AxHrmsCommonApi axHrmsCommonApi;
    @Override
    protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
        log.info("ACTION >>>>>>>>>>>::::::::;");

        long employeeId = ParamUtil.getLong(actionRequest,"employeeId");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date startDate = ParamUtil.getDate(actionRequest,"startDate",sdf);
        Date meetingDate = ParamUtil.getDate(actionRequest,"meetingDate",sdf);
        int noOfMonths = ParamUtil.getInteger(actionRequest,"noOfMonths");
        String comments = ParamUtil.getString(actionRequest,"comments");
//        EmployeeDetails employeeDetails = employeeDetailsLocalService

        ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);

        PipProgram pipProgram = pipProgramLocalService.createPipProgram(CounterLocalServiceUtil.increment(PipProgram.class.getName()));

        pipProgram.setCompanyId(themeDisplay.getCompanyId());
        pipProgram.setCreatedBy(themeDisplay.getUserId());
        pipProgram.setGroupId(themeDisplay.getCompanyGroupId());
        pipProgram.setCreateDate(new Date());
        pipProgram.setModifiedDate(new Date());
        
        pipProgram.setEmployeeId(employeeId);
        pipProgram.setStartDate(startDate);
        pipProgram.setNumberOfMonths(noOfMonths);
        pipProgram.setImprovementAreas(comments);
        Calendar cal = Calendar.getInstance();
        cal.setTime(startDate);
        cal.set(Calendar.MONTH, cal.get(Calendar.MONTH)+noOfMonths);
        pipProgram.setEndDate(cal.getTime());
        pipProgram.setMeetingDate(meetingDate);
        pipProgram.setStatus("Active");
//        'Active', 'Completed', 'Terminated', 'Demoted', 'Extended'
        pipProgramLocalService.addPipProgram(pipProgram);
        sendPipMailToEmployee(pipProgram);
    }

    private void sendPipMailToEmployee(PipProgram pipProgram) throws PortalException {


        String subject = mailTemplateConfiguration.pipProgramMailSubject();
        String body = mailTemplateConfiguration.pipProgramMailBody();
        Group group = GroupLocalServiceUtil.fetchGroup(PortalUtil.getDefaultCompanyId(), "Guest");
        String fromName = PrefsPropsUtil.getString(group.getCompanyId(), PropsKeys.ADMIN_EMAIL_FROM_NAME);
        String fromEmailAddress = PrefsPropsUtil.getString(group.getCompanyId(), PropsKeys.ADMIN_EMAIL_FROM_ADDRESS);
        EmployeeDetails employeeDetails = employeeDetailsLocalService.getEmployeeDetails(pipProgram.getEmployeeId());

        

        body = body.replace("${EMPLOYEE_NAME}", employeeDetails.getFirstName() + " " + employeeDetails.getLastName());
        body = body.replace("${PIP_START_DATE}", pipProgram.getStartDate().toString());
        body = body.replace("${PIP_END_DATE}", pipProgram.getEndDate().toString());
        body = body.replace("${IMPROVEMENT_AREAS}", pipProgram.getImprovementAreas());

        axHrmsCommonApi.sendMail(employeeDetails.getOfficialEmail(), fromEmailAddress, fromName, subject, body);
    }
}
