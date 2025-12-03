<%@ include file="/init.jsp" %>

<liferay-ui:error key="policy-type-exists" message="policy-type-name-is-already-exist" />

<portlet:actionURL name="/addEditPolicyType" var="addEditPolicyTypeURL" />

<portlet:actionURL name="/fetchPolicyType" var="fetchPolicyTypeURL" />

<portlet:renderURL var="goBack"/>


<div class="card">
  <div class="card-header"><strong><liferay-ui:message key="addPolicyType" /></strong></div>
 <form action="${addEditPolicyTypeURL}" method="post" id="addEditPolicyTypeMaster">
  <div class="card-body mb-0">
            <div class="form-group">
            
            <input value= "${policyTypeMasterData.getPolicyTypeMasterID()}" type="hidden" name = "<portlet:namespace />policyTypeMasterId">
                <label class="" for="policyTypeName"><liferay-ui:message key="policyTypeName" /><span class="text-danger">*</span></label>
              					
                <input  value= "${policyTypeMasterData.getPolicyType()}" id="policyType" placeholder="Enter Policy Type Name" class="form-control" type="text"
                    name="<portlet:namespace/>policyType" value="">
            </div>
</div>
  <div class="card-footer text-right mb-0">
			            <a href="${goBack}" class="btn btn-outline-danger mr-1"><liferay-ui:message key="back" /></a> <!-- Adjust margin as needed -->
   <button class="btn btn-outline-success" type="submit"><liferay-ui:message key="submit" /></button>
</div>
        </form>
</div>


<body>
    <p>
       
			         
    </p>

</body>

<script>

$(document).ready(function () {		
    var config = {
        namespace: '<portlet:namespace />'
    };
    AxPolicyTypeMasterWebPortlet.setConfigsForValidation(config);
});	
</script>
