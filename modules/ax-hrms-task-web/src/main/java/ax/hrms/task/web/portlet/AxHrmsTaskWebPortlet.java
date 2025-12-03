package ax.hrms.task.web.portlet;

import ax.hrms.task.web.constants.AxHrmsTaskWebConstants;
import ax.hrms.task.web.constants.AxHrmsTaskWebPortletKeys;

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
		"com.liferay.portlet.header-portlet-javascript=/js/ax-hrms-task-web/jquery.js",
		"com.liferay.portlet.header-portlet-javascript=/js/ax-hrms-task-web/jquery.validate.min.js",
		"com.liferay.portlet.header-portlet-javascript=/js/ax-hrms-task-web/main.js",
		"com.liferay.portlet.instanceable=false",
		"javax.portlet.display-name=Ax Hrms Task Web",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template="+AxHrmsTaskWebConstants.LIST_TASK_JSP,
		"javax.portlet.name=" + AxHrmsTaskWebPortletKeys.AXHRMSTASKWEB,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class AxHrmsTaskWebPortlet extends MVCPortlet {
}