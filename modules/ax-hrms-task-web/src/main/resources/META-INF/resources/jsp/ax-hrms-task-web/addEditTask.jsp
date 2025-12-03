
<%@ include file="init.jsp"%>

<%--SESSION_MESSAGES Start Here--%>
                
      
<%--SESSION_MESSAGES End Here--%>

<!-- Different URL Start -->
<portlet:renderURL var="homeUrl" >
<portlet:param name="projectId" value="${empty project ? taskDto.projectId : project.getProjectId() }" />
</portlet:renderURL>
 <portlet:actionURL name="/addUpdateTask" var="addTaskURL">
<portlet:param name="backURL" value="${homeUrl}" />
 </portlet:actionURL>
 
  
 
 
                    
 <portlet:renderURL var="timeTrackerURL" >
                     <portlet:param name="mvcRenderCommandName" value="/listLogTime" />
<portlet:param name="taskId" value="${taskDto.taskId}" />
                     
 </portlet:renderURL>
 
<%--  <liferay-ui:success key="Add-log-time" message="Log Time is SuccessFully Added !!"></liferay-ui:success> --%>
 <liferay-ui:success key="task-review-added" message="Task Review is SuccessFully Added !!"></liferay-ui:success>
 <liferay-ui:success key="Update-log-time" message="Log Time is SuccessFully Updated !!"></liferay-ui:success>
 <liferay-ui:success key="logTime-rejected" message="Log Time is Rejected !!"></liferay-ui:success>
<liferay-ui:success key="logTime-approved" message="Log Time is Approved !!"></liferay-ui:success>
<liferay-ui:success key="timeTracker-deleted" message="Log Time is Deleted Successfully !!"></liferay-ui:success>
 
<script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/5.3.0/js/bootstrap.bundle.min.js"></script> 



<div class="card">
  <div class="card-header"><strong> <liferay-ui:message key="add-task"></liferay-ui:message>  </strong></div>
   <form method="Post" action="${addTaskURL }" id="addTaskForm">
  <div class="card-body mb-0">
  <div class="row ">

	<!-- Different URL End -->
                <input type="hidden" value="${taskDto.taskId}" id="<portlet:namespace/>taskId" name="<portlet:namespace/>taskId" /> 
                <input type="hidden" value="${empty project ? taskDto.projectId : project.getProjectId()}" id="<portlet:namespace/>projectId" name="<portlet:namespace/>projectId" />
  <div class="col-md-4 col-sm-12 ">
                <div class="form-group">
                    <label for="<portlet:namespace />taskName"><liferay-ui:message key="task-name"/><span class="text-danger">*</span></label>
                    <input type="text" class="form-control" id="taskName" name="<portlet:namespace />taskName" value="${not empty taskDto.taskName ? taskDto.taskName : ''}"/>
                </div>
                </div>
         <div class="col-md-4 col-sm-12 ">        
                <div class="form-group mt-4 pt-1">
                    <input type="checkbox"  id="isSubTask" name="<portlet:namespace />isSubTask" ${not empty taskDto.isSubTask && taskDto.isSubTask == 'Yes' ? 'checked':''}/>
                    <label for="<portlet:namespace />isSubTask"><liferay-ui:message key="is-sub-task"/></label>
                </div>
                </div>
                 <div class="col-md-4 col-sm-12 ">
                <div class="form-group">
                    <label for="<portlet:namespace />mainTask"><liferay-ui:message key="main-task"/></label>
                    <select class="form-control" id="mainTask" name="<portlet:namespace />mainTask">
                        <option value="">--Select Main Task--</option>
                        
                         <c:forEach var="task" items="${taskList}">
				            <option value="${task.getTaskId()}"
				              ${taskDto.mainTaskId == task.getTaskId() ? 'selected' : ''} >
				            ${task.getTaskName()}
				               
				            </option>
	       				 </c:forEach>
                    </select>
                </div>
                </div>
                 <div class="col-md-4 col-sm-12 ">
                 <div class="form-group">
                    <label for="<portlet:namespace />project"><liferay-ui:message key="project"/></label>
                     <input type="text" class="form-control" id="project" name="<portlet:namespace />project" value="${empty project.getProjectName()? not empty taskDto.projectName ? taskDto.projectName :'': project.getProjectName()}" disabled/>
                    
                </div>
                </div>
                 
                 <div class="col-md-4 col-sm-12 ">
                <div class="form-group">
                    <label for="<portlet:namespace />assignedTo"><liferay-ui:message key="assigned-to"/><span class="text-danger">*</span></label>
                    <select class="form-control" id="assignedTo" name="<portlet:namespace />assignedTo">
                        <option value="">--Select Assignee--</option>
                         <c:forEach var="employee" items="${employeeList}">
				            <option value="${employee.getEmployeeId()}" 
				            ${not empty taskDto.assignedTo && taskDto.assignedTo eq employee.getEmployeeId() ? 'selected' : '' }>
				           ${employee.getEmployeeCode() }: ${employee.getFirstName()} ${employee.getLastName() }
				               
				            </option>
	       				 </c:forEach>
                    </select>
                </div>
                </div>
                 <div class="col-md-4 col-sm-12 ">
                <div class="form-group">
                    <label for="<portlet:namespace />projectTaskStatusMaster"><liferay-ui:message key="project-task-status-master"/><span class="text-danger">*</span></label>
                    <select class="form-control" id="projectTaskStatusMaster" name="<portlet:namespace />projectTaskStatusMaster">
                        <option value="">--Select Task Status--</option>
                         <c:forEach var="status" items="${statusList}">
				            <option value="${status.getProjectTaskStatusMasterId()}" 
				            ${not empty taskDto.projectTaskStatusId && taskDto.projectTaskStatusId eq status.getProjectTaskStatusMasterId() ? 'selected': '' }>
				            ${status.getProjectTaskStatusName()}
				               
				            </option>
	       				 </c:forEach>
                    </select>
                </div>
                </div>
                 <div class="col-md-4 col-sm-12 ">
                <div class="form-group">
                    <label for="<portlet:namespace />priority"><liferay-ui:message key="priority"/><span class="text-danger">*</span></label>
                    <select class="form-control" id="priority" name="<portlet:namespace />priority">
                        <option value="">--Select Priority--</option>
                         <c:forEach var="priority" items="${priorityList}">
				            <option value="${priority.getPriorityMasterId()}" 
				            ${not empty taskDto.priorityId && taskDto.priorityId eq priority.getPriorityMasterId() ? 'selected' :'' }>
				            ${priority.getPriorityName()}
				               
				            </option>
	       				 </c:forEach>
                    </select>
                </div>
                </div>
                 <div class="col-md-4 col-sm-12 ">
                 <div class="form-group mt-4 pt-1">
                            
                
                    <input type="checkbox"  id="isBillable" name="<portlet:namespace />isBillable" ${not empty taskDto.isBillable && taskDto.isBillable == 'Yes' ? 'checked':''} />
                    <label for="<portlet:namespace />isBillable"><liferay-ui:message key="is-billable"/><span class="text-danger">*</span></label>
                </div>
                </div>
                 <div class="col-md-4 col-sm-12 ">
                
                <div class="form-group">
                    <label for="<portlet:namespace />estimatedHours"><liferay-ui:message key="estimatedHours"/><span class="text-danger">*</span></label>
                    <input type="number" class="form-control" id="estimatedHours" name="<portlet:namespace />estimatedHours" value="${not empty taskDto.estimatedHours ? taskDto.estimatedHours : ''}"/>
                </div>
                </div>
                 <div class="col-md-4 col-sm-12 ">
                
                <div class="form-group">
                            <fmt:formatDate value="${taskDto.assignDate}" pattern="yyyy-MM-dd" var="formatedAssignDate"/> 
                
                    <label for="<portlet:namespace />assignDate"><liferay-ui:message key="assign-date"/><span class="text-danger">*</span></label>
                    <input type="date" class="form-control" id="assignDate" name="<portlet:namespace />assignDate" value="${formatedAssignDate }">
                </div>
                </div>
                 <div class="col-md-4 col-sm-12 ">
                <div class="form-group">
                                         <fmt:formatDate value="${taskDto.startDate}" pattern="yyyy-MM-dd" var="formatedStartDate"/> 
                
                    <label for="<portlet:namespace />startDate"><liferay-ui:message key="start-date"/></label>
                    <input type="date" class="form-control" id="startDate" name="<portlet:namespace />startDate" value="${formatedStartDate}">
                </div>
                </div>
                 <div class="col-md-4 col-sm-12 ">
                
                <div class="form-group">
                             <fmt:formatDate value="${taskDto.dueDate}" pattern="yyyy-MM-dd" var="formatedDueDate"/> 
                
                    <label for="<portlet:namespace />dueDate"><liferay-ui:message key="due-date"/><span class="text-danger">*</span></label>
                    <input type="date" class="form-control" id="dueDate" name="<portlet:namespace />dueDate" value="${formatedDueDate}">
                </div>
                </div>
                 <div class="col-md-4 col-sm-12 ">
                <div class="form-group">
                <fmt:formatDate value="${taskDto.completeDate}" pattern="yyyy-MM-dd" var="formatedCompleteDate"/> 
                    <label for="<portlet:namespace />completeDate"><liferay-ui:message key="complete-date"/></label>
                    <input type="date" class="form-control" id="completeDate" name="<portlet:namespace />completeDate" value="${formatedCompleteDate }">
                </div>
                </div>
                <div class="col-md-12 col-sm-12 ">
                <div class="form-group">
                    <label for="<portlet:namespace />description"><liferay-ui:message key="description"/></label>
                    <textarea class="form-control" cols="30" rows="4" id="description" name="<portlet:namespace />description" >${not empty taskDto.description ? taskDto.description : '' } </textarea>
                </div>
                </div>
	
				
</div>
</div>
  <div class="card-footer text-right mb-0">
                <a href="${homeUrl}" class="btn btn-outline-danger mr-1"><liferay-ui:message key="back"/></a>
  <button type="submit" class="btn btn-outline-success" id="submit"><liferay-ui:message key="submit"/></button>
  </div>
 
    </form>
            
            

 </div>



<c:if test="${isTableVisible}">
               
               
               <div id="">
   <div class="container mt-3">
        <!-- Navigation tabs -->
        <ul class="nav nav-tabs" id="stepperNav" role="tablist">
            <li class="nav-item" role="presentation">
                <button class="nav-link active" id="step1-tab" data-bs-toggle="tab" data-bs-target="#step1" type="button" role="tab" aria-controls="step1" aria-selected="true">
                    <liferay-ui:message key="Time Tracker"/>
                </button>
            </li>
            <li class="nav-item" role="presentation">
                <button class="nav-link" id="step2-tab" data-bs-toggle="tab" data-bs-target="#step2" type="button" role="tab" aria-controls="step2" aria-selected="false">
                    <liferay-ui:message key="Review"/>
                </button>
            </li>
         
        </ul>
        
        <div class="tab-content" id="stepperContent">
            <!-- Step 1 -->
            <div class="tab-pane fade show active" name="step1" id="step1" role="tabpanel" aria-labelledby="step1-tab">
				<jsp:include page="/jsp/ax-hrms-task-web/listLogTime.jsp" flush="true"/>			
            </div>
			
			<!-- step 2 -->
            <div class="tab-pane fade" name="step2" id="step2" role="tabpanel" aria-labelledby="step2-tab">
			    <jsp:include page="/jsp/ax-hrms-task-web/taskReview.jsp" flush="true"/>
			</div>
			
	       
</div>
</div>
               
                      
               
		 		
</c:if>
<br/>



 <script>
 $(document).ready(function(){
 	var config = new Object({}),
 	namespace = '<portlet:namespace />',
	homeURL= '${homeUrl}',
	addTaskURL = '${addTaskURL}',
 	
	taskName  ='taskName' , 
	 mainTask  ='mainTask' ,
	 project  ='project' ,
	 description = 'description',
	 assignedTo = 'assignedTo' ,
	 projectTaskStatusMaster = 'projectTaskStatusMaster' ,
	 priority = 'priority',
	 assignDate = 'assignDate',
	 startDate =  'startDate',
	 completeDate = 'completeDate',
	 dueDate = 'dueDate',
	 estimatedHours = 'estimatedHours',
	 <c:if test="${isManager}">
     isManager = true;
     </c:if>
     <c:if test="${!isManager}">
     isManager = false;
     </c:if>
	
	
	
	
	
 	config.namespace = namespace;
 	config.homeURL = homeURL;
 	config.addTaskURL = addTaskURL;
 	config.taskName = taskName;
	config.mainTask= mainTask;
	config.project= project;
	config.description= description;
	config.assignedTo= assignedTo;
	config.projectTaskStatusMaster= projectTaskStatusMaster;
	config.priority= priority;
	config.startDate= startDate;
	config.assignDate= assignDate;
	config.dueDate= dueDate;
	config.completeDate= completeDate;
	config.isManager= isManager;
	config.estimatedHours= estimatedHours;
 		
 		
 		
 		
 		
 	AxHrmsTaskWebPortlet.setConfigs(config);
 });	
 </script>

