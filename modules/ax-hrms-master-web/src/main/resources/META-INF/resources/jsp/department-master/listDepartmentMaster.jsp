<%@ include file="/init.jsp"%>

<portlet:renderURL var="departmentForm">
	<portlet:param name="mvcPath" value="/jsp/department-master/addEditDepartmentMaster.jsp" />
</portlet:renderURL>

<liferay-ui:success key="departmentDeleted" message="Department has been deleted successfully." />
<liferay-ui:error key="departmentNotFound" message="Department Not Found .." />
<liferay-ui:success key="departmentAdded" message="Department has been successfully Inserted." />

<liferay-portlet:renderURL varImpl="iteratorURL" />




<div class="card">
  <div class="card-header d-flex align-items-center justify-content-end">
  
  <!-- add-button -->
		<a href="${departmentForm}" class="btn  btn-primary btn-sm "><liferay-ui:message key="add-department" /></a>
  </div>
  <div class="card-body">  
<liferay-ui:search-container total="${departmentMastersCount}" delta="${delta}" emptyResultsMessage="no-Department-found" iteratorURL="${iteratorURL}">
  <liferay-ui:search-container-results results="${departmentMasters}" />

    <liferay-ui:search-container-row className="com.ax.hrms.master.model.DepartmentMaster" modelVar="departmentMaster" keyProperty="departmentMasterId">
        <liferay-ui:search-container-column-text name="Department Name" value="${departmentMaster.departmentName}" />

        <liferay-ui:search-container-column-text name="Actions" cssClass="text-center">
        
        	<!-- edit button -->
            <portlet:renderURL var="updateDataURL">
                <portlet:param name="mvcRenderCommandName" value="/showDepartmentDataById" />
                <portlet:param name="departmentMasterId" value="${departmentMaster.departmentMasterId}" />
            </portlet:renderURL>
	        
	        <!-- delete Button -->
			<portlet:actionURL name="/deleteRecordById" var="deleteDepartmentURL">
				<portlet:param name="departmentMasterId" value="DEPARTMENT_MASTER_ID" /> 
				<portlet:param name="iteratorURL" value="${iteratorURL}" />
			</portlet:actionURL>
			
            <!-- view Button --> 
            <portlet:renderURL var="viewDepartmentMasterRecord">
                <portlet:param name="mvcRenderCommandName" value="/viewDepartmentDataById" />
                <portlet:param name="departmentMasterId" value="${departmentMaster.departmentMasterId}" />
            </portlet:renderURL>
            
            
            
            <div class="dropdown ">
					<button class="btn fa fa-ellipsis-v dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" >
						<i class="icon-ellipsis-vertical"></i>
					</button>
					<ul class="dropdown-menu">
						<li>
						<a href="${viewDepartmentMasterRecord }" class="dropdown-item "><i class="icon-eye-open"></i> <liferay-ui:message
						key="view-button" /></a>
						</li>
						<li>
						<a href="${updateDataURL }" class=" dropdown-item"><i class="icon-edit"></i> <liferay-ui:message
						key="edit-button" /></a>
						</li>
						<li>
						<a class="dropdown-item"
					onclick="deleteAction('${departmentMaster.departmentMasterId}')"><i class="icon-trash"></i> <liferay-ui:message
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

	
	
	
  









<script type="text/javascript">
function deleteAction(departmentMasterId){		
	var config = new Object({}),
	namespace = '<portlet:namespace />';
	config.namespace = namespace;
	config.deleteDepartmentURL = '${deleteDepartmentURL}';
	config.departmentMasterId = departmentMasterId;
	AxDepartmentMasterWebPortlet.setConfigsForDeleteDepartment(config);
}
</script>