<%@ include file="/init.jsp" %>

<liferay-ui:error key="probation-status-exists" message="probation-status-name-is-already-exist" />

<portlet:actionURL name="/addEditProbationStatus" var="addEditProbationStatusURL" />

<portlet:actionURL name="/fetchProbationStatus" var="fetchProbationStatusURL" />

<portlet:renderURL var="goBack"/>


<div class="card">
  <div class="card-header"><strong><liferay-ui:message key="add-probation-status" /></strong></div>
<form action="${addEditProbationStatusURL}" method="post" id="addEditProbationStatusMaster">
  <div class="card-body mb-0">
            <div class="form-group">
            
            <input value= "${probationStatusMasterData.getProbationStatusMasterId()}" type="hidden" name = "<portlet:namespace />probationStatusMasterId">
                <label class="" for="probationStatusName"><liferay-ui:message key="probationStatusName" /><span class="text-danger">*</span></label>
              					
                <input  value= "${probationStatusMasterData.getStatusType()}" id="probationStatus" placeholder="Enter Probation Status Name" class="form-control" type="text"
                    name="<portlet:namespace/>probationStatus" value="">
            </div>
</div>
  <div class="card-footer text-right mb-0">
			            <a href="${goBack}" class="btn btn-outline-danger  mr-1"><liferay-ui:message key="back" /></a> <!-- Adjust margin as needed -->
<button class="btn btn-outline-success" type="submit"><liferay-ui:message key="submit" /></button>
</div>
        </form>
</div>

<script>

$(document).ready(function(){
	var config = {
	   	namespace: '<portlet:namespace />'
    };
	AxProbationStatusMasterWebPortlet.setConfigsForValidation(config);
});	
</script>
