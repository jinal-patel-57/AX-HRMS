<%@ include file="/init.jsp"%>
<portlet:actionURL name="/addUpdateProject" var="addUpdateProjectURL"></portlet:actionURL>
<portlet:renderURL var="homeUrl" />

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title><liferay-ui:message key="add-project"/></title>
</head>




<body>


<div class="card">
  <div class="card-header"><strong> <liferay-ui:message key="add-project"></liferay-ui:message>  </strong></div>
   <form action="${addUpdateProjectURL}" method="post" id="addProjectForm">
  
  <div class="card-body mb-0">
  <div class="row ">
          	<input type="hidden" name="<portlet:namespace/>projectId" value="${ projectDto.projectId}"> 
  
  <div class="col-md-4 col-sm-12 ">
    <div class="form-group">
                <label for="projectName"><liferay-ui:message key="project-name"/><span class="text-danger">*</span></label>
                <input type="text" class="form-control" id="projectName" name="<portlet:namespace/>projectName" value="${projectDto.projectName }">
               
            </div>
  </div>
	
 
	
  <div class="col-md-4 col-sm-12 ">
   <div class="form-group">
    <label for="projectStatus"><liferay-ui:message key="project-status"/><span class="text-danger">*</span></label>
    <select class="form-control" id="projectStatus" name="<portlet:namespace/>projectStatus" >
        <option value=""><liferay-ui:message key="select-project-status"/></option>
        <c:forEach var="status" items="${statusList}">
            <option value="${status.getProjectTaskStatusMasterId()}" 
                ${!empty projectDto.projectStatus && projectDto.projectStatus eq status.getProjectTaskStatusName() ? 'selected' : ''}>
                ${status.getProjectTaskStatusName()}
            </option>
        </c:forEach>
    </select>
    
</div>
  </div>
	
  <div class="col-md-4 col-sm-12 ">
    <div class="form-group">
                <label><liferay-ui:message key="isBillable"/><span class="text-danger">*</span></label><br>
                <div class="form-check form-check-inline">
                    <input class="form-check-input" type="radio" id="billableYes" name="<portlet:namespace/>isBillable" value="Yes" ${projectDto.isBillable =='Yes' ? 'checked' : ''}>
                    <label class="form-check-label" for="billableYes">Yes</label>
                </div>
                <div class="form-check form-check-inline">
                    <input class="form-check-input" type="radio" id="billableNo" name="<portlet:namespace/>isBillable" value="No" ${projectDto.isBillable =='No' ? 'checked' : ''}>
                    <label class="form-check-label" for="billableNo">No</label>
                </div>
               
            </div>
  </div>
  <div class="col-md-4 col-sm-12 ">
  <div class="form-group">
                <label for="employees"><liferay-ui:message key="employees"/><span class="text-danger">*</span></label>
                <select class="form-control" id="employees"  name="<portlet:namespace/>employees" >
                    <option value=""><liferay-ui:message key="select-employees"/></option>
                    <c:forEach var="employee" items="${employeeList}">
                        <option value="${employee.getEmployeeId()}">${employee.getEmployeeCode()} : ${employee.getFirstName()} ${employee.getLastName()}</option>
                    </c:forEach>
                </select>
                <div id="selectedOptionsContainerAttendees"></div>
                <input  type="hidden" value="" name="<portlet:namespace/>teamId" id="employeesHidden" />
               
            </div>
            
  </div>
  <div class="col-md-4 col-sm-12 ">
   <fmt:formatDate value="${projectDto.startDateOfProject}" pattern="yyyy-MM-dd" var="formatedStartDate"/> 
            <div class="form-group">
                <label for="startDate"><liferay-ui:message key="start-date"/><span class="text-danger">*</span></label>
                <input type="date" class="form-control" id="startDate" name="<portlet:namespace/>startDate" value="${formatedStartDate}">
               
            </div>
            
  </div>
   <div class="col-12">
      <div class="form-group">
                <label for="description"><liferay-ui:message key="description"/></label>
                <textarea class="form-control" id="description" name="<portlet:namespace/>description">${projectDto.description }</textarea>
                
            </div>
  </div>
				
</div>
</div>
  <div class="card-footer text-right mb-0">
             <a href="${homeUrl}" class="btn btn-outline-danger mr-1">
                <liferay-ui:message key="back"/>
            </a>
  <button type="submit" class="btn btn-outline-success" id="submit"><liferay-ui:message key="submit"/></button>
  
  </div>
        </form>
 </div>
        
        
          
            
        
            
           

          
            
          
           
           
            
   
    
   
    
    
     <script>
 $(document).ready(function(){
 	var config = new Object({}),
 	namespace = '<portlet:namespace />',
 	listOfAssignee = '${listOfAssignee}',
 	projectName = 'projectName',
 	description= 'description',
 	projectStatus = 'projectStatus',
 	employees = 'employees',
 	isBillable = 'isBillable',
 	startDate = 'startDate';
 	
 	
 
 	
 	config.namespace = namespace;
 	config.listOfAssignee = listOfAssignee;
 	config.projectName = projectName;
 	config.description = description;
 	config.projectStatus = projectStatus;
 	config.employees = employees;
 	config.isBillable = isBillable;
 	config.startDate = startDate;
 

 	
 	AxHrmsProjectWebPortlet.setConfigs(config);
 });	
 </script>
    
</body>
</html>
