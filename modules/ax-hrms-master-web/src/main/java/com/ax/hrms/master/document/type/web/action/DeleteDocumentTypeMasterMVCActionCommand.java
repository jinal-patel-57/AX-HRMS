package com.ax.hrms.master.document.type.web.action;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.ax.hrms.master.service.DocumentTypeMasterLocalService;
import com.ax.hrms.master.web.constants.AxDocumentTypeMasterWebPortletConstants;
import com.ax.hrms.master.web.constants.AxDocumentTypeMasterWebPortletKeys;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;

/**
 * 
 * @author keval.kathiriya
 *
 */
@Component(
		immediate = true,
		property = {
		
			"javax.portlet.name=" + AxDocumentTypeMasterWebPortletKeys.AXDOCUMENTTYPEMASTERWEB,
			"mvc.command.name="+AxDocumentTypeMasterWebPortletConstants.DELETE_DOCUMENT_TYPE
		},
		service = MVCActionCommand.class
	)

public class DeleteDocumentTypeMasterMVCActionCommand extends BaseMVCActionCommand{
	@Reference
	DocumentTypeMasterLocalService documentTypeMasterLocalService;
	
	
	
	private static final Log log = LogFactoryUtil.getLog(DeleteDocumentTypeMasterMVCActionCommand.class);

	
	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		Long documentTypeMasterId = ParamUtil.getLong(actionRequest, AxDocumentTypeMasterWebPortletConstants.DOCUMENT_TYPE_MASTER_ID);
		try {
			documentTypeMasterLocalService.deleteDocumentTypeMaster(documentTypeMasterId);
		} catch (PortalException e) {
			log.error("DeleteDocumentTypeMasterMVCActionCommand >>> Action >>>Error in deleting the Document Type........................");
		
			
		}
		
		SessionMessages.add(actionRequest, AxDocumentTypeMasterWebPortletConstants.DOCUMENT_TYPE_DELETE_MESSAGE);


		actionResponse.sendRedirect(PortalUtil.getLayoutFullURL(themeDisplay));
	}
	

}
