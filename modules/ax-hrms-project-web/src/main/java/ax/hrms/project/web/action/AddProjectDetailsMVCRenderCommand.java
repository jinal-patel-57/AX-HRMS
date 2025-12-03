package ax.hrms.project.web.action;

import java.util.List;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.ax.hrms.common.api.api.AxHrmsCommonApi;
import com.ax.hrms.master.model.ProjectTaskStatusMaster;
import com.ax.hrms.master.service.ProjectTaskStatusMasterLocalService;
import com.ax.hrms.model.EmployeeDetails;
import com.ax.hrms.service.EmployeeDetailsLocalService;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;

import ax.hrms.project.web.constants.AxHrmsProjectWebConstants;
import ax.hrms.project.web.constants.AxHrmsProjectWebPortletKeys;

@Component(immediate = true, property = {
		"javax.portlet.name=" + AxHrmsProjectWebPortletKeys.AXHRMSPROJECTWEB,
		"mvc.command.name="+AxHrmsProjectWebConstants.ADD_PROJECT}, service = MVCRenderCommand.class)

public class AddProjectDetailsMVCRenderCommand implements MVCRenderCommand {
	private static final Log log = LogFactoryUtil.getLog(AddProjectDetailsMVCRenderCommand.class);

	@Reference
	private ProjectTaskStatusMasterLocalService projectTaskStatusMasterLocalService;
	
	@Reference
	private EmployeeDetailsLocalService employeeDetailsLocalService;
	@Reference
	private AxHrmsCommonApi axHrmsCommonApi;
	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse)  {
		try {
			List<EmployeeDetails> employeeList  = employeeDetailsLocalService.findByIsTerminated(false);
		List<ProjectTaskStatusMaster> statusList = projectTaskStatusMasterLocalService.getProjectTaskStatusMasters(-1,-1);
		
		
		
		renderRequest.setAttribute(AxHrmsProjectWebConstants.EMPLOYEE_LIST, employeeList);
		renderRequest.setAttribute(AxHrmsProjectWebConstants.STATUS_LIST, statusList);
		}catch(Exception e) {
	log.error("AddProjectDetailsMVCRenderCommand >>> Render >> "+ e.getMessage());
		}

		return AxHrmsProjectWebConstants.ADD_PROJECT_DETAILS_JSP;
	}

}
