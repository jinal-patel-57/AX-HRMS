package com.ax.hrms.probation.config.configuration.action;

import com.ax.hrms.probation.config.configuration.AxHrmsProbationConfiguration;
import com.liferay.configuration.admin.display.ConfigurationFormRenderer;
import com.liferay.frontend.taglib.servlet.taglib.util.JSPRenderer;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.settings.LocalizedValuesMap;
import com.liferay.portal.kernel.util.LocalizationUtil;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import com.ax.hrms.probation.config.constants.AxHrmsProbationConfigurationConstants;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;


@Component(immediate = true, service = ConfigurationFormRenderer.class)
public class AxHrmsProbationConfigurationRender implements ConfigurationFormRenderer{

	public static final String CLASS_NAME = AxHrmsProbationConfiguration.class.getName();
	
	@Override
	public String getPid() {
		
		return CLASS_NAME;
	}

	@Override
	public Map<String, Object> getRequestParameters(HttpServletRequest httpServletRequest) {
		
		Map<String, Object> params = new HashMap<>();
		Map<Locale, String> probationPeriodMap = LocalizationUtil.getLocalizationMap(httpServletRequest, AxHrmsProbationConfigurationConstants.PROBATION_PERIOD);

	    LocalizedValuesMap probationPeriodLocalizedValuesMap = new LocalizedValuesMap();

	    for (Map.Entry<Locale, String> probationPeriodEntry : probationPeriodMap.entrySet()) {
	    	probationPeriodLocalizedValuesMap.put(probationPeriodEntry.getKey(), probationPeriodEntry.getValue());
	    }

	    
	    String probbationPeriodXML = LocalizationUtil.getXml(probationPeriodLocalizedValuesMap, AxHrmsProbationConfigurationConstants.PROBATION_PERIOD);

	    params.put(AxHrmsProbationConfigurationConstants.PROBATION_PERIOD, probbationPeriodXML);

		_logger.debug("************** setting subject = " + probbationPeriodXML);

		return params;
	}

	@Override
	public void render(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
			throws IOException {
		
		String probationPeriodXML = AxHrmsProbationConfigurationAction.probationPeriodXML();

		httpServletRequest.setAttribute(AxHrmsProbationConfigurationConstants.PROBATION_PERIOD, probationPeriodXML);

		_logger.debug("************** getting subject = "+probationPeriodXML);

		jspRenderer.renderJSP(servletContext, httpServletRequest, httpServletResponse, AxHrmsProbationConfigurationConstants.CONFIG_CUSTOM_JSP);
		
	}

	@Reference(target = "(osgi.web.symbolicname=omsb.email.configuration)", unbind = "-")
	private ServletContext servletContext;

	@Reference
	private JSPRenderer jspRenderer;

	private static final Log _logger = LogFactoryUtil.getLog(AxHrmsProbationConfigurationRender.class);
}
