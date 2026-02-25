<%@ include file="/init.jsp"%>
<%@ page import="com.liferay.portal.kernel.service.RoleLocalServiceUtil" %>

<c:if test="${empty todaysLeaves}">
	<div class="ax-card card border-0">
		<div class="card-header invisible">No Leaves Today</div>
		<div class="ax-body d-flex align-items-center">
			<div class="ax-conatiner">
				<div class="icon-no-leaves"></div>
				<div>
					<strong> No Leaves Today</strong>
				</div>
				<div class="wish-message">Looks like it's a full working day -
					no one is on leave today.</div>
			</div>
		</div>
	</div>
</c:if>


<%
boolean isHRAdmin = false;

if (themeDisplay.isSignedIn()) {
    isHRAdmin = RoleLocalServiceUtil.hasUserRole(
            themeDisplay.getUserId(),
            themeDisplay.getCompanyId(),
            "HR Admin",
            true
    );
}
%>



<c:if test="${not empty todaysLeaves}">
	<div class="card">
	   <c:if test="<%= isHRAdmin %>">
		<div
			class="card-header d-flex align-items-center justify-content-between">
			<strong>Today's Leaves</strong>
			<c:if test="${isHrAdmin}"><a class="btn btn-primary"
				href="/web/ax-hrms/leave-management" target="_blank">All Leave
				Requests</a>
				</c:if>
		</div>
	   </c:if>
		<div class="card-body ax-body">
			<table class="table ">
				<thead>
					<tr>

						<th scope="col"><liferay-ui:message key="employee-name" /></th>
						<th scope="col"><liferay-ui:message key="department-name" /></th>
						<th scope="col"><liferay-ui:message key="designation-name" /></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="todaysLeaveEmployee" items="${todaysLeaves}">
						<tr>
							<td>${todaysLeaveEmployee.name}</td>
							<td>${todaysLeaveEmployee.departmentName}</td>
							<td>${todaysLeaveEmployee.designationName}</td>

						</tr>
					</c:forEach>
				</tbody>
			</table>

		</div>
	</div>

</c:if>

<!-- <script>
    $(document).ready(function () {
        var config = new Object({}),
            namespace = '<portlet:namespace />',

        config.namespace = namespace;

        AXHrmsHrDashboardLeaveReportWebPortlet.setConfigs(config);
    });
</script>

 -->