package ax.hrms.upcoming.holiday.web.action;

import ax.hrms.upcoming.holiday.web.constants.AxHrmsUpcomingHolidayWebConstants;
import ax.hrms.upcoming.holiday.web.constants.AxHrmsUpcomingHolidayWebPortletKeys;
import com.ax.hrms.model.Holiday;
import com.ax.hrms.service.HolidayLocalService;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author krish.moradiya
 */
@Component(
        immediate = true,
        property = {
                "javax.portlet.name=" + AxHrmsUpcomingHolidayWebPortletKeys.AXHRMSUPCOMINGHOLIDAYWEB ,
                "mvc.command.name="+ AxHrmsUpcomingHolidayWebConstants.DEFAULT_PATH
        },
        service = MVCRenderCommand.class
)
public class ListUpcomingHolidayMVCRenderCommand implements MVCRenderCommand {
    private static final Log log = LogFactoryUtil.getLog(ListUpcomingHolidayMVCRenderCommand.class);
    @Reference
    private HolidayLocalService holidayLocalService;
    @Override
    public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        LocalDate currentDate = LocalDate.now();
        log.info("ListUpcomingHolidayMVCRenderCommand >>> render ::: Current Date is: "+currentDate.format(formatter));

        LocalDate lastDateOfYear = LocalDate.now().withMonth(12).withDayOfMonth(31);
        log.info(lastDateOfYear);

        String formattedLastDate = lastDateOfYear.format(formatter);
        log.info(formattedLastDate);

        List<Holiday> holidayList = holidayLocalService.getHolidays(-1,-1);
        List<Holiday> upcomingHolidayList = new ArrayList<>();
        for(Holiday holiday: holidayList){
            Date holidayDate = holiday.getDate();
            LocalDate holidayLocalDate = holidayDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            if(holidayLocalDate.isAfter(currentDate) && holidayLocalDate.isBefore(lastDateOfYear))
                upcomingHolidayList.add(holiday);
        }
        renderRequest.setAttribute(AxHrmsUpcomingHolidayWebConstants.UPCOMING_HOLIDAY_LIST,upcomingHolidayList);
        return AxHrmsUpcomingHolidayWebConstants.VIEW_UPCOMING_HOLIDAY_JSP_PATH;
    }
}
