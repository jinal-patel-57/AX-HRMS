package com.ax.hrms.module.config.configuration;

import com.ax.hrms.link.config.configuration.LinksConfiguration;
import com.ax.hrms.module.config.configuration.ModuleConfiguration;
import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;

import java.util.Map;
@Component(
        configurationPid = "com.ax.hrms.module.config.configuration.ModuleConfiguration",
        immediate = true,
        service = ModuleConfiguration.class
)
public class ModuleConfigurationImpl implements ModuleConfiguration {

    @Override
    public String domainName() {
        return _configuration.domainName();
    }

    @Override
    public String employeeCodePattern() {
        return _configuration.employeeCodePattern();
    }



    // below code need not be changed (strictly)
    @Activate
    @Modified
    protected void activate(Map<String, Object> properties) {
        _configuration = ConfigurableUtil.createConfigurable(
                ModuleConfiguration.class, properties);
    }

    private volatile ModuleConfiguration _configuration;

}
