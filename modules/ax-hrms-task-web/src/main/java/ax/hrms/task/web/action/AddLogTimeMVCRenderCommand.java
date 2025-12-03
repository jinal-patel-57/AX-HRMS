package ax.hrms.task.web.action;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.ax.hrms.common.api.api.AxHrmsCommonApi;
import com.ax.hrms.model.Attachment;
import com.ax.hrms.model.Task;
import com.ax.hrms.model.TimeTracker;
import com.ax.hrms.service.AttachmentLocalService;
import com.ax.hrms.service.EmployeeDetailsLocalService;
import com.ax.hrms.service.ProjectLocalService;
import com.ax.hrms.service.TaskLocalService;
import com.ax.hrms.service.TaskReviewLocalService;
import com.ax.hrms.service.TimeTrackerLocalService;
import com.liferay.document.library.kernel.service.DLAppLocalServiceUtil;
import com.liferay.document.library.kernel.util.DLUtil;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import ax.hrms.task.web.constants.AxHrmsTaskWebConstants;
import ax.hrms.task.web.constants.AxHrmsTaskWebPortletKeys;
import ax.hrms.task.web.dto.TaskDto;
import ax.hrms.task.web.util.TaskWebUtil;

@Component(immediate = true, property = {
		"javax.portlet.name=" + AxHrmsTaskWebPortletKeys.AXHRMSTASKWEB ,
		"mvc.command.name="+AxHrmsTaskWebConstants.ADD_LOG_TIME}, service = MVCRenderCommand.class)


public class AddLogTimeMVCRenderCommand implements MVCRenderCommand{
	private static final Log log = LogFactoryUtil.getLog(AddLogTimeMVCRenderCommand.class);

	
	
	@Reference
	private TaskLocalService taskLocalService;
	
	@Reference
	private AxHrmsCommonApi axHrmsCommonApi;
	
	@Reference
	private TimeTrackerLocalService timeTrackerLocalService;
	
	@Reference
	private AttachmentLocalService attachmentLocalService;
	@Reference
	private EmployeeDetailsLocalService employeeDetailsLocalService;
	
	@Reference
	private ProjectLocalService projectLocalService;
	
	@Reference
	private TaskReviewLocalService taskReviewLocalService;
	
	
	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse)  {
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long taskId = ParamUtil.getLong(renderRequest,AxHrmsTaskWebConstants.TASK_ID);
		long timeTrackerId = ParamUtil.getLong(renderRequest,AxHrmsTaskWebConstants.TIME_TRACKER_ID);
		
		try {
			if(Validator.isNotNull(timeTrackerId)) {
				TimeTracker timeTracker = timeTrackerLocalService.getTimeTracker(timeTrackerId);
				TaskWebUtil taskWebUtil = new TaskWebUtil(employeeDetailsLocalService, axHrmsCommonApi, projectLocalService, taskLocalService, taskReviewLocalService, timeTrackerLocalService, attachmentLocalService);
				renderRequest.setAttribute(AxHrmsTaskWebConstants.TIME_TRACKER_DTO, taskWebUtil.convertTimeTrackerDataIntoDto(timeTracker,themeDisplay));
				renderRequest.setAttribute(AxHrmsTaskWebConstants.FILE_LIST,getAttachments(timeTrackerId,themeDisplay));
				
			}
			else {	
			Task task = taskLocalService.getTask(taskId);
			renderRequest.setAttribute(AxHrmsTaskWebConstants.TASK, task);
			}
			boolean isManager = axHrmsCommonApi.isRolePerson(themeDisplay, AxHrmsTaskWebConstants.MANAGER);
			renderRequest.setAttribute(AxHrmsTaskWebConstants.IS_MANAGER, isManager);
		} catch (Exception e) {
			e.printStackTrace();
			log.error("AddLogTimeMVCRenderCommand >>> Render >>> "+ e.getMessage());
		}
		
		return AxHrmsTaskWebConstants.ADD_LOG_TIME_JSP;
	}

	
	private List<TaskDto> getAttachments(long timeTrackerId,ThemeDisplay themeDisplay) throws PortalException{
		List<Attachment> attachmentList = attachmentLocalService.findByTimeTrackerId(timeTrackerId);
		List<TaskDto> fileList= new ArrayList<>();
		for(Attachment attachment : attachmentList) {
			TaskDto fileDto = new TaskDto();
			FileEntry file = DLAppLocalServiceUtil.getFileEntry(attachment.getAttachmentId());
	
			String previewURL = DLUtil.getPreviewURL(file, file.getFileVersion(), themeDisplay,StringPool.BLANK);

			fileDto.setFile(file);
			fileDto.setPreviewURL(previewURL);
			
			fileList.add(fileDto);
		}
		return fileList;
		
	}
}
