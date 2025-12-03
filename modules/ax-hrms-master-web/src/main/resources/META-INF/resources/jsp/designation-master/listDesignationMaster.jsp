<%@ include file="/init.jsp"%>


<!-- Session Message Keys Start -->
<liferay-ui:error key="designation-already-exists" message="designation-already-exists-message" />
<liferay-ui:success key="designation-edited" message="designation-edited-success-message" />
<liferay-ui:success key="designation-master-delete-success-message" message="designation-deleted-success-message" />
<liferay-ui:success key="designation-inserted" message="designation-inserted-success-message" />
<liferay-ui:error key="designation-master-delete-failed-message" message="designation-deleted-failed-message" />
<!-- Session Message Keys End -->

<portlet:renderURL var="addDesignationUrl">
	<portlet:param name="mvcPath" value="/jsp/designation-master/addEditDesignationMaster.jsp" />
</portlet:renderURL>



<div class="card">
  <div class="card-header d-flex align-items-center justify-content-end">
<a class="btn btn-primary btn-sm" href="${addDesignationUrl}">
					<liferay-ui:message key="addDesignation" />
				</a>

</div>
  <div class="card-body"><liferay-portlet:renderURL varImpl="iteratorURL" />
			
			<liferay-ui:search-container total="${ totalDesignationMaster}" delta="3" emptyResultsMessage="no-Designation-found" iteratorURL="${iteratorURL}">
			    <liferay-ui:search-container-results results="${ designationList}" />
			
			    <liferay-ui:search-container-row className="com.ax.hrms.master.model.DesignationMaster" modelVar="designationMaster" keyProperty="designationMasterId">
			    
			        <liferay-ui:search-container-column-text name="Designation Name" value="${ designationMaster.getDesignationName() }" ></liferay-ui:search-container-column-text>
			
			        <liferay-ui:search-container-column-text name="Action" cssClass="text-center">
						<portlet:renderURL var="editDesignationMasterUrl">
							<portlet:param name="mvcRenderCommandName" value="/fetchDataInAddDesignation" />
							<portlet:param name="designationMasterId" value="${designationMaster.designationMasterId}" />
						</portlet:renderURL>
						<portlet:renderURL var="viewDesignationDetail">
							<portlet:param name="mvcRenderCommandName" value="/viewDesignationDetail" />
							<portlet:param name="designationMasterId" value="${designationMaster.designationMasterId}" />
						</portlet:renderURL>
						<portlet:actionURL name="/deleteDesignationMaster" var="deleteUrl">
							<portlet:param name="designationMasterId" value="DESIGNATION_MASTER_ID" />
							<portlet:param name="iteratorUrl" value="${iteratorURL }" />
						</portlet:actionURL>
						
						 <div class="dropdown ">
					<button class="btn fa fa-ellipsis-v dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" >
						<i class="icon-ellipsis-vertical"></i>
					</button>
					<ul class="dropdown-menu">
						<li>
						<a href="${viewDesignationDetail }" class="dropdown-item "><i class="icon-eye-open"></i> <liferay-ui:message
						key="view" /></a>
						</li>
						<li>
						<a href="${editDesignationMasterUrl }" class=" dropdown-item"><i class="icon-edit"></i> <liferay-ui:message
						key="edit" /></a>
						</li>
						<li>
						<a class="dropdown-item"
					onclick="deleteAction(${designationMaster.designationMasterId})"><i class="icon-trash"></i> <liferay-ui:message
						key="delete" />
						</a></li>
					</ul>
				</div>
						
					</liferay-ui:search-container-column-text>
					
			    </liferay-ui:search-container-row>
			
			    <liferay-ui:search-iterator markupView="lexicon" paginate="true" />
			</liferay-ui:search-container>
</div>
</div>
			
			
			
<script>

	function deleteAction(designationMasterId){		
		var config = new Object({}),
		namespace = '<portlet:namespace />';
		
		config.namespace = namespace;
		config.deleteUrl = '${deleteUrl}';
		config.designationMasterId = designationMasterId;
		
		AxDesignationMasterWebPortlet.setConfigsForDeleteDesignation(config);
	}
</script>