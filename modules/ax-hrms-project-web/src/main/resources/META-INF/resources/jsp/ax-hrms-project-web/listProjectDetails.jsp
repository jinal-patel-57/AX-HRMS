<%@ include file="/init.jsp"%>

<!-- Different URL Start -->
<portlet:renderURL var="addProjectURL">
                    <portlet:param name="mvcRenderCommandName" value="/addProject" />
                </portlet:renderURL>
<%--Different URL End Here--%>

<%--SESSION_MESSAGES Start Here--%>

<liferay-ui:success key="successfully-project-added" message="successfully-project-added-message"></liferay-ui:success>
<liferay-ui:success key="successfully-project-deleted" message="successfully-project-deleted-message"></liferay-ui:success>
<liferay-ui:success key="successfully-project-updated" message="successfully-project-updated-message"></liferay-ui:success>

<liferay-ui:error key="error-occur" message="error-message" />

<%--SESSION_MESSAGES End Here--%>
  <portlet:actionURL name="/deleteProjectDetails" var="deleteProjectDetailsURL">
                    <portlet:param name="projectId" value="PROJECTID" />
                </portlet:actionURL>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><liferay-ui:message key="project-data" /></title>
</head>
		

<body>
<div class="card">
  <div class="card-header d-flex align-items-center justify-content-end">
			<c:choose>
                   <c:when test="${isManager}">
				        <a href="${addProjectURL}" class="btn btn-primary btn-sm"><liferay-ui:message key="Add-Project" /></a>
				    </c:when>
                </c:choose>
 
</div>
  <div class="card-body mb-0 pb-0">

    <liferay-portlet:renderURL varImpl="iteratorURL" />
    <liferay-ui:search-container total="${projectSearchContainer.total }" delta="${delta}" searchContainer="${projectSearchContainer}"  emptyResultsMessage="no-project-data" iteratorURL="${iteratorURL}">

        <liferay-ui:search-container-results results="${projectSearchContainer.results }" />
        <liferay-ui:search-container-row className="package ax.hrms.project.web.dto.ProjectDetailsDto;" modelVar="project" keyProperty="projectId">
            <liferay-ui:search-container-column-text name="Project Name" cssClass="text-center" value="${project.projectName}" />
            <liferay-ui:search-container-column-text name="Project Status" cssClass="text-center" value="${project.projectStatus}" />
            <liferay-ui:search-container-column-text name="Start Date of Project"cssClass="text-center"  value="${project.startDate}" />
            <liferay-ui:search-container-column-text name="isBillable" cssClass="text-center" value="${project.isBillable}" />

            <liferay-ui:search-container-column-text name="Action" cssClass="text-center">
               
                
              
                
                <portlet:renderURL var="updateProjectDetailsURL">
                    <portlet:param name="mvcRenderCommandName" value="/fetchProjectDetails" />
                    <portlet:param name="projectId" value="${project.projectId}" />
                    <portlet:param name="command" value="update" />
                </portlet:renderURL>
                
                <portlet:renderURL var="viewProjectDetailsURL">
                    <portlet:param name="mvcRenderCommandName" value="/fetchProjectDetails" />
                    <portlet:param name="projectId" value="${project.projectId}" />
                </portlet:renderURL>

                <c:choose>
                   <c:when test="${isManager}">
                   
                   
                   <div class="dropdown ">
					<button class="btn fa fa-ellipsis-v dropdown-toggle"
						data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
						<i class="icon-ellipsis-vertical"></i>
					</button>
					<ul class="dropdown-menu">
						<li><a href="${viewProjectDetailsURL }" class="dropdown-item "><i class="icon-eye-open"></i> <liferay-ui:message
						key="view" /></a></li>
						<li><a href="${updateProjectDetailsURL }" class=" dropdown-item"><i class="icon-edit"></i> <liferay-ui:message
						key="edit" /></a></li>
						<li><a class="dropdown-item"
					onclick="deleteData('${project.projectId}')"><i class="icon-trash"></i> <liferay-ui:message
						key="delete" /></a></li>
					</ul>
				</div>
                   
                   
                   
                   
      				    </c:when>
				    <c:otherwise>

			 <div class="dropdown ">
								<button class="btn fa fa-ellipsis-v dropdown-toggle"
									data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
									<i class="icon-ellipsis-vertical"></i>
								</button>
								<ul class="dropdown-menu">
									<li><a href="${viewProjectDetailsURL }" class="dropdown-item "><i class="icon-eye-open"></i> <liferay-ui:message
									key="view" /></a></li>
								</ul>
							</div>
				    </c:otherwise>
                </c:choose>
            </liferay-ui:search-container-column-text>
        </liferay-ui:search-container-row>
        <liferay-ui:search-iterator searchContainer="${projectSearchContainer}" markupView="lexicon" paginate="true"/>
    </liferay-ui:search-container>

</div>
</div>







</body>
</html>

<script>


function deleteData(projectId){
	debugger;
	let deleteURL = '${deleteProjectDetailsURL}';
	deleteURL = deleteURL.replace('PROJECTID', projectId);
	if(confirm('Are you sure you want to delete ?')) 
		window.location.href = deleteURL;
		
}

</script>
