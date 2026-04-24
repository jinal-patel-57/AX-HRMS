package com.ax.hrms.login.override;

import com.liferay.portal.kernel.exception.NoSuchUserException;
import com.liferay.portal.kernel.exception.UserEmailAddressException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.kernel.model.CompanyConstants;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.service.UserLocalService;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
	immediate = true,
	property = {
		"javax.portlet.name=com_liferay_login_web_portlet_LoginPortlet",
		"mvc.command.name=/login/forgot_password",
		"service.ranking:Integer=100"
	},
	service = MVCActionCommand.class
)
public class ForgotPasswordMVCActionCommandOverride extends BaseMVCActionCommand {

	private static final String MVC_PATH = "mvcPath";
	private static final String FORGOT_PASSWORD_JSP = "/forgot_password.jsp";
	@Override
	protected void doProcessAction(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {
		hideDefaultErrorMessage(actionRequest);
		hideDefaultSuccessMessage(actionRequest);
		int step = ParamUtil.getInteger(actionRequest, "step", 1);

		// Only pre-validate on Step 1 (email input step)
		if (step == 1 && !validateUser(actionRequest, actionResponse)) {
			// Validation failed — error added to session, stay on forgot_password.jsp
			return;
		}

		// Delegate to Liferay's original ForgotPasswordMVCActionCommand
		forgotPasswordMVCActionCommand.processAction(actionRequest, actionResponse);
	}

	/**
	 * Validates that the submitted email/login belongs to an existing user.
	 * Returns true if valid (user exists), false if not (error added to session).
	 */
	private boolean validateUser(
			ActionRequest actionRequest,
			ActionResponse actionResponse) {

		ThemeDisplay themeDisplay =
				(ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);

		Company company = themeDisplay.getCompany();
		String authType = company.getAuthType();
		String login = ParamUtil.getString(actionRequest, "login");

		if (Validator.isNull(login)) {
			SessionErrors.add(
					actionRequest,
					UserEmailAddressException.MustNotBeNull.class);

			actionResponse.getRenderParameters().setValue(
					MVC_PATH,
					FORGOT_PASSWORD_JSP
			);

			return false;
		}

		User user = null;

		try {
			if (CompanyConstants.AUTH_TYPE_EA.equals(authType)) {

				user = userLocalService.fetchUserByEmailAddress(
						company.getCompanyId(), login);

			} else if (CompanyConstants.AUTH_TYPE_SN.equals(authType)) {

				user = userLocalService.fetchUserByScreenName(
						company.getCompanyId(), login);

			} else if (CompanyConstants.AUTH_TYPE_ID.equals(authType)) {

				long userId = Long.parseLong(login);
				user = userLocalService.fetchUser(userId);
			}

		} catch (NumberFormatException e) {

			_log.warn("Invalid login format: " + login, e);

			SessionErrors.add(
					actionRequest,
					NoSuchUserException.class);

			actionResponse.getRenderParameters().setValue(
					MVC_PATH,
					FORGOT_PASSWORD_JSP
			);

			return false;
		}

		if (user == null) {

			_log.info("No user found for login: " + login);

			SessionErrors.add(
					actionRequest,
					NoSuchUserException.class);


			actionResponse.getRenderParameters().setValue(
					MVC_PATH,
					FORGOT_PASSWORD_JSP
			);

			return false;
		}

		return true;
	}

	private static final Log _log = LogFactoryUtil.getLog(
		ForgotPasswordMVCActionCommandOverride.class);

	@Reference(
		target = "(component.name=com.liferay.login.web.internal.portlet.action.ForgotPasswordMVCActionCommand)"
	)
	private MVCActionCommand forgotPasswordMVCActionCommand;

	@Reference
	private UserLocalService userLocalService;

}
