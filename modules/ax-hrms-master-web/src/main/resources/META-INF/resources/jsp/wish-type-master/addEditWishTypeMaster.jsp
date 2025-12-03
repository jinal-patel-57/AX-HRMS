<%@ include file="/init.jsp" %>

<liferay-ui:error key="wish-type-exists" message="wish-type-name-is-already-exist" />

<portlet:actionURL name="/addEditWishType" var="addEditWishTypeURL" />

<portlet:actionURL name="/fetchWishType" var="fetchWishTypeURL" />

<portlet:renderURL var="goBack"/>

<div class="card">
  <div class="card-header"><strong> <liferay-ui:message key="addWishType" /></strong></div>
 <form action="${addEditWishTypeURL}" method="post" id="addEditWishTypeMaster">
  <div class="card-body mb-0">
            <div class="form-group">
            
            <input value= "${wishTypeMasterData.getWishTypeMasterId()}" type="hidden" name = "<portlet:namespace />wishTypeMasterId">
                <label class="" for="wishTypeName"><liferay-ui:message key="wishTypeName" /><span class="text-danger">*</span></label>
              					
                <input  value= "${wishTypeMasterData.getWishType()}" id="wishType" placeholder="Enter Wish Type Name" class="form-control" type="text"
                    name="<portlet:namespace/>wishType" value="">
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

$(document).ready(function(){
	var config = {
	   	namespace: '<portlet:namespace />'
    };
	AxWishTypeMasterWebPortlet.setConfigsForValidation(config);
});	
</script>
