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
/**
 * 
 * @author keval.kathiriya
 *
 */
import com.liferay.portal.kernel.util.ParamUtil;

@Component(immediate = true, property = {

		"javax.portlet.name=" + AxDocumentTypeMasterWebPortletKeys.AXDOCUMENTTYPEMASTERWEB,
		"mvc.command.name="+AxDocumentTypeMasterWebPortletConstants.FETCH_DOCUMENT_TYPE_ACTION}, service = MVCRenderCommand.class)



public class FetchDocumentTypeMasterMVCRenderCommand implements MVCRenderCommand {
	
	private static final Log log = LogFactoryUtil.getLog(FetchDocumentTypeMasterMVCRenderCommand.class);


	@Reference
	DocumentTypeMasterLocalService documentTypeMasterLocalService;
	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
long documentTypeMasterId =ParamUtil.getLong(renderRequest, AxDocumentTypeMasterWebPortletConstants.DOCUMENT_TYPE_MASTER_ID);
		
		try {
			DocumentTypeMaster getDocumentTypeMaster=documentTypeMasterLocalService.getDocumentTypeMaster(documentTypeMasterId);
			renderRequest.setAttribute(AxDocumentTypeMasterWebPortletConstants.DOCUMENT_TYPE_MASTER_DATA, getDocumentTypeMaster);
			log.info("get Data : "+ getDocumentTypeMaster.getDocumentTypeName());
			log.info("FetchDocumentTypeMasterMVCRenderCommand <<< Render <<< Data Fetch Successfully !!!");
			
		} catch (PortalException e) {
			log.error("FetchDocumentTypeMasterMVCRenderCommand <<< Render <<< Error in fetching data...!!!"+e.getMessage());
		}
		
		return AxDocumentTypeMasterWebPortletConstants.ADD_EDIT_DOCUMENT_TYPE_MASTER_JSP;
	}
	}


