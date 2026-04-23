package com.ax.hrms.module.config.configuration;

import aQute.bnd.annotation.metatype.Meta;
import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;

@ExtendedObjectClassDefinition(category = "HRMS", scope = ExtendedObjectClassDefinition.Scope.SYSTEM)
@Meta.OCD(id = "com.ax.hrms.module.config.configuration.ModuleConfiguration",
        localization = "content/Language",name="module-configuration")
public interface ModuleConfiguration {

    @Meta.AD(deflt = "@aixtor.com",
            name = "Employee On Boarding HR - Email Domain Name",
            required = false)
    public String domainName();

    @Meta.AD(deflt = "AX-yyyy-mm-dd-no",
            name = "Employee Onboarding HR - Employee Code Pattern",
            required = false)
    public String employeeCodePattern();


    @Meta.AD(deflt = "hr.aixtor@yopmail.com,connect@yopmail.com",
            name = "Employee Official Mail Id for not showing employee on Employee Directory",
            required = false)
    public String employeeOfficialMailIdForIgnoreFromEmployeeDirectory();



}
