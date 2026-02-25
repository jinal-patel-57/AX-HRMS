<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@ include file="/init.jsp" %>
<%@ page import="com.liferay.portal.kernel.theme.ThemeDisplay" %>
<%@ page import="com.liferay.portal.kernel.util.WebKeys" %>
<%@ page import="com.liferay.portal.kernel.util.HttpUtil" %>

<%@ page import="org.json.JSONObject" %>
<liferay-ui:error key="policy-hr-admin-exists" message="policy-hr-admin-name-is-already-exist" />
<liferay-ui:success key="policy-hr-admin-deleted" message="policy-hr-admin-has-been-deleted-successfully" />
<liferay-ui:success key="policy-hr-admin-added" message="policy-hr-admin-has-been-successfully-added" />
<liferay-ui:success key="policy-hr-admin-updated" message="policy-hr-admin-has-been-successfully-updated" />

<liferay-portlet:resourceURL var="downloadPolicyURL" id="/downloadPolicy">
    <liferay-portlet:param name="cmd" value="CMD_VALUE"/>
    <liferay-portlet:param name="policyId" value="POLICY_ID"/>
</liferay-portlet:resourceURL>



<portlet:renderURL var="listPolicyURL">
    <portlet:param name="mvcRenderCommandName" value="/" />
    <portlet:param name="selectedYear" value="YEAR"/>
</portlet:renderURL>

<!-- Start -->
<!-- <select class="btn btn-secondary mt-3" id="selectedYear" onchange="updateURLAndFetchData(this.id)"> -->

 <style>
        .Btn-disabled {
            pointer-events: none;
            opacity: 0.5;
        }
        
    </style>

<div class="card">
  <div class="card-header d-flex align-items-center justify-content-between">
  <div>
			<c:if test="${isHRAdmin}">
<select class="form-control" id="selectedYear" name="<portlet:namespace/>selectedYear">
    <c:forEach items="${fullList}" var="year">
        <c:if test="${year ne null and year ne ''}">
            <option value="${year}" ${year eq selectYear ? 'selected' : ''}>${year}</option>
        </c:if>
    </c:forEach>
 
</select>
 </c:if>
 </div>
</div>
  <div class="card-body mb-0">

<liferay-portlet:renderURL varImpl="iteratorURL" />

<liferay-ui:search-container total="${policySearchContainer.total}" delta="20" searchContainer="${policySearchContainer}" emptyResultsMessage="No-Policy-found" iteratorURL="${iteratorURL}">


                      <liferay-ui:search-container-results results="${policySearchContainer.results}" />

	 <liferay-ui:search-container-row className="com.ax.hrms.policy.process.management.hr.admin.web.dto.PolicyDto" modelVar="policy" keyProperty="policyId">
    
      <liferay-ui:search-container-column-text name="Policy Name" value="${policy.policyName}" />
        <liferay-ui:search-container-column-text name="Policy Description" value="${policy.description}"/>
        
        <liferay-ui:search-container-column-text name="Policy Type" value="${policy.policyTypeName }" />
        
        
        <liferay-ui:search-container-column-text name="Applicable Date" value="${policy.date}" />
        
        <liferay-ui:search-container-column-text name="Policy Status" value="${policy.status ? 'Active' : 'In Active'}" />

	      <%-- <liferay-ui:search-container-column-text name="Actions" cssClass="text-center">
	       
	       
	       <c:set var="isValidYear" value="${isHRAdmin || policy.year == currentYear}" />
						        <c:set var="btnClass" value="${isValidYear ? '' : 'Btn-disabled'}" />
						        
						        
				<div class="dropdown ">
					<button class="btn fa fa-ellipsis-v dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" >
						<i class="icon-ellipsis-vertical"></i>
					</button>
					<ul class="dropdown-menu">
						<li>
						<a  href="${policy.previewURL}" target="_blank" class="dropdown-item ${btnClass}"><i class="icon-download-alt"></i>  <liferay-ui:message
						key="download" /></a>
						</li>
					</ul>
				</div>
								   
           
            
        </liferay-ui:search-container-column-text>--%>

<liferay-ui:search-container-column-text name="Document">

<%
    long fileEntryId = 0;

    if (policy.getFile() != null) {
        fileEntryId = policy.getFile().getFileEntryId();
    }

%>

    <a href="${policy.previewURL}"
       target="_blank"
       rel="noopener noreferrer" style="color: #893D96;">
        <%= policy.getFile() != null ? policy.getFile().getFileName() : "No File" %>
    </a>

</liferay-ui:search-container-column-text>

    </liferay-ui:search-container-row>
 <liferay-ui:search-iterator
		searchContainer="${policySearchContainer}" markupView="lexicon" paginate="true" />
    
</liferay-ui:search-container>
<!-- end -->
</div>
</div>



<script>
    const element = document.getElementById("downloadButton");
    function downloadPolicy(policyId){
        event.preventDefault();
        let urlLink = '${downloadPolicyURL}';
        urlLink = urlLink.replace('CMD_VALUE', "download");
        urlLink = urlLink.replace('POLICY_ID', policyId);
        console.log("url" + urlLink);
        $.ajax({
            url: urlLink,
            method: 'GET',
            data: {status: "d"},
            success: function (data) {
                const resObj = JSON.parse(data);
                console.log(resObj);
                if (resObj.status == 'success') {
                    let urlLink = resObj.downloadURL;
                    element.setAttribute("href", urlLink);
                    window.location.href = element.getAttribute("href");
                }
            },
            error: function (err) {
                console.error('Error fetching data', err);
            }
        });


    }
</script>
<script type="text/javascript">
function updateURLAndFetchData(selectedYear){
	var ele=document.getElementById(selectedYear);
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
</script>
