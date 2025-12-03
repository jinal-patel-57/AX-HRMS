<%@ include file="/init.jsp"%>

<h1>Status</h1>
<c:choose>
	<c:when test="${employee.isEmployeeOnboarded == true }">
		<h2>Approved..</h2>
	</c:when>
	<c:when test="${employee.isEmployeeOnboarded  == false}">
		<h2>Rejected..</h2>
	</c:when>
</c:choose>

