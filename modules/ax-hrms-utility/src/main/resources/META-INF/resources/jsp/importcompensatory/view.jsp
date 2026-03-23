<%@page import="com.liferay.portal.kernel.util.PortalUtil"%>
<%@ include file="../../init.jsp"%>
<%
String currentURL = PortalUtil.getCurrentURL(request);
%>
<div class="container mt-5">

	<h3 class="mb-4">Import Employee's Compensatory Data</h3>

	<portlet:actionURL name="importCompensatoryDatas" var="importCompensatoryDatasURL">
        <portlet:param name="redirect" value="<%= currentURL %>" />
    </portlet:actionURL>

	<form action="${importCompensatoryDatasURL}" method="post"
		enctype="multipart/form-data"
		class="p-4 border rounded shadow-sm bg-white" id="importCompensatoryDatasFM" data-senna-off="true">

		<div class="mb-4">
			<label for="<portlet:namespace/>jsonFile" class="form-label fw-bold">
				Upload Employee's Compensatory Data Excel</label> <input type="file"
				id="<portlet:namespace/>compensatoryFile"
				name="<portlet:namespace/>compensatoryFile" accept=".xlsx, .xls"
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

$("#importCompensatoryDatasFM").on("submit", function () {
    let btn = $("#submitBtn");
    btn.prop("disabled", true);
});

</script>


