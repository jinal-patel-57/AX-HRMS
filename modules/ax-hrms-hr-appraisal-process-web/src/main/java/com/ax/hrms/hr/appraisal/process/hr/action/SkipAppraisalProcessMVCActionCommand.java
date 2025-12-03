package com.ax.hrms.hr.appraisal.process.hr.action;


import com.ax.hrms.common.api.api.AxHrmsCommonApi;
import com.ax.hrms.hr.appraisal.process.constants.AxHrmsHrAppraisalProcessHrConstants;
import com.ax.hrms.hr.appraisal.process.constants.AxHrmsHrAppraisalProcessPortletKeys;
import com.ax.hrms.master.service.AppraisalStatusMasterLocalService;
import com.ax.hrms.model.*;
import com.ax.hrms.service.*;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.GroupLocalServiceUtil;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.*;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;


/**
 * Author: Nivid Koradiya
 */
@Component(
        property = {
                "javax.portlet.name=" + AxHrmsHrAppraisalProcessPortletKeys.AX_HRMS_HR_APPRAISAL_PROCESS_WEB_PORTLET,
                "mvc.command.name=/skipURL"
        },
        service = MVCActionCommand.class
)
public class SkipAppraisalProcessMVCActionCommand extends BaseMVCActionCommand {

    Log log = LogFactoryUtil.getLog(SkipAppraisalProcessMVCActionCommand.class);

    @Reference
    AppraisalProcessLocalService appraisalProcessLocalService;

    @Reference
    AppraisalStatusMasterLocalService appraisalStatusMasterLocalService;
    @Override
    protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
        log.info("SkipAppraisalProcessMVCActionCommand >>>  doProcessAction ::: Process Action Called ");

        long appraisalId=ParamUtil.getLong(actionRequest,"appraisalProcessId");
        String level=ParamUtil.getString(actionRequest,"level");

        AppraisalProcess appraisalProcess  =appraisalProcessLocalService.getAppraisalProcess(appraisalId);
        if(level.equals(AxHrmsHrAppraisalProcessHrConstants.SELF)){
            appraisalProcess.setIsSelfEvalutionFormSent(true);
            appraisalProcess.setIsSelfEvalutionFormFilled(true);
            appraisalProcess.setStatus(appraisalStatusMasterLocalService.findBystatus(AxHrmsHrAppraisalProcessHrConstants.IN_SELF_EVALUATION).getAppraisalStatusMasterId());
            SessionMessages.add(actionRequest,"self-skipped");
        }
        if(level.equals(AxHrmsHrAppraisalProcessHrConstants.PEER)){
            appraisalProcess.setArePeerEvaluationFormSent(true);
            appraisalProcess.setArePeerEvaluationFormFilled(true);
            appraisalProcess.setStatus(appraisalStatusMasterLocalService.findBystatus(AxHrmsHrAppraisalProcessHrConstants.IN_PEER_EVALUATION).getAppraisalStatusMasterId());
            SessionMessages.add(actionRequest,"peer-skipped");
        }
        if(level.equals(AxHrmsHrAppraisalProcessHrConstants.MANAGER)){
            appraisalProcess.setIsManagementFormSent(true);
            appraisalProcess.setIsManagementFormFilled(true);
            appraisalProcess.setStatus(appraisalStatusMasterLocalService.findBystatus(AxHrmsHrAppraisalProcessHrConstants.IN_MANAGER_EVALUATION).getAppraisalStatusMasterId());
            SessionMessages.add(actionRequest,"manager-skipped");
        }
        appraisalProcessLocalService.updateAppraisalProcess(appraisalProcess);

    }
}



