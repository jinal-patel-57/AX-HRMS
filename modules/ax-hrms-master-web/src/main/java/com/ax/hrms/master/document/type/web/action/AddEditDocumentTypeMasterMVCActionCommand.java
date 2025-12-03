package com.ax.hrms.master.document.type.web.action;

import java.util.Date;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.ax.hrms.master.model.DocumentTypeMaster;
import com.ax.hrms.master.service.DocumentTypeMasterLocalService;
import com.ax.hrms.master.web.constants.AxDocumentTypeMasterWebPortletConstants;
import com.ax.hrms.master.web.constants.AxDocumentTypeMasterWebPortletKeys;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
/**
 * 
 * @author keval.kathiriya
 *
 */
@Component(immediate = true, property = {

		"javax.portlet.name=" + AxDocumentTypeMasterWebPortletKeys.AXDOCUMENTTYPEMASTERWEB,
		"mvc.command.name="
				+ AxDocumentTypeMasterWebPortletConstants.ADD_EDIT_DOCUMENT_TYPE_ACTION }, service = MVCActionCommand.class)

public class AddEditDocumentTypeMasterMVCActionCommand extends BaseMVCActionCommand {
	private static final Log log = LogFactoryUtil.getLog(AddEditDocumentTypeMasterMVCActionCommand.class);

	@Reference
	DocumentTypeMasterLocalService documentTypeMasterLocalService;

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		
	
		
		super.hideDefaultErrorMessage(actionRequest);
		super.hideDefaultSuccessMessage(actionRequest);

		Long documentTypeMasterId = ParamUtil.getLong(actionRequest,
				AxDocumentTypeMasterWebPortletConstants.DOCUMENT_TYPE_MASTER_ID);

		DocumentTypeMaster documentTypeMaster = setDocumentTypeMasterData(actionRequest, documentTypeMasterId);
		
		if(Validator.isNotNull(documentTypeMasterId))
			editDocumentTypeMasterData(actionRequest, actionResponse, documentTypeMaster);
		else
			addDocumentTypeMasterData(actionRequest, actionResponse, documentTypeMaster);
		

		
		
		
		
		
	}

	private void addDocumentTypeMasterData(ActionRequest actionRequest,ActionResponse actionResponse,DocumentTypeMaster documentTypeMaster) {
		if (!Validator.isBlank(documentTypeMaster.getDocumentTypeName())) {
			try{
				if (!documentTypeMasterLocalService.isDocumentTypeNameExists(documentTypeMaster.getDocumentTypeName())) {
					documentTypeMasterLocalService.addDocumentTypeMaster(documentTypeMaster);
					SessionMessages.add(actionRequest, AxDocumentTypeMasterWebPortletConstants.DOCUMENT_TYPE_ADD_MESSAGE);
				} else {
					log.info("AddEditDocumentTypeMasterMVCActionCommand >>> addDocumentTypeMasterData ::: Documnet Type Name Already exists.");
					actionRequest.setAttribute(AxDocumentTypeMasterWebPortletConstants.EXISTED_DOCUMENT_TYPE_MASTER_ATTRIBUTE_NAME, documentTypeMaster);
					SessionErrors.add(actionRequest, AxDocumentTypeMasterWebPortletConstants.DOCUMENT_TYPE_DUPLICATION_MESSAGE);
					actionResponse.setRenderParameter(AxDocumentTypeMasterWebPortletConstants.MVC_PATH_PARAMETER, AxDocumentTypeMasterWebPortletConstants.ADD_EDIT_DOCUMENT_TYPE_MASTER_JSP);
				}
			}catch (Exception e) {
				log.error("AddEditDocumentTypeMasterMVCActionCommand >>> addDocumentTypeMasterData ::: Something went Wrong : " + e.getMessage());
				SessionErrors.add(actionRequest, AxDocumentTypeMasterWebPortletConstants.SOMETHING_WENT_WRONG_MESSAGE_KEY);
				actionResponse.setRenderParameter(AxDocumentTypeMasterWebPortletConstants.MVC_PATH_PARAMETER, AxDocumentTypeMasterWebPortletConstants.ADD_EDIT_DOCUMENT_TYPE_MASTER_JSP);
			}
		}
	}
	
	
	private void editDocumentTypeMasterData(ActionRequest actionRequest,ActionResponse actionResponse, DocumentTypeMaster documentTypeMaster) {
		if (!Validator.isBlank(documentTypeMaster.getDocumentTypeName())) {
			try{
				if (!documentTypeMasterLocalService.isDocumentTypeNameExists(documentTypeMaster.getDocumentTypeName())) {
					SessionMessages.add(actionRequest, AxDocumentTypeMasterWebPortletConstants.DOCUMENT_TYPE_UPDATE_MESSAGE);
					documentTypeMasterLocalService.updateDocumentTypeMaster(documentTypeMaster);
				} else if (documentTypeMasterLocalService.getDocumentTypeMasterIdByName(documentTypeMaster.getDocumentTypeName()) == documentTypeMaster.getDocumentTypeMasterId()) {
					documentTypeMasterLocalService.updateDocumentTypeMaster(documentTypeMaster);
					SessionMessages.add(actionRequest, AxDocumentTypeMasterWebPortletConstants.DOCUMENT_TYPE_UPDATE_MESSAGE);
				} else {
					log.info("AddEditDocumentTypeMasterMVCActionCommand >>> edit DocumentTypeMasterData ::: Document Type Name Already exists.");
					actionRequest.setAttribute(AxDocumentTypeMasterWebPortletConstants.EXISTED_DOCUMENT_TYPE_MASTER_ATTRIBUTE_NAME, documentTypeMaster);
					actionRequest.setAttribute(AxDocumentTypeMasterWebPortletConstants.DOCUMENT_TYPE_MASTER_ID, documentTypeMaster.getDocumentTypeMasterId());

					SessionErrors.add(actionRequest, AxDocumentTypeMasterWebPortletConstants.DOCUMENT_TYPE_DUPLICATION_MESSAGE);
					actionResponse.setRenderParameter(AxDocumentTypeMasterWebPortletConstants .MVC_PATH_PARAMETER, AxDocumentTypeMasterWebPortletConstants.ADD_EDIT_DOCUMENT_TYPE_MASTER_JSP);
				}
			}catch (Exception e) {
					log.error("AddEditDocumentTypeMasterMVCActionCommand >>> edit DocumentTypeMasterData ::: Something went Wrong : " + e.getMessage());
					SessionErrors.add(actionRequest,AxDocumentTypeMasterWebPortletConstants.SOMETHING_WENT_WRONG_MESSAGE_KEY);
					actionResponse.setRenderParameter(AxDocumentTypeMasterWebPortletConstants .MVC_PATH_PARAMETER, AxDocumentTypeMasterWebPortletConstants.ADD_EDIT_DOCUMENT_TYPE_MASTER_JSP);
			}
		}
	}
	
private DocumentTypeMaster setDocumentTypeMasterData(ActionRequest actionRequest, Long documentTypeMasterId) {
		
	DocumentTypeMaster documentTypeMaster = null;
	String documentTypeName = ParamUtil.getString(actionRequest,
			AxDocumentTypeMasterWebPortletConstants.DOCUMENT_TYPE_NAME);

	ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
	long companyId = themeDisplay.getCompanyId();
	long groupId = themeDisplay.getScopeGroupId();
	Date currentDate = new Date();
		if(Validator.isNotNull(documentTypeMasterId)) {
			try {
				documentTypeMaster = documentTypeMasterLocalService.getDocumentTypeMaster(documentTypeMasterId);
			} catch (PortalException e) {
				log.error("AddEditDocumentTypeMasterMVCActionCommand >>> setDocumentTypeMasterData (MVCActionCommand) ::: Exception is: "+e.getMessage());
			}
		}
		else {
			documentTypeMaster = documentTypeMasterLocalService.createDocumentTypeMaster(CounterLocalServiceUtil.increment(DocumentTypeMaster.class.getName()));
			documentTypeMaster.setCreatedBy(themeDisplay.getUserId());
		}

		try{
			documentTypeMaster.setDocumentTypeName(documentTypeName);
			documentTypeMaster.setCompanyId(companyId);
			documentTypeMaster.setCreateDate(currentDate);
			documentTypeMaster.setDocumentTypeMasterId(documentTypeMaster.getDocumentTypeMasterId());
			documentTypeMaster.setModifiedDate(currentDate);
			documentTypeMaster.setGroupId(groupId);
		}catch (Exception e){
			log.error("AddEditDocumentTypeMasterMVCActionCommand >>> setDocumentTypeMasterData (MVCActionCommand) ::: Exception is: "+e.getMessage());
		}
		return documentTypeMaster;
	}

}
