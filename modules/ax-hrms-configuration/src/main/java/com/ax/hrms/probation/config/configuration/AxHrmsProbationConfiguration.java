package com.ax.hrms.probation.config.configuration;

import aQute.bnd.annotation.metatype.Meta.AD;
import aQute.bnd.annotation.metatype.Meta.OCD;
import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;

@ExtendedObjectClassDefinition(category = "HRMS",
scope = ExtendedObjectClassDefinition.Scope.SYSTEM)
@OCD(id = "com.ax.hrms.probation.config.configuration.AxHrmsProbationConfiguration",
localization = "content/Language",name="probation-period-configuration")
public interface AxHrmsProbationConfiguration {

	@AD(required = false, deflt="0" , name = "Probation Period Configuration (In Months	)")
	public String proationPeriod();

}
