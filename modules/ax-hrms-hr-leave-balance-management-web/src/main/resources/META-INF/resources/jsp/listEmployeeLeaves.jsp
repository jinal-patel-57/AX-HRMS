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
<liferay-ui:error key="leave-can-not-be-negative" message="leave-value-negative"/>


<div class="card">
    <div class="card-header d-flex justify-content-between align-items-center">
        <h5 class="mb-0">Employee Leave Balance</h5>
        <form class="form-inline" action="${fetchLeaves}" method="post">
            <select data-live-search="true" class="form-control mr-2 custom-select" id="employeeSelect" name="<portlet:namespace/>employeeId">
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
                    <th scope="col">Sr No.</th>
                    <th scope="col">Leave Type Name</th>
                    <th scope="col">Leave Balance</th>
                    <th scope="col">New Balance</th>
                </tr>
                </thead>
               <tbody>
                   <c:set var="totalLeave" value="0" />

                   <c:forEach var="CustomEmployeeLeave" items="${listCustomEmployeeLeave}" varStatus="loop">
                       <c:set var="totalLeave" value="${totalLeave + CustomEmployeeLeave.leaveAmount}" />

                       <tr>
                           <th scope="row">${loop.index + 1}</th>
                           <td>${CustomEmployeeLeave.leaveName}</td>
                           <td>${CustomEmployeeLeave.leaveAmount}</td>
                           <td>
                               <form action="${updateLeaveBalanceURL}" method="post">
                                   <!-- Row for input + button -->
                                   <div class="d-flex align-items-start">
                                       <div class="mr-2">
                                           <input type="number"
                                                  step="any"
                                                  min="0"
                                                  class="form-control leaveAmountInput"
                                                  name="<portlet:namespace/>leaveAmount"
                                                  value="${CustomEmployeeLeave.leaveAmount}">
                                       </div>

                                       <input type="hidden"
                                              name="<portlet:namespace/>leaveTypeMasterId"
                                              value="${CustomEmployeeLeave.leaveTypeMasterId}">

                                       <button type="submit" class="btn btn-primary">
                                           Update Balance
                                       </button>
                                   </div>

                                   <!-- Error message (below input + button) -->
                                   <div class="text-danger leave-error d-none mt-1">
                                       Leave balance cannot be negative.
                                   </div>
                               </form>
                           </td>

                       </tr>
                   </c:forEach>

                   <!-- Total Leave Row -->
                   <tr>
                       <th colspan="2" class="text-right">Total Leave Balance</th>
                       <th>${totalLeave}</th>
                       <th></th>
                   </tr>
               </tbody>

            </table>
        </c:if>
    </div>
</div>

<script>
 $('#employeeSelect').val('${employeeId}');
    // Prevent negative leave value submission (inline error)
    $(document).on('submit', 'form[action="${updateLeaveBalanceURL}"]', function (e) {

        let leaveAmountInput = $(this).find('.leaveAmountInput');
        let errorSpan = $(this).find('.leave-error');
        let value = parseFloat(leaveAmountInput.val());

        // Reset error
        errorSpan.addClass('d-none');
        leaveAmountInput.removeClass('is-invalid');

        if (isNaN(value) || value < 0) {
            e.preventDefault();

            // Show error inline
            errorSpan.removeClass('d-none');
            leaveAmountInput.addClass('is-invalid');
            leaveAmountInput.focus();

            return false;
        }
    });

    // Hide error when user corrects value
    $(document).on('input', '.leaveAmountInput', function () {
        $(this).removeClass('is-invalid');
        $(this).closest('form').find('.leave-error').addClass('d-none');
    });
</script>
