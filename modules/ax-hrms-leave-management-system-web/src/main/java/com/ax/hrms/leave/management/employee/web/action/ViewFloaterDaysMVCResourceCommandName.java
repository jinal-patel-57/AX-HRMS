package com.ax.hrms.leave.management.employee.web.action;

import com.ax.hrms.leave.management.web.constants.AxHrmsLeaveManagementSystemWebPortletKeys;
import com.ax.hrms.leave.management.web.constants.AxHrmsLeaveManagementWebPortletConstants;
import com.ax.hrms.model.Holiday;
import com.ax.hrms.service.HolidayLocalService;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;

import java.io.PrintWriter;
import java.util.Calendar;
import java.util.List;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author krish.moradiya
 * @implNote : Resource Command in which if user select any floater leave type then floater day's Drop down render using this
 */
@Component(
        immediate = true,
        property = {
                "javax.portlet.name=" + AxHrmsLeaveManagementSystemWebPortletKeys.AXHRMS_EMPLOYEE_LEAVE_MANAGEMENT_SYSTEM_WEB_PORTLET,
                "mvc.command.name=/viewFloaterDays"
        },
        service = MVCResourceCommand.class
)
public class ViewFloaterDaysMVCResourceCommandName extends BaseMVCResourceCommand {
	private static final Log log = LogFactoryUtil.getLog(ViewFloaterDaysMVCResourceCommandName.class);
    @Reference
    private HolidayLocalService holidayLocalService;
    

	@Override
	protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws Exception {
		
		Calendar calendar = Calendar.getInstance();
        int currentYear = calendar.get(Calendar.YEAR);
        
        List<Holiday> holidayList = holidayLocalService.findByIsFloaterAndCurrentYear(true, currentYear);
		
        JSONObject jsonobj =  JSONFactoryUtil.createJSONObject();
		PrintWriter printout=resourceResponse.getWriter();
	    jsonobj.put(AxHrmsLeaveManagementWebPortletConstants.DATA, holidayList);
		jsonobj.put(AxHrmsLeaveManagementWebPortletConstants.STATUS, AxHrmsLeaveManagementWebPortletConstants.SUCCESS);
		printout.write(jsonobj.toString());
	    printout.close();
	}


}
