package com.ax.hrms.holiday.hr.admin.web.action;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.ax.hrms.holiday.web.portlet.constants.AxHrmsHolidayHrAdminWebPortletConstants;
import com.ax.hrms.holiday.web.portlet.constants.AxHrmsHolidayHrAdminWebPortletKeys;
import com.ax.hrms.model.Holiday;
import com.ax.hrms.service.HolidayLocalService;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;

/**

Author: himanshu Jha
*/
@Component(
	    immediate = true,
	    property = {
	        "javax.portlet.name="+ AxHrmsHolidayHrAdminWebPortletKeys.AXHRMSHRADMINHOLIDAYWEB,
	        "mvc.command.name=/addEditHolidayHrAdmin"
	    },
	    service = MVCActionCommand.class
	)

public class AddEditHolidayHrAdminMVCActionCommand extends BaseMVCActionCommand {
	
	@Reference
	HolidayLocalService holidayLocalService;
	

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		super.hideDefaultErrorMessage(actionRequest);
		super.hideDefaultSuccessMessage(actionRequest);

		String holidayName = ParamUtil.getString(actionRequest, AxHrmsHolidayHrAdminWebPortletConstants.HOLIDAYHRADMIN_NAME, null);
		String holidayDesc = ParamUtil.getString(actionRequest, AxHrmsHolidayHrAdminWebPortletConstants.HOLIDAYHRADMIN_DESC, null);
		String floater = ParamUtil.getString(actionRequest, AxHrmsHolidayHrAdminWebPortletConstants.HOLIDAYHRADMIN_ISFLOATER, null);
		
		String enteredDate = ParamUtil.getString(actionRequest, AxHrmsHolidayHrAdminWebPortletConstants.HOLIDAYHRADMIN_DATE, null);
		
		SimpleDateFormat dateFormat = new SimpleDateFormat(AxHrmsHolidayHrAdminWebPortletConstants.HOLIDAYDATEFORMAT);
		
		Date date = dateFormat.parse(enteredDate);

		Instant instant = date.toInstant();
		LocalDate localDate = instant.atZone(ZoneId.systemDefault()).toLocalDate();
		
		int year = localDate.getYear();
		
		String backURL = ParamUtil.getString(actionRequest, AxHrmsHolidayHrAdminWebPortletConstants.BACKURL);
		
		long holidayId = ParamUtil.getLong(actionRequest, AxHrmsHolidayHrAdminWebPortletConstants.HOLIDAYHRADMIN_ID, AxHrmsHolidayHrAdminWebPortletConstants.DEFAULT_LONG_VALUE);

        if (holidayId <= 0) {
        	if(isSameDateExists(date, holidayId)) {
        		
            	Holiday holiday = holidayLocalService.createHoliday(CounterLocalServiceUtil.increment(Holiday.class.getName()));
                
                ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
                
                holiday.setHolidayName(holidayName);
                holiday.setDescription(holidayDesc);
                holiday.setDate(date);
                holiday.setIsFloater(floater.equals(AxHrmsHolidayHrAdminWebPortletConstants.HOLIDAYFLOATERVALUE));
                holiday.setYear(year);
                holiday.setCompanyId(themeDisplay.getCompanyId());
                holiday.setCreatedBy(themeDisplay.getUserId());
                holiday.setGroupId(themeDisplay.getCompanyGroupId());
                holiday.setCreateDate(new Date());
                holiday.setModifiedDate(new Date());
                holidayLocalService.addHoliday(holiday);
                backURL = backURL.replace(AxHrmsHolidayHrAdminWebPortletConstants.SELECTED_YEAR_STRING,Integer.toString(holiday.getYear()));
                
                SessionMessages.add(actionRequest, AxHrmsHolidayHrAdminWebPortletConstants.HOLIDAY_HR_ADMIN_ADDED);
                actionResponse.sendRedirect(backURL);

        	}else {
        		SessionErrors.add(actionRequest,AxHrmsHolidayHrAdminWebPortletConstants.HOLIDAY_HR_ADMIN_EXISTS);
				actionResponse.setRenderParameter(AxHrmsHolidayHrAdminWebPortletConstants.MVCCOMMANDNAME, AxHrmsHolidayHrAdminWebPortletConstants.FETCH_HOLIDAY);

        	}
        }
        else {
        	if (isSameDateExists(date, holidayId)) {
            	Holiday holiday = holidayLocalService.getHoliday(holidayId);

            	holiday.setHolidayName(holidayName);
                ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
                holiday.setDescription(holidayDesc);
                holiday.setIsFloater(floater.equals(AxHrmsHolidayHrAdminWebPortletConstants.HOLIDAYFLOATERVALUE));
                holiday.setDate(date);
                holiday.setModifiedBy(themeDisplay.getUserId());
                holidayLocalService.updateHoliday(holiday);
//                backURL = backURL.replace(AxHrmsHolidayHrAdminWebPortletConstants.SELECTED_YEAR_STRING,Integer.toString(holiday.getYear()));

                
                SessionMessages.add(actionRequest, AxHrmsHolidayHrAdminWebPortletConstants.HOLIDAY_HR_ADMIN_UPDATED);
                actionResponse.sendRedirect(backURL);

				}
				else {
					SessionErrors.add(actionRequest, AxHrmsHolidayHrAdminWebPortletConstants.HOLIDAY_HR_ADMIN_EXISTS);

					actionResponse.setRenderParameter(AxHrmsHolidayHrAdminWebPortletConstants.MVCCOMMANDNAME, AxHrmsHolidayHrAdminWebPortletConstants.FETCH_HOLIDAY);
				}
        }
    }

    private boolean isSameDateExists(Date holidayDate,long holidayId) {
    	try {
    		Holiday holiday = holidayLocalService.findByDate(holidayDate);
    	if(holiday.getHolidayId()==holidayId) {
    		return true;
    		
    	}
    	}catch(Exception e) {
    		return true;
    	}
    	return false;
    	
    }
	
}
