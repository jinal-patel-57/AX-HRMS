<%@ include file="/init.jsp" %>


<div class="card">
  <div class="card-header"><strong><liferay-ui:message key="leave-report" /></strong></div>
  <div class="card-body"><table class="table">
    <tbody>
        <c:forEach var="report" items="${leaveReportDtoList}">
        	<c:if test="${report.year == currentYear}">
                <tr>
                    <td>${report.leaveTypeName}</td>
                    <td><liferay-ui:message key="available" /> ${report.remainingDays} <liferay-ui:message key="days" /></td>
                    <td><liferay-ui:message key="Used" /> ${report.usedDays} <liferay-ui:message key="days" /></td>
                </tr>
            </c:if>
        </c:forEach>
    </tbody>
</table>
</div>
</div>


