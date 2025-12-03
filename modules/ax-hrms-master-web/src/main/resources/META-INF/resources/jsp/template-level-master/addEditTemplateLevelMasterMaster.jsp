<%@ include file="/init.jsp" %>
<portlet:actionURL name="/addEditTemplateLevelMasterDetails" var="addEditTemplateLevel" >
</portlet:actionURL>
<portlet:renderURL var="templateLevelMasterList">
	<portlet:param name="mvcRenderCommandName" value="/" />
</portlet:renderURL>

<liferay-ui:error key="error-already-exist" message="template-already-exist" />
<liferay-ui:error key="error-already-exist" message="template-level-error-already-exist" />
<liferay-ui:success key="success" message="template-level-success" />
<liferay-ui:success key="success-delete" message="template-level-delete" />
<liferay-ui:success key="success-edit" message="template-level-edit" />


<div class="card">
  <div class="card-header"><strong><liferay-ui:message key="add-template-level"/> </strong></div>
            <form action="${addEditTemplateLevel}" method="post" id="templateLevelMasterForm">
  <div class="card-body mb-0">

            <input type="hidden" value="${templateLevelMaster.templateLevelMasterId}" name="<portlet:namespace/>templateLevelMasterId">


        <div class="form-group">
            <label class="" for="levelName"><liferay-ui:message key="enter-a-levelName"/><span class="text-danger">*</span></label>
            <input id="levelName" placeholder="<liferay-ui:message key='enter-a-levelName'/>" class="form-control" type="text"
                name="<portlet:namespace/>levelName" value="${templateLevelMaster.levelName} ${levelName}" />
            <label id="levelName-error" class="error text-danger" for="levelName"></label>
        </div>

</div>
  <div class="card-footer text-right mb-0">
   <a href="${templateLevelMasterList}" class="btn btn-outline-danger mr-1"> <liferay-ui:message key="back"/></a>
                <button class="btn btn-outline-success" type="submit"><liferay-ui:message key="submit"/></button>
    </div>
    </form>
</div>


               
<script>

</script>

<script>
    $(document).ready(function(){
        var config = new Object({}),
        namespace = '<portlet:namespace />';
        
        config.namespace = namespace;
        
        AxHrmsTemplateLevelMasterWebPortlet.setConfigsForValidation(config);
    });	
</script>