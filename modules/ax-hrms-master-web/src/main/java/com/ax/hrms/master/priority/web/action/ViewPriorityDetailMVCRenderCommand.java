package com.ax.hrms.master.priority.web.action;

import com.ax.hrms.master.model. PriorityMaster;
import com.ax.hrms.master.service. PriorityMasterLocalService;
import com.ax.hrms.master.web.constants.AxHrmsPriorityMasterWebPortletConstants;
import com.ax.hrms.master.web.constants.AxHrmsMasterWebPortletKeys;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

/**
 * 
 * @author krish.moradiya
 * @category Master Table : Priority for view priority details
 */
@Component(
	    immediate = true,
	    property = {
	    	"javax.portlet.name=" + AxHrmsMasterWebPortletKeys.AXHRMS_PRIORITY_MASTER_WEB_PORTLET_KEYS,
	 	    "mvc.command.name=/viewPriorityDetail"
	    },
	    service = MVCRenderCommand.class
	)
public class ViewPriorityDetailMVCRenderCommand implements MVCRenderCommand {

	
	private static Log log = LogFactoryUtil.getLog(ViewPriorityDetailMVCRenderCommand.class);
	
	@Reference
	private  PriorityMasterLocalService  priorityMasterLocalService;
	
	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		long  priorityMasterId = ParamUtil.getLong(renderRequest, AxHrmsPriorityMasterWebPortletConstants.PRIORITY_MASTER_ID_VAR, AxHrmsPriorityMasterWebPortletConstants.DEFAULT_LONG_VALUE);
		if( priorityMasterId > 0) {
			try {					
				PriorityMaster priorityMaster =  priorityMasterLocalService.getPriorityMaster(priorityMasterId);
				renderRequest.setAttribute(AxHrmsPriorityMasterWebPortletConstants.PRIORITY_MASTER_DATA_ATTRIBUTE_NAME,  priorityMaster);
			}catch(Exception e) {
				log.error("ViewPriorityDetailMVCRenderCommand >>> render ::: "+e.getMessage());
			}
		}
		return AxHrmsPriorityMasterWebPortletConstants.VIEW_PRIORITY_MASTER_JSP_PATH;
	}

}
