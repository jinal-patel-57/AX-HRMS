<%--
  Created by IntelliJ IDEA.
  User: krish.moradiya
  Date: 15-05-2024
  Time: 04:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="/init.jsp" %>
<%--SESSION_MESSAGES Start Here--%>
<%--SESSION_MESSAGES End Here--%>

<!-- Different URL Start -->
<portlet:renderURL var="homeUrl"/>


<c:if test="${empty upcomingHolidayList}">
    <div class="alert alert-info">No Upcoming Holidays!</div>
</c:if>

<c:if test="${not empty upcomingHolidayList}">


    <!-- Different URL End -->


    <div class="card">
        <div class="card-header"><strong><liferay-ui:message key="upcoming-holiday-text"/></strong></div>
        <table class="table">
            <thead>
            <th><liferay-ui:message key="holiday-name-text"/></th>
            <th><liferay-ui:message key="holiday-date-text"/></th>
            </thead>
            <c:forEach var="upcomingHoliday" items="${upcomingHolidayList}">
                <fmt:formatDate value="${upcomingHoliday.date}" pattern="dd-MMM" var="formatedHolidayDate"/>
                <tr>
                    <td>${upcomingHoliday.holidayName}</td>
                    <td>${formatedHolidayDate} : <fmt:formatDate value="${upcomingHoliday.date}" type="date"
                                                                 pattern="EEEE"/></td>
                </tr>
            </c:forEach>
        </table>
    </div>


</c:if>
