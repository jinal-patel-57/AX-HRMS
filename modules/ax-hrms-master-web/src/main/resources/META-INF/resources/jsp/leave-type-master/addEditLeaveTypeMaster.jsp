<%@ include file="/init.jsp"%>

<%--SESSION_MESSAGES Start Here--%>
<liferay-ui:error key="leave-type-already-exists" message="leave-type-already-exists-message" />
<liferay-ui:error key="something-went-wrong-message-key" message="something-went-wrong-message" />
<%--SESSION_MESSAGES End Here--%>

<!-- Different URL Start -->
<portlet:renderURL var="homeUrl" />
<portlet:actionURL name="/addEditLeaveType" var="addLeaveTypeUrl" />
<!-- Different URL End -->
<div class="card">
  <div class="card-header"><strong><liferay-ui:message key="add-leave-type"/> </strong></div>
<form method="Post" action="${addLeaveTypeUrl }" id="leaveTypeMasterForm">
  <div class="card-body mb-0">
				<input type="hidden" value="${leaveTypeMasterData.leaveTypeMasterId}" name="<portlet:namespace/>leaveTypeMasterId">
				<div class="form-group">
			    	<label for="forLeaveTypeName"><liferay-ui:message key="leave-type-name"/><span class="text-danger">*</span></label>
				    <input type="text" class="form-control" id="<portlet:namespace />leaveTypeName" name="<portlet:namespace />leaveTypeName" placeholder="<liferay-ui:message key='leave-type-name-placeholder' />" value="${not empty existedLeaveTypeMaster ? existedLeaveTypeMaster.getLeaveTypeName(): (not empty leaveTypeMasterData ? leaveTypeMasterData.getLeaveTypeName() : '')}">
			  	</div>
			  	
			  	<div class="form-group">
			    	<label for="description"><liferay-ui:message key="description"/></label>
					<textarea class="form-control" id="<portlet:namespace />description" name="<portlet:namespace />description" rows="4" cols="30" placeholder="<liferay-ui:message key='description-placeholder' />">${not empty existedLeaveTypeMaster ? existedLeaveTypeMaster.getDescription(): (not empty leaveTypeMasterData ? leaveTypeMasterData.getDescription() : '')}</textarea>
			  	</div>
			  	
			  	<div class="form-group">
			    	<label for="isActiveLeaveType"><liferay-ui:message key="is-active"/></label>&nbsp;&nbsp;
					<input type="checkbox" name="<portlet:namespace />isActive" id="<portlet:namespace />isActive" ${not empty leaveTypeMasterData ? (leaveTypeMasterData.getIsActive() == true ? 'checked' :'')  : (not empty existedLeaveTypeMaster ? (existedLeaveTypeMaster.getIsActive() == true ? 'checked' : '') : '')}>
			  	</div>
			  	
			  	<div class="form-group">
			    	<label for="isAppearForAll"><liferay-ui:message key="is-appear-for-all"/></label>&nbsp;&nbsp;
					<input type="checkbox" name="<portlet:namespace />isAppearForAll" id="<portlet:namespace />isAppearForAll" ${not empty leaveTypeMasterData ? (leaveTypeMasterData.getIsAppearForAll() == true ? 'checked' :'')  : (not empty existedLeaveTypeMaster ? (existedLeaveTypeMaster.getIsAppearForAll() == true ? 'checked' : '') : '')}>
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
	
	AxLeaveTypeMasterWebPortlet.setConfigsForValidation(config);
});
</script>