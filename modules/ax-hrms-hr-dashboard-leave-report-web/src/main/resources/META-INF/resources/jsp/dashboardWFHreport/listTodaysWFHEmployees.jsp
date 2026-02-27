<%@ include file="/init.jsp"%>
<%@ page import="com.liferay.portal.kernel.service.RoleLocalServiceUtil" %>
<c:if test="${empty todaysWFH}">
	<div class="ax-card card border-0">
		<div class="card-header invisible">No WFH Today</div>
		<div class="ax-body d-flex align-items-center">
			<div class="ax-conatiner">
				<div class="icon-wfh"></div>
				<div>
					<strong>No Work From Home Requests Today</strong>
				</div>
				<div class="wish-message">
					Looks like everyone is working from office today.
				</div>
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

<c:if test="${not empty todaysWFH}">
	<div class="card">
		<div class="card-header d-flex align-items-center justify-content-between">
			<strong>Today's Work From Home</strong>
            <c:if test="<%= isHRAdmin %>">
                <a class="btn btn-primary"
                   href="/web/ax-hrms/wfh-management"
                   target="_blank">
                    All WFH Requests
                </a>
            </c:if>
		</div>

		<div class="card-body ax-body">
			<table class="table">
				<thead>
					<tr>
						<th scope="col">
							<liferay-ui:message key="employee-name" />
						</th>
						<th scope="col">
							<liferay-ui:message key="department-name" />
						</th>
						<th scope="col">
							<liferay-ui:message key="designation-name" />
						</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="todaysWFHEmployee" items="${todaysWFH}">
						<tr>
							<td>${todaysWFHEmployee.name}</td>
							<td>${todaysWFHEmployee.departmentName}</td>
							<td>${todaysWFHEmployee.designationName}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</c:if>