<%@ include file="/init.jsp"%>


<!-- Session Message Keys Start -->
<liferay-ui:success key="leave-type-edited-message" message="leave-type-edited-success-message" />
<liferay-ui:success key="leave-type-deleted-message" message="leave-type-deleted-success-message" />
<liferay-ui:success key="leave-type-inserted-message" message="leave-type-inserted-success-message" />
<liferay-ui:error key="leave-type-deleted-failed-message" message="leave-type-deleted-failed-message" />
<liferay-ui:error key="something-went-wrong-message-key" message="something-went-wrong-message" />
<!-- Session Message Keys End -->

<portlet:renderURL var="addLeaveTypeUrl">
	<portlet:param name="mvcPath" value="/jsp/leave-type-master/addEditLeaveTypeMaster.jsp" />
</portlet:renderURL>

<div class="card">
  <div class="card-header d-flex align-items-center justify-content-end"><a class="btn btn-primary btn-sm " href="${addLeaveTypeUrl}">
					<liferay-ui:message key="add-leave-type" />
				</a></div>
  <div class="card-body mb-0">
	
			<liferay-portlet:renderURL varImpl="iteratorURL" />
			
			<liferay-ui:search-container total="${ totalLeaveTypeMaster}" delta="20" emptyResultsMessage="no-Leave-Type-found" iteratorURL="${iteratorURL}">
			    <liferay-ui:search-container-results results="${ leaveTypeMasterList}" />
			
			    <liferay-ui:search-container-row className="com.ax.hrms.master.model.LeaveTypeMaster" modelVar="leaveTypeMaster" keyProperty="leaveTypeMasterId">
			    
			        <liferay-ui:search-container-column-text name="Leave Type Name" value="${ leaveTypeMaster.getLeaveTypeName() }" ></liferay-ui:search-container-column-text>
			        <liferay-ui:search-container-column-text name="Description" value="${ leaveTypeMaster.getDescription() }" ></liferay-ui:search-container-column-text>
			        <liferay-ui:search-container-column-text name="Is Active" value="${ leaveTypeMaster.getIsActive() }" ></liferay-ui:search-container-column-text>
			        <liferay-ui:search-container-column-text name="Is Appear For All" value="${ leaveTypeMaster.getIsAppearForAll() }" ></liferay-ui:search-container-column-text>

			        <liferay-ui:search-container-column-text name="Action" cssClass="text-center">
						<portlet:renderURL var="editLeaveTypeMasterUrl">
							<portlet:param name="mvcRenderCommandName" value="/fetchLeaveTypeDetails" />
							<portlet:param name="leaveTypeMasterId" value="${leaveTypeMaster.leaveTypeMasterId}" />
						</portlet:renderURL>
						<portlet:renderURL var="viewLeaveTypeDetail">
							<portlet:param name="mvcRenderCommandName" value="/viewLeaveTypeDetail" />
							<portlet:param name="leaveTypeMasterId" value="${leaveTypeMaster.leaveTypeMasterId}" />
						</portlet:renderURL>
						<portlet:actionURL name="/deleteLeaveTypeMaster" var="deleteUrl">
							<portlet:param name="leaveTypeMasterId" value="LEAVE_TYPE_MASTER_ID" />
							<portlet:param name="iteratorUrl" value="${iteratorURL }" />
						</portlet:actionURL>
						
						
						<div class="dropdown ">
					<button class="btn fa fa-ellipsis-v dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" >
						<i class="icon-ellipsis-vertical"></i>
					</button>
					<ul class="dropdown-menu">
						<li>
						<a href="${viewLeaveTypeDetail }" class="dropdown-item "><i class="icon-eye-open"></i> <liferay-ui:message
						key="view-button" /></a>
						</li>
						<li>
						<a href="${editLeaveTypeMasterUrl }" class=" dropdown-item"><i class="icon-edit"></i> <liferay-ui:message
						key="edit-button" /></a>
						</li>
						<li>
						<a class="dropdown-item"
					onclick="deleteAction(${leaveTypeMaster.leaveTypeMasterId})"><i class="icon-trash"></i> <liferay-ui:message
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

	function deleteAction(leaveTypeMasterId){		
		var config = new Object({}),
		namespace = '<portlet:namespace />';
		
		config.namespace = namespace;
		config.deleteUrl = '${deleteUrl}';
		config.leaveTypeMasterId = leaveTypeMasterId;

		AxLeaveTypeMasterWebPortlet.setConfigsForDeleteLeaveType(config);
	}
</script>