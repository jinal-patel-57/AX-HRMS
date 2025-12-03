<%@ include file="/init.jsp"%>

<portlet:renderURL var="homeUrl" />





<div class="card">
  <div class="card-header"><strong> <liferay-ui:message key="leave-type-details" /> </strong></div>
  <div class="card-body mb-0">

<p class="card-text fs-5"><liferay-ui:message key="leave-type-name" /> : ${leaveTypeMasterData.leaveTypeName }</p>
      <p class="card-text fs-5"><liferay-ui:message key="description" /> : ${leaveTypeMasterData.description }</p>
      <p class="card-text fs-5"><liferay-ui:message key="is-active" /> : ${leaveTypeMasterData.isActive == true ? 'Yes' : 'No' }</p>
      <p class="card-text fs-5"><liferay-ui:message key="appear-for-all" /> : ${leaveTypeMasterData.isAppearForAll == true ? 'Yes' : 'No' }</p>



</div>
  <div class="card-footer text-right mb-0">			<a href="${homeUrl }" class="btn btn-outline-danger "><liferay-ui:message key="back"></liferay-ui:message></a>
</div>
</div>
