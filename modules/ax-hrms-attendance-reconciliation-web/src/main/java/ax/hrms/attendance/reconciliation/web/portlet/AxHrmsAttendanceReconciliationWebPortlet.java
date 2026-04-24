package ax.hrms.attendance.reconciliation.web.portlet;

import ax.hrms.attendance.reconciliation.web.constants.AxHrmsAttendanceReconciliationWebPortletKeys;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.Portlet;

import org.osgi.service.component.annotations.Component;

/**
 * @author Ankit.Hadiyal
 */
@Component(
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"com.liferay.portlet.requires-namespaced-parameters=false",
		"com.liferay.portlet.action-url-redirect=true",
		"javax.portlet.display-name=Attendance Reconciliation",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + AxHrmsAttendanceReconciliationWebPortletKeys.AXHRMSATTENDANCERECONCILIATIONWEB,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class AxHrmsAttendanceReconciliationWebPortlet extends MVCPortlet {
}