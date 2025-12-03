package com.ax.hrms.holiday.hr.admin.web.action;

import com.ax.hrms.holiday.web.portlet.constants.AxHrmsHolidayHrAdminWebPortletConstants;
import com.ax.hrms.holiday.web.portlet.constants.AxHrmsHolidayHrAdminWebPortletKeys;
import com.ax.hrms.service.HolidayLocalService;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**

Author: Himanshu Jha
*/

@Component(immediate = true, property = {
    "javax.portlet.name="+AxHrmsHolidayHrAdminWebPortletKeys.AXHRMSHRADMINHOLIDAYWEB,
    "mvc.command.name=/deleteHoliday"
}, service = MVCActionCommand.class)


public class DeleteHolidayHrAdminMVCActionCommand extends BaseMVCActionCommand {
	
	private static final Log log=LogFactoryUtil.getLog(DeleteHolidayHrAdminMVCActionCommand.class);
	
	@Reference
	HolidayLocalService holidayLocalService;

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		long holidayId = ParamUtil.getLong(actionRequest, AxHrmsHolidayHrAdminWebPortletConstants.HOLIDAYHRADMIN_ID);
		
		try {
			
			holidayLocalService.deleteHoliday(holidayId);
			
			SessionMessages.add(actionRequest, AxHrmsHolidayHrAdminWebPortletConstants.HOLIDAY_HR_ADMIN_DELETED);
	
		}catch (Exception e) {
			SessionMessages.add(actionRequest, AxHrmsHolidayHrAdminWebPortletConstants.HOLIDAY_HR_ADMIN_DELETED_ERROR);
			log.error(e.getMessage());
		}
		actionResponse.sendRedirect(ParamUtil.getString(actionRequest,AxHrmsHolidayHrAdminWebPortletConstants.BACKURL));
	}

}
