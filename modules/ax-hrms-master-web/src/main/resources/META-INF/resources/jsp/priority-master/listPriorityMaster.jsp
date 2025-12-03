<%@ include file="/init.jsp"%>


<!-- Session Message Keys Start -->
<liferay-ui:success key="priority-edited-message" message="priority-edited-success-message" />
<liferay-ui:success key="priority-deleted-message" message="priority-deleted-success-message" />
<liferay-ui:success key="priority-inserted-message" message="priority-inserted-success-message" />
<liferay-ui:error key="priority-deleted-failed-message" message="priority-deleted-failed-message" />
<liferay-ui:error key="something-went-wrong-message-key" message="something-went-wrong-message" />
<!-- Session Message Keys End -->

<portlet:renderURL var="addPriorityMasterUrl">
	<portlet:param name="mvcPath" value="/jsp/priority-master/addEditPriorityMaster.jsp" />
</portlet:renderURL>


<div class="card">
  <div class="card-header d-flex align-items-center justify-content-end"><a class="btn btn-primary btn-sm " href="${addPriorityMasterUrl}">
					<liferay-ui:message key="add-priority" />
				</a></div>
  <div class="card-body mb-0">
			
			<liferay-portlet:renderURL varImpl="iteratorURL" />
			
			<liferay-ui:search-container total="${ totalPriorityMaster}" delta="3" emptyResultsMessage="no-priority-found" iteratorURL="${iteratorURL}">
			    <liferay-ui:search-container-results results="${ priorityMasterList}" />
			
			    <liferay-ui:search-container-row className="com.ax.hrms.master.model.PriorityMaster" modelVar="priorityMaster" keyProperty="priorityMasterId">
			    
			        <liferay-ui:search-container-column-text name="priority-name" value="${ priorityMaster.getPriorityName() }" ></liferay-ui:search-container-column-text>

			        <liferay-ui:search-container-column-text name="Action" cssClass="text-center">
						<portlet:renderURL var="editPriorityMasterUrl">
							<portlet:param name="mvcRenderCommandName" value="/fetchPriorityDetails" />
							<portlet:param name="priorityMasterId" value="${priorityMaster.priorityMasterId}" />
						</portlet:renderURL>
						<portlet:renderURL var="viewPriorityDetail">
							<portlet:param name="mvcRenderCommandName" value="/viewPriorityDetail" />
							<portlet:param name="priorityMasterId" value="${priorityMaster.priorityMasterId}" />
						</portlet:renderURL>
						<portlet:actionURL name="/deletePriorityMaster" var="deleteUrl">
							<portlet:param name="priorityMasterId" value="PRIORITY_MASTER_ID" />
							<portlet:param name="iteratorUrl" value="${iteratorURL }" />
						</portlet:actionURL>
						
						
						<div class="dropdown ">
					<button class="btn fa fa-ellipsis-v dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" >
						<i class="icon-ellipsis-vertical"></i>
					</button>
					<ul class="dropdown-menu">
						<li>
						<a href="${viewPriorityDetail }" class="dropdown-item "><i class="icon-eye-open"></i> <liferay-ui:message
						key="view-button" /></a>
						</li>
						<li>
						<a href="${editPriorityMasterUrl }" class=" dropdown-item"><i class="icon-edit"></i> <liferay-ui:message
						key="edit-button" /></a>
						</li>
						<li>
						<a class="dropdown-item"
					onclick="deleteAction(${priorityMaster.priorityMasterId})"><i class="icon-trash"></i> <liferay-ui:message
						key="delete-button" />
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

	function deleteAction(priorityMasterId){
		var config = new Object({}),
		namespace = '<portlet:namespace />';
		
		config.namespace = namespace;
		config.deleteUrl = '${deleteUrl}';
		config.priorityMasterId = priorityMasterId;

		AxPriorityMasterWebPortlet.setConfigsForDeletePriority(config);
	}
</script>