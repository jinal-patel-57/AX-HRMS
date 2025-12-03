package ax.hrms.upcoming.holiday.web.portlet;

import ax.hrms.upcoming.holiday.web.constants.AxHrmsUpcomingHolidayWebPortletKeys;
import ax.hrms.upcoming.holiday.web.constants.AxHrmsUpcomingHolidayWebConstants;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.Portlet;

import org.osgi.service.component.annotations.Component;

/**
 * @author krish.moradiya
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category="+AxHrmsUpcomingHolidayWebConstants.PORTLET_CATEGORY,
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=false",
		"javax.portlet.display-name="+AxHrmsUpcomingHolidayWebConstants.DISPLAY_NAME,
		"javax.portlet.init-param.template-path="+AxHrmsUpcomingHolidayWebConstants.DEFAULT_PATH,
		"javax.portlet.init-param.view-template="+AxHrmsUpcomingHolidayWebConstants.VIEW_UPCOMING_HOLIDAY_JSP_PATH,
		"javax.portlet.name=" + AxHrmsUpcomingHolidayWebPortletKeys.AXHRMSUPCOMINGHOLIDAYWEB,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class AxHrmsUpcomingHolidayWebPortlet extends MVCPortlet {
}