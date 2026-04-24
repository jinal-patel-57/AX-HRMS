<%@ include file="/init.jsp"%>

<portlet:actionURL name="changePassword" var="changePasswordUrl" />
<portlet:renderURL var="profileViewURL">
    <portlet:param name="mvcRenderCommandName" value="/" />
</portlet:renderURL>

<%
java.util.Set<String> sessionMessageKeys =
        com.liferay.portal.kernel.servlet.SessionMessages.keySet(renderRequest);
java.util.Set<String> sessionErrorKeys =
        com.liferay.portal.kernel.servlet.SessionErrors.keySet(renderRequest);

request.setAttribute("passwordChangedParam", String.valueOf(request.getParameter("passwordChanged")));
request.setAttribute("sessionMessageKeys", sessionMessageKeys.toString());
request.setAttribute("sessionErrorKeys", sessionErrorKeys.toString());
%>

<div class="card mt-3">
    <div class="card-header">
        <strong>Change Password</strong>
    </div>

    <div class="card-body">

        <c:if test="${param.passwordChanged eq 'true'}">
            <div class="alert alert-success">
                Password changed successfully.
            </div>
        </c:if>

        <liferay-ui:success
            key="password-update-success-message"
            message="Password changed successfully" />

        <liferay-ui:error
            key="password-change-empty-fields"
            message="Please fill in all password fields" />

        <liferay-ui:error
            key="password-change-mismatch"
            message="New password and confirm password must match" />

        <liferay-ui:error
            key="password-change-current-password-invalid"
            message="Current password is incorrect" />

        <liferay-ui:error
            key="password-change-update-failed"
            message="Unable to update password right now" />

        <liferay-ui:error
            exception="<%= com.liferay.portal.kernel.exception.UserPasswordException.MustBeLonger.class %>"
            message="Your new password is too short. Please enter a longer password." />

        <liferay-ui:error
            exception="<%= com.liferay.portal.kernel.exception.UserPasswordException.MustMatch.class %>"
            message="New password and confirm password must match." />

        <liferay-ui:error
            exception="<%= com.liferay.portal.kernel.exception.UserPasswordException.MustHaveMoreNumbers.class %>"
            message="Your new password must contain more numeric characters." />

        <liferay-ui:error
            exception="<%= com.liferay.portal.kernel.exception.UserPasswordException.MustHaveMoreUppercase.class %>"
            message="Your new password must contain more uppercase letters." />

        <liferay-ui:error
            exception="<%= com.liferay.portal.kernel.exception.UserPasswordException.MustHaveMoreLowercase.class %>"
            message="Your new password must contain more lowercase letters." />

        <liferay-ui:error
            exception="<%= com.liferay.portal.kernel.exception.UserPasswordException.MustHaveMoreSymbols.class %>"
            message="Your new password must contain more special characters." />

        <liferay-ui:error
            exception="<%= com.liferay.portal.kernel.exception.UserPasswordException.MustHaveMoreAlphanumeric.class %>"
            message="Your new password must contain more letters or numbers." />

        <liferay-ui:error
            exception="<%= com.liferay.portal.kernel.exception.UserPasswordException.MustComplyWithRegex.class %>"
            message="Your new password does not match the required password format." />

        <liferay-ui:error
            exception="<%= com.liferay.portal.kernel.exception.UserPasswordException.MustComplyWithModelListeners.class %>"
            message="Your new password does not satisfy the configured password policy." />

        <liferay-ui:error
            exception="<%= com.liferay.portal.kernel.exception.UserPasswordException.MustNotBeEqualToCurrent.class %>"
            message="Your new password must be different from your current password." />

        <liferay-ui:error
            exception="<%= com.liferay.portal.kernel.exception.UserPasswordException.MustNotBeRecentlyUsed.class %>"
            message="You cannot reuse a recently used password." />

        <liferay-ui:error
            exception="<%= com.liferay.portal.kernel.exception.UserPasswordException.MustNotBeTrivial.class %>"
            message="Your new password is too easy to guess. Please choose a stronger password." />

        <liferay-ui:error
            exception="<%= com.liferay.portal.kernel.exception.UserPasswordException.MustNotContainDictionaryWords.class %>"
            message="Your new password cannot contain common dictionary words." />

        <liferay-ui:error
            exception="<%= com.liferay.portal.kernel.exception.UserPasswordException.MustNotBeChangedYet.class %>"
            message="Your password cannot be changed again yet. Please try later." />

        <liferay-ui:error
            exception="<%= com.liferay.portal.kernel.exception.UserPasswordException.MustNotBeChanged.class %>"
            message="Password change is not allowed for this account." />

        <liferay-ui:error
            exception="<%= com.liferay.portal.kernel.exception.UserPasswordException.MustMatchCurrentPassword.class %>"
            message="Current password validation failed. Please enter your correct current password." />

        <liferay-ui:error
            exception="<%= com.liferay.portal.kernel.exception.UserPasswordException.MustNotBeNull.class %>"
            message="Please enter a new password." />

        <liferay-ui:error
            exception="<%= com.liferay.portal.kernel.exception.UserPasswordException.class %>"
            message="Please enter a password that satisfies your password policy requirements." />

        <aui:form action="${changePasswordUrl}" data-senna="off" method="post" name="changePasswordFm">
            <div class="row">
                <div class="col-md-4 mb-3">
                    <label for="<portlet:namespace/>currentPassword" class="form-label">
                        Current Password <span class="text-danger">*</span>
                    </label>
                    <input type="password"
                           class="form-control"
                           id="<portlet:namespace/>currentPassword"
                           name="<portlet:namespace/>currentPassword" />
                </div>

                <div class="col-md-4 mb-3">
                    <label for="<portlet:namespace/>newPassword" class="form-label">
                        New Password <span class="text-danger">*</span>
                    </label>
                    <input type="password"
                           class="form-control"
                           id="<portlet:namespace/>newPassword"
                           name="<portlet:namespace/>newPassword" />
                </div>

                <div class="col-md-4 mb-3">
                    <label for="<portlet:namespace/>confirmPassword" class="form-label">
                        Confirm Password <span class="text-danger">*</span>
                    </label>
                    <input type="password"
                           class="form-control"
                           id="<portlet:namespace/>confirmPassword"
                           name="<portlet:namespace/>confirmPassword" />
                </div>
            </div>

            <div class="text-right">
                <a href="${profileViewURL}" class="btn btn-outline-danger mr-1">Back</a>
                <button type="submit" class="btn btn-outline-primary">Update Password</button>
            </div>
        </aui:form>
    </div>
</div>

<script>
    (function () {
        function hideGlobalLoader() {
            if (document.body) {
                document.body.classList.remove('page-loading');
            }

            var overlay = document.getElementById('overlay');

            if (overlay) {
                overlay.style.display = 'none';
            }
        }

        hideGlobalLoader();

        if (document.readyState === 'loading') {
            document.addEventListener('DOMContentLoaded', hideGlobalLoader);
        }

        window.addEventListener('load', hideGlobalLoader);
        window.addEventListener('pageshow', hideGlobalLoader);

        if (window.Liferay && typeof window.Liferay.on === 'function') {
            window.Liferay.on('allPortletsReady', hideGlobalLoader);
        }
    })();
</script>
