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
    <div class="ax-card card border-0">
        <div class="card-header invisible">No Upcoming Holidays</div>
        <div class="ax-body d-flex align-items-center">
            <div class="ax-conatiner">
                <div class="icon-holidays"></div>
                <div><strong> No Upcoming Holidays</strong></div>
                <div class="wish-message">No upcoming holidays at the moment. Details about the next break will appear here once available.</div>
            </div>
        </div>
    </div>
</c:if>

<c:if test="${not empty upcomingHolidayList}">


    <!-- Different URL End -->


    <div class="card">
        <div class="card-header"><strong><liferay-ui:message key="upcoming-holiday-text"/></strong></div>
        <div class="card-body ax-body">
            <table class="table">
                <thead>
                <th><liferay-ui:message key="holiday-name-text"/></th>
                <th><liferay-ui:message key="holiday-date-text"/></th>
                <th><liferay-ui:message key="holiday-day-text"/></th>
                </thead>

                <c:forEach var="upcomingHoliday" items="${upcomingHolidayList}">

                    <fmt:formatDate
                        value="${upcomingHoliday.date}"
                        pattern="dd-MM-yyyy"
                        var="formattedHolidayDate"/>
                    <fmt:formatDate
                        value="${upcomingHoliday.date}"
                        pattern="EEEE"
                        var="formattedHolidayDay"/>

                    <tr>
                        <td>
                            ${upcomingHoliday.holidayName}
                            <c:if test="${upcomingHoliday.isFloater}">
                                (Restricted Holiday)
                            </c:if>
                        </td>

                        <td>
                            ${formattedHolidayDate}
                        </td>

                        <td>
                            ${formattedHolidayDay}
                        </td>
                    </tr>

                </c:forEach>




            </table>
        </div>
    </div>


</c:if>
