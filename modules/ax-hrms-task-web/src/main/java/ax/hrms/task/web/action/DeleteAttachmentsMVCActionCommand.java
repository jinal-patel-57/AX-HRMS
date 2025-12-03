package ax.hrms.task.web.action;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.ax.hrms.service.AttachmentLocalService;
import com.liferay.document.library.kernel.service.DLAppLocalServiceUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;

import ax.hrms.task.web.constants.AxHrmsTaskWebConstants;
import ax.hrms.task.web.constants.AxHrmsTaskWebPortletKeys;

@Component(immediate = true, property = { "javax.portlet.name=" + AxHrmsTaskWebPortletKeys.AXHRMSTASKWEB,
"mvc.command.name="+AxHrmsTaskWebConstants.DELETE_ATTACHMENT}, service = MVCActionCommand.class)


public class DeleteAttachmentsMVCActionCommand extends BaseMVCActionCommand {
	private static final Log log = LogFactoryUtil.getLog(DeleteAttachmentsMVCActionCommand.class);

	@Reference
	AttachmentLocalService attachmentLocalService;

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		super.hideDefaultErrorMessage(actionRequest);
		super.hideDefaultSuccessMessage(actionRequest);
		try {
		long attachmentId = ParamUtil.getLong(actionRequest,AxHrmsTaskWebConstants.ATTACHMENT_ID);
		
		DLAppLocalServiceUtil.deleteFileEntry(attachmentId);
		attachmentLocalService.deleteAttachment(attachmentId);
		
		SessionMessages.add(actionRequest,AxHrmsTaskWebConstants.ATTACHMENT_DELETED_KEY);
		}catch(Exception e) {
			SessionErrors.add(actionRequest, AxHrmsTaskWebConstants.ERROR_KEY);
			log.error("DeleteAttachmentsMVCActionCommand >>> "+ e.getMessage());
		}
		actionResponse.sendRedirect(ParamUtil.getString(actionRequest,AxHrmsTaskWebConstants.BACKURL));
	}
	

}
