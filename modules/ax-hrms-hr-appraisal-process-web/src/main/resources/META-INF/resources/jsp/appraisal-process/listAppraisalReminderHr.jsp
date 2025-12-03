<%@ include file="/init.jsp" %>
<portlet:renderURL var="listAppraisalProcessURL">
    <portlet:param name="mvcRenderCommandName" value="/listAppraisalProcess"/>
</portlet:renderURL>
<c:if test="${ empty AppraisalReminderList}">
    <div class="alert alert-info" > No Appraisals Upcoming !</div>
</c:if>

<c:if test="${not empty AppraisalReminderList}">

    <div class="card">
        <div class="card-header  d-flex justify-content-between align-items-center">
            <strong>
                Appraisal Process Reminder
            </strong>
            <a href="" onclick="location.href ='${appraisalProcessPageLink}'" class="btn btn-primary"><liferay-ui:message
                    key="list-appraisal-process"/></a>
        </div>
        <div class="card-body">
            <table class="table">
                <thead>
                <tr>
                    <th scope="col">Employee Name</th>
                    <th scope="col">Departments</th>
                    <th scope="col">Designations</th>
                    <th scope="col">Appraisal Date</th>
                    <th scope="col">No of years Completed</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="appraisalReminder" items="${AppraisalReminderList}">
                    <tr>
                        <th scope="row">${appraisalReminder.employeeFullName}</th>
                        <td>${appraisalReminder.departments}</td>
                        <td>${appraisalReminder.designations}</td>
                        <td>${appraisalReminder.appraisalDate}</td>
                        <td>${appraisalReminder.noOfYearsCompleted}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
            <%--    <div class="card-footer">Footer</div>--%>
    </div>
</c:if>
