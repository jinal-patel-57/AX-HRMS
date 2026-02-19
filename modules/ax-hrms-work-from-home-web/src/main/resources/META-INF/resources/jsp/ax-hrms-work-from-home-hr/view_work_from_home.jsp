<%@ include file="/init.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!-- Remove scriptlet: The controller already sets "wfh" as DTO -->
<!-- WFHRequestDto wfh = (WFHRequestDto) request.getAttribute("wfh"); -->

<portlet:renderURL var="backURL">
    <portlet:param name="mvcRenderCommandName" value="/" />
</portlet:renderURL>

<div class="card">
    <div class="card-header">
        <strong>Work From Home Details</strong>
    </div>

    <div class="card-body">
        <table class="table table-bordered">
             <tr>
                <th>Employee Name</th>
                <td>${wfh.employeeName}</td>
            </tr>
            <tr>
                <th>Employee Official Mail ID</th>
                <td>${wfh.employeeOfficialMailId}</td>
            </tr>
            <tr>
                <th>Team Mail ID</th>
                <td>${wfh.teamMailId}</td>
            </tr>

            <tr>
                <th>Status</th>
                <td>${wfh.status}</td>
            </tr>

            <tr>
                <th>Reason</th>
                <td>${wfh.reason}</td>
            </tr>

            <tr>
                <th>Request Date</th>
                <td>
                    <fmt:formatDate value="${wfh.requestDate}" pattern="dd-MM-yyyy" />
                </td>
            </tr>

            <tr>
                <th>Start Date</th>
                <td>
                    <fmt:formatDate value="${wfh.startDate}" pattern="dd-MM-yyyy" />
                </td>
            </tr>

            <tr>
                <th>End Date</th>
                <td>
                    <fmt:formatDate value="${wfh.endDate}" pattern="dd-MM-yyyy" />
                </td>
            </tr>

        </table>
    </div>

    <div class="card-footer text-right">
        <a href="${backURL}" class="btn btn-outline-danger">Back</a>
    </div>
</div>
