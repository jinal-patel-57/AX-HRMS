<%@ include file="/init.jsp"%>

<portlet:renderURL var="homeUrl" />


<div class="card">
  <div class="card-header"><strong><liferay-ui:message key="priorityDetails" /> </strong></div>
  <div class="card-body mb-0">
				<p class="card-text fs-5"><liferay-ui:message key="priority-name" />  : ${priorityMasterData.priorityName }</p>
</div>
  <div class="card-footer text-right mb-0">			<a href="${homeUrl }" class="btn btn-outline-danger "><liferay-ui:message key="back"></liferay-ui:message></a>
</div>
</div>
