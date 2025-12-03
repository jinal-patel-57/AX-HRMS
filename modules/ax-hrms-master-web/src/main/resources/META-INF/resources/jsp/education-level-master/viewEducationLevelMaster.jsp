<%@ include file="/init.jsp" %>

<portlet:renderURL var="goBack"/>



<div class="card">
  <div class="card-header"><strong> <liferay-ui:message key="viewEducationLevelDetails" /> </strong></div>
  <div class="card-body mb-0"><p class="card-text fs-5"><liferay-ui:message key="educationLevelName" />  : ${educationDetails.getLevelName()}</p></div>
  <div class="card-footer text-right mb-0">			<a href = "${goBack }" class="btn btn-outline-danger"><liferay-ui:message key="back" /></a>
</div>
</div>