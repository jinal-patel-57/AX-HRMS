package ax.hrms.task.web.action;

import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.ax.hrms.common.api.api.AxHrmsCommonApi;
import com.ax.hrms.master.service.PriorityMasterLocalService;
import com.ax.hrms.master.service.ProjectTaskStatusMasterLocalService;
import com.ax.hrms.model.TaskReview;
import com.ax.hrms.service.EmployeeDetailsLocalService;
import com.ax.hrms.service.ProjectEmployeeDetailsLocalService;
import com.ax.hrms.service.ProjectLocalService;
import com.ax.hrms.service.TaskLocalService;
import com.ax.hrms.service.TaskReviewLocalService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.ParamUtil;

import ax.hrms.task.web.constants.AxHrmsTaskWebConstants;
import ax.hrms.task.web.constants.AxHrmsTaskWebPortletKeys;
import ax.hrms.task.web.dto.TaskDto;
import ax.hrms.task.web.util.TaskWebUtil;

@Component(immediate = true, property = {
		"javax.portlet.name=" + AxHrmsTaskWebPortletKeys.AXHRMSTASKWEB ,
		"mvc.command.name="+AxHrmsTaskWebConstants.FETCH_TASK_DETAILS}, service = MVCRenderCommand.class)

public class FetchTaskDataMVCRenderCommand implements MVCRenderCommand{
	private static final Log log = LogFactoryUtil.getLog(FetchTaskDataMVCRenderCommand.class);

	@Reference
	private PriorityMasterLocalService priorityMasterLocalService;
	
	@Reference
	private TaskLocalService taskLocalService;
	
	@Reference
	private ProjectTaskStatusMasterLocalService projectTaskStatusMasterLocalService;
	@Reference
	private AxHrmsCommonApi axHrmsCommonApi;
	
	@Reference
	private EmployeeDetailsLocalService employeeDetailsLocalService;
	@Reference
	private ProjectLocalService projectLocalService;
	@Reference
	private ProjectEmployeeDetailsLocalService projectEmployeeDetailsLocalService;
	
	@Reference
	private TaskReviewLocalService taskReviewLocalService;

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {

		
		try {
		long taskId = ParamUtil.getLong(renderRequest,AxHrmsTaskWebConstants.TASK_ID);
		TaskWebUtil taskWebUtil = new TaskWebUtil(employeeDetailsLocalService, projectEmployeeDetailsLocalService, axHrmsCommonApi, projectLocalService, taskLocalService, projectTaskStatusMasterLocalService, priorityMasterLocalService);
		TaskDto taskDto;

			List<TaskReview> taskReviewList = taskReviewLocalService.findByTaskId(taskId);
			renderRequest.setAttribute(AxHrmsTaskWebConstants.REVIEW_LIST,taskReviewList);
			taskDto = taskWebUtil.getTaskData(taskId,false);
			renderRequest.setAttribute(AxHrmsTaskWebConstants.TASK_DTO,taskDto);
		
		} catch (PortalException e) {
			log.error("FetchTaskDataMVCRenderCommand >>> Render >>> "+ e.getMessage());
		}
		
		
		return AxHrmsTaskWebConstants.VIEW_TASK_JSP;
	}
	

}
