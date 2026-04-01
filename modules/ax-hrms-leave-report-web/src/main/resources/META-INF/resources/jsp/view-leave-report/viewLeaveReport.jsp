<%@ include file="/init.jsp" %>
<c:if test="${empty leaveReportDtoList}">
    <div class="ax-card card border-0">
        <div class="card-header invisible">No Leave Request</div>
        <div class="ax-body d-flex align-items-center">
            <div class="ax-conatiner">
                <div class="icon-leave-request"></div>
                <div><strong> No Leave Balance</strong></div>
                <div class="wish-message">No leave data available yet for this year. Leave balances and usage will appear here once updated.</div>
            </div>
        </div>
    </div>
</c:if>

<c:if test="${not empty leaveReportDtoList}">
    <div class="card">
    <div class="card-header"><strong><liferay-ui:message key="leave-report" /></strong></div>
    <div class="card-body ax-body"><table class="table">
        <thead>
			<tr>
				<th scope="col">Type</th>
				<th scope="col">Available</th>
				<th scope="col">Used</th>
			</tr>
		</thead>
        <tbody>
            <c:forEach var="report" items="${leaveReportDtoList}">
                <c:if test="${report.year == currentYear}">
                    <tr>
                        <td>${report.leaveTypeName}</td>
                        <td>${report.remainingDays}</td>
                        <td>${report.usedDays}</td>
                    </tr>
                </c:if>
            </c:forEach>
        </tbody>
    </table>
    </div>
    </div>
</c:if>


