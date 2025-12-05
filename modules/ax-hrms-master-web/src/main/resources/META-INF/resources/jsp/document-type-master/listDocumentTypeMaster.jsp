<%@ include file="/init.jsp"%>
<!-- Different URL Start -->

<portlet:renderURL var="addDocumentTypeURL">
	<portlet:param name="mvcPath"
		value="/jsp/document-type-master/addEditDocumentTypeMaster.jsp" />
</portlet:renderURL>



<portlet:actionURL name="/deleteDocumentType"
	var="deleteDocumentTypeURL">
	<portlet:param name="documentTypeMasterId"
		value="DOCUMENT_TYPE_MASTER_ID" />
</portlet:actionURL>
<%--Different URL End Here--%>


<%--SESSION_MESSAGES Start Here--%>

<liferay-ui:success key="document-type-add-message"
	message="document-type-add-message"></liferay-ui:success>
<liferay-ui:success key="document-type-update-message"
	message="document-type-update-message"></liferay-ui:success>
<liferay-ui:success key="document-type-delete-message"
	message="document-type-delete-message"></liferay-ui:success>
<%--SESSION_MESSAGES End Here--%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><liferay-ui:message key="document-type-table" /></title>


</head>
<body>

<div class="card">
  <div class="card-header d-flex align-items-center justify-content-end">
<a href="${addDocumentTypeURL }" class="btn btn-primary btn-sm"> <liferay-ui:message
			key="add-document-type" />
	</a>
</div>
  <div class="card-body mb-0">

<liferay-portlet:renderURL varImpl="iteratorURL" />
	<liferay-ui:search-container total="${totalDocumentTypeMaster }"
		delta="20" emptyResultsMessage="no-document-type-found-error-message"
		iteratorURL="${iteratorURL}">

		<liferay-ui:search-container-results results="${documentTypeList }" />
		<liferay-ui:search-container-row
			className="com.ax.hrms.master.model.DocumentTypeMaster"
			modelVar="documentTypeMaster" keyProperty="designationMasterId">
			<liferay-ui:search-container-column-text name="Document Type Name"
				value="${documentTypeMaster.documentTypeName}" />

			<liferay-ui:search-container-column-text name="Actions" cssClass="text-center">
				<portlet:renderURL var="updateDocumentTypeURL">
					<portlet:param name="mvcRenderCommandName"
						value="/fetchDocumentType" />
					<portlet:param name="documentTypeMasterId"
						value="${documentTypeMaster.getDocumentTypeMasterId()}" />
				</portlet:renderURL>
				<portlet:renderURL var="viewDocumentTypeURL">
					<portlet:param name="mvcRenderCommandName" value="viewDocumentType" />
					<portlet:param name="documentTypeMasterId"
						value="${documentTypeMaster.getDocumentTypeMasterId()}" />
				</portlet:renderURL>




				<!-- 				dropDown start -->



				<div class="dropdown ">
					<button class="btn fa fa-ellipsis-v dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" ><i class="icon-ellipsis-vertical"></i>
					</button>
					<ul class="dropdown-menu">
						<li><a href="${viewDocumentTypeURL }" class="dropdown-item "><i class="icon-eye-open"></i> <liferay-ui:message
						key="view" /></a></li>
						<li><a href="${updateDocumentTypeURL }" class=" dropdown-item"><i class="icon-edit"></i> <liferay-ui:message
						key="edit" /></a></li>
						<li><a class="dropdown-item"
					onclick="deleteAction(${documentTypeMaster.getDocumentTypeMasterId()})"><i class="icon-trash"></i> <liferay-ui:message
						key="delete" /></a></li>
					</ul>
				</div>






				<!-- 				dropdown end -->
				
			</liferay-ui:search-container-column-text>
		</liferay-ui:search-container-row>
		<liferay-ui:search-iterator markupView="lexicon" />
	</liferay-ui:search-container>

</div>
</div>

	

	


</body>



<script>

	function deleteAction(documentTypeMasterId){		
		var config = new Object({}),
		namespace = '<portlet:namespace />';
		
		config.namespace = namespace;
		config.deleteUrl = '${deleteDocumentTypeURL}';
		config.documentTypeMasterId = documentTypeMasterId;

		documentTypeMasterWebPortlet.setConfigsForDeleteDocumentType(config);
	}
</script>



</html>



