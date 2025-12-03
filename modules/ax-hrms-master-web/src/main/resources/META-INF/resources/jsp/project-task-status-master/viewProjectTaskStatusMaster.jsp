<%@ include file="/init.jsp" %>
<portlet:renderURL var="projectTaskStatusMasterList">
	<portlet:param name="mvcRenderCommandName" value="/" />
</portlet:renderURL>


<div class="card">
  <div class="card-header"><strong><liferay-ui:message key="project-task-status-details"/></strong></div>
  <div class="card-body mb-0">
      <p class="card-text fs-5"><liferay-ui:message key="project-task-status-name" /> : ${projectTaskStatusMaster.projectTaskStatusName}</p>
      <p class="card-text fs-5"><liferay-ui:message key="is-applicable-for-project" /> : ${projectTaskStatusMaster.isApplicableForProject}</p>
      <p class="card-text fs-5"><liferay-ui:message key="is-applicable-for-task" /> : ${projectTaskStatusMaster.isApplicableForTask}</p>


</div>
  <div class="card-footer text-right mb-0">  <a href="${projectTaskStatusMasterList}" class="btn btn-sm btn-outline-danger"><liferay-ui:message key="back"/></a>
</div>
</div>


