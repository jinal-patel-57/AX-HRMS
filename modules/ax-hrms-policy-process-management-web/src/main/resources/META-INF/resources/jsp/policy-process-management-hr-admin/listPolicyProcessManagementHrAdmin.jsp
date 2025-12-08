<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@ include file="/init.jsp" %>
<portlet:renderURL var="homeUrl">
    <portlet:param name="selectedYear" value="${selectYear}"/>
</portlet:renderURL>
<portlet:renderURL var="addPolicyProcessManagementURL">
    <portlet:param name="mvcRenderCommandName" value="/addRenderMethod" />
  <portlet:param name="selectedYear" value="YEAR" />
    
</portlet:renderURL>

<portlet:renderURL var="fetchDataWithYearsURL">
    <portlet:param name="mvcRenderCommandName" value="/"/>
    <portlet:param name="selectedYear" value="SELECTED_YEAR"/>
</portlet:renderURL>

<portlet:renderURL var="listPolicyURL">
    <portlet:param name="mvcRenderCommandName" value="/" />
    <portlet:param name="selectedYear" value="YEAR"/>
</portlet:renderURL>



<liferay-ui:error key="existed-policy-entry-key" message="Existed Policy Type Entry is Found !" />
<liferay-ui:success key="policy-hr-admin-deleted" message="Policy Deleted SuccessFully !" />
<liferay-ui:success key="deleted-key" message="Policy Deleted SuccessFully !" />
<liferay-ui:success key="add-policy-form-key" message="Policy Added SuccessFully !" />
<liferay-ui:success key="update-policy-form-key" message="Policy Updated SuccessFully !" />
<liferay-ui:error key="error-key" message="Some Error is Occur !" />

 <style>
        .Btn-disabled {
            pointer-events: none;
            opacity: 0.5;
        }
        
    </style>
<!-- Start -->

<div class="card">
  <div class="card-header d-flex align-items-center justify-content-between">
  <div>
			<select class="form-control "  id="selectedYear" name="<portlet:namespace/>selectedYear">
    <c:forEach items="${fullList}" var="year">
        <c:if test="${year ne null and year ne ''}">
            <option value="${year}" ${year eq selectYear ? 'selected' : ''}>${year}</option>
        </c:if>
    </c:forEach>
 
</select>
</div>

    <a  id="addPolicy" class="btn btn-primary btn-sm">
        <liferay-ui:message key="add-policy-hr-admin" />
    </a>
</div>
  <div class="card-body mb-0">

<liferay-portlet:renderURL varImpl="iteratorURL" />

<liferay-ui:search-container total="${policySearchContainer.total}" delta="20" searchContainer="${policySearchContainer}" emptyResultsMessage="No-Policy-found" iteratorURL="${iteratorURL}">
    <liferay-ui:search-container-results results="${policySearchContainer.results}" />

	 <liferay-ui:search-container-row className="com.ax.hrms.policy.process.management.hr.admin.web.dto" modelVar="policy" keyProperty="policyId">
    
      <liferay-ui:search-container-column-text name="Policy Name" value="${policy.policyName}" />
        <liferay-ui:search-container-column-text name="Policy Description" value="${policy.description}"/>
        
        <liferay-ui:search-container-column-text name="Policy Type" value="${policy.policyTypeName }" />
        
        
        
        <liferay-ui:search-container-column-text name="Policy Date" value="${policy.date}" />
        
        <liferay-ui:search-container-column-text name="Policy Status" value="${policy.status ? 'Active' : 'In-Active'}" /> 

	       <liferay-ui:search-container-column-text name="Actions" cssClass="text-center">
	       
	       <portlet:renderURL var="updatePolicyURL">
		                <portlet:param name="mvcRenderCommandName" value="/fetchPolicy"/>
		                <portlet:param name="policyId" value="${policy.policyId}"/>		
		                 <portlet:param name="backURL" value="${homeUrl}" />
		                            
		            </portlet:renderURL>
		            
		              <portlet:actionURL var="deletePolicyURL" name="/deletePolicy">
                        <portlet:param name="policyId" value="${policy.policyId}" />
                        <portlet:param name="backURL" value="${homeUrl}" />
                    </portlet:actionURL>
                      
                      
                       			<c:set var="isValidYear" value="${policy.year >= currentYear - 1 && policy.year <= currentYear + 1}" />
						        <c:set var="btnClass" value="${isValidYear ? '' : 'Btn-disabled'}" />
						        
					<div class="dropdown ">
					<button class="btn fa fa-ellipsis-v dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" >
						<i class="icon-ellipsis-vertical"></i>
					</button>
					<ul class="dropdown-menu">
						<li>
						<a href="${updatePolicyURL }" class="dropdown-item ${btnClass}"><i class="icon-edit"></i> <liferay-ui:message
						key="edit" /></a>
						</li>
						<li>
						<a onclick="deletePolicyById('${policy.policyId}')"  class=" dropdown-item ${btnClass}"><i class="icon-trash"></i> <liferay-ui:message
						key="delete" /></a>
						</li>
					</ul>
				</div>
				
                      
                      
            
            
        </liferay-ui:search-container-column-text>
    </liferay-ui:search-container-row>

   <liferay-ui:search-iterator
		searchContainer="${policySearchContainer}" markupView="lexicon" paginate="true" />
</liferay-ui:search-container>
<!-- end -->

</div>
</div>

<script>
function deletePolicyById(policyId) {	
	console.log(policyId);
    var config = {
        namespace: '<portlet:namespace />',
        deleteUrl: '${deletePolicyURL}',
        policyId: policyId
    };
    
    console.log(config.namespace);
    AxHrmsPolicyProcessManagementHrAdminWebPortlet.setConfigsForDeletePolicy(config);
}

function updateURLAndFetchData(selectedYear){
	var ele=document.getElementById(selectedYear);
	console.log(ele.value);
	
    var config = {
            namespace: '<portlet:namespace />selectedYear',
            renderUrl: '${fetchDataWithYearsURL}',
            selectedYear: ele.value
        };
    AxHrmsPolicyProcessManagementHrAdminWebPortlet.setConfigsForRenderPolicyWithYear(config);	
}
$("#selectedYear").on('change',function(){
	let taskUrl = '${listPolicyURL}';
	let projectId = $('#selectedYear').val();
	console.log("Text value is: "+projectId)
	taskUrl = taskUrl.replace('YEAR', projectId);
	window.location.href = taskUrl;
		
	});
	
$("#addPolicy").on('click',function(){
	
	let policyURL = '${addPolicyProcessManagementURL}';
	let selectedYear = ${selectYear};
	policyURL = policyURL.replace('YEAR', selectedYear);
	window.location.href = policyURL;
		
	
});


</script>