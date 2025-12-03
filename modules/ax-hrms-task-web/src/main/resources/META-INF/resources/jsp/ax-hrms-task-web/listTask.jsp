<%@ include file="init.jsp"%>

<!-- Different URL Start -->
<portlet:renderURL var="addTaskURL">
	<portlet:param name="mvcRenderCommandName" value="/addTask" />
	<portlet:param name="projectId" value="PROJECTID" />

</portlet:renderURL>

<portlet:renderURL var="listTaskURL">
	<portlet:param name="mvcRenderCommandName" value="/" />
	<portlet:param name="projectId" value="PROJECTID" />
</portlet:renderURL>
<portlet:renderURL var="homeUrl">
	<portlet:param name="projectId" value="PROJECTID" />
</portlet:renderURL>

<portlet:actionURL name="/deleteTask" var="deleteTaskURL">
	<portlet:param name="taskId" value="TASKID" />
	<portlet:param name="projectId" value="PROJECTID" />
	<portlet:param name="backURL" value="${homeUrl }" />

</portlet:actionURL>


<%--Different URL End Here--%>

<%--SESSION_MESSAGES Start Here--%>
<liferay-ui:success key="task-added"
	message="Task is SuccessFully Added !!"></liferay-ui:success>
<liferay-ui:success key="task-updated"
	message="Task is SuccessFully Updated !!"></liferay-ui:success>
<liferay-ui:success key="task-deleted"
	message="Task is SuccessFully Deleted !!"></liferay-ui:success>
<liferay-ui:success key="task-review"
	message="Task is SuccessFully Reviewed !!"></liferay-ui:success>
<liferay-ui:success key="Add-log-time"
	message="Log Time is SuccessFully Added !!"></liferay-ui:success>
<liferay-ui:success key="timeTracker-deleted"
	message="Log Time is SuccessFully Deleted !!"></liferay-ui:success>

<liferay-ui:error key="error" message="some error is occurs !!!"></liferay-ui:error>




<div class="card">
  <div class="card-header d-flex align-items-center justify-content-between">
  <div class="">
			<select
				class="form-control " id="project"
				name="<portlet:namespace/>projectId">
				<option value=""><liferay-ui:message key="select-project" /></option>
				<c:forEach var="projectList" items="${projectList}">

					<option value="${projectList.getProjectId() }"
						${not empty project ?(projectList.getProjectId()==project.getProjectId()?  'selected':''):''}>
						${ projectList.getProjectName()}</option>
				</c:forEach>
			</select>
			</div>

<c:choose>
				<c:when test="${isManager && isVisible}">
					<a class="btn btn-primary btn-sm" id="addTask"><liferay-ui:message
							key="add-task" /></a>
							
							
				</c:when>
			</c:choose>
			
</div>
  <div class="card-body mb-0 pb-0">

<liferay-portlet:renderURL varImpl="iteratorURL">
</liferay-portlet:renderURL>

<liferay-ui:search-container total="${taskSearchContainer.total}"
	delta="3" emptyResultsMessage="no-task-data"
	searchContainer="${taskSearchContainer}" iteratorURL="${iteratorURL}">
	<liferay-ui:search-container-results
		results="${taskSearchContainer.results}" />

	<%-- <liferay-ui:search-container-results results="${taskList}" /> --%>
	<liferay-ui:search-container-row
		className="ax.hrms.task.web.dto.TaskDto" modelVar="task"
		keyProperty="taskId">


		<portlet:renderURL var="viewTaskURL">
			<portlet:param name="mvcRenderCommandName" value="/fetchTaskDetails" />
			<portlet:param name="taskId" value="${task.taskId}" />
			<portlet:param name="projectId" value="${task.projectId}" />
		</portlet:renderURL>


		<liferay-ui:search-container-column-text name="Task Name"
			value="${task.taskName}" href="${viewTaskURL }" />
		<liferay-ui:search-container-column-text name="is Sub Task"
			value="${task.isSubTask}" />
		<liferay-ui:search-container-column-text name="Main Task Name"
			value="${task.mainTaskName}" />
		<liferay-ui:search-container-column-text name="Project Name"
			value="${task.projectName}" />
		<liferay-ui:search-container-column-text name="ProjectTask Status"
			value="${task.projectTaskStatus}" />
		<liferay-ui:search-container-column-text name="Priority"
			value="${task.priority}" />
		<liferay-ui:search-container-column-text name="isBillable"
			value="${task.isBillable}" />

		<liferay-ui:search-container-column-text name="Action" cssClass="text-center">




			<portlet:renderURL var="updateTaskURL">
				<portlet:param name="mvcRenderCommandName" value="/addTask" />
				<portlet:param name="taskId" value="${task.taskId}" />
				<portlet:param name="projectId" value="${task.projectId}" />
			</portlet:renderURL>






			<portlet:renderURL var="addLogTimeURL">
				<portlet:param name="mvcRenderCommandName" value="/addLogTime" />
				<portlet:param name="taskId" value="${task.taskId}" />
			</portlet:renderURL>
			<c:choose>
    <c:when test="${task.projectTaskStatus ne 'Completed' }">
        <c:choose>
            <c:when test="${employeeId eq task.assignedTo}">
                
                <div class="dropdown ">
					<button class="btn fa fa-ellipsis-v dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" >
						<i class="icon-ellipsis-vertical"></i>
					</button>
					<ul class="dropdown-menu">
						<li>
						<a href="${updateTaskURL }" class=" dropdown-item"><i class="icon-edit"></i> <liferay-ui:message
						key="Edit" /></a>
						</li>
						<li>
						<a href="${addLogTimeURL }" class=" dropdown-item"><i class="icon-plus"></i><liferay-ui:message
						key="AddLogTime" /></a>
						</li>
					</ul>
				</div>
				
            </c:when>
            <c:when test="${isManager}">
                 <div class="dropdown ">
					<button class="btn fa fa-ellipsis-v dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" >
						<i class="icon-ellipsis-vertical"></i>
					</button>
					<ul class="dropdown-menu">
						<li>
						<a href="${updateTaskURL }" class=" dropdown-item"><i class="icon-edit"></i> <liferay-ui:message
						key="Edit" /></a>
						</li>
						<li>
						<a class="dropdown-item"
					onclick="deleteTask(${task.taskId},${task.projectId })"><i class="icon-trash"></i> <liferay-ui:message
						key="Delete" />
						</a></li>
					</ul>
				</div>
            </c:when>
        </c:choose>
    </c:when>
</c:choose>

		</liferay-ui:search-container-column-text>
	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator searchContainer="${taskSearchContainer}"
		markupView="lexicon" paginate="true" />
</liferay-ui:search-container>




</div>
</div>

<%--SESSION_MESSAGES End Here--%>






<script type="text/javascript">


$(document).ready(function(){
 	var config = new Object({}),
 	namespace = '<portlet:namespace />',
 	listTaskURL = '${listTaskURL}';
 	addTaskURL = '${addTaskURL}';
 	homeURL = '${homeUrl}';

 	config.namespace = namespace;
 	config.listTaskURL = listTaskURL;
 	config.homeURL = homeURL;
 	config.addTaskURL = addTaskURL;	
 	AxHrmsTaskWebPortlet.setListTaskConfigs(config);
 });



 
 function deleteTask(taskId,projectId){
	 	var config = new Object({}),
	 	namespace = '<portlet:namespace />',
	 	deleteTaskURL = '${deleteTaskURL}';
	 	
	 	config.namespace = namespace;
	 	config.deleteTaskURL = deleteTaskURL;
	 	config.taskId = taskId;
	 	config.projectId = projectId;
	 	

	 	

	 	
	 	AxHrmsTaskWebPortlet.setDeleteConfigs(config);
 }
 

</script>
