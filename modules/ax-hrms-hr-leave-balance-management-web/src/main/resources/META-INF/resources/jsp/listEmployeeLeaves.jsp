<%--
  Created by IntelliJ IDEA.
  User: nivid.koradiya
  Date: 07-06-2024
  Time: 14:18
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="/init.jsp" %>
<portlet:renderURL var="fetchLeaves">
    <portlet:param name="mvcRenderCommandName" value="/"/>
</portlet:renderURL>
<portlet:actionURL name="/updateLeaveBalance" var="updateLeaveBalanceURL">
    <portlet:param name="employeeId"
                   value="${employeeId}"/>
</portlet:actionURL>

<liferay-ui:success key="leave-updated" message="leave-updated-success"
/>
<liferay-ui:error key="leave-update-failed" message="leave-update-failed"/>


<div class="card">
    <div class="card-header d-flex justify-content-between align-items-center">
        <h5 class="mb-0">Employee Leave Balance</h5>
        <form class="form-inline" action="${fetchLeaves}" method="post">
            <select class="form-control mr-2" id="employeeSelect" name="<portlet:namespace/>employeeId">
                <option value="">Select Employee</option>
                <c:forEach var="employee" items="${employeeList}">
                    <option value="${employee.employeeId}">${employee.firstName} ${employee.lastName}</option>
                </c:forEach>
            </select>
            <button type="submit" class="btn btn-primary">Fetch</button>
        </form>
    </div>
    <div class="card-body">
        <c:if test="${employeeId > 0}">

            <table class="table table-bordered">
                <thead>
                <tr>
                    <th scope="col">Sr No</th>
                    <th scope="col">Leave Type Name</th>
                    <th scope="col">Leave Balance</th>
                    <th scope="col">Action</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="CustomEmployeeLeave" items="${listCustomEmployeeLeave}" varStatus="loop">
                    <tr>
                        <th scope="row">1</th>
                        <td>${CustomEmployeeLeave.leaveName}</td>
                        <td>${CustomEmployeeLeave.leaveAmount}</td>
                        <td>
                            <form class="form-inline" action="${updateLeaveBalanceURL}" method="post">
                                <input type="number" step="any" class="form-control mb-2 mr-sm-2"
                                       name="<portlet:namespace/>leaveAmount"
                                       value="${CustomEmployeeLeave.leaveAmount}">
                                <input type="hidden" class="form-control mb-2 mr-sm-2"
                                       name="<portlet:namespace/>leaveTypeMasterId"
                                       value="${CustomEmployeeLeave.leaveTypeMasterId}">
                                <button type="submit" class="btn btn-primary mb-2">Update</button>
                            </form>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </c:if>
    </div>
</div>

<script>
    $('#employeeSelect').val('${employeeId}');
</script>
