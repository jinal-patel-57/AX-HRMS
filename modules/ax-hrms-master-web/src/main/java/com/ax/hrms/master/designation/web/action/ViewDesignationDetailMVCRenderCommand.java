package com.ax.hrms.master.designation.web.action;

import com.ax.hrms.master.model.DesignationMaster;
import com.ax.hrms.master.service.DesignationMasterLocalService;
import com.ax.hrms.master.web.constants.AxHrmsDesignationMasterWebPortletConstants;
import com.ax.hrms.master.web.constants.AxHrmsDesignationMasterWebPortletKeys;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.ParamUtil;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * 
 * @author krish.moradiya
 * @category Master Data : Designation Master Data Process like View detail of designation
 */
@Component(
	    immediate = true,
	    property = {
	    	"javax.portlet.name=" + AxHrmsDesignationMasterWebPortletKeys.AXHRMS_DESIGNATIONMASTER_WEB_PORTLET_KEY,
	 	    "mvc.command.name=/viewDesignationDetail"
	    },
	    service = MVCRenderCommand.class
	)
public class ViewDesignationDetailMVCRenderCommand implements MVCRenderCommand {

	
	private static Log log = LogFactoryUtil.getLog(ViewDesignationDetailMVCRenderCommand.class);
	
	@Reference
	private DesignationMasterLocalService designationMasterLocalService;
	
	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		long designationMasterId = ParamUtil.getLong(renderRequest, AxHrmsDesignationMasterWebPortletConstants.DESIGNATION_MASTER_ID_VAR, AxHrmsDesignationMasterWebPortletConstants.DEFAULT_LONG_VALUE);
		if(designationMasterId > 0) {
			try {					
				DesignationMaster designationMaster = designationMasterLocalService.getDesignationMaster(designationMasterId);
				renderRequest.setAttribute(AxHrmsDesignationMasterWebPortletConstants.DESIGNATION_MASTER_DATA_VAR, designationMaster);
			}catch(Exception e) {
				log.error("DesignationViewMVCRenderCommand >>> render ::: "+e.getMessage());
			}
		}
		return AxHrmsDesignationMasterWebPortletConstants.DESIGNATION_MASTER_DETAIL_JSP_PATH;
	}

}
