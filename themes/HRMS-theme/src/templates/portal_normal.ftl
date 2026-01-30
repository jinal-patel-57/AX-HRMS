<!DOCTYPE html>
<#include init />
<html class="${root_css_class}" dir="<@liferay.language key=" lang.dir" />" lang="${w3c_language_id}">

<head>
	<title>
		${html_title}
	</title>
	<meta content="initial-scale=1.0, width=device-width" name="viewport" />
	<link rel="preconnect" href="https://fonts.googleapis.com">
	<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
	<link href="https://fonts.googleapis.com/css2?family=Open+Sans:ital,wght@0,300..800;1,300..800&display=swap"
		rel="stylesheet">
	<link href="${css_folder}/slick.min.css"
		  rel="stylesheet">
<#--	<link href="${css_folder}/summernote.min.css"-->
<#--		  rel="stylesheet">-->
<#--	-->
	<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-bs4.min.css" rel="stylesheet">
	<link href="https://cdn.jsdelivr.net/npm/select2@4.0.13/dist/css/select2.min.css" rel="stylesheet" />
	<@liferay_util["include"]
		page=top_head_include />
</head>

<body class="${css_class} collapsedMenu page-loading">
	<@liferay_ui["quick-access"]
		contentId="#main-content" />
	<@liferay_util["include"]
		page=body_top_include />
	<div class="main-wrapper">
		<@liferay.control_menu />
		<#assign profile_image=user.getPortraitURL(themeDisplay) />
		<#assign user=themeDisplay.getUser()>
			<#if themeDisplay.isSignedIn()>
				<#-- Get the user's screen name -->
					<#assign screenName=user.getScreenName()>
			</#if>
			<div class="d-flex flex-column flex-fill position-relative" id="wrapper">
				<div class="innerWrapper">
					<#if is_signed_in>
						<header id="banner" role="banner" class="header">
							<div class="inner_header">
								<div class="header_left">
									<div class="header_logo">
										<a class="${logo_css_class}" href="${site_default_url}"
											title="<@liferay.language_format arguments=" ${site_name}" key="go-to-x" />">
										<img alt="${logo_description}" height="${site_logo_height}" class="collapsed"
											src="${themeDisplay.getPathThemeImages()}/aixtor_branding_logo.svg" />
										<img src="${themeDisplay.getPathThemeImages()}/aixtor-logo-cropped.svg" class="expanded"
											alt="Aixtor" />
										</a>
									</div>
									<a id="toggle_btn" href="javascript:void(0);">
										<img class="bar-icon" src="${themeDisplay.getPathThemeImages()}/sidebar_arrow.png"" />
									</a>
								</div>
								<div class="header_right">
									<ul class="user_links">
										<li></li>
										<#if is_signed_in>
											<li class="notification">
												<div class="dropdown">
													<a class="dropdown-toggle" href="${themeDisplay.getPortalURL()}/manage?p_p_id=com_liferay_notifications_web_portlet_NotificationsPortlet">
														<i class="icon-bell-alt"></i>
													</a>
												</div>
											</li>
										</#if>
										<#if !is_signed_in && show_sign_in>
											<li>
												<a data-redirect="${is_login_redirect_required?string}" href="${sign_in_url}"
													id="sign-in" rel="nofollow" class="btn btn-primary">
													${sign_in_text}
												</a>
											</li>
										</#if>
										<#if is_signed_in>
											<li class="myprofile">
												<div class="dropdown">
													<a class="dropdown-toggle" href="#" role="button" data-toggle="dropdown"
														aria-expanded="false">
														<span class="avtar">
															<img src="${profile_image}" alt="" />
														</span>
														<span class="avtar_name">
															${user_first_name + " " + user_last_name}
														</span>
													</a>
													<div class="dropdown-menu">
														<a class="dropdown-item" href="${themeDisplay.getPortalURL()}/web/ax-hrms/my-profile">My Profile</a>
														<a class="dropdown-item" href="/c/portal/logout">Logout</a>
													</div>
												</div>
											</li>
										</#if>
									</ul>
								</div>
							</div>
						</header>
						<#if has_navigation && is_setup_complete>
							<#include "${full_templates_path}/navigation.ftl" />
						</#if>
					</#if>
					<#assign no_header_sidebar ="" />

					<#if !is_signed_in && show_sign_in>
						<#assign no_header_sidebar="no-header-sidebar" />
					</#if>
					<section class="main_content ${no_header_sidebar}" id="content">
						<h2 class="hide-accessible sr-only" role="heading" aria-level="1">
							${htmlUtil.escape(the_title)}
						</h2>
						<#assign layoutName = themeDisplay.getLayout().getName(themeDisplay.getLocale()) />
						<#if is_signed_in && (layoutName != 'Dashboard' || layoutName != 'Sign In')>
							<div class="title-container">
								<h4 class="page-title mb-1">${themeDisplay.getLayout().getName(themeDisplay.getLocale())}</h4>
							</div>
						</#if>
						<#if selectable>
							<@liferay_util["include"]
								page=content_include />
							<#else>
								${portletDisplay.recycle()}
								${portletDisplay.setTitle(the_title)}
								<@liferay_theme["wrap-portlet"]
									page="portlet.ftl">
									<@liferay_util["include"]
										page=content_include />
									</@>
						</#if>
					</section>
					<footer id="footer" role="contentinfo">
						<div class="copyrights">
							<div class="container-grid">
								<div class="copyright-box">
									<p><span>&COPY; <span id="copyright-year"></span> <a href="${site_default_url}" class="ax-link">Aixtor.com</a>, All rights reserved</span> <a
											href="https://aixtor.com/privacy-policy/" class="ani-1">
											Privacy Policy
										</a>
										<a href="https://aixtor.com/cookie-policy/" class="ani-1">
											Cookie Policy
										</a>
									</p>
								</div>
							</div>
						</div>
					</footer>
					<div id="overlay">
						<div class="cv-spinner">
							<span class="spinner"></span>
						</div>
					</div>
				</div>
			</div>
	</div>
	<script src="${javascript_folder}/popper.min.js"></script>
	<script src="${javascript_folder}/jquery.validate.min.js"></script>
	<script src="${javascript_folder}/slick.js"></script>
<#--	<script src="${javascript_folder}/summernote.min.js"></script>-->
	<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-bs4.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/select2@4.0.13/dist/js/select2.min.js"></script>
	<@liferay_util["include"]
		page=body_bottom_include />
	<@liferay_util["include"]
		page=bottom_include />
	

</body>

</html>