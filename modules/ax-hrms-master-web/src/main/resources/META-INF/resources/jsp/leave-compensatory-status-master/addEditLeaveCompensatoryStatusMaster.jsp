<%@ include file="/init.jsp" %>

<liferay-ui:error key="leave-compensatory-status-exists" message="leave-compensatory-status-name-is-already-exist" />

<portlet:actionURL name="/addEditLeaveCompensatoryStatus" var="addEditLeaveCompensatoryStatusURL" />

<portlet:actionURL name="/fetchLeaveCompensatoryStatus" var="fetchLeaveCompensatoryStatusURL" />

<portlet:renderURL var="goBack"/>


<div class="card">
  <div class="card-header"><strong> <liferay-ui:message key="add-leave-compensatory" /></strong></div>
 <form action="${addEditLeaveCompensatoryStatusURL}" method="post" id="addEditLeaveCompensatoryStatusMaster">
 
  <div class="card-body mb-0">
            <div class="form-group">
            
            <input value= "${leaveCompensatoryStatusMasterData.getLeaveCompensatoryStatusMasterId()}" type="hidden" name = "<portlet:namespace />leaveCompensatoryStatusMasterId">
                <label class="" for="leaveCompensatoryStatusName"><liferay-ui:message key="leaveCompensatoryStatusName" /><span class="text-danger">*</span></label>
              					
                <input  value= "${leaveCompensatoryStatusMasterData.getLeaveCompensatoryStatus()}" id="leaveCompensatoryStatus" placeholder="Enter Leave Compensatory Status Name" class="form-control" type="text"
                    name="<portlet:namespace/>leaveCompensatoryStatus" value="">
            </div>
</div>
  <div class="card-footer text-right mb-0">

			            <a href="${goBack}" class="btn btn-outline-danger mr-1"><liferay-ui:message key="back" /></a> <!-- Adjust margin as needed -->
   <button class="btn btn-outline-success" type="submit"><liferay-ui:message key="submit" /></button>
			     
</div>
        </form>
</div>




       
            
			         
  

<script>

$(document).ready(function(){
	var config = {
	   	namespace: '<portlet:namespace />'
    };
	AxLeaveCompensatoryStatusMasterWebPortlet.setConfigsForValidation(config);
});	
</script>
