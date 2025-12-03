package com.ax.hrms.probation.config.configuration.action;

import com.ax.hrms.probation.config.configuration.AxHrmsProbationConfiguration;
import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;
import com.liferay.portal.kernel.util.LocalizationUtil;
import org.osgi.service.component.annotations.Component;

import java.util.Locale;
import java.util.Map;

@Component(configurationPid = "com.ax.hrms.probation.config.configuration.AxHrmsProbationConfiguration",enabled = true, immediate = true)
public class AxHrmsProbationConfigurationAction {
	
	public static String probationPeriod() {
		Map<Locale, String> subjectMap = LocalizationUtil.getLocalizationMap(probationPeriod);
		return subjectMap.get(Locale.US);
	}
	


	public static String probationPeriodXML() {
		return probationPeriod;
	}
	

	protected void activate(Map<String,Object> properties) {
		commonProbationConfiguration = ConfigurableUtil.createConfigurable(AxHrmsProbationConfiguration.class, properties);
		probationPeriod = commonProbationConfiguration.proationPeriod();
	}
	
	private volatile AxHrmsProbationConfiguration commonProbationConfiguration;
	
	private static String probationPeriod;
	

}
