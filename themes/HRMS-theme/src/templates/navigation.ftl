<div class="side_navbar" aria-label="<@liferay.language key=" site-pages" />" role="navigation" >
<ul role="menubar">

	<#list nav_items as nav_item>
		<#assign nav_item_attr_has_popup="" nav_item_css_class="" nav_item_layout=nav_item.getLayout() />

		<#if nav_item.isSelected()>
			<#assign nav_item_attr_has_popup="aria-haspopup='true'" nav_item_css_class="selected" />
		</#if>

		<li class="${nav_item_css_class} parent" id="layout_${nav_item.getLayoutId()}" role="presentation">
			<a ${nav_item_attr_has_popup} href="${nav_item.getURL()}" ${nav_item.getTarget()} role="menuitem" data-sena-off="true"
				class="trans" title="${nav_item.getName()}">
				<div class="span_flex">
					<span class="nav_img"><img src="${themeDisplay.getPathThemeImages()}/nav_admin.png" alt="" />
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

						<#if nav_item.isSelected()>
							<#assign nav_child_css_class="selected" />
						</#if>

						<li class="${nav_child_css_class}" id="layout_${nav_child.getLayoutId()}" role="presentation">
							<a href="${nav_child.getURL()}" ${nav_child.getTarget()} role="menuitem" class="trans" data-sena-off="true"
								title="${nav_child.getName()}">${nav_child.getName()}</a>
						</li>
					</#list>
				</ul>
			</#if>
		</li>
	</#list>
	</div>