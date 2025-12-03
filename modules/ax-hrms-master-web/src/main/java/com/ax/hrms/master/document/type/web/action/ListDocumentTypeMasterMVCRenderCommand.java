package com.ax.hrms.master.document.type.web.action;

import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.ax.hrms.master.model.DocumentTypeMaster;
import com.ax.hrms.master.service.DocumentTypeMasterLocalService;
import com.ax.hrms.master.web.constants.AxDocumentTypeMasterWebPortletConstants;
import com.ax.hrms.master.web.constants.AxDocumentTypeMasterWebPortletKeys;
import com.liferay.portal.kernel.dao.search.SearchContainer;
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
		"mvc.command.name="+AxDocumentTypeMasterWebPortletConstants.DEFAULT_PATH }, service = MVCRenderCommand.class)


public class ListDocumentTypeMasterMVCRenderCommand implements MVCRenderCommand {

	private static final Log log = LogFactoryUtil.getLog(ListDocumentTypeMasterMVCRenderCommand.class);
	@Reference
	DocumentTypeMasterLocalService documentTypeMasterLocalService;
	
	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		
	
			
			
		
		List<DocumentTypeMaster> documentTypeList = null;
		documentTypeList = documentTypeMasterLocalService.getDocumentTypeMasters(-1, -1);
				renderRequest.setAttribute(AxDocumentTypeMasterWebPortletConstants.DOCUMENT_TYPE_LIST, documentTypeList);

				int curValue = ParamUtil.getInteger(renderRequest,SearchContainer.DEFAULT_CUR_PARAM,1);
				int deltaValue = ParamUtil.getInteger(renderRequest, SearchContainer.DEFAULT_DELTA_PARAM,3);
				
				int totalOfDocumentTypeMaster = documentTypeMasterLocalService.getDocumentTypeMastersCount();
			    int totalPageContainer = (totalOfDocumentTypeMaster + deltaValue - 1) / deltaValue;
			    
			    if (curValue > totalPageContainer) {
			        curValue = totalPageContainer;
			    }
				
				int start = (curValue - 1) * deltaValue;
			    int end = start + deltaValue;
						
				log.info("ListDocumentTypeMasterMVCRenderCommand >>> render ::: ListDocumentTypeMasterMVCRenderCommand Default List render");
					
				documentTypeList = documentTypeMasterLocalService.getDocumentTypeMasters(start, end);
				renderRequest.setAttribute(AxDocumentTypeMasterWebPortletConstants.TOTAL_DOCUMMENT_TYPE_MASTER, totalOfDocumentTypeMaster);
				renderRequest.setAttribute(SearchContainer.DEFAULT_DELTA_PARAM, deltaValue);
				renderRequest.setAttribute(AxDocumentTypeMasterWebPortletConstants.DOCUMENT_TYPE_LIST, documentTypeList);
				renderRequest.setAttribute(AxDocumentTypeMasterWebPortletConstants.ITERATOR_URL_VARIMPLE_NAME, renderResponse.createRenderURL());
		
		return AxDocumentTypeMasterWebPortletConstants.LIST_DOCUMENT_TYPE_MASTER_JSP;
	}

}
