<%@ include file="/init.jsp" %>
<portlet:renderURL var="templateLevelMasterList">
	<portlet:param name="mvcRenderCommandName" value="/" />
</portlet:renderURL>



<div class="card">
  <div class="card-header"><strong><liferay-ui:message key="template-level-name-details"/></strong></div>
  <div class="card-body mb-0">
<p class="card-text fs-5"><liferay-ui:message key="template-level-name" /> : ${templateLevelMaster.levelName}</p>

</div>
  <div class="card-footer text-right mb-0">  <a href="${templateLevelMasterList}" class="btn  btn-outline-danger"><liferay-ui:message key="back"/></a>
</div>
</div>
