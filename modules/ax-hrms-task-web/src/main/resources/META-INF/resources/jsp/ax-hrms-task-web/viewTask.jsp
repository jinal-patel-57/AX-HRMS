<%@ include file="init.jsp"%>

<portlet:renderURL var="homeUrl" >
<portlet:param name="projectId" value="${taskDto.projectId }" />
</portlet:renderURL>



<div class="card">

  <div class="card-header"> <strong> <liferay-ui:message key="task-details"></liferay-ui:message>  </strong></div>  
  <div class="card-body">  
  
  
  <div class="row">


							<div class="col-lg-4 col-md-4 col-sm-6 col-xs-12 ">
								<div class="form-group-view">
									<div class="label-name"><liferay-ui:message key="task-name"/></div>
									<div class="label-content">${taskDto.taskName}</div>
								</div>
							</div>
							<div class="col-lg-4 col-md-4 col-sm-6 col-xs-12 ">
								<div class="form-group-view">
									<div class="label-name"><liferay-ui:message key="is-sub-task"/></div>
									<div class="label-content">${taskDto.isSubTask}</div>
								</div>
							</div>
							<div class="col-lg-4 col-md-4 col-sm-6 col-xs-12 ">
								<div class="form-group-view">
									<div class="label-name"><liferay-ui:message key="main-task"/></div>
									<div class="label-content">${taskDto.mainTaskName}</div>
								</div>
							</div>

							<div class="col-lg-4 col-md-4 col-sm-6 col-xs-12 ">
								<div class="form-group-view">
									<div class="label-name"><liferay-ui:message key="project"/></div>
									<div class="label-content">${taskDto.projectName}</div>
								</div>
							</div>
							<div class="col-lg-4 col-md-4 col-sm-6 col-xs-12 ">
								<div class="form-group-view">
									<div class="label-name"><liferay-ui:message key="description"/></div>
									<div class="label-content">${taskDto.description}</div>
								</div>
							</div>
							<div class="col-lg-4 col-md-4 col-sm-6 col-xs-12">
								<div class="form-group-view">
									<div class="label-name"><liferay-ui:message key="project-task-status-master"/></div>
									<div class="label-content">${taskDto.projectTaskStatus}</div>
								</div>
							</div>
                            <div class="col-lg-4 col-md-4 col-sm-6 col-xs-12">
								<div class="form-group-view">
									<div class="label-name"><liferay-ui:message key="priority"/></div>
									<div class="label-content">${taskDto.priority}</div>
								</div>
							</div>
                            <div class="col-lg-4 col-md-4 col-sm-6 col-xs-12">
								<div class="form-group-view">
									<div class="label-name"><liferay-ui:message key="EstimatedHours"/></div>
									<div class="label-content">${taskDto.estimatedHours}</div>
								</div>
							</div>
							<fmt:formatDate value="${taskDto.assignDate}" pattern="dd-MM-yyyy" var="formatedAssignDate"/> 
							
                            <div class="col-lg-4 col-md-4 col-sm-6 col-xs-12">
								<div class="form-group-view">
									<div class="label-name"><liferay-ui:message key="assign-date"/></div>
									<div class="label-content">${formatedAssignDate}</div>
								</div>
							</div>
				             <fmt:formatDate value="${taskDto.dueDate}" pattern="dd-MM-yyyy" var="formatedDueDate"/> 
							
                            <div class="col-lg-4 col-md-4 col-sm-6 col-xs-12">
								<div class="form-group-view">
									<div class="label-name"><liferay-ui:message key="due-date"/></div>
									<div class="label-content">${formatedDueDate}</div>
								</div>
							</div>
							
	                         <fmt:formatDate value="${taskDto.startDate}" pattern="dd-MM-yyyy" var="formatedStartDate"/> 
							
                            <div class="col-lg-4 col-md-4 col-sm-6 col-xs-12">
								<div class="form-group-view">
									<div class="label-name"><liferay-ui:message key="start-date"/></div>
									<div class="label-content">${formatedStartDate}</div>
								</div>
							</div>
				            <fmt:formatDate value="${taskDto.completeDate}" pattern="dd-MM-yyyy" var="formatedCompleteDate"/> 
							
                            <div class="col-lg-4 col-md-4 col-sm-6 col-xs-12">
								<div class="form-group-view">
									<div class="label-name"><liferay-ui:message key="complete-date"/></div>
									<div class="label-content">${formatedCompleteDate}</div>
								</div>
							</div>
                            <div class="col-lg-4 col-md-4 col-sm-6 col-xs-12">
								<div class="form-group-view">
									<div class="label-name"><liferay-ui:message key="isBillable"/></div>
									<div class="label-content">${taskDto.isBillable}</div>
								</div>
							</div>
                            <div class="col-lg-4 col-md-4 col-sm-6 col-xs-12">
								<div class="form-group-view">
									<div class="label-name"><liferay-ui:message key="assignee-name"/></div>
									<div class="label-content">${taskDto.assignedEmployee}</div>
								</div>
							</div>
                            <div class="col-12">
                            <c:if test="${not empty reviewList}">
							<table class="table ">
							        <thead>
							            <tr>
							            
							                <th scope="col" width="170"><liferay-ui:message key="date-of-review"/></th>
							                
							                <th scope="col" class="text-break" ><liferay-ui:message key="review"/></th>
							            </tr>
							        </thead>
							          <c:forEach var="review" items="${reviewList}">
							    
							        <tbody>
							            <tr>
							             <fmt:formatDate value="${review.getDateOfReview()}" pattern="dd-MM-yyyy" var="formatedReviewDate"/> 
							                <td>
							                ${formatedReviewDate}
							                </td>
							                <td class="text-break">
							                
							                    ${review.getReview()}
							                </td>
							                    
							            </tr>
							        </tbody>
							    
							</c:forEach>
							</table>
							</c:if>
							</div>
						
						</div>
  
  
  
  
  
  
  </div>
  <div class="card-footer text-right mb-0">
            <a href="${homeUrl}" class="btn  btn-outline-danger">
                <liferay-ui:message key="back"/>
            </a>
</div>
</div>



          
            
   