//package com.ax.hrms.work.from.home.web.action;
//
//
//
//import com.ax.hrms.model.WorkFromHome;
//import com.ax.hrms.service.WorkFromHomeLocalService;
//import com.ax.hrms.work.from.home.web.constants.AxHrmsWorkFromHomePortletKeys;
//import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
//import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
//import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
//import com.liferay.portal.kernel.theme.ThemeDisplay;
//import com.liferay.portal.kernel.util.ParamUtil;
//import com.liferay.portal.kernel.util.PortalUtil;
//import com.liferay.portal.kernel.util.WebKeys;
//import com.liferay.portal.kernel.servlet.SessionMessages;
//import org.osgi.service.component.annotations.Component;
//import org.osgi.service.component.annotations.Reference;
//
//import javax.portlet.ActionRequest;
//import javax.portlet.ActionResponse;
//import java.util.Date;
//
//@Component(
//        property = {
//                "javax.portlet.name=" + AxHrmsWorkFromHomePortletKeys.AXHRMSWORKFROMHOME,
//                "mvc.command.name=/addWorkFromHomeRequest"
//        },
//        service = MVCActionCommand.class
//)
//public class AddWorkFromHomeRequestMVCActionCommand extends BaseMVCActionCommand {
//
//    @Reference
//    WorkFromHomeLocalService workFromHomeLocalService;
//
//    @Override
//    protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse)
//            throws Exception {
//   System.out.println("Hello odfdsfsdf");
//        ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
//
//        String teamMailId = ParamUtil.getString(actionRequest, "teamMailId");
//        String reason = ParamUtil.getString(actionRequest, "reason");
//        Date startDate = ParamUtil.getDate(actionRequest, "startDate", null);
//        Date endDate = ParamUtil.getDate(actionRequest, "endDate", null);
//
//        long wfhId = CounterLocalServiceUtil.increment(WorkFromHome.class.getName());
//
//        WorkFromHome  wfh = workFromHomeLocalService.createWorkFromHome(wfhId);
//
//        // Audit Fields
//        wfh.setCompanyId(themeDisplay.getCompanyId());
//        wfh.setGroupId(themeDisplay.getScopeGroupId());
//        wfh.setCreatedBy(themeDisplay.getUserId());
//        wfh.setModifiedBy(themeDisplay.getUserId());
//        wfh.setCreateDate(new Date());
//        wfh.setModifiedDate(new Date());
//
//        // User Input Fields
//        wfh.setUserId(themeDisplay.getUserId());
//        wfh.setTeamMailId(teamMailId);
//        wfh.setReason(reason);
//        wfh.setStatus("Pending");  // default
//        wfh.setStartDate(startDate);
//        wfh.setEndDate(endDate);
//        wfh.setRequestDate(new Date());
//
//        // Save
//        workFromHomeLocalService.addWorkFromHome(wfh);
//
//        SessionMessages.add(actionRequest, "success");
//        SessionMessages.add(actionRequest,
//                PortalUtil.getPortletId(actionRequest) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
//    }
//}




















//
//
//package com.ax.hrms.work.from.home.web.action;
//
//import com.ax.hrms.model.WorkFromHome;
//import com.ax.hrms.service.WorkFromHomeLocalService;
//import com.ax.hrms.work.from.home.web.constants.AxHrmsWorkFromHomePortletKeys;
//import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
//import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
//import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
//import com.liferay.portal.kernel.servlet.SessionErrors;
//import com.liferay.portal.kernel.servlet.SessionMessages;
//import com.liferay.portal.kernel.theme.ThemeDisplay;
//import com.liferay.portal.kernel.util.ParamUtil;
//import com.liferay.portal.kernel.util.PortalUtil;
//import com.liferay.portal.kernel.util.Validator;
//import com.liferay.portal.kernel.util.WebKeys;
//import org.osgi.service.component.annotations.Component;
//import org.osgi.service.component.annotations.Reference;
//
//import javax.portlet.ActionRequest;
//import javax.portlet.ActionResponse;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//
//@Component(
//        property = {
//                "javax.portlet.name=" + AxHrmsWorkFromHomePortletKeys.AXHRMSWORKFROMHOME,
//                "mvc.command.name=/addEditWFH"
//        },
//        service = MVCActionCommand.class
//)
//public class AddWorkFromHomeRequestMVCActionCommand extends BaseMVCActionCommand {
//
//    @Reference
//    WorkFromHomeLocalService workFromHomeLocalService;
//
//    @Override
//    protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
//
//        long wfhId = ParamUtil.getLong(actionRequest, "workFromHomeRequestId");
//
//        String teamMailId = ParamUtil.getString(actionRequest, "teamMailId");
//        String reason = ParamUtil.getString(actionRequest, "reason");
////        Date startDate = ParamUtil.getDate(actionRequest, "startDate", null);
////        Date endDate = ParamUtil.getDate(actionRequest, "endDate", null);
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//
//        String startDateStr = ParamUtil.getString(actionRequest, "startDate");
//        String endDateStr = ParamUtil.getString(actionRequest, "endDate");
//
//        Date startDate = Validator.isNotNull(startDateStr) ? sdf.parse(startDateStr) : null;
//        Date endDate = Validator.isNotNull(endDateStr) ? sdf.parse(endDateStr) : null;
//
//        System.out.println("startDate :: " + startDate + " endDate :: " + endDate);
//
//         System.out.println("startDate ::  "+startDate+"  endDate ::  "+endDate);
//        ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
//
//        // ---------- ADD ----------
//        if (wfhId <= 0) {
//            WorkFromHome wfh = workFromHomeLocalService.createWorkFromHome(
//                    CounterLocalServiceUtil.increment(WorkFromHome.class.getName())
//            );
//
//            wfh.setCompanyId(themeDisplay.getCompanyId());
//            wfh.setGroupId(themeDisplay.getScopeGroupId());
//            wfh.setCreatedBy(themeDisplay.getUserId());
//            wfh.setModifiedBy(themeDisplay.getUserId());
//            wfh.setCreateDate(new Date());
//            wfh.setModifiedDate(new Date());
//
//            wfh.setUserId(themeDisplay.getUserId());
//            wfh.setTeamMailId(teamMailId);
//            wfh.setReason(reason);
//            wfh.setStatus("Pending");
//            wfh.setStartDate(startDate);
//            wfh.setEndDate(endDate);
//            wfh.setRequestDate(new Date());
//
//            workFromHomeLocalService.addWorkFromHome(wfh);
//
//            SessionMessages.add(actionRequest, "success");
//        }
//
//        // ---------- EDIT ----------
//        else {
//            WorkFromHome wfh = workFromHomeLocalService.getWorkFromHome(wfhId);
//
//            wfh.setTeamMailId(teamMailId);
//            wfh.setReason(reason);
//            wfh.setStartDate(startDate);
//            wfh.setEndDate(endDate);
//            wfh.setModifiedBy(themeDisplay.getUserId());
//            wfh.setModifiedDate(new Date());
//
//            workFromHomeLocalService.updateWorkFromHome(wfh);
//
//            SessionMessages.add(actionRequest, "success-edit");
//        }
//
//        SessionMessages.add(actionRequest,
//                PortalUtil.getPortletId(actionRequest) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
//    }
//}



































package com.ax.hrms.work.from.home.web.employee.action;

import com.ax.hrms.master.service.LeaveCompensatoryStatusMasterLocalService;
import com.ax.hrms.model.EmployeeDetails;
import com.ax.hrms.model.WorkFromHomeRequest;
import com.ax.hrms.service.EmployeeDetailsLocalService;
import com.ax.hrms.service.WorkFromHomeRequestLocalService;
import com.ax.hrms.work.from.home.web.constants.AxHrmsWorkFromHomePortletKeys;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component(
        property = {
                "javax.portlet.name=" + AxHrmsWorkFromHomePortletKeys.AXHRMSWORKFROMHOME,
                "mvc.command.name=/addEditWFH"
        },
        service = MVCActionCommand.class
)
public class AddWorkFromHomeRequestMVCActionCommand extends BaseMVCActionCommand {
    private static final Log log = LogFactoryUtil.getLog(AddWorkFromHomeRequestMVCActionCommand.class);

    @Reference
    WorkFromHomeRequestLocalService workFromHomeRequestLocalService;

    @Reference
    private LeaveCompensatoryStatusMasterLocalService leaveCompensatoryStatusMasterLocalService;

    @Reference
    private EmployeeDetailsLocalService employeeDetailsLocalService;

    @Override
    protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {

        long wfhId = ParamUtil.getLong(actionRequest, "workFromHomeRequestId");

        System.out.println("workFromHomeRequestId:" + wfhId);
        System.out.println("wfhId in doProcessAction = " + wfhId);
        log.info("wfhId in doProcessAction = " + wfhId);
        String teamMailId = ParamUtil.getString(actionRequest, "teamMailId");
        String reason = ParamUtil.getString(actionRequest, "reason");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        String startDateStr = ParamUtil.getString(actionRequest, "startDate");
        String endDateStr = ParamUtil.getString(actionRequest, "endDate");

        Date startDate = Validator.isNotNull(startDateStr) ? sdf.parse(startDateStr) : null;
        Date endDate = Validator.isNotNull(endDateStr) ? sdf.parse(endDateStr) : null;

        ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
       log.info("here ok.....");

        // -----------------------------
        // VALIDATION SECTION
        // -----------------------------

//        boolean hasError = false;
//
//        // Empty fields check
//        if (Validator.isNull(teamMailId) ||
//                Validator.isNull(reason) ||
//                Validator.isNull(startDateStr) ||
//                Validator.isNull(endDateStr)) {
//
//            SessionErrors.add(actionRequest, "empty-fields");
//            hasError = true;
//        }
//
//        // Email validation
//        if (Validator.isNull(teamMailId) || !Validator.isEmailAddress(teamMailId)) {
//            SessionErrors.add(actionRequest, "email-invalid");
//            hasError = true;
//        }
//
//        // Reason validation (min 10 chars)
//        if (reason.length() < 10) {
//            SessionErrors.add(actionRequest, "reason-min-char-invalid");
//            hasError = true;
//        }
//
//        // Reason validation (max 250 chars)
//        if (reason.length() > 250) {
//            SessionErrors.add(actionRequest, "reason-max-char-invalid");
//            hasError = true;
//        }
//
//        // Start date required
//        if (startDate == null) {
//            SessionErrors.add(actionRequest, "start-date-invalid");
//            hasError = true;
//        }
//
//        // End date required
//        if (endDate == null) {
//            SessionErrors.add(actionRequest, "end-date-invalid");
//            hasError = true;
//        }
//
//        // End date must be after start date
//        if (startDate != null && endDate != null && endDate.before(startDate)) {
//            SessionErrors.add(actionRequest, "end-before-start");
//            hasError = true;
//        }
//
//        // If any validation failed → stop processing
//        if (hasError) {
//            actionResponse.setRenderParameter("mvcPath", "/jsp/ax-hrms-work-from-home-employee/add_edit_work_from_home.jsp");
//            return;
//        }


        // -----------------------------
        // SAVE DATA (ADD / EDIT)
        // -----------------------------
        log.info("befor the condition check");
        if (wfhId <= 0) {

            log.info("inside the ....................");
            // ADD NEW ENTRY
            WorkFromHomeRequest wfh = workFromHomeRequestLocalService.createWorkFromHomeRequest(
                    CounterLocalServiceUtil.increment(WorkFromHomeRequest.class.getName())
            );
            log.info("inside the condition check");

            wfh.setCompanyId(themeDisplay.getCompanyId());
            wfh.setGroupId(themeDisplay.getScopeGroupId());
            wfh.setCreatedBy(themeDisplay.getUserId());
            wfh.setModifiedBy(themeDisplay.getUserId());
            wfh.setCreateDate(new Date());
            wfh.setModifiedDate(new Date());
try {
    EmployeeDetails employeeDetails = employeeDetailsLocalService.findByLrUserId(themeDisplay.getUserId());
    log.info("employee details " + employeeDetails.toString());
//            wfh.setEmployeeId(employeeDetails.getEmployeeId());
    wfh.setEmployeeId(employeeDetails.getEmployeeId());
}catch (Exception e) {
    e.printStackTrace();
}
            wfh.setTeamMailId(teamMailId);
            wfh.setReason(reason);
            wfh.setStatus(leaveCompensatoryStatusMasterLocalService.findByLeaveCompensatoryStatusName(AxHrmsWorkFromHomePortletKeys.PENDING).getLeaveCompensatoryStatusMasterId());
            wfh.setStartDate(startDate);
            wfh.setEndDate(endDate);
            wfh.setRequestDate(new Date());
            log.info("over here");
            workFromHomeRequestLocalService.addWorkFromHomeRequest(wfh);
            log.info("add successfullyt");

//            SessionMessages.add(actionRequest, "wfh-added");
        } else {

            // EDIT EXISTING ENTRY
            WorkFromHomeRequest wfh = workFromHomeRequestLocalService.getWorkFromHomeRequest(wfhId);

            wfh.setTeamMailId(teamMailId);
            wfh.setReason(reason);
            wfh.setStartDate(startDate);
            wfh.setEndDate(endDate);
            wfh.setModifiedBy(themeDisplay.getUserId());
            wfh.setModifiedDate(new Date());

            workFromHomeRequestLocalService.updateWorkFromHomeRequest(wfh);

            SessionMessages.add(actionRequest, "wfh-updated");
        }

        // Hide default Liferay error message
//        SessionMessages.add(actionRequest,
//                PortalUtil.getPortletId(actionRequest) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
    }
}
