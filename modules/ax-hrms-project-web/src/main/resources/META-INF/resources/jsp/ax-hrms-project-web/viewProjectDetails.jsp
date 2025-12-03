<%@ include file="/init.jsp"%>

<portlet:renderURL var="homeUrl" />




<div class="card">

  <div class="card-header"> <strong> <liferay-ui:message key="Project Details"></liferay-ui:message>  </strong></div>  
  <div class="card-body">  
  
  
  <div class="row">


		<div class="col-lg-4 col-md-4 col-sm-6 col-xs-12 ">
			<div class="form-group-view">
				<div class="label-name"><liferay-ui:message key="project-name"/></div>
				<div class="label-content">${projectDto.projectName}</div>
			</div>
							
		</div>
		<div class="col-lg-4 col-md-4 col-sm-6 col-xs-12 ">
			<div class="form-group-view">
				<div class="label-name"><liferay-ui:message key="description"/></div>
				<div class="label-content">${projectDto.description}</div>
			</div>
							
		</div>
		<div class="col-lg-4 col-md-4 col-sm-6 col-xs-12 ">
			<div class="form-group-view">
				<div class="label-name"><liferay-ui:message key="project-status"/></div>
				<div class="label-content">${projectDto.projectStatus}</div>
			</div>
							
		</div>
		<div class="col-lg-4 col-md-4 col-sm-6 col-xs-12 ">
			<div class="form-group-view">
				<div class="label-name"><liferay-ui:message key="start-date"/></div>
				<div class="label-content">${projectDto.startDate}</div>
			</div>
							
		</div>
		<div class="col-lg-4 col-md-4 col-sm-6 col-xs-12 ">
			<div class="form-group-view">
				<div class="label-name"><liferay-ui:message key="isBillable"/></div>
				<div class="label-content">${projectDto.isBillable}</div>
			</div>
							
		</div>
		<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 ">
		<c:if test="${not empty assigneeList}">
	 	 <table class="table">
        <thead>
            <tr>
                <th scope="col" class="col-4 label-name">  <liferay-ui:message key="employee-code"/></th>
                <th scope="col" class="col-4 label-name"><liferay-ui:message key="employee-name"/></th>
                <th scope="col" class="col-4 label-name"><liferay-ui:message key="employee-email"/></th>
            </tr>
        </thead>
          <c:forEach var="employee" items="${assigneeList}">
    
        <tbody>
            <tr class="label-content">
                <td>${employee.getEmployeeCode()}</td>
                <td>
                    ${employee.getFirstName()} ${employee.getLastName()}
                </td>
                    <td>
                        ${employee.getOfficialEmail()}
                    </td>
            </tr>
        </tbody>
    
</c:forEach>
</table>
</c:if>
							
		</div>
  
  
  
  
  
  
  </div>
  <div class="card-footer text-right mb-0">
            <a href="${homeUrl}" class="btn  btn-outline-danger">
                <liferay-ui:message key="back"/>
            </a>
</div>
</div>

  
    
