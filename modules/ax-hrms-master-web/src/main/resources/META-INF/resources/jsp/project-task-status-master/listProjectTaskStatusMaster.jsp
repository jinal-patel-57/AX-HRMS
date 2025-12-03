<%@ include file="/init.jsp" %>

<portlet:renderURL var="addProjectTaskStatusMasterURL">
  <portlet:param name="mvcPath" value="/jsp/project-task-status-master/addEditProjectTaskStatusMaster.jsp" />
</portlet:renderURL>




<liferay-ui:error key="error-already-exist" message="project-task-status-already-exist" />
<liferay-ui:success key="success" message="project-task-status-success" />
<liferay-ui:success key="success-delete" message="project-task-status-delete" />
<liferay-ui:success key="success-edit" message="project-task-status-edit" />



<div class="card">
  <div class="card-header d-flex align-items-center justify-content-end">   <a href="${addProjectTaskStatusMasterURL}" class="btn btn-primary btn-sm"><liferay-ui:message key="add-project-task-status"/></a>
</div>
  <div class="card-body mb-0">


 <liferay-portlet:renderURL varImpl="iteratorURL" />

<liferay-ui:search-container
deltaConfigurable="${true}" total="${count}"  searchContainer="${projectTaskStatusMasterSC}"  delta="4" emptyResultsMessage="No Project Task Status Masters found!!, Please add one to Se it here." >
  <liferay-ui:search-container-results
    results="${projectTaskStatusMasterSC.results}" />

  <liferay-ui:search-container-row className="com.ax.hrms.master.model.ProjectTaskStatusMaster"
    modelVar="projectTaskStatusMaster" keyProperty="projectTaskStatusMasterId">
   
    <liferay-ui:search-container-column-text name="project-task-status-name"
      value="${projectTaskStatusMaster.projectTaskStatusName}" />

      <liferay-ui:search-container-column-text name="is-applicable-for-project"
      value="${projectTaskStatusMaster.isApplicableForProject}" />
  
      <liferay-ui:search-container-column-text name="is-applicable-for-task"
      value="${projectTaskStatusMaster.isApplicableForTask}" />
  
    <liferay-ui:search-container-column-text name="actions" cssClass="text-center">


    <portlet:renderURL var="projectTaskStatusMasterEditForm" >
      	<portlet:param name="mvcRenderCommandName" value="/fetchProjectTaskStatusMaster" />
        <portlet:param name="projectTaskStatusMasterId"
          value="${projectTaskStatusMaster.projectTaskStatusMasterId}" />
      </portlet:renderURL>

      <portlet:renderURL var="projectTaskStatusMasterView">
      	<portlet:param name="mvcRenderCommandName" value="/viewProjectTaskStatusMaster"/>
        <portlet:param name="projectTaskStatusMasterId"
          value="${projectTaskStatusMaster.projectTaskStatusMasterId}" />
      </portlet:renderURL>

      
      <portlet:actionURL name="/deleteProjectTaskStatusMaster" var="projectTaskStatusMasterDelete">
        <portlet:param name="projectTaskStatusMasterId"  value="${projectTaskStatusMaster.projectTaskStatusMasterId}"  />
        <portlet:param name="iteratorURL"  value="${iteratorURL}"  />
      </portlet:actionURL>

      <div class="dropdown ">
					<button class="btn fa fa-ellipsis-v dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" >
						<i class="icon-ellipsis-vertical"></i>
					</button>
					<ul class="dropdown-menu">
						<li>
						<a href="${projectTaskStatusMasterView }" class="dropdown-item "><i class="icon-eye-open"></i> <liferay-ui:message
						key="view-button" /></a>
						</li>
						<li>
						<a href="${projectTaskStatusMasterEditForm }" class=" dropdown-item"><i class="icon-edit"></i> <liferay-ui:message
						key="edit-button" /></a>
						</li>
						<li>
						<a class="dropdown-item" href="${projectTaskStatusMasterDelete}"
					  onclick="return confirm('You Are going to delete ${projectTaskStatusMaster.projectTaskStatusMasterId}')"><i class="icon-trash"></i> <liferay-ui:message
						key="delete-button" />
						</a></li>
					</ul>
				</div>
    </liferay-ui:search-container-column-text>
  </liferay-ui:search-container-row>

  <liferay-ui:search-iterator paginate="${true}" markupView="lexicon" searchContainer="${projectTaskStatusMasterSC}" />
</liferay-ui:search-container>
</div>
</div>
