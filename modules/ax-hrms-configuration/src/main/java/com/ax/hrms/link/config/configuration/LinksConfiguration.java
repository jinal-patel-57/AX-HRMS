package com.ax.hrms.link.config.configuration;

import aQute.bnd.annotation.metatype.Meta;
import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;

@ExtendedObjectClassDefinition(category = "HRMS", scope = ExtendedObjectClassDefinition.Scope.SYSTEM)
@Meta.OCD(id = "com.ax.hrms.link.config.configuration.LinksConfiguration",
        localization = "content/Language",name="links-configuration")
public interface LinksConfiguration {

    @Meta.AD(deflt = "https://www.google.com/",
            name = "Login URL",
            required = false)
    public String loginLink();

    @Meta.AD(deflt = "https://www.google.com/",
            name = "Employee Onboarding Employee URL",
            required = false)
    public String employeeOnBoardingLink();

    @Meta.AD(deflt = "https://www.google.com/",
            name = "Appraisal Process Management Page",
            required = false)
    public String appraisalProcessManagementPageLink();

}
