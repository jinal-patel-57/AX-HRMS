package ax.hrms.project.web.portlet;

import ax.hrms.project.web.constants.AxHrmsProjectWebPortletKeys;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.Portlet;

import org.osgi.service.component.annotations.Component;

/**
 * @author keval.kathiriya
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=AX HRMS",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.header-portlet-javascript=/js/ax-hrms-project-web/jquery.js",
		"com.liferay.portlet.header-portlet-javascript=/js/ax-hrms-project-web/jquery.validate.min.js",
		"com.liferay.portlet.header-portlet-javascript=/js/ax-hrms-project-web/main.js",

		"com.liferay.portlet.instanceable=false",
		"javax.portlet.display-name=AxHrmsProjectWeb",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + AxHrmsProjectWebPortletKeys.AXHRMSPROJECTWEB,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class AxHrmsProjectWebPortlet extends MVCPortlet {
}