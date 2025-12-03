<%@ include file="/init.jsp"%>

<portlet:renderURL var="homeUrl" />


<div class="card">
  <div class="card-header"><strong><liferay-ui:message key="designation-details" />  </strong></div>
  <div class="card-body"><p class="card-text fs-5"><liferay-ui:message key="designation-name" />  : ${designationMasterData.designationName }</p></div>
  <div class="card-footer mb-0 text-right"><a href="${homeUrl }" class="btn btn-outline-danger"><liferay-ui:message key="back"></liferay-ui:message></a></div>
</div>


