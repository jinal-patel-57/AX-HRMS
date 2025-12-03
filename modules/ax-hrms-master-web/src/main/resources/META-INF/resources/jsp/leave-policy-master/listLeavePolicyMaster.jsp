<%@ include file="/init.jsp"%>
	<portlet:renderURL var="leavePolicyMasterForm">
		<portlet:param name="mvcRenderCommandName" value="/fetchLeaveTypes" />
	</portlet:renderURL>
	
	<liferay-ui:success key="LeavePolicyMasterAdded" message="leave-policy-inserted" />
	<liferay-ui:success key="leavePolicyMasterDeleted" message="leave-policy-deleted" />
	<liferay-ui:success key="LeavePolicyEdited" message="leave-policy-edited" />
	
	<!-- add-leave-policy-button -->


<div class="card">
  <div class="card-header d-flex align-items-center justify-content-end"><a href="${leavePolicyMasterForm}" class="btn  btn-primary btn-sm"><liferay-ui:message key="leave-policy-master-button" /></a>
</div>
  <div class="card-body mb-0">


<liferay-portlet:renderURL varImpl="iteratorURL" />

<liferay-ui:search-container total="${leavePolicyMasterCounts}" delta="${delta}" emptyResultsMessage="no-leavePolicy-found" iteratorURL="${iteratorURL}">

	<liferay-ui:search-container-results results="${leavePolicyMasterDetailsList}" />
	
	<liferay-ui:search-container-row className="com.ax.hrms.master.leave.policy.web.dto.LeavePolicyMasterDetails" modelVar="leavePolicyMasterDetailsList" keyProperty="leavePolicyMasterid">
	
		<liferay-ui:search-container-column-text name="Description" value="${leavePolicyMasterDetailsList.description}" />
		<liferay-ui:search-container-column-text name="Total Leave Of Year" value="${leavePolicyMasterDetailsList.accrualRate}" />
		<liferay-ui:search-container-column-text name="Maximum Balance" value="${leavePolicyMasterDetailsList.maximumBalance}" />
		<liferay-ui:search-container-column-text name="Leave Type Name" value="${leavePolicyMasterDetailsList.leaveTypeName}" />
		<liferay-ui:search-container-column-text name="Year Of Policy" value="${leavePolicyMasterDetailsList.yearOfPolicy}" />
		<liferay-ui:search-container-column-text name="Eligible After Months" value="${leavePolicyMasterDetailsList.eligibleAfterMonths}" />
		<liferay-ui:search-container-column-text name="is Check Max" value="${leavePolicyMasterDetailsList.isCheckMax()}" />
		<liferay-ui:search-container-column-text name="is Carry Forward" value="${leavePolicyMasterDetailsList.isCarryForward()}" />
		<liferay-ui:search-container-column-text name="is Contionous" value="${leavePolicyMasterDetailsList.isContinous()}" />
		<liferay-ui:search-container-column-text name="is ApplicableFloater" value="${leavePolicyMasterDetailsList.isApplicableFloater()}" />
		
			<liferay-ui:search-container-column-text name="Actions" cssClass="text-center">
        	<!-- edit button -->
            <portlet:renderURL var="updateDataURL">
                <portlet:param name="mvcRenderCommandName" value="/fetchLeavePolicy" />
                <portlet:param name="leavePolicyMasterId" value="${leavePolicyMasterDetailsList.leavePolicyMasterid}" />
            </portlet:renderURL>
	        
	        <!-- delete Button -->
			<portlet:actionURL name="/deleteLeavePolicy" var="deleteLeavePolicyMasterURL">
				<portlet:param name="leavePolicyMasterId" value="LEAVE_POLICY_MASTER_ID" /> 
				<portlet:param name="iteratorURL" value="${iteratorURL}" />
			</portlet:actionURL>
             
            <!-- view Button --> 
            <portlet:renderURL var="viewLeavePolicyMasterRecord">
                <portlet:param name="mvcRenderCommandName" value="/viewLeavePolicy" />
                <portlet:param name="leavePolicyMasterId" value="${leavePolicyMasterDetailsList.leavePolicyMasterid}" />
            </portlet:renderURL>
            
            <div class="dropdown ">
					<button class="btn fa fa-ellipsis-v dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" >
						<i class="icon-ellipsis-vertical"></i>
					</button>
					<ul class="dropdown-menu">
						<li>
						<a href="${viewLeavePolicyMasterRecord }" class="dropdown-item "><i class="icon-eye-open"></i> <liferay-ui:message
						key="view-button" /></a>
						</li>
						<li>
						<a href="${updateDataURL }" class=" dropdown-item"><i class="icon-edit"></i> <liferay-ui:message
						key="edit-button" /></a>
						</li>
						<li>
						<a class="dropdown-item"
					onclick="deleteAction('${leavePolicyMasterDetailsList.leavePolicyMasterid}')"><i class="icon-trash"></i> <liferay-ui:message
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






<script type="text/javascript">
function deleteAction(leavePolicyMasterid){
	var config = new Object({}),
	namespace = '<portlet:namespace />';
	config.namespace = namespace;
	config.deleteLeavePolicyMasterURL = '${deleteLeavePolicyMasterURL}';
	config.leavePolicyMasterid = leavePolicyMasterid;
	AxLeavePolicyMasterWebPortlet.setConfigsForDeleteLeavePolicyMaster(config);
}
</script>