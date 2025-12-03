package com.ax.hrms.holiday.hr.admin.web.action;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.ax.hrms.holiday.web.portlet.constants.AxHrmsHolidayHrAdminWebPortletConstants;
import com.ax.hrms.holiday.web.portlet.constants.AxHrmsHolidayHrAdminWebPortletKeys;
import com.ax.hrms.service.HolidayLocalService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.ParamUtil;

/**

Author: Himanshu Jha
*/

@Component(
		immediate = true,
		property = {
			"javax.portlet.name="+AxHrmsHolidayHrAdminWebPortletKeys.AXHRMSHRADMINHOLIDAYWEB,
			"mvc.command.name=/fetchHoliday"
		},
		service = MVCRenderCommand.class
	)


public class FetchHolidayHrAdminMVCRenderCommand implements MVCRenderCommand {
	
	private static final  Log log = LogFactoryUtil.getLog(FetchHolidayHrAdminMVCRenderCommand.class);
	
	@Reference
	HolidayLocalService holidayLocalService;

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse)  {
		
		
		long holidayId = ParamUtil.getLong(renderRequest, AxHrmsHolidayHrAdminWebPortletConstants.HOLIDAYHRADMIN_ID);
		
		try {
		
			renderRequest.setAttribute(AxHrmsHolidayHrAdminWebPortletConstants.HOLIDAYHRADMIN_DATA, holidayLocalService.getHoliday(holidayId));
			
			
		} catch (PortalException e) {
			log.error("Error " + e.getMessage());
		}
		
		return AxHrmsHolidayHrAdminWebPortletConstants.FORM_HOLIDAY_HR_ADMIN;
	}

}
