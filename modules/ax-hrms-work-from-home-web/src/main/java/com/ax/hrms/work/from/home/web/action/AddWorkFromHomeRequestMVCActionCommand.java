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






















package com.ax.hrms.work.from.home.web.action;

import com.ax.hrms.model.WorkFromHome;
import com.ax.hrms.service.WorkFromHomeLocalService;
import com.ax.hrms.work.from.home.web.constants.AxHrmsWorkFromHomePortletKeys;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import java.util.Date;

@Component(
        property = {
                "javax.portlet.name=" + AxHrmsWorkFromHomePortletKeys.AXHRMSWORKFROMHOME,
                "mvc.command.name=/addEditWFH"
        },
        service = MVCActionCommand.class
)
public class AddWorkFromHomeRequestMVCActionCommand extends BaseMVCActionCommand {

    @Reference
    WorkFromHomeLocalService workFromHomeLocalService;

    @Override
    protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {

        long wfhId = ParamUtil.getLong(actionRequest, "workFromHomeRequestId");

        String teamMailId = ParamUtil.getString(actionRequest, "teamMailId");
        String reason = ParamUtil.getString(actionRequest, "reason");
        Date startDate = ParamUtil.getDate(actionRequest, "startDate", null);
        Date endDate = ParamUtil.getDate(actionRequest, "endDate", null);

        ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);

        // ---------- ADD ----------
        if (wfhId <= 0) {
            WorkFromHome wfh = workFromHomeLocalService.createWorkFromHome(
                    CounterLocalServiceUtil.increment(WorkFromHome.class.getName())
            );

            wfh.setCompanyId(themeDisplay.getCompanyId());
            wfh.setGroupId(themeDisplay.getScopeGroupId());
            wfh.setCreatedBy(themeDisplay.getUserId());
            wfh.setModifiedBy(themeDisplay.getUserId());
            wfh.setCreateDate(new Date());
            wfh.setModifiedDate(new Date());

            wfh.setUserId(themeDisplay.getUserId());
            wfh.setTeamMailId(teamMailId);
            wfh.setReason(reason);
            wfh.setStatus("Pending");
            wfh.setStartDate(startDate);
            wfh.setEndDate(endDate);
            wfh.setRequestDate(new Date());

            workFromHomeLocalService.addWorkFromHome(wfh);

            SessionMessages.add(actionRequest, "success");
        }

        // ---------- EDIT ----------
        else {
            WorkFromHome wfh = workFromHomeLocalService.getWorkFromHome(wfhId);

            wfh.setTeamMailId(teamMailId);
            wfh.setReason(reason);
            wfh.setStartDate(startDate);
            wfh.setEndDate(endDate);
            wfh.setModifiedBy(themeDisplay.getUserId());
            wfh.setModifiedDate(new Date());

            workFromHomeLocalService.updateWorkFromHome(wfh);

            SessionMessages.add(actionRequest, "success-edit");
        }

        SessionMessages.add(actionRequest,
                PortalUtil.getPortletId(actionRequest) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
    }
}
