package com.ax.hrms.birthday.web.action;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.ax.hrms.birthday.web.util.BirthdayWebUtil;
import com.ax.hrms.common.api.api.AxHrmsCommonApi;
import com.ax.hrms.constants.AxHrmsBirthdayWebPortletConstants;
import com.ax.hrms.constants.AxHrmsBirthdayWebPortletKeys;
import com.ax.hrms.mail.template.config.configuration.MailTemplateConfiguration;
import com.ax.hrms.master.service.WishTypeMasterLocalService;
import com.ax.hrms.model.EmployeeDetails;
import com.ax.hrms.service.EmployeeDetailsLocalService;
import com.ax.hrms.service.EmployeeWishLocalService;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.PrefsPropsUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
/**
 * 
 * @author keval.kathiriya
 *
 */

@Component(immediate = true, property = {
		"javax.portlet.name=" + AxHrmsBirthdayWebPortletKeys.AXHRMSEMPLOYEEBIRTHDAYWEB,
		"mvc.command.name=" + AxHrmsBirthdayWebPortletConstants.SEND_WISHES }, service = MVCActionCommand.class)

public class SendWishesBirthdayEmployeeMVCActionCommand extends BaseMVCActionCommand {
	private static final Log log = LogFactoryUtil.getLog(SendWishesBirthdayEmployeeMVCActionCommand.class);

	@Reference
	MailTemplateConfiguration mailTemplateConfiguration;
	
	@Reference
	WishTypeMasterLocalService wishTypeMasterLocalService;

	@Reference
	EmployeeDetailsLocalService employeeDetailsLocalService;

	@Reference
	EmployeeWishLocalService employeeWishLocalService;

	@Reference
	AxHrmsCommonApi axHrmsCommonApi;

	
	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {

		super.hideDefaultErrorMessage(actionRequest);
		super.hideDefaultSuccessMessage(actionRequest);
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);

		try {
			long employeeId = ParamUtil.getLong(actionRequest, AxHrmsBirthdayWebPortletConstants.EMPLOYEE_ID);

			String wishes = ParamUtil.getString(actionRequest, AxHrmsBirthdayWebPortletConstants.WISHES);

			long userId = themeDisplay.getUserId();

			String fromName = PrefsPropsUtil.getString(themeDisplay.getCompanyId(), PropsKeys.ADMIN_EMAIL_FROM_NAME);
			String fromEmailAddress = PrefsPropsUtil.getString(themeDisplay.getCompanyId(),
					PropsKeys.ADMIN_EMAIL_FROM_ADDRESS);
			BirthdayWebUtil birthdayWebUtil = new BirthdayWebUtil(employeeDetailsLocalService, wishTypeMasterLocalService, employeeWishLocalService);

			EmployeeDetails birthdayPerson = employeeDetailsLocalService.findByEmployeeId(employeeId);
			EmployeeDetails user = employeeDetailsLocalService.findByLrUserId(userId);

			if (Validator.isNotNull(wishes)) {
				
				
				
				
				 String mailContent =  mailTemplateConfiguration.mailBirthdayWishBody();
	              mailContent =  mailContent.replace("${EMPLOYEE_NAME}", birthdayPerson.getFirstName()+StringPool.SPACE+birthdayPerson.getLastName());
	              mailContent = mailContent.replace("${SENDER_NAME}", user.getFirstName()+StringPool.SPACE+user.getLastName());
	              mailContent =  mailContent.replace("${WISH_BODY}", wishes);
	               
	               String subject = mailTemplateConfiguration.mailBirthdayWishSubject();
	                
				


				// send mail to birthday person
				axHrmsCommonApi.sendMail(birthdayPerson.getOfficialEmail(), fromEmailAddress, fromName, subject,
						mailContent);
				SessionMessages.add(actionRequest, AxHrmsBirthdayWebPortletConstants.SEND_WISHES_SUCCESSFULLY_MESSAGE);

				// store the data
				birthdayWebUtil.setDataWish(wishes, employeeId, themeDisplay);
			}
		} catch (Exception e) {
			log.error("Error >>> SendWishesBirthdayEmployeeMVCActionCommand " + e.getMessage());
			SessionErrors.add(actionRequest, AxHrmsBirthdayWebPortletConstants.ERROR_MESSAGE);

		}
		actionResponse.sendRedirect(PortalUtil.getLayoutFullURL(themeDisplay));

	}

	
}
