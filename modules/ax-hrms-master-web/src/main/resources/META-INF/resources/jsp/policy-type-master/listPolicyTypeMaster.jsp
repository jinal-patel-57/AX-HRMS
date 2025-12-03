<%@ include file="/init.jsp" %>

<portlet:renderURL var="addPolicyTypeUrl">
	<portlet:param name="mvcPath" value="/jsp/policy-type-master/addEditPolicyTypeMaster.jsp" />
	
</portlet:renderURL>


<liferay-ui:error key="policy-type-exists" message="policy-type-name-is-already-exist" />

<liferay-ui:success key="policy-type-deleted" message="policy-type-has-been-deleted-successfully" />

<liferay-ui:success key="policy-type-added" message="policy-type-has-been-successfully-added" />
<liferay-ui:success key="policy-type-updated" message="policy-type-has-been-successfully-updated" />

<div class="card">
  <div class="card-header d-flex align-items-center justify-content-end">
<a href="${addPolicyTypeUrl}" class="btn  btn-primary btn-sm ">
		<liferay-ui:message key="addPolicyType" />
	</a>
</div>
  <div class="card-body mb-0">


<liferay-portlet:renderURL varImpl="iteratorURL" />

<liferay-ui:search-container total="${totalPolicyType}" delta= "3" emptyResultsMessage="No-Policy Type-found" iteratorURL="${iteratorURL}">
    <liferay-ui:search-container-results results="${getPolicyType}" />

    <liferay-ui:search-container-row className="com.ax.hrms.master.model.PolicyTypeMaster" modelVar="policyTypeMaster" keyProperty="policyTypeMasterID">
        <liferay-ui:search-container-column-text name="Policy Type Name" value="${policyTypeMaster.getPolicyType()}" />
        																				

        <liferay-ui:search-container-column-text name="Actions" cssClass="text-center">

			<portlet:renderURL var="viewPolicyTypeUrl">
					<portlet:param name="mvcRenderCommandName" value="/viewPolicyType"/>
					<portlet:param name="policyTypeMasterId" value="${policyTypeMaster.policyTypeMasterID}"/>		            
			</portlet:renderURL>


			<portlet:renderURL var="updatePolicyTypeUrl">
				<portlet:param name="mvcRenderCommandName" value="/fetchPolicyType"/>
				<portlet:param name="policyTypeMasterId" value="${policyTypeMaster.policyTypeMasterID}"/>		            
			</portlet:renderURL>
	        
	        <portlet:actionURL var="deletePolicyTypeUrl" name="/deletePolicyType">
				<portlet:param name="policyTypeMasterId" value="POLICYTYPE_MASTER_ID" />
			</portlet:actionURL>
            
            <div class="dropdown ">
					<button class="btn fa fa-ellipsis-v dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" >
						<i class="icon-ellipsis-vertical"></i>
					</button>
					<ul class="dropdown-menu">
						<li>
						<a href="${viewPolicyTypeUrl }" class="dropdown-item "><i class="icon-eye-open"></i> <liferay-ui:message
						key="view-button" /></a>
						</li>
						<li>
						<a href="${updatePolicyTypeUrl }" class=" dropdown-item"><i class="icon-edit"></i> <liferay-ui:message
						key="edit-button" /></a>
						</li>
						<li>
						<a class="dropdown-item"
					onclick="deletePolicyTypeByMasterId('${policyTypeMaster.policyTypeMasterID}')"><i class="icon-trash"></i> <liferay-ui:message
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

function deletePolicyTypeByMasterId(policyTypeMasterID) {		
    var config = {
        namespace: '<portlet:namespace />',
        deleteUrl: '${deletePolicyTypeUrl}',
        policyTypeMasterId: policyTypeMasterID
    };
    AxPolicyTypeMasterWebPortlet.setConfigsForDeletePolicyTypeMaster(config);
}

function goBack() {
    window.history.back();
}

</script>
