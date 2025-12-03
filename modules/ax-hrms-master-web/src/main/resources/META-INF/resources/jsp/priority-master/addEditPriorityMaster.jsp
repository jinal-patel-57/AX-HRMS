<%@ include file="/init.jsp"%>

<%--SESSION_MESSAGES Start Here--%>
<liferay-ui:error key="priority-already-exists" message="priority-already-exists-message" />
<liferay-ui:error key="something-went-wrong-message-key" message="something-went-wrong-message" />
<%--SESSION_MESSAGES End Here--%>

<!-- Different URL Start -->
<portlet:renderURL var="homeUrl" />
<portlet:actionURL name="/addPriorityMaster" var="addPriorityUrl" />
<!-- Different URL End -->



<div class="card">
  <div class="card-header"><strong><liferay-ui:message key="add-priority"/> </strong></div>
<form method="Post" action="${addPriorityUrl }" id="priorityMasterForm">
  <div class="card-body mb-0">
				<input type="hidden" value="${priorityMasterData.priorityMasterId}" name="<portlet:namespace/>priorityMasterId">
				<div class="form-group">
					<label for="forPriorityName"><liferay-ui:message key="priority-name"/><span class="text-danger">*</span></label>
					<input type="text" class="form-control" id="<portlet:namespace />priorityName" name="<portlet:namespace />priorityName" placeholder="<liferay-ui:message key='priority-name-placeholder' />" value="${not empty existedPriorityMaster ? existedPriorityMaster.getPriorityName(): (not empty priorityMasterData ? priorityMasterData.getPriorityName() : '')}">
				</div>
</div>
  <div class="card-footer text-right mb-0">
				<a href="${homeUrl}" class="btn btn-outline-danger mr-1"><liferay-ui:message key="back"/></a>
  <button type="submit" class="btn btn-outline-success"><liferay-ui:message key="submit"/></button>
			</div>
			</form>
</div>



			

				
		
<script>
	$(document).ready(function(){
		var config = new Object({}),
				namespace = '<portlet:namespace />';

		config.namespace = namespace;

		AxPriorityMasterWebPortlet.setConfigsForValidation(config);
	});
</script>