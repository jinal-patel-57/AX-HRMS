package com.ax.hrms.master.document.type.web.action;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.ax.hrms.master.model.DocumentTypeMaster;
import com.ax.hrms.master.service.DocumentTypeMasterLocalService;
import com.ax.hrms.master.web.constants.AxDocumentTypeMasterWebPortletConstants;
import com.ax.hrms.master.web.constants.AxDocumentTypeMasterWebPortletKeys;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.ParamUtil;

/**
 * 
 * @author keval.kathiriya
 *
 */
@Component(immediate = true, property = {

		"javax.portlet.name=" + AxDocumentTypeMasterWebPortletKeys.AXDOCUMENTTYPEMASTERWEB,
		"mvc.command.name="+ AxDocumentTypeMasterWebPortletConstants.VIEW_DOCUMENT_TYPE }, service = MVCRenderCommand.class)



public class ViewDocumentTypeMasterMVCRenderCommand implements MVCRenderCommand{
	private static final Log log = LogFactoryUtil.getLog(ViewDocumentTypeMasterMVCRenderCommand.class);

	
	@Reference
	DocumentTypeMasterLocalService documentTypeMasterLocalService;
	
	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		Long documentTypeMasterId = ParamUtil.getLong(renderRequest,AxDocumentTypeMasterWebPortletConstants.DOCUMENT_TYPE_MASTER_ID);
		try {
			DocumentTypeMaster documentTypeMaster = documentTypeMasterLocalService.getDocumentTypeMaster(documentTypeMasterId);
			renderRequest.setAttribute(AxDocumentTypeMasterWebPortletConstants.DOCUMENT_TYPE,documentTypeMaster);

		} catch (PortalException e) {
			log.error("ViewDocumentTypeMasterMVCRenderCommand >>>Render >>> Error in View Render Class .........................");
		}
		return AxDocumentTypeMasterWebPortletConstants.VIEW_DOCUMENT_TYPE_MASTER_JSP;
	}

}
