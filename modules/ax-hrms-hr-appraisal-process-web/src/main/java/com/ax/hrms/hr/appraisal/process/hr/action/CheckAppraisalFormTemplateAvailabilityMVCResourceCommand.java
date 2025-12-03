package com.ax.hrms.hr.appraisal.process.hr.action;


import com.ax.hrms.exception.NoSuchAppraisalFormTemplatesException;
import com.ax.hrms.hr.appraisal.process.constants.AxHrmsHrAppraisalProcessHrConstants;
import com.ax.hrms.hr.appraisal.process.constants.AxHrmsHrAppraisalProcessPortletKeys;
import com.ax.hrms.master.exception.NoSuchTemplateLevelMasterException;
import com.ax.hrms.master.service.TemplateLevelMasterLocalService;
import com.ax.hrms.service.AppraisalFormTemplatesLocalService;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import java.io.PrintWriter;
import java.util.Calendar;

/**
 * Author: Nivid Koradiya
 */
@Component(
        property = {
                "javax.portlet.name=" + AxHrmsHrAppraisalProcessPortletKeys.AX_HRMS_HR_APPRAISAL_PROCESS_WEB_PORTLET,
                "mvc.command.name=/checkAppraisalFormTemplateAvailability"
        },
        service = MVCResourceCommand.class
)
public class CheckAppraisalFormTemplateAvailabilityMVCResourceCommand extends BaseMVCResourceCommand {
    Log log = LogFactoryUtil.getLog(CheckAppraisalFormTemplateAvailabilityMVCResourceCommand.class.getName());

    @Reference
    AppraisalFormTemplatesLocalService appraisalFormTemplatesLocalService;

    @Reference
    TemplateLevelMasterLocalService templateLevelMasterLocalService;

    @Override
    protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {
        String levelName = ParamUtil.getString(resourceRequest, AxHrmsHrAppraisalProcessHrConstants.LEVEL_NAME);
        boolean isAvailable;

        try{
            Calendar cal = Calendar.getInstance();
            String year = String.valueOf(cal.get(Calendar.YEAR));
            appraisalFormTemplatesLocalService.findByTemplateYearAndTemplateLevelId(year,templateLevelMasterLocalService.findBylevelName(levelName).getTemplateLevelMasterId());
            isAvailable = true;
        } catch (NoSuchTemplateLevelMasterException | NoSuchAppraisalFormTemplatesException e) {
            isAvailable = false;
        }


        JSONObject stateJson = JSONFactoryUtil.createJSONObject();

        PrintWriter writer = null;
        try {   
            stateJson.put(AxHrmsHrAppraisalProcessHrConstants.DATA, isAvailable);
            stateJson.put(AxHrmsHrAppraisalProcessHrConstants.STATUS, AxHrmsHrAppraisalProcessHrConstants.SUCCESS);
            writer = resourceResponse.getWriter();
            writer.write(stateJson.toString());
            writer.close();
        } catch (Exception e) {
            log.error("JSON Writing Error");
        }

    }
}
