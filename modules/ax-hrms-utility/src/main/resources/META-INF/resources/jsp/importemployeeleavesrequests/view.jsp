<%@page import="com.liferay.portal.kernel.util.PortalUtil"%>
<%@ page import="com.liferay.portal.kernel.util.ParamUtil" %>
<%@ page import="com.liferay.portal.kernel.util.Validator" %>
<%@ include file="../../init.jsp"%>
<%
String currentURL = PortalUtil.getCurrentURL(request);
%>
<%
String successCount = ParamUtil.getString(request, "successCount", "0");
String failedCount = ParamUtil.getString(request, "failedCount", "0");
String errorFilePath = ParamUtil.getString(request, "errorFilePath");
%>
<div class="container mt-5">

	<h3 class="mb-4">Import Employee Leaves Requests</h3>

	<portlet:actionURL name="importEmployeeLeavesRequests" var="importEmployeeLeavesRequestsURL">
        <portlet:param name="redirect" value="<%= currentURL %>" />
    </portlet:actionURL>

	<form action="${importEmployeeLeavesRequestsURL}" method="post"
		enctype="multipart/form-data"
		class="p-4 border rounded shadow-sm bg-white" id="importEmployeeLeavesRequestsFM" data-senna-off="true">

		<div class="mb-4">
			<label for="<portlet:namespace/>jsonFile" class="form-label fw-bold">
				Upload Employee's Leaves Requests Excel</label> <input type="file"
				id="<portlet:namespace/>zohoEmployeeLeavesrequestsFile"
				name="<portlet:namespace/>zohoEmployeeLeavesrequestsFile" accept=".xlsx, .xls"
				class="form-control" required />
		</div>

		<div class="text-center">
			<button type="submit" id="submitBtn" class="btn btn-primary px-4 py-2">
				Execute</button>
		</div>

	</form>
    <c:if test="<%= !"0".equals(successCount) || !"0".equals(failedCount) %>">

        <div class="alert alert-info mt-3">
            <p><b>Success Count:</b> <%= successCount %></p>
            <p><b>Failed Count:</b> <%= failedCount %></p>
        </div>

    </c:if>

    <c:if test="<%= Validator.isNotNull(errorFilePath) && !"0".equals(failedCount) %>">

        <portlet:resourceURL var="downloadURL">
            <portlet:param name="filePath" value="<%= errorFilePath %>" />
        </portlet:resourceURL>

        <div class="mt-3 text-center">
            <a href="<%= downloadURL %>" class="btn btn-danger">
                Download Error Report
            </a>
        </div>

    </c:if>
</div>
<liferay-ui:success key="success-key" message="Import completed successfully!" />
<liferay-ui:error embed="<%= false %>" key="unexpected-error-key" message="unexpected-error-key"/>



 

<script type="text/javascript">

$("#importEmployeeLeavesRequestsFM").on("submit", function () {
    let btn = $("#submitBtn");
    btn.prop("disabled", true);
});

</script>


