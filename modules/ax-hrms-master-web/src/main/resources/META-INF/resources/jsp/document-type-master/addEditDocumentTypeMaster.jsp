<%@ include file="/init.jsp" %>

<!-- Different URL Start -->

<portlet:actionURL name="/addEditDocumentType" var="addEditDocumentTypeURL" >
</portlet:actionURL>

<portlet:renderURL var="viewDocumentTypeURL">
    <portlet:param name="mvcRenderCommanName" value="/" />
</portlet:renderURL>
<%--Different URL End Here--%>


<%--SESSION_MESSAGES Start Here--%>
<liferay-ui:error key="document-type-duplication-message" message="duplicate-document-type-name-message" />
<liferay-ui:error key="something-went-wrong-message-key" message="something-went-wrong-message" />

<%--SESSION_MESSAGES End Here--%>

<div class="card">
  <div class="card-header"><strong> <liferay-ui:message key="add-document-type"/>  </strong></div>
  <form action="${addEditDocumentTypeURL}" method="post" id="documentTypeForm">
  <div class="card-body mb-0">
<input type="hidden" name="<portlet:namespace/>documentTypeMasterId" value="${not empty documentTypeMasterId ?documentTypeMasterId: documentTypeMasterData.getDocumentTypeMasterId() }"/>
         
         
        
            <div class="form-group">
                <label class="" for="documentTypeName"><liferay-ui:message key="document-type-name"/><span class="text-danger">*</span></label>
                <input id="<portlet:namespace />documentTypeName" placeholder="Enter Document Type Name" class="form-control" type="text"
                    name="<portlet:namespace/>documentTypeName" value="${not empty existedDocumentTypeMaster ? existedDocumentTypeMaster.getDocumentTypeName() : (not empty documentTypeMasterData ? documentTypeMasterData.getDocumentTypeName() : '') }">
                <label id="documentTypeName-error" class="error text-danger" for="documentTypeName"></label>
            </div>
           
</div>
  <div class="card-footer text-right mb-0">
            <a href="${viewDocumentTypeURL}" class="btn  btn-outline-danger mr-1"> <liferay-ui:message key="back"/></a>
  <button type="submit" class="btn  btn-outline-success" ><liferay-ui:message key="submit"/>  </button>
  </div>
        </form>
</div>

        
         
            
   
   
   

 <script>
 $(document).ready(function(){
 	var config = new Object({}),
 	namespace = '<portlet:namespace />',
 	documentTypeName = 'documentTypeName';
 	
 	config.namespace = namespace;
 	config.documentTypeName = documentTypeName;
 	
 	
 	documentTypeMasterWebPortlet.setConfigs(config);
 });	
 </script>
