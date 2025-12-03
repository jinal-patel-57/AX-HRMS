<%@ include file="/init.jsp" %>

<div class="card">
  <div class="card-header"><strong><liferay-ui:message key="leave-policy-master-details" /> </strong></div>
  <div class="card-body mb-0">

<p class="card-text fs-5"><liferay-ui:message key="description" /> : ${getLeavePolicyMasterRecord.description}</p>
      <p class="card-text fs-5"><liferay-ui:message key="accrual-rate" /> : ${getLeavePolicyMasterRecord.accrualRate}</p>
      <p class="card-text fs-5"><liferay-ui:message key="maximum-balance" /> :  ${getLeavePolicyMasterRecord.maximumBalance}</p>
      <p class="card-text fs-5"><liferay-ui:message key="leave-type-name" /> : ${getLeavePolicyMasterRecord.leaveTypeName}</p>
      <p class="card-text fs-5"><liferay-ui:message key="eligible-after-months" /> :  ${getLeavePolicyMasterRecord.eligibleAfterMonths}</p>
      <p class="card-text fs-5"><liferay-ui:message key="is-carry-forward" /> : ${getLeavePolicyMasterRecord.isCarryForward()}</p>
      <p class="card-text fs-5"><liferay-ui:message key="year-of-policy" /> : ${getLeavePolicyMasterRecord.yearOfPolicy}</p>
      <p class="card-text fs-5"><liferay-ui:message key="is-continuous" /> : ${getLeavePolicyMasterRecord.isContinous()}</p>
      <p class="card-text fs-5"><liferay-ui:message key="is-check-max" /> : ${getLeavePolicyMasterRecord.isCheckMax()}</p>
      <p class="card-text fs-5"><liferay-ui:message key="is-applicable-floater" /> : ${getLeavePolicyMasterRecord.isApplicableFloater()}</p>


</div>
  <div class="card-footer text-right mb-0">     <a href="<liferay-portlet:renderURL portletMode='view' windowState='normal' />" class="btn btn-outline-danger"><liferay-ui:message key ="back-button" /></a>
</div>
</div>
