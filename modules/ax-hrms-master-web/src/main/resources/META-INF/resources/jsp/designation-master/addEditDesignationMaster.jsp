<%@ include file="/init.jsp"%>

<%--SESSION_MESSAGES Start Here--%>
<liferay-ui:error key="designation-already-exists" message="designation-already-exists-message" />
<%--SESSION_MESSAGES End Here--%>

<!-- Different URL Start -->
<portlet:renderURL var="homeUrl" />
<portlet:actionURL name="addDesignation" var="addDesignationUrl" />
<!-- Different URL End -->


<div class="card">
  <div class="card-header ">
  <strong> <liferay-ui:message key="add-designation"/> </strong>
</div>
  <form method="Post" action="${addDesignationUrl }" id="designationMasterForm">
  <div class="card-body mb-0">
			
				<input type="hidden" value="${designationMasterData.designationMasterId}" name="<portlet:namespace/>designationMasterId">
				<div class="form-group">
			    	<label for="<portlet:namespace />designationName"><liferay-ui:message key="designation-name"/><span class="text-danger">*</span></label>
				    <input type="text" class="form-control" id="<portlet:namespace />designationName" name="<portlet:namespace />designationName" placeholder="<liferay-ui:message key='designation-name-placeholder' />" value="${not empty existedDesignationName ? existedDesignationName : (not empty designationMasterData ? designationMasterData.designationName : '') }">
			  	</div>
				</div>
  <div class="card-footer text-right mb-0">
			  	<a href="${homeUrl}" class="btn btn-outline-danger mr-1"><liferay-ui:message key="back"/></a>
  <button type="submit" class="btn btn-outline-success "><liferay-ui:message key="submit"/></button>
</div>
</form>
</div>

<script>
$(document).ready(function(){
	var config = new Object({}),
	namespace = '<portlet:namespace />';
	
	config.namespace = namespace;
	
	AxDesignationMasterWebPortlet.setConfigsForValidation(config);
});	
</script>