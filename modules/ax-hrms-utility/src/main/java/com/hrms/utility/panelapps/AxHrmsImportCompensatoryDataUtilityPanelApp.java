package com.hrms.utility.panelapps;

import com.hrms.utility.constants.AxHrmsImportCompensatoryDataUtilityKeys;
import com.liferay.application.list.BasePanelApp;
import com.liferay.application.list.PanelApp;
import com.liferay.application.list.constants.PanelCategoryKeys;
import com.liferay.portal.kernel.model.Portlet;
import com.liferay.portal.kernel.service.PortletLocalServiceUtil;

import java.util.Locale;

import org.osgi.service.component.annotations.Component;

/**
 * @author jinal.patel
 */
@Component(
	property = {
			"panel.app.order:Integer=100",
	        "panel.category.key=" + PanelCategoryKeys.CONTROL_PANEL_CONFIGURATION
	},
	service = PanelApp.class
)
public class AxHrmsImportCompensatoryDataUtilityPanelApp extends BasePanelApp  {
	
	@Override
	public String getPortletId() {
		return AxHrmsImportCompensatoryDataUtilityKeys.IMPORT_COMPENSATORY_DATA;
	}

	@Override
	public String getLabel(Locale locale) {
		return "Import Compensatory Data";
	}
	
	@Override
	public Portlet getPortlet() {
		Portlet portlet = PortletLocalServiceUtil.getPortletById(getPortletId());
		return portlet;
	}
}