package com.ax.hrms.pip.program.web.actions;


import com.ax.hrms.common.api.api.AxHrmsCommonApi;
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
                "mvc.command.name=/extendPipProgram"
        },
        service = MVCActionCommand.class
)
public class ExtendPipProgramMVCActionCommand extends BaseMVCActionCommand {
    private static final Log log = LogFactoryUtil.getLog(ExtendPipProgramMVCActionCommand.class);

    @Reference
    PipProgramLocalService pipProgramLocalService;

    @Reference
    EmployeeDetailsLocalService employeeDetailsLocalService;

    @Reference
    AxHrmsCommonApi axHrmsCommonApi;

    @Override
    protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
        long pipProgramId = ParamUtil.getLong(actionRequest,"pipProgramId");
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
        Date startDate = ParamUtil.getDate(actionRequest,"startDate",sdf2);
        Date meetingDate = ParamUtil.getDate(actionRequest,"meetingDate",sdf2);
        int noOfMonths = ParamUtil.getInteger(actionRequest,"noOfMonths");
        String comments = ParamUtil.    getString(actionRequest,"comments");
//        EmployeeDetails employeeDetails = employeeDetailsLocalService

        ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);

        PipProgram pipProgram = pipProgramLocalService.getPipProgram(pipProgramId);

        pipProgram.setModifiedDate(new Date());
        pipProgram.setModifiedBy(themeDisplay.getUserId());
        pipProgram.setStartDate(startDate);
        pipProgram.setNumberOfMonths(noOfMonths);
        pipProgram.setImprovementAreas(comments);
        Calendar cal = Calendar.getInstance();
        cal.setTime(startDate);
        cal.set(Calendar.MONTH, cal.get(Calendar.MONTH)+noOfMonths);
        pipProgram.setEndDate(cal.getTime());
        pipProgram.setMeetingDate(meetingDate);
        pipProgram.setStatus("Extended");
//        'Active', 'Completed', 'Terminated', 'Demoted', 'Extended'
        pipProgramLocalService.updatePipProgram(pipProgram);
        sendPipExtensionMail(pipProgram);
    }

    private void sendPipExtensionMail(PipProgram pipProgram) throws PortalException {

        String htmlBuilder = " <p>Dear,</p>\n" +
                "\n" +
                "    <p>We hope this message finds you well.</p>\n" +
                "\n" +
                "    <p>After careful consideration and review, we have identified some new areas where your performance does not meet the expected standards for your role. As a result, your PIP Period has been extended.</p>\n" +
                "\n" +
                "    <p>We believe in your potential to succeed and are committed to working with you through this process.</p>\n" +
                "    <p>PIP EXTENSION START DATE : "+pipProgram.getStartDate()+" </p>\n" +
                "    <p>PIP EXTENSION END DATE : "+pipProgram.getEndDate()+" </p>\n" +
                "    <p>Updated Improvement Areas are ad below: </p>\n" +
                "    <p> "+ pipProgram.getImprovementAreas()+ "</p>\n" +
                "\n" +
                "    <p>If you have any questions or need further information, please do not hesitate to reach out to your manager or the HR department.</p>\n";
        Group group = GroupLocalServiceUtil.fetchGroup(PortalUtil.getDefaultCompanyId(), "Guest");
        String fromName = PrefsPropsUtil.getString(group.getCompanyId(), PropsKeys.ADMIN_EMAIL_FROM_NAME);
        String fromEmailAddress = PrefsPropsUtil.getString(group.getCompanyId(), PropsKeys.ADMIN_EMAIL_FROM_ADDRESS);
        EmployeeDetails employeeDetails = employeeDetailsLocalService.getEmployeeDetails(pipProgram.getEmployeeId());
        axHrmsCommonApi.sendMail(employeeDetails.getOfficialEmail(), fromEmailAddress, fromName, "PIP PROGRAM EXTENSION NOTIFICATION", htmlBuilder);
    }
}
