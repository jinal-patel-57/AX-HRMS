<%@page import="com.liferay.portal.kernel.util.PortalUtil"%>
<%@ include file="../../init.jsp"%>
<%
String currentURL = PortalUtil.getCurrentURL(request);
%>
<div class="container mt-5">

	<h3 class="mb-4">Import Employees</h3>

	<portlet:actionURL name="importEmployees" var="importEmployeesURL">
        <portlet:param name="redirect" value="<%= currentURL %>" />
    </portlet:actionURL>

	<form action="${importEmployeesURL}" method="post"
		enctype="multipart/form-data"
		class="p-4 border rounded shadow-sm bg-white" id="importEmployeesFM" data-senna-off="true">

		<div class="mb-4">
			<label for="<portlet:namespace/>jsonFile" class="form-label fw-bold">
				Upload Employee's Excel</label> <input type="file"
				id="<portlet:namespace/>zohoEmployeesFile"
				name="<portlet:namespace/>zohoEmployeesFile" accept=".xlsx, .xls"
				class="form-control" required />
		</div>

		<div class="text-center">
			<button type="submit" id="submitBtn" class="btn btn-primary px-4 py-2">
				Execute</button>
		</div>

	</form>
</div>
<liferay-ui:success key="sucess-key"  message="sucess-key" />
<liferay-ui:error embed="<%= false %>" key="unexpected-error-key" message="unexpected-error-key"/>
 

<script type="text/javascript">

$("#importEmployeesFM").on("submit", function () {
    let btn = $("#submitBtn");
    btn.prop("disabled", true);
});

</script>


