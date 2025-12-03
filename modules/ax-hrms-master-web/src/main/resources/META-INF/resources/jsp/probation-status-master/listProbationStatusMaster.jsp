<%@ include file="/init.jsp" %>

<portlet:renderURL var="addProbationStatusURL">
	<portlet:param name="mvcPath" value="/jsp/probation-status-master/addEditProbationStatusMaster.jsp" />
</portlet:renderURL>


<div class="card">
  <div class="card-header d-flex align-items-center justify-content-end"><a href="${addProbationStatusURL}" class="btn  btn-primary btn-sm ">
		<liferay-ui:message key="add-probation-status" />
	</a></div>
  <div class="card-body mb-0">
<liferay-ui:error key="probation-status-exists" message="probation-status-name-is-already-exist" />

<liferay-ui:success key="probation-status-deleted" message="probation-status-has-been-deleted-successfully" />

<liferay-ui:success key="probation-status-added" message="probation-status-has-been-successfully-added" />
<liferay-ui:success key="probation-status-updated" message="probation-status-has-been-successfully-updated" />

<!-- Start -->


<liferay-portlet:renderURL varImpl="iteratorURL" />

<liferay-ui:search-container total="${totalProbationStatus}" delta= "3" emptyResultsMessage="No-Probation Status -found" iteratorURL="${iteratorURL}">
    <liferay-ui:search-container-results results="${getProbationStatus}" />




    <liferay-ui:search-container-row className="com.ax.hrms.master.model.ProbationStatusMaster" modelVar="probationStatusMaster" keyProperty="ProbationStatusMaster">
        <liferay-ui:search-container-column-text name="Probation Status Master" value="${probationStatusMaster.getStatusType()}" />
        																				

        <liferay-ui:search-container-column-text name="Actions" cssClass="text-center">

			<portlet:renderURL var="viewProbationStatusURL">
					<portlet:param name="mvcRenderCommandName" value="/viewProbationStatus"/>
					<portlet:param name="probationStatusMasterId" value="${probationStatusMaster.probationStatusMasterId}"/>		            
			</portlet:renderURL>


			<portlet:renderURL var="updateProbationStatusURL">
				<portlet:param name="mvcRenderCommandName" value="/fetchProbationStatus"/>
				<portlet:param name="probationStatusMasterId" value="${probationStatusMaster.probationStatusMasterId}"/>		            
			</portlet:renderURL>
	        
	        <portlet:actionURL var="deleteProbationStatusURL" name="/deleteProbationStatus">
				<portlet:param name="probationStatusMasterId" value="${probationStatusMaster.probationStatusMasterId}" />
			</portlet:actionURL>
            
            
            <div class="dropdown ">
					<button class="btn fa fa-ellipsis-v dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" >
						<i class="icon-ellipsis-vertical"></i>
					</button>
					<ul class="dropdown-menu">
						<li>
						<a href="${viewProbationStatusURL }" class="dropdown-item "><i class="icon-eye-open"></i> <liferay-ui:message
						key="view-button" /></a>
						</li>
						<li>
						<a href="${updateProbationStatusURL }" class=" dropdown-item"><i class="icon-edit"></i> <liferay-ui:message
						key="edit-button" /></a>
						</li>
						<li>
						<a class="dropdown-item"
					onclick="deleteProbationStatusByMasterId('${probationStatusMaster.probationStatusMasterId}')"><i class="icon-trash"></i> <liferay-ui:message
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



<!-- end -->

<script>

function deleteProbationStatusByMasterId(probationStatusMasterId) {		
    var config = {
        namespace: '<portlet:namespace />',
        deleteUrl: '${deleteProbationStatusURL}',
        probationStatusMasterId: probationStatusMasterId
    };
    AxProbationStatusMasterWebPortlet.setConfigsForDeleteProbationStatusMaster(config);
}

function goBack() {
    window.history.back();
}

</script>
