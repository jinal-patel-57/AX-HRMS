package com.ax.hrms.hr.appraisal.process.hr.action;


import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import com.ax.hrms.hr.appraisal.process.constants.AxHrmsHrAppraisalProcessHrConstants;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.ax.hrms.hr.appraisal.process.constants.AxHrmsHrAppraisalProcessPortletKeys;
import com.ax.hrms.master.model.DesignationMaster;
import com.ax.hrms.master.service.DesignationMasterLocalService;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;

/**
 * Author: Nivid Koradiya
 */
@Component(
        property = {
                "javax.portlet.name=" + AxHrmsHrAppraisalProcessPortletKeys.AX_HRMS_HR_APPRAISAL_PROCESS_WEB_PORTLET,
                "mvc.command.name=/getDesignationList"
        },
        service = MVCResourceCommand.class
)
public class FetchDesignationListMVCResourceCommand extends BaseMVCResourceCommand {
    Log log = LogFactoryUtil.getLog(FetchDesignationListMVCResourceCommand.class.getName());
    @Reference
    DesignationMasterLocalService designationMasterLocalService;

    @Override
    protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws Exception {
        List<DesignationMaster> designationMasterList = designationMasterLocalService.getDesignationMasters(-1,-1);
        Map<Long,String> designationMasterMap = new HashMap<>();
        designationMasterList.forEach(designationMaster ->{
            designationMasterMap.put(designationMaster.getDesignationMasterId(), designationMaster.getDesignationName());
        });
        JSONObject stateJson = JSONFactoryUtil.createJSONObject();

        PrintWriter writer = null;
        try {
            stateJson.put(AxHrmsHrAppraisalProcessHrConstants.DATA, designationMasterMap);
            stateJson.put(AxHrmsHrAppraisalProcessHrConstants.STATUS,AxHrmsHrAppraisalProcessHrConstants.SUCCESS);
            writer = resourceResponse.getWriter();
            writer.write(stateJson.toString());
            writer.close();
        } catch (Exception e) {
            log.error("JSON Writing Error");
        }
    }
}
