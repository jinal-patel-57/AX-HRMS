<#assign employeeDetailsLocalService = serviceLocator.findService("com.ax.hrms.service.EmployeeDetailsLocalService")/>
<#assign lrUserId = themeDisplay.getUserId() />
<#assign isAdmin = themeDisplay.getPermissionChecker().isOmniadmin() />
<#assign isOnboarded = false />
<#if !isAdmin && themeDisplay.isSignedIn() && validator.isNotNull(employeeDetailsLocalService) && lrUserId?has_content && (lrUserId > 0)>
	<#assign employeeDetails = employeeDetailsLocalService.fetchEmployeeDetailsByLRUserId(lrUserId)!null />
	<#if validator.isNotNull(employeeDetails) && employeeDetails??>
		<#assign isOnboarded = employeeDetails.isEmployeeOnboarded  />
	</#if>
</#if>

<div class="side_navbar" aria-label="<@liferay.language key=" site-pages" />" role="navigation" >
<ul role="menubar" class="${lrUserId}">

	<#list nav_items as nav_item>
		<#assign nav_item_attr_has_popup="" nav_item_css_class="" nav_item_layout=nav_item.getLayout() />

		<#if nav_item.isSelected()>
			<#assign nav_item_attr_has_popup="aria-haspopup='true'" nav_item_css_class="selected" />
		</#if>

		<li class="${nav_item_css_class} parent" id="layout_${nav_item.getLayoutId()}" role="presentation">
			
			<a ${nav_item_attr_has_popup} href="${nav_item.getURL()}" ${nav_item.getTarget()} role="menuitem" data-sena-off="true"
				class="trans" title="${nav_item.getName()}" <#if nav_item.hasChildren()> onclick="return false;" </#if> >
				<div class="span_flex">
					<span class="nav_img">
						<#if nav_item_layout.getIconImageId() != 0>
							<img src="/image/layout_icon?img_id=${nav_item_layout.getIconImageId()}" alt="" />
						<#else>
						 	<img src="${themeDisplay.getPathThemeImages()}/nav_admin.png" alt="" />
						</#if>
						<!-- <@liferay_theme["layout-icon"] layout=nav_item_layout /> -->
					</span>
					<span class="nav_text">
						${nav_item.getName()}
					</span>
				</div>
			</a>
			
			<#if nav_item.hasChildren()>
				<span class="collapsed_icon"></span>	
				<ul class="child" role="menu">
					<#list nav_item.getChildren() as nav_child>
						<#assign nav_child_css_class="" />

						<#if nav_child.isSelected()>
							<#assign nav_child_css_class="selected" />
						</#if>
						<#if isAdmin || (nav_child.getURL()?contains("employee-on-boarding") && !isOnboarded) || !nav_child.getURL()?contains("employee-on-boarding")>
							<li class="${nav_child_css_class}" id="layout_${nav_child.getLayoutId()}" role="presentation">
								<a href="${nav_child.getURL()}" ${nav_child.getTarget()} role="menuitem" class="trans" data-sena-off="true"
									title="${nav_child.getName()}">${nav_child.getName()}</a>
							</li>
						</#if>
						
					</#list>
				</ul>
			</#if>
		</li>
	</#list>
	</div>