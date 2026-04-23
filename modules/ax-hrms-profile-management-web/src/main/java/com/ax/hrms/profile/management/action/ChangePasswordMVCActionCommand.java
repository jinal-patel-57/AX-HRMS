package com.ax.hrms.profile.management.action;

import com.ax.hrms.profile.management.constants.AxHrmsProfileManagementWebConstants;
import com.ax.hrms.profile.management.constants.AxHrmsProfileManagementWebPortletKeys;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.UserPasswordException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.security.auth.Authenticator;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.security.auth.session.AuthenticatedSessionManagerUtil;
import org.osgi.service.component.annotations.Component;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Collections;
import java.util.HashMap;

@Component(
        immediate = true,
        property = {
                "javax.portlet.name=" + AxHrmsProfileManagementWebPortletKeys.AXHRMSPROFILEMANAGEMENTWEB,
                "mvc.command.name=" + AxHrmsProfileManagementWebConstants.CHANGE_PASSWORD_MVC_COMMAND_NAME
        },
        service = MVCActionCommand.class
)
public class ChangePasswordMVCActionCommand extends BaseMVCActionCommand {

    private static final Log log = LogFactoryUtil.getLog(ChangePasswordMVCActionCommand.class);

    @Override
    protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) {
        ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);

        actionResponse.getRenderParameters().setValue(
                "mvcRenderCommandName",
                AxHrmsProfileManagementWebConstants.CHANGE_PASSWORD_JSP_FILE
        );

        String currentPassword = ParamUtil.getString(
                actionRequest, AxHrmsProfileManagementWebConstants.CURRENT_PASSWORD);
        String newPassword = ParamUtil.getString(
                actionRequest, AxHrmsProfileManagementWebConstants.NEW_PASSWORD);
        String confirmPassword = ParamUtil.getString(
                actionRequest, AxHrmsProfileManagementWebConstants.CONFIRM_PASSWORD);

        if (Validator.isBlank(currentPassword) || Validator.isBlank(newPassword) || Validator.isBlank(confirmPassword)) {
            SessionErrors.add(
                    actionRequest, AxHrmsProfileManagementWebConstants.PASSWORD_CHANGE_EMPTY_FIELDS_ERROR_KEY);
            return;
        }

        if (!newPassword.equals(confirmPassword)) {
            SessionErrors.add(
                    actionRequest, AxHrmsProfileManagementWebConstants.PASSWORD_CHANGE_MISMATCH_ERROR_KEY);
            return;
        }

        try {
            User user = themeDisplay.getUser();

            int authResult = UserLocalServiceUtil.authenticateByUserId(
                    themeDisplay.getCompanyId(), user.getUserId(), currentPassword,
                    Collections.emptyMap(), Collections.emptyMap(), new HashMap<>());

            if (authResult != Authenticator.SUCCESS) {
                SessionErrors.add(
                        actionRequest,
                        AxHrmsProfileManagementWebConstants.PASSWORD_CHANGE_CURRENT_PASSWORD_INVALID_ERROR_KEY);
                return;
            }

            UserLocalServiceUtil.updatePassword(user.getUserId(), newPassword, confirmPassword, false);

            SessionMessages.add(
                    actionRequest, AxHrmsProfileManagementWebConstants.PASSWORD_UPDATE_SUCCESS_MESSAGE_KEY);
            actionResponse.getRenderParameters().setValue(
                    "passwordChanged",
                    Boolean.TRUE.toString()
            );
            HttpServletRequest httpServletRequest = PortalUtil.getHttpServletRequest(actionRequest);
            HttpServletResponse httpServletResponse = PortalUtil.getHttpServletResponse(actionResponse);

            AuthenticatedSessionManagerUtil.logout(httpServletRequest,httpServletResponse);
        }
        catch (UserPasswordException userPasswordException) {
            log.error("ChangePasswordMVCActionCommand >>> UserPasswordException ::: " + userPasswordException.getClass().getName() + " :: " + userPasswordException.getMessage(), userPasswordException);
            SessionErrors.add(actionRequest, userPasswordException.getClass(), userPasswordException);
        }
        catch (PortalException portalException) {
            log.error("Unable to update password for user " + themeDisplay.getUserId(), portalException);
            SessionErrors.add(
                    actionRequest, AxHrmsProfileManagementWebConstants.PASSWORD_CHANGE_UPDATE_FAILED_ERROR_KEY);
        } catch (Exception e) {
            log.error("Error occurred while changing password ::: " + e);
        }
    }
}
