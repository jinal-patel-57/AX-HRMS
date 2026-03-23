package com.hrms.utility.panelapps;

import com.hrms.utility.constants.AxHrmsImportEmployeesLeavesRequestsUtilityKeys;
import com.liferay.application.list.BasePanelApp;
import com.liferay.application.list.PanelApp;
import com.liferay.application.list.constants.PanelCategoryKeys;
import com.liferay.portal.kernel.model.Portlet;
import com.liferay.portal.kernel.service.PortletLocalServiceUtil;
import org.osgi.service.component.annotations.Component;

import java.util.Locale;

@Component(
        property = {
                "panel.app.order:Integer=100",
                "panel.category.key=" + PanelCategoryKeys.CONTROL_PANEL_CONFIGURATION
        },
        service = PanelApp.class
)
public class AxHrmsImportEmployeesLeavesRequestsUtilityPanelApp extends BasePanelApp {
    @Override
    public Portlet getPortlet() {
        Portlet portlet = PortletLocalServiceUtil.getPortletById(getPortletId());
        return portlet;
    }


    @Override
    public String getLabel(Locale locale) {
        return "Import Employee Leaves Requests Data";
    }

    @Override
    public String getPortletId() {
        return AxHrmsImportEmployeesLeavesRequestsUtilityKeys.IMPORT_EMPLOYEE_LEAVES_REQUESTS;
    }

}
