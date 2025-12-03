package com.ax.hrms.hr.appraisal.form.templates.portlet;

import com.ax.hrms.hr.appraisal.form.templates.constants.AxHrmsHrAppraisalFormTemplatesPortletKey;
import com.ax.hrms.hr.appraisal.form.templates.constants.AxHrmsHrAppraisalFormTemplatesWebConstants;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import org.osgi.service.component.annotations.Component;

import javax.portlet.Portlet;

/**
 * @author krish.moradiya
 * @implNote : Portlet file Of Appraisal Form Template
 */
@Component(
	property = {
		"com.liferay.portlet.display-category="+ AxHrmsHrAppraisalFormTemplatesWebConstants.PORTLET_CATEGORY,
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.header-portlet-javascript="+AxHrmsHrAppraisalFormTemplatesWebConstants.JQUERY_JS_PATH,
		"com.liferay.portlet.header-portlet-javascript="+AxHrmsHrAppraisalFormTemplatesWebConstants.JQUERY_VALIDATOR_JS_PATH,
		"com.liferay.portlet.footer-portlet-javascript="+AxHrmsHrAppraisalFormTemplatesWebConstants.MAIN_JS_PATH,
		"com.liferay.portlet.instanceable=false",
		"javax.portlet.display-name="+AxHrmsHrAppraisalFormTemplatesWebConstants.DISPLAY_NAME,
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template="+AxHrmsHrAppraisalFormTemplatesWebConstants.LIST_APPRAISAL_FORM_TEMPLATES_JSP_PATH,
		"javax.portlet.name=" + AxHrmsHrAppraisalFormTemplatesPortletKey.AXHRMS_HR_APPRAISAL_FORM_TEMPLATES_PORTLET_KEY,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class AxHrmsHrAppraisalFormTemplatesWebPortlet extends MVCPortlet {
}