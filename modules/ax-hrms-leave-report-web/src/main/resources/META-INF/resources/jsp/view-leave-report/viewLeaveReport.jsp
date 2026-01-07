<%@ include file="/init.jsp" %>
<c:if test="${empty leaveReportDtoList}">
    <div class="ax-card">
        <div class="ax-body d-flex align-items-center">
            <div class="ax-conatiner">
                <div class="icon-leave-request"></div>
                <div><strong> No Leave Request</strong></div>
                <div class="wish-message">No leave data available yet for this year. Leave balances and usage will appear here once updated.</div>
            </div>
        </div>
    </div>
</c:if>

<c:if test="${not empty leaveReportDtoList}">
    <div class="card">
    <div class="card-header"><strong><liferay-ui:message key="leave-report" /></strong></div>
    <div class="card-body ax-body"><table class="table">
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
</c:if>


