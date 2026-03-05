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






<c:if test="${not empty todaysLeaves}">
	<div class="card">

		<div
			class="card-header d-flex align-items-center justify-content-between">
			<strong>Today's Leaves</strong>
			<c:if test="${isHrAdmin}">
			 <c:if test="${isHrAdmin}"><a class="btn btn-primary"
				href="/web/ax-hrms/leave-management" target="_blank">All Leave
				Requests</a>
				</c:if>
				</c:if>
		</div>

		<div class="card-body ax-body">
			<table class="table ">
				<thead>
					<tr>

						<th scope="col"><liferay-ui:message key="employee-name" /></th>
						<th scope="col"><liferay-ui:message key="Department" /></th>
						<th scope="col"><liferay-ui:message key="Designation" /></th>
						 <c:if test="${isHrAdmin}">
                          <th scope="col">
                                                    <liferay-ui:message key="status" />
                                                </th>
                                </c:if>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="todaysLeaveEmployee" items="${todaysLeaves}">
						<tr>
							<td>${todaysLeaveEmployee.name}</td>
							<td>${todaysLeaveEmployee.departmentName}</td>
							<td>${todaysLeaveEmployee.designationName}</td>
							<c:if test="${isHrAdmin}">
                             <td>${todaysLeaveEmployee.status}</td>
                                </c:if>

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