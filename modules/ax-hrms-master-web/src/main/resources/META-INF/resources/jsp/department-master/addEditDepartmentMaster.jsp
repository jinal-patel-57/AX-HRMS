<%@ include file="/init.jsp"%>

<portlet:actionURL name="/saveDepartmentsDetails" var="saveDepartmentsDetails" />
<liferay-ui:error key="departmentExists" message="Department Name is Already Exist!!!" />


<body>
	<form action="${saveDepartmentsDetails}" method="post" id="departmentForm">

<div class="card">
  <div class="card-header">
  <strong> <liferay-ui:message key='add-department' /></strong>
  </div>
  <div class="card-body mb-0">

		<div class="form-group">
			<label class="" for="departmentName"><liferay-ui:message key="department-name-label" /><span class="text-danger">*</span></label>
				<input id="<portlet:namespace />departmentName" placeholder="<liferay-ui:message key='department-name-placeholder' />" class="form-control" type="text" name="<portlet:namespace/>departmentName"
				value="${not empty getdepartmentMaster ? getdepartmentMaster.departmentName : (not empty existedDepartmentName ? existedDepartmentName : '')}">
			<label id="departmentName-error" class="error text-danger" for="departmentName"></label>
		</div>
		<input type="hidden" id="departmentMasterId" name="<portlet:namespace/>departmentMasterId" value="${getdepartmentMaster.departmentMasterId}">
</div>
  <div class="card-footer">
		<div class="form-group text-right mb-0">
			<a href="<liferay-portlet:renderURL portletMode='view' windowState='normal' />" class="btn btn-outline-danger mr-1"><liferay-ui:message key="back-button" /></a>
			<button class="btn btn-outline-success" type="submit"><liferay-ui:message key="submit" /></button>
		</div>
  
  </div>
</div>
	</form>
</body>



<script type="text/javascript">
$(document).ready(function () {
	var config = new Object({}),
	namespace = '<portlet:namespace />';
	config.namespace = namespace;
	AxDepartmentMasterWebPortlet.setConfigsForValidation(config);

});
</script>

