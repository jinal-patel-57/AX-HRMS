<%@ include file="/init.jsp" %>

<portlet:renderURL var="viewDocumentTypeURL">
    <portlet:param name="mvcRenderCommanName" value="/" />
</portlet:renderURL>



 <div class="card">
  <div class="card-header"><strong><liferay-ui:message key="document-type-details" /> </strong></div>
  <div class="card-body mb-0"><p> 
<liferay-ui:message key="document-type-name" /> : ${documentType.getDocumentTypeName()}
</p></div>
  <div class="card-footer text-right mb-0"> <a href="${viewDocumentTypeURL}" class="btn  btn-outline-danger " ><liferay-ui:message key="back" /></a>
</div>
</div>