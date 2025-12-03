package com.ax.hrms.master.designation.web.action;

import com.ax.hrms.master.model.DesignationMaster;
import com.ax.hrms.master.service.DesignationMasterLocalService;
import com.ax.hrms.master.web.constants.AxHrmsDesignationMasterWebPortletConstants;
import com.ax.hrms.master.web.constants.AxHrmsDesignationMasterWebPortletKeys;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.ParamUtil;

import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;


/**
 * 
 * @author krish.moradiya
 * @category Master Data : Designation Master Data Process like Render search container list of all Designation master
 */
@Component(
	    immediate = true,
	    property = {
	       "javax.portlet.name=" + AxHrmsDesignationMasterWebPortletKeys.AXHRMS_DESIGNATIONMASTER_WEB_PORTLET_KEY,
	       "mvc.command.name="+ AxHrmsDesignationMasterWebPortletConstants.DEFAULT_PATH
	    },
	    service = MVCRenderCommand.class
	)
public class ListDesignationMasterMVCRenderCommand implements MVCRenderCommand{
	
	private static final Log log = LogFactoryUtil.getLog(ListDesignationMasterMVCRenderCommand.class);
	
	@Reference
	DesignationMasterLocalService designationMasterLocalService;
	

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {

		List<DesignationMaster> designationMasterList = null;
		
		int curValue = ParamUtil.getInteger(renderRequest,SearchContainer.DEFAULT_CUR_PARAM,1);
		int deltaValue = ParamUtil.getInteger(renderRequest, SearchContainer.DEFAULT_DELTA_PARAM,3);
		
		int totalOfDesignationMaster = designationMasterLocalService.getDesignationMastersCount();
	    int totalPageContainer = (totalOfDesignationMaster + deltaValue - 1) / deltaValue;
	    
	    if (curValue > totalPageContainer) {
	        curValue = totalPageContainer;
	    }
		
		int start = (curValue - 1) * deltaValue;
	    int end = start + deltaValue;
				
		log.info("DesignationViewMVCRenderCommand >>> render ::: Designation Master Default List render");
			
		designationMasterList = designationMasterLocalService.getDesignationMasters(start, end);
		renderRequest.setAttribute(AxHrmsDesignationMasterWebPortletConstants.TOTAL_DESIGNATION_MASTER_ATTRIBUTE_NAME, totalOfDesignationMaster);
		renderRequest.setAttribute(SearchContainer.DEFAULT_DELTA_PARAM, deltaValue);
		renderRequest.setAttribute(AxHrmsDesignationMasterWebPortletConstants.DESIGNATION_LIST_VAR, designationMasterList);
		renderRequest.setAttribute(AxHrmsDesignationMasterWebPortletConstants.ITERATOR_URL_VARIMPLE_NAME, renderResponse.createRenderURL());
		    
		return AxHrmsDesignationMasterWebPortletConstants.DESIGNATION_MASTER_LIST_JSP_PATH;
	}
}
