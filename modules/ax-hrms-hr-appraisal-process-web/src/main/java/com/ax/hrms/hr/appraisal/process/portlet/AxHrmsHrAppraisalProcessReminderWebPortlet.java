package com.ax.hrms.hr.appraisal.process.portlet;

import com.ax.hrms.hr.appraisal.process.constants.AxHrmsHrAppraisalProcessPortletKeys;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import org.osgi.service.component.annotations.Component;

import javax.portlet.Portlet;

/**
 * @author nivid.koradiya
 */
@Component(
	property = {
		"com.liferay.portlet.display-category=AX HRMS",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=false",
		"javax.portlet.display-name=Ax Hrms Hr Appraisal Reminder HR",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + AxHrmsHrAppraisalProcessPortletKeys.AX_HRMS_HR_APPRAISAL_PROCESS_REMINDER_WEB_PORTLET,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class AxHrmsHrAppraisalProcessReminderWebPortlet extends MVCPortlet {
}