<%@ include file="/init.jsp" %>

<liferay-ui:error key="education-level-exists" message="education-level-name-is-already-exist" />

<liferay-ui:error key="education-level-incorrect" message="education-level-name-is-incorrect" />

<portlet:actionURL name="/addEditEducationLevel" var="addEducationLevelURL" />

<portlet:actionURL name="/fetchEducationLevel" var="fetchEducationLevelURL" />

<portlet:renderURL var="goBack"/>



<div class="card">
  <div class="card-header"><strong> <liferay-ui:message key="add-education-level" /> </strong></div>
  <form action="${addEducationLevelURL}" method="post" id="addEditEducationLevelMaster">
  <div class="card-body mb-0"> 
            <div class="form-group">
            
            <input value= "${educationLevelMasterData.getEducationLevelMasterId()}" type="hidden" name = "<portlet:namespace />educationLevelMasterId">
                <label class="" for="educationLevelName"><liferay-ui:message key="educationLevelName" /><span class="text-danger">*</span></label>
              					
                <input  value= "${educationLevelMasterData.getLevelName()}" id="levelName" placeholder="Enter Education Level Name" class="form-control" type="text"
                    name="<portlet:namespace/>levelName" value="">
            </div></div>
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
    AxEducationLevelMasterWebPortlet.setConfigsForValidation(config);
});	
</script>
