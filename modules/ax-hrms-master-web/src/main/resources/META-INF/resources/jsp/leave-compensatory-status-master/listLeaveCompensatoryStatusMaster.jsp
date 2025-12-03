<%@ include file="/init.jsp" %>

<portlet:renderURL var="addLeaveCompensatoryStatusURL">
	<portlet:param name="mvcPath" value="/jsp/leave-compensatory-status-master/addEditLeaveCompensatoryStatusMaster.jsp" />
</portlet:renderURL>



<liferay-ui:error key="leave-compensatory-status-exists" message="leave-compensatory-status-name-is-already-exist" />

<liferay-ui:success key="leave-compensatory-status-deleted" message="leave-compensatory-status-has-been-deleted-successfully" />

<liferay-ui:success key="leave-compensatory-status-added" message="leave-compensatory-status-has-been-successfully-added" />
<liferay-ui:success key="leave-compensatory-status-updated" message="leave-compensatory-status-has-been-successfully-updated" />


<div class="card">
  <div class="card-header d-flex align-items-center justify-content-end">
<a href="${addLeaveCompensatoryStatusURL}" class="btn  btn-primary btn-sm ">
		<liferay-ui:message key="add-leave-compensatory-status" />
	</a>
</div>
  <div class="card-body mb-0">
<liferay-portlet:renderURL varImpl="iteratorURL" />

<liferay-ui:search-container total="${totalLeaveCompensatoryStatus}" delta= "3" emptyResultsMessage="No-Leave Compensatory Status-found" iteratorURL="${iteratorURL}">
    <liferay-ui:search-container-results results="${getLeaveCompensatoryStatus}" />




    <liferay-ui:search-container-row className="com.ax.hrms.master.model.LeaveCompensatoryStatusMaster" modelVar="leaveCompensatoryStatusMaster" keyProperty="LeaveCompensatoryStatusMaster">
        <liferay-ui:search-container-column-text name="Leave Compensatory Status" value="${leaveCompensatoryStatusMaster.getLeaveCompensatoryStatus()}" />
        																				

        <liferay-ui:search-container-column-text name="Actions" cssClass="text-center">

			<portlet:renderURL var="viewLeaveCompensatoryStatusURL">
					<portlet:param name="mvcRenderCommandName" value="/viewLeaveCompensatoryStatus"/>
					<portlet:param name="leaveCompensatoryStatusMasterId" value="${leaveCompensatoryStatusMaster.leaveCompensatoryStatusMasterId}"/>		            
			</portlet:renderURL>


			<portlet:renderURL var="updateLeaveCompensatoryStatusURL">
				<portlet:param name="mvcRenderCommandName" value="/fetchLeaveCompensatoryStatus"/>
				<portlet:param name="leaveCompensatoryStatusMasterId" value="${leaveCompensatoryStatusMaster.leaveCompensatoryStatusMasterId}"/>		            
			</portlet:renderURL>
	        
	        <portlet:actionURL var="deleteLeaveCompensatoryStatusURL" name="/deleteLeaveCompensatoryStatus">
				<portlet:param name="leaveCompensatoryStatusMasterId" value="${leaveCompensatoryStatusMaster.leaveCompensatoryStatusMasterId}" />
			</portlet:actionURL>
            
            
            <div class="dropdown ">
					<button class="btn fa fa-ellipsis-v dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" >
						<i class="icon-ellipsis-vertical"></i>
					</button>
					<ul class="dropdown-menu">
						<li>
						<a href="${viewLeaveCompensatoryStatusURL }" class="dropdown-item "><i class="icon-eye-open"></i> <liferay-ui:message
						key="view-button" /></a>
						</li>
						<li>
						<a href="${updateLeaveCompensatoryStatusURL }" class=" dropdown-item"><i class="icon-edit"></i> <liferay-ui:message
						key="edit-button" /></a>
						</li>
						<li>
						<a class="dropdown-item"
					onclick="deleteLeaveCompensatoryStatusByMasterId('${leaveCompensatoryStatusMaster.leaveCompensatoryStatusMasterId}')"><i class="icon-trash"></i> <liferay-ui:message
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

<!-- Start -->





<!-- end -->

<script>

function deleteLeaveCompensatoryStatusByMasterId(leaveCompensatoryStatusMasterId) {		
    var config = {
        namespace: '<portlet:namespace />',
        deleteUrl: '${deleteLeaveCompensatoryStatusURL}',
        leaveCompensatoryStatusMasterId: leaveCompensatoryStatusMasterId
    };
    AxLeaveCompensatoryStatusMasterWebPortlet.setConfigsForDeleteLeaveCompensatoryStatusMaster(config);
}

function goBack() {
    window.history.back();
}

</script>
