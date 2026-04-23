<%--
/**
 * SPDX-FileCopyrightText: (c) 2000 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */
--%>

<%@ include file="/init.jsp" %>

<%
User user2 = (User)request.getAttribute(WebKeys.FORGOT_PASSWORD_REMINDER_USER);

if (Validator.isNull(authType)) {
	authType = company.getAuthType();
}

String login = (String)portletSession.getAttribute(WebKeys.FORGOT_PASSWORD_REMINDER_USER_EMAIL_ADDRESS);

Integer reminderAttempts = (Integer)portletSession.getAttribute(WebKeys.FORGOT_PASSWORD_REMINDER_ATTEMPTS);

if (reminderAttempts == null) {
	reminderAttempts = 0;
}

renderResponse.setTitle(LanguageUtil.get(request, "forgot-password"));
%>

<link rel="stylesheet" href="<%= request.getContextPath() %>/css/login.css">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Open+Sans:ital,wght@0,300..800;1,300..800&display=swap" rel="stylesheet">

<div class="ax-login-page">
	<video autoplay loop muted playsinline class="ax-background-video">
		<source src="<%= request.getContextPath() %>/images/login-bg-video.mp4" type="video/mp4">
	</video>
	<div class="ax-video-overlay"></div>
	<div class="ax-login-wrapper">
		<div class="ax-login-card ax-universal-card">
			<div class="ax-login-right ax-universal-right">
				<div class="ax-logo-container ax-logo-centered">
                    <img src="<%= request.getContextPath() %>/images/logo-main.png" alt="AXSETU Logo">
					<p class="ax-logo-subtext">Password Recovery</p>
				</div>

				<portlet:actionURL name="/login/forgot_password" var="forgotPasswordURL">
					<portlet:param name="mvcRenderCommandName" value="/login/forgot_password" />
				</portlet:actionURL>

				<aui:form action="<%= forgotPasswordURL %>" cssClass="forgot-password-form" method="post" name="fm">
					<aui:input name="saveLastPath" type="hidden" value="<%= false %>" />
					<aui:input name="mvcRenderCommandName" type="hidden" value="/login/forgot_password" />

					<div class="liferay-error-container">
						<liferay-ui:error exception="<%= CaptchaConfigurationException.class %>" message="a-captcha-error-occurred-please-contact-an-administrator" />
						<liferay-ui:error exception="<%= CaptchaException.class %>" message="captcha-verification-failed" />
						<liferay-ui:error exception="<%= CaptchaTextException.class %>" message="text-verification-failed" />
						<liferay-ui:error exception="<%= NoSuchUserException.class %>" message='<%= "the-" + TextFormatter.format(HtmlUtil.escape(authType), TextFormatter.K) + "-you-requested-is-not-registered-in-our-database" %>' />
						<liferay-ui:error exception="<%= PrincipalException.MustBeEnabled.class %>" message="password-recovery-is-disabled" />
						<liferay-ui:error exception="<%= RequiredReminderQueryException.class %>" message="you-have-not-configured-a-reminder-query" />
						<liferay-ui:error exception="<%= SendPasswordException.MustBeEnabled.class %>" message="password-recovery-is-disabled" />
						<liferay-ui:error exception="<%= UserActiveException.class %>" message="your-account-is-not-active" />
						<liferay-ui:error exception="<%= UserEmailAddressException.MustNotBeNull.class %>" message="please-enter-an-email-address" />
						<liferay-ui:error exception="<%= UserEmailAddressException.MustValidate.class %>" message="please-enter-a-valid-email-address" />
						<liferay-ui:error exception="<%= UserLockoutException.LDAPLockout.class %>" message="this-account-is-locked" />
						<liferay-ui:error exception="<%= UserReminderQueryException.class %>" message="your-answer-does-not-match-what-is-in-our-database" />
					</div>

					<aui:fieldset>
						<c:choose>
							<c:when test="<%= user2 == null %>">

								<%
								String loginLabel = null;

								if (authType.equals(CompanyConstants.AUTH_TYPE_EA)) {
									loginLabel = "email-address";
								}
								else if (authType.equals(CompanyConstants.AUTH_TYPE_SN)) {
									loginLabel = "screen-name";
								}
								else if (authType.equals(CompanyConstants.AUTH_TYPE_ID)) {
									loginLabel = "id";
								}
								%>

								<aui:input name="step" type="hidden" value="1" />

								<c:if test="<%= !PrefsPropsUtil.getBoolean(company.getCompanyId(), PropsKeys.USERS_REMINDER_QUERIES_ENABLED, PropsValues.USERS_REMINDER_QUERIES_ENABLED) %>">
									<portlet:renderURL var="redirectURL">
										<portlet:param name="mvcPath" value="/login.jsp" />
									</portlet:renderURL>

									<aui:input name="redirect" type="hidden" value="<%= redirectURL %>" />
								</c:if>

								<div class="ax-form-group">
									<aui:input label="<%= loginLabel %>" name="login" placeholder='<%= "Enter your " + loginLabel %>' required="<%= true %>" showRequiredLabel="<%= false %>" type="text" value="<%= login %>" />
								</div>

								<c:if test="<%= captchaConfiguration.sendPasswordCaptchaEnabled() %>">
									<div class="ax-captcha-wrapper">
										<liferay-captcha:captcha />
									</div>
								</c:if>

								<aui:button-row>
									<aui:button cssClass="ax-btn-submit ax-full-width-btn" type="submit" value='<%= PrefsPropsUtil.getBoolean(company.getCompanyId(), PropsKeys.USERS_REMINDER_QUERIES_ENABLED, PropsValues.USERS_REMINDER_QUERIES_ENABLED) ? "next" : "send-new-password" %>' />
								</aui:button-row>
							</c:when>
							<c:when test="<%= user2 != null %>">
								<aui:input name="step" type="hidden" value="2" />

								<portlet:renderURL var="redirectURL">
									<portlet:param name="mvcPath" value="/login.jsp" />
								</portlet:renderURL>

								<aui:input name="redirect" type="hidden" value="<%= redirectURL %>" />

								<c:if test="<%= Validator.isNotNull(user2.getReminderQueryQuestion()) && Validator.isNotNull(user2.getReminderQueryAnswer()) %>">
									<div class="alert alert-info ax-alert-custom">
										<liferay-ui:message arguments="<%= HtmlUtil.escape(login) %>" key="an-email-will-be-sent-to-x-if-you-can-correctly-answer-the-following-question" translateArguments="<%= false %>" />
									</div>

									<div class="ax-form-group">
										<aui:input label="<%= HtmlUtil.escape(LanguageUtil.get(request, user2.getReminderQueryQuestion())) %>" name="answer" placeholder="Your Answer" type='<%= PrefsPropsUtil.getBoolean(company.getCompanyId(), PropsKeys.USERS_REMINDER_QUERIES_DISPLAY_IN_PLAIN_TEXT, PropsValues.USERS_REMINDER_QUERIES_DISPLAY_IN_PLAIN_TEXT) ? "text" : "password" %>' />
									</div>
								</c:if>

								<c:choose>
									<c:when test="<%= PrefsPropsUtil.getBoolean(company.getCompanyId(), PropsKeys.USERS_REMINDER_QUERIES_REQUIRED, PropsValues.USERS_REMINDER_QUERIES_REQUIRED) && !user2.hasReminderQuery() %>">
										<div class="alert alert-danger ax-alert-custom">
											<liferay-ui:message key="the-password-cannot-be-reset-because-you-have-not-configured-a-reminder-query" />
										</div>
									</c:when>
									<c:otherwise>
										<c:if test="<%= reminderAttempts >= 3 %>">
											<div class="ax-captcha-wrapper">
												<liferay-captcha:captcha />
											</div>
										</c:if>

										<aui:button-row>
											<aui:button cssClass="ax-btn-submit ax-full-width-btn" type="submit" value='<%= company.isSendPasswordResetLink() ? "send-password-reset-link" : "send-new-password" %>' />
										</aui:button-row>
									</c:otherwise>
								</c:choose>
							</c:when>
							<c:otherwise>
								<div class="alert alert-warning ax-alert-custom">
									<liferay-ui:message key="the-system-cannot-send-you-a-new-password-because-you-have-not-provided-an-email-address" />
								</div>
							</c:otherwise>
						</c:choose>
					</aui:fieldset>
				</aui:form>

				<div class="ax-back-link-container">
					<portlet:renderURL var="loginURL">
						<portlet:param name="mvcPath" value="/login.jsp" />
					</portlet:renderURL>
					<button class="ax-btn-forgot-password" onclick="window.location.href='<%= loginURL.toString() %>';" type="button">
						&larr; Back to Login
					</button>
				</div>

				<div class="navigaton-include ax-nav-footer">
					<%@ include file="/navigation.jspf" %>
				</div>
			</div>
		</div>
	</div>
</div>
