package com.ax.hrms.holiday.hr.admin.web.action;

import java.util.Calendar;
import java.util.Collections;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.ax.hrms.holiday.web.portlet.constants.AxHrmsHolidayHrAdminWebPortletConstants;
import com.ax.hrms.holiday.web.portlet.constants.AxHrmsHolidayHrAdminWebPortletKeys;
import com.ax.hrms.model.Holiday;
import com.ax.hrms.service.HolidayLocalService;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.portlet.PortletURLUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.ParamUtil;

/**

Author: himanshu Jha
*/

@Component(
		immediate = true,
		property = {
			"javax.portlet.name="+AxHrmsHolidayHrAdminWebPortletKeys.AXHRMSHRADMINHOLIDAYWEB,
			"mvc.command.name=/",
			"mvc.command.name=/fetchDataWithYears"
		},
		service = MVCRenderCommand.class
	)

public class ListHolidayHrAdminMVCRenderCommand implements MVCRenderCommand {
	
	@Reference
	HolidayLocalService holidayLocalService;  
	
	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		
	
			List<Holiday> holiday ;
			
		int currentYear = Calendar.getInstance().get(Calendar.YEAR);
	        int selectedYear = ParamUtil.getInteger(renderRequest, AxHrmsHolidayHrAdminWebPortletConstants.HOLIDAYSELECTED_YEAR);
	        
	        if(selectedYear != 0) {
	        	holiday = holidayLocalService.findByYear(selectedYear);
	        }
	        else {
	        	selectedYear = currentYear;
	        	holiday = holidayLocalService.findByYear(currentYear);
	        }
	        
	        PortletURL iteratorURL = PortletURLUtil.getCurrent(renderRequest, renderResponse);
			SearchContainer<Holiday> holidaySearchContainer = new SearchContainer<>(renderRequest, iteratorURL, null,
					StringPool.BLANK);
			holidaySearchContainer.setResultsAndTotal(holiday);
			
			
			renderRequest.setAttribute(AxHrmsHolidayHrAdminWebPortletConstants.HOLIDAYSEARCHCONTAINER, holidaySearchContainer);
			
        
			 List<Integer> holidayYears = holidayLocalService.getYear();
			    
		        Collections.sort(holidayYears);
		        
				
				
	
				

			    renderRequest.setAttribute(AxHrmsHolidayHrAdminWebPortletConstants.SELECTED_YEAR, selectedYear);
			    renderRequest.setAttribute(AxHrmsHolidayHrAdminWebPortletConstants.HOLIDAYHRADMIN_FULLLIST, holidayYears);
		        renderRequest.setAttribute(AxHrmsHolidayHrAdminWebPortletConstants.HOLIDAYCURRENTYEAR, Calendar.getInstance().get(Calendar.YEAR));
		        renderRequest.setAttribute(AxHrmsHolidayHrAdminWebPortletConstants.HOLIDAYEMPLOYEE_GET, holiday);
		        renderRequest.setAttribute(AxHrmsHolidayHrAdminWebPortletConstants.HOLIDAYEMPLOYEE, holiday);
		        

		   

			
			return AxHrmsHolidayHrAdminWebPortletConstants.LIST_HOLIDAY_HR_ADMIN_WITH_YEARS;
		}

}
