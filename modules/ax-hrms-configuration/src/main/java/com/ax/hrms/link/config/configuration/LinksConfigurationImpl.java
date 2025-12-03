package com.ax.hrms.link.config.configuration;

import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;

import java.util.Map;
@Component(
        configurationPid = "com.ax.hrms.link.config.configuration.LinksConfiguration",
        immediate = true,
        service = LinksConfiguration.class
)
public class LinksConfigurationImpl implements LinksConfiguration {

    @Override
    public String loginLink() {
        return _configuration.loginLink();
    }

    @Override
    public String employeeOnBoardingLink() {
        return _configuration.employeeOnBoardingLink();
    }

    @Override
    public String appraisalProcessManagementPageLink() {
        return _configuration.appraisalProcessManagementPageLink();
    }

    // below code need not be changed (strictly)
    @Activate
    @Modified
    protected void activate(Map<String, Object> properties) {
        _configuration = ConfigurableUtil.createConfigurable(
                LinksConfiguration.class, properties);
    }

    private volatile LinksConfiguration _configuration;

}
